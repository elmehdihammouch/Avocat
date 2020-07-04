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
                                    <div class="table-data__tool-left" >
                        <!-- ******************************pagination**************************************** -->    
                              <div class="rs-select2--light rs-select2--md"  onChange="pagination1()">  
                                   
                                            <select class="js-select2" name="" id="pagination1" >
                                                <option selected="selected" value="0">All Properties</option>
                                                <option value="1">3</option>
                                                <option value="2">5</option>
                                                <option value="7">7</option>
                                                <option value="10">10</option>
                                                <option value="15">15</option>
                                              	<option value="10">10</option>
                                                <option value="20">20</option>
                                                <option value="30">30</option>
                                                <option value="40">40</option>
                                                <option value="50">50</option>
                                                <option value="60">60</option>
                                                <option value="70">70</option>
                                                <option value="80">80</option>
                                                <option value="90">90</option>
                                                <option value="100">100</option>
                                            </select>
                       <!-- ************************************************************************************ -->     
                                            <div class="dropDownSelect2"></div>
                                        </div>
                 	 <!-- ******************************pagination**************************************** --> 
                                        <div class="rs-select2--light rs-select2--sm"  onChange="pagination2()">
                         
                                            <select class="js-select2" name="" id="pagination2">
                                                
                                            </select>
                       
                                            <div class="dropDownSelect2"></div>
                                        </div>
                     <!-- *********************************************************************************** --> 
                     
                  
                  
                                 
                                        <button class="au-btn-filter" onClick="deleteAll()"><i class="fas fa-dumpster"></i></button>
                                    </div>
                                    
                                    <div class="table-data__tool-right" >
                                        <div class="rs-select2--dark rs-select2--sm rs-select2--dark2" style="width:100px" onChange="trier()">
                                            <select class="js-select2" id="filter" style="width:100px" >
                                                <option selected="selected" value="filters">filters</option>
                                                <option value="1">Numero de la facture</option>
                                                <option value="2">Numero de la sous-facture</option>
                                                <option value="3">Longueur Km</option>
                                                <option value="4">Prix par Km</option>
                                                <option value="5">Indemnité kilométrique</option>
                                                <option value="6">Durée du logement</option>
                                                <option value="7">Frais par jour</option>
                                                <option value="8">Frais du logement</option>
                                                <option value="9">Montant Payée</option>
                                                <option value="10">Date de payement</option>
                                                <option value="11">Date de modification</option>
                                            </select>
                                            <div class="dropDownSelect2"></div>
                                        </div>
                              			<div class="rs-select2--light rs-select2--sm"  onChange="trier()">
                         
                                            <select class="js-select2" name="" id="tri">
                                            	<option value="desactive">Tri dessactivé</option>
                                                <option value="croissant">Croissant</option>
                                                <option value="decroissant">Decroissant</option>
                                            </select>
                       
                                            <div class="dropDownSelect2"></div>
                                        </div>
                                        
                                    </div>
                                </div>
                                <div class="table-data__tool"> <div class="table-data__tool-left" ><div class="rs-select2--light rs-select2--md"  > <input type="text" id ="search" class="form-control round-form" style="width : 630px" placeholder="search"></div></div></div>
                                <div class="table-responsive">
     <%ArrayList<FactureArch> fa = daoAjouterProces.factureArchive(); %>
     								<span style="display : none" id="mapSize"><%=fa.size()%></span>   
                                    <table class="table table-data2 " id="tableAvocat">
                                        <thead>
                                            <tr>
                                                <th>
                                                    <label class="au-checkbox" onClick="selectAll()">
                                                        <input type="checkbox" id="check">
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
  
  <% 	for(FactureArch f : fa){ %>
                                             
                                       		
                                       
                                            <tr class="tr-shadow trowM trow">
                                                
                                                <td>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox" class="check">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </td>

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