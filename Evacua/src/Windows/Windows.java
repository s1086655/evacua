package Windows;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;


//Schermata iniziale per l'amministratore

public class Windows extends JFrame{
	
	public Windows () {
		setMinimumSize(new Dimension(600, 500));		
		setTitle("Amministratore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tool =Toolkit.getDefaultToolkit();
		Dimension dim = new Dimension(tool.getScreenSize());
		int height = (int) dim.getHeight();
		int width = (int) dim.getWidth();
		setSize(width/2,height/2);
		setLocation(width / 2 - getWidth() /2, height / 2 - getHeight() /2);
		setMaximumSize(dim);
		getContentPane().setLayout(null);
		
		// pulsante per aprire la schermata per importare i dati dai file csv al database
		JButton btnImport = new JButton("Importa dati");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					WindowsImport imp = new WindowsImport();
					imp.setVisible(true);
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
		});
		btnImport.setBounds(10, 10, 150, 25);
		add(btnImport);
		
		JButton btnSimulazione1 = new JButton("Inizia Simulazione Distanza");
		btnSimulazione1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					WindowsSimDist simdis = new WindowsSimDist();
					simdis.setVisible(true);
					
					
					/*
					idUser = UserprofilesDB.SelectUser();
					ArrayList<Percorsi> idUserPerc = new ArrayList<>();
					ArrayList<Attuatori> attua = new ArrayList<>();
					for(int i=0; i<idUser.size(); i++) {
						idStartNode = General.CalculationStartNode(idUser.get(i));
						perc = MinorDistance.CalculationMinorDistance(idStartNode);
						RoutesDB.InsertUpdateRoutes(idUser.get(i), perc.get(0).getIdEdge());
						Percorsi percorsi = new Percorsi(idUser.get(i), perc);
						idUserPerc.add(percorsi);
						for(int j=0; j<perc.size(); j++) {
							perc.get(j).stampaIdEdge();
							
						}
						System.out.println("-------------");
					}
					StampaPercorsi.stampaPerc(idUserPerc, "DistanzaMinore");
					attua = AttuatoriControl.AccesiAtt(idUserPerc);
					/*/
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
		});
		btnSimulazione1.setBounds(10, 50, 250, 25);
		add(btnSimulazione1);
		
		JButton btnSimulazione2 = new JButton("Inizia Simulazione LOS");
		btnSimulazione2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					
					
					/*
					idUser = UserprofilesDB.SelectUser();
					ArrayList<Percorsi> idUserPerc = new ArrayList<>();
					ArrayList<Attuatori> attua = new ArrayList<>();
					for(int i=0; i<idUser.size(); i++) {
						idStartNode = General.CalculationStartNode(idUser.get(i));
						perc = Los.CalculationLos(idStartNode);
						Percorsi percorsi = new Percorsi(idUser.get(i), perc);
						idUserPerc.add(percorsi);
						for(int j=0; j<perc.size(); j++) {
							perc.get(j).stampaIdEdge();
						}
						System.out.println("-------------");
					}
					StampaPercorsi.stampaPerc(idUserPerc, "LOS");
					attua = AttuatoriControl.AccesiAtt(idUserPerc);
					*/
					
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
		});
		btnSimulazione2.setBounds(270, 50, 250, 25);
		add(btnSimulazione2);
		
		JButton btnSimulazione3 = new JButton("Inizia Simulazione Dijkstra");
		btnSimulazione3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					
					
					/*
					idUser = UserprofilesDB.SelectUser();
					ArrayList<Percorsi> idUserPerc = new ArrayList<>();
					ArrayList<Attuatori> attua = new ArrayList<>();
					for(int i=0; i<idUser.size(); i++) {
						idStartNode = General.CalculationStartNode(idUser.get(i));
						perc = Dijkstra.CalculationDijkstra(idStartNode);
						Percorsi percorsi = new Percorsi(idUser.get(i), perc);
						idUserPerc.add(percorsi);
						for(int j=0; j<perc.size(); j++) {
							perc.get(j).stampaIdEdge();
						}
						
						System.out.println("-------------");
					}
					StampaPercorsi.stampaPerc(idUserPerc, "Dijkstra");
					attua = AttuatoriControl.AccesiAtt(idUserPerc);
					*/
					
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
		});
		btnSimulazione3.setBounds(530, 50, 250, 25);
		add(btnSimulazione3);
	}

}
