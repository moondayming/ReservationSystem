package mw.service;

import java.sql.*;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class service {

	/**
	 * @param args
	 */
	//ԤԼ����
	
	//�ж�ר�Һ��Ƿ���ʣ��
	public String hasexportnumber(String workday,String department){
		//��������sqlite���ݿ��ѯר�Ҿ�����Ϣ
		Connection c = null;
        Statement stmt = null;
        int expertID = 0;//����ר��ID
        int number = 0;//����ר�Һ�����
        try {
            Class.forName("org.sqlite.JDBC");//jdbc����
            c = DriverManager.getConnection("jdbc:sqlite:F:\\Myeclipse\\WorkSpace\\TheService\\database\\hospitalDB.db");//�������ݿ�
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "select * from expert where workday='"+workday+"' and department='"+department+"';";//��ѯר�Ҿ�����Ϣ
            ResultSet rs = stmt.executeQuery(sql);
            int rowCount = 0;   
            while(rs.next()) {   
              rowCount++;   
            }
            //�жϲ�ѯ����Ƿ�Ϊ��
            if(rowCount==0){
            	//Ϊ��
            	stmt.close();
                c.commit();
                c.close();
            	return "����Ԥ��������";
            }
            //��Ϊ�գ��������������������ר����Ϣ���ж���ר�Һ������Ƿ���ʣ��
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
            	return "����ԤԼ��";
            }
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
		return "ok_"+String.valueOf(expertID);//�����ʣ�࣬�����ַ�����ʽ����״̬��ר��ID��ר�Һ�����
	}
	
	//ͨ���ֻ���ԤԼ
	public String reservation(String phonenum,String visitday,String visitdepartment,int expertID){
		int phonenumsize = phonenum.length();
		if(phonenumsize != 11){
			return "��Ч����";
		}
		//���ݿ��ѯ�Ƿ��Ѿ�ԤԼ
		Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");//jdbc����
            c = DriverManager.getConnection("jdbc:sqlite:F:\\Myeclipse\\WorkSpace\\TheService\\database\\hospitalDB.db");//�������ݿ�
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "select * from reserve where phonenum = '"+phonenum+"';";//��ѯ��ǰ�����Ƿ��Ѿ�ԤԼ
            ResultSet rs = stmt.executeQuery(sql);
            int rowCount = 0;   
            while(rs.next()) {   
              rowCount++;   
            }
            //�жϲ�ѯ����Ƿ�Ϊ��
            if(rowCount!=0){
            	//��Ϊ��
            	stmt.close();
                c.commit();
                c.close();
            	return "�˺����Ѿ�ԤԼ";
            }
            //Ϊ�գ���ʾ�ú���Ϊ11λ��ûԤԼ������ʼ�������
            sql = "insert into reserve values ('"+phonenum+"','"+visitday+"','"+visitdepartment+"',"+expertID+");";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
		return "ԤԼ�ɹ�";
	}
	
	//ȡ��ԤԼ
	public String cancel(String phonenum){
		int phonenumsize = phonenum.length();
		if(phonenumsize != 11){
			return "��Ч����";
		}
		//��ѯ���ݿ��ж��Ƿ��Ѿ�ԤԼ��
		Connection c = null;
        Statement stmt = null;
        int expertID=0;
        try {
            Class.forName("org.sqlite.JDBC");//jdbc����
            c = DriverManager.getConnection("jdbc:sqlite:F:\\Myeclipse\\WorkSpace\\TheService\\database\\hospitalDB.db");//�������ݿ�
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "select * from reserve where phonenum = '"+phonenum+"';";//��ѯ��ǰ�����Ƿ��Ѿ�ԤԼ
            ResultSet rs = stmt.executeQuery(sql);
            int rowCount = 0;   
            while(rs.next()) {   
            	expertID = rs.getInt("expertID");
            	rowCount++;
            }
            //�жϲ�ѯ����Ƿ�Ϊ��
            if(rowCount==0){
            	//Ϊ��
            	stmt.close();
                c.commit();
                c.close();
            	return "�˺�����δԤԼ";
            }
            //��Ϊ�գ���ʾ�ú���Ϊ11λ���Ѿ�ԤԼ������ʼɾ�����룬ר�Һż�һ
            sql = "delete from reserve where phonenum='"+phonenum+"';";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
		
		return "ȡ��ԤԼ�ɹ�_"+String.valueOf(expertID);
	}
	
	//���ԤԼ�ɹ�����ר�Һŵ�������һ
	public String subexpertnum(String expertID){
		Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");//jdbc����
            c = DriverManager.getConnection("jdbc:sqlite:F:\\Myeclipse\\WorkSpace\\TheService\\database\\hospitalDB.db");//�������ݿ�
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "update expert set number=number-1 where expertID='"+expertID+"';";//����
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
		return "ok";
	}
	
	//���ȡ��ԤԼ�ɹ�����ר�Һŵ�������һ
	public String addexpertnum(String expertID){
		Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");//jdbc����
            c = DriverManager.getConnection("jdbc:sqlite:F:\\Myeclipse\\WorkSpace\\TheService\\database\\hospitalDB.db");//�������ݿ�
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "update expert set number=number+1 where expertID='"+expertID+"';";//����
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
		System.out.println("���񷢲��ɹ�");
	}

}
