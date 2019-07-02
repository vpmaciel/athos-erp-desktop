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

import arquitetura.Sis;
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
import erp.cartorio.CartorioFc;
import erp.cartorio.CartorioFp;
import erp.centrocusto.CentroCustoFc;
import erp.centrocusto.CentroCustoFp;
import erp.cliente.ClienteFc;
import erp.cliente.ClienteFp;
import erp.contador.ContadorFc;
import erp.contador.ContadorFp;
import erp.curriculo.CurriculoFc;
import erp.curriculo.CurriculoFp;
import erp.curriculo.certificado.CertificadoFc;
import erp.curriculo.certificado.CertificadoFp;
import erp.curriculo.curso.CursoFc;
import erp.curriculo.curso.CursoFp;
import erp.curriculo.experienciaprofissional.ExperienciaProfissionalFc;
import erp.curriculo.experienciaprofissional.ExperienciaProfissionalFp;
import erp.curriculo.habilidade.HabilidadeFc;
import erp.curriculo.habilidade.HabilidadeFp;
import erp.curriculo.idioma.IdiomaFc;
import erp.curriculo.idioma.IdiomaFp;
import erp.curriculo.objetivoprofissional.ObjetivoProfissionalFc;
import erp.curriculo.objetivoprofissional.ObjetivoProfissionalFp;
import erp.curriculo.teste.avaliacaodepreferenciacerebral.TesteAvalPrefCerFc;
import erp.curriculo.teste.avaliacaodepreferenciacerebral.TesteAvalPrefCerFp;
import erp.curriculo.teste.perfilcomportmental.TestePerfilCompFc;
import erp.curriculo.teste.perfilcomportmental.TestePerfilCompFp;
import erp.curriculo.teste.testedisc.TesteDISCFc;
import erp.curriculo.teste.testedisc.TesteDISCFp;
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
import erp.utilitarios.calculadora.CalculadoraFc;
import erp.utilitarios.editor.EditorTextoFc;
import erp.utilitarios.imc.ImcFc;
import erp.veiculo.VeiculoFc;
import erp.veiculo.VeiculoFp;
import erp.veiculo.documento.DocumentoFc;
import erp.veiculo.documento.DocumentoFp;
import erp.veiculo.marca.VeiculoMarcaFc;
import erp.veiculo.marca.VeiculoMarcaFp;
import erp.veiculo.modelo.VeiculoModeloFc;
import erp.veiculo.modelo.VeiculoModeloFp;

