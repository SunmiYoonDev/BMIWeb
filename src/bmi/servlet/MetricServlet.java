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

@WebServlet("/metric")
public class MetricServlet extends HttpServlet {

	private static final long serialVersionUID =  1L;

	public MetricServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("type", 2); 
		request.getRequestDispatcher("bmiCalculator.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			BMICalculator bmiCalculator = new BMICalculator();			
			double height = Double.parseDouble(request.getParameter("height"))/100f;
			double weight = Double.parseDouble(request.getParameter("weight"));
			bmiCalculator.setHeight(height);
			bmiCalculator.setWeight(weight);
			double bmi = bmiCalculator.calculateBMI();
			String value = BMICalculator.getDescription(bmi);
			
			request.setAttribute("height", height); 
			request.setAttribute("weight", weight);
			request.setAttribute("bmi", bmi);
			request.setAttribute("value", value);
			request.setAttribute("type", 2); 
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
