package com.SuperMark.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.SuperMark.backstage.PublicUse;

class MainInterface {
	public JFrame Mainframe;
	private JButton butUser;	
	private JButton butManager;
	private JButton butRegister;
	private FlowLayout flo;

	public void Maininit() {		
		Mainframe=new JFrame("电子商城");
		butUser=new JButton("用户登录");
		butManager=new JButton("管理员登录");
		butRegister=new JButton("新用户注册");
		flo=new FlowLayout(FlowLayout.LEFT,50,50);
		
		//设置登录背景
		ImageIcon im=new ImageIcon("C:\\Users\\Lenovo\\Desktop\\50304279b9d1fefe.jpg");
		JLabel pa=new JLabel(im);
		
		Mainframe.setSize(750,400);
		Mainframe.setLocation(500,400);
		Mainframe.setLayout(flo);
		
		Mainframe.add(pa);
		Mainframe.add(butUser);
		Mainframe.add(butManager);
		Mainframe.add(butRegister);
		Mainframe.add(new PublicUse().getLabelTime());
		
		butUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"请用户进行登录操作");  
				Mainframe.dispose();
				User user=new User();
				user.Userinit();
			}
		});
		butManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"请管理员进行登录操作");  
				Mainframe.dispose();
				ManagerInterface manager=new ManagerInterface();
				manager.Managerinit();
			}
		});
		butRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Mainframe.dispose();
				Register register=new Register();
				register.Registerinit();
			}
		});
		
		Mainframe.setVisible(true);
		Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
	public class InterfaceDesign{
		public static void main(String[]args) {
			new MainInterface().Maininit();
		}
	}
	

