import beans.Airport;
import beans.Plane;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


class CmdNewFlight extends Action {
    @Override
    public Action execute(HttpServletRequest request) {

        DAO dao = DAO.getDAO();
        List<Plane> planes=dao.planeDAO.getAll("");
        List<Airport> airports = dao.airportsDAO.getAll("");

        if (planes==null || airports == null) {
            request.setAttribute( Messages.msgError,"Wrong data." + dao.userDAO.lastSQL);
            return  null;
        } else {
//            request.setAttribute(Messages.msgMessage,"Read PlanesCount=" + planes.size());
            request.setAttribute("planes", planes);
            request.setAttribute("airports", airports);
            return Actions.ADDFLIGHT.action;
        }
    }
}
