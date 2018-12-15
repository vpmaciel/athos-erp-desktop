package erp.cliente;

import java.awt.Cursor;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMinuscula;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import erp.banco.Banco;
import erp.banco.BancoFac;
import erp.banco.BancoComp;
import erp.empresa.Empresa;
import erp.empresa.EmpresaFac;
import erp.empresa.EmpresaComp;
import erp.main.MainCont;

@SuppressWarnings("serial")
public final class ClientePc extends JPanel implements Gui {

	private final BancoFac bancoFac = new BancoFac();
	private ToolBar toolBar;
	private ConfiguracaoGui configuracaoGui;
	private JComboBox<String> boxEscolaridade;
	private JComboBox<String> boxNacionalidade;
	private JComboBox<String> boxDeficiencia;
	private JComboBox<String> boxCor;
	private JComboBox<String> boxSexo;
	private JTextField textFieldNome;
	private JComboBox<String> boxEstadoCivil;
	private JTextField textFieldDataCadastro;
	private JLabel labelSexo;
	private JLabel labelStatus;
	private JLabel labelNome;
	private JLabel labelDataNascimento;
	private JLabel labelIdade;
	private JLabel labelNumeroAgenciaBancaria;
	private JLabel labelEstadoCivil;
	private JLabel labelDataCadastro;
	private JLabel labelBanco;
	private JTextField textFieldDataNascimento;
	private JTextField textFieldIdade;
	private JTextField textFieldCPF;
	private JTextField textFieldRGNumero;
	private JTextField textFieldRGOrgaoEmisssor;
	private JTextField textFieldCNPJ;
	private JLabel labelCPF;
	private JLabel labelRGNumero;
	private JLabel labelRGOrgaoEmisssor;
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
	private JTextField textFieldNumeroContaBancaria;
	private JLabel labelBairro;
	private JLabel labelCep;
	private JLabel labelCidade;
	private JLabel labelComplemento;
	private JLabel labelEstado;
	private JLabel labelLogradouro;
	private JLabel labelPais;
	private JTextField textFieldCargo;
	private JComboBox<String> boxClasseEconomica;
	private JTextField textFieldSalario;
	private JTextField textFieldNumeroAgenciaBancaria;
	private JComboBox<Empresa> boxEmpresa;
	private JComboBox<String> boxStatus;
	private JComboBox<Banco> boxBanco;
	private JLabel labelCargo;
	private JLabel labelClasseEconomica;
	private JLabel labelSalario;
	private JLabel labelEmpresa;
	private JLabel labelNomeReferencia1;
	private JLabel labelNomeReferencia2;
	private JLabel labelNomeReferencia3;
	private JLabel labelFoneReferencia1;
	private JLabel labelFoneReferencia2;
	private JLabel labelFoneReferencia3;
	private JLabel labelReferenciaRelacionamento1;
	private JLabel labelReferenciaRelacionamento2;
	private JLabel labelReferenciaRelacionamento3;
	private JLabel labelEscolaridade;
	private JLabel labelNacionalidade;
	private JLabel labelDeficiencia;
	private JLabel labelCor;
	private JLabel labelNumeroContaBancaria;
	private JComboBox<String> boxRelacionamentoReferencia1;
	private JComboBox<String> boxRelacionamentoReferencia2;
	private JComboBox<String> boxRelacionamentoReferencia3;
	private JTextField textFieldNomeReferencia1;
	private JTextField textFieldNomeReferencia2;
	private JTextField textFieldNomeReferencia3;
	private JTextField textFieldFoneReferencia1;
	private JTextField textFieldFoneReferencia2;
	private JTextField textFieldFoneReferencia3;

	public ClientePc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public JComboBox<Banco> getBancoGUI() {
		return boxBanco;
	}

	public JComboBox<String> getClasseEconomicaGUI() {
		return boxClasseEconomica;
	}

	public JComboBox<String> getCorGUI() {
		return boxCor;
	}

	public JComboBox<String> getDeficienciaGUI() {
		return boxDeficiencia;
	}

	public JComboBox<Empresa> getEmpresaGUI() {
		return boxEmpresa;
	}

	public JComboBox<String> getEscolaridadeGUI() {
		return boxEscolaridade;
	}

	public JComboBox<String> getEstadoCivilGUI() {
		return boxEstadoCivil;
	}

