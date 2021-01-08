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
		
		
		//�û���¼����
		public void Userinit() {
			Userframe=new JFrame("�û���¼");
			txtid=new JTextField(10);
			txtpass=new JTextField(10);
			LabelUserid=new JLabel("�û��˺�");
			LabelUserpass=new JLabel("�˺�����");
			butUser=new JButton("ȷ��");
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
						
						JOptionPane.showMessageDialog(null,"�û���¼�ɹ�!\n��ӭʹ�ñ������̳�!\nף���������!"); 
						Userframe.dispose();
						new User().Buyinit();
					}
					else {
						JOptionPane.showMessageDialog(null,"�û���¼ʧ�ܣ�����\n�����µ�¼"); 
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
		

		//�û��������
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
				Buyframe=new JFrame("�����̳�"); 
				label=new JLabel("����Ϊ���̳�������Ʒ");  
				labelname=new JLabel("��������Ҫ�������Ʒ���ƣ�");
				labelnum=new JLabel("��������Ҫ�������Ʒ����:");
				txtname=new JTextField(20);
				txtnum=new JTextField(20);
				sureBuy=new JButton("ȷ�Ϲ���");
				look=new JButton("�鿴������Ϣ");
				exit=new JButton("�˳���¼");
				
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
						JOptionPane.showMessageDialog(null,"����ɹ���\n��Ʒ������������ע�����"); 
						Buyframe.dispose();
						try {
							String name=txtname.getText();
							String a=txtnum.getText();
							if(a.equals(""))
								a="0";
							int num=Integer.parseInt(a);
							
							//����Goods��
							psBuy.setInt(1, num);
							psBuy.setString(2, name);
							psBuy.executeUpdate();
							
							//����BuyInfor��
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
						JOptionPane.showMessageDialog(null,"��л����ʹ��"); 
						Buyframe.dispose();
					}
				});
				
					Buyframe.setVisible(true);
					Buyframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}

//�û�ע�����
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
		Registerframe=new JFrame("�û�ע��");
		txtpass=new JTextField(50);
		txtid=new JTextField(50);
		butRegister=new JButton("ȷ��");
		LabelRegisterpass=new JLabel("����������:");
		flo=new FlowLayout(FlowLayout.LEFT,50,50);
		LabelRegisterid=new JLabel("�������˺�");		

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
				JOptionPane.showMessageDialog(null,"���û��ѱ�ע�ᣡ����\n\t������ע��"); 
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
				JOptionPane.showMessageDialog(null,"���û�ע��ɹ�");
				Registerframe.dispose();
				new User().Userinit();
			}
		}	
	});
			
	Registerframe.setVisible(true);
	Registerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}	
