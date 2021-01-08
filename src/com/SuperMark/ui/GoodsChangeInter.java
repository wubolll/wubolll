package com.SuperMark.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.SuperMark.dao.Database;

public class GoodsChangeInter {
		public static JFrame Goodsframe;
		private static JTextField nameNew;
		private static JTextField nameOld;
		private static JTextField txtnum;
		private static JTextField txtprice;
		private static JLabel labelnameNew;
		private static JLabel labelnameOld;
		private static JLabel labelnum;
		private static JLabel labelprice;
		private static JButton butsure;
		private static JButton back;
		
		PreparedStatement stmt;
		
		public void GoodsChangeinit() {
			Goodsframe=new JFrame("电子商城修改商品服务");
			nameOld=new JTextField(20);
			nameNew=new JTextField(20);
			txtnum=new JTextField(20);
			txtprice=new JTextField(20);
			labelnameOld=new JLabel("需要修改的商品名");
			labelnameNew=new JLabel("修改后的商品名");
			labelnum=new JLabel("商品数量");
			labelprice=new JLabel("商品价格");
			butsure=new JButton("确认");
			back=new JButton("取消");
			
			Goodsframe.setSize(600,300);
			Goodsframe.setLocation(500,500);
			Goodsframe.setLayout(new FlowLayout());
			
			Goodsframe.add(labelnameOld);
			Goodsframe.add(nameOld);
			Goodsframe.add(labelnameNew);
			Goodsframe.add(nameNew);
			Goodsframe.add(labelnum);
			Goodsframe.add(txtnum);
			Goodsframe.add(labelprice);
			Goodsframe.add(txtprice);
			Goodsframe.add(butsure);
			Goodsframe.add(back);

			Database connect=new Database();
			try {
				stmt=connect.database().prepareStatement("update Good set Goodsname=?,Goodsnum=?,Goodsprice=?,GoodsBuyInfor=GoodsBuyInfor where Goodsname=?");
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			butsure.addActionListener(new ActionListener() {			 		
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						String nameold=nameOld.getText();
						String namenew=nameNew.getText();
						String n=txtnum.getText(); 
						int num=Integer.parseInt(n);
						String price=txtprice.getText();
						stmt.setString(1, namenew);
						stmt.setInt(2, num);
						stmt.setString(3, price);
						stmt.setString(4, nameold);
						stmt.executeUpdate();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"成功修改商品"); 
					Goodsframe.dispose();
					new GoodsArrangeInter().Arrangeinit();
				}
			});
			
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Goodsframe.dispose();
					new GoodsArrangeInter().Arrangeinit();
				}
			});
			
			Goodsframe.setVisible(true);
			Goodsframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
