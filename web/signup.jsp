<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="airport?command=SIGNUP" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend align="center">Sign-up</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Login</label>
            <div class="col-md-4">
                <input id="login" name="login" role="Login" type="text" placeholder="login" class="form-control input-md" required="Login can't be empty.">
                <%--<span class="help-block">Type your login.</span>--%>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Email</label>
            <div class="col-md-4">
                <input id="email" name="email" role="Email" type="text" placeholder="email" class="form-control input-md" required="Email can't be empty.">
                <%--<span class="help-block">Type your email.</span>--%>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="pass">Password</label>
            <div class="col-md-4">
                <input id="pass" name="pass" role="Password" type="password" placeholder="password" class="form-control input-md" required="Password can't be empty.">
                <%--<span class="help-block">Type your password.</span>--%>
            </div>
        </div>


        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="role">Select role</label>
            <div class="col-md-4">
                <select id="role" name="role"  class="form-control">
                    <%--<option value="1">Administrator</option>--%>
                    <option value="3">User</option>
                    <option value="2">Dispatcher</option>
                </select>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" class="btn btn-success">Create User</button>
            </div>
        </div>

    </fieldset>
</form>


<%--<p>Cmd SIGN-UP: ${message}</p>--%>

<%@ include file="include/end-html.jsp" %>


