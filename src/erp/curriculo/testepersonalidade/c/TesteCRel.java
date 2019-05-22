package erp.curriculo.testepersonalidade.c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.relatorio.Relatorio;

public class TesteCRel {

	private String arquivo = "testeC.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "TESTE D.I.S.C.";
	private PdfWriter writer = null;

	public TesteCRel(List<TesteC> testeCs) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (TesteC testeC : testeCs) {
				document.newPage();
				document.add(new Paragraph("FUNCIONÁRIO: " + testeC.getFuncionario()));
				document.add(new Paragraph("DOMINÂNCIA: " + testeC.getTotalOpcaoD()));
				document.add(new Paragraph("INFLUÊNCIA: " + testeC.getTotalOpcaoI()));
				document.add(new Paragraph("ESTABILIDADE: " + testeC.getTotalOpcaoS()));
				document.add(new Paragraph("CONFORMIDADE: " + testeC.getTotalOpcaoC()));
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
