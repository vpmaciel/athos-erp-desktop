package erp.curriculo.curso;

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
public final class CursoFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private CursoCont cursoCont;
	private CursoPc cursoPc;

	public CursoFc() {
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

	public CursoCont getCursoCont() {
		return cursoCont;
	}

	public CursoPc getCursoPc() {
		return cursoPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		cursoCont = new CursoCont();
		addWindowListener(cursoCont.new Frame());
		cursoPc.getLabelFuncionario().addMouseListener(cursoCont.new MostraFrame());
		cursoPc.getTB().getExcluirBtn().addActionListener(cursoCont.new Exclui());
		cursoPc.getTB().getNovoBtn().addActionListener(cursoCont.new Novo());
		cursoPc.getTB().getPesquisarBtn().addActionListener(cursoCont.new Pesquisa());
		cursoPc.getTB().getImprimirBtn().addActionListener(cursoCont.new Imprime());
		cursoPc.getTB().getRelatorioBtn().addActionListener(cursoCont.new Relatorio());
		cursoPc.getTB().getSalvarBtn().addActionListener(cursoCont.new Salva());
		cursoPc.getTB().getFecharBtn().addActionListener(cursoCont.new FechaJanela());
		cursoPc.getTB().getSairBtn().addActionListener(cursoCont.new SaidaSistema());
		cursoPc.getTB().getAjudaBtn().addActionListener(cursoCont.new Ajuda());
		cursoPc.getTB().getHomeBtn().addActionListener(cursoCont.new Home());
		cursoPc.getTB().getRegistrosBtn().addActionListener(cursoCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		cursoPc = new CursoPc();
		cursoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(cursoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (cursoPc.isAncestorOf(focused)) {
							cursoPc.scrollRectToVisible(focused.getBounds());
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
		cursoPc.reiniciarGui();
	}
}
