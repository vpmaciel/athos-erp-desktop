package erp.curriculo.certificado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.relatorio.Relatorio;

public class CertificadoRel {

	private String arquivo = "certificado.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "CERTIFICADOS";
	private PdfWriter writer = null;

	public CertificadoRel(List<Certificado> certificados) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Certificado certificado : certificados) {
				document.newPage();
				document.add(new Paragraph("FUNCIONÁRIO: " + certificado.getFuncionario()));
				document.add(new Paragraph("INSTITUIÇÃO: " + certificado.getInstituicao()));
				document.add(new Paragraph("CURSO: " + certificado.getCurso()));
				document.add(new Paragraph("ANO DE CONCLUSÃO: " + certificado.getAnoConclusao()));
				document.add(new Paragraph("CARGA HORÁRIA: " + certificado.getCargaHoraria()));
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
