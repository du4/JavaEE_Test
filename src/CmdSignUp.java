
import beans.User;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;

class CmdSignUp extends Action {
    @Override
    public Action execute(HttpServletRequest request) {

        User user = new User();
        user.setId(0);
        try {
            user.setLogin(Form.getString(request, "login", Patterns.LOGIN));
            user.setEmail(Form.getString(request, "email", Patterns.EMAIL));
            user.setPass(Form.getString(request,"pass", Patterns.PASSWORD));
            user.setRole(Integer.parseInt(request.getParameter("role")));

        }catch (Exception e){
            request.setAttribute("msgError", "Invalid field format. "+e.toString());
            return null;
        }

        //пароль. тут проблема безопасности.
        // нужно "солить" и хешировать.

        //проверим поля (добавьте паттерны самостоятельно)
        DAO dao = DAO.getDAO();
        if (dao.userDAO.create(user)>0) {
            request.setAttribute(Messages.msgMessage, "New user is created. Input new user login and password.");
                return  Actions.SIGNUP.action;
            } else {
                request.setAttribute(Messages.msgError, "User does not created. Create new user again. " + dao.userDAO.lastSQL);
            }

        return null;
    }
}