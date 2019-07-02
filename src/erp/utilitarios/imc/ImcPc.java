package erp.utilitarios.imc;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.util.SpringUtilities;

@SuppressWarnings("serial")
public final class ImcPc extends JPanel implements Gui {

	private JComboBox<String> boxSexo;
	private ConfiguracaoGui configuracaoGui;
	private JFormattedTextField fieldAltura;
	private JFormattedTextField fieldPeso;
	private JTextField fieldResultado;

	public ImcPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JFormattedTextField getGuiAltura() {
		return fieldAltura;
	}

	public JFormattedTextField getGuiPeso() {
		return fieldPeso;
	}

	public JTextField getGuiResultado() {
		return fieldResultado;
	}

	public JComboBox<String> getGuiSexo() {
		return boxSexo;
	}

	@Override
	public void iniciarControlador() {
		
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
	
		add(new JLabel("SEXO"));

		boxSexo = new JComboBox<String>();
		boxSexo.addItem("MASCULINO");
		boxSexo.addItem("FEMININO");
		add(boxSexo);

		add(new JLabel("PESO"));

		fieldPeso = new JFormattedTextField(Sis.getNumeroFormatado());
		add(fieldPeso);

		add(new JLabel("ALTURA"));

		fieldAltura = new JFormattedTextField(Sis.getNumeroFormatado());
		add(fieldAltura);

		add(new JLabel("RESULTADO"));

		fieldResultado = new JTextField();
		fieldResultado.setDocument(new EntradaMaiuscula(50));
		fieldResultado.setEnabled(false);;
		add(fieldResultado);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 8, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
	}

	@Override
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarLayout() {
		setBorder(Sis.getBordaPainel());
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGui() {

	}

	@Override
	public void reiniciarGui() {

	}
}
