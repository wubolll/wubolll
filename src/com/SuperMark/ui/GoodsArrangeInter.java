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
		

		Arrangeframe=new JFrame("商城幕后商品信息修改");
		butAdd=new JButton("增加商品");
		butDrop=new JButton("删除商品");
		butLook=new JButton("查找商品");
		butChange=new JButton("修改商品信息");
		exit=new JButton("退出登录");
		
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
				JOptionPane.showMessageDialog(null,"请输入需要查找的商品名");  
				Arrangeframe.dispose();
				new GoodsLookInter().GoodsLookinit();
			}			
		});
		
		butAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"请输入需要增加的商品及数量");  
				Arrangeframe.dispose();
				new GoodsAddInter().GoodsAddinit(); 
			}
		});
		
		butDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"请输入需要删除的商品名");  
				Arrangeframe.dispose();
				new GoodsDropInter().GoodsDropinit();
			}
		});	
		
		butChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"请输入需要修改的商品名");  
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
