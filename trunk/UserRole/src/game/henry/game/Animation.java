package game.henry.game;

/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
public class Animation implements TimeUpdate {
	
	private AnimFrame[] frameArray = new AnimFrame[0];
	private int currFrameIndex;
	private long animTime;
	private long totalDuration = 0;
	private boolean loop = true;
	private boolean stop = true;

	public Animation() {
	}

	public void addFrame(int locationImageNum, long duration) {
		totalDuration += duration;
		AnimFrame animFrame = new AnimFrame(locationImageNum, totalDuration);
		AnimFrame[] newFrameArray = new AnimFrame[frameArray.length + 1];
		System.arraycopy(frameArray, 0, newFrameArray, 0, frameArray.length);
		newFrameArray[frameArray.length] = animFrame;
		frameArray = newFrameArray;
	}

	public void addFrame(int locationImageNum) {
		addFrame(locationImageNum, 0);
	}

	public void play() {
		animTime = 0;
		stop = false;
		currFrameIndex = 0;
	}

	public void pause() {
		stop = true;
	}

	public void update(long elapsedTime) {
		if (elapsedTime == 0) {
			return;
		}
		if (frameArray.length > 1) {
			animTime += elapsedTime;
			if (stop) {
				return;
			}
			if (animTime >= totalDuration) {
				if (!loop) {
					stop = true;
					return;
				}
				animTime = animTime % totalDuration;
				currFrameIndex = 0;
			}
			while (animTime > frameArray[currFrameIndex].endTime) {
				currFrameIndex++;
			}
		}
	}

	public int getCurrentFrameNum() {
		return frameArray[currFrameIndex].frameNumber;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public void reset() {
		animTime = 0;
	}

	public boolean isStop() {
		return stop;
	}

	private class AnimFrame {
		int frameNumber;
		long endTime;

		public AnimFrame(int frameNumber, long endTime) {
			this.frameNumber = frameNumber;
			this.endTime = endTime;
		}
	}
}
