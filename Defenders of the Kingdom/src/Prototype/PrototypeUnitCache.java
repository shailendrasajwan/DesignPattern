package Prototype;

import java.util.HashMap;

import interfaces.Weapons;
import model.unit.Avatar;
import model.unit.FireLord;
import model.unit.Henchman;
import model.unit.Marksman;
import model.unit.Scout;
import model.unit.Soldier;
import model.unit.Unit;
import model.weapon.Arrow;
import model.weapon.Bow;
import model.weapon.Spear;
import model.weapon.Sword;
import model.weapon.Weapon;
import model.weapon.Arrow;
import model.weapon.Bow;
import model.weapon.Spear;
import model.weapon.Sword;
import model.weapon.Weapon;

public class PrototypeUnitCache {
	public static int  i=0 ;
	   private static HashMap<String, Unit> unitMap  = new HashMap<String,Unit>(); 
		public static HashMap<String,Weapons> lstweapon = new  HashMap<String,Weapons>();
   public static Unit getUnit(String Unitname){
	   
	   Unit getCacheUnit =  unitMap.get(Unitname);
	   return (Unit) getCacheUnit.clone();
   }
   
   
   public static void  loadCache(){
	   i++;
	   Weapon weapon =new Weapon(1, 1,"newweapon");
	  // Avatar avatar = new  Avatar("Avatar",10,6,true,6,9,14,false,5); 
	   Avatar avatar = new  Avatar("Avatar",30,6,true,14,false,5); 
		  
	   //name,health,damage,meleeAttack,
	 //  startingX,startingY,attackRadius,cannotUseSpecialPower,movementRadius
	   
	   unitMap.put(avatar.getName(),avatar);
	   avatar.setWeapon(new Bow(new Spear(weapon,"Avtar Arrow"),"Avatar's Bow"));
	//   FireLord firelord = new  FireLord("FireLord",12,5,true,4,2,12,false,4); 
	   FireLord firelord = new  FireLord("FireLord",32,5,true,12,false,4); 
             
	   // firelord.setWeapon(weapon);
               //avatar.setWeapon(new Bow(new Sword(weapon,"Firelordsword"),"Avatar's Bow"));
            //  firelord.setWeapon(new Bow(new Sword(weapon,"Firelordsword"),"Avatar's Bow"));
                
	   unitMap.put(firelord.getName(),firelord);
	   
		  //Scout scout = new Scout("Scout",3,2,true,9,7,2,false,3); 
		  Scout scout = new Scout("Scout",10,2,true,2,false,3); 

		 // scout.setWeapon(weapon);
		//  scout.setWeapon(weapon);
		   unitMap.put( scout.getName(), scout);
		   
		   scout.setWeapon(weapon);
			//Soldier soldier = new Soldier("Soldier",7,3,true,3,8,1,false,2); 
			
			Soldier soldier = new Soldier("Soldier",15,3,true,1,false,2); 
			
			//soldier.setWeapon(weapon);
		//	soldier.setWeapon(new Sword(weapon,"solddier's sword"));  
			unitMap.put( soldier.getName(), soldier);

				
		//		Henchman henchman = new Henchman("Henchman",9,4,true,2,4,2,false,3); 
			
			Henchman henchman = new Henchman("Henchman",17,4,true,2,false,3); 
			
			//henchman.setWeapon(weapon);
				//henchman.setWeapon(new Spear(weapon,"Henchman Spear"));  
				unitMap.put( henchman.getName(), henchman);
				   
				
					Marksman marksman = new Marksman("Marksman",9,1,true,3,false,3); 
					//Marksman marksman = new Marksman("Marksman",7,1,true,7,1,2,false,3); 
					//	
					//	marksman.setWeapon(weapon);
				//	marksman.setWeapon(new Bow(new Arrow(weapon,"Marksman Arrow"),"Marksman bow arrow") );
					
					   unitMap.put( marksman.getName(), marksman);
					   
					   
		   
		   
   }
   
   
   
   public static    HashMap<String,Weapons>fetchWeapons(String unit,String weaponname){
	   Weapon weapon =new Weapon(1, 1,"Arrow");
	if(weaponname == "Sword")
	lstweapon.put(unit,new Sword(weapon,unit+"Arrow"));
	
	if(weaponname == "Spear")
		lstweapon.put(unit,new Spear(weapon,unit+"Arrow"));
		
	if(weaponname == "Bow")
		lstweapon.put(unit,new Bow(weapon,unit+"Arrow"));
		
	if(weaponname == "Arrow")
		lstweapon.put(unit,new Arrow(weapon,unit+"Arrow"));
		
	   
	return lstweapon;
}
	
   

	   

}
