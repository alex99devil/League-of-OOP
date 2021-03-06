package angels;

import characters.Pair;
import characters.Knight;
import characters.MoldCharacter;
import characters.Pyromancer;
import characters.Wizard;
import characters.Rogue;

public class Dracula extends Angel {
    private final  int pyroModifierHp = 40;
    private final  int knightModifierHp = 60;
    private final  int rogueModifierHp = 35;
    private final  int wizardModifierHp = 20;
    private final  float pyroModifier = -0.3f;
    private final  float knightModifier = -0.2f;
    private final  float rogueModifier = -0.1f;
    private final  float wizardModifier = -0.4f;


    public Dracula(final Pair<Integer, Integer> angelCoordonates, final String name) {
        super(angelCoordonates, name);
    }
    /**mesajul care apare cand Dracula ataca un jucator.*/
    public StringBuilder createMessage(final MoldCharacter character) {
        StringBuilder message = new StringBuilder();
        message.append(this.getAngelName());
        message.append(" hit ");
        message.append(character.getClass().getSimpleName());
        message.append(" ");
        message.append(character.getId());
        return message;
    }
    /** */
    @Override
    public void visitBYAngels(final Pyromancer character) {
        if (character.alive()) {
            character.setModifiers(pyroModifier);
            super.notifyAllObservers(createMessage(character));
            character.setHp(character.getHp() - pyroModifierHp);
        }
    }
    /** */
    @Override
    public void visitBYAngels(final Knight character) {
        if (character.alive()) {
            character.setModifiers(knightModifier);
            super.notifyAllObservers(createMessage(character));
            character.setHp(character.getHp() - knightModifierHp);
        }
    }
    /** */
    @Override
    public void visitBYAngels(final Wizard character) {
        if (character.alive()) {
            character.setModifiers(wizardModifier);
            super.notifyAllObservers(createMessage(character));
            character.setHp(character.getHp() - wizardModifierHp);
        }

    }
    /** */
    @Override
    public void visitBYAngels(final Rogue character) {
        if (character.alive()) {
            character.setModifiers(rogueModifier);
            super.notifyAllObservers(createMessage(character));
            character.setHp(character.getHp() - rogueModifierHp);
        }

    }
}
