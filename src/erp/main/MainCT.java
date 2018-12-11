package erp.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import arquitetura.AOP;
import arquitetura.gui.Msg;
import erp.agenda.contato.ContatoFC;
import erp.agenda.contato.ContatoFP;
import erp.agenda.evento.EventoFC;
import erp.agenda.evento.EventoFP;
import erp.agenda.evento.tipoevento.TipoEventoFC;
import erp.agenda.evento.tipoevento.TipoEventoFP;
import erp.agenda.recado.RecadoFC;
import erp.agenda.recado.RecadoFP;
import erp.banco.BancoFC;
import erp.banco.BancoFP;
import erp.calculadora.FrameCalculadora;
import erp.cartorio.CartorioFC;
import erp.cartorio.CartorioFP;
import erp.centrocusto.CentroCustoFC;
import erp.centrocusto.CentroCustoFP;
import erp.cliente.ClienteFC;
import erp.cliente.ClienteFP;
import erp.contador.ContadorFC;
import erp.contador.ContadorFP;
import erp.editor.FrameEditorTexto;
import erp.empresa.EmpresaFC;
import erp.empresa.EmpresaFP;
import erp.fornecedor.FornecedorFC;
import erp.fornecedor.FornecedorFP;
import erp.funcionario.FuncionarioFC;
import erp.funcionario.FuncionarioFP;
import erp.imovel.ImovelFC;
import erp.imovel.ImovelFP;
import erp.login.LoginFC;
import erp.sindicato.SindicatoFC;
import erp.sindicato.SindicatoFP;
import erp.usuario.UsuarioFC;
import erp.usuario.UsuarioFP;
import erp.veiculo.VeiculoFc;
import erp.veiculo.VeiculoFp;
import erp.veiculo.marca.VeiculoMarcaFc;
import erp.veiculo.marca.VeiculoMarcaFp;
import erp.veiculo.modelo.VeiculoModeloFc;
import erp.veiculo.modelo.VeiculoModeloFp;

public final class MainCT {

	public class FrameGerenteEventos extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {

		}

		@Override
		public void windowClosing(WindowEvent e) {
			if (Msg.confirmarSairDoSistema() == JOptionPane.OK_OPTION) {
				System.exit(0);
			}
		}

