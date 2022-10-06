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
        <div class="col-5 header text-center fs-1">Bán Hàng</div>
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
                                                               href="/banhang">Bán Hàng</a></span>
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
    <span>
            <button type="button" class="btn btn bg-success">
                <a class="text-decoration-underline text-white" href="banhang?action=create">Add</a>
            </button>

            <form action="/banhang">
                <input type="text" name="tenKhachHang">
                <input type="submit" name="action" value="findByName">
            </form>

        <form action="/banhang" method="get">
            <input type="text" name="tenKhachHang">
            <input type="text" name="soDienThoai">
            <input type="submit" name='action' value="findByNameAndPhone">
        </form>

        <form action="/banhang" method="get">
            <input type="text" name="tenKhachHang">
            <input type="text" name="soDienThoai">
            <input type="text" name="thoiGianGiaoDich">
            <input type="submit" name='action' value="findByNamePhoneAndDate">
        </form>


    </span>


        <div class="col-lg-12">
            <table id="tableBanHang" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã Khach Hàng</th>
                    <th>Tên Khách Hàng</th>
                    <th>Số Điện Thoại</th>
                    <th>Thời gian giao dịch</th>
                    <th>Mã Khuyến Mãi</th>
                    <th>Actions1</th>
                    <th>Actions2</th>
                    <th>Actions3</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach varStatus="status" var="banHang" items="${listBanHang}">
                    <tr>
                        <td><c:out value="${status.count}"/></td>
                        <td><c:out value="${banHang.maKhachHang}"/></td>
                        <td><c:out value="${banHang.tenKhachHang}"/></td>
                        <td><c:out value="${banHang.soDienThoai}"/></td>
                        <td><c:out value="${banHang.thoiGianGiaoDich}"/></td>

                        <td>
                            <c:forEach var="khuyenMai" items="${listKhuyenMai}">
                                <c:if test="${banHang.maKhuyenMai == khuyenMai.maKhuyenMai}">
                                    <span id="${status.count}">${khuyenMai.tenKhuyenMai}</span> </c:if>
                            </c:forEach>
                        </td>


                        <td>
                            <a href="/banhang?action=edit&maKhachHang=${banHang.maKhachHang}">
                                <button class="btn bg-warning text-white">
                                    Edit
                                </button>
                            </a>
                        </td>

                        <td>
                                <%--<a href="/customer?action=delete&ma_khach_hang=${customer.maKhachHang}">--%>
                            <!-- Button to Open the Modal -->
                            <button type="button" class="btn btn-primary bg-danger" data-bs-toggle="modal"
                                    data-bs-target="#modalDelete"
                                    onclick="setIdToFormDelete('${banHang.maKhachHang}','${banHang.tenKhachHang}',
                                            '${banHang.soDienThoai}','${banHang.thoiGianGiaoDich}','${status.count}')">
                                Delete
                            </button>

                                <%--                            </a>--%>
                        </td>

                        <td>
                                <%--<a href="/customer?action=delete&ma_khach_hang=${customer.maKhachHang}">--%>
                            <!-- Button to Open the Modal -->
                            <button type="button" class="btn btn-primary bg-primary" data-bs-toggle="modal"
                                    data-bs-target="#modalInformaion"
                                    onclick="setIdToFormInformation('${banHang.maKhachHang}','${banHang.tenKhachHang}'
                                            ,'${banHang.soDienThoai}','${banHang.thoiGianGiaoDich}','${status.count}')">
                                Thông tin
                            </button>

                                <%-- </a>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- The modalDelete -->
<div class="modal" id="modalDelete">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Modal Heading</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <span>Are you sure delete?</span>
                <table class="table table-striped table-bordered">
                    <tr>
                        <td>
                            <span style="color: red" id="maKH"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span style="color: red" id="tenKhachHang"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span style="color: red" id="soDienThoai"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span style="color: red" id="thoiGianGiaoDich"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span style="color: red" id="khuyenMai"></span>
                        </td>
                    </tr>
                </table>


            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitFormDelete()">Delete</button>
            </div>

        </div>
    </div>
</div>


<div class="modal" id="modalInformaion">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Modal Heading</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">

                <table class="table table-striped table-bordered">
                    <tr>
                        <td>
                            <span style="color: red" id="maKhachHangI"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span style="color: red" id="tenKhachHangI"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span style="color: red" id="soDienThoaiI"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span style="color: red" id="thoiGianGiaoDichI"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span style="color: red" id="khuyenMaiI"></span>
                        </td>
                    </tr>
                </table>


            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitFormInformaion()">OK</button>
            </div>

        </div>
    </div>
</div>


<script src="../../jquery/jquery-3.5.1.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="../../bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>


<form action="/banhang" id="formDelete">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" id="maKhachHang" name="maKhachHang">
</form>

<form action="/banhang" id="formInformation">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" id="maKhachHangIn" name="maKhachHang">
</form>

<script>
    $(document).ready(function () {
        $('#tableBanHang').dataTable(
            {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            }
        )
    })

    function setIdToFormDelete(maKhachHang, tenKhachHang, soDienThoai, thoiGianGiaoDich, khuyenMai) {
        document.getElementById("maKhachHang").value = maKhachHang;

        document.getElementById("maKH").innerText = maKhachHang;
        document.getElementById("tenKhachHang").innerText = tenKhachHang;
        document.getElementById("soDienThoai").innerText = soDienThoai;
        document.getElementById("thoiGianGiaoDich").innerText = thoiGianGiaoDich;
        document.getElementById("khuyenMai").innerText = document.getElementById(khuyenMai).textContent
    }

    function submitFormDelete() {
        document.getElementById("formDelete").submit();
    }
        // Hiển thị thông tin
        function setIdToFormInformation(maKhachHang, tenKhachHang, soDienThoai, thoiGianGiaoDich, khuyenMai) {
            document.getElementById("maKhachHang").value = maKhachHang;

            document.getElementById("maKhachHangI").innerText = maKhachHang;
            document.getElementById("tenKhachHangI").innerText = tenKhachHang;
            document.getElementById("soDienThoaiI").innerText = soDienThoai;
            document.getElementById("thoiGianGiaoDichI").innerText = thoiGianGiaoDich;
            document.getElementById("khuyenMaiI").innerText = document.getElementById(khuyenMai).textContent
        }

        function submitFormInformaion() {
            document.getElementById("formInformation").submit();
        }

</script>
</body>

</html>


