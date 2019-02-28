package com.kali;

public class TestingBean {
	private String str;
	private  Integer intr;
	private Long longer;
	private Double doubl;
	private Float flot;
	private Byte byt;
	private Short shrt;
	
	public String toString(){
		return this.str+" , "+this.shrt+" , "+this.byt+" , "+this.flot+" , "+this.doubl+" , "+this.longer+" , "+this.intr;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Integer getIntr() {
		return intr;
	}

	public void setIntr(Integer intr) {
		this.intr = intr;
	}

	public Long getLonger() {
		return longer;
	}

	public void setLonger(Long longer) {
		this.longer = longer;
	}

	public Double getDoubl() {
		return doubl;
	}

	public void setDoubl(Double doubl) {
		this.doubl = doubl;
	}

	public Float getFlot() {
		return flot;
	}

	public void setFlot(Float flot) {
		this.flot = flot;
	}

	public Byte getByt() {
		return byt;
	}

	public void setByt(Byte byt) {
		this.byt = byt;
	}

	public Short getShrt() {
		return shrt;
	}

	public void setShrt(Short shrt) {
		this.shrt = shrt;
	}
	
	
}
