<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<head>
    <title>Dentists</title>
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

    List of dentist

</h1>
<@sf.form action="/dentists/add" method="post" modelAttribute="dentist">
    <table>
        <tr>
            <td>
                <div hidden="true">
                    <@sf.label path="dentistId">ID</@sf.label>
                    <@sf.input path="dentistId"/>
                    <@sf.errors path="dentistId"/>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    <@sf.label path="surname">Surname</@sf.label>
                    <@sf.input path="surname"/>
                    <@sf.errors path="surname"/>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    <@sf.label path="name">Name</@sf.label>
                    <@sf.input path="name"/>
                    <@sf.errors path="name"/>

                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    <@sf.label path="birth">Birth</@sf.label>
                    <@sf.input path="birth"/>
                    <@sf.errors path="birth"/>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    <@sf.label path="spec">Specialization</@sf.label>
                    <@sf.input path="spec"/>
                    <@sf.errors path="spec"/>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    <@sf.label path="stDate">Start career</@sf.label>
                    <@sf.input path="stDate"/>
                    <@sf.errors path="stDate"/>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    <@sf.label path="WPhone">Work phone</@sf.label>
                    <@sf.input path="WPhone"/>
                    <@sf.errors path="WPhone"/>
                </div>
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="Add dentist"/>
            </td>
        </tr>
    </table>

</@sf.form>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Surname</th>
        <th width="120">Name</th>
        <th width="100">Birth</th>
        <th width="120">Specialization</th>
        <th width="100">Career start</th>
        <th width="120">Work phone</th>
        <th width="80">Edit</th>
        <th width="80">Delete</th>
    </tr>
    <#if listDentist?has_content>
        <#list listDentist as dentist>
            <tr>
                <td>${dentist.dentistId}</td>
                <td>${dentist.surname}</td>
                <td>${dentist.name}</td>
                <td>${dentist.birth}</td>
                <td>${dentist.spec}</td>
                <td>${dentist.stDate}</td>
                <td>${dentist.WPhone}</td>
                <td><a href="/edit/${dentist.dentistId}">Edit</a></td>
                <td><a href="/remove/${dentist.dentistId}">Delete</a></td>
            </tr>
        </#list>
    <#else>

        <h1>You have some error now!!!</h1>
    </#if>
</table>
</body>
</html>
