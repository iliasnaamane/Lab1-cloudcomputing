/*
 * Copyright 2017 iliasnaamane.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.appengine.helloworld.Controllers;

import com.example.appengine.helloworld.Models.Article;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.TaskOptions;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iliasnaamane
 */
public class PushController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //processRequest(request, response);
         Article a1 = new Article();
        a1.setName("a1");
        a1.setPrice(200);
        a1.setQuantity(5);
        Article a2 = new Article();
        a2.setName("a2");
        a2.setPrice(100);
        a2.setQuantity(10);
        Article a3 = new Article();
        a3.setName("a3");
        a3.setPrice(100);
        a3.setQuantity(10);
        Article a4 = new Article();
        a4.setName("a4");
        a4.setPrice(100);
        a4.setQuantity(10);
        Article a5 = new Article();
        a5.setName("a5");
        a5.setPrice(100);
        a5.setQuantity(10);
        Article a6 = new Article();
        a6.setName("a6");
        a6.setPrice(100);
        a6.setQuantity(10);
        
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
        articles.add(a4);
        articles.add(a5);
        articles.add(a6);
        
        for(Article a : articles){
            Queue queue = QueueFactory.getDefaultQueue();
            queue.add(TaskOptions.Builder.withUrl("/Worker").param("article", a.toString())); 
        }
        PrintWriter outt = response.getWriter();
        outt.println("done");

    }
}
