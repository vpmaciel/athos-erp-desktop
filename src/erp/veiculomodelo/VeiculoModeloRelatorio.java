package erp.veiculomodelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.relatorio.Relatorio;

public class VeiculoModeloRelatorio {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "veiculo-modelo.pdf";
	private String titulo = "MODELO DE VEÍCULOS";
	private Relatorio relatorio = new Relatorio();

	public VeiculoModeloRelatorio(List<VeiculoModelo> veiculoModelos) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (VeiculoModelo veiculoModelo : veiculoModelos) {
				document.newPage();
				document.add(new Paragraph("MODELO: " + veiculoModelo.getModelo()));
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
