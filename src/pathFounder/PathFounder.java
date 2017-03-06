package pathFounder;

import java.util.ArrayList;
import java.util.LinkedList;

import utils.Coordinates;

/**
 * 
 * @author matthieu
 *
 */
public class PathFounder {

	private BinaryMap binaryMap;
	private int size;
	private LinkedList<Node> openList;
	private LinkedList<Node> closeList;
	
	public PathFounder(BinaryMap binaryMap){
		openList = new LinkedList<Node>();
		closeList = new LinkedList<Node>();
		this.binaryMap = binaryMap;
		this.size = binaryMap.getSize();
	}
	
	public ArrayList<Coordinates> getPath(Coordinates coordBegin, Coordinates coordGoal){
		
		binaryMap.addStart(coordBegin.getX(), coordBegin.getY());
		binaryMap.addGoal(coordGoal.getX(), coordGoal.getY());
		//System.out.println(binaryMap.toString());
		
		Node begin = binaryMap.getNode(coordBegin.getX(), coordBegin.getY()); 
		Node goal = binaryMap.getNode(coordGoal.getX(), coordGoal.getY());
		
		calculValue(begin, goal);
		begin.setPrevious(null);
		openList.add(begin);
		
		while(!openList.isEmpty()){
			
			Node current = lowerInList(openList);
			openList.remove(current);
			closeList.add(current);
			
			if(current.getType() == 3){
				return buildPath(begin, current);
			}
			
			ArrayList<Node> neighbors = getViableNeighbour(current);
			for (int i = 0; i < neighbors.size(); i++) {
				if(!isInCloseList(neighbors.get(i))){
					calculValue(neighbors.get(i), goal);
					if(isInOpenList(neighbors.get(i))){
						if(current.getValue() < neighbors.get(i).getPrevious().getValue()){
							neighbors.get(i).setPrevious(current);
						}
					}
					else{
						neighbors.get(i).setPrevious(current);
						openList.add(neighbors.get(i));
					}
				}
			}
		}
		
		
		ArrayList<Coordinates> emptyList = new ArrayList<Coordinates>();
		emptyList.add(begin.getCoord());
		return emptyList;
	}
	
	/**
	 * this methode set the value of current by compuiting the distance with the goal
	 * @param current
	 * @param goal
	 */
	public void calculValue(Node current, Node goal){
		current.setValue(Math.pow((goal.getCoord().getX()-current.getCoord().getX()), 2) + Math.pow((goal.getCoord().getY()-current.getCoord().getY()), 2));
	}
	
	
	/**
	 * This methode return the list of current's neighbour nodes witch can be evaluate
	 * @param current
	 * @return list of node
	 */
	public ArrayList<Node> getViableNeighbour(Node current){
		
		int currentX = current.getCoord().getX();
		int currentY = current.getCoord().getY();
		
		ArrayList<Node> result = new ArrayList<Node>();
		

		if(binaryMap.validCoord(currentX, currentY+1)){
			result.add(binaryMap.getNode(currentX, currentY+1));
		}

		if(binaryMap.validCoord(currentX, currentY-1)){
			result.add(binaryMap.getNode(currentX, currentY-1));
		}

		if(binaryMap.validCoord(currentX+1, currentY)){
			result.add(binaryMap.getNode(currentX+1, currentY));
		}
		
		if(binaryMap.validCoord(currentX-1, currentY)){
			result.add(binaryMap.getNode(currentX-1, currentY));
		}
		
		for (int i = 0; i < result.size(); i++) {
			if(result.get(i).getType() == 1)
				result.remove(i);
		}
		
		return result;
	}
	
	public boolean isInCloseList(Node node){
		for (int i = 0; i < closeList.size(); i++) {
			if(closeList.get(i).equals(node))
				return true;
		}
		return false;
	}
	
	public boolean isInOpenList(Node node){
		for (int i = 0; i < openList.size(); i++) {
			if(openList.get(i).equals(node))
				return true;
		}
		return false;
	}
	
	/**
	 * this methode return the node with the lowest value in a linkedList
	 * @param list
	 * @return lower node
	 */
	public Node lowerInList(LinkedList<Node> list){
		Node lower = list.getFirst();
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getValue() < lower.getValue()){
				lower = list.get(i);
			}
		}
		
		return lower;
	}
	
	public ArrayList<Coordinates> buildPath(Node begin, Node goal){
		ArrayList<Coordinates> list = new ArrayList<Coordinates>();
		
		Node tmp = goal;
		while(!tmp.equals(begin)){
			list.add(0, tmp.getCoord());
			tmp = tmp.getPrevious();
		}
		
		return list;
	}
}
