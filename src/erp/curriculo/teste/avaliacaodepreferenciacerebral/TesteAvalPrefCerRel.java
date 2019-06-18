package erp.curriculo.teste.avaliacaodepreferenciacerebral;

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

public class TesteAvalPrefCerRel {

	private String arquivo = Data.getHora() + "-teste-aval-pref-cer.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "TESTE - AVALIAÇÃO DE PREFERÊNCIA CEREBRAL";
	private PdfWriter writer = null;

	public TesteAvalPrefCerRel(List<TesteAvalPrefCer> testeAvalPrefCers) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (TesteAvalPrefCer testeAvalPrefCer : testeAvalPrefCers) {
				document.newPage();
				document.add(new Paragraph("FUNCIONÁRIO: " + testeAvalPrefCer.getFuncionario()));
				document.add(new Paragraph("ÁGUIA: " + testeAvalPrefCer.getTotalOpcaoI() * 100 / 25.0 + " %"));
				document.add(new Paragraph("GATO: " + testeAvalPrefCer.getTotalOpcaoC() * 100 / 25.0 + " %"));
				document.add(new Paragraph("TUBARÃO: " + testeAvalPrefCer.getTotalOpcaoA() * 100 / 25.0 + " %"));
				document.add(new Paragraph("LOBO: " + testeAvalPrefCer.getTotalOpcaoO() * 100 / 25.0 + " %"));
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
