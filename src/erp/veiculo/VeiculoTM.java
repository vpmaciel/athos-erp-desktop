package erp.veiculo;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.veiculo.marca.VeiculoMarca;
import erp.veiculo.modelo.VeiculoModelo;

@SuppressWarnings("serial")
public class VeiculoTM extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private List<Veiculo> veiculoList = new LinkedList<>();
	private Veiculo veiculo;
	private static TabelaModelo tabelaModelo = new TabelaModelo();

	public VeiculoTM() {

	}

	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("MARCA", 1, 500);
		tabelaModelo.adicionar("MODELO", 2, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}

	public VeiculoTM(List<Veiculo> lista) {
		veiculoList.addAll(lista);
	}

	public Veiculo getVeiculo(int linha) {
		if (veiculoList.size() > 0) {
			return veiculoList.get(linha);
		}
		return null;
	}

	public List<Veiculo> getVeiculoList() {
		return veiculoList;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return Long.class;
		}
		if (tabelaModelo.getNome(columnIndex).equals("MARCA")) {
			return VeiculoMarca.class;
		}
		if (tabelaModelo.getNome(columnIndex).equals("MODELO")) {
			return VeiculoModelo.class;
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
		return veiculoList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Veiculo veiculo = veiculoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return veiculo.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("MARCA")) {
			return veiculo.getMarca();
		}
		if (tabelaModelo.getNome(columnIndex).equals("MODELO")) {
			return veiculo.getModelo();
		}

		return veiculo;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setVeiculoList(List<Veiculo> veiculo) {
		veiculoList = veiculo;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		veiculo = veiculoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			veiculo.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("MARCA")) {
			veiculo.setMarca((VeiculoMarca) aValue);
		}
		if (tabelaModelo.getNome(columnIndex).equals("MODELO")) {
			veiculo.setModelo((VeiculoModelo) (aValue));
		}

		fireTableDataChanged();
	}
}