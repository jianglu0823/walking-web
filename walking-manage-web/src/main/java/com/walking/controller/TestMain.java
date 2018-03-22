package com.walking.controller;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import java.awt.image.BufferedImage;  
import java.awt.image.RenderedImage;  
import java.io.File;  
import java.io.IOException;  
  
import javax.imageio.ImageIO;  
  
import org.icepdf.core.exceptions.PDFException;  
import org.icepdf.core.exceptions.PDFSecurityException;  
import org.icepdf.core.pobjects.Document;  
import org.icepdf.core.util.GraphicsRenderingHints; 

public class TestMain {

	/*public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		//ZooKeeper zk = new ZooKeeper("39.106.59.36:2181", 30000, new TestWatcher());
		ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 30000, new TestWatcher());
		String node = "/node2";
		Stat stat = zk.exists(node, false);
		if(null==stat){
			//创建节点
			String createResult = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.out.println(createResult);
		}
	}
}class TestWatcher implements Watcher{

	@Override
	public void process(WatchedEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("------------------------------------");
		System.out.println("path:"+arg0.getPath());
		System.out.println("type:"+arg0.getType());
		System.out.println("state:"+arg0.getState());
		System.out.println("------------------------------------");
	}*/
	
	public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
		String srcImgPath = "D:/a.jpg";     
        String iconPath = "D:/sy1.png";     
        String targerPath = "D:/test/aa.jpg";     
       // String targerPath2 = "D:/projects/testWeb/src/zmx/image/test/tmp_mark_icon_rotate.jpg";     
        // 给图片添加水印     
       //markImageByIcon(iconPath, srcImgPath, targerPath);  
        
                                        
        Color color=new Color(205,149,12);       //水印图片色彩以及透明度
        pressText(srcImgPath, new String(" 仅 用 于 合 同 签 订 fff".getBytes(),"utf-8"), "UTF-8", Font.BOLD,0, color,-1, -1, 0.5f);
        
