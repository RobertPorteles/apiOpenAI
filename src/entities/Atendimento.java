package entities;

import java.time.Instant;
import java.util.UUID;

public class Atendimento {
	private UUID id;
	private String nomeCliente;
	private Instant dataHora;
	private String pergunta;
	private String resposta;
	
	public Atendimento() {
		super();
	}
	public Atendimento(UUID id, String nomeCliente, Instant dataHora, String pergunta, String resposta) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.dataHora = dataHora;
		this.pergunta = pergunta;
		this.resposta = resposta;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Instant getDataHora() {
		return dataHora;
	}

	public void setDataHora(Instant dataHora) {
		this.dataHora = dataHora;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

}
