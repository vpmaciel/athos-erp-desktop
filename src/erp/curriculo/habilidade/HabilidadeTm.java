package erp.curriculo.habilidade;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public class HabilidadeTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionarColuna("ID", 0, 100);
		tabelaModelo.adicionarColuna("FUNCIONÁRIO", 1, 500);
		tabelaModelo.adicionarColuna("CONHECIMENTO", 2, 500);
		tabelaModelo.adicionarColuna("NÍVEL DE CONHECIMENTO", 3, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Habilidade habilidade;

	private List<Habilidade> HabilidadeList = new LinkedList<>();

	public HabilidadeTm() {

	}

	public HabilidadeTm(List<Habilidade> lista) {
		HabilidadeList.addAll(lista);
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

	public Habilidade getHabilidade(int linha) {
		if (HabilidadeList.size() > 0) {
			return HabilidadeList.get(linha);
		}
		return null;
	}

	public List<Habilidade> getHabilidadeList() {
		return HabilidadeList;
	}

	@Override
	public int getRowCount() {
		return HabilidadeList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Habilidade Habilidade = HabilidadeList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return Habilidade.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return Habilidade.getFuncionario();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CONHECIMENTO")) {
			return Habilidade.getConhecimento();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NÍVEL DE CONHECIMENTO")) {
			return Habilidade.getNivelConhecimento();
		}
		return Habilidade;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setHabilidadeList(List<Habilidade> Habilidade) {
		HabilidadeList = Habilidade;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		habilidade = HabilidadeList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			habilidade.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCINÁRIO")) {
			habilidade.setFuncionario((Funcionario) aValue);
		}
		if (tabelaModelo.getNome(columnIndex).equals("CONHECIMENTO")) {
			habilidade.setConhecimento(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("NÍVEL DE CONHECIMENTO")) {
			habilidade.setNivelConhecimento(aValue.toString());
		}

		fireTableDataChanged();
	}
}