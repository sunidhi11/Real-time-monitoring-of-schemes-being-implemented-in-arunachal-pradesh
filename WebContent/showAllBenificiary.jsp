<%@page import="sis.com.bo.*"%>
<%@page import="java.util.*"%>
   <title>Student Details</title>

 <form action="showAllBenificiaryController" method="post">
 	<input type="submit" value="submit" >
 </form>   
  
<div class="container container-sm border" style="">
	 
	 
	  <div class="container" >
	  <header class="container announcement-sm" style="text-align: center;">
	  <h1>Mother DETAIL</h1>
	  </header>
 <hr>
 
<div class="panel-group" id="accordian">
<div class="well">



 <table class="table table-bordered table table-hover table table-striped">
    <thead>
      <tr>
        <th>PatientId</th>
        <th>Name</th>
        <th>View More</th>
      </tr>
    </thead>
   
     <tbody>
      <%
      if(session.getAttribute("benificiaryList")!=null){
      List<Benificary> benificarylist=(List<Benificary>)session.getAttribute("benificiaryList");
      
      for(Benificary benificary:benificarylist){%>
      <tr>
        <td><%=benificary.getApplicationId()%></td>
        <td><%=benificary.getName()%></td>
      <td><a href='ViewBenificiaryController?id=<%=benificary.getApplicationId()%>' style="color:blue;"> <span class="glyphicon glyphicon-eye-open" aria-hidden="true">view</span></a></td>
      </tr>
     <%}}%>
    </tbody>
  </table>

    </div>
  </div> 
  
      
<script type="text/javascript">
function myFunction(a){
	var address = document.getElementById(a).value;
	document.getElementById("toChange").href = address;
	console.log(a);
}
</script>
	</div>  
    </div>
    </div>
    </div>
   