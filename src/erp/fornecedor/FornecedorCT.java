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
import erp.main.MainCT;

final class FornecedorCT {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (fornecedor == null || fornecedor.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				FornecedorFAC.deletarRegistro(fornecedor);
				getFornecedorFC().limparGUI();
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
				getFornecedorFC().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFornecedorFC().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFornecedorFC().setVisible(false);
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
				MainCT.mostrarFrame(MainCT.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Fornecedor> fornecedores = new LinkedList<>();

			if (fornecedor.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (fornecedores.add(FornecedorFAC.getRegistro(fornecedor))) {
					FornecedorREL fornecedorREL = new FornecedorREL(fornecedores);
					fornecedorREL.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Fornecedor> fornecedores = new LinkedList<>();

			try {
				fornecedores = new LinkedList<>(FornecedorFAC.pesquisarRegistro(fornecedor));
			} catch (Exception e) {
				System.out.println(e);
			}
			FornecedorREL fornecedorREL = new FornecedorREL(fornecedores);
			fornecedorREL.retornarRelatorio(true);
		}
	}

	public class MostraFrameFornecedor extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCT.mostrarFrame(getFornecedorFC());
			} else {
				getFornecedorFC().reiniciarGUI();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			fornecedor = new Fornecedor();
			getFornecedorFC().limparGUI();
			getFornecedorPC().getNomeFantasiaGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			fornecedor = new Fornecedor();
			atualizarObjeto();
			getFornecedorPP().pesquisarRegistroFornecedor(fornecedor);
			MainCT.mostrarFrame(MainCT.getFornecedorFP());
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
				String nome = getFornecedorPC().getNomeFantasiaGUI().getText();
				if (nome == null || nome.length() == 0) {
					getFornecedorPC().getNomeFantasiaGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					FornecedorFAC.salvarRegistro(fornecedor);
					fornecedor = new Fornecedor();
					getFornecedorFC().limparGUI();
					getFornecedorPC().getNomeFantasiaGUI().requestFocus();
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
		getFornecedorPC().getNomeFantasiaGUI().setText(fornecedor.getNomeFantasia());
		getFornecedorPC().getNumeroFuncionariosGUI().setText(fornecedor.getNumeroFuncionarios());
		getFornecedorPC().getRamoAtividadeGUI().setText(fornecedor.getRamoAtividade());
		getFornecedorPC().getRazaoSocialGUI().setText(fornecedor.getRazaoSocial());
		getFornecedorPC().getEmailGUI().setText(fornecedor.getEmail());
		getFornecedorPC().getFaxGUI().setText(fornecedor.getFax());
		getFornecedorPC().getFone1GUI().setText(fornecedor.getFone1());
		getFornecedorPC().getFone2GUI().setText(fornecedor.getFone2());
		getFornecedorPC().getInscricaoEstadualGUI().setText(fornecedor.getInscricaoEstadual());
		getFornecedorPC().getInscricaoMunicipalGUI().setText(fornecedor.getInscricaoMunicipal());
		getFornecedorPC().getCapitalSocialGUI().setText(fornecedor.getCapitalSocial());
		getFornecedorPC().getDataFundacaoGUI().setText(fornecedor.getDataFundacao());
		getFornecedorPC().getBairroGUI().setText(fornecedor.getBairro());
		getFornecedorPC().getCepGUI().setText(fornecedor.getCep());
		getFornecedorPC().getCidadeGUI().setText(fornecedor.getCidade());
		getFornecedorPC().getComplementoGUI().setText(fornecedor.getComplemento());
		getFornecedorPC().getEstadoGUI().setText(fornecedor.getEstado());
		getFornecedorPC().getLogradouroGUI().setText(fornecedor.getLogradouro());
		getFornecedorPC().getPaisGUI().setText(fornecedor.getPais());
		getFornecedorPC().getCnpjGUI().setText(fornecedor.getCnpj());
		getFornecedorPC().getCpfGUI().setText(fornecedor.getCpfNumero());
		getFornecedorPC().getTipoEmpresaGUI().setSelectedItem(fornecedor.getTipoEmpresa());
		getFornecedorPC().getFaturamentoMensalGUI().setText(fornecedor.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		fornecedor.setNomeFantasia(getFornecedorPC().getNomeFantasiaGUI().getText());
		fornecedor.setNumeroFuncionarios(getFornecedorPC().getNumeroFuncionariosGUI().getText());
		fornecedor.setRamoAtividade(getFornecedorPC().getRamoAtividadeGUI().getText());
		fornecedor.setRazaoSocial(getFornecedorPC().getRazaoSocialGUI().getText());
		fornecedor.setEmail(getFornecedorPC().getEmailGUI().getText());
		fornecedor.setFax(getFornecedorPC().getFaxGUI().getText());
		fornecedor.setFone1(getFornecedorPC().getFone1GUI().getText());
		fornecedor.setFone2(getFornecedorPC().getFone2GUI().getText());
		fornecedor.setInscricaoEstadual(getFornecedorPC().getInscricaoEstadualGUI().getText());
		fornecedor.setInscricaoMunicipal(getFornecedorPC().getInscricaoMunicipalGUI().getText());
		fornecedor.setCapitalSocial(getFornecedorPC().getCapitalSocialGUI().getText());
		fornecedor.setDataFundacao(getFornecedorPC().getDataFundacaoGUI().getText());
		fornecedor.setBairro(getFornecedorPC().getBairroGUI().getText());
		fornecedor.setCep(getFornecedorPC().getCepGUI().getText());
		fornecedor.setCidade(getFornecedorPC().getCidadeGUI().getText());
		fornecedor.setComplemento(getFornecedorPC().getComplementoGUI().getText());
		fornecedor.setEstado(getFornecedorPC().getEstadoGUI().getText());
		fornecedor.setLogradouro(getFornecedorPC().getLogradouroGUI().getText());
		fornecedor.setPais(getFornecedorPC().getPaisGUI().getText());
		fornecedor.setCnpj(getFornecedorPC().getCnpjGUI().getText());
		fornecedor.setCpf(getFornecedorPC().getCpfGUI().getText());
		fornecedor.setTipoEmpresa((String) getFornecedorPC().getTipoEmpresaGUI().getSelectedItem());
		fornecedor.setFaturamentoMensal(getFornecedorPC().getFaturamentoMensalGUI().getText());
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FornecedorFC getFornecedorFC() {
		return MainCT.getFornecedorFC();
	}

	public FornecedorPC getFornecedorPC() {
		return MainCT.getFornecedorFC().getFornecedorPC();
	}

	public FornecedorFP getFornecedorFP() {
		return MainCT.getFornecedorFP();
	}

	public FornecedorPP getFornecedorPP() {
		return MainCT.getFornecedorFP().getFornecedorPP();
	}
}
