package com.autuan.blog.util;

import org.apache.commons.codec.binary.Hex;
import tk.mybatis.mapper.util.StringUtil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class LoginUtil {
    // -------------------------
    private static final String usernameRule = "[a-zA-Z]\\w{5,}";
    private static final String passwordRule = "\\w{2,}";
    // -------------------------
    public static Map<String,String> checkUsernameFormal(String username,String password) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("result","fail");
        map.put("describe","NULL");
        // 非空验证
        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            map.put("describe","The username or password is null");
        }
        // 合法性检查
        if ( !Pattern.matches(usernameRule,username)) {
            map.put("describe","The username is illegal");
        }

        if ( !Pattern.matches(passwordRule,password) ) {
            map.put("describe","The password is illegal");
        }

        // 通过检查
        if ( map.get("describe").equals("NULL")) {
            map.put("describe","success");
        }
        return map;
    }

    public static String getSHA256Str(String str){
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }
}
