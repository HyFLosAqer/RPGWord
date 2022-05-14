package RPGgame;

public abstract class Role {
  protected String name;
  protected String career;
  protected int HP;
  protected int level;
  protected int DPS;
  public static final int LOSTBLOOD = 0;
  public static final int HIGHLOSTBLOOD = 1;
  public static final int NOMAL = 2;
  protected int blood = NOMAL;

  public Role(String name, String career) {
    this.name = name;
    this.career = career;
    this.HP = 200;
    this.level = 1;
    this.DPS = 10;
  }
  // 流血判断
  protected void blood(Role sb) {
    if (blood == NOMAL) {
      if (this.HP < 99) {
        this.HP += 2;
      }
    } else if (blood == LOSTBLOOD) {
      this.HP -= 2;
    } else if (blood == HIGHLOSTBLOOD) {
      this.HP -= 6;
    }
    if (this.HP <= 0) {
      sb.HP += 30;
      sb.level += 1;
      sb.DPS += 5;
    }
  }

  public String getWeaponLevel() {
    return "1";
  }
  ;

  protected abstract void attack(Role sb);

  protected abstract void attack(Role sb, Role mates);
}
