package erp.curriculo.teste.perfilcomportmental;

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

public class TestePerfilCompRel {

	private String arquivo = Data.getHora() +"teste-perfil-comp.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "TESTE PERFIL COMPORTAMENTAL";
	private PdfWriter writer = null;

	public TestePerfilCompRel(List<TestePerfilComp> testePerfilComps) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (TestePerfilComp testePerfilComp : testePerfilComps) {
				document.newPage();
				document.add(new Paragraph("FUNCIONÁRIO: " + testePerfilComp.getFuncionario()));
				document.add(new Paragraph("INFLUENTE: " + testePerfilComp.getTotalOpcaoA()));
				document.add(new Paragraph("GUERREIRO: " + testePerfilComp.getTotalOpcaoB()));
				document.add(new Paragraph("PERFECCIONISTA: " + testePerfilComp.getTotalOpcaoC()));
				document.add(new Paragraph("HARMONIOSO: " + testePerfilComp.getTotalOpcaoD()));
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
