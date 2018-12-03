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
import erp.agenda.contato.FCContato;
import erp.agenda.contato.FPContato;
import erp.agenda.evento.FCEvento;
import erp.agenda.evento.FPEvento;
import erp.agenda.evento.tipoevento.FCTipoEvento;
import erp.agenda.evento.tipoevento.FPTipoEvento;
import erp.agenda.recado.FCRecado;
import erp.agenda.recado.FPRecado;
import erp.banco.FCBanco;
import erp.banco.FPBanco;
import erp.calculadora.FrameCalculadora;
import erp.cartorio.FCCartorio;
import erp.cartorio.FPCartorio;
import erp.centrocusto.FCCentroCusto;
import erp.centrocusto.FPCentroCusto;
import erp.cliente.FCCliente;
import erp.cliente.FPCliente;
import erp.contador.FCContador;
import erp.contador.FPContador;
import erp.editor.FrameEditorTexto;
import erp.empresa.FCEmpresa;
import erp.empresa.FPEmpresa;
import erp.fornecedor.FCFornecedor;
import erp.fornecedor.FPFornecedor;
import erp.funcionario.FCFuncionario;
import erp.funcionario.FPFuncionario;
import erp.imovel.FCImovel;
import erp.imovel.FPImovel;
import erp.login.FLogin;
import erp.sindicato.FCSindicato;
import erp.sindicato.FPSindicato;
import erp.usuario.FCUsuario;
import erp.usuario.FPUsuario;
import erp.veiculo.FCVeiculo;
import erp.veiculo.FPVeiculo;
import erp.veiculomarca.FCVeiculoMarca;
import erp.veiculomarca.FPVeiculoMarca;
import erp.veiculomodelo.FCVeiculoModelo;
import erp.veiculomodelo.FPVeiculoModelo;

