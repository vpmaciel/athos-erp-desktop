package erp.veiculo.documento;

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
public final class DocumentoFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private DocumentoControl documentoControl;
	private DocumentoPc documentoPc;

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

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public DocumentoControl getDocumentoCont() {
		return documentoControl;
	}

	public DocumentoPc getDocumentoPc() {
		return documentoPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		documentoControl = new DocumentoControl();
		addWindowListener(documentoControl.new Frame());
		documentoPc.getLabelVeiculo().addMouseListener(documentoControl.new MostraFrame());
		documentoPc.getTB().getExcluirBtn().addActionListener(documentoControl.new Exclui());
		documentoPc.getTB().getNovoBtn().addActionListener(documentoControl.new Novo());
		documentoPc.getTB().getPesquisarBtn().addActionListener(documentoControl.new Pesquisa());
		documentoPc.getTB().getImprimirBtn().addActionListener(documentoControl.new Imprime());
		documentoPc.getTB().getRelatorioBtn().addActionListener(documentoControl.new Relatorio());
		documentoPc.getTB().getSalvarBtn().addActionListener(documentoControl.new Salva());
		documentoPc.getTB().getFecharBtn().addActionListener(documentoControl.new FechaJanela());
		documentoPc.getTB().getSairBtn().addActionListener(documentoControl.new SaidaSistema());
		documentoPc.getTB().getAjudaBtn().addActionListener(documentoControl.new Ajuda());
		documentoPc.getTB().getHomeBtn().addActionListener(documentoControl.new Home());
		documentoPc.getTB().getRegistrosBtn().addActionListener(documentoControl.new Registro());
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
		documentoPc.reiniciarGui();
	}
}
