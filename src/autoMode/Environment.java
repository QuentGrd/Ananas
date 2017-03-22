package autoMode;

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
	
	public Environment(Map map, Home home, Work work){
		Qmap = new State[SIZE][SIZE];
		initQmap(map, home, work);
	}
	
	public void initQmap(Map map, Home home, Work work){
		
		//State initialisation
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
						}
						else
							newState.setType(1);
					}
					//si c'est la maison ou le travail du perso on autorise
					if(home.getAddress().getX() == i && home.getAddress().getY() == j)
						newState.setType(0);
					else if(work.getAddress().getX() == i && work.getAddress().getY() == j)
						newState.setType(0);
					else
						newState.setType(1);
				}	
			}
		}
		
		//Action initialisation
		for(int i = 0; i<SIZE; i++){
			for(int j = 0; j<SIZE; j++){
				
			}
		}
		
		//
	}

	public State[][] getQmap() {
		return Qmap;
	}

	public void setQmap(State[][] qmap) {
		Qmap = qmap;
	}
}
