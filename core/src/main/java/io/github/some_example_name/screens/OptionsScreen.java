package io.github.some_example_name.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.some_example_name.Settings;
import io.github.some_example_name.Main;

public class OptionsScreen implements Screen {
    private final Main game;
    private  SpriteBatch batch;
    private  BitmapFont font;

    public OptionsScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show(){
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        if (Gdx.input.isTouched()) {
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();


            if (touchX > 250 && touchX < 280 && touchY > 390 && touchY < 410) {
                Settings.volume = Math.min(1.0f, Settings.volume + 0.1f);
            }

            if (touchX > 300 && touchX < 330 && touchY > 390 && touchY < 410) {
                Settings.volume = Math.max(0.0f, Settings.volume - 0.1f);
            }

            if (touchX > 100 && touchX < 200 && touchY > 300 && touchY < 320) {
                game.setScreen(new MenuScreen(game));
            }
        }

        batch.begin();
        font.draw(batch, "Opções", 100, 500);
        font.draw(batch, "Volume: " + (int) (Settings.volume * 100) + "%", 100, 400);
        font.draw(batch, "[ - ]", 300, 400);
        font.draw(batch, "[ + ]", 250, 400);
        font.draw(batch, "Voltar", 100, 310);
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
