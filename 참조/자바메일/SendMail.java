
https://java.net/projects/javamail/pages/Home �� �����Ͽ� ���̺귯�� �ٿ�ε�(÷��)


������Ʈ�� Build path�� �߰�


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
  String sendID = "���̵�";
  String sendPW = "��й�ȣ";
  String sendMailAddr = "������ ��� �̸��� �ּ�";
  int smtpPort=465;
  
  String recEmailAddr="�޴� ��� �̸��� �ּ�";
  String sub = "�ȳ�";
  String cont = "������";
  
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

