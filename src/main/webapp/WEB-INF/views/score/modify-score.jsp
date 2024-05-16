<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <!-- reset css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">

    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">


    <!-- bootstrap js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" defer></script>

    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


    <style>
      label {
        display: block;
      }

      .score-list>li {
        margin-bottom: 10px;
      }

      .score-list>li:first-child {
        font-size: 1.2em;
        color: blue;
        font-weight: 700;
        border-bottom: 1px solid skyblue;
      }

      .del-btn {
        width: 10px;
        height: 10px;
        background: red;
        color: #fff;
        border-radius: 5px;
        margin-left: 5px;
        text-decoration: none;
        font-size: 0.7em;
        padding: 6px;
      }

      .del-btn:hover {
        background: orangered;
      }

      section.score {
        padding: 50px 50px 100px;
        font-size: 1.5em;
      }

      .list-header {
        display: flex;
        justify-content: space-between;

        width: 50%;
      }
      .list-header .sort-link-group {
        display: flex;

      }
      .list-header .sort-link-group div {
        margin-right: 20px;
      }

    </style>

</head>
<body>

<div class="wrap">

    <section class="score">
        <h1>시험 점수 등록</h1>
        <form action="/score/update?stuNum=${tar.stuNum}" method="POST">
            <label>
                # 이름: <span>${tar.stuName}</span>
                <input type="hidden" name="name" value="${tar.stuName}" >
            </label>
            <label>
                # 국어: <input type="text" name="kor" value="${tar.kor}">
            </label>
            <label>
                # 영어: <input type="text" name="eng" value="${tar.eng}">
            </label>
            <label>
                # 수학: <input type="text" name="math" value="${tar.math}">
            </label>
            <label>
                <button type="submit">확인</button>
                <button id="go-home" type="button">홈화면으로</button>
            </label>
        </form>
        <hr>
    </section>

</div>
</body>
</html>