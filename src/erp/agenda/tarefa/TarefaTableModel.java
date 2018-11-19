package erp.agenda.tarefa;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import erp.empresa.Empresa;

@SuppressWarnings("serial")
public class TarefaTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static final int COL_CNPJ = 1;
	public static final int COL_CPF_NUMERO = 2;
	public static final int COL_EMAIL = 3;
	public static final int COL_EMPRESA = 4;
	public static final int COL_FAX = 5;
	public static final int COL_FONE1 = 6;
	public static final int COL_FONE2 = 7;
	public static final int COL_NOME = 8;
	public static final int COL_PIS_NUMERO = 9;
	public static final int COL_SALARIO = 10;
	public static final int COL_SEXO = 11;
	public static final int COL_PAIS = 12;
	public static final int COL_ESTADO = 13;
	public static final int COL_CIDADE = 14;
	public static final int COL_BAIRRO = 15;
	public static final int COL_LOGRADOURO = 16;
	public static final int COL_COMPLEMENTO = 17;
	public static final int COL_CEP = 18;
	public static final int[] WIDTH = new int[] { 100, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500,
			500, 500, 500, 500, 500 };
	private final boolean[] podeEditar = new boolean[] { false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false };
	private List<Tarefa> tarefaList = new LinkedList<>();
	private Tarefa tarefa;

	public TarefaTableModel() {

	}

	public TarefaTableModel(List<Tarefa> lista) {
		tarefaList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case COL_BAIRRO:
			return String.class;
		case COL_CEP:
			return String.class;
		case COL_CIDADE:
			return String.class;
		case COL_CNPJ:
			return String.class;
		case COL_COMPLEMENTO:
			return String.class;
		case COL_CPF_NUMERO:
			return String.class;
		case COL_EMAIL:
			return String.class;
		case COL_EMPRESA:
			return Empresa.class;
		case COL_ESTADO:
			return String.class;
		case COL_FAX:
			return String.class;
		case COL_FONE1:
			return String.class;
		case COL_FONE2:
			return String.class;
		case ID:
			return Long.class;
		case COL_LOGRADOURO:
			return String.class;
		case COL_NOME:
			return String.class;
		case COL_PAIS:
			return String.class;
		case COL_SALARIO:
			return String.class;
		case COL_SEXO:
			return String.class;
		default:
			return String.class;
		}
	}

	@Override
	public int getColumnCount() {
		return WIDTH.length;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case ID:
			return "REGISTRO";
		case COL_CNPJ:
			return "CNPJ";
		case COL_CPF_NUMERO:
			return "CPF";
		case COL_EMAIL:
			return "EMAIL";
		case COL_EMPRESA:
			return "EMPRESA";
		case COL_ESTADO:
			return "ESTADO";
		case COL_FAX:
			return "FAX";
		case COL_FONE1:
			return "TELEFONE";
		case COL_FONE2:
			return "TELEFONE";
		case COL_NOME:
			return "NOME";
		case COL_PIS_NUMERO:
			return "PIS";
		case COL_SALARIO:
			return "SALÁRIO";
		case COL_SEXO:
			return "SEXO";
		case COL_PAIS:
			return "PAIS";
		case COL_CIDADE:
			return "CIDADE";
		case COL_BAIRRO:
			return "BAIRRO";
		case COL_LOGRADOURO:
			return "LOGRADOURO";
		case COL_COMPLEMENTO:
			return "COMPLEMENTO";
		case COL_CEP:
			return "CEP";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		return tarefaList.size();
	}

	public Tarefa getTarefa(int linha) {
		if (tarefaList.size() > 0) {
			return tarefaList.get(linha);
		}
		return null;
	}

	public List<Tarefa> getTarefaList() {
		return tarefaList;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Tarefa tarefa = tarefaList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			return tarefa.getBairro();
		case COL_CEP:
			return tarefa.getCep();
		case COL_CIDADE:
			return tarefa.getCidade();
		case COL_CNPJ:
			return tarefa.getCnpj();
		case COL_COMPLEMENTO:
			return tarefa.getComplemento();
		case COL_CPF_NUMERO:
			return tarefa.getCpfNumero();
		case COL_EMAIL:
			return tarefa.getEmail();
		case COL_EMPRESA:
			return tarefa.getEmpresa();
		case COL_ESTADO:
			return tarefa.getEstado();
		case COL_FAX:
			return tarefa.getFax();
		case COL_FONE1:
			return tarefa.getFone1();
		case COL_FONE2:
			return tarefa.getFone2();
		case ID:
			return tarefa.getId();
		case COL_LOGRADOURO:
			return tarefa.getLogradouro();
		case COL_NOME:
			return tarefa.getNome();
		case COL_PAIS:
			return tarefa.getPais();
		case COL_SALARIO:
			return tarefa.getSalario();
		case COL_SEXO:
			return tarefa.getSexo();
		default:
			return tarefa;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setTarefaList(List<Tarefa> banco) {
		tarefaList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		tarefa = tarefaList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			tarefa.setBairro(aValue.toString());
			break;
		case COL_CEP:
			tarefa.setCep(aValue.toString());
			break;
		case COL_CIDADE:
			tarefa.setCidade(aValue.toString());
			break;
		case COL_CNPJ:
			tarefa.setCnpj(aValue.toString());
			break;
		case COL_COMPLEMENTO:
			tarefa.setComplemento(aValue.toString());
			break;
		case COL_CPF_NUMERO:
			tarefa.setCpfNumero(aValue.toString());
			break;
		case COL_EMAIL:
			tarefa.setEmail(aValue.toString());
			break;
		case COL_EMPRESA:
			tarefa.setEmpresa((Empresa) aValue);
			break;
		case COL_ESTADO:
			tarefa.setEstado(aValue.toString());
			break;
		case COL_FAX:
			tarefa.setFax(aValue.toString());
			break;
		case COL_FONE1:
			tarefa.setFone1(aValue.toString());
			break;
		case COL_FONE2:
			tarefa.setFone2(aValue.toString());
			break;
		case ID:
			tarefa.setId(Long.parseLong(aValue.toString()));
			break;
		case COL_LOGRADOURO:
			tarefa.setLogradouro(aValue.toString());
			break;
		case COL_NOME:
			tarefa.setNome(aValue.toString());
			break;
		case COL_PAIS:
			tarefa.setPais(aValue.toString());
			break;
		case COL_SALARIO:
			tarefa.setSalario(aValue.toString());
			break;
		case COL_SEXO:
			tarefa.setSexo(aValue.toString());
			break;
		}

		fireTableDataChanged();
	}
}
