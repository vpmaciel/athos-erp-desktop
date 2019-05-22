package erp.curriculo.testepersonalidade.a;

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

final class TesteACont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (testeA == null || testeA.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TesteAFac.deletarRegistro(testeA);
				getTesteAFc().limparGui();
				testeA = new TesteA();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getTesteAFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getTesteAFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getTesteAFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			testeA = new TesteA();
			getTesteAPc().getGuiFuncionario().requestFocus();
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
			List<TesteA> testeAs = new LinkedList<>();

			if (testeA.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (testeAs.add(TesteAFac.getRegistro(testeA))) {
				TesteARel testeARel = new TesteARel(testeAs);
				testeARel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getTesteAPc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			testeA = new TesteA();
			getTesteAFc().limparGui();
			getTesteAPc().getGuiFuncionario().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getTesteAPp().pesquisarRegistroTesteA(testeA);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getTesteAFp());
				getTesteAFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<TesteA> testeAs = new LinkedList<>();

			try {
				testeAs = new LinkedList<>(TesteAFac.pesquisarRegistro(new TesteA()));
			} catch (Exception e) {
				System.out.println(e);
			}

			TesteARel testeARel = new TesteARel(testeAs);
			testeARel.retornarRelatorio(true);

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
				if ((getTesteAPc().getGuiFuncionario().getSelectedItem()) == null) {
					getTesteAPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TesteAFac.salvarRegistro(testeA);
					testeA = new TesteA();
					getTesteAFc().limparGui();
					getTesteAPc().getGuiFuncionario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroSalvarRegistro();
			}
		}
	}

	private TesteA testeA;

	public void atualizarGui() {
		if (testeA == null) {
			return;
		}
		getTesteAPc().getGuiFuncionario().setSelectedItem(testeA.getFuncionario());
	}

	public void atualizarObjeto() {
		testeA.setFuncionario((Funcionario) getTesteAPc().getGuiFuncionario().getSelectedItem());
		calcularResultado();
	}

	public void calcularResultado() {		
		// QUESTÃO 1
		if (getTesteAPc().getGuiQuestao1().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao1().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao1().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao1().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoA();
		}
		// QUESTÃO 2
		if (getTesteAPc().getGuiQuestao2().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao2().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao2().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao2().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoI();
		}
		// QUESTÃO 3
		if (getTesteAPc().getGuiQuestao3().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao3().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao3().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao3().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoC();
		}
		// QUESTÃO 4
		if (getTesteAPc().getGuiQuestao4().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao4().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao4().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao4().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoA();
		}
		// QUESTÃO 5
		if (getTesteAPc().getGuiQuestao5().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao5().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao5().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao5().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoO();
		}
		// QUESTÃO 6
		if (getTesteAPc().getGuiQuestao6().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao6().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao6().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao6().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoO();
		}
		// QUESTÃO 7
		if (getTesteAPc().getGuiQuestao7().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao7().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao7().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao7().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoA();
		}
		// QUESTÃO 8
		if (getTesteAPc().getGuiQuestao8().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao8().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao8().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao8().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoC();
		}
		// QUESTÃO 9
		if (getTesteAPc().getGuiQuestao9().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao9().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao9().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao9().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoI();
		}
		// QUESTÃO 10
		if (getTesteAPc().getGuiQuestao10().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao10().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao10().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao10().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoI();
		}
		// QUESTÃO 11
		if (getTesteAPc().getGuiQuestao11().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao11().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao11().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao11().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoI();
		}
		// QUESTÃO 12
		if (getTesteAPc().getGuiQuestao12().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao12().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao12().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao12().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoA();
		}
		// QUESTÃO 13
		if (getTesteAPc().getGuiQuestao13().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao13().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao13().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao13().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoI();
		}
		// QUESTÃO 14
		if (getTesteAPc().getGuiQuestao14().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao14().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao14().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao14().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoC();
		}
		// QUESTÃO 15
		if (getTesteAPc().getGuiQuestao15().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao15().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao15().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao15().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoO();
		}
		// QUESTÃO 16
		if (getTesteAPc().getGuiQuestao16().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao16().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao16().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao16().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoO();
		}
		// QUESTÃO 17
		if (getTesteAPc().getGuiQuestao17().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao17().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao17().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao17().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoI();
		}
		// QUESTÃO 18
		if (getTesteAPc().getGuiQuestao18().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao18().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao18().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao18().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoA();
		}
		// QUESTÃO 19
		if (getTesteAPc().getGuiQuestao19().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao19().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao19().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao19().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoA();
		}
		// QUESTÃO 20
		if (getTesteAPc().getGuiQuestao20().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao20().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao20().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao20().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoI();
		}
		// QUESTÃO 21
		if (getTesteAPc().getGuiQuestao21().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao21().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao21().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao21().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoA();
		}
		// QUESTÃO 22
		if (getTesteAPc().getGuiQuestao22().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao22().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao22().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao22().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoI();
		}
		// QUESTÃO 23
		if (getTesteAPc().getGuiQuestao23().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao23().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao23().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao23().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoI();
		}
		// QUESTÃO 24
		if (getTesteAPc().getGuiQuestao24().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao24().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao24().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoA();
		} else if (getTesteAPc().getGuiQuestao24().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoC();
		}
		// QUESTÃO 25
		if (getTesteAPc().getGuiQuestao25().getSelectedIndex() == 0) {
			testeA.setTotalOpcaoI();
		} else if (getTesteAPc().getGuiQuestao25().getSelectedIndex() == 1) {
			testeA.setTotalOpcaoO();
		} else if (getTesteAPc().getGuiQuestao25().getSelectedIndex() == 2) {
			testeA.setTotalOpcaoC();
		} else if (getTesteAPc().getGuiQuestao25().getSelectedIndex() == 3) {
			testeA.setTotalOpcaoA();
		}
	}

	public TesteA getTesteA() {
		return testeA;
	}

	public TesteAFc getTesteAFc() {
		return MainCont.getCurriculoTesteAFc();
	}

	public TesteAFp getTesteAFp() {
		return MainCont.getCurriculoTesteAFp();
	}

	public TesteAPc getTesteAPc() {
		return MainCont.getCurriculoTesteAFc().getTesteAPc();
	}

	public TesteAPp getTesteAPp() {
		return MainCont.getCurriculoTesteAFp().getCertificadoPp();
	}

	public void setTesteA(TesteA TesteA) {
		this.testeA = TesteA;
	}
}
