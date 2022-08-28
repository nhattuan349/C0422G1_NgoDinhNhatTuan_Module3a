<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/08/2022
  Time: 9:05 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Customer Manager Application</title>
    <link rel="stylesheet" href="../../bootstrap520/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap5.min.css">

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
        <div class="col-5 header text-center fs-1">Học sinh</div>
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
                                                               href="/hocsinh">Hoc sinh</a></span>
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
                <a class="text-decoration-underline text-white" href="hocsinh?action=create">Add</a>
            </button>

            <form action="/hocsinh">
                <input type="text" name="statusDelete">
                <input type="submit" name="action" value="findByStatusDelete">
            </form>

            <form action="/hocsinh">
                <input type="text" name="tenHocSinh">
                <input type="submit" name="action" value="findByName">
            </form>

        <form  action="/hocsinh" method="get">
            <input type="text" name="tenHocSinh">
            <input type="text" name="tuoiHocSinh">
            <input type="submit"  name='action' value="findByNameAndAge">
        </form>

        <form  action="/hocsinh" method="get">
            <input type="text" name="tenHocSinh">
            <input type="text" name="tuoiHocSinh">
            <input type="submit"  name='action' value="findByNameOrAge">
        </form>

    </span>


        <div class="col-lg-12">
            <table id="tableHocSinh" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>id</th>
                    <th>Tên Học Sinh</th>
                    <th>Tuổi</th>
                    <th>Địa chỉ</th>
                    <th>Lớp</th>
                    <th>Actions1</th>
                    <th>Actions2</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="hocSinh" items="${listHocSinh}">
                    <tr>
                        <td><c:out value="${hocSinh.idHocSinh}"/></td>
                        <td><c:out value="${hocSinh.tenHocSinh}"/></td>
                        <td><c:out value="${hocSinh.tuoiHocSinh}"/></td>
                        <td><c:out value="${hocSinh.diaChi}"/></td>

                        <td>
                            <c:forEach var="lopHoc" items="${listLopHoc}">
                                <c:if test="${hocSinh.maLopHoc==lopHoc.maLopHoc}"> ${lopHoc.tenLopHoc}</c:if>
                            </c:forEach>
                        </td>


                        <td>
                            <a href="/hocsinh?action=edit&id_hoc_sinh=${hocSinh.idHocSinh}">
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
                                    onclick="setIdToFormDelete('${hocSinh.idHocSinh}')">
                                Delete
                            </button>

                                <%--                            </a>--%>
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
                Are you sure delete?
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitFormDelete()">Delete</button>
            </div>

        </div>
    </div>
</div>


<script src="../../jquery/jquery-3.5.1.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap5.min.js"></script>


<form action="/hocsinh" id="formDelete">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" id="id_hoc_sinh" name="id_hoc_sinh">
</form>

<script>
    $(document).ready(function () {
        $('#tableHocSinh').dataTable(
            {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            }
        )
    })

    function setIdToFormDelete(idHocSinh) {
        document.getElementById("id_hoc_sinh").value = idHocSinh;
    }

    function submitFormDelete() {
        document.getElementById("formDelete").submit();
    }
</script>
</body>

</html>

