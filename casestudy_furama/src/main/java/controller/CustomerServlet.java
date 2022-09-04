package controller;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ICustomerService customerService = new CustomerService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertCustomer(request, response);
                    break;
                case "edit":
                    updateCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int maLoaiKhachHang = Integer.parseInt(request.getParameter("maLoaiKhachHang"));
        String hoTen = request.getParameter("hoTen");
        String ngaySinh = request.getParameter("ngaySinh");
        int gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
        String soCMND = request.getParameter("soCMND");
        int soDienThoai = Integer.parseInt(request.getParameter("soDienThoai"));
        String email = request.getParameter("email");
        String diaChi = request.getParameter("diaChi");
        int statusDelete = 1;


        Customer newCustomer = new Customer(maLoaiKhachHang,hoTen,ngaySinh,gioiTinh,soCMND,soDienThoai,email,diaChi,statusDelete);
        customerService.insertCustomer(newCustomer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
        int maLoaiKhachHang = Integer.parseInt(request.getParameter("maLoaiKhachHang"));
        String hoTen = request.getParameter("hoTen");
        String ngaySinh = request.getParameter("ngaySinh");
        int gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
        String soCMND = request.getParameter("soCMND");
        int soDienThoai = Integer.parseInt(request.getParameter("soDienThoai"));
        String email = request.getParameter("email");
        String diaChi = request.getParameter("diaChi");
        int statusDelete = Integer.parseInt(request.getParameter("statusDelete"));

        Customer book = new Customer(maKhachHang,maLoaiKhachHang,hoTen,ngaySinh,gioiTinh,soCMND,soDienThoai,email,diaChi,statusDelete);
        customerService.updateCustomer(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/edit.jsp");
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
                    showNewFormCustomer(request, response);
                    break;
                case "edit":
                    showEditFormCustomer(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
                case "findByStatusDelete":
                    findByStatusDelete(request, response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewFormCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
        Customer existingCustomer = customerService.selectCustomer(maKhachHang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/edit.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
        customerService.deleteCustomer(maKhachHang);

        List<Customer> listCustomer = customerService.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void findByStatusDelete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String statusDelete = request.getParameter("statusDelete");
        List<Customer> customers = customerService.findByStatusDelete(statusDelete);
        request.setAttribute("listCustomer", customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
           throws SQLException, IOException, ServletException {
            List<Customer> listCustomer = customerService.selectAllCustomer();
            request.setAttribute("listCustomer", listCustomer);

            RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/list.jsp");
            dispatcher.forward(request, response);
    }
}
