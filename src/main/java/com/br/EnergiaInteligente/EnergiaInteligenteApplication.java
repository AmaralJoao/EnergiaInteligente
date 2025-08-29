package com.br.EnergiaInteligente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EnergiaInteligenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnergiaInteligenteApplication.class, args);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senha = "minhaSenhaSecreta"; // Substitua pela senha desejada
		String senhaCriptografada = encoder.encode(senha);

		System.out.println("Hash BCrypt: " + senhaCriptografada);
	}

}
