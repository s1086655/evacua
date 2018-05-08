package Windows;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Main.DataResource.*;
import Database.*;


//schermata per importare i dati contenuti nei csv al database

public class WindowsImport extends JFrame {
	
	public  WindowsImport() {
		setMinimumSize(new Dimension(600, 500));		
		setTitle("Importa");
		Toolkit tool =Toolkit.getDefaultToolkit();
		Dimension dim = new Dimension(tool.getScreenSize());
		int height = (int) dim.getHeight();
		int width = (int) dim.getWidth();
		setSize(600, 500);
		setLocation(width / 2 - getWidth() /2, height / 2 - getHeight() /2);
		setMaximumSize(dim);
		getContentPane().setLayout(null);
		
		JLabel field= new JLabel("Inserisci nome file");
		field.setBounds(10, 10, 270, 25);
		add(field);
		
		JTextField name= new JTextField();
		name.setBounds(10, 40, 270, 25);
		add(name);
		
		JButton btnImport = new JButton("importa");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String fileName = name.getText();
					// serie di if per fare l'import nella tabella giusta e creare il giusto oggetto per l'importazione
					if(fileName.equals("actuator"))
					{
						List<String[]> csv = CSVimport.readCSV(fileName);
						for(int i=0; i<csv.size(); i++) {
							Actuator imp = new Actuator(csv.get(i));
							ActuatorDB.InsertUpdate(imp);
						}
					}
					else if(fileName.equals("beacon"))
					{
						List<String[]> csv = CSVimport.readCSV(fileName);
						for(int i=0; i<csv.size(); i++) {
							Beacon imp = new Beacon(csv.get(i));
							BeaconDB.InsertUpdate(imp);
						}
					}
					else if(fileName.equals("building"))
					{
						List<String[]> csv = CSVimport.readCSV(fileName);
						for(int i=0; i<csv.size(); i++) {
							Building imp = new Building(csv.get(i));
							BuildingDB.InsertUpdate(imp);
						}
					}
					else if(fileName.equals("edge"))
					{
						List<String[]> csv = CSVimport.readCSV(fileName);
						for(int i=0; i<csv.size(); i++) {
							Edge imp = new Edge(csv.get(i));
							EdgeDB.InsertUpdate(imp);
						}
					}
					else if(fileName.equals("floor"))
					{
						List<String[]> csv = CSVimport.readCSV(fileName);
						for(int i=0; i<csv.size(); i++) {
							Floor imp = new Floor(csv.get(i));
							FloorDB.InsertUpdate(imp);
						}
					}
					else if(fileName.equals("simulation"))
					{
						List<String[]> csv = CSVimport.readCSV(fileName);
						for(int i=0; i<csv.size(); i++) {
							Simulation imp =new Simulation(csv.get(i));
							SimulationDB.InsertUpdate(imp);
						}
					}
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
		});
		btnImport.setBounds(10, 75, 90, 25);
		add(btnImport);
	}
}
