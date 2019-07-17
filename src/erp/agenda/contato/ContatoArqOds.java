package erp.agenda.contato;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jopendocument.dom.spreadsheet.SpreadSheet;

import arquitetura.Sis;
import arquitetura.data.Data;

public class ContatoArqOds {

	private final String arquivo = Sis.getCaminhoDiretorioOds() + "[contato]-" + Data.getDataHoraArquivo() + ".ods";
	String[] colunas = new String[] { "ID","NOME","SEXO","E-MAIL","FAX","FONE","FONE","EMPRESA","BAIRRO","CEP","CIDADE","COMPLEMENTO","ESTADO","LOGRADOURO","PAÍS","CNPJ","CPF"};
	Object[][] dados;
	File file;
	TableModel tableModel;

	public ContatoArqOds(List<Contato> listContato) {

		try {
			dados = new Object[listContato.size()][17];

			int linha = 0;

			for (Contato contato : listContato) {
				dados[linha][0] = contato.getId();
				dados[linha][1] = contato.getNome();
				dados[linha][2] = contato.getSexo();
				dados[linha][3] = contato.getEmail();
				dados[linha][4] = contato.getFax();
				dados[linha][5] = contato.getFone1();
				dados[linha][6] = contato.getFone2();
				dados[linha][7] = contato.getEmpresa();
				dados[linha][8] = contato.getEnderecoBairro();
				dados[linha][9] = contato.getEnderecoCep();
				dados[linha][10] = contato.getEnderecoCidade();
				dados[linha][11] = contato.getEnderecoComplemento();
				dados[linha][12] = contato.getEnderecoEstado();
				dados[linha][13] = contato.getEnderecoLogradouro();
				dados[linha][14] = contato.getEnderecoPais();
				dados[linha][15] = contato.getCnpj();
				dados[linha][16] = contato.getCpf();
				linha++;
			}

			tableModel = new DefaultTableModel(dados, colunas);
			file = new File(arquivo);
			SpreadSheet.createEmpty(tableModel).saveAs(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public File retornarArquivo(boolean abrirArquivo) {
		if (abrirArquivo) {
			try {
				Sis.abrirDiretorio(Sis.getCaminhoDiretorioOds());
				Desktop.getDesktop().open(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
}
