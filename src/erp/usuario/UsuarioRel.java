package erp.usuario;

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

public class UsuarioRel {

	private String arquivo = Data.getHora() + "-usuario.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "USUÁRIOS";
	private PdfWriter writer = null;

	public UsuarioRel(List<Usuario> usuarios) {

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

	public File retornarRelatorio(boolean abrirArquivo) {
		return relatorio.retornarRelatorio(arquivo, abrirArquivo);
	}
}
