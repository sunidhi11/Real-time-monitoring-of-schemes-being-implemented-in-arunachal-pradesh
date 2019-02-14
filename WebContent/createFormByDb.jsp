<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page 
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Schemes</title>
     <meta charset="utf-8"> 
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>
body {


background:#c5d2f9;
font-family: "Times New Roman", Times, serif;
  color: black;   
}

input[type=text], select, textarea, [text=integer], [text=date]{
    width: 100%;
    padding: 5px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}

input[type=submit] {
    background-color: blue;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</head>
<body>
<center>
<h3 style="color:blue;"><marquee>Apply for Scheme Here! </marquee></h3>
</center>
<div class="container">
  <form action="DynamicFormRegistrationController" method="post" enctype="MULTIPART/FORM-DATA" >
  
	
<%ArrayList<String> listName=(ArrayList<String>)session.getAttribute("listName");
 ArrayList<String> listType=(ArrayList<String>)session.getAttribute("listType");
int i=0;
		for(String list:listName){
		if((listType.get(i)).equalsIgnoreCase("varchar")){%>
		<%if(list.equalsIgnoreCase("dob")){%>
      <%=list%><input type="date"  name="<%=list%>"><br>
      <% }
		if(list.equalsIgnoreCase("gender")){%>
	<%=list%><select id="gender" name="<%=list%>">
      <option value="male">Male</option>
      <option value="female">Female</option>
      <option value="other">Other</option>
    </select>
	<% }if(!(list.equals("gender")) && !(list.equals("dob"))){%>		
		<%=list%><input type="text"  name="<%=list%>"><br>	
		 <%}}else{%>

		 <%=list%><input type="file"  name="<%=list%>" accept="image/*" ><br>
	    
	
<%}
		i++;}%>
    <input type="submit" value="Submit">

</form>
</div>
</body>
</html>