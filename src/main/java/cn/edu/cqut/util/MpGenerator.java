package cn.edu.cqut.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Properties;

/**
 * <p>
 * 代码生成器演示
 * </p>
 */
public class MpGenerator {
 
    public static void main(String[] args) throws Exception {
//        assert (false) : "代码生成属于危险操作，请确定配置后取消断言执行代码生成！";
        AutoGenerator mpg = new AutoGenerator();

        Properties properties = ConfigUtil.getProperties();
        if (properties == null) {
            throw new Exception("Please add a file named config.properties to src/main/resources");
        }
        String projectDir = properties.getProperty(ConfigUtil.PROJECT_DIR);
        if (projectDir == null || projectDir.isEmpty()) {
            throw new Exception("Configure your project directory in config.properties");
        }
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("CQUT SE 2020");
        gc.setOutputDir(projectDir + "/src/main/java"); //对应项目的src/main/java目录在磁盘上的真实路径
        gc.setFileOverride(false);// 是否覆盖同名文件，默认是false
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        mpg.setGlobalConfig(gc);

        Properties appProperties = ConfigUtil.getProperties("application.properties");
        if (appProperties == null) return;
        String userName = appProperties.getProperty("spring.datasource.username");
        if (userName == null || userName.isEmpty()) return;
        String pwd = appProperties.getProperty("spring.datasource.password");
        if (pwd == null) return;
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(userName);
        dsc.setPassword(pwd);
        dsc.setUrl("jdbc:mysql://localhost:3306/cqutcrm?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        mpg.setDataSource(dsc);
 
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
<<<<<<< HEAD
        strategy.setInclude("contact"); // 需要生成的表
=======
        strategy.setInclude("sales"); // 需要生成的表
>>>>>>> branch 'master' of https://github.com/cliuff/crmservice.git
        mpg.setStrategy(strategy);
 
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("cn.edu.cqut"); //项目的根包（启动类所在的包）
        pc.setController("controller"); //Controller类所在的包
        pc.setService("service"); //Service接口所在的包
        pc.setServiceImpl("service.impl"); //Service实现类所在的包
        pc.setMapper("mapper"); //Mapper接口所在的包
        pc.setEntity("entity"); //实体类所在的包
        pc.setXml("mapper.xml"); //mapper映射文件所在的包
        mpg.setPackageInfo(pc);
 
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null); //不生成xml映射文件
        mpg.setTemplate(tc);
 
        // 执行生成
        mpg.execute();
 
    }
}
