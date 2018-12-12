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
import erp.main.MainCont;

final class SindicatoCont {

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
				SindicatoFac.deletarRegistro(sindicato);
				getSindicatoFc().limparGUI();
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
				getSindicatoFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getSindicatoFc().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getSindicatoFc().setVisible(false);
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
				MainCont.mostrarFrame(MainCont.getFrameMain());
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
				if (sindicatos.add(SindicatoFac.getRegistro(sindicato))) {
					SindicatoRel sindicatoRel = new SindicatoRel(sindicatos);
					sindicatoRel.retornarRelatorio(true);
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
				sindicatos = new LinkedList<>(SindicatoFac.pesquisarRegistro(sindicato));
			} catch (Exception e) {
				System.out.println(e);
			}
			SindicatoRel sindicatoRel = new SindicatoRel(sindicatos);
			sindicatoRel.retornarRelatorio(true);
		}
	}

	public class MostraFrameSindicato extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCont.mostrarFrame(MainCont.getSindicatoFc());
			} else {
				MainCont.getSindicatoFc().reiniciarGUI();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			sindicato = new Sindicato();
			getSindicatoFc().limparGUI();
			getSindicatoPc().getNomeFantasiaGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			sindicato = new Sindicato();
			atualizarObjeto();
			getSindicatoPp().pesquisarRegistroSindicato(sindicato);
			MainCont.mostrarFrame(MainCont.getSindicatoFc());
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
				String nome = getSindicatoPc().getNomeFantasiaGUI().getText();
				if (nome == null || nome.length() == 0) {
					getSindicatoPc().getNomeFantasiaGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					SindicatoFac.salvarRegistro(sindicato);
					sindicato = new Sindicato();
					getSindicatoFc().limparGUI();
					getSindicatoPc().getNomeFantasiaGUI().requestFocus();
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
		getSindicatoPc().getNomeFantasiaGUI().setText(sindicato.getNomeFantasia());
		getSindicatoPc().getNumeroFuncionariosGUI().setText(sindicato.getNumeroFuncionarios());
		getSindicatoPc().getRamoAtividadeGUI().setText(sindicato.getRamoAtividade());
		getSindicatoPc().getNomeFantasiaGUI().setText(sindicato.getNomeFantasia());
		getSindicatoPc().getRazaoSocialGUI().setText(sindicato.getRazaoSocial());
		getSindicatoPc().getEmailGUI().setText(sindicato.getEmail());
		getSindicatoPc().getFaxGUI().setText(sindicato.getFax());
		getSindicatoPc().getFone1GUI().setText(sindicato.getFone1());
		getSindicatoPc().getFone2GUI().setText(sindicato.getFone2());
		getSindicatoPc().getTextEstadualGUI().setText(sindicato.getInscricaoEstadual());
		getSindicatoPc().getInscricaoMunicipalGUI().setText(sindicato.getInscricaoMunicipal());
		getSindicatoPc().getCapitalSocialGUI().setText(sindicato.getCapitalSocial());
		getSindicatoPc().getDataFundacaoGUI().setText(sindicato.getDataFundacao());
		getSindicatoPc().getBairroGUI().setText(sindicato.getBairro());
		getSindicatoPc().getCepGUI().setText(sindicato.getCep());
		getSindicatoPc().getCidadeGUI().setText(sindicato.getCidade());
		getSindicatoPc().getComplementoGUI().setText(sindicato.getComplemento());
		getSindicatoPc().getEstadoGUI().setText(sindicato.getEstado());
		getSindicatoPc().getLogradouroGUI().setText(sindicato.getLogradouro());
		getSindicatoPc().getPaisGUI().setText(sindicato.getPais());
		getSindicatoPc().getCnpjGUI().setText(sindicato.getCnpj());
		getSindicatoPc().getTipoSindicatoGUI().setSelectedItem(sindicato.getTipoSindicato());
		getSindicatoPc().getFaturamentoMensalGUI().setText(sindicato.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		sindicato.setNomeFantasia(getSindicatoPc().getNomeFantasiaGUI().getText());
		sindicato.setNumeroFuncionarios(getSindicatoPc().getNumeroFuncionariosGUI().getText());
		sindicato.setRamoAtividade(getSindicatoPc().getRamoAtividadeGUI().getText());
		sindicato.setRazaoSocial(getSindicatoPc().getRazaoSocialGUI().getText());
		sindicato.setEmail(getSindicatoPc().getEmailGUI().getText());
		sindicato.setFax(getSindicatoPc().getFaxGUI().getText());
		sindicato.setFone1(getSindicatoPc().getFone1GUI().getText());
		sindicato.setFone2(getSindicatoPc().getFone2GUI().getText());
		sindicato.setInscricaoEstadual(getSindicatoPc().getTextEstadualGUI().getText());
		sindicato.setInscricaoMunicipal(getSindicatoPc().getInscricaoMunicipalGUI().getText());
		sindicato.setCapitalSocial(getSindicatoPc().getCapitalSocialGUI().getText());
		sindicato.setDataFundacao(getSindicatoPc().getDataFundacaoGUI().getText());
		sindicato.setBairro(getSindicatoPc().getBairroGUI().getText());
		sindicato.setCep(getSindicatoPc().getCepGUI().getText());
		sindicato.setCidade(getSindicatoPc().getCidadeGUI().getText());
		sindicato.setComplemento(getSindicatoPc().getComplementoGUI().getText());
		sindicato.setEstado(getSindicatoPc().getEstadoGUI().getText());
		sindicato.setLogradouro(getSindicatoPc().getLogradouroGUI().getText());
		sindicato.setPais(getSindicatoPc().getPaisGUI().getText());
		sindicato.setCnpj(getSindicatoPc().getCnpjGUI().getText());
		sindicato.setTipoSindicato((String) getSindicatoPc().getTipoSindicatoGUI().getSelectedItem());
		sindicato.setFaturamentoMensal(getSindicatoPc().getFaturamentoMensalGUI().getText());
	}

	public Sindicato getSindicato() {
		return sindicato;
	}

	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}

	public SindicatoFc getSindicatoFc() {
		return MainCont.getSindicatoFc();
	}

	public SindicatoPc getSindicatoPc() {
		return MainCont.getSindicatoFc().getSindicatoPc();
	}

	public SindicatoFp getSindicatoFp() {
		return MainCont.getSindicatoFp();
	}

	public SindicatoPp getSindicatoPp() {
		return MainCont.getSindicatoFp().getSindicatoPp();
	}
}
