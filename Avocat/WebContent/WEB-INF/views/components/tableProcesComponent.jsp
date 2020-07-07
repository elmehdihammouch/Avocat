<%@page import="tools.Date"%>
<%@page import="java.util.Map"%>
<%@page import="models.Proces"%>
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
                                                <option value="3">3</option>
                                                <option value="5">5</option>
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
                                                <option value="3">Client</option>
                                                <option value="4">Advairsaire</option>
                                                <option value="5">Etat d'avancement</option>
                                                <option value="6">Date de creation</option>
                                                <option value="7">Etat du proces</option>
												<option value="8">Numero du proces</option>
                                                <option value="9">Etat de la facture</option>
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
    <% HashMap<String , Proces> map = daoAjouterProces.consulterProces(); %>
   								<span style="display : none" id="mapSize"><%=map.size()%></span>   
                                <table class="table table-data2 " id="tableAvocat">
                                        <thead>
                                            <tr>
                                                <th>
                                                    <label class="au-checkbox" onClick="selectAll()">
                                                        <input type="checkbox" id="check">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </th>
                                                <th style="display:;">idProces</th>
                                                <th style="display:;">idDossier</th>
                                                <th>Client</th>
                                                <th>Advairsaire</th>
                                                <th>Etat d'avancement</th>    
                                                <th>Date de creation</th>
                                                <th>Etat du proces</th>
                                                <th>Numero du proces</th>
                                                <th>Etat de la facture</th>
                                                <th>operations</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                          
  <% 	for (Map.Entry<String, Proces> e : map.entrySet()){
                          
                          		%>         <% if(request.getParameter("idDos") == null){%>     
                                            <tr class="tr-shadow trowM trow">
                                                <%}else if(Integer.parseInt(request.getParameter("idDos"))!=0){%><tr class="tr-shadow trowM trow" style="visibility: collapse;"><%} %>
                                                <td>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox" class="check">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </td>

                                                <td style="display:;"><%=e.getValue().getIdProces()%></td>

                                                <td style="display:;"><%=e.getValue().getIdDos()%></td>
                                                
                                                <td class="3"><%=e.getKey().split(",")[0] %></td>
                                                
                                                <td class="4"><%=e.getValue().getNomAdv()+" "+e.getValue().getPrenomAdv() %></td>
                                                
                                                <td class="5"><%=Proces.statutProces(e.getValue())%></td>

                                                <td class="6"><%=Date.toFDate(e.getValue().getDateCP()) %></td>
                                                
                                <%if(e.getValue().getDateAP()==null) {%>  
                                                <td style="color : orange;" class="7">en attente</td>
                                <%}else { %>     
                                				<td style="color : #00ffcc;" class="7">accepté</td>
                                <%} %>  
                                            <%if(e.getValue().getNumP()!=null) { %>    
                                                <td class="8"><%=e.getValue().getNumP() %></td>
                                            <%}else { %>    
                                                <td class="8">---</td>
                                        	<%} %>
                                                
                                <%if(e.getValue().getFacture().getMtGlobal()-e.getValue().getFacture().getMtpaye()==0) {%>  
                                                <td style="color : #00ffcc;" class="etatFacture" class="9">payée</td>
                                <%}else { %>     
                                				<td style="color : #ff3333;" class="etatFacture" class="9">pas encore payée</td>
                                <%} %> 
                                                
                                                <td>
                                                    <div class="table-data-feature">
                                                        <button class="item afficher btnPopup" data-toggle="tooltip" data-placement="top" title="show" >
                                                            <i class="zmdi zmdi-eye"></i>
                                                        </button>
                                                        <button class="item modifier" data-toggle="tooltip" data-placement="top" title="Edit">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button class="item supprimer" data-toggle="tooltip" data-placement="top" title="Delete">
                                                            <i class="zmdi zmdi-delete"></i>
                                                        </button>
                                                        </div>
                                                </td>
                                            </tr>
                                            

                                            
                                        <!-----------------------------------------------------------------------------------------> 

                                       <%} %>
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