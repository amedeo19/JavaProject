package model.board;


import java.util.Random;

public abstract class AbstractObject implements UdStrategy {
	
	protected final int tableHeight;
	protected final int tableWidth;

	private Random random = new Random();


	public AbstractObject(int tableHeight,int tableWidth) {
		this.tableHeight=tableHeight;
		this.tableWidth=tableWidth;
	}
	

	protected int randNum(int min, int max) {
	    return (this.random.nextInt((max - min)) + min);
	}

	protected int getHeight(){
		return this.tableHeight;
	}
	
	protected int getWidth(){
		return this.tableWidth;
	}
	
	@Override
	public abstract UpsideDown getObject();
	

}
