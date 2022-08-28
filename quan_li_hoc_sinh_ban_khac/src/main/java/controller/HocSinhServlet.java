package controller;

import model.HocSinh;
import service.IHocSinhService;
import service.impl.HocSinhService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HocSinhServlet", value = "/HocSinhServlet")
public class HocSinhServlet extends HttpServlet {

    private  static final long serialVersionUID = 1L;

    private IHocSinhService hocSinhService = new HocSinhService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) ;
        action = "";
        try {
            switch (action) {
                case "create":
                    insertHocSinh(request, response);
                    break;
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertHocSinh(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) ;
        action = "";
        try {
            switch (action) {
                case "create":
                    showNewFormHocSinh(request, response);
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
        throws SQLException,IOException, ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hocsinh/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listHocSinh(HttpServletRequest request, HttpServletResponse response)
    throws SQLException,IOException,ServletException{

    }

}
