package com.autuan.blog.controller;

import com.autuan.blog.util.FtpUtil;
import com.autuan.blog.util.IDUtils;
import com.autuan.blog.util.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/upload")
@Controller
public class FTPController {
    // ========================= 常量 =========================
    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    // ========================= 业务处理 =========================
    @RequestMapping("/file")
    public String fileUpload(MultipartFile uploadFile) {
        Map resultMap = new HashMap<>(16);
        try {
            // 生成一个新的文件名
            // 取原始文件名
            String oldName = uploadFile.getOriginalFilename();
            // 生成新文件名
            // UUID.randomUUID()
            String newName = IDUtils.genImageName();
            newName = newName + oldName.substring(oldName.lastIndexOf("."));
            // 图片上传
            String imagePath = new DateTime().toString("/yyyy/MM/dd");
            boolean result = FtpUtil.uploadFile(FTP_ADDRESS,FTP_PORT,FTP_USERNAME,
                    FTP_PASSWORD,FTP_BASE_PATH,imagePath,newName,uploadFile.getInputStream());
            // 返回结果
            if (!result) {
                resultMap.put("error",1);
                resultMap.put("message","File Upload Fail");
            } else {
                resultMap.put("error",0);
                resultMap.put( "url",IMAGE_BASE_URL + imagePath + "/" + newName );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //为了保证功能的兼容性，需要把Result转换成json格式的字符串。
        String json = JsonUtils.objectToJson(resultMap);
        return json;

    }
}
