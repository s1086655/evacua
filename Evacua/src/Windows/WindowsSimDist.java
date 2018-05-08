package Windows;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Database.*;
import Main.DataResource.*;
import Route.Distance;


public class WindowsSimDist extends JFrame{
	
	//faccio partire una simulazione per l'evacuazione dell'edificio di cui innserisco l'id nel JTextField
	
	public  WindowsSimDist() {
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
		
		JLabel field= new JLabel("Inserisci id building");
		field.setBounds(10, 10, 270, 25);
		add(field);
		
		JTextField name= new JTextField();
		name.setBounds(10, 40, 270, 25);
		add(name);
		
		JButton btnImport = new JButton("simulata");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int idBuild = Integer.parseInt(name.getText());
					if(BuildingDB.SearchBuilding(idBuild)) {
						//creo i tronchi per il calcolo della via di uscita in base alla distanza dell'edeificio di cui simulo l'evacuazione
						List<Edge> edge = EdgeDB.Select(FloorDB.SelectFloor(idBuild));
						List<Tronco> tronco = Distance.CreateTronco(edge);
						//Example List<Utenti> utenti = UtentiDB.(FloorDB.SelectFloor(idBuild));
						//for dove scorro gli utenti e calcolo i percorsi per ogni utente che si trova nell'edificio
						
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
