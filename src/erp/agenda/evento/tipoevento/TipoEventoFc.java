package erp.agenda.evento.tipoevento;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class TipoEventoFc extends JFrame implements Gui {

	private TipoEventoCont tipoEventoCont;
	private ConfiguracaoGui configuracaoGui;
	private TipoEventoPc tipoEventoPc;

	public TipoEventoFc() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public TipoEventoCont getTipoEventoGerenteEventos() {
		return tipoEventoCont;
	}

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
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
	public void iniciarGUI() {
		setTitle("TIPO DE EVENTO");
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

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGUIControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {
		tipoEventoCont = new TipoEventoCont();
		addWindowListener(tipoEventoCont.new Frame());
		tipoEventoPc.getToolBar().getExcluirBTN().addActionListener(tipoEventoCont.new Exclui());
		tipoEventoPc.getToolBar().getNovoBTN().addActionListener(tipoEventoCont.new Novo());
		tipoEventoPc.getToolBar().getPesquisarBTN().addActionListener(tipoEventoCont.new Pesquisa());
		tipoEventoPc.getToolBar().getImprimirBTN().addActionListener(tipoEventoCont.new Imprime());
		tipoEventoPc.getToolBar().getRelatorioBTN().addActionListener(tipoEventoCont.new Relatorio());
		tipoEventoPc.getToolBar().getSalvarBTN().addActionListener(tipoEventoCont.new Salva());
		tipoEventoPc.getToolBar().getFecharBTN().addActionListener(tipoEventoCont.new FechaJanela());
		tipoEventoPc.getToolBar().getSairBTN().addActionListener(tipoEventoCont.new SaidaSistema());
		tipoEventoPc.getToolBar().getAjudaBTN().addActionListener(tipoEventoCont.new Ajuda());
		tipoEventoPc.getToolBar().getHomeBTN().addActionListener(tipoEventoCont.new Home());

	}

	@Override
	public void iniciarLayout() {
		setLayout(null);
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
	}

	@Override
	public void iniciarTabela() {
	}

	@Override
	public void limparGUI() {
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGUI() {
		tipoEventoPc.reiniciarGUI();
	}
}
