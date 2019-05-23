package erp.curriculo.testepersonalidade.c;

import java.awt.Cursor;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import erp.funcionario.Funcionario;
import erp.funcionario.FuncionarioComp;
import erp.funcionario.FuncionarioFac;
import erp.main.MainCont;

@SuppressWarnings("serial")
public final class TesteCPc extends JPanel implements Gui {

	private JComboBox<Funcionario> boxFuncionario;
	private JCheckBox boxQuestaoC1;
	private JCheckBox boxQuestaoC10;
	private JCheckBox boxQuestaoC11;
	private JCheckBox boxQuestaoC12;
	private JCheckBox boxQuestaoC13;
	private JCheckBox boxQuestaoC14;
	private JCheckBox boxQuestaoC15;
	private JCheckBox boxQuestaoC16;
	private JCheckBox boxQuestaoC17;
	private JCheckBox boxQuestaoC18;
	private JCheckBox boxQuestaoC19;
	private JCheckBox boxQuestaoC2;
	private JCheckBox boxQuestaoC20;
	private JCheckBox boxQuestaoC21;
	private JCheckBox boxQuestaoC22;
	private JCheckBox boxQuestaoC23;
	private JCheckBox boxQuestaoC24;
	private JCheckBox boxQuestaoC25;
	private JCheckBox boxQuestaoC26;
	private JCheckBox boxQuestaoC27;
	private JCheckBox boxQuestaoC28;
	private JCheckBox boxQuestaoC3;
	private JCheckBox boxQuestaoC4;
	private JCheckBox boxQuestaoC5;
	private JCheckBox boxQuestaoC6;
	private JCheckBox boxQuestaoC7;
	private JCheckBox boxQuestaoC8;
	private JCheckBox boxQuestaoC9;
	private JCheckBox boxQuestaoD1;
	private JCheckBox boxQuestaoD10;
	private JCheckBox boxQuestaoD11;
	private JCheckBox boxQuestaoD12;
	private JCheckBox boxQuestaoD13;
	private JCheckBox boxQuestaoD14;
	private JCheckBox boxQuestaoD15;
	private JCheckBox boxQuestaoD16;
	private JCheckBox boxQuestaoD17;
	private JCheckBox boxQuestaoD18;
	private JCheckBox boxQuestaoD19;
	private JCheckBox boxQuestaoD2;
	private JCheckBox boxQuestaoD20;
	private JCheckBox boxQuestaoD21;
	private JCheckBox boxQuestaoD22;
	private JCheckBox boxQuestaoD23;
	private JCheckBox boxQuestaoD24;
	private JCheckBox boxQuestaoD25;
	private JCheckBox boxQuestaoD26;
	private JCheckBox boxQuestaoD27;
	private JCheckBox boxQuestaoD28;
	private JCheckBox boxQuestaoD3;
	private JCheckBox boxQuestaoD4;
	private JCheckBox boxQuestaoD5;
	private JCheckBox boxQuestaoD6;
	private JCheckBox boxQuestaoD7;
	private JCheckBox boxQuestaoD8;
	private JCheckBox boxQuestaoD9;
	private JCheckBox boxQuestaoI1;
	private JCheckBox boxQuestaoI10;
	private JCheckBox boxQuestaoI11;
	private JCheckBox boxQuestaoI12;
	private JCheckBox boxQuestaoI13;
	private JCheckBox boxQuestaoI14;
	private JCheckBox boxQuestaoI15;
	private JCheckBox boxQuestaoI16;
	private JCheckBox boxQuestaoI17;
	private JCheckBox boxQuestaoI18;
	private JCheckBox boxQuestaoI19;
	private JCheckBox boxQuestaoI2;
	private JCheckBox boxQuestaoI20;
	private JCheckBox boxQuestaoI21;
	private JCheckBox boxQuestaoI22;
	private JCheckBox boxQuestaoI23;
	private JCheckBox boxQuestaoI24;
	private JCheckBox boxQuestaoI25;
	private JCheckBox boxQuestaoI26;
	private JCheckBox boxQuestaoI27;
	private JCheckBox boxQuestaoI28;
	private JCheckBox boxQuestaoI3;
	private JCheckBox boxQuestaoI4;
	private JCheckBox boxQuestaoI5;
	private JCheckBox boxQuestaoI6;
	private JCheckBox boxQuestaoI7;
	private JCheckBox boxQuestaoI8;
	private JCheckBox boxQuestaoI9;
	private JCheckBox boxQuestaoS1;
	private JCheckBox boxQuestaoS10;
	private JCheckBox boxQuestaoS11;
	private JCheckBox boxQuestaoS12;
	private JCheckBox boxQuestaoS13;
	private JCheckBox boxQuestaoS14;
	private JCheckBox boxQuestaoS15;
	private JCheckBox boxQuestaoS16;
	private JCheckBox boxQuestaoS17;
	private JCheckBox boxQuestaoS18;
	private JCheckBox boxQuestaoS19;
	private JCheckBox boxQuestaoS2;
	private JCheckBox boxQuestaoS20;
	private JCheckBox boxQuestaoS21;
	private JCheckBox boxQuestaoS22;
	private JCheckBox boxQuestaoS23;
	private JCheckBox boxQuestaoS24;
	private JCheckBox boxQuestaoS25;
	private JCheckBox boxQuestaoS26;
	private JCheckBox boxQuestaoS27;
	private JCheckBox boxQuestaoS28;
	private JCheckBox boxQuestaoS3;
	private JCheckBox boxQuestaoS4;
	private JCheckBox boxQuestaoS5;
	private JCheckBox boxQuestaoS6;
	private JCheckBox boxQuestaoS7;
	private JCheckBox boxQuestaoS8;
	private JCheckBox boxQuestaoS9;

