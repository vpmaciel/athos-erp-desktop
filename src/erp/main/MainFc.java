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

	private static MainControl mainControl;

	public static MainFc getFrameMain() {
		return MainControl.getMainFc();
	}

	public static MainControl getMainGerenteEventos() {
		return mainControl;
	}

	static void mostrarFrame(JFrame frame) {
		MainControl.mostrarFrame(frame);
	}

	private JMenu menuAjuda;
	private JMenu menuArquivo;
	private final JMenuBar menuBar = new JMenuBar();
	private JMenu menuCadastro;
	private JMenu menuCadastroOculos;
	private JMenu menuCadastroProduto;
	private JMenu menuCadastroVeiculo;
	private JMenu menuContabilidade;
	private JMenu menuControle;
	private JMenu menuEconomia;
	private JMenu menuEscritorio;
	private JMenu menuEstatistica;
	private JMenu menuFinanceiro;
	private JMenu menuFinanceiroVenda;
	private JMenuItem menuItemAjudaAjudaOnLine;
	private JMenuItem menuItemAjudaAjudaSistema;
	private JMenuItem menuItemAjudaDesenvolvedores;
	private JMenuItem menuItemAjudaEnviarComentarios;
	private JMenuItem menuItemAjudaGuiaUsuario;
	private JMenuItem menuItemAjudaInformacoesSobreLicenca;
	private JMenuItem menuItemAjudaRelatarProblema;
	private JMenuItem menuItemAjudaSobreSistema;
	private JMenuItem menuItemAjudaVerificarAtualizacao;
	private JMenuItem menuItemArquivoLogin;
	private JMenuItem menuItemArquivoLogoff;
	private JMenuItem menuItemArquivoReiniciar;
	private JMenuItem menuItemArquivoSair;
	private JMenuItem menuItemCadastroBanco;
	private JMenuItem menuItemCadastroCartorio;
	private JMenuItem menuItemCadastroCentroCusto;
	private JMenuItem menuItemCadastroCliente;
	private JMenuItem menuItemCadastroContador;
	private JMenuItem menuItemCadastroDocumento;
	private JMenuItem menuItemCadastroEmpresa;
	private JMenuItem menuItemCadastroEscolaridade;
	private JMenuItem menuItemCadastroFornecedor;
	private JMenuItem menuItemCadastroImovel;
	private JMenuItem menuItemCadastroOculosArmacao;
	private JMenuItem menuItemCadastroOculosLente;
	private JMenuItem menuItemCadastroOculosOculos;
	private JMenuItem menuItemCadastroOculosTratamento;
	private JMenuItem menuItemCadastroProdutoCategoria;
	private JMenuItem menuItemCadastroProdutoListaCompras;
	private JMenuItem menuItemCadastroProdutoMarca;
	private JMenuItem menuItemCadastroProdutoProduto;
	private JMenuItem menuItemCadastroProdutoUnidade;
	private JMenuItem menuItemCadastroQuarto;
	private JMenuItem menuItemCadastroSeguradora;
	private JMenuItem menuItemCadastroServico;
	private JMenuItem menuItemCadastroSindicato;
	private JMenuItem menuItemCadastroVeiculoDocumento;
	private JMenuItem menuItemCadastroVeiculoMarca;
	private JMenuItem menuItemCadastroVeiculoModelo;
	private JMenuItem menuItemCadastroVeiculoVeiculo;
	private JMenuItem menuItemEstatisticaGrafico;
	private JMenuItem menuItemEstatisticaRelatorio;
	private JMenuItem menuItemFinanceiroBoletoBancario;
	private JMenuItem menuItemFinanceiroCaixa;
	private JMenuItem menuItemFinanceiroCarne;
	private JMenuItem menuItemFinanceiroCheque;
	private JMenuItem menuItemFinanceiroContasPagar;
	private JMenuItem menuItemFinanceiroContasReceber;
	private JMenuItem menuItemFinanceiroVendaProduto;
	private JMenuItem menuItemFinanceiroVendaServico;
	private JMenuItem menuItemGerenciamentoContacaoPreco;
	private JMenuItem menuItemGerenciamentoEntradaSaidaVeiculo;
	private JMenuItem menuItemGerenciamentoEstacionamento;
	private JMenuItem menuItemGerenciamentoResiduos;
	private JMenuItem menuItemRhCestaBasica;
	private JMenuItem menuItemRhCurriculoCertificado;
	private JMenuItem menuItemRhCurriculoCurriculo;
	private JMenuItem menuItemRhCurriculoCurso;
	private JMenuItem menuItemRhCurriculoExperienciaProfissional;
	private JMenuItem menuItemRhCurriculoHabilidade;
	private JMenuItem menuItemRhCurriculoIdioma;
	private JMenuItem menuItemRhCurriculoObjetivoProfissional;
	private JMenuItem menuItemRhCurriculoTestePerfilComportamental;
	private JMenuItem menuItemRhCurriculoTestePersonalidadeDisc;
	private JMenuItem menuItemRhCurriculoTestePreferenciaCerebral;
	private JMenuItem menuItemRhFuncionario;
	private JMenuItem menuItemRhTreinamento;
	private JMenuItem menuItemSistemaBackup;
	private JMenuItem menuItemSistemaDados;
	private JMenuItem menuItemSistemaRestaurar;
	private JMenuItem menuItemSistemaUsuario;
	private JMenuItem menuItemUtilitarioAgendaContato;
	private JMenuItem menuItemUtilitarioAgendaEvento;
	private JMenuItem menuItemUtilitarioAgendaRecado;
	private JMenuItem menuItemUtilitarioAgendaTipoEvento;
	private JMenuItem menuItemUtilitarioCalculadora;
	private JMenuItem menuItemUtilitarioCalculoData;
	private JMenuItem menuItemUtilitarioCalculoIMC;
	private JMenuItem menuItemUtilitarioEditorTexto;
	private JMenuItem menuItemUtilitarioMalaDireta;
	private JMenu menuMedicina;
	private JMenu menuRh;
	private JMenu menuRhCurriculo;
	private JMenu menuSegurancaTrabalho;
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

	public JMenuItem getMenuFinanceiroVenda() {
		return menuFinanceiroVenda;
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

	public JMenuItem getMenuItemCadastroImovel() {
		return menuItemCadastroImovel;
	}

	public JMenuItem getMenuItemCadastroProduto() {
		return menuItemCadastroProdutoProduto;
	}

	public JMenuItem getMenuItemCadastroRhCertificado() {
		return menuItemRhCurriculoCertificado;
	}

	public JMenuItem getMenuItemCadastroRhCurriculo() {
		return menuItemRhCurriculoCurriculo;
	}

	public JMenuItem getMenuItemCadastroRhCurso() {
		return menuItemRhCurriculoCurso;
	}

	public JMenuItem getMenuItemCadastroRhExperienciaProfissional() {
		return menuItemRhCurriculoExperienciaProfissional;
	}

	public JMenuItem getMenuItemCadastroRhHabilidade() {
		return menuItemRhCurriculoHabilidade;
	}

	public JMenuItem getMenuItemCadastroRhIdioma() {
		return menuItemRhCurriculoIdioma;
	}

	public JMenuItem getMenuItemCadastroRhObjetivoProfissional() {
		return menuItemRhCurriculoObjetivoProfissional;
	}

	public JMenuItem getMenuItemCadastroRhTestePersonalidadeA() {
		return menuItemRhCurriculoTestePreferenciaCerebral;
	}

	public JMenuItem getMenuItemCadastroRhTestePersonalidadeB() {
		return menuItemRhCurriculoTestePerfilComportamental;
	}

	public JMenuItem getMenuItemCadastroRhTestePersonalidadeC() {
		return menuItemRhCurriculoTestePersonalidadeDisc;
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

	public JMenuItem getMenuItemCadastroVeiculoDocumento() {
		return menuItemCadastroVeiculoDocumento;
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

	public JMenuItem getMenuItemFinanceiroVendaProduto() {
		return menuItemFinanceiroVendaProduto;
	}

	public JMenuItem getMenuItemFinanceiroVendaServico() {
		return menuItemFinanceiroVendaServico;
	}

	public JMenuItem getMenuItemRhFuncionario() {
		return menuItemRhFuncionario;
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
	
	public JMenuItem getMenuItemUtilitarioCalculoImc() {
		return menuItemUtilitarioCalculoIMC;
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
		mainControl = MainControl.getInstance(this);
		Timer timer = new Timer(1000, mainControl.new Relogio());
		timer.setInitialDelay(0);
		timer.setRepeats(true);
		timer.start();
		addWindowListener(mainControl.new FrameGerenteEventos());
		menuItemArquivoLogin.addActionListener(mainControl.new MenuArquivoGerenteEventos());
		menuItemArquivoLogoff.addActionListener(mainControl.new MenuArquivoGerenteEventos());
		menuItemArquivoReiniciar.addActionListener(mainControl.new MenuArquivoGerenteEventos());
		menuItemArquivoSair.addActionListener(mainControl.new MenuArquivoGerenteEventos());
		menuItemCadastroBanco.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemCadastroCentroCusto.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemCadastroCartorio.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemCadastroContador.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemRhFuncionario.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemCadastroCliente.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemRhCurriculoCurriculo.addActionListener(mainControl.new MenuRhGerenteEventos());
		menuItemRhCurriculoCertificado.addActionListener(mainControl.new MenuRhGerenteEventos());
		menuItemRhCurriculoCurso.addActionListener(mainControl.new MenuRhGerenteEventos());
		menuItemRhCurriculoExperienciaProfissional.addActionListener(mainControl.new MenuRhGerenteEventos());
		menuItemRhCurriculoHabilidade.addActionListener(mainControl.new MenuRhGerenteEventos());
		menuItemRhCurriculoIdioma.addActionListener(mainControl.new MenuRhGerenteEventos());
		menuItemRhCurriculoObjetivoProfissional.addActionListener(mainControl.new MenuRhGerenteEventos());
		menuItemRhCurriculoTestePreferenciaCerebral.addActionListener(mainControl.new MenuRhGerenteEventos());
		menuItemRhCurriculoTestePerfilComportamental.addActionListener(mainControl.new MenuRhGerenteEventos());
		menuItemRhCurriculoTestePersonalidadeDisc.addActionListener(mainControl.new MenuRhGerenteEventos());
		menuItemCadastroEmpresa.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemCadastroSindicato.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemCadastroServico.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemCadastroFornecedor.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemCadastroVeiculoVeiculo.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemCadastroVeiculoModelo.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemCadastroVeiculoMarca.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemCadastroVeiculoDocumento.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemCadastroImovel.addActionListener(mainControl.new MenuCadastroGerenteEventos());
		menuItemAjudaSobreSistema.addActionListener(mainControl.new MenuAjudaGerenteEventos());
		menuItemSistemaUsuario.addActionListener(mainControl.new MenuSistemaGerenteEventos());
		menuItemUtilitarioAgendaEvento.addActionListener(mainControl.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioAgendaTipoEvento.addActionListener(mainControl.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioAgendaRecado.addActionListener(mainControl.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioAgendaContato.addActionListener(mainControl.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioCalculadora.addActionListener(mainControl.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioEditorTexto.addActionListener(mainControl.new MenuUtilitarioGerenteEventos());
		menuItemUtilitarioCalculoIMC.addActionListener(mainControl.new MenuUtilitarioGerenteEventos());
	}

	private void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(1200, 660));
		setSize(new Dimension(1200, 660));
		setPreferredSize(new Dimension(1200, 660));

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

		menuItemCadastroFornecedor = new JMenuItem("Fornecedores");
		menuCadastro.add(menuItemCadastroFornecedor);

		menuItemCadastroImovel = new JMenuItem("Imóveis");
		menuCadastro.add(menuItemCadastroImovel);

		menuCadastroOculos = new JMenu("Óculos");
		menuCadastro.add(menuCadastroOculos);

		menuItemCadastroOculosOculos = new JMenuItem("Óculos");
		menuCadastroOculos.add(menuItemCadastroOculosOculos);

		menuCadastroOculos.addSeparator();

		menuItemCadastroOculosLente = new JMenuItem("Lentes");
		menuCadastroOculos.add(menuItemCadastroOculosLente);

		menuItemCadastroOculosTratamento = new JMenuItem("Tratamento");
		menuCadastroOculos.add(menuItemCadastroOculosTratamento);

		menuItemCadastroOculosArmacao = new JMenuItem("Armação");
		menuCadastroOculos.add(menuItemCadastroOculosArmacao);

		menuCadastroProduto = new JMenu("Produtos");

		menuItemCadastroProdutoProduto = new JMenuItem("Produtos");
		menuCadastroProduto.add(menuItemCadastroProdutoProduto);

		menuCadastroProduto.addSeparator();

		menuItemCadastroProdutoCategoria = new JMenuItem("Categorias");
		menuCadastroProduto.add(menuItemCadastroProdutoCategoria);

		menuItemCadastroProdutoMarca = new JMenuItem("Marcas");
		menuCadastroProduto.add(menuItemCadastroProdutoMarca);

		menuItemCadastroProdutoUnidade = new JMenuItem("Unidade");
		menuCadastroProduto.add(menuItemCadastroProdutoUnidade);

		menuCadastroProduto.addSeparator();

		menuItemCadastroProdutoListaCompras = new JMenuItem("Lista de Compras");
		menuCadastroProduto.add(menuItemCadastroProdutoListaCompras);

		menuItemCadastroQuarto = new JMenuItem("Quartos");
		menuCadastro.add(menuItemCadastroQuarto);

		menuItemCadastroServico = new JMenuItem("Serviços");
		menuCadastro.add(menuItemCadastroServico);

		menuItemCadastroSeguradora = new JMenuItem("Seguradora");
		menuCadastro.add(menuItemCadastroSeguradora);

		menuItemCadastroSindicato = new JMenuItem("Sindicatos");
		menuCadastro.add(menuItemCadastroSindicato);

		menuCadastroVeiculo = new JMenu("Veículos");
		menuCadastro.add(menuCadastroVeiculo);

		menuItemCadastroVeiculoVeiculo = new JMenuItem("Veículos");
		menuCadastroVeiculo.add(menuItemCadastroVeiculoVeiculo);
		menuCadastroVeiculo.addSeparator();

		menuItemCadastroVeiculoMarca = new JMenuItem("Marca");
		menuCadastroVeiculo.add(menuItemCadastroVeiculoMarca);

		menuItemCadastroVeiculoModelo = new JMenuItem("Modelos");
		menuCadastroVeiculo.add(menuItemCadastroVeiculoModelo);
		menuCadastroVeiculo.addSeparator();

		menuItemCadastroVeiculoDocumento = new JMenuItem("Documentos");
		menuCadastroVeiculo.add(menuItemCadastroVeiculoDocumento);

		menuBar.add(menuCadastro);

		menuControle = new JMenu("Gerenciamento");
		menuControle.setMnemonic('G');

		menuBar.add(menuControle);

		menuItemGerenciamentoEntradaSaidaVeiculo = new JMenuItem("Entrada e Saída de Veículo");
		menuControle.add(menuItemGerenciamentoEntradaSaidaVeiculo);

		menuItemGerenciamentoEstacionamento = new JMenuItem("Estacionamento");
		menuControle.add(menuItemGerenciamentoEstacionamento);

		menuItemGerenciamentoContacaoPreco = new JMenuItem("Cotação de Preço");
		menuControle.add(menuItemGerenciamentoContacaoPreco);

		menuItemGerenciamentoResiduos = new JMenuItem("Resíduos");
		menuControle.add(menuItemGerenciamentoResiduos);

		menuEscritorio = new JMenu("Escritório");
		menuEscritorio.setMnemonic('E');

		menuBar.add(menuEscritorio);

		menuFinanceiro = new JMenu("Financeiro");
		menuFinanceiro.setMnemonic('F');

		menuItemFinanceiroCaixa = new JMenuItem("Caixa");
		menuFinanceiro.add(menuItemFinanceiroCaixa);
		menuFinanceiro.addSeparator();

		menuItemFinanceiroBoletoBancario = new JMenuItem("Boleto Bancário");
		menuFinanceiro.add(menuItemFinanceiroBoletoBancario);

		menuItemFinanceiroCarne = new JMenuItem("Carnê");
		menuFinanceiro.add(menuItemFinanceiroCarne);

		menuItemFinanceiroCheque = new JMenuItem("Cheque");
		menuFinanceiro.add(menuItemFinanceiroCheque);
		menuFinanceiro.addSeparator();

		menuItemFinanceiroContasPagar = new JMenuItem("Contas a Pagar");
		menuFinanceiro.add(menuItemFinanceiroContasPagar);

		menuItemFinanceiroContasReceber = new JMenuItem("Contas a Receber");
		menuFinanceiro.add(menuItemFinanceiroContasReceber);
		menuFinanceiro.addSeparator();

		menuFinanceiroVenda = new JMenu("Vendas");
		menuFinanceiro.add(menuFinanceiroVenda);

		menuItemFinanceiroVendaProduto = new JMenuItem("Produtos");
		menuFinanceiroVenda.add(menuItemFinanceiroVendaProduto);

		menuItemFinanceiroVendaServico = new JMenuItem("Serviços");
		menuFinanceiroVenda.add(menuItemFinanceiroVendaServico);

		menuBar.add(menuFinanceiro);

		menuContabilidade = new JMenu("Contabilidade");
		menuContabilidade.setMnemonic('o');
		menuBar.add(menuContabilidade);

		menuEconomia = new JMenu("Economia");
		menuEconomia.setMnemonic('c');

		menuBar.add(menuEconomia);

		menuEstatistica = new JMenu("Estatística");
		menuEstatistica.setMnemonic('E');

		menuItemEstatisticaGrafico = new JMenuItem("Gráficos");
		menuEstatistica.add(menuItemEstatisticaGrafico);

		menuItemEstatisticaRelatorio = new JMenuItem("Relatórios");
		menuEstatistica.add(menuItemEstatisticaRelatorio);

		menuBar.add(menuEstatistica);

		menuRh = new JMenu("RH");
		menuRh.setMnemonic('R');

		menuItemRhCestaBasica = new JMenuItem("Cesta Básica");
		menuRh.add(menuItemRhCestaBasica);

		menuRhCurriculo = new JMenu("Currículo");
		menuRh.add(menuRhCurriculo);

		menuItemRhCurriculoCertificado = new JMenuItem("Certificados");
		menuRhCurriculo.add(menuItemRhCurriculoCertificado);

		menuItemRhCurriculoCurso = new JMenuItem("Cursos");
		menuRhCurriculo.add(menuItemRhCurriculoCurso);

		menuItemRhCurriculoExperienciaProfissional = new JMenuItem("Experiência Profissional");
		menuRhCurriculo.add(menuItemRhCurriculoExperienciaProfissional);

		menuItemRhCurriculoHabilidade = new JMenuItem("Habilidades");
		menuRhCurriculo.add(menuItemRhCurriculoHabilidade);

		menuItemRhCurriculoIdioma = new JMenuItem("Idiomas");
		menuRhCurriculo.add(menuItemRhCurriculoIdioma);

		menuItemRhCurriculoObjetivoProfissional = new JMenuItem("Objetivo Profissional");
		menuRhCurriculo.add(menuItemRhCurriculoObjetivoProfissional);

		menuItemRhCurriculoTestePreferenciaCerebral = new JMenuItem("Teste de Preferência Cerebral");
		menuRhCurriculo.add(menuItemRhCurriculoTestePreferenciaCerebral);

		menuItemRhCurriculoTestePerfilComportamental = new JMenuItem("Teste de Perfil Comportamental");
		menuRhCurriculo.add(menuItemRhCurriculoTestePerfilComportamental);

		menuItemRhCurriculoTestePersonalidadeDisc = new JMenuItem("Teste de Personalidade D.I.S.C.");
		menuRhCurriculo.add(menuItemRhCurriculoTestePersonalidadeDisc);

		menuRhCurriculo.addSeparator();

		menuItemRhCurriculoCurriculo = new JMenuItem("Currículo");
		menuRhCurriculo.add(menuItemRhCurriculoCurriculo);

		menuItemRhTreinamento = new JMenuItem("Treinamentos");
		menuRh.add(menuItemRhTreinamento);

		menuItemRhFuncionario = new JMenuItem("Funcionários");
		menuRh.add(menuItemRhFuncionario);

		menuBar.add(menuRh);

		menuSegurancaTrabalho = new JMenu("Segurança no Trabalho");
		menuSegurancaTrabalho.setMnemonic('S');

		menuBar.add(menuSegurancaTrabalho);

		menuMedicina = new JMenu("Medicina");
		menuMedicina.setMnemonic('M');

		menuBar.add(menuMedicina);

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

		menuItemUtilitarioCalculoData = new JMenuItem("Cálculo de Datas");
		menuUtilitario.add(menuItemUtilitarioCalculoData);

		menuItemUtilitarioCalculoIMC = new JMenuItem("Cálculo IMC");
		menuUtilitario.add(menuItemUtilitarioCalculoIMC);

		menuBar.add(menuUtilitario);

		menuSistema = new JMenu("Sistema");
		menuSistema.setMnemonic('S');

		menuItemSistemaDados = new JMenuItem("Dados do Sistema");
		menuSistema.add(menuItemSistemaDados);

		menuItemSistemaBackup = new JMenuItem("Backup do Banco de Dados");
		menuSistema.add(menuItemSistemaBackup);

		menuItemSistemaRestaurar = new JMenuItem("Restaurar Banco de Dados");
		menuSistema.add(menuItemSistemaRestaurar);

		menuItemSistemaUsuario = new JMenuItem("Usuários");
		menuSistema.add(menuItemSistemaUsuario);
		menuBar.add(menuSistema);

		menuAjuda = new JMenu("Ajuda");
		menuAjuda.setMnemonic('u');

		menuItemAjudaAjudaSistema = new JMenuItem("Ajuda do Sistema");
		menuAjuda.add(menuItemAjudaAjudaSistema);

		menuItemAjudaGuiaUsuario = new JMenuItem("Guias do Usuário");
		menuAjuda.add(menuItemAjudaGuiaUsuario);
		menuAjuda.addSeparator();

		menuItemAjudaAjudaOnLine = new JMenuItem("Obter Ajuda On-Line");
		menuAjuda.add(menuItemAjudaAjudaOnLine);

		menuItemAjudaEnviarComentarios = new JMenuItem("Enviar Comentários");
		menuAjuda.add(menuItemAjudaEnviarComentarios);
		menuAjuda.addSeparator();

		menuItemAjudaInformacoesSobreLicenca = new JMenuItem("Informações Sobre a Licença");
		menuAjuda.add(menuItemAjudaInformacoesSobreLicenca);

		menuItemAjudaVerificarAtualizacao = new JMenuItem("Verificar Atualizações");
		menuAjuda.add(menuItemAjudaVerificarAtualizacao);
		menuAjuda.addSeparator();

		menuItemAjudaRelatarProblema = new JMenuItem("Relatar Problema");
		menuAjuda.add(menuItemAjudaRelatarProblema);

		menuItemAjudaDesenvolvedores = new JMenuItem("Desenvolvedores");
		menuAjuda.add(menuItemAjudaDesenvolvedores);
		menuAjuda.addSeparator();

		menuItemAjudaSobreSistema = new JMenuItem("Sobre o Sistema");
		menuAjuda.add(menuItemAjudaSobreSistema);

		menuBar.add(menuAjuda);

		setJMenuBar(menuBar);
	}
}