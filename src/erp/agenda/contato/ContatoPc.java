package erp.agenda.contato;

import java.util.Collections;
import java.util.List;

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
import erp.empresa.Empresa;
import erp.empresa.EmpresaComp;
import erp.empresa.EmpresaFac;
import erp.main.MainCont;

@SuppressWarnings("serial")
public final class ContatoPc extends JPanel implements Gui {

	private JComboBox<Empresa> boxEmpresa;
	private JComboBox<String> boxSexo;
	private ConfiguracaoGui configuracaoGui;
	private JTextField fieldBairro;
	private JFormattedTextField fieldCep;
	private JTextField fieldCidade;
	private JFormattedTextField fieldCnpj;
	private JTextField fieldComplemento;
	private JFormattedTextField fieldCpf;
	private JTextField fieldEmail;
	private JTextField fieldEstado;
	private JFormattedTextField fieldFax;
	private JFormattedTextField fieldFone1;
	private JFormattedTextField fieldFone2;
	private JTextField fieldLogradouro;
	private JTextField fieldNome;
	private JTextField fieldPais;
	private JLabel labelEmpresa;
	private ToolBar toolBar;

	public ContatoPc() {
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
		return fieldCnpj;
	}

	public JTextField getGuiComplemento() {
		return fieldComplemento;
	}

	public JFormattedTextField getGuiCpf() {
		return fieldCpf;
	}

	public JTextField getGuiEmail() {
		return fieldEmail;
	}

	public JComboBox<Empresa> getGuiEmpresa() {
		return boxEmpresa;
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

	public JTextField getGuiNome() {
		return fieldNome;
	}

	public JTextField getGuiPais() {
		return fieldPais;
	}

	public JComboBox<String> getGuiSexo() {
		return boxSexo;
	}

	public JLabel getLabelEmpresa() {
		return labelEmpresa;
	}

	public ToolBar getToolBar() {
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

		add(toolBar.getToolBar());

		add(new JLabel("NOME"));

		fieldNome = new JTextField();
		fieldNome.setDocument(new EntradaMaiuscula(50));
		add(fieldNome);

		add(new JLabel("SEXO"));

		boxSexo = new JComboBox<String>();
		boxSexo.addItem("");
		boxSexo.addItem("MASCULINO");
		boxSexo.addItem("FEMININO");
		add(boxSexo);

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
		fieldCep.setDocument(new EntradaMaiuscula(9));
		add(fieldCep);

		labelEmpresa = new JLabel("TRABALHA NA EMPRESA");
		labelEmpresa.setCursor(Sis.getNovaJanelaCursor());
		add(labelEmpresa);

		boxEmpresa = new JComboBox<Empresa>();
		List<Empresa> empresas = (List<Empresa>) EmpresaFac.getRegistro();
		Collections.sort(empresas, new EmpresaComp().new NomeFantasia());
		for (Empresa empresa : empresas) {
			boxEmpresa.addItem(empresa);
		}
		boxEmpresa.setMaximumRowCount(5);
		add(boxEmpresa);

		add(new JLabel("CPF"));

		fieldCpf = new JFormattedTextField(Mascara.getCpf());
		add(fieldCpf);

		add(new JLabel("CNPJ"));

		fieldCnpj = new JFormattedTextField(Mascara.getCnpj());
		add(fieldCnpj);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 33, 1, // rows, cols
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
		Empresa empresa = null;
		List<Empresa> empresas = (List<Empresa>) EmpresaFac.getRegistro();
		Collections.sort(empresas, new EmpresaComp().new NomeFantasia());
		boxEmpresa.removeAllItems();
		for (Empresa e : empresas) {
			boxEmpresa.addItem(e);
		}
		if (!MainCont.getAgendaContatoFc().isShowing()
				&& MainCont.getAgendaContatoFc().getContatoCont().getContato() != null) {
			empresa = MainCont.getAgendaContatoFc().getContatoCont().getContato().getEmpresa();
			boxEmpresa.setSelectedItem(empresa);
		}

	}
}
