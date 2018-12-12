package erp.agenda.recado;

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
public final class RecadoFc extends JFrame implements Gui {

	private RecadoCont recadoCont;
	private ConfiguracaoGui guiConfiguracao;
	private RecadoPc pcRecado;

	public RecadoFc() {
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

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
		return guiConfiguracao;
	}

	public RecadoPc getRecadoPc() {
		return pcRecado;
	}

	public RecadoCont getRecadoHandle() {
		return recadoCont;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("RECADO");
		setIconImage(Imagem.getLogoTipoImage());

		pcRecado = new RecadoPc();

		pcRecado.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pcRecado);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pcRecado.isAncestorOf(focused)) {
							pcRecado.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGUIControlador() {
		guiConfiguracao = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {
		recadoCont = new RecadoCont();
		addWindowListener(recadoCont.new Frame());
		pcRecado.getToolBar().getExcluirBtn().addActionListener(recadoCont.new Exclui());
		pcRecado.getToolBar().getNovoBtn().addActionListener(recadoCont.new Novo());
		pcRecado.getToolBar().getPesquisarBtn().addActionListener(recadoCont.new Pesquisa());
		pcRecado.getToolBar().getImprimirBtn().addActionListener(recadoCont.new Imprime());
		pcRecado.getToolBar().getRelatorioBtn().addActionListener(recadoCont.new Relatorio());
		pcRecado.getToolBar().getSalvarBtn().addActionListener(recadoCont.new Salva());
		pcRecado.getToolBar().getFecharBtn().addActionListener(recadoCont.new FechaJanela());
		pcRecado.getToolBar().getSairBtn().addActionListener(recadoCont.new SaidaSistema());
		pcRecado.getToolBar().getAjudaBtn().addActionListener(recadoCont.new Ajuda());
		pcRecado.getToolBar().getHomeBtn().addActionListener(recadoCont.new Home());

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
		guiConfiguracao.limparGui();
	}

	@Override
	public void reiniciarGUI() {
		pcRecado.reiniciarGUI();
	}
}
