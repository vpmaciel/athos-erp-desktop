package erp.curriculo.certificado;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public class CertificadoTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionarColuna("ID", 0, 100);
		tabelaModelo.adicionarColuna("FUNCIONÁRIO", 1, 500);
		tabelaModelo.adicionarColuna("INSTITUIÇÃO", 2, 500);
		tabelaModelo.adicionarColuna("CURSO", 3, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Certificado certificado;

	private List<Certificado> certificadoList = new LinkedList<>();

	public CertificadoTm() {

	}

	public CertificadoTm(List<Certificado> lista) {
		certificadoList.addAll(lista);
	}

	public Certificado getCertificado(int linha) {
		if (certificadoList.size() > 0) {
			return certificadoList.get(linha);
		}
		return null;
	}

	public List<Certificado> getCertificadoList() {
		return certificadoList;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return Long.class;
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return Funcionario.class;
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

	@Override
	public int getRowCount() {
		return certificadoList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Certificado certificado = certificadoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return certificado.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return certificado.getFuncionario();
		}
		if (tabelaModelo.getNome(columnIndex).equals("INSTITUIÇÃO")) {
			return certificado.getInstituicao();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CURSO")) {
			return certificado.getCurso();
		}
		return certificado;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setCertificadoList(List<Certificado> certificado) {
		certificadoList = certificado;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		certificado = certificadoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			certificado.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCINÁRIO")) {
			certificado.setFuncionario((Funcionario) aValue);
		}
		if (tabelaModelo.getNome(columnIndex).equals("INSTITUIÇÃO")) {
			certificado.setInstituicao(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("CURSO")) {
			certificado.setCurso(aValue.toString());
		}

		fireTableDataChanged();
	}
}