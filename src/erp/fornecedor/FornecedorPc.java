package erp.fornecedor;

import javax.swing.JComboBox;
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
public final class FornecedorPc extends JPanel implements Gui {

	private JComboBox<String> boxTipoEmpresa;
	private ConfiguracaoGui configuracaoGui;
	private JTextField fieldBairro;
	private JTextField fieldCapitalSocial;
	private JFormattedTextField fieldCep;
	private JTextField fieldCidade;
	private JFormattedTextField fieldCNPJ;
	private JTextField fieldComplemento;
	private JFormattedTextField fieldCPF;
	private JFormattedTextField fieldDataFundacao;
	private JTextField fieldEmail;
	private JTextField fieldEstado;
	private JTextField fieldFaturamentoMensal;
	private JFormattedTextField fieldFax;
	private JFormattedTextField fieldFone1;
	private JFormattedTextField fieldFone2;
	private JTextField fieldInscricaoEstadual;
	private JTextField fieldInscricaoMunicipal;
	private JTextField fieldLogradouro;
	private JTextField fieldNomeFantasia;
	private JTextField fieldNumeroFuncionarios;
	private JTextField fieldPais;
	private JTextField fieldRamoAtividade;
	private JTextField fieldRazaoSocial;
	private ToolBar toolBar;

	public FornecedorPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JTextField getGuiBairro() {
		return fieldBairro;
	}

	public JTextField getGuiCapitalSocial() {
		return fieldCapitalSocial;
	}

	public JFormattedTextField getGuiCep() {
		return fieldCep;
	}

	public JTextField getGuiCidade() {
		return fieldCidade;
	}

	public JFormattedTextField getGuiCnpj() {
		return fieldCNPJ;
	}

	public JTextField getGuiComplemento() {
		return fieldComplemento;
	}

	public JFormattedTextField getGuiCpf() {
		return fieldCPF;
	}

	public JFormattedTextField getGuiDataFundacao() {
		return fieldDataFundacao;
	}

	public JTextField getGuiEmail() {
		return fieldEmail;
	}

	public JTextField getGuiEstado() {
		return fieldEstado;
	}

	public JTextField getGuiFaturamentoMensal() {
		return fieldFaturamentoMensal;
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

	public JTextField getGuiInscricaoEstadual() {
		return fieldInscricaoEstadual;
	}

	public JTextField getGuiInscricaoMunicipal() {
		return fieldInscricaoMunicipal;
	}

	public JTextField getGuiLogradouro() {
		return fieldLogradouro;
	}

	public JTextField getGuiNomeFantasia() {
		return fieldNomeFantasia;
	}

	public JTextField getGuiNumeroFuncionarios() {
		return fieldNumeroFuncionarios;
	}

	public JTextField getGuiPais() {
		return fieldPais;
	}

	public JTextField getGuiRamoAtividade() {
		return fieldRamoAtividade;
	}

	public JTextField getGuiRazaoSocial() {
		return fieldRazaoSocial;
	}

	public JComboBox<String> getGuiTipoEmpresa() {
		return boxTipoEmpresa;
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

		add(new JLabel("NOME FANTASIA"));

		fieldNomeFantasia = new JTextField();
		fieldNomeFantasia.setDocument(new EntradaMaiuscula(50));
		add(fieldNomeFantasia);

		add(new JLabel("RAZÃO SOCIAL"));

		fieldRazaoSocial = new JTextField();
		fieldRazaoSocial.setDocument(new EntradaMaiuscula(50));
		add(fieldRazaoSocial);

		add(new JLabel("EMPRESA"));

		boxTipoEmpresa = new JComboBox<String>();
		boxTipoEmpresa.addItem("");
		boxTipoEmpresa.addItem("MATRIZ");
		boxTipoEmpresa.addItem("FILIAL");
		add(boxTipoEmpresa);

		add(new JLabel("RAMO DE ATIVIDADE"));

		fieldRamoAtividade = new JTextField();
		fieldRamoAtividade.setDocument(new EntradaMaiuscula(50));
		add(fieldRamoAtividade);

		add(new JLabel("NÚMERO DE FUNCIONÁRIOS"));

		fieldNumeroFuncionarios = new JTextField();
		fieldNumeroFuncionarios.setDocument(new EntradaMaiuscula(6));
		add(fieldNumeroFuncionarios);

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

		add(new JLabel("INSCRIÇÃO ESTADUAL"));

		fieldInscricaoEstadual = new JTextField();
		fieldInscricaoEstadual.setDocument(new EntradaMaiuscula(20));
		add(fieldInscricaoEstadual);

		add(new JLabel("INSCRIÇÃO MUNICIPAL"));

		fieldInscricaoMunicipal = new JTextField();
		fieldInscricaoMunicipal.setDocument(new EntradaMaiuscula(20));
		add(fieldInscricaoMunicipal);

		add(new JLabel("CAPITAL SOCIAL"));

		fieldCapitalSocial = new JTextField();
		fieldCapitalSocial.setDocument(new EntradaMaiuscula(10));
		add(fieldCapitalSocial);

		add(new JLabel("FATURAMENTO MENSAL"));

		fieldFaturamentoMensal = new JTextField();
		fieldFaturamentoMensal.setDocument(new EntradaMaiuscula(10));
		add(fieldFaturamentoMensal);

		add(new JLabel("DATA DE FUNDAÇÃO"));

		fieldDataFundacao = new JFormattedTextField(Mascara.getData());
		add(fieldDataFundacao);

		add(new JLabel("CPF"));

		fieldCPF = new JFormattedTextField(Mascara.getCpf());
		add(fieldCPF);

		add(new JLabel("CNPJ"));

		fieldCNPJ = new JFormattedTextField(Mascara.getCnpj());
		add(fieldCNPJ);

		add(new JLabel("PAÍS"));

		fieldPais = new JTextField();
		fieldPais.setDocument(new EntradaMaiuscula(50));
		add(fieldPais);

		add(new JLabel("ESTADO"));

		fieldEstado = new JTextField();
		fieldEstado.setDocument(new EntradaMaiuscula(50));
		add(fieldEstado);

		add(new JLabel("CIDADE"));

		fieldCidade = new JTextField();
		fieldCidade.setDocument(new EntradaMaiuscula(50));
		add(fieldCidade);

		add(new JLabel("BAIRRO"));

		fieldBairro = new JTextField();
		fieldBairro.setDocument(new EntradaMaiuscula(50));
		add(fieldBairro);

		add(new JLabel("LOGRADOURO"));

		fieldLogradouro = new JTextField();
		fieldLogradouro.setDocument(new EntradaMaiuscula(50));
		add(fieldLogradouro);

		add(new JLabel("COMPLEMENTO"));

		fieldComplemento = new JTextField();
		fieldComplemento.setDocument(new EntradaMaiuscula(20));
		add(fieldComplemento);

		add(new JLabel("CEP"));

		fieldCep = new JFormattedTextField(Mascara.getEnderecoCep());
		add(fieldCep);

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
	public void iniciarLayout() {
		setBorder(Sis.getBordaPainel());
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
