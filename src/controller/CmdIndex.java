package controller;

import beans.Flight;
import beans.FlightStr;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

class CmdIndex extends Action {
    @Override
    Action execute(HttpServletRequest request, HttpServletResponse response) {

//        DAO dao = DAO.getDAO();
//        int startNumber = 0;
//        try {
//            startNumber = Form.getInt(req, "startNumber");
//        } catch (ParseException e) {
//            startNumber = 0;
//        }
//        String limit = String.format(" LIMIT %s,%s", startNumber, 10);
//        List<Ad> ads = dao.ad.getAll(limit);
//        req.setAttribute("adCount", dao.ad.getCount(""));
//        for (Ad ad : ads) {
//            ad.setViewNumber(++startNumber);
//        }
//        req.setAttribute("ads", ads);
//        return null;


        if (request.getMethod().equalsIgnoreCase("get")){
            DAO dao = DAO.getDAO();
            int startNumber = 0;
            try {
                startNumber = Form.getInt(request, "startNumber");
            } catch (ParseException e) {
                startNumber = 0;
            }
            String limit = String.format(" LIMIT %s,%s", startNumber, 10);
            List<FlightStr> flightStrs = dao.fligthStrDAO.getAll(limit);
            request.setAttribute("adCount", dao.fligthStrDAO.getCount(""));
            for (FlightStr flight : flightStrs) {
                flight.setViewNumber(++startNumber);
            }
            request.setAttribute("flights", flightStrs);
            return null;
//                List<FlightStr> flights = dao.fligthStrDAO.getAll("");

//                if (flights == null) {
//                    request.setAttribute(AttrMessages.msgError, "Wrong data." + dao.fligthStrDAO.lastSQL);
//                    return Actions.INDEX.action;
//                } else {
//                    request.setAttribute(AttrMessages.msgMessage, "Read flightsCount=" + flights.size());
//                    request.setAttribute("flights", flights);
//                    return Actions.INDEX.action;
//                }
//            }
        }
        return Actions.INDEX.action;
    }
}
