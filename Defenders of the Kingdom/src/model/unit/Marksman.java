package model.unit;

import interfaces.Weapons;
import model.board.Cell;
import model.weapon.Weapon;

public class Marksman extends Unit
{
	Weapons weapon; 
	

	public Marksman(String name, int health, int damage, boolean meleeAttack, int startingX, int startingY,
			int attackRadius, boolean cannotUseSpecialPower, int movementRadius)
	{   super(name,health,damage,meleeAttack,startingX,startingY,attackRadius,cannotUseSpecialPower,movementRadius);

			icon = 'M';
			
		}
	
	
	
	
	public Marksman(String name, int health, int damage, boolean meleeAttack,
			int attackRadius, boolean cannotUseSpecialPower, int movementRadius) {
	
		super(name,health,damage,meleeAttack,attackRadius,cannotUseSpecialPower,movementRadius);
		  
		icon = 'M';

	}

	
	
	public Marksman(){
		icon = 'M';
	}

	public Weapons getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapons weapon) {
		this.weapon = weapon;
	}
	
	
	
	public boolean isMoveValid(Cell initialCell, Cell finalCell)
	{
		return validMovement.isValidDiagonal(initialCell, finalCell, movementRadius)
				|| validMovement.isValidVertical(initialCell, finalCell, movementRadius);
	}
	
	public int doubleDamage(int damage)
	{
		return 2*damage;	
	}
}
