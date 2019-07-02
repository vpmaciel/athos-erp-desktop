package erp.curriculo.experienciaprofissional;

import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class ExperienciaProfissionalFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private ExperienciaProfissionalControl experienciaProfissionalControl;
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

	public ExperienciaProfissionalControl getExperienciaProfissionalCont() {
		return experienciaProfissionalControl;
	}

	public ExperienciaProfissionalPc getExperienciaProfissionalPc() {
		return experienciaProfissionalPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		experienciaProfissionalControl = new ExperienciaProfissionalControl();
		addWindowListener(experienciaProfissionalControl.new Frame());
		experienciaProfissionalPc.getLabelFuncionario().addMouseListener(experienciaProfissionalControl.new MostraFrame());
		experienciaProfissionalPc.getTB().getExcluirBtn().addActionListener(experienciaProfissionalControl.new Exclui());
		experienciaProfissionalPc.getTB().getNovoBtn().addActionListener(experienciaProfissionalControl.new Novo());
		experienciaProfissionalPc.getTB().getPesquisarBtn()
				.addActionListener(experienciaProfissionalControl.new Pesquisa());
		experienciaProfissionalPc.getTB().getImprimirBtn().addActionListener(experienciaProfissionalControl.new Imprime());
		experienciaProfissionalPc.getTB().getRelatorioBtn()
				.addActionListener(experienciaProfissionalControl.new Relatorio());
		experienciaProfissionalPc.getTB().getSalvarBtn().addActionListener(experienciaProfissionalControl.new Salva());
		experienciaProfissionalPc.getTB().getFecharBtn()
				.addActionListener(experienciaProfissionalControl.new FechaJanela());
		experienciaProfissionalPc.getTB().getSairBtn()
				.addActionListener(experienciaProfissionalControl.new SaidaSistema());
		experienciaProfissionalPc.getTB().getAjudaBtn().addActionListener(experienciaProfissionalControl.new Ajuda());
		experienciaProfissionalPc.getTB().getHomeBtn().addActionListener(experienciaProfissionalControl.new Home());
		experienciaProfissionalPc.getTB().getRegistrosBtn()
				.addActionListener(experienciaProfissionalControl.new Registro());
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
		setPreferredSize(Sis.getTamanhoJanela());
		setMinimumSize(Sis.getTamanhoJanela());
		setSize(Sis.getTamanhoJanela());
		setMaximumSize(Sis.getTamanhoJanela());
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
