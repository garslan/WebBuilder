<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">

<head>
    <title>List of Project</title>
</head>
<body>
<div align="center">
    <h2>List of Projects</h2>
</div>
<c:if test="${empty allProjects}">
    <h1>There are no projects.</h1>
</c:if>

<c:if test="${!empty allProjects}">
    <c:url value="/project/edit" var="editProjectUrl"/>
        <p>Project list:</p>
        <ul>
            <c:forEach var="project" items="${allProjects}">
                <li>
                    <a href="<c:url value="${editProjectUrl}/${project.id}"/>">
                        <h2>${project.name}</h2>
                    </a>
                    <p>${project.id}</p>
                </li>
            </c:forEach>
        </ul>
    </form>
</c:if>
</section>
</body>
</html>
