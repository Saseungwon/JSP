
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

## 📚 2일차

#### 00 input
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
<form action="00outVSExpression.jsp">
	<input type="text" value="" name="out">
	<input type="submit" value="아웃" name="out">
</form>

</body>
</html>
```

#### 00 out VS Expression
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
	String param=request.getParameter("out");
	if(param.equals("아웃")){
		out.print(param);
	}else{
		%><%=param %><%
	}
%>
<div>
	<%=param %>
</div>

</body>
</html>
```

#### 01 mime
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

plain
</body>
</html>
```

#### 02 Form
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
<form action="02Result.jsp" method="padt">
	한글 : <input type="text" value="" name="한글">
	english : <input type="text" value="" name="english">
	<input type="submit" value="한글이 잘 나옵니다">
</form>


</body>
</html>
```

#### 02 Result
```js
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
    <%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
한글 : <%=request.getParameter("한글") %>
english : <%=request.getParameter("english") %>
</body>
</html>
```

#### 03 declartion
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
	out.print(sum(10,54));
%>
<br>
<%!
	public int sum(int num1,int num2){
	return num1 + num2;
}

	public int sumOneToEnd(int num1){
		int sum=0;
		for(int i=0; i <= num1; i++){
			sum+=i;
		}
		return sum ;
	}
%>
<%=sumOneToEnd(100) %>

</body>
</html>
```

#### 03 declartion2
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
<%!
	private String field="fx 끝!";
	public String getField(){
	return field;
	}
	public void setField(String field){
		this.field=field;
	}
%>
<%
	out.print(getField());
	out.print("<br>");
	setField("자바 어려워");
	out.print(getField());
%>

</body>
</html>
```

#### 04 table
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

<table border="1">
<thead>
<%!
	StringBuffer sb = new StringBuffer();
	public String gugu(){
		for(int i=2; i<=9; i++){
			sb.append("<td>"+i+"단</td>");
		}
		sb.append("<thead>");
		sb.append("<tr>");
		for(int i=1; i<=9; i++){
			for(int j=2; j<=9; j++){
				sb.append("<td>"+j+"x"+i+"="+(j+i)+"</td>");
			}sb.append("</tr>");
		}
		return sb.toString();
	}
%>
<%=gugu() %>
</table>

</body>
</html>
```
## 📚 3일차
#### 00SameName.jsp
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
<form action="00sameNameResult.jsp">
	이름<input type="text" value="" name="name"> <br>
	나이<input type="text" value="" name="age"> <br>
	취미 <br>
	볼링<input type="checkbox" value="볼링" name="hobby"> <br>
	게임<input type="checkbox" value="게임" name="hobby"> <br>
	복수<input type="checkbox" value="복수" name="hobby"> <br>
	피아노<input type="checkbox" value="피아노" name="hobby"> <br>
	
	주소<input type="text" value="" name="address"> <br>
	<button type="submit">자기소개</button>
</form>

</body>
</html>
 ```

#### 00SameName2.jsp
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
<form action="00sameNameResult2.jsp">
	이름<input type="text" value="" name="name"> <br>
	나이<input type="text" value="" name="age"> <br>
	취미 <br>
	볼링<input type="checkbox" value="볼링" name="hobby">
	게임<input type="checkbox" value="게임" name="hobby">
	복수<input type="checkbox" value="복수" name="hobby">
	피아노<input type="checkbox" value="피아노" name="hobby"> <br>
	
	주소<input type="text" value="" name="address"> <br>
	<button type="submit">자기소개</button>
</form>

</body>
</html>
```

#### 00sameNameResult.jsp
```js
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : <%=request.getParameter("name") %>
나이 : <%=request.getParameter("age") %>
취미 :
<%
/* 	String[] hobbies=request.getParameterValues("hobby");
	if(hobbies !=null){
		for(String hobby:hobbies){
			out.print(hobby+ "    ");
		}
	} */
	Map parameters = request.getParameterMap();
	String[] hobbies=(String[])parameters.get("hobby");
	if(hobbies !=null){
		for(String hobby:hobbies){
			out.print(hobby+ "    ");
		}
	}
