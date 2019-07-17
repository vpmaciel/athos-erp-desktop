package erp.contador;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.gui.EntradaMinuscula;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Mascara;

@SuppressWarnings("serial")
public final class ContadorPc extends JPanel implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private JFormattedTextField fieldCnpj;
	private JFormattedTextField fieldCpf;
	private JTextField fieldCrc;
	private JTextField fieldEmail;
	private JFormattedTextField fieldFax;
	private JFormattedTextField fieldFone1;
	private JFormattedTextField fieldFone2;
	private JTextField fieldNome;
	private JTextField fieldSite;
	private ToolBar toolBar;

	public ContadorPc() {
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

	public JFormattedTextField getGuiCnpj() {
		return fieldCnpj;
	}

	public JFormattedTextField getGuiCpf() {
		return fieldCpf;
	}

	public JTextField getGuiCrc() {
		return fieldCrc;
	}

	public JTextField getGuiEmail() {
		return fieldEmail;
	}

	public JFormattedTextField getGuiFax() {
		return fieldFax;
	}

	public JFormattedTextField getGuiFone1() {
		return fieldFone1;
	}

	public JFormattedTextField getGuiFone2() {
		return fieldFone2;
	}

	public JTextField getGuiNome() {
		return fieldNome;
	}

	public JTextField getGuiSite() {
		return fieldSite;
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

		add(new JLabel("CRC"));

		fieldCrc = new JTextField();
		fieldCrc.setDocument(new EntradaMaiuscula(20));
		add(fieldCrc);

		add(new JLabel("CPF"));

		fieldCpf = new JFormattedTextField(Mascara.getCpf());
		add(fieldCpf);

		add(new JLabel("CNPJ"));

		fieldCnpj = new JFormattedTextField(Mascara.getCnpj());
		add(fieldCnpj);

		add(new JLabel("TELEFONE"));

		fieldFone1 = new JFormattedTextField(Mascara.getFone());
		add(fieldFone1);

		add(new JLabel("TELEFONE"));

		fieldFone2 = new JFormattedTextField(Mascara.getFone());
		add(fieldFone2);

		add(new JLabel("FAX"));

		fieldFax = new JFormattedTextField(Mascara.getFax());
		add(fieldFax);

		add(new JLabel("E-MAIL"));

		fieldEmail = new JTextField();
		fieldEmail.setDocument(new EntradaMinuscula(50));
		add(fieldEmail);

		add(new JLabel("SITE"));

		fieldSite = new JTextField();
		fieldSite.setDocument(new EntradaMinuscula(50));
		add(fieldSite);

		SpringUtilities.makeCompactGrid(this, 19, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
		setOpaque(true);
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
}
