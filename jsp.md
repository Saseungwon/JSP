
# ๐ดโโ๏ธ JSP

## ๐ 1์ผ์ฐจ
#### <%= %> (๊ธฐ๋ณธ์ ์ธ ์ถ๋ ฅ)
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

#### ์๋ฐ์ ๋ฌธ๋ฒ๊ณผ ์๋ฐ์คํฌ๋ฆฝํธ์ ํ๊ทธ ์ฌ์ฉ ๊ฐ๋ฅ
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
	if(param.equals("์ฌ์น์")) {
%>
	<h1> ์ฌ์น์	<h1>	
<%
	}else{
%>
	<h1> ์์น์ฌ	 <h1>	
<%
	}
%>
</body>
</html>
```

####  1๋ถํฐ 10๊น์ง์ ํฉ
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
<h1>1๋ถํฐ 10๊น์ง์ ํฉ</h1>
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

<!-- 'out.print'์ '=' ์ ๊ฐ์ -->
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
	<input type="text" value="" name="ํ๊ธ">
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
<!-- pageEncoding์ jsp ์์คํ์ผ encoding ๋ฐฉ๋ฒ
	 contentType์ charset์ ์๋ฒ๊ฐ ๋ธ๋ผ์ฐ์ ๋ก ๋ณด๋ผ ๋ encoding๋ฐฉ๋ฒ
 -->
<%-- <%request.setCharacterEncoding("utf-8");%> --%>
<!-- ์๋ฒ๊ฐ ๋ธ๋ผ์ฐ์ ๋ก๋ถํฐ ๋ฐ์ ๋ฐ์ดํฐ ๋์ฝ๋ฉ๋ฐฉ๋ฒ -->
<title>a3Time.jsp</title>
</head>
<body>
	ํ์ฌ ์๊ฐ : <%=new Date() %><br> <br>
	ํ๋ผ๋ฏธํฐ : <%= request.getParameter("ํ๊ธ") %> <br> <br>
	ํ๋ผ๋ฏธํฐ2 : <%= request.getParameter("text") %> <br> <br>
	
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
<h3>์๋ ํญ๋ชฉ์ ๋ต๋ณํด์ฃผ์ธ์</h3>
<form action="04result.jsp" method="post">
์ด ๋ฐ์์ ๊ฐ์ฅ ์ฐฉํ ์ฌ๋ : <input type="text" name="kind" value=""> <br>
์ด ๋ฐ์์ ๊ฐ์ฅ ๋์ ์ฌ๋ : <input type="text" name="bad" value=""> <br>
<button type="submit">์ ์ถ</button>
</form>
<hr>
<%
	String app_path = request.getContextPath();
	out.println(app_path+"<br>");
%>
๊ณ ์์ด1 <img alt="cat1" src="../resource/images/cat1.jpeg" width="50px" height="50px"> <br>
๊ณ ์์ด2 <img alt="cat2" src="/study/resource/images/cat1.jpeg" width="50px" height="50px"> <br>
๊ณ ์์ด3 <img alt="cat3" src="<%=request.getContextPath() %>/resource/images/cat1.jpeg" width="50px" height="50px"> <br>
๊ณ ์์ด4 <img alt="cat4" src="http://localhost:8080/study/resource/images/cat1.jpeg" width="50px" height="50px">
</body>
</html>
```

#### 04Result
```js
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- ์ธ์ฝ๋ฉ ์ค์! -->
    <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/result.jsp</title>
</head>
<body>
<h1>ํด๋ผ์ด์ธํธ์ ๋ณด, ํค๋์ ๋ณด, ํ๋ผ๋ฏธํฐ์ ๋ณด</h1> <br><br><br>
<h3>ํด๋ผ์ด์ธํธ์ ๋ณด</h3>
IP 	 	: <%=request.getRemoteAddr() %>  <br>
์น ๊ฒฝ๋ก : <%=request.getContextPath() %> <br>
URL	   : <%=request.getRequestURI() %> <br>
URI		: <%=request.getRequestURI() %> <br>

<h3>ํ๋ผ๋ฏธํฐ</h3>
kind : <%=request.getParameter("kind") %> <br>
bad : <%=request.getParameter("bad") %> <br>
<h3>๋ชจ๋  ํค๋๋ณด๊ธฐ</h3>
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
	์ซ์ 1 <input type="text" name="num1" value=""> <br>
	์ซ์ 2 <input type="text" name="num2" value=""> <br>
	<button type="submit">๊ณ์ฐ</button>
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
์ซ์1 : <%= request.getParameter("num1") %>
์ซ์2 : <%= request.getParameter("num2") %>

<%
	try{
		int pNum1 = Integer.parseInt(request.getParameter("num1"));
		int pNum2 = Integer.parseInt(request.getParameter("num2"));
		int sum = pNum1 + pNum2;
		out.print("<br> ํฉ : " +  sum);
	} catch(Exception e){
		out.print("์ซ์๋ง ์๋ ฅํ์ธ์");
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
	String name="๋ง ์ ๋ฃ๋ ํ์1";
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
	return "์ฐฉํ ํ์";
}
%>

</body>
</html>
```

