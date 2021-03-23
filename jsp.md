
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




## 📚 4일차

#### 00applicationReadAttribute
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
	Enumeration<String> apEnum = application.getAttributeNames();
	while(apEnum.hasMoreElements()) {
		String attributeName = apEnum.nextElement();
		Object attributeValue = application.getAttribute(attributeName);
		out.print("application 속성 : " + attributeName + " : " + attributeValue + "<br>");
	}
%>

</body>
</html>
```

#### 00applicationSetAttribute
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	application.setAttribute("황미선", 21);	// 	레퍼클래스를 감싸
 	application.setAttribute("윤현식", 23);
 	application.setAttribute("고창식", 25);
%>

</body>
</html>
```

#### 01requestAttribute
```js
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
		request.setAttribute("안석진", "칭구");
	List<Integer> arr1 = new ArrayList<Integer>();
	arr1.add(1);
	arr1.add(2);
	arr1.add(3);
	request.setAttribute("관저", arr1);
	%>
	<br>
	<br>
	<%
		List<Integer> arr = (List<Integer>) (request.getAttribute("관저"));
	for (int i = 0; i < arr.size(); i++) {
		out.print(arr.get(i) + "<br>");
	}
	%>
</body>
</html>
```

#### 01requestAttributeEX
```js
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 기본 객체 사용하여 자원 읽기</title>
</head>
<body>
	리스트 1, 2 교집합 차집합 합집합 리스트 만들고 출력해보기

<%
	List<Integer> List1 = new ArrayList<Integer>();
	List<Integer> List2 = new ArrayList<Integer>();
	List1.add(1);
	List1.add(3);
	List1.add(4);
	List1.add(5);
	List1.add(8);
	List2.add(1);
	List2.add(8);
	List2.add(5);
	List2.add(7);
	List2.add(10);
	
	// kyo  1,8,5   cha    list1-list2   3,4      hap   1,3,4,5,7,8,10
	List<Integer> kyo = new ArrayList<Integer>();
	List<Integer> cha = new ArrayList<Integer>();
	List<Integer> hap = new ArrayList<Integer>();
	
	kyo.addAll(List1); //List1 값 다 더하기
	kyo.retainAll(List2); //리스트2에 있는 값 빼기
	
	cha.addAll(List1); // kyo List1 원소가 같음
	cha.removeAll(List2); //리스트2에 있는 값 빼기
	
	hap.addAll(cha);
	hap.addAll(List2);
	hap.sort(Comparator.naturalOrder());
	/* hap.sort(null); */
	Collections.sort(hap);
	
	//kyo     cha     hap을 setAttribute하고
	//retain addAll remove
	
	request.setAttribute("kyo", kyo);
	request.setAttribute("cha", cha);
	request.setAttribute("hap", hap);
%>

kyo	<%=request.getAttribute("kyo")%><br>
<!-- List가 문자열로 출력됨 -->
cha	<%=request.getAttribute("cha")%><br>
hap	<%=request.getAttribute("hap")%><br>
</body>
</html>
```

#### 02errorMain
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 에러 발생시 보여줄 페이지 지정해줌 -->
    
 <%@ page errorPage="02errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러발생 시켜보기</title>
</head>
<body>
<%-- <%
String a=null;
a.substring(0);
%> --%>
 <%=request.getParameter("aa").substring(0)%>

</body>
</html>
```

#### 02errorPage
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 에러 발생시 보여줄 페이지 지정해줌 -->
    
 <%@ page errorPage="02errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러발생 시켜보기</title>
</head>
<body>
<%-- <%
String a=null;
a.substring(0);
%> --%>
 <%=request.getParameter("aa").substring(0)%>

</body>
</html>
```

#### 02main
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

100 : 해당 요청을 진행중 <br>
200 : 요청을 정상적으로 처리 했음 <br>
300 : 요청의 정보가 변경되었음 <br>
400 : 잘못된 요청(404, 401, 403) <br>
500 : 내부 서버 오류(서버 프로그램의 오류) <br><br>

에러페이지 우선 순위 <br>
1. 디렉티브 페이지 errorpage   <%-- <%@ page errorPage="02mypage.jsp" %> --%><br>
2. exception-type <br>
3. 응답 상태코드 <br>

<form action="02mypage.jsp">
나이 : <input type="number" name="age" min="10" max="99"><br>
<button type="submit">제출</button>
</form>
</body>
</html>
```

#### 02mypage
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%-- <%@ page isErrorPage="true" %>    --%>
     <%-- <%@page errorPage="02errorPage.jsp" %> --%>
     
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02/mypage.jsp</title>
<h1> 주말이다
	성심당 가야지
</h1>

<%out.flush(); %>

<%
	int age = Integer.parseInt(request.getParameter("age"));
if(age > 50) {
	throw new IndexOutOfBoundsException();
}else if(age%2==0) { //짝수면 에러
	throw new ClassCastException();
}
%>
<%=age %>

</head>
<body>
</body>
</html>
```

#### 03Main
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

03main 	전
<%@ include file="03sub.jsp" %>
<jsp:include page="03sub.jsp" /> <!-- 반복되는 부분을 sub파일로 만들고 main에 삽입 -->
03main		후

</body>
</html>
```

#### 04sub
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
<h1>sub에 만들어진 내용</h1>
</body>
</html>
```

#### 04jspPram
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>sub전</p>
<!-- url에 ? name 한창희 넣어보자  -->
<jsp:include page="04sub.jsp">
	<jsp:param value="한창희" name="name"/>
	<jsp:param value="30" name="age"/>
