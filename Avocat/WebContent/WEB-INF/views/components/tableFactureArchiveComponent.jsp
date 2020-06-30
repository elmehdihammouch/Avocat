<%@page import="models.FactureArch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="tools.Date"%>
<%@page import="java.util.Map"%>
<%@page import="models.Proces"%>
<%@page import="models.ProcesArch"%>
<%@page import="DAO.daoAjouterProces"%>
<%@page import="java.util.HashMap"%>
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
                                <h3 class="title-5 m-b-35">data table</h3>
                                <div class="table-data__tool">
                                    <div class="table-data__tool-left">
                                        <div class="rs-select2--light rs-select2--md">
                                            <select class="js-select2" name="property">
                                                <option selected="selected">All Properties</option>
                                                <option value="">Option 1</option>
                                                <option value="">Option 2</option>
                                            </select>
                                            <div class="dropDownSelect2"></div>
                                        </div>
                                        <div class="rs-select2--light rs-select2--sm">
                                            <select class="js-select2" name="time">
                                                <option selected="selected">Today</option>
                                                <option value="">3 Days</option>
                                                <option value="">1 Week</option>
                                            </select>
                                            <div class="dropDownSelect2"></div>
                                        </div>
                                        <button class="au-btn-filter">
                                            <i class="zmdi zmdi-filter-list"></i>filters</button>
                                    </div>
                                    <div class="table-data__tool-right">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small">
                                            <i class="zmdi zmdi-plus"></i>add item</button>
                                        <div class="rs-select2--dark rs-select2--sm rs-select2--dark2">
                                            <select class="js-select2" name="type">
                                                <option selected="selected">Export</option>
                                                <option value="">Option 1</option>
                                                <option value="">Option 2</option>
                                            </select>
                                            <div class="dropDownSelect2"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="table-responsive">
                                    <table class="table table-data2 ">
                                        <thead>
                                            <tr>
                                                <th>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </th>
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
  <%ArrayList<FactureArch> fa = daoAjouterProces.factureArchive();
  	for(FactureArch f : fa){
                                         %>
                                             
                                       		
                                       
                                            <tr class="tr-shadow trowM">
                                                
                                                <td>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </td>

                                                <td><%=f.getIdFacture() %></td>
                                  
                                                <td><%=f.getIdFactureArch() %></td>
 <%if(f.getLgKm()!=0) {%>                                              
                                                <td><%=f.getLgKm() %></td>
 <%}else { %>         
												<td>-</td>  
                                                 
                                                
  <%}if(f.getPrKm()!=0) {%>
                                                <td><%=f.getPrKm() %></td>
   <%}else { %>         
												<td>-</td>                                              
                                                
  <%}if(f.getPrKm()!=0 || f.getLgKm()!=0) {%>                                              
                                                <td style="color:#ff6666"><%=f.getPrKm()*f.getLgKm() %></td>
  <%}else { %>         
												<td style="color:#ff6666">-</td> 
  
  <%}if(f.getDureeJr()!=0) {%>                                               
                                                <td><%=f.getDureeJr() %></td>
   <%}else { %>         
												<td>-</td> 
   
   <%}if(f.getPrixJr()!=0) {%>                                             
                                                <td><%=f.getPrixJr() %></td>
   <%}else { %>         
												<td>-</td>    
      
   <%}if(f.getPrixJr()!=0 || f.getDureeJr()!=0) {%>                                             
                                                <td style="color:#ff6666"><%=f.getPrixJr()*f.getDureeJr() %></td>
    <%}else { %>         
												<td style="color:#ff6666">-</td> 
    
    <%}if(f.getMtPaye()!=0) {%>                                            
                                                <td style="color: #66ffcc"><%=f.getMtPaye() %></td>
    <%}else { %>         
												<td style="color: #66ffcc">-</td> 
	<%}if(Date.toFDateXH(f.getDatePayement())!=null) {%>											                                            
                                                <td><%=Date.toFDateXH(f.getDatePayement()) %></td>
     <%}else { %>         
												<td>---</td> 
	<%} %>											                                           
                                                <td><%=Date.toFDateXH(f.getDateModifcation()) %></td>
                                              
                                            </tr>
                                            <tr class="spacer"></tr>

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