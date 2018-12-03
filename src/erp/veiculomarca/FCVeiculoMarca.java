package erp.veiculo.marca;

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
public final class FrameCadastroVeiculoMarca extends JFrame implements Gui {

	private VeiculoMarcaGerenteEventos veiculoMarcaGerenteEventos;
	private GuiGerenteEventos guiGerenteEventos;
	private PanelCadastroVeiculoMarca panelCadastroVeiculoMarca;

	public FrameCadastroVeiculoMarca() {
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

	@Override
	public GuiGerenteEventos getGuiGerenteEventos() {
		return guiGerenteEventos;
	}

	public PanelCadastroVeiculoMarca getPanelCadastroVeiculoMarca() {
		return panelCadastroVeiculoMarca;
	}

	public VeiculoMarcaGerenteEventos getVeiculoMarcaHandle() {
		return veiculoMarcaGerenteEventos;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("VEÍCULO - MARCA");
		setIconImage(Imagem.getLogoTipoImage());
		panelCadastroVeiculoMarca = new PanelCadastroVeiculoMarca();
		panelCadastroVeiculoMarca.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroVeiculoMarca);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroVeiculoMarca.isAncestorOf(focused)) {
							panelCadastroVeiculoMarca.scrollRectToVisible(focused.getBounds());
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
		veiculoMarcaGerenteEventos = new VeiculoMarcaGerenteEventos();
		addWindowListener(veiculoMarcaGerenteEventos.new Frame());
		panelCadastroVeiculoMarca.getToolBar().getButtonExcluiRegistro()
				.addActionListener(veiculoMarcaGerenteEventos.new ExcluiRegistro());
		panelCadastroVeiculoMarca.getToolBar().getButtonNovoFrame()
				.addActionListener(veiculoMarcaGerenteEventos.new NovoFrame());
		panelCadastroVeiculoMarca.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(veiculoMarcaGerenteEventos.new PesquisaRegistro());
		panelCadastroVeiculoMarca.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(veiculoMarcaGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroVeiculoMarca.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(veiculoMarcaGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroVeiculoMarca.getToolBar().getButtonSalvar()
				.addActionListener(veiculoMarcaGerenteEventos.new Salva());
		panelCadastroVeiculoMarca.getToolBar().getButtonFechar()
				.addActionListener(veiculoMarcaGerenteEventos.new FechaJanela());
		panelCadastroVeiculoMarca.getToolBar().getButtonSair()
				.addActionListener(veiculoMarcaGerenteEventos.new SaidaSistema());
		panelCadastroVeiculoMarca.getToolBar().getButtonAjuda()
				.addActionListener(veiculoMarcaGerenteEventos.new Ajuda());
		panelCadastroVeiculoMarca.getToolBar().getButtonHome().addActionListener(veiculoMarcaGerenteEventos.new Home());
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
		guiGerenteEventos.limparGui();
	}

	@Override
	public void reiniciarBox() {

	}
}
