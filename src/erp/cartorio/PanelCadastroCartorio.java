package erp.cartorio;

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
public final class PanelCadastroCartorio extends JPanel implements Gui {

	private GuiHandle guiHandle;
	private JTextField textFieldComarca;
	private JTextField textFieldNomeFantasia;
	private JTextField textFieldRazaoSocial;
	private JTextField textFieldDistrito;
	private JTextField textFieldTitular;
	private JTextField textFieldSubstituto;
	private JTextField textFieldCNPJ;
	private JTextField textFieldMunicipio;
	private JLabel labelComarca;
	private JLabel labelNomeFantasia;
	private JLabel labelRazaoSocial;
	private JLabel labelDistrito;
	private JLabel labelTitular;
	private JLabel labelSubstituto;
	private JLabel labelCNPJ;
	private JLabel labelMunicipio;
	private JTextField textFieldFax;
	private JTextField textFieldFone1;
	private JTextField textFieldFone2;
	private JTextField textFieldSite;
	private JTextField textFieldEmail;
	private JLabel labelFax;
	private JLabel labelFone1;
	private JLabel labelFone2;
	private JLabel labelSite;
	private JLabel labelEmail;
	private JTextField textFieldBairro;
	private JTextField textFieldCep;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField textFieldLogradouro;
	private JTextField textFieldPais;
	private JTextField textFieldComplemento;
	private JLabel labelBairro;
	private JLabel labelCep;
	private JLabel labelCidade;
	private JLabel labelComplemento;
	private JLabel labelEstado;
	private JLabel labelLogradouro;
	private JLabel labelPais;
	private ToolBar toolBar;

