package com.scaffolding.demo.service.impl;

import com.google.common.base.CaseFormat;
import com.scaffolding.demo.dto.GenerateCodeDto;
import com.scaffolding.demo.entity.ColumnClass;
import com.scaffolding.demo.entity.TableClass;
import com.scaffolding.demo.result.RestResult;
import com.scaffolding.demo.service.GenerateCodeService;
import com.scaffolding.demo.utils.JDBCUtils;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/24 14:27
 */
@Service
public class GenerateCodeServiceImpl implements GenerateCodeService {

    Configuration cfg = null;

    {
        cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setTemplateLoader(new ClassTemplateLoader(GenerateCodeServiceImpl.class, "/templates/system/genetate/mode"));
        cfg.setDefaultEncoding("UTF-8");
    }

    @Override
    public RestResult generateCode(GenerateCodeDto generateCodeDto, String realPath) {
        try {
            Template modelTemplate = cfg.getTemplate("Model.java.ftl");
            Template mapperJavaTemplate = cfg.getTemplate("Mapper.java.ftl");
            Template mapperXmlTemplate = cfg.getTemplate("Mapper.xml.ftl");
            Template serviceTemplate = cfg.getTemplate("Service.java.ftl");
            Template serviceImplTemplate = cfg.getTemplate("ServiceImpl.java.ftl");
            Template controllerTemplate = cfg.getTemplate("Controller.java.ftl");
            Connection connection = JDBCUtils.init(generateCodeDto.getDb());
            DatabaseMetaData metaData = connection.getMetaData();
            for (TableClass tableClass : generateCodeDto.getTableClassList()) {
                ResultSet columns = metaData.getColumns(connection.getCatalog(), null, tableClass.getTableName(), null);
                ResultSet primaryKeys = metaData.getPrimaryKeys(connection.getCatalog(), null, tableClass.getTableName());
                List<ColumnClass> columnClassList = new ArrayList<>();
                while (columns.next()) {
                    String column_name = columns.getString("COLUMN_NAME");
                    String type_name = columns.getString("TYPE_NAME");
                    String remarks = columns.getString("REMARKS");
                    ColumnClass columnClass = new ColumnClass();
                    columnClass.setRemark(remarks);
                    columnClass.setColumnName(column_name);
                    columnClass.setType(type_name);
                    columnClass.setPropertyName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, column_name));
                    primaryKeys.first();
                    while (primaryKeys.next()) {
                        String pkName = primaryKeys.getString("COLUMN_NAME");
                        if (column_name.equals(pkName)) {
                            columnClass.setIsPrimary(true);
                        }
                    }
                    columnClassList.add(columnClass);
                }
                tableClass.setColumns(columnClassList);
                tableClass.setPackageName(generateCodeDto.getDb().getPackageName());
                String path = realPath + "/" + tableClass.getPackageName().replace(".", "/");
                generate(modelTemplate, tableClass, path + "/model/");
                generate(mapperJavaTemplate, tableClass, path + "/mapper/");
                generate(mapperXmlTemplate, tableClass, path + "/mapper/");
                generate(serviceTemplate, tableClass, path + "/service/");
                generate(serviceImplTemplate, tableClass, path + "/service/impl/");
                generate(controllerTemplate, tableClass, path + "/controller/");
            }
            return RestResult.suc("代码已生成");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RestResult.failMes("代码生成错误");

    }

    private void generate(Template template, TableClass tableClass, String path) throws IOException, TemplateException {
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String fileName = path + "/" + tableClass.getModelName() + template.getName().replace(".ftl", "").replace("Model", "");
        FileOutputStream fos = new FileOutputStream(fileName);
        OutputStreamWriter out = new OutputStreamWriter(fos);
        template.process(tableClass, out);
        fos.close();
        out.close();
    }
}
