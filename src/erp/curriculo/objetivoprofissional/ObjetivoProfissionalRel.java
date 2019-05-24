package erp.curriculo.objetivoprofissional;

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

public class ObjetivoProfissionalRel {

	private String arquivo = Data.getHora() + "-objetivoProfissional.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "OBJETIVO PROFISSIONAL";
	private PdfWriter writer = null;

	public ObjetivoProfissionalRel(List<ObjetivoProfissional> ObjetivoProfissionals) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (ObjetivoProfissional ObjetivoProfissional : ObjetivoProfissionals) {
				document.newPage();
				document.add(new Paragraph("FUNCIONÁRIO: " + ObjetivoProfissional.getFuncionario()));
				document.add(new Paragraph("CARGO: " + ObjetivoProfissional.getCargo()));
				document.add(new Paragraph("CONTRATO: " + ObjetivoProfissional.getContrato()));
				document.add(new Paragraph("PRETENSÃO SALARIAL: " + ObjetivoProfissional.getPretensaoSalarial()));
				document.add(new Paragraph("NÍVEL HIERÁRQUICO: " + ObjetivoProfissional.getNivelHierarquico()));
				document.add(new Paragraph("ÁREA DE INTERESSE: " + ObjetivoProfissional.getAreaInteresse()));
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
