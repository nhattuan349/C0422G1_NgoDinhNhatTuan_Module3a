<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 23/08/2022
  Time: 2:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Học Sinh Management Application</title>
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
                                                               href="/hocsinh">Học sinh</a></span>
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
        <center>
            <h1>Học sinh Management</h1>
            <h2>
                <a href="hocsinh?action=hocsinh">List All Học sinh</a>
            </h2>
        </center>
        <div align="center">
            <form method="post">
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            Edit Học sinh
                        </h2>
                    </caption>
                    <c:if test="${hocSinh != null}">
                        <input type="hidden" name="id_hoc_sinh" value="<c:out value='${hocSinh.idHocSinh}' />"/>
                    </c:if>

                    <tr>
                        <th>Tên Học sinh:</th>
                        <td>
                            <input type="text" name="ten_hoc_sinh" size="45"
                                   value="<c:out value='${hocSinh.tenHocSinh}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Tuổi Học sinh:</th>
                        <td>
                            <input type="text" name="tuoi_hoc_sinh" size="45"
                                   value="<c:out value='${hocSinh.tuoiHocSinh}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Địa chỉ:</th>
                        <td>
                            <input type="text" name="dia_chi" size="45"
                                   value="<c:out value='${hocSinh.diaChi}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Mã Lớp học</th>
                        <td>
                            <input type="text" name="ma_lop_hoc" size="45"
                                   value="<c:out value='${hocSinh.maLopHoc}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Status Delete</th>
                        <td>
                            <input type="text" name="status_delete" size="45"
                                   value="<c:out value='${hocSinh.statusDelete}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

<script src="../../jquery/jquery-3.5.1.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../bootstrap520/js/bootstrap.min.js"></script>
</body>
</html>
