package RPGgame;

public class Warrior extends Role implements Knife, Sword {
  public int weapon = 0;

  public String getWeaponLevel() {
    return weaponLevel;
  }

  private String weaponLevel;

  public Warrior(String name, String career) {
    super(name, career);
    this.HP += 50;
    weapon();
  }

  @Override
  public void weapon() {
    int choose = (int) (Math.random() * 2);
    if (choose < 1) {
      knife();
    } else {
      sword();
    }
  }

  @Override
  public void knife() {
    int choose = (int) (Math.random() * 2);
    if (choose < 1) {
      knifeHighBuff();
    } else {
      knifeLowBuff();
    }
  }

  @Override
  public void knifeHighBuff() {
    weaponLevel = "上级刀";
    this.DPS += 10;
    // 高吸血
    weapon = 1;
  }

  @Override
  public void knifeLowBuff() {
    weaponLevel = "下级刀";
    this.DPS += 5;
    // 低吸血
    weapon = 2;
  }

  @Override
  public void sword() {
    int choose = (int) (Math.random() * 2);
    if (choose < 1) {
      swordHighBuff();
    } else {
      swordLowBuff();
    }
  }

  @Override
  public void swordHighBuff() {
    weaponLevel = "上级剑";
    this.DPS += 10;
    // 高流血
    weapon = 3;
  }

  @Override
  public void swordLowBuff() {
    weaponLevel = "下级剑";
    this.DPS += 5;
    // 低流血
    weapon = 4;
  }

  public void attack(Role sb) {
    sb.HP -= this.DPS;
    switch (weapon) {
      case 1:
        this.HP += this.DPS / 2;
        break;
      case 2:
        this.HP += this.DPS / 3;
        break;
      case 3:
        sb.blood = HIGHLOSTBLOOD;
        break;
      case 4:
        sb.blood = LOSTBLOOD;
    }
    if (sb.HP <= 0) {
      this.level += 1;
      this.HP += 20;
      this.DPS += 5;
    }
  }

  @Override
  protected void attack(Role sb, Role mates) {}
}
