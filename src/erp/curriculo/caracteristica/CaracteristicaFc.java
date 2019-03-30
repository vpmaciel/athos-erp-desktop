package erp.curriculo.caracteristica;

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
public final class CaracteristicaFc extends JFrame implements Gui {

	private CaracteristicaCont caracteristicaCont;
	private ConfiguracaoGui configuracaoGui;
	private CaracteristicaPc clientePc;

	public CaracteristicaFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public CaracteristicaCont getCaracteristicaHandle() {
		return caracteristicaCont;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public CaracteristicaPc getCaracteristicaPc() {
		return clientePc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		clientePc = new CaracteristicaPc();
		clientePc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(clientePc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (clientePc.isAncestorOf(focused)) {
							clientePc.scrollRectToVisible(focused.getBounds());
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
		caracteristicaCont = new CaracteristicaCont();
		addWindowListener(caracteristicaCont.new Frame());
		clientePc.getTB().getExcluirBtn().addActionListener(caracteristicaCont.new Exclui());
		clientePc.getTB().getNovoBtn().addActionListener(caracteristicaCont.new Novo());
		clientePc.getTB().getPesquisarBtn().addActionListener(caracteristicaCont.new Pesquisa());
		clientePc.getTB().getImprimirBtn().addActionListener(caracteristicaCont.new Imprime());
		clientePc.getTB().getRelatorioBtn().addActionListener(caracteristicaCont.new Relatorio());
		clientePc.getTB().getSalvarBtn().addActionListener(caracteristicaCont.new Salva());
		clientePc.getTB().getFecharBtn().addActionListener(caracteristicaCont.new FechaJanela());
		clientePc.getTB().getSairBtn().addActionListener(caracteristicaCont.new SaidaSistema());
		clientePc.getTB().getAjudaBtn().addActionListener(caracteristicaCont.new Ajuda());
		clientePc.getTB().getHomeBtn().addActionListener(caracteristicaCont.new Home());
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
		clientePc.reiniciarGui();
	}
}
