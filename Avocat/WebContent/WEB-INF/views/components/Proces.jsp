<%@page import="tools.Date"%>
<%@page import="models.Compte"%>
<%@page import="java.util.Map"%>
<%@page import="DAO.daoAjouterProces"%>
<%@page import="models.Proces"%>
<%@page import="java.util.HashMap"%>
<% HttpSession ses = request.getSession();
	 Compte client = null;
	 client = (Compte)session.getAttribute("client"); 
	%> 



<section id="main-content">
<div id="tableDiv">
<form action="ajoutPieceJointe" method="post">
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
    <% HashMap<String , Proces> map = daoAjouterProces.consulterProcesCl(client.getIdClient()); %>
   								<span style="display : none" id="mapSize"><%=map.size()%></span>   
                                <table class="table table-data2 " id="tableAvocat">
                                        <thead>
                                            <tr>
                                                <th>
                                                    
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
                                                
                                                <td class="3"><%=e.getKey().split(",")[0] %></td>
                                                
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
      <input type="hidden" name="num" value="" id="num">
      <input type="submit" style="display:none" id="submit">  
      </form>
      
 </div>    
 </section>