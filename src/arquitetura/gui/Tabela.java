package arquitetura.gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public final class Tabela {

	private static final Color COLOR_PesquisaRegistro = new Color(255, 255, 153);

	public static void configurarLarguraColunasTabela(JTable table, int coluna, int largura) {
		table.getColumnModel().getColumn(coluna).setWidth(largura);
		table.getColumnModel().getColumn(coluna).setPreferredWidth(largura);
		table.getColumnModel().getColumn(coluna).setMaxWidth(largura);
		table.getColumnModel().getColumn(coluna).setMinWidth(largura);
	}

	public static void configurarLarguraColunasTabela(JTable table, int[] width) {
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.getColumnModel().getColumn(c).setWidth(width[c]);
			table.getColumnModel().getColumn(c).setPreferredWidth(width[c]);
			table.getColumnModel().getColumn(c).setMaxWidth(width[c]);
			table.getColumnModel().getColumn(c).setMinWidth(width[c]);
		}
	}

	public static DefaultTableCellRenderer getDefaultTableCellRenderer() {
		@SuppressWarnings("serial")
		DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				this.setHorizontalAlignment(4);
				c.setForeground(Color.BLACK);
				c.setBackground(row % 2 == 0 ? COLOR_PesquisaRegistro : Color.WHITE);
				return c;
			}
		};
		return defaultTableCellRenderer;
	}

}
