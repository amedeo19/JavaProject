package model.board;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.sun.javafx.scene.control.TableColumnSortTypeWrapper;

public abstract class AbsrtactObject implements UdStrategy {
	
	protected final int tableHeight;
	protected final int tableWidth;
	
	public final List<Coordinate> tableLiStart  = new LinkedList<>();
	public final List<Coordinate> tableLiStop = new LinkedList<>();
	Random random = new Random();


	public AbsrtactObject(int tableHeight,int tableWidth) {
		this.tableHeight=tableHeight;
		this.tableWidth=tableWidth;
	}
	

	protected int randInt(int min, int max) {
	    return (random.nextInt((max - min) + 1) + min);
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
