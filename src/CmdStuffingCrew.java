import beans.Airhostess;
import beans.Crew;
import beans.Pilot;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;


public class CmdStuffingCrew extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if (request.getMethod() == "GET") {
            DAO dao = DAO.getDAO();
            List<Pilot> pilots = dao.pilotDAO.getAll("");
            List<Airhostess> airhostesses = dao.airhostessDAO.getAll("");

            if (pilots == null || airhostesses == null) {
                request.setAttribute(Messages.msgError, "Wrong data.");
                return null;
            } else {
//            request.setAttribute(Messages.msgMessage,"Read PlanesCount=" + planes.size());
                request.setAttribute("pilots", pilots);
                request.setAttribute("airhostesses", airhostesses);
                return null;
            }
        }else{// POST

            Crew crew = new Crew();
            crew.setId(0);

            try {
                crew.setPilot1(Integer.parseInt(Form.getString(request,"pilot1", Patterns.INT)));
                crew.setPilot2(Integer.parseInt(Form.getString(request,"pilot2", Patterns.INT)));
                crew.setAirhostess1(Integer.parseInt(Form.getString(request,"airhostess1", Patterns.INT)));
                crew.setAirhostess1(Integer.parseInt(Form.getString(request,"airhostess2", Patterns.INT)));

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msgError", "Invalid field format. "+e.toString());
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.crewDAO.create(crew)>0) {
                request.setAttribute(Messages.msgMessage, "New crew is created.");
                return  null;
            } else {
                request.setAttribute(Messages.msgError, "Crew does not created. Create new user again. " + dao.crewDAO.lastSQL);
            }
            return null;
        }

    }
}
