package erp.agenda.contato;

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
import erp.empresa.Empresa;
import erp.empresa.EmpresaFac;

public class ContatoArqXml {

	private final String arquivo = Sis.getCaminhoDadosXml() + "[contato]-" + Data.getDataHoraArquivo() + ".xml";
	private File file;

	public ContatoArqXml(final List<Contato> listContato) {
		try {
			Document doc = new Document();

			Element raiz = new Element("contatos");

			for (Contato contato : listContato) {

				Element contatoElement = new Element("contato");

				Element id = new Element("id");
				id.setText(contato.getId().toString());
				contatoElement.addContent(id);

				Element nome = new Element("nome");
				nome.setText(contato.getNome());
				contatoElement.addContent(nome);

				Element sexo = new Element("sexo");
				sexo.setText(contato.getSexo());
				contatoElement.addContent(sexo);

				Element email = new Element("email");
				email.setText(contato.getEmail());
				contatoElement.addContent(email);

				Element codigo = new Element("fax");
				codigo.setText(contato.getFax());
				contatoElement.addContent(codigo);
				
				Element fone1 = new Element("fone1");
				fone1.setText(contato.getFone1());
				contatoElement.addContent(fone1);
				
				Element fone2 = new Element("fone2");
				codigo.setText(contato.getFone2());
				contatoElement.addContent(fone2);
				
				Element empresa = new Element("empresa");
				empresa.setText(contato.getEmpresa().getId().toString());
				contatoElement.addContent(empresa);
				
				Element bairro = new Element("bairro");
				bairro.setText(contato.getEnderecoBairro());
				contatoElement.addContent(bairro);
				
				Element cep = new Element("cep");
				cep.setText(contato.getEnderecoCep());
				contatoElement.addContent(cep);
				
				Element cidade = new Element("cidade");
				cidade.setText(contato.getEnderecoCidade());
				contatoElement.addContent(cidade);
				
				Element complemento = new Element("complemento");
				complemento.setText(contato.getEnderecoComplemento());
				contatoElement.addContent(complemento);
				
				Element estado = new Element("estado");
				estado.setText(contato.getEnderecoEstado());
				contatoElement.addContent(estado);
				
				Element logradouro = new Element("logradouro");
				logradouro.setText(contato.getEnderecoLogradouro());
				contatoElement.addContent(logradouro);
				
				Element pais = new Element("pais");
				pais.setText(contato.getEnderecoPais());
				contatoElement.addContent(pais);
				
				Element cnpj = new Element("cnpj");
				cnpj.setText(contato.getCnpj());
				contatoElement.addContent(cnpj);
				
				Element cpf = new Element("cpf");
				cpf.setText(contato.getCpf());
				contatoElement.addContent(cpf);
				
				raiz.addContent(contatoElement);
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
	public Collection<Contato> importarArquivo(boolean abrirArquivo) {
		List<Contato> listContato = new LinkedList<Contato>();
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

			List<Contato> listContatoXml = root.getChildren();

			for (Object object : listContatoXml) {
				Element element = (Element) object;
				Contato contato = new Contato();
				contato.setId(Long.parseLong(element.getChildText("id")));
				contato.setNome(element.getChildText("nome"));
				contato.setSexo(element.getChildText("sexo"));
				contato.setEmail(element.getChildText("email"));
				contato.setFax(element.getChildText("fax"));
				contato.setFone1(element.getChildText("fone1"));
				contato.setFone2(element.getChildText("fone2"));
				Empresa empresa = new Empresa();
				empresa.setId(Long.parseLong(element.getChildText("Empresa")));
				empresa = EmpresaFac.getRegistro(empresa);
				contato.setEmpresa(empresa);
				contato.setEnderecoBairro(element.getChildText("enderecoBairro"));
				contato.setEnderecoCep(element.getChildText("enderecoCep"));
				contato.setEnderecoCidade(element.getChildText("enderecoCidade"));
				contato.setEnderecoComplemento(element.getChildText("enderecoComplemento"));
				contato.setEnderecoEstado(element.getChildText("enderecoEstado"));
				contato.setEnderecoLogradouro(element.getChildText("enderecoLogradouro"));
				contato.setEnderecoPais(element.getChildText("enderecoPais"));
				contato.setCnpj(element.getChildText("Cnpj"));
				contato.setCpf(element.getChildText("Cpf"));
				listContato.add(contato);
			}

			if (abrirArquivo) {
				Desktop.getDesktop().open(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
			Msg.erroAbrirArquivo();
		}

		return listContato;
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
