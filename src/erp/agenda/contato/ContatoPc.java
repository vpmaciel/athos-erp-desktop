package erp.agenda.contato;

import java.awt.Cursor;
import java.util.Collections;
import java.util.List;

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
import erp.empresa.Empresa;
import erp.empresa.EmpresaComp;
import erp.empresa.EmpresaFac;
import erp.main.MainCont;

@SuppressWarnings("serial")
public final class ContatoPc extends JPanel implements Gui {

	private ToolBar toolBar;
	private ConfiguracaoGui configuracaoGui;
	private JComboBox<String> boxSexo;
	private JTextField textFieldNome;
	private JLabel labelSexo;
	private JLabel labelNome;
	private JFormattedTextField textFieldCpf;
	private JFormattedTextField textFieldCnpj;
	private JLabel labelCpf;
	private JLabel labelCnpj;
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
	private JComboBox<Empresa> boxEmpresa;
	private JLabel labelEmpresa;

	public ContatoPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public JComboBox<Empresa> getEmpresaGui() {
		return boxEmpresa;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JLabel getLabelEmpresa() {
		return labelEmpresa;
	}

	public JTextField getBairroGui() {
		return textFieldBairro;
	}

	public JFormattedTextField getCepGui() {
		return textFieldCep;
	}

	public JTextField getCidadeGui() {
		return textFieldCidade;
	}

	public JFormattedTextField getCnpjGui() {
		return textFieldCnpj;
	}

	public JTextField getComplementoGui() {
		return textFieldComplemento;
	}

	public JFormattedTextField getCpfGui() {
		return textFieldCpf;
	}

	public JTextField getEmailGui() {
		return textFieldEmail;
	}

	public JTextField getEstadoGui() {
		return textFieldEstado;
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

	public JTextField getLogradouroGui() {
		return textFieldLogradouro;
	}

	public JTextField getNomeGui() {
		return textFieldNome;
	}

	public JTextField getPaisGui() {
		return textFieldPais;
	}

	public JComboBox<String> getSexoGui() {
		return boxSexo;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {

		final Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

		toolBar = new ToolBar();

		add(toolBar.getToolBar());

		labelNome = new JLabel("NOME");
		add(labelNome);

		textFieldNome = new JTextField();
		textFieldNome.setDocument(new EntradaMaiuscula(50));
		add(textFieldNome);

		labelSexo = new JLabel("SEXO");
		add(labelSexo);

		boxSexo = new JComboBox<String>();
		boxSexo.addItem("");
		boxSexo.addItem("MASCULINO");
		boxSexo.addItem("FEMININO");
		add(boxSexo);

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
		textFieldCep.setDocument(new EntradaMaiuscula(9));
		add(textFieldCep);

		labelEmpresa = new JLabel("TRABALHA NA EMPRESA");
		labelEmpresa.setCursor(cursor);
		add(labelEmpresa);

		boxEmpresa = new JComboBox<Empresa>();
		List<Empresa> empresas = (List<Empresa>) EmpresaFac.getRegistro();
		Collections.sort(empresas, new EmpresaComp().new NomeFantasia());
		for (Empresa empresa : empresas) {
			boxEmpresa.addItem(empresa);
		}
		boxEmpresa.setMaximumRowCount(5);
		add(boxEmpresa);

		labelCpf = new JLabel("CPF");
		add(labelCpf);

		textFieldCpf = new JFormattedTextField(Mascara.getCpf());
		add(textFieldCpf);

		labelCnpj = new JLabel("CNPJ");
		add(labelCnpj);

		textFieldCnpj = new JFormattedTextField(Mascara.getCnpj());
		add(textFieldCnpj);

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
	public void iniciarControlador() {

	}

	@Override
	public void iniciarLayout() {
		setBorder(BorderFactory.createTitledBorder("CONTATO"));
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
