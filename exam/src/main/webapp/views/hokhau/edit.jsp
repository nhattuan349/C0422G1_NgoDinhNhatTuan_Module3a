<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 04/09/2022
  Time: 3:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bán Hàng Management Application</title>
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
                                                               href="/banhang">Bán hàng</a></span>
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
            <h1>Hộ Khẩu Management</h1>
            <h2>
                <a href="hokhau?action=hokhau">List All Hộ Khẩu</a>
            </h2>
        </center>
        <div align="center">
            <form method="post">
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            Edit Hộ Khẩu
                        </h2>
                    </caption>
                    <c:if test="${hoKhau != null}">
                        <input type="hidden" name="sttHoKhau" value="<c:out value='${hoKhau.sttHoKhau}' />"/>
                    </c:if>



                    <tr>
                        <th>maThanhVien:</th>
                        <td>
                            <select name="maThanhVien">
                                <c:forEach items="${listThanhVien}" var="thanhVien">
                                    <option value="${thanhVien.maThanhVien}">${thanhVien.maThanhVien}</option>
                                </c:forEach>

                            </select>

                        </td>
                    </tr>

                    <tr>
                        <th>soLuongThanhVien:</th>
                        <td>
                            <input type="text" name="soLuongThanhVien" size="45"
                                   value="<c:out value='${hokhau.soLuongThanhVien}' />"
                            />
                        </td>
                    </tr>

                    <tr>
                        <th>ngayLapHoKhau:</th>
                        <td>
                            <input type="text" name="ngayLapHoKhau" size="45"
                                   value="<c:out value='${hokhau.ngayLapHoKhau}' />"
                            />
                        </td>
                    </tr>

                    <tr>
                        <th>diaChiNha:</th>
                        <td>
                            <input type="text" name="diaChiNha" size="45"
                                   value="<c:out value='${hokhau.diaChiNha}' />"
                            />
                        </td>
                    </tr>

                    <tr>
                        <th>tenChuHo:</th>
                        <td>
                            <input type="text" name="tenChuHo" size="45"
                                   value="<c:out value='${hokhau.tenChuHo}' />"
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
