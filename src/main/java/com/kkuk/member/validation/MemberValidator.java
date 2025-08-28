package com.kkuk.member.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kkuk.member.dto.MemberDto;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return MemberDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		MemberDto memberDto = (MemberDto)target;
		String id = memberDto.getId();
		String password = memberDto.getPassword();
		String name = memberDto.getName();
		String email = memberDto.getEmail();
		Integer age = memberDto.getAge();
		String confirmPassword = memberDto.getConfirmPassword();
		
		// 아이디가 공란인지 확인
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.empty", "아이디는 필수 입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "비밀번호는 필수 입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "confirmPassword.empty", "비밀번호확인은 필수 입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "이름은 필수 입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "age.empty", "나이는 필수 입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "이메일 필수 입력 사항입니다.");
		// 아이디의 길이가 5자 이상인지 확인
		if(id != null && id.length() < 5 ) { // 참이면 error -> 아이디 길이가 5자 미만이면 error
			errors.rejectValue("id","id.short","아이디는 5자 이상이여야합니다.");
		}// 비밀번호의 길이가 5자 이상인지 확인
		if(password != null && password.length() < 5 ) { // 참이면 error -> 비밀번호 길이가 5자 미만이면 error
			errors.rejectValue("password","password.short","비밀번호는 5자 이상이여야합니다.");
		}
		//비밀번호 확인(confirmPassword 일치 여부)
		if(password != null && !password.equals(confirmPassword)) { // 참이면 비밀번호 확인실패 - > error
			errors.rejectValue("confirmPassword", "id.mismatch","비밀번호 확인이 일치하지 않습니다.");
		}
		// 18세 이상만 가입 가능하게 하겠다
		if(age == null || age < 18 ) {
			errors.rejectValue("age", "age.short", "나이가 18세 이상만 가입 가능합니다.");
		}
		
	}



}