## ๐ 2์ผ์ฐจ

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
	<input type="submit" value="์์" name="out">
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
	if(param.equals("์์")){
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
	ํ๊ธ : <input type="text" value="" name="ํ๊ธ">
	english : <input type="text" value="" name="english">
	<input type="submit" value="ํ๊ธ์ด ์ ๋์ต๋๋ค">
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
ํ๊ธ : <%=request.getParameter("ํ๊ธ") %>
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
	private String field="fx ๋!";
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
	setField("์๋ฐ ์ด๋ ค์");
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
			sb.append("<td>"+i+"๋จ</td>");
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
## ๐ 3์ผ์ฐจ
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
	์ด๋ฆ<input type="text" value="" name="name"> <br>
	๋์ด<input type="text" value="" name="age"> <br>
	์ทจ๋ฏธ <br>
	๋ณผ๋ง<input type="checkbox" value="๋ณผ๋ง" name="hobby"> <br>
	๊ฒ์<input type="checkbox" value="๊ฒ์" name="hobby"> <br>
	๋ณต์<input type="checkbox" value="๋ณต์" name="hobby"> <br>
	ํผ์๋ธ<input type="checkbox" value="ํผ์๋ธ" name="hobby"> <br>
	
	์ฃผ์<input type="text" value="" name="address"> <br>
	<button type="submit">์๊ธฐ์๊ฐ</button>
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
	์ด๋ฆ<input type="text" value="" name="name"> <br>
	๋์ด<input type="text" value="" name="age"> <br>
	์ทจ๋ฏธ <br>
	๋ณผ๋ง<input type="checkbox" value="๋ณผ๋ง" name="hobby">
	๊ฒ์<input type="checkbox" value="๊ฒ์" name="hobby">
	๋ณต์<input type="checkbox" value="๋ณต์" name="hobby">
	ํผ์๋ธ<input type="checkbox" value="ํผ์๋ธ" name="hobby"> <br>
	
	์ฃผ์<input type="text" value="" name="address"> <br>
	<button type="submit">์๊ธฐ์๊ฐ</button>
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
์ด๋ฆ : <%=request.getParameter("name") %>
๋์ด : <%=request.getParameter("age") %>
์ทจ๋ฏธ :
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
์ฃผ์ : <%=request.getParameter("address") %>
<hr>
ํ๋ผ๋ฏธํฐ๋ค
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
<!-- ์ธ์ฝ๋ฉ์ ๋ฐ๋ผ ๊ฐ์ ์์ด๋ฌธ์์ฌ๋ ์ฐจ์งํ๋ ํฌ๊ธฐ๊ฐ ๋ค๋ฅด๋ค -->
		<!--
		๋ฒํผ์ฌ์ด์ฆ
		๋จ์๋ฒํผ
		์๋ํ๋ฌ์
		ํ๋ฌ์
		ํด๋ฆฌ์ด๋ฒํผ -->
		out.clearBuffer();
		out.flush();
		out.clear();		
<ul>
	<li> ๋ฒํผ์ฌ์ด์ฆ : <%=out.getBufferSize() %>
	<li> ๋จ์ ๋ฒํผ : <%=out.getRemaining() %>
	<li> ์๋ํ๋ฌ์์ฌ๋ถ : <%=out.isAutoFlush() %>
</ul>

<%
	long startTime=System.currentTimeMillis();
	for(int i=0; i<1000; i++){
		out.print("์ผ");
		out.print("์ด");
		out.print("์ผ");
		out.print("์ฌ");
		out.print("์ค");
		out.print("์ก");
 		//out.clearBuffer(); //๋ด์ฉ์ ์ง์
		//out.flush();//๋ค ์ฐจ์ง ์์์ด๋ ๋ณด๋(๋๋ ค์ ์ ์ ์)
		//out.clear();//๋ด์ฉ์ ์ง์ */
	}
	out.print("<hr>");
	long endTime=System.currentTimeMillis();
	out.print((endTime-startTime)+"์ด");
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
<title>๊ธฐ๋ณธ๊ฐ์ฒด pageContext</title>
</head>
<body>

<%
	if(pageContext.getRequest()==request){
		out.print("๊ฐ๋ค");
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
	์์์ ์ค์ ๊ฒฝ๋ก :
	<br>
	<%=application.getRealPath(resourcePath) %>
	<hr>
	<br>
	<%=resourcePath %>์ ๋ด์ฉ
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
์ค๋ ์ ์ฌ์ ํ์ฅ
์ค๋ ์ ์ฌ์ ์ก๊ฐ์ฅ
์ ๋์ ๋ง์๋ ๊ฑฐ
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
<!-- application ๋ชจ๋  ์์ฑ ์ฝ๊ธฐ -->
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
  	<param-value>ํ์ฐฝํฌ</param-value>
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




## ๐ 4์ผ์ฐจ

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
<!-- application ๋ชจ๋  ์์ฑ ์ฝ๊ธฐ -->
<%
	Enumeration<String> apEnum = application.getAttributeNames();
	while(apEnum.hasMoreElements()) {
		String attributeName = apEnum.nextElement();
		Object attributeValue = application.getAttribute(attributeName);
		out.print("application ์์ฑ : " + attributeName + " : " + attributeValue + "<br>");
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
	application.setAttribute("ํฉ๋ฏธ์ ", 21);	// 	๋ ํผํด๋์ค๋ฅผ ๊ฐ์ธ
 	application.setAttribute("์คํ์", 23);
 	application.setAttribute("๊ณ ์ฐฝ์", 25);
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
		request.setAttribute("์์์ง", "์นญ๊ตฌ");
	List<Integer> arr1 = new ArrayList<Integer>();
	arr1.add(1);
	arr1.add(2);
	arr1.add(3);
	request.setAttribute("๊ด์ ", arr1);
	%>
	<br>
	<br>
	<%
		List<Integer> arr = (List<Integer>) (request.getAttribute("๊ด์ "));
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
<title>application ๊ธฐ๋ณธ ๊ฐ์ฒด ์ฌ์ฉํ์ฌ ์์ ์ฝ๊ธฐ</title>
</head>
<body>
	๋ฆฌ์คํธ 1, 2 ๊ต์งํฉ ์ฐจ์งํฉ ํฉ์งํฉ ๋ฆฌ์คํธ ๋ง๋ค๊ณ  ์ถ๋ ฅํด๋ณด๊ธฐ

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
	
	kyo.addAll(List1); //List1 ๊ฐ ๋ค ๋ํ๊ธฐ
	kyo.retainAll(List2); //๋ฆฌ์คํธ2์ ์๋ ๊ฐ ๋นผ๊ธฐ
	
	cha.addAll(List1); // kyo List1 ์์๊ฐ ๊ฐ์
	cha.removeAll(List2); //๋ฆฌ์คํธ2์ ์๋ ๊ฐ ๋นผ๊ธฐ
	
	hap.addAll(cha);
	hap.addAll(List2);
	hap.sort(Comparator.naturalOrder());
	/* hap.sort(null); */
	Collections.sort(hap);
	
	//kyo     cha     hap์ setAttributeํ๊ณ 
	//retain addAll remove
	
	request.setAttribute("kyo", kyo);
	request.setAttribute("cha", cha);
	request.setAttribute("hap", hap);
%>

kyo	<%=request.getAttribute("kyo")%><br>
<!-- List๊ฐ ๋ฌธ์์ด๋ก ์ถ๋ ฅ๋จ -->
cha	<%=request.getAttribute("cha")%><br>
hap	<%=request.getAttribute("hap")%><br>
</body>
</html>
```

#### 02errorMain
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- ์๋ฌ ๋ฐ์์ ๋ณด์ฌ์ค ํ์ด์ง ์ง์ ํด์ค -->
    
 <%@ page errorPage="02errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>์๋ฌ๋ฐ์ ์์ผ๋ณด๊ธฐ</title>
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
    
    <!-- ์๋ฌ ๋ฐ์์ ๋ณด์ฌ์ค ํ์ด์ง ์ง์ ํด์ค -->
    
 <%@ page errorPage="02errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>์๋ฌ๋ฐ์ ์์ผ๋ณด๊ธฐ</title>
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

100 : ํด๋น ์์ฒญ์ ์งํ์ค <br>
200 : ์์ฒญ์ ์ ์์ ์ผ๋ก ์ฒ๋ฆฌ ํ์ <br>
300 : ์์ฒญ์ ์ ๋ณด๊ฐ ๋ณ๊ฒฝ๋์์ <br>
400 : ์๋ชป๋ ์์ฒญ(404, 401, 403) <br>
500 : ๋ด๋ถ ์๋ฒ ์ค๋ฅ(์๋ฒ ํ๋ก๊ทธ๋จ์ ์ค๋ฅ) <br><br>

์๋ฌํ์ด์ง ์ฐ์  ์์ <br>
1. ๋๋ ํฐ๋ธ ํ์ด์ง errorpage   <%-- <%@ page errorPage="02mypage.jsp" %> --%><br>
2. exception-type <br>
3. ์๋ต ์ํ์ฝ๋ <br>

<form action="02mypage.jsp">
๋์ด : <input type="number" name="age" min="10" max="99"><br>
<button type="submit">์ ์ถ</button>
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
<h1> ์ฃผ๋ง์ด๋ค
	์ฑ์ฌ๋น ๊ฐ์ผ์ง
</h1>

<%out.flush(); %>

<%
	int age = Integer.parseInt(request.getParameter("age"));
if(age > 50) {
	throw new IndexOutOfBoundsException();
}else if(age%2==0) { //์ง์๋ฉด ์๋ฌ
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

03main 	์ 
<%@ include file="03sub.jsp" %>
<jsp:include page="03sub.jsp" /> <!-- ๋ฐ๋ณต๋๋ ๋ถ๋ถ์ subํ์ผ๋ก ๋ง๋ค๊ณ  main์ ์ฝ์ -->
03main		ํ

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
<h1>sub์ ๋ง๋ค์ด์ง ๋ด์ฉ</h1>
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
<p>sub์ </p>
<!-- url์ ? name ํ์ฐฝํฌ ๋ฃ์ด๋ณด์  -->
<jsp:include page="04sub.jsp">
	<jsp:param value="ํ์ฐฝํฌ" name="name"/>
	<jsp:param value="30" name="age"/>
</jsp:include>		<!-- jsp์ธํด๋ฃจ๋ ์ฌ์ด์ ์ฃผ์ ๋ชป ๋ค์ด๊ฐ๋ค. -->

<p>sub ํ</p>
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

์ด๋ฆ : <%=request.getParameter("name") %>
๋์ด : <%=request.getParameter("age") %>
ํ์  : <%=request.getParameter("taejeong") %>

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
		<h3>์ฑ์ฌ๋น ์ข์์</h3>
		<form action="05other.jsp">
			๋์ด : <input type="number" name="age" min="10" max="99"> <br>
			<button type="submit">์ ์ถ</button>
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
	String res = "์ ๊ธฐ";
	if(age < 20){
		res = "์ฒญ์๋";
		list.add("๋ก์ ");
		list.add("๋ค๋ฏธ");
	}else if(age < 30){
		res = "์ฒญ๋";
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
	}else{
		res = "๋ธ์ธ๋ค";
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
	}
	request.setAttribute("hate", list);
%>
<p>jsp include ์คํ์ </p>
<jsp:include page="05otherinclude.jsp">
	<jsp:param value="<%=res %>" name="res"/>
	<jsp:param value="<%=age %>" name="age"/>
</jsp:include>

<p> jsp include ์คํ ํ </p>
์ ๋๋ฉ๋ด : <%=request.getAttribute("dinnerMenu") %>

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
		request.setAttribute("dinnerMenu", "์ฒญ๊ตญ์ฅ");
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
	๋ค์ -> ์ง์
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
		body,th,td,input,select,textarea,button{font-size:12px;line-height:1.5;font-family:AppleSDGothicNeo-Regular,'Malgun Gothic','๋ง์ ๊ณ ๋',dotum,'๋์',sans-serif;color:#222;letter-spacing:-0.5px}
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
		
		/*** ๋ ํฐ๋ ๋์ ***/
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
				<h2 class="tit_error">์๋ ฅ๊ฐ์ <span class="emph_txt">๋ฌธ์ ๊ฐ ์์ต๋๋ค.</span></h2>
		<p class="desc_error">
			IndexOutOfBoundsException<br>
			๋ฐฉ๋ฌธ ์ํ์๋ ํ์ด์ง์ ์ฃผ์๊ฐ ์๋ชป ์๋ ฅ๋์๊ฑฐ๋,<br>
			๋ณ๊ฒฝ ํน์ ์ญ์ ๋์ด ์์ฒญํ์  ํ์ด์ง๋ฅผ ์ฐพ์ ์๊ฐ ์์ต๋๋ค.
		</p>
		<p class="desc_error">
			์๋ ฅํ์  ํ์ด์ง์ ์ฃผ์๊ฐ ์ ํํ์ง ๋ค์ ํ๋ฒ ํ์ธํด ์ฃผ์๊ธฐ ๋ฐ๋๋๋ค.
		</p>
		<p class="desc_error">
			๊ด๋ จํด <a href="http://cs.daum.net/" class="link_cs">๊ณ ๊ฐ์ผํฐ</a>๋ก ๋ฌธ์ํด ์ฃผ์๋ฉด ์น์ ํ๊ฒ ์๋ดํด ๋๋ฆฌ๊ฒ ์ต๋๋ค.
		</p>
				<h3 class="screen_out">๊ฒ์</h3>
		<div class="wrap_form">
			<form action="http://search.daum.net/search">
				<fieldset>
					<legend class="screen_out">๊ฒ์์ด ์๋ ฅํผ</legend>
					<div class="wrap_inp">
						<label for="inpSearch" id="searchLabel" class="lab_search">ํตํฉ๊ฒ์</label>
						<input type="text" id="inpSearch" class="inp_search" name="q" autocomplete="off" spellcheck="false" />
						<button type="submit" class="img_error btn_search">๊ฒ์</button>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="info_link">
			<a href="http://www.daum.net/" class="link_error">๋ฉ์ธํ๋ฉด</a>
			<a href="http://cs.daum.net/" class="link_error ">๊ณ ๊ฐ์ผํฐ</a>
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
    <%@ page isErrorPage="true" %>            <!-- ์ด๊ฑฐ ์ง์ฐ๊ณ  web.xml์ ์ค์ ํ๋๊ฑฐ ๋์ค์  -->    
<%--
	Daum -> Jiwon
	๋ค์ -> ์ง์
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
		body,th,td,input,select,textarea,button{font-size:12px;line-height:1.5;font-family:AppleSDGothicNeo-Regular,'Malgun Gothic','๋ง์ ๊ณ ๋',dotum,'๋์',sans-serif;color:#222;letter-spacing:-0.5px}
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
		
		/*** ๋ ํฐ๋ ๋์ ***/
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
				<h2 class="tit_error">์ํ์๋ ํ์ด์ง๋ฅผ <span class="emph_txt">์ฐพ์ ์๊ฐ ์์ต๋๋ค.404</span></h2>
		<p class="desc_error">
			๋ฐฉ๋ฌธ ์ํ์๋ ํ์ด์ง์ ์ฃผ์๊ฐ ์๋ชป ์๋ ฅ๋์๊ฑฐ๋,<br>
			๋ณ๊ฒฝ ํน์ ์ญ์ ๋์ด ์์ฒญํ์  ํ์ด์ง๋ฅผ ์ฐพ์ ์๊ฐ ์์ต๋๋ค.
		</p>
		<p class="desc_error">
			์๋ ฅํ์  ํ์ด์ง์ ์ฃผ์๊ฐ ์ ํํ์ง ๋ค์ ํ๋ฒ ํ์ธํด ์ฃผ์๊ธฐ ๋ฐ๋๋๋ค.
		</p>
		<p class="desc_error">
			๊ด๋ จํด <a href="http://cs.daum.net/" class="link_cs">๊ณ ๊ฐ์ผํฐ</a>๋ก ๋ฌธ์ํด ์ฃผ์๋ฉด ์น์ ํ๊ฒ ์๋ดํด ๋๋ฆฌ๊ฒ ์ต๋๋ค.
		</p>
				<h3 class="screen_out">๊ฒ์</h3>
		<div class="wrap_form">
			<form action="http://search.daum.net/search">
				<fieldset>
					<legend class="screen_out">๊ฒ์์ด ์๋ ฅํผ</legend>
					<div class="wrap_inp">
						<label for="inpSearch" id="searchLabel" class="lab_search">ํตํฉ๊ฒ์</label>
						<input type="text" id="inpSearch" class="inp_search" name="q" autocomplete="off" spellcheck="false" />
						<button type="submit" class="img_error btn_search">๊ฒ์</button>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="info_link">
			<a href="http://www.daum.net/" class="link_error">๋ฉ์ธํ๋ฉด</a>
			<a href="http://cs.daum.net/" class="link_error ">๊ณ ๊ฐ์ผํฐ</a>
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
		body,th,td,input,select,textarea,button{font-size:12px;line-height:1.5;font-family:AppleSDGothicNeo-Regular,'Malgun Gothic','๋ง์ ๊ณ ๋',dotum,'๋์',sans-serif;color:#222;letter-spacing:-0.5px}
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
		
		/*** ๋ ํฐ๋ ๋์ ***/
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
				<h2 class="tit_error">๋ด๋ถ ์๋ฒ ์ค๋ฅ <span class="emph_txt">๊ฐ ์์ต๋๋ค.</span></h2>
		<p class="desc_error">
			ClassCastException<br>
			๋ฐฉ๋ฌธ ์ํ์๋ ํ์ด์ง์ ์ฃผ์๊ฐ ์๋ชป ์๋ ฅ๋์๊ฑฐ๋,<br>
			๋ณ๊ฒฝ ํน์ ์ญ์ ๋์ด ์์ฒญํ์  ํ์ด์ง๋ฅผ ์ฐพ์ ์๊ฐ ์์ต๋๋ค.<br>
			๋ฉ์์ง : <%=exception.getMessage() %>
			์์ธํ์ : <%= exception.getClass().getName() %>
		</p>
		<p class="desc_error">
			์๋ ฅํ์  ํ์ด์ง์ ์ฃผ์๊ฐ ์ ํํ์ง ๋ค์ ํ๋ฒ ํ์ธํด ์ฃผ์๊ธฐ ๋ฐ๋๋๋ค.
		</p>
		<p class="desc_error">
			๊ด๋ จํด <a href="http://cs.daum.net/" class="link_cs">๊ณ ๊ฐ์ผํฐ</a>๋ก ๋ฌธ์ํด ์ฃผ์๋ฉด ์น์ ํ๊ฒ ์๋ดํด ๋๋ฆฌ๊ฒ ์ต๋๋ค.
		</p>
				<h3 class="screen_out">๊ฒ์</h3>
		<div class="wrap_form">
			<form action="http://search.daum.net/search">
				<fieldset>
					<legend class="screen_out">๊ฒ์์ด ์๋ ฅํผ</legend>
					<div class="wrap_inp">
						<label for="inpSearch" id="searchLabel" class="lab_search">ํตํฉ๊ฒ์</label>
						<input type="text" id="inpSearch" class="inp_search" name="q" autocomplete="off" spellcheck="false" />
						<button type="submit" class="img_error btn_search">๊ฒ์</button>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="info_link">
			<a href="http://www.daum.net/" class="link_error">๋ฉ์ธํ๋ฉด</a>
			<a href="http://cs.daum.net/" class="link_error ">๊ณ ๊ฐ์ผํฐ</a>
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
	๋ค์ -> ์ง์
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
		body,th,td,input,select,textarea,button{font-size:12px;line-height:1.5;font-family:AppleSDGothicNeo-Regular,'Malgun Gothic','๋ง์ ๊ณ ๋',dotum,'๋์',sans-serif;color:#222;letter-spacing:-0.5px}
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
		
		/*** ๋ ํฐ๋ ๋์ ***/
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
				<h2 class="tit_error">์๋ ฅ๊ฐ์ <span class="emph_txt">๋ฌธ์ ๊ฐ ์์ต๋๋ค.</span></h2>
		<p class="desc_error">
			IndexOutOfBoundsException<br>
			๋ฐฉ๋ฌธ ์ํ์๋ ํ์ด์ง์ ์ฃผ์๊ฐ ์๋ชป ์๋ ฅ๋์๊ฑฐ๋,<br>
			๋ณ๊ฒฝ ํน์ ์ญ์ ๋์ด ์์ฒญํ์  ํ์ด์ง๋ฅผ ์ฐพ์ ์๊ฐ ์์ต๋๋ค.
		</p>
		<p class="desc_error">
			์๋ ฅํ์  ํ์ด์ง์ ์ฃผ์๊ฐ ์ ํํ์ง ๋ค์ ํ๋ฒ ํ์ธํด ์ฃผ์๊ธฐ ๋ฐ๋๋๋ค.
		</p>
		<p class="desc_error">
			๊ด๋ จํด <a href="http://cs.daum.net/" class="link_cs">๊ณ ๊ฐ์ผํฐ</a>๋ก ๋ฌธ์ํด ์ฃผ์๋ฉด ์น์ ํ๊ฒ ์๋ดํด ๋๋ฆฌ๊ฒ ์ต๋๋ค.
		</p>
				<h3 class="screen_out">๊ฒ์</h3>
		<div class="wrap_form">
			<form action="http://search.daum.net/search">
				<fieldset>
					<legend class="screen_out">๊ฒ์์ด ์๋ ฅํผ</legend>
					<div class="wrap_inp">
						<label for="inpSearch" id="searchLabel" class="lab_search">ํตํฉ๊ฒ์</label>
						<input type="text" id="inpSearch" class="inp_search" name="q" autocomplete="off" spellcheck="false" />
						<button type="submit" class="img_error btn_search">๊ฒ์</button>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="info_link">
			<a href="http://www.daum.net/" class="link_error">๋ฉ์ธํ๋ฉด</a>
			<a href="http://cs.daum.net/" class="link_error ">๊ณ ๊ฐ์ผํฐ</a>
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
  	<param-value>ํ์ฐฝํฌ</param-value>
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
   <!-- ์๋ฌ ํ์ด์ง  -->

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

## ๐ ๋ณต์ต ์ ๋ฆฌ

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
		์ฌ๋<input type="text" name="person" value="">
		๋์ด<input type="text" name="age" value="">  
		<input type="submit">
	</form>
	
	<img alt="์ด๋ฏธ์ง๊ฐ ์์ต๋๋ค" src="/study/resource/images/cat1.jpeg" width="100" height="100">
	<img alt="์ด๋ฏธ์ง๊ฐ ์์ต๋๋ค" src="<%=request.getContextPath()%>/resource/images/cat1.jpeg" width="100" height="100">
	

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

๋ธ๋ผ์ฐ์ ธ			: <%= request.getHeader("User-Agent") %> <br>
ํ์ด์ง			: <%= request.getHeader("Referer") %> <br>	

ํ๋ผ๋ฏธํฐ ์ ๋ณด
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
	String name = "๊น์๋ฏผ";
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
	String name = "๊น์๋ฏผ";
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
		<input type="text" name="ํ๊ธ">
		<input type="text" name="eng">
		<button type="submit">ํ๊ธ์์ด ์ธ์ฝ๋ฉ</button>
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
ํ๊ธ <%=request.getParameter("ํ๊ธ") %> <br>
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
			sb.append("<td>"+i+"๋จ</td>");
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
	1๋ฑ<input type="text" name="a"> <br>
	๊ฒฐ์์<input type="text" name="b"> <br>
	์ง๊ฐ์: ์ฌ์น1 <input type="checkbox" name="c" value="์ฌ์น1">
		 	์ฌ์น2 <input type="checkbox" name="c" value="์ฌ์น2">
		 	์ฌ์น3 <input type="checkbox" name="c" value="์ฌ์น3">
		 	<!--  value="" ์ ์ฐ๋ฉด on์ผ๋ก ๋์ด -->
	<input type="submit" value="์ ์ถ">
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
1๋ฑ : <%=request.getParameter("a") %> <br>
๊ฒฐ์์ : <%=request.getParameter("b") %> <br>
์ทจ๋ฏธ : 
<%

	Map parameters = request.getParameterMap();
	String[] lates=(String[])parameters.get("c"); 
	if(lates !=null){
		for(String late:lates){
			out.print(late+ "    ");
		}
	} 
	
/* 	์ด๋ฐ ์์ผ๋ก๋ ๊ฐ๋ฅ
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

๋ฒํผ์ฌ์ด์ฆ			:<%=out.getBufferSize() %> <br>
๋จ์๋ฒํผ				:<%=out.getRemaining() %> <br>
์๋ํ๋ฌ์์ฌ๋ถ		:<%=out.isAutoFlush() %> <br>

<!-- flush, clear, clearbuffer -->
<%
	for(int i=0; i<1000; i++){
		out.print("๋ฒํผ๋?");
		if(i==1000){
			out.flush();
			out.clear();
		}
	}
%> <br>
๋จ์๋ฒํผ				:<%=out.getRemaining() %> <br>
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
JSP ํ์ด์ง์์ ๋ค๋ฅธ ๋ด์ฅ๊ฐ์ฒด๋ฅผ ์ป๊ฑฐ๋
ํ๋์ ํ์ด์ง์์ ๋ค๋ฅธ ํ์ด์ง๋ก ์ ์ด๊ถ ๋ฑ์
๋๊ฒจ์ค ๋ ์ฌ์ฉํ๋ ๋ด์ฅ ๋ณ์๋ ๋ฌด์์ธ๊ฐ
- ํ์ด์ง์ปจํ์คํธ ๊ฐ์ฒด
<br>
<% 
	HttpServletRequest pageRequest = (HttpServletRequest)pageContext.getRequest();
	out.print(pageRequest==request);
%> <br>



WAS์์ ๊ณต์ ํ๋ ๊ฐ์ฒด
WAS์ ์ค์  ์ ๋ณด๋ฅผ ๊ฐ๋ context์ ๊ด๋ จ์ด ์์
WAS๊ฐ ์คํ๋๋ ์๋ฒ์ ์ค์  ์ ๋ณด ๋ฐ ์์์ ๋ํ 
์ ๋ณด๋ฅผ ์ป์ด๋ด๊ฑฐ๋ ์คํ๋๊ณ  ์๋ ๋์์ ๋ฐ์ํ  ์ ์๋
์ด๋ฒคํธ ๋ก๊ทธ ์ ๋ณด์ ๊ด๋ จ๋ ๊ธฐ๋ฅ๋ค์ ์ ๊ณตํ๋ ๊ฐ์ฒด๋? 
- ์ดํ๋ฆฌ์ผ์ด์ ๊ฐ์ฒด 
<%
	application.setAttribute("name", "์ฌ์น์");
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
	out.print("์ค์  ํ์ผ ์์น : " + application.getRealPath(filePath)+ "<br>");
	
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
์๋ฌํ์ด์ง์๋๋ค.

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
500์ ์ฝ๋๋ณ, bound๊ฐ type๋ณ

100 : ํด๋น ์์ฒญ์ ์งํ์ค 
200 : ์์ฒญ์ ์ ์์ ์ผ๋ก ์ฒ๋ฆฌ ํ์ 
300 : ์์ฒญ์ ์ ๋ณด๊ฐ ๋ณ๊ฒฝ๋์์ 
400 : ์๋ชป๋ ์์ฒญ(404, 401, 403) 
500 : ๋ด๋ถ ์๋ฒ ์ค๋ฅ(์๋ฒ ํ๋ก๊ทธ๋จ์ ์ค๋ฅ) 

<form action="08my.jsp" method="post">
	๋ผ๋ฉด <input type="text" name="ramen" value="">
	<input type="submit" value="๋ผ๋ฉด">
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
	if(ramen.equals("์ธ ์ผ๋ฉ")){
		throw new NullPointerException(); 
	}
	if(ramen.equals("๋์ฅ๋ผ๋ฉด")){
		throw new ClassCastException(); 
	}
	if(ramen.equals("์๊ธ๋ผ๋ฉด")){
		throw new IOException(); 
	}
%>
๊ธฐํ ๋ผ๋ฉด : <%=ramen %> 
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
		character="๊ธํ๋ค";
	}else if(tangType.equals("jjikmeok")){
		character="์ฌ์ธํ๋ค";
	}else{ //cheomeok
		character="๊ทธ๋ฅ ๋ผ์ง";
	}
	Map<String,String> typeCharacter = new HashMap<String, String>();
	typeCharacter.put(tangType, character);
	request.setAttribute("typeCharacter", typeCharacter);
%>
๊ฑธ๊ทธ๋ฃน : <%=girlGroup %> <br>
<jsp:include page="01otherinclude.jsp">
	<jsp:param value="<%=character %>" name="character"/>
	<jsp:param value="<%=tangType %>" name="tangType"/>
</jsp:include>
include ํ์ด์ง์์ ๋ด์ ๊ฐ<%=request.getAttribute("") %>

</body>
</html>
```

## ๐ 5์ผ์ฐจ
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
<!-- jspํ๋์์ ์ป๋ character๋ฅผ ํ๋ผ๋ฏธํฐ๋ก ๋ฐ๊ณ 
setAttributeํ๋ typeCharater๋ฅผ getAttribute๋ก ๋ฐ์์ ์ฌ์ฉ๊ฐ๋ฅ -->
<%
	String character = request.getParameter("character");
	String tangType = request.getParameter("tangType");
	Map typeCharacter = (Map<String,String>)request.getAttribute("typeCharacter");
%>
include์์ character ์ฌ์ฉ : <%=character %> <br>
include์์ Map ๊ฐ์ฒด ์ฌ์ฉ : <%=typeCharacter.get(tangType) %>
<%
	request.setAttribute("include", "include์์ ๋ด์ ๋ด์ฉ");
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

<%="ํฌํจ ์ " %> <br>
<%
	String a="asd";
%>
<%@ include file="02included.jsp" %> <br>
<%="ํฌํจ ํ" %>

</body>
</html>
```

#### 02 included
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<input type="text" name="not" value="">  <br>
02included.jsp ๋ด์ฉ

<%
	String a="";
%>
```

## ๐ 6์ผ์ฐจ
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

#### path2 โ 02viewcookie
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

<!-- ํ๋ํ๋ ๋ค ์จ์ฃผ์ง ์์๋ property="*"๋ฅผ ์ฐ๋ฉด jsp:getProperty์์ ๋ฃ์ ๊ฐ์ ์๋์ผ๋ก ๋ฃ์ด์ค -->
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
		member.setMemId("๋ฐ๋๊ฑฐ");
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
<title>์ฟ ํค ์ญ์ </title>
</head>
<body>
์ฟ ํค delete ๋ฉ์๋๊ฐ ๋ฐ๋ก ์๊ณ 
setMaxAge() ๋ผ๋ ๋ฉ์๋๋ฅผ ์ฌ์ฉ

<%
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("ssw")){
				cookie.setMaxAge(0); // 0์ผ๋ก ์ง์ ํ๋ฉด ์ฟ ํค ์ญ์ ๋จ
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
	Cookie cookie = new Cookie("han",URLEncoder.encode("์ฌ์น์","utf-8"));
	
	response.addCookie(cookie);
%>

</body>
</html>
```

#### 02modifyCookie
```js
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLEncoder"%>

์ฟ ํค ๋ณ๊ฒฝ์ ๋ฐ๋ก ์๊ณ  ๊ฐ์ ์ด๋ฆ์ ์ฟ ํค๋ฅผ ๋ง๋ค๋ฉด ๊ธฐ์กด๊ฒ์ ์ญ์ , ์๋ก์ด ๊ฒ์ผ๋ก ๋์ฒด

<html>
<head>
<title>๊ฐ ๋ณ๊ฒฝ</title>
</head>
<body>
<%
	//์ด๋ฆ์ด han์ธ ์ฟ ํค๊ฐ ์๋์ง ์๋์ง ๊ฒ์ฌํด์
	//์์ผ๋ฉด ์๋ฌด๊ฒ๋ ์ ํ๊ณ  ์์ผ๋ฉด ๊ทธ ์ฟ ํค์ ๊ฐ์ ๋ฐ๊ฟ๋ณด์ธ์
	Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("han")){
				
			
				
/* 		 	๊ฐ ๋ณ๊ฒฝ..
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

//์ฟ ํค๋ ๊ธฐ๋ณธ์ ์ผ๋ก ๋ธ๋ผ์ฐ์ ธ๋ฅผ ๋๋ฉด ์ฌ๋ผ์ง๋ค.
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
HTTP : ๋น์ฐ๊ฒฐ์ฑ, ๋ฌด์ํ

์ฟ ํค
์ฟ ํค๋ผ๋ ๊ฒ์ ๋ง๋ค์ด์ ๋ธ๋ผ์ฐ์ ธ๊ฐ ์ ์ฅ์ ํฉ๋๋ค
๋ธ๋ผ์ฐ์  ์ธก์์ ๋ญ๊ฐ๋ฅผ ํ  ์ ์๋ค.
ex : ์์ด๋ ์ ์ฅ, ๊ณต์ง์ฌํญ ์ค๋ ํ๋ฃจ ์ ๋ณด๊ธฐ
	  ์กฐํ์ ์ฆ๊ฐ ๋ฐฉ์ง
	  
๋ธ๋ผ์ฐ์ ธ ------->  ์๋ฒ
		 (์ฟ ํค)
๋ณด์๊ด๋ จ๋ ๋ด์ฉ์ ์ฟ ํค์ ์ ์ฅํ์ง ์๋๋ค.
์์ด๋, ๋น๋ฐ๋ฒํธ, ๊ทธ ์ธ ๊ฐ์ธ์ ๋ณด

๋ณด์ ๊ด๋ จ๋ ๊ฒ์ session์ ํตํด์
```


## ๐์ ๊ณต

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
	<h3>ํ์๊ฐ์</h3>		
	<form action="01memberRegist.jsp" method="post" >
	<table class="table table-striped table-bordered">
		<tbody>
			<tr>
				<th>์์ด๋</th>
				<td>
					<div class="col-xs-5">
    					<input type="text" name="memId" class="form-control" placeholder="์์ด๋๋ฅผ ์๋ ฅํ์ธ์">
 					</div>
  				</td>
			</tr>
			<tr>
				<th>๋น๋ฐ๋ฒํธ</th>
				<td><input type="password" name="memPass" class="form-control input-sm" ></td>
			</tr>	
			<tr>
				<th>ํ์๋ช</th>
				<td><input type="text" name="memName" class="form-control input-sm" ></td>
			</tr>
			<tr>
				<th>์์ผ</th>
				<td><input type="date" name="memBir" class="form-control input-sm" ></td>
			</tr>
			<tr>
				<th>ํธ๋ํฐ</th>
				<td><input type="tel" name="memHp" class="form-control input-sm" ></td>
			</tr>
			<tr>
				<th>์ง์</th>
				<td>
					<select name="memJob" class="form-control input-sm" >
						<option value="">-- ์ง์ ์ ํ --</option>
						<option value="JB01">์ฃผ๋ถ</option>
						<option value="JB02">์ํ์</option>
						<option value="JB03">๊ณต๋ฌด์</option>
						<option value="JB04">์ถ์ฐ์</option>
						<option value="JB05">ํ์ฌ์</option>
						<option value="JB06">๋์</option>
						<option value="JB07">์์์</option>
						<option value="JB08">ํ์</option>
						<option value="JB09">๊ต์ฌ</option>					
					</select>				
				</td>
			</tr>
			<tr>
				<th>์ทจ๋ฏธ</th>
				<td>
					<select name="memLike" class="form-control input-sm" >
						<option value="">-- ์ทจ๋ฏธ ์ ํ --</option>
						<option value="HB01">์์</option>
						<option value="HB02">์ฅ๊ธฐ</option>
						<option value="HB03">์์</option>
						<option value="HB04">๋์</option>
						<option value="HB05">๋น๊ตฌ</option>
						<option value="HB06">๋ฐ๋</option>
						<option value="HB07">๋ณผ๋ง</option>
						<option value="HB08">์คํค</option>
						<option value="HB09">๋งํ</option>
						<option value="HB10">๋์</option>
						<option value="HB11">์ํ๊ฐ์</option>
						<option value="HB12">๋ฑ์ฐ</option>
						<option value="HB13">๊ฐ๊ทธ</option>
						<option value="HB14">์นด๋ ์ด์ฑ</option>					
					</select>				
				</td>
			</tr>			
			<tr>
				<td colspan="4">
				
					<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					&nbsp;ํ์๊ฐ์
					
					<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					&nbsp;ํ์๊ฐ์
					
					</button>
					<a href="#" class="btn btn-info btn-sm">
					<span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span>
					&nbsp;๊ฒฐ์ 
					</a>
					
					</button>
					<a href="#" class="btn btn-info btn-sm">
					<span class="glyphicon glyphicon-paperclip" aria-hidden="true"></span>
					&nbsp;๋ค์ด๋ก๋
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

<h4> request.getparameter ์ง์ ์ถ๋ ฅ </h4>

<%=request.getParameter("memId") %>
<%=request.getParameter("memPass") %>
<%=request.getParameter("memName") %>
<%=request.getParameter("memBir") %>
	

<hr>
<h4><% %> ์์์ MemberVO๋ง๋ค๊ณ  setMemIdํ๊ณ  out.print(member.getMemId)</h4>
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

<h4>useBean ์ฌ์ฉํด์ ์ถ๋ ฅ</h4>
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
			<h2>๋ก๊ทธ์ธ</h2>


			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>์์ด๋</th>
						<td><input type="text" name="userId"
							class="form-control input-sm" value=""></td>
					</tr>
					<tr>
						<th>๋น๋ฐ๋ฒํธ</th>
						<td><input type="password" name="userPass"
							class="form-control input-sm"></td>
					</tr>
					<tr>
						<td colspan="2"><label><input type="checkbox"
								name="rememberMe" value="Y" >ID ๊ธฐ์ตํ๊ธฐ</label></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-primary btn-sm pull-right">๋ก๊ทธ์ธ</button>
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
		user = new UserVO("malja", "๋ง์", "1004", "ADMIN");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("sunja", "์์", "1111", "USER");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("nolja", "์ผ๋์", "1004", "USER");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("milkis", "๋ฐํค์ค", "1004", "MANAGER");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("areum", "์๋ฆ", "0000", "MANAGER");
		usersMap.put(user.getUserId(), user);
	}

	public UserVO getUser(String id) {
		System.out.println("UserList getUser id=" + id);
		if (usersMap.containsKey(id)) {
			System.out.println("[" + id + "] ํ์ ์กด์ฌ");
			return usersMap.get(id);
		} else {
			System.out.println("[" + id + "] ํ์์ด ์กด์ฌํ์ง ์์");
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
	
	// toString() ๊ตฌํ
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	// ์์ฑ์
	public UserVO() {
		
	}
	
	// ์์ฑ์
	public UserVO(String userId, String userName, String userPass, String userRole) {
	this.userId = userId;
	this.userName = userName;
	this.userPass = userPass;
	this.userRole = userRole;
	}

	
	// ๋งด๋ฒํ๋์ get/set ๋ฉ์๋ ์์ฑ

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




## ๐ 7์ผ์ฐจ 

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
01loginCheck ์๋ ฅํ ๊ฐ์ ๋ฐ์์ userList์ ๋ฐ์ดํฐ๋ค์ด๋ ๋น๊ตํด์
				id,pw ๋ ์ค ํ๋๋ ๊ฐ์ด ์์ผ๋ฉด
				"id,pw๋ฅผ ์๋ ฅํด์ฃผ์ธ์"
				id๋ ๋ง์ง๋ง pw๋ ๋ค๋ฅธ ๊ฒฝ์ฐ
				"id๋๋ pw๋ฅผ ํ์ธํด์ฃผ์ธ์"
				id pw ๊ฐ ๊ฐ์ผ๋ฉด ๋ก๊ทธ์ธ ๋์์ต๋๋ค.
01logout 		๋ก๊ทธ์์
-->
<%
	CookieUtils cookieUtils=new CookieUtils(request);

	if(cookieUtils.exists("AUTH")){
		
	
%>
๋ก๊ทธ์ธ ๋์์ต๋๋ค
<a href="01logout.jsp" class="btn btn-defualt">๋ก๊ทธ์์</a>
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
			<h2>๋ก๊ทธ์ธ</h2>


			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>์์ด๋</th>
						<td><input type="text" name="userId"
							class="form-control input-sm" value=""></td>
					</tr>
					<tr>
						<th>๋น๋ฐ๋ฒํธ</th>
						<td><input type="password" name="userPass"
							class="form-control input-sm"></td>
					</tr>
					<tr>
						<td colspan="2"><label><input type="checkbox"
								name="rememberMe" value="Y" >ID ๊ธฐ์ตํ๊ธฐ</label></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-primary btn-sm pull-right">๋ก๊ทธ์ธ</button>
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
	//id๊ฐ ์์ผ๋ฉด ์์ด๋๋ ๋น๋ฐ๋ฒํธ ํ์ธํด์ฃผ์ธ์
	//pw๊ฐ ์์ด๋ ์์ด๋๋ ๋น๋ฐ๋ฒํธ๋ฅผ ํ์ธํด์ฃผ์ธ์
	//jsp:param name=msg, value="์์ด๋๋"
	//id pw ๋๋ค ๋ง๋ค๋ฉด cookie ๋ง๋ค์ด์
	//response, redirect login.jsp
-->
		
<%
	UserList userList=new UserList();
	String id = request.getParameter("userId");
	String pw = request.getParameter("userPass");
	
	//id pw๊ฐ null์ด๋ฉด jsp:foward ์จ์ login.jsp๋ก
	
	//id pw๋ ๋ด๊ฐ ์๋ ฅํ ๊ฐ
	UserVO user=userList.getUser(id);
	
	if((id==null || id.isEmpty()) || (pw==null || pw.isEmpty())){
		pageContext.forward("01login.jsp?msg=์์ด๋๋ ๋น๋ฐ๋ฒํธ๋ฅผ ์๋ ฅํด์ฃผ์ธ์");//jsp forward์ ๋๊ฐ์ ๊ธฐ๋ฅ
	}
	if(user==null){
		pageContext.forward("01login.jsp?msg=์์๋ ๋๋ ๋น๋ฐ๋ฒํธ๋ฅผ ํ์ธํด์ฃผ์ธ์");//jsp forward์ ๋๊ฐ์ ๊ธฐ๋ฅ
	}
	else if(user!=null){ //์์ด๋๋ ์ ์๋ ฅํ ๊ฒ
		if(pw.equals(user.getUserPass()));
			 //id,pw ๋ค ๋ง๋ ๊ฒฝ์ฐ
			 response.addCookie(CookieUtils.createCookie("AUTH", id)); //์ฟ ํค ์์ฑ
			 response.sendRedirect("01login.jsp");
		}else {
			//id๋ ๋ง์์ง๋ง ๋น๋ฐ๋ฒํธ ํ๋ฆฐ๊ฒฝ์ฐ
			pageContext.forward("01login.jsp?msg=์์๋ ๋๋ ๋น๋ฐ๋ฒํธ๋ฅผ ํ์ธํด์ฃผ์ธ์");//jsp forward์ ๋๊ฐ์ ๊ธฐ๋ฅ
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
	response.addCookie(cookie);// 0: ์ฟ ํค ์ญ์ 
	response.sendRedirect("01login.jsp?msg=๋ก๊ทธ์์ ๋์์ต๋๋ค.");// ์ฟ ํค์ญ์ ํ ์ํ๋ก ์ฒซ ํ์ด์ง๋ก ๊ฐ๋๊น ๋ก๊ทธ์์๋จ
%>
</body>
</html>
```

#### 00 cookieUtilCreate

```js

```

#### src โ com.study.common.util โ CookieUtil.java

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
	
	public CookieUtils(HttpServletRequest request) { //์์ฑ๋  ๋ ๊ทธ request์ ๋ชจ๋  ์ฟ ํค๊ฐ cookieMap์ ๋ด๊น
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
	}  //null์ returnํ  ์๋ ์๋๋ฐ ์ด๋ ๊ฒ์ฌ๋ฅผ ์ง์ ํ๋๊ฒ๋ณด๋จ exists๋ฅผ ์ด์ฉํด์...
	
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

#### src โ com.study.common.util โ UserList.java

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
		user = new UserVO("malja", "๋ง์", "1004", "ADMIN");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("sunja", "์์", "1111", "USER");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("nolja", "์ผ๋์", "1004", "USER");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("milkis", "๋ฐํค์ค", "1004", "MANAGER");
		usersMap.put(user.getUserId(), user);
		user = new UserVO("areum", "์๋ฆ", "0000", "MANAGER");
		usersMap.put(user.getUserId(), user);
	}

	public UserVO getUser(String id) {
		System.out.println("UserList getUser id=" + id);
		if (usersMap.containsKey(id)) {
			System.out.println("[" + id + "] ํ์ ์กด์ฌ");
			return usersMap.get(id);
		} else {
			System.out.println("[" + id + "] ํ์์ด ์กด์ฌํ์ง ์์");
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

#### src โ com.study.login.vo โ UserVo.java

```js
package com.study.login.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class UserVO {
	private String userId;
	private String userName;
	private String userPass;
	private String userRole;
	
	// toString() ๊ตฌํ
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	// ์์ฑ์
	public UserVO() {
		
	}
	
	// ์์ฑ์
	public UserVO(String userId, String userName, String userPass, String userRole) {
	this.userId = userId;
	this.userName = userName;
	this.userPass = userPass;
	this.userRole = userRole;
	}

	
	// ๋งด๋ฒํ๋์ get/set ๋ฉ์๋ ์์ฑ

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


#### src โ com.study.member.vo โ MemberVO.java

```js
package com.study.member.vo;

public class MemberVO {
	private String memId;         /* ํ์ ์์ด๋ */
	private String memPass;       /* ํ์ ๋น๋ฐ๋ฒํธ */
	private String memName;       /* ํ์ ์ด๋ฆ */
	private String memBir;        /* ํ์ ์์ผ */
	private String memZip;        /* ์ฐํธ๋ฒํธ */
	private String memAdd1;       /* ์ฃผ์ */
	private String memAdd2;       /* ์์ธ์ฃผ์ */
	private String memHp;         /* ์ฐ๋ฝ์ฒ */
	private String memMail;       /* ์ด๋ฉ์ผ */
	private String memJob;        /* ์ง์ ์ฝ๋ */
	private String memLike;       /* ์ทจ๋ฏธ ์ฝ๋ */
	private int memMileage;       /* ๋ง์ผ๋ฆฌ์ง */
	private String memDelYn;     /* ํํด์ฌ๋ถ */
	
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


## ๐ 8์ผ์ฐจ

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
์๊ฐ<%=session.getCreationTime()  %>		<!-- ์ธ์์ด ์์ฑ๋ ์๊ฐ -->

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
์์ฑ์๊ฐ : <%=sdf.format(date) %> <br>
์ ๊ทผ์๊ฐ : <%=sdf.format(date2) %>

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

	<!-- ์ ๊ณต๋ ํ์ผ์ ์ถ๊ฐํ๋๊ฒ๋๋ค -->

	<!-- ๋ฌธ์  : AUTH๋ผ๋ ์ฟ ํค๊ฐ ์์ผ๋ฉด "๋ก๊ทธ์ธ๋จ"  
	์์ผ๋ฉด ๋ก๊ทธ์ธ ํผ ์ถ๋ ฅํ๊ธฐ
 -->

	loginCheck : id๊ธฐ์ตํ๊ธฐ ์ฟ ํค :SAVE_ID, id

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
	๋ก๊ทธ์ธ ์ค
	<a href="01logout.jsp" class="btn btn-success btn-sm">๋ก๊ทธ์์</a>
	<%
		} else {
	%>


	<div class="container">
		<form action="01loginCheck.jsp" class="loginForm">
			<h2>๋ก๊ทธ์ธ</h2>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>์์ด๋</th>
						<td><input type="text" name="userId" class="form-control input-sm" value="<%=id%>"></td>
					</tr>
					<tr>
						<th>๋น๋ฐ๋ฒํธ</th>
						<td><input type="password" name="userPass" class="form-control input-sm"></td>
					</tr>
					<tr>
						<td colspan="2"><label><input type="checkbox" name="rememberMe" value="Y" <%=checked %>>ID ๊ธฐ์ตํ๊ธฐ</label></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-primary btn-sm pull-right">๋ก๊ทธ์ธ</button>
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
<!-- <a href="#" class="btn btn-default" onclick="history.go(-1)">๋ค๋ก๊ฐ๊ธฐ</a>
์์ด๋ํ๋ ธ์๋  -->


1.์์ด๋๋ ๋น๋ฐ๋ฒํธ ์๋ ฅ ์ํ์ ๋    forward.  msg:์๋ ฅ์ํ์ด์
2.์์ด๋๊ฐ userList์ ์์ ๋          
forward  msg:์์ด๋ ๋๋ ๋น๋ฒํ์ธ

3.์์ด๋๊ฐ userList์ ์๊ณ , pw๋ ๋ง์์ ๋  redircet
4.์์ด๋๊ฐ userList์ ์์ง๋ง pw๊ฐ ํ๋ ธ์ ๋
forward  msg:์์ด๋ ๋๋ ๋น๋ฒํ์ธ
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
		pageContext.forward("01login.jsp?msg=์๋ ฅ์ํ์ด์");
	}
	
	UserList userList=new UserList();
	UserVO user=userList.getUser(id);
	
	if(user==null){
		pageContext.forward("01login.jsp?msg=์์ด๋ ๋๋ ๋น๋ฒ ํ์ธ");
	}else{ //id๋ง์์๋
		if(user.getUserPass().equals(pw)){//๋ค ๋ง๋๊ฒฝ์ฐ
			if(save_id.equals("Y")){
				response.addCookie(
						CookieUtils.createCookie("SAVE_ID", id,"/",3600*24*7));
			}
			response.addCookie(CookieUtils.createCookie("AUTH", id));
			response.sendRedirect("01login.jsp");
		}else{//  ๋น๋ฒ๋ง ํ๋ฆฐ๊ฒฝ์ฐ
			pageContext.forward("01login.jsp?msg=์์ด๋ ๋๋ ๋น๋ฒ ํ์ธ");
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


## ๐ 9์ผ์ฐจ

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

	<!-- ์ ๊ณต๋ ํ์ผ์ ์ถ๊ฐํ๋๊ฒ๋๋ค -->

	<!-- ๋ฌธ์  : AUTH๋ผ๋ ์ฟ ํค๊ฐ ์์ผ๋ฉด "๋ก๊ทธ์ธ๋จ"  
	์์ผ๋ฉด ๋ก๊ทธ์ธ ํผ ์ถ๋ ฅํ๊ธฐ
 -->

	loginCheck : id๊ธฐ์ตํ๊ธฐ ์ฟ ํค :SAVE_ID, id

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
	๋ก๊ทธ์ธ ์ค
	<a href="03logout.jsp" class="btn btn-success btn-sm">๋ก๊ทธ์์</a>
	<%
		} else {
	%>


	<div class="container">
		<form action="03loginCheck.jsp" class="loginForm">
			<h2>๋ก๊ทธ์ธ</h2>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>์์ด๋</th>
						<td><input type="text" name="userId" class="form-control input-sm" value="<%=id%>"></td>
					</tr>
					<tr>
						<th>๋น๋ฐ๋ฒํธ</th>
						<td><input type="password" name="userPass" class="form-control input-sm"></td>
					</tr>
					<tr>
						<td colspan="2"><label><input type="checkbox" name="rememberMe" value="Y" <%=checked %>>ID ๊ธฐ์ตํ๊ธฐ</label></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-primary btn-sm pull-right">๋ก๊ทธ์ธ</button>
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
<!-- <a href="#" class="btn btn-default" onclick="history.go(-1)">๋ค๋ก๊ฐ๊ธฐ</a>
์์ด๋ํ๋ ธ์๋  -->


1.์์ด๋๋ ๋น๋ฐ๋ฒํธ ์๋ ฅ ์ํ์ ๋    forward.  msg:์๋ ฅ์ํ์ด์
2.์์ด๋๊ฐ userList์ ์์ ๋          
forward  msg:์์ด๋ ๋๋ ๋น๋ฒํ์ธ

3.์์ด๋๊ฐ userList์ ์๊ณ , pw๋ ๋ง์์ ๋  redircet
4.์์ด๋๊ฐ userList์ ์์ง๋ง pw๊ฐ ํ๋ ธ์ ๋
forward  msg:์์ด๋ ๋๋ ๋น๋ฒํ์ธ
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
		//pageContext.forward("03slogin.jsp?msg=์๋ ฅ์ํ์ด์");
		redirectPage="03login.jsp?msg=" + URLEncoder.encode("์๋ ฅ์ํจ", "utf-8");
	}
	
	UserList userList=new UserList();
	UserVO user=userList.getUser(id);
	
	if(user==null){
		//pageContext.forward("03login.jsp?msg=์์ด๋ ๋๋ ๋น๋ฒ ํ์ธ");
		redirectPage="03login.jsp?msg=" + URLEncoder.encode("์์ด๋ ๋๋ ๋น๋ฒ ํ์ธ", "utf-8");
	}else{ //id๋ง์์๋
		if(user.getUserPass().equals(pw)){//๋ค ๋ง๋๊ฒฝ์ฐ
			if(save_id.equals("Y")){
				response.addCookie(
						CookieUtils.createCookie("SAVE_ID", id,"/",3600*24*7));
			}
			response.addCookie(CookieUtils.createCookie("AUTH", id));
			
			//SAVE_ID๋ ์ฟ ํค๋ก ํ๋ ๊ฒ ๋ง๊ณ 
			//AUTH์ฟ ํค๋ง session์ผ๋ก ๊ณ ์นจ
			//session ์์ฑ ์ด๋ฆ์  "USER_INFO"
			session.setAttribute("USER_INFO", user);
			session.setMaxInactiveInterval(1800); 	//์๋ ๋ก๊ทธ์์(30๋ถ)
			
			redirectPage="03login.jsp?";
			
		}else{//  ๋น๋ฒ๋ง ํ๋ฆฐ๊ฒฝ์ฐ
			//pageContext.forward("03login.jsp?msg=์์ด๋ ๋๋ ๋น๋ฒ ํ์ธ");
			redirectPage="03login.jsp?msg=" + URLEncoder.encode("์์ด๋ ๋๋ ๋น๋ฒ ํ์ธ", "utf-8");
		}
		
		response.sendRedirect(redirectPage); //๋ง์ง๋ง ํ ๋ฒ๋ง ๋ฆฌ๋ค์ด๋ ํธ ํด์ฃผ๋ฉด ๋จ
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
	์ฌ์น์ : <%=request.getParameter("email")%>, tel:<%=request.getParameter("tel") %>
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

์ฌ์น์ ํ์ด์ง ๋ด์ฉ๋ค

<!-- ์ด๋ค ํ์ด์ง์์๋  ๋ฐ์ ์ฌ์ฉํ๋ฉด ๋๋ค. -->
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
	//db์กฐํํด์ ํ์ฐฝํฌ email tel ๊ฐ ์ป์ด์
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
<!-- jsp:forward๋ ์กฐ๊ฑด์ ๋ฐ๋ผ ์๋ก ๋ค๋ฅธ ํ์ด์ง๋ฅผ ๋ณด์ฌ์ค์ผ ํ  ๋ -->
<form action="02result.jsp" method="post">
	ํ์ฐฝํฌ <input type="radio" name="name" value="ํ์ฐฝํฌ">
	ํ์๊ท <input type="radio" name="name" value="ํ์๊ท">
	<button type="submit">ํ์จ</button>
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
	
	if(name.equals("ํ์ฐฝํฌ")){
		friendList.add("์ ๋ณ์ฃผ");
		friendList.add("๋ฌธ์ง์");
		pageName="02ch.jsp";
	}else{
		friendList.add("   ");
		pageName="02sk.jsp";
	}
	//forward ๋ถ๋ชจํ์ด์ง(result)์์์ request๋
	//์์ํ์ด์ง(ch,sk)์์์ request๋ ๊ฐ์ request
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

์๋ฐ๋น๊ท์ฝ
1. ํจํค์ง : ํจํค์ง ์์ ์์ด์ผ ํ๋ค. (default pakage ๋ง๊ณ )
2. ์์ฑ์ : ๊ธฐ๋ณธ์์ฑ์
3. ํ๋ private
4. get set public
5. ์ง๋ ฌํ๋ ์ ํ์ฌํญ (implements Serializable)

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

<!-- ๋ฐ์ ๊ฒ์ ์์ ํ์ค๋ก ๋๊ฐ์ด ์ธ ์ ์๋ค. -->
<%
/* 	UserVO inbum=(UserVO)request.getAttribute("inbum");
	if(inbum==null){
		inbum=new UserVO();
		request.setAttribute("inbum", inbum);
	} */
%>
<pre>
	set ์ <jsp:getProperty property="userId" name="inbum"/>
	<!-- set์ ํด์ผ ๊ฐ์ด ๋์ด set ํ getํ๊ธฐ -->
	<jsp:setProperty property="userId" name="inbum"/>
	set ํ<jsp:getProperty property="userId" name="inbum"/>
	
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
	session.invalidate(); // ์ธ์ ์ญ์ 
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
๋ณด์๊ณผ ๊ด๋ จ์๋ ๊ฒ์ ์ธ์์ผ๋ก ์ธ์์ ์ฃผ ์ฌ์ฉ ์ฉ๋ ๋ก๊ทธ์ธ ์ ์ง
05sessionInfo
05closeSession
05setMemberInfo
05getMemberInfo
<br>
์ธ์ id : <%=session.getId() %> <br>
<%

	long cTime=session.getCreationTime();
	long latime=session.getLastAccessedTime();
	
	session.setMaxInactiveInterval(15); // 15์ด ๋์ ์ธ์์ ์ ๊ทผ์ ์ ํ๋ฉด ์ธ์ ์ฌ ์์ฑ
	
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

<%//์ฌ๊ธฐ๋ set
	session.setAttribute("name", "value");
	UserVO user = new UserVO("han", "ํ์๊ท", "1004", "perpect");
	session.setAttribute("user", user);

%>
</body>
</html>
```


## ๐ 10์ผ์ฐจ
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

ELํํ์
Expression Language
์์ฒญ URI : <%=request.getRequestURI() %> <br>
์์ฒญ URI : ${pageContext.request.requestURI}

<hr>
EL์ ๊ฐ์ฒดํ์
pageContext, request, session, application ์์ผ๋ก ์์ฑ ๊ฒ์ฌ <br>

<%
	/* request.setAttribute("name", "์ฌ์น์"); */
	session.setAttribute("name", "aaa");
%>

${name} <br> <!-- requestScope ์ ๋ถ์ฌ๋ ์์ฑ ์ด๋ฆ ๋ง์ผ๋ก ๊ฐ ๋ฐ์์ฌ ์ ์์  -->
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
<!-- ์๋ ์์ฑ์ ์ฐ๋ฉด ๊ฐ ์ถ๋ ฅ x ์๋ฌ ์ ๋จ -->

<%-- ${user.asdsad } --%>
<!-- ์ฝ๊ธฐ ๊ฐ๋ฅํ ํ๋กํผํฐ๊ฐ ์๋ ๊ฒฝ์ฐ ์๋ฌ๋จ -->

<hr> ์ฟ ํค
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
	๋์ด<input type="number" name="number" value="">
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

๊ฐ๋จํ ์ถ๋ ฅ๋ฌธ์ out.printํ๋ฉด ๋๋๋ฐ
๋ณต์กํ ๊ฑฐ๋ out.printํ๊ธฐ ํ๋๋๊น
์คํฌ๋ฆฝํธ๋ฆฟ%%๋ซ๊ณ  ์ถ๋ ฅ ํ์์

<hr>
 	c:if๋ else๊ฐ ์์ด์
	<c:if test="<%=age<10 %>">
		<div border="1">
			<a href="04child.jsp">์ด๋ฆฐ์ด</a>
		</div>
	</c:if>
 	<hr>
 	<c:if test="<%=age>=10 %>">
 			<div border="1">
			<a href="04child.jsp">์ด๋ฆฐ์ด2</a>
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
<title>์ ํ ๋ชฉ๋ก</title>
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
<h3>์ ํ ๋ชฉ๋ก</h3>
<table class="prod-list">
	<caption class="hidden"><em>์ปดํจํฐ ์ ํ ๋ชฉ๋ก</em></caption>
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
<title>์ํ ์์ธ๋ณด๊ธฐ</title>
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
<h3>์ํ ์์ธ๋ณด๊ธฐ</h3>
<table class="prod-list">
	<caption>์ํ ์์ธ๋ณด๊ธฐ</caption>
	<colgroup>
		<col style="width: 25%;">
		<col />
	</colgroup>
	<tbody class="prod-detail">
		<tr>
			<td>์ ํ๋ช</td>			
			<td><%=prod.getProdName() %></td>
		</tr>	
		<tr>
			<td>์ด๋ฏธ์ง</td>			
			<td><img alt="" src="<%=request.getContextPath() %><%=prod.getProdImg() %>"></td>
		</tr>	
		<tr>
			<td>๊ฐ๊ฒฉ</td>			
			<td><%=prod.getProdPrice() %>"</td>
		</tr>
		<tr>
			<td>๋ฑ๋ก์ผ</td>			
			<td><%=prod.getProdRegDate() %>"</td>
		</tr>
		<tr>
			<td>์์ธ์ค๋ช</td>			
			<td><%=prod.getProdDetail() %>"</td>
		</tr>
	</tbody>
</table>

<div class="btn-basic-area" >
	<span><a href="/study/index.jsp" >Home</a> </span>
	<span><a href="prodList.jsp" >์ํ๋ชฉ๋ก</a> </span>
</div>

</div><!-- container -->
</body>
</html>

```



## ๐ 11์ผ์ฐจ 
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
	String[] vacation={"1์น์","2์น์","3์น์","4์น์"};
	request.setAttribute("vacation", vacation);
%>
<%--
<c:forEach items="${vacation }"></c:forEach> <!-- <c:forEach items="<%=vacation %>"></c:forEach>์ด๋ ๊ฐ์ -->

<c:set var="asd" value="<%=vacation %>"></c:set>
<c:forEach items="${asd}"></c:forEach>
 --%>
 
 <!-- varstatus์๋ index, current -->
 <pre>
<c:forEach items="<%=vacation %>" var="name" varStatus="status">
	${name } 	${status.current } ${status.index } <%-- ๋ฐฐ์ด์ ์ธ๋ฑ์ค(0๋ถํฐ ์์) --%>${status.count } <!-- 1๋ถํฐ ์์ -->
	<c:if test="${status.index eq 3 }">๋๋ 3๋ฒ์งธ ์ธ๋ฑ์ค ${name }</c:if>
	<c:if test='${status.current eq "3์น์" }'>์ฐพ๋ ๊ฑฐ ${name } ${status.current }</c:if>
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

<!-- ์๋ ๋์ผํ๊ฒ ์์ฑํ๋ ๋ฒ -->
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
	String badPeople="1์น์, 2์น์, 3์น์, 4์น์, 5์น์ 6์น์" ;
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
<title>์ ํ ๋ชฉ๋ก</title>
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
<h3>์ ํ ๋ชฉ๋ก</h3>
<table class="prod-list">
	<caption class="hidden"><em>์ปดํจํฐ ์ ํ ๋ชฉ๋ก</em></caption>
	<colgroup>
		<col style="width: 33%;">
		<col style="width: 33%;">
		<col />
	</colgroup>
	<tbody>
	<!-- c:forEach์จ์ ๊ฐ๋จํ๊ฒ ELํ๊ธฐ๋ฒ์ผ๋ก, items์ ๊ฐ์ฒด ๋ฃ์ด์ begin, end ์ฐ์ง๋ง๊ณ  -->
	
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
<title>์ํ ์์ธ๋ณด๊ธฐ</title>
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
<h3>์ํ ์์ธ๋ณด๊ธฐ</h3>
<table class="prod-list">
	<caption>์ํ ์์ธ๋ณด๊ธฐ</caption>
	<colgroup>
		<col style="width: 25%;">
		<col />
	</colgroup>
	<tbody class="prod-detail">
		<tr>
			<td>์ ํ๋ช</td>			
			<td>${prod.prodName } %></td>
		</tr>	
		<tr>
			<td>์ด๋ฏธ์ง</td>			
			<td><img alt="" src="<%=request.getContextPath() %>${prod.prodImg }"/></td>
		</tr>	
		<tr>
			<td>๊ฐ๊ฒฉ</td>			
			<td>${prod.prodPrice }</td>
		</tr>
		<tr>
			<td>๋ฑ๋ก์ผ</td>			
			<td>${prod.prodRegDate }</td>
		</tr>
		<tr>
			<td>์์ธ์ค๋ช</td>			
			<td>${prod.prodDetail}</td>
		</tr>
	</tbody>
</table>

<div class="btn-basic-area" >
	<span><a href="/study/index.jsp" >Home</a> </span>
	<span><a href="prodList.jsp" >์ํ๋ชฉ๋ก</a> </span>
</div>

</div><!-- container -->
</body>
</html>

```
## ๐ 12์ผ์ฐจ
#### src โ resource โ message.properties
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

#### src โ resource โ message_en.properties
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

#### src โ resource โ message_jp.properties
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

	<a href="04localeChange.jsp?lang=jp">ๆฅๆฌ่ช</a>
	<a href="04localeChange.jsp?lang=ko">ํ๊ตญ์ด</a>
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
<!-- <a href="#" class="btn btn-default" onclick="history.go(-1)">๋ค๋ก๊ฐ๊ธฐ</a>
์์ด๋ํ๋ ธ์๋  -->

session์ ์์ฑ ์ ์ฅ์ "USER_INFO"   userVO ๋ฅผ ์์ฑ์ ์ ์ฅ 


1.์์ด๋๋ ๋น๋ฐ๋ฒํธ ์๋ ฅ ์ํ์ ๋    forward.  msg:์๋ ฅ์ํ์ด์
2.์์ด๋๊ฐ userList์ ์์ ๋          
forward  msg:์์ด๋ ๋๋ ๋น๋ฒํ์ธ

3.์์ด๋๊ฐ userList์ ์๊ณ , pw๋ ๋ง์์ ๋  redircet 
4.์์ด๋๊ฐ userList์ ์์ง๋ง pw๊ฐ ํ๋ ธ์ ๋ 
forward  msg:์์ด๋ ๋๋ ๋น๋ฒํ์ธ
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
		//response.sendRedirect("03login.jsp?msg=์๋ ฅ์ํจ")
		redirectPage="03login.jsp?msg=empty";
	}
	
	UserList userList=new UserList();
	UserVO user=userList.getUser(id);
	
	if(user==null){
		//response.sendRedirect("03login.jsp?msg=์์ด๋ ๋๋ ๋น๋ฒ ํ์ธ");
		redirectPage="03login.jsp?msg=check";
	}else{ //id๋ง์์๋ 
		if(user.getUserPass().equals(pw)){//๋ค ๋ง๋๊ฒฝ์ฐ
			if(save_id.equals("Y")){
				response.addCookie(
						CookieUtils.createCookie("SAVE_ID", id,"/",3600*24*7));
			}
			session.setAttribute("USER_INFO",user );
			session.setMaxInactiveInterval(1800);
			//response.sendRedirect("03login.jsp");
			redirectPage="03login.jsp?";
		}else{//  ๋น๋ฒ๋ง ํ๋ฆฐ๊ฒฝ์ฐ
			//response.sendRedirect("03login.jsp?msg=์์ด๋ ๋๋ ๋น๋ฒ ํ์ธ");
			redirectPage="03login.jsp?msg="+URLEncoder.encode("์์ด๋ ๋๋ ๋น๋ฒ ํ์ธ","utf-8");
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
ํ์ด์ง : <%=request.getHeader("Referer") %> <br>

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
	request.setAttribute("perfect", "์ฌ์น์");
%>

test์ ๊ฐ์ด true or false๊ฐ ๋์์ผ ํจ 

<c:if test='${perfect == "์ฌ์น์" }'>
	perfect == "์ฌ์น์"์ด true๋๊น ์คํ๋จ
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
<title>์ ํ ๋ชฉ๋ก</title>
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
<h3>์ ํ ๋ชฉ๋ก</h3>
<table class="prod-list">
	<caption class="hidden"><em>์ปดํจํฐ ์ ํ ๋ชฉ๋ก</em></caption>
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
<title>์ํ ์์ธ๋ณด๊ธฐ</title>
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
<h3>์ํ ์์ธ๋ณด๊ธฐ</h3>
<table class="prod-list">
	<caption>์ํ ์์ธ๋ณด๊ธฐ</caption>
	<colgroup>
		<col style="width: 25%;">
		<col />
	</colgroup>
	<tbody class="prod-detail">
		<tr>
			<td>์ ํ๋ช</td>			
			<td>${prod.prodName }</td>
		</tr>	
		<tr>
			<td>์ด๋ฏธ์ง</td>			
			<td><img alt="" src=<%=request.getContextPath()%>${prod.prodImg }></td>
		</tr>	
		<tr>
			<td>๊ฐ๊ฒฉ</td>			
			<td>${prod.prodPrice }</td>
		</tr>
		<tr>
			<td>๋ฑ๋ก์ผ</td>			
			<td>${prod.prodRegDate }</td>
		</tr>
		<tr>
			<td>์์ธ์ค๋ช</td>			
			<td>${prod.prodDetail }</td>
		</tr>
	</tbody>
</table>

<div class="btn-basic-area" >
	<span><a href="/study/index.jsp" >Home</a> </span>
	<span><a href="prodList.jsp" >์ํ๋ชฉ๋ก</a> </span>
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

varStatus์์ ์ฌ์ฉ๊ฐ๋ฅํ ๊ฒ๋ค : index, count, begin, end, current, first, last
<c:forEach items="${userList }" var="user" varStatus="status">
${user.userId } ${user.userPass } ${status.count }<br> 

<c:if test="${status.first }">์ฒ์์๋ง ์คํ๋จ</c:if>
<c:if test="${status.last }">๋ง์ง๋ง์๋ง ์คํ๋จ</c:if>
				<!-- 
	varStatus์์ ์ฌ์ฉ๊ฐ๋ฅํ ๊ฒ๋ค : index, count, begin, end, current, first, last nolja 1004 1
	์ฒ์์๋ง ์คํ๋จ areum 0000 2
	malja 1004 3
	sunja 1111 4
	milkis 1004 5
	๋ง์ง๋ง์๋ง ์คํ๋จ
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

<!-- 01jstlUrl.jsp ํ์ด์ง ์คํ -->
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
<c:if test="${ex !=null }">์๋ฌ๊ฐ ๋ฌ๋ค</c:if>

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
		<fmt:param value="๋ง์"></fmt:param>
	</fmt:message>
</fmt:bundle>

<!-- ํ์ด์ง๋ฅผ ๋ฐ๋ก ์ ๋ง๋ค์ด๋ ๋จ -->
<a href="04localeChange.jsp?lang=jp">์ผ๋ณธ์ด</a>
<a href="04localeChange.jsp?lang=ko">ํ๊ตญ์ด</a>
<a href="04localeChange.jsp?lang=en">์์ด</a>



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
ํ์ด์ง : <%=request.getHeader("Referer") %> <br>

<c:redirect url='<%=request.getHeader("Referer") %>'></c:redirect>

</body>
</html>
```

## ๐ 13์ผ์ฐจ

## SQL ๋ถ๋ถ

#### number ๋ฉด int  ๊ทธ์ธ๋ String 
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
#### VO์์ฑ์ฟผ๋ฆฌ
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

## jsp ๋ถ๋ถ

#### src โ com.study.member.vo โ MemberVO.java
```
package com.study.member.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MemberVO {
	private String memId;                   /*ํ์์์ด๋*/
	private String memPass;                 /*ํ์๋น๋ฐ๋ฒํธ*/
	private String memName;                 /*ํ์์ด๋ฆ*/
	private String memBir;                  /*ํ์์์ผ*/
	private String memZip;                  /*ํ์์ฐํธ๋ฒํธ*/
	private String memAdd1;                 /*ํ์์ฃผ์*/
	private String memAdd2;                 /*ํ์์์ธ์ฃผ์*/
	private String memHp;                   /*ํ์์ ํ๋ฒํธ*/
	private String memMail;                 /*ํ์์ด๋ฉ์ผ*/
	private String memJob;                  /*ํ์์ง์*/
	private String memLike;                 /*ํ์์ทจ๋ฏธ*/
	private int memMileage;                 /*ํ์๋ง์ผ๋ฆฌ์ง*/
	private String memDelYn;                /*ํ์์ญ์ ์ฌ๋ถ*/
	
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
		
	//DB์ฐ๊ฒฐ
	conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jsp","oracle");
	
	//์ฟผ๋ฆฌ ์์ฑ
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

## ๐ 14์ผ์ฐจ
#### 01memberList
```js

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
		
	//DB์ฐ๊ฒฐ
	conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jsp","oracle");
	
	//์ฟผ๋ฆฌ ์์ฑ
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
<c:forEach items="${memberList }"  var="member">
	<tr>
		<td>${member.memId }</td>
		<td>${member.memName }</td>
		<td>${member.memId }</td>
		<td> <a href="memberViewST.jsp?memId=${member.memId}">${member.memName} </a>		</td>
	</tr>
</c:forEach>
	
	<c:forEach items="${memberList }" var="member">
		${member.memId } ${member.memName }
	</c:forEach>


</table>


</body>
</html>
```

#### memberViewST 
```js
<%@page import="com.study.member.vo.MemberVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp" %>
	<title>memberView.jsp </title>
</head>
<body>



<%@include file="/WEB-INF/inc/top.jsp"%>
<%
	request.getParameter("memId"); 
%>

<%
	Connection conn=null; 
	Statement stmt=null;
	ResultSet rs=null;
	try{
		
	//DB์ฐ๊ฒฐ
	conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jsp","oracle");
	
	//์ฟผ๋ฆฌ๋ฌธ ์
	stmt = conn.createStatement();
	
	String memId = request.getParameter("memId");
	StringBuffer sb = new StringBuffer();
	sb.append("select mem_id,		mem_pass,		mem_name,		");
	sb.append(" 		  mem_bir,	mem_zip,		mem_add1,		");
	sb.append(" 		  mem_add2,	mem_hp,		mem_mail,		");
	sb.append(" 		  mem_job,	mem_like,		mem_mileage,	");
	sb.append(" 		  mem_del_yn									");
	sb.append("from member											");
	sb.append("where mem_id='" + memId +"'");
	rs=stmt.executeQuery(sb.toString()); 

	
	if(rs.next()){
		MemberVO member = new MemberVO(); 
		member.setMemId(rs.getString("mem_id")); 
		member.setMemPass(rs.getString("mem_pass")); 
		member.setMemName(rs.getString("mem_name")); 
		member.setMemBir(rs.getString("mem_bir")); 
		member.setMemZip(rs.getString("mem_zip")); 
		member.setMemAdd1(rs.getString("mem_add1")); 
		member.setMemAdd2(rs.getString("mem_add2")); 
		member.setMemHp(rs.getString("mem_hp")); 
		member.setMemMail(rs.getString("mem_mail")); 
		member.setMemJob(rs.getString("mem_job")); 
		member.setMemLike(rs.getString("mem_like")); 
		member.setMemMileage(rs.getInt("mem_mileage")); 
		member.setMemDelYn(rs.getString("mem_del_yn")); 
		
		request.setAttribute("member",member); 
	}
	
	}catch(SQLException e){
		e.printStackTrace(); 
	}finally{
	if(conn!=null){conn.close();}
	if(stmt!=null){stmt.close();}
	if(rs!=null){rs.close();}
	}
	%>





 <div class="container">	
	<h3>ํ์์กฐํ</h3>		
	<table class="table table-striped table-bordered">
		<tbody>
			<tr>
				<th>์์ด๋</th>
				<td>${member.memId }</td>
			</tr>
			<tr>
				<th>๋น๋ฐ๋ฒํธ</th>
				<td><input type="password" name="memPass" class="form-control input-sm" >
				</td>
			</tr>
			<tr>
				<th>ํ์๋ช</th>
				<td>${member.memName }</td>
			</tr>
			<tr>
				<th>์ฐํธ๋ฒํธ</th>
				<td>${member.memZip }</td>
			</tr>
			<tr>
				<th>์ฃผ์</th>
				<td>${member.memAdd1 }
				    ${member.memAdd2 }
				</td>
			</tr>
			<tr>
				<th>์์ผ</th>
				<td>${member.memBir }</td>
			</tr>
			<tr>
				<th>ํธ๋ํฐ</th>
				<td>${member.memHp }</td>
			</tr>
			<tr>
				<th>์ง์</th>
				<td>
					<select name="memJob" class="form-control input-sm" >
						<option value="">-- ์ง์ ์ ํ --</option>
						<option value="JB01" ${member.memJob eq "JB01" ? "selected='selected'":"" }>์ฃผ๋ถ</option>
						<option value="JB02" ${member.memJob eq "JB02" ? "selected='selected'":"" }>์ํ์</option>
						<option value="JB03" ${member.memJob eq "JB03" ? "selected='selected'":"" }>๊ณต๋ฌด์</option>
						<option value="JB04" ${member.memJob eq "JB04" ? "selected='selected'":"" }>์ถ์ฐ์</option>
						<option value="JB05" ${member.memJob eq "JB05" ? "selected='selected'":"" }>ํ์ฌ์</option>
						<option value="JB06" ${member.memJob eq "JB06" ? "selected='selected'":"" }>๋์</option>
						<option value="JB07" ${member.memJob eq "JB07" ? "selected='selected'":"" }>์์์</option>
						<option value="JB08" ${member.memJob eq "JB08" ? "selected='selected'":"" }>ํ์</option>
						<option value="JB09" ${member.memJob eq "JB09" ? "selected='selected'":"" }>๊ต์ฌ</option>					
					</select>				
				</td>
			</tr>
			<tr>
				<th>์ทจ๋ฏธ</th>
				<td>
			
					<select name="memLike" class="form-control input-sm" >
						<option value="">-- ์ทจ๋ฏธ ์ ํ --</option>
						
						<option value="HB01" ${member.memLike eq "HB01" ? "selected='selected'":"" }>์ฃผ๋ถ</option>
						<option value="HB02" ${member.memLike eq "HB02" ? "selected='selected'":"" }>์ํ์</option>
						<option value="HB03" ${member.memLike eq "HB03" ? "selected='selected'":"" }>๊ณต๋ฌด์</option>
						<option value="HB04" ${member.memLike eq "HB04" ? "selected='selected'":"" }>์ถ์ฐ์</option>
						<option value="HB05" ${member.memLike eq "HB05" ? "selected='selected'":"" }>ํ์ฌ์</option>
						<option value="HB06" ${member.memLike eq "HB06" ? "selected='selected'":"" }>๋์</option>
						<option value="HB07" ${member.memLike eq "HB07" ? "selected='selected'":"" }>์์์</option>
						<option value="HB08" ${member.memLike eq "HB08" ? "selected='selected'":"" }>ํ์</option>
						<option value="HB09" ${member.memLike eq "HB09" ? "selected='selected'":"" }>๊ต์ฌ</option>				
					</select>				
				</td>
			</tr>			
			<tr>
				<th>๋ง์ผ๋ฆฌ์ง</th>
				<td></td>
			</tr>
			<tr>
				<th>ํํด์ฌ๋ถ</th>
				<td>
				
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					&nbsp;ํ์๊ฐ์
					</button>
					<a href="#" class="btn btn-info btn-sm">
					<span class="glyphicon glyphicon-king" aria-hidden="true"></span>
					&nbsp;๊ทธ๋ฅ ๋งํฌ
					</a>
				</td>
			</tr>
		</tbody>	
	</table>
</div>

</body>
</html>
```

#### manyConnManyJob
```js
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
	long startTime = System.currentTimeMillis(); 
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
	}catch(ClassNotFoundException e){
		e.printStackTrace(); 
	}
	
	Connection conn=null; 
	Statement stmt=null;
	ResultSet rs=null;
	
	for(int i=0; i<1000; i++){
	try{
	//DB์ฐ๊ฒฐ
	conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jsp","oracle");
	
	//์ฟผ๋ฆฌ ์์ฑ
	stmt = conn.createStatement();
	stmt.executeQuery("select * from member where mem_id='a004'"); 
	if(rs.next()){
		out.print(rs.getString("mem_name" + "<br>")); 
	}
	}catch(SQLException e){
		e.printStackTrace(); 
	}finally{
	if(conn!=null){conn.close();}
	if(stmt!=null){stmt.close();}
	if(rs!=null){rs.close();}
	}
	}
	
	long lastTime = System.currentTimeMillis();
	out.print(lastTime-startTime + "ms");

	%>

</body>
</html>
```

#### manyConnManyJobDBCP
```js
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
	long startTime = System.currentTimeMillis(); 
	
	Connection conn=null; 
	Statement stmt=null;
	ResultSet rs=null;
	
	for(int i=0; i<1000; i++){
	try{
	//DB์ฐ๊ฒฐ
	conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
	
	//์ฟผ๋ฆฌ ์์ฑ
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select * from member where mem_id='a004'"); 
	if(rs.next()){
		out.print(rs.getString("mem_name" + "<br>")); 
	}
	}catch(SQLException e){
		e.printStackTrace(); 
	}finally{
	if(conn!=null){conn.close();}
	if(stmt!=null){stmt.close();}
	if(rs!=null){rs.close();}
	}
	}
	
	long lastTime = System.currentTimeMillis();
	out.print(lastTime-startTime + "ms");

	%>

</body>
</html>
```

#### oneConnManyJob
```js
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
	long startTime = System.currentTimeMillis(); 
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
	}catch(ClassNotFoundException e){
		e.printStackTrace(); 
	}
	
	Connection conn=null; 
	Statement stmt=null;
	ResultSet rs=null;
	try{
	//DB์ฐ๊ฒฐ
	conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jsp","oracle");
	
	//์ฟผ๋ฆฌ ์์ฑ
	stmt = conn.createStatement();
	for(int i=0; i<1000; i++){
	rs=stmt.executeQuery("select * from member where mem_id='a004'"); 
	if(rs.next()){
		out.print(rs.getString("mem_name" + "<br>"));
	}
	}
	}catch(SQLException e){
		e.printStackTrace(); 
	}finally{
	if(conn!=null){conn.close();}
	if(stmt!=null){stmt.close();}
	if(rs!=null){rs.close();}
	}
	
	long lastTime = System.currentTimeMillis();
	out.print(lastTime-startTime + "ms");

	%>
</body>
</html>
```

#### oneConnOneJob
```js
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
	long startTime = System.currentTimeMillis(); 
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
	}catch(ClassNotFoundException e){
		e.printStackTrace(); 
	}
	
	Connection conn=null; 
	Statement stmt=null;
	ResultSet rs=null;
	try{
	//DB์ฐ๊ฒฐ
	conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jsp","oracle");
	
	//์ฟผ๋ฆฌ ์์ฑ
	stmt = conn.createStatement();
	rs=stmt.executeQuery("select * from member where mem_id='a004'"); 
	if(rs.next()){
		out.print(rs.getString("mem_name" + "<br>")); 
	}
	}catch(SQLException e){
		e.printStackTrace(); 
	}finally{
	if(conn!=null){conn.close();}
	if(stmt!=null){stmt.close();}
	if(rs!=null){rs.close();}
	}
	
	long lastTime = System.currentTimeMillis();
	out.print(lastTime-startTime + "ms");

	%>
</body>
</html>
```
## ๐ 15์ผ์ฐจ(ํ์ CRUD)
#### memberList
```js
<%@page import="java.util.ArrayList"%>
<%@page import="com.study.member.vo.MemberVO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp" %>
	<title>memberList.jsp </title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp"%>
 <div class="container">	
	<h3>ํ์๋ชฉ๋ก</h3>		
<% 

	Connection conn=null; 
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
		pstmt = conn.prepareStatement("select * from member");
		rs = pstmt.executeQuery(); 
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		while(rs.next()){
			MemberVO member = new MemberVO();	
		
			member.setMemId(rs.getString("mem_id")); 
			member.setMemName(rs.getString("mem_name")); 
			member.setMemHp(rs.getString("mem_hp")); 
			member.setMemBir(rs.getString("mem_bir")); 
			member.setMemJob(rs.getString("mem_job")); 
			member.setMemMileage(rs.getInt("mem_mileage")); 
			memberList.add(member); 
		}
		request.setAttribute("memberList", memberList);
	}catch(SQLException e){
		e.printStackTrace();
	}finally{

	if(conn!=null){conn.close();}
	if(pstmt!=null){pstmt.close();}
	if(rs!=null){rs.close();}
	}
	