	private ConfiguracaoGui configuracaoGui;
	private JLabel labelFuncionario;
	private ToolBar toolBar;

	public TesteCPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JComboBox<Funcionario> getGuiFuncionario() {
		return boxFuncionario;
	}

	public JCheckBox getGuiQuestaoC1() {
		return boxQuestaoC1;
	}

	public JCheckBox getGuiQuestaoC10() {
		return boxQuestaoC10;
	}

	public JCheckBox getGuiQuestaoC11() {
		return boxQuestaoC11;
	}

	public JCheckBox getGuiQuestaoC12() {
		return boxQuestaoC12;
	}

	public JCheckBox getGuiQuestaoC13() {
		return boxQuestaoC13;
	}

	public JCheckBox getGuiQuestaoC14() {
		return boxQuestaoC14;
	}

	public JCheckBox getGuiQuestaoC15() {
		return boxQuestaoC15;
	}

	public JCheckBox getGuiQuestaoC16() {
		return boxQuestaoC16;
	}

	public JCheckBox getGuiQuestaoC17() {
		return boxQuestaoC17;
	}

	public JCheckBox getGuiQuestaoC18() {
		return boxQuestaoC18;
	}

	public JCheckBox getGuiQuestaoC19() {
		return boxQuestaoC19;
	}

	public JCheckBox getGuiQuestaoC2() {
		return boxQuestaoC2;
	}

	public JCheckBox getGuiQuestaoC20() {
		return boxQuestaoC20;
	}

	public JCheckBox getGuiQuestaoC21() {
		return boxQuestaoC21;
	}

	public JCheckBox getGuiQuestaoC22() {
		return boxQuestaoC22;
	}

	public JCheckBox getGuiQuestaoC23() {
		return boxQuestaoC23;
	}

	public JCheckBox getGuiQuestaoC24() {
		return boxQuestaoC24;
	}

	public JCheckBox getGuiQuestaoC25() {
		return boxQuestaoC25;
	}

