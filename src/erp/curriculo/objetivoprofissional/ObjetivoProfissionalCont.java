package erp.curriculo.objetivoprofissional;

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
import erp.funcionario.Funcionario;
import erp.main.MainCont;

final class ObjetivoProfissionalCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (objetivoProfissional == null || objetivoProfissional.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				ObjetivoProfissionalFac.deletarRegistro(objetivoProfissional);
				getObjetivoProfissionalFc().limparGui();
				objetivoProfissional = new ObjetivoProfissional();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getObjetivoProfissionalFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getObjetivoProfissionalFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getObjetivoProfissionalFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			objetivoProfissional = new ObjetivoProfissional();
			getObjetivoProfissionalPc().getGuiFuncionario().requestFocus();
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
			List<ObjetivoProfissional> objetivoProfissionals = new LinkedList<>();

			if (objetivoProfissional.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (objetivoProfissionals.add(ObjetivoProfissionalFac.getRegistro(objetivoProfissional))) {
				ObjetivoProfissionalRel objetivoProfissionalRel = new ObjetivoProfissionalRel(objetivoProfissionals);
				objetivoProfissionalRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getObjetivoProfissionalPc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			objetivoProfissional = new ObjetivoProfissional();
			getObjetivoProfissionalFc().limparGui();
			getObjetivoProfissionalPc().getGuiFuncionario().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getObjetivoProfissionalPp().pesquisarRegistroCaracteristica(objetivoProfissional);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getObjetivoProfissionalFp());
				getObjetivoProfissionalFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<ObjetivoProfissional> objetivoProfissionals = new LinkedList<>();

			try {
				objetivoProfissionals = new LinkedList<>(
						ObjetivoProfissionalFac.pesquisarRegistro(new ObjetivoProfissional()));
			} catch (Exception e) {
				System.out.println(e);
			}

			ObjetivoProfissionalRel objetivoProfissionalRel = new ObjetivoProfissionalRel(objetivoProfissionals);
			objetivoProfissionalRel.retornarRelatorio(true);

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
				if ((getObjetivoProfissionalPc().getGuiFuncionario().getSelectedItem()) == null) {
					getObjetivoProfissionalPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ObjetivoProfissionalFac.salvarRegistro(objetivoProfissional);
					objetivoProfissional = new ObjetivoProfissional();
					getObjetivoProfissionalFc().limparGui();
					getObjetivoProfissionalPc().getGuiFuncionario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private ObjetivoProfissional objetivoProfissional;

	public void atualizarGui() {
		if (objetivoProfissional == null) {
			return;
		}
		getObjetivoProfissionalPc().getGuiFuncionario().setSelectedItem(objetivoProfissional.getFuncionario());
		getObjetivoProfissionalPc().getGuiAreaInteresse().setSelectedItem(objetivoProfissional.getAreaInteresse());
		getObjetivoProfissionalPc().getGuiCargo().setText(objetivoProfissional.getCargo());
		getObjetivoProfissionalPc().getGuiContrato().setSelectedItem(objetivoProfissional.getContrato());
		getObjetivoProfissionalPc().getGuiNivelHierarquico()
				.setSelectedItem(objetivoProfissional.getNivelHierarquico());
		getObjetivoProfissionalPc().getGuiPretensaoSalarial()
				.setSelectedItem(objetivoProfissional.getPretensaoSalarial());

	}

	public void atualizarObjeto() {
		objetivoProfissional
				.setFuncionario((Funcionario) getObjetivoProfissionalPc().getGuiFuncionario().getSelectedItem());
		objetivoProfissional
				.setAreaInteresse((String) getObjetivoProfissionalPc().getGuiAreaInteresse().getSelectedItem());
		objetivoProfissional.setCargo(getObjetivoProfissionalPc().getGuiCargo().getText());
		objetivoProfissional.setContrato((String) getObjetivoProfissionalPc().getGuiContrato().getSelectedItem());
		objetivoProfissional
				.setNivelHierarquico((String) getObjetivoProfissionalPc().getGuiNivelHierarquico().getSelectedItem());
		objetivoProfissional
				.setPretensaoSalarial((String) getObjetivoProfissionalPc().getGuiPretensaoSalarial().getSelectedItem());
	}

	public ObjetivoProfissional getObjetivoProfissional() {
		return objetivoProfissional;
	}

	public ObjetivoProfissionalFc getObjetivoProfissionalFc() {
		return MainCont.getCurriculoObjetivoProfissionalFc();
	}

	public ObjetivoProfissionalFp getObjetivoProfissionalFp() {
		return MainCont.getCurriculoObjetivoProfissionalFp();
	}

	public ObjetivoProfissionalPc getObjetivoProfissionalPc() {
		return MainCont.getCurriculoObjetivoProfissionalFc().getObjetivoProfissionalPc();
	}

	public ObjetivoProfissionalPp getObjetivoProfissionalPp() {
		return MainCont.getCurriculoObjetivoProfissionalFp().getObjetivoProfissionalPp();
	}

	public void setObjetivoProfissional(ObjetivoProfissional ObjetivoProfissional) {
		this.objetivoProfissional = ObjetivoProfissional;
	}
}
