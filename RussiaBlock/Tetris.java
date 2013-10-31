package day06.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 俄罗斯方块游戏面板 
 *
 */
public class Tetris extends JPanel {
	/** 正在下落方块 */
	private Tetromino tetromino;
	/** 下一个下落方块 */
	private Tetromino nextOne;
	/** 行数 */
	public static final int ROWS = 20;
	/** 列数 */
	public static final int COLS = 10;
	/** 墙 */
	private Cell[][] wall = new Cell[ROWS][COLS]; 
	/** 消掉的行数 */
	private int lines;
	/** 分数 */
	private int score;
	
	public static final int CELL_SIZE = 26;
	
	private static Image background;//背景图片
	public static Image I;
	public static Image J;
	public static Image L;
	public static Image S;
	public static Image Z;
	public static Image O;
	public static Image T;
	static{//加载静态资源的，加载图片
		//建议将图片放到 Tetris.java 同包中!
		//从包中加载图片对象，使用Swing API实现
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		background = toolkit.getImage(
//				Tetris.class.getResource("tetris.png"));
//		T = toolkit.getImage(Tetris.class.getResource("T.png"));
//		S = toolkit.getImage(Tetris.class.getResource("S.png"));
//		Z = toolkit.getImage(Tetris.class.getResource("Z.png"));
//		L = toolkit.getImage(Tetris.class.getResource("L.png"));
//		J = toolkit.getImage(Tetris.class.getResource("J.png"));
//		I = toolkit.getImage(Tetris.class.getResource("I.png"));
//		O = toolkit.getImage(Tetris.class.getResource("O.png"));
		//import javax.imageio.ImageIO;
		try{
			background = ImageIO.read(
				Tetris.class.getResource("tetris.png"));
			T=ImageIO.read(Tetris.class.getResource("T.png"));
			I=ImageIO.read(Tetris.class.getResource("I.png"));
			S=ImageIO.read(Tetris.class.getResource("S.png"));
			Z=ImageIO.read(Tetris.class.getResource("Z.png"));
			L=ImageIO.read(Tetris.class.getResource("L.png"));
			J=ImageIO.read(Tetris.class.getResource("J.png"));
			O=ImageIO.read(Tetris.class.getResource("O.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void action(){
		tetromino = Tetromino.randomTetromino();
		nextOne = Tetromino.randomTetromino();
		wall[19][2] = new Cell(19,2,Tetris.T);
		repaint();
		KeyAdapter l = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				//System.out.println(key); 
				switch(key){
				case KeyEvent.VK_RIGHT: moveRightAction(); break;
				case KeyEvent.VK_LEFT: moveLeftAction(); break;
				case KeyEvent.VK_DOWN: softDropAction() ; break;
				}
				repaint();
			}
		};
		this.requestFocus();
		this.addKeyListener(l);
	}
	
	public void paint(Graphics g){
		//g.setColor(new Color(0xdddddd));
		//g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
		g.drawImage(background, 0, 0, null);//使用this 作为观察者
		g.translate(15, 15);//平移绘图坐标系
		Cell[] cells = tetromino.getCells();
		for(int i=0; i<cells.length; i++){
			Cell c = cells[i];
			int x = c.getCol() * CELL_SIZE-1;
			int y = c.getRow() * CELL_SIZE-1;
			//g.setColor(new Color(c.getColor()));
			//g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
			g.drawImage(c.getImage(), x, y, null);
		}
		paintWall(g);//画墙
	}
	//在 Tetris 类 中添加 方法 paintWall
	private void paintWall(Graphics g){
		for(int row=0; row<wall.length; row++){
			//迭代每一行, i = 0 1 2 ... 19
			Cell[] line = wall[row];
			//line.length = 10
			for(int col=0; col<line.length; col++){
				Cell cell = line[col]; 
				int x = col*CELL_SIZE; 
				int y = row*CELL_SIZE;
				if(cell==null){
					g.setColor(new Color(0));
					//画方形 
					g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
				}else{
					g.drawImage(cell.getImage(), x-1, y-1, null);
				}
			}
		}
	}
	/**
	 * 在 Tetris(俄罗斯方块) 类中增加方法
	 * 这个方法的功能是：软下落的动作 控制流程
	 * 完成功能：如果能够下落就下落，否则就着陆到墙上，
	 *   而新的方块出现并开始落下。
	 */
	public void softDropAction(){
		if(tetrominoCanDrop()){
			tetromino.softDrop();
		}else{
			tetrominoLandToWall();
			destroyLines();//破坏满的行
			tetromino = nextOne;
			nextOne = Tetromino.randomTetromino();
		}
	}
	/** 销毁已经满的行，并且计分
	 * 1）迭代每一行 
	 * 2）如果（检查）某行满是格子了 就销毁这行 
	 **/
	public void destroyLines(){
		int lines = 0;
		for(int row = 0; row<wall.length; row++){
			if(fullCells(row)){
				deleteRow(row);
				lines++;
			}
		}
		// lines = ?
		this.lines += lines;//0 1 2 3 4
		this.score += SCORE_TABLE[lines];
	}
	private static final int[] SCORE_TABLE={0,1,10,30,200};
	//                                      0 1  2  3  4
	
	public boolean fullCells(int row){
		Cell[] line = wall[row];
		for(int i=0; i<line.length; i++){
			if(line[i]==null){//如果有空格式就不是满行
				return false;
			}
		}
		return true;
	}
	public void deleteRow(int row){
		for(int i=row; i>=1; i--){
			//复制 [i-1] -> [i] 
			System.arraycopy(wall[i-1], 0, wall[i], 0, COLS);
		}
		Arrays.fill(wall[0], null);
	}
	
	/** 检查当前的4格方块能否继续下落 */
	public boolean tetrominoCanDrop(){
		Cell[] cells = tetromino.getCells();
		for(int i = 0; i<cells.length; i++){
			Cell cell = cells[i];
			int row = cell.getRow(); int col = cell.getCol();
			if(row == ROWS-1){return false;}//到底就不能下降了
		}
		for(int i = 0; i<cells.length; i++){
			Cell cell = cells[i];
			int row = cell.getRow(); int col = cell.getCol();
			if(wall[row+1][col] != null){
				return false;//下方墙上有方块就不能下降了
			}
		}
		return true;
	}
	/** 4格方块着陆到墙上 */
	public void tetrominoLandToWall(){
		Cell[] cells = tetromino.getCells();
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			wall[row][col] = cell;
		}
	}
	
	public void moveRightAction(){
		tetromino.moveRight();
		if(outOfBound() || coincide()){
			tetromino.moveLeft();
		}
	}
	public void moveLeftAction(){
		tetromino.moveLeft();
		if(outOfBound() || coincide()){
			tetromino.moveRight();
		}
	}
	/** ... */
	private boolean outOfBound(){
		Cell[] cells = tetromino.getCells();
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int col = cell.getCol();
			if(col<0 || col>=COLS){
				return true;//出界了
			}
		}
		return false;
	}
	private boolean coincide(){
		Cell[] cells = tetromino.getCells();
		//for each 循环、迭代，简化了"数组迭代书写"
		for(Cell cell: cells){//Java 5 以后提供增强版for循环
			int row = cell.getRow();
			int col = cell.getCol();
			if(row<0 || row>=ROWS || col<0 || col>=COLS || 
					wall[row][col]!=null){
				return true; //墙上有格子对象，发生重合
			}
		}
		return false;
	} 
	/** 向右旋转动作 */
	public void rotateRightAction(){
		tetromino.rotateRight();
		if(outOfBound() || coincide()){
			tetromino.rotateLeft();
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Tetris tetris = new Tetris();
		frame.add(tetris);
		frame.setSize(525, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Location 位置 RelativeTo相对于 
		frame.setLocationRelativeTo(null);//使当前窗口居中
		frame.setVisible(true);
		tetris.action();
		//tetris.requestFocus();
	}
}







