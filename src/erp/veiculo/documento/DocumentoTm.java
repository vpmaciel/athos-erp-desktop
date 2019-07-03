package erp.veiculo.documento;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.veiculo.Veiculo;
import erp.veiculo.VeiculoFac;

@SuppressWarnings("serial")
public class DocumentoTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionarColuna("ID", 0, 100);
		tabelaModelo.adicionarColuna("SITUAÇÃO", 1, 200);
		tabelaModelo.adicionarColuna("LOCAL", 2, 200);
		tabelaModelo.adicionarColuna("PLACA", 3, 100);
		tabelaModelo.adicionarColuna("MARCA", 4, 300);
		tabelaModelo.adicionarColuna("MODELO", 5, 300);
		tabelaModelo.adicionarColuna("NOME DO PROPRIETÁRIO", 6, 300);
		tabelaModelo.adicionarColuna("MÊS DE RECEBIMENTO DO DOCUMENTO", 7, 300);
		tabelaModelo.adicionarColuna("ANO DE RECEBIMENTO DO DOCUMENTO", 8, 300);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Documento documento;

	private List<Documento> documentoList = new LinkedList<>();

	public DocumentoTm() {

	}

	public DocumentoTm(List<Documento> lista) {
		documentoList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return Long.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return largura.length;
	}

	@Override
	public String getColumnName(int column) {
		return tabelaModelo.getNome(column);
	}

	public Documento getDocumento(int linha) {
		if (documentoList.size() > 0) {
			return documentoList.get(linha);
		}
		return null;
	}

	public List<Documento> getDocumentoList() {
		return documentoList;
	}

	@Override
	public int getRowCount() {
		return documentoList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Documento documento = documentoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return documento.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("SITUAÇÃO")) {
			return documento.getSituacaoDocumento();
		}
		if (tabelaModelo.getNome(columnIndex).equals("LOCAL")) {
			return documento.getLocalDocumento();
		}
		if (tabelaModelo.getNome(columnIndex).equals("PLACA")) {
			return documento.getVeiculo().getPlaca();
		}
		if (tabelaModelo.getNome(columnIndex).equals("MARCA")) {
			return documento.getVeiculo().getMarca().getMarca();
		}
		if (tabelaModelo.getNome(columnIndex).equals("MODELO")) {
			return documento.getVeiculo().getModelo().getModelo();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME DO PROPRIETÁRIO")) {
			return documento.getVeiculo().getProprietarioNome();
		}
		if (tabelaModelo.getNome(columnIndex).equals("MÊS DE RECEBIMENTO DO DOCUMENTO")) {
			return documento.getMesRecebimentoDocumento();
		}
		if (tabelaModelo.getNome(columnIndex).equals("ANO DE RECEBIMENTO DO DOCUMENTO")) {
			return documento.getAnoRecebimentoDocumento();
		}
		return documento;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setDocumentoList(List<Documento> documento) {
		documentoList = documento;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		documento = documentoList.get(rowIndex);

		Veiculo veiculo = new Veiculo();
		List<Veiculo> listVeiculo = null;
		if (tabelaModelo.getNome(columnIndex).equals("PLACA")) {
			veiculo.setPlaca(aValue.toString());
			listVeiculo = (List<Veiculo>) VeiculoFac.pesquisarRegistro(veiculo);
			veiculo = listVeiculo.get(0);
			documento.setVeiculo(veiculo);
		}

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			documento.setId(Long.parseLong(aValue.toString()));
		}

		fireTableDataChanged();
	}
}