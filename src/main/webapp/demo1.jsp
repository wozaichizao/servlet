<%@ page pageEncoding="UTF-8"%>
<!-- 
	jsp页面编译成的servlet放置在{tomcat_path}\work\Catalina\localhost\servlet\org\apache\jsp
 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
response.getWriter().write(basePath);
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>首页</title>
    <style type="text/css">
        * { font-family: "Arial"; }
    </style>
  </head>

  <body>
    <h1>Hello, World!</h1>
    <hr/>
    <h2>Current time is: <%= new java.util.Date().toString() %></h2>
  </body>
</html>