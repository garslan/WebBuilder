<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Create project</title>
</head>
<body>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
<script type="text/javascript" src="/resources/js/createProject.js"></script>

<div align="center">
    <h2>CREATE PROJECT</h2>
</div>
<div class="container">

    <c:if test="${projectAmount > 0}">
        <c:url value="/project/all" var="listProject"/>
        <form action="${listProject}" method="get">
            <p>Found projects: ${projectAmount}
                    <button class="btn btn-success btn-sm">
                        show list
                    </button>
              </p>
        </form>
    </c:if>


    <c:url value="/project/edit" var="createProjectUrl"/><!-- will not depend on url we are situated -->
    <form class="form-horizontal" action="${createProjectUrl}" method="post">
        <p>Create default project
            <button  type="submit" class="btn btn-success btn-sm">
                Create
            </button>
        </p>
    </form>

    <form:form action="${createProjectUrl}" modelAttribute="project" method="post">
        Create project with:
        <table>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" id="name" required="yes"/></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><form:input path="description" id="description"/></td>
            </tr>
            <tr>
                <td></td>
                <br>
                <td>
                    <a class="pull-right">
                        <button class="btn btn-success btn-sm" type="submit" onclick="inputValid()">
                            Create
                        </button>
                    </a>
                </td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
