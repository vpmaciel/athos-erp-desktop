package erp.curriculo.teste.avaliacaodepreferenciacerebral;

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
public final class TesteAvalPrefCerPc extends JPanel implements Gui {

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
	private JComboBox<String> boxQuestao3;
	private JComboBox<String> boxQuestao4;
	private JComboBox<String> boxQuestao5;
	private JComboBox<String> boxQuestao6;
	private JComboBox<String> boxQuestao7;
	private JComboBox<String> boxQuestao8;
	private JComboBox<String> boxQuestao9;

	private ConfiguracaoGui configuracaoGui;
	private JLabel labelFuncionario;
	private ToolBar toolBar;

	public TesteAvalPrefCerPc() {
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

	public JComboBox<String> getGuiQuestao3() {
		return boxQuestao3;
	}

	public JComboBox<String> getGuiQuestao4() {
		return boxQuestao4;
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

		add(new JLabel("1. EU SOU..."));

		boxQuestao1 = new JComboBox<String>();
		boxQuestao1.addItem("IDEALISTA, CRIATIVO E VISIONÁRIO");
		boxQuestao1.addItem("DIVERTIDO, ESPIRITUAL E BENÉFICO");
		boxQuestao1.addItem("CONFIÁVEL, METICULOSO E PREVISÍVEL");
		boxQuestao1.addItem("FOCADO, DETERMINADO E PERSISTENTE");
		add(boxQuestao1);

		add(new JLabel("2. EU GOSTO DE..."));

		boxQuestao2 = new JComboBox<String>();
		boxQuestao2.addItem("SER PILOTO");
		boxQuestao2.addItem("CONVERSAR COM OS PASSAGEIROS");
		boxQuestao2.addItem("PLANEJAR A VIAGEM");
		boxQuestao2.addItem("EXPLORAR NOVAS ROTAS");
		add(boxQuestao2);

		add(new JLabel("3. SE VOCÊ QUISER SE DAR BEM COMIGO..."));

		boxQuestao3 = new JComboBox<String>();
		boxQuestao3.addItem("ME DÊ LIBERDADE");
		boxQuestao3.addItem("ME DEIXE SABER SUA EXPECTATIVA");
		boxQuestao3.addItem("LIDERE, SIGA OU SAIA DO CAMINHO");
		boxQuestao3.addItem("SEJA AMIGÁVEL, CARINHOSO ECOMPREENSIVO");
		add(boxQuestao3);

		add(new JLabel("4. PARA CONSEGUIR OBTER BONS RESULTADOS É PRECISO..."));

		boxQuestao4 = new JComboBox<String>();
		boxQuestao4.addItem("TER INCERTEZAS");
		boxQuestao4.addItem("CONTROLAR O ESSENCIAL");
		boxQuestao4.addItem("DIVERSÃO E CELEBRAÇÃO");
		boxQuestao4.addItem("PLANEJAR E OBTER RECURSOS");
		add(boxQuestao4);

		add(new JLabel("5. EU ME DIVIRTO QUANDO..."));

		boxQuestao5 = new JComboBox<String>();
		boxQuestao5.addItem("ESTOU ME EXERCITANDO");
		boxQuestao5.addItem("TENHO NOVIDADES");
		boxQuestao5.addItem("ESTOU COM OS OUTROS");
		boxQuestao5.addItem("DETERMINO AS REGRAS");
		add(boxQuestao5);

		add(new JLabel("6. EU PENSO QUE..."));

		boxQuestao6 = new JComboBox<String>();
		boxQuestao6.addItem("UNIDOS VENCEREMOS, DIVIDIDOS PERDEREMOS");
		boxQuestao6.addItem("O ATAQUE É MELHOR QUE A DEFESA");
		boxQuestao6.addItem("É BOM SER MANSO, MAS ANDAR COM UM PORRETE");
		boxQuestao6.addItem("UM HOMEM PREVENIDO VALE POR DOIS");

		add(boxQuestao6);

		add(new JLabel("7. MINHA PREOCUPAÇÃO É..."));

		boxQuestao7 = new JComboBox<String>();
		boxQuestao7.addItem("GERAR A IDEIA GLOBAL");
		boxQuestao7.addItem("FAZER COM QUE AS PESSOAS GOSTEM");
		boxQuestao7.addItem("FAZER COM QUE FUNCIONE");
		boxQuestao7.addItem("FAZER COM QUE ACONTEÇA");

		add(boxQuestao7);

		add(new JLabel("8. EU PREFIRO..."));

		boxQuestao8 = new JComboBox<String>();
		boxQuestao8.addItem("PERGUNTAS A RESPOSTAS");
		boxQuestao8.addItem("TER TODOS OS DETALHES");
		boxQuestao8.addItem("VANTAGENS A MEU FAVOR");
		boxQuestao8.addItem("QUE TODOS TENHAM A CHANCE DE SER OUVIDOS");
		add(boxQuestao8);

		add(new JLabel("9. EU GOSTO DE..."));

		boxQuestao9 = new JComboBox<String>();
		boxQuestao9.addItem("FAZER PROGRESSO");
		boxQuestao9.addItem("CONSTRUIR MEMÓRIAS");
		boxQuestao9.addItem("FAZER SENTIDO");
		boxQuestao9.addItem("TORNAR AS PESSOAS CONFORTÁVEIS");
		add(boxQuestao9);

		add(new JLabel("10. EU GOSTO DE CHEGAR..."));

		boxQuestao10 = new JComboBox<String>();
		boxQuestao10.addItem("NA FRENTE");
		boxQuestao10.addItem("JUNTO");
		boxQuestao10.addItem("NA HORA");
		boxQuestao10.addItem("EM OUTRO LUGAR");
		add(boxQuestao10);

		add(new JLabel("11. UM ÓTIMO DIA PARA MIM É QUANDO..."));

		boxQuestao11 = new JComboBox<String>();
		boxQuestao11.addItem("CONSIGO FAZER MUITAS COISAS");
		boxQuestao11.addItem("ME DIVIRTO COM MEUS AMIGOS");
		boxQuestao11.addItem("TUDO SEGUE CONFORME PLANEJADO");
		boxQuestao11.addItem("DESFRUTO DE COISAS NOVAS E ESTIMULANTES");

		add(boxQuestao11);

		add(new JLabel("12. EU VEJO A MORTE COMO..."));

		boxQuestao12 = new JComboBox<String>();
		boxQuestao12.addItem("UMA GRANDE AVENTURA MISTERIOSA");
		boxQuestao12.addItem("OPORTUNIDADE DE REVER OS FALECIDOS");
		boxQuestao12.addItem("UM MODO DE RECEBER RECOMPENSAS");
		boxQuestao12.addItem("ALGO QUE SEMPRE CHEGA MUITO CEDO");
		add(boxQuestao12);

		add(new JLabel("13. MINHA FILOSOFIA DE VIDA É..."));

		boxQuestao13 = new JComboBox<String>();
		boxQuestao13.addItem("HÁ GANHADORES E PERDEDORES, E EU ACREDITO SER UM GANHADOR");
		boxQuestao13.addItem("PARA EU GANHAR, NINGUÉM PRECISA PERDER");
		boxQuestao13.addItem("PARA GANHAR É PRECISO SEGUIR AS REGRAS");
		boxQuestao13.addItem("PARA GANHAR, É NECESSÁRIO INVENTAR NOVAS REGRAS");
		add(boxQuestao13);

		add(new JLabel("14. EU SEMPRE GOSTEI DE..."));

		boxQuestao14 = new JComboBox<String>();
		boxQuestao14.addItem("EXPLORAR");
		boxQuestao14.addItem("EVITAR SURPRESAS");
		boxQuestao14.addItem("FOCALIZAR A META");
		boxQuestao14.addItem("REALIZAR UMA ABORDAGEM NATURAL");
		add(boxQuestao14);

		add(new JLabel("15. EU GOSTO DE MUDANÇAS SE..."));

		boxQuestao15 = new JComboBox<String>();
		boxQuestao15.addItem("ME DER UMA VANTAGEM COMPETITIVA");
		boxQuestao15.addItem("FOR DIVERTIDO E PUDER SER COMPARTILHADO");
		boxQuestao15.addItem("ME DER MAIS LIBERDADE E VARIEDADE");
		boxQuestao15.addItem("MELHORAR OU ME DER MAIS CONTROLE");
		add(boxQuestao15);

		add(new JLabel("16. NÃO EXISTE NADA DE ERRADO EM..."));

		boxQuestao16 = new JComboBox<String>();
		boxQuestao16.addItem("SE COLOCAR NA FRENTE");
		boxQuestao16.addItem("COLOCAR OS OUTROS NA FRENTE");
		boxQuestao16.addItem("MUDAR DE IDEIA");
		boxQuestao16.addItem("SER CONSISTENTE");
		add(boxQuestao16);

		add(new JLabel("17. EU GOSTO DE BUSCAR CONSELHOS DE..."));

		boxQuestao17 = new JComboBox<String>();
		boxQuestao17.addItem("PESSOAS BEM-SUCEDIDAS");
		boxQuestao17.addItem("ANCIÕES E CONSELHEIROS");
		boxQuestao17.addItem("AUTORIDADES NO ASSUNTO");
		boxQuestao17.addItem("LUGARES, OS MAIS ESTRANHOS");
		add(boxQuestao17);

		add(new JLabel("18. MEU LEMA É..."));

		boxQuestao18 = new JComboBox<String>();
		boxQuestao18.addItem("FAZER O QUE PRECISA SER FEITO");
		boxQuestao18.addItem("FAZER BEM FEITO");
		boxQuestao18.addItem("FAZER JUNTO COM O GRUPO");
		boxQuestao18.addItem("SIMPLESMENTE FAZER");
		add(boxQuestao18);

		add(new JLabel("19. EU GOSTO DE..."));

		boxQuestao19 = new JComboBox<String>();
		boxQuestao19.addItem("COMPLEXIDADE, MESMO SE CONFUSO");
		boxQuestao19.addItem("ORDEM E SISTEMATIZAÇÃO");
		boxQuestao19.addItem("CALOR HUMANO E ANIMAÇÃO");
		boxQuestao19.addItem("COISAS CLARAS E SIMPLES");
		add(boxQuestao19);

		add(new JLabel("20. TEMPO PARA MIM É..."));

		boxQuestao20 = new JComboBox<String>();
		boxQuestao20.addItem("ALGO QUE DETESTO DESPERDIÇAR");
		boxQuestao20.addItem("UM GRANDE CICLO");
		boxQuestao20.addItem("UMA FLECHA QUE LEVA AO INEVITÁVEL");
		boxQuestao20.addItem("IRRELEVANTE");
		add(boxQuestao20);

		add(new JLabel("21. SE EU FOSSE BILIONÁRIO..."));

		boxQuestao21 = new JComboBox<String>();
		boxQuestao21.addItem("FARIA DOAÇÕES PARA ENTIDADES");
		boxQuestao21.addItem("CRIARIA UMA POUPANÇA AVANTAJADA");
		boxQuestao21.addItem("FARIA O QUE DESSE NA CABEÇA");
		boxQuestao21.addItem("EXIBIRIA BASTANTE COM ALGUMAS PESSOAS");
		add(boxQuestao21);

		add(new JLabel("22. EU ACREDITO QUE..."));

		boxQuestao22 = new JComboBox<String>();
		boxQuestao22.addItem("O DESTINO É MAIS IMPORTANTE QUE A JORNADA");
		boxQuestao22.addItem("A JORNADA É MAIS IMPORTANTE QUE O DESTINO");
		boxQuestao22.addItem("UM CENTAVO ECONOMIZADO É UM CENTAVO GANHO");
		boxQuestao22.addItem("BASTAM UM NAVIO E UMA ESTRELA PARA NAVEGAR");
		add(boxQuestao22);

		add(new JLabel("23. EU ACREDITO TAMBÉM QUE..."));

		boxQuestao23 = new JComboBox<String>();
		boxQuestao23.addItem("AQUELE QUE HESITA ESTÁ PERDIDO");
		boxQuestao23.addItem("DE GRÃO EM GRÃO A GALINHA ENCHE O PAPO");
		boxQuestao23.addItem("O QUE VAI, VOLTA");
		boxQuestao23.addItem("UM SORRISO OU UMA CARETA É O MESMO PARA QUEM É CEGO");
		add(boxQuestao23);

		add(new JLabel("24. EU ACREDITO AINDA QUE..."));

		boxQuestao24 = new JComboBox<String>();
		boxQuestao24.addItem("É MELHOR PRUDÊNCIA DO QUE ARREPENDIMENTO");
		boxQuestao24.addItem("A AUTORIDADE DEVE SER DESAFIADA");
		boxQuestao24.addItem("GANHAR É FUNDAMENTAL");
		boxQuestao24.addItem("O COLETIVO É MAIS IMPORTANTE DO QUE O INDIVIDUAL");
		add(boxQuestao24);

		add(new JLabel("25. EU PENSO QUE..."));

		boxQuestao25 = new JComboBox<String>();
		boxQuestao25.addItem("NÃO É FÁCIL FICAR ENCURRALADO");
		boxQuestao25.addItem("É PREFERÍVEL OLHAR, ANTES DE PULAR");
		boxQuestao25.addItem("DUAS CABEÇAS PENSAM MELHOR QUE DO QUE UMA");
		boxQuestao25.addItem("SE VOCÊ NÃO TEM CONDIÇÕES DE COMPETIR, NÃO COMPITA");
		add(boxQuestao25);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 53, 1, // rows, cols
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
		setBorder(BorderFactory.createTitledBorder("TESTE DE PREFERÊNCIA CEREBRAL"));
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
		if (!MainCont.getCurriculoTesteAvalPrefCerFc().isShowing()
				&& MainCont.getCurriculoTesteAvalPrefCerFc().getTesteAvalPrefCerCont().getTesteAvalPrefCer() != null) {
			funcionario = MainCont.getCurriculoTesteAvalPrefCerFc().getTesteAvalPrefCerCont().getTesteAvalPrefCer().getFuncionario();
			boxFuncionario.setSelectedItem(funcionario);
		}
	}
}
