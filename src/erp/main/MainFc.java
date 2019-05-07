package erp.main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public class MainFc extends JFrame {

	private static MainCont mainCont;

	public static MainFc getFrameMain() {
		return MainCont.getMainFc();
	}

	public static MainCont getMainGerenteEventos() {
		return mainCont;
	}

	public static void mostrarFrame(JFrame frame) {
		MainCont.mostrarFrame(frame);
	}

	private JMenu menuAjuda;
	private JMenu menuArquivo;
	private final JMenuBar menuBar = new JMenuBar();
	private JMenu menuCadastro;
	private JMenu menuCadastroCurriculo;
	private JMenu menuCadastroProduto;
	private JMenu menuCadastroVeiculo;
	private JMenu menuContabilidade;
	private JMenu menuEscritorio;
	private JMenu menuEstatistica;
	private JMenu menuFinanceiro;
	private JMenuItem menuItemAjudaSobreSistema;
	private JMenuItem menuItemArquivoLogin;
	private JMenuItem menuItemArquivoLogoff;
	private JMenuItem menuItemArquivoReiniciar;
	private JMenuItem menuItemArquivoSair;
	private JMenuItem menuItemCadastroBanco;
	private JMenuItem menuItemCadastroCartorio;
	private JMenuItem menuItemCadastroCentroCusto;
	private JMenuItem menuItemCadastroCliente;
	private JMenuItem menuItemCadastroContador;
	private JMenuItem menuItemCadastroCurriculoCaracteristica;
	private JMenuItem menuItemCadastroCurriculoCertificado;
	private JMenuItem menuItemCadastroCurriculoCurso;
	private JMenuItem menuItemCadastroCurriculoExperienciaProfissional;
	private JMenuItem menuItemCadastroCurriculoHabilidade;
	private JMenuItem menuItemCadastroCurriculoIdioma;
	private JMenuItem menuItemCadastroCurriculoObjetivoProfissional;
	private JMenuItem menuItemCadastroCurriculoTesteDisc;
	private JMenuItem menuItemCadastroCurriculoTestePersonalidadeA;
	private JMenuItem menuItemCadastroDocumento;
	private JMenuItem menuItemCadastroEmpresa;
	private JMenuItem menuItemCadastroEscolaridade;
	private JMenuItem menuItemCadastroFornecedor;
	private JMenuItem menuItemCadastroFuncionario;
	private JMenuItem menuItemCadastroImovel;
	private JMenuItem menuItemCadastroProdutoCategoria;
	private JMenuItem menuItemCadastroProdutoMarca;
	private JMenuItem menuItemCadastroProdutoProduto;
	private JMenuItem menuItemCadastroServico;
	private JMenuItem menuItemCadastroSindicato;
	private JMenuItem menuItemCadastroVeiculoMarca;
	private JMenuItem menuItemCadastroVeiculoModelo;
	private JMenuItem menuItemCadastroVeiculoVeiculo;
	private JMenuItem menuItemCadastroVenda;
	private JMenuItem menuItemEstatisticaGrafico;
	private JMenuItem menuItemEstatisticaRelatorio;
	private JMenuItem menuItemFinanceiroBoletoBancario;
	private JMenuItem menuItemFinanceiroCaixa;
	private JMenuItem menuItemFinanceiroContasPagar;
	private JMenuItem menuItemFinanceiroContasReceber;
	private JMenuItem menuItemSistemaBackup;
	private JMenuItem menuItemSistemaDados;
	private JMenuItem menuItemSistemaRestaurar;
	private JMenuItem menuItemSistemaUsuario;
	private JMenuItem menuItemUtilitarioAgendaContato;
	private JMenuItem menuItemUtilitarioAgendaEvento;
	private JMenuItem menuItemUtilitarioAgendaRecado;
	private JMenuItem menuItemUtilitarioAgendaTipoEvento;
	private JMenuItem menuItemUtilitarioCalculadora;
	private JMenuItem menuItemUtilitarioEditorTexto;
	private JMenuItem menuItemUtilitarioMalaDireta;
	private JMenu menuSistema;
	private JMenu menuUtilitario;
	private JMenu menuUtilitarioAgenda;

	public MainFc() {
		iniciarGui();
		iniciarCont();
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

	public JMenuItem getMenuItemCadastroCurriculoCaracteristica() {
		return menuItemCadastroCurriculoCaracteristica;
	}

	public JMenuItem getMenuItemCadastroCurriculoCertificado() {
		return menuItemCadastroCurriculoCertificado;
	}

	public JMenuItem getMenuItemCadastroCurriculoCurso() {
		return menuItemCadastroCurriculoCurso;
	}

	public JMenuItem getMenuItemCadastroCurriculoExperienciaProfissional() {
		return menuItemCadastroCurriculoExperienciaProfissional;
	}

	public JMenuItem getMenuItemCadastroCurriculoHabilidade() {
		return menuItemCadastroCurriculoHabilidade;
	}

	public JMenuItem getMenuItemCadastroCurriculoIdioma() {
		return menuItemCadastroCurriculoIdioma;
	}

	public JMenuItem getMenuItemCadastroCurriculoObjetivoProfissional() {
		return menuItemCadastroCurriculoObjetivoProfissional;
	}

	public JMenuItem getMenuItemCadastroCurriculoTesteDisc() {
		return menuItemCadastroCurriculoTesteDisc;
	}

	public JMenuItem getMenuItemCadastroCurriculoTestePersonalidadeA() {
		return menuItemCadastroCurriculoTestePersonalidadeA;
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

	public JMenuItem getMenuItemCadastroServico() {
		return menuItemCadastroServico;
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

	public JMenuItem getMenuItemEstatisticaGrafico() {
		return menuItemEstatisticaGrafico;
	}

	public JMenuItem getMenuItemEstatisticaRelatorio() {
		return menuItemEstatisticaRelatorio;
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

	public JMenuItem getMenuItemSistemaDados() {
		return menuItemSistemaDados;
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

	public JMenuItem getMenuItemUtilitarioCalculadora() {
		return menuItemUtilitarioCalculadora;
	}

	public JMenuItem getMenuItemUtilitarioEditorTexto() {
		return menuItemUtilitarioEditorTexto;
	}

	public JMenuItem getMenuItemUtilitarioMalaDireta() {
		return menuItemUtilitarioMalaDireta;
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

	public void iniciarCont() {
		mainCont = MainCont.getInstance(this);
		Timer timer = new Timer(1000, mainCont.new Relogio());
		timer.setInitialDelay(0);
		timer.setRepeats(true);
		timer.start();
		addWindowListener(mainCont.new FrameGerenteEventos());
		menuItemArquivoLogin.addActionListener(mainCont.new MenuArquivoGerenteEventos());
		menuItemArquivoLogoff.addActionListener(mainCont.new MenuArquivoGerenteEventos());
		menuItemArquivoReiniciar.addActionListener(mainCont.new MenuArquivoGerenteEventos());
		menuItemArquivoSair.addActionListener(mainCont.new MenuArquivoGerenteEventos());
		menuItemCadastroBanco.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroCentroCusto.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroCartorio.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroContador.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroFuncionario.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroCliente.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroCurriculoCaracteristica.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroCurriculoCertificado.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroCurriculoCurso.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroCurriculoExperienciaProfissional.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroCurriculoHabilidade.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroCurriculoIdioma.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroCurriculoObjetivoProfissional.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroCurriculoTestePersonalidadeA.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroCurriculoTesteDisc.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroEmpresa.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroSindicato.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroServico.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroFornecedor.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroVeiculoVeiculo.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroVeiculoModelo.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroVeiculoMarca.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemCadastroImovel.addActionListener(mainCont.new MenuCadastroGerenteEventos());
		menuItemAjudaSobreSistema.addActionListener(mainCont.new MenuAjudaGerenteEventos());
		menuItemSistemaUsuario.addActionListener(mainCont.new MenuSistemaGerenteEventos());
		menuItemUtilitarioAgendaEvento.addActionListener(mainCont.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioAgendaTipoEvento.addActionListener(mainCont.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioAgendaRecado.addActionListener(mainCont.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioAgendaContato.addActionListener(mainCont.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioCalculadora.addActionListener(mainCont.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioEditorTexto.addActionListener(mainCont.new MenuUtilitarioGerenteEventos());
	}

	private void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(1200, 600));
		
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

		menuCadastroCurriculo = new JMenu("Currículo");
		menuCadastro.add(menuCadastroCurriculo);

		menuItemCadastroCurriculoCaracteristica = new JMenuItem("Características");
		menuCadastroCurriculo.add(menuItemCadastroCurriculoCaracteristica);

		menuItemCadastroCurriculoCertificado = new JMenuItem("Certificados");
		menuCadastroCurriculo.add(menuItemCadastroCurriculoCertificado);

		menuItemCadastroCurriculoCurso = new JMenuItem("Cursos");
		menuCadastroCurriculo.add(menuItemCadastroCurriculoCurso);

		menuItemCadastroCurriculoExperienciaProfissional = new JMenuItem("Experiência Profissional");
		menuCadastroCurriculo.add(menuItemCadastroCurriculoExperienciaProfissional);

		menuItemCadastroCurriculoHabilidade = new JMenuItem("Habilidades");
		menuCadastroCurriculo.add(menuItemCadastroCurriculoHabilidade);

		menuItemCadastroCurriculoIdioma = new JMenuItem("Idiomas");
		menuCadastroCurriculo.add(menuItemCadastroCurriculoIdioma);

		menuItemCadastroCurriculoObjetivoProfissional = new JMenuItem("Objetivo Profissional");
		menuCadastroCurriculo.add(menuItemCadastroCurriculoObjetivoProfissional);

		menuItemCadastroCurriculoTestePersonalidadeA = new JMenuItem("Teste de Personalidade A");
		menuCadastroCurriculo.add(menuItemCadastroCurriculoTestePersonalidadeA);

		menuItemCadastroCurriculoTesteDisc = new JMenuItem("Teste D.I.S.C");
		menuCadastroCurriculo.add(menuItemCadastroCurriculoTesteDisc);

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

		menuItemCadastroServico = new JMenuItem("Serviços");
		menuCadastro.add(menuItemCadastroServico);

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

		menuItemSistemaDados = new JMenuItem("Dados do Sistema");
		menuSistema.add(menuItemSistemaDados);

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
}