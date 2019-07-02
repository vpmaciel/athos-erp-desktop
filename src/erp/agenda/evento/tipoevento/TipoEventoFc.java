package erp.agenda.evento.tipoevento;

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
public final class TipoEventoFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private TipoEventoControl tipoEventoControl;
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

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public TipoEventoControl getTipoEventoCont() {
		return tipoEventoControl;
	}

	public TipoEventoPc getTipoEventoPc() {
		return tipoEventoPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		tipoEventoControl = new TipoEventoControl();
		addWindowListener(tipoEventoControl.new Frame());
		tipoEventoPc.getToolBar().getExcluirBtn().addActionListener(tipoEventoControl.new Exclui());
		tipoEventoPc.getToolBar().getNovoBtn().addActionListener(tipoEventoControl.new Novo());
		tipoEventoPc.getToolBar().getPesquisarBtn().addActionListener(tipoEventoControl.new Pesquisa());
		tipoEventoPc.getToolBar().getImprimirBtn().addActionListener(tipoEventoControl.new Imprime());
		tipoEventoPc.getToolBar().getRelatorioBtn().addActionListener(tipoEventoControl.new Relatorio());
		tipoEventoPc.getToolBar().getSalvarBtn().addActionListener(tipoEventoControl.new Salva());
		tipoEventoPc.getToolBar().getFecharBtn().addActionListener(tipoEventoControl.new FechaJanela());
		tipoEventoPc.getToolBar().getSairBtn().addActionListener(tipoEventoControl.new SaidaSistema());
		tipoEventoPc.getToolBar().getAjudaBtn().addActionListener(tipoEventoControl.new Ajuda());
		tipoEventoPc.getToolBar().getHomeBtn().addActionListener(tipoEventoControl.new Home());
		tipoEventoPc.getToolBar().getRegistrosBtn().addActionListener(tipoEventoControl.new Registro());
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
		tipoEventoPc.reiniciarGui();
	}
}
