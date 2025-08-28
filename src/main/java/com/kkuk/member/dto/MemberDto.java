package com.kkuk.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

	private String id; // 회원아이디
	private String password; // 비밀번호
	private String confirmPassword; //비밀번호 확인
	private String name;
	private String email; //회원이메일
	private Integer age; // 나이 -> null 값 확인을 위해 inreger로 변경

	
}
