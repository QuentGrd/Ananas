package character;

import java.util.ArrayList;
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

	private ArrayList<Actions> dailyRoutine;
	private ArrayList<Actions> currentRoutine;
	
	private Actions currentAction;
	
	private Home home;
	private Work work;
	
	public Routine(Home home, Work work){
		this.work = work;
		this.home = home;
		dailyRoutine = new ArrayList<Actions>();
		currentRoutine = new ArrayList<Actions>();
		initDailyRoutine();
		//currentRoutine.add(dailyRoutine.get(0));
		//currentAction = dailyRoutine.get(2);
	}
	
	public void initDailyRoutine(){
		//il dort chez lui a partir de 0h00 pendant une durée aleatoire de 7h à 7h30
		Sleeping sleepAction = new Sleeping(home, new Schedule(0,0), new Schedule(7, 0));
		//il se prepart chez lui pendant 1h
		Chilling breakfastAction = new Chilling(home, new Schedule(7,0), new Schedule(1,0));
		//il part travailler
		Shifting goToWorkAction = new Shifting(new Schedule(8,0), home.getAddress(), work.getAddress());
		//il travail pendant 8h
		Working workAction = new Working(work, new Schedule(8,0), new Schedule(8, 30));
		//il rentre chez lui
		Shifting goHomeAction = new Shifting(new Schedule(16,30), work.getAddress(), home.getAddress());
		//il reste chez lui à s'occuper jusqu'à 0h00
		Chilling stayHomeAction = new Chilling(home, new Schedule(16,30), new Schedule(6,30));
		
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
	
	
	/**
	 * this methode return the first action of the currentRoutine and delete it in the currentRoutine
	 * @return
	 */
	public Actions moveFirstCurrentRoutine(){
		if(!isEmptyCurrentRoutine()){
			Actions  first = currentRoutine.get(0);
			currentRoutine.remove(currentRoutine.get(0));
			return first;
		}
		System.out.println("ERREUR DANS L'AJOUT DE L'ACTION DE TETE");
		return null;
	}
	
	
	/**
	 * This methode add a action a the end of the currentRoutine
	 * @param action
	 */
	public void addEndToCR(Actions action){
		currentRoutine.add(action);
	}
	
	/**
	 * This methode add a action at the beginning of the currentRoutine
	 * @param action
	 */
	public void addFirstToCR(Actions action){
		currentRoutine.add(0, action);
	}
	
	public Boolean isEmptyCurrentRoutine(){
		if(currentRoutine.size() == 0)
			return true;
		else
			return false;
	}
	
	public Boolean isEmptyCurrentAction(){
		if(currentAction == null)
			return true;
		else 
			return false;
	}

	public ArrayList<Actions> getDailyRoutine() {
		return dailyRoutine;
	}

	public ArrayList<Actions> getCurrentRoutine() {
		return currentRoutine;
	}

	public void setCurrentRoutine(ArrayList<Actions> currentRoutine) {
		this.currentRoutine = currentRoutine;
	}
	
	public Actions getCurrentAction() {
		return currentAction;
	}

	public void setCurrentAction(Actions currentAction) {
		this.currentAction = currentAction;
	}

	public String toString(){
		String str = "\n\t**"+currentAction.toString()+"**";
		for (int i = 0; i < dailyRoutine.size(); i++) {
			str += "\n\t";
			str += dailyRoutine.get(i);
		}
		return str;
	}
	
	
}
