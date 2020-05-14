<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<head>
    <title>Tickets</title>
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

        Add new tickets or update.

    </h1>
    <@sf.form action="/tickets/add" method="post" modelAttribute="tickets">
        <table>
            <tr>
                <div hidden="true">
                        <@sf.label path="tickId">Ticket ID</@sf.label>
                        <@sf.input path="tickId"/>
                        <@sf.errors path="tickId"/>
                </div>
            </tr>
            <tr>
                <td><@sf.label path="stTime">Start Time</@sf.label></td>
                <td><@sf.input type="time" path="stTime"/></td>
                <td><@sf.errors path="stTime"/></td>
            </tr>
            <tr>
                <td><@sf.label path="fnTime">Finish Time</@sf.label></td>
                <td> <@sf.input type="time" path="fnTime"/></td>
                <td><@sf.errors path="fnTime"/></td>
            </tr>
            <tr>
                <td><@sf.label path="ScheduleNum">Work shift</@sf.label></td>
                <td><@sf.input type="number" onclick="this.select();" path="ScheduleNum"  /></td>
                <td><@sf.errors path="ScheduleNum"/></td>
            </tr>
            <tr>
                <td width="100" height="50">
                    <#if tickets.tickId?has_content>
                        <input type="submit" value="Update ticket"  />
                    <#else>
                        <input type="submit" value="Add ticket"/>
                    </#if>
                </td>
                <td><input type="reset" value="Reset"/>
            </tr>
        </table>
    </@sf.form>
    <#if listTickets?has_content>
        <p><h1>Ticket list</h1>   <h3>Just <a href="/">click here</a>, if you want back to the menu </h3></p>
        <table class="tg">
            <tr>
                <th width="30">Ticket number</th>
                <th width="30">Work shift</th>
                <th width="80">Start time</th>
                <th width="80">Finish time</th>
                <th width="80">Engaged</th>
                <th width="60">Action</th>
                <th width="60">Edit</th>
                <th width="60">Delete</th>
            </tr>
            <#list  listTickets as ticket>
                <tr>
                    <td>${ticket.tickId}</td>
                    <td>${ticket.scheduleNum}</td>
                    <td>${ticket.stTime}</td>
                    <td>${ticket.fnTime}</td>
                    <td>${ticket.engaged?then("Engaged", "Free")}</td>
                    <td>
                        <@sf.form action="/tick/act" method="post" modelAttribute="tickets">
                            <div hidden="true">
                                <@sf.input type="hidden "name="data" path="tickId" value=ticket.tickId />
                            </div>
                            <#if ticket.engaged>
                                <input type="submit" value="Refuse"/>
                            <#else>
                                <input type="submit" value="Take"/>
                            </#if>
                        </@sf.form>
                    </td>
                    <td>
                        <@sf.form action="/tick/edit" method="post" modelAttribute="tickets">
                            <div hidden="true">
                                <@sf.input type="hidden "name="data" path="tickId" value=ticket.tickId />
                            </div>
                            <input type="submit" value="Edit"/>
                        </@sf.form>
                    </td>
                    <td>
                        <@sf.form action="/tick/remove" method="post" modelAttribute="tickets">
                            <div hidden="true">
                                <@sf.input type="hidden "name="data" path="tickId" value=ticket.tickId />
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
            <p>List of tickets is empty.</p>
            <p>Click <a href="/dentists">here</a> to cancel.</p>
            <p>If you want back to the menu just <a href="/">click here</a>)</p>
        </h1>
    </#if>
</article>
</body>
</html>
