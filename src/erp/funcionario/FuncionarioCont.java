package erp.funcionario;

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
import erp.centrocusto.CentroCusto;
import erp.funcionario.Funcionario;
import erp.funcionario.FuncionarioFac;
import erp.main.MainCont;

final class FuncionarioCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (funcionario == null || funcionario.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				FuncionarioFac.deletarRegistro(funcionario);
				getFuncionarioFc().limparGui();
				funcionario = new Funcionario();
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
				MainCont.getFuncionarioFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFuncionarioFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFuncionarioFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			funcionario = new Funcionario();
			getFuncionarioPc().getNomeGui().requestFocus();
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
			List<Funcionario> funcionarios = new LinkedList<>();

			if (funcionario.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (funcionarios.add(FuncionarioFac.getRegistro(funcionario))) {
					FuncionarioRel funcionarioRel = new FuncionarioRel(funcionarios);
					funcionarioRel.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Funcionario> funcionarios = new LinkedList<>();

			try {
				funcionarios = new LinkedList<>(FuncionarioFac.pesquisarRegistro(funcionario));
			} catch (Exception e) {
				System.out.println(e);
			}
			FuncionarioRel funcionarioRel = new FuncionarioRel(funcionarios);
			funcionarioRel.retornarRelatorio(true);
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getFuncionarioPc().getLabelCentroCusto()) {
				MainCont.mostrarFrame(MainCont.getCentroCustoFc());
			} else {
				MainCont.getCentroCustoFc().reiniciarGui();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			funcionario = new Funcionario();
			MainCont.getFuncionarioFc().limparGui();
			getFuncionarioPc().getNomeGui().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getFuncionarioPp().pesquisarRegistroFuncionario(funcionario);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getFuncionarioFp());
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
				String nome = getFuncionarioPc().getNomeGui().getText();
				if (nome == null || nome.length() == 0) {
					getFuncionarioPc().getNomeGui().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}

				Funcionario funcionarioPesquisa = new Funcionario();
				funcionarioPesquisa.setCpf(getFuncionarioPc().getCpfGui().getText());
				Funcionario funcionarioPesquisaRetornado = FuncionarioFac.consultarRegistro(funcionarioPesquisa);

				if (funcionario.getId() == null && funcionarioPesquisa.getCpf() != null
						&& funcionarioPesquisaRetornado.getCpf() != null) {
					if (funcionarioPesquisa.getCpf().equals(funcionarioPesquisaRetornado.getCpf())) {
						Msg.avisoCampoDuplicado("CPF", funcionarioPesquisa.getCpf());
						getFuncionarioPc().getCpfGui().requestFocus();
						return;
					}
				}

				if (funcionario.getId() != null && funcionarioPesquisa.getCpf() != null
						&& funcionarioPesquisaRetornado.getCpf() != null) {
					if (!funcionario.getCpf().equals(funcionarioPesquisa.getCpf())) {
						if (funcionarioPesquisa.getCpf().equals(funcionarioPesquisaRetornado.getCpf())) {
							Msg.avisoCampoDuplicado("CPF", funcionarioPesquisa.getCpf());
							getFuncionarioPc().getCpfGui().requestFocus();
						}
						return;
					}
				}

				funcionarioPesquisa = new Funcionario();
				funcionarioPesquisa.setCnpj(getFuncionarioPc().getCnpjGui().getText());
				funcionarioPesquisaRetornado = FuncionarioFac.consultarRegistro(funcionarioPesquisa);

				if (funcionario.getId() == null && funcionarioPesquisa.getCnpj() != null
						&& funcionarioPesquisaRetornado.getCnpj() != null) {
					if (funcionarioPesquisa.getCnpj().equals(funcionarioPesquisaRetornado.getCnpj())) {
						Msg.avisoCampoDuplicado("CNPJ", funcionarioPesquisa.getCnpj());
						getFuncionarioPc().getCnpjGui().requestFocus();
						return;
					}
				}

				if (funcionario.getId() != null && funcionarioPesquisa.getCnpj() != null
						&& funcionarioPesquisaRetornado.getCnpj() != null) {
					if (!funcionario.getCnpj().equals(funcionarioPesquisa.getCnpj())) {
						if (funcionarioPesquisa.getCnpj().equals(funcionarioPesquisaRetornado.getCnpj())) {
							Msg.avisoCampoDuplicado("CNPJ", funcionarioPesquisa.getCnpj());
							getFuncionarioPc().getCnpjGui().requestFocus();
						}
						return;
					}
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					FuncionarioFac.salvarRegistro(funcionario);
					funcionario = new Funcionario();
					getFuncionarioFc().limparGui();
					getFuncionarioPc().getNomeGui().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Funcionario funcionario;

	public void atualizarGui() {
		if (funcionario == null) {
			return;
		}
		getFuncionarioPc().getNomeGui().setText(funcionario.getNome());
		getFuncionarioPc().getConjugeGui().setText(funcionario.getConjuge());
		getFuncionarioPc().getFilhosGui().setText(funcionario.getFilhos());
		getFuncionarioPc().getMatriculaGui().setText(funcionario.getMatricula());
		getFuncionarioPc().getSexoGui().setSelectedItem(funcionario.getSexo());
		getFuncionarioPc().getCorGui().setSelectedItem(funcionario.getCor());
		getFuncionarioPc().getDeficienciaGui().setSelectedItem(funcionario.getDeficiencia());
		getFuncionarioPc().getEscolaridadeGui().setSelectedItem(funcionario.getEscolaridade());
		getFuncionarioPc().getNacionalidadeGui().setSelectedItem(funcionario.getNacionalidade());
		getFuncionarioPc().getNomeGui().setText(funcionario.getNome());
		getFuncionarioPc().getEstadoCivilGui().setSelectedItem(funcionario.getEstadoCivil());
		getFuncionarioPc().getEmailGui().setText(funcionario.getEmail());
		getFuncionarioPc().getFaxGui().setText(funcionario.getFax());
		getFuncionarioPc().getFone1Gui().setText(funcionario.getFone1());
		getFuncionarioPc().getFone2Gui().setText(funcionario.getFone2());
		getFuncionarioPc().getCargoGui().setText(funcionario.getCargo());
		getFuncionarioPc().getCategoriaGui().setText(funcionario.getCategoria());
		getFuncionarioPc().getCentroCustoGui().setSelectedItem(funcionario.getCentroCusto());
		getFuncionarioPc().getDepartamentoGui().setText(funcionario.getDepartamento());
		getFuncionarioPc().getEmpresaGui().setText(funcionario.getEmpresa());
		getFuncionarioPc().getGerenteGui().setText(funcionario.getGerente());
		getFuncionarioPc().getSalarioGui().setText(funcionario.getSalario());
		getFuncionarioPc().getTurnoGui().setText(funcionario.getTurno());
		getFuncionarioPc().getBairroGui().setText(funcionario.getBairro());
		getFuncionarioPc().getCepGui().setText(funcionario.getCep());
		getFuncionarioPc().getCidadeGui().setText(funcionario.getCidade());
		getFuncionarioPc().getComplementoGui().setText(funcionario.getComplemento());
		getFuncionarioPc().getEstadoGui().setText(funcionario.getEstado());
		getFuncionarioPc().getLogradouroGui().setText(funcionario.getLogradouro());
		getFuncionarioPc().getPaisGui().setText(funcionario.getPais());
		getFuncionarioPc().getCNHCategoriaGui().setText(funcionario.getCnhCategoria());
		getFuncionarioPc().getCnpjGui().setText(funcionario.getCnpj());
		getFuncionarioPc().getCpfGui().setText(funcionario.getCpf());
		getFuncionarioPc().getCtpsGui().setText(funcionario.getCtpsNumero());
		getFuncionarioPc().getPisGui().setText(funcionario.getPis());
		getFuncionarioPc().getRGNumeroGui().setText(funcionario.getRgNumero());
		getFuncionarioPc().getRGOrgaoEmisssorGui().setText(funcionario.getRgOrgaoEmissor());

	}

	public void atualizarObjeto() {
		funcionario.setNome(getFuncionarioPc().getNomeGui().getText());
		funcionario.setConjuge(getFuncionarioPc().getConjugeGui().getText());
		funcionario.setFilhos(getFuncionarioPc().getFilhosGui().getText());
		funcionario.setMatricula(getFuncionarioPc().getMatriculaGui().getText());
		funcionario.setSexo((String) getFuncionarioPc().getSexoGui().getSelectedItem());
		funcionario.setNome(getFuncionarioPc().getNomeGui().getText());
		funcionario.setEstadoCivil((String) getFuncionarioPc().getEstadoCivilGui().getSelectedItem());
		funcionario.setCor((String) getFuncionarioPc().getCorGui().getSelectedItem());
		funcionario.setDeficiencia((String) getFuncionarioPc().getDeficienciaGui().getSelectedItem());
		funcionario.setEscolaridade((String) getFuncionarioPc().getEscolaridadeGui().getSelectedItem());
		funcionario.setNacionalidade((String) getFuncionarioPc().getNacionalidadeGui().getSelectedItem());
		funcionario.setEmail(getFuncionarioPc().getEmailGui().getText());
		funcionario.setFax(getFuncionarioPc().getFaxGui().getText());
		funcionario.setFone1(getFuncionarioPc().getFone1Gui().getText());
		funcionario.setFone2(getFuncionarioPc().getFone2Gui().getText());
		funcionario.setCargo(getFuncionarioPc().getCargoGui().getText());
		funcionario.setCategoria(getFuncionarioPc().getCategoriaGui().getText());
		funcionario.setCentroDeCusto((CentroCusto) getFuncionarioPc().getCentroCustoGui().getSelectedItem());
		funcionario.setDepartamento(getFuncionarioPc().getDepartamentoGui().getText());
		funcionario.setEmpresa(getFuncionarioPc().getEmpresaGui().getText());
		funcionario.setGerente(getFuncionarioPc().getGerenteGui().getText());
		funcionario.setSalario(getFuncionarioPc().getSalarioGui().getText());
		funcionario.setTurno(getFuncionarioPc().getTurnoGui().getText());
		funcionario.setBairro(getFuncionarioPc().getBairroGui().getText());
		funcionario.setCep(getFuncionarioPc().getCepGui().getText());
		funcionario.setCidade(getFuncionarioPc().getCidadeGui().getText());
		funcionario.setComplemento(getFuncionarioPc().getComplementoGui().getText());
		funcionario.setEstado(getFuncionarioPc().getEstadoGui().getText());
		funcionario.setLogradouro(getFuncionarioPc().getLogradouroGui().getText());
		funcionario.setPais(getFuncionarioPc().getPaisGui().getText());
		funcionario.setCnhCategoria(getFuncionarioPc().getCNHCategoriaGui().getText());
		funcionario.setCnpj(getFuncionarioPc().getCnpjGui().getText());
		funcionario.setCpf(getFuncionarioPc().getCpfGui().getText());
		funcionario.setCtpsNumero(getFuncionarioPc().getCtpsGui().getText());
		funcionario.setPis(getFuncionarioPc().getPisGui().getText());
		funcionario.setRgNumero(getFuncionarioPc().getRGNumeroGui().getText());
		funcionario.setRgOrgaoEmissor(getFuncionarioPc().getRGOrgaoEmisssorGui().getText());

		if (funcionario.getCnpj().equals(Mascara.getCnpjVazio())) {
			funcionario.setCnpj(null);
		}

		if (funcionario.getCpf().equals(Mascara.getCpfVazio())) {
			funcionario.setCpf(null);
		}
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public FuncionarioFc getFuncionarioFc() {
		return MainCont.getFuncionarioFc();
	}

	public FuncionarioPc getFuncionarioPc() {
		return MainCont.getFuncionarioFc().getFuncionarioPc();
	}

	public FuncionarioFp getFuncionarioFp() {
		return MainCont.getFuncionarioFp();
	}

	public FuncionarioPp getFuncionarioPp() {
		return MainCont.getFuncionarioFp().getFuncionarioPp();
	}
}
