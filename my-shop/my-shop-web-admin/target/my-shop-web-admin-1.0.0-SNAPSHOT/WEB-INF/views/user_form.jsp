<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 19-5-6
  Time: 上午8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>我的商城 | 用户管理</title>
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
                用户管理
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
                <div class="col-md-12">
                    <!-- Horizontal Form -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${tbUser.id == null ? "新增" : "编辑"}用户</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form class="form-horizontal" action="/user/list">
                            <div class="box-body">
                                <%-- email --%>
                                <div class="form-group">
                                    <label for="inputUserEmail" class="col-sm-2 control-label">邮箱</label>

                                    <div class="col-sm-10">
                                        <input type="email" class="form-control" id="inputUserEmail" placeholder="请输入邮箱">
                                    </div>
                                </div>
                                <%-- password --%>
                                <div class="form-group">
                                    <label for="inputPassword" class="col-sm-2 control-label">密码</label>

                                    <div class="col-sm-10">
                                        <input type="password" class="form-control" id="inputPassword" placeholder="请输入密码">
                                    </div>
                                </div>

                                <%-- name --%>
                                <div class="form-group">
                                    <label for="inputUserUsername" class="col-sm-2 control-label">姓名</label>

                                    <div class="col-sm-10">
                                        <input type="password" class="form-control" id="inputUserUsername" placeholder="请输入姓名">
                                    </div>
                                </div>

                                <%-- phone --%>
                                <div class="form-group">
                                    <label for="inputPhone" class="col-sm-2 control-label">手机号</label>

                                    <div class="col-sm-10">
                                        <input type="password" class="form-control" id="inputPhone" placeholder="请输入手机号">
                                    </div>
                                </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                            <!-- /.box-footer -->
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp" />
</div>


<jsp:include page="../includes/footer.jsp" />
</body>
</html>
