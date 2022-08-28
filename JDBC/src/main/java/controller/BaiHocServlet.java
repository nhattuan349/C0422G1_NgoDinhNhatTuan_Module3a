package controller;


import model.BaiHoc;
import model.DoKho;
import model.LoaiBaiHoc;
import model.Module;
import service.IBaiHocService;
import service.impl.BaiHocService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BaiHocServlet", value = "/baihoc")
public class BaiHocServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IBaiHocService baiHocService = new BaiHocService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertBaiHoc(request, response);
                    break;
                case "edit":
                    updateBaiHoc(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertBaiHoc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String tieuDe = request.getParameter("tieu_de");
        int maLoaiBaiHoc = Integer.parseInt(request.getParameter("ma_loai_bai_hoc"));
        int maDoKho = Integer.parseInt(request.getParameter("ma_do_kho"));
        int maModule = Integer.parseInt(request.getParameter("ma_module"));
        int statusDelete = 1;
        String linkBaiHoc = request.getParameter("link_bai_hoc");

        BaiHoc newBaiHoc = new BaiHoc(tieuDe, maLoaiBaiHoc, maDoKho, maModule, statusDelete, linkBaiHoc);
        baiHocService.insertBaiHoc(newBaiHoc);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/baihoc/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateBaiHoc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idBaiHoc = Integer.parseInt(request.getParameter("id_bai_hoc"));
        String tieuDe = request.getParameter("tieu_de");
        int maLoaiBaiHoc = Integer.parseInt(request.getParameter("ma_loai_bai_hoc"));
        int maDoKho = Integer.parseInt(request.getParameter("ma_do_kho"));
        int maModule = Integer.parseInt(request.getParameter("ma_module"));
        int statusDelete = Integer.parseInt(request.getParameter("status_delete"));
        String linkBaiHoc = request.getParameter("link_bai_hoc");

        BaiHoc book = new BaiHoc(idBaiHoc, tieuDe, maLoaiBaiHoc, maDoKho, maModule, statusDelete, linkBaiHoc);
        baiHocService.updateBaiHoc(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/baihoc/edit.jsp");
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
                    showNewFormBaiHoc(request, response);
                    break;
                case "edit":
                    showEditFormBaiHoc(request, response);
                case "delete":
                    deleteBaiHoc(request, response);
                case "findByStatusDelete":
                    findByStatusDelete(request, response);
                    break;
                default:
                    listBaiHoc(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewFormBaiHoc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<LoaiBaiHoc> listLoaiBaiHoc = baiHocService.selectLoaiBaiHoc();
        request.setAttribute("listLoaiBaiHoc", listLoaiBaiHoc);

        List<DoKho> listDoKho = baiHocService.selectDoKho();
        request.setAttribute("listDoKho", listDoKho);

        List<Module> listModule = baiHocService.selectModule();
        request.setAttribute("listModule", listModule);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/baihoc/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormBaiHoc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int idBaiHoc = Integer.parseInt(request.getParameter("id_bai_hoc"));
        BaiHoc existingBaiHoc = baiHocService.selectBaiHoc(idBaiHoc);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/baihoc/edit.jsp");
        request.setAttribute("baihoc", existingBaiHoc);
        dispatcher.forward(request, response);
    }

    private void deleteBaiHoc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idBaiHoc = Integer.parseInt(request.getParameter("id_bai_hoc"));
        baiHocService.deleteBaiHoc(idBaiHoc);

        List<BaiHoc> listBaiHoc = baiHocService.selectAllBaiHoc();
        request.setAttribute("listBaiHoc", listBaiHoc);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/baihoc/list.jsp");
        dispatcher.forward(request, response);
    }

    private void findByStatusDelete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String statusDelete = request.getParameter("status_delete");
        List<BaiHoc> baiHocs = baiHocService.findByStatusDelete(statusDelete);
        request.setAttribute("listBaiHoc", baiHocs);

        List<LoaiBaiHoc> listLoaiBaiHoc = baiHocService.selectLoaiBaiHoc();
        request.setAttribute("listLoaiBaiHoc", listLoaiBaiHoc);

        List<DoKho> listDoKho = baiHocService.selectDoKho();
        request.setAttribute("listDoKho", listDoKho);

        List<Module> listModule = baiHocService.selectModule();
        request.setAttribute("listModule", listModule);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/baihoc/list.jsp");
        try {
            dispatcher.forward(request, response);
        }catch (ServletException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listBaiHoc(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException{

        List<BaiHoc> listBaiHoc = baiHocService.selectAllBaiHoc();
        request.setAttribute("listBaiHoc", listBaiHoc);

        List<LoaiBaiHoc> listLoaiBaiHoc = baiHocService.selectLoaiBaiHoc();
        request.setAttribute("listLoaiBaiHoc",listLoaiBaiHoc);

        List<DoKho> listDoKho = baiHocService.selectDoKho();
        request.setAttribute("listDoKho",listDoKho);

        List<Module> listModule = baiHocService.selectModule();
        request.setAttribute("listModule",listModule);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/baihoc/list.jsp");
        dispatcher.forward(request,response);
    }
}
