package erp.contador;

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
public final class FCContador extends JFrame implements GUI {

	private ContadorControlador contadorControlador;
	private GUIConfiguracao gUIConfiguracao;
	private PCContador pCContador;

	public FCContador() {
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

	public ContadorControlador getContadorHandle() {
		return contadorControlador;
	}

	@Override
	public GUIConfiguracao getGUIConfiguracao() {
		return gUIConfiguracao;
	}

	public PCContador getPanelCadastroContador() {
		return pCContador;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {

		setTitle("CONTADOR");
		setIconImage(Imagem.getLogoTipoImage());
		pCContador = new PCContador();
		pCContador.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCContador);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCContador.isAncestorOf(focused)) {
							pCContador.scrollRectToVisible(focused.getBounds());
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
		contadorControlador = new ContadorControlador();
		addWindowListener(contadorControlador.new Frame());
		pCContador.getToolBar().getButtonExcluiRegistro()
				.addActionListener(contadorControlador.new ExcluiRegistro());
		pCContador.getToolBar().getButtonNovoFrame()
				.addActionListener(contadorControlador.new NovoFrame());
		pCContador.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(contadorControlador.new PesquisaRegistro());
		pCContador.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(contadorControlador.new ImprimiUnicoRegistro());
		pCContador.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(contadorControlador.new ImprimiTodosRegistros());
		pCContador.getToolBar().getButtonSalvar().addActionListener(contadorControlador.new Salva());
		pCContador.getToolBar().getButtonFechar()
				.addActionListener(contadorControlador.new FechaJanela());
		pCContador.getToolBar().getButtonSair().addActionListener(contadorControlador.new SaidaSistema());
		pCContador.getToolBar().getButtonAjuda().addActionListener(contadorControlador.new Ajuda());
		pCContador.getToolBar().getButtonHome().addActionListener(contadorControlador.new Home());
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
