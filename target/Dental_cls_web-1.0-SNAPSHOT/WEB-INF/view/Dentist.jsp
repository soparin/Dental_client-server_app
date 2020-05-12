<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Books Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h1>

    Book List

</h1>

<c:if test="${!empty listDentist}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Surname</th>
            <th width="120">Name</th>
            <th width="120">Birth</th>
            <th width="120">Specialization</th>
            <th width="120">Career start date</th>
            <th width="120">Work phone</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listDentist}" var="dentist">
            <tr>
                <td>${dentist.dentistId}</td>
                <td>${dentist.surname}</td>
                <td>${dentist.name}</td>
                <td>${dentist.birth}</td>
                <td>${dentist.spec}</td>
                <td>${dentist.stDate}</td>
                <td>${dentist.WPhone}</td>
                <td><a href="<c:url value='/edit/${dentist.dentistId.longValue()}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${dentist.dentistId.longValue()}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Dentist</h1>

<c:url var="addAction" value="/dentists/add"/>

<form:form action="${addAction}" modelAttribute="dentist">
    <table>
        <c:if test="${!empty dentist.surname}">
            <tr>
                <td>
                    <form:label path="dentistid">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="dentistId" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="dentistId"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="surname">
                    <spring:message text="Surname"/>
                </form:label>
            </td>
            <td>
                <form:input path="surname"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="birth">
                    <spring:message text="Birth"/>
                </form:label>
            </td>
            <td>
                <form:input path="birth"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty dentist.surname}">
                    <input type="submit"
                           value="<spring:message text="Edit Dentist"/>"/>
                </c:if>
                <c:if test="${empty dentist.surname}">
                    <input type="submit"
                           value="<spring:message text="Add Dentist"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
