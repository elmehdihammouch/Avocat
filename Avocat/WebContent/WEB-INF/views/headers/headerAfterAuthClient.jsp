<%@page import="DAO.daoClient"%>
<%@page import="models.Compte"%>
<% HttpSession ses = request.getSession();
	 Compte client = null;
	 client = (Compte)session.getAttribute("client"); 
	%> 
<section id="container">
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
      </div>
      <!--logo start-->
      <a href="./" class="logo"><b>AVOC<span>AT</span></b></a>
      <!--logo end-->
      <div class="nav notify-row" id="top_menu">
        <!--  notification start -->
      
      </div>
   <form action="AuthentificationClient" method="get">   
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li><a class="logout" id="dis" href="#">deconnexion</a></li>
          <input type="hidden" value="disconnect" name="operation">
        </ul>
      </div>
      </form>
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
          <ul class="sidebar-menu" id="nav-accordion">
          <h5 class="centered"><%=daoClient.nomcplt(client.getIdClient()) %></h5>
          
            
           <li id="Dossier">
                <a href="./AccueilClient" class="">
                <i class="fa fa-folder" aria-hidden="true"></i>
                <span id="AccueilSB1">Dossier </span>
                </a>
           </li>
          
           <li id="">
                <a href="./ArchiveClient" class="">
                <i class="fa fa-archive" aria-hidden="true"></i>
                <span id="AccueilSB">MAJ Facture </span>
                </a>
           </li>          
       </ul>
      </div>
    </aside>
  </section>