package erp.curriculo.idioma;

import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class IdiomaFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private IdiomaControl idiomaControl;
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

	public IdiomaControl getIdiomaCont() {
		return idiomaControl;
	}

	public IdiomaPc getIdiomaPc() {
		return idiomaPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		idiomaControl = new IdiomaControl();
		addWindowListener(idiomaControl.new Frame());
		idiomaPc.getLabelFuncionario().addMouseListener(idiomaControl.new MostraFrame());
		idiomaPc.getTB().getExcluirBtn().addActionListener(idiomaControl.new Exclui());
		idiomaPc.getTB().getNovoBtn().addActionListener(idiomaControl.new Novo());
		idiomaPc.getTB().getPesquisarBtn().addActionListener(idiomaControl.new Pesquisa());
		idiomaPc.getTB().getImprimirBtn().addActionListener(idiomaControl.new Imprime());
		idiomaPc.getTB().getRelatorioBtn().addActionListener(idiomaControl.new Relatorio());
		idiomaPc.getTB().getSalvarBtn().addActionListener(idiomaControl.new Salva());
		idiomaPc.getTB().getFecharBtn().addActionListener(idiomaControl.new FechaJanela());
		idiomaPc.getTB().getSairBtn().addActionListener(idiomaControl.new SaidaSistema());
		idiomaPc.getTB().getAjudaBtn().addActionListener(idiomaControl.new Ajuda());
		idiomaPc.getTB().getHomeBtn().addActionListener(idiomaControl.new Home());
		idiomaPc.getTB().getRegistrosBtn().addActionListener(idiomaControl.new Registro());
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
		setPreferredSize(Sis.getTamanhoJanela());
		setMinimumSize(Sis.getTamanhoJanela());
		setSize(Sis.getTamanhoJanela());
		setMaximumSize(Sis.getTamanhoJanela());
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
