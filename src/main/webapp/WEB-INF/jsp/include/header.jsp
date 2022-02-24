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
                <li><a href="/about" target="_parent">About</a></li>
                <li><a href="/doctors" target="_parent">Doctors</a></li>
                <li>
<%--                    <a href="/appointments" target="_parent">Appointments</a>--%>
                    <div class="dropdown">
                        <button class="dropbtn">Appointments</button>
                        <div class="dropdown-content">
                            <a href="/appointmentform">Make an appointment</a>
                            <sec:authorize access="isAuthenticated()">
                            <a href="/appointmentList">View appointments </a>
                            </sec:authorize>
                        </div>
                    </div>

                </li>
                <sec:authorize access="hasAnyAuthority('ADMIN', 'USER')">

<%--                    <li><a href="/user/fileUpload">Upload Records</a></li>--%>
                    <li>
                        <div class="dropdown">
                            <button class="dropbtn">Records</button>
                            <div class="dropdown-content">
                                <a href="/user/fileUpload">Upload records</a>
                                <a href="/user/fileUpload">View records</a>

                            </div>
                        </div>
                    </li>

                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li><a href="/login/logout">Signout</a></li>

                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/login/login">Signin</a></li>

                </sec:authorize>

            </ul>
        </nav>

        <div class="fas fa-bars"></div>

    </div>

</header>