	public JCheckBox getGuiQuestaoC26() {
		return boxQuestaoC26;
	}

	public JCheckBox getGuiQuestaoC27() {
		return boxQuestaoC27;
	}

	public JCheckBox getGuiQuestaoC28() {
		return boxQuestaoC28;
	}

	public JCheckBox getGuiQuestaoC3() {
		return boxQuestaoC3;
	}

	public JCheckBox getGuiQuestaoC4() {
		return boxQuestaoC4;
	}

	public JCheckBox getGuiQuestaoC5() {
		return boxQuestaoC5;
	}

	public JCheckBox getGuiQuestaoC6() {
		return boxQuestaoC6;
	}

	public JCheckBox getGuiQuestaoC7() {
		return boxQuestaoC7;
	}

	public JCheckBox getGuiQuestaoC8() {
		return boxQuestaoC8;
	}

	public JCheckBox getGuiQuestaoC9() {
		return boxQuestaoC9;
	}

	public JCheckBox getGuiQuestaoD1() {
		return boxQuestaoD1;
	}

	public JCheckBox getGuiQuestaoD10() {
		return boxQuestaoD10;
	}

	public JCheckBox getGuiQuestaoD11() {
		return boxQuestaoD11;
	}

	public JCheckBox getGuiQuestaoD12() {
		return boxQuestaoD12;
	}

	public JCheckBox getGuiQuestaoD13() {
		return boxQuestaoD13;
	}

	public JCheckBox getGuiQuestaoD14() {
		return boxQuestaoD14;
	}

	public JCheckBox getGuiQuestaoD15() {
		return boxQuestaoD15;
	}

	public JCheckBox getGuiQuestaoD16() {
		return boxQuestaoD16;
	}

	public JCheckBox getGuiQuestaoD17() {
		return boxQuestaoD17;
	}

	public JCheckBox getGuiQuestaoD18() {
		return boxQuestaoD18;
	}

	public JCheckBox getGuiQuestaoD19() {
		return boxQuestaoD19;
	}

	public JCheckBox getGuiQuestaoD2() {
		return boxQuestaoD2;
	}

	public JCheckBox getGuiQuestaoD20() {
		return boxQuestaoD20;
	}

	public JCheckBox getGuiQuestaoD21() {
		return boxQuestaoD21;
	}

	public JCheckBox getGuiQuestaoD22() {
		return boxQuestaoD22;
	}

	public JCheckBox getGuiQuestaoD23() {
		return boxQuestaoD23;
	}

	public JCheckBox getGuiQuestaoD24() {
		return boxQuestaoD24;
	}

	public JCheckBox getGuiQuestaoD25() {
		return boxQuestaoD25;
	}

	public JCheckBox getGuiQuestaoD26() {
		return boxQuestaoD26;
	}

	public JCheckBox getGuiQuestaoD27() {
		return boxQuestaoD27;
	}

	public JCheckBox getGuiQuestaoD28() {
		return boxQuestaoD28;
	}

	public JCheckBox getGuiQuestaoD3() {
		return boxQuestaoD3;
	}

	public JCheckBox getGuiQuestaoD4() {
		return boxQuestaoD4;
	}

	public JCheckBox getGuiQuestaoD5() {
		return boxQuestaoD5;
	}

	public JCheckBox getGuiQuestaoD6() {
		return boxQuestaoD6;
	}

	public JCheckBox getGuiQuestaoD7() {
		return boxQuestaoD7;
	}

	public JCheckBox getGuiQuestaoD8() {
		return boxQuestaoD8;
	}

	public JCheckBox getGuiQuestaoD9() {
		return boxQuestaoD9;
	}

	public JCheckBox getGuiQuestaoI1() {
		return boxQuestaoI1;
	}

	public JCheckBox getGuiQuestaoI10() {
		return boxQuestaoI10;
	}

	public JCheckBox getGuiQuestaoI11() {
		return boxQuestaoI11;
	}

