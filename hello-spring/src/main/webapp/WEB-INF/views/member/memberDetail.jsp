<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="회원정보" name="title"/>
</jsp:include>
<style>
div#update-container{width:400px; margin:0 auto; text-align:center;}
div#update-container input, div#update-container select {margin-bottom:10px;}
</style>
<div id="update-container">
	<form name="memberUpdateFrm" action="${pageContext.request.contextPath}/member/memberUpdate.do" method="post">
		<input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="memberId" id="memberId" value="${loginMember.memberId}"readonly required/>
		<input type="text" class="form-control" placeholder="이름" name="name" id="name" value="${loginMember.name}"required/>
		<input type="date" class="form-control" placeholder="생일" name="birthday" id="birthday" value="${loginMember.birthday }"/>
		<input type="email" class="form-control" placeholder="이메일" name="email" id="email" required value="${loginMember.email}"/>
		<input type="tel" class="form-control" placeholder="전화번호 (예:01012345678)" name="phone" id="phone" maxlength="11" required value="${loginMember.phone}"/>
		<br />
		<input type="submit" class="btn btn-outline-success" value="수정" >&nbsp;
		<input type="reset" class="btn btn-outline-success" value="취소">
	</form>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
