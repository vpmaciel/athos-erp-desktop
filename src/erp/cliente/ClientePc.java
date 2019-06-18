package erp.cliente;

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
import erp.banco.Banco;
import erp.banco.BancoComp;
import erp.banco.BancoFac;
import erp.empresa.Empresa;
import erp.empresa.EmpresaComp;
import erp.empresa.EmpresaFac;
import erp.main.MainCont;

@SuppressWarnings("serial")
public final class ClientePc extends JPanel implements Gui {

	private JComboBox<Banco> boxBanco;
	private JComboBox<String> boxClasseEconomica;
	private JComboBox<String> boxDeficiencia;
	private JComboBox<Empresa> boxEmpresa;
	private JComboBox<String> boxEscolaridade;
	private JComboBox<String> boxEstadoCivil;
	private JComboBox<String> boxNacionalidade;
	private JComboBox<String> boxRelacionamentoReferencia1;
	private JComboBox<String> boxRelacionamentoReferencia2;
	private JComboBox<String> boxRelacionamentoReferencia3;
	private JComboBox<String> boxSexo;
	private JComboBox<String> boxStatus;
	private ConfiguracaoGui configuracaoGui;
	private JTextField fieldBairro;
	private JTextField fieldCargo;
	private JFormattedTextField fieldCep;
	private JTextField fieldCidade;
	private JFormattedTextField fieldCNPJ;
	private JTextField fieldComplemento;
	private JFormattedTextField fieldCPF;
	private JFormattedTextField fieldDataCadastro;
	private JFormattedTextField fieldDataNascimento;
	private JTextField fieldEmail;
	private JTextField fieldEstado;
	private JFormattedTextField fieldFax;
	private JFormattedTextField fieldFone1;
	private JFormattedTextField fieldFone2;
	private JFormattedTextField fieldFoneReferencia1;
	private JFormattedTextField fieldFoneReferencia2;
	private JFormattedTextField fieldFoneReferencia3;
	private JTextField fieldIdade;
	private JTextField fieldLogradouro;
	private JTextField fieldNome;
	private JTextField fieldNomeReferencia1;
	private JTextField fieldNomeReferencia2;
	private JTextField fieldNomeReferencia3;
	private JTextField fieldNumeroAgenciaBancaria;
	private JTextField fieldNumeroContaBancaria;
	private JTextField fieldPais;
	private JTextField fieldRGNumero;
	private JTextField fieldRGOrgaoEmisssor;
	private JTextField fieldSalario;
	private JLabel labelBanco;
	private JLabel labelEmpresa;
	private ToolBar toolBar;

