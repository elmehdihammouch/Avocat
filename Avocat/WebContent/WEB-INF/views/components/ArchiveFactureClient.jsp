<%@page import="models.Compte"%>
<%@page import="models.FactureArch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="tools.Date"%>
<%@page import="java.util.Map"%>
<%@page import="models.Proces"%>
<%@page import="models.ProcesArch"%>
<%@page import="DAO.daoAjouterProces"%>
<%@page import="java.util.HashMap"%>
<% HttpSession ses = request.getSession();
	 Compte client = null;
	 client = (Compte)session.getAttribute("client"); 
		 if(client==null)
					 {
			 request.getRequestDispatcher("ClientAuthentification.jsp").forward(request, response);
					 }
	%> 
<div id="tableDiv">
<section id="main-content">
      <section class="wrapper">
        <div class="row mb">
          <!-- page start-->
          <div class="content-panel">
            <div class="adv-table">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        
                               <div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Archives des factures</h3>
                                
                                <div class="table-responsive">
     <%ArrayList<FactureArch> fa = daoAjouterProces.factureArchive(client.getIdClient()); %>
     								<span style="display : none" id="mapSize"><%=fa.size()%></span>   
                                    <table class="table table-data2 " id="tableAvocat">
                                        <thead>
                                            <tr>
                                                <th style="display:;">Numero de la facture</th>
                                                <th style="display:;">Numero de la sous-facture</th>
                                                <th>Longueur Km</th>
                                                <th>Prix par Km</th>
                                                <th>Indemnité kilométrique</th>
                                                <th>Durée du logement</th>
                                                <th>Frais par jour</th>
                                                <th>Frais du logement</th>
                                                <th>Montant Payée</th>
                                                <th>Date de payement</th>
                                                <th>Date de modification</th>
                                            </tr>
                                        </thead>
                                        <tbody>
  
  <% 	for(FactureArch f : fa){ %>
                                             
                                       		
                                       
                                            <tr class="tr-shadow trowM trow">
                                                

                                                <td class="1"><%=f.getIdFacture() %></td>
                                  
                                                <td class="2"><%=f.getIdFactureArch() %></td>
 <%if(f.getLgKm()!=0) {%>                                              
                                                <td class="3"><%=f.getLgKm() %></td>
 <%}else { %>         
												<td class="3">-</td>  
                                                 
                                                
  <%}if(f.getPrKm()!=0) {%>
                                                <td class="4"><%=f.getPrKm() %></td>
   <%}else { %>         
												<td class="4">-</td>                                              
                                                
  <%}if(f.getPrKm()!=0 || f.getLgKm()!=0) {%>                                              
                                                <td style="color:#ff6666" class="5"><%=f.getPrKm()*f.getLgKm() %></td>
  <%}else { %>         
												<td style="color:#ff6666" class="5">-</td> 
  
  <%}if(f.getDureeJr()!=0) {%>                                               
                                                <td class="6"><%=f.getDureeJr() %></td>
   <%}else { %>         
												<td class="6">-</td> 
   
   <%}if(f.getPrixJr()!=0) {%>                                             
                                                <td class="7"><%=f.getPrixJr() %></td>
   <%}else { %>         
												<td class="7">-</td>    
      
   <%}if(f.getPrixJr()!=0 || f.getDureeJr()!=0) {%>                                             
                                                <td style="color:#ff6666" class="8"><%=f.getPrixJr()*f.getDureeJr() %></td>
    <%}else { %>         
												<td style="color:#ff6666" class="8">-</td> 
    
    <%}if(f.getMtPaye()!=0) {%>                                            
                                                <td style="color: #66ffcc" class="9"><%=f.getMtPaye() %></td>
    <%}else { %>         
												<td style="color: #66ffcc" class="9">-</td> 
	<%}if(Date.toFDateXH(f.getDatePayement())!=null) {%>											                                            
                                                <td class="10"><%=Date.toFDateXH(f.getDatePayement()) %></td>
     <%}else { %>         
												<td class="10">---</td> 
	<%} %>											                                           
                                                <td class="11"><%=Date.toFDateXH(f.getDateModifcation()) %></td>
                                              
                                            </tr>
                                            

                                          <%}%>
                                        <!-----------------------------------------------------------------------------------------> 

                                     
                                        <!-----------------------------------------------------------------------------------------> 
                                            
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                        

                    </div>
                </div>
            </div>
          </div> 
        </div>  
      </section> 
    </section>  
 </div>    