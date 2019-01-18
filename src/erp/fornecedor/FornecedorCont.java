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
			getFornecedorPc().getNomeFantasiaGui().requestFocus();
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
				String nome = getFornecedorPc().getNomeFantasiaGui().getText();
				if (nome == null || nome.length() == 0) {
					getFornecedorPc().getNomeFantasiaGui().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					FornecedorFac.salvarRegistro(fornecedor);
					fornecedor = new Fornecedor();
					getFornecedorFc().limparGui();
					getFornecedorPc().getNomeFantasiaGui().requestFocus();
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
		getFornecedorPc().getNomeFantasiaGui().setText(fornecedor.getNomeFantasia());
		getFornecedorPc().getNumeroFuncionariosGui().setText(fornecedor.getNumeroFuncionarios());
		getFornecedorPc().getRamoAtividadeGui().setText(fornecedor.getRamoAtividade());
		getFornecedorPc().getRazaoSocialGui().setText(fornecedor.getRazaoSocial());
		getFornecedorPc().getEmailGui().setText(fornecedor.getEmail());
		getFornecedorPc().getFaxGui().setText(fornecedor.getFax());
		getFornecedorPc().getFone1Gui().setText(fornecedor.getFone1());
		getFornecedorPc().getFone2Gui().setText(fornecedor.getFone2());
		getFornecedorPc().getInscricaoEstadualGui().setText(fornecedor.getInscricaoEstadual());
		getFornecedorPc().getInscricaoMunicipalGui().setText(fornecedor.getInscricaoMunicipal());
		getFornecedorPc().getCapitalSocialGui().setText(fornecedor.getCapitalSocial());
		getFornecedorPc().getDataFundacaoGui().setText(fornecedor.getDataFundacao());
		getFornecedorPc().getBairroGui().setText(fornecedor.getBairro());
		getFornecedorPc().getCepGui().setText(fornecedor.getCep());
		getFornecedorPc().getCidadeGui().setText(fornecedor.getCidade());
		getFornecedorPc().getComplementoGui().setText(fornecedor.getComplemento());
		getFornecedorPc().getEstadoGui().setText(fornecedor.getEstado());
		getFornecedorPc().getLogradouroGui().setText(fornecedor.getLogradouro());
		getFornecedorPc().getPaisGui().setText(fornecedor.getPais());
		getFornecedorPc().getCnpjGui().setText(fornecedor.getCnpj());
		getFornecedorPc().getCpfGui().setText(fornecedor.getCpfNumero());
		getFornecedorPc().getTipoEmpresaGui().setSelectedItem(fornecedor.getTipoEmpresa());
		getFornecedorPc().getFaturamentoMensalGui().setText(fornecedor.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		fornecedor.setNomeFantasia(getFornecedorPc().getNomeFantasiaGui().getText());
		fornecedor.setNumeroFuncionarios(getFornecedorPc().getNumeroFuncionariosGui().getText());
		fornecedor.setRamoAtividade(getFornecedorPc().getRamoAtividadeGui().getText());
		fornecedor.setRazaoSocial(getFornecedorPc().getRazaoSocialGui().getText());
		fornecedor.setEmail(getFornecedorPc().getEmailGui().getText());
		fornecedor.setFax(getFornecedorPc().getFaxGui().getText());
		fornecedor.setFone1(getFornecedorPc().getFone1Gui().getText());
		fornecedor.setFone2(getFornecedorPc().getFone2Gui().getText());
		fornecedor.setInscricaoEstadual(getFornecedorPc().getInscricaoEstadualGui().getText());
		fornecedor.setInscricaoMunicipal(getFornecedorPc().getInscricaoMunicipalGui().getText());
		fornecedor.setCapitalSocial(getFornecedorPc().getCapitalSocialGui().getText());
		fornecedor.setDataFundacao(getFornecedorPc().getDataFundacaoGui().getText());
		fornecedor.setBairro(getFornecedorPc().getBairroGui().getText());
		fornecedor.setCep(getFornecedorPc().getCepGui().getText());
		fornecedor.setCidade(getFornecedorPc().getCidadeGui().getText());
		fornecedor.setComplemento(getFornecedorPc().getComplementoGui().getText());
		fornecedor.setEstado(getFornecedorPc().getEstadoGui().getText());
		fornecedor.setLogradouro(getFornecedorPc().getLogradouroGui().getText());
		fornecedor.setPais(getFornecedorPc().getPaisGui().getText());
		fornecedor.setCnpj(getFornecedorPc().getCnpjGui().getText());
		fornecedor.setCpf(getFornecedorPc().getCpfGui().getText());
		fornecedor.setTipoEmpresa((String) getFornecedorPc().getTipoEmpresaGui().getSelectedItem());
		fornecedor.setFaturamentoMensal(getFornecedorPc().getFaturamentoMensalGui().getText());
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
