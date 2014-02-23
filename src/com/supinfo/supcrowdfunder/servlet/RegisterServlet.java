package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;

import javax.persistence.Entity;
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

import com.supinfo.supcrowdfunder.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/user/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emf = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("My-PU");
		super.init();
	}

	@Override
	public void destroy() {
		emf.close();
		super.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Views/users/register.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		if (password1.equals(password2)) {
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPassword(password1);
			user.setAdmin(false);
			EntityManager em = emf.createEntityManager();
			Query query = em
					.createQuery("SELECT u FROM User AS u WHERE email = '"
							+ email + "'");
			if (query.getResultList().isEmpty()) {
				EntityTransaction t = em.getTransaction();
				try {
					t.begin();
					em.persist(user);
					t.commit();
				} catch (Exception e) {
					if (t.isActive()) {
						t.rollback();
					}
					em.close();
				}
				response.sendRedirect("../");
			} else {
				request.setAttribute("error",
						"User with this email already exists");
				request.getRequestDispatcher("/Views/users/register.jsp")
						.forward(request, response);
			}
		} else {
			request.setAttribute("error", "Password 1 doesn't match password 2");
			request.getRequestDispatcher("/Views/users/register.jsp").forward(
					request, response);
		}
	}

}
