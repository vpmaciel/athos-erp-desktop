package erp.curriculo.experienciaprofissional;

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

public class ExperienciaProfissionalRel {

	private String arquivo = Data.getHora() + "-experiencia-profissional.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "EXPERIÊNCIA PROFISSIONAL";
	private PdfWriter writer = null;

	public ExperienciaProfissionalRel(List<ExperienciaProfissional> ExperienciaProfissionals) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (ExperienciaProfissional ExperienciaProfissional : ExperienciaProfissionals) {
				document.newPage();
				document.add(new Paragraph("FUNCIONÁRIO: " + ExperienciaProfissional.getFuncionario()));
				document.add(new Paragraph("NÍVEL HIERÁRQUICO: " + ExperienciaProfissional.getNivelHierarquico()));
				document.add(new Paragraph("CARGO: " + ExperienciaProfissional.getCargo()));
				document.add(new Paragraph("FUNÇÕES: " + ExperienciaProfissional.getFuncoes()));
				document.add(new Paragraph("EMPRESA: " + ExperienciaProfissional.getEmpresa()));
				document.add(new Paragraph("DATA ADMISSÃO: " + ExperienciaProfissional.getDataAdmissao()));
				document.add(new Paragraph("DATA SAÍDA: " + ExperienciaProfissional.getDataSaida()));
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
