<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<head>
    <title>Patients</title>
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
    <h1>

        Add new patient or update.

    </h1>
    <@sf.form action="/patients/add" method="post" modelAttribute="patient">
        <table>
            <tr>
                <td>
                    <div hidden="true">
                        <@sf.label path="patientId">ID</@sf.label>
                        <@sf.input path="patientId"  />
                        <@sf.errors path="patientId"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td><@sf.label path="surname">Surname</@sf.label></td>
                <td><@sf.input path="surname"/></td>
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
                <td><@sf.label path="policy">Medical policy</@sf.label>
                <td><@sf.input pattern="[0-9]{4}-[0-9]{3}-[0-9]{3}-[0-9]{3}" placeholder="0000-000-000-000" path="policy"/></td>
                <td><@sf.errors path="policy"/></td>
            </tr>
            <tr>
                <td><@sf.label path="snils">SNILS</@sf.label></td>
                <td><@sf.input pattern="[0-9]{3}-[0-9]{4}-[0-9]{2}-[0-9]{2}" placeholder="000-0000-00-00"path="snils"/></td>
                <td><@sf.errors path="snils"/></td>
            </tr>
            <tr>
                <td><@sf.label path="lastRec">Last reception</@sf.label></td>
                <td><@sf.input path="lastRec" type="Date"/></td>
                <td><@sf.errors path="lastRec"/></td>
            </tr>
            <tr>
                <td><@sf.label path="pPhone">Patient phone</@sf.label></td>
                <td><@sf.input type="number" path="pPhone"/></td>
                <td><@sf.errors path="pPhone"/></td>
            </tr>
            <tr>
                <td width="100" height="50">
                    <#if id?has_content>
                        <input type="submit" value="Update patient"  />
                    <#else>
                        <input type="submit" value="Add patient"/>
                    </#if>
                </td>
                <td><input type="reset" value="Reset"/>
            </tr>
        </table>
    </@sf.form>
    <#if listPatient?has_content>
        <p><h1>List of patients</h1>   <h3>Just <a href="/">click here</a>, if you want back to the menu </h3></p>
        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">Surname</th>
                <th width="120">Name</th>
                <th width="100">Birth</th>
                <th width="120">Medical policy</th>
                <th width="100">SNILS</th>
                <th width="100">Last reception</th>
                <th width="120">Patient phone</th>
                <th width="80">Edit</th>
                <th width="80">Delete</th>
            </tr>
            <#list listPatient as patient>
                <tr>
                    <td>${patient.patientId}</td>
                    <td>${patient.surname}</td>
                    <td>${patient.name}</td>
                    <td>${patient.birth}</td>
                    <td>${patient.policy}</td>
                    <td>${patient.snils}</td>
                    <td>${patient.lastRec}</td>
                    <td>${patient.PPhone}</td>
                    <td>
                        <@sf.form action="/pat/edit" method="post" modelAttribute="patient">
                            <div hidden="true">
                                <@sf.input type="hidden "name="data" path="patientId" value=patient.patientId />
                            </div>
                            <input type="submit" value="Edit"/>
                        </@sf.form>
                    </td>
                    <td>
                        <@sf.form action="/pat/remove" method="post" modelAttribute="patient">
                            <div hidden="true">
                                <@sf.input type="hidden "name="data" path="patientId" value=patient.patientId />
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
            <p>List of receptions is empty.</p>
            <p>Click <a href="/patients">here</a> to cancel.</p>
            <p>If you want back to the menu just <a href="/">click here</a>)</p>
        </h1>
    </#if>
</body>
</html>
