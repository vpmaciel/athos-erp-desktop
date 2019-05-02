package erp.curriculo.certificado;

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
public final class CertificadoFc extends JFrame implements Gui {

	private CertificadoCont certificadoCont;
	private ConfiguracaoGui configuracaoGui;
	private CertificadoPc certificadoPc;

	public CertificadoFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public CertificadoCont getCertificadoCont() {
		return certificadoCont;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public CertificadoPc getCertificadoPc() {
		return certificadoPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		certificadoPc = new CertificadoPc();
		certificadoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(certificadoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (certificadoPc.isAncestorOf(focused)) {
							certificadoPc.scrollRectToVisible(focused.getBounds());
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
		certificadoCont = new CertificadoCont();
		addWindowListener(certificadoCont.new Frame());
		certificadoPc.getLabelFuncionario().addMouseListener(certificadoCont.new MostraFrame());
		certificadoPc.getTB().getExcluirBtn().addActionListener(certificadoCont.new Exclui());
		certificadoPc.getTB().getNovoBtn().addActionListener(certificadoCont.new Novo());
		certificadoPc.getTB().getPesquisarBtn().addActionListener(certificadoCont.new Pesquisa());
		certificadoPc.getTB().getImprimirBtn().addActionListener(certificadoCont.new Imprime());
		certificadoPc.getTB().getRelatorioBtn().addActionListener(certificadoCont.new Relatorio());
		certificadoPc.getTB().getSalvarBtn().addActionListener(certificadoCont.new Salva());
		certificadoPc.getTB().getFecharBtn().addActionListener(certificadoCont.new FechaJanela());
		certificadoPc.getTB().getSairBtn().addActionListener(certificadoCont.new SaidaSistema());
		certificadoPc.getTB().getAjudaBtn().addActionListener(certificadoCont.new Ajuda());
		certificadoPc.getTB().getHomeBtn().addActionListener(certificadoCont.new Home());
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
		certificadoPc.reiniciarGui();
	}
}
