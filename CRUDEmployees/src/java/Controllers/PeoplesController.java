package Controllers;

import Models.People;
import Models.PeopleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emilio
 */
public class PeoplesController extends HttpServlet
{

 PeopleDAO peopleDAO = new PeopleDAO();
    People people = new People();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PeoplesController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PeoplesController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
         String action = request.getParameter("action");
        switch (action)
        {
            case "List":
                  List<People> peoples = peopleDAO.Lists();
                request.setAttribute("peoples", peoples);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

 
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
