
import beans.User;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;

class CommandSignUp implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
//        return Action.SIGNUP.inPage;
        String page = Action.SIGNUP.inPage;
        //проверим отправлены ли данные из формы, если нет, то покажем форму
        if (request.getParameter("login") == null) {
            return page;
        }

        User user = new User();
        user.setId(0);
        //добавляем пользователей и администраторов, но это демо!!!
        int roleId = Integer.parseInt(request.getParameter("role"));
        user.setRole(roleId);

        user.setEmail(request.getParameter("email"));   //почта
        user.setLogin(request.getParameter("login"));   //логин
        user.setPass(request.getParameter("pass"));
        //пароль. тут проблема безопасности.
        // нужно "солить" и хешировать.

        //проверим поля (добавьте паттерны самостоятельно)
        if (FormHelper.valid(user.getEmail()) &&
                FormHelper.valid(user.getLogin()) &&
                FormHelper.valid(user.getPass())
                ) {
            DAO dao = DAO.getDAO();
            if (dao.userDAO.create(user)>0) {
                request.setAttribute(
                        Action.msgMessage,
                        "Пользователь создан. Введите данные для авторизации.");
                page = Action.SIGNUP.okPage;
            } else {
                request.setAttribute(
                        Action.msgMessage,
                        "Пользователь НЕ создан. Введите данные заново. " + dao.userDAO.lastSQL);
                page = Action.SIGNUP.inPage;
            }
        }
        return page;
    }
}