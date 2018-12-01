package erp.usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.relatorio.Relatorio;

public class UsuarioRelatorio {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "usuario.pdf";
	private String titulo = "USUÁRIOS";
	private Relatorio relatorio = new Relatorio();

	public UsuarioRelatorio(List<Usuario> usuarios) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Usuario usuario : usuarios) {
				document.add(new Paragraph("USUÁRIO: " + usuario.getNome()));
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
