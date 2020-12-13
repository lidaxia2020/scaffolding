layui.use(['form', 'layer'], function () {
    $ = layui.jquery;
    var form = layui.form
        , layer = layui.layer;

    //自定义验证规则
    form.verify({
        nikename: function (value) {
            if (value.length < 5) {
                return '昵称至少得5个字符啊';
            }
        }
        , pass: [/(.+){6,12}$/, '密码必须6到12位']
        , repass: function (value) {
            if ($('#L_pass').val() != $('#L_repass').val()) {
                return '两次密码不一致';
            }
        }
    });


    //监听提交
    form.on('submit(add)', function (data) {
        console.log(data);
        var req = {
            userName: data.field["username"],
            nickName: data.field["username"],
            email: data.field["email"],
            phone:data.field["phone"],
            sex: data.field["sex"],
            password: data.field["L_pass"]
        };

        //发异步，把数据提交
        var data1 = JSON.stringify(req);
        console.log("111" + data1);
        $.ajax({
            type: "POST",
            url: "/sysUser/add",
            contentType: "application/json",
            data: data1,
            success: function (data) {
                layer.alert("增加成功", {icon: 6}, function () {
                    // 获得frame索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前frame
                    parent.layer.close(index);
                    // 可以对父窗口进行刷新
                    x_admin_father_reload();
                });

            },
            error: function (jqXHR) {
                console.log("发生错误：" + jqXHR.status);
            }
        });


        return false;
    });


});
