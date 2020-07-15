package io.javabrains.springSecurity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleid;
	private String rolename;
	
	public role()
	{
		
	}
	
	public role(String rolename) {
		super();
		this.rolename = rolename;
	}

	public long getRoleid() {
		return roleid;
	}
	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	

}
