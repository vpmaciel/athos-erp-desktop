package erp.veiculo.modelo;

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

public class VeiculoModeloRel {

	private String arquivo = Data.getHora() + "-veiculo-modelo.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "MODELO DE VEÍCULOS";
	private PdfWriter writer = null;

	public VeiculoModeloRel(List<VeiculoModelo> veiculoModelos) {

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

	public File retornarRelatorio(boolean abrirArquivo) {
		return relatorio.retornarRelatorio(arquivo, abrirArquivo);
	}

}
