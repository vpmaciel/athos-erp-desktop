package erp.cliente;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import erp.banco.Banco;
import erp.empresa.Empresa;

@SuppressWarnings("serial")
public class ClienteTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static final int NOME = 1;
	public static final int CPF_NUMERO = 2;
	public static final int CNPJ = 3;
	public static final int EMPRESA = 4;
	public static final int BANCO = 5;

	public static final int[] WIDTH = new int[] { 100, 400, 200, 200, 400, 400 };
	private final boolean[] podeEditar = new boolean[] { false, false, false, false, false, false };
	private List<Cliente> clientesList = new LinkedList<>();
	private Cliente cliente;

	public ClienteTableModel() {

	}

	public ClienteTableModel(List<Cliente> lista) {
		clientesList.addAll(lista);
	}

	public Cliente getCliente(int linha) {
		if (clientesList.size() > 0) {
			return clientesList.get(linha);
		}
		return new Cliente();
	}

	public List<Cliente> getClienteList() {
		return clientesList;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == CNPJ) {
			return String.class;
		}
		if (columnIndex == CPF_NUMERO) {
			return String.class;
		}
		if (columnIndex == ID) {
			return Long.class;
		}
		if (columnIndex == NOME) {
			return String.class;
		}
		if (columnIndex == EMPRESA) {
			return Empresa.class;
		}
		if (columnIndex == BANCO) {
			return Banco.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return WIDTH.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == ID) {
			return "REGISTRO";
		}
		if (columnIndex == CNPJ) {
			return "CNPJ";
		}
		if (columnIndex == CPF_NUMERO) {
			return "CPF";
		}
		if (columnIndex == NOME) {
			return "NOME";
		}
		if (columnIndex == EMPRESA) {
			return "EMPRESA";
		}
		if (columnIndex == BANCO) {
			return "BANCO";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return clientesList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente cliente = clientesList.get(rowIndex);

		if (columnIndex == CNPJ) {
			return cliente.getCnpj();
		}
		if (columnIndex == CPF_NUMERO) {
			return cliente.getCpfNumero();
		}
		if (columnIndex == ID) {
			return cliente.getId();
		}
		if (columnIndex == NOME) {
			return cliente.getNome();
		}
		if (columnIndex == EMPRESA) {
			return cliente.getEmpresa();
		}
		if (columnIndex == BANCO) {
			return cliente.getBanco();
		}
		return cliente;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setClienteList(List<Cliente> cliente) {
		clientesList = cliente;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		cliente = clientesList.get(rowIndex);

		if (columnIndex == CNPJ) {
			cliente.setCnpj(aValue.toString());
		}
		if (columnIndex == CPF_NUMERO) {
			cliente.setCpfNumero(aValue.toString());
		}
		if (columnIndex == ID) {
			cliente.setId(Long.parseLong(aValue.toString()));
		}
		if (columnIndex == NOME) {
			cliente.setNome(aValue.toString());
		}
		if (columnIndex == BANCO) {
			cliente.setBanco((Banco) aValue);
		}
		if (columnIndex == EMPRESA) {
			cliente.setEmpresa((Empresa) aValue);
		}
		fireTableDataChanged();
	}
}
