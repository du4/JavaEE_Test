<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Sign-up</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputEmail">Login</label>
            <div class="col-md-4">
                <input id="textinputLogin" name="textinputLogin" type="text" placeholder="login" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputEmail">Email</label>
            <div class="col-md-4">
                <input id="textinputEmail" name="textinputEmail" type="text" placeholder="email" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passwordinput">Password</label>
            <div class="col-md-4">
                <input id="passwordinput" name="passwordinput" type="password" placeholder="password" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passwordinputConfirm">Confirm Password</label>
            <div class="col-md-4">
                <input id="passwordinputConfirm" name="passwordinputConfirm" type="password" placeholder="password confirm" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicRole">Select role</label>
            <div class="col-md-4">
                <select id="selectbasicRole" name="selectbasicRole" class="form-control">
                    <option value="1">Administrator</option>
                    <option value="2">Dispatcher</option>
                    <option value="3">User</option>
                </select>
            </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="button1id"></label>
            <div class="col-md-8">
                <button id="button1id" name="button1id" class="btn btn-success">Ok</button>
                <button id="button2id" name="button2id" class="btn btn-danger">Cancel</button>
            </div>
        </div>

    </fieldset>
</form>


<p>Cmd SIGN-UP: ${message}</p>

<%@ include file="include/end-html.jsp" %>


