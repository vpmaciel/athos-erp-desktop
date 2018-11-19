package erp.editor.texto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import erp.aop.gui.Msg;

@SuppressWarnings("serial")
public class FrameEditorTexto extends JFrame {

	public FrameEditorTexto() {
		super("ATHOS - EDITOR DE TEXTO");

		initComponents();
	}

	/**
	 * Aqui Ã© definido as propriedades do Jframe, bem como adicionado os componentes
	 * grÃ¡ficos a esta janela.
	 */
	private void initComponents() {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));

		final EventosBlocoDeNotas eventosBlocoDeNotas = new EventosBlocoDeNotas();

		// criacao de uma barra de menu visualizada no topo da aplicacao.
		menuBar = new JMenuBar();

		fontePadrÃ£o = new Font("Lucida Console", Font.PLAIN, 14);

		// criacao de uma Ã¡rea de insercao de texto.
		texto = new JTextArea();
		texto.setFont(fontePadrÃ£o);
		texto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent event) {
				if (event.isPopupTrigger())
					botÃ£oEsquerdo.show(event.getComponent(), event.getX(), event.getY());
			}
		});
		// adicao de barra de rolagem ao JTextArea.
		add(new JScrollPane(texto), BorderLayout.CENTER);

		final UndoManager undo = new UndoManager();
		Document documento = texto.getDocument();

		// aqui Ã© ouvido os eventos de Desfazer.
		documento.addUndoableEditListener(new UndoableEditListener() {
			@Override
			public void undoableEditHappened(UndoableEditEvent event) {
				undo.addEdit(event.getEdit());
			}
		});

		/****************************** MENU ARQUIVO **************************/

		/*
		 * Dentro do menu Arquivo encontrasse: Novo (Ctrl N), Abrir (Ctrl O), Salvar
		 * Como (Ctrl S) e Sair (Alt F4).
		 */
		menuArquivo = new JMenu();
		menuArquivo.setText("Arquivo");

		// propriedades do componente menuItemNovo.
		menuItemNovo = new JMenuItem();
		menuItemNovo.setText("Novo");
		menuItemNovo.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
		menuItemNovo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemNovoActionListener();
			}
		});
		menuArquivo.add(menuItemNovo);

		// propriedades do componente menuItemAbrir.
		menuItemAbrir = new JMenuItem();
		menuItemAbrir.setText("Abrir...");
		menuItemAbrir.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		menuItemAbrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemAbrirActionListener();
			}
		});
		menuArquivo.add(menuItemAbrir);

		// propriedades do componente menuItemSalvarComo.
		menuItemSalvarComo = new JMenuItem();
		menuItemSalvarComo.setText("Salvar como...");
		menuItemSalvarComo.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		menuItemSalvarComo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemSalvarComoActionListener();
			}
		});
		menuArquivo.add(menuItemSalvarComo);

		menuArquivo.addSeparator();

		// propriedades do componente menuItemSair.
		menuItemSair = new JMenuItem();
		menuItemSair.setText("Sair");
		menuItemSair.setAccelerator(KeyStroke.getKeyStroke("alt F4"));
		menuItemSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemSairActionListener();
			}
		});
		menuArquivo.add(menuItemSair);

		/****************************** MENU EDITAR ***************************/

		/*
		 * Dentro do menu Editar encontrasse: Desfazer (Ctrl Z), Recortar (Ctrl X),
		 * Copiar (Ctrl C), Colar (Ctrl V), Localizar (Ctrl F), Localizar prÃ³xima (F3) e
		 * Selecionar tudo (Ctrl T).
		 */
		menuEditar = new JMenu();
		menuEditar.setText("Editar");

		// propriedades do componente menuItemDesfazer.
		menuItemDesfazer = new JMenuItem();
		menuItemDesfazer.setText("Desfazer");
		menuItemDesfazer.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));
		menuItemDesfazer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (undo.canUndo()) {
						undo.undo();
					}
				} catch (CannotUndoException Erro) {
				}
			}
		});
		menuEditar.add(menuItemDesfazer);

		menuEditar.addSeparator();

		// propriedades do componente menuItemRecortar.
		menuItemRecortar = new JMenuItem();
		menuItemRecortar.setText("Recortar");
		menuItemRecortar.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
		menuItemRecortar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemRecortarActionListener();
			}
		});
		menuEditar.add(menuItemRecortar);

		// propriedades do componente menuItemCopiar.
		menuItemCopiar = new JMenuItem();
		menuItemCopiar.setText("Copiar");
		menuItemCopiar.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
		menuItemCopiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemCopiarActionListener();
			}
		});
		menuEditar.add(menuItemCopiar);

		// propriedades do componente menuItemColar.
		menuItemColar = new JMenuItem();
		menuItemColar.setText("Colar");
		menuItemColar.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));
		menuItemColar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemColarActionListener();
			}
		});
		menuEditar.add(menuItemColar);

		menuEditar.addSeparator();

		// propriedades do componente menuItemLocalizar.
		menuItemLocalizar = new JMenuItem();
		menuItemLocalizar.setText("Localizar...");
		menuItemLocalizar.setAccelerator(KeyStroke.getKeyStroke("ctrl F"));
		menuItemLocalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemLocalizarActionListener();
			}
		});
		menuEditar.add(menuItemLocalizar);

		// propriedades do componente menuItemLocalizarProxima.
		menuItemLocalizarProxima = new JMenuItem();
		menuItemLocalizarProxima.setText("Localizar prÃ³xima");
		menuItemLocalizarProxima.setAccelerator(KeyStroke.getKeyStroke("F3"));
		menuItemLocalizarProxima.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemLocalizarProximaActionListener();
			}
		});
		menuEditar.add(menuItemLocalizarProxima);

		menuEditar.addSeparator();

		// propriedades do componente menuItemSelecionarTudo.
		menuItemSelecionarTudo = new JMenuItem();
		menuItemSelecionarTudo.setText("Selecionar tudo");
		menuItemSelecionarTudo.setAccelerator(KeyStroke.getKeyStroke("ctrl T"));
		menuItemSelecionarTudo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemSelecionarTudoActionListener();
			}
		});
		menuEditar.add(menuItemSelecionarTudo);

		/****************************** MENU FORMATAR *************************/

		/*
		 * Dentro do menu Formatar encontrasse: Quebra automÃ¡tica de linha (Ctrl L),
		 * Fonte (Ctrl R) e Cor da fonte (Ctrl D).
		 */
		menuFormatar = new JMenu();
		menuFormatar.setText("Formatar");

		// propriedades do componente menuItemQuebraAtomaticaDeLinha.
		menuItemQuebraAtomaticaDeLinha = new JCheckBoxMenuItem();
		menuItemQuebraAtomaticaDeLinha.setText("Quebra automÃ¡tica de linha");
		menuItemQuebraAtomaticaDeLinha.setAccelerator(KeyStroke.getKeyStroke("ctrl L"));
		menuItemQuebraAtomaticaDeLinha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemQuebraAtomaticaDeLinhaActionListener();
			}
		});
		menuFormatar.add(menuItemQuebraAtomaticaDeLinha);

		menuFormatar.addSeparator();

		// propriedades do componente menuItemFonte.
		menuItemFonte = new JMenuItem();
		menuItemFonte.setText("Fonte...");
		menuItemFonte.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
		menuItemFonte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemFonteActionListener();
			}
		});
		menuFormatar.add(menuItemFonte);

		// propriedades do componente menuItemCor.
		menuItemCor = new JMenuItem();
		menuItemCor.setText("Cor da fonte...");
		menuItemCor.setAccelerator(KeyStroke.getKeyStroke("ctrl D"));
		menuItemCor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemCorActionListener();
			}
		});
		menuFormatar.add(menuItemCor);

		/****************************** MENU EXIBIR ***************************/

		// dentro do menu Exibir encontrasse: Barra de status
		menuExibir = new JMenu();
		menuExibir.setText("Exibir");

		// propriedades do componente menuItemBarraDeStatus.
		menuItemBarraDeStatus = new JCheckBoxMenuItem();
		menuItemBarraDeStatus.setText("Barra de status");
		menuItemBarraDeStatus.setSelected(true);
		menuItemBarraDeStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemBarraDeStatusActionListener();
			}
		});
		menuExibir.add(menuItemBarraDeStatus);

		// adicionando os menus a barra de menu (JMenuBar).
		menuBar.add(menuArquivo);
		menuBar.add(menuEditar);
		menuBar.add(menuFormatar);
		menuBar.add(menuExibir);
		setJMenuBar(menuBar);

		/****************************** BOTÃƒO ESQUERDO DO MOUSE ***************/
		botÃ£oEsquerdo = new JPopupMenu();

		popupMenuItemDesfazer = new JMenuItem();
		popupMenuItemDesfazer.setText("Desfazer");
		popupMenuItemDesfazer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (undo.canUndo()) {
						undo.undo();
					}
				} catch (CannotUndoException Erro) {
					// possÃ­veis erros sÃ£o tratados aqui.
				}
			}
		});
		botÃ£oEsquerdo.add(popupMenuItemDesfazer);

		botÃ£oEsquerdo.addSeparator();

		popupMenuItemRecortar = new JMenuItem();
		popupMenuItemRecortar.setText("Recortar");
		popupMenuItemRecortar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemRecortarActionListener();
			}
		});
		botÃ£oEsquerdo.add(popupMenuItemRecortar);

		popupMenuItemCopiar = new JMenuItem();
		popupMenuItemCopiar.setText("Copiar");
		popupMenuItemCopiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemRecortarActionListener();
			}
		});
		botÃ£oEsquerdo.add(popupMenuItemCopiar);

		popupMenuItemColar = new JMenuItem();
		popupMenuItemColar.setText("Colar");
		popupMenuItemColar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemColarActionListener();
			}
		});
		botÃ£oEsquerdo.add(popupMenuItemColar);

		botÃ£oEsquerdo.addSeparator();

		popupMenuItemSelecionarTudo = new JMenuItem();
		popupMenuItemSelecionarTudo.setText("Selecionar tudo");
		popupMenuItemSelecionarTudo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventosBlocoDeNotas.MenuItemSelecionarTudoActionListener();
			}
		});
		botÃ£oEsquerdo.add(popupMenuItemSelecionarTudo);

		/****************************** BARRA DE STATUS ***********************/
		barraDeStatus = new JLabel();
		barraDeStatus.setHorizontalAlignment(JLabel.RIGHT);
		barraDeStatus.setText("Lucida Console // Font.PLAIN // 14  ");
		add(barraDeStatus, BorderLayout.SOUTH);

		/****************************** FECHA JANELA **************************/
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent event) {

				eventosBlocoDeNotas.FecharWindowListener();
			}
		});
	}

	/**************** CLASSE DESTINADA A TRATAMENTO DE EVENTOS ****************/
	private class EventosBlocoDeNotas {

		int posicaoInicial;
		int selecionar;
		String pesquisa;
		Color color = Color.BLACK;
		Color ÃºltimaCor = Color.BLACK;

		/**
		 * Apaga todo texto existente no documento.
		 */
		public void MenuItemNovoActionListener() {

			texto.setText("");
		}

		/**
		 * Abre um documento jÃ¡ existente.
		 */
		public void MenuItemAbrirActionListener() {

			AbrirArquivo();
		}

		/**
		 * Salva o arquivo texto em um diretÃ³rio.
		 */
		public void MenuItemSalvarComoActionListener() {
			SalvarArquivo();
		}

		/**
		 * MÃ©todo responsÃ¡vel por fechar o aplicativo.
		 */
		public void MenuItemSairActionListener() {
			FecharWindowListener();
		}

		/**
		 * Apaga o texto selecionado e transfere para a Ã¡rea de transferÃªncia.
		 */
		public void MenuItemRecortarActionListener() {
			texto.cut();
		}

		/**
		 * Tranfere para a Ã¡rea de tranferÃªncia o texto selecionado.
		 */
		public void MenuItemCopiarActionListener() {
			texto.copy();
		}

		/**
		 * Insere o texto no documento que esta na Ã¡rea de transferÃªncia.
		 */
		public void MenuItemColarActionListener() {

			texto.paste();
		}

		/**
		 * Busca uma determinada palavra no documento; Quando o MenuItemLocalizar for
		 * acionado, uma caixa de diÃ¡logo serÃ¡ aberta e no campo de texto a palavra o
		 * qual desejasse buscar no documento deverÃ¡ ser armazenada na variÃ¡vel, no
		 * formato String, pesquisa; Caso a variÃ¡vel pesquisa tenha um valor nÃ£o nulo, a
		 * palavra solicitada deverÃ¡ ser buscada no JTextArea, sendo estÃ¡, quando
		 * encontrada, selecionada no texto.
		 */
		public void MenuItemLocalizarActionListener() {

			pesquisa = JOptionPane.showInputDialog(FrameEditorTexto.this, "Pesquisar:", "Localizar",
					JOptionPane.PLAIN_MESSAGE);

			if (pesquisa != null) {

				posicaoInicial = 0;
				texto.requestFocus();

				selecionar = texto.getText().indexOf(pesquisa, posicaoInicial);

				if (selecionar < 0) {
					JOptionPane.showMessageDialog(FrameEditorTexto.this, "Texto nÃ£o encontrado");
					posicaoInicial = 0;
				} else {
					texto.requestFocus();
					texto.select(selecionar, selecionar + pesquisa.length());
				}
			}
		}

		/**
		 * Localiza a ocorrÃªncia de uma palavra.
		 */
		public void MenuItemLocalizarProximaActionListener() {

			if (pesquisa != null) {

				texto.requestFocus();
				posicaoInicial = selecionar + pesquisa.length();

				selecionar = texto.getText().indexOf(pesquisa, posicaoInicial);

				if (selecionar < 0) {

					// informa ao usuÃ¡rio que todas as palavras foram encontradas.
					JOptionPane.showMessageDialog(FrameEditorTexto.this, "NÃ£o existe \"" + pesquisa + "\" em frente!");
					selecionar = -1;
					posicaoInicial = 0;

				} else {

					texto.requestFocus();
					texto.select(selecionar, selecionar + pesquisa.length());
					posicaoInicial = selecionar + pesquisa.length();
				}
			}
		}

		/**
		 * Agiliza o processo de recortar, copiar e colar todo o texto.
		 */
		public void MenuItemSelecionarTudoActionListener() {
			texto.selectAll();
		}

		/**
		 * Estando ativado o menuItemQuebraAtomaticaDeLinha, o texto passa para a linha
		 * posterior quando este alcanÃ§a a margem direita do documento; Estando
		 * desabilitado, o texto segue normalmente na mesma linha atÃ© o usuÃ¡rio apertar
		 * a tecla ENTER.
		 */
		public void MenuItemQuebraAtomaticaDeLinhaActionListener() {

			if (menuItemQuebraAtomaticaDeLinha.isSelected())
				texto.setLineWrap(true);
			else
				texto.setLineWrap(false);
		}

		/**
		 * Object obtÃªm todas as fontes do sistema, sendo estas fontes exibidas em um
		 * JOptionPane; Quando o usuÃ¡rio efetivar sua escolha toda a fonte do texto serÃ¡
		 * mudada.
		 */
		public void MenuItemFonteActionListener() {

			Object[] nomeFonte = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

			String fonteEscolhida = (String) JOptionPane.showInputDialog(FrameEditorTexto.this, "Escolha a fonte",
					"Fonte", JOptionPane.PLAIN_MESSAGE, null, nomeFonte, "");

			if (fonteEscolhida == null)
				texto.setFont(new Font("Lucida Console", Font.PLAIN, 14));
			else {
				texto.setFont(new Font(fonteEscolhida, Font.PLAIN, 14));
				barraDeStatus.setText(fonteEscolhida + " // Font.PLAIN // 14  ");
			}
		}

		/**
		 * Abrindo uma caixa de diÃ¡logo que permite ao usuÃ¡rio selecionar uma
		 * determinada cor de forma interativa.
		 */
		public void MenuItemCorActionListener() {

			color = JColorChooser.showDialog(FrameEditorTexto.this, "Alterar cor da fonte", color);

			if (color != null)
				ÃºltimaCor = color;

			texto.setForeground(ÃºltimaCor);
		}

		/**
		 * Estando abilitado, serÃ¡ exibido informaÃ§Ãµes sobre a fonte e seu estilo e
		 * tamanho, no canto inferior da Janela.
		 */
		public void MenuItemBarraDeStatusActionListener() {

			if (menuItemBarraDeStatus.isSelected())
				barraDeStatus.setVisible(true);
			else
				barraDeStatus.setVisible(false);
		}

		/**
		 * Permite ao usuÃ¡rio selecionar algum arquivo do computador para que este ser
		 * â€œabertoâ€� pelo Editor de Texto.
		 */
		public void AbrirArquivo() {

			JFileChooser abrindoArquivo = new JFileChooser();

			// configurando para que somente arquivos seja abertos.
			abrindoArquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

			SwingUtilities.updateComponentTreeUI(abrindoArquivo);

			// definindo filtro de ExtensÃ£o para abrir somente arquivo *.txt
			abrindoArquivo.setFileFilter(new javax.swing.filechooser.FileFilter() {

				@Override
				public boolean accept(File file) {
					return file.getName().toLowerCase().endsWith(".txt") || file.isDirectory();
				}

				@Override
				public String getDescription() {
					return "Documento de Texto (.txt)";
				}
			});

			// armazena a escolha do usuÃ¡rio.
			int respostaDeAbrindoArquivo = abrindoArquivo.showOpenDialog(FrameEditorTexto.this);

			// se o usuÃ¡rio clicar para abrir o arquivo...
			if (respostaDeAbrindoArquivo == JFileChooser.APPROVE_OPTION) {

				File Arquivo = abrindoArquivo.getSelectedFile();
				texto.setText("");

				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(Arquivo));
					String linha;

					while ((linha = bufferedReader.readLine()) != null) {
						texto.append(linha + "\n");
					}

					bufferedReader.close();
				} catch (IOException ex) {
					// possÃ­veis erros sÃ£o tratatos aqui.
				}
			}
		}

		public void SalvarArquivo() {

			JFileChooser salvandoArquivo = new JFileChooser();

			if (salvandoArquivo.showSaveDialog(FrameEditorTexto.this) != JFileChooser.APPROVE_OPTION)
				return;

			File arquivo = salvandoArquivo.getSelectedFile();
			if (arquivo == null)
				return;

			FileWriter writer = null;
			try {
				writer = new FileWriter(arquivo);
				writer.write(texto.getText());
			} catch (IOException Ex) {
				// possÃ­veis erros aqui.
			}

			finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException ex) {
					}
				}
			}
		}

		/**
		 * Permite que o usuÃ¡rio determine se deseja que o documento seja salvo ou nÃ£o,
		 * quando clicado no botÃ£o fechar do aplicativo.
		 */
		public void FecharWindowListener() {

			int resposta = Msg.confirmarFecharJanela();

			if (resposta == JOptionPane.YES_OPTION) {
				setVisible(false);
			}
		}
	}

	// Componentes grÃ¡ficos utilizados no JFrame.
	private JMenuBar menuBar;

	private JMenu menuArquivo;

	private JMenuItem menuItemNovo;
	private JMenuItem menuItemAbrir;
	private JMenuItem menuItemSalvarComo;
	private JMenuItem menuItemSair;

	private JMenu menuEditar;

	private JMenuItem menuItemDesfazer;
	private JMenuItem menuItemRecortar;
	private JMenuItem menuItemCopiar;
	private JMenuItem menuItemColar;
	private JMenuItem menuItemLocalizar;
	private JMenuItem menuItemLocalizarProxima;
	private JMenuItem menuItemSelecionarTudo;

	private JMenu menuFormatar;

	private JCheckBoxMenuItem menuItemQuebraAtomaticaDeLinha;
	private JMenuItem menuItemFonte;
	private JMenuItem menuItemCor;

	private JMenu menuExibir;

	private JCheckBoxMenuItem menuItemBarraDeStatus;

	private JPopupMenu botÃ£oEsquerdo;

	private JMenuItem popupMenuItemDesfazer;
	private JMenuItem popupMenuItemRecortar;
	private JMenuItem popupMenuItemCopiar;
	private JMenuItem popupMenuItemColar;
	private JMenuItem popupMenuItemSelecionarTudo;
	private Font fontePadrÃ£o;
	private JLabel barraDeStatus;
	private JTextArea texto;
}
