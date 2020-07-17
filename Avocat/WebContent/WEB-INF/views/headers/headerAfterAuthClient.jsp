
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
   <form action="Authentification" method="get">   
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
          
          
            
           <li id="Dossier">
                <a href="./AccueilClient" class="">
                <i class="fa fa-folder" aria-hidden="true"></i>
                <span id="AccueilSB">Dossier </span>
                </a>
           </li>
          
           <li id="">
                <a href="./ajoutPieceJointe" class="">
                <i class="fa fa-plus" aria-hidden="true"></i>
                <span id="AccueilSB">Ajouter une Piece jointe </span>
                </a>
           </li>          
       </ul>
      </div>
    </aside>
  </section>