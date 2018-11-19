package erp.agenda.recado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import erp.aop.relatorio.Relatorio;

public class RecadoRelatorio {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "recado.pdf";
	private String titulo = "RECADOS";
	private Relatorio relatorio = new Relatorio();
	
	public RecadoRelatorio(List<Recado> recados) {
		
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Recado recado : recados) {
				document.newPage();
				document.add(new Paragraph("NOME: " + recado.getNome()));
				document.add(new Paragraph("SEXO: " + recado.getSexo()));
				document.add(new Paragraph("CNPJ: " + recado.getCnpj()));
				document.add(new Paragraph("CPF: " + recado.getCpfNumero()));
				document.add(new Paragraph("SALÁRIO: " + recado.getSalario()));
				document.add(new Paragraph("EMPRESA: " + recado.getEmpresa()));
				document.add(new Paragraph("FAX: " + recado.getFax()));
				document.add(new Paragraph("TELEFONE: " + recado.getFone1()));
				document.add(new Paragraph("TELEFONE: " + recado.getFone2()));
				document.add(new Paragraph("E-MAIL: " + recado.getEmail()));
				document.add(new Paragraph("PAÍS: " + recado.getPais()));
				document.add(new Paragraph("ESTADO: " + recado.getEstado()));
				document.add(new Paragraph("CIDADE: " + recado.getCidade()));
				document.add(new Paragraph("BAIRRO: " + recado.getBairro()));
				document.add(new Paragraph("LOGRADOURO: " + recado.getLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + recado.getComplemento()));
				document.add(new Paragraph("CEP: " + recado.getCep()));
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
