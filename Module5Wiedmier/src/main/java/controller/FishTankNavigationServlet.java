package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FishTank;

/**
 * Servlet implementation class FishTankNavigationServlet
 */
@WebServlet(name = "fishTankNavigationServlet", urlPatterns = { "/fishTankNavigationServlet" })
public class FishTankNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FishTankNavigationServlet() {
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
		String act = request.getParameter("doThisToTank"); 
		if (act == null) { 
			// no button has been selected 
			getServletContext().getRequestDispatcher("/viewAllFishTankServlet").forward(request, response); 
		 
		} else if (act.equals("delete")) { 
			try { 
				Integer tempId = Integer.parseInt(request.getParameter("id")); 
				FishTank listToDelete = dao.searchForFishTanksById(tempId); 
				dao.deleteTank(listToDelete); 
		 
			} catch (NumberFormatException e) { 
				System.out.println("Forgot to click a button"); 
			} finally { 
				getServletContext().getRequestDispatcher("/viewAllFishTankServlet").forward(request, response); 
			} 
		} else if (act.equals("edit")) { 
			try { 
				Integer tempId = Integer.parseInt(request.getParameter("id")); 
				FishTank fishTankToEdit = dao.searchForFishTanksById(tempId); 
				request.setAttribute("fishTankToEdit", fishTankToEdit); 
				FishHelper daoForFish = new FishHelper(); 
				request.setAttribute("allFish", daoForFish.showAllItems()); 
				if(daoForFish.showAllItems().isEmpty()){ 
					request.setAttribute("allFish", " "); 
				} 
				getServletContext().getRequestDispatcher("/edit-fishtank.jsp").forward(request, response); 
			} catch (NumberFormatException e) { 
				getServletContext().getRequestDispatcher("/viewAllFishTankServlet").forward(request, response); 
			} 
		 
		} else if (act.equals("add")) { 
			getServletContext().getRequestDispatcher("addFishForListServlet").forward(request, response); 
		}
	}

}
