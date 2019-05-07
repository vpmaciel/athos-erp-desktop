package erp.curriculo.curso;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public class CursoTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("FUNCIONÁRIO", 1, 500);
		tabelaModelo.adicionar("INSTITUIÇÃO", 2, 500);
		tabelaModelo.adicionar("CURSO", 3, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Curso curso;

	private List<Curso> CursoList = new LinkedList<>();

	public CursoTm() {

	}

	public CursoTm(List<Curso> lista) {
		CursoList.addAll(lista);
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

	public Curso getCurso(int linha) {
		if (CursoList.size() > 0) {
			return CursoList.get(linha);
		}
		return null;
	}

	public List<Curso> getCursoList() {
		return CursoList;
	}

	@Override
	public int getRowCount() {
		return CursoList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Curso Curso = CursoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return Curso.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return Curso.getFuncionario();
		}
		if (tabelaModelo.getNome(columnIndex).equals("INSTITUIÇÃO")) {
			return Curso.getInstituicao();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CURSO")) {
			return Curso.getCurso();
		}
		return Curso;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setCursoList(List<Curso> Curso) {
		CursoList = Curso;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		curso = CursoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			curso.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCINÁRIO")) {
			curso.setFuncionario((Funcionario) aValue);
		}
		if (tabelaModelo.getNome(columnIndex).equals("INSTITUIÇÃO")) {
			curso.setInstituicao(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("CURSO")) {
			curso.setCurso(aValue.toString());
		}

		fireTableDataChanged();
	}
}