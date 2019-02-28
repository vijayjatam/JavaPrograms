package com.kali.singleTon;

class BillPugeSingleTon{
	 private BillPugeSingleTon(){
		 
	 }
	 private static class InnerBillPugeSingleTon{
		 private static BillPugeSingleTon getInnerBillInstance(){
			final BillPugeSingleTon billSingleTon = new BillPugeSingleTon();
			 return billSingleTon;
		 }
	 }
	 
	 protected static class InnerBillPugeSingleTon1{
		 private static BillPugeSingleTon getInnerBillInstance(){
			final BillPugeSingleTon billSingleTon = new BillPugeSingleTon();
			 return billSingleTon;
		 }
	 }
	 public static BillPugeSingleTon getInstance(){
		 return InnerBillPugeSingleTon.getInnerBillInstance();
	 }
}
