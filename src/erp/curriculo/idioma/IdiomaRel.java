package erp.curriculo.idioma;

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

public class IdiomaRel {

	private String arquivo = Data.getHora() + "-idioma.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "IDIOMAS";
	private PdfWriter writer = null;

	public IdiomaRel(List<Idioma> Idiomas) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Idioma Idioma : Idiomas) {
				document.newPage();
				document.add(new Paragraph("FUNCIONÁRIO: " + Idioma.getFuncionario()));
				document.add(new Paragraph("CONHECIMENTO: " + Idioma.getConhecimento()));
				document.add(new Paragraph("NÍVEL DE CONHECIMENTO: " + Idioma.getNivelConhecimento()));

			}
		} catch (DocumentException | FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		relatorio.getRodape(writer, document);
		document.close();
		relatorio.retornarRelatorio(arquivo, false);
	}

	public File retornarRelatorio(boolean abrirArquivo) {
		return relatorio.retornarRelatorio(arquivo, abrirArquivo);
	}
}
