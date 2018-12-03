package erp.centrocusto;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.Gui;
import arquitetura.gui.GuiGerenteEventos;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FrameCadastroCentroCusto extends JFrame implements Gui {

	private CentroCustoGerenteEventos centroCustoGerenteEventos;
	private GuiGerenteEventos guiGerenteEventos;
	private PanelCadastroCentroCusto panelCadastroCentroCusto;

	public FrameCadastroCentroCusto() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGui();
		iniciarFocusTabListener();
		iniciarGuiGerenteEventos();
		iniciarGerenteEventos();
	}

	@Override
	public void atualizarTable() {
	}

	public void desabilitarGui() {
	}

	public CentroCustoGerenteEventos getCentroCustoHandle() {
		return centroCustoGerenteEventos;
	}

	@Override
	public GuiGerenteEventos getGuiGerenteEventos() {
		return guiGerenteEventos;
	}

	public PanelCadastroCentroCusto getPanelCadastroCentroCusto() {
		return panelCadastroCentroCusto;
	}

	public PanelCadastroCentroCusto getPanelCentroCustoCadastro() {
		return panelCadastroCentroCusto;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("CENTRO DE CUSTO");
		setIconImage(Imagem.getLogoTipoImage());
		panelCadastroCentroCusto = new PanelCadastroCentroCusto();
		panelCadastroCentroCusto.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroCentroCusto);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroCentroCusto.isAncestorOf(focused)) {
							panelCadastroCentroCusto.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGuiGerenteEventos() {
		guiGerenteEventos = new GuiGerenteEventos(this);
	}

	@Override
	public void iniciarGerenteEventos() {
		centroCustoGerenteEventos = new CentroCustoGerenteEventos();
		addWindowListener(centroCustoGerenteEventos.new Frame());
		panelCadastroCentroCusto.getToolBar().getButtonExcluiRegistro()
				.addActionListener(centroCustoGerenteEventos.new ExcluiRegistro());
		panelCadastroCentroCusto.getToolBar().getButtonNovoFrame()
				.addActionListener(centroCustoGerenteEventos.new NovoFrame());
		panelCadastroCentroCusto.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(centroCustoGerenteEventos.new PesquisaRegistro());
		panelCadastroCentroCusto.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(centroCustoGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroCentroCusto.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(centroCustoGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroCentroCusto.getToolBar().getButtonSalvar()
				.addActionListener(centroCustoGerenteEventos.new Salva());
		panelCadastroCentroCusto.getToolBar().getButtonFechar()
				.addActionListener(centroCustoGerenteEventos.new FechaJanela());
		panelCadastroCentroCusto.getToolBar().getButtonSair()
				.addActionListener(centroCustoGerenteEventos.new SaidaSistema());
		panelCadastroCentroCusto.getToolBar().getButtonAjuda().addActionListener(centroCustoGerenteEventos.new Ajuda());
		panelCadastroCentroCusto.getToolBar().getButtonHome().addActionListener(centroCustoGerenteEventos.new Home());
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
	public void iniciarTable() {
	}

	@Override
	public void limparGui() {
		panelCadastroCentroCusto.limparGui();
	}

	@Override
	public void reiniciarBox() {
	}

	public boolean validarCamposCadastro() {
		return panelCadastroCentroCusto.validarCamposCadastro();
	}
}
