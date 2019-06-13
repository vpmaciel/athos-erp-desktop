package erp.curriculo.curso;

import java.util.Collections;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import arquitetura.validacao.Mascara;
import erp.funcionario.Funcionario;
import erp.funcionario.FuncionarioComp;
import erp.funcionario.FuncionarioFac;
import erp.main.MainCont;

@SuppressWarnings("serial")
public final class CursoPc extends JPanel implements Gui {

	private JComboBox<Funcionario> boxFuncionario;
	private JComboBox<String> boxModalidade;
	private JComboBox<String> boxNivel;
	private JComboBox<String> boxSituacao;
	private ConfiguracaoGui configuracaoGui;
	private JFormattedTextField fieldAnoConclusao;
	private JFormattedTextField fieldAnoInicio;
	private JTextField fieldInstituicao;
	private JTextField fieldNome;
	private JLabel labelFuncionario;
	private ToolBar toolBar;

	public CursoPc() {
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

	public JFormattedTextField getGuiAnoConclusao() {
		return fieldAnoConclusao;
	}

	public JFormattedTextField getGuiAnoInicio() {
		return fieldAnoInicio;
	}

	public JComboBox<Funcionario> getGuiFuncionario() {
		return boxFuncionario;
	}

	public JTextField getGuiInstituicao() {
		return fieldInstituicao;
	}

	public JComboBox<String> getGuiModalidade() {
		return boxModalidade;
	}

	public JComboBox<String> getGuiNivel() {
		return boxNivel;
	}

	public JTextField getGuiNome() {
		return fieldNome;
	}

	public JComboBox<String> getGuiSituacao() {
		return boxSituacao;
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

		add(new JLabel("INSTITUIÇÃO"));

		fieldInstituicao = new JTextField();
		fieldInstituicao.setDocument(new EntradaMaiuscula(50));
		add(fieldInstituicao);

		add(new JLabel("CURSO"));

		fieldNome = new JTextField();
		fieldNome.setDocument(new EntradaMaiuscula(50));
		add(fieldNome);

		add(new JLabel("ANO INÍCIO"));

		fieldAnoInicio = new JFormattedTextField(Mascara.getAno());
		add(fieldAnoInicio);

		add(new JLabel("ANO CONCLUSÃO"));

		fieldAnoConclusao = new JFormattedTextField(Mascara.getAno());
		add(fieldAnoConclusao);

		add(new JLabel("SITUAÇÃO"));

		boxSituacao = new JComboBox<String>();
		boxSituacao.addItem("");
		boxSituacao.addItem("CONCLUÍDO");
		boxSituacao.addItem("NÃO CONCLUÍDO");
		boxSituacao.addItem("EM ANDAMENTO");
		add(boxSituacao);

		add(new JLabel("MODALIDADE"));

		boxModalidade = new JComboBox<String>();
		boxModalidade.addItem("");
		boxModalidade.addItem("LICENCIATURA");
		boxModalidade.addItem("BACHARELADO");
		boxModalidade.addItem("MBA");
		boxModalidade.addItem("TECNOLÓGO");
		boxModalidade.addItem("TÉCNICO");
		boxModalidade.addItem("ENSINO MÉDIO");
		boxModalidade.addItem("ENSINO FUNDAMENTAL");
		add(boxModalidade);

		add(new JLabel("NÍVEL"));

		boxNivel = new JComboBox<String>();
		boxNivel.addItem("");
		boxNivel.addItem("PÓS DOUTORADO");
		boxNivel.addItem("DOUTORADO");
		boxNivel.addItem("MESTRADO");
		boxNivel.addItem("ESPECIALIZAÇÃO");
		boxNivel.addItem("SUPERIOR COMPLETO");
		boxNivel.addItem("SUPERIOR INCOMPLETO");
		boxNivel.addItem("SEGUNDO GRAU COMPLETO");
		boxNivel.addItem("SEGUNDO GRAU INCOMPLETO");
		boxNivel.addItem("PRIMEIRO GRAU COMPLETO");
		boxNivel.addItem("PRIMEIRO GRAU INCOMPLETO");
		add(boxNivel);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 17, 1, // rows, cols
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
		if (!MainCont.getCurriculoCursoFc().isShowing()
				&& MainCont.getCurriculoCursoFc().getCursoCont().getCurso() != null) {
			funcionario = MainCont.getCurriculoCursoFc().getCursoCont().getCurso().getFuncionario();
			boxFuncionario.setSelectedItem(funcionario);
		}
	}
}
