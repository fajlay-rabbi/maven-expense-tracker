package com.fajlay.controller;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.Styler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

@WebServlet("/ExpenseChartServlet")
public class GraphGen extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Sample data
        double[] months = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        double[] expenses = new double[]{500, 600, 700, 800, 650, 720, 750, 800, 1800, 900, 950, 1000, 1400};
        double[] income = new double[]{1000, 1100, 1200, 1300, 1250, 1400, 1450, 1500, 1550, 1600, 1650, 1700, 1850};

        // Create Chart
        XYChart chart = new XYChartBuilder().width(500).height(300).xAxisTitle("Month").yAxisTitle("Amount").build();


        Color customBackgroundColor = new Color(13, 13, 13);

        // Customize Chart
        chart.getStyler().setPlotBackgroundColor(java.awt.Color.BLACK);
        chart.getStyler().setChartBackgroundColor(java.awt.Color.BLACK);
        chart.getStyler().setChartFontColor(java.awt.Color.WHITE);
        chart.getStyler().setPlotGridLinesColor(java.awt.Color.GRAY);
        chart.getStyler().setPlotGridLinesVisible(true);
        chart.getStyler().setAxisTickLabelsColor(java.awt.Color.WHITE);
        chart.getStyler().setLegendBackgroundColor(java.awt.Color.BLACK);
        chart.getStyler().setLegendBorderColor(java.awt.Color.WHITE);
        chart.getStyler().setChartTitleBoxBackgroundColor(java.awt.Color.BLACK);
        chart.getStyler().setChartTitleBoxBorderColor(java.awt.Color.WHITE);
        chart.getStyler().setChartTitleBoxVisible(true);
        chart.getStyler().setLegendVisible(true);
        chart.getStyler().setLegendSeriesLineLength(10);
        chart.getStyler().setPlotBorderColor(java.awt.Color.BLACK);

        // Add series
        chart.addSeries("Expenses", months, expenses);
        chart.addSeries("Income", months, income);

        // Render as PNG
        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
        BitmapEncoder.saveBitmap(chart, response.getOutputStream(), BitmapEncoder.BitmapFormat.PNG);
    }


}
