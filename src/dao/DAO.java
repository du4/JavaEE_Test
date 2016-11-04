package dao;

import connection.ConnectionCreator;

public class DAO {

    private static DAO dao; //синглтон для DAO
    private static String csPath;

    public FlightDAO flightDAO;                //DAO for flights
    public FligthStrDAO fligthStrDAO;       // DAO for flights in str
    public AirhostessDAO airhostessDAO;     //DAO for airhostess
    public AirportsDAO airportsDAO;         //DAO for aiports
    public PilotDAO pilotDAO;                //DAO for pilots
    public PlaneDAO planeDAO;                 //DAO for planes
    public UserDAO userDAO;                    //DAO for users
    public RoleDAO roleDAO;                    //DAO for roles
    public CrewDAO crewDAO;                 //DAO for crews
    public CommandDAO commandDAO;           // DAO for cmd
    //...

    public static DAO getDAO(String path) {   //singletone method
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    ConnectionCreator.path = path;
                    dao.airhostessDAO = new AirhostessDAO();
                    dao.airportsDAO = new AirportsDAO();
                    dao.pilotDAO = new PilotDAO();
                    dao.planeDAO = new PlaneDAO();
                    dao.userDAO = new UserDAO();
                    dao.roleDAO = new RoleDAO();
                    dao.flightDAO = new FlightDAO();
                    dao.fligthStrDAO = new FligthStrDAO();
                    dao.crewDAO = new CrewDAO();
                    dao.commandDAO = new CommandDAO();
                }
            }
        }
        return dao;
    }
}
