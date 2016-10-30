

import beans.User;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdListUsers extends Action {
    @Override
    public Action execute(HttpServletRequest request) {

        DAO dao = DAO.getDAO();
        List<User> users=dao.userDAO.getAll("");

            if (users==null) {
                request.setAttribute( Messages.msgError,"Wrong data." + dao.userDAO.lastSQL);
                return  null;
            } else {
                request.setAttribute(Messages.msgMessage,"Read usersCount=" + users.size());
                request.setAttribute("users", users);
                return Actions.FILLUSERS.action;
            }
    }
}
