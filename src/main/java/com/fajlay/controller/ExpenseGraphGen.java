package com.fajlay.controller;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.style.PieStyler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.awt.Color;


@WebServlet("/PieChartServlet")
public class ExpenseGraphGen extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Sample data
        String[] expenseNames = new String[]{"Rent", "Food", "Transport", "Entertainment", "Utilities", "Healthcare", "Other"};
        double[] expenseAmounts = new double[]{800, 300, 100, 150, 200, 120, 50};

        // Create Chart
        PieChart chart = new PieChartBuilder().width(600).height(600).build();

        // Customize Chart
        chart.getStyler().setChartBackgroundColor(Color.BLACK);
        chart.getStyler().setChartFontColor(Color.WHITE);
        chart.getStyler().setLegendBackgroundColor(Color.BLACK);
        chart.getStyler().setLegendBorderColor(Color.BLACK);
        chart.getStyler().setPlotBackgroundColor(Color.BLACK);
        chart.getStyler().setLegendVisible(true);
        chart.getStyler().setLegendPosition(PieStyler.LegendPosition.OutsideS);
        chart.getStyler().setLegendLayout(PieStyler.LegendLayout.Horizontal);
        chart.getStyler().setAnnotationDistance(1.15);
        chart.getStyler().setPlotContentSize(0.8);

        // Add series
        for (int i = 0; i < expenseNames.length; i++) {
            chart.addSeries(expenseNames[i], expenseAmounts[i]);
        }

        // Render as PNG
        response.setContentType("image/png");
        BitmapEncoder.saveBitmap(chart, response.getOutputStream(), BitmapEncoder.BitmapFormat.PNG);
    }


}
