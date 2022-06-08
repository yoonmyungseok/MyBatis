<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>title</title>
<style>
    .login-area a{
        text-decoration: none;
        color:black;
        font-size:12px;
    }
    .nav-area{
        background-color:black;
        color:white;
        height:50px;
    }
    .menu{
        display: table-cell;
        width: 250px;
        height: 50px;
        vertical-align: middle;
        font-style: 20px;
        font-weight: bold;
    }
    .menu:hover{
        background-color: darkgray;
        cursor: pointer;
    }
    .outer{
        width: 900px;
        background:black;
        color:white;
        margin:auto;
        margin-top: 50px;
    }
</style>
</head>
<body>
    <h1 align="center">Welcome to MyBatis World</h1>
    <br>
    <div class="login-area" align="right">
        <c:choose>
            <c:when test="${empty sessionScope.loginUser}">
            <!--case1. 로그인전-->
                <form action="login.me" method="post">
                    <table>
                        <tr>
                            <td>아이디</td>
                            <td><input type="text" name="userId" required></td>
                            <td rowspan="2">
                                <button type="submit" style="height: 50px;">로그인</button>
                            </td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><input type="password" name="userPwd" required></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td colspan="3" align="center">
                                <a href="enrollForm.me">회원가입</a>
                                <a href="">ID/비밀번호 찾기</a>
                            </td>
                        </tr>
                    </table>
                </form>
            </c:when>
            <c:otherwise>
                <!--case2. 로그인후-->
                <div>
                    <table>
                        <tr>
                            <td colspan="2">
                                <h3>${sessionScope.loginUser.userName}님 환영합니다 ^^</h3>
                            </td>
                        </tr>
                        <tr>
                            <td><a href="">마이페이지</a></td>
                            <td><a href="">로그아웃</a></td>
                        </tr>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    <br>
    <div class="nav-area" align="center">
        <div class="menu">HOME</div>
        <div class="menu">공지사항</div>
        <div class="menu" onclick="location.href='list.bo?currentPage=1';">게시판</div>
        <div class="menu">ETC</div>
    </div>
</body>
</html>