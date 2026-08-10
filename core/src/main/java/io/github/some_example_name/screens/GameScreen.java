package io.github.some_example_name.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.some_example_name.Main;

public class GameScreen implements Screen {
    private final Main game;
    private SpriteBatch batch;
    private BitmapFont font;
    private String teclaAtual;
    private String ultimaAcao;
    private float playerX = 400;
    private float playerY = 300;
    private  float playerSpeed = 200;

    public GameScreen(Main game) {
        this.game = game;
        this.playerX = 400;
        this.playerY = 300;
    }

    public  GameScreen(Main game, float playerX, float playerY) {
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

        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            teclaAtual = "Cima";
            playerY += playerSpeed * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            teclaAtual = "Baixo";
            playerY -= playerSpeed * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            teclaAtual = "Esquerda";
            playerX -= playerSpeed * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            teclaAtual = "Direita";
            playerX += playerSpeed * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.F)) {
            teclaAtual = "Pegou item";
        }

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new PauseScreen(game, playerX, playerY));
        }

        ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1f);

        batch.begin();
        font.draw(batch, "Movimento: " + teclaAtual, 100, 400);
        font.draw(batch, "Ultima ação: " + ultimaAcao, 100, 370);
        font.draw(batch, "Posição: " + (int)playerX + ", " +  (int)playerY, 100, 340);
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
