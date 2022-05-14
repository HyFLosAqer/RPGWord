package RPGgame;

import java.util.Arrays;

public class TEST {
  public static void main(String[] args) {
    //
    Warrior war = new Warrior("a", "a");
    Warrior war2 = new Warrior("a", "a");
    Role[] team = {new Wizard("wsz", "fs")};

    Wizard wiz = new Wizard("b", "b");

    System.out.printf("1队，%d，%d\n", war.HP, war.DPS);
    System.out.printf("2队，%d，%d\n", war2.HP, war2.DPS);
    System.out.println(team.length);
    team[0] = team[team.length - 1];
    team = Arrays.copyOf(team, team.length - 1);
    System.out.println(team.length);
  }
}
