package erp.veiculomarca;

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
public final class FCVeiculoMarca extends JFrame implements Gui {

	private VeiculoMarcaControlador veiculoMarcaControlador;
	private GuiGerenteEventos guiGerenteEventos;
	private PCVeiculoMarca pCVeiculoMarca;

	public FCVeiculoMarca() {
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

	public PCVeiculoMarca getPanelCadastroVeiculoMarca() {
		return pCVeiculoMarca;
	}

	public VeiculoMarcaControlador getVeiculoMarcaHandle() {
		return veiculoMarcaControlador;
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
		pCVeiculoMarca = new PCVeiculoMarca();
		pCVeiculoMarca.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCVeiculoMarca);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCVeiculoMarca.isAncestorOf(focused)) {
							pCVeiculoMarca.scrollRectToVisible(focused.getBounds());
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
		veiculoMarcaControlador = new VeiculoMarcaControlador();
		addWindowListener(veiculoMarcaControlador.new Frame());
		pCVeiculoMarca.getToolBar().getButtonExcluiRegistro()
				.addActionListener(veiculoMarcaControlador.new ExcluiRegistro());
		pCVeiculoMarca.getToolBar().getButtonNovoFrame()
				.addActionListener(veiculoMarcaControlador.new NovoFrame());
		pCVeiculoMarca.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(veiculoMarcaControlador.new PesquisaRegistro());
		pCVeiculoMarca.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(veiculoMarcaControlador.new ImprimiUnicoRegistro());
		pCVeiculoMarca.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(veiculoMarcaControlador.new ImprimiTodosRegistros());
		pCVeiculoMarca.getToolBar().getButtonSalvar()
				.addActionListener(veiculoMarcaControlador.new Salva());
		pCVeiculoMarca.getToolBar().getButtonFechar()
				.addActionListener(veiculoMarcaControlador.new FechaJanela());
		pCVeiculoMarca.getToolBar().getButtonSair()
				.addActionListener(veiculoMarcaControlador.new SaidaSistema());
		pCVeiculoMarca.getToolBar().getButtonAjuda()
				.addActionListener(veiculoMarcaControlador.new Ajuda());
		pCVeiculoMarca.getToolBar().getButtonHome().addActionListener(veiculoMarcaControlador.new Home());
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
