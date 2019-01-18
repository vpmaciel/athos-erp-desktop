package erp.cartorio;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class CartorioTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private List<Cartorio> cartorioList = new LinkedList<>();
	private Cartorio cartorio;
	private static TabelaModelo tabelaModelo = new TabelaModelo();

	public CartorioTm() {

	}

	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("NOME FANTASIA", 1, 500);
		tabelaModelo.adicionar("COMARCA", 2, 500);
		tabelaModelo.adicionar("CIDADE", 3, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}

	public CartorioTm(List<Cartorio> lista) {
		cartorioList.addAll(lista);
	}

	public Cartorio getCartorio(int linha) {
		if (cartorioList.size() > 0) {
			return cartorioList.get(linha);
		}
		return null;
	}

	public List<Cartorio> getCartorioList() {
		return cartorioList;
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
		return cartorioList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cartorio cartorio = cartorioList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return cartorio.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME FANTASIA")) {
			return cartorio.getNomeFantasia();
		}
		if (tabelaModelo.getNome(columnIndex).equals("COMARCA")) {
			return cartorio.getComarca();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CIDADE")) {
			return cartorio.getCidade();
		}
		return cartorio;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setCartorioList(List<Cartorio> cartorio) {
		cartorioList = cartorio;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		cartorio = cartorioList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			cartorio.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("CIDADE")) {
			cartorio.setCidade(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("COMARCA")) {
			cartorio.setComarca(aValue.toString());
		}

		fireTableDataChanged();
	}
}