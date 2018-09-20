<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>控制台 - Bootstrap后台管理系统模版Ace</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- basic styles -->
    <link href="<%=basePath%>/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/font-awesome.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/ace.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/ace-skins.min.css" />

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <script src="<%=basePath%>/assets/js/jquery-2.0.3.min.js"></script>
    <script src="<%=basePath%>/assets/js/jquery-ui-1.10.3.full.min.js"></script>

    <style>
        .nav-tabs>li.active>a>[class*="icon-"] {
            opacity : .5;
        }
        .nav-tabs>li.active>a>[class*="icon-"]:hover {
            opacity : 1;
        }
    </style>
    <script src="<%=basePath%>/assets/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/assets/js/ace.min.js"></script>

</head>
<body>
    <div class="navbar navbar-default" id="navbar">
        <div class="navbar-container" id="navbar-container">
            <div class="navbar-header pull-left">
                <a href="#" class="navbar-brand">
                    <small>
                        <i class="icon-leaf"></i>
                        ACE后台管理系统
                    </small>
                </a><!-- /.brand -->
            </div><!-- /.navbar-header -->
            <div class="navbar-header pull-right" role="navigation">
                <ul class="nav ace-nav" style="height: auto;">
                    <li class="light-blue">
                        <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                            <img class="nav-user-photo" src="${pageContext.request.contextPath}/assets/avatars/user.jpg" alt="Jason's Photo" />
                            <span class="user-info" style="line-height:35px">
                                <small>Jason</small>
                            </span>
                            <i class="icon-caret-down"></i>
                        </a>
                        <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                            <li>
                                <a href="#">
                                    <i class="icon-cog"></i>
                                    设置
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="icon-user"></i>
                                    个人资料
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <i class="icon-off"></i>
                                    退出
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul><!-- /.ace-nav -->
            </div><!-- /.navbar-header -->
        </div><!-- /.container -->
    </div>

    <div class="main-container" id="main-container">
        <div class="main-container-inner">
            <a class="menu-toggler" id="menu-toggler" href="#">
                <span class="menu-text"></span>
            </a>
            <div class="sidebar" id="sidebar">
                <div class="sidebar-shortcuts" id="sidebar-shortcuts">

                </div><!-- #sidebar-shortcuts -->

                <ul class="nav nav-list">
                    <li class="navLi active">
                        <a href="${pageContext.request.contextPath}/welcome.do" target="mainFrame">
                            <i class="icon-dashboard"></i>
                            <span class="menu-text"> 控制台 </span>
                        </a>
                    </li>
                    <li class="navLi">
                        <a href="${pageContext.request.contextPath}/lawyer/lawyerList.do" navId="1" target="mainFrame_1">
                            <i class="icon-tag"></i>
                            <span class="menu-text"> 律师信息 </span>
                        </a>
                    </li>
                    <li class="navLi">
                        <a href="${pageContext.request.contextPath}/user/userList.do" navId="2" target="mainFrame_2">
                            <i class="icon-tag"></i>
                            <span class="menu-text"> 用户管理 </span>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="dropdown-toggle">
                            <i class="icon-list"></i>
                            <span class="menu-text"> 权限管理 </span>

                            <b class="arrow icon-angle-down"></b>
                        </a>

                        <ul class="submenu">
                            <li>
                                <a href="table.html" target="mainFrame">
                                    <i class="icon-double-angle-right"></i>
                                    <span>用户管理</span>
                                </a>
                            </li>

                            <li>
                                <a href="blank.html" target="mainFrame">
                                    <i class="icon-double-angle-right"></i>
                                    <span>角色管理</span>
                                </a>
                            </li>
                            <li>
                                <a href="blank.html" target="mainFrame">
                                    <i class="icon-double-angle-right"></i>
                                    <span>菜单管理</span>
                                </a>
                            </li>
                            <li>
                                <a href="blank.html" target="mainFrame">
                                    <i class="icon-double-angle-right"></i>
                                    <span>权限管理</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="dropdown-toggle">
                            <i class="icon-desktop"></i>
                            <span class="menu-text"> 预约管理 </span>

                            <b class="arrow icon-angle-down"></b>
                        </a>

                        <ul class="submenu">
                            <li>
                                <a href="news.html" target="mainFrame">
                                    <i class="icon-double-angle-right"></i>
                                    预约时间
                                </a>
                            </li>

                            <li>
                                <a href="jqgrid.html">
                                    <i class="icon-double-angle-right"></i>
                                    预约管理
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="dropdown-toggle">
                            <i class="icon-edit"></i>
                            <span class="menu-text"> 动态管理 </span>

                            <b class="arrow icon-angle-down"></b>
                        </a>

                        <ul class="submenu">
                            <li>
                                <a href="tables.html">
                                    <i class="icon-double-angle-right"></i>
                                    简单 &amp; 动态
                                </a>
                            </li>

                            <li>
                                <a href="jqgrid.html">
                                    <i class="icon-double-angle-right"></i>
                                    jqGrid plugin
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="dropdown-toggle">
                            <i class="icon-list-alt"></i>
                            <span class="menu-text"> 留言管理 </span>

                            <b class="arrow icon-angle-down"></b>
                        </a>

                        <ul class="submenu">
                            <li>
                                <a href="tables.html">
                                    <i class="icon-double-angle-right"></i>
                                    菜单管理
                                </a>
                            </li>
                            <li>
                                <a href="tables.html">
                                    <i class="icon-double-angle-right"></i>
                                    角色管理
                                </a>
                            </li>
                            <li>
                                <a href="jqgrid.html">
                                    <i class="icon-double-angle-right"></i>
                                    用户管理
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul><!-- /.nav-list -->

                <div class="sidebar-collapse" id="sidebar-collapse">
                    <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
                </div>

                <script type="text/javascript">
                    try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
                </script>
            </div>

            <div class="main-content">
                <div class="tabbable" id="tabs">
                    <ul class="nav nav-tabs" id="tabUl" style="height: 34px;">
                        <li class="active" style="margin-left: 12px;"><a data-toggle='tab' href="#div_d"><i class="green icon-home bigger-110"></i>首页&nbsp;&nbsp;<i class="grey icon-remove"></i></a></li>
                    </ul>
                    <div class="tab-content" style="border:0" id="tabContent">
                        <div id="div_d" class="tab-pane active"><iframe src="${pageContext.request.contextPath}/welcome.do" frameborder="0" width="100%" height='750px' frameBorder='0'></iframe></div>
                    </div>
                </div>
            </div>
        </div><!-- /.main-container-inner -->


    </div><!-- /.main-container -->
    <script>
        $( function() {
            var width = $(window).width()-190;
            var template_tab = "<li class='active'><a data-toggle='tab' href='href_t'>label_t&nbsp;&nbsp;<i class=\"grey icon-remove\"></i></a></li>";
            var template_content = "<div id='id_t' class='tab-pane active'><iframe name='mainFrame' frameborder='0' width='100%' height='750px' frameBorder='0' display='block'></iframe></div>";


            $(".navLi").on("click", function(){
                var navId = $(this).children("a").attr('navId');
                var target = $(this).children("a").attr("target");
                var label = $(this).find('span').eq(0).html();
                console.log(navId+','+target+','+label);

                $('#tabUl').children('li').each(function(){
                    $(this).removeClass('active');
                });
                $('#tabContent').children('div').each(function(){
                    $(this).removeClass('active');
                });

                var li = $( template_tab.replace( /href_t/g, "#div_" + navId ).replace( /label_t/g, label ) );
                var div = $( template_content.replace( /id_t/g, 'div_'+navId ).replace( 'mainFrame', 'mainFrame_'+navId ));
                $('#tabUl').append( li );
                $('#tabContent').append( div );
            });

        });
    </script>
</body>
</html>