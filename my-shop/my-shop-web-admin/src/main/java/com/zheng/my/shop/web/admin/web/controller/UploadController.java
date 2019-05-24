package com.zheng.my.shop.web.admin.web.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传控制器
 */

@Controller
public class UploadController {

    private final String UPLOAD_DIR = "/static/upload";

    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dropzFile, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        // 文件存在路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_DIR);

        // 获取文件后缀名
        // 文件名
        String fileName = dropzFile.getOriginalFilename();
        String fileSufix = fileName.substring(fileName.lastIndexOf("."));


        // 查看文件夹是否存在，不存在及创建
        File uploadDir = new File(filePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // 将文件写入目录
        File file = new File(filePath, UPLOAD_DIR + UUID.randomUUID() + fileSufix);
        System.out.println(file.getAbsolutePath());
        try {
            dropzFile.transferTo(file);
        } catch (IOException e) {
            // 失败删除文件
            file.delete();
            e.printStackTrace();
        }
        result.put("fileName", file.getName());
        return result;
    }
}
