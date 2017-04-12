package game.models.characters;

import game.models.animations.CharacterAnimation;
import javafx.animation.Animation;

public abstract class Character {

    private float x;
    private float y;

    private int health;
    private int mana;

    private Animation currentAnimation;
    private Animation prevAnimation;

    private CharacterAnimation moveAnimation;
    private CharacterAnimation attackAnimation;

    protected Character() {

    }

}
