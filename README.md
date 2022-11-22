# Text-Based-RPG-Battle-Simulator

Flow
1. Game Start

2. Character Craetion, Select Race and Class

3. Select Action (Move, Rest, Show Stat, Quit)
  3.1 Move - Traverse the map using X,Y coordinates. (0, 0) as the starting point. Rolls a Die. There is a 50% chance for a random monster to spawn per move.
     Monsters - Skeleton, Orc, Goblin, Vampire and Stone Golem
  3.2 Rest - Resting replenishes your HP to full. There is also a 50% chance to encounter a monster while resting.
  3.3 Show Stat - Show the current stat of the player.
  3.4 Quit - Quit the program.
  
4.Battle Phase - Upon encountering a monster, the battle phase will start. You have the option to attack the monster or run for your life.
                 Each monster kill will grant you experience points or EXP and after reaching a certain amount of experience your player
                 or character will level up. However, if your character falls to 0 HP the game will end.
  4.1 Boss Battle - The goal of the game is to defeat the Stone Golem. There a 2% chance for the Stone Golem to spawn while traversing the map, defeating it will end
  the game.
  
5. End game.

------------------------

METHODS

inputValidation(int low, int hi);
Checks if the user input is an int or out of bounds. The low and hi represents the lowest number and highest number to choose from. Anything lower or higher than that
will ask the user another input.

player.createCharacter();
Calls the function for character creator which is inside the Player.class.

player.showStats();
Show the current statistics of the player after creation.

map.traverseMap();
Calls the function for traversing the map inside the Map.class

spawnMonster();
Spawns a monster whenever a monster is going to spawn(50% chance). Then rolls a die between 1 and 22, the type of monster to spawn depends on the die result.

battlePhase(player, monster);
Called after spawning the monster, and the battle phase will start.

dealDamage(player, monster);
Calls the function to deal damage to the monster.

takeDamage(player, monster);
Calls the function to take damage from the monster's attack.

isPlayerDead(player);
Checks if the player is dead or reached 0 HP. If yes, end the game.

monster.showStats();
Show the monster statistics.

------------------------

FORMULAS

hitRate = (monster.DEX * 0.1)*100;

enemyEvasion = (player.AGI * 0.1) * 100;

accuracy = accuracy + (hitRate - enemyEvasion);

damage = (player.baseDMG * player.STR) - monster.VIT;
damage = (monster.baseDMG * monster.STR) - player.VIT;

critChance = Math.ceil(critChance * monster.DEX);

critBns = Math.ceil(damage * 0.50);

critDmg = damage + (int)critBns;
