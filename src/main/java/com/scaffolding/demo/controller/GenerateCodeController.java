package com.scaffolding.demo.controller;

import com.google.common.base.CaseFormat;
import com.scaffolding.demo.dto.ConfigDto;
import com.scaffolding.demo.dto.Db;
import com.scaffolding.demo.dto.GenerateCodeDto;
import com.scaffolding.demo.entity.TableClass;
import com.scaffolding.demo.service.GenerateCodeService;
import com.scaffolding.demo.utils.JDBCUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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


    @PostMapping("/connect")
    public void connect(@RequestBody Db db) {
        Connection con = JDBCUtils.init(db);
        if (con != null) {
//            return RespBean.ok("数据库连接成功");
        }
//        return RespBean.error("数据库连接失败");
    }

    @PostMapping("/config")
    public Object config(@RequestBody ConfigDto configDto) {
        String packageName = configDto.getPackageName();
        try {
            Connection connection = JDBCUtils.init(new Db(configDto.getDriver(), configDto.getUrl(), configDto.getPackageName(), configDto.getPwd()));
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
            return tableClassList;
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