package erp.veiculo.modelo;

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
public final class FCVeiculoModelo extends JFrame implements GUI {

	private VeiculoModeloControlador veiculoModeloControlador;
	private GUIConfiguracao gUIConfiguracao;
	private PCVeiculoModelo pCVeiculoModelo;

	public FCVeiculoModelo() {
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

	public PCVeiculoModelo getPanelCadastroVeiculoModelo() {
		return pCVeiculoModelo;
	}

	public VeiculoModeloControlador getVeiculoModeloHandle() {
		return veiculoModeloControlador;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("VEÍCULO - MODELO");
		setIconImage(Imagem.getLogoTipoImage());
		pCVeiculoModelo = new PCVeiculoModelo();
		pCVeiculoModelo.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCVeiculoModelo);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCVeiculoModelo.isAncestorOf(focused)) {
							pCVeiculoModelo.scrollRectToVisible(focused.getBounds());
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
		veiculoModeloControlador = new VeiculoModeloControlador();
		addWindowListener(veiculoModeloControlador.new Frame());
		pCVeiculoModelo.getToolBar().getButtonExcluiRegistro()
				.addActionListener(veiculoModeloControlador.new ExcluiRegistro());
		pCVeiculoModelo.getToolBar().getButtonNovoFrame()
				.addActionListener(veiculoModeloControlador.new NovoFrame());
		pCVeiculoModelo.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(veiculoModeloControlador.new PesquisaRegistro());
		pCVeiculoModelo.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(veiculoModeloControlador.new ImprimiUnicoRegistro());
		pCVeiculoModelo.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(veiculoModeloControlador.new ImprimiTodosRegistros());
		pCVeiculoModelo.getToolBar().getButtonSalvar()
				.addActionListener(veiculoModeloControlador.new Salva());
		pCVeiculoModelo.getToolBar().getButtonFechar()
				.addActionListener(veiculoModeloControlador.new FechaJanela());
		pCVeiculoModelo.getToolBar().getButtonSair()
				.addActionListener(veiculoModeloControlador.new SaidaSistema());
		pCVeiculoModelo.getToolBar().getButtonAjuda()
				.addActionListener(veiculoModeloControlador.new Ajuda());
		pCVeiculoModelo.getToolBar().getButtonHome()
				.addActionListener(veiculoModeloControlador.new Home());
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
