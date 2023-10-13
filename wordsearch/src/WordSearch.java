import java.util.*;
import java.io.*;

public class WordSearch
{
	private String[][] m;
	private int row;
	private int col;

	public WordSearch(int size, String str )
	{
		col = size;
		row = str.length() / size;
		m = new String[row][col];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				m[i][j] = "" + str.charAt(0);
				if(str.length()>=2){
					str = str.substring(1);
				}
			}
		}
	}

	public boolean isFound( String word )
	{
		if(checkRight(word,row,col) || checkLeft(word,row,col) || checkUp(word,row,col) || checkDown(word,row,col)){
			return true;
		} else if (checkDiagDownLeft(word,row,col)||checkDiagUpLeft(word,row,col)||checkDiagUpRight(word,row,col)||checkDiagDownRight(word,row,col)){
			return true;
		}
		return false;
	}

	public boolean checkRight(String w, int r, int c)
	{
		for (int i = 0; i < r; i++) {
			String inmatrix = "";
			for (int j = 0; j < c; j++) {
				inmatrix += m[i][j];
			}
			if(inmatrix.contains(w)){
				return true;
			}
		}
		return false;
	}

	public boolean checkLeft(String w, int r, int c)
	{
		for (int i = 0; i < r; i++) {
			String inmatrix = "";
			for (int j = c-1;j >=0 ; j--) {
				inmatrix += m[i][j];
			}
			if(inmatrix.contains(w)){
				return true;
			}
		}
		return false;
	}

	public boolean checkUp(String w, int r, int c)
	{
		for (int j = 0; j < c; j++) {
			String inmatrix = "";
			for (int i = 0; i < r; i++) {
				inmatrix += m[i][j];
			}
			if(inmatrix.contains(w)){
				return true;
			}
		}
		return false;
	}

	public boolean checkDown(String w, int r, int c)
	{
		for (int j = 0; j < c; j++) {
			String inmatrix = "";
			for (int i = r-1; i>=0; i--) {
				inmatrix += m[i][j];
			}
			if(inmatrix.contains(w)){
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagUpRight(String w, int r, int c)
	{
		// check longest diagonal
		int xrow = 0;
		int ycol = c-1;
		String inmatrix = "";
		for (int i = 0; i < Math.min(r,c); i++) {
			inmatrix += m[xrow][ycol];
			xrow++;
			ycol--;
		}
		String proxy = "";
		for (int a = inmatrix.length()-1; a >= 0; a--) {
			proxy += inmatrix.charAt(a);
		}
		if (proxy.contains(w)){
			return true;
		}

		for (int i = c-1; i >=1; i--) {
			xrow = 0;
			ycol = i;
			inmatrix = "";
			for (int j = 0; j < c-2; j++) {
				if(xrow>=0 && ycol>=0){
					inmatrix += m[xrow][ycol];
				}
				xrow++;
				ycol--;
			}
			proxy = "";
			for (int a = inmatrix.length()-1; a >= 0; a--) {
				proxy += inmatrix.charAt(a);
			}
			if (proxy.contains(w)){
				return true;
			}
		}

		for(int j = 1; j<r-1; j++) {
			xrow = j;
			ycol = c-1;
			inmatrix = "";
			for (int i = 0; i < r-j; i++) {
				if(xrow>=0 && ycol>=0){
					inmatrix += m[xrow][ycol];
				}
				xrow++;
				ycol--;
			}
			proxy = "";
			for (int a = inmatrix.length()-1; a >= 0; a--) {
				proxy += inmatrix.charAt(a);
			}
			if (proxy.contains(w)){
				return true;
			}
		}

		return false;
	}

	public boolean checkDiagUpLeft(String w, int r, int c)
	{
		// check longest diagonal
		int xrow = 0;
		int ycol = 0;
		String inmatrix = "";
		for (int i = 0; i < Math.min(r,c); i++) {
			inmatrix += m[xrow][ycol];
			xrow++;
			ycol++;
		}
		String proxy = "";
		for (int a = inmatrix.length()-1; a >= 0; a--) {
			proxy += inmatrix.charAt(a);
		}
		if (proxy.contains(w)){
			return true;
		}

		for (int i = 1; i < c-1; i++) {
			xrow = 0;
			ycol = i;
			inmatrix = "";
			for (int j = 0; j < c-i; j++) {
				inmatrix += m[xrow][ycol];
				xrow++;
				ycol++;
			}
			proxy = "";
			for (int a = inmatrix.length()-1; a >= 0; a--) {
				proxy += inmatrix.charAt(a);
			}
			if (proxy.contains(w)){
				return true;
			}
		}

		for(int j = 1; j<r-1; j++){
			xrow = j;
			ycol = 0;
			inmatrix = "";
			for (int i = 0; i < r-j; i++) {
				inmatrix += m[xrow][ycol];
				xrow++;
				ycol++;
			}
			proxy = "";
			for (int a = inmatrix.length()-1; a >= 0; a--) {
				proxy += inmatrix.charAt(a);
			}
			if (proxy.contains(w)){
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagDownLeft(String w, int r, int c)
	{
		// check longest diagonal
		int xrow = 0;
		int ycol = c-1;
		String inmatrix = "";
		for (int i = 0; i < Math.min(r,c); i++) {
			inmatrix += m[xrow][ycol];
			xrow++;
			ycol--;
		}
		if(inmatrix.contains(w)){
			return true;
		}

		for (int i = c-1; i >=1; i--) {
			xrow = 0;
			ycol = i;
			inmatrix = "";
			for (int j = 0; j < c-2; j++) {
				if(xrow>=0 && ycol>=0){
					inmatrix += m[xrow][ycol];
				}
				xrow++;
				ycol--;
			}
			if (inmatrix.contains(w)){
				return true;
			}
		}

		for(int j = 1; j<r-1; j++) {
			xrow = j;
			ycol = c-1;
			inmatrix = "";
			for (int i = 0; i < r-j; i++) {
				if(xrow>=0 && ycol>=0){
					inmatrix += m[xrow][ycol];
				}
				xrow++;
				ycol--;
			}
			if (inmatrix.contains(w)){
				return true;
			}
		}

		return false;
	}

	public boolean checkDiagDownRight(String w, int r, int c)
	{
		// check longest diagonal
		int xrow = 0;
		int ycol = 0;
		String inmatrix = "";
		for (int i = 0; i < Math.min(r,c); i++) {
			inmatrix += m[xrow][ycol];
			xrow++;
			ycol++;
		}
		if(inmatrix.contains(w)){
			return true;
		}

		for (int i = 1; i < c-1; i++) {
			xrow = 0;
			ycol = i;
			inmatrix = "";
			for (int j = 0; j < c-i; j++) {
				inmatrix += m[xrow][ycol];
				xrow++;
				ycol++;
			}
			if (inmatrix.contains(w)){
				return true;
			}
		}

		for(int j = 1; j<r-1; j++){
			xrow = j;
			ycol = 0;
			inmatrix = "";
			for (int i = 0; i < r-j; i++) {
				inmatrix += m[xrow][ycol];
				xrow++;
				ycol++;
			}
			if (inmatrix.contains(w)){
				return true;
			}
		}
		return false;
	}

	public String toString()
	{
		String returned = "";
		for (int i=0; i<row; i++) {
			for (int j = 0; j <col; j++) {
				if(j!=col-1){
					returned += m[i][j] + " ";
				} else {
					returned += m[i][j] + "\n";
				}
			}
		}
		return returned;
	}
}

