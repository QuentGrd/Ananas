<?php require("score.php");

function decodeLvl($level, $param){
	if ($param == 1){
		switch($level){
			case 1:
			return "easy.php";
			case 3: 
			return "normal.php";
			case 5:
			return "hard.php";
			case 15:
			return "pro.php";
			default:
			return "index.php";
		}
	}
	else if ($param == 2){
		switch($level){
			case 1:
			return "easy.scr";
			case 3: 
			return "normal.scr";
			case 5:
			return "hard.scr";
			case 15:
			return "pro.scr";
			default:
			return null;
		}
	}
}

function createFile($level){
	$i = 0;
	$tab = array();
	$file_name = decodeLvl($level, 2);
	for ($i = 0; $i < 10; $i++){
		$j = $i + 1;
		$tab[$j] = new Score("empty", 0);
	}
	$str = serialize($tab);
	if ($file = fopen('res/leaderboard.scr', 'a+'))
		echo "File created";
	else
		echo "File not created";
	fseek($file, 0);
	fputs($file, $str);
	fclose($file);
}

function fileVerification($level){
	$file = decodeLvl($level, 2);
	if (!file_exists("res/lb/".$file))
		createFile($level);
	else
		echo "file exist";
}

function insertScore($score, $pseudo, $lvl){
	$score = intval($score);
	fileVerification($lvl);
	$file_name = decodeLvl($lvl, 2);
	$file = fopen("res/lb/".$file_name, "r+");
	//echo "\n File open\n";
	$str = fgets($file);
	$tab = unserialize($str);
	//echo "Unserialize\n";
	$i = 10; 
	$j = 0;
	//echo "Treatment will begin";
	if ($tab[10]->getScore() >= $score){
		//echo "Dernier Score :".$tab[10]->getScore();
		fclose($file);
	}
	else{
		//echo "Score will be register\n";
		while(($i > 1) && (intval($tab[$i-1]->getScore()) < $score)){
			$i--;
			$tab[$i+1]->setName($tab[$i]->getName());
			$tab[$i+1]->setScore($tab[$i]->getScore());
		}
		$tab[$i]->setScore($score);
		$tab[$i]->setName($pseudo);
		$str = serialize($tab);
		fseek($file, 0);
		fputs($file, $str);
		fclose($file);
	}
}
?>