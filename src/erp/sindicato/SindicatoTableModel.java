package erp.sindicato;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class SindicatoTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static final int COL_CNPJ = 1;
	public static final int COL_NUMERO_DE_FUNCIONARIOS = 2;
	public static final int COL_INSCRICAO_ESTADUAL = 3;
	public static final int COL_INSCRICAO_MUNICIPAL = 4;
	public static final int COL_CPF_NUMERO = 5;
	public static final int COL_EMAIL = 6;
	public static final int COL_CAPITAL_SOCIAL = 7;
	public static final int COL_RAZAO_SOCIAL = 8;
	public static final int COL_FAX = 9;
	public static final int COL_FONE1 = 10;
	public static final int COL_FONE2 = 11;
	public static final int COL_NOME_FANTASIA = 12;
	public static final int COL_PIS_NUMERO = 13;
	public static final int COL_TIPO_DE_EMPRESA = 14;
	public static final int COL_FATURAMENTO_MENSAL = 15;
	public static final int COL_DATA_DE_FUNDACAO = 16;
	public static final int COL_RAMO_DE_ATIVIDADE = 17;
	public static final int COL_PAIS = 18;
	public static final int COL_ESTADO = 19;
	public static final int COL_CIDADE = 20;
	public static final int COL_BAIRRO = 21;
	public static final int COL_LOGRADOURO = 22;
	public static final int COL_COMPLEMENTO = 23;
	public static final int COL_CEP = 24;
	public static final int[] WIDTH = new int[] { 100, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500,
			500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500 };
	private final boolean[] podeEditar = new boolean[] { false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false };
	private List<Sindicato> sindicatosList = new LinkedList<>();
	private Sindicato sindicato;

	public SindicatoTableModel() {
	}

	public SindicatoTableModel(List<Sindicato> lista) {
		sindicatosList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case COL_BAIRRO:
			return String.class;
		case COL_INSCRICAO_ESTADUAL:
			return String.class;
		case COL_INSCRICAO_MUNICIPAL:
			return String.class;
		case COL_CEP:
			return String.class;
		case COL_CIDADE:
			return String.class;
		case COL_CNPJ:
			return String.class;
		case COL_COMPLEMENTO:
			return String.class;
		case COL_NUMERO_DE_FUNCIONARIOS:
			return String.class;
		case COL_CPF_NUMERO:
			return String.class;
		case COL_EMAIL:
			return String.class;
		case COL_CAPITAL_SOCIAL:
			return String.class;
		case COL_ESTADO:
			return String.class;
		case COL_RAZAO_SOCIAL:
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
		case COL_NOME_FANTASIA:
			return String.class;
		case COL_PAIS:
			return String.class;
		case COL_TIPO_DE_EMPRESA:
			return String.class;
		case COL_FATURAMENTO_MENSAL:
			return String.class;
		case COL_DATA_DE_FUNDACAO:
			return String.class;
		case COL_RAMO_DE_ATIVIDADE:
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
		case COL_NUMERO_DE_FUNCIONARIOS:
			return "NÚMERO DE FUNCIONÁRIOS";
		case COL_INSCRICAO_ESTADUAL:
			return "INSCRIÇÃO ESTADUAL";
		case COL_INSCRICAO_MUNICIPAL:
			return "INSCRIÇÃO MUNICIPAL";
		case COL_CPF_NUMERO:
			return "CPF";
		case COL_EMAIL:
			return "EMAIL";
		case COL_CAPITAL_SOCIAL:
			return "CAPITAL SOCIAL";
		case COL_ESTADO:
			return "ESTADO";
		case COL_RAZAO_SOCIAL:
			return "RAZÃO SOCIAL";
		case COL_FAX:
			return "FAX";
		case COL_FONE1:
			return "TELEFONE";
		case COL_FONE2:
			return "TELEFONE";
		case COL_NOME_FANTASIA:
			return "NOME FANTASIA";
		case COL_PIS_NUMERO:
			return "PIS";
		case COL_TIPO_DE_EMPRESA:
			return "TIPO DE EMPRESA";
		case COL_FATURAMENTO_MENSAL:
			return "FATURAMENTO MENSAL";
		case COL_DATA_DE_FUNDACAO:
			return "DATA DE FUNDAÇÃO";
		case COL_RAMO_DE_ATIVIDADE:
			return "RAMO DE ATIVIDADE";
		case COL_PAIS:
			return "PAÍS";
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
		return sindicatosList.size();
	}

	public Sindicato getSindicato(int linha) {
		if (sindicatosList.size() > 0) {
			return sindicatosList.get(linha);
		}
		return null;
	}

	public List<Sindicato> getSindicatoList() {
		return sindicatosList;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Sindicato sindicato = sindicatosList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			return sindicato.getBairro();
		case COL_INSCRICAO_ESTADUAL:
			return sindicato.getInscricaoEstadual();
		case COL_INSCRICAO_MUNICIPAL:
			return sindicato.getInscricaoMunicipal();
		case COL_CEP:
			return sindicato.getCep();
		case COL_CIDADE:
			return sindicato.getCidade();
		case COL_CNPJ:
			return sindicato.getCnpj();
		case COL_COMPLEMENTO:
			return sindicato.getComplemento();
		case COL_NUMERO_DE_FUNCIONARIOS:
			return sindicato.getNumeroFuncionarios();
		case COL_CPF_NUMERO:
			return sindicato.getCep();
		case COL_EMAIL:
			return sindicato.getEmail();
		case COL_CAPITAL_SOCIAL:
			return sindicato.getCapitalSocial();
		case COL_ESTADO:
			return sindicato.getEstado();
		case COL_RAZAO_SOCIAL:
			return sindicato.getRazaoSocial();
		case COL_FAX:
			return sindicato.getFax();
		case COL_FONE1:
			return sindicato.getFone1();
		case COL_FONE2:
			return sindicato.getFone2();
		case ID:
			return sindicato.getId();
		case COL_LOGRADOURO:
			return sindicato.getLogradouro();
		case COL_NOME_FANTASIA:
			return sindicato.getNomeFantasia();
		case COL_PAIS:
			return sindicato.getPais();
		case COL_TIPO_DE_EMPRESA:
			return sindicato.getTipoSindicato();
		case COL_FATURAMENTO_MENSAL:
			return sindicato.getFaturamentoMensal();
		case COL_DATA_DE_FUNDACAO:
			return sindicato.getDataFundacao();
		case COL_RAMO_DE_ATIVIDADE:
			return sindicato.getRamoAtividade();
		default:
			return sindicato;
		}

	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setSindicatoList(List<Sindicato> banco) {
		sindicatosList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		sindicato = sindicatosList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			sindicato.setBairro(aValue.toString());
			break;
		case COL_INSCRICAO_ESTADUAL:
			sindicato.setInscricaoEstadual(aValue.toString());
			break;
		case COL_INSCRICAO_MUNICIPAL:
			sindicato.setInscricaoMunicipal(aValue.toString());
			break;
		case COL_CEP:
			sindicato.setCep(aValue.toString());
			break;
		case COL_CIDADE:
			sindicato.setCidade(aValue.toString());
			break;
		case COL_CNPJ:
			sindicato.setCnpj(aValue.toString());
			break;
		case COL_COMPLEMENTO:
			sindicato.setComplemento(aValue.toString());
			break;
		case COL_NUMERO_DE_FUNCIONARIOS:
			sindicato.setNumeroFuncionarios(aValue.toString());
			break;
		case COL_CPF_NUMERO:
			sindicato.setCnpj(aValue.toString());
			break;
		case COL_EMAIL:
			sindicato.setEmail(aValue.toString());
			break;
		case COL_CAPITAL_SOCIAL:
			sindicato.setCapitalSocial(aValue.toString());
			break;
		case COL_ESTADO:
			sindicato.setEstado(aValue.toString());
			break;
		case COL_RAZAO_SOCIAL:
			sindicato.setRazaoSocial(aValue.toString());
			break;
		case COL_FAX:
			sindicato.setFax(aValue.toString());
			break;
		case COL_FONE1:
			sindicato.setFone1(aValue.toString());
			break;
		case COL_FONE2:
			sindicato.setFone2(aValue.toString());
			break;
		case ID:
			sindicato.setId(Long.parseLong(aValue.toString()));
			break;
		case COL_LOGRADOURO:
			sindicato.setLogradouro(aValue.toString());
			break;
		case COL_NOME_FANTASIA:
			sindicato.setNomeFantasia(aValue.toString());
			break;
		case COL_PAIS:
			sindicato.setPais(aValue.toString());
			break;
		case COL_TIPO_DE_EMPRESA:
			sindicato.setTipoSindicato(aValue.toString());
			break;
		case COL_FATURAMENTO_MENSAL:
			sindicato.setFaturamentoMensal(aValue.toString());
			break;
		case COL_DATA_DE_FUNDACAO:
			sindicato.setDataFundacao(aValue.toString());
			break;
		case COL_RAMO_DE_ATIVIDADE:
			sindicato.setRamoAtividade(aValue.toString());
			break;
		}
		fireTableDataChanged();
	}
}
