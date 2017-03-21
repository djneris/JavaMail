package br.cnec.fcsl.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import br.cnec.fcsl.sistema.SendMail;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Email extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblEmailDoDestinatario;
	private JLabel lblMensagem;
	private JTextField campoDestinatario;
	private JScrollPane scrollPane;
	private JTextArea campoMensagem;
	private JButton botaoEnviar;
	private JLabel lblAssunto;
	private JTextField campoAssunto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Email frame = new Email();
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
	public Email() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblEmailDoDestinatario = new JLabel("E-mail do destinatario:");

		lblMensagem = new JLabel("Mensagem:");

		campoDestinatario = new JTextField();
		campoDestinatario.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));

		botaoEnviar = new JButton("Enviar");
		botaoEnviar.addActionListener(this);

		lblAssunto = new JLabel("Assunto:");

		campoAssunto = new JTextField();
		campoAssunto.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblEmailDoDestinatario)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(campoDestinatario, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblAssunto).addGap(18)
								.addComponent(campoAssunto, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
						.addComponent(lblMensagem)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(botaoEnviar, Alignment.TRAILING))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(20)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblEmailDoDestinatario)
						.addComponent(campoDestinatario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblAssunto).addComponent(
						campoAssunto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(lblMensagem).addGap(18)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE).addGap(28)
				.addComponent(botaoEnviar).addContainerGap(93, Short.MAX_VALUE)));

		campoMensagem = new JTextArea();
		campoMensagem.setLineWrap(true);
		scrollPane.setViewportView(campoMensagem);
		contentPane.setLayout(gl_contentPane);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoEnviar) {
			do_botaoEnviar_actionPerformed(e);
		}
	}

	protected void do_botaoEnviar_actionPerformed(ActionEvent e) {
	
	
		SendMail sm = new SendMail();
		sm.sendMail("cnecsysten@gmail.com", campoDestinatario.getText(), campoAssunto.getText(), campoMensagem.getText());

	}


}
