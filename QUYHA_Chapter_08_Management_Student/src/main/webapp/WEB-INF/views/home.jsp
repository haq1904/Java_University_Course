<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Manage Users</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 20px;
            color: #333;
        }
        .header-title {
            font-size: 22px;
            display: flex;
            align-items: center;
            margin-bottom: 15px;
            color: #333;
        }
        .header-title img {
            margin-right: 10px;
        }
        .section-header {
            background-color: #f1f1f1;
            padding: 8px 10px;
            font-weight: bold;
            font-size: 14px;
            margin-bottom: 0;
            border-top: 1px solid #e0e0e0;
            border-left: 1px solid #e0e0e0;
            border-right: 1px solid #e0e0e0;
        }
        .section-header span {
            font-size: 11px;
            margin-right: 5px;
            color: #000;
        }
        table.data-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
        }
        table.data-table th {
            background-color: #0082c8;
            color: white;
            text-align: center;
            padding: 8px;
            border-left: 1px solid white;
            border-right: 1px solid white;
            font-weight: bold;
        }
        table.data-table th:first-child {
            border-left: none;
        }
        table.data-table th:last-child {
            border-right: none;
        }
        table.data-table td {
            border: 1px solid #e0e0e0;
            padding: 8px;
            text-align: center;
        }
        
        table.form-table {
            width: 45%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table.form-table th {
            background-color: #d9d9d9;
            color: #333;
            text-align: left;
            padding: 8px;
            border: 1px solid #e0e0e0;
            font-weight: bold;
        }
        table.form-table td {
            border: 1px solid #e0e0e0;
            padding: 8px;
            color: #555;
            text-align: left;
        }
        table.form-table td.label-col {
            width: 30%;
        }
        table.form-table input[type="text"] {
            width: 100%;
            padding: 6px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        
        .btn-group {
            display: flex;
            gap: 10px;
        }
        .btn {
            padding: 8px 25px;
            border: none;
            cursor: pointer;
            font-size: 14px;
            border-radius: 4px;
            color: white;
        }
        .btn-add { background-color: #0082c8; }
        .btn-update { background-color: #ffc107; color: #333; }
        .btn-delete { background-color: #ff0000; }
    </style>
</head>

<body>
    <div class="header-title">
        <img src="resources/images/User.png" alt="Logo" width="32" height="32" />
        <span>Manage Users</span>
    </div>

    <div class="section-header">
        <span>&#9660;</span> User Lists
    </div>

    <table class="data-table">
        <thead>
            <tr>
                <th>Choose</th>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Mark</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty studentList}">
                <c:forEach var="student" items="${studentList}" varStatus="STT">
                    <tr>
                        <td align="center">
                            <input type="radio" name="selectedUser" 
                                   data-id="${student.id}" 
                                   data-firstname="${student.firstName}" 
                                   data-lastname="${student.lastName}" 
                                   data-marks="${student.marks}" 
                                   onclick="fillForm(this)">
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

    <form:form method="POST" modelAttribute="student" action="saveUser">
        <table class="form-table">
            <tr>
                <th class="label-col">Key Name</th>
                <th>Key Value</th>
            </tr>
            <tr>
                <td class="label-col">ID</td>
                <td><form:input path="id" id="id" /></td>
            </tr>
            <tr>
                <td class="label-col">First Name</td>
                <td><form:input path="firstName" id="firstName" /></td>
            </tr>
            <tr>
                <td class="label-col">Last Name</td>
                <td><form:input path="lastName" id="lastName" /></td>
            </tr>
            <tr>
                <td class="label-col">Mark</td>
                <td><form:input path="marks" id="marks" /></td>
            </tr>
        </table>
        
        <div class="btn-group">
            <button type="submit" class="btn btn-add" name="action" value="add">Add</button>
            <button type="submit" class="btn btn-update" name="action" value="update">Update</button>
            <button type="submit" class="btn btn-delete" name="action" value="delete">Delete</button>
        </div>
    </form:form>

    <script src="resources/js/Lbs_Func_General.js"></script>
    <script src="resources/js/Lbs_Is_Validate.js"></script>
    <script src="resources/js/Lbs_Modal_Message.js"></script>
    <script src="resources/js/Cls_user_ls_General.js"></script>

    <script>
        // Custom function to populate the form when a user is selected
        function fillForm(radioBtn) {
            document.getElementById('id').value = radioBtn.getAttribute('data-id');
            document.getElementById('firstName').value = radioBtn.getAttribute('data-firstname');
            document.getElementById('lastName').value = radioBtn.getAttribute('data-lastname');
            document.getElementById('marks').value = radioBtn.getAttribute('data-marks');
        }
    </script>
</body>
</html>
