package erp.funcionario;

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
import erp.centrocusto.CentroCusto;
import erp.centrocusto.CentroCustoComp;
import erp.centrocusto.CentroCustoFac;
import erp.main.MainCont;

@SuppressWarnings("serial")
public final class FuncionarioPc extends JPanel implements Gui {

	private ConfiguracaoGui configuracaoGui;
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
	private JFormattedTextField textFieldCPF;
	private JTextField textFieldRGNumero;
	private JTextField textFieldRGOrgaoEmisssor;
	private JFormattedTextField textFieldPIS;
	private JFormattedTextField textFieldCNPJ;
	private JLabel labelCTPS;
	private JLabel labelCNHCategoria;
	private JLabel labelCPF;
	private JLabel labelRGNumero;
	private JLabel labelRGOrgaoEmisssor;
	private JLabel labelPIS;
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

	public FuncionarioPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public JComboBox<CentroCusto> getGuiCentroCusto() {
		return boxCentroCusto;
	}

	public JComboBox<String> getGuiCor() {
		return boxCor;
	}

	public JComboBox<String> getGuiDeficiencia() {
		return boxDeficiencia;
	}

	public JComboBox<String> getGuiEscolaridade() {
		return boxEscolaridade;
	}

	public JComboBox<String> getGuiEstadoCivil() {
		return boxEstadoCivil;
	}

	public JComboBox<String> getGuiNacionalidade() {
		return boxNacionalidade;
	}

