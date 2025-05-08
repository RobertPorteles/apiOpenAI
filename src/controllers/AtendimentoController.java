package controllers;

import java.time.Instant;
import java.util.UUID;

import javax.swing.JOptionPane;

import entities.Atendimento;
import services.OpenAIService;

public class AtendimentoController {

	/*
	 * Método para executar o passo a passo do atendimento
	 */
	public void realizarAtendimento() {
		
		//capturando o nome do cliente
		var nomeCliente = JOptionPane.showInputDialog("Digite o seu nome:");		
		
		//capturando a pergunta digitada pelo usuário
		var pergunta = JOptionPane.showInputDialog("Digite a sua pergunta:");
		
		//criando um objeto da classe Atendimento usando 
		//o método construtor com entrada de argumentos
		var atendimento = new Atendimento(UUID.randomUUID(), nomeCliente, Instant.now(), pergunta, null);
		
		System.out.println("Processando a pergunta, por favor aguarde...");
		
		//enviando a pergunta para a openAI e capturar a resposta
		var openAIService = new OpenAIService();
		var resposta = openAIService.send(pergunta);
		
		atendimento.setResposta(resposta);
		
		System.out.println("\nATENDIMENTO GERADO COM SUCESSO!\n");
		System.out.println("ID..........: " + atendimento.getId());
		System.out.println("CLIENTE.....: " + atendimento.getNomeCliente());
		System.out.println("DATA E HORA.: " + atendimento.getDataHora());
		System.out.println("PERGUNTA....: " + atendimento.getPergunta());
		System.out.println("RESPOSTA....: " + atendimento.getResposta());
	}
}

