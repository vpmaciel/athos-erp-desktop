package erp.curriculo.testepersonalidade.c;

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

final class TesteCCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (testeC == null || testeC.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TesteCFac.deletarRegistro(testeC);
				getTesteCFc().limparGui();
				testeC = new TesteC();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getTesteCFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getTesteCFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getTesteCFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			testeC = new TesteC();
			getTesteCPc().getGuiFuncionario().requestFocus();
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
			List<TesteC> testeCs = new LinkedList<>();

			if (testeC.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (testeCs.add(TesteCFac.getRegistro(testeC))) {
				TesteCRel testeCRel = new TesteCRel(testeCs);
				testeCRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getTesteCPc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			testeC = new TesteC();
			getTesteCFc().limparGui();
			getTesteCPc().getGuiFuncionario().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getTesteCPp().pesquisarRegistroTesteC(testeC);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getTesteCFp());
				getTesteCFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<TesteC> testeCs = new LinkedList<>();

			try {
				testeCs = new LinkedList<>(TesteCFac.pesquisarRegistro(new TesteC()));
			} catch (Exception e) {
				System.out.println(e);
			}

			TesteCRel testeCRel = new TesteCRel(testeCs);
			testeCRel.retornarRelatorio(true);

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
				if ((getTesteCPc().getGuiFuncionario().getSelectedItem()) == null) {
					getTesteCPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TesteCFac.salvarRegistro(testeC);
					testeC = new TesteC();
					getTesteCFc().limparGui();
					getTesteCPc().getGuiFuncionario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroSalvarRegistro();
			}
		}
	}

	private TesteC testeC;

	public void atualizarGui() {
		if (testeC == null) {
			return;
		}
		getTesteCPc().getGuiFuncionario().setSelectedItem(testeC.getFuncionario());
	}

	public void atualizarObjeto() {
		testeC.setFuncionario((Funcionario) getTesteCPc().getGuiFuncionario().getSelectedItem());
		calcularResultado();
	}

	public void calcularResultado() {
		// PERFIL D
		if (getTesteCPc().getGuiQuestaoD1().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD2().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD3().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD4().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD5().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD6().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD7().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD8().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD9().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD10().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD11().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD12().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD13().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD14().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD15().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD16().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD17().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD18().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD19().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD20().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD21().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD22().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD23().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD24().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD25().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD26().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD27().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		if (getTesteCPc().getGuiQuestaoD28().isSelected()) {
			testeC.setTotalOpcaoD();
		}
		// PERFIL I
		if (getTesteCPc().getGuiQuestaoI1().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI2().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI3().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI4().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI5().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI6().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI7().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI8().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI9().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI10().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI11().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI12().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI13().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI14().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI15().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI16().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI17().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI18().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI19().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI20().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI21().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI22().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI23().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI24().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI25().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI26().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI27().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		if (getTesteCPc().getGuiQuestaoI28().isSelected()) {
			testeC.setTotalOpcaoI();
		}
		// PERFIL S
		if (getTesteCPc().getGuiQuestaoS1().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS2().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS3().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS4().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS5().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS6().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS7().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS8().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS9().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS10().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS11().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS12().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS13().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS14().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS15().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS16().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS17().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS18().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS19().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS20().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS21().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS22().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS23().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS24().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS25().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS26().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS27().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		if (getTesteCPc().getGuiQuestaoS28().isSelected()) {
			testeC.setTotalOpcaoS();
		}
		// PERFIL C
		if (getTesteCPc().getGuiQuestaoC1().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC2().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC3().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC4().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC5().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC6().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC7().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC8().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC9().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC10().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC11().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC12().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC13().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC14().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC15().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC16().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC17().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC18().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC19().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC20().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC21().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC22().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC23().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC24().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC25().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC26().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC27().isSelected()) {
			testeC.setTotalOpcaoC();
		}
		if (getTesteCPc().getGuiQuestaoC28().isSelected()) {
			testeC.setTotalOpcaoC();
		}
	}

	public TesteC getTesteC() {
		return testeC;
	}

	public TesteCFc getTesteCFc() {
		return MainCont.getCurriculoTesteCFc();
	}

	public TesteCFp getTesteCFp() {
		return MainCont.getCurriculoTesteCFp();
	}

	public TesteCPc getTesteCPc() {
		return MainCont.getCurriculoTesteCFc().getTesteCPc();
	}

	public TesteCPp getTesteCPp() {
		return MainCont.getCurriculoTesteCFp().getCertificadoPp();
	}

	public void setTesteC(TesteC TesteC) {
		this.testeC = TesteC;
	}
}