%>
주소 : <%=request.getParameter("address") %>
<hr>
파라미터들
<%
	String[] param1=(String[])parameters.get("age");
	if(param1 !=null){
		for(String param:param1){
			out.print(param+ "    ");
		}
	}
	%>

</body>
</html>
```

#### 00sameNameResult2.jsp
```js
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
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
	Enumeration paramNames=request.getParameterNames();
	while(paramNames.hasMoreElements()){
		String paramName=(String)paramNames.nextElement();
		out.print(paramName+" : ");
		
		Map parameters = request.getParameterMap();
		String[] param=(String[])parameters.get(paramName);
		if(param !=null){
			for(String p:param){
				out.print(p + "    ");
			}
		}
		out.print("<br>");
	}
%>

</body>
</html>
```

#### 03Buffer.jsp
```js
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page buffer="8kb" autoFlush="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 인코딩에 따라 같은 영어문자여도 차지하는 크기가 다르다 -->
		<!--
		버퍼사이즈
		남은버퍼
		자동플러시
		플러시
		클리어버퍼 -->
		out.clearBuffer();
		out.flush();
		out.clear();		
<ul>
	<li> 버퍼사이즈 : <%=out.getBufferSize() %>
	<li> 남은 버퍼 : <%=out.getRemaining() %>
	<li> 자동플러시여부 : <%=out.isAutoFlush() %>
</ul>

<%
	long startTime=System.currentTimeMillis();
	for(int i=0; i<1000; i++){
		out.print("일");
		out.print("이");
		out.print("삼");
		out.print("사");
		out.print("오");
		out.print("육");
 		//out.clearBuffer(); //내용을 지움
		//out.flush();//다 차지 않았어도 보냄(느려서 잘 안 씀)
		//out.clear();//내용을 지움 */
	}
	out.print("<hr>");
	long endTime=System.currentTimeMillis();
	out.print((endTime-startTime)+"초");
%>
</body>
</html>
```

#### 04pageContext.jsp
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본객체 pageContext</title>
</head>
<body>

<%
	if(pageContext.getRequest()==request){
		out.print("같다");
	}
	if(pageContext.getResponse()==response){
		
	}	
%>

</body>
</html>
```

#### 05 initparameter.jsp
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
	<%= application.getInitParameter("name")%>
	<%=application.getInitParameter("hobby")%>
</body>
</html>
```

#### 06readFileUsingApplication.jsp
```js
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStreamReader"%>
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
		String resourcePath = "/resource/message/06notice.txt";
	%>
	자원의 실제경로 :
	<br>
	<%=application.getRealPath(resourcePath) %>
	<hr>
	<br>
	<%=resourcePath %>의 내용
	<hr>
	<br>
	<%
		char[] buff = new char[128];
	int len = -1;
	try(InputStreamReader br = new InputStreamReader(
			application.getResourceAsStream(resourcePath), "UTF-8")){
		while((len = br.read(buff)) != -1){
			out.print(new String(buff,0,len));
		}
	}catch(IOException e){
		out.print(e.getMessage());
	}
	%>
	
	
	
</body>
</html>
```

#### 06notice.txt
```js
오늘 점심은 한솥
오늘 점심은 육개장
저녁은 맛있는 거
```

#### 07applicationReadAttribute.jsp
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

</body>
</html>
```

#### 07applicationSetAttribute.jsp
```js
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- application 모든 속성 읽기 -->
<%
	Enumeration<String> apEnum=application.getAttributeNames();
	while(apEnum.hasMoreElements()){
		String attributeName=apEnum.nextElement();
		Object attributeValue=application.getAttribute(attributeName);
		out.print(attributeName + " : " + attributeValue + "<br>");
	}
%>

</body>
</html>
```

#### web.xml
```js
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>study</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  <context-param>
  	<param-name>name</param-name>
  	<param-value>한창희</param-value>
  </context-param>
  
  <context-param>
  	<param-name>hobby</param-name>
  	<param-value>piano</param-value>
  </context-param>
  
<!--   <servlet>
  	<servlet-name>Mysum</servlet-name>
  	<servlet-class>study.Mysum</servlet-class>
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>Mysum</servlet-name>
  	<url-pattern>/04/*.do</url-pattern>
  </servlet-mapping> -->
</web-app>
```
