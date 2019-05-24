package erp.veiculo.marca;

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

public class VeiculoMarcaRel {

	private String arquivo = Data.getHora() +"-veiculo-marca.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "MARCA DE VEÍCULOS";
	private PdfWriter writer = null;

	public VeiculoMarcaRel(List<VeiculoMarca> veiculoMarcas) {

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
