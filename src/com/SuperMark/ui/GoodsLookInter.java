package com.SuperMark.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.SuperMark.dao.Database;

public class GoodsLookInter {
	
	public static JFrame Goodsframe;
	private static JLabel labelName;
	private static JLabel labelNum;
	private static JLabel labelPrice;
	private static JLabel labelBuyInfor;
	private static JTextField txtName;
	private static JTextField txtNum;
	private static JTextField txtPrice;
	private static JTextField txtBuyInfor;
	private static JButton back;
	private static JButton look;

	String name;
	Statement stmt;
	ResultSet rs;
	
	public void GoodsLookinit() {
		Goodsframe=new JFrame("商品信息查询");
		look=new JButton("查询");
		back=new JButton("返回");
		
		labelName=new JLabel("请输入您的要查找的商品名：");
		labelNum=new JLabel("商品数量为：");
		labelPrice=new JLabel("商品价格为：");
		labelBuyInfor=new JLabel("商品销量为：");
		txtName=new JTextField(25);
		txtNum=new JTextField(30);
		txtPrice=new JTextField(30);
		txtBuyInfor=new JTextField(30);
		
		Goodsframe.setSize(500,500);
		Goodsframe.setLocation(500,500);
		Goodsframe.setLayout(new FlowLayout());
		
		look.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					name=txtName.getText();
					
					Database connect=new Database();
					stmt=connect.database().createStatement();
					String sql1=("select Goodsnum,Goodsprice,GoodsBuyInfor from Good where Goodsname='"+name+"'");
					rs=stmt.executeQuery(sql1);	
					if(rs.next()) {
						txtNum.setText(rs.getString(1));
						txtPrice.setText(rs.getString(2));
						txtBuyInfor.setText(rs.getString(3));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}			
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Goodsframe.dispose();
				new GoodsArrangeInter().Arrangeinit();
			}			
		});
		
		Goodsframe.add(labelName);
		Goodsframe.add(txtName);
		Goodsframe.add(labelNum);
		Goodsframe.add(txtNum);
		Goodsframe.add(labelPrice);
		Goodsframe.add(txtPrice);
		Goodsframe.add(labelBuyInfor);
		Goodsframe.add(txtBuyInfor);
		Goodsframe.add(look);
		Goodsframe.add(back);
		
		Goodsframe.setVisible(true);
		Goodsframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
