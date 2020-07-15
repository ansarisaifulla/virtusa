package io.javabrains.springSecurity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class user {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	private String name;
	private String cpassword;
	private String mobile;
	public user()
	{
		
	}
	


//	public user(long id, String username, String password, String name, String cpassword, String mobile) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.name = name;
//		this.cpassword = cpassword;
//		this.mobile = mobile;
//	}
	public user(String username, String password, String name, String cpassword, String mobile) {
		super();
//		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.cpassword = cpassword;
		this.mobile = mobile;
	}
	
	
	@ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
	      name="user_role",
	      joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
	      inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="roleid")})

//	private Set<role> roles=new HashSet<>();
	private Collection<role> roles;


	public user(String username, String password, String name, String cpassword, String mobile,
			Collection<role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.cpassword = cpassword;
		this.mobile = mobile;
		this.roles = roles;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	


	public Collection<role> getRoles() {
		return roles;
	}



	public void setRoles(Collection<role> roles) {
		this.roles = roles;
	}



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCpassword() {
		return cpassword;
	}


	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		

}
