package com.sprite;

import javax.swing.ImageIcon;

import com.main.Commons;

public class Ball extends Sprite {

	private int xDir;
	private int yDir;
	private int speedMultiplier = 1;

	@Override
	protected void loadImage() {
		ImageIcon ii = new ImageIcon("Resource/Sprites/ball.png");
		image = ii.getImage();
	}

	private void resetState() {
		x = Commons.INIT_BALL_X;
		y = Commons.INIT_BALL_Y;
	}

	public void setXDir(int x) {
		xDir = x;
	}

	public void setYDir(int y) {
		yDir = y;
	}

	public int getYDir() {
		return yDir;
	}

	public void setSpeedMultiplier(int speedMultiplier) {
		this.speedMultiplier = speedMultiplier;
	}

	public Ball() {
		super();
		xDir = 0;
		yDir = 1;

		resetState();
	}

	public void move() {
		x += xDir * speedMultiplier;
		y += yDir * speedMultiplier;

		if (x == 0) {
			setXDir(1);
		} else if (x == Commons.WIDTH - (getImageWidth() * speedMultiplier)) {
			setXDir(-1);
		}
		if (y == getImageHeight()) {
			setYDir(1);
		}
	}
	
	public void moveNorth() {
		yDir = Math.abs(yDir) * -1;
    }
    public void moveSouth() {
    	yDir = Math.abs(yDir);
    }
    public void moveWest() {
    	xDir = Math.abs(xDir) * -1;
    }
    public void moveEast() {
    	xDir = Math.abs(xDir);
    }
}