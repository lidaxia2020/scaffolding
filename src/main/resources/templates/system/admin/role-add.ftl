<#include "../../common/_top.ftl">

<body>
<div class="x-body">
    <form action="" method="post" class="layui-form layui-form-pane">
        <div class="layui-form-item">
            <label for="name" class="layui-form-label">
                <span class="x-red">*</span>角色名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="name" name="name" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">
                拥有权限
            </label>
            <table class="layui-table layui-input-block">
                <tbody>
                <#list list as sysMenu>
                    <tr>
                        <td>
                            <input type="checkbox" name="${sysMenu.menuName}"" value="${sysMenu.id}" lay-skin="primary"
                            lay-filter="father"
                            title="${sysMenu.menuName}">
                        </td>
                        <td>
                            <div class="layui-input-block">
                                <#list sysMenu.child as childSysMenu>
                                    <input name="${childSysMenu.menuName}" value="${childSysMenu.id}" lay-skin="primary"
                                           type="checkbox" value="2"
                                           title="${childSysMenu.menuName}">
                                </#list>
                            </div>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="layui-form-item layui-form-text">
            <label for="desc" class="layui-form-label">
                描述
            </label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" id="desc" name="desc" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <button class="layui-btn" lay-submit="" lay-filter="add">增加</button>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer;


        //监听提交
        form.on('submit(add)', function (data) {

            var name = data.field.name;
            var remark = data.field.name;
            var ids = new Array();
            var i = 0;
            for (var a in data.field) {
                if (a === "name" || a === "remark") {
                    continue;
                }
                ids[i] = data.field[a];
                i++;
            }
            console.log(ids);
            $.ajax({
                type: 'post',
                url: "/sysRole/save",
                data: {name: name, menuList: ids, remark: desc},
                success: function (res) {
                    if (res.status == 200) {
                        layer.alert(res.msg, {icon: 6}, function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            //刷新页面
                            parent.location.reload();
                        });

                    } else {
                        layer.alert(res.msg, {icon: 5}, function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            //刷新页面
                            parent.location.reload();
                        });
                    }
                }
            });

            return false;
        });


        form.on('checkbox(father)', function (data) {

            if (data.elem.checked) {
                $(data.elem).parent().siblings('td').find('input').prop("checked", true);
                form.render();
            } else {
                $(data.elem).parent().siblings('td').find('input').prop("checked", false);
                form.render();
            }
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