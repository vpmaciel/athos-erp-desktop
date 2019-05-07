package erp.imovel;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class ImovelTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("NOME PROPRIETÁRIO", 1, 500);
		tabelaModelo.adicionar("CIDADE", 2, 500);
		tabelaModelo.adicionar("BAIRRO", 3, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Imovel imovel;

	private List<Imovel> imovelList = new LinkedList<>();

	public ImovelTm() {

	}

	public ImovelTm(List<Imovel> lista) {
		imovelList.addAll(lista);
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

	public Imovel getImovel(int linha) {
		if (imovelList.size() > 0) {
			return imovelList.get(linha);
		}
		return null;
	}

	public List<Imovel> getImovelList() {
		return imovelList;
	}

	@Override
	public int getRowCount() {
		return imovelList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Imovel imovel = imovelList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return imovel.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME PROPRIETÁRIO")) {
			return imovel.getNomeProprietario();
		}
		if (tabelaModelo.getNome(columnIndex).equals("BAIRRO")) {
			return imovel.getBairro();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CIDADE")) {
			return imovel.getCidade();
		}

		return imovel;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setImovelList(List<Imovel> imovel) {
		imovelList = imovel;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		imovel = imovelList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			imovel.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME PROPRIETÁRIO")) {
			imovel.setNomeProprietario(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("BAIRRO")) {
			imovel.setBairro(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("CIDADE")) {
			imovel.setCidade(aValue.toString());
		}

		fireTableDataChanged();
	}
}