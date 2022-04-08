public class Board {
	boolean[][] board = new boolean[20][10];
	int[][] intBoard = new int[20][10];
	boolean testForNew = false;
	boolean gameOver = false;
	String[] randomBlock = {"O", "S", "Z", "T", "L", "J"};
	
	
	public int centerR, centerC;
	//Keeping track of pieces
	//0 - empty, 1 - I piece, 2 - O piece, 3 - T piece, 4 - L piece, 5 - J piece, 6 - Z piece, 7 - S piece
	//false - empty, true - not empty
	
	public Board() {
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				board[r][c] = false;
			}
		}
		
		for(int r = 0; r < intBoard.length; r++) {
			for(int c = 0; c < intBoard[0].length; c++) {
				intBoard[r][c] = 0;
			}
		}
	}
	
	public void setEmpty() {
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				board[r][c] = false;
			}
		}
		
		for(int r = 0; r < intBoard.length; r++) {
			for(int c = 0; c < intBoard[0].length; c++) {
				if(intBoard[r][c] == 1) {
					intBoard[r][c] = 2;
				}
			}
		}
		spawnNewBlock();
	}
	
	
	
	public void spawn(String shape) {
		if(shape.equals("O")) {
			//System.out.println("O Piece");
			int width = 2;
			int height = 2;
			
			double rnd = Math.floor(Math.random()*(11-width));		
			for(int r = 0; r < height; r++) {
				for(int c = (int) rnd; c < width + (int) rnd; c++) {
					intBoard[r][c] = 1;
					board[r][c] = true;
				}
			}
		}else if(shape.equals("I")) {
			int width = 1;
			int height = 4;
			
			double rnd = Math.floor(Math.random()*(11-width));		
			for(int r = 0; r < height; r++) {
				for(int c = (int) rnd; c < width + (int) rnd; c++) {
					intBoard[r][c] = 1;
					board[r][c] = true;
				}
			}
		}else if(shape.equals("S")) {
			int width = 3;
			int height = 2;
			int i = 0;
			int count = 1;
			
			double rnd = Math.floor(Math.random()*(11-width));		
			for(int r = 0; r < height; r++) {
				if(i == 0) {
					for(int c = (int) rnd+1; c < width + (int) rnd; c++) {
						intBoard[r][c] = 1;
						board[r][c] = true;
						count++;
					}
				}else {
					for(int c = (int) rnd; c < width + (int) rnd-1; c++) {
						intBoard[r][c] = 1;
						board[r][c] = true;
						if(count == 4) {
							centerR = r;
							centerC = c;
						}
						count++;
					}
				}
				i++;
			}
		}else if(shape.equals("Z")) {
			int width = 3;
			int height = 2;
			int i = 0;
			int count = 1;
			
			double rnd = Math.floor(Math.random()*(11-width));		
			for(int r = 0; r < height; r++) {
				if(i == 0) {
					for(int c = (int) rnd; c < width + (int) rnd-1; c++) {
						intBoard[r][c] = 1;
						board[r][c] = true;
						count++;
					}
				}else {
					for(int c = (int) rnd+1; c < width + (int) rnd; c++) {
						intBoard[r][c] = 1;
						board[r][c] = true;
						if(count == 3) {
							centerR = r;
							centerC  = c;
						}
						count++;
					}
				}
				i++;
			}
		}else if(shape.equals("T")) {
			int width = 3;
			int height = 2;
			int i = 0;
			int count = 1;
			
			double rnd = Math.floor(Math.random()*(11-width));		
			for(int r = 0; r < height; r++) {
				if(i == 0) {
					for(int c = (int) rnd+1; c < width + (int) rnd-1; c++) {
						intBoard[r][c] = 1;
						board[r][c] = true;
						count++;
					}
				}else {
					for(int c = (int) rnd; c < width + (int) rnd; c++) {
						intBoard[r][c] = 1;
						board[r][c] = true;
						if(count == 3) {
							centerR = r;
							centerC = c;
						}
						count++;
					}
				}
				i++;
			}
		}else if(shape.equals("J")) {
			int width = 3;
			int height = 2;
			int i = 0;
			int count = 1;
			
			double rnd = Math.floor(Math.random()*(11-width));		
			for(int r = 0; r < height; r++) {
				if(i == 0) {
					for(int c = (int) rnd; c < width + (int) rnd-2; c++) {
						intBoard[r][c] = 1;
						board[r][c] = true;
						count++;
					}
				}else {
					for(int c = (int) rnd; c < width + (int) rnd; c++) {
						intBoard[r][c] = 1;
						board[r][c] = true;
						if(count == 3) {
							centerR = r;
							centerC = c;
						}
						count++;
					}
				}
				i++;
			}
		}else if(shape.equals("L")) {
			int width = 3;
			int height = 2;
			int i = 0;
			int count = 1;
			
			double rnd = Math.floor(Math.random()*(11-width));
			
			for(int r = 0; r < height; r++) {
				if(i == 0) {
					for(int c = (int) rnd+2; c < width + (int) rnd; c++) {
						intBoard[r][c] = 1;
						board[r][c] = true;
						count++;
					}
				}else {
					for(int c = (int) rnd; c < width + (int) rnd; c++) {
						intBoard[r][c] = 1;
						board[r][c] = true;
						if(count == 3) {
							centerR = r;
							centerC = c;
						}
						count++;
					}
				}
				i++;
			}
		}
		
	}//end of spawn
	 
	public void update() {
		for(int r = board.length-1; r >= 0; r--) {
			for(int c = board[r].length-1; c >= 0;c --) {
				if(board[r][c] == true) {
					if(intBoard[r+1][c] == 2)
						setEmpty();
				}
			}
		}
	}//end of update
	
	public void updateBoolArr() {
		for(int r = 0; r < intBoard.length; r++) {
			for(int c = 0; c < intBoard[0].length; c++) {
				if(intBoard[r][c] == 1) {
					board[r][c] = true;
				}else {
					board[r][c] = false;
				}
			}
		}
	}
	
	public void spawnNewBlock() {
		//check if the remaining blocks have stopped moving
		for(int r = 0; r < intBoard.length; r++) {
			for(int c = 0; c < intBoard[r].length; c++) {
				if(intBoard[r][c] == 2 || intBoard[r][c] == 0) {
					testForNew = true;
				}else testForNew = false;
			}
		}
		
		if(testForNew) {
			double rnd = Math.floor(Math.random()*(randomBlock.length));
			spawn(randomBlock[(int) rnd]);
			testForNew = false;
		}
	}
	
	public int[] intClockwiseTurn(int[] getter) { //clockwise turn repositions each element in a 9x9 array, to another position (based off its current one)
		int[] temp = new int[9];
		
		for(int i = 0; i < 9; i++) {
			temp[i] = getter[i];
			//System.out.print(getter[i]);
		}
		
		
		for(int i = 0; i < 9; i++) {
			if(i == 0) {
				getter[2] = temp[i];
			}else if(i == 1) {
				getter[5] = temp[i];
			}else if(i == 2) {
				getter[8] = temp[i];
			}else if(i == 3) {
				getter[1] = temp[i];
			}else if(i == 4) {
				getter[4] = temp[i];
			}else if(i == 5){
				getter[7] = temp[i];
			}else if(i == 6) {
				getter[0] = temp[i];
			}else if(i == 7) {
				getter[3] = temp[i];
			}else if(i == 8) {
				getter[6] = temp[i];
			}
		}
		
		for(int i = 0; i < 9; i++){
			//System.out.print(getter[i]);
		}
		
		return getter;
	}//end of clockwise rotate
	
	public void rotate(int row, int col) {
		int[] intGetter = new int[9];		   
		int[] intSetter;
		//boolean[] boolGetter = new boolean[9];
		//boolean[] boolSetter;
		boolean isSet = false;
		int count = 0;
		
		for(int r = row-1; r < row+2; r++) {
			for(int c = col-1; c < col+2; c++) {
				intGetter[count] = intBoard[r][c];
				//boolGetter[count] = board[r][c];
				count++;
			}
		}
		count = 0;
		
		for(int i = 0; i < 9; i++) {
			if(intGetter[i] == 2) {
				isSet = true;
			}
		}
		
		if(isSet == false) {
			intSetter = intClockwiseTurn(intGetter);
			//boolSetter = boolClockwiseTurn(boolGetter);
		
		
			for(int i = 0; i < 9; i++) {
				intGetter[i] = intSetter[i];
				//boolGetter[i] = boolSetter[i];
			}
		
			/*
			for(int i = 0; i < 9; i++) {
				if(i%3 == 0) {
				System.out.println("");
				}
				System.out.print(getter[i]);
			}
			*/
		
			for(int r = row-1; r < row+2; r++) {
				for(int c = col-1; c < col+2; c++) {
					intBoard[r][c] = intGetter[count];
					//board[r][c] = boolGetter[count];
					count++;
				}
			}
		}
		
		count = 0;
	}//end of rotate
	
	public void testFall() {
		updateBoolArr();
		for(int r = board.length-1; r >= 0; r--) {
			for(int c = board[0].length-1; c >= 0;c --) {
	
				if(board[r][c] == true) {
					if(intBoard[r+1][c] == 2) {
						setEmpty();
						break;
					}
					board[r+1][c] = board[r][c];
					intBoard[r+1][c] = 1;
					board[r][c] = false;
					intBoard[r][c] = 0;
				}
			}
		}
		for(int c = board[0].length-1; c >= 0;c --) {
			if(board[board.length-1][c]) {
				setEmpty();
				centerR--;
			}
		}
		centerR++;
		toString();
	}
	
	public void moveRight() { //has a couple bugs 
		for(int r = intBoard.length-1; r > 0; r--) {
			for(int c = intBoard[0].length-1; c > 0; c--) {
				if(intBoard[r][c] == 1 && c != 9) {
					centerC++;
					if(intBoard[r][c+1] == 0) {
						intBoard[r][c+1] = 1;
						intBoard[r][c] = 0;
					}
				}
			}
		}
		
	}
	
	public void moveLeft() { //has a couple bugs
		for(int r = 0; r < intBoard.length; r++) {
			for(int c = 0; c < intBoard[0].length; c++) {
				if(intBoard[r][c] == 1 && c != 0) {
					centerC--;
					if(intBoard[r][c-1] == 0) {
						intBoard[r][c-1] = 1;
						intBoard[r][c] = 0;
					}
				}
			}
		}
		
	}
	
	public String toString() {
		/*
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				if(board[r][c] == true) {
					System.out.print(board[r][c] + "  ");
				}else {
					System.out.print(board[r][c] + " ");
				}
				
			}
			System.out.println("");
		}
		*/
		
		///*
		for(int r = 0; r < intBoard.length; r++) {
			for(int c = 0; c < intBoard[0].length; c++) {
				if(intBoard[r][c] == 1) {
					System.out.print(intBoard[r][c] + " ");
				}else {
					System.out.print(intBoard[r][c] + " ");
				}		
			}
			System.out.println("");
		}
		//*/
		return "";
	}// end of toString
}
