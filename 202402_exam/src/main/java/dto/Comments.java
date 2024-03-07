package dto;

import java.sql.Date;

public class Comments {

private int commentNum;
private int boardNum;
private String writer;
private String content;
private String regtime;

public Comments(int commentNum, int boardNum, String writer, String content, String regtime) {
	this.commentNum = commentNum;
	this.boardNum = boardNum;
	this.writer = writer;
	this.content = content;
	this.regtime = regtime;
}

public Comments(int boardNum, String writer, String content) {
	this.boardNum = boardNum;
	this.writer = writer;
	this.content = content;
}


public Comments(int commentNum, String content) {
	super();
	this.commentNum = commentNum;
	this.content = content;
}

public int getCommentNum() {
	return commentNum;
}

public void setCommentNum(int commentNum) {
	this.commentNum = commentNum;
}

public int getBoardNum() {
	return boardNum;
}

public void setBoardNum(int boardNum) {
	this.boardNum = boardNum;
}

public String getWriter() {
	return writer;
}

public void setWriter(String writer) {
	this.writer = writer;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getRegtime() {
	return regtime;
}

public void setRegtime(String regtime) {
	this.regtime = regtime;
}


}

