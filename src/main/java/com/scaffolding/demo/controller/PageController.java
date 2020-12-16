package com.scaffolding.demo.controller;

import org.apache.tomcat.util.security.Escape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 16:27
 */
@Controller
public class PageController {

    @Autowired

    private MessageSource messageSource;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println(messageSource.getMessage("username", null, Locale.ENGLISH));
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
        try {
            InetAddress address = InetAddress.getLocalHost();
            modelAndView.addObject("hostName", address.getHostName());
            modelAndView.addObject("hostAddress", address.getHostAddress());
        } catch (UnknownHostException e) {
            modelAndView.addObject("hostName", "-");
            modelAndView.addObject("hostAddress", "-");
        }
        modelAndView.setViewName("/welcome");
        return modelAndView;
    }

    public static void main(String[] args) {
        System.out.println("args = " + formatSize(
                Long.valueOf(Runtime.getRuntime().freeMemory()), true));
    }

    public static void writeVMState(PrintWriter writer, int mode, Object[] args)
            throws Exception {

        SortedMap<String, MemoryPoolMXBean> memoryPoolMBeans = new TreeMap<>();
        for (MemoryPoolMXBean mbean: ManagementFactory.getMemoryPoolMXBeans()) {
            String sortKey = mbean.getType() + ":" + mbean.getName();
            memoryPoolMBeans.put(sortKey, mbean);
        }

        if (mode == 0){
            writer.print("<h1>JVM</h1>");

            writer.print("<p>");
            writer.print( args[0] );
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
        } else if (mode == 1){
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
     * @param mb true to display megabytes, false for kilobytes
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

    @RequestMapping("/index")
    public String index() {

        return "/index";
    }

    @RequestMapping("/member-list")
    public String member_list() {

        return "/member-list";
    }




//    @RequestMapping("/error")
//    public String error() {
//
//        return "/error";
//    }



}

