<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Lab 05</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <style>
            table, th, td {border: 1px solid black; border-collapse: collapse;}
    </style>
    <body>
        
        
        <h3>Ilosc odwiedzin: ${sessionScope.timer}</h3>
        
        <h1>Students List</h1>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
            <c:forEach items="${sessionScope.studentList}" var="s">
               
                <tr>
                    <td>${s.getName()}</td>
                    <td>${s.getLastName()}</td>
                    <td>${s.getEmail()}</td>
                </tr>
            
            </c:forEach>
        </table>
        <form action='/Lab05/index' method='post'>
            Przedstaw sie:
            <input type='text' name='imie'>
            <input type='text' name='nazwisko'>
            <input type='text' name='email'>
            <input type='submit'>
        </form>
        <br/>
    </body>
</html>
