<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <link href="<%=basePath%>/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/font-awesome.min.css" />


    <!-- ace -->
    <link rel="stylesheet" href="<%=basePath%>/assets/css/ace.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/ace-skins.min.css" />

    <script src="<%=basePath%>/assets/js/ace-extra.min.js"></script>
</head>
<body>
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <div class="error-container">
            <div class="well">
                <h1 class="grey lighter smaller">
                    <span class="blue bigger-125">
                        <i class="icon-sitemap"></i>
                        404
                    </span>
                    Page Not Found
                </h1>

                <hr />
                <h3 class="lighter smaller">We looked everywhere but we couldn't find it!</h3>

                <div>
                    <form class="form-search">
                        <span class="input-icon align-middle">
                            <i class="icon-search"></i>

                            <input type="text" class="search-query" placeholder="Give it a search..." />
                        </span>
                        <button class="btn btn-sm" onclick="return false;">Go!</button>
                    </form>

                    <div class="space"></div>
                    <h4 class="smaller">Try one of the following:</h4>

                    <ul class="list-unstyled spaced inline bigger-110 margin-15">
                        <li>
                            <i class="icon-hand-right blue"></i>
                            Re-check the url for typos
                        </li>

                        <li>
                            <i class="icon-hand-right blue"></i>
                            Read the faq
                        </li>

                        <li>
                            <i class="icon-hand-right blue"></i>
                            Tell us about it
                        </li>
                    </ul>
                </div>

                <hr />
                <div class="space"></div>

                <div class="center">
                    <a href="#" class="btn btn-grey">
                        <i class="icon-arrow-left"></i>
                        Go Back
                    </a>

                    <a href="#" class="btn btn-primary">
                        <i class="icon-dashboard"></i>
                        Dashboard
                    </a>
                </div>
            </div>
        </div><!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
    <script src="<%=basePath%>/assets/js/jquery-2.0.3.min.js"></script>
</body>
</html>
