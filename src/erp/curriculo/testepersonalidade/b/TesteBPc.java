package erp.curriculo.testepersonalidade.b;

import java.awt.Cursor;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
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
public final class TesteBPc extends JPanel implements Gui {

	private JComboBox<Funcionario> boxFuncionario;
	private JComboBox<String> boxQuestao1;
	private JComboBox<String> boxQuestao10;
	private JComboBox<String> boxQuestao11;
	private JComboBox<String> boxQuestao12;
	private JComboBox<String> boxQuestao13;
	private JComboBox<String> boxQuestao14;
	private JComboBox<String> boxQuestao15;
	private JComboBox<String> boxQuestao16;
	private JComboBox<String> boxQuestao17;
	private JComboBox<String> boxQuestao18;
	private JComboBox<String> boxQuestao19;
	private JComboBox<String> boxQuestao2;
	private JComboBox<String> boxQuestao20;
	private JComboBox<String> boxQuestao21;
	private JComboBox<String> boxQuestao22;
	private JComboBox<String> boxQuestao23;
	private JComboBox<String> boxQuestao24;
	private JComboBox<String> boxQuestao25;
	private JComboBox<String> boxQuestao26;
	private JComboBox<String> boxQuestao27;
	private JComboBox<String> boxQuestao28;
	private JComboBox<String> boxQuestao29;
	private JComboBox<String> boxQuestao3;
	private JComboBox<String> boxQuestao30;
	private JComboBox<String> boxQuestao31;
	private JComboBox<String> boxQuestao32;
	private JComboBox<String> boxQuestao33;
	private JComboBox<String> boxQuestao34;
	private JComboBox<String> boxQuestao35;
	private JComboBox<String> boxQuestao36;
	private JComboBox<String> boxQuestao37;
	private JComboBox<String> boxQuestao38;
	private JComboBox<String> boxQuestao39;
	private JComboBox<String> boxQuestao4;
	private JComboBox<String> boxQuestao40;
	private JComboBox<String> boxQuestao5;
	private JComboBox<String> boxQuestao6;
	private JComboBox<String> boxQuestao7;
	private JComboBox<String> boxQuestao8;
	private JComboBox<String> boxQuestao9;

	private ConfiguracaoGui configuracaoGui;
	private JLabel labelFuncionario;
	private ToolBar toolBar;

