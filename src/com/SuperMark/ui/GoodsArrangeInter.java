package com.SuperMark.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.SuperMark.backstage.PublicUse;

public class GoodsArrangeInter {
	public static JFrame Arrangeframe;
	private static JButton butAdd;
	private static JButton butDrop;	
	private static JButton butChange;
	private static JButton butLook;
	private static JButton exit;
		
	public void Arrangeinit() {
		

		Arrangeframe=new JFrame("�̳�Ļ����Ʒ��Ϣ�޸�");
		butAdd=new JButton("������Ʒ");
		butDrop=new JButton("ɾ����Ʒ");
		butLook=new JButton("������Ʒ");
		butChange=new JButton("�޸���Ʒ��Ϣ");
		exit=new JButton("�˳���¼");
		
		Arrangeframe.setSize(700,600);
		Arrangeframe.setLocation(400,400);
		Arrangeframe.setLayout(new FlowLayout());
		
		Arrangeframe.add(butAdd);
		Arrangeframe.add(butChange);
		Arrangeframe.add(butDrop);
		Arrangeframe.add(butLook);
		Arrangeframe.add(new PublicUse().getScrollPane());
		Arrangeframe.add(exit);
		
		butLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"��������Ҫ���ҵ���Ʒ��");  
				Arrangeframe.dispose();
				new GoodsLookInter().GoodsLookinit();
			}			
		});
		
		butAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"��������Ҫ���ӵ���Ʒ������");  
				Arrangeframe.dispose();
				new GoodsAddInter().GoodsAddinit(); 
			}
		});
		
		butDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"��������Ҫɾ������Ʒ��");  
				Arrangeframe.dispose();
				new GoodsDropInter().GoodsDropinit();
			}
		});	
		
		butChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"��������Ҫ�޸ĵ���Ʒ��");  
				Arrangeframe.dispose();
				new GoodsChangeInter().GoodsChangeinit();
			}
		});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Arrangeframe.dispose();
			}
		});
		
		Arrangeframe.setVisible(true);
		Arrangeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
