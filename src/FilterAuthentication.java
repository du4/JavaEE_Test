//import beans.User;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@WebFilter(urlPatterns = {"/*"},
//        initParams = {
//                @WebInitParam(name = "authentication", value = "uid", description = "Authentication filter")})
//public class FilterAuthentication implements Filter {
//    private String cookieName;
//
//    public void init(FilterConfig fConfig) throws ServletException {
//        cookieName = fConfig.getInitParameter("iud");
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response,
//                         FilterChain chain) throws IOException, ServletException {
////      Cast to HttpServletRequest
//        HttpServletRequest req=(HttpServletRequest)request;
////      Read cookies array
//        Cookie [] cookies = req.getCookies();
//
// //     Create map of cookies
//        if (cookies != null){
//            Map <String, String> cookieMap = new HashMap();
//            for(Cookie cookie : cookies){
//                cookieMap.put(cookie.getName(), cookie.getValue());
//            }
//            String userHash = cookieMap.get("cookieName");
//            String JSessionID = cookieMap.get("JSESSIONID");
//
//            //      Get Session
//            HttpSession session=req.getSession(true);
//            if (session.getId().equals(JSessionID)){
//
//            }
//
//            Object o = session.getAttribute("user");
//            if (o != null){
//                if (o instanceof User){
//                    User user = (User)o;
//                    if (user.hashCode() == Integer.valueOf(userHash)){
//
//                    }
//                }
//            }
//        }
//
//
//
//
//
//        chain.doFilter(request, response);
//
//        //тут можно изменить/прочитать выходной поток, но учтите, он уже создан и заполнен.
//    }
//
//    public void destroy() {
//        cookieName = null;
//    }
//}