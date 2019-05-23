package erp.curriculo.objetivoprofissional;

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
public final class ObjetivoProfissionalFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private ObjetivoProfissionalCont objetivoProfissionalCont;
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

	public ObjetivoProfissionalCont getObjetivoProfissionalCont() {
		return objetivoProfissionalCont;
	}

	public ObjetivoProfissionalPc getObjetivoProfissionalPc() {
		return objetivoProfissionalPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		objetivoProfissionalCont = new ObjetivoProfissionalCont();
		addWindowListener(objetivoProfissionalCont.new Frame());
		objetivoProfissionalPc.getLabelFuncionario().addMouseListener(objetivoProfissionalCont.new MostraFrame());
		objetivoProfissionalPc.getTB().getExcluirBtn().addActionListener(objetivoProfissionalCont.new Exclui());
		objetivoProfissionalPc.getTB().getNovoBtn().addActionListener(objetivoProfissionalCont.new Novo());
		objetivoProfissionalPc.getTB().getPesquisarBtn().addActionListener(objetivoProfissionalCont.new Pesquisa());
		objetivoProfissionalPc.getTB().getImprimirBtn().addActionListener(objetivoProfissionalCont.new Imprime());
		objetivoProfissionalPc.getTB().getRelatorioBtn().addActionListener(objetivoProfissionalCont.new Relatorio());
		objetivoProfissionalPc.getTB().getSalvarBtn().addActionListener(objetivoProfissionalCont.new Salva());
		objetivoProfissionalPc.getTB().getFecharBtn().addActionListener(objetivoProfissionalCont.new FechaJanela());
		objetivoProfissionalPc.getTB().getSairBtn().addActionListener(objetivoProfissionalCont.new SaidaSistema());
		objetivoProfissionalPc.getTB().getAjudaBtn().addActionListener(objetivoProfissionalCont.new Ajuda());
		objetivoProfissionalPc.getTB().getHomeBtn().addActionListener(objetivoProfissionalCont.new Home());
		objetivoProfissionalPc.getTB().getRegistrosBtn().addActionListener(objetivoProfissionalCont.new Registro());
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
		objetivoProfissionalPc.reiniciarGui();
	}
}
