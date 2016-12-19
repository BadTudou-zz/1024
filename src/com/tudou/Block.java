package com.tudou;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/*
 * 方块
 */
public class Block {
	public static HashMap<Integer, int[]> numberblocks = new HashMap<>();
	
	static {
		int[][] hexColors = {{184, 212, 235}, {158, 172, 238}, { 16, 200, 221}, {  7, 169, 239}, { 41, 124, 183}, 
							 {150, 224,  52}, { 33, 225,  59}, {203, 121, 252}, { 10, 197, 158}, {  4,   2,  89},
							 { 71,  97, 245}, { 67,  17, 237}, {209, 252, 060}, {247, 211,  84}, {216, 167, 133},
							 {244, 128,  92}, {215,  65,  74}, {172,  70,  56}, {191,  20,  98}, {209,  14,   4}};
		int[] zeroColors = {219, 219, 219};
		Block.numberblocks.put(new Integer(0), zeroColors);
		for(int i=1; i <= hexColors.length; i++){
			Block.numberblocks.put(new Integer((int) Math.pow(2,i)), hexColors[i-1]);
		}
		
	}
	
	public static int[] getColor(Integer number){
		return Block.numberblocks.get(number);
	}
	
	public static Block random(int pos_x, int pos_y){
		//int count = Block.numberblocks.size();
		int count = 3;
		int power = (int) (Math.random()*100%count) + 1;
		int number = (int) Math.pow(2, power);
		Block block = new Block(number, pos_x, pos_y);
		return block;
	}
	
	
	public int number;
	public int pos_x;//lie
	public int pos_y;//hang
	
	public Block(int number, int pos_x, int pos_y) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}
	
	public void setNumber(int number){
		this.number = number;
	}

	private void setPostion(int pos_x, int pos_y){
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}
	
	public void merge(){
		this.number += number;
	}
	
	public void move(int direction){
		switch (direction) {
			case KeyEvent.VK_W:
				this.setPostion(pos_x, pos_y-1);
				break;
				
			case KeyEvent.VK_S:
				this.setPostion(pos_x, pos_y+1);
				break;
				
			case KeyEvent.VK_A:
				this.setPostion(pos_x-1, pos_y);
				break;
				
			case KeyEvent.VK_D:
				this.setPostion(pos_x+1, pos_y);
				break;

			default:
				break;
		}
	}
	
	
}
