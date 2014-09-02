package com.apress.prospring3.ch6.afterreturning02;

public class PeaceSells {
	private String nation;
	
	public PeaceSells() {
		this.nation = "대한민국";
	}
	
	public PeaceSells(String nation) {
		this.nation = nation;
		System.out.println(sellPeace());
	}
	
	public String sellPeace() {
		StringBuffer sb = new StringBuffer();
		sb.append(nation);
		sb.append(" 평화를 팝니다! 그런데 누가 사지?" + "\r\n");
		return sb.toString();
	}
}
