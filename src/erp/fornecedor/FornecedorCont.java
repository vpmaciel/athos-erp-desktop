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
import erp.main.MainCont;

final class FornecedorCont {

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
				FornecedorFac.deletarRegistro(fornecedor);
				getFornecedorFc().limparGui();
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
				getFornecedorFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFornecedorFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFornecedorFc().setVisible(false);
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
				MainCont.mostrarFrame(MainCont.getMainFc());
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
				if (fornecedores.add(FornecedorFac.getRegistro(fornecedor))) {
					FornecedorRel fornecedorRel = new FornecedorRel(fornecedores);
					fornecedorRel.retornarRelatorio(true);
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
				fornecedores = new LinkedList<>(FornecedorFac.pesquisarRegistro(fornecedor));
			} catch (Exception e) {
				System.out.println(e);
			}
			FornecedorRel fornecedorRel = new FornecedorRel(fornecedores);
			fornecedorRel.retornarRelatorio(true);
		}
	}

	public class MostraFrameFornecedor extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCont.mostrarFrame(getFornecedorFc());
			} else {
				getFornecedorFc().reiniciarGui();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			fornecedor = new Fornecedor();
			getFornecedorFc().limparGui();
			getFornecedorPc().getNomeFantasiaGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			fornecedor = new Fornecedor();
			atualizarObjeto();
			getFornecedorPp().pesquisarRegistroFornecedor(fornecedor);
			MainCont.mostrarFrame(MainCont.getFornecedorFp());
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
				String nome = getFornecedorPc().getNomeFantasiaGUI().getText();
				if (nome == null || nome.length() == 0) {
					getFornecedorPc().getNomeFantasiaGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					FornecedorFac.salvarRegistro(fornecedor);
					fornecedor = new Fornecedor();
					getFornecedorFc().limparGui();
					getFornecedorPc().getNomeFantasiaGUI().requestFocus();
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
		getFornecedorPc().getNomeFantasiaGUI().setText(fornecedor.getNomeFantasia());
		getFornecedorPc().getNumeroFuncionariosGUI().setText(fornecedor.getNumeroFuncionarios());
		getFornecedorPc().getRamoAtividadeGUI().setText(fornecedor.getRamoAtividade());
		getFornecedorPc().getRazaoSocialGUI().setText(fornecedor.getRazaoSocial());
		getFornecedorPc().getEmailGUI().setText(fornecedor.getEmail());
		getFornecedorPc().getFaxGUI().setText(fornecedor.getFax());
		getFornecedorPc().getFone1GUI().setText(fornecedor.getFone1());
		getFornecedorPc().getFone2GUI().setText(fornecedor.getFone2());
		getFornecedorPc().getInscricaoEstadualGUI().setText(fornecedor.getInscricaoEstadual());
		getFornecedorPc().getInscricaoMunicipalGUI().setText(fornecedor.getInscricaoMunicipal());
		getFornecedorPc().getCapitalSocialGUI().setText(fornecedor.getCapitalSocial());
		getFornecedorPc().getDataFundacaoGUI().setText(fornecedor.getDataFundacao());
		getFornecedorPc().getBairroGUI().setText(fornecedor.getBairro());
		getFornecedorPc().getCepGUI().setText(fornecedor.getCep());
		getFornecedorPc().getCidadeGUI().setText(fornecedor.getCidade());
		getFornecedorPc().getComplementoGUI().setText(fornecedor.getComplemento());
		getFornecedorPc().getEstadoGUI().setText(fornecedor.getEstado());
		getFornecedorPc().getLogradouroGUI().setText(fornecedor.getLogradouro());
		getFornecedorPc().getPaisGUI().setText(fornecedor.getPais());
		getFornecedorPc().getCnpjGUI().setText(fornecedor.getCnpj());
		getFornecedorPc().getCpfGUI().setText(fornecedor.getCpfNumero());
		getFornecedorPc().getTipoEmpresaGUI().setSelectedItem(fornecedor.getTipoEmpresa());
		getFornecedorPc().getFaturamentoMensalGUI().setText(fornecedor.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		fornecedor.setNomeFantasia(getFornecedorPc().getNomeFantasiaGUI().getText());
		fornecedor.setNumeroFuncionarios(getFornecedorPc().getNumeroFuncionariosGUI().getText());
		fornecedor.setRamoAtividade(getFornecedorPc().getRamoAtividadeGUI().getText());
		fornecedor.setRazaoSocial(getFornecedorPc().getRazaoSocialGUI().getText());
		fornecedor.setEmail(getFornecedorPc().getEmailGUI().getText());
		fornecedor.setFax(getFornecedorPc().getFaxGUI().getText());
		fornecedor.setFone1(getFornecedorPc().getFone1GUI().getText());
		fornecedor.setFone2(getFornecedorPc().getFone2GUI().getText());
		fornecedor.setInscricaoEstadual(getFornecedorPc().getInscricaoEstadualGUI().getText());
		fornecedor.setInscricaoMunicipal(getFornecedorPc().getInscricaoMunicipalGUI().getText());
		fornecedor.setCapitalSocial(getFornecedorPc().getCapitalSocialGUI().getText());
		fornecedor.setDataFundacao(getFornecedorPc().getDataFundacaoGUI().getText());
		fornecedor.setBairro(getFornecedorPc().getBairroGUI().getText());
		fornecedor.setCep(getFornecedorPc().getCepGUI().getText());
		fornecedor.setCidade(getFornecedorPc().getCidadeGUI().getText());
		fornecedor.setComplemento(getFornecedorPc().getComplementoGUI().getText());
		fornecedor.setEstado(getFornecedorPc().getEstadoGUI().getText());
		fornecedor.setLogradouro(getFornecedorPc().getLogradouroGUI().getText());
		fornecedor.setPais(getFornecedorPc().getPaisGUI().getText());
		fornecedor.setCnpj(getFornecedorPc().getCnpjGUI().getText());
		fornecedor.setCpf(getFornecedorPc().getCpfGUI().getText());
		fornecedor.setTipoEmpresa((String) getFornecedorPc().getTipoEmpresaGUI().getSelectedItem());
		fornecedor.setFaturamentoMensal(getFornecedorPc().getFaturamentoMensalGUI().getText());
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FornecedorFc getFornecedorFc() {
		return MainCont.getFornecedorFc();
	}

	public FornecedorPc getFornecedorPc() {
		return MainCont.getFornecedorFc().getFornecedorPc();
	}

	public FornecedorFp getFornecedorFp() {
		return MainCont.getFornecedorFp();
	}

	public FornecedorPp getFornecedorPp() {
		return MainCont.getFornecedorFp().getFornecedorPp();
	}
}
