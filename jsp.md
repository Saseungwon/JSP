
# 🚴‍♀️ JSP

## 📚 1일차
#### <%= %> (기본적인 출력)
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%="aaa"%>

</body>
</html>
```

#### 자바의 문법과 자바스크립트의 태그 사용 가능
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String param = request.getParameter("aa");
	if(param.equals("사승원")) {
%>
	<h1> 사승원	<h1>	
<%
	}else{
%>
	<h1> 원승사	 <h1>	
<%
	}
%>
</body>
</html>
```

####  1부터 10까지의 합
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1부터 10까지의 합</h1>
<ul>
	<li>
		<%
		String result="<ul>";
			int sum = 0;
			for(int i = 1; i <= 10; i++){
				sum = sum + i;
				%>
				<%=i + "=" + sum %>
								<%="<li>" %>
		<!-- 	out.println(i + "=" + sum);
			out.println("<li>"); -->
			<%
			}
		%>
	</li>
</ul>

</body>
</html>
```

####  Calendar
```js
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Calendar cal=Calendar.getInstance();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>

<!-- 'out.print'와 '=' 은 같음 -->
<span> <% out.print(cal.getTime()); %> </span> <br>
<span> <%= cal.getTime() %> </span> <br>
<span> <% out.print(sdf.format(cal.getTime())); %> </span> <br>
<span> <%= sdf.format(cal.getTime()) %> </span> <br>

</body>
</html>
```

####  trimDirectiveWhitespaces
```js
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=new Date() %>

</body>
</html>
```

#### 03Form
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="03Time.jsp" method="POST">
	<input type="text" value="" name="한글">
	<input type="text" value="" name="text">
	<input type="submit">
</form>
</body>
</html>
```

#### 03Time
```js
<%@page import="java.util.Enumeration"%>
<%@page import="com.sun.jmx.snmp.EnumRowStatus"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- pageEncoding은 jsp 소스파일 encoding 방법
	 contentType의 charset은 서버가 브라우저로 보낼 때 encoding방법
 -->
<%-- <%request.setCharacterEncoding("utf-8");%> --%>
<!-- 서버가 브라우저로부터 받은 데이터 디코딩방법 -->
<title>a3Time.jsp</title>
</head>
<body>
	현재 시간 : <%=new Date() %><br> <br>
	파라미터 : <%= request.getParameter("한글") %> <br> <br>
	파라미터2 : <%= request.getParameter("text") %> <br> <br>
	
	<%
		Enumeration paramEnum=request.getParameterNames();
		while(paramEnum.hasMoreElements()){
			String paramName=(String)(paramEnum.nextElement());
			out.print(paramName+ "<br>");
		}
	%>
</body>
</html>
```

#### 04Form
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>아래 항목에 답변해주세요</h3>
<form action="04result.jsp" method="post">
이 반에서 가장 착한 사람 : <input type="text" name="kind" value=""> <br>
이 반에서 가장 나쁜 사람 : <input type="text" name="bad" value=""> <br>
<button type="submit">제출</button>
</form>
<hr>
<%
	String app_path = request.getContextPath();
	out.println(app_path+"<br>");
%>
고양이1 <img alt="cat1" src="../resource/images/cat1.jpeg" width="50px" height="50px"> <br>
고양이2 <img alt="cat2" src="/study/resource/images/cat1.jpeg" width="50px" height="50px"> <br>
고양이3 <img alt="cat3" src="<%=request.getContextPath() %>/resource/images/cat1.jpeg" width="50px" height="50px"> <br>
고양이4 <img alt="cat4" src="http://localhost:8080/study/resource/images/cat1.jpeg" width="50px" height="50px">
</body>
</html>
```

#### 04Result
```js
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 인코딩 중요! -->
    <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/result.jsp</title>
</head>
<body>
<h1>클라이언트정보, 헤더정보, 파라미터정보</h1> <br><br><br>
<h3>클라이언트정보</h3>
IP 	 	: <%=request.getRemoteAddr() %>  <br>
웹 경로 : <%=request.getContextPath() %> <br>
URL	   : <%=request.getRequestURI() %> <br>
URI		: <%=request.getRequestURI() %> <br>

<h3>파라미터</h3>
kind : <%=request.getParameter("kind") %> <br>
bad : <%=request.getParameter("bad") %> <br>
<h3>모든 헤더보기</h3>
<%
	Enumeration headerEnum=request.getHeaderNames();
	while(headerEnum.hasMoreElements()){
		String headerName=(String)(headerEnum.nextElement());
		String headerValue=request.getHeader(headerName);
		out.print(headerName+" : " + headerValue);
		
	}
%>
</body>
</html>
```

#### 05Input
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="05ssum.jsp" method="post">
	숫자 1 <input type="text" name="num1" value=""> <br>
	숫자 2 <input type="text" name="num2" value=""> <br>
	<button type="submit">계산</button>
</form>
</body>
</html>
```

#### 05ssum
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
숫자1 : <%= request.getParameter("num1") %>
숫자2 : <%= request.getParameter("num2") %>

<%
	try{
		int pNum1 = Integer.parseInt(request.getParameter("num1"));
		int pNum2 = Integer.parseInt(request.getParameter("num2"));
		int sum = pNum1 + pNum2;
		out.print("<br> 합 : " +  sum);
	} catch(Exception e){
		out.print("숫자만 입력하세요");
		e.printStackTrace();
	}
%>
</body>
</html>
```

#### 06redirctPage
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getParameter("name") %>
</body>
</html>
```

#### 06redirect
```js
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String name="말 안 듣는 학생1";
	String encodedName= URLEncoder.encode(name, "utf-8");
	response.sendRedirect("/study/02/06redirctPage.jsp?name=" + encodedName);

%>

</body>
</html>
```

#### table
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=hojun()%>
<%!
	public String hojun(){
	return "착한 학생";
}
%>

</body>
</html>
```

####
```js

```

####
```js

```

