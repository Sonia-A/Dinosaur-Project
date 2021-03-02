package com.dino.dino.service;


import java.io.File;
import java.util.Date;

import javax.mail.internet.MimeMessage;

import com.dino.dino.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dino.dino.model.ShoppingCart;


/**
 * Created by Nick on 4/2/2020.
 */
@Service
public class EmailProvider {
    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail1(ShoppingCart receiver,String title)throws Exception{
        MimeMessage message = mailSender.createMimeMessage();

        // Enable the multipart flag!
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        try {

         //   helper.addInline("myLogo",res.getFile());
            ClassPathResource path = new ClassPathResource("static/images/"+receiver.getCartItem().get(0).getImageName().get(0).getName());
//                helper.addAttachment("logo.png", );
                helper.addInline("myLogo",path);
                helper.setTo(receiver.getCustomerDetails().getFullAddress());
                helper.setText("\n" +
                        "<!DOCTYPE HTML PUBLIC <html>\r\n" + 
                        "<body>\r\n" + 
                        "\r\n" + 
                        "<h2>An unordered HTML list</h2>\r\n" + 
                        "\r\n" + 
                        "<ul>\r\n" + 
                        "  <li>Coffee</li>\r\n" + 
                        "  <li>Tea</li>\r\n" + 
                        "  <li>Milk</li>\r\n" + 
                        "</ul>  \r\n" + 
                        "\r\n" + 
                        "</body>\r\n" + 
                        "</html>", true);
            helper.setSubject(title);
            mailSender.send(message);
        }catch (Exception c){
                System.out.println(c);
        }

        return "email sent";
    }
public String sendEmail(ShoppingCart receiver,String title) throws Exception{
	System.out.println("starting image function sending ");
    MimeMessage message = mailSender.createMimeMessage();

        // Enable the multipart flag!
    MimeMessageHelper helper = new MimeMessageHelper(message,true);
    try {
        //helper.setFrom("ishimwenelson45@gmail.com");
        helper.setTo(receiver.getCustomerDetails().getFullAddress());
            String contentId = receiver.getCartItem().get(0).getImageName().get(0).getName();
//        String htmlText = "Hello,</br> <p>This is test with email inlines.</p><img src=\"cid:" + contentId + "\" />";
//        helper.setText(htmlText, true);
            System.out.println(contentId);
        helper.setTo(receiver.getCustomerDetails().getFullAddress());
           
                helper.setText(
                        "\n"+"<html>\r\n" + 
                        		" <header>\r\n" + 
                        		"</header>\r\n" + 
                        		" <body>\r\n" + 
                        		"  <div style=\"background-color: #ffffff;\">\r\n" + 
                        		"        <div class=\"layout two-col stack\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
                        		"                                <p style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">Hello Dinosaur Team,  \n" +
                                "</p>\n" +
                                "                                <br>\n" +
                                "                                <p style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">\n" +
                                "                                  This is new order "+receiver.getOrderId()+" From  "+receiver.getCustomerDetails().getFullName()+"\n" +
                                "</p>\n" +
                                "<br/>\n" +
                        		"          <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
                        		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-full-width\" style=\"background-color: #ffffff;\"><td class=\"layout__edges\">&nbsp;</td><td style=\"width: 300px\" valign=\"top\" class=\"w260\"><![endif]-->\r\n" + 
                        		"            <div class=\"column\" style=\"text-align: left;color: #f6f6f8;font-size: 16px;line-height: 24px;font-family: Roboto,Tahoma,sans-serif;max-width: 320px;min-width: 300px; width: 320px;width: calc(12300px - 2000%);Float: left;\">\r\n" + 
                        		"            \r\n" + 
                        		"              <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
                        		"        <div style=\"font-size: 12px;font-style: normal;font-weight: normal;line-height: 19px;\" align=\"center\">\r\n" + 
                        		"          <img style=\"border: 0;display: block;height: auto;width: 100%;max-width: 300px;\" alt=\"Tours\" width=\"260\" src=\"cid:" + contentId + "\"/>\r\n" + 
                        		"        </div>\r\n" + 
                        		"      </div>\r\n" + 
                        		"            \r\n" + 
                        		"            </div>\r\n" + 
                        		"          <!--[if (mso)|(IE)]></td><td style=\"width: 300px\" valign=\"top\" class=\"w260\"><![endif]-->\r\n" + 
                        		"            <div class=\"column\" style=\"text-align: left;color: #f6f6f8;font-size: 16px;line-height: 24px;font-family: Roboto,Tahoma,sans-serif;max-width: 320px;min-width: 300px; width: 320px;width: calc(12300px - 2000%);Float: left;\">\r\n" + 
                        		"            \r\n" + 
                        		"              <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
                        		"      <div style=\"mso-line-height-rule: exactly;line-height: 40px;font-size: 1px;\">&nbsp;</div>\r\n" + 
                        		"    </div>\r\n" + 
                        		"            \r\n" + 
                        		"              <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
                        		"      <div style=\"mso-line-height-rule: exactly;mso-text-raise: 11px;vertical-align: middle;\">\r\n" + 
                        		"        <h2 style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #fff;font-size: 18px;line-height: 26px;\"><span style=\"color:#001b71\"><strong>"+new Date()+"</strong></span></h2><p style=\"Margin-top: 16px;Margin-bottom: 20px;\"><span style=\"color:#001b71\">Order ID</span></p>" + 
                        		"        <h2 style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #fff;font-size: 18px;line-height: 26px;\"><span style=\"color:#001b71\"><strong>"+receiver.getOrderId()+"</strong></span></h2><p style=\"Margin-top: 16px;Margin-bottom: 20px;\"><span style=\"color:#001b71\">Product ID</span></p>" +
                        		"        <h2 style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #fff;font-size: 18px;line-height: 26px;\"><span style=\"color:#001b71\"><strong>"+receiver.getCartItem().get(0).getId()+"</strong></span></h2><p style=\"Margin-top: 16px;Margin-bottom: 20px;\"><span style=\"color:#001b71\">Product Name</span></p>" +
                        		"        <h2 style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #fff;font-size: 18px;line-height: 26px;\"><span style=\"color:#001b71\"><strong>"+receiver.getCartItem().get(0).getName()+"</strong></span></h2><p style=\"Margin-top: 16px;Margin-bottom: 20px;\"><span style=\"color:#001b71\">Product Brand</span></p>" +
                        		"        <h2 style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #fff;font-size: 18px;line-height: 26px;\"><span style=\"color:#001b71\"><strong>"+receiver.getCartItem().get(0).getBrand()+"</strong></span></h2><p style=\"Margin-top: 16px;Margin-bottom: 20px;\"><span style=\"color:#001b71\">Customer Full Names</span></p>" +
                        		"        <h2 style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #fff;font-size: 18px;line-height: 26px;\"><span style=\"color:#001b71\"><strong>"+receiver.getCustomerDetails().getFullName()+"</strong></span></h2><p style=\"Margin-top: 16px;Margin-bottom: 20px;\"><span style=\"color:#001b71\">Payment Mode</span></p>" +
                        		"        <h2 style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #fff;font-size: 18px;line-height: 26px;\"><span style=\"color:#001b71\"><strong>"+receiver.getCustomerDetails().getModeOfPayment()+"</strong></span></h2><p style=\"Margin-top: 16px;Margin-bottom: 20px;\"><span style=\"color:#001b71\">Customer Address</span></p>" +
                        		"        <h2 style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #fff;font-size: 18px;line-height: 26px;\"><span style=\"color:#001b71\"><strong>"+receiver.getCustomerDetails().getFullAddress()+"</strong></span></h2><p style=\"Margin-top: 16px;Margin-bottom: 20px;\"><span style=\"color:#001b71\">Comments</span></p>\r\n" +
                         		"        <h2 style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #fff;font-size: 18px;line-height: 26px;\"><span style=\"color:#001b71\"><strong>"+receiver.getTot()+"</strong></span></h2><p style=\"Margin-top: 16px;Margin-bottom: 20px;\"><span style=\"color:#001b71\">Comments</span></p>\r\n" + 
                        		"        <h2 style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #fff;font-size: 18px;line-height: 26px;\"><span style=\"color:#001b71\"><strong>"+receiver.getCustomerDetails().getComments()+"</strong></span></h2><p style=\"Margin-top: 16px;Margin-bottom: 20px;\"><span style=\"color:#001b71\">Thank you for shopping with us. We'll get in touch for further details and delivery</span></p>\r\n" +
                        		"      </div>\r\n" + 
                        		"    </div>\r\n" + 
                        		"            \r\n" + 
                        		"              <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
                        		"      <div class=\"btn btn--flat btn--large\" style=\"Margin-bottom: 20px;text-align: left;\">\r\n" + 
                        		"        <!--[if !mso]--><a style=\"border-radius: 4px;display: inline-block;font-size: 14px;font-weight: bold;line-height: 24px;padding: 12px 24px;text-align: center;text-decoration: none !important;transition: opacity 0.1s ease-in;color: #001b71 !important;background-color: #d5ff05;font-family: Roboto, Tahoma, sans-serif;\" href=\"https://nelcorp.createsend1.com/t/t-l-putkddd-l-y/\" target=\"_blank\">Thank You, Dinosaur Team! &gt;</a><!--[endif]-->\r\n" + 
                        		"      <!--[if mso]><p style=\"line-height:0;margin:0;\">&nbsp;</p><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" href=\"https://nelcorp.createsend1.com/t/t-l-putkddd-l-y/\" style=\"width:121px\" arcsize=\"9%\" fillcolor=\"#D5FF05\" stroke=\"f\"><v:textbox style=\"mso-fit-shape-to-text:t\" inset=\"0px,11px,0px,11px\"><center style=\"font-size:14px;line-height:24px;color:#001B71;font-family:Roboto,Tahoma,sans-serif;font-weight:bold;mso-line-height-rule:exactly;mso-text-raise:4px\">Book now &gt;</center></v:textbox></v:roundrect><![endif]--></div>\r\n" + 
                        		"    </div>\r\n" + 
                        		"            \r\n" + 
                        		"              <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
                        		"      <div style=\"mso-line-height-rule: exactly;line-height: 35px;font-size: 1px;\">&nbsp;</div>\r\n" + 
                        		"    </div>\r\n" + 
                        		"            \r\n" + 
                        		"            </div>\r\n" + 
                        		"          <!--[if (mso)|(IE)]></td><td class=\"layout__edges\">&nbsp;</td></tr></table><![endif]-->\r\n" + 
                        		"          </div>\r\n" + 
                        		"        </div>\r\n" + 
                        		"      </div>\r\n" + 
                        		"</body>\r\n" + 
                        		"</html>"
                        , true);
                ClassPathResource classPathResource = new ClassPathResource("static/images/"+contentId);
                helper.addInline(contentId, classPathResource);   
        helper.setSubject(title);
        System.out.println("meme");
        mailSender.send(message);
        System.out.println("meme2");
        return "email sent";
    }
    catch (Exception e) {
//        Logger.(e.getMessage());
        System.out.println(e.getMessage());
        return e.getMessage();
    }

}

}