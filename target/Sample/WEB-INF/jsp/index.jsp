<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Hello World</title>
   </head>
   
   <body>
      <h2>${message}</h2>
   </body>
   <body>
   <form action="login" method="post">
   <input type="text" id="userName" name="userName"/>
   <input type ="password" id="pass" name="pass"/>
   <input type="submit" value="LOGIN">
     </form>
   </body>
   <body>
   <font size="3" color="red">${result}</font>
   </body>
</html>