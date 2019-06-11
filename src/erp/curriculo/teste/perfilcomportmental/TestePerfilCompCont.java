package erp.curriculo.teste.perfilcomportmental;

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

final class TestePerfilCompCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (testePerfilComp == null || testePerfilComp.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TestePerfilCompFac.deletarRegistro(testePerfilComp);
				getTestePerfilCompFc().limparGui();
				testePerfilComp = new TestePerfilComp();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getTestePerfilCompFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getTestePerfilCompFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getTestePerfilCompFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			testePerfilComp = new TestePerfilComp();
			getTestePerfilCompPc().getGuiFuncionario().requestFocus();
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
			List<TestePerfilComp> testePerfilComps = new LinkedList<>();

			if (testePerfilComp.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (testePerfilComps.add(TestePerfilCompFac.getRegistro(testePerfilComp))) {
				TestePerfilCompRel testePerfilCompRel = new TestePerfilCompRel(testePerfilComps);
				testePerfilCompRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getTestePerfilCompPc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			testePerfilComp = new TestePerfilComp();
			getTestePerfilCompFc().limparGui();
			getTestePerfilCompPc().getGuiFuncionario().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getTestePerfilCompPp().pesquisarRegistro(testePerfilComp);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getTestePerfilCompFp());
				getTestePerfilCompFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getTestePerfilCompPp().pesquisarRegistro(new TestePerfilComp());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getTestePerfilCompFp());
				getTestePerfilCompFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<TestePerfilComp> testePerfilComps = new LinkedList<>();

			try {
				testePerfilComps = new LinkedList<>(TestePerfilCompFac.pesquisarRegistro(new TestePerfilComp()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			TestePerfilCompRel testePerfilCompRel = new TestePerfilCompRel(testePerfilComps);
			testePerfilCompRel.retornarRelatorio(true);

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
				if ((getTestePerfilCompPc().getGuiFuncionario().getSelectedItem()) == null) {
					getTestePerfilCompPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TestePerfilCompFac.salvarRegistro(testePerfilComp);
					testePerfilComp = new TestePerfilComp();
					getTestePerfilCompFc().limparGui();
					getTestePerfilCompPc().getGuiFuncionario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Throwable throwable = e.getCause().getCause();
				String mensagem = throwable.toString();
				if (mensagem.contains("ConstraintViolationException")) {
					if (mensagem.contains("INDEX_TESTE_B_FUNCIONARIO")) {
						Msg.avisoCampoDuplicado("NOME");
						getTestePerfilCompPc().getGuiFuncionario().requestFocus();
					} else {
						Msg.avisoCampoDuplicado();
					}
				}
				e.printStackTrace();
				Msg.erroSalvarRegistro();
			}
		}
	}

	private TestePerfilComp testePerfilComp;

	public void atualizarGui() {
		if (testePerfilComp == null) {
			return;
		}
		getTestePerfilCompPc().getGuiFuncionario().setSelectedItem(testePerfilComp.getFuncionario());
	}

	public void atualizarObjeto() {
		testePerfilComp.setFuncionario((Funcionario) getTestePerfilCompPc().getGuiFuncionario().getSelectedItem());
		calcularResultado();
	}

	public void calcularResultado() {
		// QUESTÃO 1
		if (getTestePerfilCompPc().getGuiQuestao1().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao1().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao1().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao1().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 2
		if (getTestePerfilCompPc().getGuiQuestao2().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao2().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao2().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao2().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 3
		if (getTestePerfilCompPc().getGuiQuestao3().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao3().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao3().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao3().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 4
		if (getTestePerfilCompPc().getGuiQuestao4().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao4().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao4().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao4().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 5
		if (getTestePerfilCompPc().getGuiQuestao5().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao5().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao5().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao5().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 6
		if (getTestePerfilCompPc().getGuiQuestao6().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao6().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao6().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao6().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 7
		if (getTestePerfilCompPc().getGuiQuestao7().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao7().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao7().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao7().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 8
		if (getTestePerfilCompPc().getGuiQuestao8().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao8().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao8().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao8().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 9
		if (getTestePerfilCompPc().getGuiQuestao9().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao9().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao9().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao9().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 10
		if (getTestePerfilCompPc().getGuiQuestao10().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao10().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao10().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao10().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 11
		if (getTestePerfilCompPc().getGuiQuestao11().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao11().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao11().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao11().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 12
		if (getTestePerfilCompPc().getGuiQuestao12().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao12().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao12().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao12().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 13
		if (getTestePerfilCompPc().getGuiQuestao13().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao13().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao13().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao13().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 14
		if (getTestePerfilCompPc().getGuiQuestao14().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao14().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao14().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao14().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 15
		if (getTestePerfilCompPc().getGuiQuestao15().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao15().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao15().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao15().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 16
		if (getTestePerfilCompPc().getGuiQuestao16().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao16().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao16().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao16().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 17
		if (getTestePerfilCompPc().getGuiQuestao17().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao17().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao17().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao17().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 18
		if (getTestePerfilCompPc().getGuiQuestao18().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao18().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao18().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao18().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 19
		if (getTestePerfilCompPc().getGuiQuestao19().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao19().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao19().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao19().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 20
		if (getTestePerfilCompPc().getGuiQuestao20().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao20().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao20().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao20().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 21
		if (getTestePerfilCompPc().getGuiQuestao21().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao21().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao21().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao21().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 22
		if (getTestePerfilCompPc().getGuiQuestao22().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao22().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao22().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao22().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 23
		if (getTestePerfilCompPc().getGuiQuestao23().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao23().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao23().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao23().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 24
		if (getTestePerfilCompPc().getGuiQuestao24().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao24().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao24().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao24().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 25
		if (getTestePerfilCompPc().getGuiQuestao25().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao25().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao25().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao25().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 26
		if (getTestePerfilCompPc().getGuiQuestao26().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao26().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao26().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao26().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 27
		if (getTestePerfilCompPc().getGuiQuestao27().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao27().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao27().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao27().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 28
		if (getTestePerfilCompPc().getGuiQuestao28().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao28().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao28().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao28().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 29
		if (getTestePerfilCompPc().getGuiQuestao29().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao29().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao29().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao29().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 30
		if (getTestePerfilCompPc().getGuiQuestao30().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao30().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao30().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao30().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 31
		if (getTestePerfilCompPc().getGuiQuestao31().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao31().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao31().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao31().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 32
		if (getTestePerfilCompPc().getGuiQuestao32().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao32().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao32().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao32().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 33
		if (getTestePerfilCompPc().getGuiQuestao33().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao33().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao33().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao33().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 34
		if (getTestePerfilCompPc().getGuiQuestao34().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao34().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao34().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao34().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 35
		if (getTestePerfilCompPc().getGuiQuestao35().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao35().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao35().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao35().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 36
		if (getTestePerfilCompPc().getGuiQuestao36().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao36().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao36().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao36().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 37
		if (getTestePerfilCompPc().getGuiQuestao37().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao37().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao37().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao37().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 38
		if (getTestePerfilCompPc().getGuiQuestao38().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao38().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao38().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao38().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 39
		if (getTestePerfilCompPc().getGuiQuestao39().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao39().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao39().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao39().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
		// QUESTÃO 40
		if (getTestePerfilCompPc().getGuiQuestao40().getSelectedIndex() == 0) {
			testePerfilComp.setTotalOpcaoA();
		} else if (getTestePerfilCompPc().getGuiQuestao40().getSelectedIndex() == 1) {
			testePerfilComp.setTotalOpcaoB();
		} else if (getTestePerfilCompPc().getGuiQuestao40().getSelectedIndex() == 2) {
			testePerfilComp.setTotalOpcaoC();
		} else if (getTestePerfilCompPc().getGuiQuestao40().getSelectedIndex() == 3) {
			testePerfilComp.setTotalOpcaoD();
		}
	}

	public TestePerfilComp getTestePerfilComp() {
		return testePerfilComp;
	}

	public TestePerfilCompFc getTestePerfilCompFc() {
		return MainCont.getCurriculoTestePerfilCompFc();
	}

	public TestePerfilCompFp getTestePerfilCompFp() {
		return MainCont.getCurriculoTestePerfilCompFp();
	}

	public TestePerfilCompPc getTestePerfilCompPc() {
		return MainCont.getCurriculoTestePerfilCompFc().getTestePerfilCompPc();
	}

	public TestePerfilCompPp getTestePerfilCompPp() {
		return MainCont.getCurriculoTestePerfilCompFp().getCertificadoPp();
	}

	public void setTestePerfilComp(TestePerfilComp TestePerfilComp) {
		this.testePerfilComp = TestePerfilComp;
	}
}
