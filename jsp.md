
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



#### 01 input
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
<form action="01other.jsp" method="get">
	<input type="text" name="tangType" value="aaaaa" >
	<input type="text" name="girlGroup" value="abb">
	<input type="submit">
</form>

</body>
</html>
```

#### 01 others
```js
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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
	String girlGroup = request.getParameter("girlGroup");
	String tangType = request.getParameter("tangType");
	String character ="";
	
	if(tangType.equals("bumeok")){
		character="급하다";
	}else if(tangType.equals("jjikmeok")){
		character="섬세하다";
	}else{ //cheomeok
		character="그냥 돼지";
	}
	Map<String,String> typeCharacter = new HashMap<String, String>();
	typeCharacter.put(tangType, character);
	request.setAttribute("typeCharacter", typeCharacter);
%>
걸그룹 : <%=girlGroup %> <br>
<jsp:include page="01otherinclude.jsp">
	<jsp:param value="<%=character %>" name="character"/>
	<jsp:param value="<%=tangType %>" name="tangType"/>
</jsp:include>
include 페이지에서 담은 값<%=request.getAttribute("") %>

</body>
</html>
```

## 📚 5일차
#### 01 otherinclude
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
<!-- jsp파람에서 썻던 character를 파라미터로 받고
setAttribute했던 typeCharater를 getAttribute로 받아서 사용가능 -->
<%
	String character = request.getParameter("character");
	String tangType = request.getParameter("tangType");
	Map typeCharacter = (Map<String,String>)request.getAttribute("typeCharacter");
%>
include에서 character 사용 : <%=character %> <br>
include에서 Map 객체 사용 : <%=typeCharacter.get(tangType) %>
<%
	request.setAttribute("include", "include에서 담은 내용");
%>
</body>
</html>
```

#### 02 include
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

<%="포함 전" %> <br>
<%
	String a="asd";
%>
<%@ include file="02included.jsp" %> <br>
<%="포함 후" %>

</body>
</html>
```

#### 02 included
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<input type="text" name="not" value="">  <br>
02included.jsp 내용

<%
	String a="";
%>
```

## 📚 6일차
#### path1 - 02viewcookie
```js
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title></head>
<body>
<%
	Cookie cookie = new Cookie("han","null");
	response.addCookie(cookie);
	
	Cookie cookiePath1 = new Cookie("path1","/study/08/path1");
	cookiePath1.setPath("/study/08/path1");
	response.addCookie(cookiePath1);

	Cookie cookiePath2 = new Cookie("path2","/study/08/path2");
	cookiePath1.setPath("/study/08/path2");
	response.addCookie(cookiePath2);
	
	Cookie cookieAbsolute = new Cookie("absolute","/");
	cookieAbsolute.setPath("/");
	response.addCookie(cookieAbsolute);
%>
</body>
</html>
```

#### path2 – 02viewcookie
```js
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
02viewCookie.jsp

<%
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("han")){
				out.print(cookie.getName()+ " : " + URLDecoder.decode(cookie.getValue()) + "<br>");
				continue;
			}
			out.print(cookie.getName()+ " : " + cookie.getValue()+ "<br>");
			
		}
	}
%>

</body>
</html>
```

#### 00basicBean
```js
<%@page import="com.study.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<jsp:useBean id="member" class="com.study.member.vo.MemberVO" scope="request"></jsp:useBean>

<jsp:getProperty property="memId" name="member"/>
<jsp:getProperty property="memPass" name="member"/>
<jsp:getProperty property="memDelYn" name="member"/>

<%-- <jsp:setProperty property="memId" name="member" param="memId"/>
<jsp:setProperty property="memId" name="member" value='<%=request.getParameter("memId") %>'/>
<jsp:setProperty property="memPass" name="member" value="memPass"/>
<jsp:setProperty property="memDelYn" name="member" value="Y"/> --%>

<!-- 하나하나 다 써주지 않아도 property="*"를 쓰면 jsp:getProperty에서 넣은 값을 자동으로 넣어줌 -->
<jsp:setProperty property="*" name="member"/>


<br>
<jsp:getProperty property="memId" name="member"/>
<jsp:getProperty property="memPass" name="member"/>
<jsp:getProperty property="memName" name="member"/>
<jsp:getProperty property="memBir" name="member"/>
<jsp:getProperty property="memZip" name="member"/>
<jsp:getProperty property="memAdd1" name="member"/>
<jsp:getProperty property="memAdd2" name="member"/>
<jsp:getProperty property="memHp" name="member"/>
<jsp:getProperty property="memMail" name="member"/>
<jsp:getProperty property="memJob" name="member"/>
<jsp:getProperty property="memLike" name="member"/>
<jsp:getProperty property="memMileage" name="member"/>
<jsp:getProperty property="memDelYn" name="member"/>

<jsp:forward page="00usejavaBean.jsp"></jsp:forward>

<%-- <%
	request.setAttribute("member", member);
%>
<br>
<%
	MemberVO member2=(MemberVO)request.getAttribute("member");
	out.print(member2==member);
%> --%>
<%-- <%
	MemberVO member=(MemberVO)request.getAttribute("member");
	if(member !=null){
		member=new MemberVO();
		request.setAttribute("member", member);
	}
%> --%>



</body>
</html>
```

#### 00form
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<form action="00basicBean.jsp" method="post">
	memId <input type="text" name="memId"> <br>
	memPass <input type="password" name="memPass"> <br>
	memName <input type="text" name="memName"> <br>
	memBir <input type="text" name="memBir"> <br>
	memZip <input type="text" name="memZip"> <br>
	memAdd1 <input type="text" name="memAdd1"> <br>
	memAdd2 <input type="text" name="memAdd2"> <br>
	memHp <input type="text" name="memHp"> <br>
	memMail <input type="text" name="memMail"> <br>
	memJob <input type="text" name="memJob"> <br>
	memLike <input type="text" name="memLike"> <br>
	memMileage <input type="text" name="memMileage"> <br>
	memDelYn <input type="text" name="memDelYn"> <br>
	
	<input type="submit" name="memPass">
</form>
</body>
</html>
```

#### 00usejavaBean
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

	<jsp:useBean id="member" class="com.study.member.vo.MemberVO" scope="request"></jsp:useBean>
	
	<hr>
	<jsp:getProperty property="memId" name="member"/>
	<jsp:getProperty property="memPass" name="member"/>
	<jsp:getProperty property="memDelYn" name="member"/>
	<hr>
	
	<%
		out.print(member.getMemId());
		out.print(member.getMemPass());
		out.print(member.getMemDelYn());
		member.setMemId("바뀐거");
	%>

</body>
</html>
```

#### 02deleteCookie
```js
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLEncoder"%>


<html>
<head>
<title>쿠키 삭제</title>
</head>
<body>
쿠키 delete 메소드가 따로 없고
setMaxAge() 라는 메소드를 사용

<%
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("ssw")){
				cookie.setMaxAge(0); // 0으로 지정하면 쿠키 삭제됨
				response.addCookie(cookie);
			}
		}
	}
%>

</body>
</html>
```

#### 02makeCookie
```js
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<%
	Cookie cookie = new Cookie("han",URLEncoder.encode("사승원","utf-8"));
	
	response.addCookie(cookie);
%>

</body>
</html>
```

#### 02modifyCookie
```js
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLEncoder"%>

쿠키 변경은 따로 없고 같은 이름의 쿠키를 만들면 기존것은 삭제, 새로운 것으로 대체

<html>
<head>
<title>값 변경</title>
</head>
<body>
<%
	//이름이 han인 쿠키가 있는지 없는지 검사해서
	//없으면 아무것도 안 하고 있으면 그 쿠키의 값을 바꿔보세요
	Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("han")){
				
			
				
/* 		 	값 변경..
			Cookie cookie1 = new Cookie("han", "change");
			response.addCookie(cookie); */
		}
	}
%>


</body>
</html>
```

#### 02viewcookie
```js
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
02viewCookie.jsp

<%
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("han")){
				out.print(cookie.getName()+ " : " + URLDecoder.decode(cookie.getValue()) + "<br>");
				continue;
			}
			out.print(cookie.getName()+ " : " + cookie.getValue()+ "<br>");
			
		}
	}
%>

<%

//쿠키는 기본적으로 브라우져를 끄면 사라진다.
	if(cookies!=null){
	for(Cookie cookie: cookies){
		if(cookie.getName().equals("han")){
			%>
			<%=cookie.getName() %> <br>
			<%=cookie.getValue() %> <br>
			<%=cookie.getPath() %> <br>
			<%=cookie.getMaxAge() %> <br>
			<%
		}
	}
	}
%>
</body>
</html>
```