public final class MainControlador {

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
			if (actionEvent.getSource() == frameMain.getMenuItemArquivoSair()) {
				if (Msg.confirmarSairDoSistema() == 0) {
					System.exit(0);
				}
			} else if (actionEvent.getSource() == frameMain.getMenuItemArquivoLogin()) {
				mostrarFrame(fLogin);
			} else if (actionEvent.getSource() == frameMain.getMenuItemArquivoLogoff()) {
				AOP.setUsuario(null);
				Msg.avisoUsuarioNaoLogado();
			} else if (actionEvent.getSource() == frameMain.getMenuItemArquivoReiniciar()) {
				@SuppressWarnings("rawtypes")
				Class cls = Main.class;
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
			if (actionEvent.getSource() == frameMain.getMenuItemCadastroCentroCusto()) {
				mostrarFrame(fCCentroCusto);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroBanco()) {
				mostrarFrame(fCBanco);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroCartorio()) {
				mostrarFrame(fCCartorio);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroFuncionario()) {
				mostrarFrame(fCFuncionario);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroContador()) {
				mostrarFrame(fCContador);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroCliente()) {
				mostrarFrame(fCCliente);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroEmpresa()) {
				mostrarFrame(fCEmpresa);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroSindicato()) {
				mostrarFrame(fCSindicato);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroFornecedor()) {
				mostrarFrame(fCFornecedor);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroVeiculoVeiculo()) {
				mostrarFrame(fCVeiculo);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroVeiculoModelo()) {
				mostrarFrame(fCVeiculoModelo);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroVeiculoMarca()) {
				mostrarFrame(fCVeiculoMarca);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroImovel()) {
				mostrarFrame(fCImovel);
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
			if (actionEvent.getSource() == frameMain.getMenuItemSistemaUsuario()) {
				mostrarFrame(fCUsuario);
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
			if (actionEvent.getSource() == frameMain.getMenuItemUtilitarioAgendaEvento()) {
				mostrarFrame(frameCadastroAgendaEvento);
			}
			if (actionEvent.getSource() == frameMain.getMenuItemUtilitarioAgendaTipoEvento()) {
				mostrarFrame(frameCadastroAgendaTipoEvento);
			}
			if (actionEvent.getSource() == frameMain.getMenuItemUtilitarioAgendaRecado()) {
				mostrarFrame(frameCadastroAgendaRecado);
			}
			if (actionEvent.getSource() == frameMain.getMenuItemUtilitarioAgendaContato()) {
				mostrarFrame(frameCadastroAgendaContato);
			}
			if (actionEvent.getSource() == frameMain.getMenuItemUtilitarioCalculadora()) {
				mostrarFrame(frameCalculadora);
			}
			if (actionEvent.getSource() == frameMain.getMenuItemUtilitarioEditorTexto()) {
				mostrarFrame(frameEditorTexto);
			}
		}
	}

	private static FLogin fLogin;
	private static FCBanco fCBanco;
	private static FPBanco fPBanco;
	private static FCCentroCusto fCCentroCusto;
	private static FPCentroCusto fPCentroCusto;
	private static FCEvento frameCadastroAgendaEvento;
	private static FPEvento framePesquisaAgendaEvento;
	private static FCTipoEvento frameCadastroAgendaTipoEvento;
	private static FPTipoEvento framePesquisaAgendaTipoEvento;
	private static FCContato frameCadastroAgendaContato;
	private static FPContato framePesquisaAgendaContato;
	private static FCRecado frameCadastroAgendaRecado;
	private static FPRecado framePesquisaAgendaRecado;
	private static FCCartorio fCCartorio;
	private static FPCartorio fPCartorio;
	private static FCContador fCContador;
	private static FPContador fPContador;
	private static FCFuncionario fCFuncionario;
	private static FPFuncionario fPFuncionario;
	private static FCUsuario fCUsuario;
	private static FPUsuario fPUsuario;
	private static FCCliente fCCliente;
	private static FPCliente fPCliente;
	private static FCEmpresa fCEmpresa;
	private static FPEmpresa fPEmpresa;
	private static FCSindicato fCSindicato;
	private static FPSindicato fPSindicato;
	private static FCFornecedor fCFornecedor;
	private static FPFornecedor fPFornecedor;
	private static FCVeiculo fCVeiculo;
	private static FPVeiculo fPVeiculo;
	private static FCVeiculoMarca fCVeiculoMarca;
	private static FPVeiculoMarca fPVeiculoMarca;
	private static FCVeiculoModelo fCVeiculoModelo;
	private static FPVeiculoModelo fPVeiculoModelo;
	private static FCImovel fCImovel;
	private static FPImovel fPImovel;
	private static FrameCalculadora frameCalculadora;
	private static FrameEditorTexto frameEditorTexto;
	private static MainControlador mainControlador;
	private static FrameMain frameMain;
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

	public static FCEvento getFrameCadastroAgendaEvento() {
		return frameCadastroAgendaEvento;
	}

	public static FCBanco getFrameCadastroBanco() {
		return fCBanco;
	}

	public static FCCartorio getFrameCadastroCartorio() {
		return fCCartorio;
	}

	public static FCCentroCusto getFrameCadastroCentroCusto() {
		return fCCentroCusto;
	}

	public static FCCliente getFrameCadastroCliente() {
		return fCCliente;
	}

	public static FCTipoEvento getFrameCadastroAgendaTipoEvento() {
		return frameCadastroAgendaTipoEvento;
	}

	public static FCContato getFrameCadastroAgendaContato() {
		return frameCadastroAgendaContato;
	}

	public static FCContador getFrameCadastroContador() {
		return fCContador;
	}

	public static FCEmpresa getFrameCadastroEmpresa() {
		return fCEmpresa;
	}

	public static FCFornecedor getFrameCadastroFornecedor() {
		return fCFornecedor;
	}

	public static FCFuncionario getFrameCadastroFuncionario() {
		return fCFuncionario;
	}

	public static FCImovel getFrameCadastroImovel() {
		return fCImovel;
	}

	public static FCRecado getFrameCadastroRecado() {
		return frameCadastroAgendaRecado;
	}

	public static FCSindicato getFrameCadastroSindicato() {
		return fCSindicato;
	}

	public static FCUsuario getFrameCadastroUsuario() {
		return fCUsuario;
	}

	public static FCVeiculo getFrameCadastroVeiculo() {
		return fCVeiculo;
	}

	public static FCVeiculoMarca getFrameCadastroVeiculoMarca() {
		return fCVeiculoMarca;
	}

	public static FCVeiculoModelo getFrameCadastroVeiculoModelo() {
		return fCVeiculoModelo;
	}

	public static FLogin getFrameLogin() {
		return fLogin;
	}

	public static FrameMain getFrameMain() {
		return frameMain;
	}

	public static FPTipoEvento getFramePesquisaAgendaTipoEvento() {
		return framePesquisaAgendaTipoEvento;
	}

	public static FPEvento getFramePesquisaAgendaEvento() {
		return framePesquisaAgendaEvento;
	}

	public static FPContato getFramePesquisaAgendaContato() {
		return framePesquisaAgendaContato;
	}

	public static FPBanco getFramePesquisaBanco() {
		return fPBanco;
	}

	public static FPCartorio getFramePesquisaCartorio() {
		return fPCartorio;
	}

	public static FPCentroCusto getFramePesquisaCentroCusto() {
		return fPCentroCusto;
	}

	public static FPCliente getFramePesquisaCliente() {
		return fPCliente;
	}

	public static FPContador getFramePesquisaContador() {
		return fPContador;
	}

	public static FPEmpresa getFramePesquisaEmpresa() {
		return fPEmpresa;
	}

	public static FPFornecedor getFramePesquisaFornecedor() {
		return fPFornecedor;
	}

	public static FPFuncionario getFramePesquisaFuncionario() {
		return fPFuncionario;
	}

	public static FPImovel getFramePesquisaImovel() {
		return fPImovel;
	}

	public static FPRecado getFramePesquisaRecado() {
		return framePesquisaAgendaRecado;
	}

	public static FPSindicato getFramePesquisaSindicato() {
		return fPSindicato;
	}

	public static FPUsuario getFramePesquisaUsuario() {
		return fPUsuario;
	}

	public static FPVeiculo getFramePesquisaVeiculo() {
		return fPVeiculo;
	}

	public static FPVeiculoMarca getFramePesquisaVeiculoMarca() {
		return fPVeiculoMarca;
	}

	public static FPVeiculoModelo getFramePesquisaVeiculoModelo() {
		return fPVeiculoModelo;
	}

	public static synchronized MainControlador getInstance(FrameMain frameMain) {
		if (totalPrincipalHandle > 1) {
			JOptionPane.showMessageDialog(null, "Foi instanciado mais de uma Objeto:" + Main.class);
		}
		if (mainControlador == null) {
			++totalPrincipalHandle;
			return new MainControlador(frameMain);
		}
		return mainControlador;
	}

	public static void mostrarFrame(JFrame frame) {
		frame.setVisible(true);
		frame.setResizable(false);
		frame.toFront();
		frame.repaint();
		frame.setState(java.awt.Frame.NORMAL);
		frame.setLocationRelativeTo(null);
	}

	private MainControlador(FrameMain frameMain) {
		MainControlador.frameMain = frameMain;
		criarFrames();
	}

	private void criarFrame(JFrame frame) {
		frame.pack();
		frame.setVisible(false);
	}

	private void criarFrames() {
		fLogin = new FLogin();
		criarFrame(fLogin);
		fLogin.iniciarGerenteEventos();

		fCBanco = new FCBanco();
		criarFrame(fCBanco);

		fPBanco = new FPBanco();
		criarFrame(fPBanco);

		fCCentroCusto = new FCCentroCusto();
		criarFrame(fCCentroCusto);
		fCCentroCusto.iniciarGerenteEventos();

		fPCentroCusto = new FPCentroCusto();
		criarFrame(fPCentroCusto);

		fCCliente = new FCCliente();
		criarFrame(fCCliente);
		fCCliente.iniciarGerenteEventos();

		fPCliente = new FPCliente();
		criarFrame(fPCliente);

		fCEmpresa = new FCEmpresa();
		criarFrame(fCEmpresa);

		fPEmpresa = new FPEmpresa();
		criarFrame(fPEmpresa);

		fCUsuario = new FCUsuario();
		criarFrame(fCUsuario);

		fPUsuario = new FPUsuario();
		criarFrame(fPUsuario);

		fCCartorio = new FCCartorio();
		criarFrame(fCCartorio);

		fPCartorio = new FPCartorio();
		criarFrame(fPCartorio);

		fCContador = new FCContador();
		criarFrame(fCContador);

		fPContador = new FPContador();
		criarFrame(fPContador);

		fCFuncionario = new FCFuncionario();
		criarFrame(fCFuncionario);

		fPFuncionario = new FPFuncionario();
		criarFrame(fPFuncionario);

		fCSindicato = new FCSindicato();
		criarFrame(fCSindicato);

		fPSindicato = new FPSindicato();
		criarFrame(fPSindicato);

		fCFornecedor = new FCFornecedor();
		criarFrame(fCFornecedor);

		fPFornecedor = new FPFornecedor();
		criarFrame(fPFornecedor);

		fCVeiculo = new FCVeiculo();
		criarFrame(fCVeiculo);

		fPVeiculo = new FPVeiculo();
		criarFrame(fPVeiculo);

		fCImovel = new FCImovel();
		criarFrame(fCImovel);

		fPImovel = new FPImovel();
		criarFrame(fPImovel);

		frameCadastroAgendaContato = new FCContato();
		criarFrame(frameCadastroAgendaContato);

		framePesquisaAgendaContato = new FPContato();
		criarFrame(framePesquisaAgendaContato);

		frameCadastroAgendaEvento = new FCEvento();
		criarFrame(frameCadastroAgendaEvento);

		framePesquisaAgendaEvento = new FPEvento();
		criarFrame(framePesquisaAgendaEvento);

		frameCadastroAgendaTipoEvento = new FCTipoEvento();
		criarFrame(frameCadastroAgendaTipoEvento);

		framePesquisaAgendaTipoEvento = new FPTipoEvento();
		criarFrame(framePesquisaAgendaTipoEvento);

		frameCadastroAgendaRecado = new FCRecado();
		criarFrame(frameCadastroAgendaRecado);

		framePesquisaAgendaRecado = new FPRecado();
		criarFrame(framePesquisaAgendaRecado);

		fCVeiculoMarca = new FCVeiculoMarca();
		criarFrame(fCVeiculoMarca);

		fPVeiculoMarca = new FPVeiculoMarca();
		criarFrame(fPVeiculoMarca);

		fCVeiculoModelo = new FCVeiculoModelo();
		criarFrame(fCVeiculoModelo);

		fPVeiculoModelo = new FPVeiculoModelo();
		criarFrame(fPVeiculoModelo);

		frameCalculadora = new FrameCalculadora();
		criarFrame(frameCalculadora);

		frameEditorTexto = new FrameEditorTexto();
		criarFrame(frameEditorTexto);
	}
}
