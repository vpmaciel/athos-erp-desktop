package erp.contador;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.Gui;
import arquitetura.gui.GuiHandle;
import arquitetura.gui.TamanhoLowerCase;
import arquitetura.gui.TamanhoUpperCase;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;

@SuppressWarnings("serial")
public final class PanelCadastroContador extends JPanel implements Gui {

	private JTextField textFieldCnpj;
	private JTextField textFieldCpf;
	private JTextField textFieldCrc;
	private JTextField textFieldNome;
	private GuiHandle guiHandle;
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

	public PanelCadastroContador() {
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

	public JTextField getTextFieldCnpj() {
		return textFieldCnpj;
	}

	public JTextField getTextFieldCpf() {
		return textFieldCpf;
	}

	public JTextField getTextFieldCrc() {
		return textFieldCrc;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JTextField getTextFieldFax() {
		return textFieldFax;
	}

	public JTextField getTextFieldFone1() {
		return textFieldFone1;
	}

	public JTextField getTextFieldFone2() {
		return textFieldFone2;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JTextField getTextFieldSite() {
		return textFieldSite;
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
		guiHandle.limparGui();
	}

	@Override
	public void reiniciarBox() {

	}
}
