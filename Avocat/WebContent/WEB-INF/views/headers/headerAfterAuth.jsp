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
      <a href="index.html" class="logo"><b>AVOC<span>AT</span></b></a>
      <!--logo end-->
      <div class="nav notify-row" id="top_menu">
        <!--  notification start -->
        <ul class="nav top-menu">
          <!-- notification dropdown start-->
          <li id="header_notification_bar" class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#" >
                
              <i class="fa fa-bell-o" ></i>
              <span class="badge bg-warning">7</span>
              </a>
            <ul class="dropdown-menu extended notification">
              <div class="notify-arrow notify-arrow-yellow"></div>
              <li>
                <p class="yellow">You have 7 new notifications</p>
              </li>
              <li>
                <a href="index.html#">
                  <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                  Server Overloaded.
                  <span class="small italic">4 mins.</span>
                  </a>
              </li>
              <li>
                <a href="index.html#">
                  <span class="label label-warning"><i class="fa fa-bell"></i></span>
                  Memory #2 Not Responding.
                  <span class="small italic">30 mins.</span>
                  </a>
              </li>
              <li>
                <a href="index.html#">
                  <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                  Disk Space Reached 85%.
                  <span class="small italic">2 hrs.</span>
                  </a>
              </li>
              <li>
                <a href="index.html#">
                  <span class="label label-success"><i class="fa fa-plus"></i></span>
                  New User Registered.
                  <span class="small italic">3 hrs.</span>
                  </a>
              </li>
              <li>
                <a href="index.html#">See all notifications</a>
              </li>
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
              <i class="fa fa-gavel"></i>
              <span>Gestion des consultations</span>
            </a>
            <ul class="sub">
              <li id="creerConsultation"><a href="http://localhost:8085/Avocat/AC" >creer une consultation</a></li>
              <li id="consulterConsultation"><a href="http://localhost:8085/Avocat/CC" > Liste des consultations</a></li>
            </ul>
           </li>

           <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-gavel"></i>
              <span>Gestion des dossiers</span>
            </a>
            <ul class="sub">
              <li id="creerDossier"><a href="http://localhost:8085/Avocat/AD" >creer un dossier</a></li>
              <li id="consulterDossier"><a href="http://localhost:8085/Avocat/CD" >consulter liste des dossiers</a></li>
            </ul>
           </li>

           <li class="sub-menu">
            <a href="javascript:;" >
              <i class="fa fa-gavel"></i>
              <span>Gestion des Proces</span>
            </a>
            <ul class="sub">
              <li id="createProces"><a href="http://localhost:8085/Avocat/AjouterProces">Cr�er un proces</a></li>
              <li id="consulterProces"><a href="http://localhost:8085/Avocat/ConsulterProces">consulter liste des proces</a></li>
            </ul>
           </li>
           
           <li class="sub-menu">
            <a href="javascript:;" >
              <i class="fa fa-gavel"></i>
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