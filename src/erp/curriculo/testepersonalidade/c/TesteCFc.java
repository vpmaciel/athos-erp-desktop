package erp.curriculo.testepersonalidade.c;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class TesteCFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private TesteCCont testeCCont;
	private TesteCPc testeCPc;

	public TesteCFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public TesteCCont getTesteCCont() {
		return testeCCont;
	}

	public TesteCPc getTesteCPc() {
		return testeCPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		testeCCont = new TesteCCont();
		addWindowListener(testeCCont.new Frame());
		testeCPc.getLabelFuncionario().addMouseListener(testeCCont.new MostraFrame());
		testeCPc.getTB().getExcluirBtn().addActionListener(testeCCont.new Exclui());
		testeCPc.getTB().getNovoBtn().addActionListener(testeCCont.new Novo());
		testeCPc.getTB().getPesquisarBtn().addActionListener(testeCCont.new Pesquisa());
		testeCPc.getTB().getImprimirBtn().addActionListener(testeCCont.new Imprime());
		testeCPc.getTB().getRelatorioBtn().addActionListener(testeCCont.new Relatorio());
		testeCPc.getTB().getSalvarBtn().addActionListener(testeCCont.new Salva());
		testeCPc.getTB().getFecharBtn().addActionListener(testeCCont.new FechaJanela());
		testeCPc.getTB().getSairBtn().addActionListener(testeCCont.new SaidaSistema());
		testeCPc.getTB().getAjudaBtn().addActionListener(testeCCont.new Ajuda());
		testeCPc.getTB().getHomeBtn().addActionListener(testeCCont.new Home());
		testeCPc.getTB().getRegistrosBtn().addActionListener(testeCCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		testeCPc = new TesteCPc();
		testeCPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(testeCPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (testeCPc.isAncestorOf(focused)) {
							testeCPc.scrollRectToVisible(focused.getBounds());
						}
					}
				});
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarLayout() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
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
		testeCPc.reiniciarGui();
	}
}
