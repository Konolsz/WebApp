


<%@ page language="java" contentType="text/html; utf8_polish_ci "
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <html>
    <style>
    body{
background-color:silver;
}
    </style>
    
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>MENU</h2></caption>
            <tr>
                <th>id</th>
                <th>pizza</th>
                <th>dodatki</th>
                <th>danie</th>
                <th>dodatki</th>
                 <th>zupy</th>
                  <th>napoje</th>
                   <th>uwagi</th>
                    <th>koszt</th>
            </tr>
            <c:forEach var="c" items="${wyswietl}">
                <tr>
                    <td><c:out value="${c.idCennik}" /></td>
                    <td><c:out value="${c.pizza}" /></td>
                    <td><c:out value="${c.dodatkiPizza}" /></td>
                    <td><c:out value="${c.danie}" /></td>
                    <td><c:out value="${c.dodatkiDanie}" /></td>
                    <td><c:out value="${c.zupy}" /></td>
                    <td><c:out value="${c.napoje}" /></td>
                    <td><c:out value="${c.uwagi}" /></td>
                    <td><c:out value="${c.koszt}" /></td>
                    <td>
                                          
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</html>