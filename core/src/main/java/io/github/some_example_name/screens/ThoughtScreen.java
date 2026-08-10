package io.github.some_example_name.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.some_example_name.Main;

public class ThoughtScreen implements Screen {
    private final Main game;
    private SpriteBatch batch;
    private BitmapFont font;
    private float timer = 0;

    private String[] lines = {
        "Sempre que penso nessa situação, fico cada vez mais desanimado.",
        "Será que sou o único que sente que esse ciclo nunca deveria ter existido?",
        "Eu só queria viver em paz no interior, ao lado da minha família e dos meus amigos.",
        "Ouvi dizer que até mesmo o atual Rei Demônio desejava uma mudança.",
        "Dizem que ele nunca quis iniciar outra guerra e que enfrentou grande resistência dos demônios mais conservadores.",
        "Ainda assim, conseguiu fazer alguns deles acreditarem que um futuro diferente era possível.",
        "Infelizmente, no Reino dos Humanos, as coisas parecem ainda mais difíceis.",
        "O Alto Conselho permanece preso às mesmas ideias há incontáveis gerações.",
        "Eles nunca deram ouvidos nem mesmo aos antigos Grandes Heróis, aqueles que carregaram as mesmas raízes que hoje descansam em mim.",
        "Se ignoraram aqueles que salvaram este reino tantas vezes, por que escutariam pessoas comuns que sonham com um mundo diferente?",
        "Existem aqueles que acreditam que humanos e demônios não precisam viver separados pelo medo ou pelo ódio, mas essas vozes são rapidamente silenciadas.",
        "Qualquer pensamento que desafie as antigas tradições é tratado como uma ameaça.",
        "Mesmo assim... eu não consigo aceitar que esse seja o único caminho.",
        "Se o Rei Demônio realmente deseja acabar com essa guerra tanto quanto dizem, então talvez ainda exista esperança.",
        "Talvez alguém consiga romper esse ciclo que aprisiona os dois lados há tantos séculos."

    };

    public ThoughtScreen(Main game) {
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
            game.setScreen(new GameScreen(game));
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

