<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers - List</title>
    </head>
    <body>
        <h1>Customers</h1>
        <c:forEach items="${customerList}" var="customer" >
        <li id="spittle_<c:out value="customer.id"/>">
            <div class="customerText">
                <c:out value="${customer.firstname}" /> - <c:out value="${customer.lastname}" />
            </div>
            <div>
                <span class="customerAddress"><c:out value="${customer.addressesNumber}" /></span>
            </div>
        </li>
        </c:forEach>
    </body>
</html>
