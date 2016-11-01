import beans.Airport;
import beans.Flight;
import beans.Plane;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;


class CmdNewFlight extends Action {
    @Override
    public Action execute(HttpServletRequest request) {

        if (request.getMethod().equals("POST")) {
            Flight flight = new Flight();
            try {
                flight.setFlightCode(Form.getString(request, "code", Patterns.FLIGTH_CODE));
                flight.setCompany(Form.getString(request, "company", Patterns.LOGIN));

//                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String timestampStr = request.getParameter("departureTime")+":00";
                Timestamp timestamp1 = Timestamp.valueOf(timestampStr);
//                Timestamp departureTime = new Timestamp(Long.parseLong(Form.getString(request, "departureTime", Patterns.INT)));
                flight.setArrival_time(timestamp1 );

//                timestampStr = timestamp1.toString();

                timestampStr = request.getParameter("arrivalTime")+":00";
                timestamp1 = Timestamp.valueOf(timestampStr);
                flight.setDeparture_time(timestamp1 );

                flight.setPlane(1+Integer.parseInt(Form.getString(request,"plane",Patterns.INT)));
                flight.setFrom(1+Integer.parseInt(Form.getString(request,"from",Patterns.INT)));
                flight.setTo(1+Integer.parseInt(Form.getString(request,"to",Patterns.INT)));
                flight.setCrew(3);
                flight.setUser(1);
            }catch (Exception e) {
                e.printStackTrace();
            }

            DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
            if (dao.flightDAO.create(flight)>0) {
                request.setAttribute(AttrMessages.msgMessage, "New flight is created.");
//                return  null;
            } else {
                request.setAttribute(AttrMessages.msgError, "Flight does not created. " + dao.crewDAO.lastSQL);
            }
//            return  null;
        }else{
            DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
            List<Plane> planes = dao.planeDAO.getAll("");
            List<Airport> airports = dao.airportsDAO.getAll("");

            if (planes == null || airports == null) {
                request.setAttribute(AttrMessages.msgError, "Wrong data." + dao.userDAO.lastSQL);
//                return null;
            } else {
                request.setAttribute("planes", planes);
                request.setAttribute("airports", airports);
//                return null;
            }
        }
        return null;
    }
}
