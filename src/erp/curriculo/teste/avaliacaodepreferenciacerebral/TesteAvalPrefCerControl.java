package erp.curriculo.teste.avaliacaodepreferenciacerebral;

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

final class TesteAvalPrefCerControl {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (testeAvalPrefCer == null || testeAvalPrefCer.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TesteAvalPrefCerFac.deletarRegistro(testeAvalPrefCer);
				getTesteAvalPrefCerFc().limparGui();
				testeAvalPrefCer = new TesteAvalPrefCer();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getTesteAvalPrefCerFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getTesteAvalPrefCerFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getTesteAvalPrefCerFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			testeAvalPrefCer = new TesteAvalPrefCer();
			getTesteAvalPrefCerPc().getGuiFuncionario().requestFocus();
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
			List<TesteAvalPrefCer> testeAvalPrefCers = new LinkedList<>();

			if (testeAvalPrefCer.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (testeAvalPrefCers.add(TesteAvalPrefCerFac.getRegistro(testeAvalPrefCer))) {
				TesteAvalPrefCerRel testeAvalPrefCerRel = new TesteAvalPrefCerRel(testeAvalPrefCers);
				testeAvalPrefCerRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getTesteAvalPrefCerPc().getLabelFuncionario()) {
				MainControl.mostrarFrame(MainControl.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			testeAvalPrefCer = new TesteAvalPrefCer();
			getTesteAvalPrefCerFc().limparGui();
			getTesteAvalPrefCerPc().getGuiFuncionario().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getTesteAvalPrefCerPp().pesquisarRegistro(testeAvalPrefCer);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getTesteAvalPrefCerFp());
				getTesteAvalPrefCerFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getTesteAvalPrefCerPp().pesquisarRegistro(new TesteAvalPrefCer());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getTesteAvalPrefCerFp());
				getTesteAvalPrefCerFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<TesteAvalPrefCer> testeAvalPrefCers = new LinkedList<>();

			try {
				testeAvalPrefCers = new LinkedList<>(TesteAvalPrefCerFac.pesquisarRegistro(new TesteAvalPrefCer()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			TesteAvalPrefCerRel testeAvalPrefCerRel = new TesteAvalPrefCerRel(testeAvalPrefCers);
			testeAvalPrefCerRel.retornarRelatorio(true);

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
				if ((getTesteAvalPrefCerPc().getGuiFuncionario().getSelectedItem()) == null) {
					getTesteAvalPrefCerPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TesteAvalPrefCerFac.salvarRegistro(testeAvalPrefCer);
					testeAvalPrefCer = new TesteAvalPrefCer();
					getTesteAvalPrefCerFc().limparGui();
					getTesteAvalPrefCerPc().getGuiFuncionario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Throwable throwable = e.getCause().getCause();
				String mensagem = throwable.toString();
				if (mensagem.contains("ConstraintViolationException")) {
					if (mensagem.contains("INDEX_TESTE_A_FUNCIONARIO")) {
						Msg.avisoCampoDuplicado("NOME");
						getTesteAvalPrefCerPc().getGuiFuncionario().requestFocus();
					} else {
						Msg.avisoCampoDuplicado();
					}
				}
				e.printStackTrace();
				Msg.erroSalvarRegistro();
			}
		}
	}

	private TesteAvalPrefCer testeAvalPrefCer;

	public void atualizarGui() {
		if (testeAvalPrefCer == null) {
			return;
		}
		getTesteAvalPrefCerPc().getGuiFuncionario().setSelectedItem(testeAvalPrefCer.getFuncionario());
	}

	public void atualizarObjeto() {
		testeAvalPrefCer.setFuncionario((Funcionario) getTesteAvalPrefCerPc().getGuiFuncionario().getSelectedItem());
		calcularResultado();
	}

	public void calcularResultado() {
		// QUESTÃO 1
		if (getTesteAvalPrefCerPc().getGuiQuestao1().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao1().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao1().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao1().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoA();
		}
		// QUESTÃO 2
		if (getTesteAvalPrefCerPc().getGuiQuestao2().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao2().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao2().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao2().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoI();
		}
		// QUESTÃO 3
		if (getTesteAvalPrefCerPc().getGuiQuestao3().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao3().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao3().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao3().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoC();
		}
		// QUESTÃO 4
		if (getTesteAvalPrefCerPc().getGuiQuestao4().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao4().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao4().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao4().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoA();
		}
		// QUESTÃO 5
		if (getTesteAvalPrefCerPc().getGuiQuestao5().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao5().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao5().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao5().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoO();
		}
		// QUESTÃO 6
		if (getTesteAvalPrefCerPc().getGuiQuestao6().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao6().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao6().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao6().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoO();
		}
		// QUESTÃO 7
		if (getTesteAvalPrefCerPc().getGuiQuestao7().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao7().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao7().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao7().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoA();
		}
		// QUESTÃO 8
		if (getTesteAvalPrefCerPc().getGuiQuestao8().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao8().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao8().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao8().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoC();
		}
		// QUESTÃO 9
		if (getTesteAvalPrefCerPc().getGuiQuestao9().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao9().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao9().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao9().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoI();
		}
		// QUESTÃO 10
		if (getTesteAvalPrefCerPc().getGuiQuestao10().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao10().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao10().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao10().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoI();
		}
		// QUESTÃO 11
		if (getTesteAvalPrefCerPc().getGuiQuestao11().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao11().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao11().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao11().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoI();
		}
		// QUESTÃO 12
		if (getTesteAvalPrefCerPc().getGuiQuestao12().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao12().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao12().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao12().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoA();
		}
		// QUESTÃO 13
		if (getTesteAvalPrefCerPc().getGuiQuestao13().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao13().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao13().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao13().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoI();
		}
		// QUESTÃO 14
		if (getTesteAvalPrefCerPc().getGuiQuestao14().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao14().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao14().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao14().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoC();
		}
		// QUESTÃO 15
		if (getTesteAvalPrefCerPc().getGuiQuestao15().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao15().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao15().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao15().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoO();
		}
		// QUESTÃO 16
		if (getTesteAvalPrefCerPc().getGuiQuestao16().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao16().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao16().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao16().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoO();
		}
		// QUESTÃO 17
		if (getTesteAvalPrefCerPc().getGuiQuestao17().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao17().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao17().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao17().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoI();
		}
		// QUESTÃO 18
		if (getTesteAvalPrefCerPc().getGuiQuestao18().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao18().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao18().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao18().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoA();
		}
		// QUESTÃO 19
		if (getTesteAvalPrefCerPc().getGuiQuestao19().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao19().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao19().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao19().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoA();
		}
		// QUESTÃO 20
		if (getTesteAvalPrefCerPc().getGuiQuestao20().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao20().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao20().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao20().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoI();
		}
		// QUESTÃO 21
		if (getTesteAvalPrefCerPc().getGuiQuestao21().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao21().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao21().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao21().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoA();
		}
		// QUESTÃO 22
		if (getTesteAvalPrefCerPc().getGuiQuestao22().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao22().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao22().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao22().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoI();
		}
		// QUESTÃO 23
		if (getTesteAvalPrefCerPc().getGuiQuestao23().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao23().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao23().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao23().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoI();
		}
		// QUESTÃO 24
		if (getTesteAvalPrefCerPc().getGuiQuestao24().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao24().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao24().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoA();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao24().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoC();
		}
		// QUESTÃO 25
		if (getTesteAvalPrefCerPc().getGuiQuestao25().getSelectedIndex() == 0) {
			testeAvalPrefCer.setTotalOpcaoI();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao25().getSelectedIndex() == 1) {
			testeAvalPrefCer.setTotalOpcaoO();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao25().getSelectedIndex() == 2) {
			testeAvalPrefCer.setTotalOpcaoC();
		} else if (getTesteAvalPrefCerPc().getGuiQuestao25().getSelectedIndex() == 3) {
			testeAvalPrefCer.setTotalOpcaoA();
		}
	}

	public TesteAvalPrefCer getTesteAvalPrefCer() {
		return testeAvalPrefCer;
	}

	public TesteAvalPrefCerFc getTesteAvalPrefCerFc() {
		return MainControl.getCurriculoTesteAvalPrefCerFc();
	}

	public TesteAvalPrefCerFp getTesteAvalPrefCerFp() {
		return MainControl.getCurriculoTesteAvalPrefCerFp();
	}

	public TesteAvalPrefCerPc getTesteAvalPrefCerPc() {
		return MainControl.getCurriculoTesteAvalPrefCerFc().getTesteAvalPrefCerPc();
	}

	public TesteAvalPrefCerPp getTesteAvalPrefCerPp() {
		return MainControl.getCurriculoTesteAvalPrefCerFp().getCertificadoPp();
	}

	public void setTesteAvalPrefCer(TesteAvalPrefCer TesteAvalPrefCer) {
		this.testeAvalPrefCer = TesteAvalPrefCer;
	}
}
