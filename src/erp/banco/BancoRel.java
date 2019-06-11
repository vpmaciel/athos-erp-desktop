package erp.banco;

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

public final class BancoRel {

	private final String arquivo = Data.getDataHoraCompleta()+ " - banco.pdf";
	private final Document document = new Document();
	private final Relatorio relatorio = new Relatorio();
	private final String titulo = "BANCOS";
	private PdfWriter writer = null;

	public BancoRel(List<Banco> listBanco) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Banco banco : listBanco) {
				document.add(new Paragraph("BANCO: " + banco.getNome()));
				document.add(new Paragraph("CÓDIGO DO BANCO: " + banco.getCodigo()));
				document.add(new Paragraph("\n"));
			}
		} catch (DocumentException | FileNotFoundException exception) {
			exception.printStackTrace();
		}
		relatorio.getRodape(writer, document);
		document.close();
		relatorio.retornarRelatorio(arquivo, false);
	}

	public File retornarRelatorio(boolean abrirRelatorio) {
		return relatorio.retornarRelatorio(arquivo, abrirRelatorio);
	}
}
