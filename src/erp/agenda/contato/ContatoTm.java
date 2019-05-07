package erp.agenda.contato;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class ContatoTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("NOME", 1, 400);
		tabelaModelo.adicionar("CPF", 2, 400);
		tabelaModelo.adicionar("CNPJ", 3, 400);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Contato contato;

	private List<Contato> contatoList = new LinkedList<>();

	public ContatoTm() {

	}

	public ContatoTm(List<Contato> lista) {
		contatoList.addAll(lista);
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
		if (tabelaModelo.getNome(columnIndex).equals("CPF")) {
			return tipoEvento.getCpf();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CNPJ")) {
			return tipoEvento.getCnpj();
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