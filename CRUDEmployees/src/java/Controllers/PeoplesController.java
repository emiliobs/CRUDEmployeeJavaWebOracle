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
            case "Add":
                request.getRequestDispatcher("add.jsp").forward(request, response);
                break;
            case "Save":
                String id = request.getParameter("txtId");
                String name = request.getParameter("txtName");
                String email = request.getParameter("txtEmail");
                String phone = request.getParameter("txtPhone");

                people.setId(id);
                people.setName(name);
                people.setEmail(email);
                people.setPhone(phone);

                int result = peopleDAO.add(people);

                System.out.println("Result: " + result);

                request.getRequestDispatcher("PeoplesController?action=List").forward(request, response);
                break;
            case "Edit":
                String peopleId = request.getParameter("id");
                people = peopleDAO.getPeopleById(peopleId);

                request.setAttribute("people", people);

                request.getRequestDispatcher("edit.jsp").forward(request, response);
                break;
            case "Update":

                String idPeople = request.getParameter("txtId");
                String namePeople = request.getParameter("txtName");
                String emailPeople = request.getParameter("txtEmail");
                String phonePeople = request.getParameter("txtPhone");

                People peopleEdit = new People();
                peopleEdit.setId(idPeople);
                peopleEdit.setName(namePeople);
                peopleEdit.setEmail(emailPeople);
                peopleEdit.setPhone(phonePeople);

                peopleDAO.edit(peopleEdit);

                request.getRequestDispatcher("PeoplesController?action=List").forward(request, response);
                break;
            case "Delete":
                String idDelete = request.getParameter("id");
                peopleDAO.delete(idDelete);
                
                request.getRequestDispatcher("PeoplesController?action=List").forward(request, response);
                break;
            case "Back":
                request.getRequestDispatcher("PeoplesController?action=List").forward(request, response);
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
