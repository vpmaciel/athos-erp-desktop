package erp.agenda.compromisso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import erp.aop.relatorio.Relatorio;

public class CompromissoRelatorio {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "compromisso.pdf";
	private String titulo = "COMPROMISSOS";
	private Relatorio relatorio = new Relatorio();

	public CompromissoRelatorio(List<Compromisso> compromissos) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Compromisso compromisso : compromissos) {
				document.newPage();
				document.add(new Paragraph("NOME: " + compromisso.getNome()));
				document.add(new Paragraph("SEXO: " + compromisso.getSexo()));
				document.add(new Paragraph("CNPJ: " + compromisso.getCnpj()));
				document.add(new Paragraph("CPF: " + compromisso.getCpfNumero()));
				document.add(new Paragraph("SALÁRIO: " + compromisso.getSalario()));
				document.add(new Paragraph("EMPRESA: " + compromisso.getEmpresa()));
				document.add(new Paragraph("FAX: " + compromisso.getFax()));
				document.add(new Paragraph("TELEFONE: " + compromisso.getFone1()));
				document.add(new Paragraph("TELEFONE: " + compromisso.getFone2()));
				document.add(new Paragraph("E-MAIL: " + compromisso.getEmail()));
				document.add(new Paragraph("PAÍS: " + compromisso.getPais()));
				document.add(new Paragraph("ESTADO: " + compromisso.getEstado()));
				document.add(new Paragraph("CIDADE: " + compromisso.getCidade()));
				document.add(new Paragraph("BAIRRO: " + compromisso.getBairro()));
				document.add(new Paragraph("LOGRADOURO: " + compromisso.getLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + compromisso.getComplemento()));
				document.add(new Paragraph("CEP: " + compromisso.getCep()));
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
