package erp.veiculo;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.veiculo.marca.VeiculoMarca;
import erp.veiculo.modelo.VeiculoModelo;

@SuppressWarnings("serial")
public class VeiculoTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("MARCA", 1, 400);
		tabelaModelo.adicionar("MODELO", 2, 400);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Veiculo veiculo;

	private List<Veiculo> veiculoList = new LinkedList<>();

	public VeiculoTm() {

	}

	public VeiculoTm(List<Veiculo> lista) {
		veiculoList.addAll(lista);
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
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
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

	public void setVeiculoList(List<Veiculo> veiculo) {
		veiculoList = veiculo;
	}
}