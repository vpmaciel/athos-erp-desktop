package erp.agenda.evento.tipoevento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.relatorio.Relatorio;

public class TipoEventoRel {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "agenda.pdf";
	private String titulo = "AGENDA";
	private Relatorio relatorio = new Relatorio();

	public TipoEventoRel(List<TipoEvento> tipoEventos) {
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (TipoEvento tipoEvento : tipoEventos) {
				document.newPage();
				document.add(new Paragraph("NOME: " + tipoEvento.getNome()));
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
