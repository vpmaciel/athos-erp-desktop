package erp.curriculo.objetivoprofissional;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public class ObjetivoProfissionalTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("FUNCIONÁRIO", 1, 400);
		tabelaModelo.adicionar("CARGO", 2, 400);
		tabelaModelo.adicionar("PRETENSÃO SALARIAL", 3, 400);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private ObjetivoProfissional objetivoProfissional;

	private List<ObjetivoProfissional> objetivoProfissionalList = new LinkedList<>();

	public ObjetivoProfissionalTm() {

	}

	public ObjetivoProfissionalTm(List<ObjetivoProfissional> lista) {
		objetivoProfissionalList.addAll(lista);
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

	public ObjetivoProfissional getObjetivoProfissional(int linha) {
		if (objetivoProfissionalList.size() > 0) {
			return objetivoProfissionalList.get(linha);
		}
		return null;
	}

	public List<ObjetivoProfissional> getObjetivoProfissionalList() {
		return objetivoProfissionalList;
	}

	@Override
	public int getRowCount() {
		return objetivoProfissionalList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ObjetivoProfissional objetivoProfissional = objetivoProfissionalList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return objetivoProfissional.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return objetivoProfissional.getFuncionario();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CARGO")) {
			return objetivoProfissional.getCargo();
		}
		if (tabelaModelo.getNome(columnIndex).equals("PRETENSÃO SALARIAL")) {
			return objetivoProfissional.getPretensaoSalarial();
		}
		return objetivoProfissional;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setObjetivoProfissionalList(List<ObjetivoProfissional> objetivoProfissional) {
		objetivoProfissionalList = objetivoProfissional;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		objetivoProfissional = objetivoProfissionalList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			objetivoProfissional.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCINÁRIO")) {
			objetivoProfissional.setFuncionario((Funcionario) aValue);
		}
		if (tabelaModelo.getNome(columnIndex).equals("CARGO")) {
			objetivoProfissional.setCargo(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("PRETENSÃO SALARIAL")) {
			objetivoProfissional.setPretensaoSalarial(aValue.toString());
		}

		fireTableDataChanged();
	}
}