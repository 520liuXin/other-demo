package com.example.shriodemo.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.shriodemo.bean.Email;
import com.example.shriodemo.bean.Response;
import com.example.shriodemo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
/*
 * @Author liuxin
 * @Description //TODO
 **/





@RestController
@RequestMapping("/email")
public class MailController {

    @Autowired
    private MailService mailService;
    @Autowired
    private TemplateEngine templateEngine;

    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public Response index(@RequestBody Email email){
        try {

            mailService.sendSimpleMail(email);
        }catch (Exception ex){
            ex.printStackTrace();
            return  Response.fail("邮件发送失败!!");
        }
        return  Response.success("发送成功");
    }


    @RequestMapping(value = "/htmlEmail",method = RequestMethod.POST)
    public Response htmlEmail(@RequestBody JSONObject params){
        try {
            mailService.sendHtmlMail("799296010@qq.com","啥","<body style=\"text-align: center;margin-left: auto;margin-right: auto;\">\n"
                    + "	<div id=\"welcome\" style=\"text-align: center;position: absolute;\" >\n"
                    +"		<h3>欢迎使用IJPay -By Javen</h3>\n"
                    +"		<span>https://github.com/Javen205/IJPay</span>"
                    + "		<div\n"
                    + "			style=\"text-align: center; padding: 10px\"><a style=\"text-decoration: none;\" href=\"https://github.com/Javen205/IJPay\" target=\"_bank\" ><strong>IJPay 让支付触手可及,欢迎Start支持项目发展:)</strong></a></div>\n"
                    + "		<div\n" + "			style=\"text-align: center; padding: 4px\">我知道了" +
                    "</div>\n"
                    + "		<img width=\"180px\" height=\"180px\"\n"
                    + "			src=\"https://oscimg.oschina.net/oscnet/8e86fed2ee9571eb133096d5dc1b3cb2fc1.jpg\">\n"
                    + "	</div>\n" + "</body>");
        }catch (Exception ex){
            ex.printStackTrace();
            return  Response.fail("邮件发送失败!!");
        }
        return  Response.success("发送成功");
    }

    @RequestMapping("/attachmentsMail")
    public Response attachmentsMail(){
        try {
            String filePath = "/Users/Javen/Desktop/IJPay.png";
            mailService.sendAttachmentsMail("799296010@qq.com", "这是一封带附件的邮件", "邮件中有附件，请注意查收！", filePath);
        }catch (Exception ex){
            ex.printStackTrace();
            return  Response.fail("邮件发送失败!!");
        }
        return  Response.success("发送成功");
    }

    @RequestMapping("/resourceMail")
    public Response resourceMail(){
        try {
            String rscId = "IJPay";
            String content = "<html><body>这是有图片的邮件<br/><img src=\'cid:" + rscId + "\' ></body></html>";
            String imgPath = "/Users/Javen/Desktop/IJPay.png";
            mailService.sendResourceMail("799296010@qq.com", "这邮件中含有图片", content, imgPath, rscId);

        }catch (Exception ex){
            ex.printStackTrace();
            return  Response.fail("邮件发送失败!!");
        }
        return  Response.success("发送成功");
    }




    @RequestMapping(value = "/templateMail",method = RequestMethod.GET)
    public Response templateMail(){
        try {
            Context context = new Context();
            context.setVariable("project", "IJPay");
            context.setVariable("author", "Javen");
            context.setVariable("url", "https://github.com/Javen205/IJPay");
            String emailContent = templateEngine.process("welcome", context);

            mailService.sendHtmlMail("799296010@qq.com", "邮件", emailContent);
        }catch (Exception ex){
            ex.printStackTrace();
            return  Response.fail("邮件发送失败!!");
        }
        return  Response.success("发送成功");
    }
}
