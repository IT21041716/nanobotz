package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile_servlet")
public class profile_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userID = request.getParameter("uid");
        int uid = 0;
        System.out.println(userID);

        try {
            uid = Integer.parseInt(userID);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Handle the case when uid is not a valid integer
            response.getWriter().println("Invalid UID provided.");
            return;
        }

        try {
            List<Combine> profileDetails = DBUtill.userDetails(uid);

            if (profileDetails != null && !profileDetails.isEmpty()) {
                request.setAttribute("profileDetails", profileDetails);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            } else {
                response.getWriter().println("No profile details found for the given UID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred while processing the request.");
        }
    }
}
