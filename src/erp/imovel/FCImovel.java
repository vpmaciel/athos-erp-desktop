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
public final class FCImovel extends JFrame implements Gui {

	private ImovelControlador imovelControlador;
	private GuiGerenteEventos guiGerenteEventos;
	private PCImovel pCImovel;

	public FCImovel() {
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

	public ImovelControlador getImovelHandle() {
		return imovelControlador;
	}

	public PCImovel getPanelCadastroImovel() {
		return pCImovel;
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
		pCImovel = new PCImovel();
		pCImovel.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCImovel);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCImovel.isAncestorOf(focused)) {
							pCImovel.scrollRectToVisible(focused.getBounds());
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
		imovelControlador = new ImovelControlador();
		addWindowListener(imovelControlador.new Frame());
		pCImovel.getToolBar().getButtonExcluiRegistro()
				.addActionListener(imovelControlador.new ExcluiRegistro());
		pCImovel.getToolBar().getButtonNovoFrame().addActionListener(imovelControlador.new NovoFrame());
		pCImovel.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(imovelControlador.new PesquisaRegistro());
		pCImovel.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(imovelControlador.new ImprimiUnicoRegistro());
		pCImovel.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(imovelControlador.new ImprimiTodosRegistros());
		pCImovel.getToolBar().getButtonSalvar().addActionListener(imovelControlador.new Salva());
		pCImovel.getToolBar().getButtonFechar().addActionListener(imovelControlador.new FechaJanela());
		pCImovel.getToolBar().getButtonSair().addActionListener(imovelControlador.new SaidaSistema());
		pCImovel.getToolBar().getButtonAjuda().addActionListener(imovelControlador.new Ajuda());
		pCImovel.getToolBar().getButtonHome().addActionListener(imovelControlador.new Home());
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
