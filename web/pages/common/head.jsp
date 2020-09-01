<%--
  Created by IntelliJ IDEA.
  User: 17150
  Date: 2020/8/26
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<base href="<%=basePath%>">

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>