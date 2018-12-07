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
import erp.main.MainCT;

final class SindicatoCT {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (sindicato == null || sindicato.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				SindicatoFAC.deletarRegistro(sindicato);
				getSindicatoFC().limparGUI();
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
				getSindicatoFC().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getSindicatoFC().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getSindicatoFC().setVisible(false);
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
				MainCT.mostrarFrame(MainCT.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Sindicato> sindicatos = new LinkedList<>();

			if (sindicato.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (sindicatos.add(SindicatoFAC.getRegistro(sindicato))) {
					SindicatoREL sindicatoREL = new SindicatoREL(sindicatos);
					sindicatoREL.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Sindicato> sindicatos = new LinkedList<>();

			try {
				sindicatos = new LinkedList<>(SindicatoFAC.pesquisarRegistro(sindicato));
			} catch (Exception e) {
				System.out.println(e);
			}
			SindicatoREL sindicatoREL = new SindicatoREL(sindicatos);
			sindicatoREL.retornarRelatorio(true);
		}
	}

	public class MostraFrameSindicato extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCT.mostrarFrame(MainCT.getSindicatoFC());
			} else {
				MainCT.getSindicatoFC().reiniciarGUI();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			sindicato = new Sindicato();
			getSindicatoFC().limparGUI();
			getSindicatoPC().getNomeFantasiaGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			sindicato = new Sindicato();
			atualizarObjeto();
			getSindicatoPP().pesquisarRegistroSindicato(sindicato);
			MainCT.mostrarFrame(MainCT.getSindicatoFC());
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
				String nome = getSindicatoPC().getNomeFantasiaGUI().getText();
				if (nome == null || nome.length() == 0) {
					getSindicatoPC().getNomeFantasiaGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					SindicatoFAC.salvarRegistro(sindicato);
					sindicato = new Sindicato();
					getSindicatoFC().limparGUI();
					getSindicatoPC().getNomeFantasiaGUI().requestFocus();
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
		getSindicatoPC().getNomeFantasiaGUI().setText(sindicato.getNomeFantasia());
		getSindicatoPC().getNumeroFuncionariosGUI().setText(sindicato.getNumeroFuncionarios());
		getSindicatoPC().getRamoAtividadeGUI().setText(sindicato.getRamoAtividade());
		getSindicatoPC().getNomeFantasiaGUI().setText(sindicato.getNomeFantasia());
		getSindicatoPC().getRazaoSocialGUI().setText(sindicato.getRazaoSocial());
		getSindicatoPC().getEmailGUI().setText(sindicato.getEmail());
		getSindicatoPC().getFaxGUI().setText(sindicato.getFax());
		getSindicatoPC().getFone1GUI().setText(sindicato.getFone1());
		getSindicatoPC().getFone2GUI().setText(sindicato.getFone2());
		getSindicatoPC().getTextEstadualGUI().setText(sindicato.getInscricaoEstadual());
		getSindicatoPC().getInscricaoMunicipalGUI().setText(sindicato.getInscricaoMunicipal());
		getSindicatoPC().getCapitalSocialGUI().setText(sindicato.getCapitalSocial());
		getSindicatoPC().getDataFundacaoGUI().setText(sindicato.getDataFundacao());
		getSindicatoPC().getBairroGUI().setText(sindicato.getBairro());
		getSindicatoPC().getCepGUI().setText(sindicato.getCep());
		getSindicatoPC().getCidadeGUI().setText(sindicato.getCidade());
		getSindicatoPC().getComplementoGUI().setText(sindicato.getComplemento());
		getSindicatoPC().getEstadoGUI().setText(sindicato.getEstado());
		getSindicatoPC().getLogradouroGUI().setText(sindicato.getLogradouro());
		getSindicatoPC().getPaisGUI().setText(sindicato.getPais());
		getSindicatoPC().getCnpjGUI().setText(sindicato.getCnpj());
		getSindicatoPC().getTipoSindicatoGUI().setSelectedItem(sindicato.getTipoSindicato());
		getSindicatoPC().getFaturamentoMensalGUI().setText(sindicato.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		sindicato.setNomeFantasia(getSindicatoPC().getNomeFantasiaGUI().getText());
		sindicato.setNumeroFuncionarios(getSindicatoPC().getNumeroFuncionariosGUI().getText());
		sindicato.setRamoAtividade(getSindicatoPC().getRamoAtividadeGUI().getText());
		sindicato.setRazaoSocial(getSindicatoPC().getRazaoSocialGUI().getText());
		sindicato.setEmail(getSindicatoPC().getEmailGUI().getText());
		sindicato.setFax(getSindicatoPC().getFaxGUI().getText());
		sindicato.setFone1(getSindicatoPC().getFone1GUI().getText());
		sindicato.setFone2(getSindicatoPC().getFone2GUI().getText());
		sindicato.setInscricaoEstadual(getSindicatoPC().getTextEstadualGUI().getText());
		sindicato.setInscricaoMunicipal(getSindicatoPC().getInscricaoMunicipalGUI().getText());
		sindicato.setCapitalSocial(getSindicatoPC().getCapitalSocialGUI().getText());
		sindicato.setDataFundacao(getSindicatoPC().getDataFundacaoGUI().getText());
		sindicato.setBairro(getSindicatoPC().getBairroGUI().getText());
		sindicato.setCep(getSindicatoPC().getCepGUI().getText());
		sindicato.setCidade(getSindicatoPC().getCidadeGUI().getText());
		sindicato.setComplemento(getSindicatoPC().getComplementoGUI().getText());
		sindicato.setEstado(getSindicatoPC().getEstadoGUI().getText());
		sindicato.setLogradouro(getSindicatoPC().getLogradouroGUI().getText());
		sindicato.setPais(getSindicatoPC().getPaisGUI().getText());
		sindicato.setCnpj(getSindicatoPC().getCnpjGUI().getText());
		sindicato.setTipoSindicato((String) getSindicatoPC().getTipoSindicatoGUI().getSelectedItem());
		sindicato.setFaturamentoMensal(getSindicatoPC().getFaturamentoMensalGUI().getText());
	}

	public Sindicato getSindicato() {
		return sindicato;
	}

	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}

	public SindicatoFC getSindicatoFC() {
		return MainCT.getSindicatoFC();
	}

	public SindicatoPC getSindicatoPC() {
		return MainCT.getSindicatoFC().getSindicatoPC();
	}

	public SindicatoFP getSindicatoFP() {
		return MainCT.getSindicatoFP();
	}

	public SindicatoPP getSindicatoPP() {
		return MainCT.getSindicatoFP().getSindicatoPP();
	}
}
