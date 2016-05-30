package model.player;

import java.util.Iterator;
import java.util.Random;

import com.google.java.contract.Requires;

import controller.BoardController;
import factory.HeroesFactory;
import factory.VilliansFactory;
import model.team.Heroes;
import model.team.Team;
import model.team.Villains;
import model.unit.Unit;
import utilities.PlayerUtilities;

public class PlayerCreator
{
	private Player[] players = new Player[2];
	private BoardController boardController;
	private PlayerUtilities playerUtilities =new PlayerUtilities();
	public static String str = "";
	public PlayerCreator(BoardController boardController)
	{
		this.boardController = boardController;
		for (int i = 0; i < players.length; ++i)
			players[i] = new Player();
	}
	
	public boolean createPlayers()
	{
		
		try{
		for (int i = 0; i < players.length; ++i)
		{
			String name = null;
			do
			{
				name = boardController.getInput("Enter your name Player " + (i + 1) + ":");
				if (name == null)
					return false;
				name = name.trim();
			}
			while (name.equals(""));
			players[i].setName(name);
		}
		String[] options = new String[3];
		options[0] = "Heroes";
		options[1] = "Villains";
		options[2] = "Cancel";
		Random rand = new Random();
		int whichPlayer = rand.nextInt(players.length);
		int team = boardController.getChoice("Team", "Choose your team " + players[whichPlayer].getName() + ":", options);
		String[] options1 = new String[4];
		/*options1[0] = "Avatar";
		options1[1] = "Soldier";
		options1[2] = "Scout";
		options1[3] = "FireLord";
		options1[4] = "Henchman";
		options1[5] = "Marksman";*/

		options1[0] = "Soldier";
		options1[1] = "Scout";
		options1[2] = "Henchman";
		options1[3] = "Marksman";
		
		int unit0 = boardController.getChoice("Team", "Choose your 1st unit " + players[whichPlayer].getName() + ":", options1);
		int unit1 = boardController.getChoice("Team", "Choose your 2nd unit " + players[whichPlayer].getName() + ":", options1);
		//int unit2 = boardController.getChoice("Team", "Choose your 3rd unit " + players[whichPlayer].getName() + ":", options1);
		
	//	
		String[] options2 = new String[5];
		options2[0] = "Sword";
		options2[1] = "Spear";
		options2[2] = "Bow";
		options2[3] = "Arrow";
		options2[4]  = "Cancel";
	        for(int i=0;i<4;i++)	{
		int w1 = boardController.getChoice("Team", "Choose your  weapon  for"+options1[unit0] + players[whichPlayer].getName() + ":", options2);
		      if(options2[w1]=="Cancel")
		    	  break;
		playerUtilities.setWeapons(options1[unit0],options2[w1]);
	}
	        
	        for(int i=0;i<4;i++)	{
	    		int w1 = boardController.getChoice("Team", "Choose your  weapon  for"+options1[unit1] + players[whichPlayer].getName() + ":", options2);
	    		if(options2[w1]=="Cancel")
			    	  break;
	    		playerUtilities.setWeapons(options1[unit1],options2[w1]);
	    		} 
	        
	    String  unit2 ="";
	        for(int i=0;i<4;i++)	{
	        	int w1 =0;
	        	if(team ==0){
	    		 w1 = boardController.getChoice("Team", "Choose your  weapon  for"+"Avatar" +" and  player "+ players[whichPlayer].getName() + ":", options2);
	              unit2 ="Avatar"   ; 
	              if(options2[w1]=="Cancel")
			    	  break;
	          	playerUtilities.setWeapons("Avatar",options2[w1]);
   	        	}
	        	else{
	        		 w1 = boardController.getChoice("Team", "Choose your  weapon  for"+"FireLord"+" and  player "+ players[whichPlayer].getName() + ":", options2);	
	        	      unit2 ="FireLord"  ;
	        	      if(options2[w1]=="Cancel")
				    	  break;
	        	      playerUtilities.setWeapons("FireLord",options2[w1]);
	        	}
	        	
	    	//	playerUtilities.setWeapons(options1[unit1],options2[w1]);
	    		}
	        
	        
	        
	        

		
	        
	        
		if(team==0){
			playerUtilities.addHeroes(options1[unit0]);
			playerUtilities.addHeroes(options1[unit1]);
			playerUtilities.addHeroes("Avatar");
		}
		else{
			playerUtilities.addVillains(options1[unit0]);
			playerUtilities.addVillains(options1[unit1]);
			playerUtilities.addVillains("FirLord");
		}
		
		
		//adding opponents
		int count=0 ;
		for(String str :options1){
			count++;
			if(str!=options1[unit0]&&str!=options1[unit1]&&str!=unit2){
				if(team==0){
					if(count==2){
						playerUtilities.addVillains("FireLord");
						break;}
				playerUtilities.addVillains(str);
            
				}
				else if(team ==1){
					if(count==2){
						playerUtilities.addHeroes("Avatar");
						break;}
					playerUtilities.addHeroes(str);
					}
			}
		}
		
		        
		     	int w1=0;
	       for(int i=0;i<4;i++)	{
	    	   if(team ==0){
	    		
	   		 w1 = boardController.getChoice("Team", "Choose your  weapon  for"+		PlayerUtilities.fetchvillians().get(0)+ players[whichPlayer == 0 ? 1 : 0].getName() + ":", options2);
	   		if(options2[w1]=="Cancel")
 		    	  break;
	   		 playerUtilities.setWeapons(PlayerUtilities.fetchvillians().get(0),options2[w1]);
	    	   }
	    	   if(team ==1){
	    		   w1 = boardController.getChoice("Team", "Choose your  weapon  for"+		PlayerUtilities.fetchheroes().get(0)+ players[whichPlayer == 0 ? 1 : 0].getName() + ":", options2);
	    			if(options2[w1]=="Cancel")
		   		    	  break;
	    		   playerUtilities.setWeapons(PlayerUtilities.fetchheroes().get(0),options2[w1]);
	    	   }
	   
	   		
	   	}
	   	        
	   	        for(int i=0;i<4;i++)	{
	   	  	   if(team ==0){
		    		
	  	   		 w1 = boardController.getChoice("Team", "Choose your  weapon  for"+		PlayerUtilities.fetchvillians().get(1)+ players[whichPlayer == 0 ? 1 : 0].getName() + ":", options2);
	  	   		if(options2[w1]=="Cancel")
	   		    	  break;
	  	   		 playerUtilities.setWeapons(PlayerUtilities.fetchvillians().get(1),options2[w1]);
	  	    	   }
	  	    	   if(team ==1){
	  	    		   w1 = boardController.getChoice("Team", "Choose your  weapon  for"+		PlayerUtilities.fetchheroes().get(1)+ players[whichPlayer == 0 ? 1 : 0].getName() + ":", options2);
	  	    			if(options2[w1]=="Cancel")
	  		   		    	  break;
	  	    		   playerUtilities.setWeapons(PlayerUtilities.fetchheroes().get(1),options2[w1]);
	  	    	   }
	   	    	
	   	    		} 
	   	        
	   	    String  main ="";
	   	        for(int i=0;i<4;i++)	{
	   	        	int w11 =0;
	   	        	if(team ==0){
	   	    		 w11 = boardController.getChoice("Team", "Choose your  weapon  for"+"FireLord" +" and  player "+ players[whichPlayer == 0 ? 1 : 0].getName() + ":", options2);
	   	          main ="FireLord"   ;  
	   	       if(options2[w11]=="Cancel")
			    	  break;
	   	          	playerUtilities.setWeapons("FireLord",options2[w11]);
	      	        	}
	   	        	else{
	   	        		 w11 = boardController.getChoice("Team", "Choose your  weapon  for"+"Avatar"+" and  player "+ players[whichPlayer == 0 ? 1 : 0].getName() + ":", options2);	
	   	        	   main="Avatar"  ;
	   	        	if(options2[w11]=="Cancel")
	   			    	  break;
	   	        	  	playerUtilities.setWeapons("Avatar",options2[w11]);
	   	        	}
	   	        	
	   	    	
	   	    		}
	   	        
	   	        
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
		
		
		
		

		if (team == 0)
		{  str = 	options[0];
		HeroesFactory  objheroes =new HeroesFactory();
		              Team  hero = (Heroes)objheroes.createTeam();
			players[whichPlayer].setTeam(hero);
			
	   VilliansFactory  objvillain =   new VilliansFactory();
			Villains villain =   (Villains)objvillain.createTeam();	 
			players[whichPlayer == 0 ? 1 : 0].setTeam(villain);
		}
		
		else if (team == 1)
		{ str = 	options[1];
		   VilliansFactory  objvillain =   new VilliansFactory();
				Villains villain =   (Villains)objvillain.createTeam();	 
		
			players[whichPlayer].setTeam(villain);
			
			HeroesFactory  objheroes =new HeroesFactory();
            Team  hero = (Heroes)objheroes.createTeam();
			players[whichPlayer == 0 ? 1 : 0].setTeam(hero);
		}
		else
			return false;
		for (int i = 0; i < players.length; ++i)
		{
			Iterator<Unit> iter = players[i].getTeam().getUnits().iterator();
			while (iter.hasNext())
				iter.next().setTeam(players[i].getTeam());
		}
		return true;
		
		

		}
		catch(Exception ex){
			
			return false;
		}
			}
	
	

	
	@Requires("CreatePlayers()")
	public Player[] getPlayers()
	{
		return players;
	}
}
