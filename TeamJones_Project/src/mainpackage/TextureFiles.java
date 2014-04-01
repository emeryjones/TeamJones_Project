package mainpackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class TextureFiles {

	// get the selected character textures
	public static Texture getCharacterTexture(String strCharacter) {
		Texture chTexture = null;
		switch (strCharacter) {
		case "ichigo": {
			chTexture = new Texture(
					Gdx.files.internal("assets/sprites/backgrounds/ichigo.png"));
			break;
		}

		case "byakuya": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/byakuya.png"));
			break;
		}

		case "ikkaku": {
			chTexture = new Texture(
					Gdx.files.internal("assets/sprites/backgrounds/ikkaku.png"));
			break;
		}

		case "ishida": {
			chTexture = new Texture(
					Gdx.files.internal("assets/sprites/backgrounds/ishida.png"));
			break;
		}

		case "kenpachi": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/kenpachi.png"));
			break;
		}

		case "urahara": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/urahara.png"));
			break;
		}

		case "komamura": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/komamura.png"));
			break;
		}

		case "mayuri": {
			chTexture = new Texture(
					Gdx.files.internal("assets/sprites/backgrounds/mayuri.png"));
			break;
		}

		case "renji": {
			chTexture = new Texture(
					Gdx.files.internal("assets/sprites/backgrounds/renji.png"));
			break;
		}
		}
		return chTexture;
	}

	// get the character selection textures
	public static Texture getCharacterSelectionTexture(String strCharacter) {
		Texture chTexture = null;
		switch (strCharacter) {
		case "ichigo": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/chIchigo.png"));
			break;
		}

		case "byakuya": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/chByakuya.png"));
			break;
		}

		case "ikkaku": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/chIkkaku.png"));
			break;
		}

		case "ishida": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/chIshida.png"));
			break;
		}

		case "kenpachi": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/chKenpachi.png"));
			break;
		}

		case "urahara": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/chUrahara.png"));
			break;
		}

		case "komamura": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/chKomamura.png"));
			break;
		}

		case "mayuri": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/chMayuri.png"));
			break;
		}

		case "renji": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/chRenji.png"));
			break;
		}
		}
		return chTexture;
	}

	// get the background texture
	public static Texture getBackgroundTexture(String strTexture) {
		Texture chTexture = null;
		switch (strTexture) {
		case "characterSelection": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/character_bg.png"));
			break;
		}

		case "menuScreen": {
			chTexture = new Texture(
					Gdx.files.internal("assets/gui/mainMenuBG.png"));
			break;
		}

		case "optionScreen": {
			chTexture = new Texture(
					Gdx.files.internal("assets/gui/optionsMenuBG.png"));
			break;
		}
		case "gameScreen": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/battle_BG_01.png"));
			break;
		}
		}
		return chTexture;
	}

	// get the utility texture
	public static Texture geUtilityTexture(String strTexture) {
		Texture chTexture = null;
		switch (strTexture) {
		case "player1": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/gui/P1.png"));
			break;
		}

		case "player2": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/gui/P2.png"));
			break;
		}

		case "ready": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/sprites/backgrounds/ready.png"));
			break;
		}
		case "cursor": {
			chTexture = new Texture(
					Gdx.files
							.internal("assets/gui/selectorTex.png"));
			break;
		}
		}
		return chTexture;
	}
}