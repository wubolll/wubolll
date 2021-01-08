package com.SuperMark.pojo;

public class Good {
	String Goodsname;
	int Goodsnum;
	String Goodsprice;
	int GoodsBuyInfor;
	
	public Good() {}
	
	public Good(String goodsname, int goodsnum, String goodsprice, int goodsBuyInfor) {
		super();
		Goodsname = goodsname;
		Goodsnum = goodsnum;
		Goodsprice = goodsprice;
		GoodsBuyInfor = goodsBuyInfor;
	}

	public String getGoodsname() {
		return Goodsname;
	}

	public void setGoodsname(String goodsname) {
		Goodsname = goodsname;
	}

	public int getGoodsnum() {
		return Goodsnum;
	}

	public void setGoodsnum(int goodsnum) {
		Goodsnum = goodsnum;
	}

	public String getGoodsprice() {
		return Goodsprice;
	}

	public void setGoodsprice(String goodsprice) {
		Goodsprice = goodsprice;
	}

	public int getGoodsBuyInfor() {
		return GoodsBuyInfor;
	}

	public void setGoodsBuyInfor(int goodsBuyInfor) {
		GoodsBuyInfor = goodsBuyInfor;
	}

	@Override
	public String toString() {
		return "Good [Goodsname=" + Goodsname + ", Goodsnum=" + Goodsnum + ", Goodsprice=" + Goodsprice
				+ ", GoodsBuyInfor=" + GoodsBuyInfor + "]";
	}
}
