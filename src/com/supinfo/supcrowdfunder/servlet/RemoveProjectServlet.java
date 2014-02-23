package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunder.entity.Project;

/**
 * Servlet implementation class RemoveProjectServlet
 */
@WebServlet("/project/remove")
public class RemoveProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emf = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveProjectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		emf = Persistence.createEntityManagerFactory("My-PU");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		emf.close();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer projectID = Integer.valueOf(request.getParameter("id"));
		EntityManager em = emf.createEntityManager();
		Query query = em
				.createQuery("SELECT p FROM Project AS p WHERE p.id = ?1");
		query.setParameter(1, projectID);
		if (query.getResultList().isEmpty()) {
			response.sendRedirect("/CFunder/projects");
		}
		Project project = (Project) query.getSingleResult();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.remove(project);
			t.commit();
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
				em.close();
			}
		}
	}
}
