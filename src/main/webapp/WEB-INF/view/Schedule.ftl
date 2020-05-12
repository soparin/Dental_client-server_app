<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<head>
    <title>Schedules</title>
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

        Add new schedule or update.

    </h1>
    <@sf.form action="/schedules/add" method="post" modelAttribute="schedule">
        <table>
            <tr>
                <td>
                    <div hidden="true">
                        <@sf.label path="schNum">Schedule number</@sf.label>
                        <@sf.input path="schNum"  />
                        <@sf.errors path="schNum"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td><@sf.label path="dentistId">Dentist ID</@sf.label></td>
                <td><@sf.input onclick="this.select();" path="dentistId"/></td>
                <td><@sf.errors path="dentistId"/></td>
            </tr>
            <tr>
                <td><@sf.label path="dateTickets">Date on ticket</@sf.label></td>
                <td> <@sf.input type="date" path="dateTickets"/></td>
                <td><@sf.errors path="dateTickets"/></td>
            </tr>
            <tr>
                <td><@sf.label path="cab">Cabinet</@sf.label></td>
                <td><@sf.input onclick="this.select();" path="cab"/></td>
                <td><<@sf.errors path="cab"/>/td>
            </tr>
            <tr>
                <td width="100" height="50">
                    <#if id?has_content>
                        <input type="submit" value="Update schedule"  />
                    <#else>
                        <input type="submit" value="Add schedule"/>
                    </#if>
                </td>
                <td><input type="reset" value="Reset"/>
            </tr>
        </table>
    </@sf.form>
    <#if listSchedule?has_content>
        <h1>
            List of schedules
        </h1>
        <table class="tg">
            <tr>
                <th width="80">Schedule num</th>
                <th width="120">Dentist ID</th>
                <th width="120">dateTickets</th>
                <th width="100">Cab</th>
                <th width="80">Edit</th>
                <th width="80">Delete</th>
            </tr>
            <#list listSchedule as schedule>
                <tr>
                    <td>${schedule.schNum}</td>
                    <td>${schedule.dentistId}</td>
                    <td>${schedule.dateTickets}</td>
                    <td>${schedule.cab}</td>
                    <td><a href="/sched/edit/${schedule.schNum}">Edit</a></td>
                    <td><a href="/sched/remove/${schedule.schNum}">Delete</a></td>
                </tr>
            </#list>
        </table>
        <p><h2>Just <a href="/">click here</a>, if you want back to the menu </h2></p>
    <#else>
        <h1>
            <p>List of schedule is empty.</p>
            <p>You have some error with add/update form now!!!(<a href="/schedules">Click here to cancel</a>)</p>
            <p>If you want back to the menu just <a href="/">click here</a>)</p>
        </h1>
    </#if>
</article>
</body>
</html>
