<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<%--<link type="text/css"--%>
		  <%--rel="stylesheet"--%>
		  <%--href="css/style.css" />--%>

		 <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
	<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>--%>
	<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>--%>
	<link type="text/css" rel="stylesheet" href="style.css"/>
</head>
<%--<link rel="stylesheet" href="style.css"/>--%>
<body>
	<!-- <script type="text/javascript">
		$(".postcode-input").click(function (){
		    var postcode = $(this).parents(".postcode-input")
		        .children("input").val();
		    // First do some basic validation of the postcode like
		    // correct format etc.
		    if (!validatePostcode(postcode)) {
		        alert("Invalid Postal Code, please try again");
		        return false;
		    }
		    var finalUrl = postcode;
		    $.ajax({
		    	type: "GET",
		        url: finalUrl,
		        cache: false,
		        success: function (html) {
		            // Parse the recieved data here.
		            console.log(html);
		        }
		    });
		});
		</script> -->
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<!-- <div class="postcode-input">
			<button type="submit"></button>
			</div> -->
	<div id="container">
	
		<div id="content">
		
			<!--  add our html table here -->
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Customer"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			<!-- <form method="post">
			<input type="text" name="m1" />
			</form> -->
			<form action="${pageContext.request.contextPath}/api/csv/download" method="post">
			<!-- <input type ="text" name="text1" id="text1"> -->
			<select id = "myList" name="text1">
               <option value = "january">January</option>
               <option value = "february">February</option>
               <option value = "march">March</option>
               <option value = "april">April</option>
                <option value = "may">May</option>
                 <option value = "june">June</option>
                  <option value = "july">july</option>
                   <option value = "august">August</option>
                    <option value = "september">September</option>
                     <option value = "october">october</option>
                      <option value = "november">Nov</option>
                       <option value = "december">Dec</option>
             </select>
             <br>
			 <input type="submit" value="Archival"
				   class="add-button"
			/> 
			</form>
			<form
			action="${pageContext.request.contextPath}/in/saveUser/upload"
			 enctype="multipart/form-data" method="post">
					<div class="form-group">
						<label class="add-button" for="uploadfile">Upload File:</label>
						<br>
						<input type="file" class="form-control" id="uploadfile" placeholder="Upload File" name="uploadfile"></input>
					</div>
					<button type="submit" class="add-button" id="btnSubmit">Restoring</button>
		</form>
			<!-- <a href="http://localhost:9090/web-customer-tracker/customer/multipartfile/uploadform.jsp">Restoring</a> -->		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Month</th>
					<th>Action</th>
				</tr>
				
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
				
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td> ${tempCustomer.month} </td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" onclick="if( !(confirm('Are you sure you want to delete this user?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	
	

</body>

</html>









