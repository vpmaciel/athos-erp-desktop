package erp.curriculo.habilidade;

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

public class HabilidadeRel {

	private String arquivo = Data.getHora() + "-habilidade.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "HABILIDADES";
	private PdfWriter writer = null;

	public HabilidadeRel(List<Habilidade> Habilidades) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Habilidade Habilidade : Habilidades) {
				document.newPage();
				document.add(new Paragraph("FUNCIONÁRIO: " + Habilidade.getFuncionario()));
				document.add(new Paragraph("CONHECIMENTO: " + Habilidade.getConhecimento()));
				document.add(new Paragraph("NÍVEL DE CONHECIMENTO: " + Habilidade.getNivelConhecimento()));

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
