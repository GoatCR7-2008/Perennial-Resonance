package io.github.some_example_name.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.some_example_name.Main;

public class IntroScreen implements Screen {
    private final Main game;
    private SpriteBatch batch;
    private BitmapFont font;
    private float timer = 0;

    private String[] lines = {
        "Há cem anos...",
        "Um novo Lorde Demônio e um novo Grande Herói voltam a nascer.",
        "Não importa quem sejam.",
        "Não importa o que desejem.",
        "Eles herdarão o destino daqueles que vieram antes.",
        "O Lorde Demônio buscará o poder de seus antecessores.",
        "O Grande Herói partirá em busca da Espada Sagrada na distante ilha dos elfos.",
        "E, ao fim de tudo...",
        "O mundo mergulhará novamente no mesmo ciclo interminável de guerra."
    };

    public IntroScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        timer += delta;

        if (timer >= 15f) {
            game.setScreen(new MenuScreen(game));
        }

        ScreenUtils.clear(0, 0, 0, 1);

        batch.begin();
        for (int i = 0; i < lines.length; i++) {
            float apareceEm = i * 1.5f;
            if (timer >= apareceEm) {
                float y = 400 - (i * 30);
                font.draw(batch, lines[i], 100, y);
            }
        }
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
