package Main;

public class DataResource {
	
	public static class Actuator{
		
		private int actuator;
		private int edge;
		private String type;
		
		public Actuator(int actuator, int edge, String type) {
			this.actuator=actuator;
			this.edge=edge;
			this.type=type;
		}
		
		public Actuator(String[]metadata) {
			this.actuator=Integer.parseInt(metadata[0]);
			this.edge=Integer.parseInt(metadata[1]);
			this.type=metadata[2];
		}
		
		public int getActuator() {
			return actuator;
		}
		
		public int getEdge() {
			return edge;
		}
		
		public String getType() {
			return type;
		}
	}
	
	public static class Beacon{
		
		private int beacon;
		private int floor;
		private float x;
		private float y;
		private String uuid;
		private String major;
		private String minor;
		
		public Beacon(int beacon, int floor, float x, float y, String uuid, String major, String minor) {
			this.beacon=beacon;
			this.floor=floor;
			this.x=x;
			this.y=y;
			this.uuid=uuid;
			this.major=major;
			this.minor=minor;
		}
		
		public Beacon(String metadata[]) {
			this.beacon=Integer.parseInt(metadata[0]);
			this.floor=Integer.parseInt(metadata[1]);
			this.x=Float.parseFloat(metadata[2]);
			this.y=Float.parseFloat(metadata[3]);
			this.uuid=metadata[4];
			this.major=metadata[5];
			this.minor=metadata[6];
		}
		
		public int getBeacon() {
			return beacon;
		}
		
		public int getFloor() {
			return floor;
		}
		
		public float getX() {
			return x;
		}
		
		public float getY() {
			return y;
		}
		
		public String getUuid() {
			return uuid;
		}
		
		public String getMajor() {
			return major;
		}
		
		public String getMinor() {
			return minor;
		}
	}
	
	public static class Building{
		
		private int building;
		private String name;
		private String address;
		
		public Building(int building, String name, String address) {
			this.building=building;
			this.name=name;
			this.address=address;
		}
		
		public Building(String metadata[]) {
			this.building=Integer.parseInt(metadata[0]);
			this.name=metadata[1];
			this.address=metadata[2];
		}
		
		public int getBuilding() {
			return building;
		}
		
		public String getName() {
			return name;
		}
		
		public String getAddress() {
			return address;
		}
	}
	
	public static class Edge{
		
		int edge;
		int floor_start;
		int floor_end;
		float x_start;
		float y_start;
		float x_end;
		float y_end;
		float distance;
		float area;
		
		public Edge() {
			
		}
		
		public Edge(int edge, int floor_start, int floor_end, float x_start, float y_start, float x_end, float y_end, float distance, float area) {
			this.edge=edge;
			this.floor_start=floor_start;
			this.floor_end=floor_end;
			this.x_start=x_start;
			this.x_end=x_end;
			this.y_end=y_end;
			this.distance=distance;
			this.area=area;
		}
		
		public Edge(String metadata[]) {
			this.edge=Integer.parseInt(metadata[0]);
			this.floor_start=Integer.parseInt(metadata[1]);
			this.floor_end=Integer.parseInt(metadata[2]);
			this.x_start=Float.parseFloat(metadata[3]);
			this.y_start=Float.parseFloat(metadata[4]);
			this.x_end=Float.parseFloat(metadata[5]);
			this.y_end=Float.parseFloat(metadata[6]);
			this.distance=Float.parseFloat(metadata[7]);
			this.area=Float.parseFloat(metadata[8]);
		}
		
		public int getEdge() {
			return edge;
		}
		
		public int getFloor_start() {
			return floor_start;
		}
		
		public int getFloor_end() {
			return floor_end;
		}
		
		public float getX_start() {
			return x_start;
		}
		
		public float getY_start() {
			return y_start;
		}
		
		public float getX_end() {
			return x_end;
		}
		
		public float getY_end() {
			return y_end;
		}
		
		public float getDistance() {
			return distance;
		}
		
		public float getArea() {
			return area;
		}
		
		public void setEdge(int edge) {
			this.edge=edge;
		}
		
		public void setFloor_start(int floor_start) {
			this.floor_start=floor_start;
		}
		
		public void setFloor_end(int floor_end) {
			this.floor_end=floor_end;
		}
		
		public void setX_start(float x_start) {
			this.x_start=x_start;
		}
		
		public void setY_start(float y_start) {
			this.y_start=y_start;
		}
		
		public void setX_end(float x_end) {
			this.x_end=x_end;
		}
		
		public void setY_end(float y_end) {
			this.y_end=y_end;
		}
		
		public void setDistance(float distance) {
			this.distance=distance;
		}
		
		public void setArea(float area) {
			this.area=area;
		}
	}
	
	public static class Floor{
		
		int floor;
		int building;
		int floor_number;
		
