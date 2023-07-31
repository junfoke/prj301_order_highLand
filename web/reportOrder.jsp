<%-- 
    Document   : reportOrder
    Created on : Mar 15, 2023, 12:07:56 PM
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
        <h1>View Order</h1>

        <form action="reportorder" method="get">       
            <span>From : </span>
            <input type ="date" name="fromdate"> <br>  <br>
            <span>To :</span>
            <input type ="date" name="todate"><br> <br>
            <input type="submit" value="OK" name="submit"> <br>


            <c:forEach var="o1" items="${listO}">
                OrderID:${o1.getOrderID()} Amount: ${o1.getAmmount()}
                <table border="1">
                    <tr>
                        <th>ProductID</th>
                        <th>Name</th>
                        <th>Quantity</th>
                    </tr>

                    <c:forEach var="o" items="${list}" >
                        <c:if test="${o1.getOrderID()==o.getOrderID()}">
                            <tr>
                                <td>${o.getProductID()}</td>
                                <td>${o.getName()}</td>
                                <td>${o.getQuantity()}</td>
                            </tr>
                        </c:if>

                    </c:forEach>
                </table>
                <br>
            </c:forEach>
                <br>





            <table border="1">
                <thead>
                    <tr>
                        <th>OrderID</th>
                        <th>ProductID</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Date</th>
                        <th>Amount</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="o" items="${list}" >
                        <tr>
                            <td>${o.getOrderID()}</td>
                            <td>${o.getProductID()}</td>
                            <td>${o.getName()}</td>
                            <td>${o.getQuantity()}</td>
                            <td>${o.getDate()}</td>
                            <td>${o.getAmount()}</td>
                        </tr>
                    </c:forEach>
                </tbody>                        
            </table>
            <br>                    
        </form>

        <button><a href="pay">  Return Home</a></button>

    </body>
</html>
