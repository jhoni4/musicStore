<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Detail</h1>

            <p class="lead">Here is the detail information of the Customer!</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/a1.png" /> " alt="image"
                             style="width:100%"/>
                </div> 

                <div class="col-md-5">
                    <h3>${customer.customerName}</h3>
                    <p>
                       <strong>Email</strong> : ${customer.customerEmail}
                    </p>
                    <p>
                        <strong>Phone</strong> : ${customer.customerPhone}
                    </p>
                    
                    <br>
                    <a href="/zRecord/admin/customer">Back</a>
                </div>
                
            </div>
        </div>

	</div>
</div>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
