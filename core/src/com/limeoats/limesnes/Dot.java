/*
 * Dot.java
 * By: Mark Guerra 
 * Date: 3/9/2017
 */

package com.limeoats.limesnes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Dot {
    private Sprite _sprite;
    private boolean _visible;

    public Dot(Vector2 position, Vector2 scale) {
        _sprite = new Sprite(new Texture("dot.png"));
        _sprite.setPosition(position.x, position.y);
        _sprite.setScale(scale.x, scale.y);
        _visible = false;
    }

    public void setProperties(Vector2 pos, Vector2 scale) {
        _sprite.setPosition(pos.x, pos.y);
        _sprite.setScale(scale.x, scale.y);
    }

    public Sprite getSprite() { return _sprite; }
    public boolean isVisible() { return _visible; }
    public void setVisible(boolean visible) { _visible = visible; }
}
