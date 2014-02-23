package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.supcrowdfunder.entity.Category;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;

/**
 * Servlet implementation class AddProjectServlet
 */
@WebServlet("/project/add")
public class AddProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emf = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProjectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("My-PU");
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Category AS c");
		List<Category> categories = query.getResultList();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/Views/project/add.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String stringCategory_id = request.getParameter("category_id");
		Integer category_id = null;
		Integer amount = 0;
		String stringAmount = request.getParameter("amount");
		if (name.equals("")) {
			request.setAttribute("Error",
					"You have to add a name to your project");
			response.sendRedirect("../project/add");
		}
		if (description.equals("")) {
			request.setAttribute("Error",
					"You have to add a description to your project");
			response.sendRedirect("../project/add");
		}
		if (stringCategory_id.equals("")) {
			request.setAttribute("Error",
					"You have to add a category to your project");
			response.sendRedirect("../project/add");
		} else {
			category_id = Integer.valueOf(stringCategory_id);
		}
		if (stringAmount.equals("")) {
			request.setAttribute("Error",
					"You have to add an amount to your project");
			response.sendRedirect("../project/add");
		}
		try {
			amount = Integer.valueOf(stringAmount);
		} catch (Exception e) {
			request.setAttribute("Error",
					"Check that amount value is a number (decimal)");
			response.sendRedirect("../project/add");
		}

		Project project = new Project();
		project.setName(name);
		project.setDescription(description);

		EntityManager em = emf.createEntityManager();
		Query query = em
				.createQuery("SELECT c FROM Category AS c WHERE c.id = ?1");
		query.setParameter(1, category_id);
		Category category = (Category) query.getSingleResult();

		project.setCategory(category);

		HttpSession session = request.getSession();
		query = em.createQuery("SELECT u FROM User AS u WHERE u.id = ?1");
		Long id = (Long) session.getAttribute("id");
		String stringID = id.toString();
		Integer intId = Integer.valueOf(stringID);
		query.setParameter(1, intId);
		User activeUser = (User) query.getSingleResult();

		project.setUser(activeUser);
		Date now = new Date();
		project.setCreated(now);
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.add(Calendar.MONTH, 3);
		Date threeMonthAfter = c.getTime();
		project.setEndDate(threeMonthAfter);
		project.setAmount(amount);

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(project);
			t.commit();
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
			}
			em.close();
		}
		response.sendRedirect("../project/show/" + project.getId());
	}
}
