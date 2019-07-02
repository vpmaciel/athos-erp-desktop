package erp.banco;

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
public final class BancoFc extends JFrame implements Gui {

	private BancoControl bancoControl;
	private BancoPc bancoPc;
	private ConfiguracaoGui configuracaoGui;

	public BancoFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {
	}

	public void desabilitarGui() {
	}

	public BancoControl getBancoCont() {
		return bancoControl;
	}

	public BancoPc getBancoPc() {
		return bancoPc;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		bancoControl = new BancoControl();
		addWindowListener(bancoControl.new Frame());
		bancoPc.getTB().getExcluirBtn().addActionListener(bancoControl.new Exclui());
		bancoPc.getTB().getNovoBtn().addActionListener(bancoControl.new Novo());
		bancoPc.getTB().getPesquisarBtn().addActionListener(bancoControl.new Pesquisa());
		bancoPc.getTB().getImprimirBtn().addActionListener(bancoControl.new Imprime());
		bancoPc.getTB().getRelatorioBtn().addActionListener(bancoControl.new Relatorio());
		bancoPc.getTB().getSalvarBtn().addActionListener(bancoControl.new Salva());
		bancoPc.getTB().getFecharBtn().addActionListener(bancoControl.new FechaJanela());
		bancoPc.getTB().getSairBtn().addActionListener(bancoControl.new SaidaSistema());
		bancoPc.getTB().getAjudaBtn().addActionListener(bancoControl.new Ajuda());
		bancoPc.getTB().getHomeBtn().addActionListener(bancoControl.new Home());
		bancoPc.getTB().getRegistrosBtn().addActionListener(bancoControl.new Registro());
		bancoPc.getTB().getOdsBtn().addActionListener(bancoControl.new FormatoOds());
		bancoPc.getTB().getCsvBtn().addActionListener(bancoControl.new FormatoCsv());
		bancoPc.getTB().getTxtBtn().addActionListener(bancoControl.new FormatoTxt());
		bancoPc.getTB().getXmlBtn().addActionListener(bancoControl.new FormatoXml());
		bancoPc.getTB().getAnaliseBtn().setEnabled(false);
		bancoPc.getTB().getNegociosBtn().setEnabled(false);
		bancoPc.getTB().getGraficoBtn().setEnabled(false);
		bancoPc.getTB().getImportarBtn().setEnabled(false);
		bancoPc.getTB().getExportarBtn().setEnabled(false);
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		bancoPc = new BancoPc();
		bancoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(bancoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (bancoPc.isAncestorOf(focused)) {
							bancoPc.scrollRectToVisible(focused.getBounds());
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
		bancoPc.limparGui();
	}

	@Override
	public void reiniciarGui() {
		bancoPc.reiniciarGui();
	}

	public boolean validarGui() {
		return bancoPc.validarGui();
	}
}