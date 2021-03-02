package com.dino.dino.service;


import com.dino.dino.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


/**
 * Created by Nick on 4/2/2020.
 */
@Service
public class EmailProvider {
    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(ShoppingCart receiver,String title)throws Exception{
        MimeMessage message = mailSender.createMimeMessage();

        // Enable the multipart flag!
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        try {
            helper.setTo(receiver.getCustomerDetails().getFullAddress());
                helper.setText("\n" +
                        "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n" +
                        "<html style=\"-moz-osx-font-smoothing: grayscale; -webkit-font-smoothing: antialiased; background-color: #464646; margin: 0; padding: 0;\">\n" +
                        "    <head>\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                        "        <meta name=\"format-detection\" content=\"telephone=no\">\n" +
                        "        <title>BTPRS Email</title>\n" +
                        "        \n" +
                        "    </head>\n" +
                        "    <body bgcolor=\"#d7d7d7\" class=\"generic-template\" style=\"-moz-osx-font-smoothing: grayscale; -webkit-font-smoothing: antialiased; background-color: #d7d7d7; margin: 0; padding: 0;\">\n" +
                        "        <!-- Header Start -->\n" +
                        "        <div class=\"bg-white header\" bgcolor=\"#ffffff\" style=\"background-color: white; width: 100%;\">\n" +
                        "            <table align=\"center\" bgcolor=\"#ffffff\" style=\"border-left: 10px solid white; border-right: 10px solid white; max-width: 600px; width: 100%;\">\n" +
                        "                <tr height=\"80\">\n" +
                        "                    <td align=\"left\" class=\"vertical-align-middle\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: middle;\">\n" +
                        "                        <a href=\"https://www.go.com.mt/\" target=\"_blank\" style=\"-webkit-text-decoration-color: #F16522; color: #F16522; text-decoration: none; text-decoration-color: #F16522;\">\n" +
                        "                            <span style=\"border: 0; font-size: 32px; margin: 0; max-width: 100%; padding: 0;color: black\">BTPRS</span>\n" +
                        "                        </a>\n" +
                        "                    </td>\n" +
                        "                </tr>\n" +
                        "            </table>\n" +
                        "        </div>\n" +
                        "        <!-- Header End -->\n" +
                        "\n" +
                        "        <!-- Content Start -->\n" +
                        "        <table cellpadding=\"0\" cellspacing=\"0\" cols=\"1\" bgcolor=\"#d7d7d7\" align=\"center\" style=\"max-width: 600px;\">\n" +
                        "            <tr bgcolor=\"#d7d7d7\">\n" +
                        "                <td height=\"50\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td>\n" +
                        "            </tr>\n" +
                        "\n" +
                        "            <!-- This encapsulation is required to ensure correct rendering on Windows 10 Mail app. -->\n" +
                        "            <tr bgcolor=\"#d7d7d7\">\n" +
                        "                <td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                        "                    <!-- Seperator Start -->\n" +
                        "                    <table cellpadding=\"0\" cellspacing=\"0\" cols=\"1\" bgcolor=\"#d7d7d7\" align=\"center\" style=\"max-width: 600px; width: 100%;\">\n" +
                        "                        <tr bgcolor=\"#d7d7d7\">\n" +
                        "                            <td height=\"30\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td>\n" +
                        "                        </tr>\n" +
                        "                    </table>\n" +
                        "                    <!-- Seperator End -->\n" +
                        "\n" +
                        "                    <!-- Generic Pod Left Aligned Start -->\n" +
                        "                    <table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" cols=\"3\" bgcolor=\"white\" class=\"bordered-left-right\" style=\"border-left: 10px solid #d7d7d7; border-right: 10px solid #d7d7d7; max-width: 600px; width: 100%;\">\n" +
                        "                        <tr height=\"50\"><td colspan=\"3\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                        "                        <tr align=\"center\">\n" +
                        "                            <td width=\"36\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td>\n" +
                        "                            <td class=\"text-primary\" style=\"color: #F16522; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                        "                                <h1 style=\"color: #F16522; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 30px; font-weight: 700; line-height: 34px; margin-bottom: 0; margin-top: 0;\">Your BTPRS account need to be activated</h1>\n" +
                        "                            </td>\n" +
                        "                            <td width=\"36\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td>\n" +
                        "                        </tr>\n" +
                        "                        <tr height=\"30\"><td colspan=\"3\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                        "                        <tr align=\"left\">\n" +
                        "                            <td width=\"36\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td>\n" +
                        "                            <td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                        "                                <p style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">Hi,  \n" +
                        "</p>\n" +
                        "                                <br>\n" +
                        "                                <p style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">\n" +
                        "                                  click the link below to activate your acount\n" +
                        "</p>\n" +
                        "<br/>\n" +
                        "                         <div align=\"center\" style=\"padding:14px 20px 14px 20px;background-color:#F16522;border-radius:4px\">\n" +
                        "<a href=\"#\" style=\"font-family:helvetica neue,helvetica,arial,sans-serif;font-weight:bold;font-size:18px;line-height:1.5;color:#ffffff;text-decoration:none;display:block;text-align:center;max-width:400px;overflow:hidden;text-overflow:ellipsis\">\n" +
                        receiver.getCartItem()+" "+receiver.getCustomerDetails()+"\n" +
                        "</a>\n" +
                        "</div>\n" +
                        "<br/><br/>\n" +
                        "          \n" +
                        "                                                              <p style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">\n" +
                        "\n" +
                        "Best regards\n" +
                        "</p><br/>\n" +
                        "                              <p style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">\n" +
                        "BTPRS\n" +
                        "</p>\n" +
                        "                            </td>\n" +
                        "  \n" +
                        "                        </tr>\n" +
                        "\n" +
                        "                        \n" +
                        "       \n" +
                        "                        <tr height=\"50\"><td colspan=\"3\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                        "                    </table>\n" +
                        "                    <!-- Generic Pod Left Aligned End -->\n" +
                        "\n" +
                        "                    <!-- Seperator Start -->\n" +
                        "                    <table cellpadding=\"0\" cellspacing=\"0\" cols=\"1\" bgcolor=\"#d7d7d7\" align=\"center\" style=\"max-width: 600px; width: 100%;\">\n" +
                        "                        <tr bgcolor=\"#d7d7d7\">\n" +
                        "                            <td height=\"50\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td>\n" +
                        "                        </tr>\n" +
                        "                    </table>\n" +
                        "                    <!-- Seperator End -->\n" +
                        "\n" +
                        "                </td>\n" +
                        "            </tr>\n" +
                        "        </table>\n" +
                        "        <!-- Content End -->\n" +
                        "\n" +
                        "        <!-- Footer Start -->\n" +
                        "        <div class=\"bg-gray-dark footer\" bgcolor=\"#464646\" height=\"165\" style=\"background-color: #464646; width: 100%;\">\n" +
                        "            <table align=\"center\" bgcolor=\"#464646\" style=\"max-width: 600px; width: 100%;\">\n" +
                        "                \n" +
                        "                <tr height=\"15\"><td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                        "\n" +
                        "                <tr>\n" +
                        "                    <td align=\"center\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                        "                        <span width=\"50\" style=\"border: 32px; font-size: 26px; margin: 0; max-width: 100%; padding: 0;color: #F16522;\">BTPRS</span>\n" +
                        "                    </td>\n" +
                        "                </tr>\n" +
                        "                \n" +
                        "                <tr height=\"2\"><td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                        "\n" +
                        "                <tr>\n" +
                        "                    <td align=\"center\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                        "                        <p class=\"text-white\" style=\"color: white; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">Copyright nelCorp 2020. All rights reserved.</p>\n" +
                        "                        <p class=\"text-primary\" style=\"color: #F16522; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">\n" +
                        "                        </p>\n" +
                        "                    </td>\n" +
                        "                </tr>\n" +
                        "                \n" +
                        "                <tr height=\"15\"><td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                        "                <tr>\n" +
                        "                    <td align=\"center\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                        "                        <a href=\"#\" style=\"-webkit-text-decoration-color: #464646; color: #F16522; text-decoration: none; text-decoration-color: #464646;\"><img width=\"25\" htight=\"25\" src=\"http://dgtlmrktng.s3.amazonaws.com/go/emails/generic-email-template/fb.png\" target=\"_blank\" alt=\"Facebook\" style=\"border: 0; font-size: 0; margin: 0; max-width: 100%; padding: 0;\"></a>&nbsp;\n" +
                        "                        <a href=\"#\" style=\"-webkit-text-decoration-color: #464646; color: #F16522; text-decoration: none; text-decoration-color: #464646;\"><img width=\"25\" htight=\"25\" src=\"http://dgtlmrktng.s3.amazonaws.com/go/emails/generic-email-template/youtube.png\" target=\"_blank\" alt=\"Youtube\" style=\"border: 0; font-size: 0; margin: 0; max-width: 100%; padding: 0;\"></a>&nbsp;\n" +
                        "                        <a href=\"#\" style=\"-webkit-text-decoration-color: #464646; color: #F16522; text-decoration: none; text-decoration-color: #464646;\"><img width=\"25\" htight=\"25\" src=\"http://dgtlmrktng.s3.amazonaws.com/go/emails/generic-email-template/linkedin.png\" target=\"_blank\" alt=\"LinkedIn\" style=\"border: 0; font-size: 0; margin: 0; max-width: 100%; padding: 0;\"></a>&nbsp;\n" +
                        "                    </td>\n" +
                        "                </tr>\n" +
                        "                <tr height=\"10\"><td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                        "\n" +
                        "            </table>\n" +
                        "        </div>\n" +
                        "        <!-- Footer End -->\n" +
                        "    </body>\n" +
                        "</html>", true);
            helper.setSubject(title);
            mailSender.send(message);
        }catch (Exception c){
                System.out.println(c);
        }

        return "email sent";
    }
    public String sendForClaims(String receiver,String title,String name)throws Exception{
        MimeMessage message = mailSender.createMimeMessage();

        // Enable the multipart flag!
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        try {
            helper.setTo(receiver);
            helper.setText("<html style=\"-moz-osx-font-smoothing: grayscale; -webkit-font-smoothing: antialiased; background-color: #464646; margin: 0; padding: 0;\">\n" +
                    "    <head>\n" +
                    "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                    "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                    "        <meta name=\"format-detection\" content=\"telephone=no\">\n" +
                    "        <title>BTPRS Email</title>\n" +
                    "        \n" +
                    "    </head>\n" +
                    "    <body>\n" +
                    "      <center style=\"border: none;\">\n" +
                    "         <table style=\"background-color: white\">\n" +
                    "        <tbody>\n" +
                    "          \n" +
                    "          <tr>\n" +
                    "            <td width=\"480\" style=\"border:2px solid #e8eaed;border-radius:16px\">\n" +
                    "              <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n" +
                    "                <tbody><tr>\n" +
                    "                  <td align=\"center\">  <a href=\"#m_1627106100201308027_\">\n" +
                    "    <img width=\"100%\" height=\"109\" border=\"0\" src=\"https://ci5.googleusercontent.com/proxy/4fAxIsZrJJnDp8Ywr9F2iusOLY_rPDauYNLmooDChExPyHwJnumqPbVmyZwkBiE59-ZX91taqxQae3xwrdlBy-FM3mRIMDLMyyThBA=s0-d-e1-ft#https://services.google.com/fh/files/emails/topdesign.png\" alt=\"banner\" style=\"width:100%;height:109px;text-align:center;border:none\" class=\"CToWUd\">\n" +
                    "  </a>\n" +
                    "</td>\n" +
                    "                </tr>\n" +
                    "                <tr>\n" +
                    "                  <td>\n" +
                    "              <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" width=\"100%\">\n" +
                    "                      <tbody><tr>\n" +
                    "                        \n" +
                    "                        \n" +
                    "                        <td align=\"center\" class=\"m_1627106100201308027greeting_name m_1627106100201308027space6\" style=\"color:#202124;font-family:Google Sans,&quot;Roboto&quot;,Arial;font-size:22px;font-weight:normal;line-height:45px;margin:0;padding:0 80px 0 80px;text-align:center;word-break:normal;direction:ltr\" dir=\"ltr\">Hi "+name+" ,</td>\n" +
                    "                        \n" +
                    "                      </tr>\n" +
                    "                      \n" +
                    "                      <table role=\"presentation\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-family:Helvetica,Arial,sans-serif\" width=\"100%\" bgcolor=\"#ffffff\"> <tbody> <tr> <td> <table width=\"1\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> </tbody> </table></td> </tr> <tr> <td align=\"center\" style=\"font-size:24px;line-height:24px;color:#0077b5\">The power of your Claim</td> </tr> <tr> <td> <table width=\"1\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> <tr> <td> <div style=\"height:13px;font-size:13px;line-height:13px\"> &nbsp; </div></td> </tr> </tbody> </table></td> </tr> <tr> <td align=\"center\" style=\"font-size:16px;line-height:16px\">See how well your Claim stands out from lost item list.</td> </tr> <tr> <td> <table width=\"1\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> <tr> <td> <div style=\"height:40px;font-size:40px;line-height:40px\"> &nbsp; </div></td> </tr> </tbody> </table></td> </tr> <tr> <td align=\"center\"> <table role=\"presentation\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-family:Helvetica,Arial,sans-serif\" width=\"500\"> <tbody> <tr align=\"center\"> <td width=\"200\" dir=\"ltr\"><a href=\"https://www.linkedin.com/comm/me/profile-views?trk=eml-prof-pid-wvmp-bubble&amp;midToken=AQG_B6vaZY-v0Q&amp;trkEmail=eml-b2_professional_identity_digest_02-null-10-null-null-a870zy%7Ek92ms4yl%7Eaf-null-neptune%2Fme%2Eprofile%7Eviews&amp;lipi=urn%3Ali%3Apage%3Aemail_b2_professional_identity_digest_02%3BpVJ4diU9Sa2IKWHJorcTFw%3D%3D\" style=\"text-decoration:none\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.linkedin.com/comm/me/profile-views?trk%3Deml-prof-pid-wvmp-bubble%26midToken%3DAQG_B6vaZY-v0Q%26trkEmail%3Deml-b2_professional_identity_digest_02-null-10-null-null-a870zy%257Ek92ms4yl%257Eaf-null-neptune%252Fme%252Eprofile%257Eviews%26lipi%3Durn%253Ali%253Apage%253Aemail_b2_professional_identity_digest_02%253BpVJ4diU9Sa2IKWHJorcTFw%253D%253D&amp;source=gmail&amp;ust=1587125950569000&amp;usg=AFQjCNH20xzryLehIgnAWMZH7Nk1sFuMfw\"> <table role=\"presentation\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-family:Helvetica,Arial,sans-serif\" width=\"100%\" dir=\"ltr\"> <tbody> <tr> <td width=\"21\"> <table width=\"21\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> <tr> <td> <div style=\"height:0px;font-size:0px;line-height:0px\"> &nbsp; </div></td> </tr> </tbody> </table></td> <td width=\"158\"><img alt=\"\" role=\"presentation\" width=\"158\" height=\"46\" src=\"https://ci5.googleusercontent.com/proxy/myoVRpjflxoqCs8sEo2tQaUHiheXzlRvYQm7827hKidxMDVvkLTRntB0suXUzLGyyHvSYVYt8yRTIUzMABq8e2YUcynZFyOlg0L4rNMSMBxzHvjI_rRgtOVMBEy-P_pIaUzjzZkTAXqV_XV4LaIVQZ3v5FEwx2ucZhdE6Odo_gqQqLDp631lY489nSnT3FP3whKkyAB1Ic2k09gv9XnEdjCc77cSBU-uUaZbxgUJJ8rqLRSapqmIBkVqQzxEUzdlN3yu3_7996LChYzsxYoJsxaTAeWDS1YHQqJqrozDTWSMFqtD0JIk545-3mEIFXAc4635b7s=s0-d-e1-ft#https://static.licdn.com/sc/p/com.linkedin.email-assets-frontend%3Aemail-assets-frontend-static-content%2B__latest__/f/%2Femail-assets-frontend%2Fimages%2Femail%2Fcampaigns%2Fpid_v2%2Ftexture_pid_wvmp_circle_top_158_46_v4.png\" style=\"border:none;text-decoration:none;display:block\" class=\"CToWUd\"></td> <td width=\"21\"> <table width=\"21\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> <tr> <td> <div style=\"height:0px;font-size:0px;line-height:0px\"> &nbsp; </div></td> </tr> </tbody> </table></td> </tr> <tr> <td rowspan=\"2\"><img alt=\"\" role=\"presentation\" width=\"21\" height=\"94\" src=\"https://ci4.googleusercontent.com/proxy/DJWGTJrgPZLgF7Rhdq5ykj_YNUnAsUqKIzRZHsjIEoeBNNVturedV7fhv50zA2qDGw-eLwBC9PSPqLwQ5pvMjUrSGJ6_FOprSUCIsmD75tWhPdHxc96ztTxh2qb1Te-ERfCCaJE8nacPNs9C48Ea7_XW9FNA0cfJ5Yp2ltHnsvAbhVZlrGCqng5aZhfSvrLvireccINcRXHHCBxANe-9BiUG0lWjrH46LZQQ5vNjHL4mCiiucPcB9ripQvi_u-ZxRfKRV8q4trPJndskDGM1z5ixrcEmlQoVLzvsdFjA1J94aFFk1eA9v68HfddKgaM1sezbxQQ=s0-d-e1-ft#https://static.licdn.com/sc/p/com.linkedin.email-assets-frontend%3Aemail-assets-frontend-static-content%2B__latest__/f/%2Femail-assets-frontend%2Fimages%2Femail%2Fcampaigns%2Fpid_v2%2Ftexture_pid_wvmp_circle_left_21_94_v4.png\" style=\"border:none;text-decoration:none;display:block\" class=\"CToWUd\"></td> <td align=\"center\" valign=\"top\" height=\"72\" bgcolor=\"#0073B1\" style=\"font-size:60px;line-height:64px;max-width:158px;color:#ffffff\">1</td> <td rowspan=\"2\"><img alt=\"\" role=\"presentation\" width=\"21\" height=\"94\" src=\"https://ci6.googleusercontent.com/proxy/4JQe7MKoP9iZyvBNQKvBzryngh6wmyLKldm0hsuxV_Rh5wXyTKzoM1s6OL8fvtpdwCrOrRktpfivxh3K1B1WBqiBJ5GjrgwzXQZ3egede0nmXO6JUnUJrLnO96nI2DZgFU25QAWMelAWWuOAhFp4H-dHguG3xwrxUbpK8x9BGvwbtii0GqvTnqFR7Ed1vyM_pbe7SVnVyXr0gcnH8aSOk0_dBa-Z-Si3JJHVuW_Jsf4fq-rnkLvlOXU5JTvCS-Dgm_42zGzbUTKqnBvBt8SEXGOdXL9o9Fr8BCn_GPSEZM127SgnUwtipmdhQm9sllpwUTEf3K81=s0-d-e1-ft#https://static.licdn.com/sc/p/com.linkedin.email-assets-frontend%3Aemail-assets-frontend-static-content%2B__latest__/f/%2Femail-assets-frontend%2Fimages%2Femail%2Fcampaigns%2Fpid_v2%2Ftexture_pid_wvmp_circle_right_21_94_v4.png\" style=\"border:none;text-decoration:none;display:block\" class=\"CToWUd\"></td> </tr> <tr> <td align=\"center\" valign=\"bottom\" height=\"22\" bgcolor=\"#0073B1\" style=\"font-size:16px;line-height:22px;color:#ffffff\">Match</td> </tr> <tr> <td> <table width=\"21\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> <tr> <td> <div style=\"height:0px;font-size:0px;line-height:0px\"> &nbsp; </div></td> </tr> </tbody> </table></td> <td><img alt=\"\" role=\"presentation\" width=\"158\" height=\"46\" src=\"https://ci4.googleusercontent.com/proxy/MVfkARn75OgzwTCffOecBpJenu7xOPT5R--aBZ-sw8WDIiiyXx34M8fg_nwe-TE2sBwqHo3F7tYgWAohqQ8kepSW2ZZtbs5DqYAyCIKcMC5jEERh7uM_I0cudMF7cfWoTZYeGZldmaq0odzaQc8v90iPjlvZ7OJvpFzf9vYfxoMB7zDYnJc-dN8lLz-Jvm2Lyscfcj3sL1GTPtWtWWDQdaImNgnG8lue0KPVuxUZRVr_aIzKdfjECvqBAF92jcufy43El4mYPL7hlSwmtYpae7_XeqTzA7Sv4cJxnBttKu8XQU5VYsE4dDk6QAIBlftIyFgnE_tPKEk=s0-d-e1-ft#https://static.licdn.com/sc/p/com.linkedin.email-assets-frontend%3Aemail-assets-frontend-static-content%2B__latest__/f/%2Femail-assets-frontend%2Fimages%2Femail%2Fcampaigns%2Fpid_v2%2Ftexture_pid_wvmp_circle_bottom_158_46_v4.png\" style=\"border:none;text-decoration:none;display:block\" class=\"CToWUd\"></td> <td> <table width=\"21\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> <tr> <td> <div style=\"height:0px;font-size:0px;line-height:0px\"> &nbsp; </div></td> </tr> </tbody> </table></td> </tr> </tbody> </table></a></td> <td width=\"32\"> <table width=\"32\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> <tr> <td> <div style=\"height:18px;font-size:18px;line-height:18px\"> &nbsp; </div></td> </tr> </tbody> </table></td> <td align=\"left\" width=\"268\"> <table role=\"presentation\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-family:Helvetica,Arial,sans-serif\" width=\"100%\"> <tbody> <tr> <td style=\"font-size:20px;color:#4c4c4c\">View update list to get the match</td> </tr> <tr> <td> <table width=\"1\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> <tr> <td> <div style=\"height:18px;font-size:18px;line-height:18px\"> &nbsp; </div></td> </tr> </tbody> </table></td> </tr> <tr> <td> <table role=\"presentation\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-family:Helvetica,Arial,sans-serif\" width=\"auto\" height=\"36\"> <tbody> <tr> <td><a href=\"\"> <table role=\"presentation\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-radius:4px;font-family:Helvetica,Arial,sans-serif\" width=\"auto\" height=\"36\" bgcolor=\"#0177b5\"> <tbody> <tr> <td width=\"15\" rowspan=\"3\"> <table width=\"15\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> <tr> <td> <div style=\"height:0px;font-size:0px;line-height:0px\"> &nbsp; </div></td> </tr> </tbody> </table></td> <td height=\"10\"> <table width=\"1\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> <tr> <td> <div style=\"height:8px;font-size:8px;line-height:8px\"> &nbsp; </div></td> </tr> </tbody> </table></td> <td width=\"15\" rowspan=\"3\"> <table width=\"15\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> <tr> <td> <div style=\"height:0px;font-size:0px;line-height:0px\"> &nbsp; </div></td> </tr> </tbody> </table></td> </tr> <tr> <td height=\"16\" style=\"font-size:14px;text-decoration:none;color:#ffffff;display:inline-block\"><a href=\"http://localhost:4200/lostproperty\" style=\"font-size:14px;text-decoration:none;color:#ffffff;display:inline-block\" target=\"_blank\">View Lost item List</a></td> </tr> <tr> <td height=\"10\"> <table width=\"1\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> <tr> <td> <div style=\"height:8px;font-size:8px;line-height:8px\"> &nbsp; </div></td> </tr> </tbody> </table></td> </tr> </tbody> </table></a></td> </tr> </tbody> </table></td> </tr> </tbody> </table></td> </tr> </tbody> </table></td> </tr> <tr> <td> <table width=\"1\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"font-family:Helvetica,Arial,sans-serif\"> <tbody> <tr> <td> <div style=\"height:55px;font-size:55px;line-height:55px\"> &nbsp; </div></td> </tr> </tbody> </table></td> </tr> </tbody> </table>\n" +
                    "                      \n" +
                    "                    </tbody></table>\n" +
                    "          </td>\n" +
                    "                </tr>\n" +
                    "                      \n" +
                    "                 \n" +
                    "                    </tbody></table>\n" +
                    "                  </td>\n" +
                    "                </tr>\n" +
                    "                  \n" +
                    "\n" +
                    "                  \n" +
                    "                <tr>\n" +
                    "                  <td>\n" +
                    "                   \n" +
                    "                   \n" +
                    "                  </td>\n" +
                    "                </tr>\n" +
                    "                  <tr><td height=\"50\"></td></tr>\n" +
                    "                      <tr><td border=\"0\"><hr width=\"516\" border=\"0\" bgcolor=\"#F8F9FA\" style=\"margin:0;border-collapse:collapse;background-color:#f8f9fa;color:#f8f9fa;height:8px;border:none;width:516px\"></td></tr>\n" +
                    "                <tr>  \n" +
                    "                  <td>\n" +
                    "                    \n" +
                    "                    \n" +
                    "                  </td>\n" +
                    "                </tr>\n" +
                    "              </tbody></table>\n" +
                    "            </td>\n" +
                    "          </tr>\n" +
                    "          \n" +
                    "         \n" +
                    "          <tr><td height=\"24\"></td></tr>\n" +
                    "          \n" +
                    "          <tr>\n" +
                    "              <td width=\"480\" style=\"border:2px solid #e8eaed;border-radius:16px\">\n" +
                    "                \n" +
                    "              </td>\n" +
                    "          </tr>\n" +
                    "\n" +
                    "          \n" +
                    "                  <tr>\n" +
                    "                      <td>\n" +
                    "\n" +
                    "                        <table align=\"center\" bgcolor=\"#464646\" style=\"max-width: 600px; width: 100%;\">\n" +
                    "                \n" +
                    "                <tr height=\"15\"><td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                    "\n" +
                    "                <tr>\n" +
                    "                    <td align=\"center\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                    "                        <span width=\"50\" style=\"border: 32px; font-size: 26px; margin: 0; max-width: 100%; padding: 0;color: #F16522;\">BTPRS</span>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                \n" +
                    "                <tr height=\"2\"><td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                    "\n" +
                    "                <tr>\n" +
                    "                    <td align=\"center\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                    "                        <p class=\"text-white\" style=\"color: white; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">Copyright nelCorp 2020. All rights reserved.</p>\n" +
                    "                        <p class=\"text-primary\" style=\"color: #F16522; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">\n" +
                    "                        </p>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                \n" +
                    "                <tr height=\"15\"><td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                    "                <tr>\n" +
                    "                    <td align=\"center\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                    "                        <a href=\"#\" style=\"-webkit-text-decoration-color: #464646; color: #F16522; text-decoration: none; text-decoration-color: #464646;\"><img width=\"25\" htight=\"25\" src=\"http://dgtlmrktng.s3.amazonaws.com/go/emails/generic-email-template/fb.png\" target=\"_blank\" alt=\"Facebook\" style=\"border: 0; font-size: 0; margin: 0; max-width: 100%; padding: 0;\"></a>&nbsp;\n" +
                    "                        <a href=\"#\" style=\"-webkit-text-decoration-color: #464646; color: #F16522; text-decoration: none; text-decoration-color: #464646;\"><img width=\"25\" htight=\"25\" src=\"http://dgtlmrktng.s3.amazonaws.com/go/emails/generic-email-template/youtube.png\" target=\"_blank\" alt=\"Youtube\" style=\"border: 0; font-size: 0; margin: 0; max-width: 100%; padding: 0;\"></a>&nbsp;\n" +
                    "                        <a href=\"#\" style=\"-webkit-text-decoration-color: #464646; color: #F16522; text-decoration: none; text-decoration-color: #464646;\"><img width=\"25\" htight=\"25\" src=\"http://dgtlmrktng.s3.amazonaws.com/go/emails/generic-email-template/linkedin.png\" target=\"_blank\" alt=\"LinkedIn\" style=\"border: 0; font-size: 0; margin: 0; max-width: 100%; padding: 0;\"></a>&nbsp;\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                <tr height=\"10\"><td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                    "\n" +
                    "            </table>\n" +
                    "                      </td>\n" +
                    "                  </tr>\n" +
                    "                  <tr><td height=\"18\"></td></tr>\n" +
                    "        </tbody>\n" +
                    "      </table>\n" +
                    "      </center>\n" +
                    "     \n" +
                    "    </body>\n" +
                    "</html>", true);
            helper.setSubject(title);
            mailSender.send(message);
        }catch (Exception c){
            throw new RuntimeException("email not send ");
        }

        return "email sent";
    }
        public String sendForPassword(String receiver,String title,String otp)throws Exception{
                MimeMessage message = mailSender.createMimeMessage();

                // Enable the multipart flag!
                MimeMessageHelper helper = new MimeMessageHelper(message,true);
                try {
                        helper.setTo(receiver);
                        helper.setText("\n" +
                                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n" +
                                "<html style=\"-moz-osx-font-smoothing: grayscale; -webkit-font-smoothing: antialiased; background-color: #464646; margin: 0; padding: 0;\">\n" +
                                "    <head>\n" +
                                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                                "        <meta name=\"format-detection\" content=\"telephone=no\">\n" +
                                "        <title>BTPRS Email</title>\n" +
                                "        \n" +
                                "    </head>\n" +
                                "    <body bgcolor=\"#d7d7d7\" class=\"generic-template\" style=\"-moz-osx-font-smoothing: grayscale; -webkit-font-smoothing: antialiased; background-color: #d7d7d7; margin: 0; padding: 0;\">\n" +
                                "        <!-- Header Start -->\n" +
                                "        <div class=\"bg-white header\" bgcolor=\"#ffffff\" style=\"background-color: white; width: 100%;\">\n" +
                                "            <table align=\"center\" bgcolor=\"#ffffff\" style=\"border-left: 10px solid white; border-right: 10px solid white; max-width: 600px; width: 100%;\">\n" +
                                "                <tr height=\"80\">\n" +
                                "                    <td align=\"left\" class=\"vertical-align-middle\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: middle;\">\n" +
                                "                        <a href=\"https://www.go.com.mt/\" target=\"_blank\" style=\"-webkit-text-decoration-color: #F16522; color: #F16522; text-decoration: none; text-decoration-color: #F16522;\">\n" +
                                "                            <span style=\"border: 0; font-size: 32px; margin: 0; max-width: 100%; padding: 0;color: black\">BTPRS</span>\n" +
                                "                        </a>\n" +
                                "                    </td>\n" +
                                "                </tr>\n" +
                                "            </table>\n" +
                                "        </div>\n" +
                                "        <!-- Header End -->\n" +
                                "\n" +
                                "        <!-- Content Start -->\n" +
                                "        <table cellpadding=\"0\" cellspacing=\"0\" cols=\"1\" bgcolor=\"#d7d7d7\" align=\"center\" style=\"max-width: 600px;\">\n" +
                                "            <tr bgcolor=\"#d7d7d7\">\n" +
                                "                <td height=\"50\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td>\n" +
                                "            </tr>\n" +
                                "\n" +
                                "            <!-- This encapsulation is required to ensure correct rendering on Windows 10 Mail app. -->\n" +
                                "            <tr bgcolor=\"#d7d7d7\">\n" +
                                "                <td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                                "                    <!-- Seperator Start -->\n" +
                                "                    <table cellpadding=\"0\" cellspacing=\"0\" cols=\"1\" bgcolor=\"#d7d7d7\" align=\"center\" style=\"max-width: 600px; width: 100%;\">\n" +
                                "                        <tr bgcolor=\"#d7d7d7\">\n" +
                                "                            <td height=\"30\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td>\n" +
                                "                        </tr>\n" +
                                "                    </table>\n" +
                                "                    <!-- Seperator End -->\n" +
                                "\n" +
                                "                    <!-- Generic Pod Left Aligned Start -->\n" +
                                "                    <table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" cols=\"3\" bgcolor=\"white\" class=\"bordered-left-right\" style=\"border-left: 10px solid #d7d7d7; border-right: 10px solid #d7d7d7; max-width: 600px; width: 100%;\">\n" +
                                "                        <tr height=\"50\"><td colspan=\"3\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                                "                        <tr align=\"center\">\n" +
                                "                            <td width=\"36\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td>\n" +
                                "                            <td class=\"text-primary\" style=\"color: #F16522; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                                "                                <h1 style=\"color: #F16522; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 30px; font-weight: 700; line-height: 34px; margin-bottom: 0; margin-top: 0;\">Your BTPRS account need to be activated</h1>\n" +
                                "                            </td>\n" +
                                "                            <td width=\"36\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td>\n" +
                                "                        </tr>\n" +
                                "                        <tr height=\"30\"><td colspan=\"3\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                                "                        <tr align=\"left\">\n" +
                                "                            <td width=\"36\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td>\n" +
                                "                            <td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                                "                                <p style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">Hi,  \n" +
                                "</p>\n" +
                                "                                <br>\n" +
                                "                                <p style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">\n" +
                                "                                  click the link below to activate your acount\n" +
                                "</p>\n" +
                                "<br/>\n" +
                                "                         <div align=\"center\" style=\"padding:14px 20px 14px 20px;background-color:#F16522;border-radius:4px\">\n" +
                                "<span href=\"#\" style=\"font-family:helvetica neue,helvetica,arial,sans-serif;font-weight:bold;font-size:18px;line-height:1.5;color:#ffffff;text-decoration:none;display:block;text-align:center;max-width:400px;overflow:hidden;text-overflow:ellipsis\">\n" +
                                "" +otp +"\n" +
                                "</span>\n" +
                                "</div>\n" +
                                "<br/><br/>\n" +
                                "          \n" +
                                "                                                              <p style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">\n" +
                                "\n" +
                                "Best regards\n" +
                                "</p><br/>\n" +
                                "                              <p style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">\n" +
                                "BTPRS\n" +
                                "</p>\n" +
                                "                            </td>\n" +
                                "  \n" +
                                "                        </tr>\n" +
                                "\n" +
                                "                        \n" +
                                "       \n" +
                                "                        <tr height=\"50\"><td colspan=\"3\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                                "                    </table>\n" +
                                "                    <!-- Generic Pod Left Aligned End -->\n" +
                                "\n" +
                                "                    <!-- Seperator Start -->\n" +
                                "                    <table cellpadding=\"0\" cellspacing=\"0\" cols=\"1\" bgcolor=\"#d7d7d7\" align=\"center\" style=\"max-width: 600px; width: 100%;\">\n" +
                                "                        <tr bgcolor=\"#d7d7d7\">\n" +
                                "                            <td height=\"50\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td>\n" +
                                "                        </tr>\n" +
                                "                    </table>\n" +
                                "                    <!-- Seperator End -->\n" +
                                "\n" +
                                "                </td>\n" +
                                "            </tr>\n" +
                                "        </table>\n" +
                                "        <!-- Content End -->\n" +
                                "\n" +
                                "        <!-- Footer Start -->\n" +
                                "        <div class=\"bg-gray-dark footer\" bgcolor=\"#464646\" height=\"165\" style=\"background-color: #464646; width: 100%;\">\n" +
                                "            <table align=\"center\" bgcolor=\"#464646\" style=\"max-width: 600px; width: 100%;\">\n" +
                                "                \n" +
                                "                <tr height=\"15\"><td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                                "\n" +
                                "                <tr>\n" +
                                "                    <td align=\"center\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                                "                        <span width=\"50\" style=\"border: 32px; font-size: 26px; margin: 0; max-width: 100%; padding: 0;color: #F16522;\">BTPRS</span>\n" +
                                "                    </td>\n" +
                                "                </tr>\n" +
                                "                \n" +
                                "                <tr height=\"2\"><td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                                "\n" +
                                "                <tr>\n" +
                                "                    <td align=\"center\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                                "                        <p class=\"text-white\" style=\"color: white; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">Copyright nelCorp 2020. All rights reserved.</p>\n" +
                                "                        <p class=\"text-primary\" style=\"color: #F16522; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; margin: 0;\">\n" +
                                "                        </p>\n" +
                                "                    </td>\n" +
                                "                </tr>\n" +
                                "                \n" +
                                "                <tr height=\"15\"><td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                                "                <tr>\n" +
                                "                    <td align=\"center\" style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\">\n" +
                                "                        <a href=\"#\" style=\"-webkit-text-decoration-color: #464646; color: #F16522; text-decoration: none; text-decoration-color: #464646;\"><img width=\"25\" htight=\"25\" src=\"http://dgtlmrktng.s3.amazonaws.com/go/emails/generic-email-template/fb.png\" target=\"_blank\" alt=\"Facebook\" style=\"border: 0; font-size: 0; margin: 0; max-width: 100%; padding: 0;\"></a>&nbsp;\n" +
                                "                        <a href=\"#\" style=\"-webkit-text-decoration-color: #464646; color: #F16522; text-decoration: none; text-decoration-color: #464646;\"><img width=\"25\" htight=\"25\" src=\"http://dgtlmrktng.s3.amazonaws.com/go/emails/generic-email-template/youtube.png\" target=\"_blank\" alt=\"Youtube\" style=\"border: 0; font-size: 0; margin: 0; max-width: 100%; padding: 0;\"></a>&nbsp;\n" +
                                "                        <a href=\"#\" style=\"-webkit-text-decoration-color: #464646; color: #F16522; text-decoration: none; text-decoration-color: #464646;\"><img width=\"25\" htight=\"25\" src=\"http://dgtlmrktng.s3.amazonaws.com/go/emails/generic-email-template/linkedin.png\" target=\"_blank\" alt=\"LinkedIn\" style=\"border: 0; font-size: 0; margin: 0; max-width: 100%; padding: 0;\"></a>&nbsp;\n" +
                                "                    </td>\n" +
                                "                </tr>\n" +
                                "                <tr height=\"10\"><td style=\"color: #464646; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 16px; vertical-align: top;\"></td></tr>\n" +
                                "\n" +
                                "            </table>\n" +
                                "        </div>\n" +
                                "        <!-- Footer End -->\n" +
                                "    </body>\n" +
                                "</html>", true);
                        helper.setSubject(title);
                        mailSender.send(message);
                }catch (Exception c){
                        throw new RuntimeException("email not send ");
                }

                return "email sent";
        }

}
