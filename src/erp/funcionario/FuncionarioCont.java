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
			getFuncionarioPc().getNomeGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			funcionario = new Funcionario();
			FuncionarioCont.this.atualizarObjeto();
			getFuncionarioPp().pesquisarRegistroFuncionario(funcionario);
			MainCont.mostrarFrame(getFuncionarioFp());
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
				String nome = getFuncionarioPc().getNomeGUI().getText();
				if (nome == null || nome.length() == 0) {
					getFuncionarioPc().getNomeGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					FuncionarioFac.salvarRegistro(funcionario);
					funcionario = new Funcionario();
					getFuncionarioFc().limparGui();
					getFuncionarioPc().getNomeGUI().requestFocus();
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
		getFuncionarioPc().getNomeGUI().setText(funcionario.getNome());
		getFuncionarioPc().getConjugeGUI().setText(funcionario.getConjuge());
		getFuncionarioPc().getFilhosGUI().setText(funcionario.getFilhos());
		getFuncionarioPc().getMatriculaGUI().setText(funcionario.getMatricula());
		getFuncionarioPc().getSexoGUI().setSelectedItem(funcionario.getSexo());
		getFuncionarioPc().getCorGUI().setSelectedItem(funcionario.getCor());
		getFuncionarioPc().getDeficienciaGUI().setSelectedItem(funcionario.getDeficiencia());
		getFuncionarioPc().getEscolaridadeGUI().setSelectedItem(funcionario.getEscolaridade());
		getFuncionarioPc().getNacionalidadeGUI().setSelectedItem(funcionario.getNacionalidade());
		getFuncionarioPc().getNomeGUI().setText(funcionario.getNome());
		getFuncionarioPc().getEstadoCivilGUI().setSelectedItem(funcionario.getEstadoCivil());
		getFuncionarioPc().getEmailGUI().setText(funcionario.getEmail());
		getFuncionarioPc().getFaxGUI().setText(funcionario.getFax());
		getFuncionarioPc().getFone1GUI().setText(funcionario.getFone1());
		getFuncionarioPc().getFone2GUI().setText(funcionario.getFone2());
		getFuncionarioPc().getCargoGUI().setText(funcionario.getCargo());
		getFuncionarioPc().getCategoriaGUI().setText(funcionario.getCategoria());
		getFuncionarioPc().getCentroCustoGUI().setSelectedItem(funcionario.getCentroCusto());
		getFuncionarioPc().getDepartamentoGUI().setText(funcionario.getDepartamento());
		getFuncionarioPc().getEmpresaGUI().setText(funcionario.getEmpresa());
		getFuncionarioPc().getGerenteGUI().setText(funcionario.getGerente());
		getFuncionarioPc().getSalarioGUI().setText(funcionario.getSalario());
		getFuncionarioPc().getTurnoGUI().setText(funcionario.getTurno());
		getFuncionarioPc().getBairroGUI().setText(funcionario.getBairro());
		getFuncionarioPc().getCepGUI().setText(funcionario.getCep());
		getFuncionarioPc().getCidadeGUI().setText(funcionario.getCidade());
		getFuncionarioPc().getComplementoGUI().setText(funcionario.getComplemento());
		getFuncionarioPc().getEstadoGUI().setText(funcionario.getEstado());
		getFuncionarioPc().getLogradouroGUI().setText(funcionario.getLogradouro());
		getFuncionarioPc().getPaisGUI().setText(funcionario.getPais());
		getFuncionarioPc().getCNHCategoriaGUI().setText(funcionario.getCnhCategoria());
		getFuncionarioPc().getCnpjGUI().setText(funcionario.getCnpj());
		getFuncionarioPc().getCpfGUI().setText(funcionario.getCpf());
		getFuncionarioPc().getCtpsGUI().setText(funcionario.getCtpsNumero());
		getFuncionarioPc().getPisGUI().setText(funcionario.getPisNumero());
		getFuncionarioPc().getRGNumeroGUI().setText(funcionario.getRgNumero());
		getFuncionarioPc().getRGOrgaoEmisssorGUI().setText(funcionario.getRgOrgaoEmissor());

	}

	public void atualizarObjeto() {
		funcionario.setNome(getFuncionarioPc().getNomeGUI().getText());
		funcionario.setConjuge(getFuncionarioPc().getConjugeGUI().getText());
		funcionario.setFilhos(getFuncionarioPc().getFilhosGUI().getText());
		funcionario.setMatricula(getFuncionarioPc().getMatriculaGUI().getText());
		funcionario.setSexo((String) getFuncionarioPc().getSexoGUI().getSelectedItem());
		funcionario.setNome(getFuncionarioPc().getNomeGUI().getText());
		funcionario.setEstadoCivil((String) getFuncionarioPc().getEstadoCivilGUI().getSelectedItem());
		funcionario.setCor((String) getFuncionarioPc().getCorGUI().getSelectedItem());
		funcionario.setDeficiencia((String) getFuncionarioPc().getDeficienciaGUI().getSelectedItem());
		funcionario.setEscolaridade((String) getFuncionarioPc().getEscolaridadeGUI().getSelectedItem());
		funcionario.setNacionalidade((String) getFuncionarioPc().getNacionalidadeGUI().getSelectedItem());
		funcionario.setEmail(getFuncionarioPc().getEmailGUI().getText());
		funcionario.setFax(getFuncionarioPc().getFaxGUI().getText());
		funcionario.setFone1(getFuncionarioPc().getFone1GUI().getText());
		funcionario.setFone2(getFuncionarioPc().getFone2GUI().getText());
		funcionario.setCargo(getFuncionarioPc().getCargoGUI().getText());
		funcionario.setCategoria(getFuncionarioPc().getCategoriaGUI().getText());
		funcionario.setCentroDeCusto((CentroCusto) getFuncionarioPc().getCentroCustoGUI().getSelectedItem());
		funcionario.setDepartamento(getFuncionarioPc().getDepartamentoGUI().getText());
		funcionario.setEmpresa(getFuncionarioPc().getEmpresaGUI().getText());
		funcionario.setGerente(getFuncionarioPc().getGerenteGUI().getText());
		funcionario.setSalario(getFuncionarioPc().getSalarioGUI().getText());
		funcionario.setTurno(getFuncionarioPc().getTurnoGUI().getText());
		funcionario.setBairro(getFuncionarioPc().getBairroGUI().getText());
		funcionario.setCep(getFuncionarioPc().getCepGUI().getText());
		funcionario.setCidade(getFuncionarioPc().getCidadeGUI().getText());
		funcionario.setComplemento(getFuncionarioPc().getComplementoGUI().getText());
		funcionario.setEstado(getFuncionarioPc().getEstadoGUI().getText());
		funcionario.setLogradouro(getFuncionarioPc().getLogradouroGUI().getText());
		funcionario.setPais(getFuncionarioPc().getPaisGUI().getText());
		funcionario.setCnhCategoria(getFuncionarioPc().getCNHCategoriaGUI().getText());
		funcionario.setCnpj(getFuncionarioPc().getCnpjGUI().getText());
		funcionario.setCpf(getFuncionarioPc().getCpfGUI().getText());
		funcionario.setCtpsNumero(getFuncionarioPc().getCtpsGUI().getText());
		funcionario.setPisNumero(getFuncionarioPc().getPisGUI().getText());
		funcionario.setRgNumero(getFuncionarioPc().getRGNumeroGUI().getText());
		funcionario.setRgOrgaoEmissor(getFuncionarioPc().getRGOrgaoEmisssorGUI().getText());
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
