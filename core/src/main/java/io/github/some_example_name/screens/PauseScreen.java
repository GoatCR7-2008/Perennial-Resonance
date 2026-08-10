package io.github.some_example_name.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.some_example_name.Main;

public class PauseScreen implements Screen {
    private SpriteBatch batch;
    private BitmapFont font;
    private final Main game;
    private float playerX;
    private float playerY;



    public PauseScreen(Main game, float playerX, float playerY) {
        this.game = game;
        this.playerX = playerX;
        this.playerY = playerY;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }



    @Override
    public void render(float delta) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new GameScreen(game, playerX, playerY));
        }

        ScreenUtils.clear(0f, 0f, 0f, 1f);

        batch.begin();
        font.draw(batch, "JOGO PAUSADO", 350, 400);
        font.draw(batch, "Aparete ESC para continuar", 300, 370);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }


}
