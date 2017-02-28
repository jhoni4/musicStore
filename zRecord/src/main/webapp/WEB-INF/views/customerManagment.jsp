<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Management Page</h1>

            <p class="lead">This is the customer management page.</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Username</th>
                <th>Enabled</th>
                <th>Actions</th>

            </tr>
            </thead>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerEmail}</td>
                    <td>${customer.customerPhone}</td>
                    <td>${customer.username}</td>
                    <td>${customer.enabled}</td>
                    <td><%-- <a href="<spring:url value="/admin/deleteCustomer/${customer.customerId}" />"><span
							class="glyphicon glyphicon-remove"></span></a>  --%>
						<a href="<spring:url value="/admin/viewCustomer/${customer.customerId}" />"><span
							class="glyphicon glyphicon-info-sign"></span></a>
						<%-- <a href="<spring:url value="/admin/editCustomer/${customer.customerId}" />"><span
							class="glyphicon glyphicon-edit"></span></a> --%>
					</td>
                </tr>
            </c:forEach>
        </table>
	</div>
</div>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
