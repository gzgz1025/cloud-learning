package com.cloud.learning.jwt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @ClassName: JwtUtils
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/12 11:49
 * @Version: 1.0
 */
public class JwtUtils {
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO"; //秘钥
    //生成token字符串的方法
    public static String getJwtToken(String id, String nickname) {
        //将BASE64SECRET常量字符串使用base64解码成字节数组
        //byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SecretConstant.APP_SECRET);
        //使用HmacSHA256签名算法生成一个HS256的签名秘钥Key
        //Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());

        String JwtToken = Jwts.builder()
                // JWT的头信息
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")

                // 设置过期时间
                .setSubject("onlineCourse-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + SecretConstant.EXPIRE))

                // 数据库中的字段
                .claim("id", AESSecretUtil.encryptToStr(id, SecretConstant.DATAKEY))  //设置token主体部分 ，存储用户信息
                //客户名称
                .claim("username", nickname)

                // 签名哈希
                // 签名算法SignatureAlgorithm.HS256
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();

        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(SecretConstant.APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if (StringUtils.isEmpty(jwtToken)) {
                return false;
            }
            Jwts.parser().setSigningKey(SecretConstant.APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token字符串获取会员id
     *
     * @param request
     * @return
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        if (StringUtils.isEmpty(jwtToken)) {
            return "";
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SecretConstant.APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String) claims.get("id");
    }
}
