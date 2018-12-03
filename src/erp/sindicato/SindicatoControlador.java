package erp.sindicato;

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
import erp.main.MainControlador;

final class SindicatoControlador {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (sindicato == null || sindicato.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				SindicatoDaoFacade.deletarRegistro(sindicato);
				getFrameCadastroSindicato().limparGui();
				sindicato = new Sindicato();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				getFrameCadastroSindicato().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroSindicato().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroSindicato().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			sindicato = new Sindicato();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainControlador.mostrarFrame(MainControlador.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Sindicato> sindicatos = new LinkedList<>();

			if (sindicato.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (sindicatos.add(SindicatoDaoFacade.getRegistro(sindicato))) {
					SindicatoRelatorio sindicatoRelatorio = new SindicatoRelatorio(sindicatos);
					sindicatoRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Sindicato> sindicatos = new LinkedList<>();

			try {
				sindicatos = new LinkedList<>(SindicatoDaoFacade.pesquisarRegistro(sindicato));
			} catch (Exception e) {
				System.out.println(e);
			}
			SindicatoRelatorio sindicatoRelatorio = new SindicatoRelatorio(sindicatos);
			sindicatoRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameSindicato extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainControlador.mostrarFrame(MainControlador.getFrameCadastroSindicato());
			} else {
				MainControlador.getFrameCadastroSindicato().reiniciarBox();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			sindicato = new Sindicato();
			getFrameCadastroSindicato().limparGui();
			getPanelCadastroSindicato().getTextFieldNomeFantasia().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			sindicato = new Sindicato();
			atualizarObjeto();
			getPanelPesquisaSindicato().pesquisarRegistroSindicato(sindicato);
			MainControlador.mostrarFrame(MainControlador.getFrameCadastroSindicato());
		}
	}

	public class SaidaSistema implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				int mensagem = Msg.confirmarSairDoSistema();
				if (mensagem == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(e);
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
				String nome = getPanelCadastroSindicato().getTextFieldNomeFantasia().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroSindicato().getTextFieldNomeFantasia().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					SindicatoDaoFacade.salvarRegistro(sindicato);
					sindicato = new Sindicato();
					getFrameCadastroSindicato().limparGui();
					getPanelCadastroSindicato().getTextFieldNomeFantasia().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Sindicato sindicato;

	public void atualizarGui() {
		if (sindicato == null) {
			return;
		}
		getPanelCadastroSindicato().getTextFieldNomeFantasia().setText(sindicato.getNomeFantasia());
		getPanelCadastroSindicato().getTextFieldNumeroFuncionarios().setText(sindicato.getNumeroFuncionarios());
		getPanelCadastroSindicato().getTextFieldRamoAtividade().setText(sindicato.getRamoAtividade());
		getPanelCadastroSindicato().getTextFieldNomeFantasia().setText(sindicato.getNomeFantasia());
		getPanelCadastroSindicato().getTextFieldRazaoSocial().setText(sindicato.getRazaoSocial());
		getPanelCadastroSindicato().getTextFieldEmail().setText(sindicato.getEmail());
		getPanelCadastroSindicato().getTextFieldFax().setText(sindicato.getFax());
		getPanelCadastroSindicato().getTextFieldFone1().setText(sindicato.getFone1());
		getPanelCadastroSindicato().getTextFieldFone2().setText(sindicato.getFone2());
		getPanelCadastroSindicato().getTextFieldInscricaoEstadual().setText(sindicato.getInscricaoEstadual());
		getPanelCadastroSindicato().getTextFieldInscricaoMunicipal().setText(sindicato.getInscricaoMunicipal());
		getPanelCadastroSindicato().getTextFieldCapitalSocial().setText(sindicato.getCapitalSocial());
		getPanelCadastroSindicato().getTextFieldDataFundacao().setText(sindicato.getDataFundacao());
		getPanelCadastroSindicato().getTextFieldBairro().setText(sindicato.getBairro());
		getPanelCadastroSindicato().getTextFieldCep().setText(sindicato.getCep());
		getPanelCadastroSindicato().getTextFieldCidade().setText(sindicato.getCidade());
		getPanelCadastroSindicato().getTextFieldComplemento().setText(sindicato.getComplemento());
		getPanelCadastroSindicato().getTextFieldEstado().setText(sindicato.getEstado());
		getPanelCadastroSindicato().getTextFieldLogradouro().setText(sindicato.getLogradouro());
		getPanelCadastroSindicato().getTextFieldPais().setText(sindicato.getPais());
		getPanelCadastroSindicato().getTextFieldCNPJ().setText(sindicato.getCnpj());
		getPanelCadastroSindicato().getTextFieldCPF().setText(sindicato.getCpfNumero());
		getPanelCadastroSindicato().getBoxTipoSindicato().setSelectedItem(sindicato.getTipoSindicato());
		getPanelCadastroSindicato().getTextFieldFaturamentoMensal().setText(sindicato.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		sindicato.setNomeFantasia(getPanelCadastroSindicato().getTextFieldNomeFantasia().getText());
		sindicato.setNumeroFuncionarios(getPanelCadastroSindicato().getTextFieldNumeroFuncionarios().getText());
		sindicato.setRamoAtividade(getPanelCadastroSindicato().getTextFieldRamoAtividade().getText());
		sindicato.setNomeFantasia(getPanelCadastroSindicato().getTextFieldNomeFantasia().getText());
		sindicato.setRazaoSocial(getPanelCadastroSindicato().getTextFieldRazaoSocial().getText());
		sindicato.setEmail(getPanelCadastroSindicato().getTextFieldEmail().getText());
		sindicato.setFax(getPanelCadastroSindicato().getTextFieldFax().getText());
		sindicato.setFone1(getPanelCadastroSindicato().getTextFieldFone1().getText());
		sindicato.setFone2(getPanelCadastroSindicato().getTextFieldFone2().getText());
		sindicato.setInscricaoEstadual(getPanelCadastroSindicato().getTextFieldInscricaoEstadual().getText());
		sindicato.setInscricaoMunicipal(getPanelCadastroSindicato().getTextFieldInscricaoMunicipal().getText());
		sindicato.setCapitalSocial(getPanelCadastroSindicato().getTextFieldCapitalSocial().getText());
		sindicato.setDataFundacao(getPanelCadastroSindicato().getTextFieldDataFundacao().getText());
		sindicato.setBairro(getPanelCadastroSindicato().getTextFieldBairro().getText());
		sindicato.setCep(getPanelCadastroSindicato().getTextFieldCep().getText());
		sindicato.setCidade(getPanelCadastroSindicato().getTextFieldCidade().getText());
		sindicato.setComplemento(getPanelCadastroSindicato().getTextFieldComplemento().getText());
		sindicato.setEstado(getPanelCadastroSindicato().getTextFieldEstado().getText());
		sindicato.setLogradouro(getPanelCadastroSindicato().getTextFieldLogradouro().getText());
		sindicato.setPais(getPanelCadastroSindicato().getTextFieldPais().getText());
		sindicato.setCnpj(getPanelCadastroSindicato().getTextFieldCNPJ().getText());
		sindicato.setCpfNumero(getPanelCadastroSindicato().getTextFieldCPF().getText());
		sindicato.setTipoSindicato((String) getPanelCadastroSindicato().getBoxTipoSindicato().getSelectedItem());
		sindicato.setFaturamentoMensal(getPanelCadastroSindicato().getTextFieldFaturamentoMensal().getText());
	}

	public Sindicato getSindicato() {
		return sindicato;
	}

	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}

	public FCSindicato getFrameCadastroSindicato() {
		return MainControlador.getFrameCadastroSindicato();
	}

	public PCSindicato getPanelCadastroSindicato() {
		return MainControlador.getFrameCadastroSindicato().getPanelCadastroSindicato();
	}

	public FPSindicato getFramePesquisaSindicato() {
		return MainControlador.getFramePesquisaSindicato();
	}

	public PPSindicato getPanelPesquisaSindicato() {
		return MainControlador.getFramePesquisaSindicato().getPanelPesquisaSindicato();
	}
}
