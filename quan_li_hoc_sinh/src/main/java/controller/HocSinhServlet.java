package controller;

import model.HocSinh;
import model.LopHoc;
import service.IHocSinhService;
import service.impl.HocSinhService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HocSinhServlet", value = "/hocsinh")
public class HocSinhServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IHocSinhService hocSinhService = new HocSinhService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertHocSinh(request, response);
                    break;
                case "edit":
                    updateHocSinh(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertHocSinh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String tenHocSinh = request.getParameter("ten_hoc_sinh");
        int tuoiHocSinh = Integer.parseInt(request.getParameter("tuoi_hoc_sinh"));
        String diaChi = request.getParameter("dia_chi");
        int maLopHoc = Integer.parseInt(request.getParameter("ma_lop_hoc"));
        int statusDelete = 1;

        HocSinh newHocSinh = new HocSinh(tenHocSinh, tuoiHocSinh, diaChi, maLopHoc, statusDelete);
        hocSinhService.insertHocSinh(newHocSinh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hocsinh/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateHocSinh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idHocSinh = Integer.parseInt(request.getParameter("id_hoc_sinh"));
        String tenHocSinh = request.getParameter("ten_hoc_sinh");
        int tuoiHocSinh = Integer.parseInt(request.getParameter("tuoi_hoc_sinh"));
        String diaChi = request.getParameter("dia_chi");
        int maLopHoc = Integer.parseInt(request.getParameter("ma_lop_hoc"));
        int statusDelete = Integer.parseInt(request.getParameter("status_delete"));

        HocSinh book = new HocSinh(idHocSinh, tenHocSinh, tuoiHocSinh, diaChi, maLopHoc, statusDelete);
        hocSinhService.updateHocSinh(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hocsinh/edit.jsp");
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
                case "findByStatusDelete":
                    findByStatusDelete(request, response);
                    break;
                case "findByName":
                    findByName(request, response);
                    break;
                case "findByNameAndAge":
                    findByNameAndAge(request, response);
                    break;
                case "findByNameOrAge":
                    findByNameOrAge(request, response);
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

        List<LopHoc> listLopHoc = hocSinhService.selectLopHoc();
        request.setAttribute("listLopHoc", listLopHoc);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hocsinh/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormHocSinh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idHocSinh = Integer.parseInt(request.getParameter("id_hoc_sinh"));
        HocSinh existingHocSinh = hocSinhService.selectHocSinh(idHocSinh);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hocsinh/edit.jsp");
        request.setAttribute("hocSinh", existingHocSinh);
        dispatcher.forward(request, response);
    }

    private void deleteHocSinh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idHocSinh = Integer.parseInt(request.getParameter("id_hoc_sinh"));
        hocSinhService.deleteHocSinh(idHocSinh);

        List<HocSinh> listHocSinh = hocSinhService.selectAllHocSinh();
        request.setAttribute("listHocSinh", listHocSinh);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hocsinh/list.jsp");
        dispatcher.forward(request, response);
    }

    private void findByStatusDelete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String statusDelete = request.getParameter("statusDelete");
        List<HocSinh> hocSinhs = hocSinhService.findByStatusDelete(statusDelete);
        request.setAttribute("listHocSinh", hocSinhs);

        List<LopHoc> listLopHoc = hocSinhService.selectLopHoc();
        request.setAttribute("listLopHoc", listLopHoc);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hocsinh/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String tenHocSinh = request.getParameter("tenHocSinh");

        List<HocSinh> hocSinhs = hocSinhService.findByName(tenHocSinh);
        request.setAttribute("listHocSinh", hocSinhs);

        List<LopHoc> listLopHoc = hocSinhService.selectLopHoc();
        request.setAttribute("listLopHoc", listLopHoc);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hocsinh/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByNameAndAge(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String tenHocSinh = request.getParameter("tenHocSinh");
        int tuoiHocSinh = Integer.parseInt(request.getParameter("tuoiHocSinh"));

        List<HocSinh> hocSinhs = hocSinhService.findByNameAndAge(tenHocSinh,tuoiHocSinh);
        request.setAttribute("listHocSinh", hocSinhs);

        List<LopHoc> listLopHoc = hocSinhService.selectLopHoc();
        request.setAttribute("listLopHoc", listLopHoc);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hocsinh/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByNameOrAge(HttpServletRequest request, HttpServletResponse response)
           throws SQLException, IOException, ServletException {
            String tenHocSinh = request.getParameter("tenHocSinh");
            int tuoiHocSinh = Integer.parseInt(request.getParameter("tuoiHocSinh"));

            List<HocSinh> hocSinhs = hocSinhService.findByNameOrAge(tenHocSinh,tuoiHocSinh);
            request.setAttribute("listHocSinh", hocSinhs);

            List<LopHoc> listLopHoc = hocSinhService.selectLopHoc();
            request.setAttribute("listLopHoc", listLopHoc);

            RequestDispatcher dispatcher = request.getRequestDispatcher("views/hocsinh/list.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    private void listHocSinh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<HocSinh> listHocSinh = hocSinhService.selectAllHocSinh();
        request.setAttribute("listHocSinh", listHocSinh);

        List<LopHoc> listLopHoc = hocSinhService.selectLopHoc();
        request.setAttribute("listLopHoc", listLopHoc);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hocsinh/list.jsp");
        dispatcher.forward(request, response);

    }


}
