package erp.curriculo.curso;

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
import erp.main.MainControl;

final class CursoControl {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (curso == null || curso.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				CursoFac.deletarRegistro(curso);
				getCursoFc().limparGui();
				curso = new Curso();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getCursoFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getCursoFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getCursoFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			curso = new Curso();
			getCursoPc().getGuiFuncionario().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainControl.mostrarFrame(MainControl.getMainFc());
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Curso> cursos = new LinkedList<>();

			if (curso.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (cursos.add(CursoFac.getRegistro(curso))) {
				CursoRel cursoRel = new CursoRel(cursos);
				cursoRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getCursoPc().getLabelFuncionario()) {
				MainControl.mostrarFrame(MainControl.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			curso = new Curso();
			getCursoFc().limparGui();
			getCursoPc().getGuiFuncionario().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getCursoPp().pesquisarRegistro(curso);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getCursoFp());
				getCursoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getCursoPp().pesquisarRegistro(new Curso());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getCursoFp());
				getCursoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Curso> cursos = new LinkedList<>();

			try {
				cursos = new LinkedList<>(CursoFac.pesquisarRegistro(new Curso()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			CursoRel cursoRel = new CursoRel(cursos);
			cursoRel.retornarRelatorio(true);

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
				if ((getCursoPc().getGuiFuncionario().getSelectedItem()) == null) {
					getCursoPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CursoFac.salvarRegistro(curso);
					curso = new Curso();
					getCursoFc().limparGui();
					getCursoPc().getGuiFuncionario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroSalvarRegistro();
			}
		}
	}

	private Curso curso;

	public void atualizarGui() {
		if (curso == null) {
			return;
		}
		getCursoPc().getGuiFuncionario().setSelectedItem(curso.getFuncionario());
		getCursoPc().getGuiAnoConclusao().setText(curso.getAnoConclusao());
		getCursoPc().getGuiNome().setText(curso.getCurso());
		getCursoPc().getGuiInstituicao().setText(curso.getInstituicao());
		getCursoPc().getGuiAnoInicio().setText(curso.getAnoInicio());
		getCursoPc().getGuiSituacao().setSelectedItem(curso.getSituacao());
		getCursoPc().getGuiModalidade().setSelectedItem(curso.getModalidade());
		getCursoPc().getGuiNivel().setSelectedItem(curso.getNivel());

	}

	public void atualizarObjeto() {
		curso.setFuncionario((Funcionario) getCursoPc().getGuiFuncionario().getSelectedItem());
		curso.setNome(getCursoPc().getGuiNome().getText());
		curso.setInstituicao(getCursoPc().getGuiInstituicao().getText());
		curso.setAnoInicio(getCursoPc().getGuiAnoInicio().getText());
		curso.setAnoConclusao(getCursoPc().getGuiAnoConclusao().getText());
		curso.setModalidade((String) getCursoPc().getGuiModalidade().getSelectedItem());
		curso.setNivel((String) getCursoPc().getGuiNivel().getSelectedItem());
		curso.setSituacao((String) getCursoPc().getGuiSituacao().getSelectedItem());

		if (curso.getAnoConclusao().equals(Mascara.getAnoVazio())) {
			curso.setAnoConclusao(null);
		}
		if (curso.getAnoInicio().equals(Mascara.getAnoVazio())) {
			curso.setAnoInicio(null);
		}
	}

	public Curso getCurso() {
		return curso;
	}

	public CursoFc getCursoFc() {
		return MainControl.getCurriculoCursoFc();
	}

	public CursoFp getCursoFp() {
		return MainControl.getCurriculoCursoFp();
	}

	public CursoPc getCursoPc() {
		return MainControl.getCurriculoCursoFc().getCursoPc();
	}

	public CursoPp getCursoPp() {
		return MainControl.getCurriculoCursoFp().getCursoPp();
	}

	public void setCurso(Curso Curso) {
		this.curso = Curso;
	}
}
