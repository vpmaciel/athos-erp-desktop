package erp.curriculo.experienciaprofissional;

import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.AOP;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Mascara;
import erp.funcionario.Funcionario;
import erp.funcionario.FuncionarioComp;
import erp.funcionario.FuncionarioFac;
import erp.main.MainCont;

@SuppressWarnings("serial")
public final class ExperienciaProfissionalPc extends JPanel implements Gui {

	private JComboBox<Funcionario> boxFuncionario;
	private JComboBox<String> boxNiveHierarquico;
	private ConfiguracaoGui configuracaoGui;
	private JTextField fieldCargo;
	private JFormattedTextField fieldDataAdmissao;
	private JFormattedTextField fieldDataSaida;
	private JTextField fieldEmpresa;
	private JTextArea fieldFuncoes;
	private JLabel labelFuncionario;
	private ToolBar toolBar;

	public ExperienciaProfissionalPc() {
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

	public JTextField getGuiCargo() {
		return fieldCargo;
	}

	public JFormattedTextField getGuiDataAdmissao() {
		return fieldDataAdmissao;
	}

	public JFormattedTextField getGuiDataSaida() {
		return fieldDataSaida;
	}

	public JTextField getGuiEmpresa() {
		return fieldEmpresa;
	}

	public JComboBox<Funcionario> getGuiFuncionario() {
		return boxFuncionario;
	}

	public JTextArea getGuiFuncoes() {
		return fieldFuncoes;
	}

	public JComboBox<String> getGuiNivelHierarquico() {
		return boxNiveHierarquico;
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
		labelFuncionario.setCursor(AOP.getNovaJanelaCursor());
		add(labelFuncionario);

		boxFuncionario = new JComboBox<Funcionario>();
		List<Funcionario> funcionarios = (List<Funcionario>) FuncionarioFac.getRegistro();
		Collections.sort(funcionarios, new FuncionarioComp().new Nome());
		for (Funcionario funcionario : funcionarios) {
			boxFuncionario.addItem(funcionario);
		}
		add(boxFuncionario);

		add(new JLabel("EMPRESA"));

		fieldEmpresa = new JTextField();
		fieldEmpresa.setDocument(new EntradaMaiuscula(50));
		add(fieldEmpresa);

		add(new JLabel("CARGO"));

		fieldCargo = new JTextField();
		fieldCargo.setDocument(new EntradaMaiuscula(50));
		add(fieldCargo);

		add(new JLabel("DATA SAÍDA"));

		fieldDataAdmissao = new JFormattedTextField(Mascara.getData());
		add(fieldDataAdmissao);

		add(new JLabel("DATA SAÍDA"));

		fieldDataSaida = new JFormattedTextField(Mascara.getData());
		add(fieldDataSaida);

		add(new JLabel("NÍVEL HIERÁRQUICO"));

		boxNiveHierarquico = new JComboBox<String>();
		boxNiveHierarquico.addItem("");
		boxNiveHierarquico.addItem("ESTRATÉGICO OU INSTITUCIONAL");
		boxNiveHierarquico.addItem("TÁTICO OU INTERMEDIÁRIO");
		boxNiveHierarquico.addItem("GESTORES E SUPERVISORES");
		boxNiveHierarquico.addItem("OPERACIONAL");
		add(boxNiveHierarquico);

		add(new JLabel("FUNÇÕES"));

		fieldFuncoes = new JTextArea();
		fieldFuncoes.setLineWrap(true);
		fieldFuncoes.setDocument(new EntradaMaiuscula(500));
		add(fieldFuncoes);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 15, 1, // rows, cols
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
		setBorder(BorderFactory.createTitledBorder("EXPERIÊNCIA PROFISSIONAL"));
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
		if (!MainCont.getCurriculoExperienciaProfissionalFc().isShowing()
				&& MainCont.getCurriculoExperienciaProfissionalFc().getExperienciaProfissionalCont()
						.getExperienciaProfissional() != null) {
			funcionario = MainCont.getCurriculoExperienciaProfissionalFc().getExperienciaProfissionalCont()
					.getExperienciaProfissional().getFuncionario();
			boxFuncionario.setSelectedItem(funcionario);
		}
	}
}
