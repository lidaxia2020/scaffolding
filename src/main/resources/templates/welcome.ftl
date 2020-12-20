<#include "./common/_top.ftl">

<body>
<div class="x-body">
    <blockquote class="layui-elem-quote">欢迎管理员：
        <span class="x-red">test</span>！
        <span class="x-right" style="line-height:40px">当前时间: <label id="showTime"></label></span>
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>服务器信息</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>主机名</th>
                    <td>${hostName}</td>
                </tr>
                <tr>
                    <th>IP地址</th>
                    <td>${hostAddress}</td>
                </tr>
                <tr>
                    <th>OS.名称</th>
                    <td>${osName}</td>
                </tr>
                <tr>
                    <th>操作系统架构</th>
                    <td>${osVersion}</td>
                </tr>
                <tr>
                    <th>系统核数</th>
                    <td>${systemsAuditing}</td>
                </tr>
                <tr>
                    <th>总的物理内存</th>
                    <td>${totalMemorySize}</td>
                </tr>
                <tr>
                    <th>剩余的物理内存</th>
                    <td>${freePhysicalMemorySize}</td>
                </tr>
                <tr>
                    <th>已使用的物理内存</th>
                    <td>${usedMemory}</td>
                </tr>

                <tr>
                    <th>Tomcat.版本</th>
                    <td>1.0.180420</td>
                </tr>
                <tr>
                    <th>JVM.版本</th>
                    <td>${javaRuntimeVersion}</td>
                </tr>


                </tbody>
            </table>
        </div>
    </fieldset>
    <fieldset class="layui-elem-field">
        <legend>性能情况</legend>
        <div class="layui-field-box">
            <td><div id="cpu" style="width: 100%;height:400px;"></div></td>
            <td><div id="memory" style="width: 100%;height:400px;"></div></td>
        </div>
    </fieldset>

    <fieldset class="layui-elem-field">
        <legend>开发团队</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>版权所有</th>
                    <td>lidaxia.top
                        <#--                                <a href="http://x.xuebingsi.com/" class='x-a' target="_blank">访问官网</a></td>-->
                </tr>
                <tr>
                    <th>开发者</th>
                    <td>李大虾(843180879@qq.com)</td>
                </tr>
                </tbody>
            </table>
        </div>
    </fieldset>
    <blockquote class="layui-elem-quote layui-quote-nm">天行健，君子以自强不息。</blockquote>
</div>

<script src="${ctxPath}/static/js/echarts.min.js" charset="utf-8"></script>


<script type="text/javascript">
    var cpu = document.getElementById("cpu");
    var cpuChart = echarts.init(cpu);
    var memory = document.getElementById("memory");
    var memoryChart = echarts.init(memory);

    var timeData = [];
    var cpuData = [];
    var memoryData = [];

    cpuOption = {
        title: {
            text: 'cpu',
            left: 0
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: []
        },
        yAxis: {
            boundaryGap: [0, '50%'],
            type: 'value'
        },
        series: [
            {
                name: '成交',
                type: 'line',
                smooth: true,
                symbol: 'none',
                stack: 'a',
                areaStyle: {
                    normal: {}
                },
                data: []
            }
        ]
    };

    memoryOption = {
        title: {
            text: 'memory',
            left: 0
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: []
        },
        yAxis: {
            boundaryGap: [0, '50%'],
            type: 'value'
        },
        series: [
            {
                name: '成交',
                type: 'line',
                smooth: true,
                symbol: 'none',
                stack: 'a',
                areaStyle: {
                    normal: {}
                },
                data: []
            }
        ]
    };



    // setInterval(function () {
    //
    //     $.post("/Home/AsycData", {}, function (data) {
    //         console.log(data);
    //         timeData.push(data.timeData);
    //         cpuData.push(data.cpuData);
    //         memoryData.push(data.memoryData);
    //
    //         if(timeData.length > 30){
    //             timeData.shift();
    //             cpuData.shift();
    //             memoryData.shift();
    //         }
    //
    //     });
    //
    //     cpuChart.setOption({
    //         xAxis: {
    //             data: timeData
    //         },
    //         series: [{
    //             name: '成交',
    //             data: cpuData
    //         }]
    //     });
    //
    //     memoryChart.setOption({
    //         xAxis: {
    //             data: timeData
    //         },
    //         series: [{
    //             name: '成交',
    //             data: memoryData
    //         }]
    //     });
    // }, 500);

    if (cpuOption && typeof cpuOption === "object") {
        cpuChart.setOption(cpuOption, true);

    }
    if (memoryOption && typeof memoryOption === "object") {
        memoryChart.setOption(memoryOption, true);
    }
</script>

<script>

    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();

    var t = null;
    t = setTimeout(time, 1000);//開始运行
    function time() {
        clearTimeout(t);//清除定时器
        dt = new Date();
        let s1 = dt.toLocaleString();
        document.getElementById("showTime").innerHTML = s1;
        t = setTimeout(time, 1000); //设定定时器，循环运行
    }
</script>
</body>
</html>