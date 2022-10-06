<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 04/09/2022
  Time: 3:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Customer Manager Application</title>


    <link rel="stylesheet" href="../../bootstrap520/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="../../bootstrap-5.0.2-dist/css/bootstrap.min.css">

</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-3 header">
            <span>
                <a class="navbar-brand" href="#">
                    <img src="/images/logo_furama.png" alt="" width="122" height="116">
                </a>
            </span>
        </div>
        <div class="col-5 header text-center fs-1">Hộ Khẩu</div>
        <div class="col-4 header position-relative"><span class="position-absolute top-50 start-50 translate-middle">Ngô Đình Nhật Tuấn</span>
        </div>
    </div>

    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light bg-light   ">
            <div class="col-4"></div>
            <div class="col-5">
                <div class="container-fluid d-flex justify-content-center ">
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle float-end" href="#" role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    <span class="float-end "><a class="text-decoration-none"
                                                                href="/home">Home</a></span>
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#">Action</a></li>
                                    <li><a class="dropdown-item" href="#">Another action</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                                </ul>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle float-end" href="#" role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    <span class="float-end"><a class="text-decoration-none"
                                                               href="/hokhau">Hộ Khẩu</a></span>
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#">Action</a></li>
                                    <li><a class="dropdown-item" href="#">Another action</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>

            </div>

        </nav>
    </div>
    <div class="row">



        <div class="col-lg-12">
            <table id="tableHoKhau" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>mã hộ khẩu</th>
                    <th>Tên Chủ hộ</th>
                    <th>Số lượng thành viên</th>
                    <th>Ngày Lập Hộ Chiếu</th>
                    <th>Địa chỉ nhà</th>
                    <th>Actions1</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="hoKhau" items="${listHoKhau}">
                    <tr>
                        <td><c:out value="${hoKhau.sttHoKhau}"/></td>
<%--                        <td><c:out value="${hoKhau.maThanhVien}"/></td>--%>
                        <td>
                            <c:forEach var="thanhVien" items="${listThanhVien}">
                                <c:if test="${hoKhau.maThanhVien== thanhVien.maThanhVien}"> ${thanhVien.tenThanhVien}</c:if>
                            </c:forEach>
                        </td>
                        <td><c:out value="${hoKhau.tenChuHo}"/></td>
                        <td><c:out value="${hoKhau.soLuongThanhVien}"/></td>
                        <td><c:out value="${hoKhau.ngayLapHoKhau}"/></td>
                        <td><c:out value="${hoKhau.diaChiNha}"/></td>


                        <td>
                            <a href="/hokhau?action=edit&maThanhVien=${hoKhau.maThanhVien}">
                                <button class="btn bg-warning text-white">
                                    Edit
                                </button>
                            </a>
                        </td>


                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>




<script src="../../jquery/jquery-3.5.1.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="../../bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>




<script>
    $(document).ready(function () {
        $('#tableHoKhau').dataTable(
            {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            }
        )
    })




</script>
</body>

</html>


