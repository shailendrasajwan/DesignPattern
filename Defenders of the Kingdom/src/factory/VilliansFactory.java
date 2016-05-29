package factory;

import java.awt.Color;

import Prototype.PrototypeUnitCache;
import utilities.PlayerUtilities;
import model.team.Heroes;
import model.team.Team;
import model.team.Villains;
import model.unit.Avatar;
import model.unit.FireLord;
import model.unit.Henchman;
import model.unit.Marksman;
import model.unit.Scout;
import model.unit.Soldier;

public class VilliansFactory  extends AbstractTeamfactory{
	private static int x =8; static int y =4;
			@Override
			public Team createTeam() {
				Villains v= new Villains();
				//String s = "";
				if(PrototypeUnitCache.i ==0){
				PrototypeUnitCache.loadCache();
				 System.out.print("i value"+PrototypeUnitCache.i);
				}
				
				  System.out.println(x);
				  System.out.println(y);
				for(String  s  :PlayerUtilities.fetchvillians() ) {
				
					if(s == "Scout"){
						
					    Scout sc =(Scout)PrototypeUnitCache.getUnit("Scout"); 
					    sc.setWeapon(PrototypeUnitCache.fetchWeapons("Scout", PlayerUtilities.lstweapon.get("Scout")).get("Scout")) ;
						   
					    sc.setStartingX(x);
					                 sc.setStartingY(y);
					                 y++;
							 v.getUnits().add(sc);
							// PrototypeUnitCache.getUnit("Scout")
						}
						
						if(s == "Soldier"){
						    Soldier soldier =(Soldier)PrototypeUnitCache.getUnit("Soldier"); 
						    soldier.setWeapon(PrototypeUnitCache.fetchWeapons( "Soldier", PlayerUtilities.lstweapon.get( "Soldier")).get( "Soldier")) ;
							    
						    soldier.setStartingX(x);
						    soldier.setStartingY(y);
			                y++;
							 v.getUnits().add(soldier);
						}
						
						if(s == "Avatar"){
							
						Avatar av = (Avatar)PrototypeUnitCache.getUnit("Avatar");
						   av.setWeapon(PrototypeUnitCache.fetchWeapons( "Avatar", PlayerUtilities.lstweapon.get( "Avatar")).get( "Avatar")) ;
							
						av.setStartingX(x);
						av.setStartingY(y);
			            y++;
						
						v.getUnits().add(av);
					}
						
						
						if(s == "Henchman"){
							
							Henchman h1 = (Henchman)PrototypeUnitCache.getUnit("Henchman");
							 h1.setWeapon(PrototypeUnitCache.fetchWeapons( "Henchman", PlayerUtilities.lstweapon.get( "Henchman")).get( "Henchman")) ; 
								
							h1.setStartingX(x);
							h1.setStartingY(y);
				            y++;
							v.getUnits().add(h1);
							
						}
						
						if(s == "Marksman"){
							
							Marksman m1 = (Marksman)PrototypeUnitCache.getUnit("Marksman");
						
							 m1.setWeapon(PrototypeUnitCache.fetchWeapons( "Marksman", PlayerUtilities.lstweapon.get( "Marksman")).get( "Marksman")) ; 
								
							m1.setStartingX(x);
							m1.setStartingY(y);
				            y++;
							 v.getUnits().add(m1);
						}
						
						if(s == "FireLord"){
							
							FireLord f1 = (FireLord)PrototypeUnitCache.getUnit("FireLord");
							 f1.setWeapon(PrototypeUnitCache.fetchWeapons( "FireLord", PlayerUtilities.lstweapon.get( "FireLord")).get( "FireLord")) ; 
								
							f1.setStartingX(x);
							f1.setStartingY(y);
				            y++;
							 v.getUnits().add(f1);
					}
							
					
			}
				
				v.setColour(Color.blue);
				v.setName("Villains");
				
				return v;
			}
		
			}
			
	
	
	

