package erp.sindicato;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
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
public final class SindicatoPc extends JPanel implements Gui {

	private ToolBar toolBar;
	private ConfiguracaoGui configuracaoGui;
	private JTextField textFieldRamoAtividade;
	private JTextField textFieldNomeFantasia;
	private JTextField textFieldRazaoSocial;
	private JTextField textFieldNumeroFuncionarios;
	private JLabel labelRamoAtividade;
	private JLabel labelNomeFantasia;
	private JLabel labelRazaoSocial;
	private JLabel labelNumeroFuncionarios;
	private JTextField textFieldCPF;
	private JComboBox<String> boxTipoSindicato;
	private JTextField textFieldFaturamentoMensal;
	private JTextField textFieldCNPJ;
	private JLabel labelCPF;
	private JLabel labelTipoSindicato;
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

	public SindicatoPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public JComboBox<String> getTipoSindicatoGUI() {
		return boxTipoSindicato;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JTextField getBairroGUI() {
		return textFieldBairro;
	}

	public JTextField getCapitalSocialGUI() {
		return textFieldCapitalSocial;
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

	public JTextField getComplementoGUI() {
		return textFieldComplemento;
	}

	public JTextField getTextFieldCPF() {
		return textFieldCPF;
	}

	public JTextField getDataFundacaoGUI() {
		return textFieldDataFundacao;
	}

	public JTextField getEmailGUI() {
		return textFieldEmail;
	}

	public JTextField getEstadoGUI() {
		return textFieldEstado;
	}

	public JTextField getFaturamentoMensalGUI() {
		return textFieldFaturamentoMensal;
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

	public JTextField getTextEstadualGUI() {
		return textFieldInscricaoEstadual;
	}

	public JTextField getInscricaoMunicipalGUI() {
		return textFieldInscricaoMunicipal;
	}

	public JTextField getLogradouroGUI() {
		return textFieldLogradouro;
	}

	public JTextField getNomeFantasiaGUI() {
		return textFieldNomeFantasia;
	}

	public JTextField getNumeroFuncionariosGUI() {
		return textFieldNumeroFuncionarios;
	}

	public JTextField getPaisGUI() {
		return textFieldPais;
	}

	public JTextField getRamoAtividadeGUI() {
		return textFieldRamoAtividade;
	}

	public JTextField getRazaoSocialGUI() {
		return textFieldRazaoSocial;
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

		labelTipoSindicato = new JLabel("EMPRESA");
		add(labelTipoSindicato);

		boxTipoSindicato = new JComboBox<String>();
		boxTipoSindicato.addItem("");
		boxTipoSindicato.addItem("MATRIZ");
		boxTipoSindicato.addItem("FILIAL");
		add(boxTipoSindicato);

		labelRamoAtividade = new JLabel("RAMO DE ATIVIDADE");
		add(labelRamoAtividade);

		textFieldRamoAtividade = new JTextField();
		textFieldRamoAtividade.setDocument(new EntradaMaiuscula(50));
		add(textFieldRamoAtividade);

		labelNumeroFuncionarios = new JLabel("NÚMERO DE FUNCIONÁRIOS");
		add(labelNumeroFuncionarios);

		textFieldNumeroFuncionarios = new JTextField();
		textFieldNumeroFuncionarios.setDocument(new EntradaMaiuscula(5));
		add(textFieldNumeroFuncionarios);

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

		labelInscricaoEstadual = new JLabel("INSCRIÇÃO ESTADUAL");
		add(labelInscricaoEstadual);

		textFieldInscricaoEstadual = new JTextField();
		textFieldInscricaoEstadual.setDocument(new EntradaMaiuscula(20));
		add(textFieldInscricaoEstadual);

		labelInscricaoMunicipal = new JLabel("INSCRIÇÃO MUNICIPAL");
		add(labelInscricaoMunicipal);

		textFieldInscricaoMunicipal = new JTextField();
		textFieldInscricaoMunicipal.setDocument(new EntradaMaiuscula(20));
		add(textFieldInscricaoMunicipal);

		labelCapitalSocial = new JLabel("CAPITAL SOCIAL");
		add(labelCapitalSocial);

		textFieldCapitalSocial = new JTextField();
		textFieldCapitalSocial.setDocument(new EntradaMaiuscula(10));
		add(textFieldCapitalSocial);

		labelFaturamentoMensal = new JLabel("FATURAMENTO MENSAL");
		add(labelFaturamentoMensal);

		textFieldFaturamentoMensal = new JTextField();
		textFieldFaturamentoMensal.setDocument(new EntradaMaiuscula(10));
		add(textFieldFaturamentoMensal);

		labelDataFundacao = new JLabel("DATA DE FUNDAÇÃO");
		add(labelDataFundacao);

		textFieldDataFundacao = new JTextField();
		textFieldDataFundacao.setDocument(new EntradaMaiuscula(10));
		add(textFieldDataFundacao);

		labelCPF = new JLabel("CPF");
		add(labelCPF);

		textFieldCPF = new JTextField();
		textFieldCPF.setDocument(new EntradaMaiuscula(14));
		add(textFieldCPF);

		labelCNPJ = new JLabel("CNPJ");
		add(labelCNPJ);

		textFieldCNPJ = new JTextField();
		textFieldCNPJ.setDocument(new EntradaMaiuscula(19));
		add(textFieldCNPJ);

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

		textFieldCep = new JTextField();
		textFieldCep.setDocument(new EntradaMaiuscula(10));
		add(textFieldCep);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 47, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
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
		setBorder(BorderFactory.createTitledBorder("CADASTRO"));
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
