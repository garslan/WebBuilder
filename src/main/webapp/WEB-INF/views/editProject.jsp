<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>Edit project</title>
    <link rel="stylesheet" href="/resources/css/main.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="/resources/jquery/jquery-ui.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">

    <style>
        h1 {
            padding: .2em;
            margin: 0;
        }

        h2 {
            text-align: center;
        }

        #platform {
            width: 100%;
            height: 80%;
            align-self: center
        }

        .placeholder {
            width: 80%;
            height: 80%;
            align-content: center;
        }

        .place {
            width: 80%;
            height: 80%;
            align-content: center;
        }

        /* style the list to maximize the droppable hitarea */
        #ol {
            margin: 0;
            padding: 1em 0 1em 3em;
        }
    </style>
</head>

<body>
<div id="wrapper">
        <div id="content">
            <header>
                <h1>EDIT</h1>
            </header>

            <b>
                <p>Project name: ${project.name}</p>
                <p>Project id: ${project.id}</p>
                <p>Project description: ${project.description}</p>
            </b>

            <%--Platform--%>
            <b><p>Choose platform:
            <input type="radio" name="platformType" value="phone" id="phoneRadio" checked> Phone
            <input type="radio" name="platformType" value="tablet" id="tabletRadio"> Tablet
            </p></b>

            <button class="btn btn-success btn-sm" type="submit" onclick="saveData()">
                Save project
            </button>

            <br>
            <br>
            <table id="table">
                <tr>
                    <td>
                        <section>
                            <h2>Widgets</h2>

                            <c:if test="${empty allBaseWidgets}">
                                <h1>There are no widgets.</h1>
                            </c:if>

                            <c:if test="${!empty allBaseWidgets}">
                                <div>
                                    <c:forEach var="widget" items="${allBaseWidgets}">

                                        <div class="widget ui-draggable" title="${widget.name}" draggable="true">
                                            <img src="${widget.imageUrl}" width="20" height="20" alt="${widget.name}"/>

                                            <div>
                                                <b><p id="name">${widget.name}</p></b>
                                                <b><p id="id" hidden="true">${widget.id}</p></b>
                                            </div>
                                        </div>

                                        <br/>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </section>
                    </td>
                    <td>
                        <section>
                            <div id="platform">
                                <h2 align="center">Platform</h2>
                                <center>
                                    <div class="platform">
                                        <center>
                                            <ol class="place">
                                                <li class="placeholder">Drop widget here</li>

                                            </ol>
                                        </center>
                                    </div>
                                </center>
                            </div>
                        </section>
                    </td>
                    <td>
                        <section>
                            <h2>Settings</h2>

                            <div id="settings">


                            </div>
                        </section>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <h2>Events</h2>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <p align="center">Some data</p>

                    </td>
                </tr>
            </table>
            <br>

            <footer>
                <p align="center">&copy; Web builder</p>
                <script type="text/javascript" src="/resources/jquery/jquery.js"></script>
                <script type="text/javascript" src="/resources/jquery/jquery-ui.js"></script>
                <script type="text/javascript" src="/resources/js/editProject.js?v=3"></script>
            </footer>
        </div>
</div>
</body>
</html>
