<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  
<title>Home page</title>
</head>
<body>
<h1>welcome</h1>
	<nav class="navbar navbar-expand-sm bg-light">
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="/home">home</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/login">Login</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/register">Registeration</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/profile">Profile</a>
	    </li>
	  </ul>
	</nav>
<c:choose>
<c:when test="${mode=='MODE_HOME' }">
<h1 text-center>hello aliens ,welcome to my home page</h1>
</c:when>
<c:when test="${mode=='MODE_success' }">
<h1 text-center>hello aliens ,welcome to my home page</h1>
</c:when>


<c:when test="${mode=='MODE_LOGIN' }">
<div class="container">
  <h2>Login form</h2>
 	<c:if test="${param.error != null}">          
        <p>  
            Invalid username and password.  
        </p>  
    </c:if>  
    <c:if test="${param.logout != null}">         
        <p>  
            You have been logged out.  
        </p>  
    </c:if>      
  <form action="login" method="post">
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
    </div>
    <div class="form-group form-check">
      <label class="form-check-label">
      <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
</c:when>


<c:when test="${mode=='MODE_PROFILE' }">
<div class="container text center">
<h1>User profile</h1>
<h1></h1>
<label>Name: "${userobj.name }"</label><br>
<label>Email: "${userobj.username }"</label><br>
<label>Mobile: "${userobj.mobile }"</label><br><br>
<button class="btn btn-primary">Update</button>
</div>
</c:when>

<c:when test="${mode=='MODE_REGISTER' }">
 <div class="container">
	  <h2>Registeration </h2>
	  <p>In this example, we use <code>.was-validated</code> to indicate what's missing before submitting the form:</p>
	  <form action="registeruser"  method="post">
	    <div class="form-group">
	    <h4><c:if test="${msg=='failure duplicate'}">Email already registered</c:if></h4>
	    <h4><c:if test="${msg=='success register'}"> successfully registered</c:if></h4>
	    <br>
	      <label >Name :</label>
	      <input type="text" class="form-control" value="${userobj.name}" placeholder="Enter username" name="name"  value="${u.name }" required>
	      
	    </div>
	    <div class="form-group">
	      <label >Email:</label>
	      <input type="email" class="form-control" value="${userobj.username}" placeholder="Enter email" name="username" required>
	     
	    </div>
	    <div class="form-group">
	      <label >Mobile:</label>
	      <input type="number" class="form-control" value="${userobj.mobile}" placeholder="Enter mobile no" name="mobile" required>
	     
	    </div>
	    <div class="form-group">
	      <label >Password:</label>
	      <input type="password" class="form-control" value="${userobj.password}" placeholder="Enter password" name="password" required>
	     
	    </div>
	    <div class="form-group">
	      <label >Confirm :</label>
	      <input type="password" class="form-control" value="${userobj.cpassword}" placeholder="Confirm password" name="cpassword" required>
	     
	    </div>
	    <div class="form-group form-check">
		  <label class="form-check-label">
		    <input type="radio" class="form-check-input" name="op" value="STUDENT_ROLE">Student
		  </label>
		</div>
		<div class="form-check">
		  <label class="form-check-label">
		    <input type="radio" class="form-check-input" name="op" value="ADMIN_ROLE">Teacher
		  </label>
		</div>
	    <div class="form-group form-check">
	      <label class="form-check-label">
	        <input class="form-check-input" type="checkbox" name="remember" required> I agree on blabla.
	        <div class="valid-feedback">Valid.</div>
	        <div class="invalid-feedback">Check this checkbox to continue.</div>
	      </label>
	    </div>
	    <button type="submit" class="btn btn-primary">Submit</button>
	  </form>
</div>
</c:when>

</c:choose>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>