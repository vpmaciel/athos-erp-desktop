package erp.curriculo.experienciaprofissional;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class ExperienciaProfissionalFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private ExperienciaProfissionalCont experienciaProfissionalCont;
	private ExperienciaProfissionalPc experienciaProfissionalPc;

	public ExperienciaProfissionalFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public ExperienciaProfissionalCont getExperienciaProfissionalCont() {
		return experienciaProfissionalCont;
	}

	public ExperienciaProfissionalPc getExperienciaProfissionalPc() {
		return experienciaProfissionalPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		experienciaProfissionalCont = new ExperienciaProfissionalCont();
		addWindowListener(experienciaProfissionalCont.new Frame());
		experienciaProfissionalPc.getLabelFuncionario().addMouseListener(experienciaProfissionalCont.new MostraFrame());
		experienciaProfissionalPc.getTB().getExcluirBtn().addActionListener(experienciaProfissionalCont.new Exclui());
		experienciaProfissionalPc.getTB().getNovoBtn().addActionListener(experienciaProfissionalCont.new Novo());
		experienciaProfissionalPc.getTB().getPesquisarBtn()
				.addActionListener(experienciaProfissionalCont.new Pesquisa());
		experienciaProfissionalPc.getTB().getImprimirBtn().addActionListener(experienciaProfissionalCont.new Imprime());
		experienciaProfissionalPc.getTB().getRelatorioBtn()
				.addActionListener(experienciaProfissionalCont.new Relatorio());
		experienciaProfissionalPc.getTB().getSalvarBtn().addActionListener(experienciaProfissionalCont.new Salva());
		experienciaProfissionalPc.getTB().getFecharBtn()
				.addActionListener(experienciaProfissionalCont.new FechaJanela());
		experienciaProfissionalPc.getTB().getSairBtn()
				.addActionListener(experienciaProfissionalCont.new SaidaSistema());
		experienciaProfissionalPc.getTB().getAjudaBtn().addActionListener(experienciaProfissionalCont.new Ajuda());
		experienciaProfissionalPc.getTB().getHomeBtn().addActionListener(experienciaProfissionalCont.new Home());
		experienciaProfissionalPc.getTB().getRegistrosBtn()
				.addActionListener(experienciaProfissionalCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		experienciaProfissionalPc = new ExperienciaProfissionalPc();
		experienciaProfissionalPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(experienciaProfissionalPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (experienciaProfissionalPc.isAncestorOf(focused)) {
							experienciaProfissionalPc.scrollRectToVisible(focused.getBounds());
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
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
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
		experienciaProfissionalPc.reiniciarGui();
	}
}
