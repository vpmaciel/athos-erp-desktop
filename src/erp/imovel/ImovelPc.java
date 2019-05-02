package erp.imovel;

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
public final class ImovelPc extends JPanel implements Gui {

	private ToolBar toolBar;
	private ConfiguracaoGui configuracaoGui;
	private JTextField textFieldSala;
	private JTextField textFieldNomeProprietario;
	private JTextField textFieldQuarto;
	private JTextField textFieldCozinha;
	private JLabel labelSala;
	private JLabel labelNomeProprietario;
	private JLabel labelQuarto;
	private JLabel labelCozinha;
	private JFormattedTextField textFieldCPF;
	private JComboBox<String> boxGaragem;
	private JComboBox<String> boxPiscina;
	private JFormattedTextField textFieldCNPJ;
	private JLabel labelCPF;
	private JLabel labelGaragem;
	private JLabel labelPiscina;
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
	private JTextField textFieldBanheiro;
	private JTextField textFieldSuite;
	private JComboBox<String> boxTerraco;
	private JTextField textFieldVaranda;
	private JLabel labelBanheiro;
	private JLabel labelSuite;
	private JLabel labelTerraco;
	private JLabel labelVaranda;

	public ImovelPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public JComboBox<String> getGuiGaragem() {
		return boxGaragem;
	}

	public JComboBox<String> getGuiPiscina() {
		return boxPiscina;
	}

	public JComboBox<String> getGuiTerraco() {
		return boxTerraco;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JTextField getGuiBairro() {
		return textFieldBairro;
	}

	public JTextField getGuiBanheiro() {
		return textFieldBanheiro;
	}

	public JTextField getGuiCep() {
		return textFieldCep;
	}

	public JTextField getGuiCidade() {
		return textFieldCidade;
	}

	public JTextField getGuiCnpj() {
		return textFieldCNPJ;
	}

	public JTextField getGuiComplemento() {
		return textFieldComplemento;
	}

	public JTextField getGuiCozinha() {
		return textFieldCozinha;
	}

	public JTextField getGuiCpf() {
		return textFieldCPF;
	}

	public JTextField getGuiEmail() {
		return textFieldEmail;
	}

	public JTextField getGuiEstado() {
		return textFieldEstado;
	}

	public JFormattedTextField getGuiFax() {
		return textFieldFax;
	}

	public JFormattedTextField getGuiFone1() {
		return textFieldFone1;
	}

	public JFormattedTextField getGuiFone2() {
		return textFieldFone2;
	}

	public JTextField getGuiLogradouro() {
		return textFieldLogradouro;
	}

	public JTextField getGuiNomeProprietario() {
		return textFieldNomeProprietario;
	}

	public JTextField getGuiPais() {
		return textFieldPais;
	}

	public JTextField getGuiQuarto() {
		return textFieldQuarto;
	}

	public JTextField getGuiSala() {
		return textFieldSala;
	}

	public JTextField getGuiSuite() {
		return textFieldSuite;
	}

	public JTextField getGuiVaranda() {
		return textFieldVaranda;
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

		labelNomeProprietario = new JLabel("NOME DO PROPRIETÁRIO");
		add(labelNomeProprietario);

		textFieldNomeProprietario = new JTextField();
		textFieldNomeProprietario.setDocument(new EntradaMaiuscula(50));
		add(textFieldNomeProprietario);

		labelQuarto = new JLabel("QUANTIDADE DE QUARTOS");
		add(labelQuarto);

		textFieldQuarto = new JTextField();
		textFieldQuarto.setDocument(new EntradaMaiuscula(2));
		add(textFieldQuarto);

		labelGaragem = new JLabel("GARAGEM");
		add(labelGaragem);

		boxGaragem = new JComboBox<String>();
		boxGaragem.addItem("");
		boxGaragem.addItem("SIM");
		boxGaragem.addItem("NÃO");
		add(boxGaragem);

		labelSala = new JLabel("SALAS");
		add(labelSala);

		textFieldSala = new JTextField();
		textFieldSala.setDocument(new EntradaMaiuscula(2));
		add(textFieldSala);

		labelCozinha = new JLabel("COZINHAS");
		add(labelCozinha);

		textFieldCozinha = new JTextField();
		textFieldCozinha.setDocument(new EntradaMaiuscula(2));
		add(textFieldCozinha);

		labelBanheiro = new JLabel("BANHEIROS");
		add(labelBanheiro);

		textFieldBanheiro = new JTextField();
		textFieldBanheiro.setDocument(new EntradaMaiuscula(2));
		add(textFieldBanheiro);

		labelSuite = new JLabel("SUÍTES");
		add(labelSuite);

		textFieldSuite = new JTextField();
		textFieldSuite.setDocument(new EntradaMaiuscula(2));
		add(textFieldSuite);

		labelVaranda = new JLabel("VARANDAS");
		add(labelVaranda);

		textFieldVaranda = new JTextField();
		textFieldVaranda.setDocument(new EntradaMaiuscula(2));
		add(textFieldVaranda);

		labelPiscina = new JLabel("PISCINA");
		add(labelPiscina);

		boxPiscina = new JComboBox<String>();
		boxPiscina.addItem("");
		boxPiscina.addItem("SIM");
		boxPiscina.addItem("NÃO");
		add(boxPiscina);

		labelTerraco = new JLabel("TERRAÇO");
		add(labelTerraco);

		boxTerraco = new JComboBox<String>();
		boxTerraco.addItem("");
		boxTerraco.addItem("SIM");
		boxTerraco.addItem("NÃO");
		add(boxTerraco);

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
		setBorder(BorderFactory.createTitledBorder("IMÓVEL"));
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
