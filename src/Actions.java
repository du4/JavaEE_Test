import beans.Command;
import beans.Role;
import beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

enum Actions {
    SIGNUP {{ this.action = new CmdSignUp();}},
    LOGIN { {this.action = new CmdLogin();}},
    LOGOUT {{this.action = new CmdLogout();}},
    INDEX {{this.action = new CmdIndex();}},
    PROFILE {{this.action = new CmdProfile();}},
    ERROR {{this.action = new CmdError();}},
    LISTUSERS {{this.action = new CmdListUsers();}},
    STUFFINGCREW {{this.action = new CmdStuffingCrew();}},
    NEWFLIGHT {{this.action = new CmdNewFlight();}};


    protected Action action = null;

    public static Action defineFrom(HttpServletRequest request){
        Action result ;
        String command = request.getParameter("command");
        if (command != null && !command.isEmpty()) {
            try {
                command = command.toUpperCase();
                if(checkPermission(command.toLowerCase(), request)){
                    result = Actions.valueOf(command).action;
                }else {
                    result = Actions.ERROR.action;
                }

            } catch (IllegalArgumentException e) {
                result = Actions.ERROR.action;
            }
        }else {
            result = Actions.INDEX.action;
        }
        return result;
    }

    private static boolean checkPermission(String cmd, HttpServletRequest request){
        HttpSession session = request.getSession();
        Object o =  session.getAttribute("commands");
        User user = (User) session.getAttribute("user");
        if (user == null){
            user = new User("tmpUser");
        }
        if (user.getRole() == Role.ADMINISTRATOR_ROLE){
            return true;
        }
        if (o != null){
            if (o instanceof List){
                List<Command> commands = (List<Command>) o;
                for (Command c:commands) {
                    if (c.getAction().equals(cmd) && user.getRole()==c.getRole() && c.isPermission()){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}