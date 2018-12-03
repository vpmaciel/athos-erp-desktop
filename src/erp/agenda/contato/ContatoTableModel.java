package erp.agenda.contato;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class ContatoTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private List<Contato> contatoList = new LinkedList<>();
	private Contato contato;
	private static TabelaModelo tabelaModelo = new TabelaModelo();

	public ContatoTableModel() {

	}

	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("NOME", 1, 250);
		tabelaModelo.adicionar("CPF", 2, 250);
		tabelaModelo.adicionar("CNPJ", 3, 250);
		
		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}

	public ContatoTableModel(List<Contato> lista) {
		contatoList.addAll(lista);
	}

	public Contato getContato(int linha) {
		if (contatoList.size() > 0) {
			return contatoList.get(linha);
		}
		return null;
	}

	public List<Contato> getContatoList() {
		return contatoList;
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
		return contatoList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Contato tipoEvento = contatoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return tipoEvento.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			return tipoEvento.getNome();
		}
		return tipoEvento;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setContatoList(List<Contato> contato) {
		contatoList = contato;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		contato = contatoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			contato.setId(Long.parseLong(aValue.toString()));
		}

		fireTableDataChanged();
	}
}