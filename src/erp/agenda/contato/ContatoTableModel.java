package erp.agenda.contato;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import erp.empresa.Empresa;

@SuppressWarnings("serial")
public class ContatoTableModel extends AbstractTableModel {

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
	private List<Contato> recadoList = new LinkedList<>();
	private Contato contato;

	public ContatoTableModel() {

	}

	public ContatoTableModel(List<Contato> lista) {
		recadoList.addAll(lista);
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

	public Contato getContato(int linha) {
		if (recadoList.size() > 0) {
			return recadoList.get(linha);
		}
		return null;
	}

	public List<Contato> getContatoList() {
		return recadoList;
	}

	@Override
	public int getRowCount() {
		return recadoList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Contato contato = recadoList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			return contato.getBairro();
		case COL_CEP:
			return contato.getCep();
		case COL_CIDADE:
			return contato.getCidade();
		case COL_CNPJ:
			return contato.getCnpj();
		case COL_COMPLEMENTO:
			return contato.getComplemento();
		case COL_CPF_NUMERO:
			return contato.getCpfNumero();
		case COL_EMAIL:
			return contato.getEmail();
		case COL_EMPRESA:
			return contato.getEmpresa();
		case COL_ESTADO:
			return contato.getEstado();
		case COL_FAX:
			return contato.getFax();
		case COL_FONE1:
			return contato.getFone1();
		case COL_FONE2:
			return contato.getFone2();
		case ID:
			return contato.getId();
		case COL_LOGRADOURO:
			return contato.getLogradouro();
		case COL_NOME:
			return contato.getNome();
		case COL_PAIS:
			return contato.getPais();
		case COL_SALARIO:
			return contato.getSalario();
		case COL_SEXO:
			return contato.getSexo();
		default:
			return contato;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setContatoList(List<Contato> banco) {
		recadoList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		contato = recadoList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			contato.setBairro(aValue.toString());
			break;
		case COL_CEP:
			contato.setCep(aValue.toString());
			break;
		case COL_CIDADE:
			contato.setCidade(aValue.toString());
			break;
		case COL_CNPJ:
			contato.setCnpj(aValue.toString());
			break;
		case COL_COMPLEMENTO:
			contato.setComplemento(aValue.toString());
			break;
		case COL_CPF_NUMERO:
			contato.setCpfNumero(aValue.toString());
			break;
		case COL_EMAIL:
			contato.setEmail(aValue.toString());
			break;
		case COL_EMPRESA:
			contato.setEmpresa((Empresa) aValue);
			break;
		case COL_ESTADO:
			contato.setEstado(aValue.toString());
			break;
		case COL_FAX:
			contato.setFax(aValue.toString());
			break;
		case COL_FONE1:
			contato.setFone1(aValue.toString());
			break;
		case COL_FONE2:
			contato.setFone2(aValue.toString());
			break;
		case ID:
			contato.setId(Long.parseLong(aValue.toString()));
			break;
		case COL_LOGRADOURO:
			contato.setLogradouro(aValue.toString());
			break;
		case COL_NOME:
			contato.setNome(aValue.toString());
			break;
		case COL_PAIS:
			contato.setPais(aValue.toString());
			break;
		case COL_SALARIO:
			contato.setSalario(aValue.toString());
			break;
		case COL_SEXO:
			contato.setSexo(aValue.toString());
			break;
		}

		fireTableDataChanged();
	}
}
