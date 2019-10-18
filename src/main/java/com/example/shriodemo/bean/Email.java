package com.example.shriodemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * @Author liuxin
 * @Description //TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
   /**
    * 收件人邮箱
    */
   private String[] to;
   /**
    * 邮件抄送
    */
   private String[] bcc;
   /**
    * 邮件标题
    */
   private String subject;
   /**
    *邮件正文
    */

   private String content;
   /**
    *    邮件图片地址
    */

   private String imgPath;
   /**
    * 图片名称
    */

   private String imgId;
   /**
    * 邮件附件地址
    */

   private  String filePath;
}