%>

	<div>
		<a href="memberForm.jsp" class="btn btn-primary btn-sm pull-right">ํ์ ๋ฑ๋ก</a>
	</div>
	
	<table class="table table-striped table-bordered">
	<caption class="hidden">ํ์๋ชฉ๋ก ์กฐํ</caption>
	<colgroup>
		<col style="width: 15%" />
		<col />
		<col style="width: 20%" />
		<col style="width: 20%" />
		<col style="width: 15%" />
		<col style="width: 15%" />
	</colgroup>
	<thead>
		<tr>
			<th>ID</th>
			<th>ํ์๋ช</th>
			<th>HP</th>
			<th>์์ผ</th>
			<th>์ง์</th>
			<th>๋ง์ผ๋ฆฌ์ง</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${memberList }" var="member">
		<tr>
		<td>${member.memId }</td>
		<td><a href="memberView.jsp?memId=${member.memId }">
		${member.memName }</a></td>
		<td>${member.memHp }</td>
		<td>${member.memBir }</td>
		<td>${member.memJob }</td>
		<td>${member.memMileage }</td>
		</tr>
	 	</c:forEach>
	</tbody>
		
			
		
		<tbody>
		</tbody>			
	</table>
</div>

</body>
</html>
```

#### memberView
```js
<%@page import="com.study.member.vo.MemberVO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp" %>
	<title>memberView.jsp </title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp"%>
 <div class="container">	
 <%
 

	Connection conn=null; 
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
		StringBuffer sb = new StringBuffer();
		sb.append("select mem_id,		mem_pass,		mem_name,		");
		sb.append(" 		  mem_bir,	mem_zip,		mem_add1,		");
		sb.append(" 		  mem_add2,	mem_hp,		mem_mail,		");
		sb.append(" 		  mem_job,	mem_like,		mem_mileage,	");
		sb.append(" 		  mem_del_yn									");
		sb.append("from member											");
		sb.append("where mem_id=      ? ");
		
		//pstmt๊ฐ์ฑ ์์ฑ
		pstmt=conn.prepareStatement(sb.toString()); 
		//pstmt ? ๊ฐ ์ค์ 
		pstmt.setString(1, request.getParameter("memId")); 
		//์ฟผ๋ฆฌ์คํ
		rs=pstmt.executeQuery(); 
		if(rs.next()){
			MemberVO member=new MemberVO(); 
			member.setMemId(rs.getString("mem_id"));
			member.setMemPass(rs.getString("mem_pass"));
			member.setMemName(rs.getString("mem_name"));
			member.setMemBir(rs.getString("mem_bir"));
			member.setMemZip(rs.getString("mem_zip"));
			member.setMemAdd1(rs.getString("mem_add1"));
			member.setMemAdd2(rs.getString("mem_add2"));
			member.setMemHp(rs.getString("mem_hp"));
			member.setMemMail(rs.getString("mem_mail"));
			member.setMemJob(rs.getString("mem_job"));
			member.setMemLike(rs.getString("mem_like"));
			member.setMemMileage(rs.getInt("mem_mileage"));
			member.setMemDelYn(rs.getString("mem_del_yn"));
			
			request.setAttribute("member", member);
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}finally{

	if(conn!=null){conn.close();}
	if(pstmt!=null){pstmt.close();}
	if(rs!=null){rs.close();}
	}
	
