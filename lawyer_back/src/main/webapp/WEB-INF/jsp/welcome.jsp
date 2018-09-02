<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>控制台 - Bootstrap后台管理系统模版Ace下载</title>
    <meta name="keywords" content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文" />
    <meta name="description" content="站长素材提供Bootstrap模版,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- basic styles -->
    <link href="<%=basePath%>/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/font-awesome.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/ace.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/ace-skins.min.css" />

    <%--<script src="<%=basePath%>/assets/js/jquery-2.0.3.min.js"></script>--%>
    <%--<script src="<%=basePath%>/assets/js/bootstrap.min.js"></script>--%>
    <%--<script src="<%=basePath%>/assets/js/ace.min.js"></script>--%>

</head>
<body>


        <div class="row">
            <!-- PAGE CONTENT BEGINS -->

            <div class="well">
                欢迎使用Ace后台管理系统.
            </div>
            <div class="alert alert-block alert-info">
                <button type="button" class="close" data-dismiss="alert">
                    <i class="icon-remove"></i>
                </button>

                <i class="icon-ok green"></i>

                欢迎使用Ace后台管理系统,轻量级好用的后台管理系统.
            </div>

            <div class="alert alert-block alert-warning">
                <button type="button" class="close" data-dismiss="alert">
                    <i class="icon-remove"></i>
                </button>

                <i class="icon-ok green"></i>

                欢迎使用Ace后台管理系统,轻量级好用的后台管理系统.
            </div>
            <div class="alert alert-block alert-danger">
                <button type="button" class="close" data-dismiss="alert">
                    <i class="icon-remove"></i>
                </button>

                <i class="icon-ok green"></i>

                欢迎使用Ace后台管理系统,轻量级好用的后台管理系统.
            </div>

            <!-- PAGE CONTENT ENDS -->
        </div><!-- /.col -->


        <div class="row">
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th class="center">
                        <label>
                            <input type="checkbox" class="ace"/>
                            <span class="lbl"></span>
                        </label>
                    </th>
                    <th>名称</th>
                    <th>城市</th>
                    <th>邮编</th>
                    <th>人数</th>
                    <th>位置</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="center">
                        <label>
                            <input type="checkbox" class="ace"/>
                            <span class="lbl"></span>
                        </label>
                    </td>
                    <td>Tanmay<span class="label label-danger pull-left">钻石会员</span></td>
                    <td>Bangalore</td>
                    <td>560001</td>
                    <td>20万</td>
                    <td>东部</td>
                    <td>
                        <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
                            <a class="blue" href="#">
                                <i class="icon-zoom-in bigger-130"></i>
                            </a>

                            <a class="green" href="#">
                                <i class="icon-pencil bigger-130"></i>
                            </a>

                            <a class="red" href="#">
                                <i class="icon-trash bigger-130"></i>
                            </a>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="center">
                        <label>
                            <input type="checkbox" class="ace"/>
                            <span class="lbl"></span>
                        </label>
                    </td>
                    <td>Tanmay</td>
                    <td>Bangalore</td>
                    <td>560001</td>
                    <td>20万</td>
                    <td>东部</td>
                    <td>
                        <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
                            <a class="blue" href="#">
                                <i class="icon-zoom-in bigger-130"></i>
                            </a>

                            <a class="green" href="#">
                                <i class="icon-pencil bigger-130"></i>
                            </a>

                            <a class="red" href="#">
                                <i class="icon-trash bigger-130"></i>
                            </a>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="text-center">
                <ul class="pagination text-center">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">上一页</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li class="disabled"><a href="#">...</a></li>
                    <li><a href="#">356</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">下一页</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>


<%--<script src="<%=basePath%>/assets/js/ace-elements.min.js"></script>--%>
<%--<script src="<%=basePath%>/assets/js/ace-extra.min.js"></script>--%>

</body>
</html>
