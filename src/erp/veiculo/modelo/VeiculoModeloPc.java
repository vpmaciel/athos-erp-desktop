package erp.veiculo.modelo;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;

@SuppressWarnings("serial")
public final class VeiculoModeloPc extends JPanel implements Gui {

	private ToolBar toolBar;
	private ConfiguracaoGui configuracaoGui;

	private JTextField textFieldModelo;
	private JLabel labelModelo;

	public VeiculoModeloPc() {
		iniciarLayout();
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
		return configuracaoGui;
	}

	public JTextField getTextFieldModelo() {
		return textFieldModelo;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGUI() {
		toolBar = new ToolBar();

		this.add(toolBar.getToolBar());

		labelModelo = new JLabel("MODELO");
		add(labelModelo);

		textFieldModelo = new JTextField();
		textFieldModelo.setDocument(new EntradaMaiuscula(20));
		add(textFieldModelo);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 3, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
	}

	@Override
	public void iniciarGUIControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {

	}

	@Override
	public void iniciarLayout() {
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGUI() {

	}

	@Override
	public void reiniciarGUI() {

	}
}
