<%-- 
    Document   : left
    Created on : Mar 7, 2023, 2:47:10 PM
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
        <p id="date" style="color: blue"></p>
        <p id="time" style="color: blue"></p>
        <table border="1" >
            <thead>
                <tr>
                    <th>No</th>
                    <th>ProductID</th>
                    <th>Name</th>
                    <th>Size</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Amount</th>
                </tr>
            </thead>
            
            <c:set var="t" value="0"/>
            <c:set var="o" value="${sessionScope.cart.item}"/>
            <c:set var="o1" value="${sessionScope.cart}"/>
            <c:forEach var="i" items="${o}">         
                <c:set var="t" value="${t+1}"/>
                <tbody>
                    <tr>
                        <td>${t}</td>
                        <td>${i.getProduct().getId()}</td>                        
                        <td>${i.getProduct().getName()}</td>
                        <td>${i.getProduct().getSize()}</td>
                        <td>${i.getPrice()}00 VNÐ</td>

                        <td>
                            <button><a href="process?quantity=-1&ProductCode=${i.getProduct().getId()}&cateID=${i.getProduct().getCateID()}">-</a></button>
                            <input type="text" style="width: 100px" readonly value="${i.getQuantity()}"/>
                            <button><a href="process?quantity=1&ProductCode=${i.getProduct().getId()}&cateID=${i.getProduct().getCateID()}">+</a></button>
                        </td>               
                        <td>${i.getQuantity()*i.getPrice()}00 VNÐ</td>
                    </tr>
                </tbody>
            </c:forEach>
        </table><br>
         
        TotalAmount: ${o1.getTotal()}00 VNÐ
        <form action="pay" method="post">
            <input type="submit" value="Thanh Toán" name="tt">
        </form>
    </body>
    <style>
        a{
            text-decoration: none;
        }
        table{
        border-collapse: collapse;    
        }
    </style>
    <script> 
        var today = new Date(); // tạo đối tượng Date 
        var date = today.getDate() + "-" + (today.getMonth() + 1) + "-" + today.getFullYear(); // lấy ngày tháng năm 
        var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds(); // lấy giờ phút giây 
        document.getElementById("date").innerHTML = "Date: "+date; // hiển thị ngày tháng năm trên jsp 
        document.getElementById("time").innerHTML = "Time: "+time; // hiển thị giờ phút giây trên jsp 
    </script>
</html>
