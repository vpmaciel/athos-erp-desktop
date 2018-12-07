package erp.agenda.recado;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class RecadoTM extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private List<Recado> RecadoList = new LinkedList<>();
	private Recado recado;
	private static TabelaModelo tabelaModelo = new TabelaModelo();

	public RecadoTM() {

	}

	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("DATA", 1, 100);
		tabelaModelo.adicionar("REMETENTE", 2, 500);
		tabelaModelo.adicionar("DESTINATÁRIO", 3,500);
		
		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}

	public RecadoTM(List<Recado> lista) {
		RecadoList.addAll(lista);
	}

	public Recado getRecado(int linha) {
		if (RecadoList.size() > 0) {
			return RecadoList.get(linha);
		}
		return null;
	}

	public List<Recado> getRecadoList() {
		return RecadoList;
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
		return RecadoList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Recado recado = RecadoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return recado.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("DATA")) {
			return recado.getData();
		}
		if (tabelaModelo.getNome(columnIndex).equals("REMETENTE")) {
			return recado.getRemetente();
		}
		if (tabelaModelo.getNome(columnIndex).equals("DESTINATÁRIO")) {
			return recado.getDestinatario();
		}
		return recado;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setRecadoList(List<Recado> Recado) {
		RecadoList = Recado;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		recado = RecadoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			recado.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("DATA")) {
			recado.setData(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("REMETENTE")) {
			recado.setRemetente(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("DESTINATÁRIO")) {
			recado.setDestinatario(aValue.toString());
		}
		fireTableDataChanged();
	}
}