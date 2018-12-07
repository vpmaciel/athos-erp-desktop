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
import erp.main.MainCT;

final class EmpresaCT {

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
				EmpresaFAC.deletarRegistro(empresa);
				getEmpresaFC().limparGUI();
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
				getEmpresaFC().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getEmpresaFC().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getEmpresaFC().setVisible(false);
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
				MainCT.mostrarFrame(MainCT.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Empresa> empresas = new LinkedList<>();

			if (empresa.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (empresas.add(EmpresaFAC.getRegistro(empresa))) {
					EmpresaREL empresaREL = new EmpresaREL(empresas);
					empresaREL.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Empresa> empresas = new LinkedList<>();

			try {
				empresas = new LinkedList<>(EmpresaFAC.pesquisarRegistro(empresa));
			} catch (Exception e) {
				System.out.println(e);
			}
			EmpresaREL empresaREL = new EmpresaREL(empresas);
			empresaREL.retornarRelatorio(true);
		}
	}

	public class MostraFrameEmpresa extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCT.mostrarFrame(getEmpresaFC());
			} else {
				getEmpresaFC().reiniciarGUI();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			empresa = new Empresa();
			getEmpresaFC().limparGUI();
			getEmpresaPC().getNomeFantasiaGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			empresa = new Empresa();
			atualizarObjeto();
			getEmpresaPP().pesquisarRegistroEmpresa(empresa);
			MainCT.mostrarFrame(getEmpresaFP());
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
				String nomeFantasia = getEmpresaPC().getNomeFantasiaGUI().getText();
				if (nomeFantasia == null || nomeFantasia.length() == 0) {
					getEmpresaPC().getNomeFantasiaGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					EmpresaFAC.salvarRegistro(empresa);
					empresa = new Empresa();
					getEmpresaFC().limparGUI();
					getEmpresaPC().getNomeFantasiaGUI().requestFocus();
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
		getEmpresaPC().getNomeFantasiaGUI().setText(empresa.getNomeFantasia());
		getEmpresaPC().getNumeroFuncionariosGUI().setText(empresa.getNumeroFuncionarios());
		getEmpresaPC().getRamoAtividadeGUI().setText(empresa.getRamoAtividade());
		getEmpresaPC().getNomeFantasiaGUI().setText(empresa.getNomeFantasia());
		getEmpresaPC().getRazaoSocialGUI().setText(empresa.getRazaoSocial());
		getEmpresaPC().getEmailGUI().setText(empresa.getEmail());
		getEmpresaPC().getFaxGUI().setText(empresa.getFax());
		getEmpresaPC().getFone1GUI().setText(empresa.getFone1());
		getEmpresaPC().getFone2GUI().setText(empresa.getFone2());
		getEmpresaPC().getInscricaoEstadualGUI().setText(empresa.getInscricaoEstadual());
		getEmpresaPC().getInscricaoMunicipalGUI().setText(empresa.getInscricaoMunicipal());
		getEmpresaPC().getCapitalSocialGUI().setText(empresa.getCapitalSocial());
		getEmpresaPC().getDataFundacaoGUI().setText(empresa.getDataFundacao());
		getEmpresaPC().getBairroGUI().setText(empresa.getBairro());
		getEmpresaPC().getCepGUI().setText(empresa.getCep());
		getEmpresaPC().getCidadeGUI().setText(empresa.getCidade());
		getEmpresaPC().getComplementoGUI().setText(empresa.getComplemento());
		getEmpresaPC().getEstadoGUI().setText(empresa.getEstado());
		getEmpresaPC().getLogradouroGUI().setText(empresa.getLogradouro());
		getEmpresaPC().getPaisGUI().setText(empresa.getPais());
		getEmpresaPC().getCnpjGUI().setText(empresa.getCnpj());
		getEmpresaPC().getEmpresaGUI().setSelectedItem(empresa.getTipoEmpresa());
		getEmpresaPC().getFaturamentoMensalGUI().setText(empresa.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		empresa.setNomeFantasia(getEmpresaPC().getNomeFantasiaGUI().getText());
		empresa.setNumeroFuncionarios(getEmpresaPC().getNumeroFuncionariosGUI().getText());
		empresa.setRamoAtividade(getEmpresaPC().getRamoAtividadeGUI().getText());
		empresa.setNomeFantasia(getEmpresaPC().getNomeFantasiaGUI().getText());
		empresa.setRazaoSocial(getEmpresaPC().getRazaoSocialGUI().getText());
		empresa.setEmail(getEmpresaPC().getEmailGUI().getText());
		empresa.setFax(getEmpresaPC().getFaxGUI().getText());
		empresa.setFone1(getEmpresaPC().getFone1GUI().getText());
		empresa.setFone2(getEmpresaPC().getFone2GUI().getText());
		empresa.setInscricaoEstadual(getEmpresaPC().getInscricaoEstadualGUI().getText());
		empresa.setInscricaoMunicipal(getEmpresaPC().getInscricaoMunicipalGUI().getText());
		empresa.setCapitalSocial(getEmpresaPC().getCapitalSocialGUI().getText());
		empresa.setDataFundacao(getEmpresaPC().getDataFundacaoGUI().getText());
		empresa.setBairro(getEmpresaPC().getBairroGUI().getText());
		empresa.setCep(getEmpresaPC().getCepGUI().getText());
		empresa.setCidade(getEmpresaPC().getCidadeGUI().getText());
		empresa.setComplemento(getEmpresaPC().getComplementoGUI().getText());
		empresa.setEstado(getEmpresaPC().getEstadoGUI().getText());
		empresa.setLogradouro(getEmpresaPC().getLogradouroGUI().getText());
		empresa.setPais(getEmpresaPC().getPaisGUI().getText());
		empresa.setCnpj(getEmpresaPC().getCnpjGUI().getText());
		empresa.setTipoEmpresa((String) getEmpresaPC().getEmpresaGUI().getSelectedItem());
		empresa.setFaturamentoMensal(getEmpresaPC().getFaturamentoMensalGUI().getText());
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public EmpresaFC getEmpresaFC() {
		return MainCT.getEmpresaFC();
	}

	public EmpresaPC getEmpresaPC() {
		return MainCT.getEmpresaFC().getEmpresaPC();
	}

	public EmpresaFP getEmpresaFP() {
		return MainCT.getEmpresaFP();
	}

	public EmpresaPP getEmpresaPP() {
		return MainCT.getEmpresaFP().getEmpresaPP();
	}
}
