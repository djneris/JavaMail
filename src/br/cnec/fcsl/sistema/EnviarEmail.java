package br.cnec.fcsl.sistema;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import br.cnec.fcsl.gui.Autenticacao;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EnviarEmail {
	
	private String ServidorSMTP;
	private String PortaSMTP;
	
	public EnviarEmail() {
		
	}

	/*
	 * para mudar o servidor e a porta, so enviar para o contrutor os
	 * valores como string
	 */

	public EnviarEmail(String ServidorSMTP, String PortaSMTP) {
		this.ServidorSMTP = ServidorSMTP;
		this.PortaSMTP = PortaSMTP;
	}

	public void sendMail(String usuario, String destino, String assunto, String mensagem) {
		Properties props = new Properties();
		// quem estiver utilizando um SERVIDOR PROXY descomente essa parte e
		// atribua as propriedades do SERVIDOR PROXY utilizado
		/*
		 * props.setProperty("proxySet","true");
		 * props.setProperty("socksProxyHost","ip do proxy"); // IP do Servidor Proxy 
		 * props.setProperty("socksProxyPort","porta do proxy"); // Porta do servidor Proxy
		 */
		props.put("mail.transport.protocol", "smtp"); // define protocolo de  envio como SMTP														
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", ServidorSMTP); // server SMTP
		props.put("mail.smtp.auth", "true"); // ativa autenticacao
		props.put("mail.debug", "true"); //ativa o debug
		props.put("mail.smtp.port", PortaSMTP); // porta
		props.put("mail.smtp.socketFactory.port", PortaSMTP); // mesma port para o socket
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				
		// Cria um autenticador que sera usado a seguir
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Autenticacao.getEmail(), Autenticacao.getSenha());
			}
		};

		// Session - objeto que ira realizar a conexão com o servidor
		/*
		 * Como há necessidade de autenticação é criada uma autenticacao que é
		 * responsavel por solicitar e retornar o usuário e senha para
		 * autenticação
		 */
		Session session = Session.getDefaultInstance(props, auth);
		session.setDebug(true); // Habilita o LOG das ações executadas durante o
								// envio do email

		// Objeto que contém a mensagem
		Message msg = new MimeMessage(session);
		try {
			// Setando a origem do email
			msg.setFrom(new InternetAddress(usuario));
			// Setando o destinatário
			Address[] usuarios = InternetAddress.parse(destino);//cria vetor de endereços dos destinatarios			
			msg.setRecipients(Message.RecipientType.TO, usuarios);	
			// Setando o assunto
			msg.setSubject(assunto);
			// Setando o conteúdo/corpo do email
			msg.setContent(mensagem, "text/html");			
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Completar Mensagem");
			e.printStackTrace();
		}
		// Objeto encarregado de enviar os dados para o email
		Transport tr;
		try {
			tr = session.getTransport("smtp"); // define smtp para transporte
			
			/*
			 * 1 - define o servidor smtp | 2 - seu nome de usuario | 3 - sua senha 
			 */
			tr.connect(ServidorSMTP, Autenticacao.getEmail(), Autenticacao.getSenha());

			msg.saveChanges(); 
			// envio da mensagem
			tr.sendMessage(msg, msg.getAllRecipients());
			
			JOptionPane.showMessageDialog(null, "Mensagem Enviada");
			
			tr.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Enviar Mensagem");
			e.printStackTrace();
		}
	}

}
