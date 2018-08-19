package model.board;

import java.util.List;

public interface TableBuilder {
	
	TableBuilderImpl CreateTable();
	public List<UpsideDown> getJump();
}
