package arquitetura.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

import arquitetura.Sis;
import arquitetura.data.Data;
import erp.banco.Banco;
import erp.banco.BancoFac;

public class Json<Tipo> {
	private String local;
	private Tipo tipo;
	private List<Tipo> listTipo = new LinkedList<Tipo>();
		{


		
	}

	public Json(Tipo tipo) {
		this.tipo = tipo;
		local = Sis.getCaminhoDadosJson() + tipo.getClass().getName() + ".json";
		
		//Json<Banco> json = new Json<Banco>(tipo);
		//json.lerArquivo();
		gravarArquivo(BancoFac.getRegistro());
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Tipo> getListTipo() {
		return listTipo;
	}

	public void setListTipo(List<Tipo> listTipo) {
		this.listTipo = listTipo;
	}

	public void gravarArquivo(Collection<Banco> collection) {
		Gson gson = new Gson();

		// converte objetos Java para JSON e retorna JSON como String
		String json = gson.toJson(collection);

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