package erp.contador;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ContadorTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static final int NOME = 1;
	public static final int CRC = 2;
	public static final int CPF = 3;
	public static final int CNPJ = 4;
	public static final int[] WIDTH = new int[] { 100, 400, 200, 200, 200 };
	private final boolean[] podeEditar = new boolean[] { false, false, false, false, false };
	private List<Contador> contadorList = new LinkedList<>();
	private Contador contador;

	public ContadorTableModel() {
	}

	public ContadorTableModel(List<Contador> lista) {
		contadorList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		if (columnIndex == CNPJ) {
			return String.class;
		}
		if (columnIndex == CPF) {
			return String.class;
		}
		if (columnIndex == CRC) {
			return String.class;
		}
		if (columnIndex == ID) {
			return Long.class;
		}
		if (columnIndex == NOME) {
			return String.class;
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return WIDTH.length;
	}

	@Override
	public String getColumnName(int columnIndex) {

		if (columnIndex == CNPJ) {
			return "CNPJ";
		}
		if (columnIndex == CPF) {
			return "CPF";
		}
		if (columnIndex == CRC) {
			return "CRC";
		}
		if (columnIndex == NOME) {
			return "NOME";
		}
		if (columnIndex == ID) {
			return "REGISTRO";
		}
		return null;
	}

	public Contador getContador(int linha) {
		if (contadorList.size() > 0) {
			return contadorList.get(linha);
		}
		return null;
	}

	public List<Contador> getContadorList() {
		return contadorList;
	}

	@Override
	public int getRowCount() {
		return contadorList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Contador contador = contadorList.get(rowIndex);

		if (columnIndex == CNPJ) {
			return contador.getCnpj();
		}
		if (columnIndex == CPF) {
			return contador.getCpf();
		}
		if (columnIndex == CRC) {
			return contador.getCrc();
		}
		if (columnIndex == ID) {
			return contador.getId();
		}
		if (columnIndex == NOME) {
			return contador.getNome();
		}
		return contador;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setContadorList(List<Contador> banco) {
		contadorList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		contador = contadorList.get(rowIndex);

		if (columnIndex == CNPJ) {
			contador.setCnpj(aValue.toString());
		}
		if (columnIndex == CPF) {
			contador.setCpf(aValue.toString());
		}
		if (columnIndex == CRC) {
			contador.setCrc(aValue.toString());
		}
		if (columnIndex == ID) {
			contador.setId(Long.parseLong(aValue.toString()));
		}
		if (columnIndex == NOME) {
			contador.setNome(aValue.toString());
		}
		fireTableDataChanged();
	}
}
