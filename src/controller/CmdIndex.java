package controller;

import beans.FlightStr;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class CmdIndex extends Action {
    @Override
    Action execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equalsIgnoreCase("get")){
//            if (SessionAttrSesHelper.isAdministrator(request)) {
                DAO dao = DAO.getDAO();
                List<FlightStr> flights = dao.fligthStrDAO.getAll("");

                if (flights == null) {
                    request.setAttribute(AttrMessages.msgError, "Wrong data." + dao.fligthStrDAO.lastSQL);
                    return Actions.INDEX.action;
                } else {
                    request.setAttribute(AttrMessages.msgMessage, "Read flightsCount=" + flights.size());
                    request.setAttribute("flights", flights);
                    return Actions.INDEX.action;
                }
//            }
        }
        return Actions.INDEX.action;
    }
}
