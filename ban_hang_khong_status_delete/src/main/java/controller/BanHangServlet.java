package controller;

import model.BanHang;
import model.KhuyenMai;
import service.IBanHangService;
import service.impl.BanHangService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BanHangServlet", value = "/banhang")
public class BanHangServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IBanHangService banHangService = new BanHangService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertBanHang(request, response);
                    break;
                case "edit":
                    updateBanHang(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertBanHang(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String tenKhachHang = request.getParameter("tenKhachHang");
        int soDienThoai = Integer.parseInt(request.getParameter("soDienThoai"));
        String thoiGianGiaoDich = request.getParameter("thoiGianGiaoDich");
        int maKhuyenMai = Integer.parseInt(request.getParameter("maKhuyenMai"));

        BanHang newBanHang = new BanHang(tenKhachHang, soDienThoai, thoiGianGiaoDich, maKhuyenMai);
        banHangService.insertBanHang(newBanHang);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/banhang/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateBanHang(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
        String tenKhachHang = request.getParameter("tenKhachHang");
        int soDienThoai = Integer.parseInt(request.getParameter("soDienThoai"));
        String thoiGianGiaoDich = request.getParameter("thoiGianGiaoDich");
        int maKhuyenMai = Integer.parseInt(request.getParameter("maKhuyenMai"));

        BanHang book = new BanHang(maKhachHang, tenKhachHang, soDienThoai, thoiGianGiaoDich,
                maKhuyenMai);
        banHangService.updateBanHang(book);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/banhang/edit.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewFormBanHang(request, response);
                    break;
                case "edit":
                    showEditFormBanHang(request, response);
                    break;
                case "delete":
                    deleteBanHang(request, response);
                    break;
                case "findByName":
                    findByName(request, response);
                    break;
                case "findByNameAndPhone":
                    findByNameAndPhone(request, response);
                    break;
                case "findByNamePhoneAndDate":
                    findByNamePhoneAndDate(request, response);
                    break;
                default:
                    listBanHang(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewFormBanHang(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<KhuyenMai> listKhuyenMai = banHangService.selectKhuyenMai();
        request.setAttribute("listKhuyenMai", listKhuyenMai);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/banhang/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormBanHang(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
        BanHang existingBanHang = banHangService.selectBanHang(maKhachHang);

        List<KhuyenMai> listKhuyenMai = banHangService.selectKhuyenMai();
        request.setAttribute("listKhuyenMai", listKhuyenMai);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/banhang/edit.jsp");
        request.setAttribute("banHang", existingBanHang);
        dispatcher.forward(request, response);
    }

    private void deleteBanHang(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
        banHangService.deleteBanHang(maKhachHang);

        List<BanHang> listBanHang = banHangService.selectAllBanHang();
        request.setAttribute("listBanHang", listBanHang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/banhang/list.jsp");
        dispatcher.forward(request, response);
    }


    private void findByName(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String tenKhachHang = request.getParameter("tenKhachHang");

        List<BanHang> banHangs = banHangService.findByName(tenKhachHang);
        request.setAttribute("listBanHang", banHangs);

        List<KhuyenMai> listKhuyenMai = banHangService.selectKhuyenMai();
        request.setAttribute("listKhuyenMai", listKhuyenMai);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/banhang/list.jsp");
        dispatcher.forward(request, response);

    }

    private void findByNameAndPhone(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String tenKhachHang = request.getParameter("tenKhachHang");
        String soDienThoai = request.getParameter("soDienThoai");


        List<BanHang> banHangs = banHangService.findByNameAndPhone(tenKhachHang, soDienThoai);
        request.setAttribute("listBanHang", banHangs);

        List<KhuyenMai> listKhuyenMai = banHangService.selectKhuyenMai();
        request.setAttribute("listKhuyenMai", listKhuyenMai);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/banhang/list.jsp");
        dispatcher.forward(request, response);

    }

    private void findByNamePhoneAndDate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String tenKhachHang = request.getParameter("tenKhachHang");
        String soDienThoai = request.getParameter("soDienThoai");
        String thoiGianGiaoDich = request.getParameter("thoiGianGiaoDich");


        List<BanHang> banHangs = banHangService.findByNamePhoneAndDate(tenKhachHang, soDienThoai, thoiGianGiaoDich);
        request.setAttribute("listBanHang", banHangs);

        List<KhuyenMai> listKhuyenMai = banHangService.selectKhuyenMai();
        request.setAttribute("listKhuyenMai", listKhuyenMai);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/banhang/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listBanHang(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<BanHang> listBanHang = banHangService.selectAllBanHang();
        request.setAttribute("listBanHang", listBanHang);

        List<KhuyenMai> listKhuyenMai = banHangService.selectKhuyenMai();
        request.setAttribute("listKhuyenMai", listKhuyenMai);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/banhang/list.jsp");
        dispatcher.forward(request, response);
    }

}
