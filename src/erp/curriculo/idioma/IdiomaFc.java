package erp.curriculo.idioma;

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
public final class IdiomaFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private IdiomaCont idiomaCont;
	private IdiomaPc idiomaPc;

	public IdiomaFc() {
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

	public IdiomaCont getIdiomaCont() {
		return idiomaCont;
	}

	public IdiomaPc getIdiomaPc() {
		return idiomaPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		idiomaCont = new IdiomaCont();
		addWindowListener(idiomaCont.new Frame());
		idiomaPc.getLabelFuncionario().addMouseListener(idiomaCont.new MostraFrame());
		idiomaPc.getTB().getExcluirBtn().addActionListener(idiomaCont.new Exclui());
		idiomaPc.getTB().getNovoBtn().addActionListener(idiomaCont.new Novo());
		idiomaPc.getTB().getPesquisarBtn().addActionListener(idiomaCont.new Pesquisa());
		idiomaPc.getTB().getImprimirBtn().addActionListener(idiomaCont.new Imprime());
		idiomaPc.getTB().getRelatorioBtn().addActionListener(idiomaCont.new Relatorio());
		idiomaPc.getTB().getSalvarBtn().addActionListener(idiomaCont.new Salva());
		idiomaPc.getTB().getFecharBtn().addActionListener(idiomaCont.new FechaJanela());
		idiomaPc.getTB().getSairBtn().addActionListener(idiomaCont.new SaidaSistema());
		idiomaPc.getTB().getAjudaBtn().addActionListener(idiomaCont.new Ajuda());
		idiomaPc.getTB().getHomeBtn().addActionListener(idiomaCont.new Home());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		idiomaPc = new IdiomaPc();
		idiomaPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(idiomaPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (idiomaPc.isAncestorOf(focused)) {
							idiomaPc.scrollRectToVisible(focused.getBounds());
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
		idiomaPc.reiniciarGui();
	}
}
