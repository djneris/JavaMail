package br.cnec.fcsl.sistema;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

public class CheckingMails {

   public void check(String host, String user, String password) {
	   
	   System.out.println(user+","+password);
	   
      try {

      // propriedades da conexão
      Properties properties = new Properties();

      
      properties.put("mail.pop3s.host", host);
      properties.put("mail.pop3s.port", "995");
      properties.put("mail.pop3s.starttls.enable", "true");

      // autenticação
      Session emailSession = Session.getInstance(properties,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(user, password);
            }
         });
      //emailSession.setDebug(true);

      // Criação do objeto de armazenamento POP3 e conexão com o servidor pop
      Store store = emailSession.getStore("pop3s");

      store.connect();

      // leitura da caixa de entrada
      Folder emailFolder = store.getFolder("INBOX");
      emailFolder.open(Folder.READ_ONLY);

      // Recuperar as mensagens da pasta em um array e exibi-lo
      Message[] messages = emailFolder.getMessages();
      System.out.println("messages.length---" + messages.length);

      for (int i = 0, n = messages.length; i < n; i++) {
         Message message = messages[i];
         System.out.println("---------------------------------");
         System.out.println("Email " + (i + 1));
         System.out.println("Assunto: " + message.getSubject());
         System.out.println("De: " + message.getFrom()[0]);
         System.out.println("Texto: " + message.getContent().toString());
      }

      // fechando conexoes 
      emailFolder.close(false);
      store.close();

      } catch (NoSuchProviderException e) {
         e.printStackTrace();
      } catch (MessagingException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
      //
   }

 
}