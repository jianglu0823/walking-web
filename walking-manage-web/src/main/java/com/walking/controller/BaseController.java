package com.walking.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.walking.common.util.DateTimeUtils;
import com.walking.common.util.FileUtil;
import com.walking.common.util.MD5;

public class BaseController {

	private String getImgUrl(String fileName) {
        StringBuffer imgUrl = new StringBuffer("/");
        imgUrl.append(DateTimeUtils.toString(new Date(), "yyyyMMdd")).append("/");
        imgUrl.append(MD5.compute(UUID.randomUUID().toString()));
        imgUrl.append(fileName.substring(fileName.lastIndexOf(".")));
        return imgUrl.toString();
    }
    
    public String uploadImg(MultipartFile file,String id) throws IOException {
        /**
         * 还差图片控制
         */
        String imgUrl =  this.getImgUrl(file.getOriginalFilename());
        File distFile = new File("/img/user/"+id, imgUrl);
        if (!distFile.getParentFile().exists()) {
            distFile.getParentFile().mkdirs();
        }
        if (!distFile.exists()) {
            distFile.createNewFile();
        }
        if (file != null && file.getSize() > 0) {
            FileUtil.copyFile(file.getInputStream(), new FileOutputStream(distFile));
        }
        return null;
    }
	
}