public final class MainControl {

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
			MainControl.mostrarFrame(loginFc);
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
				Sis.setUsuario(null);
				Msg.avisoUsuarioNaoLogado();
			} else if (actionEvent.getSource() == mainFc.getMenuItemArquivoReiniciar()) {
				@SuppressWarnings("rawtypes")
				Class cls = ErpMain.class;
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
			if (Sis.getUsuario() == null) {
				Msg.avisoUsuarioNaoLogado();
				return;
			}

		}
	}

	public class MenuCadastroGerenteEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (Sis.getUsuario() == null) {
				Msg.avisoUsuarioNaoLogado();
				return;
			}
			if (actionEvent.getSource() == mainFc.getMenuItemCadastroCentroCusto()) {
				mostrarFrame(centroCustoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroBanco()) {
				mostrarFrame(bancoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroCartorio()) {
				mostrarFrame(cartorioFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemRhFuncionario()) {
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
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroVeiculoDocumento()) {
				mostrarFrame(veiculoDocumentoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroImovel()) {
				mostrarFrame(imovelFc);
			}
		}
	}
	
	public class MenuRhGerenteEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (Sis.getUsuario() == null) {
				Msg.avisoUsuarioNaoLogado();
				return;
			}
			if (actionEvent.getSource() == mainFc.getMenuItemCadastroRhCurriculo()) {
				mostrarFrame(curriculoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroRhCertificado()) {
				mostrarFrame(curriculoCertificadoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroRhCurso()) {
				mostrarFrame(curriculoCursoFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroRhExperienciaProfissional()) {
				mostrarFrame(curriculoExperienciaProfissionalFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroRhHabilidade()) {
				mostrarFrame(curriculoHabilidadeFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroRhIdioma()) {
				mostrarFrame(curriculoIdiomaFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroRhObjetivoProfissional()) {
				mostrarFrame(curriculoObjetivoProfissionalFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroRhTestePersonalidadeA()) {
				mostrarFrame(curriculoTesteAvalPrefCerFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroRhTestePersonalidadeB()) {
				mostrarFrame(curriculoTestePerfilCompFc);
			} else if (actionEvent.getSource() == mainFc.getMenuItemCadastroRhTestePersonalidadeC()) {
				mostrarFrame(curriculoTesteDISCFc);
			}
		}
	}

	public class MenuSistemaGerenteEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (Sis.getUsuario() == null) {
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
			if (Sis.getUsuario() == null) {
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
			if (actionEvent.getSource() == mainFc.getMenuItemUtilitarioCalculoImc()) {
				mostrarFrame(imcFc);
			}
		}
	}

	public class Relogio implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainControl.getAgendaContatoFc().setTitle(
					Sis.getNomeSistema() + " - CONTATO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getAgendaContatoFp().setTitle(
					Sis.getNomeSistema() + " - CONTATO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getAgendaEventoFc().setTitle(
					Sis.getNomeSistema() + " - EVENTO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getAgendaEventoFp().setTitle(
					Sis.getNomeSistema() + " - EVENTO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getAgendaTipoEventoFc().setTitle(Sis.getNomeSistema() + " - TIPO DE EVENTO "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getAgendaTipoEventoFp().setTitle(Sis.getNomeSistema() + " - TIPO DE EVENTO "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getAgendaRecadoFc().setTitle(
					Sis.getNomeSistema() + " - RECADO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getAgendaRecadoFp().setTitle(
					Sis.getNomeSistema() + " - RECADO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getBancoFc().setTitle(
					Sis.getNomeSistema() + " - BANCO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getBancoFp().setTitle(
					Sis.getNomeSistema() + " - BANCO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getImcFc().setTitle(
					Sis.getNomeSistema() + " - CÁLCULO IMC " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCalculadoraFc().setTitle(
					Sis.getNomeSistema() + " - CALCULADORA " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCartorioFc().setTitle(
					Sis.getNomeSistema() + " - CARTÓRIO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCartorioFp().setTitle(
					Sis.getNomeSistema() + " - CARTÓRIO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCentroCustoFc().setTitle(Sis.getNomeSistema() + " - CENTRO DE CUSTO "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCentroCustoFp().setTitle(Sis.getNomeSistema() + " - CENTRO DE CUSTO "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getClienteFc().setTitle(
					Sis.getNomeSistema() + " - CLIENTE " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getClienteFp().setTitle(
					Sis.getNomeSistema() + " - CLIENTE " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getContadorFc().setTitle(
					Sis.getNomeSistema() + " - CONTADOR " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getContadorFp().setTitle(
					Sis.getNomeSistema() + " - CONTADOR " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getEditorTextoFc().setTitle(Sis.getNomeSistema() + " - EDITOR DE TEXTO "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getEmpresaFc().setTitle(
					Sis.getNomeSistema() + " - EMPRESA " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getEmpresaFp().setTitle(
					Sis.getNomeSistema() + " - EMPRESA " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getFornecedorFc().setTitle(
					Sis.getNomeSistema() + " - FORNECEDOR " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getFornecedorFp().setTitle(
					Sis.getNomeSistema() + " - FORNECEDOR " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoFc().setTitle(
					Sis.getNomeSistema() + " - FUNCIONÁRIO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoFp().setTitle(
					Sis.getNomeSistema() + " - FUNCIONÁRIO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getImovelFc().setTitle(
					Sis.getNomeSistema() + " - IMÓVEL " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getImovelFp().setTitle(
					Sis.getNomeSistema() + " - IMÓVEL " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getLoginFc().setTitle(
					Sis.getNomeSistema() + " - LOGIN " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getMainFc().setTitle(
					Sis.getNomeSistema() + " - PRINCIPAL " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getSindicatoFc().setTitle(
					Sis.getNomeSistema() + " - SINDICATO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getSindicatoFp().setTitle(
					Sis.getNomeSistema() + " - SINDICATO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getUsuarioFc().setTitle(
					Sis.getNomeSistema() + " - USUÁRIO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getUsuarioFp().setTitle(
					Sis.getNomeSistema() + " - USUÁRIO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getVeiculoFc().setTitle(
					Sis.getNomeSistema() + " - VEÍCULO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getVeiculoFp().setTitle(
					Sis.getNomeSistema() + " - VEÍCULO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getVeiculoMarcaFc().setTitle(Sis.getNomeSistema() + " - MARCA DE VEÍCULO "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getVeiculoMarcaFp().setTitle(Sis.getNomeSistema() + " - MARCA DE VEÍCULO "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getVeiculoModeloFc().setTitle(Sis.getNomeSistema() + " - MODELO DE VEÍCULO "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getVeiculoModeloFp().setTitle(Sis.getNomeSistema() + " - MODELO DE VEÍCULO "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getVeiculoDocumentoFc().setTitle(Sis.getNomeSistema() + " - DOCUMENTO DE VEÍCULO "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getVeiculoDocumentoFp().setTitle(Sis.getNomeSistema() + " - DOCUMENTO DE VEÍCULO "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoFc().setTitle(
					Sis.getNomeSistema() + " - CURRÍCULO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoFp().setTitle(
					Sis.getNomeSistema() + " - CURRÍCULO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoCertificadoFc().setTitle(
					Sis.getNomeSistema() + " - CERTIFICADO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoCertificadoFp().setTitle(
					Sis.getNomeSistema() + " - CERTIFICADO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoCursoFc().setTitle(
					Sis.getNomeSistema() + " - CURSO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoCursoFp().setTitle(
					Sis.getNomeSistema() + " - CURSO " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoExperienciaProfissionalFc().setTitle(Sis.getNomeSistema()
					+ " - EXPERIÊNCIA PROFISSIONAL " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoExperienciaProfissionalFp().setTitle(Sis.getNomeSistema()
					+ " - EXPERIÊNCIA PROFISSIONAL " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoHabilidadeFc().setTitle(
					Sis.getNomeSistema() + " - HABILIDADE " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoHabilidadeFp().setTitle(
					Sis.getNomeSistema() + " - HABILIDADE " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoIdiomaFc().setTitle(
					Sis.getNomeSistema() + " - IDIOMA " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoIdiomaFp().setTitle(
					Sis.getNomeSistema() + " - IDIOMA " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoObjetivoProfissionalFc().setTitle(Sis.getNomeSistema() + " - OBJETIVO PROFISSIONAL "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoObjetivoProfissionalFp().setTitle(Sis.getNomeSistema() + " - OBJETIVO PROFISSIONAL "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoTesteAvalPrefCerFc().setTitle(Sis.getNomeSistema()
					+ " - TESTE DE PREFERÊNCIA CEREBRAL " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoTesteAvalPrefCerFp().setTitle(Sis.getNomeSistema()
					+ " - TESTE DE PREFERÊNCIA CEREBRAL " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoTestePerfilCompFc().setTitle(Sis.getNomeSistema()
					+ " - TESTE DE PERFIL COMPORTAMENTAL " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoTestePerfilCompFp().setTitle(Sis.getNomeSistema()
					+ " - TESTE DE PERFIL COMPORTAMENTAL " + Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoTesteDISCFc().setTitle(Sis.getNomeSistema() + " - TESTE DE PERSONALIDADE D.I.S.C. "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
			MainControl.getCurriculoTesteDISCFp().setTitle(Sis.getNomeSistema() + " - TESTE DE PERSONALIDADE D.I.S.C. "
					+ Data.getDataHoraSimples() + Sis.getUsuarioFormatado());
		}
	}

	private static BancoFc bancoFc;
	private static BancoFp bancoFp;
	private static ImcFc imcFc;
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
	private static TesteAvalPrefCerFc curriculoTesteAvalPrefCerFc;
	private static TesteAvalPrefCerFp curriculoTesteAvalPrefCerFp;
	private static TestePerfilCompFc curriculoTestePerfilCompFc;
	private static TestePerfilCompFp curriculoTestePerfilCompFp;
	private static TesteDISCFc curriculoTesteDISCFc;
	private static TesteDISCFp curriculoTesteDISCFp;
	private static EditorTextoFc editorTextoFc;
	private static EmpresaFc empresaFc;
	private static EmpresaFp empresaFp;
	private static EventoFc eventoFc;
	private static EventoFp eventoFp;
	private static FornecedorFc fornecedorFc;
	private static FornecedorFp fornecedorFp;
	private static FuncionarioFc funcionarioFc;
	private static FuncionarioFp funcionarioFp;
	private static CurriculoFc curriculoFc;
	private static CurriculoFp curriculoFp;
	private static ImovelFc imovelFc;
	private static ImovelFp imovelFp;
	private static LoginFc loginFc;
	private static MainControl mainControl;
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
	private static DocumentoFc veiculoDocumentoFc;
	private static DocumentoFp veiculoDocumentoFp;

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
	
	public static ImcFc getImcFc() {
		return imcFc;
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

	public static HabilidadeFc getCurriculoHabilidadeFc() {
		return curriculoHabilidadeFc;
	}

	public static HabilidadeFp getCurriculoHabilidadeFp() {
		return curriculoHabilidadeFp;
	}

	public static IdiomaFc getCurriculoIdiomaFc() {
		return curriculoIdiomaFc;
	}

	public static IdiomaFp getCurriculoIdiomaFp() {
		return curriculoIdiomaFp;
	}

	public static ObjetivoProfissionalFc getCurriculoObjetivoProfissionalFc() {
		return curriculoObjetivoProfissionalFc;
	}

	public static ObjetivoProfissionalFp getCurriculoObjetivoProfissionalFp() {
		return curriculoObjetivoProfissionalFp;
	}

	public static TesteAvalPrefCerFc getCurriculoTesteAvalPrefCerFc() {
		return curriculoTesteAvalPrefCerFc;
	}

	public static TesteAvalPrefCerFp getCurriculoTesteAvalPrefCerFp() {
		return curriculoTesteAvalPrefCerFp;
	}

	public static TestePerfilCompFc getCurriculoTestePerfilCompFc() {
		return curriculoTestePerfilCompFc;
	}

	public static TestePerfilCompFp getCurriculoTestePerfilCompFp() {
		return curriculoTestePerfilCompFp;
	}

	public static TesteDISCFc getCurriculoTesteDISCFc() {
		return curriculoTesteDISCFc;
	}

	public static TesteDISCFp getCurriculoTesteDISCFp() {
		return curriculoTesteDISCFp;
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

	public static CurriculoFc getCurriculoFc() {
		return curriculoFc;
	}

	public static CurriculoFp getCurriculoFp() {
		return curriculoFp;
	}

	public static ImovelFc getImovelFc() {
		return imovelFc;
	}

	public static ImovelFp getImovelFp() {
		return imovelFp;
	}

	public static synchronized MainControl getInstance(MainFc mainFc) {
		if (totalPrincipalCont > 1) {
			JOptionPane.showMessageDialog(null, "Foi instanciado mais de uma Objeto:" + ErpMain.class);
			System.exit(0);
		}
		if (mainControl == null) {
			++totalPrincipalCont;
			return new MainControl(mainFc);
		}
		return mainControl;
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

	public static DocumentoFc getVeiculoDocumentoFc() {
		return veiculoDocumentoFc;
	}

	public static DocumentoFp getVeiculoDocumentoFp() {
		return veiculoDocumentoFp;
	}

	public static void mostrarFrame(JFrame frame) {
		frame.setVisible(true);
		frame.setResizable(false);
		frame.toFront();
		frame.repaint();
		frame.setState(java.awt.Frame.NORMAL);
		frame.setLocationRelativeTo(null);
	}

	private MainControl(MainFc mainFc) {
		MainControl.mainFc = mainFc;
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

		curriculoFc = new CurriculoFc();
		criarFrame(curriculoFc);

		curriculoFp = new CurriculoFp();
		criarFrame(curriculoFp);

		sindicatoFc = new SindicatoFc();
		criarFrame(sindicatoFc);

		sindicatoFp = new SindicatoFp();
		criarFrame(sindicatoFp);

		fornecedorFc = new FornecedorFc();
		criarFrame(fornecedorFc);

		fornecedorFp = new FornecedorFp();
		criarFrame(fornecedorFp);

		funcionarioFc = new FuncionarioFc();
		criarFrame(funcionarioFc);

		funcionarioFp = new FuncionarioFp();
		criarFrame(funcionarioFp);

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

		veiculoDocumentoFc = new DocumentoFc();
		criarFrame(veiculoDocumentoFc);

		veiculoDocumentoFp = new DocumentoFp();
		criarFrame(veiculoDocumentoFp);

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

		curriculoHabilidadeFc = new HabilidadeFc();
		criarFrame(curriculoHabilidadeFc);

		curriculoHabilidadeFp = new HabilidadeFp();
		criarFrame(curriculoHabilidadeFp);

		curriculoIdiomaFc = new IdiomaFc();
		criarFrame(curriculoIdiomaFc);

		curriculoIdiomaFp = new IdiomaFp();
		criarFrame(curriculoIdiomaFp);

		curriculoObjetivoProfissionalFc = new ObjetivoProfissionalFc();
		criarFrame(curriculoObjetivoProfissionalFc);

		curriculoObjetivoProfissionalFp = new ObjetivoProfissionalFp();
		criarFrame(curriculoObjetivoProfissionalFp);

		curriculoTesteAvalPrefCerFc = new TesteAvalPrefCerFc();
		criarFrame(curriculoTesteAvalPrefCerFc);

		curriculoTesteAvalPrefCerFp = new TesteAvalPrefCerFp();
		criarFrame(curriculoTesteAvalPrefCerFp);

		curriculoTestePerfilCompFc = new TestePerfilCompFc();
		criarFrame(curriculoTestePerfilCompFc);

		curriculoTestePerfilCompFp = new TestePerfilCompFp();
		criarFrame(curriculoTestePerfilCompFp);

		curriculoTesteDISCFc = new TesteDISCFc();
		criarFrame(curriculoTesteDISCFc);

		curriculoTesteDISCFp = new TesteDISCFp();
		criarFrame(curriculoTesteDISCFp);

		calculadoraFc = new CalculadoraFc();
		criarFrame(calculadoraFc);
		
		imcFc = new ImcFc();
		criarFrame(imcFc);

		editorTextoFc = new EditorTextoFc();
		criarFrame(editorTextoFc);
	}
}
