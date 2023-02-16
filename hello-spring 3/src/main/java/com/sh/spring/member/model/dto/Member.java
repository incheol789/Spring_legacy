package com.sh.spring.member.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Member {
	@NonNull
	private String memberId;
	@NonNull
	private String password;
	@NonNull
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday; // 1999-09-09 사용자요청처리
	private String email;
	@NonNull
	private String phone;
	private LocalDateTime createdAt;
	private boolean enabled;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(@NonNull String memberId, @NonNull String password, @NonNull String name, LocalDate birthday,
			String email, @NonNull String phone, LocalDateTime createdAt, boolean enabled) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
		this.createdAt = createdAt;
		this.enabled = enabled;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", password=" + password + ", name=" + name + ", birthday=" + birthday
				+ ", email=" + email + ", phone=" + phone + ", createdAt=" + createdAt + ", enabled=" + enabled + "]";
	}
	
	
	
	
}