package erp.agenda.evento.tipoevento;

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
public final class TipoEventoFc extends JFrame implements Gui {

	private TipoEventoCont tipoEventoCont;
	private ConfiguracaoGui configuracaoGui;
	private TipoEventoPc tipoEventoPc;

	public TipoEventoFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public TipoEventoCont getTipoEventoCont() {
		return tipoEventoCont;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public TipoEventoPc getTipoEventoPc() {
		return tipoEventoPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		tipoEventoPc = new TipoEventoPc();
		tipoEventoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(tipoEventoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (tipoEventoPc.isAncestorOf(focused)) {
							tipoEventoPc.scrollRectToVisible(focused.getBounds());
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
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		tipoEventoCont = new TipoEventoCont();
		addWindowListener(tipoEventoCont.new Frame());
		tipoEventoPc.getToolBar().getExcluirBtn().addActionListener(tipoEventoCont.new Exclui());
		tipoEventoPc.getToolBar().getNovoBtn().addActionListener(tipoEventoCont.new Novo());
		tipoEventoPc.getToolBar().getPesquisarBtn().addActionListener(tipoEventoCont.new Pesquisa());
		tipoEventoPc.getToolBar().getImprimirBtn().addActionListener(tipoEventoCont.new Imprime());
		tipoEventoPc.getToolBar().getRelatorioBtn().addActionListener(tipoEventoCont.new Relatorio());
		tipoEventoPc.getToolBar().getSalvarBtn().addActionListener(tipoEventoCont.new Salva());
		tipoEventoPc.getToolBar().getFecharBtn().addActionListener(tipoEventoCont.new FechaJanela());
		tipoEventoPc.getToolBar().getSairBtn().addActionListener(tipoEventoCont.new SaidaSistema());
		tipoEventoPc.getToolBar().getAjudaBtn().addActionListener(tipoEventoCont.new Ajuda());
		tipoEventoPc.getToolBar().getHomeBtn().addActionListener(tipoEventoCont.new Home());

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
		tipoEventoPc.reiniciarGui();
	}
}
