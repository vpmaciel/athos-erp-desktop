package erp.banco;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Entrada;
import arquitetura.validacao.RegExp;

@SuppressWarnings("serial")
public final class BancoPc extends JPanel implements Gui {

	private BancoControl bancoControl;
	private ConfiguracaoGui configuracaoGui;
	private JTextField fieldCodigo;
	private JTextField fieldNome;
	private ToolBar toolBar;

	public BancoPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
	}

	@Override
	public void atualizarTable() {
	}

	public BancoControl getBancoCont() {
		return bancoControl;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JTextField getGuiCodigo() {
		return fieldCodigo;
	}

	public JTextField getGuiNome() {
		return fieldNome;
	}

	public ToolBar getTB() {
		return toolBar;
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
		toolBar = new ToolBar();

		add(toolBar.getTB());

		add(new JLabel("NOME"));

		fieldNome = new JTextField();
		fieldNome.setDocument(new EntradaMaiuscula(50));
		add(fieldNome);

		add(new JLabel("CÓDIGO"));

		fieldCodigo = new JTextField();
		fieldCodigo.setDocument(new EntradaMaiuscula(10));
		add(fieldCodigo);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 5, 1, // rows, cols
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
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGui() {
	}

	public boolean validarGui() {
		if (!Entrada.validar(fieldNome, "NOME", RegExp.NOME, true)) {
			return false;
		}
		if (!Entrada.validar(fieldCodigo, "CÓDIGO", RegExp.NUMERO_BANCO, false)) {
			return false;
		}
		return true;
	}
}
