package controller;

import model.HoKhau;
import model.ThanhVien;
import service.IHoKhauService;
import service.impl.HoKhauService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HoKhauServlet", value = "/hokhau")
public class HoKhauServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IHoKhauService hoKhauService = new HoKhauService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "edit":
                    updateHoKhau(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateHoKhau(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int sttHoKhau = Integer.parseInt(request.getParameter("stt_ho_khau"));
        int maThanhVien = Integer.parseInt(request.getParameter("ma_thanh_vien"));
        String tenChuHo = request.getParameter("ten_chu_ho");
        int soLuongThanhVien = Integer.parseInt(request.getParameter("so_luong_thanh_vien"));
        String ngayLapHoKhau = request.getParameter("ngay_lap_ho_khau");
        String diaChiNha = request.getParameter("dia_chi_nha");


        HoKhau book = new HoKhau(sttHoKhau, maThanhVien, tenChuHo, soLuongThanhVien, ngayLapHoKhau, diaChiNha);
        hoKhauService.updateHoKhau(book);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hokhau/edit.jsp");
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
                case "show":
                    showNewFormHoKhau(request, response);
                    break;
                case "edit":
                    showEditFormHoKhau(request, response);
                    break;
                default:
                    listHoKhau(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewFormHoKhau(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<ThanhVien> listThanhVien = hoKhauService.selectThanhVien();
        request.setAttribute("listThanhVien", listThanhVien);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hokhau/show.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormHoKhau(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int sttHoKhau = Integer.parseInt(request.getParameter("stt_ho_khau"));
        HoKhau existingHoKhau = hoKhauService.selectHoKhau(sttHoKhau);

        List<ThanhVien> listThanhVien = hoKhauService.selectThanhVien();
        request.setAttribute("listThanhVien", listThanhVien);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hokhau/edit.jsp");
        request.setAttribute("hoKhau", existingHoKhau);
        dispatcher.forward(request, response);
    }

    private void listHoKhau(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<HoKhau> listHoKhau = hoKhauService.selectAllHoKhau();
        request.setAttribute("listHoKhau", listHoKhau);

        List<ThanhVien> listThanhVien = hoKhauService.selectThanhVien();
        request.setAttribute("listThanhVien", listThanhVien);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/hokhau/list.jsp");
        dispatcher.forward(request, response);
    }


}
