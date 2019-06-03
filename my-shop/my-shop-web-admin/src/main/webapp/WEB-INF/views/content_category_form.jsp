<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 19-5-6
  Time: 上午8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<html>
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp" />
    <link rel="stylesheet" href="/static/assets/plugins/ztree/css/zTreeStyle/zTreeStyle.min.css" />
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
                <div class="col-md-12">
                    <c:if test="${baseResult != null}">
                    <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <h4><i class="icon fa fa-ban"></i> ${baseResult.status == 200 ? "成功" : "失败"} </h4>
                            ${baseResult.message}
                    </div>
                    </c:if>


                    <!-- Horizontal Form -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${tbContent.id == null ? "新增" : "编辑"}分类</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form action="/content/category/save" id="inputForm" cssClass="form-horizontal" method="post" modelAttribute="tbContentCategory">
                            <form:hidden path="id" />
                            <%--<form:hidden path="parentId" />--%>
                            <%--<form:hidden path="isParent" />--%>

                            <input id="parentId" name="parentId" hidden="hidden" value="${tbContentCategory.parentId}"/>

                            <div class="box-body">
                                    <%-- 父节点 --%>
                                <div class="form-group">
                                    <label for="parent.name" class="col-sm-2 control-label">父级类目</label>
                                    <div class="col-sm-10">
                                        <input id="parent.name" class="form-control" placeholder="父级类目"
                                               readonly="true" data-toggle="modal" data-target="#modal-default" value="${tbContentCategory.parent.name}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="name" class="col-sm-2 control-label">分类名称</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" path="name" placeholder="分类名称" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="sortOrder" class="col-sm-2 control-label">分类排序</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" path="sortOrder" placeholder="分类排序" />
                                    </div>
                                </div>

                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </section>

    </div>

    <jsp:include page="../includes/copyright.jsp" />
</div>
<sys:modal message="<ul id='myTree' class='ztree'></ul>"/>

<jsp:include page="../includes/footer.jsp" />

<script src="/static/assets/plugins/ztree/js/jquery.ztree.core-3.5.min.js"></script>

<script>
    $(function () {
        App.InitZTree("/content/category/tree/data", ["id"], function (nodes) {
            var node = nodes[0];
            // alert(node.id);
            $("#categoryId").val(node.id);
            $("#categoryName").val(node.name);
            $("#modal-default").modal("hide");
        });
    });
</script>

</body>
</html>
