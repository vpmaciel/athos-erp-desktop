package erp.curriculo.curso;

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

public class CursoRel {

	private String arquivo = Data.getHora() + "-curso.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "CURSOS";
	private PdfWriter writer = null;

	public CursoRel(List<Curso> Cursos) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Curso Curso : Cursos) {
				document.newPage();
				document.add(new Paragraph("FUNCIONÁRIO: " + Curso.getFuncionario()));
				document.add(new Paragraph("INSTITUIÇÃO: " + Curso.getInstituicao()));
				document.add(new Paragraph("CARGA HORÁRIA: " + Curso.getCurso()));
				document.add(new Paragraph("ANO DE INÍCIO: " + Curso.getAnoInicio()));
				document.add(new Paragraph("ANO DE CONCLUSÃO: " + Curso.getAnoConclusao()));
				document.add(new Paragraph("SITUAÇÃO: " + Curso.getSituacao()));
				document.add(new Paragraph("MODALIDADE: " + Curso.getModalidade()));
				document.add(new Paragraph("NÍVEL: " + Curso.getNivel()));
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
