<%-- 
    Document   : head
    Created on : Mar 7, 2023, 2:47:19 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <c:forEach items="${dataCate}" var="cate">
            <button style="font-size: 20px; padding: 10px 20px; background-color: bisque;"><a href="product?cateID=${cate.getCateID()}"> ${cate.getCname()} </a></button>
        </c:forEach>
    </body>
</html>
