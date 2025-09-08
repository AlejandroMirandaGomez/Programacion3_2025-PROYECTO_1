package proyecto_1.presentation.dashboard;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChartsFactory {
    // Estados en el orden que quieres en leyenda y gráfico
    public static final String EN_PROCESO     = "En Proceso";
    public static final String LISTA          = "Lista";
    public static final String ENTREGADA      = "Entregada";
    public static final String CONFECCIONADA  = "Confeccionada";

    // Construye el ChartPanel del pastel con estilo
    public static ChartPanel buildPieRecetasPorEstado(Map<String, Integer> conteo) {
        // Dataset en orden fijo (LinkedHashMap) para que leyenda/sectores sigan ese orden
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.setValue(EN_PROCESO,    conteo.getOrDefault(EN_PROCESO, 0));
        dataset.setValue(LISTA,         conteo.getOrDefault(LISTA, 0));
        dataset.setValue(ENTREGADA,     conteo.getOrDefault(ENTREGADA, 0));
        dataset.setValue(CONFECCIONADA, conteo.getOrDefault(CONFECCIONADA, 0));

        // Crea el chart base
        JFreeChart chart = ChartFactory.createPieChart(
                "Recetas",   // título
                dataset,
                true,        // leyenda
                true,        // tooltips
                false        // URLs
        );

        // Estilo general
        chart.setBackgroundPaint(new Color(200, 200, 200)); // gris claro (fondo general)
        chart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 24));

        PiePlot<String> plot = (PiePlot<String>) chart.getPlot();
        plot.setBackgroundPaint(new Color(200, 200, 200));  // gris en el plot
        plot.setOutlineVisible(false);

        // Colores por estado (rojo, azul, verde, amarillo)
        plot.setSectionPaint(EN_PROCESO,    new Color(231, 76, 60));   // rojo
        plot.setSectionPaint(LISTA,         new Color(52, 152, 219));  // azul
        plot.setSectionPaint(ENTREGADA,     new Color(46, 204, 113));  // verde
        plot.setSectionPaint(CONFECCIONADA, new Color(241, 196, 15));  // amarillo

        // Líneas con cajas de texto (no “simple labels”)
        plot.setSimpleLabels(false);
        plot.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
        plot.setLabelBackgroundPaint(new Color(255, 255, 204)); // caja suave
        plot.setLabelOutlinePaint(Color.DARK_GRAY);
        plot.setLabelShadowPaint(null);

        // Etiquetas: NOMBRE = CUENTA (PORCENTAJE)
        plot.setLabelGenerator(
                new org.jfree.chart.labels.StandardPieSectionLabelGenerator(
                        "{0} = {1} ({2})",
                        new DecimalFormat("0"),   // cuenta sin decimales
                        new DecimalFormat("0%")   // porcentaje “29%”
                )
        );

        // Si quieres ocultar sectores de valor 0:
        plot.setIgnoreZeroValues(true);

        // Panel Swing contenedor
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(false);
        panel.setDomainZoomable(false);
        panel.setRangeZoomable(false);
        panel.setBackground(new Color(200, 200, 200)); // que combine con el fondo

        return panel;
    }
}
