package com.SuperMark.backstage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.SuperMark.dao.Database;

public class PublicUse {
	JTable table=null;
	JScrollPane scrollPane=null;
	Vector<?> row,column;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	JButton back;
	
	JLabel labelTime;

	public JScrollPane getScrollPane() {
		Vector<String> column=new Vector<String>();
		Vector<Vector<String>> row=new Vector<Vector<String>>();
		
		column.add("商品名");
		column.add("商品数量");
		column.add("商品价格");		
		column.add("商品销量");
		
		Database connect=new Database();
		try {
			ps=connect.database().prepareStatement("select * from Good order by GoodsBuyInfor desc");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Vector<String> rowdata=new Vector<String>();
				rowdata.add(rs.getString(1));
				rowdata.add(rs.getString(2));
				rowdata.add(rs.getString(3));
				rowdata.add(rs.getString(4));
				row.add(rowdata);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			try {
				if(rs!=null){
				rs.close();
				}
				if(ps!=null){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		table=new JTable(row,column);
		return scrollPane = new JScrollPane(table);
	}
	
	public void getData() {
		
	}
	public JLabel getLabelTime() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		return labelTime=new JLabel("当前时间："+dateFormat.format(calendar.getTime()));
	}
}
