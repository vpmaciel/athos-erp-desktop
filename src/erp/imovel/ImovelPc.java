package erp.imovel;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.GUI;
import arquitetura.gui.ConfiguracaoGUI;
import arquitetura.gui.EntradaMinuscula;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;

@SuppressWarnings("serial")
public final class ImovelPc extends JPanel implements GUI {

	private ToolBar toolBar;
	private ConfiguracaoGUI configuracaoGUI;
	private JTextField textFieldSala;
	private JTextField textFieldNomeProprietario;
	private JTextField textFieldQuarto;
	private JTextField textFieldCozinha;
	private JLabel labelSala;
	private JLabel labelNomeProprietario;
	private JLabel labelQuarto;
	private JLabel labelCozinha;
	private JTextField textFieldCPF;
	private JComboBox<String> boxGaragem;
	private JComboBox<String> boxPiscina;
	private JTextField textFieldCNPJ;
	private JLabel labelCPF;
	private JLabel labelGaragem;
	private JLabel labelPiscina;
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
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public JComboBox<String> getGaragemGUI() {
		return boxGaragem;
	}

	public JComboBox<String> getPiscinaGUI() {
		return boxPiscina;
	}

	public JComboBox<String> getTerracoGUI() {
		return boxTerraco;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public JTextField getBairroGUI() {
		return textFieldBairro;
	}

	public JTextField getBanheiroGUI() {
		return textFieldBanheiro;
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

	public JTextField getCozinhaGUI() {
		return textFieldCozinha;
	}

	public JTextField getCpfGUI() {
		return textFieldCPF;
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

	public JTextField getNomeProprietarioGUI() {
		return textFieldNomeProprietario;
	}

	public JTextField getPaisGUI() {
		return textFieldPais;
	}

	public JTextField getQuartoGUI() {
		return textFieldQuarto;
	}

	public JTextField getSalaGUI() {
		return textFieldSala;
	}

	public JTextField getSuiteGUI() {
		return textFieldSuite;
	}

	public JTextField getVarandaGUI() {
		return textFieldVaranda;
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

	}

	@Override
	public void reiniciarGUI() {

	}
}
