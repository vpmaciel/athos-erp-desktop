package erp.veiculo.modelo;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import erp.aop.gui.FocusTabListener;
import erp.aop.gui.Gui;
import erp.aop.gui.GuiHandle;
import erp.aop.gui.Imagem;

@SuppressWarnings("serial")
public final class FrameCadastroVeiculoModelo extends JFrame implements Gui {

	private VeiculoModeloGerenteEventos veiculoModeloGerenteEventos;
	private GuiHandle guiHandle;
	private PanelCadastroVeiculoModelo panelCadastroVeiculoModelo;

	public FrameCadastroVeiculoModelo() {
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
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public PanelCadastroVeiculoModelo getPanelCadastroVeiculoModelo() {
		return panelCadastroVeiculoModelo;
	}

	public VeiculoModeloGerenteEventos getVeiculoModeloHandle() {
		return veiculoModeloGerenteEventos;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("VEÍCULO - MODELO");
		setIconImage(Imagem.getLogoTipoImage());
		panelCadastroVeiculoModelo = new PanelCadastroVeiculoModelo();
		panelCadastroVeiculoModelo.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroVeiculoModelo);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroVeiculoModelo.isAncestorOf(focused)) {
							panelCadastroVeiculoModelo.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();

	}

	@Override
	public void iniciarGuiGerenteEventos() {
		guiHandle = new GuiHandle(this);
	}

	@Override
	public void iniciarGerenteEventos() {
		veiculoModeloGerenteEventos = new VeiculoModeloGerenteEventos();
		addWindowListener(veiculoModeloGerenteEventos.new Frame());
		panelCadastroVeiculoModelo.getToolBar().getButtonExcluiRegistro()
				.addActionListener(veiculoModeloGerenteEventos.new ExcluiRegistro());
		panelCadastroVeiculoModelo.getToolBar().getButtonNovoFrame()
				.addActionListener(veiculoModeloGerenteEventos.new NovoFrame());
		panelCadastroVeiculoModelo.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(veiculoModeloGerenteEventos.new PesquisaRegistro());
		panelCadastroVeiculoModelo.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(veiculoModeloGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroVeiculoModelo.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(veiculoModeloGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroVeiculoModelo.getToolBar().getButtonSalvar().addActionListener(veiculoModeloGerenteEventos.new Salva());
		panelCadastroVeiculoModelo.getToolBar().getButtonFechar()
				.addActionListener(veiculoModeloGerenteEventos.new FechaJanela());
		panelCadastroVeiculoModelo.getToolBar().getButtonSair()
				.addActionListener(veiculoModeloGerenteEventos.new SaidaSistema());
		panelCadastroVeiculoModelo.getToolBar().getButtonAjuda().addActionListener(veiculoModeloGerenteEventos.new Ajuda());
		panelCadastroVeiculoModelo.getToolBar().getButtonHome().addActionListener(veiculoModeloGerenteEventos.new Home());
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
		guiHandle.limparGui();
	}

	@Override
	public void reiniciarBox() {

	}
}
