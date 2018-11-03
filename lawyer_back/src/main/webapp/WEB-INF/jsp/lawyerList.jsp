<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
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
            <form class="form-horizontal" role="form" id="form_query" action="">
                <br>
                <div class="row">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="control-label col-md-3 no-padding-right" for="realName">姓名:</label>

                                <div class="col-md-6">
                                    <input type="text" name="realName" id="realName" placeholder="Real name" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 no-padding-right"> 是否显示: </label>

                                <div class="col-md-6">
                                    <label>
                                        <input name="switch-field-1" class="ace ace-switch ace-switch-5" type="checkbox" />
                                        <span class="lbl"></span>
                                    </label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 no-padding-right"> 工作时间: </label>
                                <div class="col-md-6">
                                    <div class="input-group">
                                        <input class="form-control date-picker" id="id-date-picker-1" type="text" data-date-format="dd-mm-yyyy" />
                                        <span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
												</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="control-label col-md-3 no-padding-right" for="userName"> 用户名: </label>
                                <div class="col-md-6">
                                    <input type="text" id="userName" placeholder="User name"  class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 no-padding-right"> 入驻时间: </label>
                                <div class="col-md-6">
                                    <div class="input-group">
												<span class="input-group-addon">
													<i class="icon-calendar bigger-110"></i>
												</span>
                                        <input class="form-control" type="text" name="date-range-picker" id="id-date-range-picker-1" />
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 no-padding-right" for="form-field-select-1">学历:</label>

                                <div class="col-md-6">
                                    <select class="form-control" id="form-field-select-1">
                                        <option value="" selected>请选择</option>
                                        <option value="CA">博士</option>
                                        <option value="CO">硕士</option>
                                        <option value="CT">本科</option>
                                        <option value="CT">大专</option>
                                        <option value="CT">高中</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="control-label col-md-3 no-padding-right" for="university">学校:</label>
                                <div class="col-md-6">
                                    <input type="text" name="university" id="university" autocomplete="off" placeholder="University" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 no-padding-right"> 是否显示: </label>

                                <div class="col-md-6">
                                    <label>
                                        <input name="switch-field-1" class="ace ace-switch ace-switch-5" type="checkbox" />
                                        <span class="lbl"></span>
                                    </label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 no-padding-right" for="timepicker1">上班时间:</label>
                                <div class="col-md-6">
                                    <div class="input-group bootstrap-timepicker">
                                        <input id="timepicker1" type="text" class="form-control" />
                                        <span class="input-group-addon">
													<i class="icon-time bigger-110"></i>
												</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 text-center">
                        <div class="btn-group ">
                            <button class="btn btn-info btn-sm" id="btn_query" type="button">
                                <i class="icon-ok"></i>
                                查询
                            </button>
                            <button class="btn btn-sm" type="reset">
                                <i class="icon-undo"></i>
                                重置
                            </button>
                        </div>
                    </div>
                </div>
            </form>
            <br>
        </div>

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

