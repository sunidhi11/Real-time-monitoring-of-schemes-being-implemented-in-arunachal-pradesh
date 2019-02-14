<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page 
	import="java.util.*"%>
	<%@page 
	import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container container-sm border" style="">
	 
	 
	  <div class="container" >
	  <header class="container announcement-sm" style="text-align: center;">
	  <h1>Application Confirmation</h1>
	  </header>
 <hr>
 
<div class="panel-group" id="accordian">
<div class="well">
<fieldset><legend>
<p style="text-align:center;color:red;font-family:Lucida Calligraphy;font-size:25px;">
<b>Confirm Your Details</b></p></legend>
<% ArrayList<InputStream> AllNonFormFields=(ArrayList<InputStream>)session.getAttribute("AllNonFormFields");
ArrayList<String> AllFormFields=(ArrayList<String>)session.getAttribute("AllFormFields");
ArrayList<String> AllFieldList=(ArrayList<String>)session.getAttribute("listName");
System.out.println("form field"+AllFormFields);
int i=0;%>
	<table style="width:100%">
	<%if(!(AllFormFields.isEmpty())){
	for(String allfield : AllFieldList){%>
  <tr>
    <td><%=allfield%></td>
    <td><%=AllFormFields.get(i)%></td>
  </tr>
  <%i++;}}%>
 

   <tr>
    <td><a href="createFormByDb.jsp" class="btn btn-info" role="button">Back</a></td>
   <td><form action="PreviewDynamicFormController" method="post">
    <input type="submit" value="Continue">
    </form></td>
  </tr>
  
</table>
</fieldset>
</div>
</div>
</div>
</div>
</body>
</html>
