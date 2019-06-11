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
		tabelaModelo.adicionarColuna("ID", 0, 100);
		tabelaModelo.adicionarColuna("CNPJ", 1, 200);
		tabelaModelo.adicionarColuna("NOME", 2, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Empresa empresa;

	private List<Empresa> listEmpresa = new LinkedList<>();

	public EmpresaTm() {

	}

	public EmpresaTm(List<Empresa> lista) {
		listEmpresa.addAll(lista);
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
		if (listEmpresa.size() > 0) {
			return listEmpresa.get(linha);
		}
		return null;
	}

	public List<Empresa> getListEmpresa() {
		return listEmpresa;
	}

	@Override
	public int getRowCount() {
		return listEmpresa.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Empresa empresa = listEmpresa.get(rowIndex);

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

	public void setEmpresaList(List<Empresa> listEmpresa) {
		this.listEmpresa = listEmpresa;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		empresa = listEmpresa.get(rowIndex);

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