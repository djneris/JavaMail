package br.cnec.fcsl.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Autenticacao extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField campoEmailAuth;
	private JPasswordField campoSenhaAuth;
	private JButton botaoOk;
	private String email;
	private String senha;

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
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblEmail = new JLabel("Email:");
		campoEmailAuth = new JTextField();
		campoEmailAuth.setColumns(10);
		JLabel lblSenha = new JLabel("Senha:");
		botaoOk = new JButton("OK");
		botaoOk.addActionListener(this);
		campoSenhaAuth = new JPasswordField();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblEmail)
							.addGap(18)
							.addComponent(campoEmailAuth, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblSenha)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(campoSenhaAuth, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
						.addComponent(botaoOk, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(campoEmailAuth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(campoSenhaAuth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(botaoOk)
					.addContainerGap(115, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoOk) {
			do_botaoOk_actionPerformed(e);
		}
	}
	protected void do_botaoOk_actionPerformed(ActionEvent e) {
		setEmail(campoEmailAuth.getText());
		setSenha(campoSenhaAuth.getText());
		
		new Email().setVisible(true);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