	public JCheckBox getGuiQuestaoI12() {
		return boxQuestaoI12;
	}

	public JCheckBox getGuiQuestaoI13() {
		return boxQuestaoI13;
	}

	public JCheckBox getGuiQuestaoI14() {
		return boxQuestaoI14;
	}

	public JCheckBox getGuiQuestaoI15() {
		return boxQuestaoI15;
	}

	public JCheckBox getGuiQuestaoI16() {
		return boxQuestaoI16;
	}

	public JCheckBox getGuiQuestaoI17() {
		return boxQuestaoI17;
	}

	public JCheckBox getGuiQuestaoI18() {
		return boxQuestaoI18;
	}

	public JCheckBox getGuiQuestaoI19() {
		return boxQuestaoI19;
	}

	public JCheckBox getGuiQuestaoI2() {
		return boxQuestaoI2;
	}

	public JCheckBox getGuiQuestaoI20() {
		return boxQuestaoI20;
	}

	public JCheckBox getGuiQuestaoI21() {
		return boxQuestaoI21;
	}

	public JCheckBox getGuiQuestaoI22() {
		return boxQuestaoI22;
	}

	public JCheckBox getGuiQuestaoI23() {
		return boxQuestaoI23;
	}

	public JCheckBox getGuiQuestaoI24() {
		return boxQuestaoI24;
	}

	public JCheckBox getGuiQuestaoI25() {
		return boxQuestaoI25;
	}

	public JCheckBox getGuiQuestaoI26() {
		return boxQuestaoI26;
	}

	public JCheckBox getGuiQuestaoI27() {
		return boxQuestaoI27;
	}

	public JCheckBox getGuiQuestaoI28() {
		return boxQuestaoI28;
	}

	public JCheckBox getGuiQuestaoI3() {
		return boxQuestaoI3;
	}

	public JCheckBox getGuiQuestaoI4() {
		return boxQuestaoI4;
	}

	public JCheckBox getGuiQuestaoI5() {
		return boxQuestaoI5;
	}

	public JCheckBox getGuiQuestaoI6() {
		return boxQuestaoI6;
	}

	public JCheckBox getGuiQuestaoI7() {
		return boxQuestaoI7;
	}

	public JCheckBox getGuiQuestaoI8() {
		return boxQuestaoI8;
	}

	public JCheckBox getGuiQuestaoI9() {
		return boxQuestaoI9;
	}

	public JCheckBox getGuiQuestaoS1() {
		return boxQuestaoS1;
	}

	public JCheckBox getGuiQuestaoS10() {
		return boxQuestaoS10;
	}

	public JCheckBox getGuiQuestaoS11() {
		return boxQuestaoS11;
	}

	public JCheckBox getGuiQuestaoS12() {
		return boxQuestaoS12;
	}

	public JCheckBox getGuiQuestaoS13() {
		return boxQuestaoS13;
	}

	public JCheckBox getGuiQuestaoS14() {
		return boxQuestaoS14;
	}

	public JCheckBox getGuiQuestaoS15() {
		return boxQuestaoS15;
	}

	public JCheckBox getGuiQuestaoS16() {
		return boxQuestaoS16;
	}

	public JCheckBox getGuiQuestaoS17() {
		return boxQuestaoS17;
	}

	public JCheckBox getGuiQuestaoS18() {
		return boxQuestaoS18;
	}

	public JCheckBox getGuiQuestaoS19() {
		return boxQuestaoS19;
	}

	public JCheckBox getGuiQuestaoS2() {
		return boxQuestaoS2;
	}

	public JCheckBox getGuiQuestaoS20() {
		return boxQuestaoS20;
	}

	public JCheckBox getGuiQuestaoS21() {
		return boxQuestaoS21;
	}

	public JCheckBox getGuiQuestaoS22() {
		return boxQuestaoS22;
	}

