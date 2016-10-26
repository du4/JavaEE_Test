
<p>Main: ${message}</p>

<table width="100%" border="1" cellpadding="1" cellspacing="1">
    <tbody>
    <tr>
        <th scope="col">Code</th>
        <th scope="col">Company</th>
        <th scope="col">Departure Time</th>
        <th scope="col">Arrival Time</th>
        <th scope="col">From</th>
        <th scope="col">To</th>
        <th scope="col">Crew</th>
    </tr>
    <tr>
        <td>QS690</td>
        <td>Austrian Airlines</td>
        <td>20.08.2016 05:00</td>
        <td>20.08.2016 06:00</td>
        <td>
            <div class="col-md-4">
                <select id="selectbasicFrom" name="selectbasicFrom" class="form-control">
                    <option value="1">MSQ</option>
                    <option value="2">VIE</option>
                </select>
            </div>
        </td>
        <td>
            <div class="col-md-4">
                <select id="selectbasicTo" name="selectbasicTo" class="form-control">
                    <option value="1">MSQ</option>
                    <option value="2">VIE</option>
                </select>
            </div>
        </td>
        <td>
            <a href=airport?command=STUFFINGCREW>Stuffing The Crew</a>
        </td>
    </tr>
    </tbody>
</table>

<a href=airport?command=ADDFLIGHT>Add Flight</a>


