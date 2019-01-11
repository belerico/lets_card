<%--
  Created by IntelliJ IDEA.
  User: co
  Date: 09/01/19
  Time: 14.00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Create business activity</title>
    <style>
        .container {
            width: 60%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
    <s:head/>
</head>
<body>
<div class="container">
    <h1>Fill form to register a new business activity into the webapp</h1>
    <s:form action="createActivity">
        <s:fielderror cssClass="alert alert-danger">
            <s:param>activity.name</s:param>
            <s:param>activity.type</s:param>
        </s:fielderror>
        <div class="form-group">
            <s:label for="name" value="Name"/>
            <s:textfield cssClass="form-control" name="activity.name" value="%{ activity.name }" requiredLabel="true"/>
        </div>
        <div class="form-group">
            <s:label for="type" value="Type"/>
            <s:textfield cssClass="form-control" name="activity.type" value="%{ activity.type }" requiredLabel="true"/>
        </div>
        <div class="form-group">
            <s:label for="places" value="Place"/>
            <s:select cssClass="form-control"
                      list="places"
                      listKey="id"
                      listValue="CAP + ', ' + city"
                      name="placeId"/>
        </div>
        <s:submit cssClass="btn btn-secondary" label="Create activity"/>
    </s:form>
    <span><a href="<s:url action='showActivities'/>">Show all business activities</a></span><br>
    <span><a href="<s:url action='activityPage'/>">Activity page</a></span><br>
    <span><a href="<s:url action='goIndex'/>">Home</a></span>
</div>
</body>
</html>
