package com.SuperMark.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;

import com.SuperMark.backstage.PublicUse;
import com.SuperMark.dao.Database;

public class User{

		public JFrame Userframe;
		private JTextField txtid;
		private JTextField txtpass;
		private JLabel LabelUserid;
		private JLabel LabelUserpass;
		private JPanel PanelUser;
		private JButton butUser;
		ResultSet rs;	
		String name;
		String pass;
		
		public static String UserId;
		
		
		//用户登录界面
		public void Userinit() {
			Userframe=new JFrame("用户登录");
			txtid=new JTextField(10);
			txtpass=new JTextField(10);
			LabelUserid=new JLabel("用户账号");
			LabelUserpass=new JLabel("账号密码");
			butUser=new JButton("确认");
			PanelUser=new JPanel();
			PanelUser.setSize(550,200);
		
			JLabel bg = new JLabel(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Users.jpg"));
			Userframe.setContentPane(bg);
			
			Userframe.setSize(750,300);
			Userframe.setLocation(500,500);
			Userframe.setLayout(new FlowLayout());
			
			PanelUser.add(LabelUserid);
			PanelUser.add(txtid);
			PanelUser.add(LabelUserpass);
			PanelUser.add(txtpass);
			PanelUser.add(butUser);
			PanelUser.add(new PublicUse().getLabelTime());
			PanelUser.setBackground(Color.pink);
			Userframe.add(PanelUser,BorderLayout.CENTER);
			
			butUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					name=txtid.getText();
					pass=txtpass.getText();
					// TODO Auto-generated method stub
					boolean b=SureEsit(name,pass);
					if(b==true) {
												
						UserId=name;
						
						JOptionPane.showMessageDialog(null,"用户登录成功!\n欢迎使用本电子商城!\n祝您购物愉快!"); 
						Userframe.dispose();
						new User().Buyinit();
					}
					else {
						JOptionPane.showMessageDialog(null,"用户登录失败！！！\n请重新登录"); 
						Userframe.dispose();
						new User().Userinit();
					}
				}
			});
						
			Userframe.setVisible(true);
			Userframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}	

		public boolean SureEsit(String name2,String pass2) {
			boolean boo=false;
			try {
				Statement stmt=new Database().database().createStatement();
				rs=stmt.executeQuery("select * from Users where Userid="+name2+" and Userpass="+pass2);
				if(rs.next())
					boo=true;
				else 
					boo=false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return boo;			
		}		
		public String GetUserId() {
			return UserId;
		}
		

		//用户购买界面
			public JFrame Buyframe;
			private JLabel label;
			private JLabel labelname;
			private JLabel labelnum;
			private JTextField txtname;
			private JTextField txtnum;
			private JButton sureBuy;
			private JButton look;
			private JButton exit;
		
			JTable table=null;
			JScrollPane scrollPane=null;
			Vector row,column;
			
			PreparedStatement psBuy=null;
			PreparedStatement psBuyInfor=null;

			public void Buyinit(){
				Buyframe=new JFrame("电子商城"); 
				label=new JLabel("以下为本商城所有商品");  
				labelname=new JLabel("请输入需要购买的商品名称：");
				labelnum=new JLabel("请输入需要购买的商品数量:");
				txtname=new JTextField(20);
				txtnum=new JTextField(20);
				sureBuy=new JButton("确认购买");
				look=new JButton("查看购物信息");
				exit=new JButton("退出登录");
				
				Buyframe.setSize(500,600);
				Buyframe.setLocation(700,100);
				Buyframe.setLayout(new FlowLayout());
				
				Buyframe.add(labelname);
				Buyframe.add(txtname);
				Buyframe.add(labelnum);
				Buyframe.add(txtnum);
				Buyframe.add(sureBuy);
				Buyframe.add(label);
				Buyframe.add(new PublicUse().getScrollPane());
				Buyframe.add(new PublicUse().getLabelTime());
				Buyframe.add(look);
				Buyframe.add(exit);
				
				Database connect=new Database();
				try {
					psBuy=connect.database().prepareStatement("Update Good set GoodsBuyInfor=GoodsBuyInfor+1,Goodsnum=Goodsnum-? where Goodsname=?");
					
					psBuyInfor=connect.database().prepareStatement("insert into BuyInfor values (?,?,?)");
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				sureBuy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null,"购买成功！\n商品即将发货，请注意查收"); 
						Buyframe.dispose();
						try {
							String name=txtname.getText();
							String a=txtnum.getText();
							if(a.equals(""))
								a="0";
							int num=Integer.parseInt(a);
							
							//更新Goods表
							psBuy.setInt(1, num);
							psBuy.setString(2, name);
							psBuy.executeUpdate();
							
							//更新BuyInfor表
							psBuyInfor.setString(1, name);
							psBuyInfor.setString(2, UserId);
							psBuyInfor.setInt(3, num);
							psBuyInfor.executeLargeUpdate();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}			
						new User().Buyinit();
					}
				});
				look.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Buyframe.dispose();
						
						new UserInforInter().UserInforinit();
					}
				});
				exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null,"感谢您的使用"); 
						Buyframe.dispose();
					}
				});
				
					Buyframe.setVisible(true);
					Buyframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}

//用户注册界面
class Register{	
	public JFrame Registerframe;
	private JTextField txtpass;
	private JTextField txtid;
	private FlowLayout flo;
	private JLabel LabelRegisterpass;
	private JLabel LabelRegisterid;
	private JButton butRegister;
	
	String nameRe;
	String passRe;	
	PreparedStatement stmtRe;
	
	public void Registerinit() {
		Registerframe=new JFrame("用户注册");
		txtpass=new JTextField(50);
		txtid=new JTextField(50);
		butRegister=new JButton("确认");
		LabelRegisterpass=new JLabel("请输入密码:");
		flo=new FlowLayout(FlowLayout.LEFT,50,50);
		LabelRegisterid=new JLabel("请输入账号");		

		Registerframe.setSize(750,300);
		Registerframe.setLocation(500,500);
		Registerframe.setLayout(flo);
		
		Registerframe.add(LabelRegisterid);
		Registerframe.add(txtid);
		Registerframe.add(LabelRegisterpass);
		Registerframe.add(txtpass);
		Registerframe.add(butRegister);
		Registerframe.add(new PublicUse().getLabelTime());
		
		butRegister.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			nameRe=txtid.getText();
			passRe=txtpass.getText();
			try {
				Database connectRe=new Database();
				stmtRe=connectRe.database().prepareStatement("insert into Users values(?,?)");
				stmtRe.setString(1,nameRe);
				stmtRe.setString(2, passRe);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated method stub
			boolean b2=new User().SureEsit(nameRe,passRe);
			if(b2==true) {
				JOptionPane.showMessageDialog(null,"该用户已被注册！！！\n\t请重新注册"); 
					Registerframe.dispose();
				new Register().Registerinit();
			}
			else{
				try {
					stmtRe.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"新用户注册成功");
				Registerframe.dispose();
				new User().Userinit();
			}
		}	
	});
			
	Registerframe.setVisible(true);
	Registerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}	
