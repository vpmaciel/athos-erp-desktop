package erp.curriculo.caracteristica;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public class CaracteristicaTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("FUNCIONÁRIO", 1, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Caracteristica caracteristica;

	private List<Caracteristica> caracteristicaList = new LinkedList<>();

	public CaracteristicaTm() {

	}

	public CaracteristicaTm(List<Caracteristica> lista) {
		caracteristicaList.addAll(lista);
	}

	public Caracteristica getCaracteristica(int linha) {
		if (caracteristicaList.size() > 0) {
			return caracteristicaList.get(linha);
		}
		return null;
	}

	public List<Caracteristica> getcaracteristicaList() {
		return caracteristicaList;
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
		return caracteristicaList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Caracteristica caracteristica = caracteristicaList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return caracteristica.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return caracteristica.getFuncionario();
		}
		return caracteristica;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setcaracteristicaList(List<Caracteristica> caracteristica) {
		caracteristicaList = caracteristica;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		caracteristica = caracteristicaList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			caracteristica.setId(Long.parseLong(aValue.toString()));
		}

		if (tabelaModelo.getNome(columnIndex).equals("FUNCINÁRIO")) {
			caracteristica.setFuncionario((Funcionario) aValue);
		}

		fireTableDataChanged();
	}
}