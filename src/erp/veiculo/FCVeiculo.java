package erp.veiculo;

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
public final class FCVeiculo extends JFrame implements GUI {

	private VeiculoControlador veiculoControlador;
	private GUIConfiguracao gUIConfiguracao;
	private PCVeiculo pCVeiculo;

	public FCVeiculo() {
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
		return gUIConfiguracao;
	}

	public PCVeiculo getPanelCadastroVeiculo() {
		return pCVeiculo;
	}

	public VeiculoControlador getVeiculoGerenteEventos() {
		return veiculoControlador;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("VEÍCULO");
		setIconImage(Imagem.getLogoTipoImage());
		pCVeiculo = new PCVeiculo();
		pCVeiculo.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCVeiculo);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCVeiculo.isAncestorOf(focused)) {
							pCVeiculo.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();

	}

	@Override
	public void iniciarGUIControlador() {
		gUIConfiguracao = new GUIConfiguracao(this);
	}

	@Override
	public void iniciarControlador() {
		veiculoControlador = new VeiculoControlador();
		addWindowListener(veiculoControlador.new Frame());
		pCVeiculo.getToolBar().getButtonExcluiRegistro()
				.addActionListener(veiculoControlador.new ExcluiRegistro());
		pCVeiculo.getToolBar().getButtonNovoFrame().addActionListener(veiculoControlador.new NovoFrame());
		pCVeiculo.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(veiculoControlador.new PesquisaRegistro());
		pCVeiculo.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(veiculoControlador.new ImprimiUnicoRegistro());
		pCVeiculo.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(veiculoControlador.new ImprimiTodosRegistros());
		pCVeiculo.getToolBar().getButtonSalvar().addActionListener(veiculoControlador.new Salva());
		pCVeiculo.getToolBar().getButtonFechar().addActionListener(veiculoControlador.new FechaJanela());
		pCVeiculo.getToolBar().getButtonSair().addActionListener(veiculoControlador.new SaidaSistema());
		pCVeiculo.getToolBar().getButtonAjuda().addActionListener(veiculoControlador.new Ajuda());
		pCVeiculo.getToolBar().getButtonHome().addActionListener(veiculoControlador.new Home());
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
		gUIConfiguracao.limparGui();
	}

	@Override
	public void reiniciarGUI() {

	}
}
