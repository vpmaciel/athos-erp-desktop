package erp.agenda.evento.tipoevento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import erp.aop.relatorio.Relatorio;

public class TipoEventoRelatorio {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "agenda.pdf";
	private String titulo = "AGENDA";
	private Relatorio relatorio = new Relatorio();
	
	public TipoEventoRelatorio(List<TipoEvento> tipoEventos) {	
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (TipoEvento tipoEvento : tipoEventos) {
				document.newPage();
				document.add(new Paragraph("NOME: " + tipoEvento.getNome()));
				document.add(new Paragraph("SEXO: " + tipoEvento.getSexo()));
				document.add(new Paragraph("CNPJ: " + tipoEvento.getCnpj()));
				document.add(new Paragraph("CPF: " + tipoEvento.getCpfNumero()));
				document.add(new Paragraph("SALÁRIO: " + tipoEvento.getSalario()));
				document.add(new Paragraph("EMPRESA: " + tipoEvento.getEmpresa()));
				document.add(new Paragraph("FAX: " + tipoEvento.getFax()));
				document.add(new Paragraph("TELEFONE: " + tipoEvento.getFone1()));
				document.add(new Paragraph("TELEFONE: " + tipoEvento.getFone2()));
				document.add(new Paragraph("E-MAIL: " + tipoEvento.getEmail()));
				document.add(new Paragraph("PAÍS: " + tipoEvento.getPais()));
				document.add(new Paragraph("ESTADO: " + tipoEvento.getEstado()));
				document.add(new Paragraph("CIDADE: " + tipoEvento.getCidade()));
				document.add(new Paragraph("BAIRRO: " + tipoEvento.getBairro()));
				document.add(new Paragraph("LOGRADOURO: " + tipoEvento.getLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + tipoEvento.getComplemento()));
				document.add(new Paragraph("CEP: " + tipoEvento.getCep()));
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