		@Override
		public void windowOpened(WindowEvent e) {

		}
	}

	public class MenuAjudaGerenteEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class MenuArquivoGerenteEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getSource() == mainFC.getMenuItemArquivoSair()) {
				if (Msg.confirmarSairDoSistema() == 0) {
					System.exit(0);
				}
			} else if (actionEvent.getSource() == mainFC.getMenuItemArquivoLogin()) {
				mostrarFrame(loginFC);
			} else if (actionEvent.getSource() == mainFC.getMenuItemArquivoLogoff()) {
				AOP.setUsuario(null);
				Msg.avisoUsuarioNaoLogado();
			} else if (actionEvent.getSource() == mainFC.getMenuItemArquivoReiniciar()) {
				@SuppressWarnings("rawtypes")
				Class cls = ERP.class;
				ProtectionDomain pDomain = cls.getProtectionDomain();
				CodeSource cSource = pDomain.getCodeSource();
				URL loc = cSource.getLocation();

				String comando = "java -jar " + loc.toString().substring(5);

				try {
					@SuppressWarnings("unused")
					Process processo = Runtime.getRuntime().exec(comando);
				} catch (IOException MensagemdeErro) {
					System.out.println(MensagemdeErro);
				}
				System.exit(0);
			}
		}
	}

	public class MenuCadastroGerenteEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (AOP.getUsuario() == null) {
				Msg.avisoUsuarioNaoLogado();
				return;
			}
			if (actionEvent.getSource() == mainFC.getMenuItemCadastroCentroCusto()) {
				mostrarFrame(centroCustoFC);
			} else if (actionEvent.getSource() == mainFC.getMenuItemCadastroBanco()) {
				mostrarFrame(bancoFC);
			} else if (actionEvent.getSource() == mainFC.getMenuItemCadastroCartorio()) {
				mostrarFrame(cartorioFC);
			} else if (actionEvent.getSource() == mainFC.getMenuItemCadastroFuncionario()) {
				mostrarFrame(funcionarioFC);
			} else if (actionEvent.getSource() == mainFC.getMenuItemCadastroContador()) {
				mostrarFrame(contadorFC);
			} else if (actionEvent.getSource() == mainFC.getMenuItemCadastroCliente()) {
				mostrarFrame(clienteFC);
			} else if (actionEvent.getSource() == mainFC.getMenuItemCadastroEmpresa()) {
				mostrarFrame(empresaFC);
			} else if (actionEvent.getSource() == mainFC.getMenuItemCadastroSindicato()) {
				mostrarFrame(sindicatoFC);
			} else if (actionEvent.getSource() == mainFC.getMenuItemCadastroFornecedor()) {
				mostrarFrame(fornecedorFC);
			} else if (actionEvent.getSource() == mainFC.getMenuItemCadastroVeiculoVeiculo()) {
				mostrarFrame(veiculoFc);
			} else if (actionEvent.getSource() == mainFC.getMenuItemCadastroVeiculoModelo()) {
				mostrarFrame(veiculoModeloFc);
			} else if (actionEvent.getSource() == mainFC.getMenuItemCadastroVeiculoMarca()) {
				mostrarFrame(veiculoMarcaFc);
			} else if (actionEvent.getSource() == mainFC.getMenuItemCadastroImovel()) {
				mostrarFrame(imovelFC);
			}
		}
	}

	public class MenuCadastroBancoGerenteEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (AOP.getUsuario() == null) {
				Msg.avisoUsuarioNaoLogado();
				return;
			}

		}
	}

	public class MenuSistemaGerenteEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (AOP.getUsuario() == null) {
				Msg.avisoUsuarioNaoLogado();
				return;
			}
			if (actionEvent.getSource() == mainFC.getMenuItemSistemaUsuario()) {
				mostrarFrame(usuarioFC);
			}
		}
	}

	public class MenuUtilitarioGerenteEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (AOP.getUsuario() == null) {
				Msg.avisoUsuarioNaoLogado();
				return;
			}
			if (actionEvent.getSource() == mainFC.getMenuItemUtilitarioAgendaEvento()) {
				mostrarFrame(frameCadastroAgendaEvento);
			}
			if (actionEvent.getSource() == mainFC.getMenuItemUtilitarioAgendaTipoEvento()) {
				mostrarFrame(frameCadastroAgendaTipoEvento);
			}
			if (actionEvent.getSource() == mainFC.getMenuItemUtilitarioAgendaRecado()) {
				mostrarFrame(frameCadastroAgendaRecado);
			}
			if (actionEvent.getSource() == mainFC.getMenuItemUtilitarioAgendaContato()) {
				mostrarFrame(frameCadastroAgendaContato);
			}
			if (actionEvent.getSource() == mainFC.getMenuItemUtilitarioCalculadora()) {
				mostrarFrame(frameCalculadora);
			}
			if (actionEvent.getSource() == mainFC.getMenuItemUtilitarioEditorTexto()) {
				mostrarFrame(frameEditorTexto);
			}
		}
	}

	private static LoginFC loginFC;
	private static BancoFC bancoFC;
	private static BancoFP bancoFP;
	private static CentroCustoFC centroCustoFC;
	private static CentroCustoFP centroCustoFP;
	private static EventoFC frameCadastroAgendaEvento;
	private static EventoFP framePesquisaAgendaEvento;
	private static TipoEventoFC frameCadastroAgendaTipoEvento;
	private static TipoEventoFP framePesquisaAgendaTipoEvento;
	private static ContatoFC frameCadastroAgendaContato;
	private static ContatoFP framePesquisaAgendaContato;
	private static RecadoFC frameCadastroAgendaRecado;
	private static RecadoFP framePesquisaAgendaRecado;
	private static CartorioFC cartorioFC;
	private static CartorioFP cartorioFP;
	private static ContadorFC contadorFC;
	private static ContadorFP contadorFP;
	private static FuncionarioFC funcionarioFC;
	private static FuncionarioFP funcionarioFP;
	private static UsuarioFC usuarioFC;
	private static UsuarioFP usuarioFP;
	private static ClienteFC clienteFC;
	private static ClienteFP clienteFP;
	private static EmpresaFC empresaFC;
	private static EmpresaFP empresaFP;
	private static SindicatoFC sindicatoFC;
	private static SindicatoFP sindicatoFP;
	private static FornecedorFC fornecedorFC;
	private static FornecedorFP fornecedorFP;
	private static VeiculoFc veiculoFc;
	private static VeiculoFp veiculoFp;
	private static VeiculoMarcaFc veiculoMarcaFc;
	private static VeiculoMarcaFp veiculoMarcaFp;
	private static VeiculoModeloFc veiculoModeloFc;
	private static VeiculoModeloFp veiculoModeloFp;
	private static ImovelFC imovelFC;
	private static ImovelFP imovelFP;
	private static FrameCalculadora frameCalculadora;
	private static FrameEditorTexto frameEditorTexto;
	private static MainCT mainCT;
	private static MainFC mainFC;
	private static int totalPrincipalHandle;

	static {
		totalPrincipalHandle = 0;
	}

	public static FrameEditorTexto getFrameEditorTexto() {
		return frameEditorTexto;
	}

	public static FrameCalculadora getFrameCalculadora() {
		return frameCalculadora;
	}

	public static EventoFC getAgendaEventoFC() {
		return frameCadastroAgendaEvento;
	}

	public static BancoFC getBancoFC() {
		return bancoFC;
	}

	public static CartorioFC getCartorioFC() {
		return cartorioFC;
	}

	public static CentroCustoFC getCentroCustoFC() {
		return centroCustoFC;
	}

	public static ClienteFC getClienteFC() {
		return clienteFC;
	}

	public static TipoEventoFC getAgendaTipoEventoPC() {
		return frameCadastroAgendaTipoEvento;
	}

	public static ContatoFC getAgendaContatoFC() {
		return frameCadastroAgendaContato;
	}

	public static ContadorFC getFrameCadastroContador() {
		return contadorFC;
	}

	public static EmpresaFC getEmpresaFC() {
		return empresaFC;
	}

	public static FornecedorFC getFornecedorFC() {
		return fornecedorFC;
	}

	public static FuncionarioFC getFuncionarioFC() {
		return funcionarioFC;
	}

	public static ImovelFC getImovelFC() {
		return imovelFC;
	}

	public static RecadoFC getRecadoFC() {
		return frameCadastroAgendaRecado;
	}

	public static SindicatoFC getSindicatoFC() {
		return sindicatoFC;
	}

	public static UsuarioFC getFrameCadastroUsuario() {
		return usuarioFC;
	}

	public static VeiculoFc getFrameCadastroVeiculo() {
		return veiculoFc;
	}

	public static VeiculoMarcaFc getFrameCadastroVeiculoMarca() {
		return veiculoMarcaFc;
	}

	public static VeiculoModeloFc getFrameCadastroVeiculoModelo() {
		return veiculoModeloFc;
	}

	public static LoginFC getFrameLogin() {
		return loginFC;
	}

	public static MainFC getFrameMain() {
		return mainFC;
	}

	public static TipoEventoFP getAgendaTipoEventoPP() {
		return framePesquisaAgendaTipoEvento;
	}

	public static EventoFP getAgendaEventoFP() {
		return framePesquisaAgendaEvento;
	}

	public static ContatoFP getAgendaContatoFP() {
		return framePesquisaAgendaContato;
	}

	public static BancoFP getBancoFP() {
		return bancoFP;
	}

	public static CartorioFP getCartorioFP() {
		return cartorioFP;
	}

	public static CentroCustoFP getCentroCustoFP() {
		return centroCustoFP;
	}

	public static ClienteFP getClienteFP() {
		return clienteFP;
	}

	public static ContadorFP getFramePesquisaContador() {
		return contadorFP;
	}

	public static EmpresaFP getEmpresaFP() {
		return empresaFP;
	}

	public static FornecedorFP getFornecedorFP() {
		return fornecedorFP;
	}

	public static FuncionarioFP getFuncionarioFP() {
		return funcionarioFP;
	}

	public static ImovelFP getImovelFP() {
		return imovelFP;
	}

	public static RecadoFP getRecadoFP() {
		return framePesquisaAgendaRecado;
	}

	public static SindicatoFP getSindicatoFP() {
		return sindicatoFP;
	}

	public static UsuarioFP getFramePesquisaUsuario() {
		return usuarioFP;
	}

	public static VeiculoFp getFramePesquisaVeiculo() {
		return veiculoFp;
	}

	public static VeiculoMarcaFp getFramePesquisaVeiculoMarca() {
		return veiculoMarcaFp;
	}

	public static VeiculoModeloFp getFramePesquisaVeiculoModelo() {
		return veiculoModeloFp;
	}

	public static synchronized MainCT getInstance(MainFC mainFC) {
		if (totalPrincipalHandle > 1) {
			JOptionPane.showMessageDialog(null, "Foi instanciado mais de uma Objeto:" + ERP.class);
		}
		if (mainCT == null) {
			++totalPrincipalHandle;
			return new MainCT(mainFC);
		}
		return mainCT;
	}

	public static void mostrarFrame(JFrame frame) {
		frame.setVisible(true);
		frame.setResizable(false);
		frame.toFront();
		frame.repaint();
		frame.setState(java.awt.Frame.NORMAL);
		frame.setLocationRelativeTo(null);
	}

	private MainCT(MainFC mainFC) {
		MainCT.mainFC = mainFC;
		criarFrames();
	}

	private void criarFrame(JFrame frame) {
		frame.pack();
		frame.setVisible(false);
	}

	private void criarFrames() {
		loginFC = new LoginFC();
		criarFrame(loginFC);
		loginFC.iniciarControlador();

		bancoFC = new BancoFC();
		criarFrame(bancoFC);

		bancoFP = new BancoFP();
		criarFrame(bancoFP);

		centroCustoFC = new CentroCustoFC();
		criarFrame(centroCustoFC);
		centroCustoFC.iniciarControlador();

		centroCustoFP = new CentroCustoFP();
		criarFrame(centroCustoFP);

		clienteFC = new ClienteFC();
		criarFrame(clienteFC);
		clienteFC.iniciarControlador();

		clienteFP = new ClienteFP();
		criarFrame(clienteFP);

		empresaFC = new EmpresaFC();
		criarFrame(empresaFC);

		empresaFP = new EmpresaFP();
		criarFrame(empresaFP);

		usuarioFC = new UsuarioFC();
		criarFrame(usuarioFC);

		usuarioFP = new UsuarioFP();
		criarFrame(usuarioFP);

		cartorioFC = new CartorioFC();
		criarFrame(cartorioFC);

		cartorioFP = new CartorioFP();
		criarFrame(cartorioFP);

		contadorFC = new ContadorFC();
		criarFrame(contadorFC);

		contadorFP = new ContadorFP();
		criarFrame(contadorFP);

		funcionarioFC = new FuncionarioFC();
		criarFrame(funcionarioFC);

		funcionarioFP = new FuncionarioFP();
		criarFrame(funcionarioFP);

		sindicatoFC = new SindicatoFC();
		criarFrame(sindicatoFC);

		sindicatoFP = new SindicatoFP();
		criarFrame(sindicatoFP);

		fornecedorFC = new FornecedorFC();
		criarFrame(fornecedorFC);

		fornecedorFP = new FornecedorFP();
		criarFrame(fornecedorFP);

		veiculoFc = new VeiculoFc();
		criarFrame(veiculoFc);

		veiculoFp = new VeiculoFp();
		criarFrame(veiculoFp);

		imovelFC = new ImovelFC();
		criarFrame(imovelFC);

		imovelFP = new ImovelFP();
		criarFrame(imovelFP);

		frameCadastroAgendaContato = new ContatoFC();
		criarFrame(frameCadastroAgendaContato);

		framePesquisaAgendaContato = new ContatoFP();
		criarFrame(framePesquisaAgendaContato);

		frameCadastroAgendaEvento = new EventoFC();
		criarFrame(frameCadastroAgendaEvento);

		framePesquisaAgendaEvento = new EventoFP();
		criarFrame(framePesquisaAgendaEvento);

		frameCadastroAgendaTipoEvento = new TipoEventoFC();
		criarFrame(frameCadastroAgendaTipoEvento);

		framePesquisaAgendaTipoEvento = new TipoEventoFP();
		criarFrame(framePesquisaAgendaTipoEvento);

		frameCadastroAgendaRecado = new RecadoFC();
		criarFrame(frameCadastroAgendaRecado);

		framePesquisaAgendaRecado = new RecadoFP();
		criarFrame(framePesquisaAgendaRecado);

		veiculoMarcaFc = new VeiculoMarcaFc();
		criarFrame(veiculoMarcaFc);

		veiculoMarcaFp = new VeiculoMarcaFp();
		criarFrame(veiculoMarcaFp);

		veiculoModeloFc = new VeiculoModeloFc();
		criarFrame(veiculoModeloFc);

		veiculoModeloFp = new VeiculoModeloFp();
		criarFrame(veiculoModeloFp);

		frameCalculadora = new FrameCalculadora();
		criarFrame(frameCalculadora);

		frameEditorTexto = new FrameEditorTexto();
		criarFrame(frameEditorTexto);
	}
}
