package erp.cartorio;

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

public class CartorioRel {

	private String arquivo = Data.getHora() +"-cartorio.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "CARTÓRIOS";
	private PdfWriter writer = null;

	public CartorioRel(List<Cartorio> cartorios) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Cartorio cartorio : cartorios) {
				document.newPage();
				document.add(new Paragraph("NOME FANTASIA: " + cartorio.getNomeFantasia()));
				document.add(new Paragraph("RAZÃO SOCIAL: " + cartorio.getRazaoSocial()));
				document.add(new Paragraph("COMARCA: " + cartorio.getComarca()));
				document.add(new Paragraph("MUNICÍPIO: " + cartorio.getMunicipio()));
				document.add(new Paragraph("DISTRITO: " + cartorio.getDistrito()));
				document.add(new Paragraph("TITULAR: " + cartorio.getTitular()));
				document.add(new Paragraph("SUBSTITUTO: " + cartorio.getSubstituto()));
				document.add(new Paragraph("CNPJ: " + cartorio.getCnpj()));
				document.add(new Paragraph("TELEFONE: " + cartorio.getFone1()));
				document.add(new Paragraph("TELEFONE: " + cartorio.getFone2()));
				document.add(new Paragraph("FAX: " + cartorio.getFax()));
				document.add(new Paragraph("E-MAIL: " + cartorio.getEmail()));
				document.add(new Paragraph("SITE: " + cartorio.getSite()));
				document.add(new Paragraph("PAÍS: " + cartorio.getPais()));
				document.add(new Paragraph("ESTADO: " + cartorio.getEstado()));
				document.add(new Paragraph("CIDADE: " + cartorio.getCidade()));
				document.add(new Paragraph("BAIRRO: " + cartorio.getBairro()));
				document.add(new Paragraph("LOGRADOURO: " + cartorio.getLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + cartorio.getComplemento()));
				document.add(new Paragraph("CEP: " + cartorio.getCep()));
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
