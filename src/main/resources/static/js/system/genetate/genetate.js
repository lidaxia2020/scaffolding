connect = function () {

    var url1 = $('#url').val();
    var username = $('#username').val();
    var pwd = $('#pwd').val();

    if (!url1.trim()) {
        layer.alert("url 不能为空");
        return false;
    }

    if (!username.trim()) {
        layer.alert("username 不能为空");
        return false;
    }
    if (!pwd.trim()) {
        layer.alert("pwd 不能为空");
        return false;
    }

    var url = 'jdbc:mysql://' + url1 + '?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai';

    var data = {
        url: url,
        username: username,
        pwd: pwd
    }


    $.ajax({
        type: "POST",
        url: "/generateCode/connect",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (data) {
            if (data.code === 0) {
                layer.alert(data.message, {icon: 1, time: 1000});
            } else {
                layer.alert(data.message, {icon: 2, time: 1000});
            }


        },
        error: function (jqXHR) {
            layer.alert("发生错误：" + jqXHR.status, {icon: 2, time: 1000});
        }
    });


}

config = function () {
    var url1 = $('#url').val();
    var username = $('#username').val();
    var pwd = $('#pwd').val();
    var packageName = $('#packageName').val();


    if (!url1.trim()) {
        layer.alert("url 不能为空");
        return false;
    }

    if (!username.trim()) {
        layer.alert("数据库用户名 不能为空");
        return false;
    }
    if (!pwd.trim()) {
        layer.alert("数据库密码 不能为空");
        return false;
    }
    if (!packageName.trim()) {
        layer.alert("包名 不能为空");
        return false;
    }

    var url = 'jdbc:mysql://' + url1 + '?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai';

    var data = {
        url: url,
        username: username,
        pwd: pwd,
        packageName: packageName
    }


    layui.use('table', function () {
        var table = layui.table;

        table.render({
            id: "generate",
            elem: '#test',
            url: '/generateCode/config',
            where: data,
            toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                , layEvent: 'LAYTABLE_TIPS'
                , icon: 'layui-icon-tips'
            }],
            title: '数据库表',
            cols: [[
                {type: 'checkbox', fixed: 'left'},
                {field: 'tableName', title: '表名称', edit: 'text'},
                {field: 'modelName', title: '实体类名称', edit: 'text'},
                {field: 'mapperName', title: 'Mapper名称', edit: 'text', sort: true},
                {field: 'controllerName', title: 'Controller名称'}
            ]],
            page: false
        });

        //头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：' + data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选' : '未全选');
                    break;

                //自定义头工具栏右侧图标 - 提示
                case 'LAYTABLE_TIPS':
                    layer.alert('这是工具栏右侧自定义的一个图标按钮');
                    break;
            }
            ;
        });

        //监听行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            //console.log(obj)
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                layer.prompt({
                    formType: 2
                    , value: data.email
                }, function (value, index) {
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });
    });


}

addAll = function () {
    var selectData = layui.table.checkStatus('generate').data;
    console.log(selectData);
}