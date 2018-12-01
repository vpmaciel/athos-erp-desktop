package erp.banco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.relatorio.Relatorio;

public final class BancoRelatorio {

	private PdfWriter writer = null;
	private final Document document = new Document();
	private final String arquivo = "banco.pdf";
	private final String titulo = "BANCOS";
	private final Relatorio relatorio = new Relatorio();

	public BancoRelatorio(List<Banco> bancos) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Banco banco : bancos) {
				document.add(new Paragraph("BANCO: " + banco.getNome()));
				document.add(new Paragraph("CÓDIGO DO BANCO: " + banco.getCodigo()));
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
