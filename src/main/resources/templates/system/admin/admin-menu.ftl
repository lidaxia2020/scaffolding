<#include "../../common/_top.ftl">

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">管理员管理</a>
        <a>
          <cite>菜单管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so layui-form-pane">
            <#--            <div class="layui-input-inline">-->
            <#--                <select name="cateid">-->
            <#--                    <option>规则分类</option>-->
            <#--                    <option>文章</option>-->
            <#--                    <option>会员</option>-->
            <#--                    <option>权限</option>-->
            <#--                </select>-->
            <#--            </div>-->
            <#--            <div class="layui-input-inline">-->
            <#--                <select name="contrller">-->
            <#--                    <option>请控制器</option>-->
            <#--                    <option>Index</option>-->
            <#--                    <option>Goods</option>-->
            <#--                    <option>Cate</option>-->
            <#--                </select>-->
            <#--            </div>-->
            <#--            <div class="layui-input-inline">-->
            <#--                <select name="action">-->
            <#--                    <option>请方法</option>-->
            <#--                    <option>add</option>-->
            <#--                    <option>login</option>-->
            <#--                    <option>checklogin</option>-->
            <#--                </select>-->
            <#--            </div>-->
            <input class="layui-input" placeholder="权限名" name="cate_name">
            <button class="layui-btn" lay-submit="" lay-filter="sreach" type="submit"><i
                        class="layui-icon">&#xe615;</i></button>

        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon"></i>增加</button>
        <span class="x-right" style="line-height:40px">共有数据：${list?size}  条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i
                            class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>菜单名称</th>
            <th>父菜单ID</th>
            <th>路由地址</th>
            <th>是否为外链（0是 1否）</th>
            <th>备注</th>
            <th>操作</th>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <td>
                    <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i
                                class="layui-icon">&#xe605;</i>
                    </div>
                </td>
                <td>${item.id}</td>
                <td>${item.menuName}</td>
                <td>${item.parentId}</td>
                <td>${item.path}</td>
                <td>${item.isFrame}</td>
                <td>${item.remark}</td>
                <td class="td-manage">
                    <a title="编辑" onclick="x_admin_show('编辑','xxx.html')" href="javascript:;">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>

</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;


        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

    /*用户-停用*/
    function member_stop(obj, id) {
        layer.confirm('确认要停用吗？', function (index) {

            if ($(obj).attr('title') == '启用') {

                //发异步把用户状态进行更改
                $(obj).attr('title', '停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!', {icon: 5, time: 1000});

            } else {
                $(obj).attr('title', '启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!', {icon: 5, time: 1000});
            }

        });
    }

    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {icon: 1, time: 1000});
        });
    }


    function delAll(argument) {

        var data = tableCheck.getData();

        layer.confirm('确认要删除吗？' + data, function (index) {
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }
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