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
                                                <th style="display:none;">idProcesArch</th>
                                                <th style="display:none;">idProces</th>
                                                <th style="display:none;">idDossier</th>
                                                <th>Numero du proces</th>
                                                <th>Client</th>
                                                <th>Advairsaire</th>
                                                <th>Cin advairsaire</th>
                                                <th>Adresse advairsaire</th>
                                                <th>Avocat advairsaire</th>
                                                <th>Instance</th>    
                                                <th>Tribunal</th>
                                                <th>Ville</th>
                                                <th>Numero de la salle</th>
                                                <th>Date de notification</th>
                                                <th>Date de la seance</th>
                                                <th>Date de la seance suivante</th>
                                                <th>Date du jugement</th>
                                                <th>Text du jugement</th>
                                                <th>Date de creation</th>
                                                <th>Date d'acceptation</th>
                                                <th>Description</th>
                                                <th>Date de modification</th>
                                            </tr>
                                        </thead>
                                        <tbody>
  <%HashMap<HashMap<String, Proces>, ProcesArch> map = daoAjouterProces.procesArvhive(); 
         for (Map.Entry<HashMap<String, Proces>, ProcesArch> e : map.entrySet()){ 
                 for (Map.Entry<String, Proces> ei : e.getKey().entrySet()){ 
                                         %>
                                             
                                       		
                                       
                                            <tr class="tr-shadow trowM">
                                                
                                                <td>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </td>

                                                <td style="display:none;"><%=e.getValue().getIdProcesArch() %></td>

                                                <td style="display:none;"><%=e.getValue().getIdProces() %></td>
                                                
                                                 <td style="display:none;"><%=ei.getValue().getIdDos()%></td>
       		 <%if(ei.getValue().getNumP()!=null){ %>           
                                                <td><%=ei.getValue().getNumP() %></td>
             <%}else { %>  
                                     			<td>---</td>   
             <%} %>			      
                                                <td><%=ei.getKey().split(",")[0] %></td>
                                                
             <%if(e.getValue().getNomAdv()!=null && e.getValue().getPrenomAdv()!=null){ %>                                     
                                                <td><%=e.getValue().getNomAdv()+" "+e.getValue().getPrenomAdv() %></td>
             <%}else { %>  
                                     			<td>---</td>   
             <%} %>
             	
             <%if(ei.getValue().getCinAdv()!=null){ %>                                    
                                                <td><%=ei.getValue().getCinAdv() %></td>
             <%}else { %>  
                                     			<td>---</td>   
             <%} %>
             
             <%if(e.getValue().getAdresseAdv()!=null){ %>                                   
                                                <td><%=e.getValue().getAdresseAdv() %></td>
			 <%}else { %>  
                                     			<td>---</td>   
             <%} %>
             
             <%if(e.getValue().getAvocatAdv()!=null){ %> 
                                                <td><%=e.getValue().getAvocatAdv() %></td>
            <%}else { %>  
                                     			<td>---</td>   
             <%} %>
            
            
            <%if(ei.getValue().getStatut()==1){ %>
                                                <td>Premiere instance</td>
            <%} else if(ei.getValue().getStatut()==2){ %>
                                                <td>Deuxieme instance</td>
            <%} else { %>
                                                <td>Troisieme instance</td>
            <%} %>
            
            <%if(e.getValue().getTribunal()!=null){ %>                                   
                                                <td><%=e.getValue().getTribunal() %></td>
             <%}else { %>  
                                     			<td>---</td>   
             <%} %>                                   
                                                
            <%if(e.getValue().getVille()!=null){ %>                                    
                                                
                                                <td><%=e.getValue().getVille() %></td>
               <%}else { %>  
                                     			<td>---</td>   
             <%} %>                                 
                                                
            <%if(e.getValue().getSaleNum()!=null){ %>                                    
                                                 <td><%=e.getValue().getSaleNum() %></td>
            <%}else { %>  
                                     			<td>---</td>   
             <%} %>
             
            <%if(Date.toFDate(e.getValue().getDateNotif())!=null){ %>           
                                                <td><%=Date.toFDate(e.getValue().getDateNotif()) %></td>
             <%}else{ %>
    											<td>---</td>	
             <%} %>  
                                       
			<%if(Date.toFDate(e.getValue().getDateSeance())!=null){ %>           
                                                <td><%=Date.toFDate(e.getValue().getDateSeance()) %></td>
             <%}else{ %>
    											<td>---</td>	
             <%} %>                               
                                                
			<%if(Date.toFDate(e.getValue().getDateSui())!=null){ %>           
                                                <td><%=Date.toFDate(e.getValue().getDateSui()) %></td>
             <%}else{ %>
    											<td>---</td>	
             <%} %>                                   
                                                
			<%if(Date.toFDate(e.getValue().getDateJug())!=null){ %>           
                                                <td><%=Date.toFDate(e.getValue().getDateJug()) %></td>
             <%}else{ %>
    											<td>---</td>	
             <%} %> 
             
             <%if(e.getValue().getTxtJug()!=null){ %>                                   
                                                <td><%=e.getValue().getTxtJug() %></td>
              <%}else { %>  
                                     			<td>---</td>   
             <%} %>
                                               
                                                
			<%if(Date.toFDate(ei.getValue().getDateCP())!=null){ %>           
                                                <td><%=Date.toFDate(ei.getValue().getDateCP())%></td>
             <%}else{ %>
    											<td>---</td>	
             <%} %> 
                                                
                                                
			<%if(Date.toFDate(ei.getValue().getDateAP())!=null){ %>           
                                                <td><%=Date.toFDate(ei.getValue().getDateAP()) %></td>
             <%}else{ %>
    											<td>---</td>	
             <%} %> 
             
             <%if(e.getValue().getDescription()!=null){ %>                                   
                                                <td><%=e.getValue().getDescription() %></td>
              <%}else { %>  
                                     			<td>---</td>   
             <%} %>
             
             <%if(Date.toFDateXH(e.getValue().getDateModification())!=null){ %>           
                                                <td><%=Date.toFDateXH(e.getValue().getDateModification()) %></td>
             <%}else{ %>
    											<td>---</td>	
             <%} %>
                                                
                                           
                                				
                                            </tr>
                                            <tr class="spacer"></tr>

                                          <%} }%>
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