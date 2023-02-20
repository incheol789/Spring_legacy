<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="할일" name="title"/>
</jsp:include>

<style>
div#todo-container{width:60%; margin:0 auto;text-align:center;}
</style>
<div id="todo-container">
    <form action="${pageContext.request.contextPath}/todo/insertTodo.do" class="form-inline" method="post">
        <input type="text" class="form-control col-sm-10 ml-1" name="todo" placeholder="할일" required/>&nbsp;
        <button class="btn btn-outline-success" type="submit" >저장</button>
    </form>

    <br />
    <!-- 할일목록 -->
	<table class="table">
		<thead>
		    <tr>
		      <th>번호</th>
		      <th>완료여부</th>
		      <th>할일</th>
		      <th>생성일</th>
		      <th>완료일</th>
		      <th>삭제</th>
		    </tr>
		 </thead>
	     <tbody>
				<c:forEach items="${todoList}" var="todo">
					<tr>
						<td>${todo.no}</td>
						<td>
							<input type="checkbox" name="completeCheckbox" value="${todo.no}" ${not empty todo.completedAt ? 'checked' : '' }/>
						</td>
						<td>${todo.todo}</td>
						<td>
			   				<fmt:parseDate value="${todo.createdAt}" pattern="yyyy-MM-dd'T'HH:mm" var="createdAt"/>
							<fmt:formatDate value="${createdAt}" pattern="yy-MM-dd HH:mm"/>
		   				</td>
						<td>
							<fmt:parseDate value="${todo.completedAt}" pattern="yyyy-MM-dd'T'HH:mm" var="completedAt"/>
							<fmt:formatDate value="${completedAt}" pattern="yy/MM/dd HH:mm"/>
						</td>
						<td>
							<button class="btn btn-outline-danger" type="submit">삭제</button>
						</td>
					</tr>
				</c:forEach>
		  </tbody>
</table>

<form name="todoUpdateFrm" method="POST" action="${pageContext.request.contextPath}/todo/updateTodo.do">
	<input type="hidden" name="no"/>
	<input type="hidden" name="isCompleted"/>
</form>

<script>
document.querySelectorAll("[name=completeCheckbox]").forEach((checkbox) => {
	checkbox.addEventListener('change', (e) => {
		const {value : no, checked} = e.target;
		console.log(no, checked);
		
		const frm = document.todoUpdateFrm;
		frm.no.value = no;
		frm.isCompleted.value = checked;
		frm.submit();
	});
});
</script>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
