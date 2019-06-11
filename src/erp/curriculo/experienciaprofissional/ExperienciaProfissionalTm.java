package erp.curriculo.experienciaprofissional;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public class ExperienciaProfissionalTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionarColuna("ID", 0, 100);
		tabelaModelo.adicionarColuna("FUNCIONÁRIO", 1, 500);
		tabelaModelo.adicionarColuna("EMPRESA", 2, 500);
		tabelaModelo.adicionarColuna("CARGO", 3, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private ExperienciaProfissional experienciaProfissional;

	private List<ExperienciaProfissional> ExperienciaProfissionalList = new LinkedList<>();

	public ExperienciaProfissionalTm() {

	}

	public ExperienciaProfissionalTm(List<ExperienciaProfissional> lista) {
		ExperienciaProfissionalList.addAll(lista);
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

	public ExperienciaProfissional getExperienciaProfissional(int linha) {
		if (ExperienciaProfissionalList.size() > 0) {
			return ExperienciaProfissionalList.get(linha);
		}
		return null;
	}

	public List<ExperienciaProfissional> getExperienciaProfissionalList() {
		return ExperienciaProfissionalList;
	}

	@Override
	public int getRowCount() {
		return ExperienciaProfissionalList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ExperienciaProfissional ExperienciaProfissional = ExperienciaProfissionalList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return ExperienciaProfissional.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return ExperienciaProfissional.getFuncionario();
		}
		if (tabelaModelo.getNome(columnIndex).equals("EMPRESA")) {
			return ExperienciaProfissional.getEmpresa();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CARGO")) {
			return ExperienciaProfissional.getCargo();
		}

		return ExperienciaProfissional;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setExperienciaProfissionalList(List<ExperienciaProfissional> ExperienciaProfissional) {
		ExperienciaProfissionalList = ExperienciaProfissional;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		experienciaProfissional = ExperienciaProfissionalList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			experienciaProfissional.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCINÁRIO")) {
			experienciaProfissional.setFuncionario((Funcionario) aValue);
		}
		if (tabelaModelo.getNome(columnIndex).equals("EMPRESA")) {
			experienciaProfissional.setEmpresa(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("CARGO")) {
			experienciaProfissional.setCargo(aValue.toString());
		}

		fireTableDataChanged();
	}
}