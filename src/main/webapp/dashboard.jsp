<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h3 class="text-center">Welcome,<c:out value="${user_name}"></c:out></h3>
    </div>
  <div class="container mt-5">
        <h2 class="text-center">Save your Contacts Here</h2>
        <form action="SaveContactServlet" method="POST">
            <div class="form-row align-items-center">
                
                <div class="form-group col-md-3">
                    <input type="text" class="form-control" name="contact_name" placeholder="Contact Name" required>
                </div>
                <div class="form-group col-md-3">
                    <input type="email" class="form-control" name="contact_email" placeholder="Email" required>
                </div>
                <div class="form-group col-md-3">
                    <input type="text" class="form-control" name="contact_phno" placeholder="Phone Number" required>
                    <input type ="hidden" name ="user_id" value = "${user_id }">
                    <input type ="hidden" name ="user_id" value = "${user_name }">
                </div>
                <div class="form-group col-md-1">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
                <div class="form-group col-md-1">
                    <a class="btn btn-danger" href ="index.jsp">Logout</a>
                </div>
            </div>
        </form>
        <table class="table table-bordered">
            <thead class="text-center">
                <tr>
                    <th>SL No</th>
                    <th>User Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                </tr>
            </thead>
            <tbody>
               
                <c:if test="${result.isEmpty()}">
                <tr>
                  <td colspan = "4">No Records Found</td>
                </tr>
                </c:if>
                 <c:forEach var ="list" items ="${result}" varStatus="loop">
                  <tr>
                    <td>${loop.index + 1}</td>
                    <td>${list.contact_name}</td>
                    <td>${list.contact_email}</td>
                    <td>${list.contact_phno}</td>
                  </tr>
                 </c:forEach>
                

                
                <!-- Add more rows as needed -->
            </tbody>
        </table>
    </div>

</body>
</html>