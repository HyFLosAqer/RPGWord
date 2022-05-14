package RPGgame;

import java.util.Arrays;
import java.util.Random;

public class Team {
  public static final int SINGER = 1;

  private static Role[] cutRole(Role[] team) {
    for (int i = 0; i < team.length; i++) {
      if (team[i].HP <= 0) {
        team[i] = team[team.length - 1];
        team = Arrays.copyOf(team, team.length - 1);
      }
    }
    return team;
  }

  private static void bloodJudge(Role[] team1, Role[] team2) {
    Random random = new Random();

    for (int i = 0; i < team1.length; i++) {
      if (team1[i].HP > 0) {
        int enemy = random.nextInt(team2.length);
        team1[i].blood(team2[enemy]);
        if (team1[i].HP <= 0) {

          System.out.println(
              "lv"
                  + team1[i].level
                  + team1[i].name
                  + "流血死亡,随机分配给"
                  + team2[enemy].name
                  + ":等级加1，HP加20，伤害增加5");
        }
      } else if (team1[i].HP <= 0) {
        break;
      }
    }
  }

  private static void showHP(Role[] team1, Role[] team2) {
    System.out.print("一战队成员：");
    for (int i = 0; i < team1.length; i++) {
      System.out.printf("lv%d%s:HP%d\t", team1[i].level, team1[i].name, team1[i].HP);
    }
    System.out.println();
    System.out.print("二战队成员：");
    for (int i = 0; i < team2.length; i++) {
      System.out.printf("lv%d%s:HP%d\t", team2[i].level, team2[i].name, team2[i].HP);
    }
    System.out.println();
  }
  // 攻击方  //被攻击方
  // TODO: 2022/4/25
  private static void attackTeam(Role[] team1, Role[] team2) {
    if (team1.length != 0 && team2.length != 0) {
      for (int i = 0; i < team1.length; i++) {
        if (team1[i].HP > 0) {
          if (team1[i] instanceof Warrior) {
            int j = 0;
            int enemy = (int) (Math.random() * team2.length);
            while (team2[enemy].HP <= 0 && j < 100) {
              enemy = (int) (Math.random() * team2.length);
              j++;
            }
            if (team2[enemy].HP > 0) {
              team1[i].attack(team2[enemy]);
              if (((Warrior) team1[i]).weapon == 1) {
                System.out.println(
                    team1[i].name
                        + " 攻击\t "
                        + team2[enemy].name
                        + " 造成了：\t"
                        + team1[i].DPS
                        + "伤害 剩余血量："
                        + team2[enemy].HP
                        + " 产生了强吸血效果:"
                        + team1[i].DPS / 2);
              }
              if (((Warrior) team1[i]).weapon == 2) {
                System.out.println(
                    team1[i].name
                        + " 攻击\t "
                        + team2[enemy].name
                        + " 造成了：\t"
                        + team1[i].DPS
                        + "伤害 剩余血量："
                        + team2[enemy].HP
                        + " 产生了强吸血效果:"
                        + team1[i].DPS / 3);
              }
              if (((Warrior) team1[i]).weapon == 3) {
                System.out.println(
                    team1[i].name
                        + " 攻击\t "
                        + team2[enemy].name
                        + " 造成了：\t"
                        + team1[i].DPS
                        + "伤害 剩余血量："
                        + team2[enemy].HP
                        + " 对其产生了强流血效果(每回合6HP) ");
              }
              if (((Warrior) team1[i]).weapon == 4) {
                System.out.println(
                    team1[i].name
                        + " 攻击\t "
                        + team2[enemy].name
                        + " 造成了：\t"
                        + team1[i].DPS
                        + "伤害 剩余血量："
                        + team2[enemy].HP
                        + " 对其产生了弱流血效果（每回合2HP） ");
              }
              if (team2[enemy].HP <= 0) {

                System.out.println("   *" + team1[i].name + "成功击杀，等级加1，伤害加5，血量增加20HP");
              }
            }
          }
          if (team1[i] instanceof Wizard) {
            int j = 0;
            int enemy = (int) (Math.random() * team2.length);
            int friend = (int) (Math.random() * team1.length);
            while (team2[enemy].HP <= 0 && j < 100) {
              enemy = (int) (Math.random() * team2.length);
              j++;
            }
            if (team2[enemy].HP > 0) {
              team1[i].attack(team2[enemy], team1[friend]);
              switch (((Wizard) team1[i]).weapon) {
                case 1:
                  System.out.println(
                      team1[i].name
                          + " 攻击\t "
                          + team2[enemy].name
                          + " 造成了：\t"
                          + team1[i].DPS
                          + "伤害 剩余血量："
                          + team2[enemy].HP
                          + "。  对队友施加强治疗法术:"
                          + team1[friend].name
                          + " HP增加"
                          + team1[i].DPS / 2);
                  break;
                case 2:
                  System.out.println(
                      team1[i].name
                          + " 攻击\t "
                          + team2[enemy].name
                          + " 造成了：\t"
                          + team1[i].DPS
                          + "伤害 剩余血量："
                          + team2[enemy].HP
                          + "。  对队友施加强治疗法术:"
                          + team1[friend].name
                          + " HP增加"
                          + team1[i].DPS / 3);
                  break;
                case 3:
                  System.out.println(
                      team1[i].name
                          + " 攻击\t "
                          + team2[enemy].name
                          + " 造成了：\t"
                          + team1[i].DPS
                          + "伤害 剩余血量："
                          + team2[enemy].HP
                          + "  对敌人施加强迟钝法术:"
                          + team2[enemy].name
                          + " 伤害减少：3");
                  break;
                case 4:
                  System.out.println(
                      team1[i].name
                          + " 攻击\t "
                          + team2[enemy].name
                          + " 造成了：\t"
                          + team1[i].DPS
                          + "伤害 剩余血量："
                          + team2[enemy].HP
                          + "  对敌人施加强迟钝法术:"
                          + team2[enemy].name
                          + " 伤害减少：2");
                  break;
              }
              if (team2[enemy].HP <= 0) {

                System.out.println("   *" + team1[i].name + "成功击杀，等级加1，伤害加5，血量增加20HP");
              }
            }
          }
        } else {
          break;
        }
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    //
    Role[] team1 = {
      new Wizard("盗贼猎艳王", "战士"),
      new Wizard("骑士的挽歌", "战士"),
      new Wizard("法师花祈梦", "法师"),
      new Wizard("法师FLosAngel", "法师"),
      new Wizard("傻妞", "法师"),
      new Wizard("盗贼王", "战士"),
      new Wizard("大青山", "战士"),
      new Wizard("唐神", "法师"),
      new Wizard("八戒", "战士"),
      new Wizard("池傲天", "战士"),
      new Wizard("龙天", "战士"),
      new Wizard("星期天", "战士")
    };
    Role[] team2 =
        new Role[] {
          new Warrior("伊利丹", "战士"),
          new Warrior("阿尔萨斯", "战士"),
          new Warrior("吉安娜", "法师"),
          new Warrior("古尔丹", "法师"),
          new Warrior("脑残吼", "战士"),
          new Warrior("耶路撒冷", "战士"),
          new Warrior("萨鲁法尔", "战士"),
          new Warrior("希尔瓦娜斯", "战士"),
          new Warrior("安东尼", "法师"),
          new Warrior("泰兰德", "法师"),
          new Warrior("怒风", "战士"),
          new Warrior("梅林", "法师"),
          new Warrior("特里斯", "战士"),
          new Warrior("希里", "战士")
        };

    // TODO: 2022/4/25
    System.out.println("战队一*******");
    for (int i = 0; i < team1.length; i++) {
      System.out.printf(
          "lv%d%s\t 职业%s 武器%s\t 血量%d 伤害%d \n",
          team1[i].level,
          team1[i].name,
          team1[i].career,
          team1[i].getWeaponLevel(),
          team1[i].HP,
          team1[i].DPS);
    }

    System.out.println("战队二*******");
    for (int i = 0; i < team2.length; i++) {
      System.out.printf(
          "lv%d%s\t 职业%s 武器%s\t 血量%d 伤害%d \n",
          team2[i].level,
          team2[i].name,
          team2[i].career,
          team2[i].getWeaponLevel(),
          team2[i].HP,
          team2[i].DPS);
    }
    // Thread.sleep(1000);
    int turn = 1;
    for (; ; ) {

      System.out.printf("第%d回合\n", turn);
      // Thread.sleep(1000);
      turn++;
      System.out.println("一队进攻");
      // Thread.sleep(1000);
      attackTeam(team1, team2);
      // Thread.sleep(1000);
      System.out.println();
      System.out.println("二队进攻");
      // Thread.sleep(1000);
      attackTeam(team2, team1);
      // Thread.sleep(1000);
      System.out.println("流血判定.....健康人员+2HP");
      // Thread.sleep(1000);
      bloodJudge(team1, team2);
      bloodJudge(team2, team1);
      // Thread.sleep(1000);
      team1 = cutRole(team1);
      team2 = cutRole(team2);
      showHP(team1, team2);
      // Thread.sleep(1000);
      System.out.println(
          "*****************************************************************************************");
      System.out.println();
      System.out.println();
      if (team1.length > 0 && team2.length == 0) {
        System.out.println("一队胜利");
        break;
      } else if (team1.length == 0 && team2.length > 0) {
        System.out.println("二队胜利");
        break;
      }
    }
  }
}
