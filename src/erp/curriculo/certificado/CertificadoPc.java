package erp.curriculo.certificado;

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
public final class CertificadoPc extends JPanel implements Gui {

	private JComboBox<Funcionario> boxFuncionario;
	private ConfiguracaoGui configuracaoGui;
	private JTextField fieldAnoConclusao;
	private JTextField fieldCargaHoraria;
	private JTextField fieldCurso;
	private JTextField fieldInstituicao;
	private JLabel labelFuncionario;
	private ToolBar toolBar;

	public CertificadoPc() {
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

	public JTextField getGuiAnoConclusao() {
		return fieldAnoConclusao;
	}

	public JTextField getGuiCargaHoraria() {
		return fieldCargaHoraria;
	}

	public JTextField getGuiCurso() {
		return fieldCurso;
	}

	public JComboBox<Funcionario> getGuiFuncionario() {
		return boxFuncionario;
	}

	public JTextField getGuiInstituicao() {
		return fieldInstituicao;
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

		add(new JLabel("INSTITUIÇÃO"));

		fieldInstituicao = new JTextField();
		fieldInstituicao.setDocument(new EntradaMaiuscula(50));
		add(fieldInstituicao);

		add(new JLabel("CURSO"));

		fieldCurso = new JTextField();
		fieldCurso.setDocument(new EntradaMaiuscula(50));
		add(fieldCurso);

		add(new JLabel("ANO CONCLUSÃO"));

		fieldAnoConclusao = new JTextField();
		fieldAnoConclusao.setDocument(new EntradaMaiuscula(4));
		add(fieldAnoConclusao);

		add(new JLabel("CARGA HORÁRIA"));

		fieldCargaHoraria = new JTextField();
		fieldCargaHoraria.setDocument(new EntradaMaiuscula(5));
		add(fieldCargaHoraria);

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
		if (!MainControl.getCurriculoCertificadoFc().isShowing()
				&& MainControl.getCurriculoCertificadoFc().getCertificadoCont().getCertificado() != null) {
			funcionario = MainControl.getCurriculoCertificadoFc().getCertificadoCont().getCertificado().getFuncionario();
			boxFuncionario.setSelectedItem(funcionario);
		}
	}
}
