<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<head>
    <title>Reception</title>
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

        Add new reception or update.

    </h1>
    <@sf.form action="/receptions/add" method="post" modelAttribute="reception">
        <table>
            <tr>
                <td>
                    <div hidden="true">
                        <@sf.label path="recCount">Count</@sf.label>
                        <@sf.input path="recCount"  />
                        <@sf.errors path="recCount"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td><@sf.label path="dentistId">Dentist ID</@sf.label></td>
                <td> <@sf.input type="number" onclick="this.select();" path="dentistId"/></td>
                <td><@sf.errors path="dentistId"/></td>
            </tr>
            <tr>
                <td><@sf.label path="patientId">Patient ID</@sf.label></td>
                <td><@sf.input type="number" onclick="this.select();" path="patientId"/></td>
                <td><@sf.errors path="patientId"/></td>
            </tr>
            <tr>
                <td><@sf.label path="recDate">Reception date</@sf.label></td>
                <td><@sf.input type="date" path="recDate"/></td>
                <td><<@sf.errors path="recDate"/>/td>
            </tr>
            <tr>
                <td><@sf.label path="recTime">Reception Time</@sf.label>
                <td><@sf.input type="time" path="recTime"/></td>
                <td><@sf.errors path="recTime"/></td>
            </tr>
            <tr>
                <td width="100" height="50">
                    <#if id?has_content>
                        <input type="submit" value="Update reception"  />
                    <#else>
                        <input type="submit" value="Add reception"/>
                    </#if>
                </td>
                <td><input type="reset" value="Reset"/>
            </tr>
        </table>
    </@sf.form>
    <#if listReception?has_content>
        <h1>
            <p>List of reception</p>
        </h1>
        <table class="tg">
            <tr>
                <th width="60">Reception count</th>
                <th width="60">Dentist id</th>
                <th width="60">Patient id</th>
                <th width="100">Reception date</th>
                <th width="120">Reception time</th>
                <th width="80">Edit</th>
                <th width="80">Delete</th>
            </tr>
            <#list listReception as reception>
                <tr>
                    <td>${reception.recCount}</td>
                    <td><a>${reception.dentistId}</a></td>
                    <td><a>${reception.patientId}</a></td>
                    <td>${reception.recDate}</td>
                    <td>${reception.recTime}</td>
                    <td><a href="/rec/edit/${reception.recCount}">Edit</a></td>
                    <td><a href="/rec/remove/${reception.recCount}">Delete</a></td>
                </tr>
            </#list>
        </table>
        <p><h2>Just <a href="/">click here</a>, if you want back to the menu </h2></p>

    <#else>
        <h1>
            <p>List of receptions is empty.</p>
            <p>Click <a href="/receptions">here</a> to cancel.</p>
            <p>If you want back to the menu just <a href="/">click here</a>)</p>
        </h1>
    </#if>
</article>
</body>
</html>
