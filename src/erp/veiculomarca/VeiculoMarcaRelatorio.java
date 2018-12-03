package erp.veiculomarca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.relatorio.Relatorio;

public class VeiculoMarcaRelatorio {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "veiculo-marca.pdf";
	private String titulo = "MARCA DE VEÍCULOS";
	private Relatorio relatorio = new Relatorio();

	public VeiculoMarcaRelatorio(List<VeiculoMarca> veiculoMarcas) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (VeiculoMarca veiculoMarca : veiculoMarcas) {
				document.newPage();
				document.add(new Paragraph("MARCA: " + veiculoMarca.getMarca()));
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
