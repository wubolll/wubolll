package com.SuperMark.backstage;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.SuperMark.dao.Database;

public class AddData {
	public static int getRandom() {
		Random ran=new Random();
		int i=ran.nextInt(100000);
		return i;
	}
	public static void main(String[] args) {
		String good;
		String nS=null,pS=null,name=null,pass=null;
		PreparedStatement stmtGood=null;
		
		PreparedStatement stmtUser=null;
		
		String [] one=new String[10];
		String [] two=new String[10];
		one[0]="ƻ��";
		one[1]="�㽶";
		one[2]="����";
		one[3]="����";
		one[4]="����";
		one[5]="����";
		one[6]="��ݮ";
		one[7]="����";
		one[8]="������";
		one[9]="����";
		
		two[0]="��";
		two[1]="ţ��";
		two[2]="��";
		two[3]="����";
		two[4]="��֭";
		two[5]="��";
		two[6]="����";
		two[7]="���";
		two[8]="������";
		two[9]="ǧ��";
		Database connect=new Database();
		try {
			stmtGood=connect.database().prepareStatement("insert into Good values(?,?,?)");	
			stmtUser=connect.database().prepareStatement("insert into Users values(?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				good=one[i]+two[j];
				int p=getRandom();
				int n=getRandom();
				nS=String.valueOf(n);
				pS=String.valueOf(p);
				
				try {
					stmtGood.setString(1, good);
					stmtGood.setString(2, nS);
					stmtGood.setString(3, pS);
					stmtGood.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		}
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				int a=getRandom();
				int b=getRandom();
				name=String.valueOf(a);
				pass=String.valueOf(b);
	
				try {
					stmtUser.setString(1, name);
					stmtUser.setString(2, pass);
					stmtUser.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		}
	}
}
