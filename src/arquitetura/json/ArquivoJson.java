package arquitetura.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import arquitetura.Sis;
import arquitetura.data.Data;
import arquitetura.gui.Msg;
import erp.banco.Banco;

public class ArquivoJson<Tipo> {

	private String arquivo;
	private List<Tipo> listTipo = new LinkedList<Tipo>();
	private Tipo tipo;

	public ArquivoJson(Tipo tipo, String nome) {
		this.tipo = tipo;
		arquivo = Sis.getCaminhoDadosJson() + "[" + nome + "]-" + Data.getDataHoraArquivo() + ".json";
	}

	public List<Tipo> getListTipo() {
		return listTipo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void gravarArquivo(Collection<?> collection) {
		Gson gson = new Gson();
		String json = gson.toJson(collection);
		try {
			FileWriter writer = new FileWriter(arquivo);
			writer.write(json);
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
			Msg.erroArquivo();
		}
	}

	public Collection<?> lerArquivo() {
		List<?> listTipo = null;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo));
			Type listType = new TypeToken<ArrayList<Banco>>() {
			}.getType();
			listTipo = new Gson().fromJson(bufferedReader, listType);
		} catch (Exception e) {
			e.printStackTrace();
			Msg.erroArquivo();
		}
		return listTipo;
	}

	public void setListTipo(List<Tipo> listTipo) {
		this.listTipo = listTipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}