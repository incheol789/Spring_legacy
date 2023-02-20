<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="회원등록" name="title"/>
</jsp:include>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/member.css" />

<div id="enroll-container" class="mx-auto text-center">
	<form name="memberEnrollFrm" action="" method="POST">
		<table class="mx-auto">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" 
						   class="form-control" 
						   placeholder="4글자이상"
						   name="memberId" 
						   id="memberId"
						   required>
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" class="form-control" name="password" id="password" required>
				</td>
			</tr>
			<tr>
				<th>패스워드확인</th>
				<td>	
					<input type="password" class="form-control" id="passwordCheck" required>
				</td>
			</tr>  
			<tr>
				<th>이름</th>
				<td>	
					<input type="text" class="form-control" name="name" id="name" required>
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>	
					<input type="date" class="form-control" name="birthday" id="birthday"/>
				</td>
			</tr> 
			<tr>
				<th>이메일</th>
				<td>	
					<input type="email" class="form-control" placeholder="abc@xyz.com" name="email" id="email">
				</td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td>	
					<input type="tel" class="form-control" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" required>
				</td>
			</tr>
		</table>
		<input type="submit" value="가입" >
		<input type="reset" value="취소">
	</form>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
