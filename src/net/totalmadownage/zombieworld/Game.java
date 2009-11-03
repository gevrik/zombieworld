package net.totalmadownage.zombieworld;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Game extends Activity implements OnClickListener {
	
	   public static final String KEY_DIFFICULTY =
		      "net.totalmadownage.zombieworld.difficulty";

	   public int THREAT_LEVEL = 0;
	   public int ATTACK_LEVEL = 0;
	   public int DEFENSE_LEVEL = 0;
	   public int currentenc = 0;
	   public int turns = 0;

	   public int shotgun = 0;
	   public int axe = 0;
	   public int grenade = 0;
	   public int money = 0;
	   
	   public int randmoney = 0;
	   
	   public int charexp = 0;
	   public int charlvl = 1;
	   public int pwrtmr = 0;
	   
	   public int playercc = 0;
	   public int npccc = 0;
	   public int ccbonus = 0;
	   public int npcdmg = 0;
	   public int combat_player = 0;
	   public int combat_npc = 0;
	   
	   Random rand = new Random();
	   
	   String loot_string = "";
	   
	   TextView textView;
	   
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	BreathingSpace();
	
	}

	private void BreathingSpace() {
	
	if (THREAT_LEVEL > 9) {
	
		setContentView(R.layout.theend);
		currentenc = 98;
		textView = (TextView) findViewById(R.id.turns);
		textView.setText("Score: " + turns);
		
	}

	currentenc = 99;

	setContentView(R.layout.game);
	// Set up click listeners for all the buttons
	View dirwestButton = findViewById(R.id.dir_west);
	dirwestButton.setOnClickListener(this);
	
	textView = (TextView) findViewById(R.id.threatlevel);
	textView.setText("Threat Level: " + THREAT_LEVEL + "/10");	
	textView = (TextView) findViewById(R.id.attacklevel);
	textView.setText("Attack Level: " + ATTACK_LEVEL + "/10");
	textView = (TextView) findViewById(R.id.turns);
	textView.setText("Score: " + turns);
	}
	
	private void Inventory() {
		
		setContentView(R.layout.inventory);
		// Set up click listeners for all the buttons
		//View dirwestButton = findViewById(R.id.dir_west);
		//dirwestButton.setOnClickListener(this);
		
		View continueButton = findViewById(R.id.continue_button);
		continueButton.setOnClickListener(this);
			
		textView = (TextView) findViewById(R.id.AmountShotgun);
		textView.setText("Shotgun: " + shotgun);	
		textView = (TextView) findViewById(R.id.AmountAxe);
		textView.setText("Axe: " + axe);
		textView = (TextView) findViewById(R.id.AmountGrenade);
		textView.setText("Grenade : " + grenade);
		textView = (TextView) findViewById(R.id.AmountMoney);
		textView.setText("Money : " + money + "$");
		
		}
	
	private void CombatInventory() {
		
		setContentView(R.layout.combatinventory);
		// Set up click listeners for all the buttons
		//View dirwestButton = findViewById(R.id.dir_west);
		//dirwestButton.setOnClickListener(this);
		
		View continueButton = findViewById(R.id.continue_button_bad);
		continueButton.setOnClickListener(this);

		if (shotgun	> 0) {
		View shotgunButton = findViewById(R.id.shotgun_button);
		shotgunButton.setOnClickListener(this);
			}
		if (axe	> 0) {
			View axeButton = findViewById(R.id.axe_button);
			axeButton.setOnClickListener(this);
			}
		if (grenade	> 0) {
			View grenadeButton = findViewById(R.id.grenade_button);
			grenadeButton.setOnClickListener(this);
			}
		
		textView = (TextView) findViewById(R.id.AmountShotgun);
		textView.setText("Shotgun: " + shotgun);	
		textView = (TextView) findViewById(R.id.AmountAxe);
		textView.setText("Axe: " + axe);
		textView = (TextView) findViewById(R.id.AmountGrenade);
		textView.setText("Grenade : " + grenade);
		
		}
	
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.continue_button:
			BreathingSpace();
		break;
		
		case R.id.combatinventory:
			CombatInventory();
		break;
		
		case R.id.shotgun_button:
			ShotgunBlast();
		break;
		
		case R.id.axe_button:
			AxeSwing();
		break;
		
		case R.id.grenade_button:
			GrenadeChuck();
		break;
		
		case R.id.continue_button_bad:

			if (THREAT_LEVEL > 9) {
				
				setContentView(R.layout.theend);
				currentenc = 98;
				
				textView = (TextView) findViewById(R.id.turns);
				textView.setText("Score: " + turns);
				
			}
			
			else {
			
			if ( currentenc == 0 ) {
				startEncZero();
			}
			else if ( currentenc == 1 ) {
				startEncOne();
			}
			else if ( currentenc == 2 ) {
				startEncTwo();
			}
			else if ( currentenc == 3 ) {
				startEncThree();
			}
			else if ( currentenc == 4 ) {
				startEncFour();
			}
			else if ( currentenc == 5 ) {
				startEncFive();
			}
			else if ( currentenc == 6 ) {
				startEncSix();
			}
			else if ( currentenc == 7 ) {
				startEncSeven();
			}
			else if ( currentenc == 8 ) {
				startEncEight();
			}
			else if ( currentenc == 9 ) {
				startEncNine();
			}
			else if ( currentenc == 10 ) {
				startEncTen();
			}
			else if ( currentenc == 11 ) {
				startEncEleven();
			}
			else if ( currentenc == 12 ) {
				startEncTwelve();
			}
			else if ( currentenc == 13 ) {
				startEncThirteen();
			}
			else if ( currentenc == 14 ) {
				startEncFourteen();
			}
			else if ( currentenc == 15 ) {
				startEncFifteen();
			}
			else if ( currentenc == 99 ) {
				BreathingSpace();
			}
			else if ( currentenc == 98 ) {
				finish();
			}
			}
			
		break;
		
		case R.id.dir_west:
							
  			int randenc = rand.nextInt(16);

			if ( randenc == 0 ) {
				currentenc = randenc;
				turns = turns + 1;
				startEncZero();
			}
			else if ( randenc == 1 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncOne();
			}
			else if ( randenc == 2 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncTwo();
			}
			else if (randenc == 3 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncThree();
			}
			else if (randenc == 4 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncFour();
			}
			else if (randenc == 5 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncFive();
			}
			else if (randenc == 6 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncSix();
			}
			else if (randenc == 7 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncSeven();
			}
			else if (randenc == 8 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncEight();
			}
			else if (randenc == 9 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncNine();
			}
			else if (randenc == 10 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncTen();
			}
			else if (randenc == 11 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncEleven();
			}
			else if (randenc == 12 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncTwelve();
			}
			else if (randenc == 13 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncThirteen();
			}
			else if (randenc == 14 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncFourteen();
			}
			else if (randenc == 15 ) {
				turns = turns + 1;
				currentenc = randenc;
				startEncFifteen();
			}
			else {
				turns = turns + 1;
				currentenc = 15;
				startEncFifteen();
			}			
			
		break;
		
		case R.id.combat_agg:
			
			playercc = 0;
			//npccc = rand.nextInt(5);
			
			if (npccc == 0 && playercc == 0) {
				ccbonus = 0;
			}

			else if (npccc == 1 && playercc == 0) {
				ccbonus = 5;
			}
			
			else if (npccc == 2 && playercc == 0) {
				ccbonus = 2;
			}

			else if (npccc == 3 && playercc == 0) {
				ccbonus = -2;
			}

			else if (npccc == 4 && playercc == 0) {
				ccbonus = -5;
			}
			
			combat_player = rand.nextInt(20) + ATTACK_LEVEL + ccbonus;
			combat_npc = rand.nextInt(20) + THREAT_LEVEL + npcdmg;
			
			if ( combat_player > combat_npc ) {
				setContentView(R.layout.combatsummgood);

				textView = (TextView) findViewById(R.id.MoveSumm);
				
				if (npccc == 0) {
				textView.setText("[YOU] AGG vs AGG [ZOM] : 0");
				}
				else if (npccc == 1) {
					textView.setText("[YOU] AGG vs NOR [ZOM] : +5");
					}
				else if (npccc == 2) {
					textView.setText("[YOU] AGG vs WIT [ZOM] : +2");
					}				
				else if (npccc == 3) {
					textView.setText("[YOU] AGG vs SNK [ZOM] : -2");
					}
				else if (npccc == 4) {
					textView.setText("[YOU] AGG vs DEF [ZOM] : -5");
					}
				
				ATTACK_LEVEL = ATTACK_LEVEL + 1;
				charexp = charexp + ((npcdmg + 1) * 20) ;
				
				if (charexp >= (charlvl * 500)) {
					charlvl = charlvl + 1;
					charexp = 0;
				}
				
				if (ATTACK_LEVEL > 10) {
					ATTACK_LEVEL = 10;
				}
						
				textView = (TextView) findViewById(R.id.CombatSummGood);
				int rand_successmsg = rand.nextInt(3);				
				
				if (rand_successmsg == 0) {
					textView.setText("You grab a sharp piece of metal pipe from the floor and ram it into the zombie's throat. It becomes stuck and a fountain of blood sprouts from the other end of the pipe. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}
				else if (rand_successmsg == 1) {
					textView.setText("You take a bulky stone from the ground and smash it into the zombies face. You hear bones breaking and a creepy squishy noise as blood shoots out of the zombie's head. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}
				else if (rand_successmsg == 2) {
					textView.setText("You see the very sharp end of a broken street sign stuck in the road. You maneuver yourself to the pole, wait for the zombie to charge at you and dodge away in the last second. The zombie is impaled on the pole. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}								

				int loot_chance = rand.nextInt(2);				
				
				if (loot_chance == 0) {
					textView = (TextView) findViewById(R.id.loot);
					
					int loot_type = rand.nextInt(4);
					
					if (loot_type == 0) {
						
						shotgun = shotgun + 1;
						loot_string = "shotgun";	
					}
					else if (loot_type == 1) {
						
						axe = axe + 1;
						loot_string = "axe";	
					}
					else if (loot_type == 2) {
						
						grenade = grenade + 1;
						loot_string = "grenade";	
					}
					else if (loot_type == 3) {
						
						randmoney = rand.nextInt(11);
						money = money + randmoney;
						
						loot_string = randmoney  + "$";	
					}
					
					textView.setText("Loot:" + loot_string);
					
				}
				
				View continueButton = findViewById(R.id.continue_button);
				continueButton.setOnClickListener(this);
				
			}
			else {
				
				setContentView(R.layout.combatsummbad);
	
				THREAT_LEVEL = THREAT_LEVEL + 1;
				
				if (THREAT_LEVEL > 9) {
					
					setContentView(R.layout.theend);
					currentenc = 98;
					
					textView = (TextView) findViewById(R.id.turns);
					textView.setText("Score: " + turns);
					
				}
				else {
						
					textView = (TextView) findViewById(R.id.MoveSumm);
					
						if (npccc == 0) {
						textView.setText("[YOU] AGG vs AGG [ZOM] : 0");
						}
						else if (npccc == 1) {
							textView.setText("[YOU] AGG vs NOR [ZOM] : +5");
							}
						else if (npccc == 2) {
							textView.setText("[YOU] AGG vs WIT [ZOM] : +2");
							}				
						else if (npccc == 3) {
							textView.setText("[YOU] AGG vs SNK [ZOM] : -2");
							}
						else if (npccc == 4) {
							textView.setText("[YOU] AGG vs DEF [ZOM] : -5");
							}					
					
						textView = (TextView) findViewById(R.id.CombatSummBad);	
						
					int rand_successmsg = rand.nextInt(3);				
					
					if (rand_successmsg == 0) {
						textView.setText("As you look for a weapon, the zombie manages to slam you in the back, smashing you into the ground. You see it closing in again as you get back to your feet...");	
					}
					else if (rand_successmsg == 1) {
						textView.setText("You swing at the zombie with a stick that you found but it dodges your blow. While you are recovring the zombie rams into your side and takes you down...");	
					}
					else if (rand_successmsg == 2) {
						textView.setText("The zombie is very fast and grapples your torso. It keeps rocking and biting until you topple over with it landing on top of you...");	
					}												
					
				View continueButton = findViewById(R.id.continue_button_bad);
				continueButton.setOnClickListener(this);
				}
			}
		break;

		case R.id.combat_nor:
			
			playercc = 1;
			//npccc = rand.nextInt(5);
			
			if (npccc == 0 && playercc == 1) {
				ccbonus = -5;
			}

			else if (npccc == 1 && playercc == 1) {
				ccbonus = 0;
			}
			
			else if (npccc == 2 && playercc == 1) {
				ccbonus = 5;
			}

			else if (npccc == 3 && playercc == 1) {
				ccbonus = 2;
			}

			else if (npccc == 4 && playercc == 1) {
				ccbonus = -2;
			}
			
			combat_player = rand.nextInt(20) + ATTACK_LEVEL + ccbonus;
			combat_npc = rand.nextInt(20) + THREAT_LEVEL + npcdmg;
			
			if ( combat_player > combat_npc ) {
				setContentView(R.layout.combatsummgood);
				
				ATTACK_LEVEL = ATTACK_LEVEL + 1;
				charexp = charexp + ((npcdmg + 1) * 20) ;
				
				if (charexp >= (charlvl * 500)) {
					charlvl = charlvl + 1;
					charexp = 0;
				}
				
				if (ATTACK_LEVEL > 10) {
					ATTACK_LEVEL = 10;
				}
				
				textView = (TextView) findViewById(R.id.MoveSumm);
				
				if (npccc == 0) {
				textView.setText("[YOU] NOR vs AGG [ZOM] : -5");
				}
				else if (npccc == 1) {
					textView.setText("[YOU] NOR vs NOR [ZOM] : 0");
					}
				else if (npccc == 2) {
					textView.setText("[YOU] NOR vs WIT [ZOM] : +5");
					}				
				else if (npccc == 3) {
					textView.setText("[YOU] NOR vs SNK [ZOM] : +2");
					}
				else if (npccc == 4) {
					textView.setText("[YOU] NOR vs DEF [ZOM] : -2");
					}

				textView = (TextView) findViewById(R.id.CombatSummGood);
				int rand_successmsg = rand.nextInt(3);				
				
				if (rand_successmsg == 0) {
					textView.setText("You grab a sharp piece of metal pipe from the floor and ram it into the zombie's throat. It becomes stuck and a fountain of blood sprouts from the other end of the pipe. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}
				else if (rand_successmsg == 1) {
					textView.setText("You take a bulky stone from the ground and smash it into the zombies face. You hear bones breaking and a creepy squishy noise as blood shoots out of the zombie's head. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}
				else if (rand_successmsg == 2) {
					textView.setText("You see the very sharp end of a broken street sign stuck in the road. You maneuver yourself to the pole, wait for the zombie to charge at you and dodge away in the last second. The zombie is impaled on the pole. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}								

				int loot_chance = rand.nextInt(2);				
				
				if (loot_chance == 0) {
					textView = (TextView) findViewById(R.id.loot);
					
					int loot_type = rand.nextInt(4);
					
					if (loot_type == 0) {
						
						shotgun = shotgun + 1;
						loot_string = "shotgun";	
					}
					else if (loot_type == 1) {
						
						axe = axe + 1;
						loot_string = "axe";	
					}
					else if (loot_type == 2) {
						
						grenade = grenade + 1;
						loot_string = "grenade";	
					}
					else if (loot_type == 3) {
						
						randmoney = rand.nextInt(11);
						money = money + randmoney;
						
						loot_string = randmoney  + "$";	
					}
					
					textView.setText("Loot:" + loot_string);
					
				}
				
				View continueButton = findViewById(R.id.continue_button);
				continueButton.setOnClickListener(this);
				
			}
			else {
				
				setContentView(R.layout.combatsummbad);
				THREAT_LEVEL = THREAT_LEVEL + 1;		
				
				if (THREAT_LEVEL > 9) {
					
					setContentView(R.layout.theend);
					
					currentenc = 98;
					
					textView = (TextView) findViewById(R.id.turns);
					textView.setText("Score: " + turns);
										
				}
				else {

					textView = (TextView) findViewById(R.id.MoveSumm);
					
					if (npccc == 0) {
						textView.setText("[YOU] NOR vs AGG [ZOM] : -5");
						}
						else if (npccc == 1) {
							textView.setText("[YOU] NOR vs NOR [ZOM] : 0");
							}
						else if (npccc == 2) {
							textView.setText("[YOU] NOR vs WIT [ZOM] : +5");
							}				
						else if (npccc == 3) {
							textView.setText("[YOU] NOR vs SNK [ZOM] : +2");
							}
						else if (npccc == 4) {
							textView.setText("[YOU] NOR vs DEF [ZOM] : -2");
							}
					
					textView = (TextView) findViewById(R.id.CombatSummBad);
					int rand_successmsg = rand.nextInt(3);				
					
					if (rand_successmsg == 0) {
						textView.setText("As you look for a weapon, the zombie manages to slam you in the back, smashing you into the ground. You see it closing in again as you get back to your feet...");	
					}
					else if (rand_successmsg == 1) {
						textView.setText("You swing at the zombie with a stick that you found but it dodges your blow. While you are recovring the zombie rams into your side and takes you down...");	
					}
					else if (rand_successmsg == 2) {
						textView.setText("The zombie is very fast and grapples your torso. It keeps rocking and biting until you topple over with it landing on top of you...");	
					}												
					
				View continueButton = findViewById(R.id.continue_button_bad);
				continueButton.setOnClickListener(this);
				}
			}
		break;

		
		case R.id.combat_wit:
			
			playercc = 2;
			//npccc = rand.nextInt(5);
			
			if (npccc == 0 && playercc == 2) {
				ccbonus = -2;
			}

			else if (npccc == 1 && playercc == 2) {
				ccbonus = -5;
			}
			
			else if (npccc == 2 && playercc == 2) {
				ccbonus = 0;
			}

			else if (npccc == 3 && playercc == 2) {
				ccbonus = 5;
			}

			else if (npccc == 4 && playercc == 2) {
				ccbonus = 2;
			}
			
			combat_player = rand.nextInt(20) + ATTACK_LEVEL + ccbonus;
			combat_npc = rand.nextInt(20) + THREAT_LEVEL + npcdmg;
			
			if ( combat_player > combat_npc ) {
				setContentView(R.layout.combatsummgood);
				
				ATTACK_LEVEL = ATTACK_LEVEL + 1;
				charexp = charexp + ((npcdmg + 1) * 20) ;
				
				if (charexp >= (charlvl * 500)) {
					charlvl = charlvl + 1;
					charexp = 0;
				}
				
				if (ATTACK_LEVEL > 10) {
					ATTACK_LEVEL = 10;
				}

				textView = (TextView) findViewById(R.id.MoveSumm);
				
				if (npccc == 0) {
				textView.setText("[YOU] WIT vs AGG [ZOM] : -2");
				}
				else if (npccc == 1) {
					textView.setText("[YOU] WIT vs NOR [ZOM] : -5");
					}
				else if (npccc == 2) {
					textView.setText("[YOU] WIT vs WIT [ZOM] : 0");
					}				
				else if (npccc == 3) {
					textView.setText("[YOU] WIT vs SNK [ZOM] : 5");
					}
				else if (npccc == 4) {
					textView.setText("[YOU] WIT vs DEF [ZOM] : 2");
					}
				
				textView = (TextView) findViewById(R.id.CombatSummGood);
				int rand_successmsg = rand.nextInt(3);				
				
				if (rand_successmsg == 0) {
					textView.setText("You grab a sharp piece of metal pipe from the floor and ram it into the zombie's throat. It becomes stuck and a fountain of blood sprouts from the other end of the pipe. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}
				else if (rand_successmsg == 1) {
					textView.setText("You take a bulky stone from the ground and smash it into the zombies face. You hear bones breaking and a creepy squishy noise as blood shoots out of the zombie's head. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}
				else if (rand_successmsg == 2) {
					textView.setText("You see the very sharp end of a broken street sign stuck in the road. You maneuver yourself to the pole, wait for the zombie to charge at you and dodge away in the last second. The zombie is impaled on the pole. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}								

				int loot_chance = rand.nextInt(2);				
				
				if (loot_chance == 0) {
					textView = (TextView) findViewById(R.id.loot);
					
					int loot_type = rand.nextInt(4);
					
					if (loot_type == 0) {
						
						shotgun = shotgun + 1;
						loot_string = "shotgun";	
					}
					else if (loot_type == 1) {
						
						axe = axe + 1;
						loot_string = "axe";	
					}
					else if (loot_type == 2) {
						
						grenade = grenade + 1;
						loot_string = "grenade";	
					}
					else if (loot_type == 3) {
						
						randmoney = rand.nextInt(11);
						money = money + randmoney;
						
						loot_string = randmoney  + "$";	
					}
					
					textView.setText("Loot:" + loot_string);
					
				}
				
				View continueButton = findViewById(R.id.continue_button);
				continueButton.setOnClickListener(this);
				
			}
			else {
				
				setContentView(R.layout.combatsummbad);
				THREAT_LEVEL = THREAT_LEVEL + 1;
				
				if (THREAT_LEVEL > 9) {
					
					setContentView(R.layout.theend);
					
					currentenc = 98;
					
					textView = (TextView) findViewById(R.id.turns);
					textView.setText("Score: " + turns);
					
				}
				else {

					textView = (TextView) findViewById(R.id.MoveSumm);
					
					if (npccc == 0) {
					textView.setText("[YOU] WIT vs AGG [ZOM] : -2");
					}
					else if (npccc == 1) {
						textView.setText("[YOU] WIT vs NOR [ZOM] : -5");
						}
					else if (npccc == 2) {
						textView.setText("[YOU] WIT vs WIT [ZOM] : 0");
						}				
					else if (npccc == 3) {
						textView.setText("[YOU] WIT vs SNK [ZOM] : 5");
						}
					else if (npccc == 4) {
						textView.setText("[YOU] WIT vs DEF [ZOM] : 2");
						}

					
					textView = (TextView) findViewById(R.id.CombatSummBad);
					int rand_successmsg = rand.nextInt(3);				
					
					if (rand_successmsg == 0) {
						textView.setText("As you look for a weapon, the zombie manages to slam you in the back, smashing you into the ground. You see it closing in again as you get back to your feet...");	
					}
					else if (rand_successmsg == 1) {
						textView.setText("You swing at the zombie with a stick that you found but it dodges your blow. While you are recovring the zombie rams into your side and takes you down...");	
					}
					else if (rand_successmsg == 2) {
						textView.setText("The zombie is very fast and grapples your torso. It keeps rocking and biting until you topple over with it landing on top of you...");	
					}												
					
				View continueButton = findViewById(R.id.continue_button_bad);
				continueButton.setOnClickListener(this);
				}
			}
		break;

		case R.id.combat_snk:
			
			playercc = 3;
			//npccc = rand.nextInt(5);
			
			if (npccc == 0 && playercc == 3) {
				ccbonus = 2;
			}

			else if (npccc == 1 && playercc == 3) {
				ccbonus = -2;
			}
			
			else if (npccc == 2 && playercc == 3) {
				ccbonus = -5;
			}

			else if (npccc == 3 && playercc == 3) {
				ccbonus = 0;
			}

			else if (npccc == 4 && playercc == 3) {
				ccbonus = 5;
			}
			
			combat_player = rand.nextInt(20) + ATTACK_LEVEL + ccbonus;
			combat_npc = rand.nextInt(20) + THREAT_LEVEL + npcdmg;
			
			if ( combat_player > combat_npc ) {
				setContentView(R.layout.combatsummgood);
				
				ATTACK_LEVEL = ATTACK_LEVEL + 1;
				charexp = charexp + ((npcdmg + 1) * 20) ;
				
				if (charexp >= (charlvl * 500)) {
					charlvl = charlvl + 1;
					charexp = 0;
				}
				
				if (ATTACK_LEVEL > 10) {
					ATTACK_LEVEL = 10;
				}

				textView = (TextView) findViewById(R.id.MoveSumm);
				
				if (npccc == 0) {
				textView.setText("[YOU] SNK vs AGG [ZOM] : 2");
				}
				else if (npccc == 1) {
					textView.setText("[YOU] SNK vs NOR [ZOM] : -2");
					}
				else if (npccc == 2) {
					textView.setText("[YOU] SNK vs WIT [ZOM] : -5");
					}				
				else if (npccc == 3) {
					textView.setText("[YOU] SNK vs SNK [ZOM] : 0");
					}
				else if (npccc == 4) {
					textView.setText("[YOU] SNK vs DEF [ZOM] : 5");
					}

				
				textView = (TextView) findViewById(R.id.CombatSummGood);
				int rand_successmsg = rand.nextInt(3);				
				
				if (rand_successmsg == 0) {
					textView.setText("You grab a sharp piece of metal pipe from the floor and ram it into the zombie's throat. It becomes stuck and a fountain of blood sprouts from the other end of the pipe. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}
				else if (rand_successmsg == 1) {
					textView.setText("You take a bulky stone from the ground and smash it into the zombies face. You hear bones breaking and a creepy squishy noise as blood shoots out of the zombie's head. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}
				else if (rand_successmsg == 2) {
					textView.setText("You see the very sharp end of a broken street sign stuck in the road. You maneuver yourself to the pole, wait for the zombie to charge at you and dodge away in the last second. The zombie is impaled on the pole. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}								

				int loot_chance = rand.nextInt(2);				
				
				if (loot_chance == 0) {
					textView = (TextView) findViewById(R.id.loot);
					
					int loot_type = rand.nextInt(4);
					
					if (loot_type == 0) {
						
						shotgun = shotgun + 1;
						loot_string = "shotgun";	
					}
					else if (loot_type == 1) {
						
						axe = axe + 1;
						loot_string = "axe";	
					}
					else if (loot_type == 2) {
						
						grenade = grenade + 1;
						loot_string = "grenade";	
					}
					else if (loot_type == 3) {
						
						randmoney = rand.nextInt(11);
						money = money + randmoney;
						
						loot_string = randmoney  + "$";	
					}
					
					textView.setText("Loot:" + loot_string);
					
				}
				
				View continueButton = findViewById(R.id.continue_button);
				continueButton.setOnClickListener(this);
				
			}
			else {
				
				setContentView(R.layout.combatsummbad);
				THREAT_LEVEL = THREAT_LEVEL + 1;
				
				if (THREAT_LEVEL > 9) {
					
					setContentView(R.layout.theend);
					currentenc = 98;
					
					textView = (TextView) findViewById(R.id.turns);
					textView.setText("Score: " + turns);
					
				}
				else {

					textView = (TextView) findViewById(R.id.MoveSumm);
					
					if (npccc == 0) {
					textView.setText("[YOU] SNK vs AGG [ZOM] : 2");
					}
					else if (npccc == 1) {
						textView.setText("[YOU] SNK vs NOR [ZOM] : -2");
						}
					else if (npccc == 2) {
						textView.setText("[YOU] SNK vs WIT [ZOM] : -5");
						}				
					else if (npccc == 3) {
						textView.setText("[YOU] SNK vs SNK [ZOM] : 0");
						}
					else if (npccc == 4) {
						textView.setText("[YOU] SNK vs DEF [ZOM] : 5");
						}

					
					textView = (TextView) findViewById(R.id.CombatSummBad);
					int rand_successmsg = rand.nextInt(3);				
					
					if (rand_successmsg == 0) {
						textView.setText("As you look for a weapon, the zombie manages to slam you in the back, smashing you into the ground. You see it closing in again as you get back to your feet...");	
					}
					else if (rand_successmsg == 1) {
						textView.setText("You swing at the zombie with a stick that you found but it dodges your blow. While you are recovring the zombie rams into your side and takes you down...");	
					}
					else if (rand_successmsg == 2) {
						textView.setText("The zombie is very fast and grapples your torso. It keeps rocking and biting until you topple over with it landing on top of you...");	
					}												
					
				View continueButton = findViewById(R.id.continue_button_bad);
				continueButton.setOnClickListener(this);
				}
			}
		break;
		
		case R.id.combat_def:
			
			playercc = 4;
			//npccc = rand.nextInt(5);
			
			if (npccc == 0 && playercc == 4) {
				ccbonus = 5;
			}

			else if (npccc == 1 && playercc == 4) {
				ccbonus = 2;
			}
			
			else if (npccc == 2 && playercc == 4) {
				ccbonus = -2;
			}

			else if (npccc == 3 && playercc == 4) {
				ccbonus = -5;
			}

			else if (npccc == 4 && playercc == 4) {
				ccbonus = 0;
			}
			
			combat_player = rand.nextInt(20) + ATTACK_LEVEL + ccbonus;
			combat_npc = rand.nextInt(20) + THREAT_LEVEL + npcdmg;
			
			if ( combat_player > combat_npc ) {
				setContentView(R.layout.combatsummgood);
				
				ATTACK_LEVEL = ATTACK_LEVEL + 1;
				charexp = charexp + ((npcdmg + 1) * 20) ;
				
				if (charexp >= (charlvl * 500)) {
					charlvl = charlvl + 1;
					charexp = 0;
				}
				
				if (ATTACK_LEVEL > 10) {
					ATTACK_LEVEL = 10;
				}

				textView = (TextView) findViewById(R.id.MoveSumm);
				
				if (npccc == 0) {
				textView.setText("[YOU] DEF vs AGG [ZOM] : 5");
				}
				else if (npccc == 1) {
					textView.setText("[YOU] DEF vs NOR [ZOM] : 2");
					}
				else if (npccc == 2) {
					textView.setText("[YOU] DEF vs WIT [ZOM] : -2");
					}				
				else if (npccc == 3) {
					textView.setText("[YOU] DEF vs SNK [ZOM] : -5");
					}
				else if (npccc == 4) {
					textView.setText("[YOU] DEF vs DEF [ZOM] : 0");
					}

				
				textView = (TextView) findViewById(R.id.CombatSummGood);
				int rand_successmsg = rand.nextInt(3);				
				
				if (rand_successmsg == 0) {
					textView.setText("You grab a sharp piece of metal pipe from the floor and ram it into the zombie's throat. It becomes stuck and a fountain of blood sprouts from the other end of the pipe. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}
				else if (rand_successmsg == 1) {
					textView.setText("You take a bulky stone from the ground and smash it into the zombies face. You hear bones breaking and a creepy squishy noise as blood shoots out of the zombie's head. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}
				else if (rand_successmsg == 2) {
					textView.setText("You see the very sharp end of a broken street sign stuck in the road. You maneuver yourself to the pole, wait for the zombie to charge at you and dodge away in the last second. The zombie is impaled on the pole. Well done. You feel that you have learned something about combat. Time to start running again...");	
				}								

				int loot_chance = rand.nextInt(2);				
				
				if (loot_chance == 0) {
					textView = (TextView) findViewById(R.id.loot);
					
					int loot_type = rand.nextInt(4);
					
					if (loot_type == 0) {
						
						shotgun = shotgun + 1;
						loot_string = "shotgun";	
					}
					else if (loot_type == 1) {
						
						axe = axe + 1;
						loot_string = "axe";	
					}
					else if (loot_type == 2) {
						
						grenade = grenade + 1;
						loot_string = "grenade";	
					}
					else if (loot_type == 3) {
						
						randmoney = rand.nextInt(11);
						money = money + randmoney;
						
						loot_string = randmoney  + "$";	
					}
					
					textView.setText("Loot:" + loot_string);
					
				}
				
				View continueButton = findViewById(R.id.continue_button);
				continueButton.setOnClickListener(this);
				
			}
			else {
				
				setContentView(R.layout.combatsummbad);
				THREAT_LEVEL = THREAT_LEVEL + 1;
				
				if (THREAT_LEVEL > 9) {
					
					setContentView(R.layout.theend);
					currentenc = 98;
					
					textView = (TextView) findViewById(R.id.turns);
					textView.setText("Score: " + turns);
					
				}
				else {
					
					textView = (TextView) findViewById(R.id.MoveSumm);
					
					if (npccc == 0) {
					textView.setText("[YOU] DEF vs AGG [ZOM] : 5");
					}
					else if (npccc == 1) {
						textView.setText("[YOU] DEF vs NOR [ZOM] : 2");
						}
					else if (npccc == 2) {
						textView.setText("[YOU] DEF vs WIT [ZOM] : -2");
						}				
					else if (npccc == 3) {
						textView.setText("[YOU] DEF vs SNK [ZOM] : -5");
						}
					else if (npccc == 4) {
						textView.setText("[YOU] DEF vs DEF [ZOM] : 0");
						}
					
					textView = (TextView) findViewById(R.id.CombatSummBad);
					int rand_successmsg = rand.nextInt(3);				
					
					if (rand_successmsg == 0) {
						textView.setText("As you look for a weapon, the zombie manages to slam you in the back, smashing you into the ground. You see it closing in again as you get back to your feet...");	
					}
					else if (rand_successmsg == 1) {
						textView.setText("You swing at the zombie with a stick that you found but it dodges your blow. While you are recovring the zombie rams into your side and takes you down...");	
					}
					else if (rand_successmsg == 2) {
						textView.setText("The zombie is very fast and grapples your torso. It keeps rocking and biting until you topple over with it landing on top of you...");	
					}												
					
				View continueButton = findViewById(R.id.continue_button_bad);
				continueButton.setOnClickListener(this);
				}
			}
		break;
		
		}
	}

	   @Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	      super.onCreateOptionsMenu(menu);
	      MenuInflater inflater = getMenuInflater();
	      inflater.inflate(R.menu.menu, menu);
	      return true;
	   }
	   
	   @Override
	   public boolean onOptionsItemSelected(MenuItem item) {
	   switch (item.getItemId()) {
	   case R.id.settings:
		   startActivity(new Intent(this, Prefs.class));
		   return true;
	   case R.id.charsheet:
		   
		   if ( currentenc == 98 ) {
			   finish();
		   }
		   
		   CharSheet();
		   return true;
	   case R.id.minventory:
		   
		   if ( currentenc == 98 ) {
			   finish();
		   }
		   
		   Inventory();
		   return true;
	   // More items go here (if any) ...
	   }
	   return false;
	   }
	   
	   //private static final String TAG = "Zombieworld" ;
	   
	   private void startEncZero() {
		   setContentView(R.layout.troubleahead);
		   
		   npccc = 3;
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
			View combatnorButton = findViewById(R.id.combat_nor);
			combatnorButton.setOnClickListener(this);
			View combatwitButton = findViewById(R.id.combat_wit);
			combatwitButton.setOnClickListener(this);
			View combatsnkButton = findViewById(R.id.combat_snk);
			combatsnkButton.setOnClickListener(this);
			View combatdefButton = findViewById(R.id.combat_def);
			combatdefButton.setOnClickListener(this);
			
			View combatinvButton = findViewById(R.id.combatinventory);
			combatinvButton.setOnClickListener(this);
		   
			   textView = (TextView) findViewById(R.id.threatlevel);
			   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }

	   private void startEncOne() {
		   setContentView(R.layout.roadblock);
		   
		   npccc = 1;
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
			View combatnorButton = findViewById(R.id.combat_nor);
			combatnorButton.setOnClickListener(this);
			View combatwitButton = findViewById(R.id.combat_wit);
			combatwitButton.setOnClickListener(this);
			View combatsnkButton = findViewById(R.id.combat_snk);
			combatsnkButton.setOnClickListener(this);
			View combatdefButton = findViewById(R.id.combat_def);
			combatdefButton.setOnClickListener(this);
			
			View combatinvButton = findViewById(R.id.combatinventory);
			combatinvButton.setOnClickListener(this);
			
			   textView = (TextView) findViewById(R.id.threatlevel);
			   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }
	   
	   private void startEncTwo() {
		   setContentView(R.layout.planecrash);
		   
		   npccc = 2;
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
			View combatnorButton = findViewById(R.id.combat_nor);
			combatnorButton.setOnClickListener(this);
			View combatwitButton = findViewById(R.id.combat_wit);
			combatwitButton.setOnClickListener(this);
			View combatsnkButton = findViewById(R.id.combat_snk);
			combatsnkButton.setOnClickListener(this);
			View combatdefButton = findViewById(R.id.combat_def);
			combatdefButton.setOnClickListener(this);
			
			View combatinvButton = findViewById(R.id.combatinventory);
			combatinvButton.setOnClickListener(this);
		
			   textView = (TextView) findViewById(R.id.threatlevel);
			   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
	   }
	   
	   private void startEncThree() {
		   setContentView(R.layout.thebigone);
		   
		   npccc = 0;
		   npcdmg = rand.nextInt(10);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
			View combatnorButton = findViewById(R.id.combat_nor);
			combatnorButton.setOnClickListener(this);
			View combatwitButton = findViewById(R.id.combat_wit);
			combatwitButton.setOnClickListener(this);
			View combatsnkButton = findViewById(R.id.combat_snk);
			combatsnkButton.setOnClickListener(this);
			View combatdefButton = findViewById(R.id.combat_def);
			combatdefButton.setOnClickListener(this);
			
			View combatinvButton = findViewById(R.id.combatinventory);
			combatinvButton.setOnClickListener(this);
			
			   textView = (TextView) findViewById(R.id.threatlevel);
			   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }
	   
	   private void startEncFour() {
		   setContentView(R.layout.airstrike);
		   
			View dirwestButton = findViewById(R.id.dir_west);
			dirwestButton.setOnClickListener(this);

		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   textView = (TextView) findViewById(R.id.turns);
		   textView.setText("Score: " + turns);

		   }
	   
	   private void startEncFive() {
		   setContentView(R.layout.armydrones);
		   
		   npccc = 2;
		   npcdmg = rand.nextInt(4);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
			View combatnorButton = findViewById(R.id.combat_nor);
			combatnorButton.setOnClickListener(this);
			View combatwitButton = findViewById(R.id.combat_wit);
			combatwitButton.setOnClickListener(this);
			View combatsnkButton = findViewById(R.id.combat_snk);
			combatsnkButton.setOnClickListener(this);
			View combatdefButton = findViewById(R.id.combat_def);
			combatdefButton.setOnClickListener(this);
			
			View combatinvButton = findViewById(R.id.combatinventory);
			combatinvButton.setOnClickListener(this);
			
			   textView = (TextView) findViewById(R.id.threatlevel);
			   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }

	   private void startEncSix() {
		   setContentView(R.layout.refuge);
		   
			View dirwestButton = findViewById(R.id.dir_west);
			dirwestButton.setOnClickListener(this);

		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   textView = (TextView) findViewById(R.id.turns);
		   textView.setText("Score: " + turns);
		   }

	   private void startEncSeven() {
		   setContentView(R.layout.thepark);
		   
		   npccc = 1;
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
			View combatnorButton = findViewById(R.id.combat_nor);
			combatnorButton.setOnClickListener(this);
			View combatwitButton = findViewById(R.id.combat_wit);
			combatwitButton.setOnClickListener(this);
			View combatsnkButton = findViewById(R.id.combat_snk);
			combatsnkButton.setOnClickListener(this);
			View combatdefButton = findViewById(R.id.combat_def);
			combatdefButton.setOnClickListener(this);
			
			View combatinvButton = findViewById(R.id.combatinventory);
			combatinvButton.setOnClickListener(this);
			
			   textView = (TextView) findViewById(R.id.threatlevel);
			   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }
	   
	   private void startEncEight() {
		   setContentView(R.layout.theghetto);
		   
		   npccc = 0;
		   npcdmg = rand.nextInt(2);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
			View combatnorButton = findViewById(R.id.combat_nor);
			combatnorButton.setOnClickListener(this);
			View combatwitButton = findViewById(R.id.combat_wit);
			combatwitButton.setOnClickListener(this);
			View combatsnkButton = findViewById(R.id.combat_snk);
			combatsnkButton.setOnClickListener(this);
			View combatdefButton = findViewById(R.id.combat_def);
			combatdefButton.setOnClickListener(this);
			
			View combatinvButton = findViewById(R.id.combatinventory);
			combatinvButton.setOnClickListener(this);
			
			   textView = (TextView) findViewById(R.id.threatlevel);
			   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }
	   
	   private void startEncNine() {
		   setContentView(R.layout.constructionsite);
		   
		   npccc = 2;
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
			View combatnorButton = findViewById(R.id.combat_nor);
			combatnorButton.setOnClickListener(this);
			View combatwitButton = findViewById(R.id.combat_wit);
			combatwitButton.setOnClickListener(this);
			View combatsnkButton = findViewById(R.id.combat_snk);
			combatsnkButton.setOnClickListener(this);
			View combatdefButton = findViewById(R.id.combat_def);
			combatdefButton.setOnClickListener(this);
			
			View combatinvButton = findViewById(R.id.combatinventory);
			combatinvButton.setOnClickListener(this);
			
			   textView = (TextView) findViewById(R.id.threatlevel);
			   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }

	   private void startEncTen() {
		   setContentView(R.layout.holidayresort);
		   
			View dirwestButton = findViewById(R.id.dir_west);
			dirwestButton.setOnClickListener(this);

		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   textView = (TextView) findViewById(R.id.turns);
		   textView.setText("Score: " + turns);
		   }
	   
	   private void startEncEleven() {
		   setContentView(R.layout.graveyard);
		   
		   npccc = 1;
		   npcdmg = rand.nextInt(5);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
			View combatnorButton = findViewById(R.id.combat_nor);
			combatnorButton.setOnClickListener(this);
			View combatwitButton = findViewById(R.id.combat_wit);
			combatwitButton.setOnClickListener(this);
			View combatsnkButton = findViewById(R.id.combat_snk);
			combatsnkButton.setOnClickListener(this);
			View combatdefButton = findViewById(R.id.combat_def);
			combatdefButton.setOnClickListener(this);
			
			View combatinvButton = findViewById(R.id.combatinventory);
			combatinvButton.setOnClickListener(this);
			
			   textView = (TextView) findViewById(R.id.threatlevel);
			   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }

	   private void startEncTwelve() {
		   setContentView(R.layout.club69);
		   
			View dirwestButton = findViewById(R.id.dir_west);
			dirwestButton.setOnClickListener(this);

		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   textView = (TextView) findViewById(R.id.turns);
		   textView.setText("Score: " + turns);
		   }
	   
	   private void startEncThirteen() {
		   setContentView(R.layout.graveyard);
		   
		   npccc = 4;
		   npcdmg = rand.nextInt(10);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
			View combatnorButton = findViewById(R.id.combat_nor);
			combatnorButton.setOnClickListener(this);
			View combatwitButton = findViewById(R.id.combat_wit);
			combatwitButton.setOnClickListener(this);
			View combatsnkButton = findViewById(R.id.combat_snk);
			combatsnkButton.setOnClickListener(this);
			View combatdefButton = findViewById(R.id.combat_def);
			combatdefButton.setOnClickListener(this);
			
			View combatinvButton = findViewById(R.id.combatinventory);
			combatinvButton.setOnClickListener(this);
			
			   textView = (TextView) findViewById(R.id.threatlevel);
			   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }
	   
	   private void startEncFourteen() {
		   setContentView(R.layout.ambush);
		   
		   npccc = 3;
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
			View combatnorButton = findViewById(R.id.combat_nor);
			combatnorButton.setOnClickListener(this);
			View combatwitButton = findViewById(R.id.combat_wit);
			combatwitButton.setOnClickListener(this);
			View combatsnkButton = findViewById(R.id.combat_snk);
			combatsnkButton.setOnClickListener(this);
			View combatdefButton = findViewById(R.id.combat_def);
			combatdefButton.setOnClickListener(this);
			
			View combatinvButton = findViewById(R.id.combatinventory);
			combatinvButton.setOnClickListener(this);
		   
		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }
	   
	   private void startEncFifteen() {
		   setContentView(R.layout.forest);
		   
		   npccc = 2;
		   npcdmg = rand.nextInt(3);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
			View combatnorButton = findViewById(R.id.combat_nor);
			combatnorButton.setOnClickListener(this);
			View combatwitButton = findViewById(R.id.combat_wit);
			combatwitButton.setOnClickListener(this);
			View combatsnkButton = findViewById(R.id.combat_snk);
			combatsnkButton.setOnClickListener(this);
			View combatdefButton = findViewById(R.id.combat_def);
			combatdefButton.setOnClickListener(this);
			
			View combatinvButton = findViewById(R.id.combatinventory);
			combatinvButton.setOnClickListener(this);
			
			   textView = (TextView) findViewById(R.id.threatlevel);
			   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }
	   
	   private void ShotgunBlast() {
		   setContentView(R.layout.shotgunblast);
		   
		    shotgun = shotgun - 1;
			View continueButton = findViewById(R.id.continue_button);
			continueButton.setOnClickListener(this);
		   
		   }

	   private void AxeSwing() {
		   setContentView(R.layout.axeswing);
		   
		    axe = axe - 1;
			View continueButton = findViewById(R.id.continue_button);
			continueButton.setOnClickListener(this);
		   
		   }
	   
	   private void GrenadeChuck() {
		   setContentView(R.layout.grenadechuck);
		   
		    grenade = grenade - 1;
			View continueButton = findViewById(R.id.continue_button);
			continueButton.setOnClickListener(this);
		   
		   }
	   
	   private void CharSheet() {
		   setContentView(R.layout.charsheet);
		   
		   textView = (TextView) findViewById(R.id.charlevel);
		   textView.setText("Level: " + charlvl);
		   
		   textView = (TextView) findViewById(R.id.charexp);
		   textView.setText("XP: " + charexp);
		   
		   textView = (TextView) findViewById(R.id.charatt);
		   textView.setText("Attack: " + ATTACK_LEVEL);
		   
		   textView = (TextView) findViewById(R.id.chardef);
		   textView.setText("Defense: " + DEFENSE_LEVEL);
		   
		    View continueButton = findViewById(R.id.continue_button_bad);
			continueButton.setOnClickListener(this);
		   
		   }
	   
	   @Override
	   protected void onResume() {
	   super.onResume();
	   Music.play(this, R.raw.bgmusic);
	   }

	   @Override
	   protected void onPause() {
	   super.onPause();
	   Music.stop(this);
	   }
	   
}