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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.SuperMark.backstage.GoodCollect;
import com.SuperMark.dao.Database;

class UserInforInter{	
	public static JFrame BuyInforframe;
	private static JTextField txt;
	private static JLabel label;
	private static JLabel labelname;
	private static JLabel labelnum;
	private static JButton look;
	private static JButton back;
	private static JButton GoodCollect;
	
	JTextField Nametext;
	JTextField Numtext;

	static GoodCollect goodcollect;
	
	String Id;
	Statement stmt;
	ResultSet rs;
	
	public void UserInforinit() {
		
		GoodCollect=new JButton("收藏");
		
		BuyInforframe=new JFrame("购物信息一览");
		look=new JButton("查询");
		back=new JButton("返回");
		txt=new JTextField(30);
		label=new JLabel("请输入您的账号：");
		labelname=new JLabel("您购买的商品为：");
		labelnum=new JLabel("您购买的数量为：");
		Nametext=new JTextField(30);
		Numtext=new JTextField(30);

		BuyInforframe.setSize(500,200);
		BuyInforframe.setLocation(500,500);
		BuyInforframe.setLayout(new FlowLayout());
		
		look.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Id=txt.getText();
					
					Database connect=new Database();
					stmt=connect.database().createStatement();
					String sql1=("select Goodsname,Goodsnum from BuyInfor where Userid="+Id);
					rs=stmt.executeQuery(sql1);	
					if(rs.next()) {
						Nametext.setText(rs.getString(1));
						Numtext.setText(rs.getString(2));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}			
		});
		
		GoodCollect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Id=txt.getText();
				
					Database connect=new Database();
					stmt=connect.database().createStatement();
					String sql1=("select Goodsname,Goodsnum from BuyInfor where Userid="+Id);
					rs=stmt.executeQuery(sql1);	
					if(rs.next()) {
						new GoodCollect().CollectInfor(Id,rs.getString(1),rs.getString(2));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(null,"收藏成功");
				BuyInforframe.dispose();
				new UserInforInter().UserInforinit();
			}			
		});
		
		BuyInforframe.add(label);
		BuyInforframe.add(txt);
		BuyInforframe.add(labelname);
		BuyInforframe.add(Nametext);
		BuyInforframe.add(labelnum);
		BuyInforframe.add(Numtext);
		BuyInforframe.add(look);
		BuyInforframe.add(GoodCollect);
		BuyInforframe.add(back);	
				
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BuyInforframe.dispose();
				new User().Buyinit();
			}
		});
		
		BuyInforframe.setVisible(true);
		BuyInforframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class UserBuyInfor{
	public static void main(String[]args) {
		new UserInforInter().UserInforinit();
	}
}
