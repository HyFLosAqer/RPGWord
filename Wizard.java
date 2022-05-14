package RPGgame;

public class Wizard extends Role implements Orbs, Staff {
  public Wizard(String name, String career) {
    super(name, career);
    super.DPS += 5;
    super.HP -= 50;
    weapon();
  }

  @Override
  protected void attack(Role sb) {}

  int weapon = 0;

  public String getWeaponLevel() {
    return weaponLevel;
  }

  private String weaponLevel;

  @Override
  public void orbs() {

    int choose = (int) (Math.random() * 2);
    if (choose < 1) {
      orbsHighBuff();
    } else {
      orbsLowBuff();
    }
  }

  @Override
  public void orbsHighBuff() {
    this.DPS += 10;
    weapon = 1;
    weaponLevel = "上级法球";
    // 队友加血  DPS
  }

  @Override
  public void orbsLowBuff() {
    this.DPS += 10;
    weapon = 2;
    weaponLevel = "下级法球";
    // 队友加血 DPS /2
  }

  @Override
  public void staff() {
    int choose = (int) (Math.random() * 2);
    if (choose < 1) {
      staffHighBuff();
    } else {
      staffLowBuff();
    }
  }

  @Override
  public void staffHighBuff() {
    this.DPS += 10;
    weapon = 3;
    weaponLevel = "上级法杖";
  }

  @Override
  public void staffLowBuff() {
    this.DPS += 10;
    weapon = 4;
    weaponLevel = "下级法杖";
  }

  @Override
  public void weapon() {
    int choose = (int) (Math.random() * 2);
    if (choose < 1) {
      staff();
    } else {
      orbs();
    }
  }

  public void attack(Role sb, Role mates) {
    sb.HP -= this.DPS;
    switch (weapon) {
      case 1:
        mates.HP += this.DPS / 2;
        break;
      case 2:
        this.HP += mates.DPS / 3;
        break;
      case 3:
        sb.DPS -= 3;
        break;
      case 4:
        sb.DPS -= 2;
    }
    if (sb.HP <= 0) {
      this.level += 1;
      this.HP += 20;
      this.DPS += 5;
    }
  }
}
