<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Add fiigth</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputCode">Fligth Code</label>
            <div class="col-md-4">
                <input id="textinputCode" role="textinputCode" type="text" placeholder="code" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputCompany">Company</label>
            <div class="col-md-4">
                <input id="textinputCompany" role="textinputCompany" type="text" placeholder="company" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputArrivalTime">Arrival Time</label>
            <div class="col-md-4">
                <input id="textinputArrivalTime" role="textinputArrivalTime" type="text" placeholder="arrival time" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputDepartureTime">Departure Time</label>
            <div class="col-md-4">
                <input id="textinputDepartureTime" role="textinputDepartureTime" type="text" placeholder="departure time" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicFrom">From</label>
            <div class="col-md-4">
                <select id="selectbasicFrom" role="selectbasicFrom" class="form-control">
                    <option value="1">MSQ</option>
                    <option value="2">VIE</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicTo">To</label>
            <div class="col-md-4">
                <select id="selectbasicTo" role="selectbasicTo" class="form-control">
                    <option value="1">MSQ</option>
                    <option value="2">VIE</option>
                </select>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebuttonStuffing">Stuffing Crew</label>
            <div class="col-md-4">
                <button id="singlebuttonStuffing" role="singlebuttonStuffing" class="btn btn-default">Stuffing</button>
            </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="buttonOk"></label>
            <div class="col-md-8">
                <button id="buttonOk" role="buttonOk" class="btn btn-success">Ok</button>
                <button id="buttonCancel" role="buttonCancel" class="btn btn-danger">Cancel</button>
            </div>
        </div>

    </fieldset>
</form>