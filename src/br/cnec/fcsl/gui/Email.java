package br.cnec.fcsl.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.cnec.fcsl.sistema.EnviarEmail;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Email extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField campoDestino;
	private JTextField campoAssunto;
	private JScrollPane scrollPane;
	private JTextArea campoMensagem;
	private JPanel panel;
	private JButton btnEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Email dialog = new Email();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Email() {
		setBounds(100, 100, 450, 341);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewLabel = new JLabel("Para:");
		}
		campoDestino = new JTextField();
		campoDestino.setColumns(10);
		JLabel lblAssunto = new JLabel("Assunto:");
		campoAssunto = new JTextField();
		campoAssunto.setColumns(10);
		JLabel lblMensagem = new JLabel("Mensagem:");

		scrollPane = new JScrollPane();

		panel = new JPanel();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(campoDestino, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING)
						.addComponent(lblAssunto, Alignment.LEADING)
						.addComponent(campoAssunto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(lblMensagem, Alignment.LEADING))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAssunto)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoAssunto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMensagem)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
					.addContainerGap())
		);

		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		panel.add(btnEnviar);

		campoMensagem = new JTextArea();
		scrollPane.setViewportView(campoMensagem);
		contentPanel.setLayout(gl_contentPanel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviar) {
			do_btnEnviar_actionPerformed(e);
		}
	}

	protected void do_btnEnviar_actionPerformed(ActionEvent e) {

		EnviarEmail sm = new EnviarEmail(Autenticacao.getServidorSMTP(), Autenticacao.getPortaSMTP());
		sm.sendMail(Autenticacao.getEmail(), campoDestino.getText(), campoAssunto.getText(),
				campoMensagem.getText());
	}
}
