<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page 
	import="sis.com.bo.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<style>
  table, th, td {
    border-collapse: collapse;3 
}
 th,td {
    padding: 10px;
    text-align: left;
} 

td{
 padding-left:100px;
} 

</style>
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

<% 
if((Benificary)session.getAttribute("benificiaryinfo")!=null){
	Benificary benificary=(Benificary)session.getAttribute("benificiaryinfo");
	%>
	<table style="width:100%">
  <tr>
    <td>District</td>
    <td><%=benificary.getDistrict()%></td>
  </tr>
  <tr>
    <td>Block</td>
    <td><%=benificary.getBlock()%></td>
  </tr>
  <tr>
    <td>Panchayat</td>
    <td><%=benificary.getPanchayat()%></td>
  </tr>
  <tr>
    <td>SchemeCode</td>
    <td><%=benificary.getSchemeCode()%></td>
  </tr>
  <tr>
    <td>Hospital</td>
    <td><%=benificary.getHospital()%></td>
  </tr>
  <tr>
    <td>Name</td>
    <td><%=benificary.getName()%></td>
  </tr>
	<tr>
    <td>Husband Name</td>
    <td><%=benificary.getHusband()%></td>
  </tr>
  <tr>
    <td>Maritial Status</td>
    <td><%=benificary.getMaritial()%></td>
  </tr>
  <tr>
    <td>Date of Birth</td>
    <td><%=benificary.getDob()%></td>
  </tr>
  <tr>
    <td>gender</td>
    <td><%=benificary.getGender()%></td>
  </tr>
  <tr>
    <td>Mobile</td>
    <td><%=benificary.getMobile()%></td>
  </tr>
  <tr>
    <td>Address</td>
    <td><%=benificary.getAddress()%></td>
  </tr>
   <tr>
    <td>Adhhar Number</td>
    <td><%=benificary.getAdhharNo()%></td>
  </tr>
 <%--  <tr>
    <td><img src='ImagePreviewController?id=<%=regstudent.getEnrollment()%>' width='100' height='100' /> </td>
   
 <!--   <td><img src='userimage' width='100' height='100'></td>-->
  </tr>   --%>

   <tr>
    <td><a href="applyforscheme.html" class="btn btn-info" role="button">Back</a></td>
   <td><form action="PreviewRegisterController" method="post">
    <input type="submit" value="Continue">
    </form></td>
  </tr>
   <%}%>
</table>
</fieldset>
</div>
</div>
  </div>
  </div>
</body>
</html>