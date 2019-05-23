package erp.curriculo.testepersonalidade.b;

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
public final class TesteBFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private TesteBCont testeBCont;
	private TesteBPc testeBPc;

	public TesteBFc() {
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

	public TesteBCont getTesteBCont() {
		return testeBCont;
	}

	public TesteBPc getTesteBPc() {
		return testeBPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		testeBCont = new TesteBCont();
		addWindowListener(testeBCont.new Frame());
		testeBPc.getLabelFuncionario().addMouseListener(testeBCont.new MostraFrame());
		testeBPc.getTB().getExcluirBtn().addActionListener(testeBCont.new Exclui());
		testeBPc.getTB().getNovoBtn().addActionListener(testeBCont.new Novo());
		testeBPc.getTB().getPesquisarBtn().addActionListener(testeBCont.new Pesquisa());
		testeBPc.getTB().getImprimirBtn().addActionListener(testeBCont.new Imprime());
		testeBPc.getTB().getRelatorioBtn().addActionListener(testeBCont.new Relatorio());
		testeBPc.getTB().getSalvarBtn().addActionListener(testeBCont.new Salva());
		testeBPc.getTB().getFecharBtn().addActionListener(testeBCont.new FechaJanela());
		testeBPc.getTB().getSairBtn().addActionListener(testeBCont.new SaidaSistema());
		testeBPc.getTB().getAjudaBtn().addActionListener(testeBCont.new Ajuda());
		testeBPc.getTB().getHomeBtn().addActionListener(testeBCont.new Home());
		testeBPc.getTB().getRegistrosBtn().addActionListener(testeBCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		testeBPc = new TesteBPc();
		testeBPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(testeBPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (testeBPc.isAncestorOf(focused)) {
							testeBPc.scrollRectToVisible(focused.getBounds());
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
		testeBPc.reiniciarGui();
	}
}
