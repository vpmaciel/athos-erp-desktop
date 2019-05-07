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
import arquitetura.validacao.Mascara;
import erp.main.MainCont;
import erp.main.MainFc;

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

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Fornecedor> fornecedors = new LinkedList<>();

			if (fornecedor.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (fornecedors.add(FornecedorFac.getRegistro(fornecedor))) {
				FornecedorRel fornecedorRel = new FornecedorRel(fornecedors);
				fornecedorRel.retornarRelatorio(true);
			}
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
			getFornecedorPc().getGuiNomeFantasia().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getFornecedorPp().pesquisarRegistroFornecedor(fornecedor);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainFc.mostrarFrame(getFornecedorFp());
				getFornecedorFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Fornecedor> fornecedors = new LinkedList<>();

			try {
				fornecedors = new LinkedList<>(FornecedorFac.pesquisarRegistro(new Fornecedor()));
			} catch (Exception e) {
				System.out.println(e);
			}

			FornecedorRel fornecedorRel = new FornecedorRel(fornecedors);
			fornecedorRel.retornarRelatorio(true);

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
				String nome = getFornecedorPc().getGuiNomeFantasia().getText();
				if (nome == null || nome.length() == 0) {
					getFornecedorPc().getGuiNomeFantasia().requestFocus();
					Msg.avisoCampoObrigatorio("NOME FANTASIA");
					return;
				}

				Fornecedor fornecedorPesquisa = new Fornecedor();
				fornecedorPesquisa.setCpf(getFornecedorPc().getGuiCpf().getText());
				Fornecedor fornecedorPesquisaRetornado = FornecedorFac.consultarRegistro(fornecedorPesquisa);

				if (fornecedor.getId() == null && fornecedorPesquisa.getCpf() != null
						&& fornecedorPesquisaRetornado.getCpf() != null) {
					if (fornecedorPesquisa.getCpf().equals(fornecedorPesquisaRetornado.getCpf())) {
						Msg.avisoCampoDuplicado("CPF", fornecedorPesquisa.getCpf());
						getFornecedorPc().getGuiCpf().requestFocus();
						return;
					}
				}

				if (fornecedor.getId() != null && fornecedorPesquisa.getCpf() != null
						&& fornecedorPesquisaRetornado.getCpf() != null) {
					if (!fornecedor.getCpf().equals(fornecedorPesquisa.getCpf())) {
						if (fornecedorPesquisa.getCpf().equals(fornecedorPesquisaRetornado.getCpf())) {
							Msg.avisoCampoDuplicado("CPF", fornecedorPesquisa.getCpf());
							getFornecedorPc().getGuiCpf().requestFocus();
						}
						return;
					}
				}

				fornecedorPesquisa = new Fornecedor();
				fornecedorPesquisa.setCnpj(getFornecedorPc().getGuiCnpj().getText());
				fornecedorPesquisaRetornado = FornecedorFac.consultarRegistro(fornecedorPesquisa);

				if (fornecedor.getId() == null && fornecedorPesquisa.getCnpj() != null
						&& fornecedorPesquisaRetornado.getCnpj() != null) {
					if (fornecedorPesquisa.getCnpj().equals(fornecedorPesquisaRetornado.getCnpj())) {
						Msg.avisoCampoDuplicado("CNPJ", fornecedorPesquisa.getCnpj());
						getFornecedorPc().getGuiCnpj().requestFocus();
						return;
					}
				}

				if (fornecedor.getId() != null && fornecedorPesquisa.getCnpj() != null
						&& fornecedorPesquisaRetornado.getCnpj() != null) {
					if (!fornecedor.getCnpj().equals(fornecedorPesquisa.getCnpj())) {
						if (fornecedorPesquisa.getCnpj().equals(fornecedorPesquisaRetornado.getCnpj())) {
							Msg.avisoCampoDuplicado("CNPJ", fornecedorPesquisa.getCnpj());
							getFornecedorPc().getGuiCnpj().requestFocus();
						}
						return;
					}
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					FornecedorFac.salvarRegistro(fornecedor);
					fornecedor = new Fornecedor();
					getFornecedorFc().limparGui();
					getFornecedorPc().getGuiNomeFantasia().requestFocus();
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
		getFornecedorPc().getGuiNomeFantasia().setText(fornecedor.getNomeFantasia());
		getFornecedorPc().getGuiNumeroFuncionarios().setText(fornecedor.getNumeroFuncionarios());
		getFornecedorPc().getGuiRamoAtividade().setText(fornecedor.getRamoAtividade());
		getFornecedorPc().getGuiRazaoSocial().setText(fornecedor.getRazaoSocial());
		getFornecedorPc().getGuiEmail().setText(fornecedor.getEmail());
		getFornecedorPc().getGuiFax().setText(fornecedor.getFax());
		getFornecedorPc().getGuiFone1().setText(fornecedor.getFone1());
		getFornecedorPc().getGuiFone2().setText(fornecedor.getFone2());
		getFornecedorPc().getGuiInscricaoEstadual().setText(fornecedor.getInscricaoEstadual());
		getFornecedorPc().getGuiInscricaoMunicipal().setText(fornecedor.getInscricaoMunicipal());
		getFornecedorPc().getGuiCapitalSocial().setText(fornecedor.getCapitalSocial());
		getFornecedorPc().getGuiDataFundacao().setText(fornecedor.getDataFundacao());
		getFornecedorPc().getGuiBairro().setText(fornecedor.getBairro());
		getFornecedorPc().getGuiCep().setText(fornecedor.getCep());
		getFornecedorPc().getGuiCidade().setText(fornecedor.getCidade());
		getFornecedorPc().getGuiComplemento().setText(fornecedor.getComplemento());
		getFornecedorPc().getGuiEstado().setText(fornecedor.getEstado());
		getFornecedorPc().getGuiLogradouro().setText(fornecedor.getLogradouro());
		getFornecedorPc().getGuiPais().setText(fornecedor.getPais());
		getFornecedorPc().getGuiCnpj().setText(fornecedor.getCnpj());
		getFornecedorPc().getGuiCpf().setText(fornecedor.getCpf());
		getFornecedorPc().getGuiTipoEmpresa().setSelectedItem(fornecedor.getTipoEmpresa());
		getFornecedorPc().getGuiFaturamentoMensal().setText(fornecedor.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		fornecedor.setNomeFantasia(getFornecedorPc().getGuiNomeFantasia().getText());
		fornecedor.setNumeroFuncionarios(getFornecedorPc().getGuiNumeroFuncionarios().getText());
		fornecedor.setRamoAtividade(getFornecedorPc().getGuiRamoAtividade().getText());
		fornecedor.setRazaoSocial(getFornecedorPc().getGuiRazaoSocial().getText());
		fornecedor.setEmail(getFornecedorPc().getGuiEmail().getText());
		fornecedor.setFax(getFornecedorPc().getGuiFax().getText());
		fornecedor.setFone1(getFornecedorPc().getGuiFone1().getText());
		fornecedor.setFone2(getFornecedorPc().getGuiFone2().getText());
		fornecedor.setInscricaoEstadual(getFornecedorPc().getGuiInscricaoEstadual().getText());
		fornecedor.setInscricaoMunicipal(getFornecedorPc().getGuiInscricaoMunicipal().getText());
		fornecedor.setCapitalSocial(getFornecedorPc().getGuiCapitalSocial().getText());
		fornecedor.setDataFundacao(getFornecedorPc().getGuiDataFundacao().getText());
		fornecedor.setBairro(getFornecedorPc().getGuiBairro().getText());
		fornecedor.setCep(getFornecedorPc().getGuiCep().getText());
		fornecedor.setCidade(getFornecedorPc().getGuiCidade().getText());
		fornecedor.setComplemento(getFornecedorPc().getGuiComplemento().getText());
		fornecedor.setEstado(getFornecedorPc().getGuiEstado().getText());
		fornecedor.setLogradouro(getFornecedorPc().getGuiLogradouro().getText());
		fornecedor.setPais(getFornecedorPc().getGuiPais().getText());
		fornecedor.setCnpj(getFornecedorPc().getGuiCnpj().getText());
		fornecedor.setCpf(getFornecedorPc().getGuiCpf().getText());
		fornecedor.setTipoEmpresa((String) getFornecedorPc().getGuiTipoEmpresa().getSelectedItem());
		fornecedor.setFaturamentoMensal(getFornecedorPc().getGuiFaturamentoMensal().getText());

		if (getFornecedorPc().getGuiCnpj().getText().equals(Mascara.getCnpjVazio())) {
			fornecedor.setCnpj(null);
		}

		if (getFornecedorPc().getGuiCpf().getText().equals(Mascara.getCpfVazio())) {
			fornecedor.setCpf(null);
		}
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public FornecedorFc getFornecedorFc() {
		return MainCont.getFornecedorFc();
	}

	public FornecedorFp getFornecedorFp() {
		return MainCont.getFornecedorFp();
	}

	public FornecedorPc getFornecedorPc() {
		return MainCont.getFornecedorFc().getFornecedorPc();
	}

	public FornecedorPp getFornecedorPp() {
		return MainCont.getFornecedorFp().getFornecedorPp();
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
