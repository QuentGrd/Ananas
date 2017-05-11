<?php require("score.php");

function createFile(){
	$i = 0;
	$tab = array();
	for ($i = 0; $i < 10; $i++){
		$j = $i + 1;
		$tab[$j] = new Score("empty", 0);
	}
	$str = serialize($tab);
	//echo $str;
	/*if ($file = fopen('res/leaderboard.scr', 'a+'))
		echo "File created";
	else
		echo "File not created";*/
	fseek($file, 0);
	fputs($file, $str);
	fclose($file);
}
?>