%>
 
 
 
 
 
		
		
	<h3>์์ธ๋ณด๊ธฐ</h3>		
	<table class="table table-striped table-bordered">
		<tbody>
			<tr>
				<th>์์ด๋</th>
				<td>${member.memId }</td>
			</tr>
			<tr>
				<th>๋น๋ฐ๋ฒํธ</th>
				<td>${member.memPass }</td>
			</tr>
			<tr>
				<th>ํ์๋ช</th>
				<td>${member.memName }</td>
			</tr>
			<tr>
				<th>์ฐํธ๋ฒํธ</th>
				<td>${member.memZip }</td>
			</tr>
			<tr>
				<th>์ฃผ์</th>
				<td>${member.memAdd1 }
					${member.memAdd2 } 
				</td>
			</tr>
			<tr>
				<th>์์ผ</th>
				<td>${member.memBir }</td>
			</tr>
			<tr>
				<th>ํธ๋ํฐ</th>
				<td>${member.memHp }</td>
			</tr>
			<tr>
				<th>์ง์</th>
				<td>
				${member.memJob }		
				</td>
			</tr>
			<tr>
				<th>์ทจ๋ฏธ</th>
				<td>
				${member.memLike }
				</td>
			</tr>			
			<tr>
				<th>๋ง์ผ๋ฆฌ์ง</th>
				<td>${member.memMileage }</td>
			</tr>
			<tr>
				<th>ํํด์ฌ๋ถ</th>
				<td>
				${member.memDelYn }
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="memberList.jsp?" class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
					&nbsp;๋ชฉ๋ก
					</a>
					<%-- <%=request.getParameter("memId") %>, <%=memId %>, ${param.memId}, <%=rs.getString("mem_id") %> ๋ค ๋๊ฐ์ --%>
					<a href='memberEdit.jsp?memId=<%=request.getParameter("memId")%>' class="btn btn-info btn-sm">
					<span class="glyphicon glyphicon-king" aria-hidden="true"></span>
					&nbsp;์์ 
					</a>
					<a href='memberDelete.jsp?memId=<%=request.getParameter("memId")%>' class="btn btn-danger btn-sm">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					&nbsp;์ญ์ 
					</a>
				</td>
			</tr>
		</tbody>	
			
	</table>
	
	

