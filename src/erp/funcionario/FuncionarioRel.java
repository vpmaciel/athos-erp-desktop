package erp.funcionario;

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

public class FuncionarioRel {

	private String arquivo = Data.getHora() + "-funcionario.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "FUNCIONÁRIOS";
	private PdfWriter writer = null;

	public FuncionarioRel(List<Funcionario> funcionarios) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Funcionario funcionario : funcionarios) {
				document.newPage();
				document.add(new Paragraph("NOME: " + funcionario.getNome()));
				document.add(new Paragraph("SEXO: " + funcionario.getSexo()));
				document.add(new Paragraph("MATRÍCULA: " + funcionario.getMatricula()));
				document.add(new Paragraph("RG NÚMERO: " + funcionario.getRgNumero()));
				document.add(new Paragraph("RG ÓRGÃO EMISSSOR: " + funcionario.getRgOrgaoEmissor()));
				document.add(new Paragraph("CNPJ: " + funcionario.getCnpj()));
				document.add(new Paragraph("CPF: " + funcionario.getCpf()));
				document.add(new Paragraph("PIS: " + funcionario.getPis()));
				document.add(new Paragraph("CTPS: " + funcionario.getCtpsNumero()));
				document.add(new Paragraph("CNH: " + funcionario.getCnhCategoria()));
				document.add(new Paragraph("ESCOLARIDADE: " + funcionario.getEscolaridade()));
				document.add(new Paragraph("DEFICIÊNCIA: " + funcionario.getDeficiencia()));
				document.add(new Paragraph("NACIONALIDADE: " + funcionario.getNacionalidade()));
				document.add(new Paragraph("CARGO: " + funcionario.getCargo()));
				document.add(new Paragraph("SALÁRIO: " + funcionario.getSalario()));
				document.add(new Paragraph("CATEGORIA: " + funcionario.getCategoria()));
				document.add(new Paragraph("CENTRO DE CUSTO: " + funcionario.getCentroCusto()));
				document.add(new Paragraph("DEPARTAMENTO: " + funcionario.getDepartamento()));
				document.add(new Paragraph("EMPRESA: " + funcionario.getEmpresa()));
				document.add(new Paragraph("GERENTE: " + funcionario.getGerente()));
				document.add(new Paragraph("TURNO: " + funcionario.getTurno()));
				document.add(new Paragraph("ESTADO CIVIL: " + funcionario.getEnderecoEstadoCivil()));
				document.add(new Paragraph("CÔNJUGE: " + funcionario.getConjuge()));
				document.add(new Paragraph("FILHOS: " + funcionario.getFilhos()));
				document.add(new Paragraph("FAX: " + funcionario.getFax()));
				document.add(new Paragraph("FONE: " + funcionario.getFone1()));
				document.add(new Paragraph("FONE: " + funcionario.getFone2()));
				document.add(new Paragraph("E-MAIL: " + funcionario.getEmail()));
				document.add(new Paragraph("PAÍS: " + funcionario.getEnderecoPais()));
				document.add(new Paragraph("ESTADO: " + funcionario.getEnderecoEstado()));
				document.add(new Paragraph("CIDADE: " + funcionario.getEnderecoCidade()));
				document.add(new Paragraph("BAIRRO: " + funcionario.getEnderecoBairro()));
				document.add(new Paragraph("LOGRADOURO: " + funcionario.getEnderecoLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + funcionario.getEnderecoComplemento()));
				document.add(new Paragraph("CEP: " + funcionario.getEnderecoCep()));
				document.add(new Paragraph("\n"));
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
