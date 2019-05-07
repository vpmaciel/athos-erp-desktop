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
			getEmpresaPc().getGuiNomeFantasia().requestFocus();
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

				String nomeFantasia = getEmpresaPc().getGuiNomeFantasia().getText();

				if (nomeFantasia == null || nomeFantasia.length() == 0) {
					getEmpresaPc().getGuiNomeFantasia().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}

				Empresa empresaPesquisa = new Empresa();
				empresaPesquisa.setCnpj(getEmpresaPc().getGuiCnpj().getText());
				Empresa empresaPesquisaRetornado = EmpresaFac.consultarRegistro(empresaPesquisa);

				if (empresa.getId() == null && empresaPesquisa.getCnpj() != null
						&& empresaPesquisaRetornado.getCnpj() != null) {

					if (empresaPesquisa.getCnpj().equals(empresaPesquisaRetornado.getCnpj())) {
						Msg.avisoCampoDuplicado("CNPJ", empresaPesquisa.getCnpj());
						getEmpresaPc().getGuiCnpj().requestFocus();
						return;
					}
				}

				if (empresa.getId() != null && empresaPesquisa.getCnpj() != null
						&& empresaPesquisaRetornado.getCnpj() != null) {
					if (!empresa.getCnpj().equals(empresaPesquisa.getCnpj())) {
						if (empresaPesquisa.getCnpj().equals(empresaPesquisaRetornado.getCnpj())) {
							Msg.avisoCampoDuplicado("CNPJ", empresaPesquisa.getCnpj());
							getEmpresaPc().getGuiCnpj().requestFocus();
						}
						return;
					}
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					EmpresaFac.salvarRegistro(empresa);
					empresa = new Empresa();
					getEmpresaFc().limparGui();
					getEmpresaPc().getGuiNomeFantasia().requestFocus();
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
		getEmpresaPc().getGuiNomeFantasia().setText(empresa.getNomeFantasia());
		getEmpresaPc().getGuiNumeroFuncionarios().setText(empresa.getNumeroFuncionarios());
		getEmpresaPc().getGuiRamoAtividade().setText(empresa.getRamoAtividade());
		getEmpresaPc().getGuiRazaoSocial().setText(empresa.getRazaoSocial());
		getEmpresaPc().getGuiEmail().setText(empresa.getEmail());
		getEmpresaPc().getGuiFax().setText(empresa.getFax());
		getEmpresaPc().getGuiFone1().setText(empresa.getFone1());
		getEmpresaPc().getGuiFone2().setText(empresa.getFone2());
		getEmpresaPc().getGuiInscricaoEstadual().setText(empresa.getInscricaoEstadual());
		getEmpresaPc().getGuiInscricaoMunicipal().setText(empresa.getInscricaoMunicipal());
		getEmpresaPc().getGuiCapitalSocial().setText(empresa.getCapitalSocial());
		getEmpresaPc().getGuiDataFundacao().setText(empresa.getDataFundacao());
		getEmpresaPc().getGuiBairro().setText(empresa.getBairro());
		getEmpresaPc().getGuiCep().setText(empresa.getCep());
		getEmpresaPc().getGuiCidade().setText(empresa.getCidade());
		getEmpresaPc().getGuiComplemento().setText(empresa.getComplemento());
		getEmpresaPc().getGuiEstado().setText(empresa.getEstado());
		getEmpresaPc().getGuiLogradouro().setText(empresa.getLogradouro());
		getEmpresaPc().getGuiPais().setText(empresa.getPais());
		getEmpresaPc().getGuiCnpj().setText(empresa.getCnpj());
		getEmpresaPc().getGuiEmpresa().setSelectedItem(empresa.getTipoEmpresa());
		getEmpresaPc().getGuiFaturamentoMensal().setText(empresa.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		empresa.setNomeFantasia(getEmpresaPc().getGuiNomeFantasia().getText());
		empresa.setNumeroFuncionarios(getEmpresaPc().getGuiNumeroFuncionarios().getText());
		empresa.setRamoAtividade(getEmpresaPc().getGuiRamoAtividade().getText());
		empresa.setRazaoSocial(getEmpresaPc().getGuiRazaoSocial().getText());
		empresa.setEmail(getEmpresaPc().getGuiEmail().getText());
		empresa.setFax(getEmpresaPc().getGuiFax().getText());
		empresa.setFone1(getEmpresaPc().getGuiFone1().getText());
		empresa.setFone2(getEmpresaPc().getGuiFone2().getText());
		empresa.setInscricaoEstadual(getEmpresaPc().getGuiInscricaoEstadual().getText());
		empresa.setInscricaoMunicipal(getEmpresaPc().getGuiInscricaoMunicipal().getText());
		empresa.setCapitalSocial(getEmpresaPc().getGuiCapitalSocial().getText());
		empresa.setDataFundacao(getEmpresaPc().getGuiDataFundacao().getText());
		empresa.setBairro(getEmpresaPc().getGuiBairro().getText());
		empresa.setCep(getEmpresaPc().getGuiCep().getText());
		empresa.setCidade(getEmpresaPc().getGuiCidade().getText());
		empresa.setComplemento(getEmpresaPc().getGuiComplemento().getText());
		empresa.setEstado(getEmpresaPc().getGuiEstado().getText());
		empresa.setLogradouro(getEmpresaPc().getGuiLogradouro().getText());
		empresa.setPais(getEmpresaPc().getGuiPais().getText());
		empresa.setCnpj(getEmpresaPc().getGuiCnpj().getText());
		empresa.setTipoEmpresa((String) getEmpresaPc().getGuiEmpresa().getSelectedItem());
		empresa.setFaturamentoMensal(getEmpresaPc().getGuiFaturamentoMensal().getText());

		if (getEmpresaPc().getGuiCnpj().getText().equals(Mascara.getCnpjVazio())) {
			empresa.setCnpj(null);
		}
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public EmpresaFc getEmpresaFc() {
		return MainCont.getEmpresaFc();
	}

	public EmpresaFp getEmpresaFp() {
		return MainCont.getEmpresaFp();
	}

	public EmpresaPc getEmpresaPc() {
		return MainCont.getEmpresaFc().getEmpresaPc();
	}

	public EmpresaPp getEmpresaPp() {
		return MainCont.getEmpresaFp().getEmpresaPp();
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
