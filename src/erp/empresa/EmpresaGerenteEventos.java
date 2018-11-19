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

import erp.aop.gui.Msg;
import erp.main.MainGerenteEventos;
import erp.main.PanelSobre;

final class EmpresaGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				JOptionPane.showMessageDialog(MainGerenteEventos.getFrameMain(), new PanelSobre(), "Sobre o Sistema", -1);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (empresa == null || empresa.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				EmpresaDaoFacade.deletarRegistro(empresa);
				getFrameCadastroEmpresa().limparGui();
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
				getFrameCadastroEmpresa().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroEmpresa().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroEmpresa().setVisible(false);
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
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Empresa> empresas = new LinkedList<>();

			if (empresa.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (empresas.add(EmpresaDaoFacade.getRegistro(empresa))) {
					EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio(empresas);
					empresaRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Empresa> empresas = new LinkedList<>();

			try {
				empresas = new LinkedList<>(EmpresaDaoFacade.pesquisarRegistro(empresa));
			} catch (Exception e) {
				System.out.println(e);
			}
			EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio(empresas);
			empresaRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameEmpresa extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainGerenteEventos.mostrarFrame(getFrameCadastroEmpresa());
			} else {
				getFrameCadastroEmpresa().reiniciarBox();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			empresa = new Empresa();
			getFrameCadastroEmpresa().limparGui();
			getPanelCadastroEmpresa().getTextFieldNomeFantasia().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			empresa = new Empresa();
			atualizarObjeto();
			getPanelPesquisaEmpresa().pesquisarRegistroEmpresa(empresa);
			MainGerenteEventos.mostrarFrame(getFramePesquisaEmpresa());
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
				String nomeFantasia = getPanelCadastroEmpresa().getTextFieldNomeFantasia().getText();
				if (nomeFantasia == null || nomeFantasia.length() == 0) {
					getPanelCadastroEmpresa().getTextFieldNomeFantasia().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					EmpresaDaoFacade.salvarRegistro(empresa);
					empresa = new Empresa();
					getFrameCadastroEmpresa().limparGui();
					getPanelCadastroEmpresa().getTextFieldNomeFantasia().requestFocus();
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
		getPanelCadastroEmpresa().getTextFieldNomeFantasia().setText(empresa.getNomeFantasia());
		getPanelCadastroEmpresa().getTextFieldNumeroFuncionarios().setText(empresa.getNumeroFuncionarios());
		getPanelCadastroEmpresa().getTextFieldRamoAtividade().setText(empresa.getRamoAtividade());
		getPanelCadastroEmpresa().getTextFieldNomeFantasia().setText(empresa.getNomeFantasia());
		getPanelCadastroEmpresa().getTextFieldRazaoSocial().setText(empresa.getRazaoSocial());
		getPanelCadastroEmpresa().getTextFieldEmail().setText(empresa.getEmail());
		getPanelCadastroEmpresa().getTextFieldFax().setText(empresa.getFax());
		getPanelCadastroEmpresa().getTextFieldFone1().setText(empresa.getFone1());
		getPanelCadastroEmpresa().getTextFieldFone2().setText(empresa.getFone2());
		getPanelCadastroEmpresa().getTextFieldInscricaoEstadual().setText(empresa.getInscricaoEstadual());
		getPanelCadastroEmpresa().getTextFieldInscricaoMunicipal().setText(empresa.getInscricaoMunicipal());
		getPanelCadastroEmpresa().getTextFieldCapitalSocial().setText(empresa.getCapitalSocial());
		getPanelCadastroEmpresa().getTextFieldDataFundacao().setText(empresa.getDataFundacao());
		getPanelCadastroEmpresa().getTextFieldBairro().setText(empresa.getBairro());
		getPanelCadastroEmpresa().getTextFieldCep().setText(empresa.getCep());
		getPanelCadastroEmpresa().getTextFieldCidade().setText(empresa.getCidade());
		getPanelCadastroEmpresa().getTextFieldComplemento().setText(empresa.getComplemento());
		getPanelCadastroEmpresa().getTextFieldEstado().setText(empresa.getEstado());
		getPanelCadastroEmpresa().getTextFieldLogradouro().setText(empresa.getLogradouro());
		getPanelCadastroEmpresa().getTextFieldPais().setText(empresa.getPais());
		getPanelCadastroEmpresa().getTextFieldCNPJ().setText(empresa.getCnpj());
		getPanelCadastroEmpresa().getTextFieldCPF().setText(empresa.getCpfNumero());
		getPanelCadastroEmpresa().getBoxTipoEmpresa().setSelectedItem(empresa.getTipoEmpresa());
		getPanelCadastroEmpresa().getTextFieldFaturamentoMensal().setText(empresa.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		empresa.setNomeFantasia(getPanelCadastroEmpresa().getTextFieldNomeFantasia().getText());
		empresa.setNumeroFuncionarios(getPanelCadastroEmpresa().getTextFieldNumeroFuncionarios().getText());
		empresa.setRamoAtividade(getPanelCadastroEmpresa().getTextFieldRamoAtividade().getText());
		empresa.setNomeFantasia(getPanelCadastroEmpresa().getTextFieldNomeFantasia().getText());
		empresa.setRazaoSocial(getPanelCadastroEmpresa().getTextFieldRazaoSocial().getText());
		empresa.setEmail(getPanelCadastroEmpresa().getTextFieldEmail().getText());
		empresa.setFax(getPanelCadastroEmpresa().getTextFieldFax().getText());
		empresa.setFone1(getPanelCadastroEmpresa().getTextFieldFone1().getText());
		empresa.setFone2(getPanelCadastroEmpresa().getTextFieldFone2().getText());
		empresa.setInscricaoEstadual(getPanelCadastroEmpresa().getTextFieldInscricaoEstadual().getText());
		empresa.setInscricaoMunicipal(getPanelCadastroEmpresa().getTextFieldInscricaoMunicipal().getText());
		empresa.setCapitalSocial(getPanelCadastroEmpresa().getTextFieldCapitalSocial().getText());
		empresa.setDataFundacao(getPanelCadastroEmpresa().getTextFieldDataFundacao().getText());
		empresa.setBairro(getPanelCadastroEmpresa().getTextFieldBairro().getText());
		empresa.setCep(getPanelCadastroEmpresa().getTextFieldCep().getText());
		empresa.setCidade(getPanelCadastroEmpresa().getTextFieldCidade().getText());
		empresa.setComplemento(getPanelCadastroEmpresa().getTextFieldComplemento().getText());
		empresa.setEstado(getPanelCadastroEmpresa().getTextFieldEstado().getText());
		empresa.setLogradouro(getPanelCadastroEmpresa().getTextFieldLogradouro().getText());
		empresa.setPais(getPanelCadastroEmpresa().getTextFieldPais().getText());
		empresa.setCnpj(getPanelCadastroEmpresa().getTextFieldCNPJ().getText());
		empresa.setCpfNumero(getPanelCadastroEmpresa().getTextFieldCPF().getText());
		empresa.setTipoEmpresa((String) getPanelCadastroEmpresa().getBoxTipoEmpresa().getSelectedItem());
		empresa.setFaturamentoMensal(getPanelCadastroEmpresa().getTextFieldFaturamentoMensal().getText());
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public FrameCadastroEmpresa getFrameCadastroEmpresa() {
		return MainGerenteEventos.getFrameCadastroEmpresa();
	}
	
	public PanelCadastroEmpresa getPanelCadastroEmpresa() {
		return MainGerenteEventos.getFrameCadastroEmpresa().getPanelCadastroEmpresa();
	}
	
	public FramePesquisaEmpresa getFramePesquisaEmpresa() {
		return MainGerenteEventos.getFramePesquisaEmpresa();
	}

	public PanelPesquisaEmpresa getPanelPesquisaEmpresa() {
		return MainGerenteEventos.getFramePesquisaEmpresa().getPanelPesquisaEmpresa();
	}
}
