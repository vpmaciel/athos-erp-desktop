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
import erp.curriculo.certificado.CertificadoFc;
import erp.curriculo.certificado.CertificadoFp;
import erp.curriculo.curso.CursoFc;
import erp.curriculo.curso.CursoFp;
import erp.curriculo.experienciaprofissional.ExperienciaProfissionalFc;
import erp.curriculo.experienciaprofissional.ExperienciaProfissionalFp;
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
			MainFc.mostrarFrame(loginFc);
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

	public class MenuCadastroBancoGerenteEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (AOP.getUsuario() == null) {
				Msg.avisoUsuarioNaoLogado();
				return;
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
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroCurriculoCertificado()) {
				mostrarFrame(curriculoCertificadoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroCurriculoCurso()) {
				mostrarFrame(curriculoCursoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroCurriculoExperienciaProfissional()) {
				mostrarFrame(curriculoExperienciaProfissionalFc);
			}
			/*
			 * else if
			 * 
			 * (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
			 * mostrarFrame(curriculoHabilidadeFc); } else if (actionEvent.getSource() ==
			 * mainFc.getMenuItemCadastroImovel()) { mostrarFrame(curriculoIdiomaFc); } else
			 * if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
			 * mostrarFrame(curriculoObjetivoProfissionalFc); } else if
			 * (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
			 * mostrarFrame(curriculoHabilidade); } else if (actionEvent.getSource() ==
			 * mainFc.getMenuItemCadastroImovel()) { mostrarFrame(curriculoIdiomaFc); } else
			 * if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
			 * mostrarFrame(curriculoObjetivoProfissionalFc); } else if
			 * (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
			 * mostrarFrame(curriculoTestePersonalidadeFc); } else if
			 * (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
			 * mostrarFrame(curriculoTesteDiscFc); }
			 */
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

	public class Relogio implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainCont.getAgendaContatoFc()
					.setTitle(AOP.getNomeSistema() + " - CONTATO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getAgendaContatoFp()
					.setTitle(AOP.getNomeSistema() + " - CONTATO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getAgendaEventoFc()
					.setTitle(AOP.getNomeSistema() + " - EVENTO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getAgendaEventoFp()
					.setTitle(AOP.getNomeSistema() + " - EVENTO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getAgendaTipoEventoFc()
					.setTitle(AOP.getNomeSistema() + " - TIPO DE EVENTO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getAgendaTipoEventoFp()
					.setTitle(AOP.getNomeSistema() + " - TIPO DE EVENTO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getAgendaRecadoFc()
					.setTitle(AOP.getNomeSistema() + " - RECADO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getAgendaRecadoFp()
					.setTitle(AOP.getNomeSistema() + " - RECADO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getBancoFc()
					.setTitle(AOP.getNomeSistema() + " - BANCO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getBancoFp()
					.setTitle(AOP.getNomeSistema() + " - BANCO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getCalculadoraFc()
					.setTitle(AOP.getNomeSistema() + " - CALCULADORA " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getCartorioFc()
					.setTitle(AOP.getNomeSistema() + " - CARTÓRIO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getCartorioFp()
					.setTitle(AOP.getNomeSistema() + " - CARTÓRIO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getCentroCustoFc().setTitle(
					AOP.getNomeSistema() + " - CENTRO DE CUSTO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getCentroCustoFp().setTitle(
					AOP.getNomeSistema() + " - CENTRO DE CUSTO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getClienteFc()
					.setTitle(AOP.getNomeSistema() + " - CLIENTE " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getClienteFp()
					.setTitle(AOP.getNomeSistema() + " - CLIENTE " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getContadorFc()
					.setTitle(AOP.getNomeSistema() + " - CONTADOR " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getContadorFp()
					.setTitle(AOP.getNomeSistema() + " - CONTADOR " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getEditorTextoFc().setTitle(
					AOP.getNomeSistema() + " - EDITOR DE TEXTO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getEmpresaFc()
					.setTitle(AOP.getNomeSistema() + " - EMPRESA " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getEmpresaFp()
					.setTitle(AOP.getNomeSistema() + " - EMPRESA " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getFornecedorFc()
					.setTitle(AOP.getNomeSistema() + " - FORNECEDOR " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getFornecedorFp()
					.setTitle(AOP.getNomeSistema() + " - FORNECEDOR " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getFuncionarioFc()
					.setTitle(AOP.getNomeSistema() + " - FUNCIONÁRIO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getFuncionarioFp()
					.setTitle(AOP.getNomeSistema() + " - FUNCIONÁRIO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getImovelFc()
					.setTitle(AOP.getNomeSistema() + " - IMÓVEL " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getImovelFp()
					.setTitle(AOP.getNomeSistema() + " - IMÓVEL " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getLoginFc()
					.setTitle(AOP.getNomeSistema() + " - LOGIN " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getMainFc()
					.setTitle(AOP.getNomeSistema() + " - PRINCIPAL " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getSindicatoFc()
					.setTitle(AOP.getNomeSistema() + " - SINDICATO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getSindicatoFp()
					.setTitle(AOP.getNomeSistema() + " - SINDICATO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getUsuarioFc()
					.setTitle(AOP.getNomeSistema() + " - USUÁRIO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getUsuarioFp()
					.setTitle(AOP.getNomeSistema() + " - USUÁRIO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getVeiculoFc()
					.setTitle(AOP.getNomeSistema() + " - VEÍCULO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getVeiculoFp()
					.setTitle(AOP.getNomeSistema() + " - VEÍCULO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getVeiculoMarcaFc().setTitle(
					AOP.getNomeSistema() + " - MARCA DE VEÍCULO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getVeiculoMarcaFp().setTitle(
					AOP.getNomeSistema() + " - MARCA DE VEÍCULO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getVeiculoModeloFc().setTitle(
					AOP.getNomeSistema() + " - MODELO DE VEÍCULO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getVeiculoModeloFp().setTitle(
					AOP.getNomeSistema() + " - MODELO DE VEÍCULO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getCurriculoCaracteristicaFc()
					.setTitle(AOP.getNomeSistema() + " - CARACTERÍSTICA " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getCurriculoCaracteristicaFp()
					.setTitle(AOP.getNomeSistema() + " - CARACTERÍSTICA " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getCurriculoCertificadoFc()
					.setTitle(AOP.getNomeSistema() + " - CERTIFICADO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getCurriculoCertificadoFp()
					.setTitle(AOP.getNomeSistema() + " - CERTIFICADO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getCurriculoCursoFc()
					.setTitle(AOP.getNomeSistema() + " - CURSO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getCurriculoCursoFp()
					.setTitle(AOP.getNomeSistema() + " - CURSO " + Data.getData() + AOP.getUsuarioFormatado());
			MainCont.getCurriculoExperienciaProfissionalFc()
			.setTitle(AOP.getNomeSistema() + " - EXPERIÊNCIA PROFISSIONAL " + Data.getData() + AOP.getUsuarioFormatado());
	MainCont.getCurriculoExperienciaProfissionalFp()
			.setTitle(AOP.getNomeSistema() + " - EXPERIÊNCIA PROFISSIONAL " + Data.getData() + AOP.getUsuarioFormatado());
		}
	}

	private static BancoFc bancoFc;
	private static BancoFp bancoFp;
	private static CalculadoraFc calculadoraFc;
	private static CartorioFc cartorioFc;
	private static CartorioFp cartorioFp;
	private static CentroCustoFc centroCustoFc;
	private static CentroCustoFp centroCustoFp;
	private static ClienteFc clienteFc;
	private static ClienteFp clienteFp;
	private static ContadorFc contadorFc;
	private static ContadorFp contadorFp;
	private static ContatoFc contatoFc;
	private static ContatoFp contatoFp;
	private static CaracteristicaFc curriculoCaracteristicaFc;
	private static CaracteristicaFp curriculoCaracteristicaFp;
	private static CertificadoFc curriculoCertificadoFc;
	private static CertificadoFp curriculoCertificadoFp;
	private static ExperienciaProfissionalFc curriculoExperienciaProfissionalFc;
	private static ExperienciaProfissionalFp curriculoExperienciaProfissionalFp;
	private static CursoFc curriculoCursoFc;
	private static CursoFp curriculoCursoFp;
	/*
	 * private static HabilidadeFc curriculoHabilidadeFc; private static
	 * HabilidadeFp curriculoHabilidadeFp; private static IdiomaFc
	 * curriculoIdiomaFc; private static IdiomaFp curriculoIdiomaFp; private static
	 * ObjetivoProfissionalFc curriculoObjetivoProfissionalFc; private static
	 * ObjetivoProfissionalFp curriculoObjetivoProfissionalFp; private static
	 * TestePersonalidadeFc curriculoTestePersonalidadeFc; private static
	 * TestePersonalidadeFp curriculoTestePersonalidadeFp; private static
	 * TesteDiscFc curriculoTesteDiscFc; private static TesteDiscFp
	 * curriculoTesteDiscFp;
	 */
	private static EditorTextoFc editorTextoFc;
	private static EmpresaFc empresaFc;
	private static EmpresaFp empresaFp;
	private static EventoFc eventoFc;
	private static EventoFp eventoFp;
	private static FornecedorFc fornecedorFc;
	private static FornecedorFp fornecedorFp;
	private static FuncionarioFc funcionarioFc;
	private static FuncionarioFp funcionarioFp;
	private static ImovelFc imovelFc;
	private static ImovelFp imovelFp;
	private static LoginFc loginFc;
	private static MainCont mainCont;
	private static MainFc mainFc;
	private static RecadoFc recadoFc;
	private static RecadoFp recadoFp;
	private static SindicatoFc sindicatoFc;
	private static SindicatoFp sindicatoFp;
	private static TipoEventoFc tipoEventoFc;
	private static TipoEventoFp tipoEventoFp;
	private static int totalPrincipalCont;
	private static UsuarioFc usuarioFc;
	private static UsuarioFp usuarioFp;
	private static VeiculoFc veiculoFc;
	private static VeiculoFp veiculoFp;
	private static VeiculoMarcaFc veiculoMarcaFc;
	private static VeiculoMarcaFp veiculoMarcaFp;
	private static VeiculoModeloFc veiculoModeloFc;
	private static VeiculoModeloFp veiculoModeloFp;

	static {
		totalPrincipalCont = 0;
	}

	public static ContatoFc getAgendaContatoFc() {
		return contatoFc;
	}

	public static ContatoFp getAgendaContatoFp() {
		return contatoFp;
	}

	public static EventoFc getAgendaEventoFc() {
		return eventoFc;
	}

	public static EventoFp getAgendaEventoFp() {
		return eventoFp;
	}

	public static RecadoFc getAgendaRecadoFc() {
		return recadoFc;
	}

	public static RecadoFp getAgendaRecadoFp() {
		return recadoFp;
	}

	public static TipoEventoFc getAgendaTipoEventoFc() {
		return tipoEventoFc;
	}

	public static TipoEventoFp getAgendaTipoEventoFp() {
		return tipoEventoFp;
	}

	public static BancoFc getBancoFc() {
		return bancoFc;
	}

	public static BancoFp getBancoFp() {
		return bancoFp;
	}

	public static CalculadoraFc getCalculadoraFc() {
		return calculadoraFc;
	}

	public static CartorioFc getCartorioFc() {
		return cartorioFc;
	}

	public static CartorioFp getCartorioFp() {
		return cartorioFp;
	}

	public static CentroCustoFc getCentroCustoFc() {
		return centroCustoFc;
	}

	public static CentroCustoFp getCentroCustoFp() {
		return centroCustoFp;
	}

	public static ClienteFc getClienteFc() {
		return clienteFc;
	}

	public static ClienteFp getClienteFp() {
		return clienteFp;
	}

	public static ContadorFc getContadorFc() {
		return contadorFc;
	}

	public static ContadorFp getContadorFp() {
		return contadorFp;
	}

	public static CaracteristicaFc getCurriculoCaracteristicaFc() {
		return curriculoCaracteristicaFc;
	}

	public static CaracteristicaFp getCurriculoCaracteristicaFp() {
		return curriculoCaracteristicaFp;
	}

	public static CertificadoFc getCurriculoCertificadoFc() {
		return curriculoCertificadoFc;
	}

	public static CertificadoFp getCurriculoCertificadoFp() {
		return curriculoCertificadoFp;
	}

	public static CursoFc getCurriculoCursoFc() {
		return curriculoCursoFc;
	}

	public static CursoFp getCurriculoCursoFp() {
		return curriculoCursoFp;
	}
	
	public static ExperienciaProfissionalFc getCurriculoExperienciaProfissionalFc() {
		return curriculoExperienciaProfissionalFc;
	}

	public static ExperienciaProfissionalFp getCurriculoExperienciaProfissionalFp() {
		return curriculoExperienciaProfissionalFp;
	}

	public static EditorTextoFc getEditorTextoFc() {
		return editorTextoFc;
	}

	public static EmpresaFc getEmpresaFc() {
		return empresaFc;
	}

	public static EmpresaFp getEmpresaFp() {
		return empresaFp;
	}

	public static FornecedorFc getFornecedorFc() {
		return fornecedorFc;
	}

	public static FornecedorFp getFornecedorFp() {
		return fornecedorFp;
	}

	public static FuncionarioFc getFuncionarioFc() {
		return funcionarioFc;
	}

	public static FuncionarioFp getFuncionarioFp() {
		return funcionarioFp;
	}

	public static ImovelFc getImovelFc() {
		return imovelFc;
	}

	public static ImovelFp getImovelFp() {
		return imovelFp;
	}

	public static synchronized MainCont getInstance(MainFc mainFc) {
		if (totalPrincipalCont > 1) {
			JOptionPane.showMessageDialog(null, "Foi instanciado mais de uma Objeto:" + ERP.class);
			System.exit(0);
		}
		if (mainCont == null) {
			++totalPrincipalCont;
			return new MainCont(mainFc);
		}
		return mainCont;
	}

	public static LoginFc getLoginFc() {
		return loginFc;
	}

	public static MainFc getMainFc() {
		return mainFc;
	}

	public static SindicatoFc getSindicatoFc() {
		return sindicatoFc;
	}

	public static SindicatoFp getSindicatoFp() {
		return sindicatoFp;
	}

	public static UsuarioFc getUsuarioFc() {
		return usuarioFc;
	}

	public static UsuarioFp getUsuarioFp() {
		return usuarioFp;
	}

	public static VeiculoFc getVeiculoFc() {
		return veiculoFc;
	}

	public static VeiculoFp getVeiculoFp() {
		return veiculoFp;
	}

	public static VeiculoMarcaFc getVeiculoMarcaFc() {
		return veiculoMarcaFc;
	}

	public static VeiculoMarcaFp getVeiculoMarcaFp() {
		return veiculoMarcaFp;
	}

	public static VeiculoModeloFc getVeiculoModeloFc() {
		return veiculoModeloFc;
	}

	public static VeiculoModeloFp getVeiculoModeloFp() {
		return veiculoModeloFp;
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

		curriculoCertificadoFc = new CertificadoFc();
		criarFrame(curriculoCertificadoFc);

		curriculoCertificadoFp = new CertificadoFp();
		criarFrame(curriculoCertificadoFp);

		curriculoCursoFc = new CursoFc();
		criarFrame(curriculoCursoFc);

		curriculoCursoFp = new CursoFp();
		criarFrame(curriculoCursoFp);

		curriculoExperienciaProfissionalFc = new ExperienciaProfissionalFc();
		criarFrame(curriculoExperienciaProfissionalFc);

		curriculoExperienciaProfissionalFp = new ExperienciaProfissionalFp();
		criarFrame(curriculoExperienciaProfissionalFp);

		calculadoraFc = new CalculadoraFc();
		criarFrame(calculadoraFc);

		editorTextoFc = new EditorTextoFc();
		criarFrame(editorTextoFc);
	}
}