#### 03check
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
</body>
</html>
```

#### 03cookieAge
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
	Cookie cookie = new Cookie("ssw","1st");
	//cookie.setMaxAge(15);
	cookie.setMaxAge(60*60+1);
	response.addCookie(cookie);
%>
</body>
</html>
```

#### 04cookiePath
```js
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title></head>
<body>
<%
	Cookie cookie = new Cookie("han","null");
	response.addCookie(cookie);
	
	Cookie cookiePath1 = new Cookie("path1","/study/08/path1");
	cookiePath1.setPath("/study/08/path1");
	response.addCookie(cookiePath1);

	Cookie cookiePath2 = new Cookie("path2","/study/08/path2");
	cookiePath1.setPath("/study/08/path2");
	response.addCookie(cookiePath2);
	
	Cookie cookieAbsolute = new Cookie("absolute","/");
	cookieAbsolute.setPath("/");
	response.addCookie(cookieAbsolute);
%>
</body>
</html>
```

#### 08.txt
```js
HTTP : 비연결성, 무상태

쿠키
쿠키라는 것을 만들어서 브라우져가 저장을 합니다
브라우저 측에서 뭔가를 할 수 있다.
ex : 아이디 저장, 공지사항 오늘 하루 안 보기
	  조회수 증가 방지
	  
브라우져 ------->  서버
		 (쿠키)
보안관련된 내용은 쿠키에 저장하지 않는다.
아이디, 비밀번호, 그 외 개인정보

보안 관련된 것은 session을 통해서
```


## 📚제공

#### 01memberForm
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp" %>
	<title>01memberForm.jsp </title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top.jsp" %>
 <div class="container">	
	<h3>회원가입</h3>		
	<form action="01memberRegist.jsp" method="post" >
	<table class="table table-striped table-bordered">
		<tbody>
			<tr>
				<th>아이디</th>
				<td>
					<div class="col-xs-5">
    					<input type="text" name="memId" class="form-control" placeholder="아이디를 입력하세요">
 					</div>
  				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="memPass" class="form-control input-sm" ></td>
			</tr>	
			<tr>
				<th>회원명</th>
				<td><input type="text" name="memName" class="form-control input-sm" ></td>
			</tr>
			<tr>
				<th>생일</th>
				<td><input type="date" name="memBir" class="form-control input-sm" ></td>
			</tr>
			<tr>
				<th>핸드폰</th>
				<td><input type="tel" name="memHp" class="form-control input-sm" ></td>
			</tr>
			<tr>
				<th>직업</th>
				<td>
					<select name="memJob" class="form-control input-sm" >
						<option value="">-- 직업 선택 --</option>
						<option value="JB01">주부</option>
						<option value="JB02">은행원</option>
						<option value="JB03">공무원</option>
						<option value="JB04">축산업</option>
						<option value="JB05">회사원</option>
						<option value="JB06">농업</option>
						<option value="JB07">자영업</option>
						<option value="JB08">학생</option>
						<option value="JB09">교사</option>					
					</select>				
				</td>
			</tr>
			<tr>
				<th>취미</th>
				<td>
					<select name="memLike" class="form-control input-sm" >
						<option value="">-- 취미 선택 --</option>
						<option value="HB01">서예</option>
						<option value="HB02">장기</option>
						<option value="HB03">수영</option>
						<option value="HB04">독서</option>
						<option value="HB05">당구</option>
						<option value="HB06">바둑</option>
						<option value="HB07">볼링</option>
						<option value="HB08">스키</option>
						<option value="HB09">만화</option>
						<option value="HB10">낚시</option>
						<option value="HB11">영화감상</option>
						<option value="HB12">등산</option>
						<option value="HB13">개그</option>
						<option value="HB14">카레이싱</option>					
					</select>				
				</td>
			</tr>			
			<tr>
				<td colspan="4">
				
					<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					&nbsp;회원가입
					
					<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					&nbsp;회원가입
					
					</button>
					<a href="#" class="btn btn-info btn-sm">
					<span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span>
					&nbsp;결제
					</a>
					
					</button>
					<a href="#" class="btn btn-info btn-sm">
					<span class="glyphicon glyphicon-paperclip" aria-hidden="true"></span>
					&nbsp;다운로드
					</a>
				</td>
			</tr>
			
			
			
			
			
			
			
		</tbody>	
	</table>
	</form>
</div>

</body>
</html>
```

#### 01memberRegist
```js
<%@page import="javafx.beans.property.SetProperty"%>
<%@page import="com.study.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<h4> request.getparameter 직접출력 </h4>

<%=request.getParameter("memId") %>
<%=request.getParameter("memPass") %>
<%=request.getParameter("memName") %>
<%=request.getParameter("memBir") %>
	

<hr>
<h4><% %> 안에서 MemberVO만들고 setMemId하고 out.print(member.getMemId)</h4>
<%
	MemberVO member = new MemberVO();
	member.setMemId(request.getParameter("memId"));
	member.setMemId(request.getParameter("memPass"));
	member.setMemId(request.getParameter("memName"));
	member.setMemId(request.getParameter("memBir"));
	out.print(member.getMemId());
	out.print(member.getMemPass());
	out.print(member.getMemName());
	out.print(member.getMemBir());
	
	
%>

<h4>useBean 사용해서 출력</h4>
	<jsp:useBean id="member2" class="com.study.member.vo.MemberVO" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="member2"/>

	<jsp:getProperty property="memId" name="member2"/>
	<jsp:getProperty property="memPass" name="member2"/>
	<jsp:getProperty property="memName" name="member2"/>
	<jsp:getProperty property="memBir" name="member2"/>
</body>
</html>
```

#### login
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
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	
	
	<%@include file="/WEB-INF/inc/top.jsp"%>
	<div class="container">
		<form action="06loginCheck.jsp" class="loginForm">
			<h2>로그인</h2>


			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="userId"
							class="form-control input-sm" value=""></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="userPass"
							class="form-control input-sm"></td>
					</tr>
					<tr>
						<td colspan="2"><label><input type="checkbox"
								name="rememberMe" value="Y" >ID 기억하기</label></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-primary btn-sm pull-right">로그인</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<!-- container -->
	
</body>
</html>

```

#### UserList.java
```js
package com.study.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.study.login.vo.UserVO;

public class UserList {
	private Map<String, UserVO> usersMap = null;

	public UserList() {
		UserVO user = null;
		usersMap = new HashMap<String, UserVO>();
		user = new UserVO("malja", "말자", "1004", "ADMIN");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("sunja", "순자", "1111", "USER");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("nolja", "야놀자", "1004", "USER");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("milkis", "밀키스", "1004", "MANAGER");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("areum", "아름", "0000", "MANAGER");
		usersMap.put(user.getUserId(), user);
	}

	public UserVO getUser(String id) {
		System.out.println("UserList getUser id=" + id);
		if (usersMap.containsKey(id)) {
			System.out.println("[" + id + "] 회원 존재");
			return usersMap.get(id);
		} else {
			System.out.println("[" + id + "] 회원이 존재하지 않음");
			return null;
		}
	}

	public List<UserVO> getUserList() {
		return new ArrayList<UserVO>(usersMap.values());
	}
	
	public Map<String, UserVO> getUsersMap() {
		return usersMap;
	}
	
} // class
```

#### userVO.java
```js
package com.study.login.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class UserVO {
	private String userId;
	private String userName;
	private String userPass;
	private String userRole;
	
	// toString() 구현
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	// 생성자
	public UserVO() {
		
	}
	
	// 생성자
	public UserVO(String userId, String userName, String userPass, String userRole) {
	this.userId = userId;
	this.userName = userName;
	this.userPass = userPass;
	this.userRole = userRole;
	}

	
	// 맴버필드의 get/set 메서드 생성

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
	
}

```




## 📚 7일차 

#### 01 login
```js

<%@page import="com.study.common.util.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/inc/top.jsp"%>
<!--
01login
01loginCheck 입력한 값을 받아서 userList의 데이터들이랑 비교해서
				id,pw 둘 중 하나도 값이 없으면
				"id,pw를 입력해주세요"
				id는 맞지만 pw는 다른 경우
				"id또는 pw를 확인해주세요"
				id pw 가 같으면 로그인 되었습니다.
01logout 		로그아웃
-->
<%
	CookieUtils cookieUtils=new CookieUtils(request);

	if(cookieUtils.exists("AUTH")){
		
	
%>
로그인 되었습니다
<a href="01logout.jsp" class="btn btn-defualt">로그아웃</a>
<%
	}else{
		String msg=request.getParameter("msg");
		if(msg!=null){
			out.print(msg);
		}
%>
	
	
	<div class="container">
	<%} %>
		<form action="01loginCheck.jsp" class="loginForm">
			<h2>로그인</h2>


			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="userId"
							class="form-control input-sm" value=""></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="userPass"
							class="form-control input-sm"></td>
					</tr>
					<tr>
						<td colspan="2"><label><input type="checkbox"
								name="rememberMe" value="Y" >ID 기억하기</label></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-primary btn-sm pull-right">로그인</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div> <% %>
	<!-- container -->
	
</body>
</html>

```

