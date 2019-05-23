package erp.curriculo.testepersonalidade.a;

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
public final class TesteAFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private TesteACont testeACont;
	private TesteAPc testeAPc;

	public TesteAFc() {
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

	public TesteACont getTesteACont() {
		return testeACont;
	}

	public TesteAPc getTesteAPc() {
		return testeAPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		testeACont = new TesteACont();
		addWindowListener(testeACont.new Frame());
		testeAPc.getLabelFuncionario().addMouseListener(testeACont.new MostraFrame());
		testeAPc.getTB().getExcluirBtn().addActionListener(testeACont.new Exclui());
		testeAPc.getTB().getNovoBtn().addActionListener(testeACont.new Novo());
		testeAPc.getTB().getPesquisarBtn().addActionListener(testeACont.new Pesquisa());
		testeAPc.getTB().getImprimirBtn().addActionListener(testeACont.new Imprime());
		testeAPc.getTB().getRelatorioBtn().addActionListener(testeACont.new Relatorio());
		testeAPc.getTB().getSalvarBtn().addActionListener(testeACont.new Salva());
		testeAPc.getTB().getFecharBtn().addActionListener(testeACont.new FechaJanela());
		testeAPc.getTB().getSairBtn().addActionListener(testeACont.new SaidaSistema());
		testeAPc.getTB().getAjudaBtn().addActionListener(testeACont.new Ajuda());
		testeAPc.getTB().getHomeBtn().addActionListener(testeACont.new Home());
		testeAPc.getTB().getRegistrosBtn().addActionListener(testeACont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		testeAPc = new TesteAPc();
		testeAPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(testeAPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (testeAPc.isAncestorOf(focused)) {
							testeAPc.scrollRectToVisible(focused.getBounds());
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
		testeAPc.reiniciarGui();
	}
}
