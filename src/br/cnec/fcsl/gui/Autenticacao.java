package br.cnec.fcsl.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Autenticacao extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblEscolhaOServidor;
	private JComboBox comboBox;
	private JLabel lblEmail;
	private JTextField campoEmail;
	private JLabel lblSenha;
	private JPasswordField campoSenha;
	private JPanel panel;
	private JButton botaoOk;
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autenticacao frame = new Autenticacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Autenticacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 273);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblEscolhaOServidor = new JLabel("Selecione o servidor:");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Gmail", "Yahoo"}));
		comboBox.setSelectedIndex(-1);
		
		lblEmail = new JLabel("E-mail:");
		
		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		
		lblSenha = new JLabel("Senha:");
		
		campoSenha = new JPasswordField();
		
		panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(comboBox, Alignment.LEADING, 0, 404, Short.MAX_VALUE)
						.addComponent(lblEscolhaOServidor, Alignment.LEADING)
						.addComponent(lblEmail, Alignment.LEADING)
						.addComponent(campoEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(lblSenha, Alignment.LEADING)
						.addComponent(campoSenha, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEscolhaOServidor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblEmail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSenha)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		
		botaoOk = new JButton("OK");
		botaoOk.addActionListener(this);
		panel.add(botaoOk);
		contentPane.setLayout(gl_contentPane);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoOk) {
			do_botaoOk_actionPerformed(e);
		}
	}
	protected void do_botaoOk_actionPerformed(ActionEvent e) {
		
		if(comboBox.getSelectedIndex() == 0){
			setServidorSMTP("smtp.gmail.com");
			setServidorPop3("pop.gmail.com");
		}else if(comboBox.getSelectedIndex() == 1){
			setServidorSMTP("smtp.mail.yahoo.com");
			setServidorPop3("pop.mail.yahoo.com");
		}
		
		setEmail(campoEmail.getText());
		setSenha(campoSenha.getText());
		
		new Opcoes().setVisible(true);	
		
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

	public static void setServidorSMTP(String servidorSMTP) {
		Autenticacao.servidorSMTP = servidorSMTP;
	}

	public static String getPortaSMTP() {
		return portaSMTP;
	}

	public static void setPortaSMTP(String portaSMTP) {
		Autenticacao.portaSMTP = portaSMTP;
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
