package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FishTank;
import model.Fish;
import model.Owner;

/**
 * Servlet implementation class CreateNewTankServlet
 */
@WebServlet(name = "createNewTankServlet", urlPatterns = { "/createNewTankServlet" })
public class CreateNewTankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewTankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FishHelper fih = new FishHelper();
		String tankName = request.getParameter("tankName");

		String ownerName = request.getParameter("ownerName");
		
		String[] selectedItems = request.getParameterValues("allFishToAdd");
		List<Fish> selectedItemsInList = new ArrayList<Fish>();
		
		if(selectedItems != null && selectedItems.length > 0){
			for(int i = 0; i<selectedItems.length; i++) {
				Fish f = fih.searchForFishById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(f);
			}
		}
		
		Owner owner = new Owner(ownerName);
		
		FishTank ft = new FishTank(tankName, owner);
		
		ft.setListOfFish(selectedItemsInList);
		
		FishTankHelper fth = new FishTankHelper();
		fth.insertNewFishTank(ft);
		
		getServletContext().getRequestDispatcher("/viewAllFishTankServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
