package controller;

import model.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    IUserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "edit":
                    updateHocSinh(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateHocSinh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User book = new User(id, name, email, country);
        userService.updateUser(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/edit.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewFormHocSinh(request, response);
                    break;
                case "edit":
                    showEditFormHocSinh(request, response);
                    break;
                case "delete":
                    deleteHocSinh(request, response);
                    break;
                default:
                    listHocSinh(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewFormHocSinh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/create.jsp");
        dispatcher.forward(request, response);

    }

    private void showEditFormHocSinh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser= userService.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void deleteHocSinh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);

        List<User> listUser = userService.selectAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/list.jsp");
        dispatcher.forward(request, response);

    }

    private void listHocSinh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userService.selectAllUser();
        request.setAttribute("listUser", listUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/list.jsp");
        dispatcher.forward(request, response);
    }

}
