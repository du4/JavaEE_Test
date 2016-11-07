package controller;

import beans.FlightStr;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

class CmdIndex extends Action {
    @Override
    Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = DAO.getDAO();
        int startNumber = 0;
        String limit ="";

        if (request.getMethod().equalsIgnoreCase("post")) {
            try {
                limit = "WHERE toPort="+Integer.parseInt(Form.getString(request,"to",Patterns.INT));
                limit += " AND fromPort="+Integer.parseInt(Form.getString(request,"from",Patterns.INT))+" ";

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }


        try {
            startNumber = Form.getInt(request, "startNumber");
        } catch (ParseException e) {
            startNumber = 0;
        }
         limit += String.format(" LIMIT %s,%s", startNumber, 10);
        List<FlightStr> flightStrs = dao.fligthStrDAO.getAll(limit);
        request.setAttribute("adCount", dao.fligthStrDAO.getCount(""));
        for (FlightStr flight : flightStrs) {
            flight.setViewNumber(++startNumber);
        }
        request.setAttribute("flights", flightStrs);
        SessionAttrSesHelper.setAirportsToAttribute(request);
        return null;


//        return Actions.INDEX.action;
    }
}
