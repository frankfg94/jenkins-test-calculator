<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/loginstyle.css" media="screen">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            // Reinitialisation des paramètres
            request.setAttribute("isAdmin", false);
            request.setAttribute("state", "loginAttempt");
        %>
        <div class="wrapper">
            <form class="form-signin" name ='myform' action='Controller'>
                <h2 class="form-signin-heading text-center">Result of your calculation</h2>
                <%
                    if (request.getAttribute("calcul") != null) {
                        out.print("<br/>");
                        out.print("<h2>"+request.getAttribute("calcul").toString()+"</h2>");
                        out.print("<br/>");
                    }
                %>
                <input type='submit' class="btn btn-primary btn-block" name='action' value='New calculation'>
            </form>
        </div>
    </body>
</html>
