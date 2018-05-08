package Route;

import java.util.ArrayList;
import java.util.List;

import Main.DataResource.*;

public class Distance {
	
	public static List<Tronco> CreateTronco (List<Edge> edge){
		
		List<Tronco> tronco = new ArrayList<>();
		for (int i=0; i<edge.size(); i++) {
			Tronco tr = new Tronco();
			tr.setTroncoDist(edge.get(i));
			tronco.add(tr);
		}
		
		return tronco;
	}
	
	public static float[] StartNode (List<Tronco> tronco, int x, int y) {
		float[] startPosition = {x,y};
		double somma=0;
		for(int j=0; j<tronco.size(); j++) {
			double lat = Math.abs(x-tronco.get(j).getX_start());
			double lon = Math.abs(y-tronco.get(j).getY_start());
			if(lat+lon < somma || j==0) { 
				somma= lat+lon;
				startPosition[0]=tronco.get(j).getX_start();
				startPosition[1]=tronco.get(j).getY_start();
			}
		}
		return startPosition;
	}

}
