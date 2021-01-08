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

public class GoodsDropInter{
	public static JFrame Goodsframe;
	private static JTextField txtname;
	private static JLabel labelname;
	private static JButton butsure;
	private static JButton back;
	
	PreparedStatement stmt;
	
	public void GoodsDropinit() {
		Goodsframe=new JFrame("电子商城退货服务");
		txtname=new JTextField(20);
		labelname=new JLabel("商品名");
		butsure=new JButton("确认");
		back=new JButton("取消");
		
		Goodsframe.setSize(600,300);
		Goodsframe.setLocation(500,500);
		Goodsframe.setLayout(new FlowLayout());
		
		Goodsframe.add(labelname);
		Goodsframe.add(txtname);
		Goodsframe.add(butsure);
		Goodsframe.add(back);

		Database connect=new Database();
		try {
			stmt=connect.database().prepareStatement("delete from Good where Goodsname=?");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		butsure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=txtname.getText();
				try {
					stmt.setString(1, name);
					stmt.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"删除商品成功!!!");  
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