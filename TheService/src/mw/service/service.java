package mw.service;

import java.sql.*;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class service {

	/**
	 * @param args
	 */
	//预约功能
	
	//判断专家号是否有剩余
	public String hasexportnumber(String workday,String department){
		//首先链接sqlite数据库查询专家就诊信息
		Connection c = null;
        Statement stmt = null;
        int expertID = 0;//保存专家ID
        int number = 0;//保存专家号数量
        try {
            Class.forName("org.sqlite.JDBC");//jdbc驱动
            c = DriverManager.getConnection("jdbc:sqlite:F:\\Myeclipse\\WorkSpace\\TheService\\database\\hospitalDB.db");//加载数据库
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "select * from expert where workday='"+workday+"' and department='"+department+"';";//查询专家就诊信息
            ResultSet rs = stmt.executeQuery(sql);
            int rowCount = 0;   
            while(rs.next()) {   
              rowCount++;   
            }
            //判断查询结果是否为空
            if(rowCount==0){
            	//为空
            	stmt.close();
                c.commit();
                c.close();
            	return "不在预订日期内";
            }
            //不为空，则遍历所有满足条件的专家信息，判断其专家号数量是否有剩余
            boolean hasexpertnum = false;
            rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
            	number = rs.getInt("number");
            	expertID = rs.getInt("expertID");
            	if(number>0){
            		hasexpertnum = true;
            		break;
            	}
            }
            if(hasexpertnum==false){
            	stmt.close();
                c.commit();
                c.close();
            	return "暂无预约号";
            }
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
		return "ok_"+String.valueOf(expertID);//如果有剩余，则以字符串形式返还状态、专家ID、专家号数量
	}
	
	//通过手机号预约
	public String reservation(String phonenum,String visitday,String visitdepartment,int expertID){
		int phonenumsize = phonenum.length();
		if(phonenumsize != 11){
			return "无效号码";
		}
		//数据库查询是否已经预约
		Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");//jdbc驱动
            c = DriverManager.getConnection("jdbc:sqlite:F:\\Myeclipse\\WorkSpace\\TheService\\database\\hospitalDB.db");//加载数据库
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "select * from reserve where phonenum = '"+phonenum+"';";//查询当前号码是否已经预约
            ResultSet rs = stmt.executeQuery(sql);
            int rowCount = 0;   
            while(rs.next()) {   
              rowCount++;   
            }
            //判断查询结果是否为空
            if(rowCount!=0){
            	//不为空
            	stmt.close();
                c.commit();
                c.close();
            	return "此号码已经预约";
            }
            //为空，表示该号码为11位且没预约过，则开始保存号码
            sql = "insert into reserve values ('"+phonenum+"','"+visitday+"','"+visitdepartment+"',"+expertID+");";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
		return "预约成功";
	}
	
	//取消预约
	public String cancel(String phonenum){
		int phonenumsize = phonenum.length();
		if(phonenumsize != 11){
			return "无效号码";
		}
		//查询数据库判断是否已经预约过
		Connection c = null;
        Statement stmt = null;
        int expertID=0;
        try {
            Class.forName("org.sqlite.JDBC");//jdbc驱动
            c = DriverManager.getConnection("jdbc:sqlite:F:\\Myeclipse\\WorkSpace\\TheService\\database\\hospitalDB.db");//加载数据库
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "select * from reserve where phonenum = '"+phonenum+"';";//查询当前号码是否已经预约
            ResultSet rs = stmt.executeQuery(sql);
            int rowCount = 0;   
            while(rs.next()) {   
            	expertID = rs.getInt("expertID");
            	rowCount++;
            }
            //判断查询结果是否为空
            if(rowCount==0){
            	//为空
            	stmt.close();
                c.commit();
                c.close();
            	return "此号码尚未预约";
            }
            //不为空，表示该号码为11位且已经预约过，则开始删除号码，专家号加一
            sql = "delete from reserve where phonenum='"+phonenum+"';";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
		
		return "取消预约成功_"+String.valueOf(expertID);
	}
	
	//如果预约成功，则专家号的数量减一
	public String subexpertnum(String expertID){
		Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");//jdbc驱动
            c = DriverManager.getConnection("jdbc:sqlite:F:\\Myeclipse\\WorkSpace\\TheService\\database\\hospitalDB.db");//加载数据库
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "update expert set number=number-1 where expertID='"+expertID+"';";//更新
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
		return "ok";
	}
	
	//如果取消预约成功，则专家号的数量加一
	public String addexpertnum(String expertID){
		Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");//jdbc驱动
            c = DriverManager.getConnection("jdbc:sqlite:F:\\Myeclipse\\WorkSpace\\TheService\\database\\hospitalDB.db");//加载数据库
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "update expert set number=number+1 where expertID='"+expertID+"';";//更新
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
		return "ok";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:9000/Service/reserve", new service());
		System.out.println("服务发布成功");
	}

}
