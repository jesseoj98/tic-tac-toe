package com.jesseoj98.tictactoe.util.helper.validator;

/**
 * Game input validator interface supplies blueprints to validate user or cpu
 * game inputs
 */
public interface GameInputValidator {

	public boolean isValidPlayingCharacter(char input);

	public boolean isYesOrNo(char input);

	public boolean isYes(char input);

	public boolean isValidBoardType(char input);

	public boolean isValidBoardSpace(int input);

	public boolean isValidCoordinatesSpace(int input);

}
