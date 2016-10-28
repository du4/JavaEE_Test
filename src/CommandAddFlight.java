

import javax.servlet.http.HttpServletRequest;


class CommandAddFlight implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.ADDFLIGHT.okPage;
    }
}
