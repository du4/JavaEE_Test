package dao;

public class DAO {

    private static DAO dao; //синглтон для DAO

    public FlightDAO flightDAO;                //DAO for flights
    public AirhostessDAO airhostessDAO;     //DAO for flights
    public AirportsDAO airportsDAO;         //DAO for flights
    public PilotDAO pilotDAO;                //DAO for flights
    public PlaneDAO planeDAO;                 //DAO for flights
    public UserDAO userDAO;                    //DAO для пользователей
    public RoleDAO roleDAO;                    //DAO для ролей
    //...

    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.airhostessDAO = new AirhostessDAO();
                    dao.airportsDAO = new AirportsDAO();
                    dao.pilotDAO = new PilotDAO();
                    dao.planeDAO = new PlaneDAO();
                    dao.userDAO = new UserDAO();
                    dao.roleDAO = new RoleDAO();
                    dao.flightDAO = new FlightDAO();

                }
            }
        }
        return dao;
    }
}
