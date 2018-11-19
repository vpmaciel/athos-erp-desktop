package erp.fornecedor;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class FornecedorTableModel extends AbstractTableModel {

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

	private List<Fornecedor> fornecedorsList = new LinkedList<>();
	private Fornecedor fornecedor;

	public FornecedorTableModel() {
	}

	public FornecedorTableModel(List<Fornecedor> lista) {
		fornecedorsList.addAll(lista);
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

	public Fornecedor getFornecedor(int linha) {
		if (fornecedorsList.size() > 0) {
			return fornecedorsList.get(linha);
		}
		return null;
	}

	public List<Fornecedor> getFornecedorList() {
		return fornecedorsList;
	}

	@Override
	public int getRowCount() {
		return fornecedorsList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Fornecedor fornecedor = fornecedorsList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			return fornecedor.getBairro();
		case COL_INSCRICAO_ESTADUAL:
			return fornecedor.getInscricaoEstadual();
		case COL_INSCRICAO_MUNICIPAL:
			return fornecedor.getInscricaoMunicipal();
		case COL_CEP:
			return fornecedor.getCep();
		case COL_CIDADE:
			return fornecedor.getCidade();
		case COL_CNPJ:
			return fornecedor.getCnpj();
		case COL_COMPLEMENTO:
			return fornecedor.getComplemento();
		case COL_NUMERO_DE_FUNCIONARIOS:
			return fornecedor.getNumeroFuncionarios();
		case COL_CPF_NUMERO:
			return fornecedor.getCpfNumero();
		case COL_EMAIL:
			return fornecedor.getEmail();
		case COL_CAPITAL_SOCIAL:
			return fornecedor.getCapitalSocial();
		case COL_ESTADO:
			return fornecedor.getEstado();
		case COL_RAZAO_SOCIAL:
			return fornecedor.getRazaoSocial();
		case COL_FAX:
			return fornecedor.getFax();
		case COL_FONE1:
			return fornecedor.getFone1();
		case COL_FONE2:
			return fornecedor.getFone2();
		case ID:
			return fornecedor.getId();
		case COL_LOGRADOURO:
			return fornecedor.getLogradouro();
		case COL_NOME_FANTASIA:
			return fornecedor.getNomeFantasia();
		case COL_PAIS:
			return fornecedor.getPais();
		case COL_TIPO_DE_EMPRESA:
			return fornecedor.getTipoEmpresa();
		case COL_FATURAMENTO_MENSAL:
			return fornecedor.getFaturamentoMensal();
		case COL_DATA_DE_FUNDACAO:
			return fornecedor.getDataFundacao();
		case COL_RAMO_DE_ATIVIDADE:
			return fornecedor.getRamoAtividade();
		default:
			return fornecedor;
		}

	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setFornecedorList(List<Fornecedor> banco) {
		fornecedorsList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		fornecedor = fornecedorsList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			fornecedor.setBairro(aValue.toString());
			break;
		case COL_INSCRICAO_ESTADUAL:
			fornecedor.setInscricaoEstadual(aValue.toString());
			break;
		case COL_INSCRICAO_MUNICIPAL:
			fornecedor.setInscricaoMunicipal(aValue.toString());
			break;
		case COL_CEP:
			fornecedor.setCep(aValue.toString());
			break;
		case COL_CIDADE:
			fornecedor.setCidade(aValue.toString());
			break;
		case COL_CNPJ:
			fornecedor.setCnpj(aValue.toString());
			break;
		case COL_COMPLEMENTO:
			fornecedor.setComplemento(aValue.toString());
			break;
		case COL_NUMERO_DE_FUNCIONARIOS:
			fornecedor.setNumeroFuncionarios(aValue.toString());
			break;
		case COL_CPF_NUMERO:
			fornecedor.setCpfNumero(aValue.toString());
			break;
		case COL_EMAIL:
			fornecedor.setEmail(aValue.toString());
			break;
		case COL_CAPITAL_SOCIAL:
			fornecedor.setCapitalSocial(aValue.toString());
			break;
		case COL_ESTADO:
			fornecedor.setEstado(aValue.toString());
			break;
		case COL_RAZAO_SOCIAL:
			fornecedor.setRazaoSocial(aValue.toString());
			break;
		case COL_FAX:
			fornecedor.setFax(aValue.toString());
			break;
		case COL_FONE1:
			fornecedor.setFone1(aValue.toString());
			break;
		case COL_FONE2:
			fornecedor.setFone2(aValue.toString());
			break;
		case ID:
			fornecedor.setId(Long.parseLong(aValue.toString()));
			break;
		case COL_LOGRADOURO:
			fornecedor.setLogradouro(aValue.toString());
			break;
		case COL_NOME_FANTASIA:
			fornecedor.setNomeFantasia(aValue.toString());
			break;
		case COL_PAIS:
			fornecedor.setPais(aValue.toString());
			break;
		case COL_TIPO_DE_EMPRESA:
			fornecedor.setTipoEmpresa(aValue.toString());
			break;
		case COL_FATURAMENTO_MENSAL:
			fornecedor.setFaturamentoMensal(aValue.toString());
			break;
		case COL_DATA_DE_FUNDACAO:
			fornecedor.setDataFundacao(aValue.toString());
			break;
		case COL_RAMO_DE_ATIVIDADE:
			fornecedor.setRamoAtividade(aValue.toString());
			break;
		}
		fireTableDataChanged();
	}
}
