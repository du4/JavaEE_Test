<%@ taglib tagdir="/WEB-INF/tags/menu" prefix="menu" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<div class="page-header">
    <h3 align="center">Flight time-table</h3>
</div>

<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Code</th>
            <th>Company</th>
            <th>Departure Time</th>
            <th>Arrival Time</th>
            <th>Plane</th>
            <th>From</th>
            <th>To</th>
            <th>Crew</th>
            <th>User</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${flights}" var="flight">
                <tr>
                <td>${flight.flightCode} </td>
                <td>${flight.company}</td>
                <td>${flight.departure_time}</td>
                <td>${flight.arrival_time}</td>
                <td>${flight.plane}</td>
                <td>${flight.to}</td>
                <td>${flight.from}</td>
                <td>${flight.crew}</td>
                <td>${flight.user}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>

    <br><br>(${adCount})
    <t:paginator step="10" count="${adCount}" urlprefix="?startNumber="/>

<%--<ul class="pagination">--%>
    <%--<li><a href="#">1</a></li>--%>
    <%--<li><a href="#">2</a></li>--%>
    <%--<li><a href="#">3</a></li>--%>
    <%--<li><a href="#">4</a></li>--%>
    <%--<li><a href="#">5</a></li>--%>
<%--</ul>--%>

    </fieldset>
    </form>





<%@ include file="include/end-html.jsp" %>