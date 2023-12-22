<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create User</title>
</head>
<body>

	<form action="addUser">
	
		<input type="text" name="firstName" placeholder="First Name"/>
		<br/>
		<input type="text" name="middleName" placeholder="Middle Name"/>
		<br/>		
		<input type="text" name="lastName" placeholder="Last Name"/>
		<br/>
		<input type="date" name="dateOfBirth" placeholder="Date of Birth"/>
		<br/>
		<input type="text"  placeholder="Gender"/>
		<br/>
		<input type="email" name="email" placeholder="email"/>
		<br/>
		<input type="tel" name="phone" placeholder="Phone"/>
		<br/>
		<input type="text" placeholder="House/Apartment,Street"/>
		<br/>
		<input type="text" placeholder="Colony,City"/>
		<br/>
		<input type="text" placeholder="City"/>
		<br/>
		<input type="text" placeholder="State"/>
		<br/>
		<input type="number" placeholder="Pincode"/>
		<br/>
		<input type="password" name="password" placeholder="Create Password"/>
		<br/>
		<input type="password" placeholder="Verify Password"/>
		<br/>
		<input type="submit"/>
	
	</form>

</body>
</html>