	public PanelCadastroCartorio() {
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

	public JLabel getLabelBairro() {
		return labelBairro;
	}

	public JLabel getLabelCep() {
		return labelCep;
	}

	public JLabel getLabelCidade() {
		return labelCidade;
	}

	public JLabel getLabelCNPJ() {
		return labelCNPJ;
	}

	public JLabel getLabelComarca() {
		return labelComarca;
	}

	public JLabel getLabelComplemento() {
		return labelComplemento;
	}

	public JLabel getLabelDistrito() {
		return labelDistrito;
	}

	public JLabel getLabelEmail() {
		return labelEmail;
	}

	public JLabel getLabelEstado() {
		return labelEstado;
	}

	public JLabel getLabelFax() {
		return labelFax;
	}

	public JLabel getLabelFone1() {
		return labelFone1;
	}

	public JLabel getLabelFone2() {
		return labelFone2;
	}

	public JLabel getLabelLogradouro() {
		return labelLogradouro;
	}

	public JLabel getLabelMunicipio() {
		return labelMunicipio;
	}

	public JLabel getLabelNomeFantasia() {
		return labelNomeFantasia;
	}

	public JLabel getLabelPais() {
		return labelPais;
	}

	public JLabel getLabelRazaoSocial() {
		return labelRazaoSocial;
	}

	public JLabel getLabelSite() {
		return labelSite;
	}

	public JLabel getLabelSubstituto() {
		return labelSubstituto;
	}

	public JLabel getLabelTitular() {
		return labelTitular;
	}

	public JTextField getTextFieldBairro() {
		return textFieldBairro;
	}

	public JTextField getTextFieldCep() {
		return textFieldCep;
	}

	public JTextField getTextFieldCidade() {
		return textFieldCidade;
	}

	public JTextField getTextFieldCNPJ() {
		return textFieldCNPJ;
	}

	public JTextField getTextFieldComarca() {
		return textFieldComarca;
	}

	public JTextField getTextFieldComplemento() {
		return textFieldComplemento;
	}

	public JTextField getTextFieldDistrito() {
		return textFieldDistrito;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JTextField getTextFieldEstado() {
		return textFieldEstado;
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

	public JTextField getTextFieldLogradouro() {
		return textFieldLogradouro;
	}

	public JTextField getTextFieldMunicipio() {
		return textFieldMunicipio;
	}

	public JTextField getTextFieldNomeFantasia() {
		return textFieldNomeFantasia;
	}

	public JTextField getTextFieldPais() {
		return textFieldPais;
	}

	public JTextField getTextFieldRazaoSocial() {
		return textFieldRazaoSocial;
	}

	public JTextField getTextFieldSite() {
		return textFieldSite;
	}

	public JTextField getTextFieldSubstituto() {
		return textFieldSubstituto;
	}

	public JTextField getTextFieldTitular() {
		return textFieldTitular;
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
		labelNomeFantasia = new JLabel("NOME FANTASIA");
		add(labelNomeFantasia);
		textFieldNomeFantasia = new JTextField();
		textFieldNomeFantasia.setDocument(new TamanhoUpperCase(50));
		add(textFieldNomeFantasia);
		labelRazaoSocial = new JLabel("RAZÃO SOCIAL");
		add(labelRazaoSocial);
		textFieldRazaoSocial = new JTextField();
		textFieldRazaoSocial.setDocument(new TamanhoUpperCase(50));
		add(textFieldRazaoSocial);
		labelComarca = new JLabel("COMARCA");
		add(labelComarca);
		textFieldComarca = new JTextField();
		textFieldComarca.setDocument(new TamanhoUpperCase(50));
		add(textFieldComarca);
		labelMunicipio = new JLabel("MUNICÍPIO");
		add(labelMunicipio);
		textFieldMunicipio = new JTextField();
		textFieldMunicipio.setDocument(new TamanhoUpperCase(50));
		add(textFieldMunicipio);
		labelDistrito = new JLabel("DISTRITO");
		add(labelDistrito);
		textFieldDistrito = new JTextField();
		textFieldDistrito.setDocument(new TamanhoUpperCase(50));
		add(textFieldDistrito);
		labelTitular = new JLabel("TITULAR");
		add(labelTitular);
		textFieldTitular = new JTextField();
		textFieldTitular.setDocument(new TamanhoUpperCase(50));
		add(textFieldTitular);
		labelSubstituto = new JLabel("SUBISTITUTO");
		add(labelSubstituto);
		textFieldSubstituto = new JTextField();
		textFieldSubstituto.setDocument(new TamanhoUpperCase(50));
		add(textFieldSubstituto);
		labelCNPJ = new JLabel("CNPJ");
		add(labelCNPJ);
		textFieldCNPJ = new JTextField();
		textFieldCNPJ.setDocument(new TamanhoUpperCase(19));
		add(textFieldCNPJ);
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
		labelPais = new JLabel("PAÍS");
		add(labelPais);
		textFieldPais = new JTextField();
		textFieldPais.setDocument(new TamanhoUpperCase(50));
		add(textFieldPais);
		labelEstado = new JLabel("ESTADO");
		add(labelEstado);
		textFieldEstado = new JTextField();
		textFieldEstado.setDocument(new TamanhoUpperCase(50));
		add(textFieldEstado);
		labelCidade = new JLabel("CIDADE");
		add(labelCidade);
		textFieldCidade = new JTextField();
		textFieldCidade.setDocument(new TamanhoUpperCase(50));
		add(textFieldCidade);
		labelBairro = new JLabel("BAIRRO");
		add(labelBairro);
		textFieldBairro = new JTextField();
		textFieldBairro.setDocument(new TamanhoUpperCase(50));
		add(textFieldBairro);
		labelLogradouro = new JLabel("LOGRADOURO");
		add(labelLogradouro);
		textFieldLogradouro = new JTextField();
		textFieldLogradouro.setDocument(new TamanhoUpperCase(50));
		add(textFieldLogradouro);
		labelComplemento = new JLabel("COMPLEMENTO");
		add(labelComplemento);
		textFieldComplemento = new JTextField();
		textFieldComplemento.setDocument(new TamanhoUpperCase(20));
		add(textFieldComplemento);
		labelCep = new JLabel("CEP");
		add(labelCep);
		textFieldCep = new JTextField(10);
		textFieldCep.setDocument(new TamanhoUpperCase(10));
		add(textFieldCep);
		SpringUtilities.makeCompactGrid(this, 41, 1, 5, 5, 5, 5);
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
