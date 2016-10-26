<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Stuffing the crew</legend>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicPilot1">Pilot1</label>
            <div class="col-md-4">
                <select id="selectbasicPilot1" name="selectbasicPilot1" class="form-control">
                    <option value="1">Option one</option>
                    <option value="2">Option two</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicPilot2">Pilot2</label>
            <div class="col-md-4">
                <select id="selectbasicPilot2" name="selectbasicPilot2" class="form-control">
                    <option value="1">Option one</option>
                    <option value="2">Option two</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicAirhostess1">Airhostess1</label>
            <div class="col-md-4">
                <select id="selectbasicAirhostess1" name="selectbasicAirhostess1" class="form-control">
                    <option value="1">Option one</option>
                    <option value="2">Option two</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicAirhostess2">Airhostess2</label>
            <div class="col-md-4">
                <select id="selectbasicAirhostess2" name="selectbasicAirhostess2" class="form-control">
                    <option value="1">Option one</option>
                    <option value="2">Option two</option>
                </select>
            </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="buttonOK"></label>
            <div class="col-md-8">
                <button id="buttonOK" name="buttonOK" class="btn btn-success">Ok</button>
                <button id="buttonCancel" name="buttonCancel" class="btn btn-danger">Cancel</button>
            </div>
        </div>

    </fieldset>
</form>

<p>Cmd Login: ${message}</p>

<%@ include file="include/end-html.jsp" %>
