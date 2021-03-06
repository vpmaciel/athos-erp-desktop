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
import erp.main.MainControl;

final class EmpresaControl {

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
				e.printStackTrace();
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
				MainControl.mostrarFrame(MainControl.getMainFc());
			} catch (Exception e) {
				e.printStackTrace();
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
				MainControl.mostrarFrame(getEmpresaFc());
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
			totalPesquisaRegistro = getEmpresaPp().pesquisarRegistro(empresa);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getEmpresaFp());
				getEmpresaFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getEmpresaPp().pesquisarRegistro(new Empresa());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getEmpresaFp());
				getEmpresaFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
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
				e.printStackTrace();
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
				e.printStackTrace();
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
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					EmpresaFac.salvarRegistro(empresa);
					empresa = new Empresa();
					getEmpresaFc().limparGui();
					getEmpresaPc().getGuiNomeFantasia().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Throwable throwable = e.getCause().getCause();
				String mensagem = throwable.toString();
				if (mensagem.contains("ConstraintViolationException")) {
					if (mensagem.contains("INDEX_EMPRESA_CNPJ")) {
						Msg.avisoCampoDuplicado("CNPJ");
						getEmpresaPc().getGuiCnpj().requestFocus();
					} else {
						Msg.avisoCampoDuplicado();
					}
				}
				e.printStackTrace();
				Msg.erroSalvarRegistro();
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
		getEmpresaPc().getGuiBairro().setText(empresa.getEnderecoBairro());
		getEmpresaPc().getGuiCep().setText(empresa.getEnderecoCep());
		getEmpresaPc().getGuiCidade().setText(empresa.getEnderecoCidade());
		getEmpresaPc().getGuiComplemento().setText(empresa.getEnderecoComplemento());
		getEmpresaPc().getGuiEstado().setText(empresa.getEnderecoEstado());
		getEmpresaPc().getGuiLogradouro().setText(empresa.getEnderecoLogradouro());
		getEmpresaPc().getGuiPais().setText(empresa.getEnderecoPais());
		getEmpresaPc().getGuiCnpj().setText(empresa.getCnpj());
		getEmpresaPc().getGuiEmpresa().setSelectedItem(empresa.getTipoEmpresa());
		getEmpresaPc().getGuiFaturamentoMensal().setValue(empresa.getFaturamentoMensal());
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
		empresa.setEnderecoBairro(getEmpresaPc().getGuiBairro().getText());
		empresa.setEnderecoCep(getEmpresaPc().getGuiCep().getText());
		empresa.setEnderecoCidade(getEmpresaPc().getGuiCidade().getText());
		empresa.setEnderecoComplemento(getEmpresaPc().getGuiComplemento().getText());
		empresa.setEnderecoEstado(getEmpresaPc().getGuiEstado().getText());
		empresa.setEnderecoLogradouro(getEmpresaPc().getGuiLogradouro().getText());
		empresa.setEnderecoPais(getEmpresaPc().getGuiPais().getText());
		empresa.setCnpj(getEmpresaPc().getGuiCnpj().getText());
		empresa.setTipoEmpresa((String) getEmpresaPc().getGuiEmpresa().getSelectedItem());
		try {
			empresa.setFaturamentoMensal((Double) getEmpresaPc().getGuiFaturamentoMensal().getValue());
		} catch (Exception exception) {
			empresa.setFaturamentoMensal(null);
		}

		if (getEmpresaPc().getGuiCnpj().getText().equals(Mascara.getCnpjVazio())) {
			empresa.setCnpj(null);
		}
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public EmpresaFc getEmpresaFc() {
		return MainControl.getEmpresaFc();
	}

	public EmpresaFp getEmpresaFp() {
		return MainControl.getEmpresaFp();
	}

	public EmpresaPc getEmpresaPc() {
		return MainControl.getEmpresaFc().getEmpresaPc();
	}

	public EmpresaPp getEmpresaPp() {
		return MainControl.getEmpresaFp().getEmpresaPp();
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
