package erp.calculadora;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class CalculadoraFc extends JFrame {

	private class ButtonContr implements ActionListener {

		int achou, zerar;
		String cadeiaStr = "0";
		String copiarStr = "";
		double numero1, numero2, resultado;
		char operacao = 'n';

		@Override
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == copiar) {
				copiarStr = visor.getText();
				Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
				ClipboardOwner selecao = new StringSelection(cadeiaStr);
				board.setContents((Transferable) selecao, selecao);
			}

			if (event.getSource() == colar) {
				cadeiaStr = copiarStr;
			}

			if (event.getSource() == recortar) {

				copiarStr = visor.getText();

				Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
				ClipboardOwner selecao = new StringSelection(cadeiaStr);
				board.setContents((Transferable) selecao, selecao);

				cadeiaStr = "0";
			}

			if (event.getSource() == logButton) {
				cadeiaStr = String.valueOf(Math.log10(Double.parseDouble(cadeiaStr)));
				zerar = 1;
			}

			if (event.getSource() == raizButton) {
				cadeiaStr = String.valueOf(Math.sqrt(Double.parseDouble(cadeiaStr)));
				zerar = 1;
			}

			if (event.getSource() == senoButton) {
				cadeiaStr = String.valueOf((Math.sin(Math.toRadians(Double.parseDouble(cadeiaStr)))));
				cadeiaStr = new BigDecimal(cadeiaStr).setScale(5, RoundingMode.HALF_DOWN).toString();
				zerar = 1;
			}

			if (event.getSource() == cossenoButton) {
				cadeiaStr = String.valueOf((Math.cos(Math.toRadians(Double.parseDouble(cadeiaStr)))));
				cadeiaStr = new BigDecimal(cadeiaStr).setScale(5, RoundingMode.HALF_DOWN).toString();
				zerar = 1;
			}

			if (event.getSource() == b1Button) {
				// Efetua a ação de enviar o valor para o visor
				if (zerar == 1)
					cadeiaStr = "";
				if (cadeiaStr.equals("0"))
					cadeiaStr = "";
				cadeiaStr = cadeiaStr + "1";
				zerar = 0;
			}

			if (event.getSource() == b2Button) {
				if (zerar == 1)
					cadeiaStr = "";
				if (cadeiaStr.equals("0"))
					cadeiaStr = "";
				cadeiaStr = cadeiaStr + "2";
				zerar = 0;
			}

			if (event.getSource() == b3Button) {
				if (zerar == 1)
					cadeiaStr = "";
				if (cadeiaStr.equals("0"))
					cadeiaStr = "";
				cadeiaStr = cadeiaStr + "3";
				zerar = 0;
			}

			if (event.getSource() == b4Button) {
				if (zerar == 1)
					cadeiaStr = "";
				if (cadeiaStr.equals("0"))
					cadeiaStr = "";
				cadeiaStr = cadeiaStr + "4";
				zerar = 0;
			}

			if (event.getSource() == b5Button) {
				if (zerar == 1)
					cadeiaStr = "";
				if (cadeiaStr.equals("0"))
					cadeiaStr = "";
				cadeiaStr = cadeiaStr + "5";
				zerar = 0;
			}

			if (event.getSource() == b6Button) {
				if (zerar == 1)
					cadeiaStr = "";
				if (cadeiaStr.equals("0"))
					cadeiaStr = "";
				cadeiaStr = cadeiaStr + "6";
				zerar = 0;
			}

			if (event.getSource() == b7Button) {
				if (zerar == 1)
					cadeiaStr = "";
				if (cadeiaStr.equals("0"))
					cadeiaStr = "";
				cadeiaStr = cadeiaStr + "7";
				zerar = 0;
			}

			if (event.getSource() == b8Button) {
				if (zerar == 1)
					cadeiaStr = "";
				if (cadeiaStr.equals("0"))
					cadeiaStr = "";
				cadeiaStr = cadeiaStr + "8";
				zerar = 0;
			}

			if (event.getSource() == b9Button) {
				if (zerar == 1)
					cadeiaStr = "";
				if (cadeiaStr.equals("0"))
					cadeiaStr = "";
				cadeiaStr = cadeiaStr + "9";
				zerar = 0;
			}

			if (event.getSource() == pontoButton) {
				achou = 0;
				if (zerar == 1)
					cadeiaStr = "";

				for (int i = 0; i < cadeiaStr.length(); ++i)
					if (cadeiaStr.charAt(i) == '.')
						achou = 1;

				if (cadeiaStr.equals(""))
					cadeiaStr = cadeiaStr + "0.";
				else if (achou == 0)
					cadeiaStr = cadeiaStr + ".";

				zerar = 0;
			}

			if (event.getSource() == b0Button) {
				if (zerar == 1)
					cadeiaStr = "";

				if (!cadeiaStr.equals("0")) {
					cadeiaStr = cadeiaStr + "0";
				} else
					zerar = 1;
				// Operacao = 'n';
				zerar = 0;
			}

			if (event.getSource() == cButton) {
				cadeiaStr = "0";
				zerar = 1;
			}

			if (event.getSource() == bButton) {
				if (cadeiaStr.length() > 1)
					cadeiaStr = cadeiaStr.substring(0, cadeiaStr.length() - 1);
				else {
					cadeiaStr = "0";
					zerar = 1;
				}
			}

			if (event.getSource() == inversoButton) {

				cadeiaStr = String.valueOf(1 / Double.parseDouble(cadeiaStr));
				zerar = 1;
			}

			if (event.getSource() == quadradoButton) {
				cadeiaStr = String.valueOf(Math.pow(Double.parseDouble(cadeiaStr), 2));
				zerar = 1;
			}

			if (event.getSource() == adicionaButton) {
				numero1 = Double.parseDouble(visor.getText());
				operacao = '+';
				zerar = 1;
			}

			if (event.getSource() == subtraiButton) {
				numero1 = Double.parseDouble(visor.getText());
				operacao = '-';
				zerar = 1;
			}

			if (event.getSource() == multiplicaButton) {
				numero1 = Double.parseDouble(visor.getText());
				operacao = '*';
				zerar = 1;
			}

			if (event.getSource() == divideButton) {
				numero1 = Double.parseDouble(visor.getText());
				operacao = '/';
				zerar = 1;
			}

			if (event.getSource() == igualButton) {
				// Converte uma String em Double
				numero2 = Double.parseDouble(visor.getText());

				switch (operacao) {

				case 'n':
					resultado = numero2;
					break;

				case '+':
					resultado = numero1 + numero2;
					break;

				case '-':
					resultado = numero1 - numero2;
					break;

				case '*':
					resultado = numero1 * numero2;
					break;

				case '/':
					resultado = numero1 / numero2;
					break;
				}

				cadeiaStr = String.valueOf(resultado);
				zerar = 1;
			}
			visor.setText("" + cadeiaStr);
		}
	}

	private class JanelaContr extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			visor.setText("0");
			setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			visor.setText("0");
		}
	}

	private JButton adicionaButton = new JButton("+");
	private JPanel aPanel = new JPanel();
	private JButton b0Button = new JButton("0");
	private JButton b1Button = new JButton("1");
	private JButton b2Button = new JButton("2");
	private JButton b3Button = new JButton("3");
	private JButton b4Button = new JButton("4");
	private JButton b5Button = new JButton("5");
	private JButton b6Button = new JButton("6");
	private JButton b7Button = new JButton("7");
	private JButton b8Button = new JButton("8");
	private JButton b9Button = new JButton("9");
	private JButton bButton = new JButton("Del");
	private JPanel bPanel = new JPanel();
	private JButton cButton = new JButton("C");
	private JMenuItem colar = new JMenuItem("Colar");
	private JMenuItem copiar = new JMenuItem("Copiar");
	private JButton cossenoButton = new JButton("Cos");
	private JButton divideButton = new JButton("/");
	private JMenu Editar = new JMenu("Editar");
	private Font fonteVisor = new Font("Consolas", Font.PLAIN, 26);
	private JPanel geralPanel = new JPanel();
	private JButton igualButton = new JButton("=");
	private JButton inversoButton = new JButton("1/x");
	private JanelaContr janelaContr = new JanelaContr();
	private GridLayout Layout = new GridLayout(6, 4, 4, 4);
	private JButton logButton = new JButton("Log");
	private JMenuBar MenuBar = new JMenuBar();
	private JButton multiplicaButton = new JButton("x");
	private JButton pontoButton = new JButton(".");
	private JButton quadradoButton = new JButton("x²");
	private JButton raizButton = new JButton("\u221A");
	private JMenuItem recortar = new JMenuItem("Recortar");
	private JButton senoButton = new JButton("Sin");

	private JButton subtraiButton = new JButton("-");

	private JLabel visor = new JLabel("0");

	public CalculadoraFc() {
		super("ATHOS - CALCULADORA");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(janelaContr);
		setSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));

		Font fonte = new Font("TimesRoman", Font.PLAIN, 20);

		logButton.setFont(fonte);
		raizButton.setFont(fonte);
		senoButton.setFont(fonte);
		cossenoButton.setFont(fonte);
		cButton.setFont(fonte);
		bButton.setFont(fonte);
		inversoButton.setFont(fonte);
		quadradoButton.setFont(fonte);
		b1Button.setFont(fonte);
		b2Button.setFont(fonte);
		b3Button.setFont(fonte);
		b4Button.setFont(fonte);
		b5Button.setFont(fonte);
		b6Button.setFont(fonte);
		b7Button.setFont(fonte);
		b8Button.setFont(fonte);
		b9Button.setFont(fonte);
		b0Button.setFont(fonte);
		adicionaButton.setFont(fonte);
		subtraiButton.setFont(fonte);
		multiplicaButton.setFont(fonte);
		divideButton.setFont(fonte);
		igualButton.setFont(fonte);
		bButton.setFont(fonte);
		cButton.setFont(fonte);
		logButton.setFont(fonte);

		logButton.setToolTipText("Logaritmo na base 10");
		raizButton.setToolTipText("Raiz");
		senoButton.setToolTipText("Seno em Graus");
		cossenoButton.setToolTipText("Cosseno em Graus");
		cButton.setToolTipText("Limpa o visor");
		bButton.setToolTipText("Apaga o último caractere digitado");
		inversoButton.setToolTipText("Inverso");
		quadradoButton.setToolTipText("Quadrado");

		b1Button.setMnemonic(KeyEvent.VK_NUMPAD1);
		b2Button.setMnemonic(KeyEvent.VK_NUMPAD2);
		b3Button.setMnemonic(KeyEvent.VK_NUMPAD3);
		b4Button.setMnemonic(KeyEvent.VK_NUMPAD4);
		b5Button.setMnemonic(KeyEvent.VK_NUMPAD5);
		b6Button.setMnemonic(KeyEvent.VK_NUMPAD6);
		b7Button.setMnemonic(KeyEvent.VK_NUMPAD7);
		b8Button.setMnemonic(KeyEvent.VK_NUMPAD8);
		b9Button.setMnemonic(KeyEvent.VK_NUMPAD9);
		b0Button.setMnemonic(KeyEvent.VK_NUMPAD0);

		adicionaButton.setMnemonic(KeyEvent.VK_ADD);
		subtraiButton.setMnemonic(KeyEvent.VK_SUBTRACT);
		multiplicaButton.setMnemonic(KeyEvent.VK_MULTIPLY);
		divideButton.setMnemonic(KeyEvent.VK_DIVIDE);
		igualButton.setMnemonic(KeyEvent.VK_ENTER);
		bButton.setMnemonic(KeyEvent.VK_BACK_SPACE);
		cButton.setMnemonic(KeyEvent.VK_DELETE);
		logButton.setMnemonic(KeyEvent.VK_L);

		Editar.add(copiar);
		Editar.add(colar);
		Editar.add(recortar);

		MenuBar.add(Editar);

		this.setJMenuBar(MenuBar);

		aPanel.add(logButton);
		aPanel.add(raizButton);
		aPanel.add(senoButton);
		aPanel.add(cossenoButton);

		aPanel.add(cButton);
		aPanel.add(bButton);
		aPanel.add(inversoButton);
		aPanel.add(quadradoButton);

		aPanel.add(b7Button);
		aPanel.add(b8Button);
		aPanel.add(b9Button);
		aPanel.add(divideButton);

		aPanel.add(b4Button);
		aPanel.add(b5Button);
		aPanel.add(b6Button);
		aPanel.add(multiplicaButton);

		aPanel.add(b1Button);
		aPanel.add(b2Button);
		aPanel.add(b3Button);
		aPanel.add(subtraiButton);

		aPanel.add(b0Button);
		aPanel.add(pontoButton);
		aPanel.add(igualButton);
		aPanel.add(adicionaButton);

		aPanel.setLayout(Layout);
		visor.setFont(fonteVisor);
		visor.setHorizontalAlignment(SwingConstants.RIGHT);
		visor.setBorder(BorderFactory.createTitledBorder(""));
		bPanel.add(aPanel);

		visor.setPreferredSize(new Dimension(780, 80));

		geralPanel.add(visor);
		geralPanel.add(bPanel);
		add(geralPanel);

		ButtonContr Contr = new ButtonContr();
		b1Button.addActionListener(Contr);
		b2Button.addActionListener(Contr);
		b3Button.addActionListener(Contr);
		b4Button.addActionListener(Contr);
		b5Button.addActionListener(Contr);
		b6Button.addActionListener(Contr);
		b7Button.addActionListener(Contr);
		b8Button.addActionListener(Contr);
		b9Button.addActionListener(Contr);
		b0Button.addActionListener(Contr);

		cButton.addActionListener(Contr);
		bButton.addActionListener(Contr);
		adicionaButton.addActionListener(Contr);
		subtraiButton.addActionListener(Contr);
		multiplicaButton.addActionListener(Contr);
		divideButton.addActionListener(Contr);
		igualButton.addActionListener(Contr);
		inversoButton.addActionListener(Contr);
		quadradoButton.addActionListener(Contr);
		pontoButton.addActionListener(Contr);

		logButton.addActionListener(Contr);
		raizButton.addActionListener(Contr);
		senoButton.addActionListener(Contr);
		cossenoButton.addActionListener(Contr);

		copiar.addActionListener(Contr);
		colar.addActionListener(Contr);
		recortar.addActionListener(Contr);

	}
}