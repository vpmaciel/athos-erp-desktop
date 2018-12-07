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
import erp.main.MainCT;

final class FuncionarioCT {

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
				FuncionarioFAC.deletarRegistro(funcionario);
				getFuncionarioFC().limparGUI();
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
				MainCT.getFuncionarioFC().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFuncionarioFC().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFuncionarioFC().setVisible(false);
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
				MainCT.mostrarFrame(MainCT.getFrameMain());
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
				if (funcionarios.add(FuncionarioFAC.getRegistro(funcionario))) {
					FuncionarioREL funcionarioREL = new FuncionarioREL(funcionarios);
					funcionarioREL.retornarRelatorio(true);
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
				funcionarios = new LinkedList<>(FuncionarioFAC.pesquisarRegistro(funcionario));
			} catch (Exception e) {
				System.out.println(e);
			}
			FuncionarioREL funcionarioREL = new FuncionarioREL(funcionarios);
			funcionarioREL.retornarRelatorio(true);
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getFuncionarioPC().getLabelCentroCusto()) {
				MainCT.mostrarFrame(MainCT.getCentroCustoFC());
			} else {
				MainCT.getCentroCustoFC().reiniciarGUI();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			funcionario = new Funcionario();
			MainCT.getFuncionarioFC().limparGUI();
			getFuncionarioPC().getNomeGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			funcionario = new Funcionario();
			FuncionarioCT.this.atualizarObjeto();
			getFuncionarioPP().pesquisarRegistroFuncionario(funcionario);
			MainCT.mostrarFrame(getFuncionarioFP());
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
				String nome = getFuncionarioPC().getNomeGUI().getText();
				if (nome == null || nome.length() == 0) {
					getFuncionarioPC().getNomeGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					FuncionarioFAC.salvarRegistro(funcionario);
					funcionario = new Funcionario();
					getFuncionarioFC().limparGUI();
					getFuncionarioPC().getNomeGUI().requestFocus();
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
		getFuncionarioPC().getNomeGUI().setText(funcionario.getNome());
		getFuncionarioPC().getConjugeGUI().setText(funcionario.getConjuge());
		getFuncionarioPC().getFilhosGUI().setText(funcionario.getFilhos());
		getFuncionarioPC().getMatriculaGUI().setText(funcionario.getMatricula());
		getFuncionarioPC().getSexoGUI().setSelectedItem(funcionario.getSexo());
		getFuncionarioPC().getCorGUI().setSelectedItem(funcionario.getCor());
		getFuncionarioPC().getDeficienciaGUI().setSelectedItem(funcionario.getDeficiencia());
		getFuncionarioPC().getEscolaridadeGUI().setSelectedItem(funcionario.getEscolaridade());
		getFuncionarioPC().getNacionalidadeGUI().setSelectedItem(funcionario.getNacionalidade());
		getFuncionarioPC().getNomeGUI().setText(funcionario.getNome());
		getFuncionarioPC().getEstadoCivilGUI().setSelectedItem(funcionario.getEstadoCivil());
		getFuncionarioPC().getEmailGUI().setText(funcionario.getEmail());
		getFuncionarioPC().getFaxGUI().setText(funcionario.getFax());
		getFuncionarioPC().getFone1GUI().setText(funcionario.getFone1());
		getFuncionarioPC().getFone2GUI().setText(funcionario.getFone2());
		getFuncionarioPC().getCargoGUI().setText(funcionario.getCargo());
		getFuncionarioPC().getCategoriaGUI().setText(funcionario.getCategoria());
		getFuncionarioPC().getCentroCustoGUI().setSelectedItem(funcionario.getCentroCusto());
		getFuncionarioPC().getDepartamentoGUI().setText(funcionario.getDepartamento());
		getFuncionarioPC().getEmpresaGUI().setText(funcionario.getEmpresa());
		getFuncionarioPC().getGerenteGUI().setText(funcionario.getGerente());
		getFuncionarioPC().getSalarioGUI().setText(funcionario.getSalario());
		getFuncionarioPC().getTurnoGUI().setText(funcionario.getTurno());
		getFuncionarioPC().getBairroGUI().setText(funcionario.getBairro());
		getFuncionarioPC().getCepGUI().setText(funcionario.getCep());
		getFuncionarioPC().getCidadeGUI().setText(funcionario.getCidade());
		getFuncionarioPC().getComplementoGUI().setText(funcionario.getComplemento());
		getFuncionarioPC().getEstadoGUI().setText(funcionario.getEstado());
		getFuncionarioPC().getLogradouroGUI().setText(funcionario.getLogradouro());
		getFuncionarioPC().getPaisGUI().setText(funcionario.getPais());
		getFuncionarioPC().getCNHCategoriaGUI().setText(funcionario.getCnhCategoria());
		getFuncionarioPC().getCnpjGUI().setText(funcionario.getCnpj());
		getFuncionarioPC().getCpfGUI().setText(funcionario.getCpf());
		getFuncionarioPC().getCtpsGUI().setText(funcionario.getCtpsNumero());
		getFuncionarioPC().getPisGUI().setText(funcionario.getPisNumero());
		getFuncionarioPC().getRGNumeroGUI().setText(funcionario.getRgNumero());
		getFuncionarioPC().getRGOrgaoEmisssorGUI().setText(funcionario.getRgOrgaoEmissor());

	}

	public void atualizarObjeto() {
		funcionario.setNome(getFuncionarioPC().getNomeGUI().getText());
		funcionario.setConjuge(getFuncionarioPC().getConjugeGUI().getText());
		funcionario.setFilhos(getFuncionarioPC().getFilhosGUI().getText());
		funcionario.setMatricula(getFuncionarioPC().getMatriculaGUI().getText());
		funcionario.setSexo((String) getFuncionarioPC().getSexoGUI().getSelectedItem());
		funcionario.setNome(getFuncionarioPC().getNomeGUI().getText());
		funcionario.setEstadoCivil((String) getFuncionarioPC().getEstadoCivilGUI().getSelectedItem());
		funcionario.setCor((String) getFuncionarioPC().getCorGUI().getSelectedItem());
		funcionario.setDeficiencia((String) getFuncionarioPC().getDeficienciaGUI().getSelectedItem());
		funcionario.setEscolaridade((String) getFuncionarioPC().getEscolaridadeGUI().getSelectedItem());
		funcionario.setNacionalidade((String) getFuncionarioPC().getNacionalidadeGUI().getSelectedItem());
		funcionario.setEmail(getFuncionarioPC().getEmailGUI().getText());
		funcionario.setFax(getFuncionarioPC().getFaxGUI().getText());
		funcionario.setFone1(getFuncionarioPC().getFone1GUI().getText());
		funcionario.setFone2(getFuncionarioPC().getFone2GUI().getText());
		funcionario.setCargo(getFuncionarioPC().getCargoGUI().getText());
		funcionario.setCategoria(getFuncionarioPC().getCategoriaGUI().getText());
		funcionario.setCentroDeCusto((CentroCusto) getFuncionarioPC().getCentroCustoGUI().getSelectedItem());
		funcionario.setDepartamento(getFuncionarioPC().getDepartamentoGUI().getText());
		funcionario.setEmpresa(getFuncionarioPC().getEmpresaGUI().getText());
		funcionario.setGerente(getFuncionarioPC().getGerenteGUI().getText());
		funcionario.setSalario(getFuncionarioPC().getSalarioGUI().getText());
		funcionario.setTurno(getFuncionarioPC().getTurnoGUI().getText());
		funcionario.setBairro(getFuncionarioPC().getBairroGUI().getText());
		funcionario.setCep(getFuncionarioPC().getCepGUI().getText());
		funcionario.setCidade(getFuncionarioPC().getCidadeGUI().getText());
		funcionario.setComplemento(getFuncionarioPC().getComplementoGUI().getText());
		funcionario.setEstado(getFuncionarioPC().getEstadoGUI().getText());
		funcionario.setLogradouro(getFuncionarioPC().getLogradouroGUI().getText());
		funcionario.setPais(getFuncionarioPC().getPaisGUI().getText());
		funcionario.setCnhCategoria(getFuncionarioPC().getCNHCategoriaGUI().getText());
		funcionario.setCnpj(getFuncionarioPC().getCnpjGUI().getText());
		funcionario.setCpf(getFuncionarioPC().getCpfGUI().getText());
		funcionario.setCtpsNumero(getFuncionarioPC().getCtpsGUI().getText());
		funcionario.setPisNumero(getFuncionarioPC().getPisGUI().getText());
		funcionario.setRgNumero(getFuncionarioPC().getRGNumeroGUI().getText());
		funcionario.setRgOrgaoEmissor(getFuncionarioPC().getRGOrgaoEmisssorGUI().getText());
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public FuncionarioFC getFuncionarioFC() {
		return MainCT.getFuncionarioFC();
	}

	public FuncionarioPC getFuncionarioPC() {
		return MainCT.getFuncionarioFC().getFuncionarioPC();
	}

	public FuncionarioFP getFuncionarioFP() {
		return MainCT.getFuncionarioFP();
	}

	public FuncionarioPP getFuncionarioPP() {
		return MainCT.getFuncionarioFP().getFuncionarioPP();
	}
}
