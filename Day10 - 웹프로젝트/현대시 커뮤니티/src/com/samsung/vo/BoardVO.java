package com.samsung.vo;

import java.sql.Date;

public class BoardVO {
	private int bseq;
	private String btitle;
	private String bcontent;
	private String buser;
	private Date bdate;
	private int bcnt;
	
	public BoardVO(){}

	public BoardVO(int bseq, String btitle, String bcontent, String buser,
			Date bdate, int bcnt) {
		super();
		this.bseq = bseq;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.buser = buser;
		this.bdate = bdate;
		this.bcnt = bcnt;
	}

	public int getBseq() {
		return bseq;
	}

	public void setBseq(int bseq) {
		this.bseq = bseq;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBuser() {
		return buser;
	}

	public void setBuser(String buser) {
		this.buser = buser;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public int getBcnt() {
		return bcnt;
	}

	public void setBcnt(int bcnt) {
		this.bcnt = bcnt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardVO [bseq=");
		builder.append(bseq);
		builder.append(", btitle=");
		builder.append(btitle);
		builder.append(", bcontent=");
		builder.append(bcontent);
		builder.append(", buser=");
		builder.append(buser);
		builder.append(", bdate=");
		builder.append(bdate);
		builder.append(", bcnt=");
		builder.append(bcnt);
		builder.append("]");
		return builder.toString();
	}
	
}
