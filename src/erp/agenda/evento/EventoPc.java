package erp.agenda.evento;

import java.awt.Cursor;
import java.util.Collections;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Mascara;
import erp.agenda.evento.tipoevento.TipoEvento;
import erp.agenda.evento.tipoevento.TipoEventoFac;
import erp.agenda.evento.tipoevento.TipoEventoComp;
import erp.main.MainCont;

@SuppressWarnings("serial")
public final class EventoPc extends JPanel implements Gui {

	private ToolBar toolBar;
	private ConfiguracaoGui configuracaoGui;
	private JTextField textFieldDescricao;
	private JLabel labelDescricao;
	private JFormattedTextField	 textFieldHoraInicio;
	private JLabel labelHoraTermino;
	private JFormattedTextField textFieldHoraTermino;
	private JLabel labelHoraInicio;
	private JLabel labelData;
	private JFormattedTextField textFieldData;
	private JComboBox<TipoEvento> boxTipoEvento;
	private JLabel labelTipoEvento;

	public EventoPc() {
		iniciarLayout();
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public JComboBox<TipoEvento> getTipoEventoGUI() {
		return boxTipoEvento;
	}

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
		return configuracaoGui;
	}

	public JLabel getLabelTipoEvento() {
		return labelTipoEvento;
	}

	public JTextField getHoraInicioGUI() {
		return textFieldHoraInicio;
	}
	
	public JTextField getDataGUI() {
		return textFieldData;
	}
	
	
	public JTextField getHoraTerminoGUI() {
		return textFieldHoraTermino;
	}

	public JTextField getDescricaoGUI() {
		return textFieldDescricao;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGUI() {

		final Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
		
		toolBar = new ToolBar();

		add(toolBar.getToolBar());

		labelTipoEvento = new JLabel("TIPO DE EVENTO");
		labelTipoEvento.setCursor(cursor);
		add(labelTipoEvento);

		boxTipoEvento = new JComboBox<TipoEvento>();
		List<TipoEvento> tipoEventos = (List<TipoEvento>) TipoEventoFac.getRegistro();
		Collections.sort(tipoEventos, new TipoEventoComp().new Nome());
		for (TipoEvento tipoEvento : tipoEventos) {
			boxTipoEvento.addItem(tipoEvento);
		}
		boxTipoEvento.setMaximumRowCount(5);
		add(boxTipoEvento);
		
		labelDescricao = new JLabel("DESCRIÇÃO");
		add(labelDescricao);

		textFieldDescricao = new JTextField();
		textFieldDescricao.setDocument(new EntradaMaiuscula(50));
		add(textFieldDescricao);
		
		labelData = new JLabel("DATA");
		add(labelData);

		textFieldData = new JFormattedTextField(Mascara.getData());
		add(textFieldData);

		labelHoraInicio = new JLabel("HORÁRIO DE INÍCIO");
		add(labelHoraInicio);

		textFieldHoraInicio = new JFormattedTextField(Mascara.getHora());
		add(textFieldHoraInicio);
		
		labelHoraTermino = new JLabel("HORÁRIO DE TÉRMINO");
		add(labelHoraTermino);

		textFieldHoraTermino = new JFormattedTextField(Mascara.getHora());
		add(textFieldHoraTermino);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 11, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
	}

	@Override
	public void iniciarGUIControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {

	}

	@Override
	public void iniciarLayout() {
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGUI() {
		configuracaoGui.limparGui();
		reiniciarGUI();
	}

	@Override
	public void reiniciarGUI() {
		TipoEvento tipoEvento = null;
		List<TipoEvento> tipoEventos = (List<TipoEvento>) TipoEventoFac.getRegistro();
		Collections.sort(tipoEventos, new TipoEventoComp().new Nome());
		boxTipoEvento.removeAllItems();
		for (TipoEvento b : tipoEventos) {
			boxTipoEvento.addItem(b);
		}

		if (!MainCont.getAgendaEventoFc().isShowing()
				&& MainCont.getAgendaEventoFc().getEventoGerenteEventos().getEvento() != null) {
			tipoEvento = MainCont.getAgendaEventoFc().getEventoGerenteEventos().getEvento().getTipoEvento();
			System.out.println(tipoEvento);
			boxTipoEvento.setSelectedItem(tipoEvento);
		}
	}
}