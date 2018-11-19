package erp.agenda.evento.tipoevento;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import erp.empresa.Empresa;

@SuppressWarnings("serial")
public class TipoEventoTableModel extends AbstractTableModel {

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
	private List<TipoEvento> agendaList = new LinkedList<>();
	private TipoEvento tipoEvento;

	public TipoEventoTableModel() {

	}

	public TipoEventoTableModel(List<TipoEvento> lista) {
		agendaList.addAll(lista);
	}

	public TipoEvento getAgenda(int linha) {
		if (agendaList.size() > 0) {
			return agendaList.get(linha);
		}
		return null;
	}

	public List<TipoEvento> getAgendaList() {
		return agendaList;
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
		return agendaList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TipoEvento tipoEvento = agendaList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			return tipoEvento.getBairro();
		case COL_CEP:
			return tipoEvento.getCep();
		case COL_CIDADE:
			return tipoEvento.getCidade();
		case COL_CNPJ:
			return tipoEvento.getCnpj();
		case COL_COMPLEMENTO:
			return tipoEvento.getComplemento();
		case COL_CPF_NUMERO:
			return tipoEvento.getCpfNumero();
		case COL_EMAIL:
			return tipoEvento.getEmail();
		case COL_EMPRESA:
			return tipoEvento.getEmpresa();
		case COL_ESTADO:
			return tipoEvento.getEstado();
		case COL_FAX:
			return tipoEvento.getFax();
		case COL_FONE1:
			return tipoEvento.getFone1();
		case COL_FONE2:
			return tipoEvento.getFone2();
		case ID:
			return tipoEvento.getId();
		case COL_LOGRADOURO:
			return tipoEvento.getLogradouro();
		case COL_NOME:
			return tipoEvento.getNome();
		case COL_PAIS:
			return tipoEvento.getPais();
		case COL_SALARIO:
			return tipoEvento.getSalario();
		case COL_SEXO:
			return tipoEvento.getSexo();
		default:
			return tipoEvento;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setAgendaList(List<TipoEvento> banco) {
		agendaList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		tipoEvento = agendaList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			tipoEvento.setBairro(aValue.toString());
			break;
		case COL_CEP:
			tipoEvento.setCep(aValue.toString());
			break;
		case COL_CIDADE:
			tipoEvento.setCidade(aValue.toString());
			break;
		case COL_CNPJ:
			tipoEvento.setCnpj(aValue.toString());
			break;
		case COL_COMPLEMENTO:
			tipoEvento.setComplemento(aValue.toString());
			break;
		case COL_CPF_NUMERO:
			tipoEvento.setCpfNumero(aValue.toString());
			break;
		case COL_EMAIL:
			tipoEvento.setEmail(aValue.toString());
			break;
		case COL_EMPRESA:
			tipoEvento.setEmpresa((Empresa) aValue);
			break;
		case COL_ESTADO:
			tipoEvento.setEstado(aValue.toString());
			break;
		case COL_FAX:
			tipoEvento.setFax(aValue.toString());
			break;
		case COL_FONE1:
			tipoEvento.setFone1(aValue.toString());
			break;
		case COL_FONE2:
			tipoEvento.setFone2(aValue.toString());
			break;
		case ID:
			tipoEvento.setId(Long.parseLong(aValue.toString()));
			break;
		case COL_LOGRADOURO:
			tipoEvento.setLogradouro(aValue.toString());
			break;
		case COL_NOME:
			tipoEvento.setNome(aValue.toString());
			break;
		case COL_PAIS:
			tipoEvento.setPais(aValue.toString());
			break;
		case COL_SALARIO:
			tipoEvento.setSalario(aValue.toString());
			break;
		case COL_SEXO:
			tipoEvento.setSexo(aValue.toString());
			break;
		}

		fireTableDataChanged();
	}
}
