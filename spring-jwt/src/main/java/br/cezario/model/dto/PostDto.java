package br.cezario.model.dto;

import java.time.LocalDate;

import br.cezario.model.User;

public class PostDto {

	private String texto;
	private LocalDate data;

	public PostDto() {
		this.data = LocalDate.now();
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}
