package arquitetura.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import arquitetura.AOP;
import erp.banco.Banco;

public class Json<Tipo> {
	String local;
	Tipo tipo;

	{
		/*
		 * Banco banco = new Banco(); banco.setId(1L); banco.setCodigo("111");
		 * banco.setNome("BMG");
		 * 
		 * Json<Banco> json = new Json<Banco>(banco); json.lerArquivo();
		 */

	}

	public Json(Tipo tipo) {
		this.tipo = tipo;
		local = AOP.getCaminhoDadosCsv() + tipo.getClass().getName() + ".json";
	}

	public void gravarArquivo() {
		Gson gson = new Gson();

		// converte objetos Java para JSON e retorna JSON como String
		String json = gson.toJson(tipo);

		try {
			// Escreve Json convertido em arquivo chamado "file.json"
			FileWriter writer = new FileWriter(local);
			writer.write(json);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(json);
	}

	public void lerArquivo() {
		Gson gson = new Gson();

		try {

			BufferedReader br = new BufferedReader(new FileReader(local));

			// Converte String JSON para objeto Java
			@SuppressWarnings("unchecked")
			Tipo obj = (Tipo) gson.fromJson(br, tipo.getClass());

			System.out.println(obj);
			System.out.println(((Banco) obj).getCodigo());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}