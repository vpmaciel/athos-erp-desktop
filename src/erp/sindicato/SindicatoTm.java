package erp.sindicato;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class SindicatoTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionarColuna("ID", 0, 100);
		tabelaModelo.adicionarColuna("CNPJ", 1, 100);
		tabelaModelo.adicionarColuna("NOME", 2, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Sindicato sindicato;

	private List<Sindicato> sindicatoList = new LinkedList<>();

	public SindicatoTm() {

	}

	public SindicatoTm(List<Sindicato> lista) {
		sindicatoList.addAll(lista);
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

	@Override
	public int getRowCount() {
		return sindicatoList.size();
	}

	public Sindicato getSindicato(int linha) {
		if (sindicatoList.size() > 0) {
			return sindicatoList.get(linha);
		}
		return null;
	}

	public List<Sindicato> getSindicatoList() {
		return sindicatoList;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Sindicato sindicato = sindicatoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return sindicato.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME FANTASIA")) {
			return sindicato.getNomeFantasia();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CNPJ")) {
			return sindicato.getCnpj();
		}

		return sindicato;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setSindicatoList(List<Sindicato> sindicato) {
		sindicatoList = sindicato;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		sindicato = sindicatoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			sindicato.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME FANTASIA")) {
			sindicato.setNomeFantasia(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("CNPJ")) {
			sindicato.setCnpj(aValue.toString());
		}

		fireTableDataChanged();
	}
}