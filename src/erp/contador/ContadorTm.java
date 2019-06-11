package erp.contador;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class ContadorTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionarColuna("ID", 0, 100);
		tabelaModelo.adicionarColuna("CNPJ", 1, 100);
		tabelaModelo.adicionarColuna("CPF", 2, 100);
		tabelaModelo.adicionarColuna("NOME", 3, 500);
		tabelaModelo.adicionarColuna("CRC", 4, 100);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Contador contador;

	private List<Contador> contadorList = new LinkedList<>();

	public ContadorTm() {

	}

	public ContadorTm(List<Contador> lista) {
		contadorList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return Long.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return largura.length;
	}

	@Override
	public String getColumnName(int column) {
		return tabelaModelo.getNome(column);
	}

	public Contador getContador(int linha) {
		if (contadorList.size() > 0) {
			return contadorList.get(linha);
		}
		return null;
	}

	public List<Contador> getContadorList() {
		return contadorList;
	}

	@Override
	public int getRowCount() {
		return contadorList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Contador contador = contadorList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return contador.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			return contador.getNome();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CNPJ")) {
			return contador.getCnpj();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CPF")) {
			return contador.getCpf();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CRC")) {
			return contador.getCrc();
		}

		return contador;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setContadorList(List<Contador> contador) {
		contadorList = contador;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		contador = contadorList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			contador.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			contador.setNome(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("CNPJ")) {
			contador.setCnpj(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("CPF")) {
			contador.setCpf(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("CRC")) {
			contador.setCrc(aValue.toString());
		}
		fireTableDataChanged();
	}
}