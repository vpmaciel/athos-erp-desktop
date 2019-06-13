package erp.veiculo.documento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import arquitetura.validacao.Mascara;
import erp.main.MainCont;
import erp.veiculo.Veiculo;
import erp.veiculo.VeiculoFac;

final class DocumentoCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (documento == null || documento.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				DocumentoFac.deletarRegistro(documento);
				getDocumentoFc().limparGui();
				documento = new Documento();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getDocumentoFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getDocumentoFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getDocumentoFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			documento = new Documento();
			getDocumentoPc().getGuiVeiculo().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainCont.mostrarFrame(MainCont.getMainFc());
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getDocumentoPc().getLabelVeiculo()) {
				MainCont.mostrarFrame(MainCont.getVeiculoFc());
			} else {
				MainCont.getVeiculoDocumentoFc().reiniciarGui();
			}
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Documento> documentos = new LinkedList<>();

			if (documento.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (documentos.add(DocumentoFac.getRegistro(documento))) {
				DocumentoRel documentoRel = new DocumentoRel(documentos);
				documentoRel.retornarRelatorio(true);
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			documento = new Documento();
			getDocumentoFc().limparGui();
			getDocumentoPc().getGuiVeiculo().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getDocumentoPp().pesquisarRegistro(documento);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getDocumentoFp());
				getDocumentoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getDocumentoPp().pesquisarRegistro(new Documento());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getDocumentoFp());
				getDocumentoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Documento> documentos = new LinkedList<>();

			try {
				documentos = new LinkedList<>(DocumentoFac.pesquisarRegistro(new Documento()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			DocumentoRel documentoRel = new DocumentoRel(documentos);
			documentoRel.retornarRelatorio(true);

		}
	}

	public class SaidaSistema implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (Msg.confirmarSairDoSistema() == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

	public class Salva implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				int mensagem = Msg.confirmarSalvarRegistro();

				if (mensagem != JOptionPane.YES_OPTION) {
					return;
				}

				if (getDocumentoPc().getGuiVeiculo() == null) {
					getDocumentoPc().getGuiVeiculo().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					DocumentoFac.salvarRegistro(documento);
					documento = new Documento();
					getDocumentoFc().limparGui();
					getDocumentoPc().getGuiVeiculo().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroSalvarRegistro();
			}
		}
	}

	private Documento documento;

	public void atualizarGui() {
		if (documento == null) {
			return;
		}
		getDocumentoPc().getGuiAnoDevolucaoDocumento().setText(documento.getAnoDevolucaoDocumento());
		getDocumentoPc().getGuiAnoRecebimentoDocumento().setText(documento.getAnoRecebimentoDocumento());
		getDocumentoPc().getGuiCNPJRecebedorDocumento().setText(documento.getCnpjRecebedorDocumento());
		getDocumentoPc().getGuiCPFRecebedorDocumento().setText(documento.getCpfRecebedorDocumento());
		getDocumentoPc().getGuiDiaDevolucaoDocumento().setText(documento.getDiaDevolucaoDocumento());
		getDocumentoPc().getGuiDiaRecebimentoDocumento().setText(documento.getDiaRecebimentoDocumento());
		getDocumentoPc().getGuiLocalDocumento().setSelectedItem(documento.getLocalDocumento());
		getDocumentoPc().getGuiMesDevolucaoDocumento().setSelectedItem(documento.getMesDevolucaoDocumento());
		getDocumentoPc().getGuiMesRecebimentoDocumento().setSelectedItem(documento.getMesRecebimentoDocumento());
		getDocumentoPc().getGuiNomeProprietário().setText(documento.getVeiculo().getProprietarioNome());
		getDocumentoPc().getGuiNomeRecebedorDocumento().setText(documento.getNomeRecebedorDocumento());
		getDocumentoPc().getGuiVeiculo().setSelectedItem(documento.getVeiculo());
		getDocumentoPc().getGuiRGNumeroRecebedorDocumento().setText(documento.getRgNumeroRecebedorDocumento());
		getDocumentoPc().getGuiRGOrgaoEmisssorRecebedorDocumento()
				.setText(documento.getRgOrgaoEmisssorRecebedorDocumento());
		getDocumentoPc().getGuiSituacaoDocumento().setSelectedItem(documento.getSituacaoDocumento());
	}

	public void atualizarObjeto() {
		documento.setAnoDevolucaoDocumento(getDocumentoPc().getGuiAnoDevolucaoDocumento().getText());
		documento.setAnoRecebimentoDocumento(getDocumentoPc().getGuiAnoRecebimentoDocumento().getText());
		documento.setCnpjRecebedorDocumento(getDocumentoPc().getGuiCNPJRecebedorDocumento().getText());
		documento.setCpfRecebedorDocumento(getDocumentoPc().getGuiCPFRecebedorDocumento().getText());
		documento.setDiaDevolucaoDocumento(getDocumentoPc().getGuiDiaDevolucaoDocumento().getText());
		documento.setDiaRecebimentoDocumento(getDocumentoPc().getGuiDiaRecebimentoDocumento().getText());
		documento.setLocalDocumento((String) getDocumentoPc().getGuiLocalDocumento().getSelectedItem());
		documento.setMesDevolucaoDocumento((String) getDocumentoPc().getGuiMesDevolucaoDocumento().getSelectedItem());
		documento.setMesRecebimentoDocumento(
				(String) getDocumentoPc().getGuiMesRecebimentoDocumento().getSelectedItem());

		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca(((Veiculo) getDocumentoPc().getGuiVeiculo().getSelectedItem()).getPlaca());

		List<Veiculo> listVeiculo = (List<Veiculo>) VeiculoFac.pesquisarRegistro(veiculo);
		if (listVeiculo.size() > 0) {
			veiculo = listVeiculo.get(0);
			documento.setNomeRecebedorDocumento(veiculo.getProprietarioNome());
			documento.setVeiculo(veiculo);
		}

		documento.setRgNumeroRecebedorDocumento(getDocumentoPc().getGuiRGNumeroRecebedorDocumento().getText());
		documento.setRgOrgaoEmisssorRecebedorDocumento(
				getDocumentoPc().getGuiRGOrgaoEmisssorRecebedorDocumento().getText());
		documento.setSituacaoDocumento((String) getDocumentoPc().getGuiSituacaoDocumento().getSelectedItem());

		if (documento.getCnpjRecebedorDocumento().equals(Mascara.getCnpjVazio())) {
			documento.setCnpjRecebedorDocumento(null);
		}

		if (documento.getCpfRecebedorDocumento().equals(Mascara.getCpfVazio())) {
			documento.setCpfRecebedorDocumento(null);
		}
	}

	public Documento getDocumento() {
		return documento;
	}

	public DocumentoFc getDocumentoFc() {
		return MainCont.getVeiculoDocumentoFc();
	}

	public DocumentoFp getDocumentoFp() {
		return MainCont.getVeiculoDocumentoFp();
	}

	public DocumentoPc getDocumentoPc() {
		return MainCont.getVeiculoDocumentoFc().getDocumentoPc();
	}

	public DocumentoPp getDocumentoPp() {
		return MainCont.getVeiculoDocumentoFp().getDocumentoPp();
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
}
