package erp.curriculo.teste.perfilcomportmental;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public class TestePerfilCompTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("FUNCIONÁRIO", 1, 400);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private TestePerfilComp testePerfilComp;

	private List<TestePerfilComp> testePerfilCompList = new LinkedList<>();

	public TestePerfilCompTm() {

	}

	public TestePerfilCompTm(List<TestePerfilComp> lista) {
		testePerfilCompList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return Long.class;
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return Funcionario.class;
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
		return testePerfilCompList.size();
	}

	public TestePerfilComp getTestePerfilComp(int linha) {
		if (testePerfilCompList.size() > 0) {
			return testePerfilCompList.get(linha);
		}
		return null;
	}

	public List<TestePerfilComp> gettestePerfilCompList() {
		return testePerfilCompList;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TestePerfilComp testePerfilComp = testePerfilCompList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return testePerfilComp.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return testePerfilComp.getFuncionario();
		}
		return testePerfilComp;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void settestePerfilCompList(List<TestePerfilComp> testePerfilComp) {
		testePerfilCompList = testePerfilComp;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		testePerfilComp = testePerfilCompList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			testePerfilComp.setId(Long.parseLong(aValue.toString()));
		}

		if (tabelaModelo.getNome(columnIndex).equals("FUNCINÁRIO")) {
			testePerfilComp.setFuncionario((Funcionario) aValue);
		}

		fireTableDataChanged();
	}
}