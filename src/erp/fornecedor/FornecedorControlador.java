package erp.fornecedor;

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
import erp.main.MainGerenteEventos;

final class FornecedorGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (fornecedor == null || fornecedor.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				FornecedorDaoFacade.deletarRegistro(fornecedor);
				getFrameCadastroFornecedor().limparGui();
				fornecedor = new Fornecedor();
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
				getFrameCadastroFornecedor().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroFornecedor().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroFornecedor().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			fornecedor = new Fornecedor();
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
			List<Fornecedor> fornecedores = new LinkedList<>();

			if (fornecedor.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (fornecedores.add(FornecedorDaoFacade.getRegistro(fornecedor))) {
					FornecedorRelatorio fornecedorRelatorio = new FornecedorRelatorio(fornecedores);
					fornecedorRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Fornecedor> fornecedores = new LinkedList<>();

			try {
				fornecedores = new LinkedList<>(FornecedorDaoFacade.pesquisarRegistro(fornecedor));
			} catch (Exception e) {
				System.out.println(e);
			}
			FornecedorRelatorio fornecedorRelatorio = new FornecedorRelatorio(fornecedores);
			fornecedorRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameFornecedor extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainGerenteEventos.mostrarFrame(getFrameCadastroFornecedor());
			} else {
				getFrameCadastroFornecedor().reiniciarBox();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			fornecedor = new Fornecedor();
			getFrameCadastroFornecedor().limparGui();
			getPanelCadastroFornecedor().getTextFieldNomeFantasia().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			fornecedor = new Fornecedor();
			atualizarObjeto();
			getPanelPesquisaFornecedor().pesquisarRegistroFornecedor(fornecedor);
			MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFramePesquisaFornecedor());
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
				String nome = getPanelCadastroFornecedor().getTextFieldNomeFantasia().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroFornecedor().getTextFieldNomeFantasia().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					FornecedorDaoFacade.salvarRegistro(fornecedor);
					fornecedor = new Fornecedor();
					getFrameCadastroFornecedor().limparGui();
					getPanelCadastroFornecedor().getTextFieldNomeFantasia().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Fornecedor fornecedor;

	public void atualizarGui() {
		if (fornecedor == null) {
			return;
		}
		getPanelCadastroFornecedor().getTextFieldNomeFantasia().setText(fornecedor.getNomeFantasia());
		getPanelCadastroFornecedor().getTextFieldNumeroFuncionarios().setText(fornecedor.getNumeroFuncionarios());
		getPanelCadastroFornecedor().getTextFieldRamoAtividade().setText(fornecedor.getRamoAtividade());
		getPanelCadastroFornecedor().getTextFieldRazaoSocial().setText(fornecedor.getRazaoSocial());
		getPanelCadastroFornecedor().getTextFieldEmail().setText(fornecedor.getEmail());
		getPanelCadastroFornecedor().getTextFieldFax().setText(fornecedor.getFax());
		getPanelCadastroFornecedor().getTextFieldFone1().setText(fornecedor.getFone1());
		getPanelCadastroFornecedor().getTextFieldFone2().setText(fornecedor.getFone2());
		getPanelCadastroFornecedor().getTextFieldInscricaoEstadual().setText(fornecedor.getInscricaoEstadual());
		getPanelCadastroFornecedor().getTextFieldInscricaoMunicipal().setText(fornecedor.getInscricaoMunicipal());
		getPanelCadastroFornecedor().getTextFieldCapitalSocial().setText(fornecedor.getCapitalSocial());
		getPanelCadastroFornecedor().getTextFieldDataFundacao().setText(fornecedor.getDataFundacao());
		getPanelCadastroFornecedor().getTextFieldBairro().setText(fornecedor.getBairro());
		getPanelCadastroFornecedor().getTextFieldCep().setText(fornecedor.getCep());
		getPanelCadastroFornecedor().getTextFieldCidade().setText(fornecedor.getCidade());
		getPanelCadastroFornecedor().getTextFieldComplemento().setText(fornecedor.getComplemento());
		getPanelCadastroFornecedor().getTextFieldEstado().setText(fornecedor.getEstado());
		getPanelCadastroFornecedor().getTextFieldLogradouro().setText(fornecedor.getLogradouro());
		getPanelCadastroFornecedor().getTextFieldPais().setText(fornecedor.getPais());
		getPanelCadastroFornecedor().getTextFieldCNPJ().setText(fornecedor.getCnpj());
		getPanelCadastroFornecedor().getTextFieldCPF().setText(fornecedor.getCpfNumero());
		getPanelCadastroFornecedor().getBoxTipoEmpresa().setSelectedItem(fornecedor.getTipoEmpresa());
		getPanelCadastroFornecedor().getTextFieldFaturamentoMensal().setText(fornecedor.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		fornecedor.setNomeFantasia(getPanelCadastroFornecedor().getTextFieldNomeFantasia().getText());
		fornecedor.setNumeroFuncionarios(getPanelCadastroFornecedor().getTextFieldNumeroFuncionarios().getText());
		fornecedor.setRamoAtividade(getPanelCadastroFornecedor().getTextFieldRamoAtividade().getText());
		fornecedor.setRazaoSocial(getPanelCadastroFornecedor().getTextFieldRazaoSocial().getText());
		fornecedor.setEmail(getPanelCadastroFornecedor().getTextFieldEmail().getText());
		fornecedor.setFax(getPanelCadastroFornecedor().getTextFieldFax().getText());
		fornecedor.setFone1(getPanelCadastroFornecedor().getTextFieldFone1().getText());
		fornecedor.setFone2(getPanelCadastroFornecedor().getTextFieldFone2().getText());
		fornecedor.setInscricaoEstadual(getPanelCadastroFornecedor().getTextFieldInscricaoEstadual().getText());
		fornecedor.setInscricaoMunicipal(getPanelCadastroFornecedor().getTextFieldInscricaoMunicipal().getText());
		fornecedor.setCapitalSocial(getPanelCadastroFornecedor().getTextFieldCapitalSocial().getText());
		fornecedor.setDataFundacao(getPanelCadastroFornecedor().getTextFieldDataFundacao().getText());
		fornecedor.setBairro(getPanelCadastroFornecedor().getTextFieldBairro().getText());
		fornecedor.setCep(getPanelCadastroFornecedor().getTextFieldCep().getText());
		fornecedor.setCidade(getPanelCadastroFornecedor().getTextFieldCidade().getText());
		fornecedor.setComplemento(getPanelCadastroFornecedor().getTextFieldComplemento().getText());
		fornecedor.setEstado(getPanelCadastroFornecedor().getTextFieldEstado().getText());
		fornecedor.setLogradouro(getPanelCadastroFornecedor().getTextFieldLogradouro().getText());
		fornecedor.setPais(getPanelCadastroFornecedor().getTextFieldPais().getText());
		fornecedor.setCnpj(getPanelCadastroFornecedor().getTextFieldCNPJ().getText());
		fornecedor.setCpfNumero(getPanelCadastroFornecedor().getTextFieldCPF().getText());
		fornecedor.setTipoEmpresa((String) getPanelCadastroFornecedor().getBoxTipoEmpresa().getSelectedItem());
		fornecedor.setFaturamentoMensal(getPanelCadastroFornecedor().getTextFieldFaturamentoMensal().getText());
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FrameCadastroFornecedor getFrameCadastroFornecedor() {
		return MainGerenteEventos.getFrameCadastroFornecedor();
	}

	public PanelCadastroFornecedor getPanelCadastroFornecedor() {
		return MainGerenteEventos.getFrameCadastroFornecedor().getPanelCadastroFornecedor();
	}

	public FramePesquisaFornecedor getFramePesquisaFornecedor() {
		return MainGerenteEventos.getFramePesquisaFornecedor();
	}

	public PanelPesquisaFornecedor getPanelPesquisaFornecedor() {
		return MainGerenteEventos.getFramePesquisaFornecedor().getPanelPesquisaFornecedor();
	}
}
