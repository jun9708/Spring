<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>user3::list</title>
</head>
<body>
<h3>user3 목록</h3>

<a href="/ch05">메인</a>
<a href="/ch05/user4/register">등록</a>

<table border="1">
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>생년월일</th>
        <th>주소</th>
        <th>관리</th>
    </tr>

    <c:forEach var="member" items="${members}">
        <tr>
            <td>${member.uid}</td>
            <td>${member.name}</td>
            <td>${member.birth}</td>
            <td>${member.hp}</td>
            <td>${member.addr}</td>
            <td>
                <a href="/ch05/user4/modify?uid=${user.uid}">수정</a>
                <a href="/ch05/user4/delete?uid=${user.uid}">삭제</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>