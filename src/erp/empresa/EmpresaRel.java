package erp.empresa;

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

public class EmpresaRel {

	private String arquivo = Data.getTempo() +"-empresa.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "EMPRESAS";
	private PdfWriter writer = null;

	public EmpresaRel(List<Empresa> empresas) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Empresa empresa : empresas) {
				document.newPage();
				document.add(new Paragraph("NOME FANTASIA: " + empresa.getNomeFantasia()));
				document.add(new Paragraph("RAMO DE ATIVIDADE: " + empresa.getRamoAtividade()));
				document.add(new Paragraph("TIPO DE EMPRESA: " + empresa.getTipoEmpresa()));
				document.add(new Paragraph("FATURAMENTO MENSAL: " + empresa.getFaturamentoMensal()));
				document.add(new Paragraph("CNPJ: " + empresa.getCnpj()));
				document.add(new Paragraph("NÚMERO DE FUNCIONÁRIOS: " + empresa.getNumeroFuncionarios()));
				document.add(new Paragraph("INSCRIÇÃO ESTADUAL: " + empresa.getInscricaoEstadual()));
				document.add(new Paragraph("DATA DE FUNDAÇÃO: " + empresa.getDataFundacao()));
				document.add(new Paragraph("INSCRIÇÃO MUNICIPAL: " + empresa.getInscricaoMunicipal()));
				document.add(new Paragraph("CAPITAL SOCIAL: " + empresa.getCapitalSocial()));
				document.add(new Paragraph("RAZÃO SOCIAL: " + empresa.getRazaoSocial()));
				document.add(new Paragraph("FAX: " + empresa.getFax()));
				document.add(new Paragraph("TELEFONE: " + empresa.getFone1()));
				document.add(new Paragraph("TELEFONE: " + empresa.getFone2()));
				document.add(new Paragraph("E-MAIL: " + empresa.getEmail()));
				document.add(new Paragraph("PAÍS: " + empresa.getPais()));
				document.add(new Paragraph("ESTADO: " + empresa.getEstado()));
				document.add(new Paragraph("CIDADE: " + empresa.getCidade()));
				document.add(new Paragraph("BAIRRO: " + empresa.getBairro()));
				document.add(new Paragraph("LOGRADOURO: " + empresa.getLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + empresa.getComplemento()));
				document.add(new Paragraph("CEP: " + empresa.getCep()));
			}
		} catch (DocumentException | FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		relatorio.getRodape(writer, document);
		document.close();
		relatorio.retornarRelatorio(arquivo, false);
	}

	public File retornarRelatorio(boolean abrirRelatorio) {
		return relatorio.retornarRelatorio(arquivo, abrirRelatorio);
	}
}