</jsp:include>		<!-- jsp인클루드 사이에 주석 못 들어간다. -->

<p>sub 후</p>
</body>
</html>
```

#### 04sub
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

이름 : <%=request.getParameter("name") %>
나이 : <%=request.getParameter("age") %>
태정 : <%=request.getParameter("taejeong") %>

</body>
</html>
```

#### 05input
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
<div class="container">
	<div id="content">
		<h3>성심당 좋아요</h3>
		<form action="05other.jsp">
			나이 : <input type="number" name="age" min="10" max="99"> <br>
			<button type="submit">제출</button>
		</form>
	</div>
</div>

</body>
</html>
```

#### 05other
```js
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%
    	request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<%
	String aa = request.getParameter("age");
	int age = Integer.parseInt(aa);
	List list = new ArrayList();
	String res = "애기";
	if(age < 20){
		res = "청소년";
		list.add("로제");
		list.add("다미");
	}else if(age < 30){
		res = "청년";
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
	}else{
		res = "노인네";
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
	}
	request.setAttribute("hate", list);
%>
<p>jsp include 실행전</p>
<jsp:include page="05otherinclude.jsp">
	<jsp:param value="<%=res %>" name="res"/>
	<jsp:param value="<%=age %>" name="age"/>
</jsp:include>

<p> jsp include 실행 후 </p>
저녁메뉴 : <%=request.getAttribute("dinnerMenu") %>

</div>

</body>
</html>
```

#### 05otherinclude
```js
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<%
		List<String> hate=(List<String>)(request.getAttribute("hate"));
%>

res : <%= request.getParameter("res") %> <br>
age : <%= request.getParameter("age") %> <br>
hateList : <% for(String hateElement : hate){
						out.println(hateElement);
	}
	%>
	
	<%
		request.setAttribute("dinnerMenu", "청국장");
	%>

</div>

