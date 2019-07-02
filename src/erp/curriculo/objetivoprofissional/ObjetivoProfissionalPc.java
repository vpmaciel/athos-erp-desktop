package erp.curriculo.objetivoprofissional;

import java.util.Collections;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import erp.funcionario.Funcionario;
import erp.funcionario.FuncionarioComp;
import erp.funcionario.FuncionarioFac;
import erp.main.MainControl;

@SuppressWarnings("serial")
public final class ObjetivoProfissionalPc extends JPanel implements Gui {

	private JComboBox<String> boxAreaInteresse;
	private JComboBox<String> boxContrato;
	private JComboBox<Funcionario> boxFuncionario;
	private JComboBox<String> boxNivelHierarquico;
	private JComboBox<String> boxPretensaoSalarial;
	private ConfiguracaoGui configuracaoGui;
	private JTextField fieldCargo;

	private JLabel labelFuncionario;
	private ToolBar toolBar;

	public ObjetivoProfissionalPc() {
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

	public JComboBox<String> getGuiAreaInteresse() {
		return boxAreaInteresse;
	}

	public JTextField getGuiCargo() {
		return fieldCargo;
	}

	public JComboBox<String> getGuiContrato() {
		return boxContrato;
	}

	public JComboBox<Funcionario> getGuiFuncionario() {
		return boxFuncionario;
	}

	public JComboBox<String> getGuiNivelHierarquico() {
		return boxNivelHierarquico;
	}

	public JComboBox<String> getGuiPretensaoSalarial() {
		return boxPretensaoSalarial;
	}

	public JLabel getLabelFuncionario() {
		return labelFuncionario;
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

		labelFuncionario = new JLabel("FUNCIONÁRIO");
		labelFuncionario.setCursor(Sis.getNovaJanelaCursor());
		add(labelFuncionario);

		boxFuncionario = new JComboBox<Funcionario>();
		List<Funcionario> funcionarios = (List<Funcionario>) FuncionarioFac.getRegistro();
		Collections.sort(funcionarios, new FuncionarioComp().new Nome());
		for (Funcionario funcionario : funcionarios) {
			boxFuncionario.addItem(funcionario);
		}
		add(boxFuncionario);

		add(new JLabel("CARGO"));

		fieldCargo = new JTextField();
		fieldCargo.setDocument(new EntradaMaiuscula(50));
		add(fieldCargo);

		add(new JLabel("CONTRATO"));

		boxContrato = new JComboBox<String>();
		boxContrato.addItem("");
		boxContrato.addItem("EFETIVO (CLT)");
		boxContrato.addItem("ESTÁGIO");
		boxContrato.addItem("TEMPORÁRIO");
		boxContrato.addItem("AUTÔNOMO");
		boxContrato.addItem("PRESTADOR DE SERVIÇOS (PJ)");
		boxContrato.addItem("TRAINEE");
		boxContrato.addItem("COOPERADO");
		boxContrato.addItem("OUTROS");
		add(boxContrato);

		add(new JLabel("PRETENSÃO SALARIAL"));

		boxPretensaoSalarial = new JComboBox<String>();
		boxPretensaoSalarial.addItem("");
		boxPretensaoSalarial.addItem("A COMBINAR");
		boxPretensaoSalarial.addItem("ATÉ R$ 1.000,00");
		boxPretensaoSalarial.addItem("DE R$ 1.000,00 ATÉ R$ 2.000,00");
		boxPretensaoSalarial.addItem("DE R$ 2.000,00 ATÉ R$ 3.000,00");
		boxPretensaoSalarial.addItem("DE R$ 3.000,00 ATÉ R$ 4.000,00");
		boxPretensaoSalarial.addItem("DE R$ 4.000,00 ATÉ R$ 5.000,00");
		boxPretensaoSalarial.addItem("DE R$ 5.000,00 ATÉ R$ 6.000,00");
		boxPretensaoSalarial.addItem("DE R$ 6.000,00 ATÉ R$ 7.000,00");
		boxPretensaoSalarial.addItem("DE R$ 7.000,00 ATÉ R$ 8.000,00");
		boxPretensaoSalarial.addItem("DE R$ 8.000,00 ATÉ R$ 9.000,00");
		boxPretensaoSalarial.addItem("DE R$ 9.000,00 ATÉ R$ 10.000,00");
		boxPretensaoSalarial.addItem("DE R$ 10.000,00 ATÉ R$ 15.000,00");
		boxPretensaoSalarial.addItem("DE R$ 15.000,00 ATÉ R$ 20.000,00");
		boxPretensaoSalarial.addItem("DE R$ 20.000,00 ATÉ R$ 25.000,00");
		boxPretensaoSalarial.addItem("DE R$ 25.000,00 ATÉ R$ 50.000,00");
		boxPretensaoSalarial.addItem("ACIMA DE R$ 50.000,00");
		add(boxPretensaoSalarial);

		add(new JLabel("NÍVEL HIERÁRQUICO"));

		boxNivelHierarquico = new JComboBox<String>();
		boxNivelHierarquico.addItem("");
		boxNivelHierarquico.addItem("ESTRATÉGICO OU INSTITUCIONAL");
		boxNivelHierarquico.addItem("TÁTICO OU INTERMEDIÁRIO");
		boxNivelHierarquico.addItem("GESTORES E SUPERVISORES");
		boxNivelHierarquico.addItem("OPERACIONAL");
		add(boxNivelHierarquico);

		add(new JLabel("ÁREA DE INTERESSE"));

		boxAreaInteresse = new JComboBox<String>();
		boxAreaInteresse.addItem("");
		boxAreaInteresse.addItem("ADMINISTRAÇÃO COMERCIAL/VENDAS");
		boxAreaInteresse.addItem("ADMINISTRAÇÃO DE EMPRESAS");
		boxAreaInteresse.addItem("ADMINISTRAÇÃO PÚBLICA");
		boxAreaInteresse.addItem("ADVOCACIA/JURÁDICA");
		boxAreaInteresse.addItem("AGRONOMIA");
		boxAreaInteresse.addItem("ARQUITETURA/URBANISMO");
		boxAreaInteresse.addItem("ARQUIVOLOGIA");
		boxAreaInteresse.addItem("ARTES CÊNICAS");
		boxAreaInteresse.addItem("ARTES GRÁFICAS");
		boxAreaInteresse.addItem("ARTES PLÁSTICAS");
		boxAreaInteresse.addItem("ATENDIMENTO AO CLIENTE - BARES E RESTAURANTES");
		boxAreaInteresse.addItem("ATENDIMENTO AO CLIENTE - TELEFONISTAS/RECEPCIONISTAS");
		boxAreaInteresse.addItem("ATENDIMENTO AO CLIENTE - TELEMARKETING/CALL CENTER");
		boxAreaInteresse.addItem("ATENDIMENTO AO CLIENTE");
		boxAreaInteresse.addItem("AUDITORIA");
		boxAreaInteresse.addItem("BANCOS");
		boxAreaInteresse.addItem("BIBLIOTECONOMIA");
		boxAreaInteresse.addItem("BIOLOGIA/CIÊNCIAS BIOLÓGICAS");
		boxAreaInteresse.addItem("BIOMEDICINA");
		boxAreaInteresse.addItem("CIÊNCIAS SOCIAIS");
		boxAreaInteresse.addItem("CINEMA");
		boxAreaInteresse.addItem("COMÉRCIO");
		boxAreaInteresse.addItem("COMÉRCIO EXTERIOR");
		boxAreaInteresse.addItem("COMPRAS");
		boxAreaInteresse.addItem("COMUNICAÇÃO");
		boxAreaInteresse.addItem("CONSTRUÇÃO CIVIL");
		boxAreaInteresse.addItem("CONTABILIDADE");
		boxAreaInteresse.addItem("CONTROLADORIA");
		boxAreaInteresse.addItem("CULINÁRIA/GASTRONOMIA");
		boxAreaInteresse.addItem("DESENHO INDUSTRIAL");
		boxAreaInteresse.addItem("DESIGN DE INTERIORES");
		boxAreaInteresse.addItem("DESIGN GRÁFICO");
		boxAreaInteresse.addItem("ECOLOGIA/MEIO AMBIENTE");
		boxAreaInteresse.addItem("ECONOMIA");
		boxAreaInteresse.addItem("ENFERMAGEM");
		boxAreaInteresse.addItem("ENGENHARIA DE ALIMENTOS");
		boxAreaInteresse.addItem("ENGENHARIA CIVIL");
		boxAreaInteresse.addItem("ENGENHARIA ELETRÔNICA");
		boxAreaInteresse.addItem("ENGENHARIA ELÉTRICA");
		boxAreaInteresse.addItem("ENGENHARIA MECÂNICA");
		boxAreaInteresse.addItem("ENGENHARIA METALÚRGICA E DE MATERIAIS");
		boxAreaInteresse.addItem("ENGENHARIA DE MINAS");
		boxAreaInteresse.addItem("ENGENHARIA DE PRODUÇÃO");
		boxAreaInteresse.addItem("ENGENHARIA QUÍMICA");
		boxAreaInteresse.addItem("ENGENHARIA - OUTRAS");
		boxAreaInteresse.addItem("ENSINO SUPERIOR E PESQUISA");
		boxAreaInteresse.addItem("ENSINO - OUTROS");
		boxAreaInteresse.addItem("ENTRETERIMENTO");
		boxAreaInteresse.addItem("ESPORTES");
		boxAreaInteresse.addItem("ESTÉTICA");
		boxAreaInteresse.addItem("FARMÁCIA");
		boxAreaInteresse.addItem("FILOSOFIA");
		boxAreaInteresse.addItem("FINANÇAS");
		boxAreaInteresse.addItem("FISCAL");
		boxAreaInteresse.addItem("FÍSICA");
		boxAreaInteresse.addItem("FISIOTERAPIA");
		boxAreaInteresse.addItem("FONOAUDIOLOGIA");
		boxAreaInteresse.addItem("GEOGRAFIA");
		boxAreaInteresse.addItem("GEOLOGIA");
		boxAreaInteresse.addItem("GESTÃO EMPRESARIAL");
		boxAreaInteresse.addItem("HISTÓRIA");
		boxAreaInteresse.addItem("HOTELARIA");
		boxAreaInteresse.addItem("INDÚSTRIA");
		boxAreaInteresse.addItem("INFORMÁTICA/T.I.");
		boxAreaInteresse.addItem("INTERNET");
		boxAreaInteresse.addItem("JORNALISMO");
		boxAreaInteresse.addItem("LETRAS");
		boxAreaInteresse.addItem("LOGÍSTICA");
		boxAreaInteresse.addItem("MANUTENÇÃO INDUSTRIAL");
		boxAreaInteresse.addItem("MANUTENÇÃO PREDIAL");
		boxAreaInteresse.addItem("MATEMÁTICA/ESTATÍSTICA");
		boxAreaInteresse.addItem("MEDICINA/HOSPITALAR");
		boxAreaInteresse.addItem("METEOROLOGIA");
		boxAreaInteresse.addItem("MINERAÇÃO");
		boxAreaInteresse.addItem("MODA");
		boxAreaInteresse.addItem("MUSEOLOGIA");
		boxAreaInteresse.addItem("MÚSICA");
		boxAreaInteresse.addItem("NUTRIÇÃO");
		boxAreaInteresse.addItem("OCEANOGRAFIA");
		boxAreaInteresse.addItem("ODONTOLOGIA");
		boxAreaInteresse.addItem("ORGANIZAÇÃO DE EVENTOS/PRODUÇÃO CULTURAL");
		boxAreaInteresse.addItem("ORGANIZAÇÃO E MÉTODOS");
		boxAreaInteresse.addItem("PEDAGOGIA");
		boxAreaInteresse.addItem("PESQUISA DE MERCADO");
		boxAreaInteresse.addItem("PETROLÍFERA");
		boxAreaInteresse.addItem("PRODUÇÃO/FABRICAÇÃO");
		boxAreaInteresse.addItem("PROFESSOR");
		boxAreaInteresse.addItem("PROPAGANDA/MARKETING");
		boxAreaInteresse.addItem("PSICOLOGIA");
		boxAreaInteresse.addItem("QUALIDADE");
		boxAreaInteresse.addItem("QUÍMICA");
		boxAreaInteresse.addItem("RADIALISMO E TELEVISÃO");
		boxAreaInteresse.addItem("RECURSOS HUMANOS");
		boxAreaInteresse.addItem("RELAÇÕES INTERNACIONAIS");
		boxAreaInteresse.addItem("RELAÇÕES PÚBLICAS");
		boxAreaInteresse.addItem("SECRETARIADO");
		boxAreaInteresse.addItem("SEGURANÇA E SAÚDE NO TRABALHO");
		boxAreaInteresse.addItem("SEGURANÇA PATRIMONIAL");
		boxAreaInteresse.addItem("SEGUROS");
		boxAreaInteresse.addItem("SERVIÇO SOCIAL");
		boxAreaInteresse.addItem("SERVIÇOS");
		boxAreaInteresse.addItem("SERVIÇOS ADMINISTRATIVOS");
		boxAreaInteresse.addItem("SERVIÇOS DOMÉSTICOS");
		boxAreaInteresse.addItem("SERVIÇOS ESPECIALIZADOS - AÇOUGUE");
		boxAreaInteresse.addItem("SERVIÇOS ESPECIALIZADOS - PADARIA/CONFEITARIA");
		boxAreaInteresse.addItem("SERVIÇOS ESPECIALIZADOS - PEIXARIA");
		boxAreaInteresse.addItem("SERVIÇOS GERAIS");
		boxAreaInteresse.addItem("SERVIÇOS TÉCNICOS - ELÉTRICOS");
		boxAreaInteresse.addItem("SERVIÇOS TÉCNICOS - ELETRÔNICOS");
		boxAreaInteresse.addItem("SERVIÇOS TÉCNICOS - MECÂNICOS");
		boxAreaInteresse.addItem("SERVIÇOS TÉCNICOS - OUTROS");
		boxAreaInteresse.addItem("SUPRIMENTOS");
		boxAreaInteresse.addItem("TELECOMUNICAÇÕES");
		boxAreaInteresse.addItem("TERAPIA OCUPACIONAL");
		boxAreaInteresse.addItem("TERCEIRO SETOR/RESPONSABILIDADE SOCIAL");
		boxAreaInteresse.addItem("TRADUÇÃO/INTERPRETAÇÃO");
		boxAreaInteresse.addItem("TRANSPORTE AÉREO");
		boxAreaInteresse.addItem("TRANSPORTE MARÍTIMO");
		boxAreaInteresse.addItem("TRANSPORTE TERRESTRE");
		boxAreaInteresse.addItem("TRIBUTÁRIA");
		boxAreaInteresse.addItem("TURISMO");
		boxAreaInteresse.addItem("VENDAS");
		boxAreaInteresse.addItem("VENDAS - VAREJO");
		boxAreaInteresse.addItem("VENDAS - TÉCNICAS");
		boxAreaInteresse.addItem("VETERINÁRIA");
		boxAreaInteresse.addItem("WEB DESIGN");
		boxAreaInteresse.addItem("ZOOLOGIA");
		boxAreaInteresse.addItem("ZOOTECNIA");
		add(boxAreaInteresse);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 13, 1, // rows, cols
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
		Funcionario funcionario = null;
		List<Funcionario> funcionarios = (List<Funcionario>) FuncionarioFac.getRegistro();
		Collections.sort(funcionarios, new FuncionarioComp().new Nome());
		boxFuncionario.removeAllItems();

		for (Funcionario b : funcionarios) {
			boxFuncionario.addItem(b);
		}
		if (!MainControl.getCurriculoObjetivoProfissionalFc().isShowing() && MainControl.getCurriculoObjetivoProfissionalFc()
				.getObjetivoProfissionalCont().getObjetivoProfissional() != null) {
			funcionario = MainControl.getCurriculoObjetivoProfissionalFc().getObjetivoProfissionalCont()
					.getObjetivoProfissional().getFuncionario();
			boxFuncionario.setSelectedItem(funcionario);
		}
	}
}
