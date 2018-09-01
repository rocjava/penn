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
    <link rel="stylesheet" href="<%=basePath%>/assets/css/jquery-ui-1.10.3.full.min.css">
    <script src="<%=basePath%>/assets/js/jquery-2.0.3.min.js"></script>
    <script src="<%=basePath%>/assets/js/jquery-ui-1.10.3.full.min.js"></script>


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
                        <a href="${pageContext.request.contextPath}/welcome.do" navId="2" target="mainFrame_2">
                            <i class="icon-tag"></i>
                            <span class="menu-text"> Add Tab </span>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="dropdown-toggle">
                            <i class="icon-list"></i>
                            <span class="menu-text"> 律所管理 </span>

                            <b class="arrow icon-angle-down"></b>
                        </a>

                        <ul class="submenu">
                            <li>
                                <a href="table.html" target="mainFrame">
                                    <i class="icon-double-angle-right"></i>
                                    <span>增删查改</span>
                                </a>
                            </li>

                            <li>
                                <a href="blank.html" target="mainFrame">
                                    <i class="icon-double-angle-right"></i>
                                    <span>空白页</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="dropdown-toggle">
                            <i class="icon-desktop"></i>
                            <span class="menu-text"> 内容管理 </span>

                            <b class="arrow icon-angle-down"></b>
                        </a>

                        <ul class="submenu">
                            <li>
                                <a href="news.html" target="mainFrame">
                                    <i class="icon-double-angle-right"></i>
                                    新闻管理
                                </a>
                            </li>

                            <li>
                                <a href="jqgrid.html">
                                    <i class="icon-double-angle-right"></i>
                                    文章管理
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="dropdown-toggle">
                            <i class="icon-edit"></i>
                            <span class="menu-text"> 服务范围 </span>

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
                            <span class="menu-text"> 系统管理 </span>

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


            <!-- /.main-content -->

<%--
            <div id="tabs">
                <ul>
                    <li><a href="#tabs-1">Nunc tincidunt</a> <span class="ui-icon ui-icon-close" role="presentation">Remove Tab</span></li>
                </ul>
                <div id="tabs-1">
                    <p>Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.</p>
                </div>
            </div>

--%>
            <div class="main-content">
                <div class="" id="tabs">
                    <ul class="nav nav-tabs" style="height: 37px;">
                        <li class="active"><a data-toggle='tab' href="#div_d">首页</a></li>
                    </ul>
                    <div class="tab-content" style="border:0">
                        <div id="div_d" class="tab-pane"><iframe src="${pageContext.request.contextPath}/welcome.do" frameborder="0" width="1132px" height='750px' frameBorder='0'></iframe></div>
                    </div>
                </div>
            </div>
        </div><!-- /.main-container-inner -->


    </div><!-- /.main-container -->
    <script>
        $( function() {
            var width = $(window).width()-190;
            var tabs = $( "#tabs" ).tabs();

            var template_tab = "<li ><a data-toggle='tab' href='href_t'>label_t</a></li>";
            var template_content = "<div id='id_t' class='tab-pane'><iframe name='mainFrame' frameborder='0' width='"+width+"px' height='750px' frameBorder='0' display='block'></iframe></div>";


            $(".navLi").on("click", function(){
                var navId = $(this).children("a").attr('navId');
                var target = $(this).children("a").attr("target");
                var label = $(this).find('span').eq(0).html();
                console.log(navId+','+target+','+label);

                $('.nav-tabs li.ui-tabs-active').removeClass('ui-tabs-active').removeClass('ui-state-active');


                var li = $( template_tab.replace( /href_t/g, "#div_" + navId ).replace( /label_t/g, label ) );
                var div = $( template_content.replace( /id_t/g, 'div_'+navId ).replace( 'mainFrame', 'mainFrame_'+navId ));
                tabs.find( ".nav-tabs" ).append( li );
                tabs.find( ".tab-content" ).append( div );
                tabs.tabs( "refresh" );
                $(".nav-tabs li:last").addClass('ui-tabs-active').addClass('ui-state-active');
                $(".nav-tabs li:last").trigger('click');
            });


        });
    </script>
</body>
</html>