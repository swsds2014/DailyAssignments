package com.samsung.vo;

import java.sql.Date;

public class ReplyVO {
	private int rseq;
	private String rcontent;
	private String ruser;
	private Date rdate;
	private int rlevel;
	private int rstep;
	private int bseq;
	
	public ReplyVO(){}

	public ReplyVO(int rseq, String rcontent, String ruser, Date rdate,
			int rlevel, int rstep, int bseq) {
		super();
		this.rseq = rseq;
		this.rcontent = rcontent;
		this.ruser = ruser;
		this.rdate = rdate;
		this.rlevel = rlevel;
		this.rstep = rstep;
		this.bseq = bseq;
	}

	public int getRseq() {
		return rseq;
	}

	public void setRseq(int rseq) {
		this.rseq = rseq;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRuser() {
		return ruser;
	}

	public void setRuser(String ruser) {
		this.ruser = ruser;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public int getRlevel() {
		return rlevel;
	}

	public void setRlevel(int rlevel) {
		this.rlevel = rlevel;
	}

	public int getRstep() {
		return rstep;
	}

	public void setRstep(int rstep) {
		this.rstep = rstep;
	}

	public int getBseq() {
		return bseq;
	}

	public void setBseq(int bseq) {
		this.bseq = bseq;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReplyVO [rseq=");
		builder.append(rseq);
		builder.append(", rcontent=");
		builder.append(rcontent);
		builder.append(", ruser=");
		builder.append(ruser);
		builder.append(", rdate=");
		builder.append(rdate);
		builder.append(", rlevel=");
		builder.append(rlevel);
		builder.append(", rstep=");
		builder.append(rstep);
		builder.append(", bseq=");
		builder.append(bseq);
		builder.append("]");
		return builder.toString();
	}
	
}
