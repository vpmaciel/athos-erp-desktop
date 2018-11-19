package erp.funcionario;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import erp.centrocusto.CentroCusto;

@SuppressWarnings("serial")
public class FuncionarioTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static final int COL_CNPJ = 1;
	public static final int COL_CONJUGE = 2;
	public static final int COL_CARGO = 3;
	public static final int COL_CATEGORIA = 4;
	public static final int COL_CENTRO_DE_CUSTO = 5;
	public static final int COL_CNH_CATEGORIA = 6;
	public static final int COL_CPF_NUMERO = 7;
	public static final int COL_CTPS_NUMERO = 8;
	public static final int COL_DEPARTAMENTO = 9;
	public static final int COL_EMAIL = 10;
	public static final int COL_EMPRESA = 11;
	public static final int COL_ESTADOCIVIL = 12;
	public static final int COL_FAX = 13;
	public static final int COL_FILHOS = 14;
	public static final int COL_FONE1 = 15;
	public static final int COL_FONE2 = 16;
	public static final int COL_GERENTE = 17;
	public static final int COL_MATRICULA = 18;
	public static final int COL_NOME = 19;
	public static final int COL_PIS_NUMERO = 20;
	public static final int COL_RG_NUMERO = 21;
	public static final int COL_RG_ORGAOEMISSOR = 22;
	public static final int COL_SALARIO = 23;
	public static final int COL_SEXO = 24;
	public static final int COL_TURNO = 25;
	public static final int COL_PAIS = 26;
	public static final int COL_ESTADO = 27;
	public static final int COL_CIDADE = 28;
	public static final int COL_BAIRRO = 29;
	public static final int COL_LOGRADOURO = 30;
	public static final int COL_COMPLEMENTO = 31;
	public static final int COL_CEP = 32;
	public static final int[] WIDTH = new int[] { 100, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500,
			500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500 };
	private final boolean[] podeEditar = new boolean[] { false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false };
	private List<Funcionario> funcionariosList = new LinkedList<>();
	private Funcionario funcionario;

	public FuncionarioTableModel() {
	}

	public FuncionarioTableModel(List<Funcionario> lista) {
		funcionariosList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case COL_BAIRRO:
			return String.class;
		case COL_CARGO:
			return String.class;
		case COL_CATEGORIA:
			return String.class;
		case COL_CENTRO_DE_CUSTO:
			return CentroCusto.class;
		case COL_CEP:
			return String.class;
		case COL_CIDADE:
			return String.class;
		case COL_CNH_CATEGORIA:
			return String.class;
		case COL_CNPJ:
			return String.class;
		case COL_COMPLEMENTO:
			return String.class;
		case COL_CONJUGE:
			return String.class;
		case COL_CPF_NUMERO:
			return String.class;
		case COL_DEPARTAMENTO:
			return String.class;
		case COL_EMAIL:
			return String.class;
		case COL_EMPRESA:
			return String.class;
		case COL_ESTADO:
			return String.class;
		case COL_ESTADOCIVIL:
			return String.class;
		case COL_FAX:
			return String.class;
		case COL_FILHOS:
			return String.class;
		case COL_FONE1:
			return String.class;
		case COL_FONE2:
			return String.class;
		case COL_GERENTE:
			return String.class;
		case ID:
			return Long.class;
		case COL_LOGRADOURO:
			return String.class;
		case COL_MATRICULA:
			return String.class;
		case COL_NOME:
			return String.class;
		case COL_PAIS:
			return String.class;
		case COL_PIS_NUMERO:
			return String.class;
		case COL_RG_NUMERO:
			return String.class;
		case COL_RG_ORGAOEMISSOR:
			return String.class;
		case COL_SALARIO:
			return String.class;
		case COL_SEXO:
			return String.class;
		case COL_TURNO:
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
		case COL_CONJUGE:
			return "CÔNJUGE";
		case COL_CARGO:
			return "CARGO";
		case COL_CATEGORIA:
			return "CATEGORIA";
		case COL_CENTRO_DE_CUSTO:
			return "CENTRO DE CUSTO";
		case COL_CNH_CATEGORIA:
			return "CNH";
		case COL_CPF_NUMERO:
			return "CPF";
		case COL_CTPS_NUMERO:
			return "CTPS";
		case COL_DEPARTAMENTO:
			return "DEPARTAMENTO";
		case COL_EMAIL:
			return "EMAIL";
		case COL_EMPRESA:
			return "EMPRESA";
		case COL_ESTADO:
			return "ESTADO";
		case COL_ESTADOCIVIL:
			return "ESTADO CIVIL";
		case COL_FAX:
			return "FAX";
		case COL_FILHOS:
			return "FILHOS";
		case COL_FONE1:
			return "TELEFONE";
		case COL_FONE2:
			return "TELEFONE";
		case COL_GERENTE:
			return "GERENTE";
		case COL_MATRICULA:
			return "MATRÍCULA";
		case COL_NOME:
			return "NOME";
		case COL_PIS_NUMERO:
			return "PIS";
		case COL_RG_NUMERO:
			return "IDENTIDADE NÚMERO";
		case COL_RG_ORGAOEMISSOR:
			return "IDENTIDADE ÓRGÃO EMISSOR";
		case COL_SALARIO:
			return "SALÁRIO";
		case COL_SEXO:
			return "SEXO";
		case COL_TURNO:
			return "TURNO";
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

	public Funcionario getFuncionario(int linha) {
		if (funcionariosList.size() > 0) {
			return funcionariosList.get(linha);
		}
		return null;
	}

	public List<Funcionario> getFuncionarioList() {
		return funcionariosList;
	}

	@Override
	public int getRowCount() {
		return funcionariosList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Funcionario funcionario = funcionariosList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			return funcionario.getBairro();
		case COL_CARGO:
			return funcionario.getCargo();
		case COL_CATEGORIA:
			return funcionario.getCategoria();
		case COL_CENTRO_DE_CUSTO:
			return funcionario.getCentroCusto();
		case COL_CEP:
			return funcionario.getCep();
		case COL_CIDADE:
			return funcionario.getCidade();
		case COL_CNH_CATEGORIA:
			return funcionario.getCnhCategoria();
		case COL_CNPJ:
			return funcionario.getCnpj();
		case COL_COMPLEMENTO:
			return funcionario.getComplemento();
		case COL_CONJUGE:
			return funcionario.getConjuge();
		case COL_CPF_NUMERO:
			return funcionario.getCpfNumero();
		case COL_CTPS_NUMERO:
			return funcionario.getCtpsNumero();
		case COL_DEPARTAMENTO:
			return funcionario.getDepartamento();
		case COL_EMAIL:
			return funcionario.getEmail();
		case COL_EMPRESA:
			return funcionario.getEmpresa();
		case COL_ESTADO:
			return funcionario.getEstado();
		case COL_ESTADOCIVIL:
			return funcionario.getEstadoCivil();
		case COL_FAX:
			return funcionario.getFax();
		case COL_FILHOS:
			return funcionario.getFilhos();
		case COL_FONE1:
			return funcionario.getFone1();
		case COL_FONE2:
			return funcionario.getFone2();
		case COL_GERENTE:
			return funcionario.getGerente();
		case ID:
			return funcionario.getId();
		case COL_LOGRADOURO:
			return funcionario.getLogradouro();
		case COL_MATRICULA:
			return funcionario.getMatricula();
		case COL_NOME:
			return funcionario.getNome();
		case COL_PAIS:
			return funcionario.getPais();
		case COL_PIS_NUMERO:
			return funcionario.getPisNumero();
		case COL_RG_NUMERO:
			return funcionario.getRgNumero();
		case COL_RG_ORGAOEMISSOR:
			return funcionario.getRgOrgaoEmissor();
		case COL_SALARIO:
			return funcionario.getSalario();
		case COL_SEXO:
			return funcionario.getSexo();
		case COL_TURNO:
			return funcionario.getTurno();
		default:
			return funcionario;
		}

	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setFuncionarioList(List<Funcionario> banco) {
		funcionariosList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		funcionario = funcionariosList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			funcionario.setBairro(aValue.toString());
			break;
		case COL_CARGO:
			funcionario.setCargo(aValue.toString());
			break;
		case COL_CATEGORIA:
			funcionario.setCategoria(aValue.toString());
			break;
		case COL_CENTRO_DE_CUSTO:
			funcionario.setCentroDeCusto((CentroCusto) aValue);
			break;
		case COL_CEP:
			funcionario.setCep(aValue.toString());
			break;
		case COL_CIDADE:
			funcionario.setCidade(aValue.toString());
			break;
		case COL_CNH_CATEGORIA:
			funcionario.setCnhCategoria(aValue.toString());
			break;
		case COL_CNPJ:
			funcionario.setCnpj(aValue.toString());
			break;
		case COL_COMPLEMENTO:
			funcionario.setComplemento(aValue.toString());
			break;
		case COL_CONJUGE:
			funcionario.setConjuge(aValue.toString());
			break;
		case COL_CPF_NUMERO:
			funcionario.setCpfNumero(aValue.toString());
			break;
		case COL_CTPS_NUMERO:
			funcionario.setCtpsNumero(aValue.toString());
			break;
		case COL_DEPARTAMENTO:
			funcionario.setDepartamento(aValue.toString());
			break;
		case COL_EMAIL:
			funcionario.setEmail(aValue.toString());
			break;
		case COL_EMPRESA:
			funcionario.setEmpresa(aValue.toString());
			break;
		case COL_ESTADO:
			funcionario.setEstado(aValue.toString());
			break;
		case COL_ESTADOCIVIL:
			funcionario.setEstadoCivil(aValue.toString());
			break;
		case COL_FAX:
			funcionario.setFax(aValue.toString());
			break;
		case COL_FILHOS:
			funcionario.setFilhos(aValue.toString());
			break;
		case COL_FONE1:
			funcionario.setFone1(aValue.toString());
			break;
		case COL_FONE2:
			funcionario.setFone2(aValue.toString());
			break;
		case COL_GERENTE:
			funcionario.setGerente(aValue.toString());
			break;
		case ID:
			funcionario.setId(Long.parseLong(aValue.toString()));
			break;
		case COL_LOGRADOURO:
			funcionario.setLogradouro(aValue.toString());
			break;
		case COL_MATRICULA:
			funcionario.setMatricula(aValue.toString());
			break;
		case COL_NOME:
			funcionario.setNome(aValue.toString());
			break;
		case COL_PAIS:
			funcionario.setPais(aValue.toString());
			break;
		case COL_PIS_NUMERO:
			funcionario.setPisNumero(aValue.toString());
			break;
		case COL_RG_NUMERO:
			funcionario.setRgNumero(aValue.toString());
			break;
		case COL_RG_ORGAOEMISSOR:
			funcionario.setRgOrgaoEmissor(aValue.toString());
			break;
		case COL_SALARIO:
			funcionario.setSalario(aValue.toString());
			break;
		case COL_SEXO:
			funcionario.setSexo(aValue.toString());
			break;
		case COL_TURNO:
			funcionario.setTurno(aValue.toString());
			break;
		}
		fireTableDataChanged();
	}
}
