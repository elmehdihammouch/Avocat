<%@page import="DAO.daoAjouterDossier.MyResult"%>
<%@page import="DAO.daoAjouterDossier"%>
<%@page import="DAO.daoAjouterProces"%>
<%@page import="models.Dossier"%>
<%@page import="DAO.daoAjouterConsultation"%>
<%@page import="models.Consultation"%>
<%@page import="models.Client"%>
<%@page import="DAO.daoClient"%>
<%@page import="java.util.ArrayList"%>
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
                                <h3 class="title-5 m-b-35">data table</h3>
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
                                  <button class="au-btn-filter" onClick="deleteAll()"><i class="fas fa-dumpster"></i></button>
                                  </div>
                                  <div class="table-data__tool-right" >
                                        <div class="rs-select2--dark rs-select2--sm rs-select2--dark2" style="width:100px" onChange="trier()">
                                            <select class="js-select2" id="filter" style="width:100px" >
                                                <option selected="selected" value="filters">filters</option>
                                                <option value="2">Nom</option>
                                                <option value="3">Prenom</option>
                                                <option value="4">Cin</option>
                                                <option value="5">Type Proces</option>
                                                <option value="6">Etat Avancement </option>
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
                                <%ArrayList<MyResult> list = daoAjouterDossier.listDossier(); %>
                                <span style="display : none" id="mapSize"><%=list.size()%></span>
                                    <table class="table table-data2" id="tableAvocat">
                                        <thead>
                                            <tr>
                                                <th>
                                                    <label class="au-checkbox" onclick="selectAll()">
                                                        <input type="checkbox" id="check">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </th>
                                                <th>Id Dossier</th>
                                                <th>nom</th>
                                                <th>prenom</th>
                                                <th>CIN</th>
                                                <th>Type de procés</th>
                                                <th>Etat Avancemant</th>
                                                <th>Operation</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                        String stat = null;
                                        	for(int i =0 ; i<list.size();i++){
                                        	if(list.get(i).getStatut()==1){
                                        		stat ="Premiere Instance";}else if(list.get(i).getStatut()==2){stat="Deuxieme instance";}else if(list.get(i).getStatut()==3){stat="troisieme instance";}%>
											<tr class="tr-shadow trowM trow">
                                                <td>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox" class="check">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                             					</td>
                                                <td><%=list.get(i).getDossier().getIdDos()%></td>
                                                <td class="2"><%=list.get(i).getDossier().getClient().getNom()%></td>
                                                <td class="3">
                                                    <%=list.get(i).getDossier().getClient().getPrenom() %>
                                                </td>
                                                <td class="desc 4"><%=list.get(i).getDossier().getClient().getCin() %></td>
                                                <td class="5"><%=list.get(i).getDossier().getTypeProces() %></td>
                                                <td class="6">
                                                    <span style="font-size: 1em"><%=stat %></span>
                                                </td>
                                                <td>
                                                    <div class="table-data-feature">
                                                        <button class="item affiche btnPopup" data-toggle="tooltip" data-placement="top" title="Eye" >
                                                            <i class="zmdi zmdi-eye"></i>
                                                        </button>
                                                        <button class="item modifie" data-toggle="tooltip" data-placement="top" title="Edit" >
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button class="item supprime" data-toggle="tooltip" data-placement="top" title="Delete">
                                                            <i class="zmdi zmdi-delete"></i>
                                                        </button>
                                                        </div>
                                                </td>
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
    	</div>
	</section>            
</div>