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
import arquitetura.data.Data;
import arquitetura.gui.Msg;
import erp.agenda.contato.ContatoFc;
import erp.agenda.contato.ContatoFp;
import erp.agenda.evento.EventoFc;
import erp.agenda.evento.EventoFp;
import erp.agenda.evento.tipoevento.TipoEventoFc;
import erp.agenda.evento.tipoevento.TipoEventoFp;
import erp.agenda.recado.RecadoFc;
import erp.agenda.recado.RecadoFp;
import erp.banco.BancoFc;
import erp.banco.BancoFp;
import erp.calculadora.CalculadoraFc;
import erp.cartorio.CartorioFc;
import erp.cartorio.CartorioFp;
import erp.centrocusto.CentroCustoFc;
import erp.centrocusto.CentroCustoFp;
import erp.cliente.ClienteFc;
import erp.cliente.ClienteFp;
import erp.contador.ContadorFc;
import erp.contador.ContadorFp;
import erp.curriculo.caracteristica.CaracteristicaFc;
import erp.curriculo.caracteristica.CaracteristicaFp;
import erp.editor.EditorTextoFc;
import erp.empresa.EmpresaFc;
import erp.empresa.EmpresaFp;
import erp.fornecedor.FornecedorFc;
import erp.fornecedor.FornecedorFp;
import erp.funcionario.FuncionarioFc;
import erp.funcionario.FuncionarioFp;
import erp.imovel.ImovelFc;
import erp.imovel.ImovelFp;
import erp.login.LoginFc;
import erp.sindicato.SindicatoFc;
import erp.sindicato.SindicatoFp;
import erp.usuario.UsuarioFc;
import erp.usuario.UsuarioFp;
import erp.veiculo.VeiculoFc;
import erp.veiculo.VeiculoFp;
import erp.veiculo.marca.VeiculoMarcaFc;
import erp.veiculo.marca.VeiculoMarcaFp;
import erp.veiculo.modelo.VeiculoModeloFc;
import erp.veiculo.modelo.VeiculoModeloFp;

public final class MainCont {