	public TesteBPc() {
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

	public JComboBox<String> getGuiQuestao1() {
		return boxQuestao1;
	}

	public JComboBox<String> getGuiQuestao10() {
		return boxQuestao10;
	}

	public JComboBox<String> getGuiQuestao11() {
		return boxQuestao11;
	}

	public JComboBox<String> getGuiQuestao12() {
		return boxQuestao12;
	}

	public JComboBox<String> getGuiQuestao13() {
		return boxQuestao13;
	}

	public JComboBox<String> getGuiQuestao14() {
		return boxQuestao14;
	}

	public JComboBox<String> getGuiQuestao15() {
		return boxQuestao15;
	}

	public JComboBox<String> getGuiQuestao16() {
		return boxQuestao16;
	}

	public JComboBox<String> getGuiQuestao17() {
		return boxQuestao17;
	}

	public JComboBox<String> getGuiQuestao18() {
		return boxQuestao18;
	}

	public JComboBox<String> getGuiQuestao19() {
		return boxQuestao19;
	}

	public JComboBox<String> getGuiQuestao2() {
		return boxQuestao2;
	}

	public JComboBox<String> getGuiQuestao20() {
		return boxQuestao20;
	}

	public JComboBox<String> getGuiQuestao21() {
		return boxQuestao21;
	}

	public JComboBox<String> getGuiQuestao22() {
		return boxQuestao22;
	}

	public JComboBox<String> getGuiQuestao23() {
		return boxQuestao23;
	}

	public JComboBox<String> getGuiQuestao24() {
		return boxQuestao24;
	}

	public JComboBox<String> getGuiQuestao25() {
		return boxQuestao25;
	}

	public JComboBox<String> getGuiQuestao26() {
		return boxQuestao26;
	}

	public JComboBox<String> getGuiQuestao27() {
		return boxQuestao27;
	}

	public JComboBox<String> getGuiQuestao28() {
		return boxQuestao28;
	}

	public JComboBox<String> getGuiQuestao29() {
		return boxQuestao29;
	}

	public JComboBox<String> getGuiQuestao3() {
		return boxQuestao3;
	}

	public JComboBox<String> getGuiQuestao30() {
		return boxQuestao30;
	}

	public JComboBox<String> getGuiQuestao31() {
		return boxQuestao31;
	}

	public JComboBox<String> getGuiQuestao32() {
		return boxQuestao32;
	}

	public JComboBox<String> getGuiQuestao33() {
		return boxQuestao33;
	}

	public JComboBox<String> getGuiQuestao34() {
		return boxQuestao34;
	}

	public JComboBox<String> getGuiQuestao35() {
		return boxQuestao35;
	}

	public JComboBox<String> getGuiQuestao36() {
		return boxQuestao36;
	}

	public JComboBox<String> getGuiQuestao37() {
		return boxQuestao37;
	}

	public JComboBox<String> getGuiQuestao38() {
		return boxQuestao38;
	}

	public JComboBox<String> getGuiQuestao39() {
		return boxQuestao39;
	}

	public JComboBox<String> getGuiQuestao4() {
		return boxQuestao4;
	}

	public JComboBox<String> getGuiQuestao40() {
		return boxQuestao40;
	}

	public JComboBox<String> getGuiQuestao5() {
		return boxQuestao5;
	}

	public JComboBox<String> getGuiQuestao6() {
		return boxQuestao6;
	}

	public JComboBox<String> getGuiQuestao7() {
		return boxQuestao7;
	}

	public JComboBox<String> getGuiQuestao8() {
		return boxQuestao8;
	}

	public JComboBox<String> getGuiQuestao9() {
		return boxQuestao9;
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

		add(new JLabel("1. QUAL PALAVRA MELHOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao1 = new JComboBox<String>();
		boxQuestao1.addItem("ANIMADO");
		boxQuestao1.addItem("AVENTUREIRO");
		boxQuestao1.addItem("ANALÍTICO");
		boxQuestao1.addItem("ADAPTÁVEL");
		add(boxQuestao1);

		add(new JLabel("2. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao2 = new JComboBox<String>();
		boxQuestao2.addItem("SOCIÁVEL");
		boxQuestao2.addItem("ENERGÉTICO");
		boxQuestao2.addItem("DOADOR");
		boxQuestao2.addItem("SUBMISSO");
		add(boxQuestao2);

		add(new JLabel("3. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao3 = new JComboBox<String>();
		boxQuestao3.addItem("ESTIMULANTE");
		boxQuestao3.addItem("HABILIDOSO");
		boxQuestao3.addItem("RESPEITOSO");
		boxQuestao3.addItem("RESERVADO");
		add(boxQuestao3);

		add(new JLabel("4. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao4 = new JComboBox<String>();
		boxQuestao4.addItem("CHARMOSO");
		boxQuestao4.addItem("POSITIVO");
		boxQuestao4.addItem("PLANEJADOR");
		boxQuestao4.addItem("PACIENTE");
		add(boxQuestao4);

		add(new JLabel("5. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao5 = new JComboBox<String>();
		boxQuestao5.addItem("BRINCALHÃO");
		boxQuestao5.addItem("PERSUASIVO");
		boxQuestao5.addItem("PERSISTENTE");
		boxQuestao5.addItem("SERENO");
		add(boxQuestao5);

		add(new JLabel("6. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao6 = new JComboBox<String>();
		boxQuestao6.addItem("CONVINENTE");
		boxQuestao6.addItem("COMPETITIVO");
		boxQuestao6.addItem("ATENCIOSO");
		boxQuestao6.addItem("CONTROLADO");
		add(boxQuestao6);

		add(new JLabel("7. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao7 = new JComboBox<String>();
		boxQuestao7.addItem("ESPIRITUOSO");
		boxQuestao7.addItem("AUTO-SUFICIENTE");
		boxQuestao7.addItem("SENSÍVEL");
		boxQuestao7.addItem("SATISFEITO");

		add(boxQuestao7);

		add(new JLabel("8. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao8 = new JComboBox<String>();
		boxQuestao8.addItem("ESPONTÂNEO");
		boxQuestao8.addItem("SEGURO");
		boxQuestao8.addItem("ORGANIZADO");
		boxQuestao8.addItem("TÍMIDO");

		add(boxQuestao8);

		add(new JLabel("9. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao9 = new JComboBox<String>();
		boxQuestao9.addItem("OTIMISTA");
		boxQuestao9.addItem("FRANCO");
		boxQuestao9.addItem("ORDEIRO");
		boxQuestao9.addItem("SERVIÇAL");
		add(boxQuestao9);

		add(new JLabel("10. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao10 = new JComboBox<String>();
		boxQuestao10.addItem("ENCANTADOR");
		boxQuestao10.addItem("AUDACIOSO");
		boxQuestao10.addItem("MINUCIOSO");
		boxQuestao10.addItem("DIPLOMÁTICO");
		add(boxQuestao10);

		add(new JLabel("11. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao11 = new JComboBox<String>();
		boxQuestao11.addItem("INSPIRADO");
		boxQuestao11.addItem("INDEPENDENTE");
		boxQuestao11.addItem("IDEALISTA");
		boxQuestao11.addItem("INOFENSIVO");
		add(boxQuestao11);

		add(new JLabel("12. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao12 = new JComboBox<String>();
		boxQuestao12.addItem("DESEMBARAÇADO");
		boxQuestao12.addItem("ATIVO");
		boxQuestao12.addItem("MUSICAL");
		boxQuestao12.addItem("MEDIADOR");
		add(boxQuestao12);

		add(new JLabel("13. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao13 = new JComboBox<String>();
		boxQuestao13.addItem("ENGRAÇADO");
		boxQuestao13.addItem("VIGOROSO");
		boxQuestao13.addItem("FIEL");
		boxQuestao13.addItem("AMIGÁVEL");
		add(boxQuestao13);

		add(new JLabel("14. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao14 = new JComboBox<String>();
		boxQuestao14.addItem("ALEGRE");
		boxQuestao14.addItem("CONFIANTE");
		boxQuestao14.addItem("CULTO");
		boxQuestao14.addItem("PREVISÍVEL");
		add(boxQuestao14);

		add(new JLabel("15. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao15 = new JComboBox<String>();
		boxQuestao15.addItem("DEMONSTRATIVO");
		boxQuestao15.addItem("DECIDIDO");
		boxQuestao15.addItem("PROFUNDO");
		boxQuestao15.addItem("IRÔNICO");
		add(boxQuestao15);

		add(new JLabel("16. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao16 = new JComboBox<String>();
		boxQuestao16.addItem("CONVERSADOR");
		boxQuestao16.addItem("FIRME");
		boxQuestao16.addItem("PENSATIVO");
		boxQuestao16.addItem("TOLERANTE");
		add(boxQuestao16);

		add(new JLabel("17. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao17 = new JComboBox<String>();
		boxQuestao17.addItem("VIVO");
		boxQuestao17.addItem("LÍDER");
		boxQuestao17.addItem("LEAL");
		boxQuestao17.addItem("OUVINTE");
		add(boxQuestao17);

		add(new JLabel("18. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao18 = new JComboBox<String>();
		boxQuestao18.addItem("POPULAR");
		boxQuestao18.addItem("PRODUTIVO");
		boxQuestao18.addItem("PERFECCIONISTA");
		boxQuestao18.addItem("AGRADÁVEL");
		add(boxQuestao18);

		add(new JLabel("19. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao19 = new JComboBox<String>();
		boxQuestao19.addItem("METIDO");
		boxQuestao19.addItem("MANDÃO");
		boxQuestao19.addItem("ACANHADO");
		boxQuestao19.addItem("VAZIO");
		add(boxQuestao19);

		add(new JLabel("20. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao20 = new JComboBox<String>();
		boxQuestao20.addItem("REPETITÍVEL");
		boxQuestao20.addItem("INFLEXÍVEL");
		boxQuestao20.addItem("RESSENTIDO");
		boxQuestao20.addItem("RELUTANTE");
		add(boxQuestao20);

		add(new JLabel("21. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao21 = new JComboBox<String>();
		boxQuestao21.addItem("ATRAENTE");
		boxQuestao21.addItem("CHEFE");
		boxQuestao21.addItem("DETALHISTA");
		boxQuestao21.addItem("CONTENTE");
		add(boxQuestao21);

		add(new JLabel("22. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao22 = new JComboBox<String>();
		boxQuestao22.addItem("VIVAZ");
		boxQuestao22.addItem("VALENTE");
		boxQuestao22.addItem("COMPORTADO");
		boxQuestao22.addItem("EQUILIBRADO");
		add(boxQuestao22);

		add(new JLabel("23. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao23 = new JComboBox<String>();
		boxQuestao23.addItem("INDISCIPLINADO");
		boxQuestao23.addItem("INSENSÍVEL");
		boxQuestao23.addItem("RANCOROSO");
		boxQuestao23.addItem("DESINTERESSADO");
		add(boxQuestao23);

		add(new JLabel("24. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao24 = new JComboBox<String>();
		boxQuestao24.addItem("ESQUECIDO");
		boxQuestao24.addItem("FRANCO");
		boxQuestao24.addItem("COMPLICADO");
		boxQuestao24.addItem("MEDROSO");
		add(boxQuestao24);

		add(new JLabel("25. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao25 = new JComboBox<String>();
		boxQuestao25.addItem("INOPORTUNO");
		boxQuestao25.addItem("IMPACIENTE");
		boxQuestao25.addItem("INSEGURO");
		boxQuestao25.addItem("INDECISO");
		add(boxQuestao25);

		add(new JLabel("26. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao26 = new JComboBox<String>();
		boxQuestao26.addItem("CASUAL");
		boxQuestao26.addItem("CABEÇUDO");
		boxQuestao26.addItem("INSATISFEITO");
		boxQuestao26.addItem("EXITANTE");
		add(boxQuestao26);

		add(new JLabel("27. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao27 = new JComboBox<String>();
		boxQuestao27.addItem("ESQUENTADO");
		boxQuestao27.addItem("DISCUTIDOR");
		boxQuestao27.addItem("ALIENADO");
		boxQuestao27.addItem("INCERTO");
		add(boxQuestao27);

		add(new JLabel("28. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao28 = new JComboBox<String>();
		boxQuestao28.addItem("EGOÍSTA");
		boxQuestao28.addItem("TRABALHADOR");
		boxQuestao28.addItem("RETRAÍDO");
		boxQuestao28.addItem("PREOCUPADO");
		add(boxQuestao28);

		add(new JLabel("29. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao29 = new JComboBox<String>();
		boxQuestao29.addItem("IMPREVISÍVEL");
		boxQuestao29.addItem("FRIO");
		boxQuestao29.addItem("IMPOPULAR");
		boxQuestao29.addItem("DESLIGADO");
		add(boxQuestao29);

		add(new JLabel("30. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao30 = new JComboBox<String>();
		boxQuestao30.addItem("PERMISSIVO");
		boxQuestao30.addItem("ORGULHOSO");
		boxQuestao30.addItem("CAUTELOSO");
		boxQuestao30.addItem("SIMPLES");
		add(boxQuestao30);

		add(new JLabel("31. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao31 = new JComboBox<String>();
		boxQuestao31.addItem("INGÊNUO");
		boxQuestao31.addItem("OUSADO");
		boxQuestao31.addItem("NEGATIVO");
		boxQuestao31.addItem("INDIFERENTE");
		add(boxQuestao31);

		add(new JLabel("32. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao32 = new JComboBox<String>();
		boxQuestao32.addItem("TAGARELA");
		boxQuestao32.addItem("INDELICADO");
		boxQuestao32.addItem("SENSÍVEL DEMA");
		boxQuestao32.addItem("TÍMIDO");
		add(boxQuestao32);

		add(new JLabel("33. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao33 = new JComboBox<String>();
		boxQuestao33.addItem("DESORGANIZADO");
		boxQuestao33.addItem("MANDÃO");
		boxQuestao33.addItem("DEPRIMIDO");
		boxQuestao33.addItem("CONFUSO");
		add(boxQuestao33);

		add(new JLabel("34. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao34 = new JComboBox<String>();
		boxQuestao34.addItem("DESORDENADO");
		boxQuestao34.addItem("MANIPULADOR");
		boxQuestao34.addItem("TRISTE");
		boxQuestao34.addItem("RESMUNGÃO");
		add(boxQuestao34);

		add(new JLabel("35. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao35 = new JComboBox<String>();
		boxQuestao35.addItem("BARULHENTO");
		boxQuestao35.addItem("TIRÂNICO");
		boxQuestao35.addItem("SOLITÁRIO");
		boxQuestao35.addItem("PREGUIÇOSO");
		add(boxQuestao35);

		add(new JLabel("36. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao36 = new JComboBox<String>();
		boxQuestao36.addItem("AGITADO");
		boxQuestao36.addItem("IMPRUDENTE");
		boxQuestao36.addItem("VINGATIVO");
		boxQuestao36.addItem("RELUTANTE");
		add(boxQuestao36);

		add(new JLabel("37. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao37 = new JComboBox<String>();
		boxQuestao37.addItem("INCONSTANTE");
		boxQuestao37.addItem("INTOLERANTE");
		boxQuestao37.addItem("INTROVERTIDO");
		boxQuestao37.addItem("APÁTICO");
		add(boxQuestao37);

		add(new JLabel("38. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao38 = new JComboBox<String>();
		boxQuestao38.addItem("CONVENCIDO");
		boxQuestao38.addItem("OBSTINADO");
		boxQuestao38.addItem("CÉTICO ( NÃO ACREDITAR )");
		boxQuestao38.addItem("LENTO");
		add(boxQuestao38);

		add(new JLabel("39. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao39 = new JComboBox<String>();
		boxQuestao39.addItem("DISTRAÍDO");
		boxQuestao39.addItem("IRRITÁVEL");
		boxQuestao39.addItem("DESCONFIADO");
		boxQuestao39.addItem("VAGAROSO");
		add(boxQuestao39);

		add(new JLabel("40. QUAL PALAVRA MELOR SE ENCAIXA A SUA CARACTERÍSTICA PESSOAL"));

		boxQuestao40 = new JComboBox<String>();
		boxQuestao40.addItem("INSTÁVEL");
		boxQuestao40.addItem("ASTUTO");
		boxQuestao40.addItem("CRÍTICO");
		boxQuestao40.addItem("ACOMODADO");
		add(boxQuestao40);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 83, 1, // rows, cols
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
		setBorder(BorderFactory.createTitledBorder("TESTE DE PERFIL COMPORTAMENTAL"));
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
		if (!MainCont.getCurriculoTesteBFc().isShowing()
				&& MainCont.getCurriculoTesteBFc().getTesteBCont().getTesteB() != null) {
			funcionario = MainCont.getCurriculoTesteBFc().getTesteBCont().getTesteB().getFuncionario();
			boxFuncionario.setSelectedItem(funcionario);
		}
	}
}
