package horseGame;

public class VerticalRunStrategy extends RunningStrategy{

	@Override
	public void play(Horse horse) {
		horse.setInterval(0, Horse.INTERVAL);
		
	}


}
