package erp.banco;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class BancoTM extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private List<Banco> bancoList = new LinkedList<>();
	private Banco banco;
	private static TabelaModelo tabelaModelo = new TabelaModelo();

	public BancoTM() {

	}

	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("NOME", 1, 500);
		
		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}

	public BancoTM(List<Banco> lista) {
		bancoList.addAll(lista);
	}

	public Banco getBanco(int linha) {
		if (bancoList.size() > 0) {
			return bancoList.get(linha);
		}
		return null;
	}

	public List<Banco> getBancoList() {
		return bancoList;
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
		return bancoList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Banco banco = bancoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return banco.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			return banco.getNome();
		}
		return banco;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setBancoList(List<Banco> banco) {
		bancoList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		banco = bancoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			banco.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			banco.setNome(aValue.toString());
		}

		fireTableDataChanged();
	}
}