package erp.agenda.evento;

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

public class EventoRel {

	private String arquivo = Data.getHora() + "-agenda.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "AGENDA";
	private PdfWriter writer = null;

	public EventoRel(List<Evento> eventos) {
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Evento evento : eventos) {
				document.newPage();
				document.add(new Paragraph("DATA: " + evento.getData()));
				document.add(new Paragraph("HORA INÍCIO: " + evento.getHoraInicio()));
				document.add(new Paragraph("HORA TÉRMINO: " + evento.getHoraTermino()));
				document.add(new Paragraph("TIPO DE EVENTO: " + evento.getTipoEvento()));
				document.add(new Paragraph("REUNIÃO: " + evento.getDescricao()));
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
