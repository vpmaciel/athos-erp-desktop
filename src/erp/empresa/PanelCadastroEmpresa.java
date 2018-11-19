package erp.empresa;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import erp.aop.gui.FocusTabListener;
import erp.aop.gui.Gui;
import erp.aop.gui.GuiHandle;
import erp.aop.gui.TamanhoLowerCase;
import erp.aop.gui.TamanhoUpperCase;
import erp.aop.gui.registro.ToolBar;
import erp.aop.util.SpringUtilities;

@SuppressWarnings("serial")
public final class PanelCadastroEmpresa extends JPanel implements Gui {

	private GuiHandle guiHandle;
	private JTextField textFieldRamoAtividade;
	private JTextField textFieldNomeFantasia;
	private JTextField textFieldRazaoSocial;
	private JTextField textFieldNumeroFuncionarios;
	private JLabel labelRamoAtividade;
	private JLabel labelNomeFantasia;
	private JLabel labelRazaoSocial;
	private JLabel labelNumeroFuncionarios;
	private JTextField textFieldCPF;
	private JComboBox<String> boxTipoEmpresa;
	private JTextField textFieldFaturamentoMensal;
	private JTextField textFieldCNPJ;
	private JLabel labelCPF;
	private JLabel labelTipoEmpresa;
	private JLabel labelFaturamentoMensal;
	private JLabel labelCNPJ;
	private JTextField textFieldEmail;
	private JTextField textFieldFax;
	private JTextField textFieldFone1;
	private JTextField textFieldFone2;
	private JLabel labelFone2;
	private JLabel labelEmail;
	private JLabel labelFax;
	private JLabel labelFone1;
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
	private JTextField textFieldInscricaoEstadual;
	private JTextField textFieldInscricaoMunicipal;
	private JTextField textFieldDataFundacao;
	private JTextField textFieldCapitalSocial;
	private JLabel labelInscricaoEstadual;
	private JLabel labelInscricaoMunicipal;
	private JLabel labelDataFundacao;
	private JLabel labelCapitalSocial;
	private ToolBar toolBar;

	public PanelCadastroEmpresa() {
		iniciarLayout();
		iniciarGui();
		iniciarFocusTabListener();
		iniciarGuiGerenteEventos();
	}

	@Override
	public void atualizarTable() {

	}

	public JComboBox<String> getBoxTipoEmpresa() {
		return boxTipoEmpresa;
	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public JTextField getTextFieldBairro() {
		return textFieldBairro;
	}

	public JTextField getTextFieldCapitalSocial() {
		return textFieldCapitalSocial;
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

	public JTextField getTextFieldComplemento() {
		return textFieldComplemento;
	}

	public JTextField getTextFieldCPF() {
		return textFieldCPF;
	}

	public JTextField getTextFieldDataFundacao() {
		return textFieldDataFundacao;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JTextField getTextFieldEstado() {
		return textFieldEstado;
	}

	public JTextField getTextFieldFaturamentoMensal() {
		return textFieldFaturamentoMensal;
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

	public JTextField getTextFieldInscricaoEstadual() {
		return textFieldInscricaoEstadual;
	}

	public JTextField getTextFieldInscricaoMunicipal() {
		return textFieldInscricaoMunicipal;
	}

	public JTextField getTextFieldLogradouro() {
		return textFieldLogradouro;
	}

	public JTextField getTextFieldNomeFantasia() {
		return textFieldNomeFantasia;
	}

	public JTextField getTextFieldNumeroFuncionarios() {
		return textFieldNumeroFuncionarios;
	}

	public JTextField getTextFieldPais() {
		return textFieldPais;
	}

	public JTextField getTextFieldRamoAtividade() {
		return textFieldRamoAtividade;
	}

	public JTextField getTextFieldRazaoSocial() {
		return textFieldRazaoSocial;
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

		labelTipoEmpresa = new JLabel("EMPRESA");
		add(labelTipoEmpresa);

		boxTipoEmpresa = new JComboBox<String>();
		boxTipoEmpresa.addItem("");
		boxTipoEmpresa.addItem("MATRIZ");
		boxTipoEmpresa.addItem("FILIAL");
		add(boxTipoEmpresa);

		labelRamoAtividade = new JLabel("RAMO DE ATIVIDADE");
		add(labelRamoAtividade);

		textFieldRamoAtividade = new JTextField();
		textFieldRamoAtividade.setDocument(new TamanhoUpperCase(50));
		add(textFieldRamoAtividade);

		labelNumeroFuncionarios = new JLabel("NÚMERO DE FUNCIONÁRIOS");
		add(labelNumeroFuncionarios);

		textFieldNumeroFuncionarios = new JTextField();
		textFieldNumeroFuncionarios.setDocument(new TamanhoUpperCase(6));
		add(textFieldNumeroFuncionarios);

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

		labelInscricaoEstadual = new JLabel("INSCRIÇÃO ESTADUAL");
		add(labelInscricaoEstadual);

		textFieldInscricaoEstadual = new JTextField();
		textFieldInscricaoEstadual.setDocument(new TamanhoUpperCase(20));
		add(textFieldInscricaoEstadual);

		labelInscricaoMunicipal = new JLabel("INSCRIÇÃO MUNICIPAL");
		add(labelInscricaoMunicipal);

		textFieldInscricaoMunicipal = new JTextField();
		textFieldInscricaoMunicipal.setDocument(new TamanhoUpperCase(20));
		add(textFieldInscricaoMunicipal);

		labelCapitalSocial = new JLabel("CAPITAL SOCIAL");
		add(labelCapitalSocial);

		textFieldCapitalSocial = new JTextField();
		textFieldCapitalSocial.setDocument(new TamanhoUpperCase(10));
		add(textFieldCapitalSocial);

		labelFaturamentoMensal = new JLabel("FATURAMENTO MENSAL");
		add(labelFaturamentoMensal);

		textFieldFaturamentoMensal = new JTextField();
		textFieldFaturamentoMensal.setDocument(new TamanhoUpperCase(10));
		add(textFieldFaturamentoMensal);

		labelDataFundacao = new JLabel("DATA DE FUNDAÇÃO");
		add(labelDataFundacao);

		textFieldDataFundacao = new JTextField();
		textFieldDataFundacao.setDocument(new TamanhoUpperCase(10));
		add(textFieldDataFundacao);

		labelCPF = new JLabel("CPF");
		add(labelCPF);

		textFieldCPF = new JTextField();
		textFieldCPF.setDocument(new TamanhoUpperCase(14));
		add(textFieldCPF);

		labelCNPJ = new JLabel("CNPJ");
		add(labelCNPJ);

		textFieldCNPJ = new JTextField();
		textFieldCNPJ.setDocument(new TamanhoUpperCase(19));
		add(textFieldCNPJ);

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

		textFieldCep = new JTextField();
		textFieldCep.setDocument(new TamanhoUpperCase(10));
		add(textFieldCep);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 47, 1, // rows, cols
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