	public JCheckBox getGuiQuestaoS23() {
		return boxQuestaoS23;
	}

	public JCheckBox getGuiQuestaoS24() {
		return boxQuestaoS24;
	}

	public JCheckBox getGuiQuestaoS25() {
		return boxQuestaoS25;
	}

	public JCheckBox getGuiQuestaoS26() {
		return boxQuestaoS26;
	}

	public JCheckBox getGuiQuestaoS27() {
		return boxQuestaoS27;
	}

	public JCheckBox getGuiQuestaoS28() {
		return boxQuestaoS28;
	}

	public JCheckBox getGuiQuestaoS3() {
		return boxQuestaoS3;
	}

	public JCheckBox getGuiQuestaoS4() {
		return boxQuestaoS4;
	}

	public JCheckBox getGuiQuestaoS5() {
		return boxQuestaoS5;
	}

	public JCheckBox getGuiQuestaoS6() {
		return boxQuestaoS6;
	}

	public JCheckBox getGuiQuestaoS7() {
		return boxQuestaoS7;
	}

	public JCheckBox getGuiQuestaoS8() {
		return boxQuestaoS8;
	}

	public JCheckBox getGuiQuestaoS9() {
		return boxQuestaoS9;
	}

	public JLabel getLabelFuncionario() {
		return labelFuncionario;
	}

	public ToolBar getTB() {
		return toolBar;
	}

