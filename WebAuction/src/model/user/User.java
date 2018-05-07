package model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USERID")
	private String userid;
	@Column(name = "NAME")
	private String name;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;

	public User(String userid, String name, String username, String password) {
		super();
		this.userid = userid;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public User() {
		this(null, null, null, null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserid() {
		return userid;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name  + ", username=" + username
				+ ", password=" + password + "]";
	}

}
