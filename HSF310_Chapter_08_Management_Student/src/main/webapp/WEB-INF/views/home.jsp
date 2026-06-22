<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Demo Spring MVC</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="" name="author" />
    <!-- BEGIN GLOBAL MANDATORY STYLES -->

    <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
    <link href="resources/css/layout.css" rel="stylesheet" type="text/css" />
    <link href="resources/css/darkblue.css" rel="stylesheet" type="text/css" id="style_color" />
    <!-- END THEME LAYOUT STYLES -->

    <link rel="shortcut icon" href="favicon.ico" />
    <link href="resources/css/gof.css" rel="stylesheet" type="text/css" />
    <link href="resources/css/modal_message.css" rel="stylesheet" type="text/css" />

</head>

<body>

    <div class="clearfix"></div>

    <div class="container">
        <div class="row" style="margin-top: 5px">
            <div class="col-md-12 col-xs-12 col-sm-12">
                <div class="portlet light bordered" style="min-height: 170px">
                    <div style="margin-bottom: 20px;">
                        <img src="resources/images/User.png" class="title-icons" alt="Logo" width="32" height="32" />
                        <span class="caption-subject font-dark bold" style="font-size: 22px; font-weight: 500;">Manage Users</span>
                    </div>

                    <div class="row" style="margin-top: 5px">
                        <div class="col-md-12">
                            <div>
                                <input id="collapsible3" class="toggle" type="checkbox" checked style="display:none;" />
                                <label for="collapsible3" class="lbl-toggle" style="cursor: pointer; display: block; font-weight: bold; margin-bottom: 10px;">User Lists</label>
                                <div class="collapsible-content">
                                    <div>
                                        <table>
                                            <thead>
                                                <tr>
                                                    <th>Choose</th>
                                                    <th>ID</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Marks</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:if test="${not empty studentList}">
                                                    <c:forEach var="student" items="${studentList}" varStatus="STT">
                                                        <tr>
                                                            <td align="center">
                                                                <div class="icheck-list">
                                                                    <input type="radio" id="" value="${STT.index+1}" name="Oamuser_InGroup_1" onclick="Oamuser_Js_getRowSelected()">
                                                                </div>
                                                            </td>
                                                            <td align="center">${student.id}</td>
                                                            <td align="center">${student.firstName}</td>
                                                            <td align="center">${student.lastName}</td>
                                                            <td align="center">${student.marks}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <form:form method="POST" modelAttribute="student" action="saveUser">
                        <table style="width: auto;">
                            <tr>
                                <th colspan="2" style="text-align: left;">Key Name</th>
                                <th style="text-align: left;">Key Value</th>
                            </tr>
                            <tr>
                                <td colspan="2">ID</td>
                                <td><form:input path="id" id="id" /></td>
                            </tr>
                            <tr>
                                <td colspan="2">First Name</td>
                                <td><form:input path="firstName" id="firstName" /></td>
                            </tr>
                            <tr>
                                <td colspan="2">Last Name</td>
                                <td><form:input path="lastName" id="lastName" /></td>
                            </tr>
                            <tr>
                                <td colspan="2">Marks</td>
                                <td><form:input path="marks" id="marks" /></td>
                            </tr>
                        </table>
                        <br/>
                        <button type="submit" class="btn btn-primary" name="action" value="add">Add</button>
                        <button type="submit" class="btn btn-warning" name="action" value="update">Update</button>
                        <button type="submit" class="btn btn-danger" name="action" value="delete">Delete</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <script src="resources/js/Lbs_Func_General.js"></script>
    <script src="resources/js/Lbs_Is_Validate.js"></script>
    <script src="resources/js/Lbs_Modal_Message.js"></script>
    <script src="resources/js/Cls_user_ls_General.js"></script>

</body>
</html>
