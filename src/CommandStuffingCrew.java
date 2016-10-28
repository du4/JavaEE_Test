

import javax.servlet.http.HttpServletRequest;


public class CommandStuffingCrew implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.STUFFINGCREW.okPage;
    }
}
