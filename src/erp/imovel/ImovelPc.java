package erp.imovel;

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
public final class ImovelPc extends JPanel implements Gui {

	private JComboBox<String> boxGaragem;
	private JComboBox<String> boxPiscina;
	private JComboBox<String> boxTerraco;
	private ConfiguracaoGui configuracaoGui;
	private JTextField fieldBairro;
	private JTextField fieldBanheiro;
	private JFormattedTextField fieldCep;
	private JTextField fieldCidade;
	private JFormattedTextField fieldCNPJ;
	private JTextField fieldComplemento;
	private JTextField fieldCozinha;
	private JFormattedTextField fieldCPF;
	private JTextField fieldEmail;
	private JTextField fieldEstado;
	private JFormattedTextField fieldFax;
	private JFormattedTextField fieldFone1;
	private JFormattedTextField fieldFone2;
	private JTextField fieldLogradouro;
	private JTextField fieldNomeProprietario;
	private JTextField fieldPais;
	private JTextField fieldQuarto;
	private JTextField fieldSala;
	private JTextField fieldSuite;
	private JTextField fieldVaranda;
	private ToolBar toolBar;

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

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JTextField getGuiBairro() {
		return fieldBairro;
	}

	public JTextField getGuiBanheiro() {
		return fieldBanheiro;
	}

	public JTextField getGuiCep() {
		return fieldCep;
	}

	public JTextField getGuiCidade() {
		return fieldCidade;
	}

	public JTextField getGuiCnpj() {
		return fieldCNPJ;
	}

	public JTextField getGuiComplemento() {
		return fieldComplemento;
	}

	public JTextField getGuiCozinha() {
		return fieldCozinha;
	}

	public JTextField getGuiCpf() {
		return fieldCPF;
	}

	public JTextField getGuiEmail() {
		return fieldEmail;
	}

	public JTextField getGuiEstado() {
		return fieldEstado;
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

	public JComboBox<String> getGuiGaragem() {
		return boxGaragem;
	}

	public JTextField getGuiLogradouro() {
		return fieldLogradouro;
	}

	public JTextField getGuiNomeProprietario() {
		return fieldNomeProprietario;
	}

	public JTextField getGuiPais() {
		return fieldPais;
	}

	public JComboBox<String> getGuiPiscina() {
		return boxPiscina;
	}

	public JTextField getGuiQuarto() {
		return fieldQuarto;
	}

	public JTextField getGuiSala() {
		return fieldSala;
	}

	public JTextField getGuiSuite() {
		return fieldSuite;
	}

	public JComboBox<String> getGuiTerraco() {
		return boxTerraco;
	}

	public JTextField getGuiVaranda() {
		return fieldVaranda;
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

		this.add(toolBar.getTB());

		add(new JLabel("NOME DO PROPRIETÁRIO"));

		fieldNomeProprietario = new JTextField();
		fieldNomeProprietario.setDocument(new EntradaMaiuscula(50));
		add(fieldNomeProprietario);

		add(new JLabel("QUANTIDADE DE QUARTOS"));

		fieldQuarto = new JTextField();
		fieldQuarto.setDocument(new EntradaMaiuscula(2));
		add(fieldQuarto);

		add(new JLabel("GARAGEM"));

		boxGaragem = new JComboBox<String>();
		boxGaragem.addItem("");
		boxGaragem.addItem("SIM");
		boxGaragem.addItem("NÃO");
		add(boxGaragem);

		add(new JLabel("SALAS"));

		fieldSala = new JTextField();
		fieldSala.setDocument(new EntradaMaiuscula(2));
		add(fieldSala);

		add(new JLabel("COZINHAS"));

		fieldCozinha = new JTextField();
		fieldCozinha.setDocument(new EntradaMaiuscula(2));
		add(fieldCozinha);

		add(new JLabel("BANHEIROS"));

		fieldBanheiro = new JTextField();
		fieldBanheiro.setDocument(new EntradaMaiuscula(2));
		add(fieldBanheiro);

		add(new JLabel("SUÍTES"));

		fieldSuite = new JTextField();
		fieldSuite.setDocument(new EntradaMaiuscula(2));
		add(fieldSuite);

		add(new JLabel("VARANDAS"));

		fieldVaranda = new JTextField();
		fieldVaranda.setDocument(new EntradaMaiuscula(2));
		add(fieldVaranda);

		add(new JLabel("PISCINA"));

		boxPiscina = new JComboBox<String>();
		boxPiscina.addItem("");
		boxPiscina.addItem("SIM");
		boxPiscina.addItem("NÃO");
		add(boxPiscina);

		add(new JLabel("TERRAÇO"));

		boxTerraco = new JComboBox<String>();
		boxTerraco.addItem("");
		boxTerraco.addItem("SIM");
		boxTerraco.addItem("NÃO");
		add(boxTerraco);

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
		fieldCep.setDocument(new EntradaMaiuscula(10));
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
