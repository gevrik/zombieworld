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
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

public class Game extends Activity implements OnClickListener {
	
	   public static final String KEY_DIFFICULTY =
		      "net.totalmadownage.zombieworld.difficulty";

	   public int THREAT_LEVEL = 0;
	   public int ATTACK_LEVEL = 0;
	   public int DEFENSE_LEVEL = 0;
	   public int currentenc = 0;
	   public int turns = 0;
	   
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
		textView = (TextView) findViewById(R.id.turns);
		textView.setText("Total Turns: " + turns);
		
	}
				
	setContentView(R.layout.game);
	// Set up click listeners for all the buttons
	View dirwestButton = findViewById(R.id.dir_west);
	dirwestButton.setOnClickListener(this);
		
	textView = (TextView) findViewById(R.id.threatlevel);
	textView.setText("Threat Level: " + THREAT_LEVEL + "/10");	
	textView = (TextView) findViewById(R.id.attacklevel);
	textView.setText("Attack Level: " + ATTACK_LEVEL + "/10");
	textView = (TextView) findViewById(R.id.turns);
	textView.setText("Turns: " + turns);
	}
	
	public void onClick(View v) {

		Random rand = new Random();
				
		switch (v.getId()) {
		case R.id.continue_button:
		BreathingSpace();
		break;
		
		case R.id.continue_button_bad:

			if (THREAT_LEVEL > 9) {
				
				setContentView(R.layout.theend);
				
				textView = (TextView) findViewById(R.id.turns);
				textView.setText("Total Turns: " + turns);
				
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
			}
			
		break;
		
		case R.id.dir_west:
			//THREAT_LEVEL = THREAT_LEVEL + 1;
				
  			int randenc = rand.nextInt(11);

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
			
		break;
		
		case R.id.combat_agg:
			int combat_player = rand.nextInt(20) + ATTACK_LEVEL;
			int combat_npc = rand.nextInt(20) + THREAT_LEVEL;
			
			if ( combat_player > combat_npc ) {
				setContentView(R.layout.combatsummgood);
				
				ATTACK_LEVEL = ATTACK_LEVEL + 1;
				
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
								
				View continueButton = findViewById(R.id.continue_button);
				continueButton.setOnClickListener(this);
				
			}
			else {
				
				setContentView(R.layout.combatsummbad);
				THREAT_LEVEL = THREAT_LEVEL + 1;
				
				if (THREAT_LEVEL > 9) {
					
					setContentView(R.layout.theend);
					
					textView = (TextView) findViewById(R.id.turns);
					textView.setText("Total Turns: " + turns);
					
				}
				else {
					
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
	   // More items go here (if any) ...
	   }
	   return false;
	   }
	   
	   //private static final String TAG = "Zombieworld" ;
	   
	   private void startEncZero() {
		   setContentView(R.layout.troubleahead);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
		   
		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }

	   private void startEncOne() {
		   setContentView(R.layout.roadblock);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
		   
		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }
	   
	   private void startEncTwo() {
		   setContentView(R.layout.planecrash);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
		   
		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }
	   
	   private void startEncThree() {
		   setContentView(R.layout.thebigone);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
		   
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
		   textView.setText("Turns: " + turns);

		   }
	   
	   private void startEncFive() {
		   setContentView(R.layout.armydrones);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
		   
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
		   textView.setText("Turns: " + turns);
		   }

	   private void startEncSeven() {
		   setContentView(R.layout.thepark);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
		   
		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }
	   
	   private void startEncEight() {
		   setContentView(R.layout.theghetto);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
		   
		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }
	   
	   private void startEncNine() {
		   setContentView(R.layout.constructionsite);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
		   
		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }

	   private void startEncTen() {
		   setContentView(R.layout.holidayresort);
		   
			View dirwestButton = findViewById(R.id.dir_west);
			dirwestButton.setOnClickListener(this);

			//THREAT_LEVEL = THREAT_LEVEL - 1;
		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   textView = (TextView) findViewById(R.id.turns);
		   textView.setText("Turns: " + turns);
		   }
	   
	   private void startEncEleven() {
		   setContentView(R.layout.backalley);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
		   
		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }

	   private void startEncTwelve() {
		   setContentView(R.layout.club69);
		   
			View dirwestButton = findViewById(R.id.dir_west);
			dirwestButton.setOnClickListener(this);

			THREAT_LEVEL = THREAT_LEVEL - 1;
		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   textView = (TextView) findViewById(R.id.turns);
		   textView.setText("Turns: " + turns);
		   }
	   
	   private void startEncThirteen() {
		   setContentView(R.layout.graveyard);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
		   
		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }
	   
	   private void startEncFourteen() {
		   setContentView(R.layout.ambush);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
		   
		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
		   }
	   
	   private void startEncFifteen() {
		   setContentView(R.layout.forest);
		   
			View combataggButton = findViewById(R.id.combat_agg);
			combataggButton.setOnClickListener(this);
		   
		   textView = (TextView) findViewById(R.id.threatlevel);
		   textView.setText("Threat Level: " + THREAT_LEVEL + "/10");
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