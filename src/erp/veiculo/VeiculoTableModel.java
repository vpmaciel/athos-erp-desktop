package erp.veiculo;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class VeiculoTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static final int COL_DATA_COMPRA = 1;
	public static final int COL_PROPRIETARIO_ANTERIOR_CNPJ = 2;
	public static final int COL_ANO_MODELO = 3;
	public static final int COL_CHASSI_REMARCADO = 4;
	public static final int COL_CILINDRADA = 5;
	public static final int COL_COR = 6;
	public static final int COL_PROPRIETARIO_ANTERIOR_CPF = 7;
	public static final int COL_PROPRIETARIO_ANTERIOR_NOME = 8;
	public static final int COL_PROPRIETARIO_CNPJ = 9;
	public static final int COL_PROPRIETARIO_CPF = 10;
	public static final int COL_PROPRIETARIO_NOME = 11;
	public static final int COL_TIPO = 12;
	public static final int COL_VALOR_COMPRA = 13;
	public static final int COL_VALOR_VENDA = 14;
	public static final int COL_RENAVAM = 15;
	public static final int COL_COMBUSTIVEL = 16;
	public static final int COL_ANO_DE_FABRICACAO = 17;
	public static final int COL_DATA_VENDA = 18;
	public static final int COL_CMT_TON = 19;
	public static final int[] WIDTH = new int[] { 100, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500,
			500, 500, 500, 500, 500, 500 };
	private final boolean[] podeEditar = new boolean[] { false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false };
	private List<Veiculo> veiculosList = new LinkedList<>();
	private Veiculo veiculo;

	public VeiculoTableModel() {
	}

	public VeiculoTableModel(List<Veiculo> lista) {
		veiculosList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case COL_ANO_DE_FABRICACAO:
			return String.class;
		case COL_ANO_MODELO:
			return String.class;
		case COL_CHASSI_REMARCADO:
			return String.class;
		case COL_CILINDRADA:
			return String.class;
		case COL_CMT_TON:
			return String.class;
		case COL_COMBUSTIVEL:
			return String.class;
		case COL_COR:
			return String.class;
		case COL_DATA_COMPRA:
			return String.class;
		case COL_DATA_VENDA:
			return String.class;
		case COL_PROPRIETARIO_ANTERIOR_CNPJ:
			return String.class;
		case COL_PROPRIETARIO_ANTERIOR_CPF:
			return String.class;
		case COL_PROPRIETARIO_CNPJ:
			return String.class;
		case COL_PROPRIETARIO_CPF:
			return String.class;
		case COL_PROPRIETARIO_NOME:
			return String.class;
		case COL_RENAVAM:
			return String.class;
		case COL_TIPO:
			return String.class;
		case COL_VALOR_COMPRA:
			return String.class;
		case COL_VALOR_VENDA:
			return String.class;
		case ID:
			return Long.class;
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
		case COL_DATA_COMPRA:
			return "DATA DA COMPRA";
		case COL_PROPRIETARIO_ANTERIOR_CNPJ:
			return "CNPJ (PROPRIETÁRIO ANTERIOR)";
		case COL_ANO_MODELO:
			return "ANO MODELO";
		case COL_CHASSI_REMARCADO:
			return "CHASSI REMARCADO";
		case COL_CILINDRADA:
			return "CILINDRADA";
		case COL_COR:
			return "COR";
		case COL_PROPRIETARIO_ANTERIOR_CPF:
			return "CPF (PROPRIETÁRIO ANTERIOR)";
		case COL_PROPRIETARIO_ANTERIOR_NOME:
			return "NOME (PROPRIETÁRIO ANTERIOR)";
		case COL_PROPRIETARIO_CNPJ:
			return "CNPJ (PROPRIETÁRIO)";
		case COL_PROPRIETARIO_CPF:
			return "CPF (PROPRIETÁRIO)";
		case COL_PROPRIETARIO_NOME:
			return "NOME (PROPRIETÁRIO)";
		case COL_RENAVAM:
			return "RENAVAM";
		case COL_TIPO:
			return "TIPO";
		case COL_VALOR_COMPRA:
			return "VALOR DE COMPRA";
		case COL_VALOR_VENDA:
			return "VALOR DA VENDA";
		case COL_COMBUSTIVEL:
			return "COMBUSTÍVEL";
		case COL_ANO_DE_FABRICACAO:
			return "ANO DE FABRICAÇÃO";
		case COL_DATA_VENDA:
			return "DATA DA VENDA";
		case COL_CMT_TON:
			return "CMT-TON";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		return veiculosList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Veiculo veiculo = veiculosList.get(rowIndex);
		switch (columnIndex) {
		case COL_ANO_DE_FABRICACAO:
			return veiculo.getAnoFabricacao();
		case COL_ANO_MODELO:
			return veiculo.getAnoModelo();
		case COL_CHASSI_REMARCADO:
			return veiculo.getChassiRemarcado();
		case COL_CILINDRADA:
			return veiculo.getCilindrada();
		case COL_CMT_TON:
			return veiculo.getCmtTon();
		case COL_COMBUSTIVEL:
			return veiculo.getCombustivel();
		case COL_COR:
			return veiculo.getCor();
		case COL_DATA_COMPRA:
			return veiculo.getDataCompra();
		case COL_DATA_VENDA:
			return veiculo.getDataVenda();
		case COL_PROPRIETARIO_ANTERIOR_CNPJ:
			return veiculo.getProprietarioAnteriorCNPJ();
		case COL_PROPRIETARIO_ANTERIOR_CPF:
			return veiculo.getProprietarioAnteriorCPF();
		case COL_PROPRIETARIO_ANTERIOR_NOME:
			return veiculo.getProprietarioAnteriorNome();
		case COL_PROPRIETARIO_CNPJ:
			return veiculo.getProprietarioCNPJ();
		case COL_PROPRIETARIO_CPF:
			return veiculo.getProprietarioCPF();
		case COL_PROPRIETARIO_NOME:
			return veiculo.getProprietarioNome();
		case COL_RENAVAM:
			return veiculo.getRenavam();
		case COL_TIPO:
			return veiculo.getTipo();
		case COL_VALOR_COMPRA:
			return veiculo.getValorCompra();
		case COL_VALOR_VENDA:
			return veiculo.getValorVenda();
		case ID:
			return veiculo.getId();
		default:
			return veiculo;
		}
	}

	public Veiculo getVeiculo(int linha) {
		if (veiculosList.size() > 0) {
			return veiculosList.get(linha);
		}
		return null;
	}

	public List<Veiculo> getVeiculoList() {
		return veiculosList;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		veiculo = veiculosList.get(rowIndex);
		switch (columnIndex) {
		case COL_ANO_DE_FABRICACAO:
			veiculo.setAnoFabricacao(aValue.toString());
			break;
		case COL_ANO_MODELO:
			veiculo.setModelo(aValue.toString());
			break;
		case COL_CHASSI_REMARCADO:
			veiculo.setChassiRemarcado(aValue.toString());
			break;
		case COL_CILINDRADA:
			veiculo.setCilindrada(aValue.toString());
			break;
		case COL_CMT_TON:
			veiculo.setCmtTon(aValue.toString());
			break;
		case COL_COMBUSTIVEL:
			veiculo.setCombustivel(aValue.toString());
			break;
		case COL_COR:
			veiculo.setCor(aValue.toString());
			break;
		case COL_DATA_COMPRA:
			veiculo.setDataCompra(aValue.toString());
			break;
		case COL_DATA_VENDA:
			veiculo.setDataVenda(aValue.toString());
			break;
		case COL_PROPRIETARIO_ANTERIOR_CNPJ:
			veiculo.setProprietarioAnteriorCNPJ(aValue.toString());
			break;
		case COL_PROPRIETARIO_ANTERIOR_CPF:
			veiculo.setProprietarioAnteriorCPF(aValue.toString());
			break;
		case COL_PROPRIETARIO_ANTERIOR_NOME:
			veiculo.setProprietarioAnteriorNome(aValue.toString());
			break;
		case COL_PROPRIETARIO_CNPJ:
			veiculo.setProprietarioCNPJ(aValue.toString());
			break;
		case COL_PROPRIETARIO_CPF:
			veiculo.setProprietarioCPF(aValue.toString());
			break;
		case COL_PROPRIETARIO_NOME:
			veiculo.setProprietarioNome(aValue.toString());
			break;
		case COL_RENAVAM:
			veiculo.setRenavam(aValue.toString());
			break;
		case COL_TIPO:
			veiculo.setTipo(aValue.toString());
			break;
		case COL_VALOR_COMPRA:
			veiculo.setValorCompra(aValue.toString());
			break;
		case COL_VALOR_VENDA:
			veiculo.setValorVenda(aValue.toString());
			break;
		case ID:
			veiculo.setId(Long.parseLong(aValue.toString()));
			break;
		}
		fireTableDataChanged();
	}

	public void setVeiculoList(List<Veiculo> banco) {
		veiculosList = banco;
	}
}
