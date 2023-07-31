<%-- 
    Document   : right_item
    Created on : Mar 7, 2023, 2:47:55 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="f" action="order" method="post">
            <c:forEach items="${dataPro}" var="pro">
                <div class="list_pro" style="display: inline-block; width: 30%">
                    <button onclick="buy('${pro.getId()}','${pro.getCateID()}')" style="font-size: 16px;width:100%; padding: 10px 20px;
                            background-color: darkseagreen;">${pro.getName()} ${pro.getSize()}<br>${pro.getPrice()}00.Ð 
                    </button>
                </div>
            </c:forEach>
        </form>

    </body>
</html>
<script type="text/javascript">
    function buy(ProductCode, cateID) {
        document.f.action = "order?ProductCode="+ProductCode+"&cateID="+cateID;
        document.f.submit();
    }
</script>
