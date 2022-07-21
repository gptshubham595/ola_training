package gamepack;

interface FlyAbility {
    void Fly();
}

interface AttackAbility {
    void Attack();
}

class AttackWithHands implements AttackAbility {

    @Override
    public void Attack() {
        System.out.println("I dont need any weapons!");
    }
}

class AttackWithGuns implements AttackAbility {

    @Override
    public void Attack() {
        System.out.println(" Gunners!");
    }
}

abstract class Player {
    FlyAbility flyAbility;
    AttackAbility attackAbility;

    public AttackAbility getAttackAbility() {
        return attackAbility;
    }

    public void setAttackAbility(AttackAbility attackAbility) {
        this.attackAbility = attackAbility;
    }

    public FlyAbility getFlyAbility() {
        return flyAbility;
    }

    public void setFlyAbility(FlyAbility flyAbility) {
        this.flyAbility = flyAbility;
    }

    public void Eat() {
    }

    public void performFLy() {
        flyAbility.Fly();
    }

    public void performAttack() {
        attackAbility.Attack();
    }

    abstract void display();
}

class WithWings implements FlyAbility {

    @Override
    public void Fly() {
        System.out.println("Flying using wings!");
    }
}

class CantFly implements FlyAbility {
    @Override
    public void Fly() {
        System.out.println("I Cannot Fly!");
    }
}

class WithJetPack implements FlyAbility {
    @Override
    public void Fly() {
        System.out.println("JetPacks are awesome!");
    }
}

class Alex extends Player {
    Alex(FlyAbility flyAbility, AttackAbility attackAbility) {
        super.flyAbility = flyAbility;
        super.attackAbility = attackAbility;
    }

    public void display() {
        System.out.println("I am Alex!");
    }
}

class Sam extends Player {
    Sam(FlyAbility flyAbility) {
        super.flyAbility = flyAbility;
    }

    public void display() {
        System.out.println("I am Sam!");
    }
}

public class Demo {
    public static void main(String[] args) {
        Player player = new Alex(new CantFly(),new AttackWithGuns());
        player.display();
        player.performFLy();
        player.performAttack();

        System.out.println("Fuel Over");
        player.setFlyAbility(new CantFly());
        player.display(); // Displays the player name
        player.performFLy();


        Player playerTwo = new Sam(new WithJetPack());
        playerTwo.display();
        playerTwo.performFLy();
    }
}
