package mw.call;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import mw.client.Service;
import mw.client.ServiceService;
public class testSwing {
	public static JLabel statusLabel;
	public static JFrame frame;
	public static JLabel dateLabel;
	public static JTextField dateText;
	public static JLabel departmentLabel;
	public static JTextField departmentText;
	public static JButton reserveButton;
	public static String[] para;
	public static JPanel panel1;
	public static JPanel panel2;
	public static JPanel panel3;
	public static JLabel phoneLabel;
	public static JTextField phoneText;
	public static JButton okButton;
	public static JLabel resultLabel;
	public static JLabel cancelLabel;
	public static JTextField cancelText;
	public static JButton cancelButton;
	public static JLabel resultLabel2;
	public static JButton cancelrReserveButton;
	public static JButton returnButton2;
	public static JButton returnButton3;

	public static void main(String[] args) {
		frame = new JFrame("就诊预约系统");
		frame.setSize(350,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//panel1 预约界面
		panel1  = new JPanel();
		panel1.setBounds(0, 0, 350, 200);
		frame.add(panel1);
		placeComponents1(panel1);
		panel1.setVisible(true);
		
		//panel2 输入手机号界面
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 350, 200);
		frame.add(panel2);
		placeComponents2(panel2);
		panel2.setVisible(false);
		
		//panel3 取消预约界面
		panel3 = new JPanel();
		panel3.setBounds(0, 0, 350, 200);
		frame.add(panel3);
		placeComponents3(panel3);
		panel3.setVisible(false);
		
		frame.setVisible(true);
	}
	
	//处理panel3   取消预约界面
	private static void placeComponents3(JPanel panel){
		panel.setLayout(null);
		
		cancelLabel = new JLabel("手机号");
		cancelLabel.setBounds(10, 20, 80, 25);
		panel.add(cancelLabel);
		
		cancelText = new JTextField(20);
		cancelText.setBounds(100, 20, 165, 25);
		panel.add(cancelText);
		
		cancelButton = new JButton("取消预约");
		cancelButton.addActionListener(new cancelButtonClickLinstener());
		cancelButton.setBounds(10, 50, 120, 25);
		panel.add(cancelButton);
		
		returnButton3 = new JButton("返回");
		returnButton3.addActionListener(new returnToIndex());
		returnButton3.setBounds(150, 50, 100, 25);
		panel.add(returnButton3);
		
		resultLabel2 = new JLabel();
		resultLabel2.setBounds(10, 80, 100, 25);
		panel.add(resultLabel2);
	}

	//处理panel2  预约界面
	private static void placeComponents2(JPanel panel){
		panel.setLayout(null);
		
		phoneLabel = new JLabel("手机号");
		phoneLabel.setBounds(10, 20, 80, 25);
		panel.add(phoneLabel);
		
		phoneText = new JTextField(20);
		phoneText.setBounds(100, 20, 165, 25);
		panel.add(phoneText);
		
		okButton = new JButton("确定预约");
		okButton.addActionListener(new okButtonClickLinstener());
		okButton.setBounds(10, 50, 120, 25);
		panel.add(okButton);
		
		returnButton2 = new JButton("返回");
		returnButton2.addActionListener(new returnToIndex());
		returnButton2.setBounds(180, 50, 100, 25);
		panel.add(returnButton2);
		
		resultLabel = new JLabel();
		resultLabel.setBounds(10, 80, 100, 25);
		panel.add(resultLabel);
	}
	
	 
	//处理pannel1  开始界面
	private static void placeComponents1(JPanel panel) {
		panel.setLayout(null);
		
		dateLabel = new JLabel("就诊日期");
		dateLabel.setBounds(10, 20, 80, 25);
		panel.add(dateLabel);
		
		dateText = new JTextField(20);
		
		dateText.setBounds(100, 20, 165, 25);
		panel.add(dateText);
		
		departmentLabel = new JLabel("预约部门");
		departmentLabel.setBounds(10, 50, 80, 25);
		panel.add(departmentLabel);
		
		
		departmentText = new JTextField(20);
        departmentText.setBounds(100,50,165,25);
        panel.add(departmentText);
		
        reserveButton = new JButton("预约");
        reserveButton.addActionListener(new reserveButtonClickLinstener());
        reserveButton.setBounds(10, 80, 60, 25);
		panel.add(reserveButton);
		
		cancelrReserveButton = new JButton("取消预约");
		cancelrReserveButton.addActionListener(new cancelReserveButtonClickLinstener());
		cancelrReserveButton.setBounds(150, 80, 120, 25);
		panel.add(cancelrReserveButton);
		
		statusLabel = new JLabel();
		statusLabel.setBounds(10, 110, 100, 25);
		panel.add(statusLabel);
		
		
	}
	
}

//点击确定取消预约按钮
class cancelButtonClickLinstener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Service service = new ServiceService().getServicePort();
		
		String phone = testSwing.cancelText.getText();
		
		String s2 = service.cancel(phone);//通过手机号进行取消预约
		if(s2.equals("无效号码") || s2.equals("此号码尚未预约")){
			testSwing.resultLabel2.setText(s2);
		}else{
			String[] para2 = s2.split("_");
			if(para2[0].equals("取消预约成功")){
				testSwing.resultLabel2.setText(para2[0]);
				String s3 = service.addexpertnum(para2[1]);//如果取消预约成功，则将专家号数量加一
			}
		}
		
		
		
	}
}

//点击预约按钮
class reserveButtonClickLinstener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Service service = new ServiceService().getServicePort();
		
		String date = testSwing.dateText.getText();
		String department = testSwing.departmentText.getText();
		
		String s1 = service.hasexportnumber(date,department);//判断专家号是否有剩余
		
		if(s1.equals("不在预订日期内") || s1.equals("暂无预约号")){
			testSwing.statusLabel.setText(s1);
		}else{
			testSwing.para = s1.split("_");
			testSwing.panel1.setVisible(false);
			testSwing.panel2.setVisible(true);
			testSwing.panel3.setVisible(false);
		}
		
		
	}
}

//点击取消预约按钮
class cancelReserveButtonClickLinstener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
			testSwing.panel1.setVisible(false);
			testSwing.panel2.setVisible(false);
			testSwing.panel3.setVisible(true);
		
	}
}

//点击确定按钮
class okButtonClickLinstener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Service service = new ServiceService().getServicePort();
		String phone = testSwing.phoneText.getText();
		String date = testSwing.dateText.getText();
		String department = testSwing.departmentText.getText();
		
		if(testSwing.para[0].equals("ok")){
			String s2 = service.reservation(phone, date, department,Integer.valueOf(testSwing.para[1]));//进行预约，如果预约成功则会将预约信息保存至数据库
			testSwing.resultLabel.setText(s2);
			if(s2.equals("预约成功")){
				String s3 = service.subexpertnum(testSwing.para[1]);//预约成功，则将专家号减一
			}
		}
		
		
	}
}

//panel3返回index
class returnToIndex implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		testSwing.panel1.setVisible(true);
		testSwing.panel2.setVisible(false);
		testSwing.panel3.setVisible(false);
		
	}
}