#### 01 logincheck

```js
<%@page import="com.study.common.util.CookieUtils"%>
<%@page import="com.study.login.vo.UserVO"%>
<%@page import="com.study.common.util.UserList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
		

<!-- 	
	//id가 없으면 아이디나 비밀번호 확인해주세요
	//pw가 없어도 아이디나 비밀번호를 확인해주세요
	//jsp:param name=msg, value="아이디나"
	//id pw 둘다 맞다면 cookie 만들어서
	//response, redirect login.jsp
-->
		
<%
	UserList userList=new UserList();
	String id = request.getParameter("userId");
	String pw = request.getParameter("userPass");
	
	//id pw가 null이면 jsp:foward 써서 login.jsp로
	
	//id pw는 내가 입력한 값
	UserVO user=userList.getUser(id);
	
	if((id==null || id.isEmpty()) || (pw==null || pw.isEmpty())){
		pageContext.forward("01login.jsp?msg=아이디나 비밀번호를 입력해주세요");//jsp forward와 똑같은 기능
	}
	if(user==null){
		pageContext.forward("01login.jsp?msg=아아디 또는 비밀번호를 확인해주세요");//jsp forward와 똑같은 기능
	}
	else if(user!=null){ //아이디는 잘 입력한 것
		if(pw.equals(user.getUserPass()));
			 //id,pw 다 맞는 경우
			 response.addCookie(CookieUtils.createCookie("AUTH", id)); //쿠키 생성
			 response.sendRedirect("01login.jsp");
		}else {
			//id는 맞았지만 비밀번호 틀린경우
			pageContext.forward("01login.jsp?msg=아아디 또는 비밀번호를 확인해주세요");//jsp forward와 똑같은 기능
		}

%>
</body>
</html>
```

#### 01 logout

```js
<%@page import="com.study.common.util.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<%
	Cookie cookie = CookieUtils.createCookie("AUTH", "a","/",0);
	response.addCookie(cookie);// 0: 쿠키 삭제
	response.sendRedirect("01login.jsp?msg=로그아웃 되었습니다.");// 쿠키삭제한 상태로 첫 페이지로 가니까 로그아웃됨
%>
</body>
</html>
```

#### 00 cookieUtilCreate

```js

```

#### src – com.study.common.util – CookieUtil.java

```js
package com.study.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {
	
	private Map<String,Cookie> cookieMap=new HashMap<String, Cookie>();
	
	public CookieUtils(HttpServletRequest request) { //생성될 때 그 request의 모든 쿠키가 cookieMap에 담김
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
	}
	
	public boolean exists(String name) {
		return cookieMap.get(name)!=null;
	}
	
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}  //null을 return할 수도 있는데 이때 검사를 직접하는것보단 exists를 이용해서...
	
	public String getValue(String name) throws IOException{
		Cookie cookie=cookieMap.get(name);
		if(cookie==null) return null;
		return URLDecoder.decode(cookie.getValue(),"utf-8");
	}
	
	public static Cookie createCookie(String name, String value) throws IOException {
		return createCookie(name, value, "", "/", -1);
	}
	
	public static Cookie createCookie(String name, String value, String path, int maxAge) throws IOException {
		return createCookie(name, value, "", path, maxAge);
	}
	
	public static Cookie createCookie(String name, String value, String domain, String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
}
```

#### src – com.study.common.util – UserList.java

```js
package com.study.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.study.login.vo.UserVO;

public class UserList {
	private Map<String, UserVO> usersMap = null;

	public UserList() {
		UserVO user = null;
		usersMap = new HashMap<String, UserVO>();
		user = new UserVO("malja", "말자", "1004", "ADMIN");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("sunja", "순자", "1111", "USER");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("nolja", "야놀자", "1004", "USER");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("milkis", "밀키스", "1004", "MANAGER");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("areum", "아름", "0000", "MANAGER");
		usersMap.put(user.getUserId(), user);
	}

	public UserVO getUser(String id) {
		System.out.println("UserList getUser id=" + id);
		if (usersMap.containsKey(id)) {
			System.out.println("[" + id + "] 회원 존재");
			return usersMap.get(id);
		} else {
			System.out.println("[" + id + "] 회원이 존재하지 않음");
			return null;
		}
	}

	public List<UserVO> getUserList() {
		return new ArrayList<UserVO>(usersMap.values());
	}
	
	public Map<String, UserVO> getUsersMap() {
		return usersMap;
	}
	
} // class
```

#### src – com.study.login.vo – UserVo.java

```js
package com.study.login.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class UserVO {
	private String userId;
	private String userName;
	private String userPass;
	private String userRole;
	
	// toString() 구현
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	// 생성자
	public UserVO() {
		
	}
	
	// 생성자
	public UserVO(String userId, String userName, String userPass, String userRole) {
	this.userId = userId;
	this.userName = userName;
	this.userPass = userPass;
	this.userRole = userRole;
	}

	
	// 맴버필드의 get/set 메서드 생성

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
	
}

```


#### src – com.study.member.vo – MemberVO.java

```js
package com.study.member.vo;

public class MemberVO {
	private String memId;         /* 회원 아이디 */
	private String memPass;       /* 회원 비밀번호 */
	private String memName;       /* 회원 이름 */
	private String memBir;        /* 회원 생일 */
	private String memZip;        /* 우편번호 */
	private String memAdd1;       /* 주소 */
	private String memAdd2;       /* 상세주소 */
	private String memHp;         /* 연락처 */
	private String memMail;       /* 이메일 */
	private String memJob;        /* 직업 코드 */
	private String memLike;       /* 취미 코드 */
	private int memMileage;       /* 마일리지 */
	private String memDelYn;     /* 탈퇴여부 */
	
	public String getMemDelYn() {
		return memDelYn;
	}
	public void setMemDelYn(String memDelYn) {
		this.memDelYn = memDelYn;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemBir() {
		return memBir;
	}
	public void setMemBir(String memBir) {
		this.memBir = memBir;
	}
	public String getMemZip() {
		return memZip;
	}
	public void setMemZip(String memZip) {
		this.memZip = memZip;
	}
	public String getMemAdd1() {
		return memAdd1;
	}
	public void setMemAdd1(String memAdd1) {
		this.memAdd1 = memAdd1;
	}
	public String getMemAdd2() {
		return memAdd2;
	}
	public void setMemAdd2(String memAdd2) {
		this.memAdd2 = memAdd2;
	}
	public String getMemHp() {
		return memHp;
	}
	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public String getMemJob() {
		return memJob;
	}
	public void setMemJob(String memJob) {
		this.memJob = memJob;
	}
	public String getMemLike() {
		return memLike;
	}
	public void setMemLike(String memLike) {
		this.memLike = memLike;
	}
	public int getMemMileage() {
		return memMileage;
	}
	public void setMemMileage(int memMileage) {
		this.memMileage = memMileage;
	}


}

```


## 📚 8일차

##

#### 02getSessionInfo
```js
<%@page import="com.study.login.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<%=((UserVO)session.getAttribute("user")).toString() %> <br>
<%=((UserVO)session.getAttribute("user1")).toString() %> <br>

</body>
</html>
```

#### 02 sessionInfo
```js
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

session ID : <%=session.getId()%>
시간<%=session.getCreationTime()  %>		<!-- 세션이 생성된 시간 -->

<%
	long time = session.getCreationTime();
	long accessTime=session.getLastAccessedTime();
	Date date = new Date();
	Date date2 = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	date.setTime(time);
	date2.setTime(accessTime);
	session.setMaxInactiveInterval(15);
%> <br> <br> <br>
생성시간 : <%=sdf.format(date) %> <br>
접근시간 : <%=sdf.format(date2) %>

</body>
</html>
```

#### 02setSessionInfo
```js
<%@page import="com.study.login.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	UserVO user1=new UserVO();
	user1.setUserId("aaa");
	UserVO user=new UserVO();
	user1.setUserId("bbb");
	
	session.setAttribute("user", user);
	session.setAttribute("user1", user1);
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
</body>
</html>
```

