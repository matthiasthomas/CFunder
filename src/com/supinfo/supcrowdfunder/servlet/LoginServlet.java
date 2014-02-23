package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.supcrowdfunder.entity.Category;
import com.supinfo.supcrowdfunder.entity.User;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/user/login")
public class LoginServlet extends HttpServlet {

	private EntityManagerFactory emf = null;

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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/Views/users/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		EntityManager em = emf.createEntityManager();

		Query q = em
				.createQuery("select u from User as u where u.email = :email and u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		User user = (User) q.getSingleResult();
		em.close();

		if (email != null && email.equals(user.getEmail().toString())) {
			if (password != null
					&& password.equals(user.getPassword().toString())) {
				HttpSession session = req.getSession();
				session.setAttribute("email", user.getEmail().toString());
				session.setAttribute("id", user.getId().longValue());
				System.out.println("======>" + session.getAttribute("email"));
				resp.sendRedirect("/CFunder");
			} else {
				System.out.println("Connection failed / bad password");
				resp.sendRedirect("/CFunder/user/login");
			}
		} else {
			resp.sendRedirect("/CFunder/user/login");
		}
	}
}
