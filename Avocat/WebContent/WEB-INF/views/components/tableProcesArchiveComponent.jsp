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
                                <h3 class="title-5 m-b-35">Archives des procès</h3>
                                <div class="table-data__tool">
                                    <div class="table-data__tool-left" >
                        <!-- ******************************pagination**************************************** -->    
                              <div class="rs-select2--light rs-select2--md"  onChange="pagination1()">  
                                   
                                            <select class="js-select2" name="" id="pagination1" >
                                                <option selected="selected" value="0">Tous</option>
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
                                                <option value="4">Numero du proces</option>
                                                <option value="5">Client</option>
                                                <option value="6">Advairsaire</option>
                                                <option value="7">CIN advairsaire</option>
                                                <option value="8">Adresse advairsaire</option>
                                                <option value="9">Avocat advairsaire</option>
                                                <option value="10">Instance</option>
                                                <option value="11">Tribunal</option>
                                                <option value="12">Ville</option>
                                                <option value="13">Numero de la salle</option>
                                                <option value="14">Date de notification</option>
                                                <option value="15">Date de la seance</option>
                                                <option value="16">Date de la seance suivante</option>
                                                <option value="17">Date du jugement</option>
                                                <option value="18">Jugement</option>
                                                <option value="19">Date de creation</option>
                                                <option value="20">Date d acceptation</option>
                                                <option value="21">Description</option>
                                                <option value="22">Date de modification</option>
                                           </select>
                                            <div class="dropDownSelect2"></div>
                                        </div>
                              			<div class="rs-select2--light rs-select2--sm"  onChange="trier()">
                         
                                            <select class="js-select2" name="" id="tri">
                                            	<option value="desactive">Desactiver le tri</option>
                                                <option value="croissant">Croissant</option>
                                                <option value="decroissant">Decroissant</option>
                                            </select>
                       
                                            <div class="dropDownSelect2"></div>
                                        </div>
                                        
                                    </div>
                                </div>
                                <div class="table-data__tool"> <div class="table-data__tool-left" ><div class="rs-select2--light rs-select2--md"> <input type="text" id ="search" class="form-control round-form" style="width : 630px" placeholder="search"></div></div></div>
                                
                                <div class="table-responsive">
   <%HashMap<HashMap<String, Proces>, ProcesArch> map = daoAjouterProces.procesArvhive(); %>
   <span style="display : none" id="mapSize"><%=map.size()%></span> 
                                    <table class="table table-data2 table-hover table-striped" id="tableAvocat">
                                        <thead>
                                            <tr>
                                                <th style="color : #4ecdc4" >
                                                    <label class="au-checkbox" onClick="selectAll()">
                                                        <input type="checkbox" id="check">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </th>
                                                <th style="color : #4ecdc4">idProcesArch</th>
                                                <th style="color : #4ecdc4" >idProces</th>
                                                <th style="color : #4ecdc4" >idDossier</th>
                                                <th style="color : #4ecdc4" >Numero du proces</th>
                                                <th style="color : #4ecdc4" >Client</th>
                                                <th style="color : #4ecdc4" >Advairsaire</th>
                                                <th style="color : #4ecdc4" >Cin advairsaire</th>
                                                <th style="color : #4ecdc4" >Adresse advairsaire</th>
                                                <th style="color : #4ecdc4" >Avocat advairsaire</th>
                                                <th style="color : #4ecdc4" >Instance</th>    
                                                <th style="color : #4ecdc4" >Tribunal</th>
                                                <th style="color : #4ecdc4" >Ville</th>
                                                <th style="color : #4ecdc4" >Numero de la salle</th>
                                                <th style="color : #4ecdc4" >Date de notification</th>
                                                <th style="color : #4ecdc4" >Date de la seance</th>
                                                <th style="color : #4ecdc4" >Date de la seance suivante</th>
                                                <th style="color : #4ecdc4" >Date du jugement</th>
                                                <th style="color : #4ecdc4" >Text du jugement</th>
                                                <th style="color : #4ecdc4" >Date de creation</th>
                                                <th style="color : #4ecdc4" >Date d'acceptation</th>
                                                <th style="color : #4ecdc4" >Description</th>
                                                <th style="color : #4ecdc4" >Date de modification</th>
                                            </tr>
                                        </thead>
                                        <tbody>
  
  										
     <%    for (Map.Entry<HashMap<String, Proces>, ProcesArch> e : map.entrySet()){ 
                 for (Map.Entry<String, Proces> ei : e.getKey().entrySet()){ 
                                         %>
                                             
                                       		
                                       
                                            <tr class="tr-shadow trowM trow">
                                                
                                                <td>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox" class="check">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </td>

                                                <td style="display:;"><%=e.getValue().getIdProcesArch()%></td>

                                                <td style="display:;"><%=e.getValue().getIdProces()%></td>
                                                
                                                 <td style="display:;"><%=ei.getValue().getIdDos()%></td>
       		 <%if(ei.getValue().getNumP()!=null){ %>           
                                                <td class="4"><%=ei.getValue().getNumP()%></td>
             <%}else { %>  
                                     			<td class="4">---</td>   
             <%} %>			      
                                                <td class="5"><%=ei.getKey().split(",")[0] %></td>
                                                
             <%if(e.getValue().getNomAdv()!=null && e.getValue().getPrenomAdv()!=null){ %>                                     
                                                <td class="6"><%=e.getValue().getNomAdv()+" "+e.getValue().getPrenomAdv() %></td>
             <%}else { %>  
                                     			<td class="6">---</td>   
             <%} %>
             	
             <%if(ei.getValue().getCinAdv()!=null){ %>                                    
                                                <td class="7"><%=ei.getValue().getCinAdv() %></td>
             <%}else { %>  
                                     			<td class="7">---</td>   
             <%} %>
             
             <%if(e.getValue().getAdresseAdv()!=null){ %>                                   
                                                <td class="8" ><%=e.getValue().getAdresseAdv() %></td>
			 <%}else { %>  
                                     			<td class="8">---</td>   
             <%} %>
             
             <%if(e.getValue().getAvocatAdv()!=null){ %> 
                                                <td class="9"><%=e.getValue().getAvocatAdv() %></td>
            <%}else { %>  
                                     			<td class="9">---</td>   
             <%} %>
            
            
            <%if(ei.getValue().getStatut()==1){ %>
                                                <td class="10">Premiere instance</td>
            <%} else if(ei.getValue().getStatut()==2){ %>
                                                <td class="10">Deuxieme instance</td>
            <%} else { %>
                                                <td class="10">Troisieme instance</td>
            <%} %>
            
            <%if(e.getValue().getTribunal()!=null){ %>                                   
                                                <td class="11"><%=e.getValue().getTribunal() %></td>
             <%}else { %>  
                                     			<td class="11">---</td>   
             <%} %>                                   
                                                
            <%if(e.getValue().getVille()!=null){ %>                                    
                                                
                                                <td class="12"><%=e.getValue().getVille() %></td>
               <%}else { %>  
                                     			<td class="12">---</td>   
             <%} %>                                 
                                                
            <%if(e.getValue().getSaleNum()!=null){ %>                                    
                                                 <td class="13"><%=e.getValue().getSaleNum() %></td>
            <%}else { %>  
                                     			<td class="13">---</td>   
             <%} %>
             
            <%if(Date.toFDate(e.getValue().getDateNotif())!=null){ %>           
                                                <td class="14"><%=Date.toFDate(e.getValue().getDateNotif()) %></td>
             <%}else{ %>
    											<td class="14">---</td>	
             <%} %>  
                                       
			<%if(Date.toFDate(e.getValue().getDateSeance())!=null){ %>           
                                                <td class="15"><%=Date.toFDate(e.getValue().getDateSeance()) %></td>
             <%}else{ %>
    											<td class="15">---</td>	
             <%} %>                               
                                                
			<%if(Date.toFDate(e.getValue().getDateSui())!=null){ %>           
                                                <td class="16"><%=Date.toFDate(e.getValue().getDateSui()) %></td>
             <%}else{ %>
    											<td class="16">---</td>	
             <%} %>                                   
                                                
			<%if(Date.toFDate(e.getValue().getDateJug())!=null){ %>           
                                                <td class="17"><%=Date.toFDate(e.getValue().getDateJug()) %></td>
             <%}else{ %>
    											<td class="17">---</td>	
             <%} %> 
             
             <%if(e.getValue().getTxtJug()!=null){ %>                                   
                                                <td class="18"><%=e.getValue().getTxtJug() %></td>
              <%}else { %>  
                                     			<td class="18">---</td>   
             <%} %>
                                               
                                                
			<%if(Date.toFDate(ei.getValue().getDateCP())!=null){ %>           
                                                <td class="19"><%=Date.toFDate(ei.getValue().getDateCP())%></td>
             <%}else{ %>
    											<td class="19">---</td>	
             <%} %> 
                                                
                                                
			<%if(Date.toFDate(ei.getValue().getDateAP())!=null){ %>           
                                                <td class="20"><%=Date.toFDate(ei.getValue().getDateAP()) %></td>
             <%}else{ %>
    											<td class="20">---</td>	
             <%} %> 
             
             <%if(e.getValue().getDescription()!=null){ %>                                   
                                                <td class="21"><%=e.getValue().getDescription() %></td>
              <%}else { %>  
                                     			<td class="21">---</td>   
             <%} %>
             
             <%if(Date.toFDateXH(e.getValue().getDateModification())!=null){ %>           
                                                <td class="22"><%=Date.toFDateXH(e.getValue().getDateModification()) %></td>
             <%}else{ %>
    											<td class="22">---</td>	
             <%} %>
                                                
                                           
                                				
                                            </tr>
                                            

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