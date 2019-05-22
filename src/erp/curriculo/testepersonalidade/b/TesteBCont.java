package erp.curriculo.testepersonalidade.b;

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

final class TesteBCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (testeB == null || testeB.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TesteBFac.deletarRegistro(testeB);
				getTesteBFc().limparGui();
				testeB = new TesteB();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getTesteBFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getTesteBFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getTesteBFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			testeB = new TesteB();
			getTesteBPc().getGuiFuncionario().requestFocus();
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
			List<TesteB> testeBs = new LinkedList<>();

			if (testeB.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (testeBs.add(TesteBFac.getRegistro(testeB))) {
				TesteBRel testeBRel = new TesteBRel(testeBs);
				testeBRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getTesteBPc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			testeB = new TesteB();
			getTesteBFc().limparGui();
			getTesteBPc().getGuiFuncionario().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getTesteBPp().pesquisarRegistroTesteB(testeB);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getTesteBFp());
				getTesteBFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<TesteB> testeBs = new LinkedList<>();

			try {
				testeBs = new LinkedList<>(TesteBFac.pesquisarRegistro(new TesteB()));
			} catch (Exception e) {
				System.out.println(e);
			}

			TesteBRel testeBRel = new TesteBRel(testeBs);
			testeBRel.retornarRelatorio(true);

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
				if ((getTesteBPc().getGuiFuncionario().getSelectedItem()) == null) {
					getTesteBPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TesteBFac.salvarRegistro(testeB);
					testeB = new TesteB();
					getTesteBFc().limparGui();
					getTesteBPc().getGuiFuncionario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroSalvarRegistro();
			}
		}
	}

	private TesteB testeB;

	public void atualizarGui() {
		if (testeB == null) {
			return;
		}
		getTesteBPc().getGuiFuncionario().setSelectedItem(testeB.getFuncionario());
	}

	public void atualizarObjeto() {
		testeB.setFuncionario((Funcionario) getTesteBPc().getGuiFuncionario().getSelectedItem());
		calcularResultado();
	}

	public void calcularResultado() {
		// QUESTÃO 1
		if (getTesteBPc().getGuiQuestao1().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao1().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao1().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao1().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 2
		if (getTesteBPc().getGuiQuestao2().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao2().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao2().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao2().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 3
		if (getTesteBPc().getGuiQuestao3().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao3().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao3().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao3().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 4
		if (getTesteBPc().getGuiQuestao4().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao4().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao4().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao4().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 5
		if (getTesteBPc().getGuiQuestao5().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao5().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao5().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao5().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 6
		if (getTesteBPc().getGuiQuestao6().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao6().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao6().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao6().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 7
		if (getTesteBPc().getGuiQuestao7().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao7().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao7().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao7().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 8
		if (getTesteBPc().getGuiQuestao8().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao8().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao8().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao8().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 9
		if (getTesteBPc().getGuiQuestao9().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao9().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao9().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao9().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 10
		if (getTesteBPc().getGuiQuestao10().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao10().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao10().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao10().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 11
		if (getTesteBPc().getGuiQuestao11().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao11().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao11().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao11().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 12
		if (getTesteBPc().getGuiQuestao12().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao12().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao12().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao12().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 13
		if (getTesteBPc().getGuiQuestao13().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao13().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao13().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao13().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 14
		if (getTesteBPc().getGuiQuestao14().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao14().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao14().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao14().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 15
		if (getTesteBPc().getGuiQuestao15().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao15().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao15().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao15().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 16
		if (getTesteBPc().getGuiQuestao16().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao16().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao16().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao16().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 17
		if (getTesteBPc().getGuiQuestao17().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao17().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao17().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao17().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 18
		if (getTesteBPc().getGuiQuestao18().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao18().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao18().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao18().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 19
		if (getTesteBPc().getGuiQuestao19().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao19().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao19().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao19().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 20
		if (getTesteBPc().getGuiQuestao20().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao20().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao20().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao20().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 21
		if (getTesteBPc().getGuiQuestao21().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao21().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao21().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao21().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 22
		if (getTesteBPc().getGuiQuestao22().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao22().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao22().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao22().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 23
		if (getTesteBPc().getGuiQuestao23().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao23().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao23().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao23().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 24
		if (getTesteBPc().getGuiQuestao24().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao24().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao24().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao24().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 25
		if (getTesteBPc().getGuiQuestao25().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao25().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao25().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao25().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 26
		if (getTesteBPc().getGuiQuestao26().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao26().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao26().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao26().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 27
		if (getTesteBPc().getGuiQuestao27().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao27().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao27().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao27().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 28
		if (getTesteBPc().getGuiQuestao28().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao28().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao28().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao28().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 29
		if (getTesteBPc().getGuiQuestao29().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao29().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao29().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao29().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 30
		if (getTesteBPc().getGuiQuestao30().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao30().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao30().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao30().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 31
		if (getTesteBPc().getGuiQuestao31().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao31().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao31().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao31().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 32
		if (getTesteBPc().getGuiQuestao32().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao32().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao32().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao32().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 33
		if (getTesteBPc().getGuiQuestao33().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao33().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao33().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao33().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 34
		if (getTesteBPc().getGuiQuestao34().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao34().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao34().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao34().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 35
		if (getTesteBPc().getGuiQuestao35().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao35().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao35().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao35().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 36
		if (getTesteBPc().getGuiQuestao36().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao36().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao36().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao36().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 37
		if (getTesteBPc().getGuiQuestao37().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao37().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao37().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao37().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 38
		if (getTesteBPc().getGuiQuestao38().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao38().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao38().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao38().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 39
		if (getTesteBPc().getGuiQuestao39().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao39().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao39().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao39().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
		// QUESTÃO 40
		if (getTesteBPc().getGuiQuestao40().getSelectedIndex() == 0) {
			testeB.setTotalOpcaoA();
		} else if (getTesteBPc().getGuiQuestao40().getSelectedIndex() == 1) {
			testeB.setTotalOpcaoB();
		} else if (getTesteBPc().getGuiQuestao40().getSelectedIndex() == 2) {
			testeB.setTotalOpcaoC();
		} else if (getTesteBPc().getGuiQuestao40().getSelectedIndex() == 3) {
			testeB.setTotalOpcaoD();
		}
	}

	public TesteB getTesteB() {
		return testeB;
	}

	public TesteBFc getTesteBFc() {
		return MainCont.getCurriculoTesteBFc();
	}

	public TesteBFp getTesteBFp() {
		return MainCont.getCurriculoTesteBFp();
	}

	public TesteBPc getTesteBPc() {
		return MainCont.getCurriculoTesteBFc().getTesteBPc();
	}

	public TesteBPp getTesteBPp() {
		return MainCont.getCurriculoTesteBFp().getCertificadoPp();
	}

	public void setTesteB(TesteB TesteB) {
		this.testeB = TesteB;
	}
}
