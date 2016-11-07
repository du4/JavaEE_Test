<%@ taglib tagdir="/WEB-INF/tags/menu" prefix="menu" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<div class="page-header">
    <h3 align="center">Flight time-table</h3>
</div>

<div class="container">
    <div class="row">
        <form class="form-find" action="airport?command=index" method=POST>

            <label class="col-md-1 control-label" for="to">To</label>
            <!-- Select Basic -->
            <div class="col-md-2">
                <select id="to" name="to" class="form-control">
                    <option value="" selected disabled>Please select</option>
                    <c:forEach items="${airports}" var="airport">
                        <option value=${airport.id}>${airport.acronim}</option>
                    </c:forEach>
                </select>
            </div>

            <label class="col-md-1 control-label" for="from">From</label>
            <!-- Select Basic -->
            <div class="col-md-2">
                <select id="from" name="from"  class="form-control">
                    <option value="" selected disabled>Please select</option>
                    <c:forEach items="${airports}" var="airport">
                        <option value=${airport.id}>${airport.acronim}</option>
                    </c:forEach>
                </select>
            </div>

            <!-- Button -->
                <div class="col-md-2">
                    <button id="singlebutton" class="btn btn-success">Find</button>
                </div>
        </form>
    </div>


    <table class="table table-hover">
        <thead>
        <tr>
            <th>Code</th>
            <th>Company</th>
            <th>Departure Time</th>
            <th>Arrival Time</th>
            <th>Plane</th>
            <th>To</th>
            <th>From</th>
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

    </fieldset>
    </form>





<%@ include file="include/end-html.jsp" %>