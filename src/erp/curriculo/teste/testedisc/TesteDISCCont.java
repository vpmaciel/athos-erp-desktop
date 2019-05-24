package erp.curriculo.teste.testedisc;

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

final class TesteDISCCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (testeDISC == null || testeDISC.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TesteDISCFac.deletarRegistro(testeDISC);
				getTesteDISCFc().limparGui();
				testeDISC = new TesteDISC();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getTesteDISCFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getTesteDISCFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getTesteDISCFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			testeDISC = new TesteDISC();
			getTesteDISCPc().getGuiFuncionario().requestFocus();
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
			List<TesteDISC> testeDISCs = new LinkedList<>();

			if (testeDISC.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (testeDISCs.add(TesteDISCFac.getRegistro(testeDISC))) {
				TesteDISCRel testeDISCRel = new TesteDISCRel(testeDISCs);
				testeDISCRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getTesteDISCPc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			testeDISC = new TesteDISC();
			getTesteDISCFc().limparGui();
			getTesteDISCPc().getGuiFuncionario().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getTesteDISCPp().pesquisarRegistro(testeDISC);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getTesteDISCFp());
				getTesteDISCFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getTesteDISCPp().pesquisarRegistro(new TesteDISC());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getTesteDISCFp());
				getTesteDISCFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<TesteDISC> testeDISCs = new LinkedList<>();

			try {
				testeDISCs = new LinkedList<>(TesteDISCFac.pesquisarRegistro(new TesteDISC()));
			} catch (Exception e) {
				System.out.println(e);
			}

			TesteDISCRel testeDISCRel = new TesteDISCRel(testeDISCs);
			testeDISCRel.retornarRelatorio(true);

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
				if ((getTesteDISCPc().getGuiFuncionario().getSelectedItem()) == null) {
					getTesteDISCPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TesteDISCFac.salvarRegistro(testeDISC);
					testeDISC = new TesteDISC();
					getTesteDISCFc().limparGui();
					getTesteDISCPc().getGuiFuncionario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Throwable throwable = e.getCause().getCause();
				String mensagem = throwable.toString();
				if (mensagem.contains("ConstraintViolationException")) {
					if (mensagem.contains("INDEX_TESTE_C_FUNCIONARIO")) {
						Msg.avisoCampoDuplicado("NOME");
						getTesteDISCPc().getGuiFuncionario().requestFocus();
					} else {
						Msg.avisoCampoDuplicado();
					}
				}
				e.printStackTrace();
				Msg.erroSalvarRegistro();
			}
		}
	}

	private TesteDISC testeDISC;

	public void atualizarGui() {
		if (testeDISC == null) {
			return;
		}
		getTesteDISCPc().getGuiFuncionario().setSelectedItem(testeDISC.getFuncionario());
	}

	public void atualizarObjeto() {
		testeDISC.setFuncionario((Funcionario) getTesteDISCPc().getGuiFuncionario().getSelectedItem());
		calcularResultado();
	}

	public void calcularResultado() {
		// PERFIL D
		if (getTesteDISCPc().getGuiQuestaoD1().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD2().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD3().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD4().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD5().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD6().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD7().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD8().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD9().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD10().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD11().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD12().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD13().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD14().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD15().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD16().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD17().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD18().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD19().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD20().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD21().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD22().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD23().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD24().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD25().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD26().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD27().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		if (getTesteDISCPc().getGuiQuestaoD28().isSelected()) {
			testeDISC.setTotalOpcaoD();
		}
		// PERFIL I
		if (getTesteDISCPc().getGuiQuestaoI1().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI2().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI3().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI4().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI5().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI6().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI7().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI8().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI9().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI10().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI11().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI12().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI13().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI14().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI15().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI16().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI17().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI18().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI19().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI20().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI21().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI22().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI23().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI24().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI25().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI26().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI27().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		if (getTesteDISCPc().getGuiQuestaoI28().isSelected()) {
			testeDISC.setTotalOpcaoI();
		}
		// PERFIL S
		if (getTesteDISCPc().getGuiQuestaoS1().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS2().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS3().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS4().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS5().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS6().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS7().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS8().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS9().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS10().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS11().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS12().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS13().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS14().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS15().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS16().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS17().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS18().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS19().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS20().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS21().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS22().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS23().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS24().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS25().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS26().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS27().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		if (getTesteDISCPc().getGuiQuestaoS28().isSelected()) {
			testeDISC.setTotalOpcaoS();
		}
		// PERFIL C
		if (getTesteDISCPc().getGuiQuestaoC1().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC2().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC3().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC4().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC5().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC6().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC7().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC8().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC9().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC10().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC11().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC12().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC13().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC14().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC15().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC16().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC17().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC18().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC19().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC20().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC21().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC22().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC23().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC24().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC25().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC26().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC27().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
		if (getTesteDISCPc().getGuiQuestaoC28().isSelected()) {
			testeDISC.setTotalOpcaoC();
		}
	}

	public TesteDISC getTesteDISC() {
		return testeDISC;
	}

	public TesteDISCFc getTesteDISCFc() {
		return MainCont.getCurriculoTesteDISCFc();
	}

	public TesteDISCFp getTesteDISCFp() {
		return MainCont.getCurriculoTesteDISCFp();
	}

	public TesteDISCPc getTesteDISCPc() {
		return MainCont.getCurriculoTesteDISCFc().getTesteDISCPc();
	}

	public TesteDISCPp getTesteDISCPp() {
		return MainCont.getCurriculoTesteDISCFp().getCertificadoPp();
	}

	public void setTesteDISC(TesteDISC TesteDISC) {
		this.testeDISC = TesteDISC;
	}
}
