package com.SuperMark.ui;

import com.SuperMark.backstage.PublicUse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class ManagerInterface{
	public static JFrame Managerframe;
	private static JTextField txtid;
	private static JTextField txtpass;
	private static FlowLayout flo;
	private static JLabel LabelManagerid;
	private static JLabel LabelManagerpass;
	private static JButton butManager;

	public void Managerinit() {
		
		Managerframe=new JFrame("管理员登录");
		txtid=new JTextField(10);
		txtpass=new JTextField(10);
		LabelManagerid=new JLabel("管理账号");
		LabelManagerpass=new JLabel("账号密码");
		flo=new FlowLayout(FlowLayout.LEFT,50,50);
		butManager=new JButton("确认");
		
		Managerframe.setSize(750,300);
		Managerframe.setLocation(400,400);
		Managerframe.setLayout(flo);
		
		Managerframe.add(LabelManagerid);
		Managerframe.add(txtid);
		Managerframe.add(LabelManagerpass);
		Managerframe.add(txtpass);
		Managerframe.add(butManager);
		Managerframe.add(new PublicUse().getLabelTime());
		
		butManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Maname=txtid.getText();
				String Mapass=txtpass.getText();
				int change=0;
				if(Maname.equals("老大")||Mapass.equals("111111")) {
					Managerframe.dispose();
					change=1;
				}else if(Maname.equals("老二")||Mapass.equals("222222")) {
					Managerframe.dispose();
					change=1;
				}
				if(change==1) {
					JOptionPane.showMessageDialog(null,"管理员登录成功!\n欢迎!");  
					new GoodsArrangeInter().Arrangeinit();
				}else {
					JOptionPane.showMessageDialog(null,"管理员登录失败!!!");  	
					Managerframe.dispose();
					new MainInterface().Maininit();
				}
			}
		});
		
		Managerframe.setVisible(true);
		Managerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
}





