package erp.curriculo.habilidade;

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

final class HabilidadeCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (habilidade == null || habilidade.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				HabilidadeFac.deletarRegistro(habilidade);
				getHabilidadeFc().limparGui();
				habilidade = new Habilidade();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getHabilidadeFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getHabilidadeFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getHabilidadeFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			habilidade = new Habilidade();
			getHabilidadePc().getGuiFuncionario().requestFocus();
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
			List<Habilidade> habilidades = new LinkedList<>();

			if (habilidade.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (habilidades.add(HabilidadeFac.getRegistro(habilidade))) {
				HabilidadeRel habilidadeRel = new HabilidadeRel(habilidades);
				habilidadeRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getHabilidadePc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			habilidade = new Habilidade();
			getHabilidadeFc().limparGui();
			getHabilidadePc().getGuiFuncionario().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getHabilidadePp().pesquisarRegistro(habilidade);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getHabilidadeFp());
				getHabilidadeFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getHabilidadePp().pesquisarRegistro(new Habilidade());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getHabilidadeFp());
				getHabilidadeFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Habilidade> habilidades = new LinkedList<>();

			try {
				habilidades = new LinkedList<>(HabilidadeFac.pesquisarRegistro(new Habilidade()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			HabilidadeRel habilidadeRel = new HabilidadeRel(habilidades);
			habilidadeRel.retornarRelatorio(true);

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
				if ((getHabilidadePc().getGuiFuncionario().getSelectedItem()) == null) {
					getHabilidadePc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					HabilidadeFac.salvarRegistro(habilidade);
					habilidade = new Habilidade();
					getHabilidadeFc().limparGui();
					getHabilidadePc().getGuiFuncionario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroSalvarRegistro();
			}
		}
	}

	private Habilidade habilidade;

	public void atualizarGui() {
		if (habilidade == null) {
			return;
		}
		getHabilidadePc().getGuiFuncionario().setSelectedItem(habilidade.getFuncionario());
		getHabilidadePc().getGuiConhecimento().setText(habilidade.getConhecimento());
		getHabilidadePc().getGuiNivelConhecimento().setSelectedItem(habilidade.getNivelConhecimento());

	}

	public void atualizarObjeto() {
		habilidade.setFuncionario((Funcionario) getHabilidadePc().getGuiFuncionario().getSelectedItem());
		habilidade.setConhecimento(getHabilidadePc().getGuiConhecimento().getText());
		habilidade.setNivelConhecimento((String) getHabilidadePc().getGuiNivelConhecimento().getSelectedItem());
	}

	public Habilidade getHabilidade() {
		return habilidade;
	}

	public HabilidadeFc getHabilidadeFc() {
		return MainCont.getCurriculoHabilidadeFc();
	}

	public HabilidadeFp getHabilidadeFp() {
		return MainCont.getCurriculoHabilidadeFp();
	}

	public HabilidadePc getHabilidadePc() {
		return MainCont.getCurriculoHabilidadeFc().getHabilidadePc();
	}

	public HabilidadePp getHabilidadePp() {
		return MainCont.getCurriculoHabilidadeFp().getHabilidadePp();
	}

	public void setHabilidade(Habilidade Habilidade) {
		this.habilidade = Habilidade;
	}
}
