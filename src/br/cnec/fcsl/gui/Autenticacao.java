package br.cnec.fcsl.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.cnec.fcsl.sistema.CheckingMails;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Autenticacao extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblEmail;
	private JTextField campoEmail;
	private JLabel lblSenha;
	private JPasswordField campoSenha;
	private JPanel panel;
	private JButton botaoOk;
	private JComboBox comboBox;
	private JLabel lblEscolhaOServido;
	private static String senha;
	private static String email;
	private static String servidorSMTP;
	private static String portaSMTP = "465";
	private static String servidorPop3;
	private static String portaPop3 = "995";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Autenticacao dialog = new Autenticacao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Autenticacao() {
		setTitle("Configura\u00E7\u00E3o do Servidor");
		setBounds(100, 100, 466, 358);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		lblEmail = new JLabel("E-mail:");
		
		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		
		lblSenha = new JLabel("Senha:");
		
		panel = new JPanel();
		
		campoSenha = new JPasswordField();
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Gmail", "Yahoo"}));
		comboBox.setSelectedIndex(0);
		
		lblEscolhaOServido = new JLabel("Escolha o servidor:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
						.addComponent(campoSenha, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
						.addComponent(lblSenha)
						.addComponent(campoEmail, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
						.addComponent(lblEmail)
						.addComponent(comboBox, 0, 420, Short.MAX_VALUE)
						.addComponent(lblEscolhaOServido))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEscolhaOServido)
					.addGap(13)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(65)
					.addComponent(lblEmail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSenha)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		botaoOk = new JButton("Enviar Email");
		botaoOk.addActionListener(this);
		panel.add(botaoOk);
		contentPanel.setLayout(gl_contentPanel);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == botaoOk) {
			do_botaoOk_actionPerformed(arg0);
		}
	}
	protected void do_botaoOk_actionPerformed(ActionEvent arg0) {
		
		if(comboBox.getSelectedIndex() == 0){
			setServidorSMTP("smtp.gmail.com");
			setServidorPop3("pop.gmail.com");
		}else{
			setServidorSMTP("smtp.mail.yahoo.com");
			setServidorPop3("pop.mail.yahoo.com");
		}
		
		setEmail(campoEmail.getText());
		setSenha(campoSenha.getText());
		
		new Email().setVisible(true);		
	}

	public static String getSenha() {
		return senha;
	}

	public static void setSenha(String senha) {
		Autenticacao.senha = senha;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		Autenticacao.email = email;
	}

	public static String getServidorSMTP() {
		return servidorSMTP;
	}

	public static void setServidorSMTP(String servidor) {
		Autenticacao.servidorSMTP = servidor;
	}

	public static String getPortaSMTP() {
		return portaSMTP;
	}

	public static void setPortaSMTP(String porta) {
		Autenticacao.portaSMTP = porta;
	}
	
	public static String getServidorPop3() {
		return servidorPop3;
	}

	public static void setServidorPop3(String servidorPop3) {
		Autenticacao.servidorPop3 = servidorPop3;
	}

	public static String getPortaPop3() {
		return portaPop3;
	}

	public static void setPortaPop3(String portaPop3) {
		Autenticacao.portaPop3 = portaPop3;
	}
}