	public JComboBox<String> getNacionalidadeGUI() {
		return boxNacionalidade;
	}

	public JComboBox<String> getRelRef1GUI() {
		return boxRelacionamentoReferencia1;
	}

	public JComboBox<String> getRelRef2GUI() {
		return boxRelacionamentoReferencia2;
	}

	public JComboBox<String> getRelRef3GUI() {
		return boxRelacionamentoReferencia3;
	}

	public JComboBox<String> getSexoGUI() {
		return boxSexo;
	}

	public JComboBox<String> getStatusGUI() {
		return boxStatus;
	}

	public JTextField geTextFieldNumeroDaAgenciaBancaria() {
		return textFieldNumeroAgenciaBancaria;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JLabel getLabelBanco() {
		return labelBanco;
	}

	public JLabel getLabelEmpresa() {
		return labelEmpresa;
	}

	public JLabel getLabelPais() {
		return labelPais;
	}

	public JTextField getBairroGUI() {
		return textFieldBairro;
	}

	public JTextField getCargoGUI() {
		return textFieldCargo;
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

	public JTextField getCpfGUI() {
		return textFieldCPF;
	}

	public JTextField getDataCadastroGUI() {
		return textFieldDataCadastro;
	}

	public JTextField getDataNascimentoGUI() {
		return textFieldDataNascimento;
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

	public JTextField getFoneReferencia1GUI() {
		return textFieldFoneReferencia1;
	}

	public JTextField getFoneReferencia2GUI() {
		return textFieldFoneReferencia2;
	}

	public JTextField getFoneReferencia3GUI() {
		return textFieldFoneReferencia3;
	}

	public JTextField getIdadeGUI() {
		return textFieldIdade;
	}

	public JTextField getLogradouroGUI() {
		return textFieldLogradouro;
	}

	public JTextField getNomeGUI() {
		return textFieldNome;
	}

	public JTextField getReferencia1GUI() {
		return textFieldNomeReferencia1;
	}

	public JTextField getNomeReferencia2GUI() {
		return textFieldNomeReferencia2;
	}

	public JTextField getNomeReferencia3GUI() {
		return textFieldNomeReferencia3;
	}

	public JTextField getNumeroAgenciaBancariaGUI() {
		return textFieldNumeroAgenciaBancaria;
	}

	public JTextField getNumeroContaBancariaGUI() {
		return textFieldNumeroContaBancaria;
	}

	public JTextField getTextFieldNumeroDaContaBancaria() {
		return textFieldNumeroContaBancaria;
	}

	public JTextField getPaisGUI() {
		return textFieldPais;
	}

	public JTextField getRGNumeroGUI() {
		return textFieldRGNumero;
	}

	public JTextField getRGOrgaoEmisssorGUI() {
		return textFieldRGOrgaoEmisssor;
	}

	public JTextField getSalarioGUI() {
		return textFieldSalario;
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

		labelNome = new JLabel("NOME DO CLIENTE");
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

		labelSexo = new JLabel("SEXO");
		add(labelSexo);

		boxSexo = new JComboBox<String>();
		boxSexo.addItem("");
		boxSexo.addItem("MASCULINO");
		boxSexo.addItem("FEMININO");
		add(boxSexo);

		labelDataCadastro = new JLabel("DATA DE CADASTRO");
		add(labelDataCadastro);

		textFieldDataCadastro = new JTextField();
		textFieldDataCadastro.setDocument(new EntradaMaiuscula(10));
		add(textFieldDataCadastro);

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

		labelDataNascimento = new JLabel("DATA DE NASCIMENTO");
		add(labelDataNascimento);

		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setDocument(new EntradaMaiuscula(10));
		add(textFieldDataNascimento);

		labelIdade = new JLabel("IDADE");
		add(labelIdade);

		textFieldIdade = new JTextField();
		textFieldIdade.setDocument(new EntradaMaiuscula(3));
		add(textFieldIdade);

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

		labelCargo = new JLabel("CARGO");
		add(labelCargo);

		textFieldCargo = new JTextField();
		textFieldCargo.setDocument(new EntradaMaiuscula(50));
		add(textFieldCargo);

		labelClasseEconomica = new JLabel("CLASSE ECONÔMICA");
		add(labelClasseEconomica);

		boxClasseEconomica = new JComboBox<String>();
		boxClasseEconomica.addItem("");
		boxClasseEconomica.addItem("A");
		boxClasseEconomica.addItem("B");
		boxClasseEconomica.addItem("C");
		boxClasseEconomica.addItem("D");
		boxClasseEconomica.addItem("E");
		add(boxClasseEconomica);

		labelEmpresa = new JLabel("EMPRESA");
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

		labelSalario = new JLabel("SALÁRIO");
		add(labelSalario);

		textFieldSalario = new JTextField();
		textFieldSalario.setDocument(new EntradaMaiuscula(10));
		add(textFieldSalario);

		labelCPF = new JLabel("CPF");
		add(labelCPF);

		textFieldCPF = new JTextField();
		textFieldCPF.setDocument(new EntradaMaiuscula(14));
		add(textFieldCPF);

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

		textFieldCNPJ = new JTextField();
		textFieldCNPJ.setDocument(new EntradaMaiuscula(19));
		add(textFieldCNPJ);

		labelStatus = new JLabel("STATUS");
		add(labelStatus);

		boxStatus = new JComboBox<String>();
		boxStatus.addItem("");
		boxStatus.addItem("ATIVO");
		boxStatus.addItem("INATIVO");
		add(boxStatus);

		labelBanco = new JLabel("BANCO");
		labelBanco.setCursor(cursor);
		add(labelBanco);

		boxBanco = new JComboBox<Banco>();
		List<Banco> bancos = (List<Banco>) bancoFac.getRegistro();
		Collections.sort(bancos, new BancoComp().new Nome());
		for (Banco b : bancos) {
			boxBanco.addItem(b);
		}
		boxBanco.setMaximumRowCount(5);
		add(boxBanco);

		labelNumeroAgenciaBancaria = new JLabel("AGÊNCIA BANCÁRIA NÚMERO");
		labelNumeroAgenciaBancaria.setCursor(cursor);
		add(labelNumeroAgenciaBancaria);

		textFieldNumeroAgenciaBancaria = new JTextField();
		textFieldNumeroAgenciaBancaria.setDocument(new EntradaMaiuscula(20));
		add(textFieldNumeroAgenciaBancaria);

		labelNumeroContaBancaria = new JLabel("CONTA BANCÁRIA NÚMERO");
		add(labelNumeroContaBancaria);

		textFieldNumeroContaBancaria = new JTextField();
		textFieldNumeroContaBancaria.setDocument(new EntradaMaiuscula(20));
		add(textFieldNumeroContaBancaria);

		labelNomeReferencia1 = new JLabel("NOME PARA REFERÊNCIA 1");
		add(labelNomeReferencia1);

		textFieldNomeReferencia1 = new JTextField();
		textFieldNomeReferencia1.setDocument(new EntradaMaiuscula(50));
		add(textFieldNomeReferencia1);

		labelFoneReferencia1 = new JLabel("TELEFONE PARA REFERÊNCIA 1");
		add(labelFoneReferencia1);

		textFieldFoneReferencia1 = new JTextField();
		textFieldFoneReferencia1.setDocument(new EntradaMaiuscula(10));
		add(textFieldFoneReferencia1);

		labelReferenciaRelacionamento1 = new JLabel("NOME PARA REFERÊNCIA 1 É DO CLIENTE");
		add(labelReferenciaRelacionamento1);

		boxRelacionamentoReferencia1 = new JComboBox<String>();
		boxRelacionamentoReferencia1.addItem("");
		boxRelacionamentoReferencia1.addItem("TRISAVÔ (Ó)");
		boxRelacionamentoReferencia1.addItem("BISAVÔ (Ó)");
		boxRelacionamentoReferencia1.addItem("AVÔ (Ó)");
		boxRelacionamentoReferencia1.addItem("CÔNJUGE");
		boxRelacionamentoReferencia1.addItem("PAI");
		boxRelacionamentoReferencia1.addItem("MÃE");
		boxRelacionamentoReferencia1.addItem("FILHO (A)");
		boxRelacionamentoReferencia1.addItem("NETO (A)");
		boxRelacionamentoReferencia1.addItem("BISNETO (A)");
		boxRelacionamentoReferencia1.addItem("TRINETO (A)");
		boxRelacionamentoReferencia1.addItem("PRIMO (A)");
		boxRelacionamentoReferencia1.addItem("TIO (A)");
		boxRelacionamentoReferencia1.addItem("SOBRINHO (A)");
		boxRelacionamentoReferencia1.addItem("IRMÃO (Ã)");
		boxRelacionamentoReferencia1.addItem("AMIGO (A)");
		boxRelacionamentoReferencia1.addItem("VIZINHO (A)");
		boxRelacionamentoReferencia1.addItem("PROFESSOR (A)");
		boxRelacionamentoReferencia1.addItem("ALUNO (A)");
		boxRelacionamentoReferencia1.addItem("CHEFE");
		boxRelacionamentoReferencia1.addItem("COLEGA DE TRABALHO");
		boxRelacionamentoReferencia1.addItem("COLEGA DE ESTUDO");
		boxRelacionamentoReferencia1.addItem("CONHECIDO (A)");
		boxRelacionamentoReferencia1.addItem("NÃO CONHECE");
		boxRelacionamentoReferencia1.addItem("NAMORADO (A)");
		boxRelacionamentoReferencia1.addItem("CLIENTE");
		boxRelacionamentoReferencia1.addItem("EMPREGADO");
		boxRelacionamentoReferencia1.addItem("EMPREGADOR");
		boxRelacionamentoReferencia1.addItem("OUTROS");
		add(boxRelacionamentoReferencia1);

		labelNomeReferencia2 = new JLabel("NOME PARA REFERÊNCIA 2");
		add(labelNomeReferencia2);

		textFieldNomeReferencia2 = new JTextField();
		textFieldNomeReferencia2.setDocument(new EntradaMaiuscula(50));
		add(textFieldNomeReferencia2);

		labelFoneReferencia2 = new JLabel("TELEFONE PARA REFERÊNCIA 2");
		add(labelFoneReferencia2);

		textFieldFoneReferencia2 = new JTextField();
		textFieldFoneReferencia2.setDocument(new EntradaMaiuscula(10));
		add(textFieldFoneReferencia2);

		labelReferenciaRelacionamento2 = new JLabel("NOME PARA REFERÊNCIA 2 É DO CLIENTE");
		add(labelReferenciaRelacionamento2);

		boxRelacionamentoReferencia2 = new JComboBox<String>();
		boxRelacionamentoReferencia2.addItem("");
		boxRelacionamentoReferencia2.addItem("TRISAVÔ (Ó)");
		boxRelacionamentoReferencia2.addItem("BISAVÔ (Ó)");
		boxRelacionamentoReferencia2.addItem("AVÔ (Ó)");
		boxRelacionamentoReferencia2.addItem("CÔNJUGE");
		boxRelacionamentoReferencia2.addItem("PAI");
		boxRelacionamentoReferencia2.addItem("MÃE");
		boxRelacionamentoReferencia2.addItem("FILHO (A)");
		boxRelacionamentoReferencia2.addItem("NETO (A)");
		boxRelacionamentoReferencia2.addItem("BISNETO (A)");
		boxRelacionamentoReferencia2.addItem("TRINETO (A)");
		boxRelacionamentoReferencia2.addItem("PRIMO (A)");
		boxRelacionamentoReferencia2.addItem("TIO (A)");
		boxRelacionamentoReferencia2.addItem("SOBRINHO (A)");
		boxRelacionamentoReferencia2.addItem("IRMÃO (Ã)");
		boxRelacionamentoReferencia2.addItem("AMIGO (A)");
		boxRelacionamentoReferencia2.addItem("VIZINHO (A)");
		boxRelacionamentoReferencia2.addItem("PROFESSOR (A)");
		boxRelacionamentoReferencia2.addItem("ALUNO (A)");
		boxRelacionamentoReferencia2.addItem("CHEFE");
		boxRelacionamentoReferencia2.addItem("COLEGA DE TRABALHO");
		boxRelacionamentoReferencia2.addItem("COLEGA DE ESTUDO");
		boxRelacionamentoReferencia2.addItem("CONHECIDO (A)");
		boxRelacionamentoReferencia2.addItem("NÃO CONHECE");
		boxRelacionamentoReferencia2.addItem("NAMORADO (A)");
		boxRelacionamentoReferencia2.addItem("CLIENTE");
		boxRelacionamentoReferencia2.addItem("EMPREGADO");
		boxRelacionamentoReferencia2.addItem("EMPREGADOR");
		boxRelacionamentoReferencia2.addItem("OUTROS");
		add(boxRelacionamentoReferencia2);

		labelNomeReferencia3 = new JLabel("NOME PARA REFERÊNCIA 3");
		add(labelNomeReferencia3);

		textFieldNomeReferencia3 = new JTextField();
		textFieldNomeReferencia3.setDocument(new EntradaMaiuscula(50));
		add(textFieldNomeReferencia3);

		labelFoneReferencia3 = new JLabel("TELEFONE PARA REFERÊNCIA 3");
		add(labelFoneReferencia3);

		textFieldFoneReferencia3 = new JTextField();
		textFieldFoneReferencia3.setDocument(new EntradaMaiuscula(10));
		add(textFieldFoneReferencia3);

		labelReferenciaRelacionamento3 = new JLabel("NOME PARA REFERÊNCIA 3 É DO CLIENTE");
		add(labelReferenciaRelacionamento3);

		boxRelacionamentoReferencia3 = new JComboBox<String>();
		boxRelacionamentoReferencia3.addItem("");
		boxRelacionamentoReferencia3.addItem("TRISAVÔ (Ó)");
		boxRelacionamentoReferencia3.addItem("BISAVÔ (Ó)");
		boxRelacionamentoReferencia3.addItem("AVÔ (Ó)");
		boxRelacionamentoReferencia3.addItem("CÔNJUGE");
		boxRelacionamentoReferencia3.addItem("PAI");
		boxRelacionamentoReferencia3.addItem("MÃE");
		boxRelacionamentoReferencia3.addItem("FILHO (A)");
		boxRelacionamentoReferencia3.addItem("NETO (A)");
		boxRelacionamentoReferencia3.addItem("BISNETO (A)");
		boxRelacionamentoReferencia3.addItem("TRINETO (A)");
		boxRelacionamentoReferencia3.addItem("PRIMO (A)");
		boxRelacionamentoReferencia3.addItem("TIO (A)");
		boxRelacionamentoReferencia3.addItem("SOBRINHO (A)");
		boxRelacionamentoReferencia3.addItem("IRMÃO (Ã)");
		boxRelacionamentoReferencia3.addItem("AMIGO (A)");
		boxRelacionamentoReferencia3.addItem("VIZINHO (A)");
		boxRelacionamentoReferencia3.addItem("PROFESSOR (A)");
		boxRelacionamentoReferencia3.addItem("ALUNO (A)");
		boxRelacionamentoReferencia3.addItem("CHEFE");
		boxRelacionamentoReferencia3.addItem("COLEGA DE TRABALHO");
		boxRelacionamentoReferencia3.addItem("COLEGA DE ESTUDO");
		boxRelacionamentoReferencia3.addItem("CONHECIDO (A)");
		boxRelacionamentoReferencia3.addItem("NÃO CONHECE");
		boxRelacionamentoReferencia3.addItem("NAMORADO (A)");
		boxRelacionamentoReferencia3.addItem("CLIENTE");
		boxRelacionamentoReferencia3.addItem("EMPREGADO");
		boxRelacionamentoReferencia3.addItem("EMPREGADOR");
		boxRelacionamentoReferencia3.addItem("OUTROS");
		add(boxRelacionamentoReferencia3);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 85, 1, // rows, cols
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
		setBorder(BorderFactory.createTitledBorder("CADASTRO"));
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
		for (Empresa b : empresas) {
			boxEmpresa.addItem(b);
		}
		Banco banco = null;
		List<Banco> bancos = (List<Banco>) bancoFac.getRegistro();
		Collections.sort(bancos, new BancoComp().new Nome());
		boxBanco.removeAllItems();
		for (Banco b : bancos) {
			boxBanco.addItem(b);
		}
		if (!MainCont.getClienteFc().isShowing()
				&& MainCont.getClienteFc().getClienteHandle().getCliente() != null) {
			empresa = MainCont.getClienteFc().getClienteHandle().getCliente().getEmpresa();
			if (empresa != null) {
				boxEmpresa.setSelectedItem(empresa);
			}
			banco = MainCont.getClienteFc().getClienteHandle().getCliente().getBanco();

			if (banco != null) {
				banco = MainCont.getClienteFc().getClienteHandle().getCliente().getBanco();
			}
		}

	}
}
