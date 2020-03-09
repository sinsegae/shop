
https://java.net/projects/javamail/pages/Home 에 접속하여 라이브러리 다운로드(첨부)


프로젝트의 Build path에 추가


package mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
 public static void main(String[] args) {
  String server = "smtp.gmail.com";
  String sendID = "아이디";
  String sendPW = "비밀번호";
  String sendMailAddr = "보내는 사람 이메일 주소";
  int smtpPort=465;
  
  String recEmailAddr="받는 사람 이메일 주소";
  String sub = "안녕";
  String cont = "내용임";
  
  Properties props = System.getProperties();
  
  props.put("mail.smtp.host", server);
  props.put("mail.smtp.port", smtpPort);
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.ssl.enable", "true");
  props.put("mail.smtp.ssl.trust", server);
  
  Session session = Session.getDefaultInstance(props, new Authenticator(){
   protected PasswordAuthentication getPasswordAuthentication(){
    return new PasswordAuthentication(sendID, sendPW);
   }
  });
  
  session.setDebug(true);
  
  Message mimeMessage = new MimeMessage(session);
  try {
   mimeMessage.setFrom(new InternetAddress( sendMailAddr ));
   mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recEmailAddr));
   mimeMessage.setSubject(sub);
   mimeMessage.setText(cont);
   Transport.send(mimeMessage);
  } catch (AddressException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (MessagingException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  
 }
}

