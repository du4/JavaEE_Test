import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aliaksei on 26.10.2016.
 */
public class CommandStuffingCrew implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.STUFFINGCREW.okPage;
    }
}
