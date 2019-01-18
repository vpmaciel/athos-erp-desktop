package erp.contador;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.gui.EntradaMinuscula;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Mascara;

@SuppressWarnings("serial")
public final class ContadorPc extends JPanel implements Gui {

	private JFormattedTextField textFieldCnpj;
	private JFormattedTextField textFieldCpf;
	private JTextField textFieldCrc;
	private JTextField textFieldNome;
	private ConfiguracaoGui configuracaoGui;
	private JLabel labelCnpj;
	private JLabel labelCpf;
	private JLabel labelCrc;
	private JLabel labelNome;
	private JTextField textFieldEmail;
	private JFormattedTextField textFieldFax;
	private JFormattedTextField textFieldFone1;
	private JFormattedTextField textFieldFone2;
	private JTextField textFieldSite;
	private JLabel labelFone2;
	private JLabel labelEmail;
	private JLabel labelSite;
	private JLabel labelFax;
	private JLabel labelFone1;
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

	public JFormattedTextField getCnpjGui() {
		return textFieldCnpj;
	}

	public JFormattedTextField getCpfGui() {
		return textFieldCpf;
	}

	public JTextField getCrcGui() {
		return textFieldCrc;
	}

	public JTextField getEmailGui() {
		return textFieldEmail;
	}

	public JFormattedTextField getFaxGui() {
		return textFieldFax;
	}

	public JFormattedTextField getFone1Gui() {
		return textFieldFone1;
	}

	public JFormattedTextField getFone2Gui() {
		return textFieldFone2;
	}

	public JTextField getNomeGui() {
		return textFieldNome;
	}

	public JTextField getSiteGui() {
		return textFieldSite;
	}

	public ToolBar getTB() {
		return toolBar;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		toolBar = new ToolBar();

		add(toolBar.getToolBar());
		labelNome = new JLabel("NOME");
		add(labelNome);
		textFieldNome = new JTextField();
		textFieldNome.setDocument(new EntradaMaiuscula(50));
		add(textFieldNome);
		labelCrc = new JLabel("CRC");
		add(labelCrc);
		textFieldCrc = new JTextField();
		textFieldCrc.setDocument(new EntradaMaiuscula(20));
		add(textFieldCrc);
		labelCpf = new JLabel("CPF");
		labelCpf.setBounds(10, 90, 70, 35);
		add(labelCpf);
		textFieldCpf = new JFormattedTextField(Mascara.getCpf());
		add(textFieldCpf);
		labelCnpj = new JLabel("CNPJ");
		add(labelCnpj);
		textFieldCnpj = new JFormattedTextField(Mascara.getCnpj());
		add(textFieldCnpj);
		labelFone1 = new JLabel("TELEFONE");
		add(labelFone1);
		textFieldFone1 = new JFormattedTextField(Mascara.getFone());
		add(textFieldFone1);
		labelFone2 = new JLabel("TELEFONE");
		add(labelFone2);
		textFieldFone2 = new JFormattedTextField(Mascara.getFone());
		add(textFieldFone2);
		labelFax = new JLabel("FAX");
		add(labelFax);
		textFieldFax = new JFormattedTextField(Mascara.getFax());
		add(textFieldFax);
		labelEmail = new JLabel("E-MAIL");
		add(labelEmail);
		textFieldEmail = new JTextField();
		textFieldEmail.setDocument(new EntradaMinuscula(50));
		add(textFieldEmail);
		labelSite = new JLabel("SITE");
		add(labelSite);
		textFieldSite = new JTextField();
		textFieldSite.setDocument(new EntradaMinuscula(50));
		add(textFieldSite);
		SpringUtilities.makeCompactGrid(this, 19, 1, 5, 5, 5, 5);
		setOpaque(true);
	}

	@Override
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {

	}

	@Override
	public void iniciarLayout() {
		setBorder(BorderFactory.createTitledBorder("CONTADOR"));
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
