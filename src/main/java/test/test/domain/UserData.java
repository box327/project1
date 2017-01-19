package test.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class UserData {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(length = 15, nullable = false, unique = true)
	private String userId;
	@Column(length = 20, nullable = false)
	private String password;
	@Column(length = 20, nullable = false)
	private String name;
	@Column(length = 50, nullable = false)
	private String email;
	
	public UserData() {
		super();
	}

	public UserData(String userId, String password, String name, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public boolean checkPassword(String password)
	{
		return this.password.equals(password);
	}
	
	public boolean userUpdate(UserData updateUser)
	{
		if(this.userId.equals(updateUser.getUserId()) && checkPassword(updateUser.getPassword()))
		{
			this.email = updateUser.getEmail();
			this.name = updateUser.getName();
			return true;
		}
		return false;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserData [id=" + id + ", userId=" + userId + ", password=" + password + ", name=" + name + ", email="
				+ email + "]";
	}
	
	
}