	public ClientePc() {
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

	public JComboBox<Banco> getGuiBanco() {
		return boxBanco;
	}

	public JTextField getGuiCargo() {
		return fieldCargo;
	}

	public JFormattedTextField getGuiCep() {
		return fieldCep;
	}

	public JTextField getGuiCidade() {
		return fieldCidade;
	}

	public JComboBox<String> getGuiClasseEconomica() {
		return boxClasseEconomica;
	}

	public JFormattedTextField getGuiCnpj() {
		return fieldCNPJ;
	}

	public JTextField getGuiComplemento() {
		return fieldComplemento;
	}

	public JFormattedTextField getGuiCpf() {
		return fieldCPF;
	}

	public JFormattedTextField getGuiDataCadastro() {
		return fieldDataCadastro;
	}

	public JFormattedTextField getGuiDataNascimento() {
		return fieldDataNascimento;
	}

	public JComboBox<String> getGuiDeficiencia() {
		return boxDeficiencia;
	}

	public JTextField getGuiEmail() {
		return fieldEmail;
	}

	public JComboBox<Empresa> getGuiEmpresa() {
		return boxEmpresa;
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

	public JFormattedTextField getGuiFone1() {
		return fieldFone1;
	}

	public JFormattedTextField getGuiFone2() {
		return fieldFone2;
	}

	public JFormattedTextField getGuiFoneReferencia1() {
		return fieldFoneReferencia1;
	}

	public JFormattedTextField getGuiFoneReferencia2() {
		return fieldFoneReferencia2;
	}

	public JFormattedTextField getGuiFoneReferencia3() {
		return fieldFoneReferencia3;
	}

	public JTextField getGuiIdade() {
		return fieldIdade;
	}

	public JTextField getGuiLogradouro() {
		return fieldLogradouro;
	}

	public JComboBox<String> getGuiNacionalidade() {
		return boxNacionalidade;
	}

	public JTextField getGuiNome() {
		return fieldNome;
	}

	public JTextField getGuiNomeReferencia3() {
		return fieldNomeReferencia3;
	}

	public JTextField getGuiNumeroAgenciaBancaria() {
		return fieldNumeroAgenciaBancaria;
	}

	public JTextField getGuiNumeroContaBancaria() {
		return fieldNumeroContaBancaria;
	}

	public JTextField getGuiPais() {
		return fieldPais;
	}

	public JTextField getGuiReferencia1() {
		return fieldNomeReferencia1;
	}

	public JComboBox<String> getGuiRelRef1() {
		return boxRelacionamentoReferencia1;
	}

	public JComboBox<String> getGuiRelRef2() {
		return boxRelacionamentoReferencia2;
	}

	public JComboBox<String> getGuiRelRef3() {
		return boxRelacionamentoReferencia3;
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

	public JComboBox<String> getGuiStatus() {
		return boxStatus;
	}

	public JLabel getLabelBanco() {
		return labelBanco;
	}

	public JLabel getLabelEmpresa() {
		return labelEmpresa;
	}

	public JTextField getNomeGuiReferencia2() {
		return fieldNomeReferencia2;
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

		add(toolBar.getToolBar());

		add(new JLabel("NOME DO CLIENTE"));

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

		add(new JLabel("SEXO"));

		boxSexo = new JComboBox<String>();
		boxSexo.addItem("");
		boxSexo.addItem("MASCULINO");
		boxSexo.addItem("FEMININO");
		add(boxSexo);

		add(new JLabel("DATA DE CADASTRO"));

		fieldDataCadastro = new JFormattedTextField(Mascara.getData());
		add(fieldDataCadastro);

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

		add(new JLabel("DATA DE NASCIMENTO"));

		fieldDataNascimento = new JFormattedTextField(Mascara.getData());
		add(fieldDataNascimento);

		add(new JLabel("IDADE"));

		fieldIdade = new JTextField();
		fieldIdade.setDocument(new EntradaMaiuscula(3));
		add(fieldIdade);

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

		fieldCep = new JFormattedTextField(Mascara.getCep());
		add(fieldCep);

		add(new JLabel("CARGO"));

		fieldCargo = new JTextField();
		fieldCargo.setDocument(new EntradaMaiuscula(50));
		add(fieldCargo);

		add(new JLabel("CLASSE ECONÔMICA"));

		boxClasseEconomica = new JComboBox<String>();
		boxClasseEconomica.addItem("");
		boxClasseEconomica.addItem("A");
		boxClasseEconomica.addItem("B");
		boxClasseEconomica.addItem("C");
		boxClasseEconomica.addItem("D");
		boxClasseEconomica.addItem("E");
		add(boxClasseEconomica);

		labelEmpresa = new JLabel("EMPRESA");
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

		add(new JLabel("SALÁRIO"));

		fieldSalario = new JTextField();
		fieldSalario.setDocument(new EntradaMaiuscula(10));
		add(fieldSalario);

		add(new JLabel("CPF"));

		fieldCPF = new JFormattedTextField(Mascara.getCpf());
		add(fieldCPF);

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

		add(new JLabel("STATUS"));

		boxStatus = new JComboBox<String>();
		boxStatus.addItem("");
		boxStatus.addItem("ATIVO");
		boxStatus.addItem("INATIVO");
		add(boxStatus);

		labelBanco = new JLabel("BANCO");
		labelBanco.setCursor(Sis.getNovaJanelaCursor());
		add(labelBanco);

		boxBanco = new JComboBox<Banco>();
		List<Banco> listBanco = (List<Banco>) BancoFac.getRegistro();
		Collections.sort(listBanco, new BancoComp().new Nome());
		for (Banco b : listBanco) {
			boxBanco.addItem(b);
		}
		boxBanco.setMaximumRowCount(5);
		add(boxBanco);

		add(new JLabel("AGÊNCIA BANCÁRIA NÚMERO"));

		fieldNumeroAgenciaBancaria = new JTextField();
		fieldNumeroAgenciaBancaria.setDocument(new EntradaMaiuscula(20));
		add(fieldNumeroAgenciaBancaria);

		add(new JLabel("CONTA BANCÁRIA NÚMERO"));

		fieldNumeroContaBancaria = new JTextField();
		fieldNumeroContaBancaria.setDocument(new EntradaMaiuscula(20));
		add(fieldNumeroContaBancaria);

		add(new JLabel("NOME PARA REFERÊNCIA 1"));

		fieldNomeReferencia1 = new JTextField();
		fieldNomeReferencia1.setDocument(new EntradaMaiuscula(50));
		add(fieldNomeReferencia1);

		add(new JLabel("TELEFONE PARA REFERÊNCIA 1"));

		fieldFoneReferencia1 = new JFormattedTextField(Mascara.getFone());
		fieldFoneReferencia1.setDocument(new EntradaMaiuscula(10));
		add(fieldFoneReferencia1);

		add(new JLabel("NOME PARA REFERÊNCIA 1 É DO CLIENTE"));

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

		add(new JLabel("NOME PARA REFERÊNCIA 2"));

		fieldNomeReferencia2 = new JTextField();
		fieldNomeReferencia2.setDocument(new EntradaMaiuscula(50));
		add(fieldNomeReferencia2);

		add(new JLabel("TELEFONE PARA REFERÊNCIA 2"));

		fieldFoneReferencia2 = new JFormattedTextField(Mascara.getFone());
		fieldFoneReferencia2.setDocument(new EntradaMaiuscula(10));
		add(fieldFoneReferencia2);

		add(new JLabel("NOME PARA REFERÊNCIA 2 É DO CLIENTE"));

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

		add(new JLabel("NOME PARA REFERÊNCIA 3"));

		fieldNomeReferencia3 = new JTextField();
		fieldNomeReferencia3.setDocument(new EntradaMaiuscula(50));
		add(fieldNomeReferencia3);

		add(new JLabel("TELEFONE PARA REFERÊNCIA 3"));

		fieldFoneReferencia3 = new JFormattedTextField(Mascara.getFone());
		fieldFoneReferencia3.setDocument(new EntradaMaiuscula(10));
		add(fieldFoneReferencia3);

		add(new JLabel("NOME PARA REFERÊNCIA 3 É DO CLIENTE"));

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
		SpringUtilities.makeCompactGrid(this, 83, 1, // rows, cols
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
		configuracaoGui.limparGui();
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
		List<Banco> listBanco = (List<Banco>) BancoFac.getRegistro();
		Collections.sort(listBanco, new BancoComp().new Nome());
		boxBanco.removeAllItems();
		for (Banco b : listBanco) {
			boxBanco.addItem(b);
		}
		if (!MainCont.getClienteFc().isShowing() && MainCont.getClienteFc().getClienteCont().getCliente() != null) {
			empresa = MainCont.getClienteFc().getClienteCont().getCliente().getEmpresa();
			if (empresa != null) {
				boxEmpresa.setSelectedItem(empresa);
			}
			banco = MainCont.getClienteFc().getClienteCont().getCliente().getBanco();

			if (banco != null) {
				banco = MainCont.getClienteFc().getClienteCont().getCliente().getBanco();
			}
		}
	}
}
