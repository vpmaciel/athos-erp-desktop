package erp.curriculo;

import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import arquitetura.AOP;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class CurriculoFc extends JFrame implements Gui {

	private CurriculoCont curriculoCont;
	private CurriculoPc curriculoPc;
	private ConfiguracaoGui configuracaoGui;

	public CurriculoFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public CurriculoCont getCurriculoCont() {
		return curriculoCont;
	}

	public CurriculoPc getCurriculoPc() {
		return curriculoPc;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		curriculoCont = new CurriculoCont();
		addWindowListener(curriculoCont.new Frame());
		curriculoPc.getLabelFuncionario().addMouseListener(curriculoCont.new MostraFrame());
		curriculoPc.getTB().getExcluirBtn().setEnabled(false);
		curriculoPc.getTB().getNovoBtn().setEnabled(false);
		curriculoPc.getTB().getPesquisarBtn().setEnabled(false);
		curriculoPc.getTB().getImprimirBtn().addActionListener(curriculoCont.new Imprime());
		curriculoPc.getTB().getRelatorioBtn().setEnabled(false);
		curriculoPc.getTB().getSalvarBtn().setEnabled(false);
		curriculoPc.getTB().getFecharBtn().addActionListener(curriculoCont.new FechaJanela());
		curriculoPc.getTB().getSairBtn().addActionListener(curriculoCont.new SaidaSistema());
		curriculoPc.getTB().getAjudaBtn().addActionListener(curriculoCont.new Ajuda());
		curriculoPc.getTB().getHomeBtn().addActionListener(curriculoCont.new Home());
		curriculoPc.getTB().getRegistrosBtn().addActionListener(curriculoCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		curriculoPc = new CurriculoPc();
		curriculoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(curriculoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (curriculoPc.isAncestorOf(focused)) {
							curriculoPc.scrollRectToVisible(focused.getBounds());
						}
					}
				});
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarLayout() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setPreferredSize(AOP.getTamanhoJanela());
		setMinimumSize(AOP.getTamanhoJanela());
		setSize(AOP.getTamanhoJanela());
		setMaximumSize(AOP.getTamanhoJanela());
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
		curriculoPc.reiniciarGui();
	}
}
