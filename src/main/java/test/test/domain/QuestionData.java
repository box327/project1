package test.test.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class QuestionData {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private UserData writer;
	
	@OneToMany(mappedBy="question")
	private List<AnswerData> answers;

	public void setAnswers(List<AnswerData> answers) {
		this.answers = answers;
	}

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
	

	public List<AnswerData> getAnswers() {
		return answers;
	}

	
	public void setWriter(UserData writer) {
		this.writer = writer;
	}



	public UserData getWriter() {
		return writer;
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
		return "QuestionData [id=" + id + ", writer=" + writer + ", answers=" + answers + ", title=" + title
				+ ", contents=" + contents + ", writeDate=" + writeDate + "]";
	}
	
}
