<?php include("php/function.inc.php"); ?>
<!DOCTYPE html>
<html>
	<head>
		<title>Urabn Life Simulator - Home</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="css/new_style2.css">
	</head>

	<body>
		<section>
			<?php 
			if (isset($_GET['lvl']) && isset($_GET['score'])){ 
				$dest = decodeLvl($_GET['lvl'], 1);
				echo '<h2>Entrez votre pseudo :</h2>';
				echo '<article>';
				echo '	<form method="post" action="'.$dest.'">';
				echo '	<input type="text" name="pseudo">';
				echo '	<input type="hidden" name="score" value="'.$_GET['score'].'">';
				echo '	<input type="submit" name="valid" value="Je m enregistre !">';
				echo '</form>';
				echo '</article>';
			} 
			else{
				echo "<h2>Nous ne pouvons pas enregistrer votre score !</h2>";
			}
			 ?>
		</section>

	</body>
</html>