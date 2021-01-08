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

public class GoodsAddInter{
	public static JFrame Goodsframe;
	private static JTextField txtname;
	private static JTextField txtnum;
	private static JTextField txtprice;
	private static JLabel labelname;
	private static JLabel labelnum;
	private static JLabel labelprice;
	private static JButton butsure;
	private static JButton back;
	
	PreparedStatement stmt;
	
	public void GoodsAddinit() {
		Goodsframe=new JFrame("电子商城进货服务");
		txtname=new JTextField(20);
		txtnum=new JTextField(20);
		txtprice=new JTextField(20);
		labelname=new JLabel("商品名");
		labelnum=new JLabel("商品数量");
		labelprice=new JLabel("商品价格");
		butsure=new JButton("确认");
		back=new JButton("取消");
		
		Goodsframe.setSize(600,300);
		Goodsframe.setLocation(500,500);
		Goodsframe.setLayout(new FlowLayout());
		
		Goodsframe.add(labelname);
		Goodsframe.add(txtname);
		Goodsframe.add(labelnum);
		Goodsframe.add(txtnum);
		Goodsframe.add(labelprice);
		Goodsframe.add(txtprice);
		Goodsframe.add(butsure);	
		Goodsframe.add(back);
		
		Database connect=new Database();
		try {
			stmt=connect.database().prepareStatement("insert into Good (Goodsname,Goodsnum,Goodsprice,GoodsBuyInfor) values(?,?,?,0)");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		butsure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtname.getText();
				String n=txtnum.getText(); 
				int num=Integer.parseInt(n);
				String price=txtprice.getText(); 
				try {
					stmt.setString(1, name);
					stmt.setInt(2, num);
					stmt.setString(3, price);
					stmt.executeUpdate();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"添加商品成功");  
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
