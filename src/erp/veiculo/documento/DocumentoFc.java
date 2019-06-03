package erp.veiculo.documento;

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
public final class DocumentoFc extends JFrame implements Gui {

	private DocumentoCont documentoCont;
	private DocumentoPc documentoPc;
	private ConfiguracaoGui configuracaoGui;

	public DocumentoFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public DocumentoCont getDocumentoCont() {
		return documentoCont;
	}

	public DocumentoPc getDocumentoPc() {
		return documentoPc;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		documentoCont = new DocumentoCont();
		addWindowListener(documentoCont.new Frame());
		documentoPc.getLabelVeiculo().addMouseListener(documentoCont.new MostraFrame());
		documentoPc.getTB().getExcluirBtn().addActionListener(documentoCont.new Exclui());
		documentoPc.getTB().getNovoBtn().addActionListener(documentoCont.new Novo());
		documentoPc.getTB().getPesquisarBtn().addActionListener(documentoCont.new Pesquisa());
		documentoPc.getTB().getImprimirBtn().addActionListener(documentoCont.new Imprime());
		documentoPc.getTB().getRelatorioBtn().addActionListener(documentoCont.new Relatorio());
		documentoPc.getTB().getSalvarBtn().addActionListener(documentoCont.new Salva());
		documentoPc.getTB().getFecharBtn().addActionListener(documentoCont.new FechaJanela());
		documentoPc.getTB().getSairBtn().addActionListener(documentoCont.new SaidaSistema());
		documentoPc.getTB().getAjudaBtn().addActionListener(documentoCont.new Ajuda());
		documentoPc.getTB().getHomeBtn().addActionListener(documentoCont.new Home());
		documentoPc.getTB().getRegistrosBtn().addActionListener(documentoCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		documentoPc = new DocumentoPc();
		documentoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(documentoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (documentoPc.isAncestorOf(focused)) {
							documentoPc.scrollRectToVisible(focused.getBounds());
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
		documentoPc.reiniciarGui();
	}
}
