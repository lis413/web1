package servlets;

import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ValueServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {


        String[] str = request.getParameterValues("value");
        if (str == null){
            response.getWriter().println(0);
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(400);
        }
        else if (str[0].matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+"))
        {
            response.getWriter().println(Integer.valueOf(str[0]) * 2);
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else {
            response.getWriter().println(0);
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(400);

        }
    }
}
