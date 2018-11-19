package erp.agenda.compromisso;

import java.awt.Cursor;
import java.util.Collections;
import java.util.List;

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
import erp.empresa.Empresa;
import erp.empresa.EmpresaDaoFacade;
import erp.empresa.EmpresaSort;
import erp.main.MainGerenteEventos;

@SuppressWarnings("serial")
public final class PanelCadastroCompromisso extends JPanel implements Gui {

	private ToolBar toolBar;
	private GuiHandle guiHandle;
	private JComboBox<String> boxSexo;
	private JTextField textFieldNome;
	private JTextField textFieldDataC;
	private JLabel labelSexo;
	private JLabel labelNome;
	private JTextField textFieldCPF;
	private JTextField textFieldCNPJ;
	private JLabel labelCPF;
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
	private JComboBox<Empresa> boxEmpresa;
	private JLabel labelEmpresa;

	public PanelCadastroCompromisso() {
		iniciarLayout();
		iniciarGui();
		iniciarFocusTabListener();
		iniciarGuiGerenteEventos();
	}

	@Override
	public void atualizarTable() {

	}

	public JComboBox<Empresa> getBoxEmpresa() {
		return boxEmpresa;
	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public JLabel getLabelEmpresa() {
		return labelEmpresa;
	}

	public JTextField getTextFieldBairro() {
		return textFieldBairro;
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

	public JTextField getTextFieldDataC() {
		return textFieldDataC;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JTextField getTextFieldEstado() {
		return textFieldEstado;
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

	public JTextField getTextFieldLogradouro() {
		return textFieldLogradouro;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JTextField getTextFieldPais() {
		return textFieldPais;
	}

	public JComboBox<String> getTextFieldSexo() {
		return boxSexo;
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

		final Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

		toolBar = new ToolBar();

		add(toolBar.getToolBar());

		labelNome = new JLabel("NOME");
		add(labelNome);

		textFieldNome = new JTextField();
		textFieldNome.setDocument(new TamanhoUpperCase(30));
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

		textFieldFone1 = new JTextField(20);
		textFieldFone1.setDocument(new TamanhoUpperCase(20));
		add(textFieldFone1);

		labelFone2 = new JLabel("TELEFONE");
		add(labelFone2);

		textFieldFone2 = new JTextField(20);
		textFieldFone2.setDocument(new TamanhoUpperCase(20));
		add(textFieldFone2);

		labelFax = new JLabel("FAX");
		add(labelFax);

		textFieldFax = new JTextField(20);
		textFieldFax.setDocument(new TamanhoUpperCase(20));
		add(textFieldFax);

		labelEmail = new JLabel("E-MAIL");
		add(labelEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setDocument(new TamanhoLowerCase(50));
		add(textFieldEmail);

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
		textFieldComplemento.setDocument(new TamanhoUpperCase(50));
		add(textFieldComplemento);

		labelCep = new JLabel("CEP");
		add(labelCep);

		textFieldCep = new JTextField();
		textFieldCep.setDocument(new TamanhoUpperCase(9));
		add(textFieldCep);

		labelEmpresa = new JLabel("TRABALHA NA EMPRESA");
		labelEmpresa.setCursor(cursor);
		add(labelEmpresa);

		boxEmpresa = new JComboBox<Empresa>();
		List<Empresa> empresas = (List<Empresa>) EmpresaDaoFacade.getRegistro();
		Collections.sort(empresas, new EmpresaSort().new NomeFantasia());
		for (Empresa empresa : empresas) {
			boxEmpresa.addItem(empresa);
		}
		boxEmpresa.setMaximumRowCount(5);
		add(boxEmpresa);

		labelCPF = new JLabel("CPF");
		add(labelCPF);

		textFieldCPF = new JTextField(14);
		textFieldCPF.setDocument(new TamanhoUpperCase(14));
		add(textFieldCPF);

		labelCNPJ = new JLabel("CNPJ");
		add(labelCNPJ);

		textFieldCNPJ = new JTextField(19);
		textFieldCNPJ.setDocument(new TamanhoUpperCase(19));
		add(textFieldCNPJ);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 33, 1, // rows, cols
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
		Empresa empresa = null;
		List<Empresa> empresas = (List<Empresa>) EmpresaDaoFacade.getRegistro();
		Collections.sort(empresas, new EmpresaSort().new NomeFantasia());
		boxEmpresa.removeAllItems();
		for (Empresa b : empresas) {
			boxEmpresa.addItem(b);
		}
		if (!MainGerenteEventos.getFrameCadastroCompromisso().isShowing()
				&& MainGerenteEventos.getFrameCadastroCompromisso().getCompromissoHandle().getCompromisso() != null) {
			empresa = MainGerenteEventos.getFrameCadastroCompromisso().getCompromissoHandle().getCompromisso().getEmpresa();
			boxEmpresa.setSelectedItem(empresa);
		}

	}
}
