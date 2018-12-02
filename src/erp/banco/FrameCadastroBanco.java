package erp.banco;

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
public final class FrameCadastroBanco extends JFrame implements Gui {

	private BancoGerenteEventos bancoGerenteEventos;
	private GuiGerenteEventos guiGerenteEventos;
	private PanelCadastroBanco panelCadastroBanco;

	public FrameCadastroBanco() {
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

	public BancoGerenteEventos getBancoHandle() {
		return bancoGerenteEventos;
	}

	@Override
	public GuiGerenteEventos getGuiGerenteEventos() {
		return guiGerenteEventos;
	}

	public PanelCadastroBanco getPanelCadastroBanco() {
		return panelCadastroBanco;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("BANCO");
		setIconImage(Imagem.getLogoTipoImage());
		panelCadastroBanco = new PanelCadastroBanco();
		panelCadastroBanco.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroBanco);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroBanco.isAncestorOf(focused)) {
							panelCadastroBanco.scrollRectToVisible(focused.getBounds());
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
		bancoGerenteEventos = new BancoGerenteEventos();
		addWindowListener(bancoGerenteEventos.new Frame());
		panelCadastroBanco.getToolBar().getButtonExcluiRegistro()
				.addActionListener(bancoGerenteEventos.new ExcluiRegistro());
		panelCadastroBanco.getToolBar().getButtonNovoFrame().addActionListener(bancoGerenteEventos.new NovoFrame());
		panelCadastroBanco.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(bancoGerenteEventos.new PesquisaRegistro());
		panelCadastroBanco.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(bancoGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroBanco.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(bancoGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroBanco.getToolBar().getButtonSalvar().addActionListener(bancoGerenteEventos.new Salva());
		panelCadastroBanco.getToolBar().getButtonFechar().addActionListener(bancoGerenteEventos.new FechaJanela());
		panelCadastroBanco.getToolBar().getButtonSair().addActionListener(bancoGerenteEventos.new SaidaSistema());
		panelCadastroBanco.getToolBar().getButtonAjuda().addActionListener(bancoGerenteEventos.new Ajuda());
		panelCadastroBanco.getToolBar().getButtonHome().addActionListener(bancoGerenteEventos.new Home());
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
		panelCadastroBanco.limparGui();
	}

	@Override
	public void reiniciarBox() {
		panelCadastroBanco.reiniciarBox();
	}

	public boolean validarCamposCadastro() {
		return panelCadastroBanco.validarCamposCadastro();
	}
}
