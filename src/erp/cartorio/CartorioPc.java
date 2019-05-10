package erp.cartorio;

import javax.swing.BorderFactory;
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
import arquitetura.gui.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Mascara;

@SuppressWarnings("serial")
public final class CartorioPc extends JPanel implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private JTextField fieldBairro;
	private JFormattedTextField fieldCep;
	private JTextField fieldCidade;
	private JFormattedTextField fieldCNPJ;
	private JTextField fieldComarca;
	private JTextField fieldComplemento;
	private JTextField fieldDistrito;
	private JTextField fieldEmail;
	private JTextField fieldEstado;
	private JFormattedTextField fieldFax;
	private JFormattedTextField fieldFone1;
	private JFormattedTextField fieldFone2;
	private JTextField fieldLogradouro;
	private JTextField fieldMunicipio;
	private JTextField fieldNomeFantasia;
	private JTextField fieldPais;
	private JTextField fieldRazaoSocial;
	private JTextField fieldSite;
	private JTextField fieldSubstituto;
	private JTextField fieldTitular;
	private ToolBar toolBar;

	public CartorioPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
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

	public JFormattedTextField getGuiCep() {
		return fieldCep;
	}

	public JTextField getGuiCidade() {
		return fieldCidade;
	}

	public JFormattedTextField getGuiCnpj() {
		return fieldCNPJ;
	}

	public JTextField getGuiComarca() {
		return fieldComarca;
	}

	public JTextField getGuiComplemento() {
		return fieldComplemento;
	}

	public JTextField getGuiDistrito() {
		return fieldDistrito;
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

	public JTextField getGuiLogradouro() {
		return fieldLogradouro;
	}

	public JTextField getGuiMunicipio() {
		return fieldMunicipio;
	}

	public JTextField getGuiPais() {
		return fieldPais;
	}

	public JTextField getGuiRazaoSocial() {
		return fieldRazaoSocial;
	}

	public JTextField getGuiSite() {
		return fieldSite;
	}

	public JTextField getGuiSubstituto() {
		return fieldSubstituto;
	}

	public JTextField getGuiTitular() {
		return fieldTitular;
	}

	public JTextField getNomeGuiFantasia() {
		return fieldNomeFantasia;
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

		this.add(toolBar.getToolBar());

		add(new JLabel("NOME FANTASIA"));

		fieldNomeFantasia = new JTextField();
		fieldNomeFantasia.setDocument(new EntradaMaiuscula(50));
		add(fieldNomeFantasia);

		add(new JLabel("RAZÃO SOCIAL"));

		fieldRazaoSocial = new JTextField();
		fieldRazaoSocial.setDocument(new EntradaMaiuscula(50));
		add(fieldRazaoSocial);

		add(new JLabel("COMARCA"));

		fieldComarca = new JTextField();
		fieldComarca.setDocument(new EntradaMaiuscula(50));
		add(fieldComarca);

		add(new JLabel("MUNICÍPIO"));

		fieldMunicipio = new JTextField();
		fieldMunicipio.setDocument(new EntradaMaiuscula(50));
		add(fieldMunicipio);

		add(new JLabel("DISTRITO"));

		fieldDistrito = new JTextField();
		fieldDistrito.setDocument(new EntradaMaiuscula(50));
		add(fieldDistrito);

		add(new JLabel("TITULAR"));

		fieldTitular = new JTextField();
		fieldTitular.setDocument(new EntradaMaiuscula(50));
		add(fieldTitular);

		add(new JLabel("SUBISTITUTO"));

		fieldSubstituto = new JTextField();
		fieldSubstituto.setDocument(new EntradaMaiuscula(50));
		add(fieldSubstituto);

		add(new JLabel("CNPJ"));

		fieldCNPJ = new JFormattedTextField(Mascara.getCnpj());
		add(fieldCNPJ);

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

		add(new JLabel("SITE"));

		fieldSite = new JTextField();
		fieldSite.setDocument(new EntradaMinuscula(50));
		add(fieldSite);

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

		fieldCep = new JFormattedTextField(Mascara.getCep());
		add(fieldCep);

		SpringUtilities.makeCompactGrid(this, 41, 1, 5, 5, 5, 5);
		setOpaque(true);
	}

	@Override
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarLayout() {
		setBorder(BorderFactory.createTitledBorder("CARTÓRIO"));
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTabela() {
	}

	@Override
	public void limparGui() {
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGui() {
	}
}
