
package erp.banco;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import arquitetura.Sis;
import arquitetura.data.Data;
import arquitetura.gui.Msg;

public class BancoArquivoXml {

	private final String arquivo = Sis.getCaminhoDadosTxt() + "[banco]-" + Data.getDataHoraArquivo() + ".txt";
	private BufferedWriter bufferedWriter = null;
	private File file;

	public BancoArquivoXml(final List<Banco> listBanco) {
		try {
			Document doc = new Document();

			Element root = new Element("turma");

			Element pessoa = new Element("pessoa");
			Attribute sexo = new Attribute("sexo", "Masculino");
			pessoa.setAttribute(sexo);

			Element nome = new Element("nome");
			nome.setText("Rodrigo");
			pessoa.addContent(nome);

			Element sobrenome = new Element("sobrenome");
			sobrenome.setText("sobrenome");
			pessoa.addContent(sobrenome);

			Element notas = new Element("notas");
			pessoa.addContent(notas);

			Element teste1 = new Element("teste1");
			teste1.setText("8.3");
			Element teste2 = new Element("teste2");
			teste2.setText("7.8");
			Element prova = new Element("prova");
			prova.setText("9.2");

			notas.addContent(teste1);
			notas.addContent(teste2);
			notas.addContent(prova);

			root.addContent(pessoa);

			doc.setRootElement(root);

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

	public File retornarArquivo(boolean abrirArquivo) {

		try {
			Sis.abrirDiretorio(Sis.getCaminhoDadosXml());
			file = new File(arquivo);
				        
			SAXBuilder builder = new SAXBuilder();
			Element root2 =null;
			try {

				Document doc2 = builder.build(file);
				            
				root2 = (Element) doc2.getRootElement();
				    	
			}catch (Exception e) {
				// TODO: handle exception
			}     
			List pessoas = root2.getChildren();
			             
			Iterator i = pessoas.iterator();
			             
			while( i.hasNext() ){
			        Element pessoa2 = (Element) i.next();
			        System.out.println("Nome: " + pessoa2.getChildText("nome"));
			        System.out.println("Sobrenome: " + pessoa2.getChildText("sobrenome"));
			        System.out.println("Sexo: " + pessoa2.getAttributeValue("sexo"));
			        System.out.println("Nota( teste1 ): "+pessoa2.getChild("notas").getChildText("teste1"));
			        System.out.println("Nota( teste2 ): "+pessoa2.getChild("notas").getChildText("teste2"));
			        System.out.println("Nota( prova ): "+pessoa2.getChild("notas").getChildText("prova"));
			        System.out.println();
			}

			
			
			if (abrirArquivo) {
				Desktop.getDesktop().open(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}
}
