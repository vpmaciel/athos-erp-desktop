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
import erp.agenda.contato.FrameCadastroContato;
import erp.agenda.contato.FramePesquisaContato;
import erp.agenda.evento.FrameCadastroEvento;
import erp.agenda.evento.FramePesquisaEvento;
import erp.agenda.evento.tipoevento.FrameCadastroTipoEvento;
import erp.agenda.evento.tipoevento.FramePesquisaTipoEvento;
import erp.agenda.recado.FrameCadastroRecado;
import erp.agenda.recado.FramePesquisaRecado;
import erp.banco.FrameCadastroBanco;
import erp.banco.FramePesquisaBanco;
import erp.cartorio.FrameCadastroCartorio;
import erp.cartorio.FramePesquisaCartorio;
import erp.centrocusto.FrameCadastroCentroCusto;
import erp.centrocusto.FramePesquisaCentroCusto;
import erp.cliente.FrameCadastroCliente;
import erp.cliente.FramePesquisaCliente;
import erp.contador.FrameCadastroContador;
import erp.contador.FramePesquisaContador;
import erp.empresa.FrameCadastroEmpresa;
import erp.empresa.FramePesquisaEmpresa;
import erp.fornecedor.FrameCadastroFornecedor;
import erp.fornecedor.FramePesquisaFornecedor;
import erp.funcionario.FrameCadastroFuncionario;
import erp.funcionario.FramePesquisaFuncionario;
import erp.imovel.FrameCadastroImovel;
import erp.imovel.FramePesquisaImovel;
import erp.login.FrameLogin;
import erp.sindicato.FrameCadastroSindicato;
import erp.sindicato.FramePesquisaSindicato;
import erp.usuario.FrameCadastroUsuario;
import erp.usuario.FramePesquisaUsuario;
import erp.utilitario.calculadora.FrameCalculadora;
import erp.utilitario.editortexto.FrameEditorTexto;
import erp.veiculo.marca.FrameCadastroVeiculoMarca;
import erp.veiculo.marca.FramePesquisaVeiculoMarca;
import erp.veiculo.modelo.FrameCadastroVeiculoModelo;
import erp.veiculo.modelo.FramePesquisaVeiculoModelo;
import erp.veiculo.veiculo.FrameCadastroVeiculo;
import erp.veiculo.veiculo.FramePesquisaVeiculo;