</div>

</body>
</html>
```

#### memberModify
```js
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp"%>

<jsp:useBean id="member" class="com.study.member.vo.MemberVO" ></jsp:useBean>
<jsp:setProperty property="*" name="member"/> <!--Post ํ๋ผ๋ฏธํฐ๋ฅผ ์๋์ผ๋ก ๋ฐ์์ค name์ผ๋ก -->

<%-- <%
out.print();
%> --%>

<%

	Connection conn=null; 
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
		StringBuffer sb = new StringBuffer();
		sb.append("update member set     ");
		//sb.append("mem_pass= ?            ,"); 
		sb.append("mem_name= ?            ,"); 
		//sb.append("mem_bir= ?            ,"); 
		sb.append("mem_zip= ?            ,"); 
		sb.append("mem_add1= ?            ,"); 
		sb.append("mem_add2= ?            ,"); 
		sb.append("mem_hp= ?            ,"); 
		sb.append("mem_mail= ?            ,"); 
		sb.append("mem_job= ?            ,"); 
		sb.append("mem_like= ?            "); 
		sb.append("where mem_id= ?       "); 		
		
		//pstmt๊ฐ์ฑ ์์ฑ
		pstmt=conn.prepareStatement(sb.toString()); 
		//pstmt ? ๊ฐ ์ค์ 
		int i = 1 ; 
		//pstmt.setString(i++, member.getMemPass()); 
		pstmt.setString(i++, member.getMemName()); 
		//pstmt.setString(i++, member.getMemBir()); 
		pstmt.setString(i++, member.getMemZip()); 
		pstmt.setString(i++, member.getMemAdd1()); 
		pstmt.setString(i++, member.getMemAdd2()); 
		pstmt.setString(i++, member.getMemHp()); 
		pstmt.setString(i++, member.getMemMail()); 
		pstmt.setString(i++, member.getMemJob()); 
		pstmt.setString(i++, member.getMemLike()); 
		pstmt.setString(i++, member.getMemId()); 
		//์ฟผ๋ฆฌ์คํ
		int cnt = pstmt.executeUpdate();
		
		if(cnt == 1){
			request.setAttribute("cnt", cnt); 
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}finally{

	if(conn!=null){conn.close();}
	if(pstmt!=null){pstmt.close();}
	if(rs!=null){rs.close();}
	}
	
