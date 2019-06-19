package erp.curriculo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.data.Data;
import arquitetura.relatorio.Relatorio;
import erp.curriculo.certificado.Certificado;
import erp.curriculo.certificado.CertificadoFac;
import erp.curriculo.curso.Curso;
import erp.curriculo.curso.CursoFac;
import erp.curriculo.experienciaprofissional.ExperienciaProfissional;
import erp.curriculo.experienciaprofissional.ExperienciaProfissionalFac;
import erp.curriculo.habilidade.Habilidade;
import erp.curriculo.habilidade.HabilidadeFac;
import erp.curriculo.idioma.Idioma;
import erp.curriculo.idioma.IdiomaFac;
import erp.curriculo.objetivoprofissional.ObjetivoProfissional;
import erp.curriculo.objetivoprofissional.ObjetivoProfissionalFac;
import erp.curriculo.teste.avaliacaodepreferenciacerebral.TesteAvalPrefCer;
import erp.curriculo.teste.avaliacaodepreferenciacerebral.TesteAvalPrefCerFac;
import erp.curriculo.teste.perfilcomportmental.TestePerfilComp;
import erp.curriculo.teste.perfilcomportmental.TestePerfilCompFac;
import erp.curriculo.teste.testedisc.TesteDISC;
import erp.curriculo.teste.testedisc.TesteDISCFac;
import erp.funcionario.Funcionario;

public class CurriculoRel {

	private String arquivo = Data.getHora() + "-curriculo.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "CURRÍCULO";
	private PdfWriter writer = null;

