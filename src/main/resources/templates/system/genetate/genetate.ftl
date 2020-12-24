<#include "../../common/_top.ftl">

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
        <form class="layui-form layui-col-md12 x-so">
            <span style="line-height:40px">数据库连接地址 ：</span>
            <span style="line-height:40px" id="pre">jdbc:mysql://</span>
            <input class="layui-input" placeholder="localhost:3306/test" name="url" id="url" value="${sysUserDto.endTime}" />
            <span style="line-height:40px" id="last">
                ?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
            </span>
            <br/>
            <span style="line-height:40px">数据库用户名 ：</span>
            <input class="layui-input" placeholder="root" name="username" id="username" value="${sysUserDto.startTime}" />
            <span style="line-height:40px">数据库密码 ：</span>
            <input class="layui-input" placeholder="123" name="pwd" id="pwd" value="${sysUserDto.endTime}" />

            <button class="layui-btn" lay-submit="" lay-filter="sreach" onclick="connect()">连接数据库</button>
        </form>
        <form class="layui-form layui-col-md12 x-so" action="/sysUser/admin-list" method="get">
            <span style="line-height:40px">包名：</span>
            <input class="layui-input" placeholder="org.gene.test" name="username" id="username" value="${sysUserDto.startTime}" />
            <button class="layui-btn" disabled="true" onclick="x_admin_show('添加用户','/sysUser/admin-add')"><i class="layui-icon"></i>配置</button>
        </form>
    </div>
    <xblock>

        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量生成</button>
        <span class="x-right" style="line-height:40px">共有数据：${list?size} 条</span>
    </xblock>
    <div id="index_table">
        <table class="layui-table">
            <thead>
            <tr>
                <th>
                    <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i
                                class="layui-icon">&#xe605;</i></div>
                </th>
                <th>表名称</th>
                <th>实体类名称</th>
                <th>Mapper名称</th>
                <th>Service名称</th>
                <th>Controller名称</th>
            </thead>
            <tbody>
            <#list data.list as item>
                <tr>
                    <td>
                        <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i
                                    class="layui-icon">&#xe605;</i></div>
                    </td>
                    <td>${item.id}</td>
                    <td>${item.userName}</td>
                    <td>${item.nickName}</td>
                    <td>${item.phone}</td>
                    <td>${item.email}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

</div>


<script type="text/javascript" src="${ctxPath}/static/js/system/genetate/genetate.js"></script>


<script>var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();</script>
</body>

</html>