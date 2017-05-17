<?php include("php/function.inc.php");
if (!file_exists("res/leaderboard.scr")){
	createFile();
}
else{
	if ($file = fopen('res/leaderboard.scr', 'r')){
		$str = fgets($file);
		$tab = unserialize($str);
		fclose($file);
	}
	else{
		echo "Error file not open";
	}
}
?>
<!DOCTYPE html>
<html>
	<head>
		<title>Leaderboard</title>
		<meta charset="utf-8">
	</head>

	<body>
	<h1>Leaderbord</h1>
		<section>
			<h2>Classement</h2>
			<article>
				<?php
				$i = 0;
				foreach ($tab as $key => $score) {
					echo "<p>".$key.". ".$score->getName().": ".$score->getScore();
				}
				?>
			</article>
			<p>fin</p>
		</section>
	</body>
</html>