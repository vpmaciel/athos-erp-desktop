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

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.Gui;
import arquitetura.gui.GuiGerenteEventos;
import arquitetura.gui.TamanhoUpperCase;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Mascara;
import erp.agenda.evento.tipoevento.TipoEvento;
import erp.agenda.evento.tipoevento.TipoEventoDaoFacade;
import erp.agenda.evento.tipoevento.TipoEventoSort;
import erp.main.MainControlador;

@SuppressWarnings("serial")
public final class PCEvento extends JPanel implements Gui {

	private ToolBar toolBar;
	private GuiGerenteEventos guiGerenteEventos;
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

	public PCEvento() {
		iniciarLayout();
		iniciarGui();
		iniciarFocusTabListener();
		iniciarGuiGerenteEventos();
	}

	@Override
	public void atualizarTable() {

	}

	public JComboBox<TipoEvento> getBoxTipoEvento() {
		return boxTipoEvento;
	}

	@Override
	public GuiGerenteEventos getGuiGerenteEventos() {
		return guiGerenteEventos;
	}

	public JLabel getLabelTipoEvento() {
		return labelTipoEvento;
	}

	public JTextField getTextFieldHoraInicio() {
		return textFieldHoraInicio;
	}
	
	public JTextField getTextFieldData() {
		return textFieldData;
	}
	
	
	public JTextField getTextFieldHoraTermino() {
		return textFieldHoraTermino;
	}

	public JTextField getTextFieldDescricao() {
		return textFieldDescricao;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {

		final Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
		
		toolBar = new ToolBar();

		add(toolBar.getToolBar());

		labelTipoEvento = new JLabel("TIPO DE EVENTO");
		labelTipoEvento.setCursor(cursor);
		add(labelTipoEvento);

		boxTipoEvento = new JComboBox<TipoEvento>();
		List<TipoEvento> tipoEventos = (List<TipoEvento>) TipoEventoDaoFacade.getRegistro();
		Collections.sort(tipoEventos, new TipoEventoSort().new Nome());
		for (TipoEvento tipoEvento : tipoEventos) {
			boxTipoEvento.addItem(tipoEvento);
		}
		boxTipoEvento.setMaximumRowCount(5);
		add(boxTipoEvento);
		
		labelDescricao = new JLabel("DESCRIÇÃO");
		add(labelDescricao);

		textFieldDescricao = new JTextField();
		textFieldDescricao.setDocument(new TamanhoUpperCase(50));
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
	public void iniciarGuiGerenteEventos() {
		guiGerenteEventos = new GuiGerenteEventos(this);
	}

	@Override
	public void iniciarGerenteEventos() {

	}

	@Override
	public void iniciarLayout() {
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTable() {

	}

	@Override
	public void limparGui() {
		guiGerenteEventos.limparGui();
		reiniciarBox();
	}

	@Override
	public void reiniciarBox() {
		TipoEvento tipoEvento = null;
		List<TipoEvento> tipoEventos = (List<TipoEvento>) TipoEventoDaoFacade.getRegistro();
		Collections.sort(tipoEventos, new TipoEventoSort().new Nome());
		boxTipoEvento.removeAllItems();
		for (TipoEvento b : tipoEventos) {
			boxTipoEvento.addItem(b);
		}

		if (!MainControlador.getFrameCadastroAgendaEvento().isShowing()
				&& MainControlador.getFrameCadastroAgendaEvento().getEventoGerenteEventos().getEvento() != null) {
			tipoEvento = MainControlador.getFrameCadastroAgendaEvento().getEventoGerenteEventos().getEvento().getTipoEvento();
			System.out.println(tipoEvento);
			boxTipoEvento.setSelectedItem(tipoEvento);
		}
	}
}
