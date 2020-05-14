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
            width: max-content;
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
<article>
<h1>

    Add new dentist or update.

</h1>
<@sf.form action="/dentists/add" method="post" modelAttribute="dentist">
    <table>
        <tr>
            <td>
                <div hidden="true">
                    <@sf.label path="dentistId">ID</@sf.label>
                    <@sf.input path="dentistId"  />
                    <@sf.errors path="dentistId"/>
                </div>
            </td>
        </tr>
        <tr>
            <td><@sf.label path="surname">Surname</@sf.label></td>
            <td><@sf.input  path="surname"/></td>
            <td><@sf.errors path="surname"/></td>
        </tr>
        <tr>
            <td><@sf.label path="name">Name</@sf.label></td>
            <td> <@sf.input path="name"/></td>
            <td><@sf.errors path="name"/></td>
        </tr>
        <tr>
            <td><@sf.label path="birth">Birth</@sf.label></td>
            <td><@sf.input type="date" path="birth"/></td>
            <td><<@sf.errors path="birth"/>/td>
        </tr>
        <tr>
            <td><@sf.label path="spec">Specialization</@sf.label>
            <td><@sf.input path="spec"/></td>
            <td><@sf.errors path="spec"/></td>
        </tr>
        <tr>
            <td><@sf.label path="stDate">Start career</@sf.label></td>
            <td><@sf.input type="date" path="stDate"/></td>
            <td><@sf.errors path="stDate"/></td>
        </tr>
        <tr>
            <td><@sf.label path="workPhone">Work phone</@sf.label></td>
            <td><@sf.input type="number" path="workPhone"/></td>
            <td><@sf.errors path="workPhone"/></td>
        </tr>
        <tr>
            <td width="100" height="50">
                <#if dentist.dentistId?has_content>
                    <input type="submit" value="Update dentist"  />
                <#else>
                    <input type="submit" value="Add dentist"/>
                </#if>
            </td>
            <td><input type="reset" value="Reset"/>
        </tr>
    </table>
</@sf.form>

    <#if listDentist?has_content>
        <p><h1>List of dentists</h1>   <h3>Just <a href="/">click here</a>, if you want back to the menu </h3></p>
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
            <#list listDentist as dentist>
                <tr>
                    <td>${dentist.dentistId}</td>
                    <td>${dentist.surname}</td>
                    <td>${dentist.name}</td>
                    <td>${dentist.birth}</td>
                    <td>${dentist.spec}</td>
                    <td>${dentist.stDate}</td>
                    <td>${dentist.workPhone}</td>
                    <td>
                        <@sf.form action="/dent/edit" method="post" modelAttribute="dentist">
                        <div hidden="true">
                        <@sf.input type="hidden "name="data" path="dentistId" value=dentist.dentistId />
                        </div>
                         <input type="submit" value="Edit"/>
                        </@sf.form>
                    </td>
                    <td>
                        <@sf.form action="/dent/remove" method="post" modelAttribute="dentist">
                            <div hidden="true">
                                <@sf.input type="hidden "name="data" path="dentistId" value=dentist.dentistId />
                            </div>
                            <input type="submit" value="Delete"/>
                        </@sf.form>
                    </td>
                </tr>
            </#list>
        </table>
        <p><h3>Just <a href="/">click here</a>, if you want back to the menu </h3></p>
    <#else>
        <h1>
            <p>List of dentists is empty.</p>
            <p>Click <a href="/dentists">here</a> to cancel.</p>
            <p>If you want back to the menu just <a href="/">click here</a>)</p>
        </h1>
    </#if>
</article>
</body>
</html>