</body>
</html>
```

#### errorBound
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<%--
	Daum -> Jiwon
	다음 -> 지원
	Kakao -> Jiwon
 --%>
<!DOCTYPE html>
<html lang="ko" class="os_mac chrome pc version_56_0_2924_87">
<head>
	<meta charset="utf-8">
		<title>IndexOutOfBoundsException</title>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">	
	<style type="text/css">
		/* reset */
		body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,code,form,fieldset,legend,textarea,p,blockquote,th,td,input,select,button{margin:0;padding:0}
		fieldset,img{border:0 none}
		dl,ul,ol,menu,li{list-style:none}
		blockquote, q{quotes: none}
		blockquote:before, blockquote:after,q:before, q:after{content:'';content:none}
		input,select,textarea,button{vertical-align:middle}
		input::-ms-clear{display:none}
		button{border:0 none;background-color:transparent;cursor:pointer}
		body{background:#fbfbfc}
		body,th,td,input,select,textarea,button{font-size:12px;line-height:1.5;font-family:AppleSDGothicNeo-Regular,'Malgun Gothic','맑은 고딕',dotum,'돋움',sans-serif;color:#222;letter-spacing:-0.5px}
		a{color:#333;text-decoration:none}
		a:active, a:hover{text-decoration:underline}
		a:active{background-color:transparent}
		address,caption,cite,code,dfn,em,var{font-style:normal;font-weight:normal}
		
		/* global */
		.ir_pm{display:block;overflow:hidden;font-size:0;line-height:0;text-indent:-9999px}
		.ir_wa{display:block;overflow:hidden;position:relative;z-index:-1;width:100%;height:100%}
		.screen_out{overflow:hidden;position:absolute;width:0;height:0;line-height:0;text-indent:-9999px}
		.hide{display:none}
		
		/* error */
		.img_error{overflow:hidden;background:url(http://t1.daumcdn.net/daumtop_deco/error/pc/img_error.png) no-repeat 0 0;font-size:0;line-height:0;vertical-align:top;text-indent:-9999px}
		.page_error{width:600px;margin:103px auto 0}
		.page_error .head_error{overflow:hidden}
		.page_error .head_error h1{float:left}
		.page_error .link_daum{display:block;width:69px;height:28px;background:url(http://t1.daumcdn.net/daumtop_deco/error/pc/img_error.png) no-repeat 0 0}
		.page_error .cont_error{position:relative;margin-top:19px;min-height:180px;padding:70px 0 200px;border-top:2px solid #222}
		.page_error .tit_error{margin-bottom:33px;font-weight:normal;font-size:36px;line-height:45px;letter-spacing:-3.5px}
		.os_mac .page_error .tit_error{letter-spacing:-0.5px}
		.page_error .emph_txt{color:#e30000}
		.page_error .desc_error{margin-top:9px;font-size:14px;line-height:22px}
		.page_error .info_link{position:absolute;right:0;top:-45px;overflow:hidden}
		.os_mac .page_error .info_link{top:-38px}
		.page_error .info_link .link_error{float:left;margin-left:12px;color:#555}
		.page_error .wrap_form{position:absolute;left:50%;bottom:70px;width:420px;margin-left:-210px}
		.page_error .wrap_inp{position:relative;height:24px;padding:10px 0;border:1px solid #bfbfbf;background:#fff}
		.page_error .lab_search{position:absolute;left:14px;top:11px;font-size:14px;color:#888}
		.os_mac .page_error .lab_search{top:13px}
		.page_error .inp_search{display:block;width:348px;height:24px;padding-left:14px;font-size:14px;border:0 none;background:none;outline:0}
		.page_error .btn_search{position:absolute;right:0;top:0;width:50px;height:44px;background-position:0 -30px}
		.page_error .link_cs{color:#118eff;text-decoration:underline}
		.page_error .foot_error{padding-top:15px;border-top:1px solid #222}
		.page_error .info_copyright{font-size:11px;color:#888}
		.page_error .link_kakao{color:#888}
		
		/*** 레티나 대응 ***/
		@media
		only screen and (-webkit-min-device-pixel-ratio:1.5),
		only screen and (min-device-pixel-ratio:1.5),
		only screen and (min-resolution:144dpi),
		only screen and (min-resolution:1.5dppx){
		.img_error{background-image:url(http://t1.daumcdn.net/daumtop_deco/error/pc/rtn/img_error.png);background-size:70px 80px;-webkit-background-size:70px 80px}
		.page_error .link_daum{background-image:url(http://t1.daumcdn.net/daumtop_deco/error/pc/rtn/img_error.png);background-size:70px 80px;-webkit-background-size:70px 80px}
		}
	</style>
</head>
<body>
<div id="kakaoWrap" class="page_error">
	<div id="kakaoHead" role="banner" class="head_error">
		<h1>
			<a href="http://www.daum.net/" class="link_daum"><span class="ir_wa">Jiwon</span></a>
		</h1>
	</div>
	<hr class="hide">
	<div id="kakaoContent" class="cont_error" role="main">
				<h2 class="tit_error">입력값에 <span class="emph_txt">문제가 있습니다.</span></h2>
		<p class="desc_error">
			IndexOutOfBoundsException<br>
			방문 원하시는 페이지의 주소가 잘못 입력되었거나,<br>
			변경 혹은 삭제되어 요청하신 페이지를 찾을 수가 없습니다.
		</p>
		<p class="desc_error">
			입력하신 페이지의 주소가 정확한지 다시 한번 확인해 주시기 바랍니다.
		</p>
		<p class="desc_error">
			관련해 <a href="http://cs.daum.net/" class="link_cs">고객센터</a>로 문의해 주시면 친절하게 안내해 드리겠습니다.
		</p>
				<h3 class="screen_out">검색</h3>
		<div class="wrap_form">
			<form action="http://search.daum.net/search">
				<fieldset>
					<legend class="screen_out">검색어 입력폼</legend>
					<div class="wrap_inp">
						<label for="inpSearch" id="searchLabel" class="lab_search">통합검색</label>
						<input type="text" id="inpSearch" class="inp_search" name="q" autocomplete="off" spellcheck="false" />
						<button type="submit" class="img_error btn_search">검색</button>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="info_link">
			<a href="http://www.daum.net/" class="link_error">메인화면</a>
			<a href="http://cs.daum.net/" class="link_error ">고객센터</a>
		</div>
	</div>
	<hr class="hide">
	<div id="kakaoFoot" class="foot_error" role="contentinfo">
		<small class="info_copyright">Copyright &copy; <a href="http://www.kakaocorp.com/" target="_blank" class="link_kakao">Jiwon Corp.</a> All rights reserved.</small>
	</div>
</div>
<script type="text/javascript">
//<![CDATA[
function init() {
	var inpSearch = document.getElementById('inpSearch');
	var searchLabel = document.getElementById('searchLabel');
	if(inpSearch) {
		inpSearch.onfocus = function() {
			searchLabel.className = 'screen_out';
		}
		inpSearch.onblur = function() {
			if(inpSearch.value.length==0){
				searchLabel.className = 'lab_search';
			}
		}
	}
}
init();
//]]>
</script>
</body>
</html>
```

#### error404
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>            <!-- 이거 지우고 web.xml에 설정하는거 나중에  -->    
<%--
	Daum -> Jiwon
	다음 -> 지원
	Kakao -> Jiwon
 --%>
