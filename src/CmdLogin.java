import beans.User;
import com.sun.deploy.net.HttpRequest;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;

class CmdLogin extends Action {
    @Override
    public Action execute(HttpServletRequest request) {

        if (request.getMethod()== "POST") {
            User user = new User();
            try {
                user.setLogin(Form.getString(request, "login", Patterns.LOGIN));
                user.setPass(Form.getString(request, "pass", Patterns.PASSWORD));
            } catch (Exception e) {
                request.setAttribute(Messages.msgError, "Invalid field format. " + e.toString());
                return null;
            }

            DAO dao = DAO.getDAO();
            if (dao.userDAO.getAll(String.format("WHERE login='%s' AND pass='%s'", user.getLogin(), user.getPass())).size() > 0) {
                request.setAttribute(Messages.msgMessage, "User login - OK ");
                return Actions.LOGOUT.action;
            }
        }
        return  null;
    }
}