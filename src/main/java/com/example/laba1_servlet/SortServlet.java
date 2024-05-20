package com.example.laba1_servlet;

import java.io.*;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SortServlet", value = "/count")
public class SortServlet extends HttpServlet {
    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String allnums = request.getParameter("InputNumbers");
        String[] splitnums = allnums.strip().split(", ");
        int[] nums = new int[splitnums.length];
        for (int i = 0; i < splitnums.length; i++) {
            nums[i] = Integer.parseInt(splitnums[i]);
        }
        Arrays.sort(nums);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Ваши числа отсортировали!</h1>");
        out.println("<p>" + Arrays.toString(nums) + "</p>");
        out.println("</body></html>");
    }

    public void destroy() {}
}