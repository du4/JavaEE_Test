

import javax.servlet.http.HttpServletRequest;

class CommandLogout implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.LOGOUT.inPage;
    }
}
