package erp.fornecedor;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class FornecedorTm extends AbstractTableModel {

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
	private Fornecedor fornecedor;

	private List<Fornecedor> fornecedorList = new LinkedList<>();

	public FornecedorTm() {

	}

	public FornecedorTm(List<Fornecedor> lista) {
		fornecedorList.addAll(lista);
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

	public Fornecedor getFornecedor(int linha) {
		if (fornecedorList.size() > 0) {
			return fornecedorList.get(linha);
		}
		return null;
	}

	public List<Fornecedor> getFornecedorList() {
		return fornecedorList;
	}

	@Override
	public int getRowCount() {
		return fornecedorList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Fornecedor fornecedor = fornecedorList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return fornecedor.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME FANTASIA")) {
			return fornecedor.getNomeFantasia();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CNPJ")) {
			return fornecedor.getCnpj();
		}

		return fornecedor;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setFornecedorList(List<Fornecedor> fornecedor) {
		fornecedorList = fornecedor;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		fornecedor = fornecedorList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			fornecedor.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME FANTASIA")) {
			fornecedor.setNomeFantasia(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("CNPJ")) {
			fornecedor.setCnpj(aValue.toString());
		}

		fireTableDataChanged();
	}
}