	public class Relogio implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainCont.getAgendaContatoFc().setTitle(AOP.getNomeSistema() + " - CONTATO " + Data.getData());
			MainCont.getAgendaContatoFp().setTitle(AOP.getNomeSistema() + " - CONTATO " + Data.getData());
			MainCont.getAgendaEventoFc().setTitle(AOP.getNomeSistema() + " - EVENTO " + Data.getData());
			MainCont.getAgendaEventoFp().setTitle(AOP.getNomeSistema() + " - EVENTO " + Data.getData());
			MainCont.getAgendaTipoEventoFc().setTitle(AOP.getNomeSistema() + " - TIPO DE EVENTO " + Data.getData());
			MainCont.getAgendaTipoEventoFp().setTitle(AOP.getNomeSistema() + " - TIPO DE EVENTO " + Data.getData());
			MainCont.getAgendaRecadoFc().setTitle(AOP.getNomeSistema() + " - RECADO " + Data.getData());
			MainCont.getAgendaRecadoFp().setTitle(AOP.getNomeSistema() + " - RECADO " + Data.getData());
			MainCont.getBancoFc().setTitle(AOP.getNomeSistema() + " - BANCO " + Data.getData());
			MainCont.getBancoFp().setTitle(AOP.getNomeSistema() + " - BANCO " + Data.getData());
			MainCont.getCalculadoraFc().setTitle(AOP.getNomeSistema() + " - CALCULADORA " + Data.getData());
			MainCont.getCartorioFc().setTitle(AOP.getNomeSistema() + " - CARTÓRIO " + Data.getData());
			MainCont.getCartorioFp().setTitle(AOP.getNomeSistema() + " - CARTÓRIO " + Data.getData());
			MainCont.getCentroCustoFc().setTitle(AOP.getNomeSistema() + " - CENTRO DE CUSTO " + Data.getData());
			MainCont.getCentroCustoFp().setTitle(AOP.getNomeSistema() + " - CENTRO DE CUSTO " + Data.getData());
			MainCont.getClienteFc().setTitle(AOP.getNomeSistema() + " - CLIENTE " + Data.getData());
			MainCont.getClienteFp().setTitle(AOP.getNomeSistema() + " - CLIENTE " + Data.getData());
			MainCont.getContadorFc().setTitle(AOP.getNomeSistema() + " - CONTADOR " + Data.getData());
			MainCont.getContadorFp().setTitle(AOP.getNomeSistema() + " - CONTADOR " + Data.getData());
			MainCont.getEditorTextoFc().setTitle(AOP.getNomeSistema() + " - EDITOR DE TEXTO " + Data.getData());
			MainCont.getEmpresaFc().setTitle(AOP.getNomeSistema() + " - EMPRESA " + Data.getData());
			MainCont.getEmpresaFp().setTitle(AOP.getNomeSistema() + " - EMPRESA " + Data.getData());
			MainCont.getFornecedorFc().setTitle(AOP.getNomeSistema() + " - FORNECEDOR " + Data.getData());
			MainCont.getFornecedorFp().setTitle(AOP.getNomeSistema() + " - FORNECEDOR " + Data.getData());
			MainCont.getFuncionarioFc().setTitle(AOP.getNomeSistema() + " - FUNCIONÁRIO " + Data.getData());
			MainCont.getFuncionarioFp().setTitle(AOP.getNomeSistema() + " - FUNCIONÁRIO " + Data.getData());
			MainCont.getImovelFc().setTitle(AOP.getNomeSistema() + " - IMÓVEL " + Data.getData());
			MainCont.getImovelFp().setTitle(AOP.getNomeSistema() + " - IMÓVEL " + Data.getData());
			MainCont.getLoginFc().setTitle(AOP.getNomeSistema() + " - LOGIN " + Data.getData());
			MainCont.getMainFc().setTitle(AOP.getNomeSistema() + " - PRINCIPAL " + Data.getData());
			MainCont.getSindicatoFc().setTitle(AOP.getNomeSistema() + " - SINDICATO " + Data.getData());
			MainCont.getSindicatoFp().setTitle(AOP.getNomeSistema() + " - SINDICATO " + Data.getData());
			MainCont.getUsuarioFc().setTitle(AOP.getNomeSistema() + " - USUÁRIO " + Data.getData());
			MainCont.getUsuarioFp().setTitle(AOP.getNomeSistema() + " - USUÁRIO " + Data.getData());
			MainCont.getVeiculoFc().setTitle(AOP.getNomeSistema() + " - VEÍCULO " + Data.getData());
			MainCont.getVeiculoFp().setTitle(AOP.getNomeSistema() + " - VEÍCULO " + Data.getData());
			MainCont.getVeiculoMarcaFc().setTitle(AOP.getNomeSistema() + " - MARCA DE VEÍCULO " + Data.getData());
			MainCont.getVeiculoMarcaFp().setTitle(AOP.getNomeSistema() + " - MARCA DE VEÍCULO " + Data.getData());
			MainCont.getVeiculoModeloFc().setTitle(AOP.getNomeSistema() + " - MODELO DE VEÍCULO " + Data.getData());
			MainCont.getVeiculoModeloFp().setTitle(AOP.getNomeSistema() + " - MODELO DE VEÍCULO " + Data.getData());
		}
	}

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
			if (actionEvent.getSource() == mainFc.getMenuItemArquivoSair()) {
				if (Msg.confirmarSairDoSistema() == 0) {
					System.exit(0);
				}
			} else if (actionEvent.getSource() == mainFc.getMenuItemArquivoLogin()) {
				mostrarFrame(loginFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemArquivoLogoff()) {
				AOP.setUsuario(null);
				Msg.avisoUsuarioNaoLogado();
			} else if (actionEvent.getSource() == mainFc.getMenuItemArquivoReiniciar()) {
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
			if (actionEvent.getSource() == mainFc.getMenuItemCadastroCentroCusto()) {
				mostrarFrame(centroCustoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroBanco()) {
				mostrarFrame(bancoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroCartorio()) {
				mostrarFrame(cartorioFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroFuncionario()) {
				mostrarFrame(funcionarioFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroContador()) {
				mostrarFrame(contadorFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroCliente()) {
				mostrarFrame(clienteFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroEmpresa()) {
				mostrarFrame(empresaFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroSindicato()) {
				mostrarFrame(sindicatoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroFornecedor()) {
				mostrarFrame(fornecedorFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroVeiculoVeiculo()) {
				mostrarFrame(veiculoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroVeiculoModelo()) {
				mostrarFrame(veiculoModeloFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroVeiculoMarca()) {
				mostrarFrame(veiculoMarcaFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
				mostrarFrame(imovelFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroCurriculoCaracteristica()) {
				mostrarFrame(curriculoCaracteristicaFc);
			}/* else if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
				mostrarFrame(curriculoCertificadoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
				mostrarFrame(curriculoCursoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
				mostrarFrame(curriculoExperienciaProfissionalFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
				mostrarFrame(curriculoHabilidadeFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
				mostrarFrame(curriculoIdiomaFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
				mostrarFrame(curriculoObjetivoProfissionalFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
				mostrarFrame(curriculoHabilidade);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
				mostrarFrame(curriculoIdiomaFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
				mostrarFrame(curriculoObjetivoProfissionalFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
				mostrarFrame(curriculoTestePersonalidadeFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
				mostrarFrame(curriculoTesteDiscFc);
			}
			*/
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
			if (actionEvent.getSource() == mainFc.getMenuItemSistemaUsuario()) {
				mostrarFrame(usuarioFc);
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
			if (actionEvent.getSource() == mainFc.getMenuItemUtilitarioAgendaEvento()) {
				mostrarFrame(eventoFc);
			}
			if (actionEvent.getSource() == mainFc.getMenuItemUtilitarioAgendaTipoEvento()) {
				mostrarFrame(tipoEventoFc);
			}
			if (actionEvent.getSource() == mainFc.getMenuItemUtilitarioAgendaRecado()) {
				mostrarFrame(recadoFc);
			}
			if (actionEvent.getSource() == mainFc.getMenuItemUtilitarioAgendaContato()) {
				mostrarFrame(contatoFc);
			}
			if (actionEvent.getSource() == mainFc.getMenuItemUtilitarioCalculadora()) {
				mostrarFrame(calculadoraFc);
			}
			if (actionEvent.getSource() == mainFc.getMenuItemUtilitarioEditorTexto()) {
				mostrarFrame(editorTextoFc);
			}
		}
	}

	private static LoginFc loginFc;
	private static BancoFc bancoFc;
	private static BancoFp bancoFp;
	private static CentroCustoFc centroCustoFc;
	private static CentroCustoFp centroCustoFp;
	private static EventoFc eventoFc;
	private static EventoFp eventoFp;
	private static TipoEventoFc tipoEventoFc;
	private static TipoEventoFp tipoEventoFp;
	private static ContatoFc contatoFc;
	private static ContatoFp contatoFp;
	private static RecadoFc recadoFc;
	private static RecadoFp recadoFp;
	private static CartorioFc cartorioFc;
	private static CartorioFp cartorioFp;
	private static ContadorFc contadorFc;
	private static ContadorFp contadorFp;
	private static CaracteristicaFc curriculoCaracteristicaFc;
	private static CaracteristicaFp curriculoCaracteristicaFp;
	/*
	private static CertificadoFc curriculoCertificadoFc;
	private static CertificadoFp curriculoCertificadoFp;
	private static CursoFc curriculoCursoFc;
	private static CursoFp curriculoCursoFp;
	private static ExperienciaProfissionalFc curriculoExperienciaProfissionalFc;
	private static ExperienciaProfissionalFp curriculoExperienciaProfissionalFp;
	private static HabilidadeFc curriculoHabilidadeFc;
	private static HabilidadeFp curriculoHabilidadeFp;
	private static IdiomaFc curriculoIdiomaFc;
	private static IdiomaFp curriculoIdiomaFp;
	private static ObjetivoProfissionalFc curriculoObjetivoProfissionalFc;
	private static ObjetivoProfissionalFp curriculoObjetivoProfissionalFp;
	private static TestePersonalidadeFc curriculoTestePersonalidadeFc;
	private static TestePersonalidadeFp curriculoTestePersonalidadeFp;
	private static TesteDiscFc curriculoTesteDiscFc;
	private static TesteDiscFp curriculoTesteDiscFp;
	*/
	private static FuncionarioFc funcionarioFc;
	private static FuncionarioFp funcionarioFp;
	private static UsuarioFc usuarioFc;
	private static UsuarioFp usuarioFp;
	private static ClienteFc clienteFc;
	private static ClienteFp clienteFp;
	private static EmpresaFc empresaFc;
	private static EmpresaFp empresaFp;
	private static SindicatoFc sindicatoFc;
	private static SindicatoFp sindicatoFp;
	private static FornecedorFc fornecedorFc;
	private static FornecedorFp fornecedorFp;
	private static VeiculoFc veiculoFc;
	private static VeiculoFp veiculoFp;
	private static VeiculoMarcaFc veiculoMarcaFc;
	private static VeiculoMarcaFp veiculoMarcaFp;
	private static VeiculoModeloFc veiculoModeloFc;
	private static VeiculoModeloFp veiculoModeloFp;
	private static ImovelFc imovelFc;
	private static ImovelFp imovelFp;
	private static CalculadoraFc calculadoraFc;
	private static EditorTextoFc editorTextoFc;
	private static MainCont mainCont;
	private static MainFc mainFc;
	private static int totalPrincipalHandle;

	static {
		totalPrincipalHandle = 0;
	}

	public static EditorTextoFc getEditorTextoFc() {
		return editorTextoFc;
	}

	public static CalculadoraFc getCalculadoraFc() {
		return calculadoraFc;
	}

	public static EventoFc getAgendaEventoFc() {
		return eventoFc;
	}

	public static BancoFc getBancoFc() {
		return bancoFc;
	}

	public static CartorioFc getCartorioFc() {
		return cartorioFc;
	}

	public static CentroCustoFc getCentroCustoFc() {
		return centroCustoFc;
	}

	public static ClienteFc getClienteFc() {
		return clienteFc;
	}

	public static TipoEventoFc getAgendaTipoEventoFc() {
		return tipoEventoFc;
	}

	public static ContatoFc getAgendaContatoFc() {
		return contatoFc;
	}

	public static ContadorFc getContadorFc() {
		return contadorFc;
	}

	public static EmpresaFc getEmpresaFc() {
		return empresaFc;
	}

	public static FornecedorFc getFornecedorFc() {
		return fornecedorFc;
	}

	public static FuncionarioFc getFuncionarioFc() {
		return funcionarioFc;
	}

	public static ImovelFc getImovelFc() {
		return imovelFc;
	}

	public static RecadoFc getAgendaRecadoFc() {
		return recadoFc;
	}

	public static SindicatoFc getSindicatoFc() {
		return sindicatoFc;
	}

	public static UsuarioFc getUsuarioFc() {
		return usuarioFc;
	}

	public static VeiculoFc getVeiculoFc() {
		return veiculoFc;
	}

	public static VeiculoMarcaFc getVeiculoMarcaFc() {
		return veiculoMarcaFc;
	}

	public static VeiculoModeloFc getVeiculoModeloFc() {
		return veiculoModeloFc;
	}

	public static LoginFc getLoginFc() {
		return loginFc;
	}

	public static MainFc getMainFc() {
		return mainFc;
	}

	public static TipoEventoFp getAgendaTipoEventoFp() {
		return tipoEventoFp;
	}

	public static EventoFp getAgendaEventoFp() {
		return eventoFp;
	}

	public static ContatoFp getAgendaContatoFp() {
		return contatoFp;
	}

	public static BancoFp getBancoFp() {
		return bancoFp;
	}

	public static CartorioFp getCartorioFp() {
		return cartorioFp;
	}

	public static CentroCustoFp getCentroCustoFp() {
		return centroCustoFp;
	}

	public static ClienteFp getClienteFp() {
		return clienteFp;
	}

	public static ContadorFp getContadorFp() {
		return contadorFp;
	}

	public static EmpresaFp getEmpresaFp() {
		return empresaFp;
	}

	public static FornecedorFp getFornecedorFp() {
		return fornecedorFp;
	}

	public static FuncionarioFp getFuncionarioFp() {
		return funcionarioFp;
	}

	public static ImovelFp getImovelFp() {
		return imovelFp;
	}

	public static RecadoFp getAgendaRecadoFp() {
		return recadoFp;
	}

	public static SindicatoFp getSindicatoFp() {
		return sindicatoFp;
	}

	public static UsuarioFp getUsuarioFp() {
		return usuarioFp;
	}

	public static VeiculoFp getVeiculoFp() {
		return veiculoFp;
	}

	public static VeiculoMarcaFp getVeiculoMarcaFp() {
		return veiculoMarcaFp;
	}

	public static VeiculoModeloFp getVeiculoModeloFp() {
		return veiculoModeloFp;
	}

	public static CaracteristicaFc getCurriculoCaracteristicaFc() {
		return curriculoCaracteristicaFc;
	}

	public static CaracteristicaFp getCurriculoCaracteristicaFp() {
		return curriculoCaracteristicaFp;
	}

	public static synchronized MainCont getInstance(MainFc mainFc) {
		if (totalPrincipalHandle > 1) {
			JOptionPane.showMessageDialog(null, "Foi instanciado mais de uma Objeto:" + ERP.class);
			System.exit(0);
		}
		if (mainCont == null) {
			++totalPrincipalHandle;
			return new MainCont(mainFc);
		}
		return mainCont;
	}

	public static void mostrarFrame(JFrame frame) {
		frame.setVisible(true);
		frame.setResizable(false);
		frame.toFront();
		frame.repaint();
		frame.setState(java.awt.Frame.NORMAL);
		frame.setLocationRelativeTo(null);
	}

	private MainCont(MainFc mainFc) {
		MainCont.mainFc = mainFc;
		criarFrames();
	}

	private void criarFrame(JFrame frame) {
		frame.pack();
		frame.setVisible(false);
	}

	private void criarFrames() {
		loginFc = new LoginFc();
		criarFrame(loginFc);

		bancoFc = new BancoFc();
		criarFrame(bancoFc);

		bancoFp = new BancoFp();
		criarFrame(bancoFp);

		centroCustoFc = new CentroCustoFc();
		criarFrame(centroCustoFc);

		centroCustoFp = new CentroCustoFp();
		criarFrame(centroCustoFp);

		clienteFc = new ClienteFc();
		criarFrame(clienteFc);

		clienteFp = new ClienteFp();
		criarFrame(clienteFp);

		empresaFc = new EmpresaFc();
		criarFrame(empresaFc);

		empresaFp = new EmpresaFp();
		criarFrame(empresaFp);

		usuarioFc = new UsuarioFc();
		criarFrame(usuarioFc);

		usuarioFp = new UsuarioFp();
		criarFrame(usuarioFp);

		cartorioFc = new CartorioFc();
		criarFrame(cartorioFc);

		cartorioFp = new CartorioFp();
		criarFrame(cartorioFp);

		contadorFc = new ContadorFc();
		criarFrame(contadorFc);

		contadorFp = new ContadorFp();
		criarFrame(contadorFp);

		funcionarioFc = new FuncionarioFc();
		criarFrame(funcionarioFc);

		funcionarioFp = new FuncionarioFp();
		criarFrame(funcionarioFp);

		sindicatoFc = new SindicatoFc();
		criarFrame(sindicatoFc);

		sindicatoFp = new SindicatoFp();
		criarFrame(sindicatoFp);

		fornecedorFc = new FornecedorFc();
		criarFrame(fornecedorFc);

		fornecedorFp = new FornecedorFp();
		criarFrame(fornecedorFp);

		veiculoFc = new VeiculoFc();
		criarFrame(veiculoFc);

		veiculoFp = new VeiculoFp();
		criarFrame(veiculoFp);

		imovelFc = new ImovelFc();
		criarFrame(imovelFc);

		imovelFp = new ImovelFp();
		criarFrame(imovelFp);

		contatoFc = new ContatoFc();
		criarFrame(contatoFc);

		contatoFp = new ContatoFp();
		criarFrame(contatoFp);

		eventoFc = new EventoFc();
		criarFrame(eventoFc);

		eventoFp = new EventoFp();
		criarFrame(eventoFp);

		tipoEventoFc = new TipoEventoFc();
		criarFrame(tipoEventoFc);

		tipoEventoFp = new TipoEventoFp();
		criarFrame(tipoEventoFp);

		recadoFc = new RecadoFc();
		criarFrame(recadoFc);

		recadoFp = new RecadoFp();
		criarFrame(recadoFp);

		veiculoMarcaFc = new VeiculoMarcaFc();
		criarFrame(veiculoMarcaFc);

		veiculoMarcaFp = new VeiculoMarcaFp();
		criarFrame(veiculoMarcaFp);

		veiculoModeloFc = new VeiculoModeloFc();
		criarFrame(veiculoModeloFc);

		veiculoModeloFp = new VeiculoModeloFp();
		criarFrame(veiculoModeloFp);

		curriculoCaracteristicaFc = new CaracteristicaFc();
		criarFrame(curriculoCaracteristicaFc);

		curriculoCaracteristicaFp = new CaracteristicaFp();
		criarFrame(curriculoCaracteristicaFp);

		calculadoraFc = new CalculadoraFc();
		criarFrame(calculadoraFc);

		editorTextoFc = new EditorTextoFc();
		criarFrame(editorTextoFc);
	}
}
