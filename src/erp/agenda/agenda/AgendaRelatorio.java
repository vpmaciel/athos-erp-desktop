package erp.agenda.agenda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import erp.aop.relatorio.Relatorio;

public class AgendaRelatorio {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "agenda.pdf";
	private String titulo = "AGENDA";
	private Relatorio relatorio = new Relatorio();
	
	public AgendaRelatorio(List<Agenda> agendas) {	
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Agenda agenda : agendas) {
				document.newPage();
				document.add(new Paragraph("NOME: " + agenda.getNome()));
				document.add(new Paragraph("SEXO: " + agenda.getSexo()));
				document.add(new Paragraph("CNPJ: " + agenda.getCnpj()));
				document.add(new Paragraph("CPF: " + agenda.getCpfNumero()));
				document.add(new Paragraph("SALÁRIO: " + agenda.getSalario()));
				document.add(new Paragraph("EMPRESA: " + agenda.getEmpresa()));
				document.add(new Paragraph("FAX: " + agenda.getFax()));
				document.add(new Paragraph("TELEFONE: " + agenda.getFone1()));
				document.add(new Paragraph("TELEFONE: " + agenda.getFone2()));
				document.add(new Paragraph("E-MAIL: " + agenda.getEmail()));
				document.add(new Paragraph("PAÍS: " + agenda.getPais()));
				document.add(new Paragraph("ESTADO: " + agenda.getEstado()));
				document.add(new Paragraph("CIDADE: " + agenda.getCidade()));
				document.add(new Paragraph("BAIRRO: " + agenda.getBairro()));
				document.add(new Paragraph("LOGRADOURO: " + agenda.getLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + agenda.getComplemento()));
				document.add(new Paragraph("CEP: " + agenda.getCep()));
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
