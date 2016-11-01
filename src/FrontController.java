import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/airport")
public class FrontController extends HttpServlet {
    public static final String CSPATH = "csPath";
    private String csPath;

    @Override
    public void init() throws ServletException {
            csPath = getServletContext().getRealPath("/WEB-INF/CSettings.json");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute(CSPATH, csPath);
        Action action = Actions.defineFrom(request);
        Action nextAction = action.execute(request);

//        if (nextAction == null){
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(action.getJsp());
            requestDispatcher.forward(request,response);
//        }else {
//            response.sendRedirect("airport?command="+nextAction);
//        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute(CSPATH, csPath);
        Action action = Actions.defineFrom(request);
        action.execute(request);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(action.getJsp());
        requestDispatcher.forward(request,response);
    }
}