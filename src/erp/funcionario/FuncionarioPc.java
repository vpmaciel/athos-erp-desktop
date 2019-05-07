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

	private JComboBox<CentroCusto> boxCentroCusto;
	private JComboBox<String> boxCor;
	private JComboBox<String> boxDeficiencia;
	private JComboBox<String> boxEscolaridade;
	private JComboBox<String> boxEstadoCivil;
	private JComboBox<String> boxNacionalidade;
	private JComboBox<String> boxSexo;
	private ConfiguracaoGui configuracaoGui;
	private JTextField fieldBairro;
	private JTextField fieldCargo;
	private JTextField fieldCategoria;
	private JFormattedTextField fieldCep;
	private JTextField fieldCidade;
	private JTextField fieldCNHCategoria;
	private JFormattedTextField fieldCNPJ;
	private JTextField fieldComplemento;
	private JTextField fieldConjuge;
	private JFormattedTextField fieldCPF;
	private JTextField fieldCTPS;
	private JTextField fieldDepartamento;
	private JTextField fieldEmail;
	private JTextField fieldEmpresa;
	private JTextField fieldEstado;
	private JFormattedTextField fieldFax;
	private JTextField fieldFilhos;
	private JFormattedTextField fieldFone1;
	private JFormattedTextField fieldFone2;
	private JTextField fieldGerente;
	private JTextField fieldLogradouro;
	private JTextField fieldMatricula;
	private JTextField fieldNome;
	private JTextField fieldPais;
	private JFormattedTextField fieldPIS;
	private JTextField fieldRGNumero;
	private JTextField fieldRGOrgaoEmisssor;
	private JTextField fieldSalario;
	private JTextField fieldTurno;
	private JLabel labelCentroCusto;
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

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JTextField getGuiBairro() {
		return fieldBairro;
	}

	public JTextField getGuiCargo() {
		return fieldCargo;
	}

	public JTextField getGuiCategoria() {
		return fieldCategoria;
	}

	public JComboBox<CentroCusto> getGuiCentroCusto() {
		return boxCentroCusto;
	}

	public JFormattedTextField getGuiCep() {
		return fieldCep;
	}

	public JTextField getGuiCidade() {
		return fieldCidade;
	}

	public JTextField getGuiCNHCategoria() {
		return fieldCNHCategoria;
	}

	public JFormattedTextField getGuiCnpj() {
		return fieldCNPJ;
	}

	public JTextField getGuiComplemento() {
		return fieldComplemento;
	}

	public JTextField getGuiConjuge() {
		return fieldConjuge;
	}

	public JComboBox<String> getGuiCor() {
		return boxCor;
	}

	public JFormattedTextField getGuiCpf() {
		return fieldCPF;
	}

	public JTextField getGuiCtps() {
		return fieldCTPS;
	}

	public JComboBox<String> getGuiDeficiencia() {
		return boxDeficiencia;
	}

	public JTextField getGuiDepartamento() {
		return fieldDepartamento;
	}

	public JTextField getGuiEmail() {
		return fieldEmail;
	}

	public JTextField getGuiEmpresa() {
		return fieldEmpresa;
	}

	public JComboBox<String> getGuiEscolaridade() {
		return boxEscolaridade;
	}

	public JTextField getGuiEstado() {
		return fieldEstado;
	}

	public JComboBox<String> getGuiEstadoCivil() {
		return boxEstadoCivil;
	}

	public JFormattedTextField getGuiFax() {
		return fieldFax;
	}

	public JTextField getGuiFilhos() {
		return fieldFilhos;
	}

	public JFormattedTextField getGuiFone1() {
		return fieldFone1;
	}

	public JFormattedTextField getGuiFone2() {
		return fieldFone2;
	}

	public JTextField getGuiGerente() {
		return fieldGerente;
	}

	public JTextField getGuiLogradouro() {
		return fieldLogradouro;
	}

	public JTextField getGuiMatricula() {
		return fieldMatricula;
	}

	public JComboBox<String> getGuiNacionalidade() {
		return boxNacionalidade;
	}

	public JTextField getGuiNome() {
		return fieldNome;
	}

	public JTextField getGuiPais() {
		return fieldPais;
	}

	public JFormattedTextField getGuiPis() {
		return fieldPIS;
	}

	public JTextField getGuiRGNumero() {
		return fieldRGNumero;
	}

	public JTextField getGuiRGOrgaoEmisssor() {
		return fieldRGOrgaoEmisssor;
	}

	public JTextField getGuiSalario() {
		return fieldSalario;
	}

	public JComboBox<String> getGuiSexo() {
		return boxSexo;
	}

	public JTextField getGuiTurno() {
		return fieldTurno;
	}

	public JLabel getLabelCentroCusto() {
		return labelCentroCusto;
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

		final Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

		toolBar = new ToolBar();

		add(toolBar.getToolBar());

		add(new JLabel("NOME"));

		fieldNome = new JTextField();
		fieldNome.setDocument(new EntradaMaiuscula(50));
		add(fieldNome);

		add(new JLabel("ESTADO CIVIL"));

		boxEstadoCivil = new JComboBox<String>();
		boxEstadoCivil.addItem("");
		boxEstadoCivil.addItem("SOLTEIRO (A)");
		boxEstadoCivil.addItem("CASADO (A)");
		boxEstadoCivil.addItem("SEPARADO (A)");
		boxEstadoCivil.addItem("DIVORCIADO (A)");
		boxEstadoCivil.addItem("VIÚVO (A)");
		add(boxEstadoCivil);

		add(new JLabel("DEFICIÊNCIA"));

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

		add(new JLabel("ESCOLARIDADE"));

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

		add(new JLabel("NACIONALIDADE"));

		boxNacionalidade = new JComboBox<String>();
		boxNacionalidade.addItem("");
		boxNacionalidade.addItem("BRASILEIRO (A) NATO (A)");
		boxNacionalidade.addItem("BRASILEIRO (A) NATURALIZADO (A)");
		boxNacionalidade.addItem("ESTRANGEIRO (A)");
		add(boxNacionalidade);

		add(new JLabel("COR"));

		boxCor = new JComboBox<String>();
		boxCor.addItem("");
		boxCor.addItem("BRANCO (A)");
		boxCor.addItem("PRETO (A)");
		boxCor.addItem("PARDO (A)");
		boxCor.addItem("AMARELO (A)");
		boxCor.addItem("INDÍGENA");
		add(boxCor);

		add(new JLabel("SEXO"));

		boxSexo = new JComboBox<String>();
		boxSexo.addItem("");
		boxSexo.addItem("MASCULINO");
		boxSexo.addItem("FEMININO");
		add(boxSexo);

		add(new JLabel("MATRÍCULA"));

		fieldMatricula = new JTextField();
		fieldMatricula.setDocument(new EntradaMaiuscula(20));
		add(fieldMatricula);

		add(new JLabel("CÔNJUGE"));

		fieldConjuge = new JTextField();
		fieldConjuge.setDocument(new EntradaMaiuscula(50));
		add(fieldConjuge);

		add(new JLabel("FILHOS"));

		fieldFilhos = new JTextField();
		fieldFilhos.setDocument(new EntradaMaiuscula(2));
		add(fieldFilhos);

		add(new JLabel("TELEFONE"));

		fieldFone1 = new JFormattedTextField(Mascara.getFone());
		fieldFone1.setDocument(new EntradaMaiuscula(20));
		add(fieldFone1);

		add(new JLabel("TELEFONE"));

		fieldFone2 = new JFormattedTextField(Mascara.getFone());
		fieldFone2.setDocument(new EntradaMaiuscula(20));
		add(fieldFone2);

		add(new JLabel("FAX"));

		fieldFax = new JFormattedTextField(Mascara.getFax());
		fieldFax.setDocument(new EntradaMaiuscula(20));
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

		fieldCep = new JFormattedTextField(Mascara.getCep());
		add(fieldCep);

		add(new JLabel("CARGO"));

		fieldCargo = new JTextField();
		fieldCargo.setDocument(new EntradaMaiuscula(50));
		add(fieldCargo);

		add(new JLabel("CATEGORIA"));

		fieldCategoria = new JTextField();
		fieldCategoria.setDocument(new EntradaMaiuscula(50));
		add(fieldCategoria);

		add(new JLabel("DEPARTAMENTO"));

		fieldDepartamento = new JTextField();
		fieldDepartamento.setDocument(new EntradaMaiuscula(50));
		add(fieldDepartamento);

		add(new JLabel("EMPRESA"));

		fieldEmpresa = new JTextField();
		fieldEmpresa.setDocument(new EntradaMaiuscula(50));
		add(fieldEmpresa);

		add(new JLabel("GERENTE"));

		fieldGerente = new JTextField();
		fieldGerente.setDocument(new EntradaMaiuscula(50));
		add(fieldGerente);

		add(new JLabel("SALÁRIO"));

		fieldSalario = new JTextField();
		fieldSalario.setDocument(new EntradaMaiuscula(10));
		add(fieldSalario);

		add(new JLabel("TURNO"));

		fieldTurno = new JTextField();
		fieldTurno.setDocument(new EntradaMaiuscula(50));
		add(fieldTurno);

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

		add(new JLabel("CNH"));

		fieldCNHCategoria = new JTextField();
		fieldCNHCategoria.setDocument(new EntradaMaiuscula(15));
		add(fieldCNHCategoria);

		add(new JLabel("CPF"));

		fieldCPF = new JFormattedTextField(Mascara.getCpf());
		add(fieldCPF);

		add(new JLabel("CTPS"));

		fieldCTPS = new JTextField();
		fieldCTPS.setDocument(new EntradaMaiuscula(20));
		add(fieldCTPS);

		add(new JLabel("PIS"));

		fieldPIS = new JFormattedTextField(Mascara.getPis());
		add(fieldPIS);

		add(new JLabel("IDENTIDADE NÚMERO"));

		fieldRGNumero = new JTextField();
		fieldRGNumero.setDocument(new EntradaMaiuscula(15));
		add(fieldRGNumero);

		add(new JLabel("IDENTIDADE ÓRGÃO EMISSOR"));

		fieldRGOrgaoEmisssor = new JTextField();
		fieldRGOrgaoEmisssor.setDocument(new EntradaMaiuscula(20));
		add(fieldRGOrgaoEmisssor);

		add(new JLabel("CNPJ"));

		fieldCNPJ = new JFormattedTextField(Mascara.getCnpj());
		add(fieldCNPJ);

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
