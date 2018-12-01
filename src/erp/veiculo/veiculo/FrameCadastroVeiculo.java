package erp.veiculo.veiculo;

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
import arquitetura.gui.GuiHandle;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FrameCadastroVeiculo extends JFrame implements Gui {

	private VeiculoGerenteEventos veiculoGerenteEventos;
	private GuiHandle guiHandle;
	private PanelCadastroVeiculo panelCadastroVeiculo;

	public FrameCadastroVeiculo() {
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

	public PanelCadastroVeiculo getPanelCadastroVeiculo() {
		return panelCadastroVeiculo;
	}

	public VeiculoGerenteEventos getVeiculoHandle() {
		return veiculoGerenteEventos;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("VEÍCULO");
		setIconImage(Imagem.getLogoTipoImage());
		panelCadastroVeiculo = new PanelCadastroVeiculo();
		panelCadastroVeiculo.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroVeiculo);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroVeiculo.isAncestorOf(focused)) {
							panelCadastroVeiculo.scrollRectToVisible(focused.getBounds());
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
		veiculoGerenteEventos = new VeiculoGerenteEventos();
		addWindowListener(veiculoGerenteEventos.new Frame());
		panelCadastroVeiculo.getToolBar().getButtonExcluiRegistro()
				.addActionListener(veiculoGerenteEventos.new ExcluiRegistro());
		panelCadastroVeiculo.getToolBar().getButtonNovoFrame().addActionListener(veiculoGerenteEventos.new NovoFrame());
		panelCadastroVeiculo.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(veiculoGerenteEventos.new PesquisaRegistro());
		panelCadastroVeiculo.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(veiculoGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroVeiculo.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(veiculoGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroVeiculo.getToolBar().getButtonSalvar().addActionListener(veiculoGerenteEventos.new Salva());
		panelCadastroVeiculo.getToolBar().getButtonFechar().addActionListener(veiculoGerenteEventos.new FechaJanela());
		panelCadastroVeiculo.getToolBar().getButtonSair().addActionListener(veiculoGerenteEventos.new SaidaSistema());
		panelCadastroVeiculo.getToolBar().getButtonAjuda().addActionListener(veiculoGerenteEventos.new Ajuda());
		panelCadastroVeiculo.getToolBar().getButtonHome().addActionListener(veiculoGerenteEventos.new Home());
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
