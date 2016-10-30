<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal action="airport?command=AddFlight" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Add Flight</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="code">Fligth Code</label>
            <div class="col-md-4">
                <input id="code" role="textinputCode" type="text" placeholder="code" name="code" class="form-control input-md" required="">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="company">Company</label>
            <div class="col-md-4">
                <input id="company" name="company" role="textinputCompany" type="text" placeholder="company" class="form-control input-md" required="">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="arrivalTime">Arrival Time</label>
            <div class="col-md-4">
                <input id="arrivalTime" name="arrivalTime" role="textinputArrivalTime" type="text" placeholder="arrival time" class="form-control input-md" required="">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="departureTime">Departure Time</label>
            <div class="col-md-4">
                <input id="departureTime" name="departureTime" role="textinputDepartureTime" type="text" placeholder="departure time" class="form-control input-md" required="">
            </div>
        </div>


        <%--<div class="container">--%>
            <%--<div class="row">--%>
                <%--<div class='col-sm-6'>--%>
                    <%--<div class="form-group">--%>
                        <%--<div class='input-group date' id='datetimepicker1'>--%>
                            <%--<input type='text' class="form-control" />--%>
                            <%--<span class="input-group-addon">--%>
                        <%--<span class="glyphicon glyphicon-calendar"></span>--%>
                    <%--</span>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<script type="text/javascript">--%>
                    <%--$(function () {--%>
                        <%--$('#datetimepicker1').datetimepicker();--%>
                    <%--});--%>
                <%--</script>--%>
            <%--</div>--%>
        <%--</div>--%>


        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="plane">Plane</label>
            <div class="col-md-4">
                <select id="plane" name="plane" role="selectbasicFrom" class="form-control">
                        <c:forEach items="${planes}" var="plane">
                           <option value=plane.id>${plane.planeName}</option>
                        </c:forEach>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="from">From</label>
            <div class="col-md-4">
                <select id="from" name="from" role="selectbasicFrom" class="form-control">
                    <c:forEach items="${airports}" var="airport">
                        <option value=${airport.id}>${airport.acronim}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="to">To</label>
            <div class="col-md-4">
                <select id="to" name="to" role="selectbasicTo" class="form-control">
                    <c:forEach items="${airports}" var="airport">
                        <option value=${airport.id}>${airport.acronim}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" role="singlebutton" class="btn btn-success">Add</button>
            </div>
        </div>

    </fieldset>
</form>

<%--<p>Cmd Login: ${message}</p>--%>

<%@ include file="include/end-html.jsp" %>