package com.demo.model;

import javax.persistence.*;

@Entity
@Table(name="STUDENT_MST")
public class StudentMst {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "STUDENT_NAME")
	private String studName;
	
	@Column(name = "STUDENT_CODE")
	private String studCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudCode() {
		return studCode;
	}

	public void setStudCode(String studCode) {
		this.studCode = studCode;
	}

	@Override
	public String toString() {
		return "StudentMst [id=" + id + ", studName=" + studName + ", studCode=" + studCode + "]";
	}
	
	
}
