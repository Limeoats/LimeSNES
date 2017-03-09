package com.limeoats.limesnes;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class LimeSNES extends ApplicationAdapter {

	private enum ControllerMapping {
		X(0), A(1), B(2), Y(3), L(4), R(5), Select(6), Start(7), DpadRight(8), DpadDown(9), DpadLeft(10), DpadUp(11);
		private final int _value;
		private ControllerMapping(int value) { this._value = value; }
		public int getValue() { return this._value; }
	}

	private SpriteBatch _batch;

	private Texture _controller;
	private List<Dot> _dots = new ArrayList<>();
	
	@Override
	public void create () {
		this._batch = new SpriteBatch();

		this._controller = new Texture("controller.jpg");
		for (int i = 0; i < 12; ++i) {
			this._dots.add(new Dot(new Vector2(0, 0), new Vector2(1.0f, 1.0f)));
		}
		this._dots.get(ControllerMapping.X.getValue()).setProperties(new Vector2(842, 308), new Vector2(0.6f, 0.6f));
		this._dots.get(ControllerMapping.A.getValue()).setProperties(new Vector2(952, 226), new Vector2(0.6f, 0.6f));
		this._dots.get(ControllerMapping.B.getValue()).setProperties(new Vector2(845, 140), new Vector2(0.6f, 0.6f));
		this._dots.get(ControllerMapping.Y.getValue()).setProperties(new Vector2(738, 224), new Vector2(0.6f, 0.6f));
		this._dots.get(ControllerMapping.L.getValue()).setProperties(new Vector2(200, 454), new Vector2(2.0f, 0.3f));
		this._dots.get(ControllerMapping.R.getValue()).setProperties(new Vector2(845, 454), new Vector2(2.0f, 0.3f));
		this._dots.get(ControllerMapping.Select.getValue()).setProperties(new Vector2(410, 200), new Vector2(0.8f, 0.8f));
		this._dots.get(ControllerMapping.Start.getValue()).setProperties(new Vector2(532, 200), new Vector2(0.8f, 0.8f));
		this._dots.get(ControllerMapping.DpadRight.getValue()).setProperties(new Vector2(256, 224), new Vector2(0.4f, 0.4f));
		this._dots.get(ControllerMapping.DpadDown.getValue()).setProperties(new Vector2(197, 160), new Vector2(0.4f, 0.4f));
		this._dots.get(ControllerMapping.DpadLeft.getValue()).setProperties(new Vector2(138, 224), new Vector2(0.4f, 0.4f));
		this._dots.get(ControllerMapping.DpadUp.getValue()).setProperties(new Vector2(197, 288), new Vector2(0.4f, 0.4f));
	}

	private void update() {
		this._dots.get(ControllerMapping.A.getValue()).setVisible(Gdx.input.isKeyPressed(Input.Keys.A));
		this._dots.get(ControllerMapping.B.getValue()).setVisible(Gdx.input.isKeyPressed(Input.Keys.B));
		this._dots.get(ControllerMapping.X.getValue()).setVisible(Gdx.input.isKeyPressed(Input.Keys.X));
		this._dots.get(ControllerMapping.Y.getValue()).setVisible(Gdx.input.isKeyPressed(Input.Keys.Y));
		this._dots.get(ControllerMapping.L.getValue()).setVisible(Gdx.input.isKeyPressed(Input.Keys.L));
		this._dots.get(ControllerMapping.R.getValue()).setVisible(Gdx.input.isKeyPressed(Input.Keys.R));
		this._dots.get(ControllerMapping.Select.getValue()).setVisible(Gdx.input.isKeyPressed(Input.Keys.S));
		this._dots.get(ControllerMapping.Start.getValue()).setVisible(Gdx.input.isKeyPressed(Input.Keys.D));
		this._dots.get(ControllerMapping.DpadRight.getValue()).setVisible(Gdx.input.isKeyPressed(Input.Keys.RIGHT));
		this._dots.get(ControllerMapping.DpadDown.getValue()).setVisible(Gdx.input.isKeyPressed(Input.Keys.DOWN));
		this._dots.get(ControllerMapping.DpadLeft.getValue()).setVisible(Gdx.input.isKeyPressed(Input.Keys.LEFT));
		this._dots.get(ControllerMapping.DpadUp.getValue()).setVisible(Gdx.input.isKeyPressed(Input.Keys.UP));
	}

	private void draw() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this._batch.begin();
		this._batch.draw(this._controller, 0, 0);
		for (Dot d : this._dots) {
			if (d.isVisible()) d.getSprite().draw(this._batch);
		}
		this._batch.end();
	}

	@Override
	public void render () {
		this.update();
		this.draw();
	}
	
	@Override
	public void dispose () {
		this._batch.dispose();
		this._controller.dispose();

	}
}
