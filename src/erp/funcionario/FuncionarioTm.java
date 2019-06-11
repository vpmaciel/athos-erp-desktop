package erp.funcionario;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class FuncionarioTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionarColuna("ID", 0, 100);
		tabelaModelo.adicionarColuna("CPF", 1, 100);
		tabelaModelo.adicionarColuna("NOME", 2, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Funcionario funcionario;

	private List<Funcionario> funcionarioList = new LinkedList<>();

	public FuncionarioTm() {

	}

	public FuncionarioTm(List<Funcionario> lista) {
		funcionarioList.addAll(lista);
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

	public Funcionario getFuncionario(int linha) {
		if (funcionarioList.size() > 0) {
			return funcionarioList.get(linha);
		}
		return null;
	}

	public List<Funcionario> getFuncionarioList() {
		return funcionarioList;
	}

	@Override
	public int getRowCount() {
		return funcionarioList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Funcionario funcionario = funcionarioList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return funcionario.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			return funcionario.getNome();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CPF")) {
			return funcionario.getCpf();
		}

		return funcionario;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setFuncionarioList(List<Funcionario> funcionario) {
		funcionarioList = funcionario;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		funcionario = funcionarioList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			funcionario.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			funcionario.setNome(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("CPF")) {
			funcionario.setCpf(aValue.toString());
		}

		fireTableDataChanged();
	}
}