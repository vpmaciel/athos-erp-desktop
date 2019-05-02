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
import arquitetura.validacao.Mascara;
import erp.sindicato.Sindicato;
import erp.sindicato.SindicatoFac;
import erp.main.MainCont;
import erp.main.MainFc;

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
				getSindicatoFc().limparGui();
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
			getSindicatoFc().reiniciarGui();
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
				MainCont.mostrarFrame(MainCont.getMainFc());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Sindicato> sindicatos = new LinkedList<>();

			try {
				sindicatos = new LinkedList<>(SindicatoFac.pesquisarRegistro(new Sindicato()));
			} catch (Exception e) {
				System.out.println(e);
			}

			SindicatoRel sindicatoRel = new SindicatoRel(sindicatos);
			sindicatoRel.retornarRelatorio(true);

		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Sindicato> sindicatos = new LinkedList<>();

			if (sindicato.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (sindicatos.add(SindicatoFac.getRegistro(sindicato))) {
				SindicatoRel sindicatoRel = new SindicatoRel(sindicatos);
				sindicatoRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrameSindicato extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCont.mostrarFrame(MainCont.getSindicatoFc());
			} else {
				MainCont.getSindicatoFc().reiniciarGui();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			sindicato = new Sindicato();
			getSindicatoFc().limparGui();
			getSindicatoPc().getNomeFantasiaGui().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getSindicatoPp().pesquisarRegistroSindicato(sindicato);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainFc.mostrarFrame(getSindicatoFp());
			}
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
				String nome = getSindicatoPc().getNomeFantasiaGui().getText();
				if (nome == null || nome.length() == 0) {
					getSindicatoPc().getNomeFantasiaGui().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					SindicatoFac.salvarRegistro(sindicato);
					sindicato = new Sindicato();
					getSindicatoFc().limparGui();
					getSindicatoPc().getNomeFantasiaGui().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
				Sindicato sindicatoPesquisa = new Sindicato();
				sindicatoPesquisa.setCnpj(getSindicatoPc().getCnpjGui().getText());
				Sindicato sindicatoPesquisaRetornado = SindicatoFac.consultarRegistro(sindicatoPesquisa);

				if (sindicato.getId() == null && sindicatoPesquisa.getCnpj() != null
						&& sindicatoPesquisaRetornado.getCnpj() != null) {
					if (sindicatoPesquisa.getCnpj().equals(sindicatoPesquisaRetornado.getCnpj())) {
						Msg.avisoCampoDuplicado("CNPJ", sindicatoPesquisa.getCnpj());
						getSindicatoPc().getCnpjGui().requestFocus();
						return;
					}
				}

				if (sindicato.getId() != null && sindicatoPesquisa.getCnpj() != null
						&& sindicatoPesquisaRetornado.getCnpj() != null) {
					if (!sindicato.getCnpj().equals(sindicatoPesquisa.getCnpj())) {
						if (sindicatoPesquisa.getCnpj().equals(sindicatoPesquisaRetornado.getCnpj())) {
							Msg.avisoCampoDuplicado("CNPJ", sindicatoPesquisa.getCnpj());
							getSindicatoPc().getCnpjGui().requestFocus();
						}
						return;
					}
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
		getSindicatoPc().getNomeFantasiaGui().setText(sindicato.getNomeFantasia());
		getSindicatoPc().getNumeroFuncionariosGui().setText(sindicato.getNumeroFuncionarios());
		getSindicatoPc().getRamoAtividadeGui().setText(sindicato.getRamoAtividade());
		getSindicatoPc().getNomeFantasiaGui().setText(sindicato.getNomeFantasia());
		getSindicatoPc().getRazaoSocialGui().setText(sindicato.getRazaoSocial());
		getSindicatoPc().getEmailGui().setText(sindicato.getEmail());
		getSindicatoPc().getFaxGui().setText(sindicato.getFax());
		getSindicatoPc().getFone1Gui().setText(sindicato.getFone1());
		getSindicatoPc().getFone2Gui().setText(sindicato.getFone2());
		getSindicatoPc().getTextEstadualGui().setText(sindicato.getInscricaoEstadual());
		getSindicatoPc().getInscricaoMunicipalGui().setText(sindicato.getInscricaoMunicipal());
		getSindicatoPc().getCapitalSocialGui().setText(sindicato.getCapitalSocial());
		getSindicatoPc().getDataFundacaoGui().setText(sindicato.getDataFundacao());
		getSindicatoPc().getBairroGui().setText(sindicato.getBairro());
		getSindicatoPc().getCepGui().setText(sindicato.getCep());
		getSindicatoPc().getCidadeGui().setText(sindicato.getCidade());
		getSindicatoPc().getComplementoGui().setText(sindicato.getComplemento());
		getSindicatoPc().getEstadoGui().setText(sindicato.getEstado());
		getSindicatoPc().getLogradouroGui().setText(sindicato.getLogradouro());
		getSindicatoPc().getPaisGui().setText(sindicato.getPais());
		getSindicatoPc().getCnpjGui().setText(sindicato.getCnpj());
		getSindicatoPc().getTipoSindicatoGui().setSelectedItem(sindicato.getTipoSindicato());
		getSindicatoPc().getFaturamentoMensalGui().setText(sindicato.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		sindicato.setNomeFantasia(getSindicatoPc().getNomeFantasiaGui().getText());
		sindicato.setNumeroFuncionarios(getSindicatoPc().getNumeroFuncionariosGui().getText());
		sindicato.setRamoAtividade(getSindicatoPc().getRamoAtividadeGui().getText());
		sindicato.setRazaoSocial(getSindicatoPc().getRazaoSocialGui().getText());
		sindicato.setEmail(getSindicatoPc().getEmailGui().getText());
		sindicato.setFax(getSindicatoPc().getFaxGui().getText());
		sindicato.setFone1(getSindicatoPc().getFone1Gui().getText());
		sindicato.setFone2(getSindicatoPc().getFone2Gui().getText());
		sindicato.setInscricaoEstadual(getSindicatoPc().getTextEstadualGui().getText());
		sindicato.setInscricaoMunicipal(getSindicatoPc().getInscricaoMunicipalGui().getText());
		sindicato.setCapitalSocial(getSindicatoPc().getCapitalSocialGui().getText());
		sindicato.setDataFundacao(getSindicatoPc().getDataFundacaoGui().getText());
		sindicato.setBairro(getSindicatoPc().getBairroGui().getText());
		sindicato.setCep(getSindicatoPc().getCepGui().getText());
		sindicato.setCidade(getSindicatoPc().getCidadeGui().getText());
		sindicato.setComplemento(getSindicatoPc().getComplementoGui().getText());
		sindicato.setEstado(getSindicatoPc().getEstadoGui().getText());
		sindicato.setLogradouro(getSindicatoPc().getLogradouroGui().getText());
		sindicato.setPais(getSindicatoPc().getPaisGui().getText());
		sindicato.setCnpj(getSindicatoPc().getCnpjGui().getText());
		sindicato.setTipoSindicato((String) getSindicatoPc().getTipoSindicatoGui().getSelectedItem());
		sindicato.setFaturamentoMensal(getSindicatoPc().getFaturamentoMensalGui().getText());

		if (getSindicatoPc().getCnpjGui().getText().equals(Mascara.getCnpjVazio())) {
			sindicato.setCnpj(null);
		}
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
