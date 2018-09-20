<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <link href="<%=basePath%>/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/font-awesome.min.css" />

    <!-- jqgrid -->
    <link rel="stylesheet" href="<%=basePath%>/assets/css/jquery-ui-1.10.3.full.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/ui.jqgrid.css" />

    <!-- datatime input -->
    <link rel="stylesheet" href="<%=basePath%>/assets/css/jquery-ui-1.10.3.custom.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/chosen.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/datepicker.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/bootstrap-timepicker.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/daterangepicker.css" />

    <!-- ace -->
    <link rel="stylesheet" href="<%=basePath%>/assets/css/ace.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/ace-skins.min.css" />

    <script src="<%=basePath%>/assets/js/ace-extra.min.js"></script>
</head>
<body>
    <div class="col-md-12">
        <!-- Table -->
        <table id="gridTable" class="table table-striped table-bordered table-hover"></table>
        <div id="gridPager"></div>

    </div>


    <script src="<%=basePath%>/assets/js/jquery-2.0.3.min.js"></script>
    <script src="<%=basePath%>/assets/js/bootstrap.min.js"></script>

    <script src="<%=basePath%>/assets/js/date-time/bootstrap-datepicker.min.js"></script>
    <script src="<%=basePath%>/assets/js/date-time/bootstrap-timepicker.min.js"></script>
    <script src="<%=basePath%>/assets/js/date-time/moment.min.js"></script>
    <script src="<%=basePath%>/assets/js/date-time/daterangepicker.min.js"></script>

    <script src="<%=basePath%>/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
    <script src="<%=basePath%>/assets/js/jqGrid/i18n/grid.locale-en.js"></script>

    <script src="<%=basePath%>/assets/js/ace-elements.min.js"></script>
    <script src="<%=basePath%>/assets/js/ace.min.js"></script>


    <script>
        $(function(){
            $("#gridTable").jqGrid({
                url: "<%=basePath%>/back/lawyer/list.do",
                datatype: "json",
                mtype : "post",
                //width : width,
                height: 360,
                colNames:['主键','名称','年龄', '性别', '手机','邮箱','学历','大学','工作年限','状态','创建时间'],
                colModel:[
                    {
                        name:'id',
                        index:'id',
                        key : true,
                        editable: true,
                        width:100
                    },
                    {
                        name:'userName',
                        index:'userName',
                        editable: true,
                        width:100
                    },
                    {
                        name:'realName',
                        index:'realName' ,
                        width:50,
                        editable: true
                    },
                    {
                        name:'mobile',
                        index:'mobile',
                        editable: true,
                        width:50

                    },
                    {
                        name:'email',
                        index:'email' ,
                        width:150,
                        editable: true
                    },
                    {
                        name:'imageUrl',
                        index:'imageUrl',
                        width:150,
                        editable: true
                    },
                    {
                        name:'status',
                        index:'status' ,
                        editable: true ,
                        edittype:"checkbox" ,
                        width:100,
                        editoptions: {value:"有效:无效"} ,
                        unformat: aceSwitch
                    },
                    {
                        name:'birthday',
                        index:'birthday' ,
                        editable: true ,
                        width:120,
                        sorttype:"date",
                        formatter:function(value,options,row){
                            var date =  new Date(value);
                            return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
                        }
                    },
                    {
                        name:'createDate',
                        index:'createDate' ,
                        editable: true ,
                        width:120,
                        sorttype:"date",
                        formatter:function(value,options,row){
                            var date =  new Date(value);
                            return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
                        }
                    }
                ],
                editurl: '<%=basePath%>/back/user/createOrUpdateOrDelete.do',
                viewrecords:true,
                rowNum:10,
                rowList:[10,20,30],
                pager:"#gridPager",
                altRows: true,
                multiselect: true,
                multiboxonly: true,
                autowidth: true,
                prmNames : {
                    search : "search"
                },
                jsonReader : {
                    root : "rows",
                    page: "page",
                    total: "total",
                    records : "records",
                    repeatitems : false
                },
                loadComplete : function() {
                    var table = this;
                    setTimeout(function(){
                        updatePagerIcons(table);
                        enableTooltips(table);
                    }, 0);
                }
            });

            //按钮
            //navButtons
            $('#gridTable').jqGrid('navGrid','#gridPager',
                { 	//navbar options
                    edit: true,
                    editicon : 'icon-pencil blue',
                    add: true,
                    addicon : 'icon-plus-sign purple',
                    del: true,
                    delicon : 'icon-trash red',
                    search: true,
                    searchicon : 'icon-search orange',
                    refresh: true,
                    refreshicon : 'icon-refresh green',
                    view: true,
                    viewicon : 'icon-zoom-in grey',
                },
                {
                    //edit record form
                    recreateForm: true,
                    beforeShowForm : function(e) {
                        var form = $(e[0]);
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                        style_edit_form(form);
                    },
                    top : 138, //位置
                    left: 622, //位置
                    height:600, //大小
                    width:400, //大小
                    mtype : "PUT"
                },
                {
                    //add record form
                    closeAfterAdd: true,
                    recreateForm: true,
                    viewPagerButtons: false,
                    beforeShowForm : function(e) {
                        var form = $(e[0]);
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                        style_edit_form(form);
                    },
                    top : 138, //位置
                    left: 622, //位置
                    height:600, //大小
                    width:400, //大小
                    mtype : "POST"
                },
                {
                    //delete record form
                    recreateForm: true,
                    beforeShowForm : function(e) {
                        var form = $(e[0]);
                        if(form.data('styled')) return false;
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                        style_delete_form(form);
                        form.data('styled', true);
                    },
                    onClick : function(e) {
                        alert(1);
                    },
                    top : 270, //位置
                    left: 737, //位置
                    mtype : "PUT"
                },{
                    //search form
                    recreateForm: true,
                    afterShowSearch: function(e){
                        var form = $(e[0]);
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                        style_search_form(form);
                    },
                    afterRedraw: function(){
                        style_search_filters($(this));
                    }
                    ,
                    multipleSearch: true,
                    /**
                     multipleGroup:true,
                     showQuery: true
                     */
                },
                {
                    //view record form
                    recreateForm: true,
                    beforeShowForm: function(e){
                        var form = $(e[0]);
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                    },
                    top : 138, //位置
                    left: 622, //位置
                }
            );

            $('#btn_query').on('click',function(){
                var userName = $("#userName").val();
                var realName = $("#realName").val();
                var university = $("#university").val();
                $("#gridTable").jqGrid('setGridParam',{
                    url: "<%=basePath%>/back/lawyer/list.do",
                    postData: {'name': userName,'university': university},
                    datatype: "json",
                    mtype : "post",
                    page : 1,///
                    rows : 10
                }).trigger('reloadGrid');
            });
        });
    </script>
</body>
</html>
