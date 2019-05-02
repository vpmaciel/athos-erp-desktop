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
	private CaracteristicaPc caracteristicaPc;

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

	public CaracteristicaCont getCaracteristicaCont() {
		return caracteristicaCont;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public CaracteristicaPc getCaracteristicaPc() {
		return caracteristicaPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		caracteristicaPc = new CaracteristicaPc();
		caracteristicaPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(caracteristicaPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (caracteristicaPc.isAncestorOf(focused)) {
							caracteristicaPc.scrollRectToVisible(focused.getBounds());
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
		caracteristicaPc.getLabelFuncionario().addMouseListener(caracteristicaCont.new MostraFrame());
		caracteristicaPc.getTB().getExcluirBtn().addActionListener(caracteristicaCont.new Exclui());
		caracteristicaPc.getTB().getNovoBtn().addActionListener(caracteristicaCont.new Novo());
		caracteristicaPc.getTB().getPesquisarBtn().addActionListener(caracteristicaCont.new Pesquisa());
		caracteristicaPc.getTB().getImprimirBtn().addActionListener(caracteristicaCont.new Imprime());
		caracteristicaPc.getTB().getRelatorioBtn().addActionListener(caracteristicaCont.new Relatorio());
		caracteristicaPc.getTB().getSalvarBtn().addActionListener(caracteristicaCont.new Salva());
		caracteristicaPc.getTB().getFecharBtn().addActionListener(caracteristicaCont.new FechaJanela());
		caracteristicaPc.getTB().getSairBtn().addActionListener(caracteristicaCont.new SaidaSistema());
		caracteristicaPc.getTB().getAjudaBtn().addActionListener(caracteristicaCont.new Ajuda());
		caracteristicaPc.getTB().getHomeBtn().addActionListener(caracteristicaCont.new Home());
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
		caracteristicaPc.reiniciarGui();
	}
}
