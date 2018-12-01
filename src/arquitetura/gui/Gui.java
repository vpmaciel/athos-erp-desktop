package arquitetura.gui;

public interface Gui {

	void atualizarTable();

	GuiHandle getGuiGerenteEventos();

	void iniciarFocusTabListener();

	void iniciarGui();

	void iniciarGuiGerenteEventos();

	void iniciarGerenteEventos();

	void iniciarLayout();

	void iniciarTable();

	void limparGui();

	void reiniciarBox();
}
