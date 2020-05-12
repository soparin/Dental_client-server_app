<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<html>
    <head>
        <title>Menu</title>
        <style type="text/css"></style>
    </head>
    <body>
    <h1>Menu</h1>
<#--    <h2>-->
<#--        -->
<#--        Run as</h2>-->
<#--    <@sf.form action="/index/run" method="post" modelAttribute="menu">-->
<#--        <table>-->
<#--            <tr>-->
<#--                <td><@sf.label path="mask"><a href="/run/patient/{musk}/">Patient</a> with id</@sf.label></td>-->
<#--                <td><@sf.input path="musk"/></td>-->
<#--                <td><@sf.errors path="musk"/></td>-->
<#--            </tr>-->
<#--            <tr>-->
<#--                <td><@sf.label path="mask"><a href="/run/dentist/{musk}/">Dentist</a> with id</@sf.label></td>-->
<#--                <td><@sf.input path="musk"/></td>-->
<#--                <td><@sf.errors path="musk"/></td>-->
<#--            </tr>-->
<#--        </table>-->
<#--    </@sf.form>-->
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