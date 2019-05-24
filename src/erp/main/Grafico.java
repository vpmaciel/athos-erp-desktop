package erp.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.data.Data;

public class Grafico {

	public static void main(String[] args) throws FileNotFoundException, DocumentException, IOException {
		(new Grafico()).create(new FileOutputStream(new File("ugly-demo.pdf")));
	}

	final JFreeChart chart;

	public Grafico() {
		final CategoryDataset dataset = createDataset();
		chart = createChart(dataset);

	}

	/**
	 * Creates PDf file.
	 *
	 * @param outputStream {@link OutputStream}.
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void create(OutputStream outputStream) throws DocumentException, IOException {
		Document document = null;
		PdfWriter writer = null;

		try {
			// instantiate document and writer
			document = new Document(PageSize.A4.rotate(), 10f, 10f, 10f, 10f);
			writer = PdfWriter.getInstance(document, outputStream);

			// open document
			document.open();

			// add image
			int width = 660;
			int height = 480;

			BufferedImage bufferedImage = chart.createBufferedImage(width, height);
			Image image = Image.getInstance(writer, bufferedImage, 1.0f);
			document.add(image);

			document.add(new Paragraph("\n"));
			document.add(new Paragraph(Data.getDataHora()));

			// release resources
			document.close();
			document = null;

			writer.close();
			writer = null;
		} catch (DocumentException de) {
			throw de;
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			// release resources
			if (null != document) {
				try {
					document.close();
				} catch (Exception ex) {
				}
			}

			if (null != writer) {
				try {
					writer.close();
				} catch (Exception ex) {
				}
			}
		}
	}

	/**
	 * Creates a sample chart.
	 * 
	 * @param dataset a dataset.
	 * 
	 * @return The chart.
	 */
	private JFreeChart createChart(final CategoryDataset dataset) {

		// create the chart...
		final JFreeChart chart = ChartFactory.createLineChart("Variação de preços", // chart title
				"Mês", // domain axis label
				"Aumento Valor (R$)", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips
				false // urls
		);

		chart.setBackgroundPaint(Color.white);

		final CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setRangeGridlinePaint(Color.white);

		// customise the range axis...
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(true);

		// customise the renderer...
		final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
//        renderer.setDrawShapes(true);

		renderer.setSeriesStroke(0, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f,
				new float[] { 10.0f, 6.0f }, 0.0f));
		renderer.setSeriesStroke(1, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f,
				new float[] { 6.0f, 6.0f }, 0.0f));
		renderer.setSeriesStroke(2, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f,
				new float[] { 2.0f, 6.0f }, 0.0f));
		// OPTIONAL CUSTOMISATION COMPLETED.

		return chart;
	}

	/**
	 * Creates a sample dataset.
	 * 
	 * @return The dataset.
	 */
	private CategoryDataset createDataset() {

		// row keys...
		final String series1 = "Arroz";
		final String series2 = "Feijão";
		final String series3 = "Macarrão";

		// column keys...
		final String type1 = "Janeiro";
		final String type2 = "Fevereiro";
		final String type3 = "Março";
		final String type4 = "Abril";
		final String type5 = "Maio";
		final String type6 = "Junho";
		final String type7 = "Julho";
		final String type8 = "Agosto";

		// create the dataset...
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(1.0, series1, type1);
		dataset.addValue(4.0, series1, type2);
		dataset.addValue(3.0, series1, type3);
		dataset.addValue(5.0, series1, type4);
		dataset.addValue(5.0, series1, type5);
		dataset.addValue(7.0, series1, type6);
		dataset.addValue(7.0, series1, type7);
		dataset.addValue(8.0, series1, type8);

		dataset.addValue(5.0, series2, type1);
		dataset.addValue(7.0, series2, type2);
		dataset.addValue(6.0, series2, type3);
		dataset.addValue(8.0, series2, type4);
		dataset.addValue(4.0, series2, type5);
		dataset.addValue(4.0, series2, type6);
		dataset.addValue(2.0, series2, type7);
		dataset.addValue(1.0, series2, type8);

		dataset.addValue(4.0, series3, type1);
		dataset.addValue(3.0, series3, type2);
		dataset.addValue(2.0, series3, type3);
		dataset.addValue(3.0, series3, type4);
		dataset.addValue(6.0, series3, type5);
		dataset.addValue(3.0, series3, type6);
		dataset.addValue(4.0, series3, type7);
		dataset.addValue(3.0, series3, type8);

		return dataset;

	}
}
