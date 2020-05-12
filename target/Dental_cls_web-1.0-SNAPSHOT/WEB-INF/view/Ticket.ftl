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
                <td><@sf.label path="schNum">Work shift</@sf.label></td>
                <td><@sf.input onclick="this.select();" path="schNum"  /></td>
                <td><@sf.errors path="schNum"/></td>
            </tr>
<#--            <tr>-->
<#--                <td><@sf.label path="engaged">Engaged</@sf.label></td>-->
<#--                <td><@sf.input path="engaged"/></td>-->
<#--                <td><<@sf.errors path="engaged"/>/td>-->
<#--            </tr>-->
            <tr>
                <td width="100" height="50">
                    <#if timeId?has_content>
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
        <h1>
            <p>Ticket list</p>
        </h1>
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
                    <td>${ticket.schNum}</td>
                    <td>${ticket.stTime}</td>
                    <td>${ticket.fnTime}</td>
                    <td>${ticket.engaged?then("Engaged", "Free")}</td>
                    <#if ticket.engaged>
                        <td><a href="/tick/act/${ticket.tickId}">Refuse</a></td>
                    <#else>
                        <td><a href="/tick/act/${ticket.tickId}">Take</a></td>
                    </#if>
                    <td><a href="/tick/edit/${ticket.tickId}">Edit</a></td>
                    <td><a href="/tick/remove/${ticket.tickId}">Delete</a></td>
                </tr>
            </#list>
        </table>
        <p><h2>Just <a href="/">click here</a>, if you want back to the menu </h2></p>
    <#else>
        <h1>
            <p>List of tickets is empty.</p>
            <p>You have some error with add/update form now!!!(<a href="/dentists">Click here to cancel</a>)</p>
            <p>If you want back to the menu just <a href="/">click here</a>)</p>
        </h1>
    </#if>
</article>
</body>
</html>
