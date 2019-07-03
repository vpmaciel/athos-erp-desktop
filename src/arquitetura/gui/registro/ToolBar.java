package arquitetura.gui.registro;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;

import arquitetura.gui.Imagem;

public class ToolBar {

	JButton buttonAjuda = new JButton(Imagem.getAjudar());
	JButton buttonAnalise = new JButton(Imagem.getAnalise());
	JButton buttonCsv = new JButton(Imagem.getCsv());
	JButton buttonExclui = new JButton(Imagem.getExclui());
	JButton buttonExportar = new JButton(Imagem.getExportar());
	JButton buttonFechar = new JButton(Imagem.getFechar());
	JButton buttonGrafico = new JButton(Imagem.getGrafico());
	JButton buttonHome = new JButton(Imagem.getHome());
	JButton buttonImportar = new JButton(Imagem.getImportar());
	JButton buttonImprime = new JButton(Imagem.getImprime());
	JButton buttonJson = new JButton(Imagem.getJson());
	JButton buttonNegocios = new JButton(Imagem.getNegocios());
	JButton buttonNovo = new JButton(Imagem.getNovo());
	JButton buttonPesquisa = new JButton(Imagem.getPesquisar());
	JButton buttonPlanilha = new JButton(Imagem.getPlanilha());
	JButton buttonRegistros = new JButton(Imagem.getRegistros());
	JButton buttonRelatorio = new JButton(Imagem.getRelatorio());
	JButton buttonSair = new JButton(Imagem.getSair());
	JButton buttonSalvar = new JButton(Imagem.getSalva());
	JButton buttonTxt = new JButton(Imagem.getTxt());
	JButton buttonXml = new JButton(Imagem.getXml());

	JToolBar toolBar = new JToolBar();

	public ToolBar() {
		toolBar.setPreferredSize(new Dimension(840, 40));
		toolBar.setMinimumSize(new Dimension(840, 40));
		toolBar.setSize(new Dimension(840, 40));
		toolBar.setMaximumSize(new Dimension(840, 40));
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

		buttonRegistros.setToolTipText("Registros");
		toolBar.add(buttonRegistros);

		buttonImprime.setToolTipText("Imprimir");
		toolBar.add(buttonImprime);

		buttonPlanilha.setToolTipText("Planilha");
		toolBar.add(buttonPlanilha);

		buttonCsv.setToolTipText("Csv");
		toolBar.add(buttonCsv);

		buttonXml.setToolTipText("Xml");
		toolBar.add(buttonXml);

		buttonTxt.setToolTipText("Txt");
		toolBar.add(buttonTxt);

		buttonJson.setToolTipText("Json");
		toolBar.add(buttonJson);

		buttonRelatorio.setToolTipText("Relatório");
		toolBar.add(buttonRelatorio);

		buttonAnalise.setToolTipText("Análise");
		toolBar.add(buttonAnalise);

		buttonNegocios.setToolTipText("Negócios");
		toolBar.add(buttonNegocios);

		buttonExportar.setToolTipText("Exportar");
		toolBar.add(buttonExportar);

		buttonImportar.setToolTipText("Importar");
		toolBar.add(buttonImportar);

		buttonGrafico.setToolTipText("Gráfico");
		toolBar.add(buttonGrafico);

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

	public JButton getAnaliseBtn() {
		return buttonAnalise;
	}

	public JButton getCsvBtn() {
		return buttonCsv;
	}

	public JButton getExcluirBtn() {
		return buttonExclui;
	}

	public JButton getExportarBtn() {
		return buttonExportar;
	}

	public JButton getFecharBtn() {
		return buttonFechar;
	}

	public JButton getGraficoBtn() {
		return buttonGrafico;
	}

	public JButton getHomeBtn() {
		return buttonHome;
	}

	public JButton getImportarBtn() {
		return buttonImportar;
	}

	public JButton getImprimirBtn() {
		return buttonImprime;
	}

	public JButton getJsonBtn() {
		return buttonJson;
	}

	public JButton getNegociosBtn() {
		return buttonNegocios;
	}

	public JButton getNovoBtn() {
		return buttonNovo;
	}

	public JButton getOdsBtn() {
		return buttonPlanilha;
	}

	public JButton getPesquisarBtn() {
		return buttonPesquisa;
	}

	public JButton getRegistrosBtn() {
		return buttonRegistros;
	}

	public JButton getRelatorioBtn() {
		return buttonRelatorio;
	}

	public JButton getSairBtn() {
		return buttonSair;
	}

	public JButton getSalvarBtn() {
		return buttonSalvar;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}

	public JButton getTxtBtn() {
		return buttonTxt;
	}

	public JButton getXmlBtn() {
		return buttonXml;
	}
}