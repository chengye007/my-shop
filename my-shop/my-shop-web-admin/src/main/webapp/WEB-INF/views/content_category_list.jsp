<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 19-5-5
  Time: 上午1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<html>
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <jsp:include page="../includes/nav.jsp" />

    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="../includes/menu.jsp" />

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                内容管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">

                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <h4><i class="icon fa fa-ban"></i> ${baseResult.status == 200 ? "成功" : "失败"} </h4>
                                ${baseResult.message}
                        </div>
                    </c:if>

                    <div class="box box-info">
                        <div class="box-header">
                            <h3 class="box-title">分类列表</h3>

                            <div class="box-body">
                                <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa  fa-user-plus"></i>添加</a>&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-sm btn-default"><i class="fa fa-trash"></i>删除</button>&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i>导入</button>&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i>导出</button>&nbsp;&nbsp;&nbsp;

                            </div>
                            <%--<div class="input-group-btn">--%>
                            <%--<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>--%>
                            <%--</div>--%>

                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="dataTable" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <td>ID</td>
                                    <td>名称</td>
                                    <td>排序</td>
                                </tr>
                                </thead>

                                <c:forEach items="${tbContentCategories}" var="tbContentCategory">
                                    <tr>
                                        <td>${tbContentCategory.id}</td>
                                        <td>${tbContentCategory.name}</td>
                                        <td>${tbContentCategory.sortOrder}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp" />
</div>

<sys:modal />

<jsp:include page="../includes/footer.jsp" />
</body>
</html>