		/*String filePath = "F:/testPdf/mzqd.pdf";  
        Document document = new Document();  
  
        try {  
            document.setFile(filePath);  
            float scale = 	3.0f;// 缩放比例（大图）  
            // float scale = 0.2f;// 缩放比例（小图）  
            float rotation = 0f;// 旋转角度  
            for (int i = 0; i < document.getNumberOfPages(); i++) {  
                BufferedImage image = (BufferedImage) document.getPageImage(i,  
                        GraphicsRenderingHints.SCREEN,  
                        org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX,  
                        rotation, scale);  
                RenderedImage rendImage = image;  
                try {  
                    File file = new File("F:/testPdf/img/icepdf_a" + i + ".jpg");  
                    // 这里png作用是：格式是jpg但有png清晰度  
                    ImageIO.write(rendImage, "png", file);  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
                image.flush();  
            }  
            document.dispose();  
        } catch (PDFException e1) {  
            e1.printStackTrace();  
        } catch (PDFSecurityException e1) {  
            e1.printStackTrace();  
        } catch (IOException e1) {  
            e1.printStackTrace();  
        }  */
        System.out.println("======================完成============================");  
	}
	
	 /**  
     * 添加文字水印  
     * @param targetImg 目标图片路径，如：C://myPictrue//1.jpg  
     * @param pressText 水印文字， 如：中国证券网  
     * @param fontName 字体名称，    如：宋体  
     * @param fontStyle 字体样式，如：粗体和斜体(Font.BOLD|Font.ITALIC)  
     * @param fontSize 字体大小，单位为像素  
     * @param color 字体颜色  
     * @param x 水印文字距离目标图片左侧的偏移量，如果x<0, 则在正中间  
     * @param y 水印文字距离目标图片上侧的偏移量，如果y<0, 则在正中间  
     * @param alpha 透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明)  
     */  
    public static void pressText(String targetImg,String pressText,String fontName,int fontStyle,int fontSize,Color color,int x,int y,float alpha){  
        try {  
            File file = new File(targetImg);  
            Image image = ImageIO.read(file);  
            int width = image.getWidth(null);  
            int height = image.getHeight(null);  
            fontSize=width/100 * 8;
              
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            Graphics2D g = bufferedImage.createGraphics();  
            g.drawImage(image,0,0, width, height, null);  
            g.setFont(new Font(fontName, fontStyle, fontSize)); 
            g.rotate(Math.toRadians(25),(double) width / 2, (double) height / 2);
            g.setColor(color);  
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));  
              
            int width_wi = fontSize*getTextLength(pressText);  
            int height_wi = fontSize;  
              
            int widthDiff = width-width_wi;  
            int heightDiff = height-height_wi;  
            if(x<0){  
                x = widthDiff/2;  
            }else if(x>widthDiff){  
                x=widthDiff;  
            }  
              
            if(y<0){  
                y = heightDiff/2;  
            }else if(y>heightDiff){  
                y = heightDiff;  
            }
            g.drawString(" —————————", x+fontSize*3, y+height_wi+fontSize);
            g.drawString("|"+pressText+" |", x+fontSize*3, y+height_wi);//水印文件  
            g.drawString(" —————————", x+fontSize*3, y+height_wi-fontSize);
            g.dispose();  
            ImageIO.write(bufferedImage, "JPEG", file);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 计算文字像素长度 
     * @param text 
     * @return 
     */  
    private static int getTextLength(String text){  
        int textLength = text.length();  
        int length = textLength;  
        for (int i = 0; i < textLength; i++) {  
            int wordLength = String.valueOf(text.charAt(i)).getBytes().length;  
            if(wordLength > 1){  
                length+=(wordLength-1);  
            }  
        }  
          
        return length%2==0 ? length/2:length/2+1;  
    }  
	
	
	 /**    
     * 给图片添加水印    
     * @param iconPath 水印图片路径    
     * @param srcImgPath 源图片路径    
     * @param targerPath 目标图片路径    
     */    
    public static void markImageByIcon(String iconPath, String srcImgPath,     
            String targerPath) {     
        markImageByIcon(iconPath, srcImgPath, targerPath, null);     
    }     
    
    /**    
     * 给图片添加水印、可设置水印图片旋转角度    
     * @param iconPath 水印图片路径    
     * @param srcImgPath 源图片路径    
     * @param targerPath 目标图片路径    
     * @param degree 水印图片旋转角度    
     */    
    public static void markImageByIcon(String iconPath, String srcImgPath,     
            String targerPath, Integer degree) {     
        OutputStream os = null;     
        try {     
            Image srcImg = ImageIO.read(new File(srcImgPath));     
            File file = new File(srcImgPath);
            
    
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),     
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);     
    
            // 得到画笔对象     
            // Graphics g= buffImg.getGraphics();     
            Graphics2D g = buffImg.createGraphics();     
    
            // 设置对线段的锯齿状边缘处理     
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,     
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);     
    
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg     
                    .getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);     
    
            if (null != degree) {     
                // 设置水印旋转     
                g.rotate(Math.toRadians(degree),     
                        (double) buffImg.getWidth() / 2, (double) buffImg     
                                .getHeight() / 2);     
            }     
    
            // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度     
            ImageIcon imgIcon = new ImageIcon(iconPath);     
    
            // 得到Image对象。     
            Image img = imgIcon.getImage();     
    
            float alpha = 0.2f; // 透明度     
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,     
                    alpha));     
    
            // 表示水印图片的位置     
            g.drawImage(img, 0, 0, null);     
    
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));     
    
            g.dispose();     
    
            
            os = new FileOutputStream(file);     
    
            // 生成图片     
            boolean write = ImageIO.write(buffImg, "JPG", os);     
            
            System.out.println("图片完成添加Icon印章。。。。。。");     
        } catch (Exception e) {     
            e.printStackTrace();     
        } finally {     
            try {     
                if (null != os)     
                    os.close();     
            } catch (Exception e) {     
                e.printStackTrace();     
            }     
        }     
    }     
}    
	
