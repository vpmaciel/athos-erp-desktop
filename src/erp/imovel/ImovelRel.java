package erp.imovel;

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

public class ImovelRel {

	private String arquivo = Data.getHora() + "-imovel.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "IMÓVEIS";
	private PdfWriter writer = null;

	public ImovelRel(List<Imovel> imoveis) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Imovel imovel : imoveis) {
				document.newPage();
				document.add(new Paragraph("NOME DO PROPRIETÁRIO: " + imovel.getNomeProprietario()));
				document.add(new Paragraph("SALA: " + imovel.getSala()));
				document.add(new Paragraph("GARAGEM: " + imovel.getGaragem()));
				document.add(new Paragraph("PISCINA: " + imovel.getPiscina()));
				document.add(new Paragraph("CNPJ: " + imovel.getCnpj()));
				document.add(new Paragraph("CPF: " + imovel.getCpf()));
				document.add(new Paragraph("COZINHA: " + imovel.getCozinha()));
				document.add(new Paragraph("BANHEIRO: " + imovel.getBanheiro()));
				document.add(new Paragraph("TERRAÇO: " + imovel.getTerraco()));
				document.add(new Paragraph("SUÍTE: " + imovel.getSuite()));
				document.add(new Paragraph("VARANDA: " + imovel.getVaranda()));
				document.add(new Paragraph("QUARTO: " + imovel.getQuarto()));
				document.add(new Paragraph("FAX: " + imovel.getFax()));
				document.add(new Paragraph("TELEFONE: " + imovel.getFone1()));
				document.add(new Paragraph("TELEFONE: " + imovel.getFone2()));
				document.add(new Paragraph("E-MAIL: " + imovel.getEmail()));
				document.add(new Paragraph("PAÍS: " + imovel.getPais()));
				document.add(new Paragraph("ESTADO: " + imovel.getEnderecoEstado()));
				document.add(new Paragraph("CIDADE: " + imovel.getEnderecoCidade()));
				document.add(new Paragraph("BAIRRO: " + imovel.getEnderecoBairro()));
				document.add(new Paragraph("LOGRADOURO: " + imovel.getEnderecoLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + imovel.getEnderecoComplemento()));
				document.add(new Paragraph("CEP: " + imovel.getEnderecoCep()));
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
