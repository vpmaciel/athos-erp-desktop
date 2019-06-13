package erp.curriculo.teste.testedisc;

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

public class TesteDISCRel {

	private String arquivo = Data.getHora() + "-teste-disc.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "TESTE D.I.S.C.";
	private PdfWriter writer = null;

	public TesteDISCRel(List<TesteDISC> testeDISCs) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (TesteDISC testeDISC : testeDISCs) {
				document.newPage();
				document.add(new Paragraph("FUNCIONÁRIO: " + testeDISC.getFuncionario()));
				document.add(new Paragraph("DOMINÂNCIA: " + testeDISC.getTotalOpcaoD()));
				document.add(new Paragraph("INFLUÊNCIA: " + testeDISC.getTotalOpcaoI()));
				document.add(new Paragraph("ESTABILIDADE: " + testeDISC.getTotalOpcaoS()));
				document.add(new Paragraph("CONFORMIDADE: " + testeDISC.getTotalOpcaoC()));
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
