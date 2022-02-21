<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual Health System</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">

    <link rel="stylesheet" href="/pub/css/style.css">

</head>
<body>

<header>

    <div class="container">

        <a href="#" class="logo"><span>V</span>irtual<span>H</span>ealth<span>C</span>are</a>

        <nav class="nav">
            <ul>
                    <li><a href="/index" >Home</a></li>
                <li><a href="about.html" target="_parent">About</a></li>
                <li><a href="doctors.html" target="_parent">Doctors</a></li>
                <li><a href="appointments.html" target="_parent">appointments</a></li>
                <sec:authorize access="isAuthenticated()">
                    <li><a href="/login/logout">Signout</a></li>

                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/login/login">Signin</a></li>

                </sec:authorize>
<%--                <li><a href="login/login" target="_parent">Sign in</a></li>--%>
<%--                <li><a href="/logout">Signout</a></li>--%>
            </ul>
        </nav>

        <div class="fas fa-bars"></div>

    </div>

</header>

