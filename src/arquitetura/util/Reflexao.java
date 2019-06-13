package arquitetura.util;

import java.lang.reflect.Field;
import java.util.List;

public class Reflexao {

	private final Object object;
	private final Field[] campos;
	private Class<?> classe;
	private String[] colunas;
	private Object[][] dados;
	private List<?> list;

	Reflexao(Object object, List<?> list) {
		this.object = object;
		this.classe = object.getClass();
		this.campos = classe.getDeclaredFields();
		this.list = list;
	}

	public String[] getColunas() {

		this.colunas = new String[campos.length];
		int indice = 0;

		for (Field campo : campos) {
			try {
				colunas[indice++] = campo.getName();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return colunas;
	}

	public Object[][] getDados() {

		String nomeAtributo = "";
		Object valorAtributo = null;
		dados = new Object[list.size()][colunas.length];
		int linha = 0, coluna = 0;
		for (Object object : list) {
			for (Field campo : campos) {
				try {
					nomeAtributo = campo.getName();
					campo.setAccessible(true); // Necessário por conta do encapsulamento das variáveis (private)
					valorAtributo = campo.get(object);
					dados[linha][coluna] = campo.get(object);
				} catch (Exception e) {
					e.printStackTrace();
				}
				coluna++;
			}
			linha++;
			coluna = 0;
		}
		return dados;
	}
}
