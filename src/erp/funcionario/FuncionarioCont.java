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
			getFuncionarioPc().getGuiNome().requestFocus();
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
			List<Funcionario> funcionarios = new LinkedList<>();

			if (funcionario.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (funcionarios.add(FuncionarioFac.getRegistro(funcionario))) {
				FuncionarioRel funcionarioRel = new FuncionarioRel(funcionarios);
				funcionarioRel.retornarRelatorio(true);
			}
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
			getFuncionarioPc().getGuiNome().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getFuncionarioPp().pesquisarRegistro(funcionario);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getFuncionarioFp());
				getFuncionarioFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getFuncionarioPp().pesquisarRegistro(new Funcionario());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getFuncionarioFp());
				getFuncionarioFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Funcionario> funcionarios = new LinkedList<>();

			try {
				funcionarios = new LinkedList<>(FuncionarioFac.pesquisarRegistro(new Funcionario()));
			} catch (Exception e) {
				System.out.println(e);
			}

			FuncionarioRel funcionarioRel = new FuncionarioRel(funcionarios);
			funcionarioRel.retornarRelatorio(true);

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
				String nome = getFuncionarioPc().getGuiNome().getText();
				if (nome == null || nome.length() == 0) {
					getFuncionarioPc().getGuiNome().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					FuncionarioFac.salvarRegistro(funcionario);
					funcionario = new Funcionario();
					getFuncionarioFc().limparGui();
					getFuncionarioPc().getGuiNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Throwable throwable = e.getCause().getCause();
				String mensagem = throwable.toString();
				if (mensagem.contains("ConstraintViolationException")) {
					if (mensagem.contains("INDEX_FUNCIONARIO_CPF")) {
						Msg.avisoCampoDuplicado("CPF");
						getFuncionarioPc().getGuiCpf().requestFocus();
					} else if (mensagem.contains("INDEX_FUNCIONARIO_CNPJ")) {
						Msg.avisoCampoDuplicado("CNPJ");
						getFuncionarioPc().getGuiCnpj().requestFocus();
					} else {
						Msg.avisoCampoDuplicado();
					}
				}
				e.printStackTrace();
				Msg.erroSalvarRegistro();
			}
		}
	}

	private Funcionario funcionario;

	public void atualizarGui() {
		if (funcionario == null) {
			return;
		}
		getFuncionarioPc().getGuiNome().setText(funcionario.getNome());
		getFuncionarioPc().getGuiConjuge().setText(funcionario.getConjuge());
		getFuncionarioPc().getGuiFilhos().setText(funcionario.getFilhos());
		getFuncionarioPc().getGuiMatricula().setText(funcionario.getMatricula());
		getFuncionarioPc().getGuiSexo().setSelectedItem(funcionario.getSexo());
		getFuncionarioPc().getGuiDeficiencia().setSelectedItem(funcionario.getDeficiencia());
		getFuncionarioPc().getGuiEscolaridade().setSelectedItem(funcionario.getEscolaridade());
		getFuncionarioPc().getGuiNacionalidade().setSelectedItem(funcionario.getNacionalidade());
		getFuncionarioPc().getGuiEstadoCivil().setSelectedItem(funcionario.getEstadoCivil());
		getFuncionarioPc().getGuiEmail().setText(funcionario.getEmail());
		getFuncionarioPc().getGuiFax().setText(funcionario.getFax());
		getFuncionarioPc().getGuiFone1().setText(funcionario.getFone1());
		getFuncionarioPc().getGuiFone2().setText(funcionario.getFone2());
		getFuncionarioPc().getGuiCargo().setText(funcionario.getCargo());
		getFuncionarioPc().getGuiCategoria().setText(funcionario.getCategoria());
		getFuncionarioPc().getGuiCentroCusto().setSelectedItem(funcionario.getCentroCusto());
		getFuncionarioPc().getGuiDepartamento().setText(funcionario.getDepartamento());
		getFuncionarioPc().getGuiEmpresa().setText(funcionario.getEmpresa());
		getFuncionarioPc().getGuiGerente().setText(funcionario.getGerente());
		getFuncionarioPc().getGuiSalario().setText(funcionario.getSalario());
		getFuncionarioPc().getGuiTurno().setText(funcionario.getTurno());
		getFuncionarioPc().getGuiBairro().setText(funcionario.getBairro());
		getFuncionarioPc().getGuiCep().setText(funcionario.getCep());
		getFuncionarioPc().getGuiCidade().setText(funcionario.getCidade());
		getFuncionarioPc().getGuiComplemento().setText(funcionario.getComplemento());
		getFuncionarioPc().getGuiEstado().setText(funcionario.getEstado());
		getFuncionarioPc().getGuiLogradouro().setText(funcionario.getLogradouro());
		getFuncionarioPc().getGuiPais().setText(funcionario.getPais());
		getFuncionarioPc().getGuiCNHCategoria().setText(funcionario.getCnhCategoria());
		getFuncionarioPc().getGuiCnpj().setText(funcionario.getCnpj());
		getFuncionarioPc().getGuiCpf().setText(funcionario.getCpf());
		getFuncionarioPc().getGuiCtps().setText(funcionario.getCtpsNumero());
		getFuncionarioPc().getGuiPis().setText(funcionario.getPis());
		getFuncionarioPc().getGuiRGNumero().setText(funcionario.getRgNumero());
		getFuncionarioPc().getGuiRGOrgaoEmisssor().setText(funcionario.getRgOrgaoEmissor());
	}

	public void atualizarObjeto() {
		funcionario.setNome(getFuncionarioPc().getGuiNome().getText());
		funcionario.setConjuge(getFuncionarioPc().getGuiConjuge().getText());
		funcionario.setFilhos(getFuncionarioPc().getGuiFilhos().getText());
		funcionario.setMatricula(getFuncionarioPc().getGuiMatricula().getText());
		funcionario.setSexo((String) getFuncionarioPc().getGuiSexo().getSelectedItem());
		funcionario.setEstadoCivil((String) getFuncionarioPc().getGuiEstadoCivil().getSelectedItem());
		funcionario.setDeficiencia((String) getFuncionarioPc().getGuiDeficiencia().getSelectedItem());
		funcionario.setEscolaridade((String) getFuncionarioPc().getGuiEscolaridade().getSelectedItem());
		funcionario.setNacionalidade((String) getFuncionarioPc().getGuiNacionalidade().getSelectedItem());
		funcionario.setEmail(getFuncionarioPc().getGuiEmail().getText());
		funcionario.setFax(getFuncionarioPc().getGuiFax().getText());
		funcionario.setFone1(getFuncionarioPc().getGuiFone1().getText());
		funcionario.setFone2(getFuncionarioPc().getGuiFone2().getText());
		funcionario.setCargo(getFuncionarioPc().getGuiCargo().getText());
		funcionario.setCategoria(getFuncionarioPc().getGuiCategoria().getText());
		funcionario.setCentroDeCusto((CentroCusto) getFuncionarioPc().getGuiCentroCusto().getSelectedItem());
		funcionario.setDepartamento(getFuncionarioPc().getGuiDepartamento().getText());
		funcionario.setEmpresa(getFuncionarioPc().getGuiEmpresa().getText());
		funcionario.setGerente(getFuncionarioPc().getGuiGerente().getText());
		funcionario.setSalario(getFuncionarioPc().getGuiSalario().getText());
		funcionario.setTurno(getFuncionarioPc().getGuiTurno().getText());
		funcionario.setBairro(getFuncionarioPc().getGuiBairro().getText());
		funcionario.setCep(getFuncionarioPc().getGuiCep().getText());
		funcionario.setCidade(getFuncionarioPc().getGuiCidade().getText());
		funcionario.setComplemento(getFuncionarioPc().getGuiComplemento().getText());
		funcionario.setEstado(getFuncionarioPc().getGuiEstado().getText());
		funcionario.setLogradouro(getFuncionarioPc().getGuiLogradouro().getText());
		funcionario.setPais(getFuncionarioPc().getGuiPais().getText());
		funcionario.setCnhCategoria(getFuncionarioPc().getGuiCNHCategoria().getText());
		funcionario.setCnpj(getFuncionarioPc().getGuiCnpj().getText());
		funcionario.setCpf(getFuncionarioPc().getGuiCpf().getText());
		funcionario.setCtpsNumero(getFuncionarioPc().getGuiCtps().getText());
		funcionario.setPis(getFuncionarioPc().getGuiPis().getText());
		funcionario.setRgNumero(getFuncionarioPc().getGuiRGNumero().getText());
		funcionario.setRgOrgaoEmissor(getFuncionarioPc().getGuiRGOrgaoEmisssor().getText());

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

	public FuncionarioFc getFuncionarioFc() {
		return MainCont.getFuncionarioFc();
	}

	public FuncionarioFp getFuncionarioFp() {
		return MainCont.getFuncionarioFp();
	}

	public FuncionarioPc getFuncionarioPc() {
		return MainCont.getFuncionarioFc().getFuncionarioPc();
	}

	public FuncionarioPp getFuncionarioPp() {
		return MainCont.getFuncionarioFp().getFuncionarioPp();
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
