package com.kali.kali;

public class STSBean  implements Comparable<STSBean>{
	private Integer number;
	private String name;
	private String account;
	public String pubN;
	protected String proN;
	String defN;
	
	public STSBean(){
	}
	public STSBean(Integer num,String name, String acc){
		this.number = num;
		this.name= name;
		this.account = acc;
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Override
	public int compareTo(STSBean o) {
		int val = number.compareTo(o.getNumber());
		if(val==0){
			return account.compareTo(o.getAccount());
		}
		return val;
	}
	@Override
	public boolean equals(Object obj){
		if(obj==null)
			return false;
		else if(obj.getClass()== STSBean.class){
			STSBean sts = (STSBean) obj;
			if(sts.number==this.number && sts.name.equals(this.name) && sts.account.equals(this.account)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		int hash = this.number.hashCode();
		hash = hash+this.account.hashCode();
		hash = hash+this.name.hashCode();
		
		return hash;
	}
	
	  void m1(){
		System.out.println("from parent");
	}
	
	
}
