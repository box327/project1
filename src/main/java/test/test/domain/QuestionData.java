package test.test.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QuestionData {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(length=20, nullable=false)
	private String writer;
	@Column(length=40, nullable=false)
	private String title;
	@Column(length=2000, nullable=false)
	private String contents;
	@Column
	private Date writeDate;
	
	public QuestionData() {
		super();
		writeDate = new Date();
	}
	
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
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
		return "QuestionData [id=" + id + ", writer=" + writer + ", title=" + title + ", contents=" + contents
				+ ", writeDate=" + writeDate + "]";
	}
	
}
