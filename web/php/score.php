<?php
class Score{
	private $_name;
	private $_score;

	public function __construct($name, $score){
		$this->_score = $score;
		$this->_name = $name;
	}

	public function getScore(){
		return $this->_score;
	}

	public function getName(){
		return $this->_name;
	}
}
?>