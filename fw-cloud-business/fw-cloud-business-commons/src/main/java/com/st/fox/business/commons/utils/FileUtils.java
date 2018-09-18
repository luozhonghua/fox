package com.st.fox.business.commons.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;


/**
 * Created by luozhonghua on 2018/9/12.
 */
public class FileUtils extends org.apache.commons.io.FileUtils {

    public static void downloadFile(String fileName, String tmpFileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(StringUtils.isEmpty(fileName) && StringUtils.isEmpty(tmpFileName)){
            return;
        }
        File file = new File(tmpFileName);
        if(!file.exists()) {
            return;
        }
        String postfix = tmpFileName.substring(tmpFileName.lastIndexOf("."));
        response.reset();
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(fileName, "utf-8") + postfix+"\"");
        } else {
            fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1"); // 下载的文件名显示编码处理
            response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + postfix+"\"");
        }
        response.setContentType("application/x-msdownload;charset=UTF-8");
        FileInputStream fis = new FileInputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

        byte[] buffer = new byte[2048];
        int readlength = 0;
        while((readlength = fis.read(buffer)) != -1){
            bos.write(buffer,0,readlength);
        }
        try {
            fis.close();
        } catch (IOException e) {
        }
        try {
            bos.flush();
            bos.close();
        } catch (IOException e) {
        }
    }

}