	public CurriculoRel(List<Funcionario> funcionarioList) {

		Funcionario funcionario = funcionarioList.get(0);

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			document.add(new Paragraph("DADOS PESSOAIS"));
			document.add(new Paragraph(""));
			document.add(new Paragraph("NOME: " + funcionario.getNome()));
			document.add(new Paragraph("SEXO: " + funcionario.getSexo()));
			document.add(new Paragraph("CPF: " + funcionario.getCpf()));
			document.add(new Paragraph("CNPJ: " + funcionario.getCnpj()));
			document.add(new Paragraph("TELEFONE: " + funcionario.getFone1()));
			document.add(new Paragraph("TELEFONE: " + funcionario.getFone2()));
			document.add(new Paragraph("FAX: " + funcionario.getFax()));
			document.add(new Paragraph("E-MAIL: " + funcionario.getEmail()));
			document.add(new Paragraph("BAIRRO: " + funcionario.getEnderecoBairro()));
			document.add(new Paragraph("CIDADE: " + funcionario.getEnderecoCidade()));
			document.add(new Paragraph("ESTADO: " + funcionario.getEnderecoEstado()));
			document.add(new Paragraph("ESCOLARIDADE: " + funcionario.getEscolaridade()));
			document.add(new Paragraph("CNH: " + funcionario.getCnhCategoria()));
			document.add(new Paragraph(""));

			document.add(new Paragraph("CETIFICADO"));
			document.add(new Paragraph(""));

			for (Certificado certificado : CertificadoFac.getRegistro()) {
				if (certificado.getFuncionario().getId() == funcionario.getId()) {
					document.add(new Paragraph("INSTITUIÇÃO: " + certificado.getInstituicao()));
					document.add(new Paragraph("CURSO: " + certificado.getCurso()));
					document.add(new Paragraph("ANO DE CONCLUSÃO: " + certificado.getAnoConclusao()));
					document.add(new Paragraph("CARGA HORÁRIA: " + certificado.getCargaHoraria()));
					document.add(new Paragraph(""));
				}
			}

			document.add(new Paragraph("CURSO"));
			document.add(new Paragraph(""));

			for (Curso curso : CursoFac.getRegistro()) {
				if (curso.getFuncionario().getId() == funcionario.getId()) {
					document.add(new Paragraph("INSTITUIÇÃO: " + curso.getInstituicao()));
					document.add(new Paragraph("CURSO: " + curso.getCurso()));
					document.add(new Paragraph("MODALIDADE: " + curso.getModalidade()));
					document.add(new Paragraph("NÍVEL: " + curso.getNivel()));
					document.add(new Paragraph("SITUAÇÃO: " + curso.getSituacao()));
					document.add(new Paragraph("ANO DE INÍCIO: " + curso.getAnoInicio()));
					document.add(new Paragraph("ANO DE CONCLUSÃO: " + curso.getAnoConclusao()));
					document.add(new Paragraph(""));
				}
			}

			document.add(new Paragraph("EXPERIÊNCIA PROFISSIONAL"));
			document.add(new Paragraph(""));

			for (ExperienciaProfissional experienciaProfissional : ExperienciaProfissionalFac.getRegistro()) {
				if (experienciaProfissional.getFuncionario().getId() == funcionario.getId()) {
					document.add(new Paragraph("EMPRESA: " + experienciaProfissional.getEmpresa()));
					document.add(new Paragraph("CARGO: " + experienciaProfissional.getCargo()));
					document.add(new Paragraph("NÍVEL HIERÁRQUICO: " + experienciaProfissional.getNivelHierarquico()));
					document.add(new Paragraph("DATA ADMISSÃO: " + experienciaProfissional.getDataAdmissao()));
					document.add(new Paragraph("DATA SAÍDA: " + experienciaProfissional.getDataSaida()));
					document.add(new Paragraph("FUNÇÕES: " + experienciaProfissional.getFuncoes()));
					document.add(new Paragraph(""));
				}
			}

			document.add(new Paragraph("HABILIDADE"));
			document.add(new Paragraph(""));

			for (Habilidade habilidade : HabilidadeFac.getRegistro()) {
				if (habilidade.getFuncionario().getId() == funcionario.getId()) {
					document.add(new Paragraph("CONHECIMENTO: " + habilidade.getConhecimento()));
					document.add(new Paragraph("NÍVEL DE CONHECIMENTO: " + habilidade.getNivelConhecimento()));
					document.add(new Paragraph(""));
				}
			}

			document.add(new Paragraph("IDIOMA"));
			document.add(new Paragraph(""));

			for (Idioma idioma : IdiomaFac.getRegistro()) {
				if (idioma.getFuncionario().getId() == funcionario.getId()) {
					document.add(new Paragraph("CONHECIMENTO: " + idioma.getConhecimento()));
					document.add(new Paragraph("NÍVEL DE CONHECIMENTO: " + idioma.getNivelConhecimento()));
					document.add(new Paragraph(""));
				}
			}

			document.add(new Paragraph("OBJETIVO PROFISSIONAL"));
			document.add(new Paragraph(""));

			for (ObjetivoProfissional objetivoProfissional : ObjetivoProfissionalFac.getRegistro()) {
				if (objetivoProfissional.getFuncionario().getId() == funcionario.getId()) {
					document.add(new Paragraph("ÁREA DE INTERESSE: " + objetivoProfissional.getAreaInteresse()));
					document.add(new Paragraph("NÍVEL HIERÁRQUICO: " + objetivoProfissional.getNivelHierarquico()));
					document.add(new Paragraph("PRETENSÃO SALARIAL: " + objetivoProfissional.getPretensaoSalarial()));
					document.add(new Paragraph("CARGO: " + objetivoProfissional.getCargo()));
					document.add(new Paragraph("CONTRATO: " + objetivoProfissional.getContrato()));
					document.add(new Paragraph(""));
				}
			}

			document.add(new Paragraph("TESTE DE AVALIAÇÃO DE PREFERÊNCIA CEREBRAL"));
			document.add(new Paragraph(""));

			for (TesteAvalPrefCer testeAvalPrefCer : TesteAvalPrefCerFac.getRegistro()) {
				if (testeAvalPrefCer.getFuncionario().getId() == funcionario.getId()) {
					document.add(new Paragraph("ÁGUIA: " + testeAvalPrefCer.getTotalOpcaoI() + "%"));
					document.add(new Paragraph("GATO: " + testeAvalPrefCer.getTotalOpcaoC() + "%"));
					document.add(new Paragraph("TUBARÃO: " + testeAvalPrefCer.getTotalOpcaoA() + "%"));
					document.add(new Paragraph("LOBO: " + testeAvalPrefCer.getTotalOpcaoO() + "%"));
					document.add(new Paragraph(""));
				}
			}

			document.add(new Paragraph("TESTE DE PERFIL COMPORTAMENTAL"));
			document.add(new Paragraph(""));

			for (TestePerfilComp testePerfilComp : TestePerfilCompFac.getRegistro()) {
				if (testePerfilComp.getFuncionario().getId() == funcionario.getId()) {
					document.add(new Paragraph("INFLUENTE: " + testePerfilComp.getTotalOpcaoA()));
					document.add(new Paragraph("GUERREIRO: " + testePerfilComp.getTotalOpcaoB()));
					document.add(new Paragraph("PERFECCIONISTA: " + testePerfilComp.getTotalOpcaoC()));
					document.add(new Paragraph("HARMONIOSO: " + testePerfilComp.getTotalOpcaoD()));
					document.add(new Paragraph(""));
				}
			}

			document.add(new Paragraph("TESTE D.I.S.C."));
			document.add(new Paragraph(""));

			for (TesteDISC testeDISC : TesteDISCFac.getRegistro()) {
				if (testeDISC.getFuncionario().getId() == funcionario.getId()) {
					document.add(new Paragraph("DOMINÂNCIA: " + testeDISC.getTotalOpcaoD()));
					document.add(new Paragraph("INFLUÊNCIA: " + testeDISC.getTotalOpcaoI()));
					document.add(new Paragraph("ESTABILIDADE: " + testeDISC.getTotalOpcaoS()));
					document.add(new Paragraph("CONFORMIDADE: " + testeDISC.getTotalOpcaoC()));
					document.add(new Paragraph(""));
				}
			}

		} catch (DocumentException | FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		relatorio.getRodape(writer, document);
		document.close();
		relatorio.retornarRelatorio(arquivo, false);
	}

	public File retornarRelatorio(boolean abrirArquivo) {
		return relatorio.retornarRelatorio(arquivo, abrirArquivo);
	}
}
