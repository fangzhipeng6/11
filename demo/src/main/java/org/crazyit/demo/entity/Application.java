package org.crazyit.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APPLICATION")
public class Application {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	    
	 @Column
	 private Integer premananid_key;
	 
	 @Column
	 private Integer telephone;
	 
	 @Column
	 private String email;
	 
	 @Column
	 private Integer profession;
	 
	 @Column
	 private String promise;
	 
	 @Column
	 private Integer memberid1;
	 
	 @Column
	 private Integer memberid2;
	 
	 @Column
	 private Integer memberid3;
	 
	 @Column
	 private Date createtime;
	 
	 @Column
	 private Date modifytime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPremananid_key() {
		return premananid_key;
	}

	public void setPremananid_key(Integer premananid_key) {
		this.premananid_key = premananid_key;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getProfession() {
		return profession;
	}

	public void setProfession(Integer profession) {
		this.profession = profession;
	}

	public String getPromise() {
		return promise;
	}

	public void setPromise(String promise) {
		this.promise = promise;
	}

	public Integer getMemberid1() {
		return memberid1;
	}

	public void setMemberid1(Integer memberid1) {
		this.memberid1 = memberid1;
	}

	public Integer getMemberid2() {
		return memberid2;
	}

	public void setMemberid2(Integer memberid2) {
		this.memberid2 = memberid2;
	}

	public Integer getMemberid3() {
		return memberid3;
	}

	public void setMemberid3(Integer memberid3) {
		this.memberid3 = memberid3;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	 
}
