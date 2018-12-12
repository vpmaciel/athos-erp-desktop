package erp.cartorio;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMinuscula;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;

@SuppressWarnings("serial")
public final class CartorioPc extends JPanel implements Gui {

	private ConfiguracaoGui configuracaoGui;
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

	public CartorioPc() {
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

	public JTextField getBairroGUI() {
		return textFieldBairro;
	}

	public JTextField getCepGUI() {
		return textFieldCep;
	}

	public JTextField getCidadeGUI() {
		return textFieldCidade;
	}

	public JTextField getCnpjGUI() {
		return textFieldCNPJ;
	}

	public JTextField getComarcaGUI() {
		return textFieldComarca;
	}

	public JTextField getComplementoGUI() {
		return textFieldComplemento;
	}

	public JTextField getDistritoGUI() {
		return textFieldDistrito;
	}

	public JTextField getEmailGUI() {
		return textFieldEmail;
	}

	public JTextField getEstadoGUI() {
		return textFieldEstado;
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

	public JTextField getLogradouroGUI() {
		return textFieldLogradouro;
	}

	public JTextField getMunicipioGUI() {
		return textFieldMunicipio;
	}

	public JTextField getNomeFantasiaGUI() {
		return textFieldNomeFantasia;
	}

	public JTextField getPaisGUI() {
		return textFieldPais;
	}

	public JTextField getRazaoSocialGUI() {
		return textFieldRazaoSocial;
	}

	public JTextField getSiteGUI() {
		return textFieldSite;
	}

	public JTextField getSubstitutoGUI() {
		return textFieldSubstituto;
	}

	public JTextField getTitularGUI() {
		return textFieldTitular;
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
	public void iniciarGUI() {
		toolBar = new ToolBar();

		this.add(toolBar.getToolBar());
		labelNomeFantasia = new JLabel("NOME FANTASIA");
		add(labelNomeFantasia);
		textFieldNomeFantasia = new JTextField();
		textFieldNomeFantasia.setDocument(new EntradaMaiuscula(50));
		add(textFieldNomeFantasia);
		labelRazaoSocial = new JLabel("RAZÃO SOCIAL");
		add(labelRazaoSocial);
		textFieldRazaoSocial = new JTextField();
		textFieldRazaoSocial.setDocument(new EntradaMaiuscula(50));
		add(textFieldRazaoSocial);
		labelComarca = new JLabel("COMARCA");
		add(labelComarca);
		textFieldComarca = new JTextField();
		textFieldComarca.setDocument(new EntradaMaiuscula(50));
		add(textFieldComarca);
		labelMunicipio = new JLabel("MUNICÍPIO");
		add(labelMunicipio);
		textFieldMunicipio = new JTextField();
		textFieldMunicipio.setDocument(new EntradaMaiuscula(50));
		add(textFieldMunicipio);
		labelDistrito = new JLabel("DISTRITO");
		add(labelDistrito);
		textFieldDistrito = new JTextField();
		textFieldDistrito.setDocument(new EntradaMaiuscula(50));
		add(textFieldDistrito);
		labelTitular = new JLabel("TITULAR");
		add(labelTitular);
		textFieldTitular = new JTextField();
		textFieldTitular.setDocument(new EntradaMaiuscula(50));
		add(textFieldTitular);
		labelSubstituto = new JLabel("SUBISTITUTO");
		add(labelSubstituto);
		textFieldSubstituto = new JTextField();
		textFieldSubstituto.setDocument(new EntradaMaiuscula(50));
		add(textFieldSubstituto);
		labelCNPJ = new JLabel("CNPJ");
		add(labelCNPJ);
		textFieldCNPJ = new JTextField();
		textFieldCNPJ.setDocument(new EntradaMaiuscula(19));
		add(textFieldCNPJ);
		labelFone1 = new JLabel("TELEFONE");
		add(labelFone1);
		textFieldFone1 = new JTextField();
		textFieldFone1.setDocument(new EntradaMaiuscula(20));
		add(textFieldFone1);
		labelFone2 = new JLabel("TELEFONE");
		add(labelFone2);
		textFieldFone2 = new JTextField();
		textFieldFone2.setDocument(new EntradaMaiuscula(20));
		add(textFieldFone2);
		labelFax = new JLabel("FAX");
		add(labelFax);
		textFieldFax = new JTextField();
		textFieldFax.setDocument(new EntradaMaiuscula(20));
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
		labelPais = new JLabel("PAÍS");
		add(labelPais);
		textFieldPais = new JTextField();
		textFieldPais.setDocument(new EntradaMaiuscula(50));
		add(textFieldPais);
		labelEstado = new JLabel("ESTADO");
		add(labelEstado);
		textFieldEstado = new JTextField();
		textFieldEstado.setDocument(new EntradaMaiuscula(50));
		add(textFieldEstado);
		labelCidade = new JLabel("CIDADE");
		add(labelCidade);
		textFieldCidade = new JTextField();
		textFieldCidade.setDocument(new EntradaMaiuscula(50));
		add(textFieldCidade);
		labelBairro = new JLabel("BAIRRO");
		add(labelBairro);
		textFieldBairro = new JTextField();
		textFieldBairro.setDocument(new EntradaMaiuscula(50));
		add(textFieldBairro);
		labelLogradouro = new JLabel("LOGRADOURO");
		add(labelLogradouro);
		textFieldLogradouro = new JTextField();
		textFieldLogradouro.setDocument(new EntradaMaiuscula(50));
		add(textFieldLogradouro);
		labelComplemento = new JLabel("COMPLEMENTO");
		add(labelComplemento);
		textFieldComplemento = new JTextField();
		textFieldComplemento.setDocument(new EntradaMaiuscula(20));
		add(textFieldComplemento);
		labelCep = new JLabel("CEP");
		add(labelCep);
		textFieldCep = new JTextField(10);
		textFieldCep.setDocument(new EntradaMaiuscula(10));
		add(textFieldCep);
		SpringUtilities.makeCompactGrid(this, 41, 1, 5, 5, 5, 5);
		setOpaque(true);
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
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGUI() {
	}
}
