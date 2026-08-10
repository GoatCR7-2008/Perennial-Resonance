package io.github.some_example_name.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.some_example_name.Main;

public class MenuScreen implements Screen {
    private SpriteBatch batch;
    private BitmapFont font;
    private final Main game;

    public MenuScreen(Main game) {
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

            if (touchX > 100 && touchX < 300 && touchY > 390 && touchY < 410) {
                game.setScreen(new IntroScreen(game));
            }
            if (touchX > 100 && touchX < 200 && touchY > 340 && touchY < 360){}

            if (touchX > 100 && touchX < 150 && touchY > 290 && touchY < 310){
                Gdx.app.exit();
            }

            if (touchX > 100 && touchX < 200 && touchY > 340 && touchY < 360){
                game.setScreen(new OptionsScreen(game));
            }

        }

        batch.begin();
        font.draw(batch, "Perennial Resonance", 100, 500);
        font.draw(batch, "Começar Novo Jogo", 100, 400);
        font.draw(batch, "Continuar", 100, 400);
        font.draw(batch, "Opções", 100, 400);
        font.draw(batch, "Sair", 100, 300);
        batch.end();
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();

    }
}
