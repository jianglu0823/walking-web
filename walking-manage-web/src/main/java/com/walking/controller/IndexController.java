package com.walking.controller;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.icepdf.core.pobjects.Document;
import org.icepdf.core.util.GraphicsRenderingHints;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.remoting.exchange.Response;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView getUserById(){
		System.out.println("-------------------------进入了Index");
		ModelAndView mv = new ModelAndView("/index");
		return mv;
	}
	
	@RequestMapping("/test")
	public ModelAndView test(){
		ModelAndView mv = new ModelAndView("/test/test");
		return mv;
	}
	
	@RequestMapping("/pdfToImg")
	public HttpServletResponse pdfToImg(HttpServletRequest request,HttpServletResponse response,MultipartFile pdfFile ){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss"); 
        String name=sdf.format(new Date());
        //String projectPath = request.getSession().getServletContext().getContextPath();
        String projectRealPath = request.getSession().getServletContext().getRealPath("");
        //System.out.println("contextPath="+projectPath+"realPath="+projectRealPath);

		String path = projectRealPath+"/date/"+name+"/";
		
		InputStream fis = null;
	    OutputStream toClient = null;
	    try {
	    	String originalFilename = pdfFile.getOriginalFilename();
	    	String filename = pdfFile.getName();
	        // path是指欲下载的文件的路径。
	        File file = new File(path);
	        if(!file.isDirectory()){
	        	file.mkdir();
	        }
	        
	       Document document = new Document();
	      document.setInputStream(pdfFile.getInputStream(), null);;
	      float scale = 2.5f;//缩放比例
	      float rotation = 0f;//旋转角度
	      System.out.println("pdf共"+document.getNumberOfPages()+"页");
	      for (int i = 0; i < document.getNumberOfPages(); i++) {
	    	  BufferedImage image = (BufferedImage)
	    	  document.getPageImage(i, GraphicsRenderingHints.SCREEN, org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, rotation, scale);
	    	  RenderedImage rendImage = image;
	      
	    	  File pdfImg = new File(path +"/"+ filename+i + ".png");
	    	  ImageIO.write(rendImage, "png", pdfImg); 
	    	  System.out.println("转换图片第"+i+1+"页");
	    	  image.flush();
	      }
	      document.dispose();
	      //----------压缩文件夹-------------------
	      File[] filesLIst = file.listFiles();
	      String tmpFileName = filename+".zip";
          byte[] buffer = new byte[1024];
          String strZipPath = path + tmpFileName;
          ZipOutputStream out = new ZipOutputStream(new FileOutputStream(strZipPath));
          //同时需要下载文件
          for (File file1 : filesLIst){
              FileInputStream fileInputStream = new FileInputStream(file1);
              out.putNextEntry(new ZipEntry(file1.getName()));
              //设置压缩文件内的字符编码，不然会变成乱码
              System.out.println("压缩文件开始------"+file1.getName());
              int len;
              // 读入需要下载的文件的内容，打包到zip文件
              while ((len = fileInputStream.read(buffer)) > 0) {
                  out.write(buffer, 0, len);
              }
              out.closeEntry();
              fileInputStream.close();
          }
          out.close();
	      //pdfFile.transferTo(file);
	      System.out.println(file.getAbsolutePath()+"-----------------");
	        // 取得文件名。
	        // 取得文件的后缀名。
	        //String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
	        // 以流的形式下载文件。
	        fis = new BufferedInputStream(new FileInputStream(new File(strZipPath)));
	        byte[] buffer1 = new byte[fis.available()];
	        fis.read(buffer1);
	        response.reset();
	        // 设置response的Header
	        response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
	        response.addHeader("Content-Length", "" + file.length());
	        toClient = new BufferedOutputStream(response.getOutputStream());
	        response.setContentType("application/octet-stream");
	        toClient.write(buffer1);
	        toClient.flush();
	       // deleteDir(new File(path));
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }finally{
	        try {
	            if(fis!=null)
	            fis.close();
	            if(toClient!=null)
	            toClient.close();
	        }catch (Exception e){
	            e.printStackTrace();
	        } 
	    }
	    return response;
	}
	
	/****
     * 递归删除目录下的所有文件及子目录下所有文件
     * @author 作者：jianglu
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
	
}
