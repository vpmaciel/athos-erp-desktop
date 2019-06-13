package erp.curriculo;

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
import erp.funcionario.FuncionarioFac;
import erp.main.MainCont;

final class CurriculoCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getCurriculoFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getCurriculoFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getCurriculoFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			funcionario = new Funcionario();
			getCurriculoPc().getGuiFuncionario().requestFocus();
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
			List<Funcionario> funcionarioList = new LinkedList<>();
			atualizarObjeto();
			if (funcionario.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (funcionarioList.add(FuncionarioFac.getRegistro(funcionario))) {
				CurriculoRel curriculoRel = new CurriculoRel(funcionarioList);
				curriculoRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getCurriculoPc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getCurriculoFc());
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getCurriculoPp().pesquisarRegistro(new Funcionario());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getCurriculoFp());
				getCurriculoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
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

	private Funcionario funcionario;

	public void atualizarGui() {
		if (funcionario == null) {
			return;
		}
		getCurriculoPc().getGuiFuncionario().setSelectedItem(funcionario);
	}

	public void atualizarObjeto() {
		funcionario = (Funcionario) getCurriculoPc().getGuiFuncionario().getSelectedItem();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public CurriculoFc getCurriculoFc() {
		return MainCont.getCurriculoFc();
	}

	public CurriculoFp getCurriculoFp() {
		return MainCont.getCurriculoFp();
	}

	public CurriculoPc getCurriculoPc() {
		return MainCont.getCurriculoFc().getCurriculoPc();
	}

	public CurriculoPp getCurriculoPp() {
		return MainCont.getCurriculoFp().getCurriculoPp();
	}

	public void setFuncionario(Funcionario Funcionario) {
		this.funcionario = Funcionario;
	}
}
