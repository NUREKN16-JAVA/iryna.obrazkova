package ua.nure.obrazkova.iryna.usermanagement.web;

import ua.nure.obrazkova.iryna.usermanagement.User;
import ua.nure.obrazkova.iryna.usermanagement.db.DaoFactory;
import ua.nure.obrazkova.iryna.usermanagement.db.DatabaseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.io.IOException;

public class AddUserServlet extends UserServlet {

    public AddUserServlet() {
        super();
    }

    @Override
    String getJspTemplate() {
        return "/add.jsp";
    }

    @Override
    void doOk(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            User user = getUser(req);
            DaoFactory.getInstance().getUserDao().create(user);
            res.sendRedirect("browse");
        } catch (ValidationException e) {
            req.setAttribute("error", e.getMessage());
            showPage(req, res);
        } catch (DatabaseException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
