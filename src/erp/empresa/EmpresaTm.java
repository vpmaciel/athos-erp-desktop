package erp.empresa;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class EmpresaTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("CNPJ", 1, 100);
		tabelaModelo.adicionar("NOME", 2, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Empresa empresa;

	private List<Empresa> empresaList = new LinkedList<>();

	public EmpresaTm() {

	}

	public EmpresaTm(List<Empresa> lista) {
		empresaList.addAll(lista);
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

	public Empresa getEmpresa(int linha) {
		if (empresaList.size() > 0) {
			return empresaList.get(linha);
		}
		return null;
	}

	public List<Empresa> getEmpresaList() {
		return empresaList;
	}

	@Override
	public int getRowCount() {
		return empresaList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Empresa empresa = empresaList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return empresa.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME FANTASIA")) {
			return empresa.getNomeFantasia();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CNPJ")) {
			return empresa.getCnpj();
		}

		return empresa;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setEmpresaList(List<Empresa> empresa) {
		empresaList = empresa;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		empresa = empresaList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			empresa.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME FANTASIA")) {
			empresa.setNomeFantasia(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("CNPJ")) {
			empresa.setCnpj(aValue.toString());
		}

		fireTableDataChanged();
	}
}