package erp.imovel;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.Gui;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class ImovelFp extends JFrame implements Gui {

	private ImovelPp ImovelPp;

	public ImovelFp() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGUI();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
		return null;
	}

	public ImovelPp getImovelPp() {
		return ImovelPp;
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGUI() {
		setTitle("Imóveis");
		setIconImage(Imagem.getLogoTipoImage());
		ImovelPp = new ImovelPp();
		setContentPane(ImovelPp);
	}

	@Override
	public void iniciarGUIControlador() {

	}

	@Override
	public void iniciarControlador() {
		ImovelPp.iniciarHandle();
	}

	@Override
	public void iniciarLayout() {
		setLayout(null);
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGUI() {

	}

	@Override
	public void reiniciarGUI() {

	}
}
