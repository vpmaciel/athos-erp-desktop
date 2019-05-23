package erp.curriculo.experienciaprofissional;

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
import erp.funcionario.Funcionario;
import erp.main.MainCont;

final class ExperienciaProfissionalCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (experienciaProfissional == null || experienciaProfissional.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				ExperienciaProfissionalFac.deletarRegistro(experienciaProfissional);
				getExperienciaProfissionalFc().limparGui();
				experienciaProfissional = new ExperienciaProfissional();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getExperienciaProfissionalFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getExperienciaProfissionalFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getExperienciaProfissionalFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			experienciaProfissional = new ExperienciaProfissional();
			getExperienciaProfissionalPc().getGuiFuncionario().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainCont.mostrarFrame(MainCont.getMainFc());
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<ExperienciaProfissional> experienciaProfissionals = new LinkedList<>();

			if (experienciaProfissional.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (experienciaProfissionals.add(ExperienciaProfissionalFac.getRegistro(experienciaProfissional))) {
				ExperienciaProfissionalRel experienciaProfissionalRel = new ExperienciaProfissionalRel(
						experienciaProfissionals);
				experienciaProfissionalRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getExperienciaProfissionalPc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			experienciaProfissional = new ExperienciaProfissional();
			getExperienciaProfissionalFc().limparGui();
			getExperienciaProfissionalPc().getGuiFuncionario().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getExperienciaProfissionalPp().pesquisarRegistro(experienciaProfissional);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getExperienciaProfissionalFp());
				getExperienciaProfissionalFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getExperienciaProfissionalPp().pesquisarRegistro(new ExperienciaProfissional());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getExperienciaProfissionalFp());
				getExperienciaProfissionalFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<ExperienciaProfissional> experienciaProfissionals = new LinkedList<>();

			try {
				experienciaProfissionals = new LinkedList<>(
						ExperienciaProfissionalFac.pesquisarRegistro(new ExperienciaProfissional()));
			} catch (Exception e) {
				System.out.println(e);
			}

			ExperienciaProfissionalRel experienciaProfissionalRel = new ExperienciaProfissionalRel(
					experienciaProfissionals);
			experienciaProfissionalRel.retornarRelatorio(true);

		}
	}

	public class SaidaSistema implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (Msg.confirmarSairDoSistema() == JOptionPane.YES_OPTION) {
				System.exit(0);
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
				if ((getExperienciaProfissionalPc().getGuiFuncionario().getSelectedItem()) == null) {
					getExperienciaProfissionalPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					System.out.println("SALVANDO");
					System.out.println(experienciaProfissional);
					ExperienciaProfissionalFac.salvarRegistro(experienciaProfissional);
					experienciaProfissional = new ExperienciaProfissional();
					getExperienciaProfissionalFc().limparGui();
					getExperienciaProfissionalPc().getGuiFuncionario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroSalvarRegistro();
			}
		}
	}

	private ExperienciaProfissional experienciaProfissional;

	public void atualizarGui() {
		if (experienciaProfissional == null) {
			return;
		}
		getExperienciaProfissionalPc().getGuiFuncionario().setSelectedItem(experienciaProfissional.getFuncionario());
		getExperienciaProfissionalPc().getGuiDataSaida().setText(experienciaProfissional.getDataSaida());
		getExperienciaProfissionalPc().getGuiCargo().setText(experienciaProfissional.getCargo());
		getExperienciaProfissionalPc().getGuiEmpresa().setText(experienciaProfissional.getEmpresa());
		getExperienciaProfissionalPc().getGuiDataAdmissao().setText(experienciaProfissional.getDataAdmissao());
		getExperienciaProfissionalPc().getGuiFuncoes().setText(experienciaProfissional.getFuncoes());
		getExperienciaProfissionalPc().getGuiNivelHierarquico()
				.setSelectedItem(experienciaProfissional.getNivelHierarquico());

	}

	public void atualizarObjeto() {
		experienciaProfissional
				.setFuncionario((Funcionario) getExperienciaProfissionalPc().getGuiFuncionario().getSelectedItem());
		experienciaProfissional.setCargo(getExperienciaProfissionalPc().getGuiCargo().getText());
		experienciaProfissional.setEmpresa(getExperienciaProfissionalPc().getGuiEmpresa().getText());
		experienciaProfissional.setDataAdmissao(getExperienciaProfissionalPc().getGuiDataAdmissao().getText());
		experienciaProfissional.setDataSaida(getExperienciaProfissionalPc().getGuiDataSaida().getText());
		experienciaProfissional.setNivelHierarquico(
				(String) getExperienciaProfissionalPc().getGuiNivelHierarquico().getSelectedItem());
		experienciaProfissional.setFuncoes(getExperienciaProfissionalPc().getGuiFuncoes().getText());

		if (experienciaProfissional.getDataAdmissao().equals(Mascara.getDataVazio())) {
			experienciaProfissional.setDataAdmissao(null);
		}
		if (experienciaProfissional.getDataSaida().equals(Mascara.getDataVazio())) {
			experienciaProfissional.setDataSaida(null);
		}
	}

	public ExperienciaProfissional getExperienciaProfissional() {
		return experienciaProfissional;
	}

	public ExperienciaProfissionalFc getExperienciaProfissionalFc() {
		return MainCont.getCurriculoExperienciaProfissionalFc();
	}

	public ExperienciaProfissionalFp getExperienciaProfissionalFp() {
		return MainCont.getCurriculoExperienciaProfissionalFp();
	}

	public ExperienciaProfissionalPc getExperienciaProfissionalPc() {
		return MainCont.getCurriculoExperienciaProfissionalFc().getExperienciaProfissionalPc();
	}

	public ExperienciaProfissionalPp getExperienciaProfissionalPp() {
		return MainCont.getCurriculoExperienciaProfissionalFp().getExperienciaProfissionalPp();
	}

	public void setExperienciaProfissional(ExperienciaProfissional experienciaProfissional) {
		this.experienciaProfissional = experienciaProfissional;
	}
}