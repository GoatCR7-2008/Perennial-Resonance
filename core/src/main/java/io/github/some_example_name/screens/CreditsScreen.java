package io.github.some_example_name.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.some_example_name.Main;

public class CreditsScreen implements Screen {
    private SpriteBatch batch;
    private BitmapFont font;
    private final Main game;

    public CreditsScreen(final Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new MenuScreen(game));
        }

        ScreenUtils.clear(0.1f,0.1f,0.1f,0.1f);

        batch.begin();
        font.draw(batch, "CREDITOS", 350, 450);
        font.draw(batch, "Arte 2D: [Nome do pack/ autor]", 100, 400);
        font.draw(batch, "Licença: [tipo de licença]", 100, 380);

        font.draw(batch, "Aperte ESC para voltar", 300, 100);
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
