package br.com.tis.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired 
	private JavaMailSender mailSender;
	
	@PostMapping("/enviarEmail")
	public void enviarEmail(@RequestBody String dados) throws UnsupportedEncodingException {
		String nome = URLDecoder.decode(dados, "UTF-8").split("&")[0].split("=")[1];
		String assunto = URLDecoder.decode(dados, "UTF-8").split("&")[1].split("=")[1];
		String mensagem = URLDecoder.decode(dados, "UTF-8").split("&")[2].split("=")[1];
		String contato = URLDecoder.decode(dados, "UTF-8").split("&")[3].split("=")[1];
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject(nome + " - " + assunto);
		message.setText(mensagem + "\n" + "\n" + "Contato: " + contato);
        message.setTo("dwagner146@gmail.com");
        message.setFrom("dwagner146@gmail.com");
        
        try {
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }       
	}
}
