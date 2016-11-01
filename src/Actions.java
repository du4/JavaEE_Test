import javax.servlet.http.HttpServletRequest;

enum Actions {
    SIGNUP {{ this.action = new CmdSignUp();}},
    LOGIN { {this.action = new CmdLogin();}},
    LOGOUT {{this.action = new CmdLogout();}},
    ERROR {{this.action = new CmdError();}},
    LISTUSERS {{this.action = new CmdListUsers();}},
    STUFFINGCREW {{this.action = new CmdStuffingCrew();}},
    NEWFLIGHT {{this.action = new CmdNewFlight();}};


    protected Action action = null;

    public static Action defineFrom(HttpServletRequest request){
        Action result = null;
        String command = request.getParameter("command").toUpperCase();
        if (command != null) {
            try {
                result = Actions.valueOf(command).action;
            } catch (IllegalArgumentException e) {
                result = Actions.ERROR.action;
            }
        }else {
//            result = Actions.INDEX.action;
        }

        return result;
    }
}