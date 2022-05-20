package callbacks;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Game.GamePanel;

public class GameEvent extends KeyAdapter {
	private GamePanel board;
	public GameEvent(GamePanel board)
	{
		this.board=board;
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		this.board.keyReleased(e);
	}
	public void keyPressed(KeyEvent e)
	{
		this.board.keyPressed(e);
	}

}
