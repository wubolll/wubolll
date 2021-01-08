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
		one[0]="Æ»¹û";
		one[1]="Ïã½¶";
		one[2]="ÇàÀæ";
		one[3]="ÆÏÌÑ";
		one[4]="ÁñÁ«";
		one[5]="éÙ×Ó";
		one[6]="²İİ®";
		one[7]="Î÷¹Ï";
		one[8]="»ğÁú¹û";
		one[9]="³È×Ó";
		
		two[0]="ÌÇ";
		two[1]="Å£ÄÌ";
		two[2]="ËÖ";
		two[3]="µ°¸â";
		two[4]="¹ûÖ­";
		two[5]="ÅÉ";
		two[6]="ËáÄÌ";
		two[7]="Ãæ°ü";
		two[8]="ÈıÃ÷ÖÎ";
		two[9]="Ç§²ã";
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
