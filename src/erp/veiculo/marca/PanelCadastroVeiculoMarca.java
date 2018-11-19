package erp.veiculo.marca;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import erp.aop.gui.FocusTabListener;
import erp.aop.gui.Gui;
import erp.aop.gui.GuiHandle;
import erp.aop.gui.TamanhoUpperCase;
import erp.aop.gui.registro.ToolBar;
import erp.aop.util.SpringUtilities;

@SuppressWarnings("serial")
public final class PanelCadastroVeiculoMarca extends JPanel implements Gui {

	private ToolBar toolBar;
	private GuiHandle guiHandle;

	private JTextField textFieldMarca;
	private JLabel labelMarca;

	public PanelCadastroVeiculoMarca() {
		iniciarLayout();
		iniciarGui();
		iniciarFocusTabListener();
		iniciarGuiGerenteEventos();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public JTextField getTextFieldMarca() {
		return textFieldMarca;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		toolBar = new ToolBar();

		this.add(toolBar.getToolBar());

		labelMarca = new JLabel("CHASSI");
		add(labelMarca);

		textFieldMarca = new JTextField();
		textFieldMarca.setDocument(new TamanhoUpperCase(20));
		add(textFieldMarca);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 3, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
	}

	@Override
	public void iniciarGuiGerenteEventos() {
		guiHandle = new GuiHandle(this);
	}

	@Override
	public void iniciarGerenteEventos() {

	}

	@Override
	public void iniciarLayout() {
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTable() {

	}

	@Override
	public void limparGui() {

	}

	@Override
	public void reiniciarBox() {

	}
}