	public JComboBox<String> getGuiSexo() {
		return boxSexo;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JLabel getLabelCentroCusto() {
		return labelCentroCusto;
	}

	public JTextField getGuiBairro() {
		return textFieldBairro;
	}

	public JTextField getGuiCargo() {
		return textFieldCargo;
	}

	public JTextField getGuiCategoria() {
		return textFieldCategoria;
	}

	public JFormattedTextField getGuiCep() {
		return textFieldCep;
	}

	public JTextField getGuiCidade() {
		return textFieldCidade;
	}

	public JTextField getGuiCNHCategoria() {
		return textFieldCNHCategoria;
	}

	public JFormattedTextField getGuiCnpj() {
		return textFieldCNPJ;
	}

	public JTextField getGuiComplemento() {
		return textFieldComplemento;
	}

	public JTextField getGuiConjuge() {
		return textFieldConjuge;
	}

	public JFormattedTextField getGuiCpf() {
		return textFieldCPF;
	}

	public JTextField getGuiCtps() {
		return textFieldCTPS;
	}

	public JTextField getGuiDepartamento() {
		return textFieldDepartamento;
	}

	public JTextField getGuiEmail() {
		return textFieldEmail;
	}

	public JTextField getGuiEmpresa() {
		return textFieldEmpresa;
	}

	public JTextField getGuiEstado() {
		return textFieldEstado;
	}

	public JFormattedTextField getGuiFax() {
		return textFieldFax;
	}

	public JTextField getGuiFilhos() {
		return textFieldFilhos;
	}

	public JFormattedTextField getGuiFone1() {
		return textFieldFone1;
	}

	public JFormattedTextField getGuiFone2() {
		return textFieldFone2;
	}

	public JTextField getGuiGerente() {
		return textFieldGerente;
	}

	public JTextField getGuiLogradouro() {
		return textFieldLogradouro;
	}

	public JTextField getGuiMatricula() {
		return textFieldMatricula;
	}

	public JTextField getGuiNome() {
		return textFieldNome;
	}

	public JTextField getGuiPais() {
		return textFieldPais;
	}

	public JFormattedTextField getGuiPis() {
		return textFieldPIS;
	}

	public JTextField getGuiRGNumero() {
		return textFieldRGNumero;
	}

	public JTextField getGuiRGOrgaoEmisssor() {
		return textFieldRGOrgaoEmisssor;
	}

	public JTextField getGuiSalario() {
		return textFieldSalario;
	}

	public JTextField getGuiTurno() {
		return textFieldTurno;
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

		final Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

		toolBar = new ToolBar();

		add(toolBar.getToolBar());

		labelNome = new JLabel("NOME");
		add(labelNome);

		textFieldNome = new JTextField();
		textFieldNome.setDocument(new EntradaMaiuscula(50));
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
		textFieldMatricula.setDocument(new EntradaMaiuscula(20));
		add(textFieldMatricula);

		labelConjuge = new JLabel("CÔNJUGE");
		add(labelConjuge);

		textFieldConjuge = new JTextField();
		textFieldConjuge.setDocument(new EntradaMaiuscula(50));
		add(textFieldConjuge);

		labelFilhos = new JLabel("FILHOS");
		add(labelFilhos);

		textFieldFilhos = new JTextField();
		textFieldFilhos.setDocument(new EntradaMaiuscula(2));
		add(textFieldFilhos);

		labelFone1 = new JLabel("TELEFONE");
		add(labelFone1);

		textFieldFone1 = new JFormattedTextField(Mascara.getFone());
		textFieldFone1.setDocument(new EntradaMaiuscula(20));
		add(textFieldFone1);

		labelFone2 = new JLabel("TELEFONE");
		add(labelFone2);

		textFieldFone2 = new JFormattedTextField(Mascara.getFone());
		textFieldFone2.setDocument(new EntradaMaiuscula(20));
		add(textFieldFone2);

		labelFax = new JLabel("FAX");
		add(labelFax);

		textFieldFax = new JFormattedTextField(Mascara.getFax());
		textFieldFax.setDocument(new EntradaMaiuscula(20));
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
		add(textFieldCep);

		labelCargo = new JLabel("CARGO");
		add(labelCargo);

		textFieldCargo = new JTextField();
		textFieldCargo.setDocument(new EntradaMaiuscula(50));
		add(textFieldCargo);

		labelCategoria = new JLabel("CATEGORIA");
		add(labelCategoria);

		textFieldCategoria = new JTextField();
		textFieldCategoria.setDocument(new EntradaMaiuscula(50));
		add(textFieldCategoria);

		labelDepartamento = new JLabel("DEPARTAMENTO");
		add(labelDepartamento);

		textFieldDepartamento = new JTextField();
		textFieldDepartamento.setDocument(new EntradaMaiuscula(50));
		add(textFieldDepartamento);

		labelEmpresa = new JLabel("EMPRESA");
		add(labelEmpresa);

		textFieldEmpresa = new JTextField();
		textFieldEmpresa.setDocument(new EntradaMaiuscula(50));
		add(textFieldEmpresa);

		labelGerente = new JLabel("GERENTE");
		add(labelGerente);

		textFieldGerente = new JTextField();
		textFieldGerente.setDocument(new EntradaMaiuscula(50));
		add(textFieldGerente);

		labelSalario = new JLabel("SALÁRIO");
		add(labelSalario);

		textFieldSalario = new JTextField();
		textFieldSalario.setDocument(new EntradaMaiuscula(10));
		add(textFieldSalario);

		labelTurno = new JLabel("TURNO");
		add(labelTurno);

		textFieldTurno = new JTextField();
		textFieldTurno.setDocument(new EntradaMaiuscula(50));
		add(textFieldTurno);

		labelCentroCusto = new JLabel("CENTRO DE CUSTO");
		labelCentroCusto.setCursor(cursor);
		add(labelCentroCusto);

		boxCentroCusto = new JComboBox<CentroCusto>();
		List<CentroCusto> centroCustos = (List<CentroCusto>) CentroCustoFac.getRegistro();
		Collections.sort(centroCustos, new CentroCustoComp().new Nome());
		for (CentroCusto c : centroCustos) {
			boxCentroCusto.addItem(c);
		}
		add(boxCentroCusto);

		labelCNHCategoria = new JLabel("CNH");
		add(labelCNHCategoria);

		textFieldCNHCategoria = new JTextField();
		textFieldCNHCategoria.setDocument(new EntradaMaiuscula(15));
		add(textFieldCNHCategoria);

		labelCPF = new JLabel("CPF");
		add(labelCPF);

		textFieldCPF = new JFormattedTextField(Mascara.getCpf());
		add(textFieldCPF);

		labelCTPS = new JLabel("CTPS");
		add(labelCTPS);

		textFieldCTPS = new JTextField();
		textFieldCTPS.setDocument(new EntradaMaiuscula(20));
		add(textFieldCTPS);

		labelPIS = new JLabel("PIS");
		add(labelPIS);

		textFieldPIS = new JFormattedTextField(Mascara.getPis());
		add(textFieldPIS);

		labelRGNumero = new JLabel("IDENTIDADE NÚMERO");
		add(labelRGNumero);

		textFieldRGNumero = new JTextField();
		textFieldRGNumero.setDocument(new EntradaMaiuscula(15));
		add(textFieldRGNumero);

		labelRGOrgaoEmisssor = new JLabel("IDENTIDADE ÓRGÃO EMISSOR");
		add(labelRGOrgaoEmisssor);

		textFieldRGOrgaoEmisssor = new JTextField();
		textFieldRGOrgaoEmisssor.setDocument(new EntradaMaiuscula(20));
		add(textFieldRGOrgaoEmisssor);

		labelCNPJ = new JLabel("CNPJ");
		add(labelCNPJ);

		textFieldCNPJ = new JFormattedTextField(Mascara.getCnpj());
		add(textFieldCNPJ);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 73, 1, // rows, cols
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
		setBorder(BorderFactory.createTitledBorder("FUNCIONÁRIO"));
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
		CentroCusto centroCusto = null;
		List<CentroCusto> centroCustos = (List<CentroCusto>) CentroCustoFac.getRegistro();
		Collections.sort(centroCustos, new CentroCustoComp().new Nome());
		this.boxCentroCusto.removeAllItems();
		for (CentroCusto b : centroCustos) {
			this.boxCentroCusto.addItem(b);
		}
		if (!MainCont.getFuncionarioFc().isShowing()
				&& MainCont.getFuncionarioFc().getFuncionarioCont().getFuncionario() != null) {
			centroCusto = MainCont.getFuncionarioFc().getFuncionarioCont().getFuncionario().getCentroCusto();
			boxCentroCusto.setSelectedItem(centroCusto);
		}

	}
}
