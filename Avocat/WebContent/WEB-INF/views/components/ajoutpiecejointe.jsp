<%Integer i =(Integer) request.getAttribute("num");%> 
<section id="main-content">

<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12">
              <div class="custom-box" id="filesBoxM">
                <div class="servicetitle">
                  <h4>Files</h4>
                  <hr>
                </div>
                <div class="icn-main-container">
                  <span class="icn-container">FS</span>
                </div>
                <p></p>
                <ul class="pricingM">
                
                </ul>
                
                <form action="ajoutPieceJointe" method="post" enctype="multipart/form-data">
	                <ul class="pricingM">
	                <li><input type="hidden" name="action" value="fileUpload"><input type="hidden" name="fileProces" id="fileProces" value="<%=i%>"></li>
	                <li><input type="file" name="file" id="files" class="inputfile" data-multiple-caption="{count} files selected" multiple /></li>
	                </ul>
	               <button class="btn btn-theme" type="submit">Ajouter une piece</button>
                </form>
              </div>
              <!-- end custombox -->
            </div>

                
</section>                