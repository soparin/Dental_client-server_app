<html>
    <head>
        <title>Patient query        </title>
    </head>
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
    <body bgcolor="#39CCCC">
    <h1> Query result</h1>
    <#if qList?has_content>
    <table class="tg">
        <tr>
            <th width="80">Date of reception</th>
            <th width="120">Specialization</th>
            <th width="200">F/L name</th>
            <th width="100">Career start date</th>
            <th width="50">Free reception time</th>
            <th width="100">Phone</th>
        </tr>
        <#list qList as q>
            <tr>
                <td>${q.dateTicket}</td>
                <td>${q.spec}</td>
                <td>${q.surnamename}</td>
                <td>${q.startDate}</td>
                <td><a href="/ticket/act">${q.time}</a></td>
                <td>${q.phone}</td>

            </tr>
        </#list>
    </table>
        <#else> <p><h1>List is empty.</h1></p>
    </#if>
    <br>
    <p>
        <table border="0">
        <tr>
            <td width="120"><a href="/dentists"> Dentist </a></td>
            <td width="120"><a href="/patients"> Patients </a></td>
            <td width="120"><a href="/receptions"> Receptions </a></>
            <td width="120"><a href="/tickets"> Tickets </a></td>
            <td width="120"><a href="/"> Back to menu </a></td>
        </tr>
    </table>
    </p>
    <br>
    </body>
</html>