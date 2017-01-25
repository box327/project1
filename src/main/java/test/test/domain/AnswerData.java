package test.test.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerData {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private UserData writer;
	@ManyToOne
	private QuestionData question;
	
	@Column
	private Date writeDate;
	@Column(length=500)
	private String comment;

	
	
	public AnswerData() {
		super();
		writeDate = new Date();
	}

	public UserData getWriter() {
		return writer;
	}

	public void setWriter(UserData writer) {
		this.writer = writer;
	}

	public QuestionData getQuestion() {
		return question;
	}

	public void setQuestion(QuestionData question) {
		this.question = question;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "AnswerData [writer=" + writer + ", writeDate=" + writeDate + ", comment="
				+ comment + "]";
	}
	
}
