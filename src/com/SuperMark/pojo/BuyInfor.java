package com.SuperMark.pojo;

public class BuyInfor {
	String Goodsname;
	String Userid;
	int Goodsnum;
	
	public BuyInfor() {}
	
	public BuyInfor(String goodsname, String userid, int goodsnum) {
		super();
		Goodsname = goodsname;
		Userid = userid;
		Goodsnum = goodsnum;
	}

	public String getGoodsname() {
		return Goodsname;
	}

	public void setGoodsname(String goodsname) {
		Goodsname = goodsname;
	}

	public String getUserid() {
		return Userid;
	}

	public void setUserid(String userid) {
		Userid = userid;
	}

	public int getGoodsnum() {
		return Goodsnum;
	}

	public void setGoodsnum(int goodsnum) {
		Goodsnum = goodsnum;
	}

	@Override
	public String toString() {
		return "BuyInfor [Goodsname=" + Goodsname + ", Userid=" + Userid + ", Goodsnum=" + Goodsnum + "]";
	}		
}
