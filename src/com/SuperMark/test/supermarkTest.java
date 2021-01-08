package com.SuperMark.test;

import org.junit.Test;

import com.SuperMark.pojo.*;
import com.SuperMark.pojo.User;
import com.SuperMark.ui.*;

public class supermarkTest {
	@Test
	public void test1() {
		new GoodsAddInter().GoodsAddinit();
	}
	@Test
	public void test2() {
		new GoodsDropInter().GoodsDropinit(); 
	}
	@Test
	public void test3() {
		new GoodsChangeInter().GoodsChangeinit();
	}
	@Test
	public void test4() {
		new GoodsLookInter().GoodsLookinit();
	}
	@Test
	public void test5() {
		new Good();
	}
	@Test
	public void test6() {
		new BuyInfor();
	}
	@Test
	public void test7() {
		new User();
	}
}
