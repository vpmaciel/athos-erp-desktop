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
import erp.centrocusto.CentroCusto;
import erp.main.MainGerenteEventos;

final class FuncionarioGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (funcionario == null || funcionario.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				FuncionarioDaoFacade.deletarRegistro(funcionario);
				getFrameCadastroFuncionario().limparGui();
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
				MainGerenteEventos.getFrameCadastroFuncionario().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroFuncionario().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroFuncionario().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			funcionario = new Funcionario();
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
			List<Funcionario> funcionarios = new LinkedList<>();

			if (funcionario.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (funcionarios.add(FuncionarioDaoFacade.getRegistro(funcionario))) {
					FuncionarioRelatorio funcionarioRelatorio = new FuncionarioRelatorio(funcionarios);
					funcionarioRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Funcionario> funcionarios = new LinkedList<>();

			try {
				funcionarios = new LinkedList<>(FuncionarioDaoFacade.pesquisarRegistro(funcionario));
			} catch (Exception e) {
				System.out.println(e);
			}
			FuncionarioRelatorio funcionarioRelatorio = new FuncionarioRelatorio(funcionarios);
			funcionarioRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameCentroCusto extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getPanelCadastroFuncionario().getLabelCentroCusto()) {
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroCentroCusto());
			} else {
				MainGerenteEventos.getFrameCadastroCentroCusto().reiniciarBox();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			funcionario = new Funcionario();
			MainGerenteEventos.getFrameCadastroFuncionario().limparGui();
			getPanelCadastroFuncionario().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			funcionario = new Funcionario();
			FuncionarioGerenteEventos.this.atualizarObjeto();
			getPanelPesquisaFuncionario().pesquisarRegistroFuncionario(funcionario);
			MainGerenteEventos.mostrarFrame(getFramePesquisaFuncionario());
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
				String nome = getPanelCadastroFuncionario().getTextFieldNome().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroFuncionario().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("Nome");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					FuncionarioDaoFacade.salvarRegistro(funcionario);
					funcionario = new Funcionario();
					getFrameCadastroFuncionario().limparGui();
					getPanelCadastroFuncionario().getTextFieldNome().requestFocus();
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
		getPanelCadastroFuncionario().getTextFieldNome().setText(funcionario.getNome());
		getPanelCadastroFuncionario().getTextFieldConjuge().setText(funcionario.getConjuge());
		getPanelCadastroFuncionario().getTextFieldFilhos().setText(funcionario.getFilhos());
		getPanelCadastroFuncionario().getTextFieldMatricula().setText(funcionario.getMatricula());
		getPanelCadastroFuncionario().getBoxSexo().setSelectedItem(funcionario.getSexo());
		getPanelCadastroFuncionario().getBoxCor().setSelectedItem(funcionario.getCor());
		getPanelCadastroFuncionario().getBoxDeficiencia().setSelectedItem(funcionario.getDeficiencia());
		getPanelCadastroFuncionario().getBoxEscolaridade().setSelectedItem(funcionario.getEscolaridade());
		getPanelCadastroFuncionario().getBoxNacionalidade().setSelectedItem(funcionario.getNacionalidade());
		getPanelCadastroFuncionario().getTextFieldNome().setText(funcionario.getNome());
		getPanelCadastroFuncionario().getBoxEstadoCivil().setSelectedItem(funcionario.getEstadoCivil());
		getPanelCadastroFuncionario().getTextFieldEmail().setText(funcionario.getEmail());
		getPanelCadastroFuncionario().getTextFieldFax().setText(funcionario.getFax());
		getPanelCadastroFuncionario().getTextFieldFone1().setText(funcionario.getFone1());
		getPanelCadastroFuncionario().getTextFieldFone2().setText(funcionario.getFone2());
		getPanelCadastroFuncionario().getTextFieldCargo().setText(funcionario.getCargo());
		getPanelCadastroFuncionario().getTextFieldCategoria().setText(funcionario.getCategoria());
		getPanelCadastroFuncionario().getBoxCentroCusto().setSelectedItem(funcionario.getCentroCusto());
		getPanelCadastroFuncionario().getTextFieldDepartamento().setText(funcionario.getDepartamento());
		getPanelCadastroFuncionario().getTextFieldEmpresa().setText(funcionario.getEmpresa());
		getPanelCadastroFuncionario().getTextFieldGerente().setText(funcionario.getGerente());
		getPanelCadastroFuncionario().getTextFieldSalario().setText(funcionario.getSalario());
		getPanelCadastroFuncionario().getTextFieldTurno().setText(funcionario.getTurno());
		getPanelCadastroFuncionario().getTextFieldBairro().setText(funcionario.getBairro());
		getPanelCadastroFuncionario().getTextFieldCep().setText(funcionario.getCep());
		getPanelCadastroFuncionario().getTextFieldCidade().setText(funcionario.getCidade());
		getPanelCadastroFuncionario().getTextFieldComplemento().setText(funcionario.getComplemento());
		getPanelCadastroFuncionario().getTextFieldEstado().setText(funcionario.getEstado());
		getPanelCadastroFuncionario().getTextFieldLogradouro().setText(funcionario.getLogradouro());
		getPanelCadastroFuncionario().getTextFieldPais().setText(funcionario.getPais());
		getPanelCadastroFuncionario().getTextFieldCNHCategoria().setText(funcionario.getCnhCategoria());
		getPanelCadastroFuncionario().getTextFieldCNPJ().setText(funcionario.getCnpj());
		getPanelCadastroFuncionario().getTextFieldCPF().setText(funcionario.getCpfNumero());
		getPanelCadastroFuncionario().getTextFieldCTPS().setText(funcionario.getCtpsNumero());
		getPanelCadastroFuncionario().getTextFieldPIS().setText(funcionario.getPisNumero());
		getPanelCadastroFuncionario().getTextFieldRGNumero().setText(funcionario.getRgNumero());
		getPanelCadastroFuncionario().getTextFieldRGOrgaoEmisssor().setText(funcionario.getRgOrgaoEmissor());

	}

	public void atualizarObjeto() {
		funcionario.setNome(getPanelCadastroFuncionario().getTextFieldNome().getText());
		funcionario.setConjuge(getPanelCadastroFuncionario().getTextFieldConjuge().getText());
		funcionario.setFilhos(getPanelCadastroFuncionario().getTextFieldFilhos().getText());
		funcionario.setMatricula(getPanelCadastroFuncionario().getTextFieldMatricula().getText());
		funcionario.setSexo((String) getPanelCadastroFuncionario().getBoxSexo().getSelectedItem());
		funcionario.setNome(getPanelCadastroFuncionario().getTextFieldNome().getText());
		funcionario.setEstadoCivil((String) getPanelCadastroFuncionario().getBoxEstadoCivil().getSelectedItem());
		funcionario.setCor((String) getPanelCadastroFuncionario().getBoxCor().getSelectedItem());
		funcionario.setDeficiencia((String) getPanelCadastroFuncionario().getBoxDeficiencia().getSelectedItem());
		funcionario.setEscolaridade((String) getPanelCadastroFuncionario().getBoxEscolaridade().getSelectedItem());
		funcionario.setNacionalidade((String) getPanelCadastroFuncionario().getBoxNacionalidade().getSelectedItem());
		funcionario.setEmail(getPanelCadastroFuncionario().getTextFieldEmail().getText());
		funcionario.setFax(getPanelCadastroFuncionario().getTextFieldFax().getText());
		funcionario.setFone1(getPanelCadastroFuncionario().getTextFieldFone1().getText());
		funcionario.setFone2(getPanelCadastroFuncionario().getTextFieldFone2().getText());
		funcionario.setCargo(getPanelCadastroFuncionario().getTextFieldCargo().getText());
		funcionario.setCategoria(getPanelCadastroFuncionario().getTextFieldCategoria().getText());
		funcionario.setCentroDeCusto((CentroCusto) getPanelCadastroFuncionario().getBoxCentroCusto().getSelectedItem());
		funcionario.setDepartamento(getPanelCadastroFuncionario().getTextFieldDepartamento().getText());
		funcionario.setEmpresa(getPanelCadastroFuncionario().getTextFieldEmpresa().getText());
		funcionario.setGerente(getPanelCadastroFuncionario().getTextFieldGerente().getText());
		funcionario.setSalario(getPanelCadastroFuncionario().getTextFieldSalario().getText());
		funcionario.setTurno(getPanelCadastroFuncionario().getTextFieldTurno().getText());
		funcionario.setBairro(getPanelCadastroFuncionario().getTextFieldBairro().getText());
		funcionario.setCep(getPanelCadastroFuncionario().getTextFieldCep().getText());
		funcionario.setCidade(getPanelCadastroFuncionario().getTextFieldCidade().getText());
		funcionario.setComplemento(getPanelCadastroFuncionario().getTextFieldComplemento().getText());
		funcionario.setEstado(getPanelCadastroFuncionario().getTextFieldEstado().getText());
		funcionario.setLogradouro(getPanelCadastroFuncionario().getTextFieldLogradouro().getText());
		funcionario.setPais(getPanelCadastroFuncionario().getTextFieldPais().getText());
		funcionario.setCnhCategoria(getPanelCadastroFuncionario().getTextFieldCNHCategoria().getText());
		funcionario.setCnpj(getPanelCadastroFuncionario().getTextFieldCNPJ().getText());
		funcionario.setCpfNumero(getPanelCadastroFuncionario().getTextFieldCPF().getText());
		funcionario.setCtpsNumero(getPanelCadastroFuncionario().getTextFieldCTPS().getText());
		funcionario.setPisNumero(getPanelCadastroFuncionario().getTextFieldPIS().getText());
		funcionario.setRgNumero(getPanelCadastroFuncionario().getTextFieldRGNumero().getText());
		funcionario.setRgOrgaoEmissor(getPanelCadastroFuncionario().getTextFieldRGOrgaoEmisssor().getText());
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public FrameCadastroFuncionario getFrameCadastroFuncionario() {
		return MainGerenteEventos.getFrameCadastroFuncionario();
	}

	public PanelCadastroFuncionario getPanelCadastroFuncionario() {
		return MainGerenteEventos.getFrameCadastroFuncionario().getPanelCadastroFuncionario();
	}

	public FramePesquisaFuncionario getFramePesquisaFuncionario() {
		return MainGerenteEventos.getFramePesquisaFuncionario();
	}

	public PanelPesquisaFuncionario getPanelPesquisaFuncionario() {
		return MainGerenteEventos.getFramePesquisaFuncionario().getPanelPesquisaFuncionario();
	}
}
