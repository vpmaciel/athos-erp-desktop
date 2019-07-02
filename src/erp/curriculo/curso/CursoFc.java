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
	private CursoControl cursoControl;
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

	public CursoControl getCursoCont() {
		return cursoControl;
	}

	public CursoPc getCursoPc() {
		return cursoPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		cursoControl = new CursoControl();
		addWindowListener(cursoControl.new Frame());
		cursoPc.getLabelFuncionario().addMouseListener(cursoControl.new MostraFrame());
		cursoPc.getTB().getExcluirBtn().addActionListener(cursoControl.new Exclui());
		cursoPc.getTB().getNovoBtn().addActionListener(cursoControl.new Novo());
		cursoPc.getTB().getPesquisarBtn().addActionListener(cursoControl.new Pesquisa());
		cursoPc.getTB().getImprimirBtn().addActionListener(cursoControl.new Imprime());
		cursoPc.getTB().getRelatorioBtn().addActionListener(cursoControl.new Relatorio());
		cursoPc.getTB().getSalvarBtn().addActionListener(cursoControl.new Salva());
		cursoPc.getTB().getFecharBtn().addActionListener(cursoControl.new FechaJanela());
		cursoPc.getTB().getSairBtn().addActionListener(cursoControl.new SaidaSistema());
		cursoPc.getTB().getAjudaBtn().addActionListener(cursoControl.new Ajuda());
		cursoPc.getTB().getHomeBtn().addActionListener(cursoControl.new Home());
		cursoPc.getTB().getRegistrosBtn().addActionListener(cursoControl.new Registro());
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
