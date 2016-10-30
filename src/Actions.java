import javax.servlet.http.HttpServletRequest;

enum Actions {
    SIGNUP {{ this.action = new CmdSignUp();}},
    LOGIN { {this.action = new CmdLogin();}},
    LOGOUT {{this.action = new CmdLogout();}},
    ERROR {{this.action = new CmdError();}},
    LISTUSERS {{this.action = new CmdListUsers();}},
    FILLUSERS {{this.action = new CmdFillUsers();}},
    STUFFINGCREW {{this.action = new CmdStuffingCrew();}},
    NEWFLIGHT {{this.action = new CmdNewFlight();}},
    ADDFLIGHT {{this.action = new CmdAddFlight();}};

    protected Action action = null;

    public static Action defineFrom(HttpServletRequest request){
        Action result;
        String command = request.getParameter("command").toUpperCase();
        try {
            result=Actions.valueOf(command).action;
        }catch (IllegalArgumentException e){
            result = Actions.ERROR.action;
        }
        return result;
    }
}