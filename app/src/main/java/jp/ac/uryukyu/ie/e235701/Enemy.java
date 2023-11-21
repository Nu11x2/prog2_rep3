package jp.ac.uryukyu.ie.e235701;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        if(dead == false){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getName(), damage);
            hero.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }
    
    /**
     * nameフィールドのセッターメソッド。
     * @param _name
     */
    public void setName(String _name){
        this.name = _name;
    }

    /**
     * hitPointフィールドのセッターメソッド。
     * @param _hitPoint
     */
    public void setHitPoint(int _hitPoint){
        this.hitPoint = _hitPoint;
    }

    /**
     * attackフィールドのセッターメソッド。
     * @param _attack
     */
    public void setAttack(int _attack){
        this.attack = _attack;
    }

    /**
     * deadフィールドのセッターメソッド。
     * @param _dead
     */
    public void setDead(boolean _dead){
        this.dead = _dead;
    }
    
    /**
     * nameフィールドのゲッターメソッド。
     * @return this.name
     */
    public String getName(){
        return this.name;
    }

    /**
     * hitPointフィールドのゲッターメソッド。
     * @return this.hitPoint
     */
    public int getHitPoint(){
        return this.hitPoint;
    }

    /**
     *attackフィールドのゲッターメソッド。
     * @return this.attack
     */
    public int getAttack(){
        return this.attack;
    }

    /**
     * deadフィールドのゲッターメソッド。
     * @return this.dead
     */
    public boolean getDead(){
        return this.dead;
    }

}