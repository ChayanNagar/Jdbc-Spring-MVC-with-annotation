<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Employee</title>
</head>
<body>
	<h1 align="center" style="background-color:#f1f1f1" >Create Employee  Page</h1>
	
	
	<div class="container">
	<div class="col-sm-3">
    <pre>
    <form action="empinsert" method="post">
    <h3 color="blue"> ${msg}</h3>
  <div class="form-group">
    <label for="Name">Employee Name:</label>
    <input type="text" class="form-control" name="ename" id="name">
  </div>
 
  <div class="form-group">
    <label for="salary">Salary:</label>
    <input type="text" class="form-control" name="salary" id="Mobile No.">
  </div>
  
  <div class="form-group">
    <label for="address">Employee Address:</label>
     <textarea name="address" class="form-control" ></textarea>
     </div>

     <button type="submit" class="btn btn-default">Submit</button>
</form>
</pre>
</div>
</div>

</body>
</html>