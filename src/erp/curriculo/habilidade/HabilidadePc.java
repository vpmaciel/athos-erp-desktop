package erp.curriculo.habilidade;

import java.util.Collections;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.AOP;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import erp.funcionario.Funcionario;
import erp.funcionario.FuncionarioComp;
import erp.funcionario.FuncionarioFac;
import erp.main.MainCont;

@SuppressWarnings("serial")
public final class HabilidadePc extends JPanel implements Gui {

	private JComboBox<Funcionario> boxFuncionario;
	private JComboBox<String> boxNivelConhecimento;
	private ConfiguracaoGui configuracaoGui;
	private JTextField fieldConhecimento;
	private JLabel labelFuncionario;
	private ToolBar toolBar;

	public HabilidadePc() {
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

	public JTextField getGuiConhecimento() {
		return fieldConhecimento;
	}

	public JComboBox<Funcionario> getGuiFuncionario() {
		return boxFuncionario;
	}

	public JComboBox<String> getGuiNivelConhecimento() {
		return boxNivelConhecimento;
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

		add(new JLabel("CONHECIMENTO"));

		fieldConhecimento = new JTextField();
		fieldConhecimento.setDocument(new EntradaMaiuscula(50));
		add(fieldConhecimento);

		add(new JLabel("NÍVEL DE CONHECIMENTO"));

		boxNivelConhecimento = new JComboBox<String>();
		boxNivelConhecimento.addItem("");
		boxNivelConhecimento.addItem("BÁSICO");
		boxNivelConhecimento.addItem("INTERMEDIÁRIO");
		boxNivelConhecimento.addItem("AVANÇADO");
		add(boxNivelConhecimento);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 7, 1, // rows, cols
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
		setBorder(AOP.getBordaPainel());
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
		if (!MainCont.getCurriculoHabilidadeFc().isShowing()
				&& MainCont.getCurriculoHabilidadeFc().getHabilidadeCont().getHabilidade() != null) {
			funcionario = MainCont.getCurriculoHabilidadeFc().getHabilidadeCont().getHabilidade().getFuncionario();
			boxFuncionario.setSelectedItem(funcionario);
		}
	}
}
