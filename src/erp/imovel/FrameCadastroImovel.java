package erp.imovel;

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
public final class FrameCadastroImovel extends JFrame implements Gui {

	private ImovelGerenteEventos imovelGerenteEventos;
	private GuiGerenteEventos guiGerenteEventos;
	private PanelCadastroImovel panelCadastroImovel;

	public FrameCadastroImovel() {
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

	public ImovelGerenteEventos getImovelHandle() {
		return imovelGerenteEventos;
	}

	public PanelCadastroImovel getPanelCadastroImovel() {
		return panelCadastroImovel;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("Imóveis");
		setIconImage(Imagem.getLogoTipoImage());
		panelCadastroImovel = new PanelCadastroImovel();
		panelCadastroImovel.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroImovel);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroImovel.isAncestorOf(focused)) {
							panelCadastroImovel.scrollRectToVisible(focused.getBounds());
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
		imovelGerenteEventos = new ImovelGerenteEventos();
		addWindowListener(imovelGerenteEventos.new Frame());
		panelCadastroImovel.getToolBar().getButtonExcluiRegistro()
				.addActionListener(imovelGerenteEventos.new ExcluiRegistro());
		panelCadastroImovel.getToolBar().getButtonNovoFrame().addActionListener(imovelGerenteEventos.new NovoFrame());
		panelCadastroImovel.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(imovelGerenteEventos.new PesquisaRegistro());
		panelCadastroImovel.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(imovelGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroImovel.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(imovelGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroImovel.getToolBar().getButtonSalvar().addActionListener(imovelGerenteEventos.new Salva());
		panelCadastroImovel.getToolBar().getButtonFechar().addActionListener(imovelGerenteEventos.new FechaJanela());
		panelCadastroImovel.getToolBar().getButtonSair().addActionListener(imovelGerenteEventos.new SaidaSistema());
		panelCadastroImovel.getToolBar().getButtonAjuda().addActionListener(imovelGerenteEventos.new Ajuda());
		panelCadastroImovel.getToolBar().getButtonHome().addActionListener(imovelGerenteEventos.new Home());
	}

	@Override
	public void iniciarLayout() {
		setLayout(null);
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
