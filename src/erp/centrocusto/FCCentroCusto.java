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
import arquitetura.gui.GUI;
import arquitetura.gui.GUIConfiguracao;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FCCentroCusto extends JFrame implements GUI {

	private CentroCustoControlador centroCustoControlador;
	private GUIConfiguracao gUIConfiguracao;
	private PCCentroCusto pCCentroCusto;

	public FCCentroCusto() {
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

	public void desabilitarGui() {
	}

	public CentroCustoControlador getCentroCustoHandle() {
		return centroCustoControlador;
	}

	@Override
	public GUIConfiguracao getGUIConfiguracao() {
		return gUIConfiguracao;
	}

	public PCCentroCusto getPanelCadastroCentroCusto() {
		return pCCentroCusto;
	}

	public PCCentroCusto getPanelCentroCustoCadastro() {
		return pCCentroCusto;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("CENTRO DE CUSTO");
		setIconImage(Imagem.getLogoTipoImage());
		pCCentroCusto = new PCCentroCusto();
		pCCentroCusto.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCCentroCusto);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCCentroCusto.isAncestorOf(focused)) {
							pCCentroCusto.scrollRectToVisible(focused.getBounds());
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
		centroCustoControlador = new CentroCustoControlador();
		addWindowListener(centroCustoControlador.new Frame());
		pCCentroCusto.getToolBar().getButtonExcluiRegistro()
				.addActionListener(centroCustoControlador.new ExcluiRegistro());
		pCCentroCusto.getToolBar().getButtonNovoFrame()
				.addActionListener(centroCustoControlador.new NovoFrame());
		pCCentroCusto.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(centroCustoControlador.new PesquisaRegistro());
		pCCentroCusto.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(centroCustoControlador.new ImprimiUnicoRegistro());
		pCCentroCusto.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(centroCustoControlador.new ImprimiTodosRegistros());
		pCCentroCusto.getToolBar().getButtonSalvar()
				.addActionListener(centroCustoControlador.new Salva());
		pCCentroCusto.getToolBar().getButtonFechar()
				.addActionListener(centroCustoControlador.new FechaJanela());
		pCCentroCusto.getToolBar().getButtonSair()
				.addActionListener(centroCustoControlador.new SaidaSistema());
		pCCentroCusto.getToolBar().getButtonAjuda().addActionListener(centroCustoControlador.new Ajuda());
		pCCentroCusto.getToolBar().getButtonHome().addActionListener(centroCustoControlador.new Home());
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
		pCCentroCusto.limparGUI();
	}

	@Override
	public void reiniciarGUI() {
	}

	public boolean validarCamposCadastro() {
		return pCCentroCusto.validarCamposCadastro();
	}
}
