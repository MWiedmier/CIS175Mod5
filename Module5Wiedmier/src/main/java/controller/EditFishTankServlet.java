package controller;

import java.io.IOException;
import java.time.LocalDate;
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
 * Servlet implementation class EditFishTankServlet
 */
@WebServlet(name = "editFishTankServlet", urlPatterns = { "/editFishTankServlet" })
public class EditFishTankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFishTankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FishTankHelper dao = new FishTankHelper();
		FishHelper fih = new FishHelper(); 
		OwnerHelper oh = new OwnerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id")); 
		FishTank tankToUpdate = dao.searchForFishTanksById(tempId);
		
		String newTankName = request.getParameter("tankName");
		
		String ownerName = request.getParameter("ownerName"); 
		//find our add the new shopper 
		Owner newOwner = oh.findOwner(ownerName);
		
		try { 
			//items are selected in list to add 
			String[] selectedFish = request.getParameterValues("allFishToAdd"); 
			List<Fish> selectedItemsInList = new ArrayList<Fish>(); 
			for (int i = 0; i < selectedFish.length; i++) { 
				System.out.println(selectedFish[i]); 
				Fish f = fih.searchForFishById(Integer.parseInt(selectedFish[i])); 
				selectedItemsInList.add(f); 
			} 
			tankToUpdate.setListOfFish(selectedItemsInList); 
		} catch (NullPointerException ex) { 
			// no items selected in list - set to an empty list 
			List<Fish> selectedItemsInList = new ArrayList<Fish>(); 
			tankToUpdate.setListOfFish(selectedItemsInList);
		} 
		tankToUpdate.setFishTankName(newTankName); 
		tankToUpdate.setOwner(newOwner); 
		dao.updateTank(tankToUpdate); 
		getServletContext().getRequestDispatcher("/viewAllFishTankServlet").forward(request, response);
	}

}
