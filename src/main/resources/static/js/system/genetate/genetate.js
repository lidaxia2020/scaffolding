connect = function () {

    var url= $('#pre').val() + $('#url').val() +$('#last').val();

    var data = {
        url: url,
        username: $('#username').val(),
        pwd:$('#pwd').val()
    }


    $.ajax({
        type: "POST",
        url: "/generateCode/connect",
        contentType: "application/json",
        data: data.parseJSON(),
        success: function (data) {
            layer.msg('连接成功!', {icon: 1, time: 1000});
        },
        error: function (jqXHR) {
            console.log("发生错误：" + jqXHR.status);
        }

    });

}