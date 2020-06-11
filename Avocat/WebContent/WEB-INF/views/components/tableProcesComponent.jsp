<%@page import="tools.Date"%>
<%@page import="java.util.Map"%>
<%@page import="models.Proces"%>
<%@page import="DAO.daoAjouterProces"%>
<%@page import="java.util.HashMap"%>
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
                                <div class="table-responsive table-responsive-data2">
                                    <table class="table table-data2 ">
                                        <thead>
                                            <tr>
                                                <th>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </th>
                                                <th style="display:none;">idProces</th>
                                                <th style="display:none;">idDossier</th>
                                                <th>Client</th>
                                                <th>Advairsaire</th>
                                                <th>statut</th>    
                                                
                                                <th>Date de creation</th>
                                                <th>Etat</th>
                                                <th>Numero du proces</th>
                                                      
                                                <th>Etat facture</th>
                                                <th>operations</th>
                                            </tr>
                                        </thead>
                                        <tbody><!-- <span class="block-email">lori@example.com</span>    green : class="status--process" -->
                          <% HashMap<String , Proces> map = daoAjouterProces.consulterProces(); 
                          	for (Map.Entry<String, Proces> e : map.entrySet()){
                          
                          		%>              
                                            <tr class="tr-shadow">
                                                
                                                <td>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </td>

                                                <td style="display:none;"><%=e.getValue().getIdProces() %></td>

                                                <td style="display:none;"><%=e.getValue().getIdDos() %></td>
                                                
                                                <td ><%=e.getKey() %></td>
                                                
                                                <td><%=e.getValue().getNomAdv()+" "+e.getValue().getPrenomAdv() %></td>
                                                
                                                <td><%=Proces.statutProces(e.getValue())%></td>

                                                <td><%=Date.toFDate(e.getValue().getDateCP()) %></td>
                                                
                                <%if(e.getValue().getDateAP()==null) {%>  
                                                <td style="color : orange;">en attente</td>
                                <%}else { %>     
                                				<td style="color : #00ffcc;">accepté</td>
                                <%} %>  
                                                
                                                <td><%=e.getValue().getNumP() %></td>
                                                
                                                
                                        
                                                
                                <%if(e.getValue().getFacture().getMtGlobal()-e.getValue().getFacture().getMtpaye()==0) {%>  
                                                <td style="color : #00ffcc;">payée</td>
                                <%}else { %>     
                                				<td style="color : #ff3333;">pas encore payée</td>
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
                                            <tr class="spacer"></tr>

                                            
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