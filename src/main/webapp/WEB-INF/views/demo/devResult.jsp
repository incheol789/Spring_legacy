<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="Dev 등록결과" name="title" />
</jsp:include>

<table class="table w-50 mx-auto" >
	<tr>
		<th scope="col">이름</th>
		<td>${dev.name}</td>
	</tr>
	<tr>
		<th scope="col">경력</th>
		<td>${dev.career}년</td>
	</tr>
	<tr>
		<th scope="col">이메일</th>
		<td>${dev.email}</td>
	</tr>
	<tr>
		<th scope="col">성별</th>
		<td>${empty dev.gender ? '' : (dev.gender eq 'M' ? '남' : '여')}</td><!-- 남/여 출력 -->
	</tr>
	<tr>
		<th scope="col">개발언어</th>
		<td>
			<c:forEach items="${dev.lang}" var="lang" varStatus="vs">
				${lang}${not vs.last ? ',' : ''}
			</c:forEach>
		</td><!-- 반복처리 Java, C, Python -->
	</tr>
	<tr>
		<th scope="col">등록일</th>
		<td>
			<fmt:parseDate value="${dev.createdAt}" pattern="yyyy-MM-dd'T'HH:mm" var="createdAt"/>
			<fmt:formatDate value="${createdAt}" pattern="yy-MM-dd HH:mm"/>			
		</td><!-- 년월일 시분 -->
	</tr>
</table>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
