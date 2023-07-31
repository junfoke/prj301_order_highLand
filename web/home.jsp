<%-- 
    Document   : home
    Created on : Feb 27, 2023, 6:14:20 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <div id="logo" style="position: absolute;  top: 10px;  right: 350px;">
            <img style="width: 100px;" src="https://upload.wikimedia.org/wikipedia/vi/thumb/c/c9/Highlands_Coffee_logo.svg/800px-Highlands_Coffee_logo.svg.png" alt="alt"/>
        </div>    
</head>
<body>
    <br>
    <%@include file="head_cate.jsp" %>

    <br><br><br>


    <div class="row">
        <div class="col-md-5" style="background-color:lavender;">

            <div class="show_order">
                <%@include file="left_order.jsp" %>
            </div>
        </div>
        <div class="col-md-7" style="background-color: #f2dede">
            <div class="show_product">
                <%@include file="right_item.jsp" %>
            </div>
        </div>
    </div>


    <div class="chuc_nang">
        <div>
            <button style="position: fixed;    bottom: 35px;    right: 180px; "><a href="reportOrder.jsp">View Order By Time</a></button>

            <form action="logout" method="post">
                <button type="submit" name="exit" style="position: fixed;    bottom: 35px;    right: 90px; ">Log Out</button>
            </form>
        </div>
    </div>        
</body>
</html>