public final class MainGerenteEventos {

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
				mostrarFrame(frameLogin);
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
				mostrarFrame(frameCadastroCentroCusto);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroBanco()) {
				mostrarFrame(frameCadastroBanco);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroCartorio()) {
				mostrarFrame(frameCadastroCartorio);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroFuncionario()) {
				mostrarFrame(frameCadastroFuncionario);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroContador()) {
				mostrarFrame(frameCadastroContador);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroCliente()) {
				mostrarFrame(frameCadastroCliente);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroEmpresa()) {
				mostrarFrame(frameCadastroEmpresa);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroSindicato()) {
				mostrarFrame(frameCadastroSindicato);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroFornecedor()) {
				mostrarFrame(frameCadastroFornecedor);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroVeiculoVeiculo()) {
				mostrarFrame(frameCadastroVeiculo);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroVeiculoModelo()) {
				mostrarFrame(frameCadastroVeiculoModelo);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroVeiculoMarca()) {
				mostrarFrame(frameCadastroVeiculoMarca);
			} else if (actionEvent.getSource() == frameMain.getMenuItemCadastroImovel()) {
				mostrarFrame(frameCadastroImovel);
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
				mostrarFrame(frameCadastroUsuario);
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

	private static FrameLogin frameLogin;
	private static FrameCadastroBanco frameCadastroBanco;
	private static FramePesquisaBanco framePesquisaBanco;
	private static FrameCadastroCentroCusto frameCadastroCentroCusto;
	private static FramePesquisaCentroCusto framePesquisaCentroCusto;
	private static FrameCadastroEvento frameCadastroAgendaEvento;
	private static FramePesquisaEvento framePesquisaAgendaEvento;
	private static FrameCadastroTipoEvento frameCadastroAgendaTipoEvento;
	private static FramePesquisaTipoEvento framePesquisaAgendaTipoEvento;
	private static FrameCadastroContato frameCadastroAgendaContato;
	private static FramePesquisaContato framePesquisaAgendaContato;
	private static FrameCadastroRecado frameCadastroAgendaRecado;
	private static FramePesquisaRecado framePesquisaAgendaRecado;
	private static FrameCadastroCartorio frameCadastroCartorio;
	private static FramePesquisaCartorio framePesquisaCartorio;
	private static FrameCadastroContador frameCadastroContador;
	private static FramePesquisaContador framePesquisaContador;
	private static FrameCadastroFuncionario frameCadastroFuncionario;
	private static FramePesquisaFuncionario framePesquisaFuncionario;
	private static FrameCadastroUsuario frameCadastroUsuario;
	private static FramePesquisaUsuario framePesquisaUsuario;
	private static FrameCadastroCliente frameCadastroCliente;
	private static FramePesquisaCliente framePesquisaCliente;
	private static FrameCadastroEmpresa frameCadastroEmpresa;
	private static FramePesquisaEmpresa framePesquisaEmpresa;
	private static FrameCadastroSindicato frameCadastroSindicato;
	private static FramePesquisaSindicato framePesquisaSindicato;
	private static FrameCadastroFornecedor frameCadastroFornecedor;
	private static FramePesquisaFornecedor framePesquisaFornecedor;
	private static FrameCadastroVeiculo frameCadastroVeiculo;
	private static FramePesquisaVeiculo framePesquisaVeiculo;
	private static FrameCadastroVeiculoMarca frameCadastroVeiculoMarca;
	private static FramePesquisaVeiculoMarca framePesquisaVeiculoMarca;
	private static FrameCadastroVeiculoModelo frameCadastroVeiculoModelo;
	private static FramePesquisaVeiculoModelo framePesquisaVeiculoModelo;
	private static FrameCadastroImovel frameCadastroImovel;
	private static FramePesquisaImovel framePesquisaImovel;
	private static FrameCalculadora frameCalculadora;
	private static FrameEditorTexto frameEditorTexto;
	private static MainGerenteEventos mainGerenteEventos;
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

	public static FrameCadastroEvento getFrameCadastroAgendaEvento() {
		return frameCadastroAgendaEvento;
	}

	public static FrameCadastroBanco getFrameCadastroBanco() {
		return frameCadastroBanco;
	}

	public static FrameCadastroCartorio getFrameCadastroCartorio() {
		return frameCadastroCartorio;
	}

	public static FrameCadastroCentroCusto getFrameCadastroCentroCusto() {
		return frameCadastroCentroCusto;
	}

	public static FrameCadastroCliente getFrameCadastroCliente() {
		return frameCadastroCliente;
	}

	public static FrameCadastroTipoEvento getFrameCadastroAgendaTipoEvento() {
		return frameCadastroAgendaTipoEvento;
	}

	public static FrameCadastroContato getFrameCadastroAgendaContato() {
		return frameCadastroAgendaContato;
	}

	public static FrameCadastroContador getFrameCadastroContador() {
		return frameCadastroContador;
	}

	public static FrameCadastroEmpresa getFrameCadastroEmpresa() {
		return frameCadastroEmpresa;
	}

	public static FrameCadastroFornecedor getFrameCadastroFornecedor() {
		return frameCadastroFornecedor;
	}

	public static FrameCadastroFuncionario getFrameCadastroFuncionario() {
		return frameCadastroFuncionario;
	}

	public static FrameCadastroImovel getFrameCadastroImovel() {
		return frameCadastroImovel;
	}

	public static FrameCadastroRecado getFrameCadastroRecado() {
		return frameCadastroAgendaRecado;
	}

	public static FrameCadastroSindicato getFrameCadastroSindicato() {
		return frameCadastroSindicato;
	}

	public static FrameCadastroUsuario getFrameCadastroUsuario() {
		return frameCadastroUsuario;
	}

	public static FrameCadastroVeiculo getFrameCadastroVeiculo() {
		return frameCadastroVeiculo;
	}

	public static FrameCadastroVeiculoMarca getFrameCadastroVeiculoMarca() {
		return frameCadastroVeiculoMarca;
	}

	public static FrameCadastroVeiculoModelo getFrameCadastroVeiculoModelo() {
		return frameCadastroVeiculoModelo;
	}

	public static FrameLogin getFrameLogin() {
		return frameLogin;
	}

	public static FrameMain getFrameMain() {
		return frameMain;
	}

	public static FramePesquisaTipoEvento getFramePesquisaAgendaTipoEvento() {
		return framePesquisaAgendaTipoEvento;
	}

	public static FramePesquisaEvento getFramePesquisaAgendaEvento() {
		return framePesquisaAgendaEvento;
	}

	public static FramePesquisaContato getFramePesquisaAgendaContato() {
		return framePesquisaAgendaContato;
	}

	public static FramePesquisaBanco getFramePesquisaBanco() {
		return framePesquisaBanco;
	}

	public static FramePesquisaCartorio getFramePesquisaCartorio() {
		return framePesquisaCartorio;
	}

	public static FramePesquisaCentroCusto getFramePesquisaCentroCusto() {
		return framePesquisaCentroCusto;
	}

	public static FramePesquisaCliente getFramePesquisaCliente() {
		return framePesquisaCliente;
	}

	public static FramePesquisaContador getFramePesquisaContador() {
		return framePesquisaContador;
	}

	public static FramePesquisaEmpresa getFramePesquisaEmpresa() {
		return framePesquisaEmpresa;
	}

	public static FramePesquisaFornecedor getFramePesquisaFornecedor() {
		return framePesquisaFornecedor;
	}

	public static FramePesquisaFuncionario getFramePesquisaFuncionario() {
		return framePesquisaFuncionario;
	}

	public static FramePesquisaImovel getFramePesquisaImovel() {
		return framePesquisaImovel;
	}

	public static FramePesquisaRecado getFramePesquisaRecado() {
		return framePesquisaAgendaRecado;
	}

	public static FramePesquisaSindicato getFramePesquisaSindicato() {
		return framePesquisaSindicato;
	}

	public static FramePesquisaUsuario getFramePesquisaUsuario() {
		return framePesquisaUsuario;
	}

	public static FramePesquisaVeiculo getFramePesquisaVeiculo() {
		return framePesquisaVeiculo;
	}

	public static FramePesquisaVeiculoMarca getFramePesquisaVeiculoMarca() {
		return framePesquisaVeiculoMarca;
	}

	public static FramePesquisaVeiculoModelo getFramePesquisaVeiculoModelo() {
		return framePesquisaVeiculoModelo;
	}

	public static synchronized MainGerenteEventos getInstance(FrameMain frameMain) {
		if (totalPrincipalHandle > 1) {
			JOptionPane.showMessageDialog(null, "Foi instanciado mais de uma Objeto:" + Main.class);
		}
		if (mainGerenteEventos == null) {
			++totalPrincipalHandle;
			return new MainGerenteEventos(frameMain);
		}
		return mainGerenteEventos;
	}

	public static void mostrarFrame(JFrame frame) {
		frame.setVisible(true);
		frame.setResizable(false);
		frame.toFront();
		frame.repaint();
		frame.setState(java.awt.Frame.NORMAL);
		frame.setLocationRelativeTo(null);
	}

	private MainGerenteEventos(FrameMain frameMain) {
		MainGerenteEventos.frameMain = frameMain;
		criarFrames();
	}

	private void criarFrame(JFrame frame) {
		frame.pack();
		frame.setVisible(false);
	}

	private void criarFrames() {
		frameLogin = new FrameLogin();
		criarFrame(frameLogin);
		frameLogin.iniciarGerenteEventos();

		frameCadastroBanco = new FrameCadastroBanco();
		criarFrame(frameCadastroBanco);

		framePesquisaBanco = new FramePesquisaBanco();
		criarFrame(framePesquisaBanco);

		frameCadastroCentroCusto = new FrameCadastroCentroCusto();
		criarFrame(frameCadastroCentroCusto);
		frameCadastroCentroCusto.iniciarGerenteEventos();

		framePesquisaCentroCusto = new FramePesquisaCentroCusto();
		criarFrame(framePesquisaCentroCusto);

		frameCadastroCliente = new FrameCadastroCliente();
		criarFrame(frameCadastroCliente);
		frameCadastroCliente.iniciarGerenteEventos();

		framePesquisaCliente = new FramePesquisaCliente();
		criarFrame(framePesquisaCliente);

		frameCadastroEmpresa = new FrameCadastroEmpresa();
		criarFrame(frameCadastroEmpresa);

		framePesquisaEmpresa = new FramePesquisaEmpresa();
		criarFrame(framePesquisaEmpresa);

		frameCadastroUsuario = new FrameCadastroUsuario();
		criarFrame(frameCadastroUsuario);

		framePesquisaUsuario = new FramePesquisaUsuario();
		criarFrame(framePesquisaUsuario);

		frameCadastroCartorio = new FrameCadastroCartorio();
		criarFrame(frameCadastroCartorio);

		framePesquisaCartorio = new FramePesquisaCartorio();
		criarFrame(framePesquisaCartorio);

		frameCadastroContador = new FrameCadastroContador();
		criarFrame(frameCadastroContador);

		framePesquisaContador = new FramePesquisaContador();
		criarFrame(framePesquisaContador);

		frameCadastroFuncionario = new FrameCadastroFuncionario();
		criarFrame(frameCadastroFuncionario);

		framePesquisaFuncionario = new FramePesquisaFuncionario();
		criarFrame(framePesquisaFuncionario);

		frameCadastroSindicato = new FrameCadastroSindicato();
		criarFrame(frameCadastroSindicato);

		framePesquisaSindicato = new FramePesquisaSindicato();
		criarFrame(framePesquisaSindicato);

		frameCadastroFornecedor = new FrameCadastroFornecedor();
		criarFrame(frameCadastroFornecedor);

		framePesquisaFornecedor = new FramePesquisaFornecedor();
		criarFrame(framePesquisaFornecedor);

		frameCadastroVeiculo = new FrameCadastroVeiculo();
		criarFrame(frameCadastroVeiculo);

		framePesquisaVeiculo = new FramePesquisaVeiculo();
		criarFrame(framePesquisaVeiculo);

		frameCadastroImovel = new FrameCadastroImovel();
		criarFrame(frameCadastroImovel);

		framePesquisaImovel = new FramePesquisaImovel();
		criarFrame(framePesquisaImovel);

		frameCadastroAgendaContato = new FrameCadastroContato();
		criarFrame(frameCadastroAgendaContato);

		framePesquisaAgendaContato = new FramePesquisaContato();
		criarFrame(framePesquisaAgendaContato);

		frameCadastroAgendaEvento = new FrameCadastroEvento();
		criarFrame(frameCadastroAgendaEvento);

		framePesquisaAgendaEvento = new FramePesquisaEvento();
		criarFrame(framePesquisaAgendaEvento);

		frameCadastroAgendaTipoEvento = new FrameCadastroTipoEvento();
		criarFrame(frameCadastroAgendaTipoEvento);

		framePesquisaAgendaTipoEvento = new FramePesquisaTipoEvento();
		criarFrame(framePesquisaAgendaTipoEvento);

		frameCadastroAgendaRecado = new FrameCadastroRecado();
		criarFrame(frameCadastroAgendaRecado);

		framePesquisaAgendaRecado = new FramePesquisaRecado();
		criarFrame(framePesquisaAgendaRecado);

		frameCadastroVeiculoMarca = new FrameCadastroVeiculoMarca();
		criarFrame(frameCadastroVeiculoMarca);

		framePesquisaVeiculoMarca = new FramePesquisaVeiculoMarca();
		criarFrame(framePesquisaVeiculoMarca);

		frameCadastroVeiculoModelo = new FrameCadastroVeiculoModelo();
		criarFrame(frameCadastroVeiculoModelo);

		framePesquisaVeiculoModelo = new FramePesquisaVeiculoModelo();
		criarFrame(framePesquisaVeiculoModelo);

		frameCalculadora = new FrameCalculadora();
		criarFrame(frameCalculadora);

		frameEditorTexto = new FrameEditorTexto();
		criarFrame(frameEditorTexto);
	}
}
