package com.example.oral.util;
/**
 * @author: WuHao
 * @date: 2024/4/3 13:23
 * @description:
 */

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.example.oral.common.BaseService;

import java.util.Collections;

/**
 *
 * @author WuHao
 * @date 2024/04/03 13:23
 **/
public class CodeGenerator {

    public static void main(String[] args) {
        //1、配置数据源
        FastAutoGenerator.create("jdbc:mysql://119.23.252.133:3306/oral_sys", "power", "tower.1893")
                //2、全局配置
                .globalConfig(builder -> {
                    builder.author("WuHao") // 设置作者名
                            .outputDir("D://test")   //设置输出路径：项目的 java 目录下
                            .commentDate("yyyy-MM-dd hh:mm:ss")   //注释日期
                            .dateType(DateType.ONLY_DATE)   //定义生成的实体类中日期的类型 TIME_PACK=LocalDateTime;ONLY_DATE=Date;
                            .fileOverride()   //覆盖之前的文件
                            .enableSwagger();   //开启 swagger 模式
                })

                //3、包配置
                .packageConfig(builder -> {
                    builder.parent("com.example.oral") // 设置父包名
                            .entity("entity")   // 实体类包名
                            .service("service") //Service 包名
                            .serviceImpl("serviceImpl") // ***ServiceImpl 包名
                            .mapper("mapper")   //Mapper 包名
                            .xml("mapper")  //Mapper XML 包名
                            .controller("controller") //Controller 包名
                            .other("utils") //自定义文件包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://test"));    //配置 mapper.xml 路径信息：项目的 resources 目录下
                })
                //4、策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("patient", "patient_cleft_relation", "treatment", "evaluation", "consultation") // 设置需要生成的数据表名
                            // .addTablePrefix("t_", "c_") // 设置过滤表前缀

                    //4.1、Mapper策略配置
                    .mapperBuilder()
                    .superClass(BaseMapper.class)   //设置父类
                    .formatMapperFileName("%sMapper")   //格式化 mapper 文件名称
                    .enableMapperAnnotation()       //开启 @Mapper 注解
                    .formatXmlFileName("%sXml") //格式化 Xml 文件名称

                    // 4.2、Service配置策略
                    .serviceBuilder()
                    .formatServiceFileName("%sService")
                    .formatServiceImplFileName("%sServiceImpl")
                    .superServiceClass(BaseService.class)

                    // 4.3、Entity配置策略
                    .entityBuilder()
                    .enableLombok() //开启 Lombok
                    .disableSerialVersionUID() //关闭 serialVersionUID
                    .enableTableFieldAnnotation() //开启字段注解
                    .naming(NamingStrategy.underline_to_camel) //下划线转驼峰
                    .columnNaming(NamingStrategy.underline_to_camel) //下划线转驼峰
//                    .addTableFills(
//                            new Column("create_time", FieldFill.INSERT),
//                            new Column("modify_time", FieldFill.INSERT_UPDATE)
//                    ) //添加表字段填充，"create_time"字段自动填充为插入时间，"modify_time"字段自动填充为插入修改时间

                    // 4.4、Controller配置策略
                    .controllerBuilder()
                    .formatFileName("%sController") //格式化 Controller 文件名称
                    .enableRestStyle(); //开启 @RestController 注解
                })
                //5、模板
                .templateEngine(new VelocityTemplateEngine())
                //6、执行
                .execute();
    }

}
