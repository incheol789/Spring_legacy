package com.sh.spring.member.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
