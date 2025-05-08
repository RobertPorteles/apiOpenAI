package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class OpenAIService {

	//Atributos
	private String endpoint = "https://api.openai.com/v1/responses";
	private String apiKey = "digite sua chave aqui";
	private String prompt = "Você é um atendente de suporte de TI, responda as dúvidas de forma objetiva e cordial. Só gere respostas para perguntas relacionadas a assuntos de Tecnologia.";
	
	/*
	 * Método para receber uma pergunta, fazer a integração com a OpenAI
	 * e ao final retornar a resposta obtida
	 */
	public String send(String text) {
		
		try {
			
			//definir a URL (endpoint) que será executado da API
			URL url = new URI(endpoint).toURL();
			
			//fazendo uma conexão com o servidor da API
			var connection = (HttpURLConnection) url.openConnection();
			
			//configurando a requisição
			connection.setRequestMethod("POST"); //tipo de requisição que será enviada para a OpenAI (POST)
			connection.setRequestProperty("Authorization", "Bearer " + apiKey); //enviando  TOKEN de autenticação
			connection.setRequestProperty("Content-Type", "application/json"); //dados serão enviados em JSON
			connection.setDoOutput(true); //configurando para capturar os dados de resposta
			
			//escrevendo os dados em JSON que serão enviados para a API
			var input = prompt + "Responda a pergunta: " + text;
			var jsonRequest = String.format("""
								{
									"model": "gpt-4.1",
								    "input": "%s"
								}
							""", input);			
			
			//preparando os dados para serem enviados
			var output = connection.getOutputStream();
			var request = jsonRequest.getBytes(StandardCharsets.UTF_8);
			output.write(request, 0, request.length);
			
			//executando chamada para a API e capturar a resposta
			var response = new StringBuilder();
			var reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			//lendo a resposta obtida
			var linha = "";
			while((linha = reader.readLine()) != null)
				response.append(linha.trim());
			
			//retornar o texto da resposta gerado pelo ChatGPT
			var json = response.toString();
			
		    String marker = "\"text\": \"";
		    int start = json.indexOf(marker);
		       
		    start += marker.length();

		    return extractFullText(json, start);
		}
		catch(Exception e) {
			System.out.println("\nFalha ao enviar requisição para OpenAI: " + e.getMessage());
			return null;
		}
	}
	
	private static String extractFullText(String json, int start) {
        StringBuilder sb = new StringBuilder();
        boolean escaping = false;
        for (int i = start; i < json.length(); i++) {
            char c = json.charAt(i);
            if (escaping) {
                sb.append(c);
                escaping = false;
            } else if (c == '\\') {
                sb.append(c);
                escaping = true;
            } else if (c == '"') {                
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString()
                .replace("\\n", "\n")
                .replace("\\\"", "\"");
    }}