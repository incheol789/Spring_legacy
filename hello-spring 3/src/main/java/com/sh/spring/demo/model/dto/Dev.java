package com.sh.spring.demo.model.dto;

import java.time.LocalDateTime;
import java.util.Arrays;



//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class Dev {
	private int no; // pk
	private String name;
	private int career;
	private String email;
	private Gender gender;
	private String[] lang;
	private LocalDateTime createdAt;
	
	
	public Dev() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Dev(int no, String name, int career, String email, Gender gender, String[] lang, LocalDateTime createdAt) {
		super();
		this.no = no;
		this.name = name;
		this.career = career;
		this.email = email;
		this.gender = gender;
		this.lang = lang;
		this.createdAt = createdAt;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCareer() {
		return career;
	}


	public void setCareer(int career) {
		this.career = career;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public String[] getLang() {
		return lang;
	}


	public void setLang(String[] lang) {
		this.lang = lang;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "Dev [no=" + no + ", name=" + name + ", career=" + career + ", email=" + email + ", gender=" + gender
				+ ", lang=" + Arrays.toString(lang) + ", createdAt=" + createdAt + "]";
	}
	
	
	
	

}