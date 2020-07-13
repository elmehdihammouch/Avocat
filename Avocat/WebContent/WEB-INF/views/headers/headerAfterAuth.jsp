<%@page import="models.Administrateur"%>
<%HttpSession ses = request.getSession();
 Administrateur admin = null;
 admin = (Administrateur)session.getAttribute("admin"); 			
%>




<section id="container">
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
      </div>
      <!--logo start-->
      <a href="index.jsp" class="logo"><b>AVOC<span>AT</span></b></a>
      <!--logo end-->
      <div class="nav notify-row" id="top_menu">
        <!--  notification start -->
        <ul class="nav top-menu">
          <!-- settings start -->

          <!-- inbox dropdown end -->
          <!-- notification dropdown start-->
          <li id="header_notification_bar" class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" >
              <i class="fa fa-bell-o"></i>
              <span class="badge bg-warning nbnotif">0</span>
            </a>
            <ul class="dropdown-menu extended notification" style="overflow: auto;max-height: 90vh;">
              <div class="notify-arrow notify-arrow-yellow"></div>
              <li>
                
              </li>
              
             <!--  = <li>
                <a href="index.html#">See all notifications</a>
              </li>-->
            </ul>
          </li>
          <!-- notification dropdown end -->
        </ul>
        <!--  notification end -->
      </div>
      
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li><a class="logout" href="">deconnexion</a></li>
        </ul>
      </div>
    </header>
    <!--header end-->
    <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
          
        <ul class="sidebar-menu" id="nav-accordion">
          <p class="centered"><a href="profile.html"><img src="<%if(admin!=null){%>
          <%=admin.getImageUrl()%>
          <%} %>" class="img-circle" width="80"></a></p>
          <h5 class="centered"><%if(admin!=null){%>
          <%=admin.getNom() %>
            &nbsp  
          <%=admin.getPrenom() %>
          <%} %></h5>
            
           <li >
                <a href="#" class="">
                <i class="fa fa-home"></i>
                <span>Accueil </span>
                </a>
           </li>
          
           <li class="sub-menu">
            <a href="javascript:;" >
              <i class="fa fa-user"></i>
              <span>Gestion Client</span>
              </a>
            <ul class="sub">
            	<li id="consulterClient"><a href="http://localhost:8085/Avocat/ConsulterClient">consulter liste clients</a></li>
            </ul>
           </li>
          
           <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-handshake-o"></i>
              <span>Gestion des consultations</span>
            </a>
            <ul class="sub">
              <li id="creerConsultation"><a href="http://localhost:8085/Avocat/AjouterConsultation" >creer une consultation</a></li>
              <li id="consulterConsultation"><a href="http://localhost:8085/Avocat/ConsulterConsultation" > Liste des consultations</a></li>
            </ul>
           </li>

           <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-folder" aria-hidden="true"></i>
              <span>Gestion des dossiers</span>
            </a>
            <ul class="sub">
              <li id="creerDossier"><a href="http://localhost:8085/Avocat/AjouterDossier" >creer un dossier</a></li>
              <li id="consulterDossier"><a href="http://localhost:8085/Avocat/ConsulterDossier" >consulter liste des dossiers</a></li>
            </ul>
           </li>

           <li class="sub-menu">
            <a href="javascript:;" >
              <i class="fa fa-gavel"></i>
              <span>Gestion des Proces</span>
            </a>
            <ul class="sub">
              <li id="createProces"><a href="http://localhost:8085/Avocat/AjouterProces">Créer un proces</a></li>
              <li id="consulterProces"><a href="http://localhost:8085/Avocat/ConsulterProces">consulter liste des proces</a></li>
            </ul>
           </li>
           
           <li class="sub-menu">
            <a href="javascript:;" >
              <i class="fa fa-archive" aria-hidden="true"></i>
              <span>Archive</span>
            </a>
            <ul class="sub">
              <li id="procesArchive"><a href="http://localhost:8085/Avocat/ProcesArchive">Archive des proces</a></li>
              <li id="factureArchive"><a href="http://localhost:8085/Avocat/FactureArchive">Archive des factures</a></li>
            </ul>
           </li>

            
           

          
       </ul>
      </div>
    </aside>
  </section>