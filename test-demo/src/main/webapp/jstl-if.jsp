<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2025/4/29
  Time: 09:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page isELIgnored="false" %>
<!-- 这个是启用el表达式 -->


<html>
<head>
    <title>Title</title>
</head>
<body>
  <!-- c:if
    test里面写判断条件
    el表达式来获取数据
    jstl来判断
  -->
<%--    <c:if test="true">--%>
<%--        <h1>true</h1>--%>
<%--    </c:if>--%>
<%--    <c:if test="false">--%>
<%--        <h1>false</h1>--%>
<%--    </c:if>--%>

  <c:if test="${status == 1}">
      <h1>true</h1>
  </c:if>
  <c:if test="${status == 0}">
      <h1>false</h1>
  </c:if>

</body>
</html>
