<%
    String message = pageContext.getException().getMessage();
    String exception = pageContext.getException().getClass().toString();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Exception</title>
    </head>
    <body bgcolor="#39CCCC">
    <p>
        <p><h1>Sorry, something went wrong :(</h1></p>
        <p><h2>Exception occurred while processing the request</h2></p>
        <p>Type: <%= exception%></p>
        <p>Message: <%= message %></p>
        <p>
        <h3>
            Contact your administrator or simply return to the
            <a onclick="javascript:history.back(); return false;">previous page</a>.
        </h3>
        </p>
    </body>
</html>
