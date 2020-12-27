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
        <span class="layui-form layui-col-md12 x-so">
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
        </span>
        <span class="layui-form layui-col-md12 x-so">
            <span style="line-height:40px">包名：</span>
            <input class="layui-input" placeholder="org.gene.test" name="packageName" id="packageName" value="${sysUserDto.startTime}" />
            <button class="layui-btn layui-btn-disabled" onclick="config()"><i class="layui-icon"></i>配置</button>
        </span>

    </div>
    <table class="layui-hide" id="test" lay-filter="test"></table>

</div>


<script type="text/javascript" src="${ctxPath}/static/js/system/genetate/genetate.js"></script>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量生成</button>
    </div>
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