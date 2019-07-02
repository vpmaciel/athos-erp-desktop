package erp.curriculo.idioma;

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
import erp.main.MainControl;

final class IdiomaControl {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (idioma == null || idioma.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				IdiomaFac.deletarRegistro(idioma);
				getIdiomaFc().limparGui();
				idioma = new Idioma();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getIdiomaFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getIdiomaFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getIdiomaFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			idioma = new Idioma();
			getIdiomaPc().getGuiFuncionario().requestFocus();
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
			List<Idioma> idiomas = new LinkedList<>();

			if (idioma.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (idiomas.add(IdiomaFac.getRegistro(idioma))) {
				IdiomaRel idiomaRel = new IdiomaRel(idiomas);
				idiomaRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getIdiomaPc().getLabelFuncionario()) {
				MainControl.mostrarFrame(MainControl.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			idioma = new Idioma();
			getIdiomaFc().limparGui();
			getIdiomaPc().getGuiFuncionario().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getIdiomaPp().pesquisarRegistro(idioma);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getIdiomaFp());
				getIdiomaFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getIdiomaPp().pesquisarRegistro(new Idioma());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getIdiomaFp());
				getIdiomaFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Idioma> idiomas = new LinkedList<>();

			try {
				idiomas = new LinkedList<>(IdiomaFac.pesquisarRegistro(new Idioma()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			IdiomaRel idiomaRel = new IdiomaRel(idiomas);
			idiomaRel.retornarRelatorio(true);

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
				if ((getIdiomaPc().getGuiFuncionario().getSelectedItem()) == null) {
					getIdiomaPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					IdiomaFac.salvarRegistro(idioma);
					idioma = new Idioma();
					getIdiomaFc().limparGui();
					getIdiomaPc().getGuiFuncionario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroSalvarRegistro();
			}
		}
	}

	private Idioma idioma;

	public void atualizarGui() {
		if (idioma == null) {
			return;
		}
		getIdiomaPc().getGuiFuncionario().setSelectedItem(idioma.getFuncionario());
		getIdiomaPc().getGuiConhecimento().setText(idioma.getConhecimento());
		getIdiomaPc().getGuiNivelConhecimento().setSelectedItem(idioma.getNivelConhecimento());

	}

	public void atualizarObjeto() {
		idioma.setFuncionario((Funcionario) getIdiomaPc().getGuiFuncionario().getSelectedItem());
		idioma.setConhecimento(getIdiomaPc().getGuiConhecimento().getText());
		idioma.setNivelConhecimento((String) getIdiomaPc().getGuiNivelConhecimento().getSelectedItem());
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public IdiomaFc getIdiomaFc() {
		return MainControl.getCurriculoIdiomaFc();
	}

	public IdiomaFp getIdiomaFp() {
		return MainControl.getCurriculoIdiomaFp();
	}

	public IdiomaPc getIdiomaPc() {
		return MainControl.getCurriculoIdiomaFc().getIdiomaPc();
	}

	public IdiomaPp getIdiomaPp() {
		return MainControl.getCurriculoIdiomaFp().getIdiomaPp();
	}

	public void setIdioma(Idioma Idioma) {
		this.idioma = Idioma;
	}
}