	@Override
	public void iniciarControlador() {

	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {

		final Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

		toolBar = new ToolBar();
		add(toolBar.getToolBar());

		labelFuncionario = new JLabel("FUNCIONÁRIO");
		labelFuncionario.setCursor(cursor);
		add(labelFuncionario);

		boxFuncionario = new JComboBox<Funcionario>();
		List<Funcionario> funcionarios = (List<Funcionario>) FuncionarioFac.getRegistro();
		Collections.sort(funcionarios, new FuncionarioComp().new Nome());
		for (Funcionario funcionario : funcionarios) {
			boxFuncionario.addItem(funcionario);
		}

		add(boxFuncionario);

		add(new JLabel("QUAIS PALAVRAS MELHOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestaoD1 = new JCheckBox("MODESTO");
		add(boxQuestaoD1);

		boxQuestaoD2 = new JCheckBox("DEPENDENTES");
		add(boxQuestaoD2);

		boxQuestaoD3 = new JCheckBox("INSEGURO");
		add(boxQuestaoD3);

		boxQuestaoD4 = new JCheckBox("QUIET");
		add(boxQuestaoD4);

		boxQuestaoD5 = new JCheckBox("SUAVE");
		add(boxQuestaoD5);

		boxQuestaoD6 = new JCheckBox("PACÍFICOS");
		add(boxQuestaoD6);

		boxQuestaoD7 = new JCheckBox("CONSERVADOR");
		add(boxQuestaoD7);

		boxQuestaoD8 = new JCheckBox("MANSO");
		add(boxQuestaoD8);

		boxQuestaoD9 = new JCheckBox("PESA PRÓS E CONTRAS");
		add(boxQuestaoD9);

		boxQuestaoD10 = new JCheckBox("REALISTAS");
		add(boxQuestaoD10);

		boxQuestaoD11 = new JCheckBox("AUTO-APAGADOR");
		add(boxQuestaoD11);

		boxQuestaoD12 = new JCheckBox("DESPRETENSIOSO");
		add(boxQuestaoD12);

		boxQuestaoD13 = new JCheckBox("AUTOCRÍTICO");
		add(boxQuestaoD13);

		boxQuestaoD14 = new JCheckBox("CALCULISTA TOMADOR DE RISCO");
		add(boxQuestaoD14);

		boxQuestaoD15 = new JCheckBox("AUTOCONFIANTE");
		add(boxQuestaoD15);

		boxQuestaoD16 = new JCheckBox("RÁPIDO");
		add(boxQuestaoD16);

		boxQuestaoD17 = new JCheckBox("COMPETITIVA");
		add(boxQuestaoD17);

		boxQuestaoD18 = new JCheckBox("AUTO-CONFIANTE");
		add(boxQuestaoD18);

		boxQuestaoD19 = new JCheckBox("INQUISITIVO");
		add(boxQuestaoD19);

		boxQuestaoD20 = new JCheckBox("DECISIVOS");
		add(boxQuestaoD20);

		boxQuestaoD21 = new JCheckBox("AVENTUREIRO");
		add(boxQuestaoD21);

		boxQuestaoD22 = new JCheckBox("TOMADOR DE RISCO");
		add(boxQuestaoD22);

		boxQuestaoD23 = new JCheckBox("VIGOROSO");
		add(boxQuestaoD23);

		boxQuestaoD24 = new JCheckBox("EXIGINDO");
		add(boxQuestaoD24);

		boxQuestaoD25 = new JCheckBox("DOMINADOR");
		add(boxQuestaoD25);

		boxQuestaoD26 = new JCheckBox("OUSADOS");
		add(boxQuestaoD26);

		boxQuestaoD27 = new JCheckBox("DIRETA");
		add(boxQuestaoD27);

		boxQuestaoD28 = new JCheckBox("EGOCÊNTRICO");
		add(boxQuestaoD28);

		boxQuestaoI1 = new JCheckBox("RETICENTE");
		add(boxQuestaoI1);

		boxQuestaoI2 = new JCheckBox("AUTOCONSCIENTES");
		add(boxQuestaoI2);

		boxQuestaoI3 = new JCheckBox("RETIRADO");
		add(boxQuestaoI3);

		boxQuestaoI4 = new JCheckBox("ALOOF");
		add(boxQuestaoI4);

		boxQuestaoI5 = new JCheckBox("PESSIMISTA");
		add(boxQuestaoI5);

		boxQuestaoI6 = new JCheckBox("SUSPEITOS");
		add(boxQuestaoI6);

		boxQuestaoI7 = new JCheckBox("APOSENTAR");
		add(boxQuestaoI7);

		boxQuestaoI8 = new JCheckBox("CONTROLADO");
		add(boxQuestaoI8);

		boxQuestaoI9 = new JCheckBox("LOGICA");
		add(boxQuestaoI9);

		boxQuestaoI10 = new JCheckBox("FACTUAIS");
		add(boxQuestaoI10);

		boxQuestaoI11 = new JCheckBox("REFLEXIVO");
		add(boxQuestaoI11);

		boxQuestaoI12 = new JCheckBox("DISCRIMINANDO");
		add(boxQuestaoI12);

		boxQuestaoI13 = new JCheckBox("OBSERVANDO");
		add(boxQuestaoI13);

		boxQuestaoI14 = new JCheckBox("CONVENCENDO");
		add(boxQuestaoI14);

		boxQuestaoI15 = new JCheckBox("CONFIANTE");
		add(boxQuestaoI15);

		boxQuestaoI16 = new JCheckBox("ENCANTADOR");
		add(boxQuestaoI16);

		boxQuestaoI17 = new JCheckBox("PREPARADA");
		add(boxQuestaoI17);

		boxQuestaoI18 = new JCheckBox("GENEROSO");
		add(boxQuestaoI18);

		boxQuestaoI19 = new JCheckBox("SOCIÁVEL");
		add(boxQuestaoI19);

		boxQuestaoI20 = new JCheckBox("AGRADÁVEIS");
		add(boxQuestaoI20);

		boxQuestaoI21 = new JCheckBox("INFLUENTE");
		add(boxQuestaoI21);

		boxQuestaoI22 = new JCheckBox("CONFIANDO");
		add(boxQuestaoI22);

		boxQuestaoI23 = new JCheckBox("AUTO-PROMOÇÃO");
		add(boxQuestaoI23);

		boxQuestaoI24 = new JCheckBox("EMOCIONAL");
		add(boxQuestaoI24);

		boxQuestaoI25 = new JCheckBox("IMPULSIVO");
		add(boxQuestaoI25);

		boxQuestaoI26 = new JCheckBox("PERSUASIVOS");
		add(boxQuestaoI26);

		boxQuestaoI27 = new JCheckBox("GREGÁRIA");
		add(boxQuestaoI27);

		boxQuestaoI28 = new JCheckBox("ENTUSIASMADO");
		add(boxQuestaoI28);

		boxQuestaoS1 = new JCheckBox("ATIVO");
		add(boxQuestaoS1);

		boxQuestaoS2 = new JCheckBox("FRUSTRADOS PELO STATUS QUO");
		add(boxQuestaoS2);

		boxQuestaoS3 = new JCheckBox("ESPONTÂNEO");
		add(boxQuestaoS3);

		boxQuestaoS4 = new JCheckBox("FAULT-FINDING");
		add(boxQuestaoS4);

		boxQuestaoS5 = new JCheckBox("ORIENTADA POR MUDANÇA");
		add(boxQuestaoS5);

		boxQuestaoS6 = new JCheckBox("INQUIETOS");
		add(boxQuestaoS6);

		boxQuestaoS7 = new JCheckBox("IMPETUOSO");
		add(boxQuestaoS7);

		boxQuestaoS8 = new JCheckBox("INQUIETO");
		add(boxQuestaoS8);

		boxQuestaoS9 = new JCheckBox("DESCONTENTE");
		add(boxQuestaoS9);

		boxQuestaoS10 = new JCheckBox("CRÍTICOS");
		add(boxQuestaoS10);

		boxQuestaoS11 = new JCheckBox("ANSIOSO");
		add(boxQuestaoS11);

		boxQuestaoS12 = new JCheckBox("ALERTA");
		add(boxQuestaoS12);

		boxQuestaoS13 = new JCheckBox("EXTROVERTIDO");
		add(boxQuestaoS13);

		boxQuestaoS14 = new JCheckBox("MÓVEL");
		add(boxQuestaoS14);

		boxQuestaoS15 = new JCheckBox("ESTÁVEL");
		add(boxQuestaoS15);

		boxQuestaoS16 = new JCheckBox("AMÁVEL");
		add(boxQuestaoS16);

		boxQuestaoS17 = new JCheckBox("DELIBERADA");
		add(boxQuestaoS17);

		boxQuestaoS18 = new JCheckBox("NÃO DEMONSTRATIVO");
		add(boxQuestaoS18);

		boxQuestaoS19 = new JCheckBox("DESCONTRAÍDO");
		add(boxQuestaoS19);

		boxQuestaoS20 = new JCheckBox("INATIVOS");
		add(boxQuestaoS20);

		boxQuestaoS21 = new JCheckBox("COMPLACENTE");
		add(boxQuestaoS21);

		boxQuestaoS22 = new JCheckBox("POSSESSIVO");
		add(boxQuestaoS22);

		boxQuestaoS23 = new JCheckBox("SERENO");
		add(boxQuestaoS23);

		boxQuestaoS24 = new JCheckBox("EQUIPE-PESSOA");
		add(boxQuestaoS24);

		boxQuestaoS25 = new JCheckBox("PREVISÍVEL");
		add(boxQuestaoS25);

		boxQuestaoS26 = new JCheckBox("LEAIS");
		add(boxQuestaoS26);

		boxQuestaoS27 = new JCheckBox("PACIENTE");
		add(boxQuestaoS27);

		boxQuestaoS28 = new JCheckBox("PASSIVO");
		add(boxQuestaoS28);

		boxQuestaoC1 = new JCheckBox("SARCÁSTICO");
		add(boxQuestaoC1);

		boxQuestaoC2 = new JCheckBox("SEM TATO");
		add(boxQuestaoC2);

		boxQuestaoC3 = new JCheckBox("OBSTINADO");
		add(boxQuestaoC3);

		boxQuestaoC4 = new JCheckBox("DESAFIADOR");
		add(boxQuestaoC4);

		boxQuestaoC5 = new JCheckBox("REBELDE");
		add(boxQuestaoC5);

		boxQuestaoC6 = new JCheckBox("ARBITRÁRIOS");
		add(boxQuestaoC6);

		boxQuestaoC7 = new JCheckBox("TEIMOSO");
		add(boxQuestaoC7);

		boxQuestaoC8 = new JCheckBox("FIRME");
		add(boxQuestaoC8);

		boxQuestaoC9 = new JCheckBox("RÍGIDO");
		add(boxQuestaoC9);

		boxQuestaoC10 = new JCheckBox("INDEPENDENTES");
		add(boxQuestaoC10);

		boxQuestaoC11 = new JCheckBox("PERSISTENTE");
		add(boxQuestaoC11);

		boxQuestaoC12 = new JCheckBox("OPINATIVO");
		add(boxQuestaoC12);

		boxQuestaoC13 = new JCheckBox("HIPÓCRITA");
		add(boxQuestaoC13);

		boxQuestaoC14 = new JCheckBox("PESSOA PRÓPRIA");
		add(boxQuestaoC14);

		boxQuestaoC15 = new JCheckBox("EVASIVO");
		add(boxQuestaoC15);

		boxQuestaoC16 = new JCheckBox("MADURO");
		add(boxQuestaoC16);

		boxQuestaoC17 = new JCheckBox("SENSÍVEL");
		add(boxQuestaoC17);

		boxQuestaoC18 = new JCheckBox("ANALÍTICO");
		add(boxQuestaoC18);

		boxQuestaoC19 = new JCheckBox("PADRÕES ELEVADOS");
		add(boxQuestaoC19);

		boxQuestaoC20 = new JCheckBox("CONTIDOS");
		add(boxQuestaoC20);

		boxQuestaoC21 = new JCheckBox("CUIDADO");
		add(boxQuestaoC21);

		boxQuestaoC22 = new JCheckBox("CORTÊS");
		add(boxQuestaoC22);

		boxQuestaoC23 = new JCheckBox("CONVENCIONAL");
		add(boxQuestaoC23);

		boxQuestaoC24 = new JCheckBox("SISTEMÁTICO");
		add(boxQuestaoC24);

		boxQuestaoC25 = new JCheckBox("DIPLOMÁTICO");
		add(boxQuestaoC25);

		boxQuestaoC26 = new JCheckBox("DESCOBRIDORES DE FATOS");
		add(boxQuestaoC26);

		boxQuestaoC27 = new JCheckBox("PRECISAS");
		add(boxQuestaoC27);

		boxQuestaoC28 = new JCheckBox("PERFECCIONISTA");
		add(boxQuestaoC28);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 116, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
	}

	@Override
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarLayout() {
		setBorder(BorderFactory.createTitledBorder("TESTE DE PERSONALIDADE D.I.S.C."));
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGui() {
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGui() {
		Funcionario funcionario = null;
		List<Funcionario> funcionarios = (List<Funcionario>) FuncionarioFac.getRegistro();
		Collections.sort(funcionarios, new FuncionarioComp().new Nome());
		boxFuncionario.removeAllItems();
		for (Funcionario b : funcionarios) {
			boxFuncionario.addItem(b);
		}
		if (!MainCont.getCurriculoTesteCFc().isShowing()
				&& MainCont.getCurriculoTesteCFc().getTesteCCont().getTesteC() != null) {
			funcionario = MainCont.getCurriculoTesteCFc().getTesteCCont().getTesteC().getFuncionario();
			boxFuncionario.setSelectedItem(funcionario);
		}
	}
}
