package erp.empresa;

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
public final class EmpresaFc extends JFrame implements Gui {

	private EmpresaCont empresaCont;
	private ConfiguracaoGui configuracaoGui;
	private EmpresaPc empresaPc;

	public EmpresaFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public EmpresaCont getEmpresaHandle() {
		return empresaCont;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public EmpresaPc getEmpresaPc() {
		return empresaPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		empresaPc = new EmpresaPc();
		empresaPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(empresaPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (empresaPc.isAncestorOf(focused)) {
							empresaPc.scrollRectToVisible(focused.getBounds());
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
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		empresaCont = new EmpresaCont();
		addWindowListener(empresaCont.new Frame());
		empresaPc.getTB().getExcluirBtn().addActionListener(empresaCont.new Exclui());
		empresaPc.getTB().getNovoBtn().addActionListener(empresaCont.new NovoFrame());
		empresaPc.getTB().getPesquisarBtn().addActionListener(empresaCont.new Pesquisa());
		empresaPc.getTB().getImprimirBtn().addActionListener(empresaCont.new Imprime());
		empresaPc.getTB().getRelatorioBtn().addActionListener(empresaCont.new Relatorio());
		empresaPc.getTB().getSalvarBtn().addActionListener(empresaCont.new Salva());
		empresaPc.getTB().getFecharBtn().addActionListener(empresaCont.new FechaJanela());
		empresaPc.getTB().getSairBtn().addActionListener(empresaCont.new SaidaSistema());
		empresaPc.getTB().getAjudaBtn().addActionListener(empresaCont.new Ajuda());
		empresaPc.getTB().getHomeBtn().addActionListener(empresaCont.new Home());
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

	}
}