%>



 <div class="container">	
	<h3>ํ์์์ </h3>		
		<c:if test="${cnt==1 }">
			<div class="alert alert-success">
				์ ์์ ์ผ๋ก ์์ ํ์ต๋๋ค.
			</div>		
		</c:if>
		
		<c:if test="${cnt!=1 }">
			<div class="alert alert-warning">
				๋ฑ๋ก ์คํจ.
			</div>	
		</c:if>
	</div>
</body>
</html>
```

#### memberRegist
```js
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.study.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %> 
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/inc/header.jsp"  %>
</head>




<body>
<%@ include file="/WEB-INF/inc/top.jsp"  %>
<jsp:useBean id="member" class="com.study.member.vo.MemberVO"></jsp:useBean>
<jsp:setProperty property="*" name="member"/>
<%

	Connection conn=null; 
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
		StringBuffer sb = new StringBuffer();
		sb.append("insert into member values(  ");
		sb.append("?   , "); 
		sb.append("?   , "); 
		sb.append("?   , "); 
		sb.append("?   , "); 
		sb.append("?   , "); 
		sb.append("?   , "); 
		sb.append("?   , "); 
		sb.append("?   , "); 
		sb.append("?   , "); 
		sb.append("?   , "); 
		sb.append("?   , "); 
		sb.append("0   , "); 
		sb.append("'N'    "); 
		sb.append(")"); 
		
	
		
		//pstmt๊ฐ์ฑ ์์ฑ
		pstmt=conn.prepareStatement(sb.toString()); 
		//pstmt ? ๊ฐ ์ค์ 
		int i = 1 ; 
		pstmt.setString(i++, member.getMemId()); 
		pstmt.setString(i++, member.getMemPass()); 
		pstmt.setString(i++, member.getMemName()); 
		pstmt.setString(i++, member.getMemBir()); 
		pstmt.setString(i++, member.getMemZip()); 
		pstmt.setString(i++, member.getMemAdd1()); 
		pstmt.setString(i++, member.getMemAdd2()); 
		pstmt.setString(i++, member.getMemHp()); 
		pstmt.setString(i++, member.getMemMail()); 
		pstmt.setString(i++, member.getMemJob()); 
		pstmt.setString(i++, member.getMemLike()); 
		//์ฟผ๋ฆฌ์คํ
		int cnt = pstmt.executeUpdate();
		
		if(cnt == 1){
			request.setAttribute("cnt", cnt); 
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}finally{

	if(conn!=null){conn.close();}
	if(pstmt!=null){pstmt.close();}
	if(rs!=null){rs.close();}
	}
	
