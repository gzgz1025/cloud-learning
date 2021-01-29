package com.cloud.learning;

import cn.hutool.json.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.util.Json;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UrlTest
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/29 17:07
 * @Version: 1.0
 */
public class UrlTest {
    public static void main(String[] args) {
        String encode = URLEncoder.encode("[{'s':'你好'}]");
        System.out.println(encode);
        String str="%7b%22orderId%22%3a%226002000015202101010057142346%22%2c%22buyerEmail%22%3a%22fn3lzphk9jsrq9v%2bA0152310OPRWY1FWR876%40marketplace%2eamazon%2efr%22%2c%22subject%22%3a%22Re%3a%20commande%20N%b0403%2d3793854%2d7709901%22%2c%22formatTime%22%3a%2201%2f27%22%2c%22saleAccountId%22%3a%226002000015202005270000046749%22%2c%22buyerAccountId%22%3a%22autoshopping%40163%2ecom%22%2c%22transportTime%22%3a%7b%22date%22%3a27%2c%22day%22%3a3%2c%22hours%22%3a17%2c%22minutes%22%3a51%2c%22month%22%3a0%2c%22seconds%22%3a33%2c%22time%22%3a1611741093000%2c%22timezoneOffset%22%3a%2d480%2c%22year%22%3a121%7d%2c%22solrId%22%3a%221ef4251ea11c159a509d3e5a9cef4f3e%22%2c%22emailConfigId%22%3a%226002000015202008110000065482%22%2c%22transportParentId%22%3anull%2c%22disposeMethod%22%3a1%2c%22email%22%3a%22autoshopping%40163%2ecom%22%2c%22webstoreOrderId%22%3a%22403%2d3793854%2d7709901%22%7d";
        //解码
        try {
            String result= URLDecoder.decode(str,"iso-8859-1");
            System.out.println(result);
            byte[] buf_iso88591 = result.getBytes("iso-8859-1");
            String sGbk = new String(buf_iso88591, "utf-8");
            System.out.println(sGbk);
//            System.out.println(sGbk);
//            JSONObject jsonObject = JSON.parseObject(result);
//            System.out.println(jsonObject);
            //JSONObject jsonObject = JSON.parseObject(sGbk);
            //JSONArray array=JSONArray.fromObject(stu);
            String s = JSONArray.toJSONString(sGbk);
            System.out.println(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
