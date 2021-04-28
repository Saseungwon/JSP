<%@page import="com.study.free.service.FreeBoardServiceImpl"%>
<%@page import="com.study.free.service.IFreeBoardService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.study.free.vo.FreeBoardVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/inc/top.jsp"%>

<%
	IFreeBoardService freeBoardService=FreeBoardServiceImpl.getInstance(); //싱글턴 패턴이라 새로고침 할 때마다 new로 생성해주는 게 아니라 똑같은 객체로 생성하는  
	List<FreeBoardVO> freeList= freeBoardService.getBoardList();
	request.setAttribute("freeList", freeList);
%>

<div class="container">
	<div class="page-header">
		<h3>자유게시판 - <small>글 목록</small></h3>
	</div>
<div class="row">
    <div class="col-sm-2 col-sm-offset-10 text-right" style="margin-bottom: 5px;" >
        <a href="freeForm.jsp" class="btn btn-primary btn-sm"> 
        	<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
        	&nbsp;새글쓰기
		</a>
    </div>
</div>
	<table class="table table-striped table-bordered table-hover">
	<colgroup>
		<col width="10%" />
		<col width="15%" />
		<col />
		<col width="10%" />
		<col width="15%" />
		<col width="10%" />
	</colgroup>
	<thead>
		<tr>
			<th>글번호</th>
			<th>분류</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
	</thead>	
	<tbody>
	<c:forEach items="${freeList }" var="free">
			<tr class="text-center">
				<td>${free.boNo }</td>
				<td>${free.boCategory }</td>
				<td class="text-left">
					<a href="freeView.jsp?boNo=${free.boNo }">
						${free.boTitle }
					</a>
				</td>
				<td>${free.boWriter }</td>
				<td>${free.boRegDate }</td>
				<td>${free.boHit }</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</div><!-- container --> 
</body>
</html>

bo_no 은 SEQ_FREE_BOARD.nextval
bo_hit은 기본 0
bo_reg_date는 sysdate
bo_cate_gory는 'BC01
bo_ip는 127.0.0.1
bo_del_yn   'N'




