package bmi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bmi.exception.ImpossibleHeightException;
import bmi.exception.ImpossibleWeightException;
import bmi.model.BMICalculator;
import bmi.model.MetricConverter;

@WebServlet("/usa")
public class USAServlet extends HttpServlet {

	private static final long serialVersionUID =  1L;

	public USAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("type", 1); 
		request.getRequestDispatcher("bmiCalculator.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			BMICalculator bmiCalculator = new BMICalculator();			
			double iheight = Double.parseDouble(request.getParameter("height"));
			double mheight = MetricConverter.inchToMeter(Double.parseDouble(request.getParameter("height")));
			double pweight = Double.parseDouble(request.getParameter("weight"));
			double kweight = MetricConverter.poundToKg(Double.parseDouble(request.getParameter("weight")));
			bmiCalculator.setHeight(mheight);
			bmiCalculator.setWeight(kweight);
			double bmi = bmiCalculator.calculateBMI();
			String value = BMICalculator.getDescription(bmi);
			
			request.setAttribute("height", iheight); 
			request.setAttribute("weight", pweight);
			request.setAttribute("bmi", bmi);
			request.setAttribute("value", value);
			request.setAttribute("type", 1); 
			request.getRequestDispatcher("bmiResult.jsp").forward(request, response);

		} catch (ImpossibleHeightException | ImpossibleWeightException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage", "Please put numeric value only");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		}

	}


}