%>

 <div class="container">	
 
	<h3>ํ์๋ฑ๋ก</h3>		
	<c:if test="${cnt==1 }">
		<div class="alert alert-success">
			์ ์์ ์ผ๋ก ํ์ ๋ฑ๋ก ๋์์ต๋๋ค.
		</div>		
	</c:if>

	<c:if test="${cnt!=1 }">
		<div class="alert alert-success">
			๋ฑ๋ก ์คํจ 
		</div>		
	</c:if>


 	<a href="memberList.jsp" class="btn btn-default btn-sm">
		<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
		&nbsp;๋ชฉ๋ก
	</a>
 </div>
</body>
</html>
```

#### memberForm
```js
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp"%>
 <div class="container">	
	<h3>ํ์๊ฐ์</h3>		
	<form action="memberRegist.jsp" method="post" >
	<table class="table table-striped table-bordered">
		<tbody>
			<tr>
				<th>์์ด๋</th>
				<td><input type="text" name="memId" class="form-control input-sm" 
						   required="required" pattern="\w{4,}" title="์ํ๋ฒณ๊ณผ ์ซ์๋ก 4๊ธ์ ์ด์ ์๋ ฅ" ></td>
			</tr>
			<tr>
				<th>๋น๋ฐ๋ฒํธ</th>
				<td><input type="password" name="memPass" class="form-control input-sm"
						   required="required" pattern="\w{4,}" title="์ํ๋ฒณ๊ณผ ์ซ์๋ก 4๊ธ์ ์ด์ ์๋ ฅ" ></td>
			</tr>
			<tr>
				<th>ํ์๋ช</th>
				<td><input type="text" name="memName" class="form-control input-sm"
						   required="required" pattern="[๊ฐ-ํฃ]{2,}" title="ํ๊ธ๋ก 2๊ธ์ ์ด์ ์๋ ฅ" ></td>
			</tr>
			<tr>
				<th>์ฐํธ๋ฒํธ</th>
				<td><input type="text" name="memZip" class="form-control input-sm" ></td>
			</tr>
			<tr>
				<th>์ฃผ์</th>
				<td><input type="text" name="memAdd1" class="form-control input-sm" >
					<input type="text" name="memAdd2" class="form-control input-sm" >
				</td>
			</tr>
			<tr>
				<th>์์ผ</th>
				<td><input type="date" name="memBir" class="form-control input-sm" ></td>
			</tr>
			<tr>
				<th>๋ฉ์ผ</th>
				<td><input type="email" name="memMail" class="form-control input-sm" ></td>
			</tr>
			<tr>
				<th>ํธ๋ํฐ</th>
				<td><input type="tel" name="memHp" class="form-control input-sm" ></td>
			</tr>
			<tr>
				<th>์ง์</th>
				<td>
					<select name="memJob" class="form-control input-sm" required="required">
						<option value="">-- ์ง์ ์ ํ --</option>
						<option value="JB01">์ฃผ๋ถ</option>
						<option value="JB02">์ํ์</option>
						<option value="JB03">๊ณต๋ฌด์</option>
						<option value="JB04">์ถ์ฐ์</option>
						<option value="JB05">ํ์ฌ์</option>
						<option value="JB06">๋์</option>
						<option value="JB07">์์์</option>
						<option value="JB08">ํ์</option>
						<option value="JB09">๊ต์ฌ</option>					
					</select>				
				</td>
			</tr>
			<tr>
				<th>์ทจ๋ฏธ</th>
				<td>
					<select name="memLike" class="form-control input-sm" required="required">
						<option value="">-- ์ทจ๋ฏธ ์ ํ --</option>
						<option value="HB01">์์</option>
						<option value="HB02">์ฅ๊ธฐ</option>
						<option value="HB03">์์</option>
						<option value="HB04">๋์</option>
						<option value="HB05">๋น๊ตฌ</option>
						<option value="HB06">๋ฐ๋</option>
						<option value="HB07">๋ณผ๋ง</option>
						<option value="HB08">์คํค</option>
						<option value="HB09">๋งํ</option>
						<option value="HB10">๋์</option>
						<option value="HB11">์ํ๊ฐ์</option>
						<option value="HB12">๋ฑ์ฐ</option>
						<option value="HB13">๊ฐ๊ทธ</option>
						<option value="HB14">์นด๋ ์ด์ฑ</option>					
					</select>				
				</td>
			</tr>			
			<tr>
				<td colspan="2">
					<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					&nbsp;ํ์๊ฐ์
					</button>
					<a href="memberList.jsp" class="btn btn-info btn-sm">
					<span class="glyphicon glyphicon-th-lis" aria-hidden="true"></span>
					&nbsp;๋ชฉ๋ก
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

#### memberEdit
```js
<%@page import="com.study.member.vo.MemberVO"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp"%>

<%
 

	Connection conn=null; 
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
		StringBuffer sb = new StringBuffer();
		sb.append("select mem_id,		mem_pass,		mem_name,		");
		sb.append(" 		  mem_bir,	mem_zip,		mem_add1,		");
		sb.append(" 		  mem_add2,	mem_hp,		mem_mail,		");
		sb.append(" 		  mem_job,	mem_like,		mem_mileage,	");
		sb.append(" 		  mem_del_yn									");
		sb.append("from member											");
		sb.append("where mem_id=      ? ");
		
		//pstmt๊ฐ์ฑ ์์ฑ
		pstmt=conn.prepareStatement(sb.toString()); 
		//pstmt ? ๊ฐ ์ค์ 
		pstmt.setString(1, request.getParameter("memId")); 
		//์ฟผ๋ฆฌ์คํ
		rs=pstmt.executeQuery(); 
		if(rs.next()){
			MemberVO member=new MemberVO(); 
			member.setMemId(rs.getString("mem_id"));
			member.setMemPass(rs.getString("mem_pass"));
			member.setMemName(rs.getString("mem_name"));
			member.setMemBir(rs.getString("mem_bir"));
			member.setMemZip(rs.getString("mem_zip"));
			member.setMemAdd1(rs.getString("mem_add1"));
			member.setMemAdd2(rs.getString("mem_add2"));
			member.setMemHp(rs.getString("mem_hp"));
			member.setMemMail(rs.getString("mem_mail"));
			member.setMemJob(rs.getString("mem_job"));
			member.setMemLike(rs.getString("mem_like"));
			member.setMemMileage(rs.getInt("mem_mileage"));
			member.setMemDelYn(rs.getString("mem_del_yn"));
			
			request.setAttribute("member", member);
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}finally{

	if(conn!=null){conn.close();}
	if(pstmt!=null){pstmt.close();}
	if(rs!=null){rs.close();}
	}
	
%>
 
 


 <div class="container">	
	<h3>ํ์ ์ ๋ณด ์์ </h3>	
	<form action="memberModify.jsp" method="post" >
	<table class="table table-striped table-bordered">
		<tbody>
			<tr>
				<th>์์ด๋</th>
				<td>${member.memId } <input type="hidden" value="${member.memId }" name="memId"> </td>
			</tr>
			<tr>
				<th>๋น๋ฐ๋ฒํธ</th>
				<td><input type="password" name="memPass" class="form-control input-sm" 
						    pattern="\w{4,}" title="์ํ๋ฒณ๊ณผ ์ซ์๋ก 4๊ธ์ ์ด์ ์๋ ฅ" ></td>
			</tr>
			<tr>
				<th>ํ์๋ช</th>
				<td><input type="text" name="memName" class="form-control input-sm" value='${member.memName }'
						   required="required" pattern="[๊ฐ-ํฃ]{2,}" title="ํ๊ธ๋ก 2๊ธ์ ์ด์ ์๋ ฅ" ></td>
			</tr>
			<tr>
				<th>์ฐํธ๋ฒํธ</th>
				<td><input type="text" name="memZip" class="form-control input-sm" value='${member.memZip }'></td>
			</tr>
			<tr>
				<th>์ฃผ์</th>
				<td><input type="text" name="memAdd1" class="form-control input-sm" value='${member.memAdd1 }'>
					<input type="text" name="memAdd2" class="form-control input-sm" value='${member.memAdd2 }'>
				</td>
			</tr>
			<tr>
				<th>์์ผ</th>
				<td><input type="date" name="memBir" class="form-control input-sm" value='${member.memBir }'></td>
			</tr>
			<tr>
				<th>๋ฉ์ผ</th>
				<td><input type="email" name="memMail" class="form-control input-sm" required="required" value='${member.memMail }'></td>
			</tr>
			<tr>
				<th>ํธ๋ํฐ</th>
				<td><input type="tel" name="memHp" class="form-control input-sm" value='${member.memHp }'></td>
			</tr>
			<tr>
				<th>์ง์</th>
				<td>
				
					<select name="memJob" class="form-control input-sm" >
						<option value="">-- ์ง์ ์ ํ --</option>
						<option value="JB01" ${member.memJob eq "JB01" ? "selected='selected'":""}>์ฃผ๋ถ</option>
						<option value="JB02" ${member.memJob eq "JB02" ? "selected='selected'":""}>์ํ์</option>
						<option value="JB03" ${member.memJob eq "JB03" ? "selected='selected'":""}>๊ณต๋ฌด์</option>
						<option value="JB04" ${member.memJob eq "JB04" ? "selected='selected'":""}>์ถ์ฐ์</option>
						<option value="JB05" ${member.memJob eq "JB05" ? "selected='selected'":""}>ํ์ฌ์</option>
						<option value="JB06" ${member.memJob eq "JB06" ? "selected='selected'":""}>๋์</option>
						<option value="JB07" ${member.memJob eq "JB07" ? "selected='selected'":""}>์์์</option>
						<option value="JB08" ${member.memJob eq "JB08" ? "selected='selected'":""}>ํ์</option>
						<option value="JB09" ${member.memJob eq "JB09" ? "selected='selected'":""}>๊ต์ฌ</option>					
					</select>			
				</td>
			</tr>
			<tr>
				<th>์ทจ๋ฏธ</th>
				<td>
				
					<select name="memLike" class="form-control input-sm" >
						<option value="">-- ์ทจ๋ฏธ ์ ํ --</option>
						<option value="HB01" ${member.memLike eq "HB01" ? "selected='selected'":""}>์์</option>
						<option value="HB02" ${member.memLike eq "HB02" ? "selected='selected'":""}>>์ฅ๊ธฐ</option>
						<option value="HB03" ${member.memLike eq "HB03" ? "selected='selected'":""}>>์์</option>
						<option value="HB04" ${member.memLike eq "HB04" ? "selected='selected'":""}>>๋์</option>
						<option value="HB05" ${member.memLike eq "HB05" ? "selected='selected'":""}>>๋น๊ตฌ</option>
						<option value="HB06" ${member.memLike eq "HB06" ? "selected='selected'":""}>>๋ฐ๋</option>
						<option value="HB07" ${member.memLike eq "HB07" ? "selected='selected'":""}>>๋ณผ๋ง</option>
						<option value="HB08" ${member.memLike eq "HB08" ? "selected='selected'":""}>>์คํค</option>
						<option value="HB09" ${member.memLike eq "HB09" ? "selected='selected'":""}>>๋งํ</option>
						<option value="HB10" ${member.memLike eq "HB10" ? "selected='selected'":""}>>๋์</option>
						<option value="HB11" ${member.memLike eq "HB11" ? "selected='selected'":""}>>์ํ๊ฐ์</option>
						<option value="HB12" ${member.memLike eq "HB12" ? "selected='selected'":""}>>๋ฑ์ฐ</option>
						<option value="HB13" ${member.memLike eq "HB13" ? "selected='selected'":""}>>๊ฐ๊ทธ</option>
						<option value="HB14" ${member.memLike eq "HB14" ? "selected='selected'":""}>>์นด๋ ์ด์ฑ</option>					
					</select>			
				</td>
			</tr>	
			<tr>
				<th>๋ง์ผ๋ฆฌ์ง</th>
				<td>${member.memMileage }</td>
			</tr>	
			<tr>
				<th>ํํด์ฌ๋ถ</th>
				<td>${member.memDelYn }</td>
			</tr>	
			<tr>
				<td colspan="2">
					<a href="memberList.jsp" class="btn btn-info btn-sm">
					<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
					&nbsp;๋ชฉ๋ก์ผ๋ก
					</a>
					<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
					&nbsp;&nbsp; ์ ์ฅ
					</button>
				</td>
			</tr>
		</tbody>	
	</table>
	</form>

</div>

</body>
</html>
```

#### memberDelete
```js

<%@page import="com.study.member.vo.MemberVO"%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp"%>

 <%
 

	Connection conn=null; 
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
		StringBuffer sb = new StringBuffer();
		sb.append("update member set mem_del_yn= 'Y' ");
		sb.append("where mem_id =?   ");
		
		//pstmt๊ฐ์ฑ ์์ฑ
		pstmt=conn.prepareStatement(sb.toString()); 
		//pstmt ? ๊ฐ ์ค์ 
		pstmt.setString(1, request.getParameter("memId")); 
		//์ฟผ๋ฆฌ์คํ
		int cnt =pstmt.executeUpdate(); 
		if(cnt==1){
			request.setAttribute("cnt", cnt);
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}finally{

	if(conn!=null){conn.close();}
	if(pstmt!=null){pstmt.close();}
	if(rs!=null){rs.close();}
	}
	
%>
 <div class="container">	
	<h3>ํ์์ญ์ </h3>		
	
		<c:if test="${cnt==1 }">
			<div class="alert alert-warning">
				<h4>์ญ์  ์ฑ๊ณต</h4>
				์ ์์ ์ผ๋ก ํ์์ ์ญ์ ํ์ต๋๋ค.
			</div>
		</c:if>
		
		
<%-- 				<c:if test="${cnt==1 }">
			<div class="alert alert-warning">
				<h4>์ญ์  ์ฑ๊ณต</h4>
				์ ์์ ์ผ๋ก ํ์์ ์ญ์ ํ์ต๋๋ค.
			</div>
		</c:if> --%>
		
		<c:if test="${cnt!=1 }">
				<div class="alert alert-warning">
					<h4>ํ์์ด ์กด์ฌํ์ง ์์ต๋๋ค.</h4>
					์ฌ๋ฐ๋ฅด๊ฒ ์ ๊ทผํด์ฃผ์ธ์.
				</div>
		</c:if>
		
	<a href="memberList.jsp?" class="btn btn-default btn-sm">
		<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
		&nbsp;๋ชฉ๋ก
	</a>
	</div>
</body>
</html>
```