<!DOCTYPE html>
<html lang="ko" class="os_mac chrome pc version_56_0_2924_87">
<head>
	<meta charset="utf-8">
		<title>error 404</title>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">	
	<style type="text/css">
		/* reset */
		body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,code,form,fieldset,legend,textarea,p,blockquote,th,td,input,select,button{margin:0;padding:0}
		fieldset,img{border:0 none}
		dl,ul,ol,menu,li{list-style:none}
		blockquote, q{quotes: none}
		blockquote:before, blockquote:after,q:before, q:after{content:'';content:none}
		input,select,textarea,button{vertical-align:middle}
		input::-ms-clear{display:none}
		button{border:0 none;background-color:transparent;cursor:pointer}
		body{background:#fbfbfc}
		body,th,td,input,select,textarea,button{font-size:12px;line-height:1.5;font-family:AppleSDGothicNeo-Regular,'Malgun Gothic','맑은 고딕',dotum,'돋움',sans-serif;color:#222;letter-spacing:-0.5px}
		a{color:#333;text-decoration:none}
		a:active, a:hover{text-decoration:underline}
		a:active{background-color:transparent}
		address,caption,cite,code,dfn,em,var{font-style:normal;font-weight:normal}
		
		/* global */
		.ir_pm{display:block;overflow:hidden;font-size:0;line-height:0;text-indent:-9999px}
		.ir_wa{display:block;overflow:hidden;position:relative;z-index:-1;width:100%;height:100%}
		.screen_out{overflow:hidden;position:absolute;width:0;height:0;line-height:0;text-indent:-9999px}
		.hide{display:none}
		
		/* error */
		.img_error{overflow:hidden;background:url(http://t1.daumcdn.net/daumtop_deco/error/pc/img_error.png) no-repeat 0 0;font-size:0;line-height:0;vertical-align:top;text-indent:-9999px}
		.page_error{width:600px;margin:103px auto 0}
		.page_error .head_error{overflow:hidden}
		.page_error .head_error h1{float:left}
		.page_error .link_daum{display:block;width:69px;height:28px;background:url(http://t1.daumcdn.net/daumtop_deco/error/pc/img_error.png) no-repeat 0 0}
		.page_error .cont_error{position:relative;margin-top:19px;min-height:180px;padding:70px 0 200px;border-top:2px solid #222}
		.page_error .tit_error{margin-bottom:33px;font-weight:normal;font-size:36px;line-height:45px;letter-spacing:-3.5px}
		.os_mac .page_error .tit_error{letter-spacing:-0.5px}
		.page_error .emph_txt{color:#e30000}
		.page_error .desc_error{margin-top:9px;font-size:14px;line-height:22px}
		.page_error .info_link{position:absolute;right:0;top:-45px;overflow:hidden}
		.os_mac .page_error .info_link{top:-38px}
		.page_error .info_link .link_error{float:left;margin-left:12px;color:#555}
		.page_error .wrap_form{position:absolute;left:50%;bottom:70px;width:420px;margin-left:-210px}
		.page_error .wrap_inp{position:relative;height:24px;padding:10px 0;border:1px solid #bfbfbf;background:#fff}
		.page_error .lab_search{position:absolute;left:14px;top:11px;font-size:14px;color:#888}
		.os_mac .page_error .lab_search{top:13px}
		.page_error .inp_search{display:block;width:348px;height:24px;padding-left:14px;font-size:14px;border:0 none;background:none;outline:0}
		.page_error .btn_search{position:absolute;right:0;top:0;width:50px;height:44px;background-position:0 -30px}
		.page_error .link_cs{color:#118eff;text-decoration:underline}
		.page_error .foot_error{padding-top:15px;border-top:1px solid #222}
		.page_error .info_copyright{font-size:11px;color:#888}
		.page_error .link_kakao{color:#888}
		
		/*** 레티나 대응 ***/
		@media
		only screen and (-webkit-min-device-pixel-ratio:1.5),
		only screen and (min-device-pixel-ratio:1.5),
		only screen and (min-resolution:144dpi),
		only screen and (min-resolution:1.5dppx){
		.img_error{background-image:url(http://t1.daumcdn.net/daumtop_deco/error/pc/rtn/img_error.png);background-size:70px 80px;-webkit-background-size:70px 80px}
		.page_error .link_daum{background-image:url(http://t1.daumcdn.net/daumtop_deco/error/pc/rtn/img_error.png);background-size:70px 80px;-webkit-background-size:70px 80px}
		}
	</style>
</head>
<body>
<div id="kakaoWrap" class="page_error">
	<div id="kakaoHead" role="banner" class="head_error">
		<h1>
			<a href="http://www.daum.net/" class="link_daum"><span class="ir_wa">Jiwon</span></a>
		</h1>
	</div>
	<hr class="hide">
	<div id="kakaoContent" class="cont_error" role="main">
				<h2 class="tit_error">원하시는 페이지를 <span class="emph_txt">찾을 수가 없습니다.404</span></h2>
		<p class="desc_error">
			방문 원하시는 페이지의 주소가 잘못 입력되었거나,<br>
			변경 혹은 삭제되어 요청하신 페이지를 찾을 수가 없습니다.
		</p>
		<p class="desc_error">
			입력하신 페이지의 주소가 정확한지 다시 한번 확인해 주시기 바랍니다.
		</p>
		<p class="desc_error">
			관련해 <a href="http://cs.daum.net/" class="link_cs">고객센터</a>로 문의해 주시면 친절하게 안내해 드리겠습니다.
		</p>
				<h3 class="screen_out">검색</h3>
		<div class="wrap_form">
			<form action="http://search.daum.net/search">
				<fieldset>
					<legend class="screen_out">검색어 입력폼</legend>
					<div class="wrap_inp">
						<label for="inpSearch" id="searchLabel" class="lab_search">통합검색</label>
						<input type="text" id="inpSearch" class="inp_search" name="q" autocomplete="off" spellcheck="false" />
						<button type="submit" class="img_error btn_search">검색</button>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="info_link">
			<a href="http://www.daum.net/" class="link_error">메인화면</a>
			<a href="http://cs.daum.net/" class="link_error ">고객센터</a>
		</div>
	</div>
	<hr class="hide">
	<div id="kakaoFoot" class="foot_error" role="contentinfo">
		<small class="info_copyright">Copyright &copy; <a href="http://www.kakaocorp.com/" target="_blank" class="link_kakao">Jiwon Corp.</a> All rights reserved.</small>
	</div>
</div>
<script type="text/javascript">
//<![CDATA[
function init() {
	var inpSearch = document.getElementById('inpSearch');
	var searchLabel = document.getElementById('searchLabel');
	if(inpSearch) {
		inpSearch.onfocus = function() {
			searchLabel.className = 'screen_out';
		}
		inpSearch.onblur = function() {
			if(inpSearch.value.length==0){
				searchLabel.className = 'lab_search';
			}
		}
	}
}
init();
//]]>
</script>
</body>
</html>
```

#### error500
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="ko" class="os_mac chrome pc version_56_0_2924_87">
<head>
	<meta charset="utf-8">
		<title>error 500</title>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">	
	<style type="text/css">
		/* reset */
		body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,code,form,fieldset,legend,textarea,p,blockquote,th,td,input,select,button{margin:0;padding:0}
		fieldset,img{border:0 none}
		dl,ul,ol,menu,li{list-style:none}
		blockquote, q{quotes: none}
		blockquote:before, blockquote:after,q:before, q:after{content:'';content:none}
		input,select,textarea,button{vertical-align:middle}
		input::-ms-clear{display:none}
		button{border:0 none;background-color:transparent;cursor:pointer}
		body{background:#fbfbfc}
		body,th,td,input,select,textarea,button{font-size:12px;line-height:1.5;font-family:AppleSDGothicNeo-Regular,'Malgun Gothic','맑은 고딕',dotum,'돋움',sans-serif;color:#222;letter-spacing:-0.5px}
		a{color:#333;text-decoration:none}
		a:active, a:hover{text-decoration:underline}
		a:active{background-color:transparent}
		address,caption,cite,code,dfn,em,var{font-style:normal;font-weight:normal}
		
		/* global */
		.ir_pm{display:block;overflow:hidden;font-size:0;line-height:0;text-indent:-9999px}
		.ir_wa{display:block;overflow:hidden;position:relative;z-index:-1;width:100%;height:100%}
		.screen_out{overflow:hidden;position:absolute;width:0;height:0;line-height:0;text-indent:-9999px}
		.hide{display:none}
		
		/* error */
		.img_error{overflow:hidden;background:url(http://t1.daumcdn.net/daumtop_deco/error/pc/img_error.png) no-repeat 0 0;font-size:0;line-height:0;vertical-align:top;text-indent:-9999px}
		.page_error{width:600px;margin:103px auto 0}
		.page_error .head_error{overflow:hidden}
		.page_error .head_error h1{float:left}
		.page_error .link_daum{display:block;width:69px;height:28px;background:url(http://t1.daumcdn.net/daumtop_deco/error/pc/img_error.png) no-repeat 0 0}
		.page_error .cont_error{position:relative;margin-top:19px;min-height:180px;padding:70px 0 200px;border-top:2px solid #222}
		.page_error .tit_error{margin-bottom:33px;font-weight:normal;font-size:36px;line-height:45px;letter-spacing:-3.5px}
		.os_mac .page_error .tit_error{letter-spacing:-0.5px}
		.page_error .emph_txt{color:#e30000}
		.page_error .desc_error{margin-top:9px;font-size:14px;line-height:22px}
		.page_error .info_link{position:absolute;right:0;top:-45px;overflow:hidden}
		.os_mac .page_error .info_link{top:-38px}
		.page_error .info_link .link_error{float:left;margin-left:12px;color:#555}
		.page_error .wrap_form{position:absolute;left:50%;bottom:70px;width:420px;margin-left:-210px}
		.page_error .wrap_inp{position:relative;height:24px;padding:10px 0;border:1px solid #bfbfbf;background:#fff}
		.page_error .lab_search{position:absolute;left:14px;top:11px;font-size:14px;color:#888}
		.os_mac .page_error .lab_search{top:13px}
		.page_error .inp_search{display:block;width:348px;height:24px;padding-left:14px;font-size:14px;border:0 none;background:none;outline:0}
		.page_error .btn_search{position:absolute;right:0;top:0;width:50px;height:44px;background-position:0 -30px}
		.page_error .link_cs{color:#118eff;text-decoration:underline}
		.page_error .foot_error{padding-top:15px;border-top:1px solid #222}
		.page_error .info_copyright{font-size:11px;color:#888}
		.page_error .link_kakao{color:#888}
		
		/*** 레티나 대응 ***/
		@media
		only screen and (-webkit-min-device-pixel-ratio:1.5),
		only screen and (min-device-pixel-ratio:1.5),
		only screen and (min-resolution:144dpi),
		only screen and (min-resolution:1.5dppx){
		.img_error{background-image:url(http://t1.daumcdn.net/daumtop_deco/error/pc/rtn/img_error.png);background-size:70px 80px;-webkit-background-size:70px 80px}
		.page_error .link_daum{background-image:url(http://t1.daumcdn.net/daumtop_deco/error/pc/rtn/img_error.png);background-size:70px 80px;-webkit-background-size:70px 80px}
		}
	</style>
</head>
<body>
<div id="kakaoWrap" class="page_error">
	<div id="kakaoHead" role="banner" class="head_error">
		<h1>
			<a href="http://www.daum.net/" class="link_daum"><span class="ir_wa">Jiwon</span></a>
		</h1>
	</div>
	<hr class="hide">
	<div id="kakaoContent" class="cont_error" role="main">
				<h2 class="tit_error">내부 서버 오류 <span class="emph_txt">가 있습니다.</span></h2>
		<p class="desc_error">
			ClassCastException<br>
			방문 원하시는 페이지의 주소가 잘못 입력되었거나,<br>
			변경 혹은 삭제되어 요청하신 페이지를 찾을 수가 없습니다.<br>
			메시지 : <%=exception.getMessage() %>
			예외타입 : <%= exception.getClass().getName() %>
		</p>
		<p class="desc_error">
			입력하신 페이지의 주소가 정확한지 다시 한번 확인해 주시기 바랍니다.
		</p>
		<p class="desc_error">
			관련해 <a href="http://cs.daum.net/" class="link_cs">고객센터</a>로 문의해 주시면 친절하게 안내해 드리겠습니다.
		</p>
				<h3 class="screen_out">검색</h3>
		<div class="wrap_form">
			<form action="http://search.daum.net/search">
				<fieldset>
					<legend class="screen_out">검색어 입력폼</legend>
					<div class="wrap_inp">
						<label for="inpSearch" id="searchLabel" class="lab_search">통합검색</label>
						<input type="text" id="inpSearch" class="inp_search" name="q" autocomplete="off" spellcheck="false" />
						<button type="submit" class="img_error btn_search">검색</button>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="info_link">
			<a href="http://www.daum.net/" class="link_error">메인화면</a>
			<a href="http://cs.daum.net/" class="link_error ">고객센터</a>
		</div>
	</div>
	<hr class="hide">
	<div id="kakaoFoot" class="foot_error" role="contentinfo">
		<small class="info_copyright">Copyright &copy; <a href="http://www.kakaocorp.com/" target="_blank" class="link_kakao">Jiwon Corp.</a> All rights reserved.</small>
	</div>
</div>
<script type="text/javascript">
//<![CDATA[
function init() {
	var inpSearch = document.getElementById('inpSearch');
	var searchLabel = document.getElementById('searchLabel');
	if(inpSearch) {
		inpSearch.onfocus = function() {
			searchLabel.className = 'screen_out';
		}
		inpSearch.onblur = function() {
			if(inpSearch.value.length==0){
				searchLabel.className = 'lab_search';
			}
		}
	}
}
init();
//]]>
</script>
</body>
</html>
```

#### errorBound
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<%--
	Daum -> Jiwon
	다음 -> 지원
	Kakao -> Jiwon
 --%>
<!DOCTYPE html>
<html lang="ko" class="os_mac chrome pc version_56_0_2924_87">
<head>
	<meta charset="utf-8">
		<title>IndexOutOfBoundsException</title>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">	
	<style type="text/css">
		/* reset */
		body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,code,form,fieldset,legend,textarea,p,blockquote,th,td,input,select,button{margin:0;padding:0}
		fieldset,img{border:0 none}
		dl,ul,ol,menu,li{list-style:none}
		blockquote, q{quotes: none}
		blockquote:before, blockquote:after,q:before, q:after{content:'';content:none}
		input,select,textarea,button{vertical-align:middle}
		input::-ms-clear{display:none}
		button{border:0 none;background-color:transparent;cursor:pointer}
		body{background:#fbfbfc}
		body,th,td,input,select,textarea,button{font-size:12px;line-height:1.5;font-family:AppleSDGothicNeo-Regular,'Malgun Gothic','맑은 고딕',dotum,'돋움',sans-serif;color:#222;letter-spacing:-0.5px}
		a{color:#333;text-decoration:none}
		a:active, a:hover{text-decoration:underline}
		a:active{background-color:transparent}
		address,caption,cite,code,dfn,em,var{font-style:normal;font-weight:normal}
		
		/* global */
		.ir_pm{display:block;overflow:hidden;font-size:0;line-height:0;text-indent:-9999px}
		.ir_wa{display:block;overflow:hidden;position:relative;z-index:-1;width:100%;height:100%}
		.screen_out{overflow:hidden;position:absolute;width:0;height:0;line-height:0;text-indent:-9999px}
		.hide{display:none}
		
		/* error */
		.img_error{overflow:hidden;background:url(http://t1.daumcdn.net/daumtop_deco/error/pc/img_error.png) no-repeat 0 0;font-size:0;line-height:0;vertical-align:top;text-indent:-9999px}
		.page_error{width:600px;margin:103px auto 0}
		.page_error .head_error{overflow:hidden}
		.page_error .head_error h1{float:left}
		.page_error .link_daum{display:block;width:69px;height:28px;background:url(http://t1.daumcdn.net/daumtop_deco/error/pc/img_error.png) no-repeat 0 0}
		.page_error .cont_error{position:relative;margin-top:19px;min-height:180px;padding:70px 0 200px;border-top:2px solid #222}
		.page_error .tit_error{margin-bottom:33px;font-weight:normal;font-size:36px;line-height:45px;letter-spacing:-3.5px}
		.os_mac .page_error .tit_error{letter-spacing:-0.5px}
		.page_error .emph_txt{color:#e30000}
		.page_error .desc_error{margin-top:9px;font-size:14px;line-height:22px}
		.page_error .info_link{position:absolute;right:0;top:-45px;overflow:hidden}
		.os_mac .page_error .info_link{top:-38px}
		.page_error .info_link .link_error{float:left;margin-left:12px;color:#555}
		.page_error .wrap_form{position:absolute;left:50%;bottom:70px;width:420px;margin-left:-210px}
		.page_error .wrap_inp{position:relative;height:24px;padding:10px 0;border:1px solid #bfbfbf;background:#fff}
		.page_error .lab_search{position:absolute;left:14px;top:11px;font-size:14px;color:#888}
		.os_mac .page_error .lab_search{top:13px}
		.page_error .inp_search{display:block;width:348px;height:24px;padding-left:14px;font-size:14px;border:0 none;background:none;outline:0}
		.page_error .btn_search{position:absolute;right:0;top:0;width:50px;height:44px;background-position:0 -30px}
		.page_error .link_cs{color:#118eff;text-decoration:underline}
		.page_error .foot_error{padding-top:15px;border-top:1px solid #222}
		.page_error .info_copyright{font-size:11px;color:#888}
		.page_error .link_kakao{color:#888}
		
		/*** 레티나 대응 ***/
		@media
		only screen and (-webkit-min-device-pixel-ratio:1.5),
		only screen and (min-device-pixel-ratio:1.5),
		only screen and (min-resolution:144dpi),
		only screen and (min-resolution:1.5dppx){
		.img_error{background-image:url(http://t1.daumcdn.net/daumtop_deco/error/pc/rtn/img_error.png);background-size:70px 80px;-webkit-background-size:70px 80px}
		.page_error .link_daum{background-image:url(http://t1.daumcdn.net/daumtop_deco/error/pc/rtn/img_error.png);background-size:70px 80px;-webkit-background-size:70px 80px}
		}
	</style>
</head>
<body>
<div id="kakaoWrap" class="page_error">
	<div id="kakaoHead" role="banner" class="head_error">
		<h1>
			<a href="http://www.daum.net/" class="link_daum"><span class="ir_wa">Jiwon</span></a>
		</h1>
	</div>
	<hr class="hide">
	<div id="kakaoContent" class="cont_error" role="main">
				<h2 class="tit_error">입력값에 <span class="emph_txt">문제가 있습니다.</span></h2>
		<p class="desc_error">
			IndexOutOfBoundsException<br>
			방문 원하시는 페이지의 주소가 잘못 입력되었거나,<br>
			변경 혹은 삭제되어 요청하신 페이지를 찾을 수가 없습니다.
		</p>
		<p class="desc_error">
			입력하신 페이지의 주소가 정확한지 다시 한번 확인해 주시기 바랍니다.
		</p>
		<p class="desc_error">
			관련해 <a href="http://cs.daum.net/" class="link_cs">고객센터</a>로 문의해 주시면 친절하게 안내해 드리겠습니다.
		</p>
				<h3 class="screen_out">검색</h3>
		<div class="wrap_form">
			<form action="http://search.daum.net/search">
				<fieldset>
					<legend class="screen_out">검색어 입력폼</legend>
					<div class="wrap_inp">
						<label for="inpSearch" id="searchLabel" class="lab_search">통합검색</label>
						<input type="text" id="inpSearch" class="inp_search" name="q" autocomplete="off" spellcheck="false" />
						<button type="submit" class="img_error btn_search">검색</button>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="info_link">
			<a href="http://www.daum.net/" class="link_error">메인화면</a>
			<a href="http://cs.daum.net/" class="link_error ">고객센터</a>
		</div>
	</div>
	<hr class="hide">
	<div id="kakaoFoot" class="foot_error" role="contentinfo">
		<small class="info_copyright">Copyright &copy; <a href="http://www.kakaocorp.com/" target="_blank" class="link_kakao">Jiwon Corp.</a> All rights reserved.</small>
	</div>
</div>
<script type="text/javascript">
//<![CDATA[
function init() {
	var inpSearch = document.getElementById('inpSearch');
	var searchLabel = document.getElementById('searchLabel');
	if(inpSearch) {
		inpSearch.onfocus = function() {
			searchLabel.className = 'screen_out';
		}
		inpSearch.onblur = function() {
			if(inpSearch.value.length==0){
				searchLabel.className = 'lab_search';
			}
		}
	}
}
init();
//]]>
</script>
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
  
<!--   <context-param>
  	<param-name>name</param-name>
  	<param-value>한창희</param-value>
  </context-param>
  
  <context-param>
  	<param-name>hobby</param-name>
  	<param-value>piano</param-value>
  </context-param> -->
  
<!--   <servlet>
  	<servlet-name>Mysum</servlet-name>
  	<servlet-class>study.Mysum</servlet-class>
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>Mysum</servlet-name>
  	<url-pattern>/04/*.do</url-pattern>
  </servlet-mapping> -->
   <!-- 에러 페이지  -->

<!--  <error-page>
 <error-code>404</error-code>
 <location>/WEB-INF/err/error404.jsp</location>
 </error-page>
 -->
 


<!--  <error-page>
 <error-code>500</error-code>
 <location>/WEB-INF/err/error500.jsp</location>
 </error-page> -->


<!--  <error-page>
 <exception-type>java.lang.NullPointerException</exception-type>
 <location>/WEB-INF/err/error500.jsp</location>
 </error-page>
 

  <error-page>
 <exception-type>java.lang.ClassCastException</exception-type>
 <location>/WEB-INF/err/error500.jsp</location>
 </error-page>

 
 <error-page>
 <exception-type>java.lang.NumberFormatException</exception-type>
 <location>/WEB-INF/err/error500.jsp</location>
 </error-page>
 

  <error-page>
 <exception-type>java.lang.IndexOutOfBoundsException</exception-type>
 <location>/WEB-INF/err/error500.jsp</location>
 </error-page> -->
  
  
  
</web-app>
```

## 📚 복습 정리

#### 00form
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
	<form action="00result.jsp" method="post">
		사람<input type="text" name="person" value="">
		나이<input type="text" name="age" value="">  
		<input type="submit">
	</form>
	
	<img alt="이미지가 없습니다" src="/study/resource/images/cat1.jpeg" width="100" height="100">
	<img alt="이미지가 없습니다" src="<%=request.getContextPath()%>/resource/images/cat1.jpeg" width="100" height="100">
	

</body>
</html>
```

#### 00result
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
<%request.setCharacterEncoding("utf-8"); %>
	
ip				: <%= request.getRemoteAddr() %> <br>
uri				: <%= request.getRequestURI() %> <br>
url				: <%= request.getRequestURL() %> <br>

브라우져			: <%= request.getHeader("User-Agent") %> <br>
페이지			: <%= request.getHeader("Referer") %> <br>	

파라미터 정보
person			: <%= request.getParameter("person") %> <br>
age				: <%= request.getHeader("age") %> <br>

</body>
</html>
```

#### 01redirect
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
	String name = "김소민";
	String encodeName=URLEncoder.encode(name);
	
	response.sendRedirect("01redirectPage.jsp?name=" + encodeName);
%>

</body>
</html>
```

#### 01redirectPage
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
	String name = "김소민";
	String encodeName=URLEncoder.encode(name);
	out.print(encodeName);
%>


<%=request.getParameter("name") %> <br>

</body>
</html>
```

#### 02form
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

	<form action="02result.jsp" method="post">
		<input type="text" name="한글">
		<input type="text" name="eng">
		<button type="submit">한글영어 인코딩</button>
	</form>

</body>
</html>
```

#### 02result
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
한글 <%=request.getParameter("한글") %> <br>
eng <%=request.getParameter("eng") %> <br>



</body>
</html>
```

#### 03table
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table{
		display: inline-block;
		border: 1px solid blue;
	}
</style>
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
				sb.append("<td>"+j+"x"+i+"="+(j*i)+"</td>");
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

#### 04sameName
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

<form action="04sameNameResult.jsp" method="post">
	1등<input type="text" name="a"> <br>
	결석자<input type="text" name="b"> <br>
	지각자: 사승1 <input type="checkbox" name="c" value="사승1">
		 	사승2 <input type="checkbox" name="c" value="사승2">
		 	사승3 <input type="checkbox" name="c" value="사승3">
		 	<!--  value="" 안 쓰면 on으로 나옴 -->
	<input type="submit" value="제출">
</form>

</body>
</html>
```

#### 04sameNameResult
```js
<%@page import="java.util.Map"%>
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
<form action="04sameNameResult.jsp">
1등 : <%=request.getParameter("a") %> <br>
결석자 : <%=request.getParameter("b") %> <br>
취미 : 
<%

	Map parameters = request.getParameterMap();
	String[] lates=(String[])parameters.get("c"); 
	if(lates !=null){
		for(String late:lates){
			out.print(late+ "    ");
		}
	} 
	
/* 	이런 식으로도 가능
	Map pMap = request.getParameterMap();
	String[] names2 = (String[])pMap.get("name"); */
%> 


</form>


</body>
</html>
```

#### 05buffer
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page buffer="8kb" autoFlush="true" %>
    
    <%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

버퍼사이즈			:<%=out.getBufferSize() %> <br>
남은버퍼				:<%=out.getRemaining() %> <br>
자동플러시여부		:<%=out.isAutoFlush() %> <br>

<!-- flush, clear, clearbuffer -->
<%
	for(int i=0; i<1000; i++){
		out.print("버퍼는?");
		if(i==1000){
			out.flush();
			out.clear();
		}
	}
%> <br>
남은버퍼				:<%=out.getRemaining() %> <br>
</body>
</html>
```

#### 06basicObject
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
JSP 페이지에서 다른 내장객체를 얻거나
하나의 페이지에서 다른 페이지로 제어권 등을
넘겨줄 때 사용하는 내장 변수는 무엇인가
- 페이지컨텍스트 객체
<br>
<% 
	HttpServletRequest pageRequest = (HttpServletRequest)pageContext.getRequest();
	out.print(pageRequest==request);
%> <br>



WAS에서 공유하는 객체
WAS의 설정 정보를 갖는 context와 관련이 없음
WAS가 실행되는 서버의 설정 정보 및 자원에 대한 
정보를 얻어내거나 실행되고 있는 동안에 발생할 수 있는
이벤트 로그 정보와 관련된 기능들을 제공하는 객체는? 
- 어플리케이션 객체 
<%
	application.setAttribute("name", "사승원");
	application.setAttribute("like", "pizza");
%>

</body>
</html>
```

#### 06share
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
<%=application.getAttribute("name") %>
<%=application.getAttribute("like") %>
</body>
</html>
```

#### 07readFile
```js
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
	String filePath="/resource/message/06notice.txt";
	out.print("실제 파일 위치 : " + application.getRealPath(filePath)+ "<br>");
	
	char[] buff=new char[128]; 
	int len=-1; 
	try(InputStreamReader br = new InputStreamReader(
			application.getResourceAsStream(filePath), "utf-8")){
			while((len=br.read(buff))!=-1){
				out.print(new String(buff, 0, len));
			}
		}
%>

</body>
</html>
```

#### 08error
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
에러페이지입니다.

</body>
</html>
```

#### 08form
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
500은 코드별, bound가 type별

100 : 해당 요청을 진행중 
200 : 요청을 정상적으로 처리 했음 
300 : 요청의 정보가 변경되었음 
400 : 잘못된 요청(404, 401, 403) 
500 : 내부 서버 오류(서버 프로그램의 오류) 

<form action="08my.jsp" method="post">
	라면 <input type="text" name="ramen" value="">
	<input type="submit" value="라면">
</form>

</body>
</html>
```

#### 08my
```js
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="08error.jsp"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String ramen = request.getParameter("ramen"); 
	if(ramen.equals("츠케멘")){
		throw new NullPointerException(); 
	}
	if(ramen.equals("된장라면")){
		throw new ClassCastException(); 
	}
	if(ramen.equals("소금라면")){
		throw new IOException(); 
	}
%>
기타 라면 : <%=ramen %> 
</body>
</html>
```