#### 03login
```js
<%@page import="com.study.common.util.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/inc/top.jsp"%>

	<!-- 제공된 파일에 추가하는겁니다 -->

	<!-- 문제 : AUTH라는 쿠키가 있으면 "로그인됨"  
	없으면 로그인 폼 출력하기
 -->

	loginCheck : id기억하기 쿠키 :SAVE_ID, id

	<%
		String msg = request.getParameter("msg");
	String id = "";
	String checked = "";

	if (msg != null) {
		out.print(msg);
	}
	CookieUtils cookieUtils = new CookieUtils(request);

	if (cookieUtils.exists("SAVE_ID")) {
		id = cookieUtils.getValue("SAVE_ID");
		checked = "checked='checked'";
	}

	if (cookieUtils.exists("AUTH")) {
	%>
	로그인 중
	<a href="01logout.jsp" class="btn btn-success btn-sm">로그아웃</a>
	<%
		} else {
	%>


	<div class="container">
		<form action="01loginCheck.jsp" class="loginForm">
			<h2>로그인</h2>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="userId" class="form-control input-sm" value="<%=id%>"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="userPass" class="form-control input-sm"></td>
					</tr>
					<tr>
						<td colspan="2"><label><input type="checkbox" name="rememberMe" value="Y" <%=checked %>>ID 기억하기</label></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-primary btn-sm pull-right">로그인</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<!-- container -->
	<%}%>
</body>
</html>
```

#### 03loginCheck
```js
<%@page import="com.study.common.util.CookieUtils"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.study.login.vo.UserVO"%>
<%@page import="com.study.common.util.UserList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/inc/header.jsp" %>
<title></title>
</head>
<body>
<!-- <a href="#" class="btn btn-default" onclick="history.go(-1)">뒤로가기</a>
아이디틀렸을때  -->


1.아이디나 비밀번호 입력 안했을 때    forward.  msg:입력안했어요
2.아이디가 userList에 없을 때          
forward  msg:아이디 또는 비번확인

3.아이디가 userList에 있고, pw도 맞았을 떄  redircet
4.아이디가 userList에 있지만 pw가 틀렸을 때
forward  msg:아이디 또는 비번확인
<%
	String id=request.getParameter("userId");
	String pw=request.getParameter("userPass");
	String save_id=request.getParameter("rememberMe");
	if(save_id==null){
		CookieUtils cookieUtils = new CookieUtils(request);
		if(cookieUtils.exists("SAVE_ID")){
			Cookie cookie= CookieUtils.createCookie("SAVE_ID", id, "/" ,0);
			response.addCookie(cookie);
		}
		save_id="";
	}
	
	if((id==null||id.isEmpty() )|| (pw==null||pw.isEmpty())){
		pageContext.forward("01login.jsp?msg=입력안했어요");
	}
	
	UserList userList=new UserList();
	UserVO user=userList.getUser(id);
	
	if(user==null){
		pageContext.forward("01login.jsp?msg=아이디 또는 비번 확인");
	}else{ //id맞았을때
		if(user.getUserPass().equals(pw)){//다 맞는경우
			if(save_id.equals("Y")){
				response.addCookie(
						CookieUtils.createCookie("SAVE_ID", id,"/",3600*24*7));
			}
			response.addCookie(CookieUtils.createCookie("AUTH", id));
			response.sendRedirect("01login.jsp");
		}else{//  비번만 틀린경우
			pageContext.forward("01login.jsp?msg=아이디 또는 비번 확인");
		}
		
	}
%>



	
	
</body>
</html>
```

#### 03logout
```js
<%@page import="com.study.common.util.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>Insert title here</title>
</head>

<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<%
	Cookie cookie=CookieUtils.createCookie("AUTH","");
	cookie.setMaxAge(0);
	response.addCookie(cookie);
	response.sendRedirect("01login.jsp");
%>

</body>
</html>
```


## 📚 9일차

##

#### 00login
```js
<%@page import="com.study.login.vo.UserVO"%>
<%@page import="com.study.common.util.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/inc/top.jsp"%>

	<!-- 제공된 파일에 추가하는겁니다 -->

	<!-- 문제 : AUTH라는 쿠키가 있으면 "로그인됨"  
	없으면 로그인 폼 출력하기
 -->

	loginCheck : id기억하기 쿠키 :SAVE_ID, id

	<%
		String msg = request.getParameter("msg");
	String id = "";
	String checked = "";

	if (msg != null) {
		out.print(msg);
	}
	CookieUtils cookieUtils = new CookieUtils(request);

	if (cookieUtils.exists("SAVE_ID")) {
		id = cookieUtils.getValue("SAVE_ID");
		checked = "checked='checked'";
	}

	
	UserVO user = (UserVO)session.getAttribute("USER_INFO");
	if (user!=null) {
	%>
	로그인 중
	<a href="03logout.jsp" class="btn btn-success btn-sm">로그아웃</a>
	<%
		} else {
	%>


	<div class="container">
		<form action="03loginCheck.jsp" class="loginForm">
			<h2>로그인</h2>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="userId" class="form-control input-sm" value="<%=id%>"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="userPass" class="form-control input-sm"></td>
					</tr>
					<tr>
						<td colspan="2"><label><input type="checkbox" name="rememberMe" value="Y" <%=checked %>>ID 기억하기</label></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-primary btn-sm pull-right">로그인</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<!-- container -->
	<%}%>
</body>
</html>
```

#### 00loginCheck
```js
<%@page import="com.study.common.util.CookieUtils"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.study.login.vo.UserVO"%>
<%@page import="com.study.common.util.UserList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/inc/header.jsp" %>
<title></title>
</head>
<body>
<!-- <a href="#" class="btn btn-default" onclick="history.go(-1)">뒤로가기</a>
아이디틀렸을때  -->


1.아이디나 비밀번호 입력 안했을 때    forward.  msg:입력안했어요
2.아이디가 userList에 없을 때          
forward  msg:아이디 또는 비번확인

3.아이디가 userList에 있고, pw도 맞았을 떄  redircet
4.아이디가 userList에 있지만 pw가 틀렸을 때
forward  msg:아이디 또는 비번확인
<%
	String id=request.getParameter("userId");
	String pw=request.getParameter("userPass");
	String save_id=request.getParameter("rememberMe");
	if(save_id==null){
		CookieUtils cookieUtils = new CookieUtils(request);
		if(cookieUtils.exists("SAVE_ID")){
			Cookie cookie= CookieUtils.createCookie("SAVE_ID", id, "/" ,0);
			response.addCookie(cookie);
		}
		save_id="";
	}
	
	String redirectPage="";
	
	if((id==null||id.isEmpty() )|| (pw==null||pw.isEmpty())){
		//pageContext.forward("03slogin.jsp?msg=입력안했어요");
		redirectPage="03login.jsp?msg=" + URLEncoder.encode("입력안함", "utf-8");
	}
	
	UserList userList=new UserList();
	UserVO user=userList.getUser(id);
	
	if(user==null){
		//pageContext.forward("03login.jsp?msg=아이디 또는 비번 확인");
		redirectPage="03login.jsp?msg=" + URLEncoder.encode("아이디 또는 비번 확인", "utf-8");
	}else{ //id맞았을때
		if(user.getUserPass().equals(pw)){//다 맞는경우
			if(save_id.equals("Y")){
				response.addCookie(
						CookieUtils.createCookie("SAVE_ID", id,"/",3600*24*7));
			}
			response.addCookie(CookieUtils.createCookie("AUTH", id));
			
			//SAVE_ID는 쿠키로 하는 게 맞고
			//AUTH쿠키만 session으로 고침
			//session 속성 이름은  "USER_INFO"
			session.setAttribute("USER_INFO", user);
			session.setMaxInactiveInterval(1800); 	//자동 로그아웃(30분)
			
			redirectPage="03login.jsp?";
			
		}else{//  비번만 틀린경우
			//pageContext.forward("03login.jsp?msg=아이디 또는 비번 확인");
			redirectPage="03login.jsp?msg=" + URLEncoder.encode("아이디 또는 비번 확인", "utf-8");
		}
		
		response.sendRedirect(redirectPage); //마지막 한 번만 리다이렉트 해주면 됨
	}
%>



	
	
</body>
</html>
```

#### 00logout
```js
<%@page import="com.study.common.util.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>Insert title here</title>
</head>

<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<%
	session.invalidate();
	response.sendRedirect("03login.jsp");

/* 	Cookie cookie=CookieUtils.createCookie("AUTH","");
	cookie.setMaxAge(0);
	response.addCookie(cookie);
	response.sendRedirect("01login.jsp"); */
%>

</body>
</html>
```

#### 01footer
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<div class="navbar-fixed-bottom">
	사승원 : <%=request.getParameter("email")%>, tel:<%=request.getParameter("tel") %>
</div>
</body>
</html>
```

#### 01include
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

사승원 페이지 내용들

<!-- 어떤 페이지에서든 밑에 사용하면 된다. -->
<jsp:include page="01footer.jsp">
	<jsp:param value="dfg1425@naver.com" name="email"/>
	<jsp:param value="010-9908-6359" name="tel"/>
</jsp:include>
</body>
</html>
```


#### 02ch
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<%
	List<String> chFriendList=
	(List<String>)request.getAttribute("friendList");
	out.print("<ul>");
	for(String chFriend : chFriendList){
		out.print("<li>" + chFriend);
	}
	//db조회해서 한창희 email tel 값 얻어서
