package erp.agenda.recado;

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

public class RecadoRel {

	private String arquivo = Data.getTempo() +"-recado.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "RECADOS";
	private PdfWriter writer = null;

	public RecadoRel(List<Recado> recados) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Recado recado : recados) {
				document.newPage();
				document.add(new Paragraph("DATA: " + recado.getData()));
				document.add(new Paragraph("REMETENTE: " + recado.getRemetente()));
				document.add(new Paragraph("DESTINATÁRIO: " + recado.getDestinatario()));
				document.add(new Paragraph("RECADO: " + recado.getRecado()));
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
