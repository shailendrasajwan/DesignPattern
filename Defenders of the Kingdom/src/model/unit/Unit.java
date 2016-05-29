package model.unit;

import com.fasterxml.jackson.annotation.JsonIgnore;

import interfaces.Weapons;
import model.board.Cell;
import model.entity.Entity;
import model.manager.ValidMovement;
import model.team.Team;
import model.weapon.Weapon;

public abstract class Unit extends Entity  implements Cloneable
{
	protected String name;
	protected int health;
	protected int damage;
	protected boolean meleeAttack;
	protected int startingX;
	protected int startingY;
	protected int attackRadius;
	protected boolean cannotUseSpecialPower;
	protected int movementRadius;
	@JsonIgnore
	protected Team team;
	protected Weapons weapons;
	
	
	
	
	
	
	public Weapons getWeapons() {
		return weapons;
	}







	public void setWeapons(Weapons weapons) {
		this.weapons = weapons;
	}







	public ValidMovement getValidMovement() {
		return validMovement;
	}







	public void setValidMovement(ValidMovement validMovement) {
		this.validMovement = validMovement;
	}

	protected ValidMovement validMovement = new ValidMovement();
//	protected Weapon weaponManager = new Weapon(attackRadius,damage,"new weapon");
	
	
	
	
	public Unit(String name, int health, int damage, boolean meleeAttack, int startingX, int startingY,
			int attackRadius, boolean cannotUseSpecialPower, int movementRadius, Team team, Weapons weapon,
			ValidMovement validMovement) {
	
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.meleeAttack = meleeAttack;
		this.startingX = startingX;
		this.startingY = startingY;
		this.attackRadius = attackRadius;
		this.cannotUseSpecialPower = cannotUseSpecialPower;
		this.movementRadius = movementRadius;
		this.team = team;
		this.weapons = weapon;
		this.validMovement = validMovement;
	
	}


	
	
	
	
	
	public Unit(String name, int health, int damage, boolean meleeAttack, int startingX, int startingY,
			int attackRadius, boolean cannotUseSpecialPower, int movementRadius) {
	
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.meleeAttack = meleeAttack;
		this.startingX = startingX;
		this.startingY = startingY;
		this.attackRadius = attackRadius;
		this.cannotUseSpecialPower = cannotUseSpecialPower;
		this.movementRadius = movementRadius;
	}

	public Unit(String name, int health, int damage, boolean meleeAttack,
			int attackRadius, boolean cannotUseSpecialPower, int movementRadius) {
	
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.meleeAttack = meleeAttack;
	    this.attackRadius = attackRadius;
		this.cannotUseSpecialPower = cannotUseSpecialPower;
		this.movementRadius = movementRadius;
	}






	public Unit() {
	
	}







	public abstract boolean isMoveValid(Cell initialCell, Cell finalCell);
	
	public Team getTeam()
	{
		return team;
	}
	
	public void setTeam(Team team)
	{
		this.team = team;
	}

	public int getMovementRadius()
	{
		return movementRadius;
	}
	
	public int getAttackRadius()
	{
		return weapons.getAttackRadius();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public int getDamage()
	{
		return weapons.getDamage();
	}

	public boolean isMeleeAttack()
	{
		return meleeAttack;
	}

	public void setMeleeAttack(boolean meleeAttack)
	{
		this.meleeAttack = meleeAttack;
	}

	public void setStartingX(int startingX)
	{
		this.startingX = startingX;
	}

	public void setStartingY(int startingY)
	{
		this.startingY = startingY;
	}
	
	public int getStartingX()
	{
		return startingX;
	}
	
	public int getStartingY()
	{
		return startingY;
	}
	
	 public Object clone() {
	      Object clone = null;
	      
	      try {
	         clone = super.clone();
	         
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clone;
	   }
	
}
