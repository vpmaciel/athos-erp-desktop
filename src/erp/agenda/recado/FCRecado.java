package erp.agenda.recado;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.GUI;
import arquitetura.gui.GUIConfiguracao;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FCRecado extends JFrame implements GUI {

	private RecadoControlador recadoControlador;
	private GUIConfiguracao guiConfiguracao;
	private PCRecado pcRecado;

	public FCRecado() {
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
	public GUIConfiguracao getGUIConfiguracao() {
		return guiConfiguracao;
	}

	public PCRecado getPanelCadastroRecado() {
		return pcRecado;
	}

	public RecadoControlador getRecadoHandle() {
		return recadoControlador;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("RECADO");
		setIconImage(Imagem.getLogoTipoImage());

		pcRecado = new PCRecado();

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
		guiConfiguracao = new GUIConfiguracao(this);
	}

	@Override
	public void iniciarControlador() {
		recadoControlador = new RecadoControlador();
		addWindowListener(recadoControlador.new Frame());
		pcRecado.getToolBar().getButtonExcluiRegistro()
				.addActionListener(recadoControlador.new ExcluiRegistro());
		pcRecado.getToolBar().getButtonNovoFrame().addActionListener(recadoControlador.new NovoFrame());
		pcRecado.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(recadoControlador.new PesquisaRegistro());
		pcRecado.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(recadoControlador.new ImprimiUnicoRegistro());
		pcRecado.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(recadoControlador.new ImprimiTodosRegistros());
		pcRecado.getToolBar().getButtonSalvar().addActionListener(recadoControlador.new Salva());
		pcRecado.getToolBar().getButtonFechar().addActionListener(recadoControlador.new FechaJanela());
		pcRecado.getToolBar().getButtonSair().addActionListener(recadoControlador.new SaidaSistema());
		pcRecado.getToolBar().getButtonAjuda().addActionListener(recadoControlador.new Ajuda());
		pcRecado.getToolBar().getButtonHome().addActionListener(recadoControlador.new Home());

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
