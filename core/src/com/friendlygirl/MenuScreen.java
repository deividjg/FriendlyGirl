package com.friendlygirl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MenuScreen extends BaseScreen {

    private Stage stage;
    private Image image;
    private Skin skin;
    private TextButton comenzar, puntuaciones, salir;
    private Music menumusic;

    public MenuScreen(final MainGame game) {
        super(game);

        stage = new Stage(new FitViewport(640, 360));
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        image = new Image(game.getManager().get("logo.png", Texture.class));
        comenzar = new TextButton("Comenzar", skin);
        puntuaciones = new TextButton("Puntuaciones", skin);
        salir = new TextButton("Salir", skin);
        comenzar.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.gameScreen);
            }
        });
        puntuaciones.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.maxPuntuaciones);
            }
        });
        salir.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        image.setPosition(320 - image.getWidth()/2, 120);
        comenzar.setSize(150, 70);
        puntuaciones.setSize(150, 70);
        salir.setSize(150, 70);
        comenzar.setPosition(50, 20);
        puntuaciones.setPosition(250, 20);
        salir.setPosition(450, 20);

        stage.addActor(image);
        stage.addActor(comenzar);
        stage.addActor(puntuaciones);
        stage.addActor(salir);

        menumusic = game.getManager().get("audio/menumusic.ogg");
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        menumusic.setLooping(true);
        menumusic.play();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
        menumusic.stop();
    }

    @Override
    public void dispose() {
        stage.dispose();
        menumusic.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}