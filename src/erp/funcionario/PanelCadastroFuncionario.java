package erp.funcionario;

import java.awt.Cursor;
import java.util.Collections;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.Gui;
import arquitetura.gui.GuiHandle;
import arquitetura.gui.TamanhoLowerCase;
import arquitetura.gui.TamanhoUpperCase;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import erp.centrocusto.CentroCusto;
import erp.centrocusto.CentroCustoDaoFacade;
import erp.centrocusto.CentroCustoSort;
import erp.main.MainGerenteEventos;

@SuppressWarnings("serial")
public final class PanelCadastroFuncionario extends JPanel implements Gui {

	private GuiHandle guiHandle;
	private JComboBox<String> boxSexo;
	private JTextField textFieldNome;
	private JComboBox<String> boxEstadoCivil;
	private JComboBox<String> boxEscolaridade;
	private JComboBox<String> boxNacionalidade;
	private JComboBox<String> boxDeficiencia;
	private JComboBox<String> boxCor;
	private JTextField textFieldConjuge;
	private JTextField textFieldFilhos;
	private JTextField textFieldMatricula;
	private JLabel labelEstadoCivil;
	private JLabel labelEscolaridade;
	private JLabel labelNacionalidade;
	private JLabel labelDeficiencia;
	private JLabel labelCor;
	private JLabel labelSexo;
	private JLabel labelNome;
	private JLabel labelConjuge;
	private JLabel labelFilhos;
	private JLabel labelMatricula;
	private JTextField textFieldCTPS;
	private JTextField textFieldCNHCategoria;
	private JTextField textFieldCPF;
	private JTextField textFieldRGNumero;
	private JTextField textFieldRGOrgaoEmisssor;
	private JTextField textFieldPIS;
	private JTextField textFieldCNPJ;
	private JLabel labelCTPS;
	private JLabel labelCNHCategoria;
	private JLabel labelCPF;
	private JLabel labelRGNumero;
	private JLabel labelRGOrgaoEmisssor;
	private JLabel labelPIS;
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
	private JTextField textFieldDepartamento;
	private JTextField textFieldCargo;
	private JTextField textFieldCategoria;
	private JTextField textFieldGerente;
	private JTextField textFieldSalario;
	private JTextField textFieldTurno;
	private JComboBox<CentroCusto> boxCentroCusto;
	private JTextField textFieldEmpresa;
	private JLabel labelDepartamento;
	private JLabel labelCargo;
	private JLabel labelCategoria;
	private JLabel labelGerente;
	private JLabel labelSalario;
	private JLabel labelTurno;
	private JLabel labelCentroCusto;
	private JLabel labelEmpresa;
	private ToolBar toolBar;

	public PanelCadastroFuncionario() {
		iniciarLayout();
		iniciarGui();
		iniciarFocusTabListener();
		iniciarGuiGerenteEventos();
	}

	@Override
	public void atualizarTable() {

	}

	public JComboBox<CentroCusto> getBoxCentroCusto() {
		return boxCentroCusto;
	}

	public JComboBox<String> getBoxCor() {
		return boxCor;
	}

	public JComboBox<String> getBoxDeficiencia() {
		return boxDeficiencia;
	}

	public JComboBox<String> getBoxEscolaridade() {
		return boxEscolaridade;
	}

	public JComboBox<String> getBoxEstadoCivil() {
		return boxEstadoCivil;
	}

	public JComboBox<String> getBoxNacionalidade() {
		return boxNacionalidade;
	}