%>

<jsp:include page="02footer.jsp">
	<jsp:param value='<%=request.getParameter("name") %>' name="name"/>
	<jsp:param value="gks930620@daum.net" name="email"/>
	<jsp:param value="010-9908-6359" name="tel"/>
</jsp:include>
</body>
</html>
```

#### 02footer
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<div class="navbar-fixed-bottom">
 <%=request.getParameter("name")%>
 <%=request.getParameter("email")%>
 <%=request.getParameter("tel")%>
</div>
</body>
</html>
```

#### 02input
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<!-- jsp:forward는 조건에 따라 서로 다른 페이지를 보여줘야 할 때 -->
<form action="02result.jsp" method="post">
	한창희 <input type="radio" name="name" value="한창희">
	한석규 <input type="radio" name="name" value="한석규">
	<button type="submit">한씨</button>
</form>

</body>
</html>
```

#### 02result
```js
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String name = request.getParameter("name");
	String pageName = "";
	List<String> friendList=new ArrayList<String>();
	
	if(name.equals("한창희")){
		friendList.add("유병주");
		friendList.add("문지영");
		pageName="02ch.jsp";
	}else{
		friendList.add("   ");
		pageName="02sk.jsp";
	}
	//forward 부모페이지(result)에서의 request랑
	//자식페이지(ch,sk)에서의 request는 같은 request
	request.setAttribute("friendList", friendList);
%>

	<jsp:forward page="<%=pageName %>">
		<jsp:param value="<%=name %>" name="name"/>
	</jsp:forward>

<%@include file="/WEB-INF/inc/top.jsp" %>

</body>
</html>
```

#### 02sk
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
</body>
</html>
```

#### 03basicBean
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
</body>
</html>
```

#### 03form
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

자바빈규약
1. 패키지 : 패키지 안에 있어야 한다. (default pakage 말고)
2. 생성자 : 기본생성자
3. 필드 private
4. get set public
5. 직렬화는 선택사항 (implements Serializable)

<form action="03useJavaBean.jsp" method="post">
	<pre>
	userId		<input type="text" value="" name="userId">
	userName	<input type="text" value="" name="userName">
	userPass	<input type="password" value="" name="userPass">
	userRole	<input type="hidden" value="MANAGER" name="userRole">
	</pre>
	
	<input type="submit">
</form>

</body>
</html>
```

#### 03useJavaBean
```js
<%@page import="com.study.login.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>


<jsp:useBean id="inbum" class="com.study.login.vo.UserVO" scope="request"></jsp:useBean>

<!-- 밑에 것을 위에 한줄로 똑같이 쓸 수 있다. -->
<%
/* 	UserVO inbum=(UserVO)request.getAttribute("inbum");
	if(inbum==null){
		inbum=new UserVO();
		request.setAttribute("inbum", inbum);
	} */
%>
<pre>
	set 전<jsp:getProperty property="userId" name="inbum"/>
	<!-- set을 해야 값이 나옴 set 후 get하기 -->
	<jsp:setProperty property="userId" name="inbum"/>
	set 후<jsp:getProperty property="userId" name="inbum"/>
	
	<jsp:setProperty property="*" name="inbum"/>
	
</pre>
	<%=inbum %>
</body>
</html>
```

#### 05closSession
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<%
	session.invalidate(); // 세션 삭제
%>

</body>
</html>
```

#### 05getMemberInfo
```js
<%@page import="com.study.login.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<%
	String nameValue= (String)session.getAttribute("name");
	UserVO user = (UserVO)session.getAttribute("user");
%>

<%=nameValue %> <br>
<%=user %>
</body>
</html>
```

#### 05sessionInfo
```js
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
보안과 관련있는 것은 세션으로 세션의 주 사용 용도 로그인 유지
05sessionInfo
05closeSession
05setMemberInfo
05getMemberInfo
<br>
세션 id : <%=session.getId() %> <br>
<%

	long cTime=session.getCreationTime();
	long latime=session.getLastAccessedTime();
	
	session.setMaxInactiveInterval(15); // 15초 동안 세션에 접근을 안 하면 세션 재 생성
	
	Date date = new Date();
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	date.setTime(cTime);
	sdf.format(date);
	out.print(sdf.format(date));
	
	out.print("<br>");
	
	date.setTime(latime);
	sdf.format(date);
	out.print(sdf.format(date));
	
	
	%>
<%

%>
</body>
</html>
```

#### 05setMemberInfo
```js
<%@page import="com.study.login.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<%//여기는 set
	session.setAttribute("name", "value");
	UserVO user = new UserVO("han", "한석규", "1004", "perpect");
	session.setAttribute("user", user);

%>
</body>
</html>
```


## 📚 10일차
##

#### 01el
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

EL표현식
Expression Language
요청 URI : <%=request.getRequestURI() %> <br>
요청 URI : ${pageContext.request.requestURI}

<hr>
EL의 객체탐색
pageContext, request, session, application 순으로 속성 검사 <br>

<%
	/* request.setAttribute("name", "사승원"); */
	session.setAttribute("name", "aaa");
%>

${name} <br> <!-- requestScope 안 붙여도 속성 이름 만으로 값 받아올 수 있음  -->
<hr>
${param.jeong } <%=request.getParameter("jeong") %>

</body>
</html>
```

#### 02el
```js
<%@page import="com.study.common.util.UserList"%>
<%@page import="com.study.login.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<%
	UserVO user = (new UserList()).getUser("malja");
	request.setAttribute("user", user);
%>

<%-- ${usadfafd } --%>
<!-- 없는 속성을 쓰면 값 출력 x 에러 안 남 -->

<%-- ${user.asdsad } --%>
<!-- 읽기 가능한 프로퍼티가 아닌 경우 에러남 -->

<hr> 쿠키
${cookie.JSESSIONID.value }

</body>
</html>
```

#### 03jsstSet
```js
<%@page import="com.study.common.util.UserList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
JSTL
JSP Standard Tag Library
jsp

<%
	UserList userList=new UserList();
	request.setAttribute("userList",userList);  
%>
<c:set value="${userList }" var="nam"/>
<c:set value="<%=userList %>" var="nam"/>
${nam.userList }
<hr>
<c:set value="String" var="han" scope="request"/>
<%-- <%
	request.setAttribute
	("han", "String");
%> --%>
${han }

<c:remove var="han"/>

</body>
</html>
```

#### 04input
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<form action="04jstlIf.jsp" method="post">
	나이<input type="number" name="number" value="">
	<input type="submit">
</form>


</body>
</html>
```

#### 04jstlIf
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<%
	int age =
	Integer.parseInt(request.getParameter("number"));
%>

간단한 출력문은 out.print하면 되는데
복잡한 거는 out.print하기 힘드니까
스크립트릿%%닫고 출력 했었음

<hr>
 	c:if는 else가 없어요
	<c:if test="<%=age<10 %>">
		<div border="1">
			<a href="04child.jsp">어린이</a>
		</div>
	</c:if>
 	<hr>
 	<c:if test="<%=age>=10 %>">
 			<div border="1">
			<a href="04child.jsp">어린이2</a>
		</div>
 	</c:if>

</body>
</html>
```

#### 05prodList
```js
<%@page import="com.study.common.vo.ProdVO"%>
<%@page import="com.study.common.util.ProductList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>제품 목록</title>
<style>
.prod-list tbody td {border: 1px dashed;}
.prod-list tbody ul {padding-left: 20px;}
.prod-list tbody ul li {list-style: none; line-height: 1.4em;}

.prod-title a ,
.prod-title a:active,
.prod-title a:focus   {text-overflow:ellipsis; text-decoration: none; }

.prod-image {text-align: center;}
.prod-image img {
	 height: 150px;
}
</style>
</head>
<%
	List<ProdVO> productList= ProductList.getProductList();
%>

<body>
<div class="container">
<h3>제품 목록</h3>
<table class="prod-list">
	<caption class="hidden"><em>컴퓨터 제품 목록</em></caption>
	<colgroup>
		<col style="width: 33%;">
		<col style="width: 33%;">
		<col />
	</colgroup>
	<tbody>
	<%
		for(int i=0; i<3; i++){
	%>
		<tr>
		<%
			for(int j=0; j<3; j++){
		%>
			<td>
				<ul>
					<li class="prod-image"><a href="05prodView.jsp?prodId=<%=productList.get(i*3+j).getProdId()%>">
					<img alt="" src="<%=request.getContextPath()%><%=productList.get(i*3+j).getProdImg()%>"></a>
					<li class="prod-title">
					<a href="05prodView.jsp?prodId=<%=productList.get(i*3+j).getProdImg()%>">
					<%=productList.get(i*3+j).getProdName() %></a>
					<li class="prod-price"><%=productList.get(i*3+j).getProdPrice() %>
					<li class="prod-reg-date"><%=productList.get(i*3+j).getProdRegDate() %>
				</ul>
			</td>
			<%
			}
			%>
			</tr>
			<%
			}
			%>
			
	</tbody>

</table>
</div>
</body>
</html>

```

