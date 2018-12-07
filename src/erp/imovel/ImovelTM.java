package erp.imovel;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ImovelTM extends AbstractTableModel {

	public static final int ID = 0;
	public static final int COL_CNPJ = 1;
	public static final int COL_COZINHA = 2;
	public static final int COL_BANHEIRO = 3;
	public static final int COL_SUITE = 4;
	public static final int COL_CPF_NUMERO = 5;
	public static final int COL_EMAIL = 6;
	public static final int COL_VARANDA = 7;
	public static final int COL_FAX = 8;
	public static final int COL_FONE1 = 9;
	public static final int COL_FONE2 = 10;
	public static final int COL_NOME_PROPRIETARIO = 11;
	public static final int COL_GARAGEM = 12;
	public static final int COL_PISCINA = 13;
	public static final int COL_TERRACO = 14;
	public static final int COL_SALA = 15;
	public static final int COL_PAIS = 16;
	public static final int COL_ESTADO = 17;
	public static final int COL_CIDADE = 18;
	public static final int COL_BAIRRO = 19;
	public static final int COL_LOGRADOURO = 20;
	public static final int COL_COMPLEMENTO = 21;
	public static final int COL_CEP = 22;
	public static final int[] WIDTH = new int[] { 100, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500,
			500, 500, 500, 500, 500, 500, 500, 500, 500 };
	private final boolean[] podeEditar = new boolean[] { false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false };
	private List<Imovel> imovelsList = new LinkedList<>();
	private Imovel imovel;

	public ImovelTM() {
	}

	public ImovelTM(List<Imovel> lista) {
		imovelsList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case COL_BAIRRO:
			return String.class;
		case COL_BANHEIRO:
			return String.class;
		case COL_SUITE:
			return String.class;
		case COL_CEP:
			return String.class;
		case COL_CIDADE:
			return String.class;
		case COL_CNPJ:
			return String.class;
		case COL_COMPLEMENTO:
			return String.class;
		case COL_COZINHA:
			return String.class;
		case COL_CPF_NUMERO:
			return String.class;
		case COL_EMAIL:
			return String.class;
		case COL_VARANDA:
			return String.class;
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
		case COL_NOME_PROPRIETARIO:
			return String.class;
		case COL_PAIS:
			return String.class;
		case COL_GARAGEM:
			return String.class;
		case COL_PISCINA:
			return String.class;
		case COL_TERRACO:
			return String.class;
		case COL_SALA:
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
		case COL_COZINHA:
			return "COZINHA";
		case COL_BANHEIRO:
			return "BANHEIRO";
		case COL_SUITE:
			return "SUÍTE";
		case COL_CPF_NUMERO:
			return "CPF";
		case COL_EMAIL:
			return "EMAIL";
		case COL_VARANDA:
			return "VARANDA";
		case COL_ESTADO:
			return "ESTADO";
		case COL_FAX:
			return "FAX";
		case COL_FONE1:
			return "TELEFONE";
		case COL_FONE2:
			return "TELEFONE";
		case COL_NOME_PROPRIETARIO:
			return "NOME PROPRIETÁRIO";
		case COL_GARAGEM:
			return "GARAGE,";
		case COL_PISCINA:
			return "PISCINA";
		case COL_TERRACO:
			return "TERRAÇO";
		case COL_SALA:
			return "SALA";
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

	public Imovel getImovel(int linha) {
		if (imovelsList.size() > 0) {
			return imovelsList.get(linha);
		}
		return null;
	}

	public List<Imovel> getImovelList() {
		return imovelsList;
	}

	@Override
	public int getRowCount() {
		return imovelsList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Imovel imovel = imovelsList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			return imovel.getBairro();
		case COL_BANHEIRO:
			return imovel.getBanheiro();
		case COL_SUITE:
			return imovel.getSuite();
		case COL_CEP:
			return imovel.getCep();
		case COL_CIDADE:
			return imovel.getCidade();
		case COL_CNPJ:
			return imovel.getCnpj();
		case COL_COMPLEMENTO:
			return imovel.getComplemento();
		case COL_COZINHA:
			return imovel.getCozinha();
		case COL_CPF_NUMERO:
			return imovel.getCpfNumero();
		case COL_EMAIL:
			return imovel.getEmail();
		case COL_VARANDA:
			return imovel.getVaranda();
		case COL_ESTADO:
			return imovel.getEstado();
		case COL_FAX:
			return imovel.getFax();
		case COL_FONE1:
			return imovel.getFone1();
		case COL_FONE2:
			return imovel.getFone2();
		case ID:
			return imovel.getId();
		case COL_LOGRADOURO:
			return imovel.getLogradouro();
		case COL_NOME_PROPRIETARIO:
			return imovel.getNomeProprietario();
		case COL_PAIS:
			return imovel.getPais();
		case COL_GARAGEM:
			return imovel.getGaragem();
		case COL_PISCINA:
			return imovel.getPiscina();
		case COL_TERRACO:
			return imovel.getTerracao();
		case COL_SALA:
			return imovel.getSala();
		}
		return imovel;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setImovelList(List<Imovel> banco) {
		imovelsList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		imovel = imovelsList.get(rowIndex);
		switch (columnIndex) {
		case COL_BAIRRO:
			imovel.setBairro(aValue.toString());
			break;
		case COL_BANHEIRO:
			imovel.setBanheiro(aValue.toString());
			break;
		case COL_SUITE:
			imovel.setSuite(aValue.toString());
			break;
		case COL_CEP:
			imovel.setCep(aValue.toString());
			break;
		case COL_CIDADE:
			imovel.setCidade(aValue.toString());
			break;
		case COL_CNPJ:
			imovel.setCnpj(aValue.toString());
			break;
		case COL_COMPLEMENTO:
			imovel.setComplemento(aValue.toString());
			break;
		case COL_COZINHA:
			imovel.setCozinha(aValue.toString());
			break;
		case COL_CPF_NUMERO:
			imovel.setCpfNumero(aValue.toString());
			break;
		case COL_EMAIL:
			imovel.setEmail(aValue.toString());
			break;
		case COL_VARANDA:
			imovel.setVaranda(aValue.toString());
			break;
		case COL_ESTADO:
			imovel.setEstado(aValue.toString());
			break;
		case COL_FAX:
			imovel.setFax(aValue.toString());
			break;
		case COL_FONE1:
			imovel.setFone1(aValue.toString());
			break;
		case COL_FONE2:
			imovel.setFone2(aValue.toString());
			break;
		case ID:
			imovel.setId(Long.parseLong(aValue.toString()));
			break;
		case COL_LOGRADOURO:
			imovel.setLogradouro(aValue.toString());
			break;
		case COL_NOME_PROPRIETARIO:
			imovel.setNomeProprietario(aValue.toString());
			break;
		case COL_PAIS:
			imovel.setPais(aValue.toString());
			break;
		case COL_GARAGEM:
			imovel.setGaragem(aValue.toString());
			break;
		case COL_PISCINA:
			imovel.setPiscina(aValue.toString());
			break;
		case COL_TERRACO:
			imovel.setTerraco(aValue.toString());
			break;
		case COL_SALA:
			imovel.setSala(aValue.toString());
			break;
		}
		fireTableDataChanged();
	}
}
