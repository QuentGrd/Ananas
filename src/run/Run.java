package run;

public class Run {
	
	private static boolean run;
	
	private static boolean play;
	
	private static int speed;

	public static void switchPlayStatus(){
		if (play)
			play = false;
		else
			play = true;
	}
	
	public static void switchRun(){
		if (run)
			run = false;
		else
			run = true;
	}
	
	public static void setSpeed(int s){
		speed = s;
	}

	public static boolean isPlay() {
		return play;
	}
	
}
