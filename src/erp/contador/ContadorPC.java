package erp.contador;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.GUI;
import arquitetura.gui.ConfiguracaoGUI;
import arquitetura.gui.TamanhoLowerCase;
import arquitetura.gui.TamanhoUpperCase;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;

@SuppressWarnings("serial")
public final class ContadorPC extends JPanel implements GUI {

	private JTextField textFieldCnpj;
	private JTextField textFieldCpf;
	private JTextField textFieldCrc;
	private JTextField textFieldNome;
	private ConfiguracaoGUI configuracaoGUI;
	private JLabel labelCnpj;
	private JLabel labelCpf;
	private JLabel labelCrc;
	private JLabel labelNome;
	private JTextField textFieldEmail;
	private JTextField textFieldFax;
	private JTextField textFieldFone1;
	private JTextField textFieldFone2;
	private JTextField textFieldSite;
	private JLabel labelFone2;
	private JLabel labelEmail;
	private JLabel labelSite;
	private JLabel labelFax;
	private JLabel labelFone1;
	private ToolBar toolBar;

	public ContadorPC() {
		iniciarLayout();
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public JTextField getCnpjGUI() {
		return textFieldCnpj;
	}

	public JTextField getCpfGUI() {
		return textFieldCpf;
	}

	public JTextField getCrcGUI() {
		return textFieldCrc;
	}

	public JTextField getEmailGUI() {
		return textFieldEmail;
	}

	public JTextField getFaxGUI() {
		return textFieldFax;
	}

	public JTextField getFone1GUI() {
		return textFieldFone1;
	}

	public JTextField getFone2GUI() {
		return textFieldFone2;
	}

	public JTextField getNomeGUI() {
		return textFieldNome;
	}

	public JTextField getSiteGUI() {
		return textFieldSite;
	}

	public ToolBar getTB() {
		return toolBar;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		toolBar = new ToolBar();

		add(toolBar.getToolBar());
		labelNome = new JLabel("NOME");
		add(labelNome);
		textFieldNome = new JTextField();
		textFieldNome.setDocument(new TamanhoUpperCase(50));
		add(textFieldNome);
		labelCrc = new JLabel("CRC");
		add(labelCrc);
		textFieldCrc = new JTextField();
		textFieldCrc.setDocument(new TamanhoUpperCase(20));
		add(textFieldCrc);
		labelCpf = new JLabel("CPF");
		labelCpf.setBounds(10, 90, 70, 35);
		add(labelCpf);
		textFieldCpf = new JTextField();
		textFieldCpf.setDocument(new TamanhoUpperCase(14));
		add(textFieldCpf);
		labelCnpj = new JLabel("CNPJ");
		add(labelCnpj);
		textFieldCnpj = new JTextField();
		textFieldCnpj.setDocument(new TamanhoUpperCase(19));
		add(textFieldCnpj);
		labelFone1 = new JLabel("TELEFONE");
		add(labelFone1);
		textFieldFone1 = new JTextField();
		textFieldFone1.setDocument(new TamanhoUpperCase(20));
		add(textFieldFone1);
		labelFone2 = new JLabel("TELEFONE");
		add(labelFone2);
		textFieldFone2 = new JTextField();
		textFieldFone2.setDocument(new TamanhoUpperCase(20));
		add(textFieldFone2);
		labelFax = new JLabel("FAX");
		add(labelFax);
		textFieldFax = new JTextField();
		textFieldFax.setDocument(new TamanhoUpperCase(20));
		add(textFieldFax);
		labelEmail = new JLabel("E-MAIL");
		add(labelEmail);
		textFieldEmail = new JTextField();
		textFieldEmail.setDocument(new TamanhoLowerCase(50));
		add(textFieldEmail);
		labelSite = new JLabel("SITE");
		add(labelSite);
		textFieldSite = new JTextField();
		textFieldSite.setDocument(new TamanhoLowerCase(50));
		add(textFieldSite);
		SpringUtilities.makeCompactGrid(this, 19, 1, 5, 5, 5, 5);
		setOpaque(true);
	}

	@Override
	public void iniciarGUIControlador() {
		configuracaoGUI = new ConfiguracaoGUI(this);
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
		configuracaoGUI.limparGui();
	}

	@Override
	public void reiniciarGUI() {

	}
}