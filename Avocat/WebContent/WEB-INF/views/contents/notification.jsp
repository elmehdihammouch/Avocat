<%@page import="DAO.daoAjouterProces"%>
<%@page import="DAO.daoAjouterProces.notif"%>
<%@page import="java.util.ArrayList"%>
<section id="main-content">
<div id="tab" >

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
                                <h3 class="title-5 m-b-35">les évenements à venir</h3>
                                <div class="table-data__tool">
                                    <div class="table-data__tool-left">
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
                                        
                                  </div>
                                  <div class="table-data__tool-right" >
                                        <div class="rs-select2--dark rs-select2--sm rs-select2--dark2" style="width:100px" onChange="trier()">
                                            <select class="js-select2" id="filter" style="width:100px" >
                                                <option selected="selected" value="filters">filters</option>
                                                <option value="1">Numero du proces</option>
                                                <option value="2">Client</option>
                                                <option value="3">CIN</option>
                                                <option value="4">Date</option>
                                                <option value="5">Type de Notif </option>
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
                                <div class="rs-select2--light rs-select2--sm"  onChange="afficher()">
                                        <select class="js-select2" name="" id="aff" >
                                                <option selected="selected" value="">Aucun Type</option>
                                                <option value="Audience">Audience</option>
                                                <option value="Rappel">Rappel</option>
                                                <option value="Payement">Payement</option>
                                            </select>
                                            <div class="dropDownSelect2"></div>
                                        </div>
                                            </div>
                                <div class="table-responsive">
                                
                                <%ArrayList<notif> list = daoAjouterProces.listdenotification(); %>
                                <span style="display : none" id="mapSize"><%=list.size()%></span>
                                    <table class="table table-data2" id="tableAvocat">
                                        <thead>
                                            <tr>
                                                <th style="display:none">
                                                    <label class="au-checkbox" onclick="selectAll()">
                                                        <input type="checkbox" id="check">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </th>
                                                <th style="display:none"></th>
                                                <th>Numero du proces</th>
                                                <th>Client</th>
                                                <th>CIN :</th>
                                                <th>Date : </th>
                                                <th>Type de Notif</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <%for(int i =0 ; i<list.size();i++){%>
                                        	<tr class="tr-shadow trowM trow">	
                                        		<td style="display:none">
                                                    <label class="au-checkbox">
                                                        <input type="checkbox" class="check">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                             					</td>
                                        		<td style="display:none"><%=list.get(i).getIdproces() %></td>
                                                <td class="1"><%if(list.get(i).getNumP()!=null){%><%=list.get(i).getNumP()%><%}else{ %>----<%} %></td>
                                                <td class="2">
                                                    <%=list.get(i).getNomclient()%>
                                                </td>
                                                <td class="desc 3"><%=list.get(i).getCin() %></td>
                                                <td class="4"><%=list.get(i).getDate().split("\\.")[0] %></td>
                                                <td class="5"><%=list.get(i).getNom()%></td>
                                            </tr>
                                           
                                            <%} %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
						</div>
					</div>
				</div>
        	</div>
    		</section>
    	</div>
	</section>            
