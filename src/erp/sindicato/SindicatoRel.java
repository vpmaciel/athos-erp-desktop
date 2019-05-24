package erp.sindicato;

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

public class SindicatoRel {

	private String arquivo = Data.getTempo() +"-sindicato.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "SINDICATOS";
	private PdfWriter writer = null;

	public SindicatoRel(List<Sindicato> sindicatos) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Sindicato sindicato : SindicatoFac.getRegistro()) {
				document.newPage();
				document.add(new Paragraph("NOME FANTASIA: " + sindicato.getNomeFantasia()));
				document.add(new Paragraph("RAMO DE ATIVIDADE: " + sindicato.getRamoAtividade()));
				document.add(new Paragraph("TIPO DE EMPRESA: " + sindicato.getTipoSindicato()));
				document.add(new Paragraph("FATURAMENTO MENSAL: " + sindicato.getFaturamentoMensal()));
				document.add(new Paragraph("CNPJ: " + sindicato.getCnpj()));
				document.add(new Paragraph("NÚMERO DE FUNCIONÁRIOS: " + sindicato.getNumeroFuncionarios()));
				document.add(new Paragraph("INSCRIÇÃO ESTADUAL: " + sindicato.getInscricaoEstadual()));
				document.add(new Paragraph("DATA DE FUNDAÇÃO: " + sindicato.getDataFundacao()));
				document.add(new Paragraph("INSCRIÇÃO MUNICIPAL: " + sindicato.getInscricaoMunicipal()));
				document.add(new Paragraph("CAPITAL SOCIAL: " + sindicato.getCapitalSocial()));
				document.add(new Paragraph("RAZÃO SOCIAL: " + sindicato.getRazaoSocial()));
				document.add(new Paragraph("FAX: " + sindicato.getFax()));
				document.add(new Paragraph("TELEFONE: " + sindicato.getFone1()));
				document.add(new Paragraph("TELEFONE: " + sindicato.getFone2()));
				document.add(new Paragraph("E-MAIL: " + sindicato.getEmail()));
				document.add(new Paragraph("PAÍS: " + sindicato.getPais()));
				document.add(new Paragraph("ESTADO: " + sindicato.getEstado()));
				document.add(new Paragraph("CIDADE: " + sindicato.getCidade()));
				document.add(new Paragraph("BAIRRO: " + sindicato.getBairro()));
				document.add(new Paragraph("LOGRADOURO: " + sindicato.getLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + sindicato.getComplemento()));
				document.add(new Paragraph("CEP: " + sindicato.getCep()));
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
