package erp.sindicato;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
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
	private JFormattedTextField textFieldCPF;
	private JComboBox<String> boxTipoSindicato;
	private JTextField textFieldFaturamentoMensal;
	private JFormattedTextField textFieldCNPJ;
	private JLabel labelCPF;
	private JLabel labelTipoSindicato;
	private JLabel labelFaturamentoMensal;
	private JLabel labelCNPJ;
	private JTextField textFieldEmail;
	private JFormattedTextField textFieldFax;
	private JFormattedTextField textFieldFone1;
	private JFormattedTextField textFieldFone2;
	private JLabel labelFone2;
	private JLabel labelEmail;
	private JLabel labelFax;
	private JLabel labelFone1;
	private JTextField textFieldBairro;
	private JFormattedTextField textFieldCep;
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
	private JFormattedTextField textFieldDataFundacao;
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

	public JComboBox<String> getTipoSindicatoGui() {
		return boxTipoSindicato;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JTextField getBairroGui() {
		return textFieldBairro;
	}

	public JTextField getCapitalSocialGui() {
		return textFieldCapitalSocial;
	}

	public JFormattedTextField getCepGui() {
		return textFieldCep;
	}

	public JTextField getCidadeGui() {
		return textFieldCidade;
	}

	public JFormattedTextField getCnpjGui() {
		return textFieldCNPJ;
	}

	public JTextField getComplementoGui() {
		return textFieldComplemento;
	}

	public JFormattedTextField getTextFieldCPF() {
		return textFieldCPF;
	}

	public JFormattedTextField getDataFundacaoGui() {
		return textFieldDataFundacao;
	}

	public JTextField getEmailGui() {
		return textFieldEmail;
	}

	public JTextField getEstadoGui() {
		return textFieldEstado;
	}

	public JTextField getFaturamentoMensalGui() {
		return textFieldFaturamentoMensal;
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

	public JTextField getTextEstadualGui() {
		return textFieldInscricaoEstadual;
	}

	public JTextField getInscricaoMunicipalGui() {
		return textFieldInscricaoMunicipal;
	}

	public JTextField getLogradouroGui() {
		return textFieldLogradouro;
	}

	public JTextField getNomeFantasiaGui() {
		return textFieldNomeFantasia;
	}

	public JTextField getNumeroFuncionariosGui() {
		return textFieldNumeroFuncionarios;
	}

	public JTextField getPaisGui() {
		return textFieldPais;
	}

	public JTextField getRamoAtividadeGui() {
		return textFieldRamoAtividade;
	}

	public JTextField getRazaoSocialGui() {
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

		textFieldDataFundacao = new JFormattedTextField(Mascara.getData());
		add(textFieldDataFundacao);

		labelCPF = new JLabel("CPF");
		add(labelCPF);

		textFieldCPF = new JFormattedTextField(Mascara.getCpf());
		add(textFieldCPF);

		labelCNPJ = new JLabel("CNPJ");
		add(labelCNPJ);

		textFieldCNPJ = new JFormattedTextField(Mascara.getCnpj());
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

		textFieldCep = new JFormattedTextField(Mascara.getCep());
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
		setBorder(BorderFactory.createTitledBorder("SINDICATO"));
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
