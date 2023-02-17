<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="com.sh.spring.demo.model.dto.Dev"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% 
	Dev dev = (Dev)request.getAttribute("dev");
	List<String> devLangList = 
			dev.getLang() != null ? 
				Arrays.asList(dev.getLang()) :
					null;
	pageContext.setAttribute("devLangList", devLangList);
%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="Demo" name="pageTitle"/>
</jsp:include>
<style>
div#demo-container{
	width:550px;
	padding:15px;
	border:1px solid lightgray;
	border-radius: 10px;
}
</style>
<div id="demo-container" class="mx-auto">
	<!-- https://getbootstrap.com/docs/4.1/components/forms/#readonly-plain-text -->
	<form
		id="devFrm"
		name="devFrm"	
	  	method="post" 
	 	action="${pageContext.request.contextPath}/demo/updateDev.do">
		<div class="form-group row">
		  <label for="name" class="col-sm-2 col-form-label">이름</label>
		  <div class="col-sm-10">
		    <input type="text" class="form-control" id="name" name="name" value="${ dev.name }" required>
		  </div>
		</div>
		<div class="form-group row">
		  <label for="career" class="col-sm-2 col-form-label">개발경력</label>
		  <div class="col-sm-10">
		    <input type="number" class="form-control" id="career" name="career" value="${ dev.career }" required>
		  </div>
		</div>
		<div class="form-group row">
		  <label for="email" class="col-sm-2 col-form-label">이메일</label>
		  <div class="col-sm-10">
		    <input type="email" class="form-control" id="email" name="email" value="${ dev.email }" required>
		  </div>
		</div>
	  	<!-- https://getbootstrap.com/docs/4.1/components/forms/#inline -->
	    <div class="form-group row">
	    	<label class="col-sm-2 col-form-label">성별</label>
	    	<div class="col-sm-10">
			    <div class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="gender" 
				  		 id="gender0" value="M"
				  		 ${ dev.gender eq 'M' ? 'checked' : '' }>
				  <label class="form-check-label" for="gender0">남</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="gender" 
				  		 id="gender1" value="F"
				  		 ${ dev.gender eq 'F' ? 'checked' : '' }>
				  <label class="form-check-label" for="gender1">여</label>
				</div>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">개발언어</label>
			<div class="col-sm-10">
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" name="lang" 
				  		 id="Java" value="Java"
				  		 ${ devLangList.contains('Java') ? "checked" : "" }>
				  <label class="form-check-label" for="Java">Java</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" name="lang" 
				  		 id="C" value="C"
				  		 ${ devLangList.contains('C') ? "checked" : "" }>
				  <label class="form-check-label" for="C">C</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" name="lang" 
				  		 id="Javascript" value="Javascript"
				  		 ${ devLangList.contains('Javascript') ? "checked" : "" }>
				  <label class="form-check-label" for="Javascript">Javascript</label>
				</div>
			</div>
		</div>
		<!-- 중요 - 수정시 반드시 고유번호도 함께 넘겨주어야 함 -->
	  	<input type="hidden" name="no" value="${ dev.no }" />
	  	<button type="submit" class="list-group-item list-group-item-action">dev 수정</button>
	</form>
</div>

<script>

document.devFrm.onsubmit = (e) => {
 	const name = e.target.name;
	if(/^[가-힣]{2,}$/.test(name.value) == false){
		alert("이름을 작성하세요");
		return false;
	}
	
	//클라이언트단 유효성검사
	const langs = e.target.querySelectorAll("[name=lang]:checked");
	if(langs.length == 0){
		alert("하나이상의 개발언어를 선택하세요.")
		return false;
	}

}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
