<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Duch Airlines</title>
    <meta charset="utf-8">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<img width="100%" height="50%" src="include/logo.jpg">
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <div class="navbar-header">
                <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-send"></span>  Duch Airlines</a>
            </div>


        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="/airport"><span class="glyphicon glyphicon-home"></span>  Home</a></li>

                <c:if test="${user.role==1}">
                    <li><a href="airport?command=ListUsers"><span class="glyphicon glyphicon-list-alt"></span>  List Users</a></li>
                    <li><a href="airport?command=NewFlight"><span class="glyphicon glyphicon-plane"></span>  New flight</a></li>
                    <li><a href="airport?command=StuffingCrew"><span class="glyphicon glyphicon-bullhorn"></span>  Add Flight Crew</a></li>
                </c:if>
                <c:if test="${user.role==2}">
                    <li><a href="airport?command=StuffingCrew"><span class="glyphicon glyphicon-send"></span>  Add Flight Crew</a></li>
                </c:if>

                <%--<li><a href="#"><span class="	glyphicon glyphicon-alert"></span> ${jsp_error}</a></li>--%>
                <li><a href="#"> ${jsp_error}</a></li>


            </ul>

            <ul class="nav navbar-nav navbar-right">
                <c:if test="${user==null}">
                    <li><a href="airport?command=Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    <li><a href="airport?command=SignUp"><span class="glyphicon glyphicon-user"></span> SignUp</a></li>
                </c:if>
                <c:if test="${user!=null}">
                    <li><a href="#" data-toggle="tooltip" title="${curUser}"><span class="glyphicon glyphicon-check"></span>  user=${user.login}</a></li>
                    <li><a href="airport?command=Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                    <li><a href="airport?command=Profile"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<div class="row content">
    <div class="col-sm-2 sidenav"></div>
    <div class="col-sm-8 text-left">