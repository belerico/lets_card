<%--
  Created by IntelliJ IDEA.
  User: avogadro
  Date: 09/01/19
  Time: 21.50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <%--<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Cards</title>
    <style>
        .container {
            width: 60%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Cards</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">CardNumber</th>
            <th scope="col">Type</th>
            <th scope="col">Quantity</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="cards" status="cardsStatus" var="c">
            <tr>
                <th scope="row">
                    <s:property value="#cardsStatus.index"/>
                    <s:hidden name="idCard" value="%{id}" />
                </th>
                <td>
                    <s:property value="cardNumber"/>
                </td>
                <td>
                    <s:if test="%{#c instanceof com.assignment3.jpa.model.SharableCard}">
                        Sharable card
                    </s:if>
                    <s:else>
                        Standard card
                    </s:else>
                </td>
                <td>
                    <s:property value="quantity"/>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <span><a href="<s:url action='cardPage'/>">Remove all cards</a></span><br>
    <span><a href="<s:url action='cardPage'/>">Cards</a></span><br>
    <span><a href="<s:url action='goIndex'/>">Go back to home</a></span>
</div>
</body>
</html>