#### 05prodView
```js
<%@page import="com.study.common.util.ProductList"%>
<%@page import="com.study.common.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>상품 상세보기</title>
<style>
.btn-basic-area { padding-top: 10px; border-top: 1px dashed;  text-align: center; }
.btn-basic-area span {padding: 10px 30px 10px; min-width: 100px;}
</style>
</head>
<body>
<%
	ProdVO prod= ProductList.getProduct(request.getParameter("prodId"));
%>


<div class="container">
<h3>상품 상세보기</h3>
<table class="prod-list">
	<caption>상품 상세보기</caption>
	<colgroup>
		<col style="width: 25%;">
		<col />
	</colgroup>
	<tbody class="prod-detail">
		<tr>
			<td>제품명</td>			
			<td><%=prod.getProdName() %></td>
		</tr>	
		<tr>
			<td>이미지</td>			
			<td><img alt="" src="<%=request.getContextPath() %><%=prod.getProdImg() %>"></td>
		</tr>	
		<tr>
			<td>가격</td>			
			<td><%=prod.getProdPrice() %>"</td>
		</tr>
		<tr>
			<td>등록일</td>			
			<td><%=prod.getProdRegDate() %>"</td>
		</tr>
		<tr>
			<td>상세설명</td>			
			<td><%=prod.getProdDetail() %>"</td>
		</tr>
	</tbody>
</table>

<div class="btn-basic-area" >
	<span><a href="/study/index.jsp" >Home</a> </span>
	<span><a href="prodList.jsp" >상품목록</a> </span>
</div>

</div><!-- container -->
</body>
</html>

```



## 📚 11일차 
#### 01jstlForArray
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<%
	String[] vacation={"1승원","2승원","3승원","4승원"};
	request.setAttribute("vacation", vacation);
%>
<%--
<c:forEach items="${vacation }"></c:forEach> <!-- <c:forEach items="<%=vacation %>"></c:forEach>이랑 같음 -->

<c:set var="asd" value="<%=vacation %>"></c:set>
<c:forEach items="${asd}"></c:forEach>
 --%>
 
 <!-- varstatus에는 index, current -->
 <pre>
<c:forEach items="<%=vacation %>" var="name" varStatus="status">
	${name } 	${status.current } ${status.index } <%-- 배열의 인덱스(0부터 시작) --%>${status.count } <!-- 1부터 시작 -->
	<c:if test="${status.index eq 3 }">나는 3번째 인덱스 ${name }</c:if>
	<c:if test='${status.current eq "3승원" }'>찾는 거 ${name } ${status.current }</c:if>
</c:forEach>
</pre>

<%
	for(String asd : vacation){
		out.print(asd);
	}
%>


</body>
</html>
```

#### 01jstlForList
```js
<%@page import="com.study.common.util.UserList"%>
<%@page import="com.study.login.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<%
	List<UserVO> userList=new UserList().getUserList();
	request.setAttribute("userList", userList);
%>
<c:forEach items="${userList }" var="user" varStatus="status">
	${user.userId } ${user.userPass } ${user.userName } <br>
</c:forEach>

<hr>

<c:forEach items="${userList }" var="user" varStatus="status">
	<c:if test="${status.first }">
	${user.userId } ${user.userPass } ${user.userName } <br>
	</c:if>
	<c:if test="${status.last }">
	${user.userId } ${user.userPass } ${user.userName } <br>
	</c:if>
</c:forEach>

</body>
</html>
```

#### 02 jstlForMap
```js
<%@page import="com.study.common.util.UserList"%>
<%@page import="com.study.login.vo.UserVO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<%
	Map<String, UserVO> userMap=new UserList().getUsersMap();
	for(Map.Entry<String, UserVO> entry: userMap.entrySet()){
		out.print(entry.getKey()+" : " + entry.getValue().getUserName());
	}
	request.setAttribute("userMap", userMap);
%>
<hr>

<!-- 위랑 동일하게 작성하는 법 -->
<c:forEach items="${userMap }" var="user">
	${user.key } : ${user.value.userName }
</c:forEach>

</body>
</html>
```js

```

#### 03jstlForToken
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<%
	String badPeople="1승원, 2승원, 3승원, 4승원, 5승원 6승원" ;
%>
<c:forTokens items="<%=badPeople %>" delims="" var="badPerson">
	${badPerson }
</c:forTokens>


</body>
</html>

```

#### 04 prodList
```js
<%@page import="com.study.common.vo.ProdVO"%>
<%@page import="com.study.common.util.ProductList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>제품 목록</title>
<style>
.prod-list tbody td {border: 1px dashed;}
.prod-list tbody ul {padding-left: 20px;}
.prod-list tbody ul li {list-style: none; line-height: 1.4em;}

.prod-title a ,
.prod-title a:active,
.prod-title a:focus   {text-overflow:ellipsis; text-decoration: none; }

.prod-image {text-align: center;}
.prod-image img {
	 height: 150px;
}
</style>
</head>


<body>
<div class="container">
<h3>제품 목록</h3>
<table class="prod-list">
	<caption class="hidden"><em>컴퓨터 제품 목록</em></caption>
	<colgroup>
		<col style="width: 33%;">
		<col style="width: 33%;">
		<col />
	</colgroup>
	<tbody>
	<!-- c:forEach써서 간단하게 EL표기법으로, items에 객체 넣어서 begin, end 쓰지말고 -->
	
<%
	List<ProdVO> productList=new ProductList().getProductList();
	request.setAttribute("productList", productList);
%>
	
	

		<c:forEach items="${productList }" var="j" varStatus="status">
		<c:if test="${status.count %3==1 }"> <tr> </c:if>
			<td>
				<ul>
					<li class="prod-image"><a href="04prodView.jsp?prodId=${j.prodId }">
					<img alt="wrfgetrgtrg" src="<%=request.getContextPath()%>${j.prodImg}" ></a>
					<li class="prod-title">
					<a href="04prodView.jsp?prodId=${j.prodId }">
					${j.prodName } </a>
					<li class="prod-price> ${j.prodPrice}">
					<li class="prod-reg-date ${j.prodRegDate}">
				</ul>
			</td>
		<c:if test="${status.count %3==0 }"></tr> </c:if>
		
		</c:forEach>
</table>
			

</div>
</body>
</html>

```

#### 04prodView
```js
<%@page import="java.util.List"%>
<%@page import="com.study.common.util.ProductList"%>
<%@page import="com.study.common.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>상품 상세보기</title>
<style>
.btn-basic-area { padding-top: 10px; border-top: 1px dashed;  text-align: center; }
.btn-basic-area span {padding: 10px 30px 10px; min-width: 100px;}
</style>
</head>
<body>
<%-- <%
	ProdVO prod= ProductList.getProduct(request.getParameter("prodId"));
%>
 --%>
<%
	ProdVO prod= ProductList.getProduct(request.getParameter("prodId"));
	request.setAttribute("prod", prod);
%>


<div class="container">
<h3>상품 상세보기</h3>
<table class="prod-list">
	<caption>상품 상세보기</caption>
	<colgroup>
		<col style="width: 25%;">
		<col />
	</colgroup>
	<tbody class="prod-detail">
		<tr>
			<td>제품명</td>			
			<td>${prod.prodName } %></td>
		</tr>	
		<tr>
			<td>이미지</td>			
			<td><img alt="" src="<%=request.getContextPath() %>${prod.prodImg }"/></td>
		</tr>	
		<tr>
			<td>가격</td>			
			<td>${prod.prodPrice }</td>
		</tr>
		<tr>
			<td>등록일</td>			
			<td>${prod.prodRegDate }</td>
		</tr>
		<tr>
			<td>상세설명</td>			
			<td>${prod.prodDetail}</td>
		</tr>
	</tbody>
</table>

<div class="btn-basic-area" >
	<span><a href="/study/index.jsp" >Home</a> </span>
	<span><a href="prodList.jsp" >상품목록</a> </span>
</div>

</div><!-- container -->
</body>
</html>

```
## 📚 12일차
#### src – resource – message.properties
```js
name = saseungwon

title = \uB85C\uADF8\uC778
id = \uC544\uC774\uB514

