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
		
		Managerframe=new JFrame("����Ա��¼");
		txtid=new JTextField(10);
		txtpass=new JTextField(10);
		LabelManagerid=new JLabel("�����˺�");
		LabelManagerpass=new JLabel("�˺�����");
		flo=new FlowLayout(FlowLayout.LEFT,50,50);
		butManager=new JButton("ȷ��");
		
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
				if(Maname.equals("�ϴ�")||Mapass.equals("111111")) {
					Managerframe.dispose();
					change=1;
				}else if(Maname.equals("�϶�")||Mapass.equals("222222")) {
					Managerframe.dispose();
					change=1;
				}
				if(change==1) {
					JOptionPane.showMessageDialog(null,"����Ա��¼�ɹ�!\n��ӭ!");  
					new GoodsArrangeInter().Arrangeinit();
				}else {
					JOptionPane.showMessageDialog(null,"����Ա��¼ʧ��!!!");  	
					Managerframe.dispose();
					new MainInterface().Maininit();
				}
			}
		});
		
		Managerframe.setVisible(true);
		Managerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
}





