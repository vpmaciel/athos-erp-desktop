package erp.veiculo.modelo;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class VeiculoModeloTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionarColuna("ID", 0, 100);
		tabelaModelo.adicionarColuna("MODELO", 1, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private VeiculoModelo veiculoModelo;

	private List<VeiculoModelo> veiculoModeloList = new LinkedList<>();

	public VeiculoModeloTm() {

	}

	public VeiculoModeloTm(List<VeiculoModelo> lista) {
		veiculoModeloList.addAll(lista);
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
		return veiculoModeloList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		VeiculoModelo veiculoModelo = veiculoModeloList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return veiculoModelo.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("MODELO")) {
			return veiculoModelo.getModelo();
		}
		return veiculoModelo;
	}

	public VeiculoModelo getVeiculoModelo(int linha) {
		if (veiculoModeloList.size() > 0) {
			return veiculoModeloList.get(linha);
		}
		return null;
	}

	public List<VeiculoModelo> getVeiculoModeloList() {
		return veiculoModeloList;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		veiculoModelo = veiculoModeloList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			veiculoModelo.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("MODELO")) {
			veiculoModelo.setModelo(aValue.toString());
		}

		fireTableDataChanged();
	}

	public void setVeiculoModeloList(List<VeiculoModelo> veiculoModelo) {
		veiculoModeloList = veiculoModelo;
	}
}