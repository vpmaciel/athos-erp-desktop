package erp.agenda.evento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.relatorio.Relatorio;

public class EventoRelatorio {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "agenda.pdf";
	private String titulo = "AGENDA";
	private Relatorio relatorio = new Relatorio();

	public EventoRelatorio(List<Evento> eventos) {
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Evento evento : eventos) {
				document.newPage();
				document.add(new Paragraph("NOME: " + evento.getNome()));
				document.add(new Paragraph("SEXO: " + evento.getSexo()));
				document.add(new Paragraph("CNPJ: " + evento.getCnpj()));
				document.add(new Paragraph("CPF: " + evento.getCpfNumero()));
				document.add(new Paragraph("SALÁRIO: " + evento.getSalario()));
				document.add(new Paragraph("EMPRESA: " + evento.getEmpresa()));
				document.add(new Paragraph("FAX: " + evento.getFax()));
				document.add(new Paragraph("TELEFONE: " + evento.getFone1()));
				document.add(new Paragraph("TELEFONE: " + evento.getFone2()));
				document.add(new Paragraph("E-MAIL: " + evento.getEmail()));
				document.add(new Paragraph("PAÍS: " + evento.getPais()));
				document.add(new Paragraph("ESTADO: " + evento.getEstado()));
				document.add(new Paragraph("CIDADE: " + evento.getCidade()));
				document.add(new Paragraph("BAIRRO: " + evento.getBairro()));
				document.add(new Paragraph("LOGRADOURO: " + evento.getLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + evento.getComplemento()));
				document.add(new Paragraph("CEP: " + evento.getCep()));
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
