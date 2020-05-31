package com.hyp.utils.mail_send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
@Transactional
public class MailSendService {

    @Autowired
    private Environment env;

    /**
     * 发送邮件方法
     *
     * @param emailAddress 目标地址
     * @param text 邮件内容
     * @param topic 主题
     * @param cc 抄送
     * @return boolean
     */
    public boolean sendMail(String emailAddress, String text, String topic, String cc) {

        final String username = env.getProperty("mail.username");
        final String password = env.getProperty("mail.password");
        if (username.isEmpty() || password.isEmpty()){
            return false;
        }
        String from = username;
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", "smtp.chinasoftinc.com");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.transport.protocol", "smtp");
        Session session = Session.getInstance(properties);
        session.setDebug(true);
        try {
            // 创建邮件对象
            MimeMessage message = new MimeMessage(session);
            // 设置邮件发送方
            message.setFrom(new InternetAddress(from));
            // 设置邮件发送的主题<邮件标题>
            message.setSubject(topic);
            // 设置抄送地址
            if(null != cc && !cc.isEmpty()){
                @SuppressWarnings("static-access")
                InternetAddress[] internetAddressCC = new InternetAddress().parse(cc);
                message.setRecipients(Message.RecipientType.CC, internetAddressCC);
            }
            // 设置邮件发送的内容
            message.setContent(text, "text/html;charset=utf-8");
            Transport transport = session.getTransport();
            transport.connect(username, password);
            transport.sendMessage(message, new Address[]{new InternetAddress(emailAddress)});
            transport.close();
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