## ๐ 16์ผ์ฐจ(๊ฒ์ํ CRUD)

#### ๊ฒ์ํ ๋ฐ์ดํฐ(SQL)
```sql
insert into free_board values(
    SEQ_FREE_BOARD.nextval
    ,'๋๋ฏธ ์ ๋ชฉ'
    ,'BC01'
    ,'์ ๊พผ ์ก์ธ๋ฒ'
    ,'1004'
    ,'๋๋ฏธ์ ๋ชฉ ๊ธฐ์ด์ด์ด์ด์ด์ด์ด์ด์ด์ด์ผ๊ฒ'
    ,'127.0.0.1'
    ,0
    ,sysdate
    ,null
    ,'N'
); 

insert into free_board
    select SEQ_FREE_BOARD.nextval
           ,bo_title
           ,bo_category
           ,bo_writer
           ,bo_pass
           ,bo_content
           ,bo_ip
           ,bo_hit
           ,bo_reg_date
           ,bo_mod_date
           ,bo_del_yn
           from free_board
;
commit;
```

#### freeList
```js
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.study.free.vo.freeBoardVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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

	Connection conn=null; 
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
		pstmt = conn.prepareStatement("select * from free_board");
		rs = pstmt.executeQuery(); 
		List<freeBoardVO> freeBoard = new ArrayList<freeBoardVO>();
		while(rs.next()){
			freeBoardVO board = new freeBoardVO();	
		
			board.setBoNo(rs.getInt("bo_no")); 
			board.setBoCategory(rs.getString("bo_category")); 
			board.setBoTitle(rs.getString("bo_title")); 
			board.setBoWriter(rs.getString("bo_writer")); 
			board.setBoRegDate(rs.getString("bo_reg_date")); 
			board.setBoHit(rs.getInt("bo_hit")); 
			freeBoard.add(board); 
		}
		request.setAttribute("freeBoard", freeBoard);
	}catch(SQLException e){
		e.printStackTrace();
	}finally{

	if(conn!=null){conn.close();}
	if(pstmt!=null){pstmt.close();}
	if(rs!=null){rs.close();}
	}
	
%>


<div class="container">
	<div class="page-header">
		<h3>์์ ๊ฒ์ํ - <small>๊ธ ๋ชฉ๋ก</small></h3>
	</div>
<div class="row">
    <div class="col-sm-2 col-sm-offset-10 text-right" style="margin-bottom: 5px;" >
        <a href="freeForm.jsp" class="btn btn-primary btn-sm"> 
        	<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
        	&nbsp;์๊ธ์ฐ๊ธฐ
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
			<th>๊ธ๋ฒํธ</th>
			<th>๋ถ๋ฅ</th>
			<th>์ ๋ชฉ</th>
			<th>์์ฑ์</th>
			<th>๋ฑ๋ก์ผ</th>
			<th>์กฐํ์</th>
		</tr>
	</thead>	
	<tbody>
	<c:forEach items="${freeBoard }" var="Board">
		<tr class="text-center">
			<td>${Board.boNo }</td>
			<td>${Board.boCategory }</td>
			<td class="text-left">
				<a href="freeView.jsp?boNo=${Board.boNo }">
					${Board.boTitle }
				</a>
			</td>
			<td>${Board.boWriter }</td>
			<td>${Board.boRegDate }</td>
			<td>${Board.boHit }</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</div><!-- container --> 
</body>
</html>
```

#### freeView
```js
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.study.free.vo.freeBoardVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<title>์์ ๊ฒ์ํ - ๊ธ ๋ณด๊ธฐ</title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top.jsp" %>
<div class="container">
 <%
 

	Connection conn=null; 
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
		StringBuffer sb = new StringBuffer();
		sb.append("select bo_no,		bo_title,		bo_category,		");
		sb.append(" 		  bo_writer,	bo_pass,		bo_content,		");
		sb.append(" 		  bo_ip,	bo_hit,			");
		sb.append(" 		  to_char(bo_reg_date, 'YYYY-MM-DD') AS bo_reg_date,		");
		sb.append(" 		  to_char(bo_mod_date, 'YYYY-MM-DD') AS bo_mod_date,		");
		sb.append(" 		  bo_del_yn									");
		sb.append("from free_board											");
		sb.append("where bo_no=      ? ");
		
		//pstmt๊ฐ์ฑ ์์ฑ
		pstmt=conn.prepareStatement(sb.toString()); 
		//pstmt ? ๊ฐ ์ค์ 
		pstmt.setString(1, request.getParameter("boNo")); 
		//์ฟผ๋ฆฌ์คํ
		rs=pstmt.executeQuery(); 
		List<freeBoardVO> freeBoard = new ArrayList<freeBoardVO>();
		if(rs.next()){
			freeBoardVO board = new freeBoardVO();	
			board.setBoNo(rs.getInt("bo_no")); 
			board.setBoTitle(rs.getString("bo_title")); 
			board.setBoCategory(rs.getString("bo_category")); 
			board.setBoWriter(rs.getString("bo_writer")); 
			board.setBoPass(rs.getString("bo_pass"));
			board.setBoContent(rs.getString("bo_content"));
			board.setBoIp(rs.getString("bo_ip")); 
			board.setBoHit(rs.getInt("bo_hit")); 
			board.setBoRegDate(rs.getString("bo_reg_date")); 
			board.setBoModDate(rs.getString("bo_mod_date")); 
			board.setBoDelYn(rs.getString("bo_del_yn")); 
			freeBoard.add(board); 
			
			request.setAttribute("Board", board);
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}finally{

	if(conn!=null){conn.close();}
	if(pstmt!=null){pstmt.close();}
	if(rs!=null){rs.close();}
	}
	
%>




	<div class="page-header">
		<h3>์์ ๊ฒ์ํ - <small>๊ธ ๋ณด๊ธฐ</small></h3>
	</div>
		<table class="table table-striped table-bordered">
			<tbody>
				<tr>
					<th>๊ธ๋ฒํธ</th>
					<td>${Board.boNo }</td>
				</tr>
				<tr>
					<th>๊ธ์ ๋ชฉ</th>
					<td>${Board.boTitle }</td>
				</tr>
				<tr>
					<th>๊ธ๋ถ๋ฅ</th>
					<td>${Board.boCategory }</td>
				</tr>
				<tr>
					<th>์์ฑ์๋ช</th>
					<td>${Board.boWriter }</td>
				</tr>
				<!-- ๋น๋ฐ๋ฒํธ๋ ๋ณด์ฌ์ฃผ์ง ์์  -->
				<tr>
					<th>๋ด์ฉ</th>
					<td>
					<textarea rows="10" name="boContent" class="form-control input-sm">
					${Board.boContent }
					</textarea>
					</td>
				</tr>
				<tr>
					<th>๋ฑ๋ก์ IP</th>
					<td>${Board.boIp }</td>
				</tr>
				<tr>
					<th>์กฐํ์</th>
					<td>${Board.boHit }</td>
				</tr>
				<tr>
					<th>๋ฑ๋ก์ผ์</th>
					<td>${Board.boRegDate }</td>
				</tr>
				<tr>
					<th>์ญ์ ์ฌ๋ถ</th>
					<td>${Board.boDelYn }</td>
				</tr>
				<tr>
					<td colspan="2">
					  <div class="pull-left">
							<a href="freeList.jsp" class="btn btn-default btn-sm"> 
								<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
								&nbsp;&nbsp;๋ชฉ๋ก
							</a>
						</div>
						<div class="pull-right">
							<a href="freeEdit.jsp?boNo=${Board.boNo }" class="btn btn-success btn-sm"> 
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								&nbsp;&nbsp;์์ 
						  </a>
						</div>
					</td>					  
				</tr>
			</tbody>
		</table>
</div><!-- container -->
</body>
</html>
```

#### freeEdit
```js
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.study.free.vo.freeBoardVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/inc/header.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/inc/top.jsp"%>
	
	
	<%
	Connection conn=null; 
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
		StringBuffer sb = new StringBuffer();
		sb.append("select bo_no,		bo_title,		bo_category,		");
		sb.append(" 		  bo_writer,	bo_pass,		bo_content,		");
		sb.append(" 		  bo_ip,	bo_hit,			");
		sb.append(" 		  to_char(bo_reg_date, 'YYYY-MM-DD') AS bo_reg_date,		");
		sb.append(" 		  to_char(bo_mod_date, 'YYYY-MM-DD') AS bo_mod_date,		");
		sb.append(" 		  bo_del_yn									");
		sb.append("from free_board											");
		sb.append("where bo_no=      ? ");
		
		//pstmt๊ฐ์ฑ ์์ฑ
		pstmt=conn.prepareStatement(sb.toString()); 
		//pstmt ? ๊ฐ ์ค์ 
		pstmt.setString(1, request.getParameter("boNo")); 
		//์ฟผ๋ฆฌ์คํ
		rs=pstmt.executeQuery(); 
			List<freeBoardVO> freeBoard = new ArrayList<freeBoardVO>();
		if(rs.next()){
			freeBoardVO board = new freeBoardVO();	
			board.setBoNo(rs.getInt("bo_no")); 
			board.setBoTitle(rs.getString("bo_title")); 
			board.setBoCategory(rs.getString("bo_category")); 
			board.setBoWriter(rs.getString("bo_writer")); 
			board.setBoPass(rs.getString("bo_pass"));
			board.setBoContent(rs.getString("bo_content"));
			board.setBoIp(rs.getString("bo_ip")); 
			board.setBoHit(rs.getInt("bo_hit")); 
			board.setBoRegDate(rs.getString("bo_reg_date")); 
			board.setBoModDate(rs.getString("bo_mod_date")); 
			board.setBoDelYn(rs.getString("bo_del_yn")); 
			freeBoard.add(board); 
			
			request.setAttribute("Board", board);
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}finally{

	if(conn!=null){conn.close();}
	if(pstmt!=null){pstmt.close();}
	if(rs!=null){rs.close();}
	}
	
%>
	
	
	
	<div class="container">
		<div class="page-header">
			<h3>
				์์ ๊ฒ์ํ - <small>๊ธ ์์ </small>
			</h3>
		</div>
		<form action="freeModify.jsp" method="post">
			<table class="table table-striped table-bordered">
				<colgroup>
					<col width="20%" />
					<col />
				</colgroup>
				<tr>
					<th>๊ธ๋ฒํธ</th>
					<td>${Board.boNo } <input type="hidden" value="${Board.boNo }" name="boNo"> </td>

				</tr>
				<tr>
					<th>์ ๋ชฉ</th>
					<td>
						<input type="text" name="boTitle" value="${Board.boTitle }" class="form-control input-sm" required="required">
					</td>
				</tr>
				<tr>
					<th>์์ฑ์</th>
					<td>
						<input type="text" name="boWriter" value="${Board.boWriter }" class="form-control input-sm" required="required" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>๋น๋ฐ๋ฒํธ</th>
					<td>
						<input type="password" name="boPass" value="${Board.boPass }" 
						class="form-control input-sm" required="required" pattern="\w{4,}" title="์ํ๋ฒณ๊ณผ ์ซ์๋ก 4๊ธ์ ์ด์ ์๋ ฅ"> <span class="text-danger"> <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> ๊ธ ๋ฑ๋ก์์ ์๋ ฅํ ๋น๋ฐ๋ฒํธ๋ฅผ ์๋ ฅํ์ธ์.
						</span>
					</td>
				</tr>
				<tr>
					<th>๋ถ๋ฅ</th>
					<td>
						<select name="boCategory" class="form-control input-sm" required="required">
							<option value="">-- ์ ํํ์ธ์--</option>
							<option value="BC01" ${board.boCategory eq "BC01" ? "selected='selected'":""}>ํ๋ก๊ทธ๋จ</option>
							<option value="BC02" ${board.boCategory eq "BC02" ? "selected='selected'":""}>์น</option>
							<option value="BC03" ${board.boCategory eq "BC03" ? "selected='selected'":""}>์ฌ๋ ์ด์ผ๊ธฐ</option>
							<option value="BC04" ${board.boCategory eq "BC04" ? "selected='selected'":""}>์ทจ์</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>๋ด์ฉ</th>
					<td>
						<textarea rows="10" name="boContent" class="form-control input-sm">
						${Board.boContent }
						</textarea>
					</td>
				</tr>
				<tr>
					<th>IP</th>
					<td>${Board.boIp }</td>
				</tr>
				<tr>
					<th>์กฐํ์</th>
					<td>${Board.boHit }</td>
				</tr>
				<tr>
					<th>๋ฑ๋ก์ผ์</th>
					<td>${Board.boRegDate }</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="pull-left">
							<a href="freeList.jsp" class="btn btn-default btn-sm"> <span class="glyphicon glyphicon-list" aria-hidden="true"></span> &nbsp;&nbsp;๋ชฉ๋ก
							</a>
						</div>
						<div class="pull-right">
							<!-- ๋ฌธ์ ์  : ์ฌ์ฉ์๊ฐ ์๋ ฅ๋ฐ์ค์์ ์ํฐ๋ฅผ ์น๋ฉด ์ฒซ๋ฒ์งธ submit์ formaction ๋ฐฉํฅ์ผ๋ก ์ด๋ํ๋ค.  -->
							<button type="submit" formaction="freeDelete.jsp" class="btn btn-sm btn-danger">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> &nbsp;&nbsp;์ญ์ 
							</button>
							<button type="submit" class="btn btn-sm btn-primary">
								<span class="glyphicon glyphicon-save" aria-hidden="true"></span> &nbsp;&nbsp;์ ์ฅ
							</button>
						</div>
					</td>
				</tr>
			</table>
		</form>

	</div>
	<!-- container -->
</body>
</html>
```

#### freeModify
```js
<%@page import="com.study.free.vo.freeBoardVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

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

<jsp:useBean id="board" class="com.study.free.vo.freeBoardVO" ></jsp:useBean>
<jsp:setProperty property="*" name="board"/> <!--Post ํ๋ผ๋ฏธํฐ๋ฅผ ์๋์ผ๋ก ๋ฐ์์ค name์ผ๋ก -->

<%-- <%
out.print();
%> --%>

<%

	Connection conn=null; 
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
		StringBuffer sb = new StringBuffer();
		sb.append("update free_board set     ");
		sb.append("bo_title= ?            ,"); 
		sb.append("bo_category= ?            ,"); 
		sb.append("bo_pass= ?            ,"); 
		sb.append("bo_content= ?            ,"); 
		sb.append("bo_mod_date= sysdate            "); 
		sb.append("where bo_no= ?       "); 		
		
		//pstmt๊ฐ์ฑ ์์ฑ
		pstmt=conn.prepareStatement(sb.toString()); 
		//pstmt ? ๊ฐ ์ค์ 
		int i = 1 ; 

		pstmt.setString(i++, board.getBoTitle()); 
		pstmt.setString(i++, board.getBoCategory()); 
		pstmt.setString(i++, board.getBoPass()); 
		pstmt.setString(i++, board.getBoContent()); 
		pstmt.setInt(i++, board.getBoNo()); 
		//์ฟผ๋ฆฌ์คํ
		int cnt = pstmt.executeUpdate();
		
		if(cnt == 1){
			request.setAttribute("cnt", cnt); 
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}finally{

	if(conn!=null){conn.close();}
	if(pstmt!=null){pstmt.close();}
	if(rs!=null){rs.close();}
	}
	
%>

<div class="container">	
	<h3>๊ธ ์์ </h3>		
		<c:if test="${cnt==1 }">
			<div class="alert alert-success">
				์ ์์ ์ผ๋ก ์์ ํ์ต๋๋ค.
			</div>		
		</c:if>
	
		<c:if test="${cnt!=1 }">
			<div class="alert alert-warning">
			ํด๋น ๊ธ์ด ์กด์ฌํ์ง ์์ต๋๋ค.
			</div>	
		</c:if>
</div>
	<a href="freeList.jsp?" class="btn btn-default btn-sm">
		<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
		&nbsp;๋ชฉ๋ก
	</a>


</body>
</html>
```



## ์ถ๊ฐํด์ผ๋จ
#### freeForm
```js

```

#### freeRegist
```js

```

#### freeDelete
```js

```




