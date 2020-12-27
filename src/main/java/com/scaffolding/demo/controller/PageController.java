package com.scaffolding.demo.controller;

import com.scaffolding.demo.entity.SysMenu;
import com.scaffolding.demo.service.SysMenuService;
import com.sun.management.OperatingSystemMXBean;
import org.apache.catalina.util.ServerInfo;
import org.apache.tomcat.util.security.Escape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 16:27
 */
@Controller
public class PageController {

    private static final String PREFIX = "/system";

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        //获取菜单列表
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        authentication.getPrincipal();

        List<SysMenu> menus = sysMenuService.getMenusByRoleIds(Arrays.asList(1));
        //分组
        Map<Long, List<SysMenu>> collect = menus.stream().collect(Collectors.groupingBy(SysMenu::getParentId));
        //树形结构 肯定有一个根部，我的这个根部的就是parentId.euqal("0"),而且只有一个就get（"0"）
        List<SysMenu> sysMenus = collect.get(0L);

        for (SysMenu sysMenu : sysMenus) {
            sysMenu.setChild(collect.get(sysMenu.getId()));
        }

//        SysMenu treeMenuNode = sysMenus.get(0);
//        //拼接数据
//        forEach(collect, treeMenuNode);

        modelAndView.addObject("menus", sysMenus);
        modelAndView.setViewName("/index");

        //获取用户头像
//        Integer id = ShiroKit.getUser().getId();
//        User user = userMapper.selectById(id);
//        String avatar = user.getAvatar();
//        model.addAttribute("avatar", avatar);
//        model.addAttribute("shiro",new ShiroKit());

