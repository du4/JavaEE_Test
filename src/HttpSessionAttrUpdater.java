import beans.Role;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class HttpSessionAttrUpdater {

    static void updateList  (HttpServletRequest request, String attrName){
        Object o = request.getSession().getAttribute(attrName);
        if (o != null) {
            if (o instanceof List) {
                List<Role> roleList = (List<Role>) o;
                request.setAttribute(attrName, roleList);
                request.getSession().setAttribute(attrName,roleList);
            }
        }else {
            DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
            List<Role> roles = dao.roleDAO.getAll("");
            request.setAttribute(attrName,roles);
            request.getSession().setAttribute(attrName,roles);
        }
    }
    
}
