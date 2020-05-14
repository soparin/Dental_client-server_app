<html>
    <head>
        Patient query
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
    <body>
    <h> Query result</h>
    <#if qList?has_content>
    <table class="tg">
        <tr>
            <th width="200">Surname</th>
            <th width="200">Name</th>
            <th width="200">Date of start</th>
            <th width="220">Specialization</th>
            <th width="100">Phone</th>
            <th width="120">Free reception time</th>
        </tr>
        <#list qList as q>
            <tr>
                <td>${q.surname}</td>
                <td>${q.name}</td>
                <td>${q.startDate}</td>
                <td>${q.dateTicket}</td>
                <td>${q.phone}</td>
                <td>${q.time}</td>
            </tr>
        </#list>
    </table>
        <#else> <p><h1>List is empty.</h1></p>
    </#if>
    <br>
    <p>
        <table border="0">
        <tr>
            <td><a href="/dentists"> Dentist </a></td>
            <td><a href="/patients"> Patients </a></td>
            <td><a href="/receptions"> Receptions </a></td>
            <td><a href="/tickets"> Tickets </a></td>
            <td><a href="/"> Back to menu </a></td>
        </tr>
    </table>
    </p>
    </body>
</html>