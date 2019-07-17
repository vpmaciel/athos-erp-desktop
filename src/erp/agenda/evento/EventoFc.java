package erp.agenda.evento;

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
public final class EventoFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private EventoControl eventoControl;
	private EventoPc eventoPc;

	public EventoFc() {
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

	public EventoControl getEventoCont() {
		return eventoControl;
	}

	public EventoPc getEventoPc() {
		return eventoPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		eventoControl = new EventoControl();
		addWindowListener(eventoControl.new Frame());
		eventoPc.getTB().getExcluirBtn().addActionListener(eventoControl.new Exclui());
		eventoPc.getTB().getNovoBtn().addActionListener(eventoControl.new Novo());
		eventoPc.getTB().getPesquisarBtn().addActionListener(eventoControl.new Pesquisa());
		eventoPc.getTB().getImprimirBtn().addActionListener(eventoControl.new Imprime());
		eventoPc.getTB().getRelatorioBtn().addActionListener(eventoControl.new Relatorio());
		eventoPc.getTB().getSalvarBtn().addActionListener(eventoControl.new Salva());
		eventoPc.getTB().getFecharBtn().addActionListener(eventoControl.new FechaJanela());
		eventoPc.getTB().getSairBtn().addActionListener(eventoControl.new SaidaSistema());
		eventoPc.getTB().getAjudaBtn().addActionListener(eventoControl.new Ajuda());
		eventoPc.getTB().getHomeBtn().addActionListener(eventoControl.new Home());
		eventoPc.getTB().getRegistrosBtn().addActionListener(eventoControl.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		eventoPc = new EventoPc();
		eventoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(eventoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (eventoPc.isAncestorOf(focused)) {
							eventoPc.scrollRectToVisible(focused.getBounds());
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
		eventoPc.reiniciarGui();
	}
}
