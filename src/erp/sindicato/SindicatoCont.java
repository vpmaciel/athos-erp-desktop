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
			getSindicatoPc().getGuiNomeFantasia().requestFocus();
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
				String nome = getSindicatoPc().getGuiNomeFantasia().getText();
				if (nome == null || nome.length() == 0) {
					getSindicatoPc().getGuiNomeFantasia().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					SindicatoFac.salvarRegistro(sindicato);
					sindicato = new Sindicato();
					getSindicatoFc().limparGui();
					getSindicatoPc().getGuiNomeFantasia().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
				Sindicato sindicatoPesquisa = new Sindicato();
				sindicatoPesquisa.setCnpj(getSindicatoPc().getGuiCnpj().getText());
				Sindicato sindicatoPesquisaRetornado = SindicatoFac.consultarRegistro(sindicatoPesquisa);

				if (sindicato.getId() == null && sindicatoPesquisa.getCnpj() != null
						&& sindicatoPesquisaRetornado.getCnpj() != null) {
					if (sindicatoPesquisa.getCnpj().equals(sindicatoPesquisaRetornado.getCnpj())) {
						Msg.avisoCampoDuplicado("CNPJ", sindicatoPesquisa.getCnpj());
						getSindicatoPc().getGuiCnpj().requestFocus();
						return;
					}
				}

				if (sindicato.getId() != null && sindicatoPesquisa.getCnpj() != null
						&& sindicatoPesquisaRetornado.getCnpj() != null) {
					if (!sindicato.getCnpj().equals(sindicatoPesquisa.getCnpj())) {
						if (sindicatoPesquisa.getCnpj().equals(sindicatoPesquisaRetornado.getCnpj())) {
							Msg.avisoCampoDuplicado("CNPJ", sindicatoPesquisa.getCnpj());
							getSindicatoPc().getGuiCnpj().requestFocus();
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
		getSindicatoPc().getGuiNomeFantasia().setText(sindicato.getNomeFantasia());
		getSindicatoPc().getGuiNumeroFuncionarios().setText(sindicato.getNumeroFuncionarios());
		getSindicatoPc().getGuiRamoAtividade().setText(sindicato.getRamoAtividade());
		getSindicatoPc().getGuiRazaoSocial().setText(sindicato.getRazaoSocial());
		getSindicatoPc().getGuiEmail().setText(sindicato.getEmail());
		getSindicatoPc().getGuiFax().setText(sindicato.getFax());
		getSindicatoPc().getGuiFone1().setText(sindicato.getFone1());
		getSindicatoPc().getGuiFone2().setText(sindicato.getFone2());
		getSindicatoPc().getGuiTextEstadual().setText(sindicato.getInscricaoEstadual());
		getSindicatoPc().getGuiInscricaoMunicipal().setText(sindicato.getInscricaoMunicipal());
		getSindicatoPc().getGuiCapitalSocial().setText(sindicato.getCapitalSocial());
		getSindicatoPc().getGuiDataFundacao().setText(sindicato.getDataFundacao());
		getSindicatoPc().getGuiBairro().setText(sindicato.getBairro());
		getSindicatoPc().getGuiCep().setText(sindicato.getCep());
		getSindicatoPc().getGuiCidade().setText(sindicato.getCidade());
		getSindicatoPc().getGuiComplemento().setText(sindicato.getComplemento());
		getSindicatoPc().getGuiEstado().setText(sindicato.getEstado());
		getSindicatoPc().getGuiLogradouro().setText(sindicato.getLogradouro());
		getSindicatoPc().getGuiPais().setText(sindicato.getPais());
		getSindicatoPc().getGuiCnpj().setText(sindicato.getCnpj());
		getSindicatoPc().getGuiTipoSindicato().setSelectedItem(sindicato.getTipoSindicato());
		getSindicatoPc().getGuiFaturamentoMensal().setText(sindicato.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		sindicato.setNomeFantasia(getSindicatoPc().getGuiNomeFantasia().getText());
		sindicato.setNumeroFuncionarios(getSindicatoPc().getGuiNumeroFuncionarios().getText());
		sindicato.setRamoAtividade(getSindicatoPc().getGuiRamoAtividade().getText());
		sindicato.setRazaoSocial(getSindicatoPc().getGuiRazaoSocial().getText());
		sindicato.setEmail(getSindicatoPc().getGuiEmail().getText());
		sindicato.setFax(getSindicatoPc().getGuiFax().getText());
		sindicato.setFone1(getSindicatoPc().getGuiFone1().getText());
		sindicato.setFone2(getSindicatoPc().getGuiFone2().getText());
		sindicato.setInscricaoEstadual(getSindicatoPc().getGuiTextEstadual().getText());
		sindicato.setInscricaoMunicipal(getSindicatoPc().getGuiInscricaoMunicipal().getText());
		sindicato.setCapitalSocial(getSindicatoPc().getGuiCapitalSocial().getText());
		sindicato.setDataFundacao(getSindicatoPc().getGuiDataFundacao().getText());
		sindicato.setBairro(getSindicatoPc().getGuiBairro().getText());
		sindicato.setCep(getSindicatoPc().getGuiCep().getText());
		sindicato.setCidade(getSindicatoPc().getGuiCidade().getText());
		sindicato.setComplemento(getSindicatoPc().getGuiComplemento().getText());
		sindicato.setEstado(getSindicatoPc().getGuiEstado().getText());
		sindicato.setLogradouro(getSindicatoPc().getGuiLogradouro().getText());
		sindicato.setPais(getSindicatoPc().getGuiPais().getText());
		sindicato.setCnpj(getSindicatoPc().getGuiCnpj().getText());
		sindicato.setTipoSindicato((String) getSindicatoPc().getGuiTipoSindicato().getSelectedItem());
		sindicato.setFaturamentoMensal(getSindicatoPc().getGuiFaturamentoMensal().getText());

		if (getSindicatoPc().getGuiCnpj().getText().equals(Mascara.getCnpjVazio())) {
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
