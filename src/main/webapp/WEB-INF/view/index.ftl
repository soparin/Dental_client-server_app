<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<html>
    <head>
        <title>Menu</title>
        <style type="text/css"></style>
    </head>
    <body>
    <h1>Menu</h1>
    <p><h2>Run as</h2></p>
    <table border="0">
        <@sf.form action="/run/pat" method="post" modelAttribute="PatientMenu">
            <tr>
                <td rowspan="2">Patient</td>
                <td>Specialization</td>
                <td>Date of start career</td>
                <td></td>
                <td rowspan="2"><input type="submit"></td>
            </tr>
            <tr>
                <td><@sf.input path="spec" size ="30" /></td>
                <td><@sf.input path="date" type="date" /></td>
            </tr>
        </@sf.form>>
        <@sf.form action="/run/dent" method="post" modelAttribute="DentistMenu">
        <tr>
            <td rowspan="2">Dentist</td>
            <td>Date</td>
            <td>Id</td>
            <td></td>
            <td rowspan="2"><input type="submit"></td>
        </tr>
        <tr>
            <td><@sf.input path="id" type ="number" /></td>
            <td><@sf.input path="date" type="date" /></td>
            <td></td>
        </tr>
        </@sf.form>
    </table>

    <h2>
        Get information
    </h2>
        <ul>
                <li><a href="/patients/">Patients</a></li>
                <li><a href="/dentists/">Dentists</a></li>
                <li><a href="/receptions/">All receptions</a></li>
                <li><a href="/schedules/">Schedules</a></li>
                <li><a href="/tickets/">Tickets</a></li>
        </ul>
    </body>
</html>