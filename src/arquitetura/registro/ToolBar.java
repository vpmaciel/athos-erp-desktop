package arquitetura.registro;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;

import arquitetura.gui.Imagem;

public class ToolBar {

	JToolBar toolBar = new JToolBar();

	JButton buttonHome = new JButton(Imagem.getHome());
	JButton buttonNovo = new JButton(Imagem.getNovo());
	JButton buttonExclui = new JButton(Imagem.getExclui());
	JButton buttonSalvar = new JButton(Imagem.getSalva());
	JButton buttonImprime = new JButton(Imagem.getImprime());
	JButton buttonPesquisa = new JButton(Imagem.getpesquisar());
	JButton buttonRelatorio = new JButton(Imagem.getRelatorio());
	JButton buttonAjuda = new JButton(Imagem.getAjudar());
	JButton buttonFechar = new JButton(Imagem.getFechar());
	JButton buttonSair = new JButton(Imagem.getSair());

	public ToolBar() {
		toolBar.setPreferredSize(new Dimension(700, 40));
		toolBar.setMinimumSize(new Dimension(700, 40));
		toolBar.setSize(new Dimension(700, 40));
		toolBar.setMaximumSize(new Dimension(700, 40));
		toolBar.setFloatable(false);
		toolBar.setOpaque(false);
		toolBar.setBorder(BorderFactory.createEtchedBorder());

		buttonHome.setToolTipText("Home");
		toolBar.add(buttonHome);

		buttonNovo.setToolTipText("Novo");
		toolBar.add(buttonNovo);

		buttonExclui.setToolTipText("Excluir");
		toolBar.add(buttonExclui);

		buttonSalvar.setToolTipText("Salvar");
		toolBar.add(buttonSalvar);

		buttonPesquisa.setToolTipText("Pesquisar");
		toolBar.add(buttonPesquisa);

		buttonImprime.setToolTipText("Imprimir");
		toolBar.add(buttonImprime);

		buttonRelatorio.setToolTipText("Relatório");
		toolBar.add(buttonRelatorio);

		buttonAjuda.setToolTipText("Ajuda");
		toolBar.add(buttonAjuda);

		buttonFechar.setToolTipText("Fechar");
		toolBar.add(buttonFechar);

		buttonSair.setToolTipText("Sair");
		toolBar.add(buttonSair);
	}

	public JButton getAjudaBtn() {
		return this.buttonAjuda;
	}

	public JButton getExcluirBtn() {
		return buttonExclui;
	}

	public JButton getFecharBtn() {
		return buttonFechar;
	}

	public JButton getHomeBtn() {
		return buttonHome;
	}

	public JButton getRelatorioBtn() {
		return this.buttonRelatorio;
	}

	public JButton getImprimirBtn() {
		return this.buttonImprime;
	}

	public JButton getNovoBtn() {
		return this.buttonNovo;
	}

	public JButton getPesquisarBtn() {
		return this.buttonPesquisa;
	}

	public JButton getSairBtn() {
		return buttonSair;
	}

	public JButton getSalvarBtn() {
		return this.buttonSalvar;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}
}
