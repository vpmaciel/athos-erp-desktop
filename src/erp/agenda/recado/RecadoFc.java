package erp.agenda.recado;

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
public final class RecadoFc extends JFrame implements Gui {

	private ConfiguracaoGui guiConfiguracao;
	private RecadoPc pcRecado;
	private RecadoCont recadoCont;

	public RecadoFc() {
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
		return guiConfiguracao;
	}

	public RecadoCont getRecadoCont() {
		return recadoCont;
	}

	public RecadoPc getRecadoPc() {
		return pcRecado;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		recadoCont = new RecadoCont();
		addWindowListener(recadoCont.new Frame());
		pcRecado.getToolBar().getExcluirBtn().addActionListener(recadoCont.new Exclui());
		pcRecado.getToolBar().getNovoBtn().addActionListener(recadoCont.new Novo());
		pcRecado.getToolBar().getPesquisarBtn().addActionListener(recadoCont.new Pesquisa());
		pcRecado.getToolBar().getImprimirBtn().addActionListener(recadoCont.new Imprime());
		pcRecado.getToolBar().getRelatorioBtn().addActionListener(recadoCont.new Relatorio());
		pcRecado.getToolBar().getSalvarBtn().addActionListener(recadoCont.new Salva());
		pcRecado.getToolBar().getFecharBtn().addActionListener(recadoCont.new FechaJanela());
		pcRecado.getToolBar().getSairBtn().addActionListener(recadoCont.new SaidaSistema());
		pcRecado.getToolBar().getAjudaBtn().addActionListener(recadoCont.new Ajuda());
		pcRecado.getToolBar().getHomeBtn().addActionListener(recadoCont.new Home());
		pcRecado.getToolBar().getRegistrosBtn().addActionListener(recadoCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		pcRecado = new RecadoPc();

		pcRecado.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pcRecado);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pcRecado.isAncestorOf(focused)) {
							pcRecado.scrollRectToVisible(focused.getBounds());
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
		guiConfiguracao = new ConfiguracaoGui(this);
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
		guiConfiguracao.limparGui();
	}

	@Override
	public void reiniciarGui() {
		pcRecado.reiniciarGui();
	}
}
