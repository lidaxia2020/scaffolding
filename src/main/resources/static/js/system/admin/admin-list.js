var admin_list = {};


/*用户-停用*/
admin_list.member_stop = function (obj, id) {
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
admin_list.member_del = function (obj, id) {
    layer.confirm('确认要删除吗？', function (index) {
        //发异步删除数据
        // $(obj).parents("tr").remove();
        var req = new Array();
        req[0] = id;
        var data = JSON.stringify(req);

        $.ajax({
            type: "POST",
            url: "/sysUser/delete",
            contentType: "application/json",
            data: data,
            success: function (data) {
                layer.msg('已删除!', {icon: 1, time: 1000});
                location.reload();
            },
            error: function (jqXHR) {
                console.log("发生错误：" + jqXHR.status);
            }

        });
    });
}

admin_list.delAll = function (argument) {

    var data = tableCheck.getData();

    layer.confirm('确认要删除吗？' + data, function (index) {
        //捉到所有被选中的，发异步进行删除
        layer.msg('删除成功', {icon: 1});
        $(".layui-form-checked").not('.header').parents('tr').remove();
    });
}

admin_list.list = function () {

    var req = {
        username: $("#username").val(),
        startTime: $("#start").val(),
        endTime: $("#end").val(),
        page: 1,
        size: 10
    };
    var data = JSON.stringify(req);

    $.ajax({
        type: "POST",
        url: "/sysUser/admin-list",
        contentType: "application/json",
        data: data,
        success: function (data) {
            // var json = ;
            $("#index_table").empty();
            $("#index_table").append(data);

        },
        error: function (jqXHR) {
            console.log("发生错误：" + jqXHR.status);
        }
    });
}

// $(function () {
//     // admin_list.list();
//     console.info("runoob");
// })

