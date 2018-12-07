package erp.main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import arquitetura.AOP;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public class MainFC extends JFrame {

	private static MainCT mainCT;

	public static MainCT getMainGerenteEventos() {
		return mainCT;
	}

	public static MainFC getFrameMain() {
		return MainCT.getFrameMain();
	}

	public static void mostrarFrame(JFrame frame) {
		MainCT.mostrarFrame(frame);
	}

	private final JMenuBar menuBar = new JMenuBar();
	private JMenu menuAjuda;
	private JMenu menuArquivo;
	private JMenu menuCadastro;
	private JMenu menuCadastroProduto;
	private JMenu menuEscritorio;
	private JMenu menuContabilidade;
	private JMenu menuEstatistica;
	private JMenu menuFinanceiro;
	private JMenu menuUtilitario;
	private JMenu menuUtilitarioAgenda;
	private JMenu menuSistema;
	private JMenuItem menuItemAjudaSobreSistema;
	private JMenuItem menuItemArquivoLogin;
	private JMenuItem menuItemArquivoLogoff;
	private JMenuItem menuItemArquivoReiniciar;
	private JMenuItem menuItemArquivoSair;
	private JMenuItem menuItemCadastroCentroCusto;
	private JMenuItem menuItemCadastroBanco;
	private JMenuItem menuItemCadastroCartorio;
	private JMenuItem menuItemCadastroContador;
	private JMenuItem menuItemCadastroDocumento;
	private JMenuItem menuItemCadastroCliente;
	private JMenuItem menuItemCadastroFornecedor;
	private JMenuItem menuItemCadastroImovel;
	private JMenuItem menuItemCadastroEmpresa;
	private JMenuItem menuItemCadastroProdutoProduto;
	private JMenuItem menuItemCadastroProdutoMarca;
	private JMenuItem menuItemCadastroProdutoCategoria;
	private JMenuItem menuItemCadastroProdutoImposto;
	private JMenuItem menuItemFinanceiroCaixa;
	private JMenuItem menuItemFinanceiroContasPagar;
	private JMenuItem menuItemFinanceiroContasReceber;
	private JMenuItem menuItemCadastroEscolaridade;
	private JMenuItem menuItemCadastroFuncionario;
	private JMenuItem menuItemUtilitarioMalaDireta;
	private JMenuItem menuItemFinanceiroBoletoBancario;
	private JMenuItem menuItemCadastroVenda;
	private JMenu menuCadastroVeiculo;
	private JMenuItem menuItemCadastroVeiculoVeiculo;
	private JMenuItem menuItemCadastroVeiculoModelo;
	private JMenuItem menuItemCadastroVeiculoMarca;
	private JMenuItem menuItemCadastroSindicato;
	private JMenuItem menuItemUtilitarioAgendaContato;
	private JMenuItem menuItemUtilitarioAgendaEvento;
	private JMenuItem menuItemUtilitarioAgendaTipoEvento;
	private JMenuItem menuItemUtilitarioAgendaRecado;
	private JMenuItem menuItemUtilitarioCalculadora;
	private JMenuItem menuItemUtilitarioEditorTexto;
	private JMenuItem menuItemSistemaBackup;
	private JMenuItem menuItemSistemaRestaurar;
	private JMenuItem menuItemSistemaUsuario;
	private JMenuItem menuItemEstatisticaRelatorio;
	private JMenuItem menuItemEstatisticaGrafico;

	public MainFC() {
		iniciarGUI();
		iniciarHandle();
	}

	public JMenu getMenuAjuda() {
		return menuAjuda;
	}

	public JMenu getMenuArquivo() {
		return menuArquivo;
	}

	public JMenu getMenuCadastro() {
		return menuCadastro;
	}

	public JMenu getMenuFinanceiro() {
		return menuFinanceiro;
	}

	public JMenuItem getMenuItemAjudaSobreSistema() {
		return menuItemAjudaSobreSistema;
	}

	public JMenuItem getMenuItemArquivoLogin() {
		return menuItemArquivoLogin;
	}

	public JMenuItem getMenuItemArquivoLogoff() {
		return menuItemArquivoLogoff;
	}

	public JMenuItem getMenuItemArquivoReiniciar() {
		return menuItemArquivoReiniciar;
	}

	public JMenuItem getMenuItemArquivoSair() {
		return menuItemArquivoSair;
	}

	public JMenuItem getMenuItemCadastroBanco() {
		return menuItemCadastroBanco;
	}

	public JMenuItem getMenuItemCadastroBoletoBancario() {
		return menuItemFinanceiroBoletoBancario;
	}

	public JMenuItem getMenuItemCadastroCartorio() {
		return menuItemCadastroCartorio;
	}

	public JMenuItem getMenuItemCadastroCentroCusto() {
		return menuItemCadastroCentroCusto;
	}

	public JMenuItem getMenuItemCadastroCliente() {
		return menuItemCadastroCliente;
	}

	public JMenuItem getMenuItemCadastroContador() {
		return menuItemCadastroContador;
	}

	public JMenuItem getMenuItemCadastroDocumento() {
		return menuItemCadastroDocumento;
	}

	public JMenuItem getMenuItemCadastroEmpresa() {
		return menuItemCadastroEmpresa;
	}

	public JMenuItem getMenuItemCadastroEscolaridade() {
		return menuItemCadastroEscolaridade;
	}

	public JMenuItem getMenuItemCadastroFinanceiroContasPagar() {
		return menuItemFinanceiroContasPagar;
	}

	public JMenuItem getMenuItemCadastroFinanceiroContasReceber() {
		return menuItemFinanceiroContasReceber;
	}

	public JMenuItem getMenuItemCadastroFornecedor() {
		return menuItemCadastroFornecedor;
	}

	public JMenuItem getMenuItemCadastroFuncionario() {
		return menuItemCadastroFuncionario;
	}

	public JMenuItem getMenuItemCadastroImovel() {
		return menuItemCadastroImovel;
	}

	public JMenuItem getMenuItemCadastroProduto() {
		return menuItemCadastroProdutoProduto;
	}

	public JMenuItem getMenuItemCadastroSindicato() {
		return menuItemCadastroSindicato;
	}

	public JMenu getMenuItemCadastroVeiculo() {
		return menuCadastroVeiculo;
	}

	public JMenuItem getMenuItemCadastroVeiculoMarca() {
		return menuItemCadastroVeiculoMarca;
	}

	public JMenuItem getMenuItemCadastroVeiculoModelo() {
		return menuItemCadastroVeiculoModelo;
	}

	public JMenuItem getMenuItemCadastroVeiculoVeiculo() {
		return menuItemCadastroVeiculoVeiculo;
	}

	public JMenuItem getMenuItemCadastroVenda() {
		return menuItemCadastroVenda;
	}

	public JMenuItem getMenuItemFinanceiroBoletoBancario() {
		return menuItemFinanceiroBoletoBancario;
	}

	public JMenuItem getMenuItemFinanceiroCaixa() {
		return menuItemFinanceiroCaixa;
	}

	public JMenuItem getMenuItemFinanceiroContasPagar() {
		return menuItemFinanceiroContasPagar;
	}

	public JMenuItem getMenuItemFinanceiroContasReceber() {
		return menuItemFinanceiroContasReceber;
	}

	public JMenuItem getMenuItemSistemaBackup() {
		return menuItemSistemaBackup;
	}

	public JMenuItem getMenuItemSistemaRestaurar() {
		return menuItemSistemaRestaurar;
	}

	public JMenuItem getMenuItemSistemaUsuario() {
		return menuItemSistemaUsuario;
	}

	public JMenuItem getMenuItemUtilitarioAgendaContato() {
		return menuItemUtilitarioAgendaContato;
	}

	public JMenuItem getMenuItemUtilitarioAgendaEvento() {
		return menuItemUtilitarioAgendaEvento;
	}

	public JMenuItem getMenuItemUtilitarioAgendaRecado() {
		return menuItemUtilitarioAgendaRecado;
	}

	public JMenuItem getMenuItemUtilitarioAgendaTipoEvento() {
		return menuItemUtilitarioAgendaTipoEvento;
	}

	public JMenuItem getMenuItemUtilitarioMalaDireta() {
		return menuItemUtilitarioMalaDireta;
	}

	public JMenuItem getMenuItemUtilitarioCalculadora() {
		return menuItemUtilitarioCalculadora;
	}

	public JMenuItem getMenuItemUtilitarioEditorTexto() {
		return menuItemUtilitarioEditorTexto;
	}

	public JMenu getMenuSistema() {
		return menuSistema;
	}

	public JMenu getMenuUtilitario() {
		return menuUtilitario;
	}

	public JMenu getMenuUtilitarioAgencia() {
		return menuUtilitarioAgenda;
	}

	public JMenu getMenuUtilitarioAgenda() {
		return menuUtilitarioAgenda;
	}

	public JMenuItem getMenuItemEstatisticaRelatorio() {
		return menuItemEstatisticaRelatorio;
	}

	public JMenuItem getMenuItemEstatisticaGrafico() {
		return menuItemEstatisticaGrafico;
	}

	private void iniciarGUI() {
		setIconImage(Imagem.getLogoTipoImage());
		setTitle(AOP.getNomeSistema());
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(1200, 600));
		setMaximumSize(new Dimension(1200, 600));
		setPreferredSize(new Dimension(1200, 600));

		menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic('A');

		menuItemArquivoLogin = new JMenuItem("Login");
		menuArquivo.add(menuItemArquivoLogin);

		menuItemArquivoLogoff = new JMenuItem("Logoff");
		menuArquivo.add(menuItemArquivoLogoff);

		menuItemArquivoReiniciar = new JMenuItem("Reiniciar");
		menuArquivo.add(menuItemArquivoReiniciar);

		menuItemArquivoSair = new JMenuItem("Sair");
		menuArquivo.addSeparator();
		menuArquivo.add(menuItemArquivoSair);

		menuBar.add(menuArquivo);

		menuCadastro = new JMenu("Cadastro");
		menuCadastro.setMnemonic('C');

		menuItemCadastroBanco = new JMenuItem("Bancos");
		menuCadastro.add(menuItemCadastroBanco);

		menuItemCadastroCentroCusto = new JMenuItem("Centro de Custo");
		menuCadastro.add(menuItemCadastroCentroCusto);

		menuItemCadastroCartorio = new JMenuItem("Cartórios");
		menuCadastro.add(menuItemCadastroCartorio);

		menuItemCadastroContador = new JMenuItem("Contador");
		menuCadastro.add(menuItemCadastroContador);

		menuItemCadastroCliente = new JMenuItem("Clientes");
		menuCadastro.add(menuItemCadastroCliente);

		menuItemCadastroDocumento = new JMenuItem("Documentos");
		menuCadastro.add(menuItemCadastroDocumento);

		menuItemCadastroEmpresa = new JMenuItem("Empresas");
		menuCadastro.add(menuItemCadastroEmpresa);

		menuItemCadastroFuncionario = new JMenuItem("Funcionários");
		menuCadastro.add(menuItemCadastroFuncionario);

		menuItemCadastroFornecedor = new JMenuItem("Fornecedores");
		menuCadastro.add(menuItemCadastroFornecedor);

		menuItemCadastroImovel = new JMenuItem("Imóveis");
		menuCadastro.add(menuItemCadastroImovel);

		menuCadastroProduto = new JMenu("Produtos");
		menuCadastro.add(menuCadastroProduto);

		menuItemCadastroProdutoProduto = new JMenuItem("Produtos");
		menuCadastroProduto.add(menuItemCadastroProdutoProduto);

		menuItemCadastroProdutoMarca = new JMenuItem("Marcas");
		menuCadastroProduto.add(menuItemCadastroProdutoMarca);

		menuItemCadastroProdutoCategoria = new JMenuItem("Categorias");
		menuCadastroProduto.add(menuItemCadastroProdutoCategoria);

		menuItemCadastroProdutoImposto = new JMenuItem("Impostos");
		menuCadastroProduto.add(menuItemCadastroProdutoImposto);

		menuItemCadastroSindicato = new JMenuItem("Sindicatos");
		menuCadastro.add(menuItemCadastroSindicato);

		menuCadastroVeiculo = new JMenu("Veículos");
		menuCadastro.add(menuCadastroVeiculo);

		menuItemCadastroVeiculoMarca = new JMenuItem("Marca");
		menuCadastroVeiculo.add(menuItemCadastroVeiculoMarca);

		menuItemCadastroVeiculoModelo = new JMenuItem("Modelos");
		menuCadastroVeiculo.add(menuItemCadastroVeiculoModelo);

		menuItemCadastroVeiculoVeiculo = new JMenuItem("Veículos");
		menuCadastroVeiculo.add(menuItemCadastroVeiculoVeiculo);

		menuItemCadastroVenda = new JMenuItem("Vendas");
		menuCadastro.add(menuItemCadastroVenda);

		menuBar.add(menuCadastro);

		menuEscritorio = new JMenu("Escritório");
		menuEscritorio.setMnemonic('E');

		menuBar.add(menuEscritorio);

		menuFinanceiro = new JMenu("Financeiro");
		menuFinanceiro.setMnemonic('F');
		menuCadastro.add(menuFinanceiro);

		menuItemFinanceiroBoletoBancario = new JMenuItem("Boleto Bancário");
		menuFinanceiro.add(menuItemFinanceiroBoletoBancario);

		menuItemFinanceiroCaixa = new JMenuItem("Caixa");
		menuFinanceiro.add(menuItemFinanceiroCaixa);

		menuItemFinanceiroContasPagar = new JMenuItem("Contas a Pagar");
		menuFinanceiro.add(menuItemFinanceiroContasPagar);

		menuItemFinanceiroContasReceber = new JMenuItem("Contas a Receber");
		menuFinanceiro.add(menuItemFinanceiroContasReceber);

		menuBar.add(menuFinanceiro);

		menuContabilidade = new JMenu("Contabilidade");
		menuContabilidade.setMnemonic('o');
		menuBar.add(menuContabilidade);

		menuEstatistica = new JMenu("Estatística");
		menuEstatistica.setMnemonic('E');

		menuItemEstatisticaGrafico = new JMenuItem("Gráficos");
		menuEstatistica.add(menuItemEstatisticaGrafico);

		menuItemEstatisticaRelatorio = new JMenuItem("Relatórios");
		menuEstatistica.add(menuItemEstatisticaRelatorio);

		menuBar.add(menuEstatistica);

		menuUtilitario = new JMenu("Utilitários");
		menuUtilitario.setMnemonic('U');

		menuUtilitarioAgenda = new JMenu("Agenda");
		menuUtilitario.add(menuUtilitarioAgenda);

		menuItemUtilitarioAgendaContato = new JMenuItem("Contato");
		menuUtilitarioAgenda.add(menuItemUtilitarioAgendaContato);

		menuItemUtilitarioAgendaEvento = new JMenuItem("Evento");
		menuUtilitarioAgenda.add(menuItemUtilitarioAgendaEvento);

		menuItemUtilitarioAgendaTipoEvento = new JMenuItem("Tipo de Evento");
		menuUtilitarioAgenda.add(menuItemUtilitarioAgendaTipoEvento);

		menuItemUtilitarioAgendaRecado = new JMenuItem("Recado");
		menuUtilitarioAgenda.add(menuItemUtilitarioAgendaRecado);

		menuItemUtilitarioMalaDireta = new JMenuItem("Mala Direta");
		menuUtilitario.add(menuItemUtilitarioMalaDireta);

		menuItemUtilitarioCalculadora = new JMenuItem("Calculadora");
		menuUtilitario.add(menuItemUtilitarioCalculadora);

		menuItemUtilitarioEditorTexto = new JMenuItem("Editor de Texto");
		menuUtilitario.add(menuItemUtilitarioEditorTexto);

		menuBar.add(menuUtilitario);

		menuSistema = new JMenu("Sistema");
		menuSistema.setMnemonic('S');

		menuItemSistemaBackup = new JMenuItem("Database Backup");
		menuSistema.add(menuItemSistemaBackup);

		menuItemSistemaRestaurar = new JMenuItem("Database Restaurar");
		menuSistema.add(menuItemSistemaRestaurar);

		menuItemSistemaUsuario = new JMenuItem("Usuários");
		menuSistema.add(menuItemSistemaUsuario);
		menuBar.add(menuSistema);

		menuAjuda = new JMenu("Ajuda");
		menuAjuda.setMnemonic('u');

		menuItemAjudaSobreSistema = new JMenuItem("Sobre o Sistema");
		menuAjuda.add(menuItemAjudaSobreSistema);

		menuBar.add(menuAjuda);
		setJMenuBar(menuBar);
	}

	public void iniciarHandle() {
		mainCT = MainCT.getInstance(this);
		addWindowListener(mainCT.new FrameGerenteEventos());
		menuItemArquivoLogin.addActionListener(mainCT.new MenuArquivoGerenteEventos());
		menuItemArquivoLogoff.addActionListener(mainCT.new MenuArquivoGerenteEventos());
		menuItemArquivoReiniciar.addActionListener(mainCT.new MenuArquivoGerenteEventos());
		menuItemArquivoSair.addActionListener(mainCT.new MenuArquivoGerenteEventos());
		menuItemCadastroBanco.addActionListener(mainCT.new MenuCadastroGerenteEventos());
		menuItemCadastroCentroCusto.addActionListener(mainCT.new MenuCadastroGerenteEventos());
		menuItemCadastroCartorio.addActionListener(mainCT.new MenuCadastroGerenteEventos());
		menuItemCadastroContador.addActionListener(mainCT.new MenuCadastroGerenteEventos());
		menuItemCadastroFuncionario.addActionListener(mainCT.new MenuCadastroGerenteEventos());
		menuItemCadastroCliente.addActionListener(mainCT.new MenuCadastroGerenteEventos());
		menuItemCadastroEmpresa.addActionListener(mainCT.new MenuCadastroGerenteEventos());
		menuItemCadastroSindicato.addActionListener(mainCT.new MenuCadastroGerenteEventos());
		menuItemCadastroFornecedor.addActionListener(mainCT.new MenuCadastroGerenteEventos());
		menuItemCadastroVeiculoVeiculo.addActionListener(mainCT.new MenuCadastroGerenteEventos());
		menuItemCadastroVeiculoModelo.addActionListener(mainCT.new MenuCadastroGerenteEventos());
		menuItemCadastroVeiculoMarca.addActionListener(mainCT.new MenuCadastroGerenteEventos());
		menuItemCadastroImovel.addActionListener(mainCT.new MenuCadastroGerenteEventos());
		menuItemAjudaSobreSistema.addActionListener(mainCT.new MenuAjudaGerenteEventos());
		menuItemSistemaUsuario.addActionListener(mainCT.new MenuSistemaGerenteEventos());
		menuItemUtilitarioAgendaEvento.addActionListener(mainCT.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioAgendaTipoEvento.addActionListener(mainCT.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioAgendaRecado.addActionListener(mainCT.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioAgendaContato.addActionListener(mainCT.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioCalculadora.addActionListener(mainCT.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioEditorTexto.addActionListener(mainCT.new MenuUtilitarioGerenteEventos());
	}
}