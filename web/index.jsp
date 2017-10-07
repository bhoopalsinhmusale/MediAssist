<%-- 
    Document   : index
    Created on : 13 Mar, 2017, 7:18:15 PM
    Author     : Bhoopal
--%>

<%@page import="org.jsoup.nodes.Document"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>MediAssist:An Intelligent Medical Assistance</title>
	<!-- Favicons (created with http://realfavicongenerator.net/)-->
	<link rel="apple-touch-icon" sizes="57x57" href="img/favicons/apple-touch-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="img/favicons/apple-touch-icon-60x60.png">
	<link rel="icon" type="image/png" href="img/favicons/favicon-32x32.png" sizes="32x32">
	<link rel="icon" type="image/png" href="img/favicons/favicon-16x16.png" sizes="16x16">
	<link rel="manifest" href="img/favicons/manifest.json">
	<link rel="shortcut icon" href="img/favicons/favicon.ico">
	<meta name="msapplication-TileColor" content="#00a8ff">
	<meta name="msapplication-config" content="img/favicons/browserconfig.xml">
	<meta name="theme-color" content="#ffffff">
	<!-- Normalize -->
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	<!-- Bootstrap -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<!-- Owl -->
	<link rel="stylesheet" type="text/css" href="css/owl.css">
	<!-- Animate.css -->
	<link rel="stylesheet" type="text/css" href="css/animate.css">
	<!-- Font Awesome -->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.1.0/css/font-awesome.min.css">
	<!-- Elegant Icons -->
	<link rel="stylesheet" type="text/css" href="fonts/eleganticons/et-icons.css">
	<!-- Main style -->
	<link rel="stylesheet" type="text/css" href="css/cardio.css">
        <link rel="stylesheet" type="text/css" href="css/indextable.css">
        
        <script type="text/javascript">
function SwapDivsWithClick(div1,div2)
{
   d1 = document.getElementById(div1);
   d2 = document.getElementById(div2);
   if( d2.style.display == "none" )
   {
      d1.style.display = "none";
      d2.style.display = "block";
   }
   else
   {
      d1.style.display = "block";
      d2.style.display = "none";
   }
}
</script>

</head>

<body>
	<div class="preloader">
		<img src="img/loader.gif" alt="Preloader image">
	</div>
	<nav class="navbar">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
                            <a class="navbar-brand" href="#"><img src="img/med.png"   data-active-url="img/med.png" alt=""></a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right main-nav">
                                   
                                    <li><a href="#intro"><img src="img/medihome3.ico" height="50px" width="50px" alt=""></a></li>
					<li><a href="#services"><img src="img/healthinfo1.png" height="60px" width="60px" alt=""></a></li>					
					<li><a href="#pricing"><img src="img/healthtopics1.svg" height="50px" width="50px" alt=""></a></li>
                                        
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
<header id="intro">
		<div class="container bg-color" >
			<div class="table">
				<div class="header-text">
					<div class="row">
                                            
                                            
                                         
                                            
                                           
                                            <div id="swapper-first" >
                                                <form method="get" action="" class="subscribe_form">
                                                       
                                                        <h1 class="heading" >HEALTH CARE AT YOUR DESK!! </h1>
                                                                                                               
                                                        <br><br>
                                                        <table111 class="table11" align="center">
                                                              <col width="130">
                                                            <col width="80">
                                                           <tr1>
                                                               <td111>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td111>
                                                            <td111 class="td111" ><img src="img/ou7.gif" height="140px" width="140px"></td111>
                                                                <td111>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td111>
                                                                <td111 class="td111"><img src="img/mp2.png" height="140px" width="140px"></td111>
                                                           </tr1>
                                                               <br><br> 
                                                            <tr1>
                                                                <td111>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td111>
                                                                <td111 class="td111"><a href="connect1" data-toggle="modal" data-target="#modal1" class="btn btn-blue">Patient</a></td111>
                                                                 <td111>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td111>
                                                                <td111 class="td111"><a href="javascript:SwapDivsWithClick('swapper-first','swapper-other')" class="btn btn-blue">Medical Professional</a></td111>
                                                            </tr1>
                                                        </table111> 
                                                        <br><br>
                                                        
                                                        
                                                         </form>
    
                                                        </div>
                                                        <div id="swapper-other" style="display:none;">
                                                        <form method="get" action="" class="subscribe_form">
                                                        
                                                        <h2 class="heading"><b>HEALTH CARE AT YOUR DESK!! </b></h2>
                                                        <br>
                                                        
                                                        <input type="text" name="termName" required="" class="text" placeholder="Enter Medical Query.....">
                                                                                                                
                                                        <br><br>
                                                        <input type="submit" name="submit" value="Submit" class="btn btn-blue" formaction="ParseHtmlServlet">
                                                        <a href="javascript:SwapDivsWithClick('swapper-first','swapper-other')" class="btn btn-blue">Return</a>
                                                        <br><br>
                                                         </form>
    </div>
                                            
                                            
                                            
					</div>
				</div>
			</div>
		</div>
	</header>
	
<section id="services" class="section section-padded">
		<div class="container">
			<div class="row text-center title">
				<h2>Health Topics</h2>
				<h4 class="light muted">It's something important you want to know.</h4>
			</div>
			<div class="row services">
				<div class="col-md-4">
					<div class="service">
						<div class="icon-holder">
							<img src="img/icons/heart-blue.png" alt="" class="icon">
						</div>
						<h4 class="heading">Heart Health</h4>
						<p class="description">Did you know that heart disease is the leading cause of death for both men and women in the India? Luckily, there is a lot you can do to lower your risk for heart disease.</p>
                                                <a href="#pricing">know more</a>
                                        </div>
				</div>
				<div class="col-md-4">
					<div class="service">
						<div class="icon-holder">
							<img src="img/icons/guru-blue.png" alt="" class="icon">
						</div>
						<h4 class="heading">Diabetes</h4>
						<p class="description">If it is not controlled, diabetes can cause serious health problems, like blindness, nerve damage, and kidney disease.</p>
					</div>
				</div>
				<div class="col-md-4">
					<div class="service">
						<div class="icon-holder">
							<img src="img/icons/weight-blue.png" alt="" class="icon">
						</div>
						<h4 class="heading">Cancer</h4>
						<p class="description">cancer is also one of the leading causes of premature death. The earlier you detect possible signs of cancer, the better the chances of survival.</p>
					</div>
				</div>          
			</div>
		</div>
		<div class="cut cut-bottom"></div>
	</section><section id="pricing" class="section">
		<div class="container">
			<div class="row title text-center">
				<h2 class="margin-top white">Recent Health Topics</h2>
                                <h5 class="white">It's something important you want to know.</h5>
			</div>
			<div class="row no-margin">
				<div class="col-md-7 no-padding col-md-offset-5 pricings text-center">
					<div class="pricing">
						<div class="box-main active" data-img="img/pricing1.jpg">
							<h4 class="white">Diabetes</h4>
                                                        <h5>Overview</h5>
                                                        <p class="white">Diabetes is a leading cause of disability and death in the India. if its not managed, diabetes can cause serious health problems.</p>
							<i class="info-icon icon_question"></i>
						</div>
						<div class="box-second active">
							<ul class="white-list text-left">
                                                            <h4>Diabetes increases the risk of:</h4>
								<li>Blindness</li>
								<li>Nerve damage</li>
								<li>Kidney disease</li>
								<li>Heart disease</li>
								<li>Stroke</li>
							</ul>
						</div>
					</div>
					<div class="pricing">
						<div class="box-main" data-img="img/background2.jpg">
                                                        <h4 class="white">Diabetes</h4>
                                                        <h5>Overview</h5>
                                                        <p class="white">Diabetes is a leading cause of disability and death in the India. if its not managed, diabetes can cause serious health problems.</p>
							<i class="info-icon icon_question"></i>
						</div>
						<div class="box-second">
							<ul class="white-list text-left">
								<h4>Diabetes increases the risk of:</h4>
								<li>Blindness</li>
								<li>Nerve damage</li>
								<li>Kidney disease</li>
								<li>Heart disease</li>
								<li>Stroke</li>
							</ul>
						</div>
					</div>
                                    
                                        <div class="pricing">
						<div class="box-main" data-img="img/pricing2.jpg">
							<h4 class="white">Diabetes</h4>
                                                        <h5>Overview</h5>
                                                        <p class="white">Diabetes is a leading cause of disability and death in the India. if its not managed, diabetes can cause serious health problems.</p>
							<i class="info-icon icon_question"></i>
						</div>
						<div class="box-third">
							<ul class="white-list text-left">
								<h4>Diabetes increases the risk of:</h4>
								<li>Blindness</li>
								<li>Nerve damage</li>
								<li>Kidney disease</li>
								<li>Heart disease</li>
								<li>Stroke</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
    
            <div class="modal fade" id="modal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content modal-popup">
				<a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
				
			</div>
		</div>
	</div>
    
    
    <div id="topModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">Top-Level</h3>
	</div>
	<div class="modal-body">
		<p>This modal should appear above the other modal.</p>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
	</div>
</div>
</div>
</div>
    <footer>
		<div class="container bg-color1">
			<div class="row">
				<div class="col-sm-6 text-center-mobile">
					<h3 class="white"align="center">Our Mission!</h3>
                                        <p align="center" class="light regular light-white">How you feel affects every precious day of your life. MediAssist understands that, which is why we are committed to being your most trusted ally in your pursuit of health and well-being.
                                        </p>
				</div>
				<!--<div class="col-sm-6 text-center-mobile">
					<h3 class="white">Opening Hours <span class="open-blink"></span></h3>
					<div class="row opening-hours">
						<div class="col-sm-6 text-center-mobile">
							<h5 class="light-white light">Mon - Fri</h5>
							<h3 class="regular white">9:00 - 22:00</h3>
						</div>
						<div class="col-sm-6 text-center-mobile">
							<h5 class="light-white light">Sat - Sun</h5>
							<h3 class="regular white">10:00 - 18:00</h3>
						</div>
					</div>
				</div>-->
			</div>
			<div class="row bottom-footer text-center-mobile">
				<div class="col-sm-8">
                                    <p><b>We are human, just like you. We know that peace of mind can make all the difference in how you feel. So we will be here when you need us.</b></p>
					<!--<p>&copy; 2017 All Rights Reserved. Powered by <a href="http://www./">MediAssist</a> exclusively for <a href="http://www./">VPKBIET</a></p>-->
				</div>
				<div class="col-sm-4 text-right text-center-mobile">
					<!--<ul class="social-footer">
						<li><a href="http://www.facebook.com/"><i class="fa fa-facebook"></i></a></li>
						<li><a href="http://www.twitter.com/"><i class="fa fa-twitter"></i></a></li>
						<li><a href="https://plus.google.com/"><i class="fa fa-google-plus"></i></a></li>
					</ul>-->
				</div>
			</div>
		</div>
	</footer>
	<!-- Holder for mobile navigation -->
	<div class="mobile-nav">
		<ul>
		</ul>
		<a href="#" class="close-link"><i class="arrow_up"></i></a>
	</div>
	<!-- Scripts -->
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/typewriter.js"></script>
	<script src="js/jquery.onepagenav.js"></script>
	<script src="js/main.js"></script>
</body>

</html>
