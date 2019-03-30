package erp.curriculo.caracteristica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.relatorio.Relatorio;

public class CaracteristicaRel {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "cliente.pdf";
	private String titulo = "CLIENTES";
	private Relatorio relatorio = new Relatorio();

	public CaracteristicaRel(List<Caracteristica> caracteristicas) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Caracteristica caracteristica : caracteristicas) {
				document.newPage();
				document.add(new Paragraph("FUNCIONÁRIO: " + caracteristica.getFuncionario()));
				document.add(new Paragraph("ADEQUADO: " + caracteristica.getAdequado()));
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