id.placeholder = \uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694
password = \uBE44\uBC00\uBC88\uD638
password.placeholder = \uBE44\uBC00\uBC88\uD638 \uD655\uC778
remember = \uC544\uC774\uB514 \uAE30\uC5B5\uD558\uAE30
btn.submit = \uB85C\uADF8\uC778
info = \uC9C1\uCC45 {0}, \uC544\uB514\uB514={1}, \uC774\uB984={2}
logout = \uB85C\uADF8\uC544\uC6C3
empty = \uBE44\uBC00\uBC88\uD638\uB098 \uC544\uC774\uB514\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694
check = \uC544\uC774\uB514\uC640 \uBE44\uBC00\uBC88\uD638\uB97C \uD655\uC778\uD574\uC8FC\uC138\uC694
```

#### src – resource – message_en.properties
```js
name = saseungwon

title = Login
id = ID

id.placeholder = Enter Id
password = password
password.placeholder = Enter Password
remember = Save Id
btn.submit = Login
info = your Role is {0}, Id={1}, Name={2}
logout = Logout
empty = Password or Id is empty.
check = Check your Id or Password. 
```

#### src – resource – message_jp.properties
```js
name = saseungwon

title = \u30ED\u30B0\u30A4\u30F3
id = ID

id.placeholder = ID\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044
password = \u30D1\u30B9\u30EF\u30FC\u30C9
password.placeholder = \u30D1\u30B9\u30EF\u30FC\u30C9\u3092\u5165\u529B\u3059\u308B
remember = ID\u3092\u4FDD\u5B58
btn.submit = \u30ED\u30B0\u30A4\u30F3
info = \u3042\u306A\u305F\u306E\u5F79\u5272\u306F {0}, Id={1}, \u540D\u524D={2}
logout = \u30ED\u30B0\u30A2\u30A6\u30C8
empty = \u30D1\u30B9\u30EF\u30FC\u30C9\u307E\u305F\u306FID\u304C\u7A7A\u3067\u3059\u3002
check = ID\u307E\u305F\u306F\u30D1\u30B9\u30EF\u30FC\u30C9\u3092\u78BA\u8A8D\u3057\u3066\u304F\u3060\u3055\u3044\u3002
```

#### login - 03login 
```js
<%@page import="com.study.login.vo.UserVO"%>
<%@page import="com.study.common.util.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/inc/top.jsp"%>
	<%
		String msg = request.getParameter("msg");
	String id = "";
	String checked = "";

	if (msg != null) {
		out.print(msg);
	}
	CookieUtils cookieUtils = new CookieUtils(request);

	if (cookieUtils.exists("SAVE_ID")) {
		id = cookieUtils.getValue("SAVE_ID");
		checked = "checked='checked'";
	}
	%>

	<a href="04localeChange.jsp?lang=jp">日本語</a>
	<a href="04localeChange.jsp?lang=ko">한국어</a>
	<a href="04localeChange.jsp?lang=en">english</a>
	<fmt:bundle basename="resource.message">
			<%=response.getLocale() %>
	<c:if test="${USER_INFO ne null }">
	
	<fmt:message key="info">
		<fmt:param value="${USER_INFO.userRole }"></fmt:param>
		<fmt:param value="${USER_INFO.userId }"></fmt:param>
		<fmt:param value="${USER_INFO.userName }"></fmt:param>
	</fmt:message>
	
	<fmt:message key="title" />
	<a href="03logout.jsp" class="btn btn-success btn-sm"><fmt:message key="logout"/> </a>
	</c:if> 
	
	<c:if test="${USER_INFO eq null }">
		<c:if test="<%=msg !=null %>"> <fmt:message key="<%=msg %>"/> </c:if>
		
		<div class="container">
		<form action="03loginCheck.jsp" class="loginForm">
			<h2><fmt:message key="title"/> </h2>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th><fmt:message key="id"/></th>
						<td><input type="text" name="userId" class="form-control input-sm" value="<%=id%>" placeholder='<fmt:message key="id.placeholder"/>'></td>
					</tr>
					<tr>
						<th><fmt:message key="password"/></th>
						<td><input type="password" name="userPass" class="form-control input-sm" placeholder='<fmt:message key="password.placeholder"/>'></td>
					</tr>
					<tr>
						<td colspan="2"><label><input type="checkbox" name="rememberMe" value="Y" <%=checked %>><fmt:message key="remember"/></label></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-primary btn-sm pull-right"><fmt:message key="btn.submit"/></button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	
	
	</c:if>
	</fmt:bundle>

	<!-- container -->
</body>
</html>
```

#### login - 03loginCheck
```js
<%@page import="com.study.common.util.CookieUtils"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.study.login.vo.UserVO"%>
<%@page import="com.study.common.util.UserList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/inc/header.jsp" %>
<title></title>
</head>
<body>
<!-- <a href="#" class="btn btn-default" onclick="history.go(-1)">뒤로가기</a>
아이디틀렸을때  -->

session에 속성 저장은 "USER_INFO"   userVO 를 속성에 저장 


1.아이디나 비밀번호 입력 안했을 때    forward.  msg:입력안했어요
2.아이디가 userList에 없을 때          
forward  msg:아이디 또는 비번확인

3.아이디가 userList에 있고, pw도 맞았을 떄  redircet 
4.아이디가 userList에 있지만 pw가 틀렸을 때 
forward  msg:아이디 또는 비번확인
<%
	String id=request.getParameter("userId");
	String pw=request.getParameter("userPass");
	String save_id=request.getParameter("rememberMe");
	if(save_id==null){
		CookieUtils cookieUtils=new CookieUtils(request);
		if(cookieUtils.exists("SAVE_ID")){
			Cookie cookie=CookieUtils.createCookie("SAVE_ID",id,"/",0);
			response.addCookie(cookie);
		}
		save_id="";
	}
	
	String redirectPage="";
	
	
	if((id==null||id.isEmpty() )|| (pw==null||pw.isEmpty())){	
		//response.sendRedirect("03login.jsp?msg=입력안함")
		redirectPage="03login.jsp?msg=empty";
	}
	
	UserList userList=new UserList();
	UserVO user=userList.getUser(id);
	
	if(user==null){
		//response.sendRedirect("03login.jsp?msg=아이디 또는 비번 확인");
		redirectPage="03login.jsp?msg=check";
	}else{ //id맞았을때 
		if(user.getUserPass().equals(pw)){//다 맞는경우
			if(save_id.equals("Y")){
				response.addCookie(
						CookieUtils.createCookie("SAVE_ID", id,"/",3600*24*7));
			}
			session.setAttribute("USER_INFO",user );
			session.setMaxInactiveInterval(1800);
			//response.sendRedirect("03login.jsp");
			redirectPage="03login.jsp?";
		}else{//  비번만 틀린경우
			//response.sendRedirect("03login.jsp?msg=아이디 또는 비번 확인");
			redirectPage="03login.jsp?msg="+URLEncoder.encode("아이디 또는 비번 확인","utf-8");
		}
		
	}

	response.sendRedirect(redirectPage);
%>



	
	
</body>
</html>
```

#### login - 03logout
```js
<%@page import="com.study.common.util.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>Insert title here</title>
</head>

<body>
<%@include file="/WEB-INF/inc/top.jsp" %> 
<%
	session.invalidate();
	response.sendRedirect("03login.jsp");
%>

</body>
</html>

```

#### login - 04localeChange
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<%
	String lang = request.getParameter("lang"); 
%>
${param.lang }


<fmt:setLocale value="${param.lang }" scope="session"/>
페이지 : <%=request.getHeader("Referer") %> <br>

<c:redirect url='<%=request.getHeader("Referer") %>'></c:redirect>

</body>
</html>
```

#### 00jstlIf
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<%
	request.setAttribute("perfect", "사승원");
%>

test의 값이 true or false가 나와야 함 

<c:if test='${perfect == "사승원" }'>
	perfect == "사승원"이 true니까 실행됨
</c:if>

</body>
</html>
```

#### 00prodList
```js
<%@page import="com.study.common.util.ProductList"%>
<%@page import="com.study.common.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>제품 목록</title>
<style>
.prod-list tbody td {border: 1px dashed;}
.prod-list tbody ul {padding-left: 20px;}
.prod-list tbody ul li {list-style: none; line-height: 1.4em;}

.prod-title a ,
.prod-title a:active,
.prod-title a:focus   {text-overflow:ellipsis; text-decoration: none; }

.prod-image {text-align: center;}
.prod-image img {
	 height: 150px; 
}
</style>
</head>
<body>
<%
	List<ProdVO> prodList=ProductList.getProductList();
	request.setAttribute("prodList", prodList); 
%>

