package erp.centrocusto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.relatorio.Relatorio;

public class CentroCustoRel {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "centro-de-custo.pdf";
	private String titulo = "CENTROS DE CUSTO";
	private Relatorio relatorio = new Relatorio();

	public CentroCustoRel(List<CentroCusto> centroCustos) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (CentroCusto centroCusto : centroCustos) {
				document.add(new Paragraph("NOME: " + centroCusto.getNome()));
				document.add(new Paragraph("\n"));
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
