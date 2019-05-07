package erp.veiculo.marca;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class VeiculoMarcaTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("MARCA", 1, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private VeiculoMarca veiculoMarca;

	private List<VeiculoMarca> veiculoMarcaList = new LinkedList<>();

	public VeiculoMarcaTm() {

	}

	public VeiculoMarcaTm(List<VeiculoMarca> lista) {
		veiculoMarcaList.addAll(lista);
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
		return veiculoMarcaList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		VeiculoMarca veiculoMarca = veiculoMarcaList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return veiculoMarca.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("MARCA")) {
			return veiculoMarca.getMarca();
		}
		return veiculoMarca;
	}

	public VeiculoMarca getVeiculoMarca(int linha) {
		if (veiculoMarcaList.size() > 0) {
			return veiculoMarcaList.get(linha);
		}
		return null;
	}

	public List<VeiculoMarca> getVeiculoMarcaList() {
		return veiculoMarcaList;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		veiculoMarca = veiculoMarcaList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			veiculoMarca.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("MARCA")) {
			veiculoMarca.setMarca(aValue.toString());
		}
		fireTableDataChanged();
	}

	public void setVeiculoMarcaList(List<VeiculoMarca> veiculoMarca) {
		veiculoMarcaList = veiculoMarca;
	}
}