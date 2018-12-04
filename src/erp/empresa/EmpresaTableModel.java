package erp.empresa;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class EmpresaTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static final int CNPJ = 1;
	public static final int NUMERO_DE_FUNCIONARIOS = 2;
	public static final int INSCRICAO_ESTADUAL = 3;
	public static final int INSCRICAO_MUNICIPAL = 4;
	public static final int CPF_NUMERO = 5;
	public static final int EMAIL = 6;
	public static final int CAPITAL_SOCIAL = 7;
	public static final int RAZAO_SOCIAL = 8;
	public static final int FAX = 9;
	public static final int FONE1 = 10;
	public static final int FONE2 = 11;
	public static final int NOME_FANTASIA = 12;
	public static final int TIPO_DE_EMPRESA = 13;
	public static final int FATURAMENTO_MENSAL = 14;
	public static final int DATA_DE_FUNDACAO = 15;
	public static final int RAMO_DE_ATIVIDADE = 16;
	public static final int PAIS = 17;
	public static final int ESTADO = 18;
	public static final int CIDADE = 19;
	public static final int BAIRRO = 20;
	public static final int LOGRADOURO = 21;
	public static final int COMPLEMENTO = 22;
	public static final int CEP = 23;
	public static final int[] WIDTH = new int[] { 100, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600,
			600, 600, 600, 600, 600, 600, 600, 600, 600, 600 };
	private final boolean[] podeEditar = new boolean[] { false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false };
	private List<Empresa> empresasList = new LinkedList<>();
	private Empresa empresa;

	public EmpresaTableModel() {
	}

	public EmpresaTableModel(List<Empresa> lista) {
		empresasList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == BAIRRO) {
			return String.class;
		}
		if (columnIndex == INSCRICAO_ESTADUAL) {
			return String.class;
		}
		if (columnIndex == INSCRICAO_MUNICIPAL) {
			return String.class;
		}
		if (columnIndex == CEP) {
			return String.class;
		}
		if (columnIndex == CIDADE) {
			return String.class;
		}
		if (columnIndex == CNPJ) {
			return String.class;
		}
		if (columnIndex == COMPLEMENTO) {
			return String.class;
		}
		if (columnIndex == NUMERO_DE_FUNCIONARIOS) {
			return String.class;
		}
		if (columnIndex == CPF_NUMERO) {
			return String.class;
		}
		if (columnIndex == EMAIL) {
			return String.class;
		}
		if (columnIndex == CAPITAL_SOCIAL) {
			return String.class;
		}
		if (columnIndex == ESTADO) {
			return String.class;
		}
		if (columnIndex == RAZAO_SOCIAL) {
			return String.class;
		}
		if (columnIndex == FAX) {
			return String.class;
		}
		if (columnIndex == FONE1) {
			return String.class;
		}
		if (columnIndex == FONE2) {
			return String.class;
		}
		if (columnIndex == ID) {
			return Long.class;
		}
		if (columnIndex == LOGRADOURO) {
			return String.class;
		}
		if (columnIndex == NOME_FANTASIA) {
			return String.class;
		}
		if (columnIndex == PAIS) {
			return String.class;
		}
		if (columnIndex == TIPO_DE_EMPRESA) {
			return String.class;
		}
		if (columnIndex == FATURAMENTO_MENSAL) {
			return String.class;
		}
		if (columnIndex == DATA_DE_FUNDACAO) {
			return String.class;
		}
		if (columnIndex == RAMO_DE_ATIVIDADE) {
			return String.class;
		}
		JOptionPane.showMessageDialog(null, columnIndex);
		return null;
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
		if (columnIndex == NUMERO_DE_FUNCIONARIOS) {
			return "NÚMERO DE FUNCIONÁRIOS";
		}
		if (columnIndex == INSCRICAO_ESTADUAL) {
			return "INSCRIÇÃO ESTADUAL";
		}
		if (columnIndex == INSCRICAO_MUNICIPAL) {
			return "INSCRIÇÃO MUNICIPAL";
		}
		if (columnIndex == CPF_NUMERO) {
			return "CPF";
		}
		if (columnIndex == EMAIL) {
			return "EMAIL";
		}
		if (columnIndex == CAPITAL_SOCIAL) {
			return "CAPITAL SOCIAL";
		}
		if (columnIndex == ESTADO) {
			return "ESTADO";
		}
		if (columnIndex == RAZAO_SOCIAL) {
			return "RAZÃO SOCIAL";
		}
		if (columnIndex == FAX) {
			return "FAX";
		}
		if (columnIndex == FONE1) {
			return "TELEFONE";
		}
		if (columnIndex == FONE2) {
			return "TELEFONE";
		}
		if (columnIndex == NOME_FANTASIA) {
			return "NOME FANTASIA";
		}
		if (columnIndex == TIPO_DE_EMPRESA) {
			return "TIPO DE EMPRESA";
		}
		if (columnIndex == FATURAMENTO_MENSAL) {
			return "FATURAMENTO MENSAL";
		}
		if (columnIndex == DATA_DE_FUNDACAO) {
			return "DATA DE FUNDAÇÃO";
		}
		if (columnIndex == RAMO_DE_ATIVIDADE) {
			return "RAMO DE ATIVIDADE";
		}
		if (columnIndex == PAIS) {
			return "PAÍS";
		}
		if (columnIndex == CIDADE) {
			return "CIDADE";
		}
		if (columnIndex == BAIRRO) {
			return "BAIRRO";
		}
		if (columnIndex == LOGRADOURO) {
			return "LOGRADOURO";
		}
		if (columnIndex == COMPLEMENTO) {
			return "COMPLEMENTO";
		}
		if (columnIndex == CEP) {
			return "CEP";
		}
		JOptionPane.showMessageDialog(null, columnIndex);
		return null;
	}

	public Empresa getEmpresa(int linha) {
		if (empresasList.size() > 0) {
			return empresasList.get(linha);
		}
		return null;
	}

	public List<Empresa> getEmpresaList() {
		return empresasList;
	}

	@Override
	public int getRowCount() {
		return empresasList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Empresa empresa = empresasList.get(rowIndex);

		if (columnIndex == BAIRRO) {
			return empresa.getBairro();
		}
		if (columnIndex == INSCRICAO_ESTADUAL) {
			return empresa.getInscricaoEstadual();
		}
		if (columnIndex == INSCRICAO_MUNICIPAL) {
			return empresa.getInscricaoMunicipal();
		}
		if (columnIndex == CEP) {
			return empresa.getCep();
		}
		if (columnIndex == CIDADE) {
			return empresa.getCidade();
		}
		if (columnIndex == CNPJ) {
			return empresa.getCnpj();
		}
		if (columnIndex == COMPLEMENTO) {
			return empresa.getComplemento();
		}
		if (columnIndex == NUMERO_DE_FUNCIONARIOS) {
			return empresa.getNumeroFuncionarios();
		}
		if (columnIndex == EMAIL) {
			return empresa.getEmail();
		}
		if (columnIndex == CAPITAL_SOCIAL) {
			return empresa.getCapitalSocial();
		}
		if (columnIndex == ESTADO) {
			return empresa.getEstado();
		}
		if (columnIndex == RAZAO_SOCIAL) {
			return empresa.getRazaoSocial();
		}
		if (columnIndex == FAX) {
			return empresa.getFax();
		}
		if (columnIndex == FONE1) {
			return empresa.getFone1();
		}
		if (columnIndex == FONE2) {
			return empresa.getFone2();
		}
		if (columnIndex == ID) {
			return empresa.getId();
		}
		if (columnIndex == LOGRADOURO) {
			return empresa.getLogradouro();
		}
		if (columnIndex == NOME_FANTASIA) {
			return empresa.getNomeFantasia();
		}
		if (columnIndex == PAIS) {
			return empresa.getPais();
		}
		if (columnIndex == TIPO_DE_EMPRESA) {
			return empresa.getTipoEmpresa();
		}
		if (columnIndex == FATURAMENTO_MENSAL) {
			return empresa.getFaturamentoMensal();
		}
		if (columnIndex == DATA_DE_FUNDACAO) {
			return empresa.getDataFundacao();
		}
		if (columnIndex == RAMO_DE_ATIVIDADE) {
			return empresa.getRamoAtividade();
		}
		return empresa;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setEmpresaList(List<Empresa> banco) {
		empresasList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		empresa = empresasList.get(rowIndex);

		if (columnIndex == BAIRRO) {
			empresa.setBairro(aValue.toString());
		}
		if (columnIndex == INSCRICAO_ESTADUAL) {
			empresa.setInscricaoEstadual(aValue.toString());
		}
		if (columnIndex == INSCRICAO_MUNICIPAL) {
			empresa.setInscricaoMunicipal(aValue.toString());
		}
		if (columnIndex == CEP) {
			empresa.setCep(aValue.toString());
		}
		if (columnIndex == CIDADE) {
			empresa.setCidade(aValue.toString());
		}
		if (columnIndex == CNPJ) {
			empresa.setCnpj(aValue.toString());
		}
		if (columnIndex == COMPLEMENTO) {
			empresa.setComplemento(aValue.toString());
		}
		if (columnIndex == NUMERO_DE_FUNCIONARIOS) {
			empresa.setNumeroFuncionarios(aValue.toString());
		}
		if (columnIndex == EMAIL) {
			empresa.setEmail(aValue.toString());
		}
		if (columnIndex == CAPITAL_SOCIAL) {
			empresa.setCapitalSocial(aValue.toString());
		}
		if (columnIndex == ESTADO) {
			empresa.setEstado(aValue.toString());
		}
		if (columnIndex == RAZAO_SOCIAL) {
			empresa.setRazaoSocial(aValue.toString());
		}
		if (columnIndex == FAX) {
			empresa.setFax(aValue.toString());
		}
		if (columnIndex == FONE1) {
			empresa.setFone1(aValue.toString());
		}
		if (columnIndex == FONE2) {
			empresa.setFone2(aValue.toString());
		}
		if (columnIndex == ID) {
			empresa.setId(Long.parseLong(aValue.toString()));
		}
		if (columnIndex == LOGRADOURO) {
			empresa.setLogradouro(aValue.toString());
		}
		if (columnIndex == NOME_FANTASIA) {
			empresa.setNomeFantasia(aValue.toString());
		}
		if (columnIndex == PAIS) {
			empresa.setPais(aValue.toString());
		}
		if (columnIndex == TIPO_DE_EMPRESA) {
			empresa.setTipoEmpresa(aValue.toString());
		}
		if (columnIndex == FATURAMENTO_MENSAL) {
			empresa.setFaturamentoMensal(aValue.toString());
		}
		if (columnIndex == DATA_DE_FUNDACAO) {
			empresa.setDataFundacao(aValue.toString());
		}
		if (columnIndex == RAMO_DE_ATIVIDADE) {
			empresa.setRamoAtividade(aValue.toString());
		}

		fireTableDataChanged();
	}
}
