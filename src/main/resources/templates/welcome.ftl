<#include "./common/_top.ftl">

<body>
<div class="x-body">
    <blockquote class="layui-elem-quote">欢迎管理员：
        <span class="x-red">test</span>！
        <span class="x-right" style="line-height:40px">当前时间: <label id="showTime"></label></span>
    </blockquote>
    <#--        <fieldset class="layui-elem-field">-->
    <#--            <legend>数据统计</legend>-->
    <#--            <div class="layui-field-box">-->
    <#--                <div class="layui-col-md12">-->
    <#--                    <div class="layui-card">-->
    <#--                        <div class="layui-card-body">-->
    <#--                            <div class="layui-carousel x-admin-carousel x-admin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 90px;">-->
    <#--                                <div carousel-item="">-->
    <#--                                    <ul class="layui-row layui-col-space10 layui-this">-->
    <#--                                        <li class="layui-col-xs2">-->
    <#--                                            <a href="javascript:;" class="x-admin-backlog-body">-->
    <#--                                                <h3>文章数</h3>-->
    <#--                                                <p>-->
    <#--                                                    <cite>66</cite></p>-->
    <#--                                            </a>-->
    <#--                                        </li>-->
    <#--                                        <li class="layui-col-xs2">-->
    <#--                                            <a href="javascript:;" class="x-admin-backlog-body">-->
    <#--                                                <h3>会员数</h3>-->
    <#--                                                <p>-->
    <#--                                                    <cite>12</cite></p>-->
    <#--                                            </a>-->
    <#--                                        </li>-->
    <#--                                        <li class="layui-col-xs2">-->
    <#--                                            <a href="javascript:;" class="x-admin-backlog-body">-->
    <#--                                                <h3>回复数</h3>-->
    <#--                                                <p>-->
    <#--                                                    <cite>99</cite></p>-->
    <#--                                            </a>-->
    <#--                                        </li>-->
    <#--                                        <li class="layui-col-xs2">-->
    <#--                                            <a href="javascript:;" class="x-admin-backlog-body">-->
    <#--                                                <h3>商品数</h3>-->
    <#--                                                <p>-->
    <#--                                                    <cite>67</cite></p>-->
    <#--                                            </a>-->
    <#--                                        </li>-->
    <#--                                        <li class="layui-col-xs2">-->
    <#--                                            <a href="javascript:;" class="x-admin-backlog-body">-->
    <#--                                                <h3>文章数</h3>-->
    <#--                                                <p>-->
    <#--                                                    <cite>67</cite></p>-->
    <#--                                            </a>-->
    <#--                                        </li>-->
    <#--                                        <li class="layui-col-xs2">-->
    <#--                                            <a href="javascript:;" class="x-admin-backlog-body">-->
    <#--                                                <h3>文章数</h3>-->
    <#--                                                <p>-->
    <#--                                                    <cite>6766</cite></p>-->
    <#--                                            </a>-->
    <#--                                        </li>-->
    <#--                                    </ul>-->
    <#--                                </div>-->
    <#--                            </div>-->
    <#--                        </div>-->
    <#--                    </div>-->
    <#--                </div>-->
    <#--            </div>-->
    <#--        </fieldset>-->
    <#--        <fieldset class="layui-elem-field">-->
    <#--            <legend>系统通知</legend>-->
    <#--            <div class="layui-field-box">-->
    <#--                <table class="layui-table" lay-skin="line">-->
    <#--                    <tbody>-->
    <#--                        <tr>-->
    <#--                            <td >-->
    <#--                                <a class="x-a" href="/" target="_blank">新版x-admin 2.0上线了</a>-->
    <#--                            </td>-->
    <#--                        </tr>-->
    <#--                        <tr>-->
    <#--                            <td >-->
    <#--                                <a class="x-a" href="/" target="_blank">交流qq群:(519492808)</a>-->
    <#--                            </td>-->
    <#--                        </tr>-->
    <#--                    </tbody>-->
    <#--                </table>-->
    <#--            </div>-->
    <#--        </fieldset>-->
    <fieldset class="layui-elem-field">
        <legend>服务器信息</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>Tomcat.版本</th>
                    <td>1.0.180420</td>
                </tr>
                <tr>
                    <th>JVM.版本</th>
                    <td>${javaRuntimeVersion}</td>
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
                    <th>主机名</th>
                    <td>${hostName}</td>
                </tr>
                <tr>
                    <th>IP地址</th>
                    <td>${hostAddress}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </fieldset>
    <fieldset class="layui-elem-field">
        <legend></legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>Tomcat.版本</th>
                    <td>1.0.180420</td>
                </tr>
                <tr>
                    <th>JVM.版本</th>
                    <td>${javaRuntimeVersion}</td>
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
                    <th>主机名</th>
                    <td>${hostName}</td>
                </tr>
                <tr>
                    <th>IP地址</th>
                    <td>${hostAddress}</td>
                </tr>
                </tbody>
            </table>
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