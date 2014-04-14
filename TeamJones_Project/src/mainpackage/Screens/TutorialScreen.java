package mainpackage.Screens;

import org.lwjgl.input.Keyboard;

import mainpackage.Game;
import mainpackage.PlayerInput;
import mainpackage.SoundFiles;
import mainpackage.TextureFiles;
import mainpackage.UserConfig;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TutorialScreen implements Screen {
	private Game game;
	private Stage stage;
	public Music openingMusic;
	private TextureAtlas atlas;
	private Skin skin;
	private SpriteBatch batch;
	private Texture splashTexture, tuTexture, leftTexture, rightTexture,
			exitTexture;
	private SoundFiles soundFiles;
	private float bgmVolume, sfxVolume;
	private BitmapFont gameFont;
	private String name;
	private int menuCount = 0;

	// constructor to keep a reference to the main Game class
	public TutorialScreen(Game game) {
		this.game = game;
		bgmVolume = UserConfig.getBGMVolume(false);
		sfxVolume = UserConfig.getSFXVolume(false);
		openingMusic = Gdx.audio.newMusic(Gdx.files
				.internal("assets/audioFiles/menuSounds/mainMenuMusic.mp3"));
		openingMusic.setVolume(bgmVolume);
		openingMusic.setLooping(true);
	}

	// called when the screen should render itself.
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		// draw objects into the screen
		batch.begin();
		// draw background texture
		batch.draw(splashTexture, 0, 0, 800, 600, 0, 0,
				splashTexture.getWidth(), splashTexture.getHeight(), false,
				false);

		// draw tutorial screen texture
		batch.draw(tuTexture, 50, 50, 700, 510, 0, 0, tuTexture.getWidth(),
				tuTexture.getHeight(), false, false);

		// draw left arrow texture
		batch.draw(leftTexture, 0, 270, 50, 45, 0, 0, leftTexture.getWidth(),
				leftTexture.getHeight(), false, false);

		// draw right arrow texture
		batch.draw(rightTexture, 750, 270, 50, 45, 0, 0,
				rightTexture.getWidth(), rightTexture.getHeight(), false, false);

		// draw exit button texture
		batch.draw(exitTexture, 330, 9, 100, 30, 0, 0, exitTexture.getWidth(),
				exitTexture.getHeight(), false, false);

		// set the text to center of the screen
		TextBounds bounds = gameFont.getBounds(name);
		gameFont.draw(batch, String.valueOf(name), Gdx.graphics.getWidth() / 2
				- bounds.width / 2, 585);

		batch.end();

		// this will enable the continuous key press
		Keyboard.enableRepeatEvents(false);
	}

	// called when the screen resized
	public void resize(int width, int height) {

	}

	// called when this screen becomes the current screen for a Game.
	public void show() {
		PlayerInput playerInput = new PlayerInput(game);
		Gdx.input.setInputProcessor(playerInput);

		// set the background image to the menu screen
		splashTexture = TextureFiles.getBackgroundTexture("tutorialScreen");
		tuTexture = TextureFiles.getTutorialTexture("characterSelection");
		leftTexture = TextureFiles.getUtilityTexture("leftArrow");
		rightTexture = TextureFiles.getUtilityTexture("rightArrow");
		exitTexture = TextureFiles.getUtilityTexture("exit");
		batch = new SpriteBatch();
		atlas = new TextureAtlas("assets/gui/button.pack");
		skin = new Skin();
		skin.addRegions(atlas);

		// load the new font
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal("assets/gui/gamefonts.ttf"));

		name = "Character Selection";
		// set the size of the digital font
		gameFont = generator.generateFont(30);

		// plays background music for menus
		if (openingMusic.isPlaying() == false) {
			openingMusic.play();
		}
	}

	// called when current screen changes from this to a different screen
	public void hide() {

	}

	// called when game paused.
	public void pause() {

	}

	// called when game resume
	public void resume() {

	}

	// called when this screen should release all resources.
	public void dispose() {
		batch.dispose();
		skin.dispose();
		atlas.dispose();
	}

	// method to return the key selection
	public void keyDown(int keycode) {
		soundFiles = new SoundFiles();
		if (keycode == Keys.RIGHT) {
			if (menuCount < 0 || menuCount > 3)
				return;
			
			if (menuCount < 3)
				menuCount++;		
			// dispose the current instance
			tuTexture.dispose();
			switch (menuCount) {
			case 0: {
				// load the new texture
				tuTexture = TextureFiles
						.getTutorialTexture("characterSelection");
				// change the text
				name = "Character Selection";
				break;
			}
			case 1: {
				// load the new texture
				tuTexture = TextureFiles.getTutorialTexture("health");
				// change the text
				name = "Health Tutorial";
				break;
			}
			case 2: {
				// load the new texture
				tuTexture = TextureFiles.getTutorialTexture("movement");
				// change the text
				name = "Movement Tutorial";
				break;
			}
			case 3: {
				// load the new texture
				tuTexture = TextureFiles.getTutorialTexture("action");
				// change the text
				name = "Action Tutorial";
				break;
			}
			}
			soundFiles.playSound("menuTraverse", sfxVolume);
			return;
		}
		if (keycode == Keys.LEFT) {
			if (menuCount < 0 || menuCount > 3)
				return;
			
			if (menuCount > 0)
			menuCount--;			
			// dispose the current instance
			tuTexture.dispose();
			switch (menuCount) {
			case 0: {
				// load the new texture
				tuTexture = TextureFiles
						.getTutorialTexture("characterSelection");
				// change the text
				name = "Character Selection";
				break;
			}
			case 1: {
				// load the new texture
				tuTexture = TextureFiles.getTutorialTexture("health");
				// change the text
				name = "Health Tutorial";
				break;
			}
			case 2: {
				// load the new texture
				tuTexture = TextureFiles.getTutorialTexture("movement");
				// change the text
				name = "Movement Tutorial";
				break;
			}
			case 3: {
				// load the new texture
				tuTexture = TextureFiles.getTutorialTexture("action");
				// change the text
				name = "Action Tutorial";
				break;
			}
			}
			soundFiles.playSound("menuTraverse", sfxVolume);
			return;
		}

		if (keycode == Keys.ENTER) {
			game.setScreen(new MenuScreen(game));
			soundFiles.playSound("menuSelect", sfxVolume);
			openingMusic.stop();
			return;
		}
	}
}
