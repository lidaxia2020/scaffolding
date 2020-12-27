package com.scaffolding.demo.controller;

import com.google.common.base.CaseFormat;
import com.scaffolding.demo.dto.ConfigDto;
import com.scaffolding.demo.dto.Db;
import com.scaffolding.demo.dto.GenerateCodeDto;
import com.scaffolding.demo.entity.TableClass;
import com.scaffolding.demo.result.RestResult;
import com.scaffolding.demo.service.GenerateCodeService;
import com.scaffolding.demo.utils.JDBCUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/24 14:18
 */
@Controller
@RequestMapping("/generateCode")
public class GenerateCodeController {
    @Autowired
    GenerateCodeService generateCodeService;
    private String packageName;


    @PostMapping("/connect")
    @ResponseBody
    public RestResult connect(@RequestBody Db db) {
        Connection con = JDBCUtils.init(db);
        if (con != null) {
            return RestResult.sucMes("数据库连接成功");
        }
        return RestResult.failMes("数据库连接失败");
    }


    @GetMapping("/config")
    @ResponseBody
    public RestResult configGet(@RequestParam String url,
                                @RequestParam String username,
                                @RequestParam String pwd,
                                @RequestParam String packageName) {

        ConfigDto configDto = new ConfigDto();
        configDto.setPwd(pwd);
        configDto.setUrl(url);
        configDto.setUsername(username);
        configDto.setPackageName(packageName);

        return config(configDto);
    }

    @PostMapping("/config")
    @ResponseBody
    public RestResult config(@RequestBody ConfigDto configDto) {

        String packageName = configDto.getPackageName();
        try {
            Connection connection = JDBCUtils.init(new Db(configDto.getDriver(), configDto.getUrl(), configDto.getUsername(), configDto.getPwd()));
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables(connection.getCatalog(), null, null, null);
            List<TableClass> tableClassList = new ArrayList<>();
            while (tables.next()) {
                TableClass tableClass = new TableClass();
                tableClass.setPackageName(packageName);
                String table_name = tables.getString("TABLE_NAME");
                String modelName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table_name);
                tableClass.setTableName(table_name);
                tableClass.setModelName(modelName);
                tableClass.setControllerName(modelName + "Controller");
                tableClass.setMapperName(modelName + "Mapper");
                tableClass.setServiceName(modelName + "Service");
                tableClassList.add(tableClass);
            }

            return RestResult.suc(tableClassList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @PostMapping("/generateCode")
    public void generateCode(@RequestBody GenerateCodeDto generateCodeDto, HttpServletRequest req) {
        generateCodeService.generateCode(generateCodeDto, req.getServletContext().getRealPath("/"));
    }
}