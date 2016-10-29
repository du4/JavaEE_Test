

import beans.User;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandListUsers implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.LISTUSERS.inPage;

        DAO dao = DAO.getDAO();
        List<User> users=dao.userDAO.getAll("");

            if (users==null) {
                request.setAttribute(
                        Action.msgMessage,
                        "Wrong data.");
                page = Action.LOGIN.inPage;
            } else {
                request.setAttribute(
                        Action.msgMessage,
                        "Read usersCount="+users.size());
                        request.setAttribute("users", users);
                page = Action.LISTUSERS.okPage;
            }

        return page;
    }
}
