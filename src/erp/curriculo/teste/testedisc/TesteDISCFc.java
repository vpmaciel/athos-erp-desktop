package erp.curriculo.teste.testedisc;

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
public final class TesteDISCFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private TesteDISCCont testeDISCCont;
	private TesteDISCPc testeDISCPc;

	public TesteDISCFc() {
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

	public TesteDISCCont getTesteDISCCont() {
		return testeDISCCont;
	}

	public TesteDISCPc getTesteDISCPc() {
		return testeDISCPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		testeDISCCont = new TesteDISCCont();
		addWindowListener(testeDISCCont.new Frame());
		testeDISCPc.getLabelFuncionario().addMouseListener(testeDISCCont.new MostraFrame());
		testeDISCPc.getTB().getExcluirBtn().addActionListener(testeDISCCont.new Exclui());
		testeDISCPc.getTB().getNovoBtn().addActionListener(testeDISCCont.new Novo());
		testeDISCPc.getTB().getPesquisarBtn().addActionListener(testeDISCCont.new Pesquisa());
		testeDISCPc.getTB().getImprimirBtn().addActionListener(testeDISCCont.new Imprime());
		testeDISCPc.getTB().getRelatorioBtn().addActionListener(testeDISCCont.new Relatorio());
		testeDISCPc.getTB().getSalvarBtn().addActionListener(testeDISCCont.new Salva());
		testeDISCPc.getTB().getFecharBtn().addActionListener(testeDISCCont.new FechaJanela());
		testeDISCPc.getTB().getSairBtn().addActionListener(testeDISCCont.new SaidaSistema());
		testeDISCPc.getTB().getAjudaBtn().addActionListener(testeDISCCont.new Ajuda());
		testeDISCPc.getTB().getHomeBtn().addActionListener(testeDISCCont.new Home());
		testeDISCPc.getTB().getRegistrosBtn().addActionListener(testeDISCCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		testeDISCPc = new TesteDISCPc();
		testeDISCPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(testeDISCPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (testeDISCPc.isAncestorOf(focused)) {
							testeDISCPc.scrollRectToVisible(focused.getBounds());
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
		testeDISCPc.reiniciarGui();
	}
}
