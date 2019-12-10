import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

public class FreemakerDemo {

    public static void main(String[] args) throws Exception{
        //1.创建配置类
        Configuration configuration=new Configuration(Configuration.getVersion());
        //2.设置模板所在的目录
        configuration.setDirectoryForTemplateLoading(new File("E:\\IDEA\\Four\\freemakerDemo\\src\\main\\resources\\"));
        //3.设置字符集
        configuration.setDefaultEncoding("utf-8");
        //4.加载模板
        Template template = configuration.getTemplate("test.ftl");
        //5.创建数据模型
        Map map=new HashMap();
        map.put("name", "张三 ");
        map.put("message", "欢迎来到神奇的优乐选世界！");
        map.put("success",true);

        List goodsList=new ArrayList();
        Map goods1=new HashMap();
        goods1.put("name", "苹果");
        goods1.put("price", 5.8);
        Map goods2=new HashMap();
        goods2.put("name", "香蕉");
        goods2.put("price", 2.5);
        Map goods3=new HashMap();
        goods3.put("name", "橘子");
        goods3.put("price", 3.2);
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        map.put("goodsList", goodsList);
        map.put("today",new Date());
        map.put("point",101010023);
        //6 创建writer对象
        FileWriter out = new FileWriter(new File("D:\\youlexuanjingtai\\test.html\\"));
        //输出
        template.process(map,out);
        //关闭流
        out.close();
    }


}
