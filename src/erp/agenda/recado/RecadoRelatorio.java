package erp.agenda.recado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.relatorio.Relatorio;

public class RecadoRelatorio {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "recado.pdf";
	private String titulo = "RECADOS";
	private Relatorio relatorio = new Relatorio();

	public RecadoRelatorio(List<Recado> recados) {

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