		public  Floor(int floor, int building, int floor_number) {
			this.floor=floor;
			this.building=building;
			this.floor_number=floor_number;
		}
		
		public Floor(String metadata[]) {
			this.floor=Integer.parseInt(metadata[0]);
			this.building=Integer.parseInt(metadata[1]);
			this.floor_number=Integer.parseInt(metadata[2]);
		}
		
		public int getFloor() {
			return floor;
		}
		
		public int getBuilding() {
			return building;
		}
		
		public int getFloor_number() {
			return floor_number;
		}
	}
	
	public static class Simulation{
		
		int edge;
		float ostruzione_tronco;
		float stato_pericolo;
		float vulnerabilita_edif;
		float illuminamento;
		
		public Simulation() {
			
		}
		
		public Simulation(int edge, float ostruzione_tronco, float stato_pericolo, float vulnerabilita_edif, float illuminamento) {
			this.edge=edge;
			this.ostruzione_tronco=ostruzione_tronco;
			this.stato_pericolo=stato_pericolo;
			this.vulnerabilita_edif=vulnerabilita_edif;
			this.illuminamento=illuminamento;
		}
		
		public Simulation(String metadata[]) {
			this.edge=Integer.parseInt(metadata[0]);
			this.ostruzione_tronco=Float.parseFloat(metadata[1]);
			this.stato_pericolo=Float.parseFloat(metadata[2]);
			this.vulnerabilita_edif=Float.parseFloat(metadata[3]);
			this.illuminamento=Float.parseFloat(metadata[4]);
		}
		
		public int getEdge() {
			return edge;
		}
		
		public float getOstruzione_tronco() {
			return ostruzione_tronco;
		}
		
		public float getStato_pericolo() {
			return stato_pericolo;
		}
		
		public float getVulnerabilita_edif() {
			return vulnerabilita_edif;
		}
		
		public float getIlluminamento() {
			return illuminamento;
		}
		
		public void setEdge(int edge) {
			this.edge=edge;
		}
		
		public void setOstruzione_tronco(float ostruzione_tronco) {
			this.ostruzione_tronco=ostruzione_tronco;
		}
		
		public void setStato_pericolo(float stato_pericolo) {
			this.stato_pericolo=stato_pericolo;
		}
		
		public void setVulnerabilita_edif(float vulnerabilita_edif) {
			this.vulnerabilita_edif=vulnerabilita_edif;
		}
		
		public void setIlluminamento(float illuminamento) {
			this.illuminamento=illuminamento;
		}
	}
	
	public static class Tronco{
		
		int edge;
		int floor_start;
		int floor_end;
		float x_start;
		float y_start;
		float x_end;
		float y_end;
		float distance;
		float los;
		float weight;
		
		public Tronco() {
			
		}
		
		public Tronco(int edge, int floor_start, int floor_end, float x_start, float y_start, float x_end, float y_end, float distance) {
			this.edge=edge;
			this.floor_start=floor_start;
			this.floor_end=floor_end;
			this.x_start=x_start;
			this.x_end=x_end;
			this.y_end=y_end;
			this.distance=distance;
		}
		
		public int getEdge() {
			return edge;
		}
		
		public float getFloor_start() {
			return floor_start;
		}
		
		public float getFloor_end() {
			return floor_end;
		}
		
		public float getX_start() {
			return x_start;
		}
		
		public float getY_start() {
			return y_start;
		}
		
		public float getX_end() {
			return x_end;
		}
		
		public float getY_end() {
			return y_end;
		}
		
		public float getDistance() {
			return distance;
		}
		
		public void setEdge(int edge) {
			this.edge=edge;
		}
		
		public void setFloor_start(int floor_start) {
			this.floor_start=floor_start;
		}
		
		public void setFloor_end(int floor_end) {
			this.floor_end=floor_end;
		}
		
		public void setX_start(float x_start) {
			this.x_start=x_start;
		}
		
		public void setY_start(float y_start) {
			this.y_start=y_start;
		}
		
		public void setX_end(float x_end) {
			this.x_end=x_end;
		}
		
		public void setY_end(float y_end) {
			this.y_end=y_end;
		}
		
		public void setDistance(float distance) {
			this.distance=distance;
		}
		
		public void setTroncoDist(Edge edge) {
			this.edge=edge.getEdge();
			this.floor_start=edge.getFloor_start();
			this.floor_end=edge.getFloor_end();
			this.x_start=edge.getX_start();
			this.y_start=edge.getY_start();
			this.x_end=edge.getX_end();
			this.y_end=edge.getY_end();
			this.distance=edge.getDistance();
		}
	}
	
	public static class User{
		private String name;
		private int building;
		private int floor;
		private float x;
		private Float y;
		
		public User() {
			
		}
	}
}