<div class="container">
<h3>제품 목록</h3>
<table class="prod-list">
	<caption class="hidden"><em>컴퓨터 제품 목록</em></caption>
	<colgroup>
		<col style="width: 33%;">
		<col style="width: 33%;">
		<col />
	</colgroup>
	<tbody>
	
	<c:forEach items="${prodList }" var="prod" varStatus="status">
		<c:if test="${status.count %3 eq 1 }"> <tr>  </c:if>
			<td>
				<ul>
					<li class="prod-image"><a href="00prodView.jsp?prodId=${prod.prodId }"> 
					<img alt="" src=<%=request.getContextPath()%>${prod.prodImg }></a>
					<li class="prod-title"><a href="00prodView.jsp?prodId=${prod.prodId }">${prod.prodName }</a>
					<li class="prod-price">${prod.prodPrice }
					<li class="prod-reg-date">${prod.prodRegDate } 
				</ul>
			</td>
			<c:if test="${status.count %3 eq 0  }"> </tr> </c:if>
	</c:forEach>
	

	</tbody>

</table>
</div>
</body>
</html>

```

#### 00prodView
```js
<%@page import="com.study.common.util.ProductList"%>
<%@page import="com.study.common.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>상품 상세보기</title>
<style>
.btn-basic-area { padding-top: 10px; border-top: 1px dashed;  text-align: center; }
.btn-basic-area span {padding: 10px 30px 10px; min-width: 100px;}
</style>
</head>
<body>

<%
	ProdVO prod = ProductList.getProduct(request.getParameter("prodId")); 
	request.setAttribute("prod", prod);
%>

<div class="container">
<h3>상품 상세보기</h3>
<table class="prod-list">
	<caption>상품 상세보기</caption>
	<colgroup>
		<col style="width: 25%;">
		<col />
	</colgroup>
	<tbody class="prod-detail">
		<tr>
			<td>제품명</td>			
			<td>${prod.prodName }</td>
		</tr>	
		<tr>
			<td>이미지</td>			
			<td><img alt="" src=<%=request.getContextPath()%>${prod.prodImg }></td>
		</tr>	
		<tr>
			<td>가격</td>			
			<td>${prod.prodPrice }</td>
		</tr>
		<tr>
			<td>등록일</td>			
			<td>${prod.prodRegDate }</td>
		</tr>
		<tr>
			<td>상세설명</td>			
			<td>${prod.prodDetail }</td>
		</tr>
	</tbody>
</table>

<div class="btn-basic-area" >
	<span><a href="/study/index.jsp" >Home</a> </span>
	<span><a href="prodList.jsp" >상품목록</a> </span>
</div>

</div><!-- container -->
</body>
</html>

```

#### 01jstlForList
```js
<%@page import="com.study.common.util.UserList"%>
<%@page import="com.study.login.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<%
	List<UserVO> userList = new UserList().getUserList();
	request.setAttribute("userList", userList); 
%>

varStatus에서 사용가능한 것들 : index, count, begin, end, current, first, last
<c:forEach items="${userList }" var="user" varStatus="status">
${user.userId } ${user.userPass } ${status.count }<br> 

<c:if test="${status.first }">처음에만 실행됨</c:if>
<c:if test="${status.last }">마지막에만 실행됨</c:if>
				<!-- 
	varStatus에서 사용가능한 것들 : index, count, begin, end, current, first, last nolja 1004 1
	처음에만 실행됨 areum 0000 2
	malja 1004 3
	sunja 1111 4
	milkis 1004 5
	마지막에만 실행됨
				 -->
 </c:forEach>



</body>
</html>
```

#### 01jstlUrl
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<img alt="aa" src="<c:url value='/resource/images/cat1.jpeg'/>">


</body>
</html>
```

#### 02jstlRedirect
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<!-- 01jstlUrl.jsp 페이지 실행 -->
<c:redirect url="01jstlUrl.jsp"></c:redirect>

</body>
</html>
```

#### 03jstlCatch
```js
<%@page import="com.study.common.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<c:catch var="ex">
	<%
		ProdVO prod=null; 
		prod.getProdDetail(); 
	%>
</c:catch>
<c:if test="${ex !=null }">에러가 났다</c:if>

</body>
</html>
```
#### 04jstlFmt
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<fmt:bundle basename="resource.message">
	<fmt:message key="name"></fmt:message>
	<fmt:message key="info">
		<fmt:param value="manager"></fmt:param>
		<fmt:param value="malja"></fmt:param>
		<fmt:param value="말자"></fmt:param>
	</fmt:message>
</fmt:bundle>

<!-- 페이지를 따로 안 만들어도 됨 -->
<a href="04localeChange.jsp?lang=jp">일본어</a>
<a href="04localeChange.jsp?lang=ko">한국어</a>
<a href="04localeChange.jsp?lang=en">영어</a>



</body>
</html>
```

#### 04localChange
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>
<%
	String lang = request.getParameter("lang"); 
%>
${param.lang }


<fmt:setLocale value="${param.lang }" scope="session"/>
페이지 : <%=request.getHeader("Referer") %> <br>

<c:redirect url='<%=request.getHeader("Referer") %>'></c:redirect>

</body>
</html>
```

## 📚 13일차

## SQL 부분

#### number 면 int  그외는 String 
```sql
select 
'private ' 
|| decode(a.data_type, 'NUMBER', 'int ', 'String ')
|| lower(substr(a.column_name,1,1)) 
|| substr(replace(initcap(a.column_name),'_',''),2) 
from user_tab_cols a
where a.table_name ='MEMBER'; 

select b.comments
from user_col_comments b
where b.table_name='MEMBER'; 

```
#### VO생성쿼리
```
select rpad('private ' 
|| decode(a.data_type, 'NUMBER', 'int ', 'String ')
|| lower(substr(a.column_name,1,1)) 
|| substr(replace(initcap(a.column_name),'_',''),2) 
|| ';', 40)
|| nvl2(b.comments,'/*' || b.comments || '*/','')
from user_tab_cols a, user_col_comments b
where a.table_name =upper(:TB)
and a.table_name = b.table_name
and a.column_name = b.column_name ; 

```

## jsp 부분

#### src – com.study.member.vo – MemberVO.java
```
package com.study.member.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MemberVO {
	private String memId;                   /*회원아이디*/
	private String memPass;                 /*회원비밀번호*/
	private String memName;                 /*회원이름*/
	private String memBir;                  /*회원생일*/
	private String memZip;                  /*회원우편번호*/
	private String memAdd1;                 /*회원주소*/
	private String memAdd2;                 /*회원상세주소*/
	private String memHp;                   /*회원전화번호*/
	private String memMail;                 /*회원이메일*/
	private String memJob;                  /*회원직업*/
	private String memLike;                 /*회원취미*/
	private int memMileage;                 /*회원마일리지*/
	private String memDelYn;                /*회원삭제여부*/
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemBir() {
		return memBir;
	}
	public void setMemBir(String memBir) {
		this.memBir = memBir;
	}
	public String getMemZip() {
		return memZip;
	}
	public void setMemZip(String memZip) {
		this.memZip = memZip;
	}
	public String getMemAdd1() {
		return memAdd1;
	}
	public void setMemAdd1(String memAdd1) {
		this.memAdd1 = memAdd1;
	}
	public String getMemAdd2() {
		return memAdd2;
	}
	public void setMemAdd2(String memAdd2) {
		this.memAdd2 = memAdd2;
	}
	public String getMemHp() {
		return memHp;
	}
	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public String getMemJob() {
		return memJob;
	}
	public void setMemJob(String memJob) {
		this.memJob = memJob;
	}
	public String getMemLike() {
		return memLike;
	}
	public void setMemLike(String memLike) {
		this.memLike = memLike;
	}
	public int getMemMileage() {
		return memMileage;
	}
	public void setMemMileage(int memMileage) {
		this.memMileage = memMileage;
	}
	public String getMemDelYn() {
		return memDelYn;
	}
	public void setMemDelYn(String memDelYn) {
		this.memDelYn = memDelYn;
	} 



}


``` 

#### 01memberList.jsp

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.study.member.vo.MemberVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="oracle.jdbc.driver.OracleDriver"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<%
	

	try{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
	}catch(ClassNotFoundException e){
		
	}
	
	Connection conn=null; 
	Statement stmt=null;
	ResultSet rs=null;
	try{
		
	//DB연결
	conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jsp","oracle");
	
	//쿼리 생성
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select mem_id, mem_name from member"); 

	%>
	<% 
	List<MemberVO> memberList= new ArrayList<MemberVO>();
	while(rs.next()){
		MemberVO member = new MemberVO();
		member.setMemId(rs.getString("mem_id"));
		member.setMemName(rs.getString("mem_name"));
		memberList.add(member); 
	}
	request.setAttribute("memberList", memberList); 
	}catch(SQLException e){
		e.printStackTrace(); 
	}finally{
	if(conn!=null){conn.close();}
	if(stmt!=null){stmt.close();}
	if(rs!=null){rs.close();}
	}
%>
<table class="table table border">
	
	<c:forEach items="${memberList }" var="member">
		${member.memId } ${member.memName }
	</c:forEach>


</table>


</body>
</html>
```

