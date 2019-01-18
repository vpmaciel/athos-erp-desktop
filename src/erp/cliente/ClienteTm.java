package erp.cliente;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.banco.Banco;
import erp.empresa.Empresa;

@SuppressWarnings("serial")
public class ClienteTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private List<Cliente> clienteList = new LinkedList<>();
	private Cliente cliente;
	private static TabelaModelo tabelaModelo = new TabelaModelo();

	public ClienteTm() {

	}

	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("CNPJ", 1, 100);
		tabelaModelo.adicionar("CPF", 2, 100);
		tabelaModelo.adicionar("NOME", 3, 500);
		tabelaModelo.adicionar("EMPRESA", 4, 500);
		tabelaModelo.adicionar("BANCO", 5, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}

	public ClienteTm(List<Cliente> lista) {
		clienteList.addAll(lista);
	}

	public Cliente getCliente(int linha) {
		if (clienteList.size() > 0) {
			return clienteList.get(linha);
		}
		return null;
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return Long.class;
		}
		if (tabelaModelo.getNome(columnIndex).equals("EMPRESA")) {
			return Empresa.class;
		}
		if (tabelaModelo.getNome(columnIndex).equals("BANCO")) {
			return Banco.class;
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
		return clienteList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente cliente = clienteList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return cliente.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			return cliente.getNome();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CNPJ")) {
			return cliente.getCnpj();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CPF")) {
			return cliente.getCpf();
		}
		if (tabelaModelo.getNome(columnIndex).equals("EMPRESA")) {
			return cliente.getEmpresa();
		}
		if (tabelaModelo.getNome(columnIndex).equals("BANCO")) {
			return cliente.getBanco();
		}
		return cliente;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setClienteList(List<Cliente> cliente) {
		clienteList = cliente;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		cliente = clienteList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			cliente.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			cliente.setNome(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("CNPJ")) {
			cliente.setCnpj(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("CPF")) {
			cliente.setCpf(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("EMPRESA")) {
			cliente.setEmpresa((Empresa) aValue);
		}
		if (tabelaModelo.getNome(columnIndex).equals("BANCO")) {
			cliente.setBanco((Banco) aValue);
		}

		fireTableDataChanged();
	}
}