	public JComboBox<String> getBoxSexo() {
		return boxSexo;
	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public JLabel getLabelCentroCusto() {
		return labelCentroCusto;
	}

	public JTextField getTextFieldBairro() {
		return textFieldBairro;
	}

	public JTextField getTextFieldCargo() {
		return textFieldCargo;
	}

	public JTextField getTextFieldCategoria() {
		return textFieldCategoria;
	}

	public JTextField getTextFieldCep() {
		return textFieldCep;
	}

	public JTextField getTextFieldCidade() {
		return textFieldCidade;
	}

	public JTextField getTextFieldCNHCategoria() {
		return textFieldCNHCategoria;
	}

	public JTextField getTextFieldCNPJ() {
		return textFieldCNPJ;
	}

	public JTextField getTextFieldComplemento() {
		return textFieldComplemento;
	}

	public JTextField getTextFieldConjuge() {
		return textFieldConjuge;
	}

	public JTextField getTextFieldCPF() {
		return textFieldCPF;
	}

	public JTextField getTextFieldCTPS() {
		return textFieldCTPS;
	}

	public JTextField getTextFieldDepartamento() {
		return textFieldDepartamento;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JTextField getTextFieldEmpresa() {
		return textFieldEmpresa;
	}

	public JTextField getTextFieldEstado() {
		return textFieldEstado;
	}

	public JTextField getTextFieldFax() {
		return textFieldFax;
	}

	public JTextField getTextFieldFilhos() {
		return textFieldFilhos;
	}

	public JTextField getTextFieldFone1() {
		return textFieldFone1;
	}

	public JTextField getTextFieldFone2() {
		return textFieldFone2;
	}

	public JTextField getTextFieldGerente() {
		return textFieldGerente;
	}

	public JTextField getTextFieldLogradouro() {
		return textFieldLogradouro;
	}

	public JTextField getTextFieldMatricula() {
		return textFieldMatricula;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JTextField getTextFieldPais() {
		return textFieldPais;
	}

	public JTextField getTextFieldPIS() {
		return textFieldPIS;
	}

	public JTextField getTextFieldRGNumero() {
		return textFieldRGNumero;
	}

	public JTextField getTextFieldRGOrgaoEmisssor() {
		return textFieldRGOrgaoEmisssor;
	}

	public JTextField getTextFieldSalario() {
		return textFieldSalario;
	}

	public JTextField getTextFieldTurno() {
		return textFieldTurno;
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
		textFieldNome.setDocument(new TamanhoUpperCase(50));
		add(textFieldNome);

		labelEstadoCivil = new JLabel("ESTADO CIVIL");
		add(labelEstadoCivil);

		boxEstadoCivil = new JComboBox<String>();
		boxEstadoCivil.addItem("");
		boxEstadoCivil.addItem("SOLTEIRO (A)");
		boxEstadoCivil.addItem("CASADO (A)");
		boxEstadoCivil.addItem("SEPARADO (A)");
		boxEstadoCivil.addItem("DIVORCIADO (A)");
		boxEstadoCivil.addItem("VIÚVO (A)");
		add(boxEstadoCivil);

		labelDeficiencia = new JLabel("DEFICIÊNCIA");
		add(labelDeficiencia);

		boxDeficiencia = new JComboBox<String>();
		boxDeficiencia.addItem("");
		boxDeficiencia.addItem("NÃO POSSUI DEFICIÊNCIA");
		boxDeficiencia.addItem("MOTORA");
		boxDeficiencia.addItem("FÍSICA");
		boxDeficiencia.addItem("MENTAL");
		boxDeficiencia.addItem("AUDITIVA");
		boxDeficiencia.addItem("FALA");
		boxDeficiencia.addItem("MÚLTIPLA");
		add(boxDeficiencia);

		labelEscolaridade = new JLabel("ESCOLARIDADE");
		add(labelEscolaridade);

		boxEscolaridade = new JComboBox<String>();
		boxEscolaridade.addItem("");
		boxEscolaridade.addItem("PÓS DOUTORADO");
		boxEscolaridade.addItem("DOUTORADO");
		boxEscolaridade.addItem("MESTRADO");
		boxEscolaridade.addItem("PÓS GRADUAÇÃO");
		boxEscolaridade.addItem("SUPERIOR COMPLETO");
		boxEscolaridade.addItem("SUPERIOR INCOMPLETO");
		boxEscolaridade.addItem("SEGUNDO GRAU COMPLETO");
		boxEscolaridade.addItem("SEGUNDO GRAU INCOMPLETO");
		boxEscolaridade.addItem("PRIMEIRO GRAU COMPLETO");
		boxEscolaridade.addItem("PRIMEIRO GRAU INCOMPLETO");
		add(boxEscolaridade);

		labelNacionalidade = new JLabel("NACIONALIDADE");
		add(labelNacionalidade);

		boxNacionalidade = new JComboBox<String>();
		boxNacionalidade.addItem("");
		boxNacionalidade.addItem("BRASILEIRO (A) NATO (A)");
		boxNacionalidade.addItem("BRASILEIRO (A) NATURALIZADO (A)");
		boxNacionalidade.addItem("ESTRANGEIRO (A)");
		add(boxNacionalidade);

		labelCor = new JLabel("COR");
		add(labelCor);

		boxCor = new JComboBox<String>();
		boxCor.addItem("");
		boxCor.addItem("BRANCO (A)");
		boxCor.addItem("PRETO (A)");
		boxCor.addItem("PARDO (A)");
		boxCor.addItem("AMARELO (A)");
		boxCor.addItem("INDÍGENA");
		add(boxCor);

		labelSexo = new JLabel("SEXO");
		add(labelSexo);

		boxSexo = new JComboBox<String>();
		boxSexo.addItem("");
		boxSexo.addItem("MASCULINO");
		boxSexo.addItem("FEMININO");
		add(boxSexo);

		labelMatricula = new JLabel("MATRÍCULA");
		add(labelMatricula);

		textFieldMatricula = new JTextField();
		textFieldMatricula.setDocument(new TamanhoUpperCase(20));
		add(textFieldMatricula);

		labelConjuge = new JLabel("CÔNJUGE");
		add(labelConjuge);

		textFieldConjuge = new JTextField();
		textFieldConjuge.setDocument(new TamanhoUpperCase(50));
		add(textFieldConjuge);

		labelFilhos = new JLabel("FILHOS");
		add(labelFilhos);

		textFieldFilhos = new JTextField();
		textFieldFilhos.setDocument(new TamanhoUpperCase(2));
		add(textFieldFilhos);

		labelFone1 = new JLabel("TELEFONE");
		add(labelFone1);

		textFieldFone1 = new JTextField();
		textFieldFone1.setDocument(new TamanhoUpperCase(20));
		add(textFieldFone1);

		labelFone2 = new JLabel("TELEFONE");
		add(labelFone2);

		textFieldFone2 = new JTextField();
		textFieldFone2.setDocument(new TamanhoUpperCase(20));
		add(textFieldFone2);

		labelFax = new JLabel("FAX");
		add(labelFax);

		textFieldFax = new JTextField();
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
		textFieldComplemento.setDocument(new TamanhoUpperCase(20));
		add(textFieldComplemento);

		labelCep = new JLabel("CEP");
		add(labelCep);

		textFieldCep = new JTextField();
		textFieldCep.setDocument(new TamanhoUpperCase(10));
		add(textFieldCep);

		labelCargo = new JLabel("CARGO");
		add(labelCargo);

		textFieldCargo = new JTextField();
		textFieldCargo.setDocument(new TamanhoUpperCase(50));
		add(textFieldCargo);

		labelCategoria = new JLabel("CATEGORIA");
		add(labelCategoria);

		textFieldCategoria = new JTextField();
		textFieldCategoria.setDocument(new TamanhoUpperCase(50));
		add(textFieldCategoria);

		labelDepartamento = new JLabel("DEPARTAMENTO");
		add(labelDepartamento);

		textFieldDepartamento = new JTextField();
		textFieldDepartamento.setDocument(new TamanhoUpperCase(50));
		add(textFieldDepartamento);

		labelEmpresa = new JLabel("EMPRESA");
		add(labelEmpresa);

		textFieldEmpresa = new JTextField();
		textFieldEmpresa.setDocument(new TamanhoUpperCase(50));
		add(textFieldEmpresa);

		labelGerente = new JLabel("GERENTE");
		add(labelGerente);

		textFieldGerente = new JTextField();
		textFieldGerente.setDocument(new TamanhoUpperCase(50));
		add(textFieldGerente);

		labelSalario = new JLabel("SALÁRIO");
		add(labelSalario);

		textFieldSalario = new JTextField();
		textFieldSalario.setDocument(new TamanhoUpperCase(10));
		add(textFieldSalario);

		labelTurno = new JLabel("TURNO");
		add(labelTurno);

		textFieldTurno = new JTextField();
		textFieldTurno.setDocument(new TamanhoUpperCase(50));
		add(textFieldTurno);

		labelCentroCusto = new JLabel("CENTRO DE CUSTO");
		labelCentroCusto.setCursor(cursor);
		add(labelCentroCusto);

		boxCentroCusto = new JComboBox<CentroCusto>();
		List<CentroCusto> centroCustos = (List<CentroCusto>) CentroCustoDaoFacade.getRegistro();
		Collections.sort(centroCustos, new CentroCustoSort().new Nome());
		for (CentroCusto c : centroCustos) {
			boxCentroCusto.addItem(c);
		}
		add(boxCentroCusto);

		labelCNHCategoria = new JLabel("CNH");
		add(labelCNHCategoria);

		textFieldCNHCategoria = new JTextField();
		textFieldCNHCategoria.setDocument(new TamanhoUpperCase(15));
		add(textFieldCNHCategoria);

		labelCPF = new JLabel("CPF");
		add(labelCPF);

		textFieldCPF = new JTextField();
		textFieldCPF.setDocument(new TamanhoUpperCase(14));
		add(textFieldCPF);

		labelCTPS = new JLabel("CTPS");
		add(labelCTPS);

		textFieldCTPS = new JTextField();
		textFieldCTPS.setDocument(new TamanhoUpperCase(20));
		add(textFieldCTPS);

		labelPIS = new JLabel("PIS");
		add(labelPIS);

		textFieldPIS = new JTextField();
		textFieldPIS.setDocument(new TamanhoUpperCase(20));
		add(textFieldPIS);

		labelRGNumero = new JLabel("IDENTIDADE NÚMERO");
		add(labelRGNumero);

		textFieldRGNumero = new JTextField();
		textFieldRGNumero.setDocument(new TamanhoUpperCase(15));
		add(textFieldRGNumero);

		labelRGOrgaoEmisssor = new JLabel("IDENTIDADE ÓRGÃO EMISSOR");
		add(labelRGOrgaoEmisssor);

		textFieldRGOrgaoEmisssor = new JTextField();
		textFieldRGOrgaoEmisssor.setDocument(new TamanhoUpperCase(20));
		add(textFieldRGOrgaoEmisssor);

		labelCNPJ = new JLabel("CNPJ");
		add(labelCNPJ);

		textFieldCNPJ = new JTextField();
		textFieldCNPJ.setDocument(new TamanhoUpperCase(19));
		add(textFieldCNPJ);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 73, 1, // rows, cols
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
		CentroCusto centroCusto = null;
		List<CentroCusto> centroCustos = (List<CentroCusto>) CentroCustoDaoFacade.getRegistro();
		Collections.sort(centroCustos, new CentroCustoSort().new Nome());
		this.boxCentroCusto.removeAllItems();
		for (CentroCusto b : centroCustos) {
			this.boxCentroCusto.addItem(b);
		}
		if (!MainGerenteEventos.getFrameCadastroFuncionario().isShowing()
				&& MainGerenteEventos.getFrameCadastroFuncionario().getFuncionarioHandle().getFuncionario() != null) {
			centroCusto = MainGerenteEventos.getFrameCadastroFuncionario().getFuncionarioHandle().getFuncionario()
					.getCentroCusto();
			boxCentroCusto.setSelectedItem(centroCusto);
		}
	}
}
