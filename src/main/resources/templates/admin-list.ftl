<#assign ctxPath=request.contextPath />
<!DOCTYPE html>
<html class="x-admin-sm" xmlns="http://www.w3.org/1999/html">

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.1</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${ctxPath}/static/css/font.css">
    <link rel="stylesheet" href="${ctxPath}/static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctxPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctxPath}/static/js/xadmin.js"></script>
    <script type="text/javascript" src="${ctxPath}/static/js/cookie.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">管理员管理</a>
        <a>
          <cite>管理员列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/sysUser/admin-list" method="get">
            <input class="layui-input" placeholder="开始日" name="startTime" id="startTime">
            <input class="layui-input" placeholder="截止日" name="endTime" id="endTime">
            <input type="text" name="username" id="username" placeholder="请输入用户名" autocomplete="off"
                   class="layui-input">
            <button class="layui-btn" lay-submit="" lay-filter="sreach" type="submit"><i
                        class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','/admin-add')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：${data.total} 条</span>
    </xblock>
    <div id="index_table">
        <table class="layui-table">
            <thead>
            <tr>
                <th>
                    <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i
                                class="layui-icon">&#xe605;</i></div>
                </th>
                <th>ID</th>
                <th>用户账号</th>
                <th>用户昵称</th>
                <th>手机</th>
                <th>邮箱</th>
                <th>性别</th>
                <th>最后登陆IP</th>
                <th>最后登陆时间</th>
                <th>状态</th>
                <th>操作</th>
            </thead>
            <tbody>
            <#list data.list as item>
                <tr>
                    <td>
                        <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i
                                    class="layui-icon">&#xe605;</i></div>
                    </td>
                    <td id="userId">${item.userId}</td>
                    <td>${item.userName}</td>
                    <td>${item.nickName}</td>
                    <td>${item.phone}</td>
                    <td>${item.email}</td>
                    <td>${item.sex}</td>
                    <td>${item.loginIp}</td>
                    <td>${item.loginDate}</td>
                    <td class="td-status">
                        <#if item.status = 0>
                        <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span>
                    <#else>
                        <span class="layui-btn layui-btn-normal layui-btn-disabled">已停用</span>
                    </#if>
                    </td>
                    <td class="td-manage">
                        <a onclick="admin_list.member_stop(this,${item.userId})" href="javascript:;" title="启用">
                            <i class="layui-icon">&#xe601;</i>
                        </a>
                        <a title="编辑" onclick="x_admin_show('编辑','/admin-edit')" href="javascript:;">
                            <i class="layui-icon">&#xe642;</i>
                        </a>
                        <a title="删除" onclick="admin_list.member_del(this,${item.userId})" href="javascript:;">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
    <div class="paging">
        <#--        <div>-->
        <#--            <a class="prev" href="">&lt;&lt;</a>-->
        <#--            <a class="num" href="">1</a>-->
        <#--            <span class="current">2</span>-->
        <#--            <a class="num" href="">3</a>-->
        <#--            <a class="num" href="">489</a>-->
        <#--            <a class="next" href="">&gt;&gt;</a>-->
        <#--        </div>-->
    </div>

</div>
<script type="text/javascript" src="${ctxPath}/static/js/system/admin/admin-list.js"></script>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;


        //执行一个laydate实例
        laydate.render({
            elem: '#startTime' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#endTime' //指定元素
        });
    });


</script>
<script>var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();</script>
</body>

</html>