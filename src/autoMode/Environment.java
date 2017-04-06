package autoMode;

import java.util.ArrayList;

import building.Entertainment;
import building.Home;
import building.Work;
import city.Map;

/**
 * 
 * @author matthieu
 *
 */
public class Environment {
	
	private State[][] Qmap;
	private static final int SIZE = 30;
	
	public Environment(Map map, Home home){
		Qmap = new State[SIZE][SIZE];
		initQmap(map, home);
	}
	
	public void initQmap(Map map, Home home){
		
		creatState(map, home);
		creatActions(map);
		
	}
	
	/**
	 * this methode creat all state of the Qmap
	 * @param map
	 * @param home
	 * @param work
	 */
	public void creatState(Map map, Home home){
		
		for(int i=0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++){
				
				State newState = new State(i, j);
				newState.setInfrastructure(map.getInfrastructure(i, j));
				//route
				if(newState.getInfrastructure().getType() == 4)
					newState.setType(0);
				//autre
				else{
					// si entertainment, autorise l'accé a l'adresse
					if(newState.getInfrastructure().getType() == 3){
						Entertainment enter = (Entertainment) newState.getInfrastructure();
						if(enter.getAddress().getX() == i && enter.getAddress().getY() == j){
							newState.setType(0);
							newState.setReward(enter.getReward());
						}
						else
							newState.setType(1);
					}
					// si work, autorise l'accé a l'adresse
					else if(newState.getInfrastructure().getType() == 2){
						Work work = (Work) newState.getInfrastructure();
						if(work.getAddress().getX() == i && work.getAddress().getY() == j){
							newState.setType(0);
							newState.setReward(work.getReward());
						}
						else
							newState.setType(1);
					}
					else
						newState.setType(1);
					
					//si c'est la maison ou le travail du perso on autorise
					if(home.getAddress().getX() == i && home.getAddress().getY() == j){
						newState.setType(0);
						newState.setReward(home.getReward());
					}
					
				}
				
				Qmap[i][j] = newState;
			}
		}
	}
	
	/**
	 * This methode create all actions for each state of the Qmap
	 * @param map
	 */
	public void creatActions(Map map){
		for(int i = 0; i<SIZE; i++){
			for(int j = 0; j<SIZE; j++){
				ArrayList<QActions> list = new ArrayList<QActions>();
				
				QActions actionStay = new QActions(Qmap[i][j], Qmap[i][j]);
				list.add(actionStay);
				
				if(i>0){
					if(Qmap[i-1][j].getType() == 0){
						QActions actionDown = new QActions(Qmap[i][j], Qmap[i-1][j]);
						list.add(actionDown);
					}
				}
				if(i<(SIZE-1)){
					if(Qmap[i+1][j].getType() == 0){
						QActions actionTop = new QActions(Qmap[i][j], Qmap[i+1][j]);
						list.add(actionTop);
					}
				}
				if(j>0){
					if(Qmap[i][j-1].getType() == 0){
						QActions actionLeft = new QActions(Qmap[i][j], Qmap[i][j-1]);
						list.add(actionLeft);
					}
				}
				if(j<(SIZE-1)){
					if(Qmap[i][j+1].getType() == 0){
						QActions actionRight = new QActions(Qmap[i][j], Qmap[i][j+1]);
						list.add(actionRight);
					}
				}
				
				Qmap[i][j].setListAction(list);
			}
		}
	}
	
	public State getState(int x, int y){
		return Qmap[x][y];
	}

	public State[][] getQmap() {
		return Qmap;
	}

	public void setQmap(State[][] qmap) {
		Qmap = qmap;
	}
	
	public String toString(){
		String result = "";
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
//				result += " " + Qmap[i][j].getType();
				result += " " + Qmap[i][j].getListAction().size();
//				result += " " + Qmap[i][j].getReward();
			}
			result += "\n";
		}
		
		return result;
}
}
