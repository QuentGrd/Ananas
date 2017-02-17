package character;

import java.util.Queue;
import java.util.Random;

import actions.Actions;
import actions.Chilling;
import actions.Shifting;
import actions.Sleeping;
import actions.Working;
import building.Home;
import building.Work;
import clock.Schedule;

/**
 * 
 * @author matthieu
 *
 */
public class Routine {

	private Queue<Actions> dailyRoutine;
	private Queue<Actions> currentRoutine;
	
	private Home home;
	private Work work;
	
	public Routine(Home home, Work work){
		this.work = work;
		this.home = home;
		initDailyRoutine();
	}
	
	public void initDailyRoutine(){
		//il dort chez lui a partir de 0h00 pendant une durée aleatoire de 7h à 7h30
		Sleeping sleepAction = new Sleeping(home, new Schedule(0,0), new Schedule(7, randomSelection(0, 30)));
		//il se prepart chez lui pendant 1h
		Chilling breakfastAction = new Chilling(home, new Schedule(7,0), new Schedule(1,0));
		//il part travailler
		Shifting goToWorkAction = new Shifting(new Schedule(8,0), home.getAddress(), work.getAddress());
		//il travail pendant 8h
		Working workAction = new Working(work, new Schedule(8,30), new Schedule(8, 0));
		//il rentre chez lui
		Shifting goHomeAction = new Shifting(new Schedule(16,30), work.getAddress(), home.getAddress());
		//il reste chez lui à s'occuper jusqu'à 0h00
		Chilling stayHomeAction = new Chilling(home, new Schedule(17,0), new Schedule(6,0));
		
		try{
			dailyRoutine.add(sleepAction);
			dailyRoutine.add(breakfastAction);
			dailyRoutine.add(goToWorkAction);
			dailyRoutine.add(workAction);
			dailyRoutine.add(goHomeAction);
			dailyRoutine.add(stayHomeAction);
		}catch(IllegalStateException e){
			e.printStackTrace();
		}
	}
	
	public int randomSelection(int min, int max){
		int random;
		Random rand = new Random();
		
		random = rand.nextInt(max - min +1) + min;
		
		return random;
	}

	public Queue<Actions> getDailyRoutine() {
		return dailyRoutine;
	}

	public Queue<Actions> getCurrentRoutine() {
		return currentRoutine;
	}

	public void setCurrentRoutine(Queue<Actions> currentRoutine) {
		this.currentRoutine = currentRoutine;
	}
	
	
}
