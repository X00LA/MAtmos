package eu.ha3.matmos.game.gui.editor;

import eu.ha3.matmos.game.gui.editor.condition.ConditionEditorDiv;
import eu.ha3.matmos.game.gui.editor.condition.ConditionListDiv;
import eu.ha3.matmos.game.gui.editor.div.ScreenDiv;

/**
 * @author dags_ <dags@dags.me>
 */

public class Screens
{
    public static ScreenDiv buildConditionsScreen(int displayWidth, int displayHeight)
    {
        ScreenDiv screen = new ScreenDiv(displayWidth, displayHeight);

        ConditionEditorDiv editor = new ConditionEditorDiv(0.72F, 0.99F, 0.27F, 0.005F);
        ConditionListDiv list = new ConditionListDiv(editor, 0.25F, 0.99F, 0.01F, 0.005F);

        editor.background(0xCC777777).border(0xFFFFFFFF);
        list.background(0xCC777777).border(0xFFFFFFFF);

        screen.background(0xCC222222);
        screen.addChild(list, editor);

        return screen;
    }
}