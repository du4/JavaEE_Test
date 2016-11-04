import beans.User;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

class CmdListUsers extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        if (request.getMethod().equalsIgnoreCase("POST")){
            User user=new User();
            try {
                DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
                user.setId(Form.getInt(request,"ID"));
                user.setLogin(Form.getString(request, "Login", Patterns.LOGIN));
                user.setPass(Form.getString(request, "Password", Patterns.PASSWORD));
                user.setEmail(Form.getString(request, "Email", Patterns.EMAIL));
                user.setRole(Form.getInt(request,"fk_Role"));
                request.setAttribute(AttrMessages.msgMessage,user);
                if (user.getId()>0){
                    dao.userDAO.update(user);
                }
                if (user.getId()<0){
                    user.setId(user.getId()*(-1));
                    dao.userDAO.delete(user);
                }
                if (user.getId()==0){
                    dao.userDAO.create(user);
                }

            } catch (ParseException e) {
                e.printStackTrace();
                request.setAttribute(AttrMessages.msgMessage,"Error");
            }


           return  null;
        }else {//GET

            // here must placed authorization
            HttpSessionAttrHelper.setRolesToAttribute(request);

            DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
            List<User> users=dao.userDAO.getAll("");

            if (users==null) {
                request.setAttribute( AttrMessages.msgError,"No users found." + dao.userDAO.lastSQL);
            } else {
                request.setAttribute(AttrMessages.msgMessage,"Read usersCount=" + users.size());
                request.setAttribute("users", users);
            }
            return null;
        }

    }
}
