package erp.curriculo.certificado;

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
public final class CertificadoFc extends JFrame implements Gui {

	private CertificadoControl certificadoControl;
	private CertificadoPc certificadoPc;
	private ConfiguracaoGui configuracaoGui;

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

	public CertificadoControl getCertificadoCont() {
		return certificadoControl;
	}

	public CertificadoPc getCertificadoPc() {
		return certificadoPc;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		certificadoControl = new CertificadoControl();
		addWindowListener(certificadoControl.new Frame());
		certificadoPc.getLabelFuncionario().addMouseListener(certificadoControl.new MostraFrame());
		certificadoPc.getTB().getExcluirBtn().addActionListener(certificadoControl.new Exclui());
		certificadoPc.getTB().getNovoBtn().addActionListener(certificadoControl.new Novo());
		certificadoPc.getTB().getPesquisarBtn().addActionListener(certificadoControl.new Pesquisa());
		certificadoPc.getTB().getImprimirBtn().addActionListener(certificadoControl.new Imprime());
		certificadoPc.getTB().getRelatorioBtn().addActionListener(certificadoControl.new Relatorio());
		certificadoPc.getTB().getSalvarBtn().addActionListener(certificadoControl.new Salva());
		certificadoPc.getTB().getFecharBtn().addActionListener(certificadoControl.new FechaJanela());
		certificadoPc.getTB().getSairBtn().addActionListener(certificadoControl.new SaidaSistema());
		certificadoPc.getTB().getAjudaBtn().addActionListener(certificadoControl.new Ajuda());
		certificadoPc.getTB().getHomeBtn().addActionListener(certificadoControl.new Home());
		certificadoPc.getTB().getRegistrosBtn().addActionListener(certificadoControl.new Registro());
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
		certificadoPc.reiniciarGui();
	}
}
