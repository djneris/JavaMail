package br.cnec.fcsl.sistema;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import br.cnec.fcsl.gui.Mensagem;

public class ChecarEmail {
	
	private String ms = "";

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public void checar(String serverPop, String user, String password) {

		try {

			// propriedades da conexão
			Properties properties = new Properties();

			properties.put("mail.pop3s.host", serverPop);//servidor pop3
			properties.put("mail.pop3s.port", "995");//porta pop3
			properties.put("mail.pop3s.starttls.enable", "true");

			// autenticação
			Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			session.setDebug(true);

			// Criação do objeto de armazenamento POP3 e conexão com o servidor
			// pop
			Store store = session.getStore("pop3s");

			store.connect();

			// leitura da caixa de entrada
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// Recuperar as mensagens da pasta em um array e exibi-lo
			Message[] messages = emailFolder.getMessages();
			
			for (int i = 0; i < messages.length; i++) {
				Message message = messages[i];
				
				ms += "Email " + (i + 1) +" \n"+
						"Assunto " + message.getSubject() + "\n"+
						"De: " + message.getFrom()[0] +"\n"+
						"Texto: " + message.getContent().toString() +"\n\n";
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
	}

}