<script type="text/javascript">
    $('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
        $(this).prev().focus();
    });
    $('input[name=date-range-picker]').daterangepicker().prev().on(ace.click_event, function(){
        $(this).next().focus();
    });
    $('#timepicker1').timepicker({
        minuteStep: 1,
        showSeconds: true,
        showMeridian: false
    }).next().on(ace.click_event, function(){
        $(this).prev().focus();
    });
    $('#modal-form input[type=file]').ace_file_input({
        style:'well',
        btn_choose:'Drop files here or click to choose',
        btn_change:null,
        no_icon:'icon-cloud-upload',
        droppable:true,
        thumbnail:'large'
    });

    $("#bootbox-confirm").on(ace.click_event, function() {
        bootbox.confirm("Are you sure?", function(result) {
            if(result) {
                //
            }
        });
    });

    //chosen plugin inside a modal will have a zero width because the select element is originally hidden
    //and its width cannot be determined.
    //so we set the width after modal is show
    $("#btn_add").on("click", function () {
        $("#modal-form").modal();
    });

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
                    name:'name',
                    index:'name',
                    editable: true,
                    width:100
                },
                {
                    name:'age',
                    index:'age' ,
                    width:50,
                    editable: true
                },
                {
                    name:'gender',
                    index:'gender',
                    editable: true,
                    width:50,
                    edittype: 'checkbox',
                    editoptions: {value:"男:女"},
                    unformat: aceSwitch

                },
                {
                    name:'mobile',
                    index:'mobile' ,
                    width:150,
                    editable: true
                },
                {
                    name:'email',
                    index:'email',
                    width:150,
                    editable: true
                },
                {
                    name:'degree',
                    index:'degree' ,
                    editable: true ,
                    width:100,
                    edittype:"select",
                    editoptions:{value:"1:大专;2:本科;3:研究生;4:博士"},
                    formatter:function(value,options,row){
                       if(value == 1){
                           return '大专';
                       }else if(value == 2){
                           return '本科';
                       }else if(value == 3){
                           return '研究生';
                       }else if(value == 4){
                           return '博士';
                       }
                    }
                },
                {
                    name:'university',
                    index:'university' ,
                    width:100,
                    editable: true
                },
                {
                    name:'workingYears',
                    index:'workingYears' ,
                    width:50,
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
            editurl: '<%=basePath%>/back/lawyer/createOrUpdateOrDelete.do',
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

    function aceSwitch( cellvalue, options, cell ) {
        setTimeout(function(){
            $(cell) .find('input[type=checkbox]')
                .wrap('<label class="inline" />')
                .addClass('ace ace-switch ace-switch-5')
                .after('<span class="lbl"></span>');
        }, 0);
    }

    function pickDate( cellvalue, options, cell ) {
        setTimeout(function(){
            $(cell) .find('input[type=text]')
                .datepicker({format:'yyyy-mm-dd' , autoclose:true});
        }, 0);
    }


    function style_edit_form(form) {
        console.log(form);
        //enable datepicker on "sdate" field and switches for "stock" field
        form.find('input[name=createDate]').datepicker({format:'yyyy-mm-dd' , autoclose:true}).end();
        form.find('input[name=status]').addClass('ace ace-switch ace-switch-5').before('<label class="inline">').after('<label/>').after('<span class="lbl"></span>').end();
        form.find('input[name=id]').attr('disabled','disabled').end();
        form.find('input[name=gender]').addClass('ace ace-switch ace-switch-2').before('<label class="inline">').after('<label/>').after('<span class="lbl"></span>').end();

        //update buttons classes
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
        buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
        buttons.eq(1).prepend('<i class="icon-remove"></i>')

        buttons = form.next().find('.navButton a');
        buttons.find('.ui-icon').remove();
        buttons.eq(0).append('<i class="icon-chevron-left"></i>');
        buttons.eq(1).append('<i class="icon-chevron-right"></i>');
    }


    function style_delete_form(form) {
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
        buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
        buttons.eq(1).prepend('<i class="icon-remove"></i>')
    }

    function style_search_filters(form) {
        form.find('.delete-rule').val('X');
        form.find('.add-rule').addClass('btn btn-xs btn-primary');
        form.find('.add-group').addClass('btn btn-xs btn-success');
        form.find('.delete-group').addClass('btn btn-xs btn-danger');
    }
    function style_search_form(form) {
        var dialog = form.closest('.ui-jqdialog');
        var buttons = dialog.find('.EditTable')
        buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
        buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
        buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
    }

    //replace icons with FontAwesome icons like above
    function updatePagerIcons(table) {
        var replacement =
            {
                'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
                'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
                'ui-icon-seek-next' : 'icon-angle-right bigger-140',
                'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
            };
        $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
            var icon = $(this);
            var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
            if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
        })
    }
    function enableTooltips(table) {
        $('.navtable .ui-pg-button').tooltip({container:'body'});
        $(table).find('.ui-pg-div').tooltip({container:'body'});
    }


</script>
</body>
</html>
