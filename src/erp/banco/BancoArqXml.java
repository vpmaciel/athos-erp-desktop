
package erp.banco;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import arquitetura.Sis;
import arquitetura.data.Data;
import arquitetura.gui.Msg;

public class BancoArqXml {

	private final String arquivo = Sis.getCaminhoDadosXml() + "[banco]-" + Data.getDataHoraArquivo() + ".xml";
	private File file;

	public BancoArqXml(final List<Banco> listBanco) {
		try {
			Document doc = new Document();

			Element raiz = new Element("bancos");

			for (Banco banco : listBanco) {

				Element bancoElement = new Element("banco");

				Element id = new Element("id");
				id.setText(banco.getId().toString());
				bancoElement.addContent(id);

				Element nome = new Element("nome");
				nome.setText(banco.getNome());
				bancoElement.addContent(nome);

				Element codigo = new Element("codigo");
				codigo.setText(banco.getCodigo());
				bancoElement.addContent(codigo);

				raiz.addContent(bancoElement);
			}

			doc.setRootElement(raiz);

			XMLOutputter xout = new XMLOutputter();
			OutputStream out = new FileOutputStream(new File(arquivo));
			xout.output(doc, out);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			Msg.erroCodificacao();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Msg.erroArquivoNaoEncontrado();
		} catch (IOException e) {
			e.printStackTrace();
			Msg.erroAbrirArquivo();
		}
	}

	@SuppressWarnings("unchecked")
	public Collection<Banco> importarArquivo(boolean abrirArquivo) {
		List<Banco> listBanco = new LinkedList<Banco>();
		try {
			Sis.abrirDiretorio(Sis.getCaminhoDadosXml());
			file = new File(arquivo);

			SAXBuilder builder = new SAXBuilder();
			Element root = null;
			try {

				Document document = builder.build(file);

				root = (Element) document.getRootElement();

			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroAbrirArquivo();
			}

			List<Banco> listBancoXml = root.getChildren();

			for (Object object : listBancoXml) {
				Element element = (Element) object;
				Banco banco = new Banco();
				banco.setId(Long.parseLong(element.getChildText("id")));
				banco.setNome(element.getChildText("nome"));
				banco.setCodigo(element.getChildText("codigo"));
				listBanco.add(banco);
			}

			if (abrirArquivo) {
				Desktop.getDesktop().open(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
			Msg.erroAbrirArquivo();
		}

		return listBanco;
	}

	public File retornarArquivo(boolean abrirArquivo) {

		try {
			Sis.abrirDiretorio(Sis.getCaminhoDadosXml());
			file = new File(arquivo);

			if (abrirArquivo) {
				Desktop.getDesktop().open(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
			Msg.erroAbrirArquivo();
		}

		return file;
	}
}
