<%@page import="models.Compte"%>
<%@page import="tools.Date"%>
<%@page import="java.util.Map"%>
<%@page import="models.Proces"%>
<%@page import="DAO.daoAjouterProces"%>
<%@page import="java.util.HashMap"%>
<%Integer i =(Integer) request.getAttribute("num");%> 
<section id="main-content">
<div id="tableDiv">

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
                                <h3 class="title-5 m-b-35">Proces</h3>
                                <div class="table-responsive">
    <% HashMap<String , Proces> map = daoAjouterProces.consulterProces(i); %>
   								<span style="display : none" id="mapSize"><%=map.size()%></span>   
                                <table class="table table-data2 " id="tableAvocat">
                                        <thead>
                                            <tr>
                                                <th>
                                                    
                                                </th>
                                                <th style="display:;">idProces</th>
                                                <th style="display:;">idDossier</th>
                                                <th>Advairsaire</th>
                                                <th>Etat d'avancement</th>    
                                                <th>Date de creation</th>
                                                <th>Etat du proces</th>
                                                <th>Numero du proces</th>
                                                <th>Etat de la facture</th>
                                               
                                            </tr>
                                        </thead>
                                        <tbody>
                          
  <% 	for (Map.Entry<String, Proces> e : map.entrySet()){
                          
                          		%>     
                                            <tr class="tr-shadow trowM trow">
                                                <td>
                                                    <i class="fa fa-external-link-square" aria-hidden="true"></i>
                                                </td>

                                                <td style="display:;"><%=e.getValue().getIdProces()%></td>

                                                <td style="display:;"><%=e.getValue().getIdDos()%></td>
                                                
                                                
                                <%try{ %>        
                                         <%if(e.getValue().getNomAdv().equals("") || e.getValue().getPrenomAdv().equals("")) { %> 
                                         		<td class="4">---</td>
                                         <%}else {%>          
                                         <td class="4"><%=e.getValue().getNomAdv()+" "+e.getValue().getPrenomAdv() %></td>   
                                          <%} %>
                                <%}catch(Exception e1){ %>           
                                         <td class="4">---</td>   
                                 <%} %> 
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
      
 </div>    
 
 <div id="affichageDiv"	style="display:none;"	>
	
      <section class="wrapper site-min-height">
        <div class="row">
          <div class="col-lg-10 col-lg-offset-2">
            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
              <div class="custom-box" id="procesBox">
                <div class="servicetitle">
                  <h4>Proces</h4>
                  <hr>
                </div>
                <div class="icn-main-container">
                  <span class="icn-container">P</span>
                </div>
                <p></p>
                <ul class="pricing">
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                </ul>
                <a class="btn btn-theme" href="#" onClick="imprimer('procesBox')">Imprimer</a>
              </div>
              <!-- end custombox -->
            </div>
            <!-- end col-4 -->
            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
              <div class="custom-box" id="factureBox">
                <div class="servicetitle">
                  <h4>Facture</h4>
                  <hr>
                </div>
                <div class="icn-main-container">
                  <span class="icn-container">F</span>
                </div>
                <p></p>
                <ul class="pricing">
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                </ul>
                <a class="btn btn-theme" href="#" onClick="imprimer('factureBox')">Imprimer</a>
              </div>
              <!-- end custombox -->
            </div>
            <!-- end col-4 -->
            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
              <div class="custom-box" id="filesBox">
                <div class="servicetitle">
                  <h4>Files</h4>
                  <hr>
                </div>
                <div class="icn-main-container">
                  <span class="icn-container">FS</span>
                </div>
                <p></p>
                <ul class="pricing">
                
                </ul>
                <a class="btn btn-theme" href="#" onClick="imprimer('filesBox')">Imprimer</a>
              </div>
              <!-- end custombox -->
            </div>
            <div class="col-xs-12">
                    </div>
            
            <div class="col-lg-8 col-md-12 col-sm-12 col-xs-12  ">
            <button class="btn btn-theme" style="white-space: pre;padding-left:315px;padding-right:295px;"id="ret">Precedent</button>
            </div>
            <!-- end col-4 -->
          </div>
          <!--  /col-lg-12 -->
        </div>
        <!--  /row -->
      </section>
      <!-- /wrapper -->
</div>		    			
</section>				
	