        return modelAndView;
    }


    @GetMapping(value = "/genetate")
    public ModelAndView genetate() {
        ModelAndView modelAndView = new ModelAndView();

       // modelAndView.setViewName(PREFIX + "system/genetate");
        modelAndView.addObject("list", new ArrayList<>());
        modelAndView.setViewName( "/system/genetate/genetate");

        return modelAndView;
    }

    @GetMapping(value = "/genetateConfig")
    public ModelAndView genetateConfig() {
        ModelAndView modelAndView = new ModelAndView();

        // modelAndView.setViewName(PREFIX + "system/genetate");
        modelAndView.addObject("list", new ArrayList<>());
        modelAndView.setViewName( "/system.genetate/genetate");

        return modelAndView;
    }


    @RequestMapping("/Home/AsycData")
    @ResponseBody
    public Object home() throws InterruptedException {
        Map map = new HashMap();
        // cpu 情况
        SystemInfo systemInfo = new SystemInfo();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        TimeUnit.SECONDS.sleep(1);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()]
                - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()]
                - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()]
                - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()]
                - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()]
                - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()]
                - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()]
                - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()]
                - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;

        map.put("cpuData", new DecimalFormat("#.##").format(user * 1.0 / totalCpu));
        map.put("timeData", new SimpleDateFormat("HH:mm:ss").format(new Date()));
        map.put("memoryData", formatSize(
                Long.valueOf(Runtime.getRuntime().freeMemory()), true).replace("MB", ""));
        return map;
    }


    /**
     * 国际化测试
     *
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println(messageSource.getMessage("username", null, Locale.US));
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("username", null, locale);
    }

    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("javaRuntimeVersion", System.getProperty("java.runtime.version"));
        modelAndView.addObject("javaVmVendor", System.getProperty("java.vm.vendor"));
        modelAndView.addObject("osName", System.getProperty("os.name"));
        modelAndView.addObject("osVersion", System.getProperty("os.version"));
        modelAndView.addObject("osArch", System.getProperty("os.arch"));
        modelAndView.addObject("tomcat", ServerInfo.getServerInfo());

        try {
            InetAddress address = InetAddress.getLocalHost();
            modelAndView.addObject("hostName", address.getHostName());
            modelAndView.addObject("hostAddress", address.getHostAddress());
        } catch (UnknownHostException e) {
            modelAndView.addObject("hostName", "-");
            modelAndView.addObject("hostAddress", "-");
        }


        // cpu 情况
        SystemInfo systemInfo = new SystemInfo();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        // 睡眠1s
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()]
                - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()]
                - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()]
                - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()]
                - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()]
                - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()]
                - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()]
                - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()]
                - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
        modelAndView.addObject("systemsAuditing", processor.getLogicalProcessorCount());


        // 内存情况
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        // 总的物理内存
        String totalMemorySize = new DecimalFormat("#.##")
                .format(osmxb.getTotalPhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
        // 剩余的物理内存
        String freePhysicalMemorySize = new DecimalFormat("#.##")
                .format(osmxb.getFreePhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
        // 已使用的物理内存
        String usedMemory = new DecimalFormat("#.##").format(
                (osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize()) / 1024.0 / 1024 / 1024)
                + "G";

        modelAndView.addObject("totalMemorySize", totalMemorySize);
        modelAndView.addObject("freePhysicalMemorySize", freePhysicalMemorySize);
        modelAndView.addObject("usedMemory", usedMemory);


        modelAndView.setViewName("/welcome");
        return modelAndView;
    }


    public static void writeVMState(PrintWriter writer, int mode, Object[] args)
            throws Exception {

        SortedMap<String, MemoryPoolMXBean> memoryPoolMBeans = new TreeMap<>();
        for (MemoryPoolMXBean mbean : ManagementFactory.getMemoryPoolMXBeans()) {
            String sortKey = mbean.getType() + ":" + mbean.getName();
            memoryPoolMBeans.put(sortKey, mbean);
        }

        if (mode == 0) {
            writer.print("<h1>JVM</h1>");

            writer.print("<p>");
            writer.print(args[0]);
            writer.print(' ');
            writer.print(formatSize(
                    Long.valueOf(Runtime.getRuntime().freeMemory()), true));
            writer.print(' ');
            writer.print(args[1]);
            writer.print(' ');
            writer.print(formatSize(
                    Long.valueOf(Runtime.getRuntime().totalMemory()), true));
            writer.print(' ');
            writer.print(args[2]);
            writer.print(' ');
            writer.print(formatSize(
                    Long.valueOf(Runtime.getRuntime().maxMemory()), true));
            writer.print("</p>");

            writer.write("<table border=\"0\"><thead><tr><th>" + args[3] + "</th><th>" + args[4] + "</th><th>" + args[5] + "</th><th>" + args[6] + "</th><th>" + args[7] + "</th><th>" + args[8] + "</th></tr></thead><tbody>");
            for (MemoryPoolMXBean memoryPoolMBean : memoryPoolMBeans.values()) {
                MemoryUsage usage = memoryPoolMBean.getUsage();
                writer.write("<tr><td>");
                writer.print(memoryPoolMBean.getName());
                writer.write("</td><td>");
                writer.print(memoryPoolMBean.getType());
                writer.write("</td><td>");
                writer.print(formatSize(Long.valueOf(usage.getInit()), true));
                writer.write("</td><td>");
                writer.print(formatSize(Long.valueOf(usage.getCommitted()), true));
                writer.write("</td><td>");
                writer.print(formatSize(Long.valueOf(usage.getMax()), true));
                writer.write("</td><td>");
                writer.print(formatSize(Long.valueOf(usage.getUsed()), true));
                if (usage.getMax() > 0) {
                    writer.write(" ("
                            + (usage.getUsed() * 100 / usage.getMax()) + "%)");
                }
                writer.write("</td></tr>");
            }
            writer.write("</tbody></table>");
        } else if (mode == 1) {
            writer.write("<jvm>");

            writer.write("<memory");
            writer.write(" free='" + Runtime.getRuntime().freeMemory() + "'");
            writer.write(" total='" + Runtime.getRuntime().totalMemory() + "'");
            writer.write(" max='" + Runtime.getRuntime().maxMemory() + "'/>");

            for (MemoryPoolMXBean memoryPoolMBean : memoryPoolMBeans.values()) {
                MemoryUsage usage = memoryPoolMBean.getUsage();
                writer.write("<memorypool");
                writer.write(" name='" + Escape.xml("", memoryPoolMBean.getName()) + "'");
                writer.write(" type='" + memoryPoolMBean.getType() + "'");
                writer.write(" usageInit='" + usage.getInit() + "'");
                writer.write(" usageCommitted='" + usage.getCommitted() + "'");
                writer.write(" usageMax='" + usage.getMax() + "'");
                writer.write(" usageUsed='" + usage.getUsed() + "'/>");
            }

            writer.write("</jvm>");
        }

    }


    /**
     * 显示以字节为单位给定的大小，无论是作为KB或MB。
     * Display the given size in bytes, either as KB or MB.
     *
     * @param obj The object to format
     * @param mb  true to display megabytes, false for kilobytes
     * @return formatted size
     */
    public static String formatSize(Object obj, boolean mb) {

        long bytes = -1L;

        if (obj instanceof Long) {
            bytes = ((Long) obj).longValue();
        } else if (obj instanceof Integer) {
            bytes = ((Integer) obj).intValue();
        }

        if (mb) {
            StringBuilder buff = new StringBuilder();
            if (bytes < 0) {
                buff.append('-');
                bytes = -bytes;
            }
            long mbytes = bytes / (1024 * 1024);
            long rest =
                    ((bytes - (mbytes * (1024 * 1024))) * 100) / (1024 * 1024);
            buff.append(mbytes).append('.');
            if (rest < 10) {
                buff.append('0');
            }
            buff.append(rest).append(" MB");
            return buff.toString();
        } else {
            return ((bytes / 1024) + " KB");
        }

    }

    @RequestMapping("/login")
    public String login() {

        return "/login";
    }

    @RequestMapping("/member-list")
    public String member_list() {

        return "/member-list";
    }

    @RequestMapping("/echarts1")
    public String echarts1() {

        return "/echarts1";
    }

    @RequestMapping("/echarts2")
    public String echarts2() {

        return "/echarts2";
    }

    @RequestMapping("/echarts3")
    public String echarts3() {

        return "/echarts3";
    }

    @RequestMapping("/echarts4")
    public String echarts4() {

        return "/echarts4";
    }

    @RequestMapping("/echarts5")
    public String echarts5() {

        return "/echarts5";
    }

    @RequestMapping("/echarts6")
    public String echarts6() {

        return "/echarts6";
    }

    @RequestMapping("/echarts7")
    public String echarts7() {

        return "/echarts7";
    }

    @RequestMapping("/echarts8")
    public String echarts8() {

        return "/echarts8";
    }

//    @RequestMapping("/error")
//    public String error() {
//
//        return "/error";
//    }


}

