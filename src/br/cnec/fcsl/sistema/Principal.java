package br.cnec.fcsl.sistema;

public class Principal {

	public static void main(String[] args) {
		
		SendMail sm = new SendMail("smtp.gmail.com","465");
		sm.sendMail("oliveira.daniloneri@gmail.com","cristianhenrique06@hotmail.com","Teste","Envio de email usando a API JavaMail");
		
	}

}
