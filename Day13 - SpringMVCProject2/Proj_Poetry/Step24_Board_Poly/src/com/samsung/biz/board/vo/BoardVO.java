package com.samsung.biz.board.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.samsung.biz.common.CommonVO;

@Component("boardVO")
public class BoardVO extends CommonVO{
	private int seq;			
	private String title;		
	private String nickname;	
	private String content;		
	private Date regdate; 			
	private int cnt;			
	private String userid;	
	
	public BoardVO(){
		super();
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardVO [seq=");
		builder.append(seq);
		builder.append(", title=");
		builder.append(title);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append(", content=");
		builder.append(content);
		builder.append(", regdate=");
		builder.append(regdate);
		builder.append(", cnt=");
		builder.append(cnt);
		builder.append(", userid=");
		builder.append(userid);
		builder.append(", getSearchCondition()=");
		builder.append(getSearchCondition());
		builder.append(", getSearchKeyword()=");
		builder.append(getSearchKeyword());
		builder.append("]");
		return builder.toString();
	}

}
