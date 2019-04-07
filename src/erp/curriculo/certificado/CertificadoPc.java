package erp.curriculo.certificado;

import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import erp.funcionario.Funcionario;
import erp.funcionario.FuncionarioComp;
import erp.funcionario.FuncionarioFac;
import erp.main.MainCont;

@SuppressWarnings("serial")
public final class CertificadoPc extends JPanel implements Gui {

	private ToolBar toolBar;
	private ConfiguracaoGui configuracaoGui;
	private JLabel labelFuncionario;
	private JComboBox<Funcionario> boxFuncionario;
	private JLabel labelInstituicao;
	private JTextField textFieldInstituicao;
	private JLabel labelCurso;
	private JTextField textFieldCurso;
	private JLabel labelCargaHoraria;
	private JTextField textFieldCargaHoraria;
	private JLabel labelAnoConclusao;
	private JTextField textFieldAnoConclusao;

	public JComboBox<Funcionario> getFuncionarioGui() {
		return boxFuncionario;
	}

	public JTextField getInstituicaoGui() {
		return textFieldInstituicao;
	}

	public JTextField getCursoGui() {
		return textFieldCurso;
	}

	public JTextField getCargaHorariaGui() {
		return textFieldCargaHoraria;
	}

	public JTextField getAnoConclusaoGui() {
		return textFieldAnoConclusao;
	}

	public CertificadoPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
	}

	@Override
	public void atualizarTable() {

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
		toolBar = new ToolBar();
		add(toolBar.getToolBar());

		labelFuncionario = new JLabel("FUNCIONÁRIO");
		add(labelFuncionario);

		boxFuncionario = new JComboBox<Funcionario>();
		List<Funcionario> funcionarios = (List<Funcionario>) FuncionarioFac.getRegistro();
		Collections.sort(funcionarios, new FuncionarioComp().new Nome());
		for (Funcionario funcionario : funcionarios) {
			boxFuncionario.addItem(funcionario);
		}

		add(boxFuncionario);

		labelInstituicao = new JLabel("INSTITUIÇÃO");
		add(labelInstituicao);

		textFieldInstituicao = new JTextField();
		textFieldInstituicao.setDocument(new EntradaMaiuscula(50));
		add(textFieldInstituicao);

		labelCurso = new JLabel("CURSO");
		add(labelCurso);

		textFieldCurso = new JTextField();
		textFieldCurso.setDocument(new EntradaMaiuscula(50));
		add(textFieldCurso);

		labelAnoConclusao = new JLabel("ANO CONCLUSÃO");
		add(labelAnoConclusao);

		textFieldAnoConclusao = new JTextField();
		textFieldAnoConclusao.setDocument(new EntradaMaiuscula(4));
		add(textFieldAnoConclusao);

		labelCargaHoraria = new JLabel("CARGA HORÁRIA");
		add(labelCargaHoraria);

		textFieldCargaHoraria = new JTextField();
		textFieldCargaHoraria.setDocument(new EntradaMaiuscula(5));
		add(textFieldCargaHoraria);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 11, 1, // rows, cols
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
		setBorder(BorderFactory.createTitledBorder("CARACTERÍSTICAS"));
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
		this.boxFuncionario.removeAllItems();

		for (Funcionario b : funcionarios) {
			this.boxFuncionario.addItem(b);
		}
		if (!MainCont.getCurriculoCertificadoFc().isShowing()
				&& MainCont.getCurriculoCertificadoFc().getCertificadoCont().getCertificado() != null) {
			funcionario = MainCont.getCurriculoCertificadoFc().getCertificadoCont().getCertificado().getFuncionario();
			boxFuncionario.setSelectedItem(funcionario);
		}

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}
}
