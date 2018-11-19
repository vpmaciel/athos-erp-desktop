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

import erp.agenda.agenda.FrameCadastroAgenda;
import erp.agenda.agenda.FramePesquisaAgenda;
import erp.agenda.agenda.PanelCadastroAgenda;
import erp.agenda.agenda.PanelPesquisaAgenda;
import erp.agenda.compromisso.FrameCadastroCompromisso;
import erp.agenda.compromisso.FramePesquisaCompromisso;
import erp.agenda.compromisso.PanelCadastroCompromisso;
import erp.agenda.compromisso.PanelPesquisaCompromisso;
import erp.agenda.evento.FrameCadastroEvento;
import erp.agenda.evento.FramePesquisaEvento;
import erp.agenda.evento.tipoevento.FrameCadastroTipoEvento;
import erp.agenda.evento.tipoevento.FramePesquisaTipoEvento;
import erp.agenda.recado.FrameCadastroRecado;
import erp.agenda.recado.FramePesquisaRecado;
import erp.agenda.recado.PanelCadastroRecado;
import erp.agenda.recado.PanelPesquisaRecado;
import erp.agenda.tarefa.FrameCadastroTarefa;
import erp.agenda.tarefa.FramePesquisaTarefa;
import erp.agenda.tarefa.PanelCadastroTarefa;
import erp.agenda.tarefa.PanelPesquisaTarefa;
import erp.aop.AOP;
import erp.aop.gui.Msg;
import erp.banco.FrameCadastroBanco;
import erp.banco.FramePesquisaBanco;
import erp.banco.PanelPesquisaBanco;
import erp.calculadora.FrameCalculadora;
import erp.cartorio.FrameCadastroCartorio;
import erp.cartorio.FramePesquisaCartorio;
import erp.cartorio.PanelCadastroCartorio;
import erp.cartorio.PanelPesquisaCartorio;
import erp.centrocusto.FrameCadastroCentroCusto;
import erp.centrocusto.FramePesquisaCentroCusto;
import erp.centrocusto.PanelCadastroCentroCusto;
import erp.centrocusto.PanelPesquisaCentroCusto;
import erp.cliente.FrameCadastroCliente;
import erp.cliente.FramePesquisaCliente;
import erp.cliente.PanelCadastroCliente;
import erp.cliente.PanelPesquisaCliente;
import erp.contador.FrameCadastroContador;
import erp.contador.FramePesquisaContador;
import erp.contador.PanelCadastroContador;
import erp.contador.PanelPesquisaContador;
import erp.editor.texto.FrameEditorTexto;
import erp.empresa.FrameCadastroEmpresa;
import erp.empresa.FramePesquisaEmpresa;
import erp.empresa.PanelCadastroEmpresa;
import erp.empresa.PanelPesquisaEmpresa;
import erp.fornecedor.FrameCadastroFornecedor;
import erp.fornecedor.FramePesquisaFornecedor;
import erp.fornecedor.PanelCadastroFornecedor;
import erp.fornecedor.PanelPesquisaFornecedor;
import erp.funcionario.FrameCadastroFuncionario;
import erp.funcionario.FramePesquisaFuncionario;
import erp.funcionario.PanelCadastroFuncionario;
import erp.funcionario.PanelPesquisaFuncionario;
import erp.imovel.FrameCadastroImovel;
import erp.imovel.FramePesquisaImovel;
import erp.imovel.PanelCadastroImovel;
import erp.imovel.PanelPesquisaImovel;
import erp.login.FrameLogin;
import erp.sindicato.FrameCadastroSindicato;
import erp.sindicato.FramePesquisaSindicato;
import erp.sindicato.PanelCadastroSindicato;
import erp.sindicato.PanelPesquisaSindicato;
import erp.usuario.FrameCadastroUsuario;
import erp.usuario.FramePesquisaUsuario;
import erp.usuario.PanelCadastroUsuario;
import erp.usuario.PanelPesquisaUsuario;
import erp.veiculo.marca.FrameCadastroVeiculoMarca;
import erp.veiculo.marca.FramePesquisaVeiculoMarca;
import erp.veiculo.marca.PanelCadastroVeiculoMarca;
import erp.veiculo.marca.PanelPesquisaVeiculoMarca;
import erp.veiculo.modelo.FrameCadastroVeiculoModelo;
import erp.veiculo.modelo.FramePesquisaVeiculoModelo;
import erp.veiculo.modelo.PanelCadastroVeiculoModelo;
import erp.veiculo.modelo.PanelPesquisaVeiculoModelo;
import erp.veiculo.veiculo.FrameCadastroVeiculo;
import erp.veiculo.veiculo.FramePesquisaVeiculo;
import erp.veiculo.veiculo.PanelCadastroVeiculo;
import erp.veiculo.veiculo.PanelPesquisaVeiculo;

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
			if (actionEvent.getSource() == frameMain.getMenuItemUtilitarioAgendaAgenda()) {
				mostrarFrame(frameCadastroAgenda);
			}
			if (actionEvent.getSource() == frameMain.getMenuItemUtilitarioAgendaCompromisso()) {
				mostrarFrame(frameCadastroAgendaCompromisso);
			}
			if (actionEvent.getSource() == frameMain.getMenuItemUtilitarioAgendaTarefa()) {
				mostrarFrame(frameCadastroAgendaTarefa);
			}
			if (actionEvent.getSource() == frameMain.getMenuItemUtilitarioAgendaRecado()) {
				mostrarFrame(frameCadastroAgendaRecado);
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
	private static FrameCadastroCompromisso frameCadastroAgendaCompromisso;
	private static FramePesquisaCompromisso framePesquisaCompromisso;
	private static FrameCadastroRecado frameCadastroAgendaRecado;
	private static FramePesquisaRecado framePesquisaRecado;
	private static FrameCadastroTarefa frameCadastroAgendaTarefa;
	private static FramePesquisaTarefa framePesquisaTarefa;
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
	private static FrameCadastroAgenda frameCadastroAgenda;
	private static FramePesquisaAgenda framePesquisaAgenda;
	private static FrameCadastroEvento frameCadastroEvento;
	private static FramePesquisaEvento framePesquisaEvento;
	private static FrameCadastroTipoEvento frameCadastroTipoEvento;
	private static FramePesquisaTipoEvento framePesquisaTipoEvento;
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

	public static FrameCadastroAgenda getFrameCadastroAgenda() {
		return frameCadastroAgenda;
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

	public static FrameCadastroCompromisso getFrameCadastroCompromisso() {
		return frameCadastroAgendaCompromisso;
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

	public static FrameCadastroTarefa getFrameCadastroTarefa() {
		return frameCadastroAgendaTarefa;
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

	public static FrameCadastroTipoEvento getFrameCadastroTipoEvento() {
		return frameCadastroTipoEvento;
	}

	public static FramePesquisaTipoEvento getFramePesquisaTipoEvento() {
		return framePesquisaTipoEvento;
	}

	public static FrameCadastroEvento getFrameCadastroEvento() {
		return frameCadastroEvento;
	}

	public static FramePesquisaEvento getFramePesquisaEvento() {
		return framePesquisaEvento;
	}

	public static FramePesquisaAgenda getFramePesquisaAgenda() {
		return framePesquisaAgenda;
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

	public static FramePesquisaCompromisso getFramePesquisaCompromisso() {
		return framePesquisaCompromisso;
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
		return framePesquisaRecado;
	}

	public static FramePesquisaSindicato getFramePesquisaSindicato() {
		return framePesquisaSindicato;
	}

	public static FramePesquisaTarefa getFramePesquisaTarefa() {
		return framePesquisaTarefa;
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

	public static PanelCadastroAgenda getPanelCadastroAgenda() {
		return frameCadastroAgenda.getPanelCadastroAgenda();
	}

	public static PanelCadastroCartorio getPanelCadastroCartorio() {
		return frameCadastroCartorio.getPanelCadastroCartorio();
	}

	public static PanelCadastroCentroCusto getPanelCadastroCentroCusto() {
		return frameCadastroCentroCusto.getPanelCadastroCentroCusto();
	}

	public static PanelCadastroCliente getPanelCadastroCliente() {
		return frameCadastroCliente.getPanelCadastroCliente();
	}

	public static PanelCadastroCompromisso getPanelCadastroCompromisso() {
		return frameCadastroAgendaCompromisso.getPanelCadastroCompromisso();
	}

	public static PanelCadastroContador getPanelCadastroContador() {
		return frameCadastroContador.getPanelCadastroContador();
	}

	public static PanelCadastroEmpresa getPanelCadastroEmpresa() {
		return frameCadastroEmpresa.getPanelCadastroEmpresa();
	}

	public static PanelCadastroFornecedor getPanelCadastroFornecedor() {
		return frameCadastroFornecedor.getPanelCadastroFornecedor();
	}

	public static PanelCadastroFuncionario getPanelCadastroFuncionario() {
		return frameCadastroFuncionario.getPanelCadastroFuncionario();
	}

	public static PanelCadastroImovel getPanelCadastroImovel() {
		return frameCadastroImovel.getPanelCadastroImovel();
	}

	public static PanelCadastroRecado getPanelCadastroRecado() {
		return frameCadastroAgendaRecado.getPanelCadastroRecado();
	}

	public static PanelCadastroSindicato getPanelCadastroSindicato() {
		return frameCadastroSindicato.getPanelCadastroSindicato();
	}

	public static PanelCadastroTarefa getPanelCadastroTarefa() {
		return frameCadastroAgendaTarefa.getPanelCadastroTarefa();
	}

	public static PanelCadastroUsuario getPanelCadastroUsuario() {
		return frameCadastroUsuario.getPanelCadastroUsuario();
	}

	public static PanelCadastroVeiculo getPanelCadastroVeiculo() {
		return frameCadastroVeiculo.getPanelCadastroVeiculo();
	}

	public static PanelCadastroVeiculoMarca getPanelCadastroVeiculoMarca() {
		return getPanelCadastroVeiculoMarca();
	}

	public static PanelCadastroVeiculoModelo getPanelCadastroVeiculoModelo() {
		return frameCadastroVeiculoModelo.getPanelCadastroVeiculoModelo();
	}

	public static PanelPesquisaAgenda getPanelPesquisaAgenda() {
		return framePesquisaAgenda.getPanelPesquisaAgenda();
	}

	public static PanelPesquisaBanco getPanelPesquisaBanco() {
		return framePesquisaBanco.getPanelPesquisaBanco();
	}

	public static PanelPesquisaCartorio getPanelPesquisaCartorio() {
		return framePesquisaCartorio.getPanelPesquisaCartorio();
	}

	public static PanelPesquisaCentroCusto getPanelPesquisaCentroCusto() {
		return framePesquisaCentroCusto.getPanelPesquisaCentroCusto();
	}

	public static PanelPesquisaCliente getPanelPesquisaCliente() {
		return framePesquisaCliente.getPanelPesquisaCliente();
	}

	public static PanelPesquisaCompromisso getPanelPesquisaCompromisso() {
		return framePesquisaCompromisso.getPanelPesquisaCompromisso();
	}

	public static PanelPesquisaContador getPanelPesquisaContador() {
		return framePesquisaContador.getPanelPesquisaContador();
	}

	public static PanelPesquisaEmpresa getPanelPesquisaEmpresa() {
		return framePesquisaEmpresa.getPanelPesquisaEmpresa();
	}

	public static PanelPesquisaFornecedor getPanelPesquisaFornecedor() {
		return framePesquisaFornecedor.getPanelPesquisaFornecedor();
	}

	public static PanelPesquisaFuncionario getPanelPesquisaFuncionario() {
		return framePesquisaFuncionario.getPanelPesquisaFuncionario();
	}

	public static PanelPesquisaImovel getPanelPesquisaImovel() {
		return framePesquisaImovel.getPanelPesquisaImovel();
	}

	public static PanelPesquisaRecado getPanelPesquisaRecado() {
		return framePesquisaRecado.getPanelPesquisaRecado();
	}

	public static PanelPesquisaSindicato getPanelPesquisaSindicato() {
		return framePesquisaSindicato.getPanelPesquisaSindicato();
	}

	public static PanelPesquisaTarefa getPanelPesquisaTarefa() {
		return framePesquisaTarefa.getPanelPesquisaTarefa();
	}

	public static PanelPesquisaUsuario getPanelPesquisaUsuario() {
		return framePesquisaUsuario.getPanelPesquisaUsuario();
	}

	public static PanelPesquisaVeiculo getPanelPesquisaVeiculo() {
		return framePesquisaVeiculo.getPanelPesquisaVeiculo();
	}

	public static PanelPesquisaVeiculoMarca getPanelPesquisaVeiculoMarca() {
		return getPanelPesquisaVeiculoMarca();
	}

	public static PanelPesquisaVeiculoModelo getPanelPesquisaVeiculoModelo() {
		return framePesquisaVeiculoModelo.getPanelPesquisaVeiculoModelo();
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
		// frameCadastroEmpresa.iniciarGerenteEventos();

		framePesquisaEmpresa = new FramePesquisaEmpresa();
		criarFrame(framePesquisaEmpresa);

		frameCadastroUsuario = new FrameCadastroUsuario();
		criarFrame(frameCadastroUsuario);
		// frameCadastroUsuario.iniciarGerenteEventos();

		framePesquisaUsuario = new FramePesquisaUsuario();
		criarFrame(framePesquisaUsuario);

		frameCadastroCartorio = new FrameCadastroCartorio();
		criarFrame(frameCadastroCartorio);
		frameCadastroCartorio.iniciarGerenteEventos();

		framePesquisaCartorio = new FramePesquisaCartorio();
		criarFrame(framePesquisaCartorio);

		frameCadastroContador = new FrameCadastroContador();
		criarFrame(frameCadastroContador);
		frameCadastroContador.iniciarGerenteEventos();

		framePesquisaContador = new FramePesquisaContador();
		criarFrame(framePesquisaContador);

		frameCadastroFuncionario = new FrameCadastroFuncionario();
		criarFrame(frameCadastroFuncionario);
		// frameCadastroFuncionario.iniciarGerenteEventos();

		framePesquisaFuncionario = new FramePesquisaFuncionario();
		criarFrame(framePesquisaFuncionario);

		frameCadastroSindicato = new FrameCadastroSindicato();
		criarFrame(frameCadastroSindicato);
		// frameCadastroSindicato.iniciarGerenteEventos();

		framePesquisaSindicato = new FramePesquisaSindicato();
		criarFrame(framePesquisaSindicato);

		frameCadastroFornecedor = new FrameCadastroFornecedor();
		criarFrame(frameCadastroFornecedor);
		// frameCadastroFornecedor.iniciarGerenteEventos();

		framePesquisaFornecedor = new FramePesquisaFornecedor();
		criarFrame(framePesquisaFornecedor);

		frameCadastroVeiculo = new FrameCadastroVeiculo();
		criarFrame(frameCadastroVeiculo);
		frameCadastroVeiculo.iniciarGerenteEventos();

		framePesquisaVeiculo = new FramePesquisaVeiculo();
		criarFrame(framePesquisaVeiculo);

		frameCadastroImovel = new FrameCadastroImovel();
		criarFrame(frameCadastroImovel);
		// frameCadastroImovel.iniciarGerenteEventos();

		framePesquisaImovel = new FramePesquisaImovel();
		criarFrame(framePesquisaImovel);

		frameCadastroAgenda = new FrameCadastroAgenda();
		criarFrame(frameCadastroAgenda);
		// frameCadastroAgenda.iniciarGerenteEventos();

		framePesquisaAgenda = new FramePesquisaAgenda();
		criarFrame(framePesquisaAgenda);

		frameCadastroAgendaCompromisso = new FrameCadastroCompromisso();
		criarFrame(frameCadastroAgendaCompromisso);
		// frameCadastroAgendaCompromisso.iniciarGerenteEventos();

		framePesquisaCompromisso = new FramePesquisaCompromisso();
		criarFrame(framePesquisaCompromisso);

		frameCadastroAgendaRecado = new FrameCadastroRecado();
		criarFrame(frameCadastroAgendaRecado);
		// frameCadastroAgendaRecado.iniciarGerenteEventos();

		framePesquisaRecado = new FramePesquisaRecado();
		criarFrame(framePesquisaRecado);

		frameCadastroAgendaTarefa = new FrameCadastroTarefa();
		criarFrame(frameCadastroAgendaTarefa);
		// frameCadastroAgendaTarefa.iniciarGerenteEventos();

		framePesquisaTarefa = new FramePesquisaTarefa();
		criarFrame(framePesquisaTarefa);

		frameCadastroVeiculoMarca = new FrameCadastroVeiculoMarca();
		criarFrame(frameCadastroVeiculoMarca);
		frameCadastroVeiculoMarca.iniciarGerenteEventos();

		framePesquisaVeiculoMarca = new FramePesquisaVeiculoMarca();
		criarFrame(framePesquisaVeiculoMarca);

		frameCadastroVeiculoModelo = new FrameCadastroVeiculoModelo();
		criarFrame(frameCadastroVeiculoModelo);
		frameCadastroVeiculoModelo.iniciarGerenteEventos();

		framePesquisaVeiculoModelo = new FramePesquisaVeiculoModelo();
		criarFrame(framePesquisaVeiculoModelo);

		frameCalculadora = new FrameCalculadora();
		criarFrame(frameCalculadora);

		frameEditorTexto = new FrameEditorTexto();
		criarFrame(frameEditorTexto);
	}

}
