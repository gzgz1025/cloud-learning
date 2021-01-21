package com.cloud.learning.utils;


import cn.hutool.core.lang.Dict;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.cloud.learning.exception.AssertsException;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: FreemarkerUtil
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/21 9:26
 * @Version: 1.0
 */
public class FreemarkerUtil {
    public static String rendereString(String templateString, Map<String, ?> model) {
        try {
            StringWriter result = new StringWriter();
            Template t = new Template("name", new StringReader(templateString), new Configuration());
            t.process(model, result);
            return result.toString();
        } catch (Exception e) {
            AssertsException.throwIt("短信模板解析异常");
        }

        return null;
    }

    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("s","123");
        String str="你好！${s}";
        System.out.println(rendereString(str,map));
        //https://www.hutool.cn/docs/#/extra/模板引擎/模板引擎封装-TemplateUtil
        //hutool工具模板替换实现
        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig());

        //假设我们引入的是Beetl引擎，则：
        cn.hutool.extra.template.Template template = engine.getTemplate("Hello ${name}");
        //Dict本质上为Map，此处可用Map
        String result = template.render(Dict.create().set("name", "Hutool"));

        System.out.println(result);
    }
}

