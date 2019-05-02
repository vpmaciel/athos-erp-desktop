package erp.empresa;

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
import erp.main.MainFc;

final class EmpresaCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (empresa == null || empresa.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				EmpresaFac.deletarRegistro(empresa);
				getEmpresaFc().limparGui();
				empresa = new Empresa();
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
				getEmpresaFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getEmpresaFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getEmpresaFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			empresa = new Empresa();
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

			List<Empresa> empresas = new LinkedList<>();

			try {
				empresas = new LinkedList<>(EmpresaFac.pesquisarRegistro(new Empresa()));
			} catch (Exception e) {
				System.out.println(e);
			}

			EmpresaRel empresaRel = new EmpresaRel(empresas);
			empresaRel.retornarRelatorio(true);

		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Empresa> empresas = new LinkedList<>();

			if (empresa.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (empresas.add(EmpresaFac.getRegistro(empresa))) {
				EmpresaRel empresaRel = new EmpresaRel(empresas);
				empresaRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrameEmpresa extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCont.mostrarFrame(getEmpresaFc());
			} else {
				getEmpresaFc().reiniciarGui();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			empresa = new Empresa();
			getEmpresaFc().limparGui();
			getEmpresaPc().getNomeFantasiaGui().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getEmpresaPp().pesquisarRegistroEmpresa(empresa);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainFc.mostrarFrame(getEmpresaFp());
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

				String nomeFantasia = getEmpresaPc().getNomeFantasiaGui().getText();

				if (nomeFantasia == null || nomeFantasia.length() == 0) {
					getEmpresaPc().getNomeFantasiaGui().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}

				Empresa empresaPesquisa = new Empresa();
				empresaPesquisa.setCnpj(getEmpresaPc().getCnpjGui().getText());
				Empresa empresaPesquisaRetornado = EmpresaFac.consultarRegistro(empresaPesquisa);

				if (empresa.getId() == null && empresaPesquisa.getCnpj() != null
						&& empresaPesquisaRetornado.getCnpj() != null) {

					if (empresaPesquisa.getCnpj().equals(empresaPesquisaRetornado.getCnpj())) {
						Msg.avisoCampoDuplicado("CNPJ", empresaPesquisa.getCnpj());
						getEmpresaPc().getCnpjGui().requestFocus();
						return;
					}
				}

				if (empresa.getId() != null && empresaPesquisa.getCnpj() != null
						&& empresaPesquisaRetornado.getCnpj() != null) {
					if (!empresa.getCnpj().equals(empresaPesquisa.getCnpj())) {
						if (empresaPesquisa.getCnpj().equals(empresaPesquisaRetornado.getCnpj())) {
							Msg.avisoCampoDuplicado("CNPJ", empresaPesquisa.getCnpj());
							getEmpresaPc().getCnpjGui().requestFocus();
						}
						return;
					}
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					EmpresaFac.salvarRegistro(empresa);
					empresa = new Empresa();
					getEmpresaFc().limparGui();
					getEmpresaPc().getNomeFantasiaGui().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Empresa empresa;

	public void atualizarGui() {
		if (empresa == null) {
			return;
		}
		getEmpresaPc().getNomeFantasiaGui().setText(empresa.getNomeFantasia());
		getEmpresaPc().getNumeroFuncionariosGui().setText(empresa.getNumeroFuncionarios());
		getEmpresaPc().getRamoAtividadeGui().setText(empresa.getRamoAtividade());
		getEmpresaPc().getNomeFantasiaGui().setText(empresa.getNomeFantasia());
		getEmpresaPc().getRazaoSocialGui().setText(empresa.getRazaoSocial());
		getEmpresaPc().getEmailGui().setText(empresa.getEmail());
		getEmpresaPc().getFaxGui().setText(empresa.getFax());
		getEmpresaPc().getFone1Gui().setText(empresa.getFone1());
		getEmpresaPc().getFone2Gui().setText(empresa.getFone2());
		getEmpresaPc().getInscricaoEstadualGui().setText(empresa.getInscricaoEstadual());
		getEmpresaPc().getInscricaoMunicipalGui().setText(empresa.getInscricaoMunicipal());
		getEmpresaPc().getCapitalSocialGui().setText(empresa.getCapitalSocial());
		getEmpresaPc().getDataFundacaoGui().setText(empresa.getDataFundacao());
		getEmpresaPc().getBairroGui().setText(empresa.getBairro());
		getEmpresaPc().getCepGui().setText(empresa.getCep());
		getEmpresaPc().getCidadeGui().setText(empresa.getCidade());
		getEmpresaPc().getComplementoGui().setText(empresa.getComplemento());
		getEmpresaPc().getEstadoGui().setText(empresa.getEstado());
		getEmpresaPc().getLogradouroGui().setText(empresa.getLogradouro());
		getEmpresaPc().getPaisGui().setText(empresa.getPais());
		getEmpresaPc().getCnpjGui().setText(empresa.getCnpj());
		getEmpresaPc().getEmpresaGui().setSelectedItem(empresa.getTipoEmpresa());
		getEmpresaPc().getFaturamentoMensalGui().setText(empresa.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		empresa.setNomeFantasia(getEmpresaPc().getNomeFantasiaGui().getText());
		empresa.setNumeroFuncionarios(getEmpresaPc().getNumeroFuncionariosGui().getText());
		empresa.setRamoAtividade(getEmpresaPc().getRamoAtividadeGui().getText());
		empresa.setNomeFantasia(getEmpresaPc().getNomeFantasiaGui().getText());
		empresa.setRazaoSocial(getEmpresaPc().getRazaoSocialGui().getText());
		empresa.setEmail(getEmpresaPc().getEmailGui().getText());
		empresa.setFax(getEmpresaPc().getFaxGui().getText());
		empresa.setFone1(getEmpresaPc().getFone1Gui().getText());
		empresa.setFone2(getEmpresaPc().getFone2Gui().getText());
		empresa.setInscricaoEstadual(getEmpresaPc().getInscricaoEstadualGui().getText());
		empresa.setInscricaoMunicipal(getEmpresaPc().getInscricaoMunicipalGui().getText());
		empresa.setCapitalSocial(getEmpresaPc().getCapitalSocialGui().getText());
		empresa.setDataFundacao(getEmpresaPc().getDataFundacaoGui().getText());
		empresa.setBairro(getEmpresaPc().getBairroGui().getText());
		empresa.setCep(getEmpresaPc().getCepGui().getText());
		empresa.setCidade(getEmpresaPc().getCidadeGui().getText());
		empresa.setComplemento(getEmpresaPc().getComplementoGui().getText());
		empresa.setEstado(getEmpresaPc().getEstadoGui().getText());
		empresa.setLogradouro(getEmpresaPc().getLogradouroGui().getText());
		empresa.setPais(getEmpresaPc().getPaisGui().getText());
		empresa.setCnpj(getEmpresaPc().getCnpjGui().getText());
		empresa.setTipoEmpresa((String) getEmpresaPc().getEmpresaGui().getSelectedItem());
		empresa.setFaturamentoMensal(getEmpresaPc().getFaturamentoMensalGui().getText());

		if (getEmpresaPc().getCnpjGui().getText().equals(Mascara.getCnpjVazio())) {
			empresa.setCnpj(null);
		}
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public EmpresaFc getEmpresaFc() {
		return MainCont.getEmpresaFc();
	}

	public EmpresaPc getEmpresaPc() {
		return MainCont.getEmpresaFc().getEmpresaPc();
	}

	public EmpresaFp getEmpresaFp() {
		return MainCont.getEmpresaFp();
	}

	public EmpresaPp getEmpresaPp() {
		return MainCont.getEmpresaFp().getEmpresaPp();
	}
}
