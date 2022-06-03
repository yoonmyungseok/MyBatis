<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>title</title>
</head>
<body>
    <!--
        *   프레임워크
        -   개발자가 보다 편리한 환경에서 개발할 수 있도록 제공하는 뼈대, 틀이라고 생각
        -   소프트웨어 개발의 입장으로써는 라이브러리 / 개발도구/ 인터페이스 등등을 포괄적으로 의미

        *   왜 프레임워크를 쓰는가? 필요성
        -   현재 웹프로그래밍 규모가 커지고 있음
            =>거대하고 복잡도가 높은 프레임워크를 완성시키기 위해서는 많은 개발자들이 필요함
            =>그 개발자들이 "통일성" 있게 "빠르고" "안정적"으로 웹사이트를 개발하기 위한 것으로
            프레임워크가 좋은 성과를 내고 있음(가이드라인을 제공하기 때문에)
            =>즉, 생산성 향상에 큰 도움이 된다.
        
        *   프레임워크의 장단점
        >   장점:   개발 시간을 줄일 수 있음
                    오류로부터 약간 자유로워 질 수 있음
        >   단점:   너무 의존하다보면 개발능력이 떨어져서 프레임워크 없이 개발하는것이 어려워짐
                    습득하는데 까지 시간이 오래걸릴 수 있음

        *   프레임워크의 종류
        -   영속성: 데이터 관련한 (CRUD) 기능들을 편리하게 작업할 수 있도록 하는 프레임워크
                    ex)MyBatis, Hibernate
        -   자바:   웹 애플리케이션에 초점을 맞춰서 필요한 요소들을 모듈화해서 제공해주는 프레임워크
                    ex)Spring, Struts
        -   화면구현:   Front-end를 보다 쉽게 구현할 수 있게 틀을 제공해주는 프레임워크
                    ex)Bootstrap
        -   기능 및 지원:   특정 기능이나 업무 수행에 도움을 주는 기능을 제공하는 프레임워크
                    ex)Log4j, JUnit
    -->
    여기는 index.jsp야

    <!--
        스프링에서는 views 폴더가 WEB-INF 폴더 안에 자동으로 들어가있음
        그런데 WEB-INF 폴더는 url 주소로 직접 접근이 불가능한 폴더임
        =>index.jsp를 띄워주되 (localhost:8888/mybatis) 화면은 main.jsp를 보여줄 수 있도록 "포워딩"으로 지정해줄 예정
    -->
    <jsp:forward page="WEB-INF/views/main.jsp"/>
</body>
</html>