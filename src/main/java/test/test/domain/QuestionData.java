package test.test.domain;

import java.util.Date;

public class QuestionData {
	private String writer;
	private String title;
	private String contents;
	private Date writeDate;
	
	public QuestionData() {
		super();
		writeDate = new Date();
	}
	
	
	
	public Date getWriteDate() {
		return writeDate;
	}



	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}



	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	@Override
	public String toString() {
		return "QuestionData [writer=" + writer + ", title=" + title + ", contents=" + contents + ", writeDate="
				+ writeDate + "]";
	}
	
}
