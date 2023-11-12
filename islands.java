import java.util.*;

class Main {
	public static void main(String[] args) {
		// 0 woda; 1 ziemia

		// jest 13 pól ziemi
		int mapa1[][] = {
			{1,0,0,0,0,1,1,0},
			{0,0,0,0,1,0,1,0},
			{0,0,0,1,0,0,0,0},
			{0,0,1,0,0,1,1,1},
			{1,0,0,0,1,0,0,1}
		};

		// jest 11 pól ziemi
		int mapa2[][] = {
			{1,1,1},
			{1,0,0},
			{1,1,1},
			{0,0,1},
			{1,1,1}
		};
		System.out.print("pola ziemii: ");
		System.out.println(ProcessMapaPrimitive(mapa1));
		System.out.print("pola ziemii: ");
		System.out.println(ProcessMapaPrimitive(mapa2));
	}

	private static int ProcessMapaPrimitive (int mapa[][]) {
		int out = 0;
		for (int i=0; i<mapa.length; i++) {
			for (int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]==1) {
					out++;
					mapa[i][j] = 0;
					remNeighbours(mapa, i, j); //y:x
				}
			}
		}
		return out;
	}

	private static void remNeighbours(int mapa[][], int y, int x) {
		if (x < mapa[y].length-1 && mapa[y][x+1] == 1) {
			mapa[y][x+1] = 0;
			remNeighbours(mapa, y, x+1);
		}
		if (y < mapa.length-1 && mapa[y+1][x] == 1) {
			mapa[y+1][x] = 0;
			remNeighbours(mapa, y+1, x);
		}
		if (x!=0 && mapa[y][x-1] == 1) {
			mapa[y][x-1] = 0;
			remNeighbours(mapa, y, x-1);
		}
		if (y != 0 && mapa[y-1][x] == 1) {
			mapa[y-1][x] = 0;
			remNeighbours(mapa, y-1, x);
		}
	}
}