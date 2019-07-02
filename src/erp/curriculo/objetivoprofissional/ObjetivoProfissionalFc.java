package erp.curriculo.objetivoprofissional;

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
public final class ObjetivoProfissionalFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private ObjetivoProfissionalControl objetivoProfissionalControl;
	private ObjetivoProfissionalPc objetivoProfissionalPc;

	public ObjetivoProfissionalFc() {
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

	public ObjetivoProfissionalControl getObjetivoProfissionalCont() {
		return objetivoProfissionalControl;
	}

	public ObjetivoProfissionalPc getObjetivoProfissionalPc() {
		return objetivoProfissionalPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		objetivoProfissionalControl = new ObjetivoProfissionalControl();
		addWindowListener(objetivoProfissionalControl.new Frame());
		objetivoProfissionalPc.getLabelFuncionario().addMouseListener(objetivoProfissionalControl.new MostraFrame());
		objetivoProfissionalPc.getTB().getExcluirBtn().addActionListener(objetivoProfissionalControl.new Exclui());
		objetivoProfissionalPc.getTB().getNovoBtn().addActionListener(objetivoProfissionalControl.new Novo());
		objetivoProfissionalPc.getTB().getPesquisarBtn().addActionListener(objetivoProfissionalControl.new Pesquisa());
		objetivoProfissionalPc.getTB().getImprimirBtn().addActionListener(objetivoProfissionalControl.new Imprime());
		objetivoProfissionalPc.getTB().getRelatorioBtn().addActionListener(objetivoProfissionalControl.new Relatorio());
		objetivoProfissionalPc.getTB().getSalvarBtn().addActionListener(objetivoProfissionalControl.new Salva());
		objetivoProfissionalPc.getTB().getFecharBtn().addActionListener(objetivoProfissionalControl.new FechaJanela());
		objetivoProfissionalPc.getTB().getSairBtn().addActionListener(objetivoProfissionalControl.new SaidaSistema());
		objetivoProfissionalPc.getTB().getAjudaBtn().addActionListener(objetivoProfissionalControl.new Ajuda());
		objetivoProfissionalPc.getTB().getHomeBtn().addActionListener(objetivoProfissionalControl.new Home());
		objetivoProfissionalPc.getTB().getRegistrosBtn().addActionListener(objetivoProfissionalControl.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		objetivoProfissionalPc = new ObjetivoProfissionalPc();
		objetivoProfissionalPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(objetivoProfissionalPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (objetivoProfissionalPc.isAncestorOf(focused)) {
							objetivoProfissionalPc.scrollRectToVisible(focused.getBounds());
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
		objetivoProfissionalPc.reiniciarGui();
	}
}
